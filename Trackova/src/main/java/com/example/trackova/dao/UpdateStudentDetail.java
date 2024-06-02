package com.example.trackova.dao;

import java.io.IOException;

import com.example.trackova.singleton.MySQLSingleton;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStudentDetail extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username=req.getParameter("EditStudentUsername");
		String studentName = req.getParameter("EditStudentName");
        Long studentPhone = Long.parseLong(req.getParameter("EditStudentPhone"));
        int studentState = Integer.parseInt(req.getParameter("EditStudentState"));
        int studentDistrict = Integer.parseInt(req.getParameter("EditStudentDistrict"));
        String studentEmail = req.getParameter("EditStudentEmail");
        boolean isUpdated=MySQLSingleton.getInstance().updateStudentDetail(username,studentName,studentPhone,studentState,studentDistrict,studentEmail);
        if(isUpdated)
        {
        	 res.getWriter().write("success");
        }
        else
        {
        	 res.getWriter().write("failure");
        }
	}
}
