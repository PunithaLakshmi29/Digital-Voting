import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/Adminlogin")

public class Adminlogin extends HttpServlet

{

protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException

{

res.setContentType("text/html");

PrintWriter out=res.getWriter();

String n=req.getParameter("userName");

String p=req.getParameter("userPassword");

if(n.equals("Admin")&&p.equals("snekapa1@"))

{

RequestDispatcher rd=req.getRequestDispatcher("servlet2");

rd.forward(req, res);

}

else{

out.print("Sorry UserName or Password Error!");

RequestDispatcher rd=req.getRequestDispatcher("/Admin.html");

rd.include(req, res);

}

}

}


