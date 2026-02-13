package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList; // Import der ArrayList-Klasse
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import DBConnector.DBConnector;

public class Service {
	
	/*
	static ArrayList<Person>  personen = new ArrayList<Person>();
	
	public static void insert(Person person){
		personen.add(person);
		
	
	} 
	public static ArrayList<Person> getAll() {
	    return personen;  
	}
	public static void delete(String id) {
	    personen.removeIf(p -> p.getUuid().equals(id));
	}
*/
    public static List<Person> readAll() {
        List<Person> personen = new ArrayList<>();
        String sql = "SELECT * FROM personenliste";
        try (Connection conn = DBConnector.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Person p = new Person(
            		rs.getString("vorname"),
            		rs.getString("nachname"),
            		rs.getString("uuid")
            	);
            	personen.add(p);	
            			
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personen;
    }

    public static void insert(Person person) {

        try {
            Connection connection = DBConnector.getInstance().getConnection();
            String insertSQL = "INSERT INTO personenliste (vorname, nachname, uuid) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            System.out.println("Autocommit = " + connection.getAutoCommit());

            preparedStatement.setString(1, person.getVorname());
            preparedStatement.setString(2, person.getNachname());
            preparedStatement.setString(3, person.getUuid());

            int updatedRowCount = preparedStatement.executeUpdate();
            if (updatedRowCount == 1) {
                connection.commit();
                System.out.println("Data inserted successfully.");
            } else {
                connection.rollback();
                System.out.println("An error occurred while inserting new data.");
            }
            preparedStatement.close();


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    

    public static void deletePerson(String id) {
    	System.out.println(id);
        try (Connection connection =  DBConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false);

            String sql = "DELETE FROM personenliste WHERE uuid = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, id);

                int rowsDeleted = ps.executeUpdate();
                if (rowsDeleted > 0) connection.commit();
                else connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public static void updatePerson(String uuid, String vorname, String nachname) {
		    try (Connection connection = DBConnector.getInstance().getConnection()) {
		        connection.setAutoCommit(false);

		        String sql = "UPDATE personenliste SET vorname = ?, nachname = ? WHERE uuid = ?";
		        try (PreparedStatement ps = connection.prepareStatement(sql)) {
		            ps.setString(1, vorname);
		            ps.setString(2, nachname);
		            ps.setString(3, uuid);

		            int rows = ps.executeUpdate();
		            if (rows > 0) connection.commit();
		            else connection.rollback();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
   }
	
