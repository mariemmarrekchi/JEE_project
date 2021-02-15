<%@page language="java" import="metier.User"%>
<%
User us= (User)session.getAttribute("user");
if (us==null)
{
  request.getRequestDispatcher("UserConnexion.jsp").forward(request, response);
}
else
{


%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title></title>

	<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
</head>
<body >

<nav class="navbar navbar-expand-lg navbar-light bg-info ">
<div class="container">
  <a class="navbar-brand text-white" href="#">BienVenue : <h3><i class="text-danger">Clinique El Aliya</i></h3> </a>
  <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon text-white"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link text-white text-right" style="margin-left:200px"href="accueil.jsp">Accueil <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item active">
      <a class="nav-link text-white text-left" id="decon" href="UserDeconnexionController">Déconnection &nbsp <svg class="bi bi-x-square-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M2 0a2 2 0 00-2 2v12a2 2 0 002 2h12a2 2 0 002-2V2a2 2 0 00-2-2H2zm9.854 4.854a.5.5 0 00-.708-.708L8 7.293 4.854 4.146a.5.5 0 10-.708.708L7.293 8l-3.147 3.146a.5.5 0 00.708.708L8 8.707l3.146 3.147a.5.5 0 00.708-.708L8.707 8l3.147-3.146z" clip-rule="evenodd"/>
</svg></a></li>
      
    <li class="nav-item active"  >
        
         
     <a class="nav-link text-white" href="#">  <svg  data-toggle="collapse" data-target="#decon" class="bi bi-person-check-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 100-6 3 3 0 000 6zm9.854-2.854a.5.5 0 010 .708l-3 3a.5.5 0 01-.708 0l-1.5-1.5a.5.5 0 01.708-.708L12.5 7.793l2.646-2.647a.5.5 0 01.708 0z" clip-rule="evenodd"/>
</svg> <%=us.getNom()%>&nbsp <%=us.getPrenom()%></a>
      </li> 
      
      
      
      
    </ul>
   
  </div>
  </div>
</nav>



<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>	
</body>
</html>
<%
}
%>