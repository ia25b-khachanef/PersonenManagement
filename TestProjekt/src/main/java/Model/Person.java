package Model;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;

public class Person {
	public String nachname;
    public String vorname;
    
	private String uuid;
    


    public Person(String vorname, String nachname) {
    	super();
    	this.vorname = vorname;
        this.nachname = nachname;
        this.uuid = UUID.randomUUID().toString();
        
    }
    public Person(String vorname, String nachname, String uuid) {
    	super();
    	this.vorname = vorname;
        this.nachname = nachname;
        this.uuid = uuid;
        
    }
	public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }


	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}




}
