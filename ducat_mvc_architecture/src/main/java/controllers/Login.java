package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.LoginService;
@WebServlet("/login")
public class Login extends HttpServlet{

	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out =response.getWriter();
		String name = request.getParameter("email");
		String password = request.getParameter("password");
		LoginService logService = new LoginService();
		User user = logService.LoginService(name, password);
		if (user !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("session_user", user);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
			rd.forward(request, response);
					}
		else {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);

		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
	
}
