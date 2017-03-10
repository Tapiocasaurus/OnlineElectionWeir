<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.ArrayList, model.VoteTally, model.VotingDAO, model.ElectionSelect, controller.NewElectionServlet" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote!</title>
<% VotingDAO dao = new VotingDAO(); 
String eN = (String) request.getAttribute("ElectionName");
%>


</head>
<body>
<form method = "post" action = "VotingServlet">
<font color="blue" size=6>
<br><div align="center"><br/> Cast your vote!</div>
</font>
<font color="black" size=5>
<div align="center">----------------------------------------------------------------------------------------------------------------</div>
<br><div align="center"><br/> <%=dao.getName(1,eN)%></div>
<br><div align="center"><br/> <input type = "submit" name = doThisToItem value = "1"></div>
<div align="center">----------------------------------------------------------------------------------------------------------------</div>

<br><div align="center"><br/> <%=dao.getName(2,eN)%></div>
<br><div align="center"><br/> <input type = "submit" name = doThisToItem value = "2"></div>
<div align="center">----------------------------------------------------------------------------------------------------------------</div>

<br><div align="center"><br/> <%=dao.getName(3,eN)%></div>
<br><div align="center"><br/> <input type = "submit" name = doThisToItem value = "3"></div>
<div align="center">----------------------------------------------------------------------------------------------------------------</div>

</font>
</form>
</body>
</html>