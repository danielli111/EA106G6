<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*"%>

<%
	ShopVO shopVO = (ShopVO) request.getAttribute("shopVO");
%>
<html>
<head>
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

				<a href="#" class="text-white"><span class="d-md-inline-block"><img
						class="icon" src="images/add-icon.png">���U</span></a>

				<div class="float-right">
					<a href="#" class="text-white"><span class="d-md-inline-block"><img
							class="icon" src="images/User-icon.png">�|���n�J</span></a> <a href="login.jsp"
						class="text-white"><span class="d-md-inline-block"><img
							class="icon" src="images/man-icon.png">���a�n�J</span></a>
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
						<li><a href="index.jsp" class="nav-link">����</a></li>

						<li class="has-children"><a href="" class="nav-link">�|���M��</a>
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

						<li><a href="#mall" class="nav-link">�ӫ�</a></li>
						<li><a href="#shop" class="nav-link">����</a></li>
						<li><a href="#play" class="nav-link">���ΰ�</a></li>
						<li><a href="listAllShop.jsp" class="nav-link">���a�C��</a></li>
						<li><a href="#forum" class="nav-link">�Q�װ�</a></li>
					</ul>
				</nav>

			</div>

			<div class="toggle-button d-inline-block d-lg-none">
				<a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span
					class="icon-menu h3"></span></a>
			</div>

		</div>
	</div>

	<title>���U���a</title>

	<style>
table {
	margin-top: 10px;
}

tr th {
	border: 2px solid black;
	text-align: center;
}

td {
	border: 2px solid black;
	text-align: center;
}
label {
	text-align: left;
}
.icon {
	width: 20px;
	height: 20px;
}

tr:nth-child(odd) {
	background-color: #FFED97;
}

img {
	width:300px;
	height:200px;
}
</style>
</head>
<body bgcolor='white'>

	<table id="table-1">
		<a href="index.jsp"><img src="images/add-icon.png"
			class="icon">�^����</a>
		<h3>���a���U</h3>
	</table>
	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="shop.do" enctype="multipart/form-data">
		<table>
			<tr>
				<td>���a�b��:</td>
				<td><input type="TEXT" name="shopact" size=100%
					value="<%=(shopVO == null) ? "321" : shopVO.getShopact()%>" /></td>
			</tr>
			<tr>
				<td>���a�K�X:</td>
				<td><input type="TEXT" name="shoppw" size=100%
					value="<%=(shopVO == null) ? "123" : shopVO.getShoppw()%>" /></td>
			</tr>
			<tr>
				<td>���a�W��:</td>
				<td><input type="TEXT" name="shopname" size=100%
					value="<%=(shopVO == null) ? "RRRR" : shopVO.getShopname()%>" /></td>
			</tr>
			<tr>
				<td>���a��m:</td>
				<td><input type="TEXT" name="shoploc" size=100%
					value="<%=(shopVO == null) ? "��饫" : shopVO.getShoploc()%>" /></td>
			</tr>
			<tr>
				<td>���a:</td>
				<td><input type="TEXT" name="shopcy" size=100%
					value="<%=(shopVO == null) ? "10�H��*10" : shopVO.getShopcy()%>" /></td>
			</tr>
			<tr>
				<td>�q��:</td>
				<td><input type="TEXT" name="shopphone" size=100%
					value="<%=(shopVO == null) ? "093040" : shopVO.getShopphone()%>" /></td>
			</tr>
			<tr>
				<td>���a�Ϥ�:</td>
				<td>
					<input type="file" id="myFile" name="shopimg">				
					<div id="preview">
					</div>	
				</td>
			</tr>
			<tr>
				<input type="hidden" name="status" value="0">
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W">
	</FORM>
</body>
<script>
	function init() {
		var myFile = document.getElementById("myFile");
		var filename = document.getElementById("filename");
		var preview = document.getElementById('preview');
		myFile.addEventListener('change', function(e) {
			var files = myFile.files;
			if (files !== null && files.length > 0) {
				var file = files[0];
				if (file.type.indexOf('image') > -1) {
// 					filename.value = file.name;
					var reader = new FileReader();
					reader.addEventListener('load', function(e) {
						var result = e.target.result;
						console.log(result);
						var img = document.createElement('img');
						img.src = result;
						preview.innerHTML="";
						preview.append(img);
					});
					reader.readAsDataURL(file);
				}
			}
		});
	}
	window.onload = init;
</script>
</html>