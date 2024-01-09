package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.entity.*;

public class TodoDAO {
	private Connection conn;

	public TodoDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addTodo(String name,String todo,String status) {
		boolean f=false;
		
		try {
			String query="insert into todo_app(name,todo,status) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,todo);
			ps.setString(3,status);
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return f;
		
	}
	
	public List<TodoDtls> getTodo() {
		List<TodoDtls> list = new ArrayList<TodoDtls>();
		TodoDtls po = null;
		try {
			String qu = "select * from todo_app";
			PreparedStatement ps = conn.prepareStatement(qu);
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				po=new TodoDtls();
				po.setId(rs.getInt(1));
				po.setName(rs.getString(2));
				po.setStatus(rs.getString(3));
				po.setTodo(rs.getString(4));
				list.add(po);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public TodoDtls getTodoById(int id)
	{
		TodoDtls p=null;
		try {
			String qu="select * from todo_app where id=?";
			PreparedStatement ps=conn.prepareStatement(qu);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p=new TodoDtls();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setStatus(rs.getString(3));
				p.setTodo(rs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return p;
	}
	public boolean updateTodo(TodoDtls us) {
		boolean f=false;
		
		try {
			String query="update todo_app set name=?,todo=?,status=? where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,us.getName());
			ps.setString(2,us.getTodo());
			ps.setString(3,us.getStatus());
			ps.setInt(4,us.getId());
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return f;
		
	}
	public boolean DeleteTodo( int nid) {
		boolean f = false;
		try {
			String qu = "delete from todo_app where id=?";
			PreparedStatement ps = conn.prepareStatement(qu);
			
			ps.setInt(1, nid);

		int i=ps.executeUpdate();
		if(i==1)
		{
			f=true;
		}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	
	
	
	
	
	
	
	
}