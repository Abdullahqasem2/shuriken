<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>Shuriken</title>
	<meta charset="UTF-8">
	<meta name="description" content="EndGam Gaming Magazine Template">
	<meta name="keywords" content="endGam,gGaming, magazine, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->
	<link href="img/favicon.ico" rel="shortcut icon"/>

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,700,700i,900,900i" rel="stylesheet">


	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" href="css/slicknav.min.css"/>
	<link rel="stylesheet" href="css/owl.carousel.min.css"/>
	<link rel="stylesheet" href="css/magnific-popup.css"/>
	<link rel="stylesheet" href="css/animate.css"/>

	<!-- Main Stylesheets -->
	<link rel="stylesheet" href="css/style.css"/>


	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
	<header class="header-section">
		<div class="header-warp">
			<div class="header-social d-flex justify-content-end">
				<p>Follow us:</p>
				<a href="#"><i class="fa fa-pinterest"></i></a>
				<a href="#"><i class="fa fa-facebook"></i></a>
				<a href="#"><i class="fa fa-twitter"></i></a>
				<a href="#"><i class="fa fa-dribbble"></i></a>
				<a href="#"><i class="fa fa-behance"></i></a>
			</div>
			<div class="header-bar-warp d-flex">
				<!-- site logo -->
				<a href="/" class="site-logo">
					<img src="./img/logo.png" alt="">
				</a>
				<nav class="top-nav-area w-100">
					<div class="user-panel">
						<a href="/registration">Register</a>
					</div>
					<!-- Menu -->
					<ul class="main-menu primary-menu">
						<li><a href="/">Home</a></li>
						<li><a href="/games">Games</a>
							<ul class="sub-menu">
								<li><a href="/game">Game Singel</a></li>
							</ul>
						</li>
						<!-- <li><a href="review.html">Reviews</a></li> -->
						<li><a href="/news">News</a></li>
						<li><a href="/contact">Contact</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	<!-- Header section end -->


	<!-- Page top section -->
	<section class="page-top-section set-bg" data-setbg="img/page-top-bg/2.jpg">
		<div class="page-info">
			<h2>Login</h2>
			<div class="site-breadcrumb">
				<a href="/home">Home</a>  /
				<span>Login</span>
			</div>
		</div>
	</section>
	
		<section class="newsletter-section">
		<div class="container">
				<c:if test="${logoutMessage != null}">
			<p><c:out value="${logoutMessage}"></c:out></p>
		</c:if>
			<h2>Login</h2>
					<c:if test="${errorMessage != null}">
			<p><c:out value="${errorMessage}"></c:out></p>
		</c:if>
			<form method="POST" action="/login" class="newsletter-form">
				<input type="text" placeholder="ENTER YOUR E-MAIL" name="username">
				<input type="password" placeholder="ENTER YOUR PASSWORD" name="password">
				<br>
				<br>
				<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				<button type="submit" class="site-btn">login<img src="img/icons/double-arrow.png" alt="#"/></button>|||||||||<a href="/registration" class="site-btn">sign up<img src="img/icons/double-arrow.png"/></a>
				
			</form>
			<br>
			<br>
			
		</div>
	</section>

	<section class="game-author-section">
		<div class="container">
			<div class="game-author-pic set-bg" data-setbg="img/Tamara_Adeeb.JPG"></div>
			<div class="game-author-info">
				<h4>Develobed by: Tamara Adeeb</h4>
				<p>Vivamus volutpat nibh ac sollicitudin imperdiet. Donec scelerisque lorem sodales odio ultricies, nec rhoncus ex lobortis. Vivamus tincid-unt sit amet sem id varius. Donec elementum aliquet tortor. Curabitur justo mi, efficitur sed eros alique.</p>
			</div>
		</div>
	</section>
	<section class="game-author-section">
		<div class="container">
			<div class="game-author-pic set-bg" data-setbg="img/Tariq_Hamarsheh.JPG"></div>
			<div class="game-author-info">
				<h4>Develobed by: Tareq Hamarsha</h4>
				<p>Vivamus volutpat nibh ac sollicitudin imperdiet. Donec scelerisque lorem sodales odio ultricies, nec rhoncus ex lobortis. Vivamus tincid-unt sit amet sem id varius. Donec elementum aliquet tortor. Curabitur justo mi, efficitur sed eros alique.</p>
			</div>
		</div>
	</section>

	<!-- Footer section -->
	<footer class="footer-section">
		<div class="container">
			<div class="footer-left-pic">
				<img src="img/footer-left-pic.png" alt="">
			</div>
			<div class="footer-right-pic">
				<img src="img/footer-right-pic.png" alt="">
			</div>
			<a href="#" class="footer-logo">
				<img src="./img/logo.png" alt="">
			</a>
			<ul class="main-menu footer-menu">
				<li><a href="/">Home</a></li>
				<li><a href="/games">Games</a></li>
				<!-- <li><a href="">Reviews</a></li> -->
				<li><a href="/news">News</a></li>
				<li><a href="/contact">Contact</a></li>
			</ul>
			<div class="footer-social d-flex justify-content-center">
				<a href="#"><i class="fa fa-pinterest"></i></a>
				<a href="#"><i class="fa fa-facebook"></i></a>
				<a href="#"><i class="fa fa-twitter"></i></a>
				<a href="#"><i class="fa fa-dribbble"></i></a>
				<a href="#"><i class="fa fa-behance"></i></a>
			</div>
			<div class="copyright"><a href="">Colorlib</a> 2018 @ All rights reserved</div>
		</div>
	</footer>
	<!-- Footer section end -->


	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky-sidebar.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/main.js"></script>

	</body>
</html>