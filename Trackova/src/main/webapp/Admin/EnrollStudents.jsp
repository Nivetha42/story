<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Students</title>

<style>
body, html {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
}

nav {
	background: rgba(0, 0, 0, 0.7);
	padding: 10px 0;
}

nav ul {
	list-style-type: none;
	padding: 0;
	margin: 0;
	display: flex;
	justify-content: flex-end;
}

nav ul li {
	margin: 0 15px;
}

nav ul li a {
	color: white;
	text-decoration: none;
	padding: 10px 0;
	display: block;
}

.body {
	padding: 10px; font-family : Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #f0f0f0;
	font-family: Arial, sans-serif;
}

.login-container {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 90%;
	text-align: center;
}

.input-group {
	text-align: left;
}

.input-group label {
	display: block;
	margin-bottom: 5px;
}

.input-group input, select {
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

button {
	padding: 10px 20px;
	border: none;
	background-color: #007BFF;
	color: #fff;
	border-radius: 4px;
}

button:hover {
	background-color: #0056b3;
}

button:last-child {
	background-color: #6c757d;
}

button:last-child:hover {
	background-color: #5a6268;
}

.set-flex {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
	align-items: center;
}

.details-container {
	
	padding-top: 10px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 10px;
	text-align: left;
}



/* Modal styles */
.modal {
    display: none;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0,0,0,0.4);
    display: flex;
    align-items: center;
    justify-content: center;
}

.modal-content {
    background-color: #fefefe;
    padding: 20px;
    border: 1px solid #888;
    width: 25%;
    max-width: 500px;
    border-radius: 10px;
    position: relative;
    display:flex;
    align-items:center;
    justify-content:center;
}

.close {
    color: #aaa;
    position: absolute;
    top: 10px;
    right: 20px;
    font-size: 28px;
    font-weight: bold;
    cursor: pointer;
}

.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
}
#editStudentForm div
{
margin:10px;
}
#editStudentForm button
{
margin:10px;
}


</style>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <script src="../Scripts.js"></script>
</head>
<body>
	<nav>
		<ul>
			<li><a href="AdminHome.jsp">Students</a></li>
			<li><a href="EnrollStudents.jsp">Students</a></li>
			<li><a href="#">Course</a></li>
			<li><a href="#">Session Scheduling</a></li>
			<li><a href="#">View Reports</a></li>
		</ul>
	</nav>
	<div class="body">
		<div class="login-container">
			<h2>Add Student</h2>
			<form id="addStudentForm">
				<div class="set-flex">
					<div class="input-group">
						<input type="text" name="StudentName" placeholder="Name" required>
					</div>
					<div class="input-group">
						<input type="text" name="StudentPhone" placeholder="Phone No"
							required>
					</div>
					<div class="input-group">
						<select id="state" name="StudentState" required>
							<option value="">Select State</option>
						</select>
					</div>
					<div class="input-group">
						<select id="district" name="StudentDistrict" required>
							<option value="">Select District</option>
						</select>
					</div>
					<div class="input-group">
						<input type="email" name="StudentEmail" placeholder="email"
							required>
					</div>
					<button type="submit">Add</button>
				</div>
			</form>

		</div>
	</div>



	<session class="body ">
	<div class="login-container">
		<div class="details-container" id="detailsContainer">
			<h2>Student Details</h2>
			<table id="detailsTable">
				<thead>
					<tr>
						<th>Name</th>
						<th>Phone Number</th>
						<th>State</th>
						<th>District</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
	</session>
	
	
<div id="editStudentModal" class="modal" style="display:none">
    <div class="modal-content">
        <span class="close">&times;</span>
       
        <form id="editStudentForm">
        	 <div class="set-flex">
        	 <h3>Edit Student</h3>
        	 </div>
            <input type="hidden" id="editStudentUsername" name="EditStudentUsername">
            <div class="input-group">  
                <input type="text" id="editStudentName" name="EditStudentName" placeholder="Name" required>
            </div>
            <div class="input-group">
              
                <input type="text" id="editStudentPhone" name="EditStudentPhone" placeholder="PhoneNumber" required>
            </div>
            <div class="input-group">
               <select id="editstate" name="EditStudentState" required>
				<option value="">Select State</option>
				</select>
            </div>
            <div class="input-group">
               <select id="editDistrict" name="EditStudentDistrict" required>
				<option value="">Select District</option>
				</select>
            </div>
            <div class="input-group">
               
                <input type="email" id="editStudentEmail" name="EditStudentEmail" placeholder="EmailId" required>
            </div>
            <div class="set-flex">
            <button type="submit">Save Changes</button>
            </div>
        </form>
    </div>
</div>

	
</body>
</html>
