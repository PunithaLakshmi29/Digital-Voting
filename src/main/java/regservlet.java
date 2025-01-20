
import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loginservlet")

public class regservlet extends HttpServlet {

private static final String insert_query="insert into registrationform1(Name, Fathername,Dob,Mobilenumber,adharnum,voterid,Address,district,state,taluk,division ,pincode,username,Password)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

@Override

protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

//super.doGet(request,response);

// response.getWriter();

response.getWriter().append(request.getContextPath());

//

// System.out.println("Name"+username);

// System.out.println("account number"+AccountNumber);

// System.out.println("mail id"+MailId);

// System.out.println("password"+Password);

// System.out.println("confirm password"+Confirmpassword);

// System.out.println("phone number"+PhoneNumber);

}

@Override

protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

//doGet(request,response);

response.setContentType("text/html");

PrintWriter out=response.getWriter();

String Name=request.getParameter("name");

String Fathername=request.getParameter("fname");

String Dob=request.getParameter("dob");

//String Gender=req.getParameter("gender");

String MobileNumber=request.getParameter("Num");

String adharnum=request.getParameter("num");

String voterid=request.getParameter("vname");

String Address=request.getParameter("aname");

String district=request.getParameter("dname");

String state=request.getParameter("sname");

String taluk=request.getParameter("tname");

String division=request.getParameter("diname");

String pincode=request.getParameter("pnum");

String username=request.getParameter("uname");

String Password=request.getParameter("psd");

try {

Class.forName("com.mysql.jdbc.Driver");

}

catch(ClassNotFoundException e) {

e.printStackTrace();

}

try(Connection con=DriverManager.getConnection("jdbc:mysql:///sys","root","root");

PreparedStatement ps =con.prepareStatement(insert_query);){

ps.setString(1, Name);

ps.setString(2, Fathername);

ps.setString(3, Dob);

//ps.setString(4, Gender);

ps.setString(4, MobileNumber);

ps.setString(5, adharnum);

ps.setString(6, voterid);

ps.setString(7, Address);

ps.setString(8, district);

ps.setString(9, state);

ps.setString(10, taluk);

ps.setString(11, division);

ps.setString(12, pincode);

ps.setString(13, username);

ps.setString(14, Password);

int count=ps.executeUpdate();

if(count>0) {

out.println("Record submitted");

RequestDispatcher ed=request.getRequestDispatcher("Login.html");

ed.forward(request, response);

}else

{

out.print("Record not submitted");

//out.println("<script type=\"text/javascript\">");

//out.println("alert('Record not submitted');");

//out.println("</script>");

}

}

catch(SQLException se) {

out.println(se.getMessage());

se.printStackTrace();

}catch(Exception e) {

out.println(e.getMessage());

e.printStackTrace();

}

out.close();

}

}