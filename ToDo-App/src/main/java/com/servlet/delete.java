
package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.DAO.TodoDAO;

@WebServlet("/delete")
public class delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		TodoDAO dao=new TodoDAO(DBConnect.getConn());
		boolean f=dao.DeleteTodo(id);
		
		HttpSession session;
		if(f)
		{
			
			   session=request.getSession();
				session.setAttribute("reg-success", "data deleted Successfully..");
			response.sendRedirect("index.jsp");
		}
		else {
			session=request.getSession();
			session.setAttribute("failed-msg", "something went wrong on server");
			response.sendRedirect("index.jsp");
		}
		
		
		
		
	}


}
