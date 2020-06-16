<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*"%>

<%
	ShopVO shopVO = (ShopVO) request.getAttribute("shopVO"); //shopServlet.java (Concroller) �s�Jreq��shopVO���� (�]�A�������X��shopVO, �]�]�A��J��ƿ��~�ɪ�shopVO����)
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
							class="icon" src="images/User-icon.png">�|���n�J</span></a> <a href="#"
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
						<li><a href="" class="nav-link">����</a></li>

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
						<li><a href="#store" class="nav-link">���a�C��</a></li>
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

	<title>���a�ק���</title>

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

	<table>
		<h4>
			<a href="select_page.jsp"><img src="images/add-icon.png"
				class="icon">�^����</a>
		</h4>
	</table>

	<h3>��ƭק�:</h3>

	<%-- ���~���C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="shop.do" name="form1" enctype="multipart/form-data">
		<table>
			<tr>
				<td>���a�s��:</td>
				<td><%=shopVO.getShopno()%></td>
			</tr>
			<tr>
				<td>���a�b��:</td>
				<td><input type="TEXT" name="shopact" size="45"
					value="<%=shopVO.getShopact()%>" /></td>
			</tr>
			<tr>
				<td>���a�K�X:</td>
				<td><input type="password" name="shoppw" size="45"
					value="<%=shopVO.getShoppw()%>" /></td>
			</tr>
			<tr>
				<td>���a�W��:</td>
				<td><input type="text" name="shopname" size="45"
					value="<%=shopVO.getShopname()%>" /></td>
			</tr>
			<tr>
				<td>��m:</td>
				<td><input type="TEXT" name="shoploc" size="45"
					value="<%=shopVO.getShoploc()%>" /></td>
			</tr>
			<tr>
				<td>���a:</td>
				<td><input type="TEXT" name="shopcy" size="45"
					value="<%=shopVO.getShopcy()%>" /></td>
			</tr>
			<tr>
				<td>�q��:</td>
				<td><input type="TEXT" name="shopphone" size="45"
					value="<%=shopVO.getShopphone()%>" /></td>
			</tr>
			<tr>
				<td>���a�Ϥ�:</td>
				<td><input type="file" id="myFile" name="shopimg">
					<div type="file" id="preview"><img style="width:300px;height:200px" src="<%=request.getContextPath()%>/ShopShowImg?shopno=${shopVO.shopno}" /></div></td>
			</tr>
			<input type="hidden" name="status" size="45"
				value="<%=shopVO.getStatus()%>" />



		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="shopno" value="<%=shopVO.getShopno()%>">
		<input type="submit" value="�e�X�ק�">
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