<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shopbk.model.*"%>

<%
	ShopbkVO shopbkVO = (ShopbkVO) request.getAttribute("shopbkVO");
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
							class="icon" src="images/User-icon.png">�|���n�J</span></a> <a
						href="login.jsp" class="text-white"><span
						class="d-md-inline-block"><img class="icon"
							src="images/man-icon.png">���a�n�J</span></a>
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

	<title>�s�W�C��</title>

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
	width: 300px;
	height: 200px;
}
</style>
</head>
<body bgcolor='white'>

	<table id="table-1">
		<a href="index.jsp"><img src="images/add-icon.png" class="icon">�^����</a>
		<h3>���ѭq��</h3>
	</table>
	<%-- ���~��C --%>
	<%-- 	<c:if test="${not empty errorMsgs}"> --%>
	<!-- 		<font style="color: red">�Эץ��H�U���~:</font> -->
	<!-- 		<ul> -->
	<%-- 			<c:forEach var="message" items="${errorMsgs}"> --%>
	<%-- 				<li style="color: red">${message}</li> --%>
	<%-- 			</c:forEach> --%>
	<!-- 		</ul> -->
	<%-- 	</c:if> --%>

	<FORM METHOD="post" ACTION="shopbk.do">
		<table>
			<tr>
				<td>���a�s��:</td>
				<td><input type="TEXT" name="shopno" size=100%
					value="<%=(shopbkVO == null) ? "" : shopbkVO.getShopno()%>" /></td>
			</tr>
			<tr>
				<td>���ѤH��:</td>
				<td><input type="TEXT" name="ofdtable" size=100%
					value="<%=(shopbkVO == null) ? "" : shopbkVO.getOfdtable()%>" /></td>
			</tr>
			<tr>
				<td>�_:</td>
				<td><input type="TEXT" name="shoppds" size=100% id="f_date1"
					value="<%=(shopbkVO == null) ? "" : shopbkVO.getShoppds()%>" /></td>
			</tr>
			<tr>
				<td>��:</td>
				<td><input type="TEXT" name="shoppde" size=100% id="f_date2"
					value="<%=(shopbkVO == null) ? "" : shopbkVO.getShoppde()%>" /></td>
			</tr>
			<tr>
				<td>�C�p��:</td>
				<td><input type="TEXT" name="payinfohr" size=100%
					value="<%=(shopbkVO == null) ? "" : shopbkVO.getPayinfohr()%>" />��</td>
			</tr>
			<tr>
				<td>�]��:</td>
				<td><input type="TEXT" name="payinfoday" size=100%
					value="<%=(shopbkVO == null) ? "" : shopbkVO.getPayinfoday()%>" />��</td>
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W">
	</FORM>
</body>

<link rel="stylesheet" type="text/css"
	href="../../datetimepicker/jquery.datetimepicker.css" />
<script src="../../datetimepicker/jquery.js"></script>
<script src="../../datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
	$.datetimepicker.setLocale('zh'); // kr ko ja en
	$('#f_date1').datetimepicker({
		theme : '', //theme: 'dark',
		timepicker : true, //timepicker: false,
		step : 30, //step: 60 (�o�Otimepicker���w�]���j60����)
		format : 'Y-m-d H:i',
		value : new Date(),
		//disabledDates:    ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
		//startDate:	        '2017/07/10',  // �_�l��
		minDate : '-1970-01-01', // �h������(���t)���e
	//maxDate:           '+1970-01-01'  // �h������(���t)����
	});
	$('#f_date2').datetimepicker({
		theme : '', //theme: 'dark',
		timepicker : true, //timepicker: false,
		step : 30, //step: 60 (�o�Otimepicker���w�]���j60����)
		format : 'Y-m-d H:i',
		value : new Date(),
		//disabledDates:    ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
		//startDate:	        '2017/07/10',  // �_�l��
		minDate : '-1970-01-01', // �h������(���t)���e
	//maxDate:           '+1970-01-01'  // �h������(���t)����
	});

</script>
</html>