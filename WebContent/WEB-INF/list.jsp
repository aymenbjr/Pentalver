<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="web.PentalverServlet"%>
    
        <%@ page import="entities.Client" %>
        <%@ page import="entities.Commande" %>
        <%@ page import="entities.Conteneur" %>
        <%@ page import="entities.Depot" %>
        
    
    <!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <title>Commandes</title>
    <!-- Custom CSS -->
    <link href="assets/libs/chartist/dist/chartist.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="dist/css/style.min.css" rel="stylesheet">
</head>

<body>
        <div class="page-wrapper">
   <center>         
<c:if test="${succes != null }">
	<H2 style="color: green" role="alert">
  		<c:out value=" ${succes} "></c:out>
	</H2>
</c:if>
<c:if test="${erreur != null }">
	<H2 style="color: red"" role="alert">
  		<c:out value=" ${erreur} "></c:out>
	</H2>
</c:if>
</center>
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Liste des Commandes</h4>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th class="border-top-0">Titre</th>
                                            <th class="border-top-0">Type</th>
                                            <th class="border-top-0">Taille</th>
                                            <th class="border-top-0">Prix</th>
                                            <th class="border-top-0">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${ commande}" var="commande">
                                        <tr>
                                            <td class="txt-oflo">${ commande.titre}</td>
                                            <td class="txt-oflo">${ commande.type}</td>
                                            <td class="txt-oflo">${ commande.taille}</td>
                                            <td class="txt-oflo">${ commande.prix}</td>

						<td>
						<a href="http://localhost:8080/Pentalver/modifierCommande?id_c=${ commande.id_commande}"<span class="label label-success label-rounded">Modifier</span>></a>
						<a href="http://localhost:8080/Pentalver/deleteCommande?id_c=${ commande.id_commande}"<span class="label label-danger label-rounded">Supprimer</span>></a>
						 </td>
                                        
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        

                
                
            </div>
            <footer class="footer text-center">
            </footer>
        </div>
    </div>
    <script src="assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="assets/extra-libs/sparkline/sparkline.js"></script>
    <!--Wave Effects -->
    <script src="dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="dist/js/custom.min.js"></script>
    <!--This page JavaScript -->
    <!--chartis chart-->
    <script src="assets/libs/chartist/dist/chartist.min.js"></script>
    <script src="assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
    <script src="dist/js/pages/dashboards/dashboard1.js"></script>
</body>

</html>