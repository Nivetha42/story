package com.example.trackova.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.trackova.dao.model.States;
import com.example.trackova.dao.model.Student;
import com.example.trackova.singleton.MySQLSingleton;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetStudentDetails extends HttpServlet{
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		 List<Student> students=MySQLSingleton.getInstance().getAllStudents();
		 Gson gson = new Gson();
	     String json = gson.toJson(students);
	     PrintWriter out = res.getWriter();
	     out.print(json);
	     out.flush();
	 }
}
