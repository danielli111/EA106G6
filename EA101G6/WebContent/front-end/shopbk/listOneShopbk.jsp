<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shopbk.model.*"%>

<%
	ShopbkVO shopbkVO = (ShopbkVO) request.getAttribute("shopbkVO"); //shopServlet.java (Concroller) 存入req的shopVO物件 (包括幫忙取出的shopVO, 也包括輸入資料錯誤時的shopVO物件)	
%>

<!doctype html>
<html lang="en">
<head>
<title>Unearth &mdash; Website Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Rubik:300,400,700|Oswald:400,700"
	rel="stylesheet">
<!-- 登入圖示 -->
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
						class="d-none d-md-inline-block">會員註冊</span></a> <span
						class="mx-md-2 d-inline-block"></span> <a href="#"
						class="text-white"><span class="mr-2 text-white icon-phone"></span>
						<span class="d-none d-md-inline-block">1+ (234) 5678 9101</span></a>


					<div class="float-right">

						<a href="#" class="text-white"><span
							class="mr-2 text-white icon-twitter"></span> <span
							class="d-none d-md-inline-block">會員登入</span></a>
						<c:if test="${not empty account}">
							<span class="mx-md-2 d-inline-block"></span>
							<a href="update_shop_input.jsp" class="text-white" name="action"
								value="getOne_For_Update"><span
								class="mr-2 text-white icon-instagram"></span> <span
								class="d-none d-md-inline-block">${account.getShopname()}</span></a>
						</c:if>
						<c:if test="${empty account}">
							<span class="mx-md-2 d-inline-block"></span>
							<a href="login.jsp" class="text-white"><span
								class="mr-2 text-white icon-instagram"></span> <span
								class="d-none d-md-inline-block">店家登入</span></a>
						</c:if>

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
					<a href="../shop/index.jsp" class="text-black"><span
						class="text-primary">Unearth</span></a>
				</div>

				<div class="col-12">
					<nav class="site-navigation text-right ml-auto " role="navigation">

						<ul
							class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
							<li><a href="../shop/index.jsp" class="nav-link">首頁</a></li>

							<li class="has-children"><a href="#about-section"
								class="nav-link">會員專區</a>
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

							<li><a href="#services-section" class="nav-link">商城</a></li>




							<li><a href="#press-section" class="nav-link">市集</a></li>

							<li><a href="#testimonials-section" class="nav-link">揪團區</a></li>
							<!--            <li><a href="#blog-section" class="nav-link">店家列表</a></li> -->
							<li><a href="../shop/listAllShop.jsp" class="nav-link">店家列表</a></li>
							<li><a href="#contact-section" class="nav-link">討論區</a></li>
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

	<title>遊戲列表</title>

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
	width: 50px;
	height: 50px;
}

h4 {
	margin-left: 20px;
}
</style>
</head>
<h4>
	<a href="../shop/index.jsp"><img src="images/add-icon.png" class="icon">回首頁</a>
</h4>

<jsp:include page="select_page.jsp" flush="true">
	<jsp:param name="" value="" />
</jsp:include>

<table>
	<tr>
			<th>店家編號</th>
			<th>提供人數</th>
			<th>開始時間</th>
			<th>結束時間</th>
			<th>以小時計算</th>
			<th>包日</th>
		</tr>
	<tr>
		<td>${shopbkVO.shopno}</td>
		<td>${shopbkVO.ofdtable}</td>
		<td>${shopbkVO.shoppds}</td>
		<td>${shopbkVO.shoppde}</td>
		<td>${shopbkVO.payinfohr}</td>
		<td>${shopbkVO.payinfoday}</td>
	</tr>
</table>

</body>
</html>