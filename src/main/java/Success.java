

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

/**

* Servlet implementation class Success

*/

@WebServlet("/Success")

public class Success extends HttpServlet {

private static final long serialVersionUID = 1L;

/**

* @see HttpServlet#HttpServlet()

*/

public Success() {

super();

// TODO Auto-generated constructor stub

}

/**

* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

*/

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html");

PrintWriter out=response.getWriter();

String username=request.getParameter("uname");

out.print("Welcome" +username);

}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// TODO Auto-generated method stub

response.setContentType("text/html");

PrintWriter out=response.getWriter();

String username=request.getParameter("uname");

// out.print("Welcome" +username);

RequestDispatcher ed=request.getRequestDispatcher("Terms.html");

ed.include(request, response);

}

}