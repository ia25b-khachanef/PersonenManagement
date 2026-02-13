package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Klasse für die Verwaltung von MySQL-Datenbankverbindungen.
 *
 * Diese Klasse implementiert das Singleton-Pattern, um sicherzustellen,
 * dass nur eine Instanz der Datenbankverbindung existiert.
 *
 * @author HF-ICT
 * @version 1.0
 */
public class DBConnector {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/PersonManagement";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Weiss1Doch2Selber3Nöt4";

    // Singleton-Instanz
    private static DBConnector instance;
    private static Connection connection = null;
    /**
     * Privater Konstruktor für Singleton-Pattern.
     * Lädt den MySQL JDBC-Treiber.
     *
     * @throws SQLException wenn der Treiber nicht geladen werden kann
     */
    private DBConnector() throws SQLException {
        try {
            // MySQL JDBC-Treiber laden (ab JDBC 4.0 optional)
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Datenbankverbindung erfolgreich hergestellt.");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC-Treiber nicht gefunden.", e);
        }
    }

    /**
     * Gibt die Singleton-Instanz zurück.
     * Erstellt eine neue Instanz, falls noch keine existiert.
     *
     * @return die einzige Instanz von DBConnector
     * @throws SQLException wenn die Verbindung nicht hergestellt werden kann
     */
    public static DBConnector getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnector();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnector();
        }
        return instance;
    }

    /**
     * Gibt die aktuelle Datenbankverbindung zurück.
     *
     * @return Connection-Objekt zur Datenbank
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Schließt die Datenbankverbindung.
     * Sollte am Ende der Anwendung aufgerufen werden.
     */
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Datenbankverbindung geschlossen.");
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Schließen der Verbindung: " + e.getMessage());
        }
    }

    /**
     * Testet die Datenbankverbindung.
     *
     * @return true wenn die Verbindung aktiv ist, sonst false
     */
    public boolean testConnection() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            System.err.println("Fehler beim Testen der Verbindung: " + e.getMessage());
            return false;
        }
    }

    /**
     * Beispiel-Hauptmethode zum Testen der Datenbankverbindung.
     *
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    private Connection openConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            connection.setAutoCommit(false);// disable automatic commits
            return connection;
        } catch (Exception e) {
            System.out.println("No connection to " + DB_URL);
            e.printStackTrace();
        }
        return null;
    }
    public Connection getconnection() throws SQLException {
        if (connection == null) {
            connection = new DBConnector().openConnection();
        }
        return connection;
    }
    public static void main(String[] args) {
        try {
            // Datenbankverbindung herstellen
            DBConnector dbConnection = DBConnector.getInstance();

            // Verbindung testen
            if (dbConnection.testConnection()) {
                System.out.println("Verbindung ist aktiv!");
            } else {
                System.out.println("Verbindung ist nicht aktiv.");
            }

            // Beispiel: Connection-Objekt verwenden
            Connection conn = dbConnection.getConnection();
            System.out.println("Catalog: " + conn.getCatalog());

            // Am Ende: Verbindung schließen
            dbConnection.closeConnection();

        } catch (SQLException e) {
            System.err.println("Datenbankfehler: " + e.getMessage());
            e.printStackTrace();
        }

    }
}

 