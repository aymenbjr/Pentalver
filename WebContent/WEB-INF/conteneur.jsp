<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@ page import="entities.Conteneur" %>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="web.PentalverServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Pentalver</title>

		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="css2/bootstrap.min.css"/>

		<!-- Slick -->
		<link type="text/css" rel="stylesheet" href="css2/slick.css"/>
		<link type="text/css" rel="stylesheet" href="css2/slick-theme.css"/>

		<!-- nouislider -->
		<link type="text/css" rel="stylesheet" href="css2/nouislider.min.css"/>

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="css2/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="css2/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>
		<!-- HEADER -->
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-envelope-o"></i> Pentalver.GmbH@gmail.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i>  Marjane 2,B.P. 15290  </a></li>
					</ul> 
				</div>
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="http://localhost:8080/Pentalver/Acceuil" class="logo">
									<img src="./img/logo2.png" alt="" width="200" height="65">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form  method ="post" action="recherche">
									<select class="input-select" name="option">
										<option value="0">Categories</option>
										<option value="1">DRY</option>
										<option value="1">OPEN TOP</option>
										<option value="1">FLAT RACK</option>
									</select>
									<input class="input" placeholder="Chercher ici" name="recherche">
									<button class="search-btn">Chercher</button>
								</form>
							</div>
						</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
								<!-- Wishlist -->
								<c:choose>
								<c:when test="${session == null}">
								<div>
									<a href="http://localhost:8080/Pentalver/login">
										<i class="fa fa-user-o"></i>
										<span>Login</span>
									</a>
								</div>
								<!-- /Wishlist -->

								</c:when>
								<c:when test="${session != null}">
								<div>
									<a href="http://localhost:8080/Pentalver/utilisateur_commande?id_client=${id }">
										<i class="fa fa-gear"></i>
										<span>Mes Commandes</span>
									</a>
								</div>
								<!-- /Wishlist -->

								<!-- Cart -->
								<div class="dropdown">
									<a href="http://localhost:8080/Pentalver/deconnexion">
										<i class="fa fa-user-o"></i>
										<span>Déconnection</span>
									</a>
									
								</div>
								</c:when>
								</c:choose>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li><a href="http://localhost:8080/Pentalver/Acceuil">Acceuil</a></li>
						<li class="active"><a href="http://localhost:8080/Pentalver/conteneur">Nos Conteneurs</a></li>
						
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- ASIDE -->
					
			
            
					
					<!-- /ASIDE -->

					<!-- STORE -->
					<div id="store" class="col-md-9">
						<!-- store top filter -->
						<div class="store-filter clearfix">
							
							
						</div>

						<!-- store products -->
						   	
						<div class="row">
						
						
						
						<c:forEach items="${ conteneur }" var="conteneur">
						
							<div class="col-md-4 col-xs-6">
								<div class="product">
									<div class="product-img">
									<img src="${ conteneur.image}"  height="180" alt="">
									</div>
									<div class="product-body">
									<p class="product-category">${ conteneur.type}</p> 
									<h3 class="product-name">${ conteneur.titre }</h3>
									</div>
									<div class="add-to-cart">
									<a  class="add-to-cart-btn" href="http://localhost:8080/Pentalver/detail?id_c=${ conteneur.id_conteneur }">Plus d'Info</a>
									</div>
								</div>
							</div>
							
						</c:forEach>
						
						
						
							 
						</div>
						<!-- /store products -->

						<!-- store bottom filter -->
						<div class="store-filter clearfix">
							<span class="store-qty"></span>
							<ul class="store-pagination">
								<li class="active">1</li>
								<li>2</li>
								<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
							</ul>
						</div>
						<!-- /store bottom filter -->
					</div>
					<!-- /STORE -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- BREADCRUMB -->
		
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
			<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
				<!-- row -->
				<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Voir Aussi</h3>
							<div class="section-nav">
								
							</div>
						</div>
					</div>
				
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		

		<!-- FOOTER -->
		<footer id="footer">
			<!-- top footer -->
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">A propos</h3>
								<p>Assurez-vous de noter ce Module avec 20</p>
								<ul class="footer-links">
									<li><a href="#"><i class="fa fa-map-marker"></i> Marjane 2,B.P. 15290 </a></li>
									<li><a href="#"><i class="fa fa-envelope-o"></i>Pentalver.GmbH@gmail.com</a></li>
								</ul>
							</div>
						</div>

						<div class="col-md-3 col-xs-6">
							<div class="footer">
								<h3 class="footer-title">NOTRE MARKETPLACE</h3>
								<ul class="footer-links">
								<li><a href="http://localhost:8080/Pentalver/Acceuil">Acceuil</a></li>
									<li><a href="http://localhost:8080/Pentalver/conteneur">Nos Conteneurs</a></li>
								</ul>
							</div>
						</div>

						<div class="clearfix visible-xs"></div>
					</div>
					<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /top footer -->

			<!-- bottom footer -->
			<div id="bottom-footer" class="section">
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-12 text-center">
							<ul class="footer-payments">
								<li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
								<li><a href="#"><i class="fa fa-credit-card"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
								<li><a href=""><i class="fa fa-cc-amex"></i></a></li>
							</ul>
							<span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> Projet Site de location des Conteneurs <i class="fa fa-heart-o"></i> by <a  target="_blank">Oussama Dridi</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>


						</div>
					</div>
						<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /bottom footer -->
		</footer>
		<!-- /FOOTER -->

		<!-- jQuery Plugins -->
		<script src="js2/jquery.min.js"></script>
		<script src="js2/bootstrap.min.js"></script>
		<script src="js2/slick.min.js"></script>
		<script src="js2/nouislider.min.js"></script>
		<script src="js2/jquery.zoom.min.js"></script>
		<script src="js2/main.js"></script>

	</body>
</html>
