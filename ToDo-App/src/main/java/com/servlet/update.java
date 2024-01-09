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
import com.entity.TodoDtls;

@WebServlet("/update")
public class update extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String todo = request.getParameter("todo");
		String status = request.getParameter("status");

		TodoDAO dao = new TodoDAO(DBConnect.getConn());

		TodoDtls t = new TodoDtls();
		t.setId(id);
		t.setName(name);
		t.setTodo(todo);
		t.setStatus(status);

		boolean f = dao.updateTodo(t);
		HttpSession session;
		if (f) {

			session = request.getSession();
			session.setAttribute("reg-success", "Todo update Successfully..");
			response.sendRedirect("index.jsp");
		} else {
			session = request.getSession();
			session.setAttribute("failed-msg", "something went wrong on server");
			response.sendRedirect("index.jsp");
		}

	}

}