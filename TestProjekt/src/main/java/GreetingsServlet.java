
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Scanner;
/**
 * Servlet implementation class GreetingsServlet
 */
@WebServlet("/greetings")
public class GreetingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String zahl1 = request.getParameter("zahl1");
		System.out.println("Greetings " + zahl1);
	
		
		request.setAttribute("upperCaseName", zahl1.toUpperCase());
		request.getRequestDispatcher("greetings.jsp").forward(request, response);
		
		String zahl2 = request.getParameter("zahl2");
		System.out.println("Greetings " + zahl2);
	
		
		request.setAttribute("upperCaseName", zahl2.toUpperCase());
		request.getRequestDispatcher("greetings.jsp").forward(request, response);
		
		String Operationszeichen = request.getParameter("Operationszeichen");
		System.out.println("Greetings " + Operationszeichen);
	
		
		request.setAttribute("upperCaseName", Operationszeichen.toUpperCase());
		request.getRequestDispatcher("greetings.jsp").forward(request, response);
		
		String resultat = request.getParameter("resultat");
		System.out.println("Greetings " + resultat);
	
		
		request.setAttribute("upperCaseName", resultat.toUpperCase());
		request.getRequestDispatcher("greetings.jsp").forward(request, response);
		
		if (Operationszeichen == "+") {
			resultat = zahl1 + zahl2;
			response.getWriter().println(zahl1 + "+" + zahl2 + "=" + resultat);
		} else if(Operationszeichen == "-") {
			resultat = zahl1 + zahl2;
			return;
		} else if(Operationszeichen == "/") {
			resultat = zahl1 + zahl2;
			return;
		} else if(Operationszeichen == "*") {
			resultat = zahl1 + zahl2;
			return;
		}
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html><body><h1>Zahlen eingeben</h1>"
					+ "        <form>\r\n"
					+ "            <label for=\"zahl1\">Erste Zahl:</label>\r\n"
					+ "            <input type=\"text\" id=\"zahl1\" zahl1=\"zahl1\"><br><br>\r\n"
					+ "			   <label for=\"zahl2\">Zweite Zahl:</label>\r\n"
					+ "	           <input type=\"text\" id=\"zahl2\" zahl2=\"zahl2\"><br><br>\r\n"
					+ "            <label for=\"Operationszeichen\">Gib das Operationszeichen ein (+*/-):</label>\r\n\r\n\r\n"
					+ "		       <input type=\"text\" id=\"Operationszeichen\" Operationszeichen=\"Operationszeichen\"><br><br>\r\n"
					+ "            <input type=\"submit\" value=\"Submit\">\r\n"
					+ "        </form>"
					+ "</body></html>");

		
	}
}
