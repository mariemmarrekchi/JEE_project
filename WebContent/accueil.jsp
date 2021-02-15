<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
	<%@include file="entete.jsp" %>
	<%@page language="java" import="metier.User"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Connexion</title>

<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
</head>
<body>
<div class="container">
<div class="row">

<div class="col-sm-4 card" style="width: 18rem;margin-top:100px">
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><a href="UserForm.jsp" >Ajouter un malade</a></li>
    <li class="list-group-item"><a href="UserListController">Liste des malades</a></li>
  
  </ul>
  <div class="col-sm-12" style="margin-top:50px">
<nav aria-label="Page navigation example"  >
  <ul class="pagination">
    
    <li class="page-item"><a class="page-link" href="UserForm.jsp">1</a></li>
    <li class="page-item"><a class="page-link" href="UserList.jsp">2</a></li>
  
   
  </ul>
</nav>

</div>
</div>
&nbsp
&nbsp
&nbsp
&nbsp
&nbsp
&nbsp
&nbsp
<div class="col-sm-5 card" style="width: 18rem;margin-top:100px;font-size:25px;font-family:arial">
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><h1 class="text-danger">Profile:</h1></li>
    <li class="list-group-item">Nom : <%=us.getNom()%> </li>
    <li class="list-group-item">Prenom : <%=us.getPrenom()%> </li>
    <li class="list-group-item">Login : <%=us.getLogin()%> </li>
    <li class="list-group-item">Password : <%=us.getPassword()%> </li>
  
  </ul>


</div>


</div>
</div>


	 
<nav class="navbar navbar-expand-lg navbar-light bg-info fixed-bottom" height="50px"  >
  <div class="container">
    <a class="navbar-brand text-white" href="#">© Mariem Marrekchi</a>
  </div>
</nav>
	
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</body>
</html>

