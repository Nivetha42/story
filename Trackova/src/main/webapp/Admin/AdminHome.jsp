<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
    <link rel="stylesheet" href="styles.css">
    <style>
    body, html {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
   
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

.hero {
    height: 100vh;
 
}



.content {
  
   	display:flex;
   align-items: center;
   justify-content: center;
   height:100%;
}

.content h1 {
    font-size: 3em;
    margin-bottom: 20px;
}

.content p {
	text-align: center;
    font-size: 1.2em;
}
    
    nav {
	background: rgba(0, 0, 0, 0.7);
	padding: 10px 0;
	
}


    </style>
</head>
<body>

    <div class="hero">
       <nav>
		<ul>
			<li><a href="AdminHome.jsp">Home</a></li>
			<li><a href="EnrollStudents.jsp">Students</a></li>
			<li><a href="#">Course</a></li>
			<li><a href="#">Session Scheduling</a></li>
			<li><a href="#">View Reports</a></li>
		</ul>
	</nav>
        <div class="content">
        	<div>
            <h1>Keeping together is a Progress</h1>
            <p> comes with everything you need to get your business rolling.</p>
            </div>
        </div>
    </div>
</body>
</html>