<%--
  Created by IntelliJ IDEA.
  User: surya
  Date: 31-05-2024
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trackova - Student Page</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f0f0f0;
        color: #222831;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        height: 100vh;
    }
    .navbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #393E46;
        padding: 10px 20px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        color: #EEEEEE;
    }
    .navbar .logo {
        font-size: 1.5em;
        font-weight: bold;
        color: #00ADB5; /* Trackova */
    }
    .navbar .notification {
        font-size: 1.5em;
        cursor: pointer;
        color: #00ADB5;
    }
    .main-content {
        display: flex;
        flex: 1;
    }
    .sidebar {
        width: 250px;
        background-color: #222831;
        padding: 20px;
        box-shadow: 2px 0 5px rgba(0,0,0,0.1);
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }
    .sidebar .user-info {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
        color: #EEEEEE;
    }
    .sidebar .user-info .contact-icon {
        border-radius: 50%;
        width: 50px;
        height: 50px;
        margin-right: 10px;
        background-color: #00ADB5;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 1.5em;
        color: #393E46;
    }
    .sidebar a {
        display: block;
        color: #EEEEEE;
        padding: 10px;
        margin: 10px 0;
        text-decoration: none;
        transition: background-color 0.3s, color 0.3s;
    }
    .sidebar a:hover {
        background-color: #00ADB5;
        color: #222831;
        border-radius: 5px;
    }
    .content {
        flex: 1;
        padding: 20px;
    }
</style>
</head>
<body>

<div class="navbar">
    <div class="logo"><i>Trackova</i></div>
    <div class="notification">&#128276;</div> <!-- Notification bell icon -->
</div>

<div class="main-content">
    <div class="sidebar">
        <div>
            <div class="user-info">
                <div class="contact-icon">&#128100;</div> <!-- Contact icon -->
                <span>Surya</span>
            </div>
            <a href="Message.jsp">Message</a>
            <a href="Enrollments.jsp">Enrollments</a>
            <a href="Assignments.jsp">Assignments</a>
            <a href="Quiz.jsp">Quiz</a>
            <a href="Report.jsp">Report</a>
            <a href="AskDoubts.jsp">Ask Doubts</a>
        </div>
        <div>
            <a href="Logout.jsp">Logout</a>
        </div>
    </div>
    <div class="content">
        <!-- Main content goes here -->
        <h2>Welcome to Trackova</h2>
        <p>Select an option from the sidebar to get started.</p>
    </div>
</div>

</body>
</html>

