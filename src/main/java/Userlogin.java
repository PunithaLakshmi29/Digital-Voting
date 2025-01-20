import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String username=request.getParameter("uname");
		String Password=request.getParameter("psd");
		
		if(Loginpage.validate(username,Password))
		{
			RequestDispatcher ed=request.getRequestDispatcher("Success");
			ed.include(request, response);
		}
		else
		{
			//out.print("sorry username or password error");
			RequestDispatcher ed= request.getRequestDispatcher("Login.html");
			ed.include(request, response);
		}

	}

}