<%@page language="java" import="java.util.ArrayList, metier.Malade"%>
 <%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Fiche User</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
</head>
<body >

<%
		
	      //gestion des erreurs
			ArrayList erreurs = (ArrayList) request.getAttribute("err");
			if (erreurs != null) 
			{
				%>
				<div class="col-sm-6 erreur alert alert-danger" style="margin-top:10px">
				<%
				out.println("<ul>");
				for (int i = 0; i < erreurs.size(); i++) {
					out.println("<li> " + (String) erreurs.get(i) + "</li>");
				}
				out.println("</ul>");
				%>
				</div>
			<%
			}
			
			
			// gestion de la saisie de  l'utilisateur en cours
			String nom =null;
			String cin=null;
			String prenom =null;
			String date_ar =null;
			String date_dep =null;
			int id =0;
			Malade u = (Malade)request.getAttribute("malade");
			
			
			// Correction des  valleurs nulles
			
			
			
			if (u!=null)
			{
			 id=u.getId();
			 cin=u.getCin();
			 nom = u.getNom();
			 prenom = u.getPrenom();
			 date_ar = u.getDate_ar();
			 date_dep = u.getDate_dep();
			 
			 
			}
			else{
				if(cin==null)cin="";
				if (nom==null)nom="";
				if (prenom==null)prenom="";
				if (date_ar==null)date_ar="";
				if (date_dep==null)date_dep="";
			}
			
		%>
		
<div class="container">
<div class="row">

		
		<div class="col-sm-12 card" style="margin-top:50px" >
  <div class="card-header">
   Veuillez saisir cordonnées :
  </div>
  <div class="card-body">
    <h5 class="card-title">Formulaire</h5>
    
    <form  action="UserEditionController" method="POST">
    <input class="form-control" type="hidden" name="id" value ="<%=id%>"/>
			<table>
			<tr>
				
			</tr>
			
			<tr>
				<td>Cin:</td>
				<td><input type="text" name="cin" value ="<%=cin%>"/></td>
			</tr>
			<tr>
				<td>Nom:</td>
				<td><input type="text" name="nom" value ="<%=nom%>"/></td>
			</tr>
			
			<tr>
				<td>Prénom:</td>
				<td><input type="text" name="prenom" value ="<%=prenom%>"/></td>
				
			</tr>
			<tr>
				<td>date d'arrivé :</td>
				<td><input type="date" name="date_ar" value ="<%=date_ar%>"/></td>
			</tr>
			<tr>
				<td>date de depart:</td>
				<td><input type="date" name="date_dep" value ="<%=date_dep%>"/></td>
			</tr>
			
			
			
			<tr>
				<td align="center" colspan="2"><input class="btn btn-info" type="submit" value="ok" />&nbsp
					<input class="btn btn-dark" type="reset" value="Annuler" /></td>&nbsp
					<td> <nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="accueil.jsp" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </ul>
    </nav></td>
			</tr>

	
	</form>
  </div>
</div>
			
	
   
</div>
</div>
		
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>