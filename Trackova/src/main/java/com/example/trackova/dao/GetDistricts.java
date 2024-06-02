package com.example.trackova.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.trackova.dao.model.Districts;
import com.example.trackova.singleton.MySQLSingleton;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetDistricts  extends HttpServlet{
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	 String stateId = req.getParameter("stateId");
	 List<Districts> districts=MySQLSingleton.getInstance().getDistricts(Integer.parseInt(stateId));
	 Gson gson = new Gson();
     String json = gson.toJson(districts);
     PrintWriter out = res.getWriter();
     out.print(json);
     out.flush();
	 }
}
