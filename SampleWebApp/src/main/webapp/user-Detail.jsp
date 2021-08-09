<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<h1>**************** User Details *******************</h1> <br>
	<h2>
	User Name: ${regObj.name } <br>
	User Email: ${regObj.email } <br>
	Gender: ${regObj.gender } <br>
	Hobbies: ${regObj.hobbies[0]}, ${regObj.hobbies[1]}, ${regObj.hobbies[2]}
	</h2> 
</body>
</html>