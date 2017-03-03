<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.ArrayList, model.VoteTally, model.VotingDAO" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose the Election</title>
</head>
<body>
<%
ArrayList<VoteTally> allItems = (ArrayList<VoteTally>)request.getAttribute("AllItems");
%>
<form method = "post" action = "ElectionMasterControl">
<table border= 1 cellpadding = 5>
<tr>
<th>Election Name</th>
<th>Results</th>
</tr>


</table>
<input type = "submit" name = "doThisToItem" value = "Choose Election">
<input type = "submit" name = "doThisToItem" value = "New Election">
</form>
</body>
</html>