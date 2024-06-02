package com.example.trackova.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.trackova.dao.model.*;
public class MySQLSingleton {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/trackova";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;
    private static MySQLSingleton mySQLSingleton;
	private MySQLSingleton() {
	}
	public static MySQLSingleton getInstance()
	{
		if(mySQLSingleton==null)
		{
			mySQLSingleton=new MySQLSingleton();
		}
		return mySQLSingleton;
		
	}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new SQLException("Error connecting to database: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    public List<States> getStates() {
		List<States> states = new ArrayList<>();
		try (Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT id, name FROM state");) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int stateId = rs.getInt("id");
				String stateName = rs.getString("name");
				states.add(new States(stateId, stateName));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
    public List<Districts> getDistricts(int stateId) {
		List<Districts> districts = new ArrayList<>();
		try (Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT id, name FROM district where stateId ="+stateId);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				districts.add(new Districts(id, name));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return districts;
	}
    public List<Student> getAllStudents()
    {
    	List<Student> students=new ArrayList();
    	try (Connection con = getConnection();
    			PreparedStatement stmt = con.prepareStatement("SELECT s.username,s.name as studentName, s.phoneno, st.name as stateName, d.name as districtName, s.emailId "
                        + "FROM studentpersonaldetails s "
                        + "JOIN state st ON s.stateId = st.id "
                        + "JOIN district d ON s.districtId = d.id") ){
    			ResultSet rs = stmt.executeQuery();
    			while (rs.next()) {
    				String username=rs.getString("username");
    				String name = rs.getString("studentName");
    				long phoneno=rs.getLong("phoneNo");
    				String state=rs.getString("stateName");
    				String district=rs.getString("districtName");
    				String email=rs.getString("emailId");
    				students.add(new Student(username,name,email,state,district,phoneno));
    				
    			}

    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return students;
    }
    public boolean addStudent(String username,String name,String emailId,int stateId,int districtId,long phoneno)
    {
    	 String sql = "INSERT INTO studentpersonaldetails (username, name,emailId,stateId,DistrictId,phoneno) VALUES (?, ?, ?, ?, ?, ?)";
         try (Connection conn = getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, username);
             stmt.setString(2, name);
             stmt.setString(3, emailId);
             stmt.setInt(4, stateId);
             stmt.setInt(5, districtId);
             stmt.setLong(6,phoneno);
             int rowsAffected = stmt.executeUpdate();
             return rowsAffected > 0; // Return true if insertion successful
         } catch (Exception e) {
             e.printStackTrace();
             return false; // Return false in case of any exception
         }
    	
    }
	public Student getStudent(String username) {
		try (Connection con = getConnection();
    			PreparedStatement stmt = con.prepareStatement("SELECT s.username,s.name as studentName, s.phoneno, st.name as stateName, d.name as districtName, s.emailId "
                        + "FROM studentpersonaldetails s "
                        + "JOIN state st ON s.stateId = st.id "
                        + "JOIN district d ON s.districtId = d.id where username = ?") ){
			    stmt.setString(1, username);
    			ResultSet rs = stmt.executeQuery();
    			while (rs.next()) {
    				String sUsername=rs.getString("username");
    				String name = rs.getString("studentName");
    				long phoneno=rs.getLong("phoneNo");
    				String state=rs.getString("stateName");
    				String district=rs.getString("districtName");
    				String email=rs.getString("emailId");
    				Student student=new Student(sUsername,name,email,state,district,phoneno);
    				return student;
    			}

    		} catch (Exception e) {
    			e.printStackTrace();
    		}
		return null;
	}
	public boolean updateStudentDetail(String username, String name, Long phoneno, int stateId,
			int districtId, String emailId) {
		 String sql = "update studentpersonaldetails set name=?,phoneNo=?,stateId=?,districtId=?,emailId=? where username =?";
         try (Connection conn = getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(6, username);
             stmt.setString(1, name);
             stmt.setString(5, emailId);
             stmt.setInt(3, stateId);
             stmt.setInt(4, districtId);
             stmt.setLong(2,phoneno);
             int rowsAffected = stmt.executeUpdate();
             return rowsAffected > 0; // Return true if insertion successful
         } catch (Exception e) {
             e.printStackTrace();
             return false; // Return false in case of any exception
         }
    	
	}

    
}
