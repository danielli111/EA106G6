<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.gmlist.model.*"%>
<%@ page import="com.shop.model.*"%>
<%@ page import="com.game.model.*"%>

<%
	GmlistService gmlistSvc = new GmlistService();
	ShopVO shopVO = (ShopVO) session.getAttribute("account");
	List<GmlistVO> list = gmlistSvc.getSomeGmlistByShop(shopVO.getShopno());
	pageContext.setAttribute("list", list);
%>
<jsp:useBean id="gameSvc" scope="page"
	class="com.game.model.GameService" />
<jsp:useBean id="shopSvc" scope="page"
	class="com.shop.model.ShopService" />
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

	<title>新增提供的遊戲</title>

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
	<a href="../shop/index.jsp"><img src="images/add-icon.png"
		class="icon">回首頁</a>
</h4>

<table>
	<tr style="background-color: #FFFFFF; border: 0px; font:;">
		<td style="background-color: #FFFFFF; border: 0px;">
			<h3>新增提供的遊戲</h3>
		</td>
	</tr>
</table>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color: red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color: red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
<div>
	<table>
		<tr>
			<th>遊戲名稱</th>
			<th>遊戲圖片</th>
			<th>刪除</th>
		</tr>
		<c:forEach var="gmlistVO" items="${list}">				
			<tr>
				<td>${gameSvc.getOneGame(gmlistVO.gmno).gmname}</td>
				<td><img
					src="<%=request.getContextPath()%>/GameShowImg?gmno=${gmlistVO.gmno}"></td>
				<td><FORM METHOD="post" ACTION="gmlist.do">
				<input type="hidden" name="shopno" value="${gmlistVO.shopno}">
				<input type="hidden" name="gmno" value="${gmlistVO.gmno}">
				<input type="hidden" name="action" value="delete">
				<input type="submit" value="刪除">
					</FORM></td>								
			</tr>
		</c:forEach>
	</table>
</div>

<div>
	<table>
		<tr>
			<th>遊戲名稱</th>
			<th>遊戲圖片</th>
			<th>新增</th>
		</tr>
			
			<c:forEach var="gameVO" items="${gameSvc.all}">
				<c:set var="tampbollean" value="true"/>
				<c:forEach var="gmlistVO" items="${list}">
					<c:if test="${gameVO.gmno==gmlistVO.gmno}">
						<c:set var="tampbollean" value="false"/>
					</c:if>
				</c:forEach>					
						
						<c:if test="${tampbollean}">
						<tr>
							<td>${gameVO.gmname}</td>
							<td><img
								src="<%=request.getContextPath()%>/GameShowImg?gmno=${gameVO.gmno}"></td>
							<td>							
							<FORM METHOD="post" ACTION="gmlist.do">
							<input type="hidden" name="shopno" value="<%=shopVO.getShopno()%>">
							<input type="hidden" name="gmno" value="${gameVO.gmno}">
							<input type="hidden" name="action" value="insert">
							<input type="submit" value="新增">
							</FORM></td>								
						</tr>
						</c:if>
						
			</c:forEach>
	</table>
</div>
</body>
</html>