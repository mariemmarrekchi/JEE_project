<%@ page language="java"
	import="java.util.ArrayList, java.util.Iterator"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	String login = (String) request.getAttribute("login");
	String password = (String) request.getAttribute("password");
	if (login == null)
		login = "";
	if (password == null)
		password = "";
	ArrayList<String> err = (ArrayList<String>) request.getAttribute("tab_err");
%>

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Connexion</title>
 <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/styl.css" />  
	<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-info">
  <div class="container">
    <a class="navbar-brand text-white" href="#">Administration :<h3><i class="text-danger">Clinique El Aliya</i></h3></a>
  </div>
</nav>
<div class="container">
<div class="row">

	<div class="col-sm-8 card text-center" style="margin-top:50px">
  <div class="card-header text-blod">Veuillez saisir vos cordonnées </div>
  <div class="card-body text-danger">
    
   
    <form class="form-group" action="UserController" method="POST">
    <p><label> Login :</label>
   <input  type="text" name="login" value="<%=login%>"/></p>
    <p><label>password :</label>
    <input type="password" name="password"
						value="<%=password%>" /></p>
						<p><input class="btn btn-info" type="submit"
						value="ok " /> &nbsp <input class="btn btn-dark" type="reset" value="Annuler" /></p>
     </form>
    
  </div>
</div>


	<%
		if (err != null && !err.isEmpty()) {
	%>
	<div class="col-sm-4 erreur fixed-center" style="margin-top:100px">
	<div class="alert alert-danger" role="alert">
	 <ul style="color:red">

			<%
				for (Iterator<String> it = err.iterator(); it.hasNext();) {
			%>
			<li><%=it.next()%></li>
			<%
				}
			%>
		</ul>
		
	
	<%
		}
	%>
  
</div>
 
</div>
	
	
</div>	
</div>	

<nav class="navbar navbar-expand-lg navbar-light bg-info fixed-bottom" style="margin-top:100px" >
  <div class="container">
    <a class="navbar-brand text-white" href="#">© Mariem Marrekchi</a>
  </div>
</nav>	
	 <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>