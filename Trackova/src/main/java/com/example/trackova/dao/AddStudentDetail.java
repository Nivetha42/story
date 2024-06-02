package com.example.trackova.dao;

import java.io.IOException;

import com.example.trackova.singleton.MySQLSingleton;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddStudentDetail extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		 	String studentName = req.getParameter("StudentName");
	        Long studentPhone = Long.parseLong(req.getParameter("StudentPhone"));
	        int studentState = Integer.parseInt(req.getParameter("StudentState"));
	        int studentDistrict = Integer.parseInt(req.getParameter("StudentDistrict"));
	        String studentEmail = req.getParameter("StudentEmail");
	        boolean isInserted=MySQLSingleton.getInstance().addStudent(studentName, studentName, studentEmail, studentState, studentDistrict, studentPhone);
	        if(isInserted)
	        {
	        	 res.getWriter().println("Student added successfully.");
	        }else
	        {
	        	res.getWriter().println("Failed to add student.");
	        }
		
	}
}