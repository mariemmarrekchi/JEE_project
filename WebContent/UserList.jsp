<%@page language="java" import="java.util.ArrayList, metier.Malade"%>
<%@ page language="java"
	import="java.util.ArrayList, java.util.Iterator"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Consultation</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
</head>

<body >


<div class="container">
<div class="row">


<div style="margin-top:50px">
<form action="UserListController" method="post">
<div class="col-sm-12">
<input  type="text" id="name" name="nom"  class="col-sm-6" placeholder="recherche "  />
 <input  type="submit" value="ok" class="btn btn-info"/> </form></div>
		
			<table class="table table-hover" id="table">
			<tr>
			<th>Cin:</th>
				<th>Nom:</th>
				<th>Prenom:</th>
				<th>Date d'arrivé:</th>
				<th>Date de départ:</th>
				<th colspan="2">Actions:</th>
				
			</tr>
			
			
		<%


			ArrayList users = (ArrayList) session.getAttribute("listOfUsers");
			if (users != null) {
				
				for (int i = 0; i < users.size(); i++) 
				{
					out.println("<tr>");
					out.println("<td> " + ((Malade) users.get(i)).getCin() + "</td>");
					out.println("<td> " + ((Malade) users.get(i)).getNom() + "</td>");
					out.println("<td> " + ((Malade) users.get(i)).getPrenom() + "</td>");
					out.println("<td style='background-color:pink'> " + ((Malade) users.get(i)).getDate_ar() + "</td>");
					out.println("<td style='background-color:lightgreen'> " + ((Malade) users.get(i)).getDate_dep() + "</td>");
					out.print("<td>  <a href ='UserEditionController?id="+((Malade) users.get(i)).getId()+"&mode=Edition"+"'>Modifier</a> </td>");
					out.println("<td>  <a href ='UserEditionController?id="+((Malade) users.get(i)).getId()+"&mode=Suppression"+"'  onclick='return confirm(\"Voulez vous vraiment supprimer cet utilisateur ?\")'      >Supprimer</a> </td>");

					
					out.println("</tr>");
				}
				
			}%>


		</table>
</div>
	
</div>
</div>
		
 
<nav class="navbar navbar-expand-lg navbar-light bg-info fixed-bottom" height="50px"  >
  <div class="container">
    <a class="navbar-brand text-white" href="#">© Mariem Marrekchi</a>
  </div>
</nav>

<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</body>
</html>