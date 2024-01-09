package com.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DB.DBConnect;
@WebServlet("/add_notes")
public class AddServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String todo=request.getParameter("todo");
		String status=request.getParameter("status");
		
	
		
		
		
		
		TodoDAO dao=new TodoDAO(DBConnect.getConn());
		boolean f=dao.addTodo(name, todo, status);
		HttpSession session;
		if(f)
		{
			
			   session=request.getSession();
				session.setAttribute("reg-success", "data insert Successfully..");
			response.sendRedirect("index.jsp");
		}
		else {
			session=request.getSession();
			session.setAttribute("failed-msg", "something went wrong on server");
			response.sendRedirect("add_todo.jsp");
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
}