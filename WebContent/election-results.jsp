<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.ArrayList, model.VoteTally, model.VotingDAO, model.ElectionSelect, controller.NewElectionServlet" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Election Results</title>
<%
String eN = (String) request.getAttribute("ElectionName");
%>
<% VotingDAO dao = new VotingDAO(); 

%>


</head>
<body>
<form method = "post" action = "ElectionMasterControl">
<font color="black" size=5>
<br><div align="center"><br/> </div>
<br><div align="center"><br/> <%=dao.getName(1,eN)%> - <%=dao.getVote(1,eN)%></div>
<br><div align="center"><br/> <%=dao.getName(2,eN)%> - <%=dao.getVote(2,eN)%></div>
<br><div align="center"><br/> <%=dao.getName(3,eN)%> - <%=dao.getVote(3,eN)%></div>
<br><div align="center"><br/> <input type = "submit" name = "doThisToItem" value = "OK"></div>
</font>
</form>
</body>
</html>