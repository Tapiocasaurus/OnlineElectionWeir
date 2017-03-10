<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.ArrayList, model.VoteTally" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose the Election</title>
</head>
<body>
<%
ArrayList<VoteTally> allItems = (ArrayList<VoteTally>)request.getAttribute("AllItems");
%>
<font color="black" size=5>
<form method = "post" action = "ElectionMasterControl">
<div align="center">
<table border= 1 cellpadding = 5>
<tr>
<th> </th>
<th>Election Name</th>
<th>Results</th>
</tr>

<%
for(int i = 0; i<allItems.size(); i++){
%>


<tr>
<td><input type = "radio" name = "id" value="<%= i %>"></td>
<td><%= allItems.get(i).getElectionName()%></td>
<td><%= allItems.get(i).displayTallies()%></td>
</tr>
<%
}
%>
</table>
</div>
<div align="center"><input type = "submit" name = "doThisToItem" value = "Choose Election">
<input type = "submit" name = "doThisToItem" value = "New Election">
</div>
</form>
</body>
</html>
</font>