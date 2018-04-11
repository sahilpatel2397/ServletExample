package main.com;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.objectLayer.Person;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Hands On Lecture";
		out.println(
		         "<html>\n" +
		            "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor = \"#f0f0f0\">\n" +
		               "<h1 align = \"center\">" + title + "</h1>\n" +
		               "<ul>\n" +
		                  "  <li><b>First Name</b>: "
		                  + request.getParameter("first_name") + "\n" +
		                  "  <li><b>Last Name</b>: "
		                  + request.getParameter("last_name") + "\n" +
		               "</ul>\n" +
		            "</body>"+
		         "</html>"
		      );
		
	/*	String button = request.getParameter("submit");
		if (button.equals("Register!")){
			out.println("<html>\n" +
		            "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor = \"#f0f0f0\">\n" +
		               "<h1 align = \"center\">" + title + "</h1>\n" + 
		               "<h2 align = \"center\">Sucessfully Registered</h1>\n" + 
		            "</body>"+
		         "</html>");
		}
		else if(button.equals("Login!")){
			out.println("<html>\n" +
		            "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor = \"#f0f0f0\">\n" +
		               "<h1 align = \"center\">" + title + "</h1>\n" + 
		               "<h2 align = \"center\">Sucessfully Logged In</h1>\n" + 
		            "</body>"+
		         "</html>");
		}
	
		
		//Storing Information In Objects and adding to Database
	/*	String firstName = request.getParameter("first_name");
		Person person = new Person();
		person.setFirstName(firstName);
	*/	
		
		//Handling Cookies
	/*	Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
	    Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));
		
	    firstName.setMaxAge(60*60*24);
		lastName.setMaxAge(60*60*24);
		
		response.addCookie(firstName);
		response.addCookie(lastName);
		out.println(
		         "<html>\n" +
		            "<head><title>Cookies Example</title></head>\n" +
		            "<body bgcolor = \"#f0f0f0\">\n" +
		               "<h1 align = \"center\">Cookies Example</h1>\n" +
		               "<ul>\n" +
		                  "  <li><b>First Name</b>: "
		                  + request.getParameter("first_name") + "\n" +
		                  "  <li><b>Last Name</b>: "
		                  + request.getParameter("last_name") + "\n" +
		               "</ul>\n" +
		            "</body>"+
		         "</html>"
		      );
		
		//Reading the Cookies
		Cookie cookie = null;
		Cookie[] cookies = null;
		
		cookies = request.getCookies();
		 title = "Reading Cookies";
	    
	      out.println(
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n" );

	      if( cookies != null ) {
	         out.println("<h2> Cookies Found</h2>");

	         for (int i = 0; i < cookies.length; i++) {
	            cookie = cookies[i];
	            out.print("Name : " + cookie.getName( ) + ",  ");
	            out.print("Value: " + cookie.getValue( ) + " <br/>");
	         }
	      } 
	      else {
	         out.println("<h2>No cookies founds</h2>");
	      }
	      out.println("</body>");
	      out.println("</html>");
   
	    
	      //Handling Sessions
	      
	      //gets a session (creates one if there doesnt exist one already)
	      HttpSession session = request.getSession(true);
	      
	      Date newTime = new Date(session.getCreationTime());
	      
	      Date lastAccessedTime = new Date(session.getLastAccessedTime());
	      
	       title = "Welcome Back to my website";
	      Integer visitCount = new Integer(0);
	      String visitCountKey = new String("visitCount");
	      String userIDKey = new String(request.getParameter("first_name"));
	      String userID = new String("ABCD");
	      
	      if (session.isNew()) {
	          title = "Welcome to my website";
	          session.setAttribute(userIDKey, userID);
	       } 
	      else {
	          visitCount = (Integer)session.getAttribute(visitCountKey);
	          visitCount = visitCount + 1;
	          userID = (String)session.getAttribute(userIDKey);
	       }
	       session.setAttribute(visitCountKey,  visitCount);
	       
	       out.println(
	    	         "<html>\n" +
	    	            "<head><title>" + title + "</title></head>\n" +
	    	            
	    	            "<body bgcolor = \"#f0f0f0\">\n" +
	    	               "<h1 align = \"center\">" + title + "</h1>\n" +
	    	               "<h2 align = \"center\">Session Infomation</h2>\n" +
	    	               "<table border = \"1\" align = \"center\">\n" +
	    	                  
	    	                  "<tr bgcolor = \"#949494\">\n" +
	    	                     "  <th>Session info</th><th>value</th>"+
	    	                  "</tr>\n" +
	    	                     
	    	                  "<tr>\n" +
	    	                     "  <td>id</td>\n" +
	    	                     "  <td>" + session.getId() + "</td>"+
	    	                  "</tr>\n" +
	    	                  
	    	                  "<tr>\n" +
	    	                     "  <td>Creation Time</td>\n" +
	    	                     "  <td>" + newTime + "  </td>"+
	    	                  "</tr>\n" +
	    	                  
	    	                  "<tr>\n" +
	    	                     "  <td>Time of Last Access</td>\n" +
	    	                     "  <td>" + lastAccessedTime + "  </td>"+
	    	                  "</tr>\n" +
	    	                  
	    	                  "<tr>\n" +
	    	                     "  <td>User ID</td>\n" +
	    	                     "  <td>" + userID + "  </td>"+
	    	                  "</tr>\n" +
	    	                  
	    	                  "<tr>\n" +
	    	                     "  <td>Number of visits</td>\n" +
	    	                     "  <td>" + visitCount + "</td>"+
	    	                  "</tr>\n" +
	    	               "</table>\n" +
	    	            "</body>"+
	    	         "</html>"
	    	      );
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
