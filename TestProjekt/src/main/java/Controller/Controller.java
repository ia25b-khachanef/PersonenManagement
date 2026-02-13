package Controller;

import java.io.IOException;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList; 
import java.util.List;

import Model.Person;

@WebServlet("/Person")
public class Controller extends HttpServlet {
	
	
	/*@Override
	public void init() throws ServletException {
		Service.insert(new Person("Feris", "Müller", "9823"));
		Service.insert(new Person("Patrick", "streber", "3829"));
		Service.insert(new Person("escher", "erser", "3198"));
		Service.insert(new Person("mekre", "frau", "3912"));
	}*/

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {
		    request.setAttribute("persons", Service.readAll());  
		    request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
		   throws ServletException, IOException {
			String uuid = request.getParameter("uuid");
			String vorname = request.getParameter("vorname");
			String nachname = request.getParameter("nachname");
			if (uuid == null || uuid.isBlank()) {
		        // CREATE
		       Service.insert(new Person(vorname, nachname));
		    } else {
		        // UPDATE
		    	Service.updatePerson(uuid, vorname, nachname);
		    }
			response.sendRedirect("Person");
		}
		protected void doDelete(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {

		    String idStr = request.getParameter("uuid");

		    response.setContentType("application/json; charset=UTF-8");

		    if (idStr == null) {
		        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		        response.getWriter().write("{\"ok\":false,\"error\":\"missing id\"}");
		        return;
		    }

		    try {
		    	Service.deletePerson(idStr);
		        response.getWriter().write("{\"ok\":true}");
		    } catch (Exception e) {
		        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		        response.getWriter().write("{\"ok\":false,\"error\":\"delete failed\"}");
		    }
		}

		
	}

