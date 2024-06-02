package com.example.trackova.dao;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.trackova.dao.model.Student;
import com.example.trackova.singleton.MySQLSingleton;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetStudentDetail extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		Student student = MySQLSingleton.getInstance().getStudent(username);
		System.out.println(student.getName());
		if(student!=null) {
		Gson gson = new Gson();
	    String json = gson.toJson(student);
	    PrintWriter out = res.getWriter();
	    out.print(json);
	    out.flush();
		}
		else
		{
		res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
