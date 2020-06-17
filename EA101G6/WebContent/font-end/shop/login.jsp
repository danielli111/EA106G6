<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.shop.model.*"%>
<!DOCTYPE html>
<html>
<!doctype html>
<html lang="en">
<head>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="../../css/loginStyle.css">
<title>Unearth &mdash; Website Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Rubik:300,400,700|Oswald:400,700"
	rel="stylesheet">
<!-- �n�J�ϥ� -->
<link rel="stylesheet" href="../../fonts/icomoon/style.css">

<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/jquery.fancybox.min.css">
<link rel="stylesheet" href="../../css/owl.carousel.min.css">
<link rel="stylesheet" href="../../css/owl.theme.default.min.css">

<link rel="stylesheet" href="../../css/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="../../css/style.css">

</head>
<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<!--   <div id="overlayer"></div>
  <div class="loader">
    <div class="spinner-border text-primary" role="status">
      <span class="sr-only">Loading...</span>
    </div>
  </div> -->

	<div class="site-wrap" id="home-section">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>
	</div>

	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<a href="#" class="text-white"><span
						class="mr-2 text-white icon-envelope-open-o"></span> <span
						class="d-none d-md-inline-block">�|�����U</span></a> <span
						class="mx-md-2 d-inline-block"></span> <a href="#"
						class="text-white"><span class="mr-2 text-white icon-phone"></span>
						<span class="d-none d-md-inline-block">1+ (234) 5678 9101</span></a>


					<div class="float-right">

						<a href="#" class="text-white"><span
							class="mr-2 text-white icon-twitter"></span> <span
							class="d-none d-md-inline-block">�|���n�J</span></a> <span
							class="mx-md-2 d-inline-block"></span>
					</div>

				</div>

			</div>

		</div>
	</div>

	<header class="site-navbar js-sticky-header site-navbar-target"
		role="banner">

		<div class="container">
			<div class="row align-items-center position-relative">


				<div class="site-logo">
					<a href="index.jsp" class="text-black"><span
						class="text-primary">Unearth</span></a>
				</div>

				<div class="col-12">
					<nav class="site-navigation text-right ml-auto " role="navigation">

						<ul
							class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
							<li><a href="#home-section" class="nav-link">����</a></li>

							<li class="has-children"><a href="#about-section"
								class="nav-link">�|���M��</a>
								<ul class="dropdown arrow-top">
									<li><a href="#team-section" class="nav-link">Team</a></li>
									<li><a href="#pricing-section" class="nav-link">Pricing</a></li>
									<li><a href="#faq-section" class="nav-link">FAQ</a></li>
									<li class="has-children"><a href="#">More Links</a>
										<ul class="dropdown">
											<li><a href="#">Menu One</a></li>
											<li><a href="#">Menu Two</a></li>
											<li><a href="#">Menu Three</a></li>
										</ul></li>
								</ul></li>

							<li><a href="#services-section" class="nav-link">�ӫ�</a></li>




							<li><a href="#press-section" class="nav-link">����</a></li>

							<li><a href="#testimonials-section" class="nav-link">���ΰ�</a></li>
							<!--            <li><a href="#blog-section" class="nav-link">���a�C��</a></li> -->
							<li><a href="listAllShop.jsp" class="nav-link">���a�C��</a></li>
							<li><a href="#contact-section" class="nav-link">�Q�װ�</a></li>
						</ul>
					</nav>

				</div>

				<div class="toggle-button d-inline-block d-lg-none">
					<a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span
						class="icon-menu h3"></span></a>
				</div>

			</div>
		</div>

	</header>

	<title>���a�n�J</title>
	<style>
table {
	margin-top: 10px;
}

tr th {
	border: 2px solid black;
	text-align: center;
}

td {
	text-align: center;
}

.icon {
	width: 20px;
	height: 20px;
}

tr:nth-child(odd) {
	background-color: #FFED97;
}

img {
	width: 300px;
	height: 200px;
}

h4 {
	margin-left: 20px;
}
</style>
</head>
<h4 style="margin-left: 20px;">
	<a href="index.jsp"><img src="images/add-icon.png" class="icon">�^����</a>
</h4>
<body>

	<form method="post" action="shop.do">
		<div class="login-form" style="margin-top: 40px;">
			<h1>���a�n�J</h1>
			<div class="form-group ">
				<input type="text" class="form-control" placeholder="�b�� "
					id="UserName" name="account"> <i class="fa fa-user"></i>
			</div>
			<div class="form-group log-status">
				<input type="password" class="form-control" placeholder="�K�X"
					id="Passwod" name="password"> <i class="fa fa-lock"></i>
			</div>
			<span style="font-size: 12px; color: #f00; float: left;"> 
			<%-- ���~��C --%> 
			<c:if test="${not empty errorMsgs}">
						<c:forEach var="message" items="${errorMsgs}">
							${message}
						</c:forEach>
			</c:if>
			</span>
			 <a class="link" href="addShop.jsp">���U</a> <input type="submit"
				class="log-btn" value="�|���n�J"> <input type="hidden"
				name="action" value="login">
			<!-- 			</button> -->
		</div>
	</form>

	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<!-- 		<script src="../../js/script.js"></script> -->
</body>
</html>