<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new Election</title>
</head>
<body>
<form action = "NewElectionServlet" method = "post">
<br><div align="center">ElectionID: <br/> <input type = "text" name = "eID" value = " "></div>
<br><div align="center">ElectionName:<br/> <input type = "text" name = "ename" value = " " ></div>
<br><div align="center">Candidate1Name:<br/>  <input type = "text" name = "c1name" value = " "></div>
<br><div align="center">Candidate2Name:<br/>  <input type = "text" name = "c2name" value = " "></div>
<br><div align="center">Candidate3Name:<br/>  <input type = "text" name = "c3name" value = " "></div>



<br><div align="center"><br/> <input type = "submit" name ="doThisToItem" value = "Submit Election"></div>

</form>
</body>
</html>