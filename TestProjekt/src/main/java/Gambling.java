import java.io.IOException;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
* Servlet implementation class HelloWorldServlet
*/
@WebServlet("/gambling")
public class Gambling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prize = 0;
		
		int randomNumber = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 43);
		response.getWriter().println(randomNumber);
		int randomNumber2 = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 43);
		response.getWriter().println(randomNumber2);
		int randomNumber3 = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 43);
		response.getWriter().println(randomNumber3);
		int randomNumber4 = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 43);
		response.getWriter().println(randomNumber4);
		int randomNumber5 = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 43);
		response.getWriter().println(randomNumber5);
		int randomNumber6 = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 43);
		response.getWriter().println(randomNumber6);
		
		int zahl1 = Integer.parseInt(request.getParameter("zahl1"));
	
		
		request.setAttribute("zahl1", zahl1);
		
		int zahl2 = Integer.parseInt(request.getParameter("zahl2"));
	
		
		request.setAttribute("zahl2", zahl2);
		
		int zahl3 = Integer.parseInt(request.getParameter("zahl3"));
	
		
		request.setAttribute("zahl3", zahl3);
		
		int zahl4 = Integer.parseInt(request.getParameter("zahl4"));
	
		
		request.setAttribute("zahl4", zahl4);
		
		int zahl5 = Integer.parseInt(request.getParameter("zahl5"));
	
		
		request.setAttribute("zahl5", zahl5);
		
		int zahl6 = Integer.parseInt(request.getParameter("zahl6"));
	
		
		request.setAttribute("zahl6", zahl6);
		

        request.setAttribute("randomNumber", randomNumber);
        request.setAttribute("randomNumber2", randomNumber2);
        request.setAttribute("randomNumber3", randomNumber3);
        request.setAttribute("randomNumber4", randomNumber4);
        request.setAttribute("randomNumber5", randomNumber5);
        request.setAttribute("randomNumber6", randomNumber6);
        

        request.setAttribute("prize", prize);
		request.getRequestDispatcher("Gambling.jsp").forward(request, response);
		
		
		
		/* erste Zahl*/
		if (zahl1 == randomNumber){
			prize += 20000;
		}
		else if (zahl2 == randomNumber){
			prize += 500;
		}
		else if (zahl3 == randomNumber){
			prize += 500;
		}
		else if (zahl4 == randomNumber){
			prize += 500;
		}
		else if (zahl5 == randomNumber){
			prize += 500;
		}
		else if (zahl6 == randomNumber){
			prize += 500;
		}
		
		
		/* zweite Zahl*/
		if (zahl2 == randomNumber2){
			prize += 20000;
		}
		else if (zahl1 == randomNumber2){
			prize += 500;
		}
		else if (zahl3 == randomNumber2){
			prize += 500;
		}
		else if (zahl4 == randomNumber2){
			prize += 500;
		}
		else if (zahl5 == randomNumber2){
			prize += 500;
		}
		else if (zahl6 == randomNumber2){
			prize += 500;
		}
		
		
		/* dritte Zahl*/
		if (zahl3 == randomNumber3){
			prize += 20000;
		}
		else if (zahl1 == randomNumber3){
			prize += 500;
		}
		else if (zahl2 == randomNumber3){
			prize += 500;
		}
		else if (zahl4 == randomNumber3){
			prize += 500;
		}
		else if (zahl5 == randomNumber3){
			prize += 500;
		}
		else if (zahl6 == randomNumber3){
			prize += 500;
		}
		
		
		/* vierte Zahl*/
		if (zahl4 == randomNumber4){
			prize += 20000;
		}
		else if (zahl1 == randomNumber4){
			prize += 500;
		}
		else if (zahl2 == randomNumber4){
			prize += 500;
		}
		else if (zahl3 == randomNumber4){
			prize += 500;
		}
		else if (zahl5 == randomNumber4){
			prize += 500;
		}
		else if (zahl6 == randomNumber4){
			prize += 500;
		}
		
		
		/* fünfte Zahl*/
		if (zahl5 == randomNumber5){
			prize += 20000;
		}
		else if (zahl1 == randomNumber5){
			prize += 500;
		}
		else if (zahl2 == randomNumber5){
			prize += 500;
		}
		else if (zahl3 == randomNumber5){
			prize += 500;
		}
		else if (zahl4 == randomNumber5){
			prize += 500;
		}
		else if (zahl6 == randomNumber5){
			prize += 500;
		}
		/* sechste Zahl*/
		if (zahl6 == randomNumber6){
			prize += 20000;
		}
		else if (zahl1 == randomNumber6){
			prize += 500;
		}
		else if (zahl2 == randomNumber6){
			prize += 500;
		}
		else if (zahl3 == randomNumber6){
			prize += 500;
		}
		else if (zahl4 == randomNumber6){
			prize += 500;
		}
		else if (zahl5 == randomNumber6){
			prize += 500;
		}
		
		System.out.println("dein Preis ist" +prize);
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
 
}