import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
  
public class Login extends HttpServlet {  
  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException,IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out =response.getWriter();  
          
    String n=request.getParameter("userName");  
    String p=request.getParameter("userPass");  
          
    if(p.equals("voting"))
    		{  
        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
        rd.forward(request,response);  
    }  
    else{  
        response.setContentType("text/html");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('sorry your password is incorrect');");
        out.println("</script>");
        RequestDispatcher rd=request.getRequestDispatcher("/Admin.html");  
        rd.include(request,response);  
                      
        }  
    }  
  
}  


