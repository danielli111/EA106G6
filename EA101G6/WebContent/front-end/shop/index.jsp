<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*"%>

<%
	ShopVO account = (ShopVO)session.getAttribute("account");
%>

<!doctype html>
<html lang="en">
  <head>
    <title>Unearth &mdash; Website Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Rubik:300,400,700|Oswald:400,700" rel="stylesheet">
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
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

<!--   <div id="overlayer"></div>
  <div class="loader">
    <div class="spinner-border text-primary" role="status">
      <span class="sr-only">Loading...</span>
    </div>
  </div> -->
  
  <div class="site-wrap"  id="home-section">

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
            <a href="#" class="text-white"><span class="mr-2 text-white icon-envelope-open-o"></span> <span class="d-none d-md-inline-block">會員註冊</span></a>
            <span class="mx-md-2 d-inline-block"></span>
            <a href="#" class="text-white"><span class="mr-2 text-white icon-phone"></span> <span class="d-none d-md-inline-block">1+ (234) 5678 9101</span></a>
            

            <div class="float-right">

            <a href="#" class="text-white"><span class="mr-2 text-white icon-twitter"></span> <span class="d-none d-md-inline-block">會員登入</span></a>          
            <c:if test="${not empty account}">				
							 <span class="mx-md-2 d-inline-block"></span>
							 <a href="update_shop_input.jsp" class="text-white">
							 <span class="mr-2 text-white icon-instagram"></span>
							 <span class="d-none d-md-inline-block">${account.getShopname()}</span>
			</c:if>
			<c:if test="${empty account}">		
							 <span class="mx-md-2 d-inline-block"></span><a href="login.jsp" class="text-white"><span class="mr-2 text-white icon-instagram"></span> <span class="d-none d-md-inline-block">店家登入</span></a>
			</c:if>
            </div>

          </div>
          
        </div>
        
      </div>
    </div>
      
    <header class="site-navbar js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center position-relative">
          
            
            <div class="site-logo">
              <a href="index.jsp" class="text-black"><span class="text-primary">Unearth</span></a>
            </div>
            
            <div class="col-12">
              <nav class="site-navigation text-right ml-auto " role="navigation">

                <ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
                <li><a href="#home-section" class="nav-link">首頁</a></li>

                  <li class="has-children">
                  <a href="#about-section" class="nav-link">會員專區</a>
                  <ul class="dropdown arrow-top">
                    <li><a href="#team-section" class="nav-link">Team</a></li>
                    <li><a href="#pricing-section" class="nav-link">Pricing</a></li>
                    <li><a href="#faq-section" class="nav-link">FAQ</a></li>
                    <li class="has-children">
                      <a href="#">More Links</a>
                      <ul class="dropdown">
                        <li><a href="#">Menu One</a></li>
                        <li><a href="#">Menu Two</a></li>
                        <li><a href="#">Menu Three</a></li>
                      </ul>
                    </li>
                  </ul>
                </li>

                <li><a href="#services-section" class="nav-link">商城</a></li>
              

              

                <li><a href="#press-section" class="nav-link">市集</a></li>
                
                <li><a href="#testimonials-section" class="nav-link">揪團區</a></li>
<!--            <li><a href="#blog-section" class="nav-link">店家列表</a></li> -->
				<li><a href="listAllShop.jsp" class="nav-link">店家列表</a></li>
                <li><a href="#contact-section" class="nav-link">討論區</a></li>
              </ul>
              </nav>
          
            </div>

          <div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

        </div>
      </div>
      
    </header>
    
    <div class="owl-carousel slide-one-item">
      

      


      <div class="site-section-cover  img-bg-section" style="background-image: url('images/logo.gif'); " >
        <div class="container">
          <div class="row align-items-center justify-content-center text-center">
            <div class="col-md-12 col-lg-7">
              <h1 data-aos="fade-up" data-aos-delay="">Welcome to Gameing on board</h1>  
              <p class="mb-5" data-aos="fade-up" data-aos-delay="100">資策會最大桌遊平台上線啦!!</p>
              <p data-aos="fade-up" data-aos-delay="200"><a href="#" class="btn btn-outline-white border-w-2 btn-md">Get in touch</a></p>
            </div>
          </div>
        </div>

      </div>



      <div class="site-section-cover  img-bg-section" style="background-image: url('images/game.png'); " >
        <div class="container">
          <div class="row align-items-center justify-content-center text-center">
            <div class="col-md-12 col-lg-8">
            </div>
          </div>
        </div>

      </div>

      <div class="site-section-cover  img-bg-section" style="background-image: url('images/game2.png'); " >
        <div class="container">
          <div class="row align-items-center justify-content-center text-center">
            <div class="col-md-12 col-lg-8">
            </div>
          </div>
        </div>

      </div>


      <div class="site-section-cover overlay img-bg-section" style="background-image: url('images/game2.png'); " >
        <div class="container">
          <div class="row align-items-center justify-content-center text-center">
            <div class="col-md-12 col-lg-8">
              <h1 data-aos="fade-up" data-aos-delay="">New Generation of Mining</h1>      
              <p class="mb-5" data-aos="fade-up" data-aos-delay="100">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est odit dolorum voluptates!</p>
              <p data-aos="fade-up" data-aos-delay="200"><a href="#" class="btn btn-outline-white border-w-2 btn-md">Get in touch</a></p>
            </div>
          </div>
        </div>
      </div>
      

    </div>
    
    <div class="block__73694 mb-2" >
        最新消息<br>
        ................<br>
        ................<br>
        ................<br>
        ................<br>
    </div>
    
    <div class="block__73694 mb-2" id="services-section">
        商城區<br>
        .........................<br>
        ..........................<br>
        ...........................<br>
        ...........................<br>

    </div>


      

    
    
    <div class="site-section" id="press-section">
     市集<br>
      .........................<br>
        ..........................<br>
        ...........................<br>
        ...........................<br>

    </div>
    <!--  -->
    <div class="site-section bg-light block-13" id="testimonials-section" data-aos="fade">
      揪團區<br>
       .........................<br>
        ..........................<br>
        ...........................<br>
        ...........................<br>

    </div>
    
     <div class="site-section" id="blog-section">
      店家列表<br>
       .........................<br>
        ..........................<br>
        ...........................<br>
        ...........................<br>

    </div>

    <div class="site-section bg-light" id="contact-section">
      討論區<br>
       .........................<br>
        ..........................<br>
        ...........................<br>
        ...........................<br>

    </div>
    

  

  <script src="../../js/jquery-3.3.1.min.js"></script>
   <!-- 看起來沒屁用 -->
  <script src="../../js/popper.min.js"></script>
  <script src="../../js/bootstrap.min.js"></script>
   <!-- 重要廣告界面 -->
  <script src="../../js/owl.carousel.min.js"></script>
  <!-- 看起來沒屁用 -->
  <script src="../../js/jquery.sticky.js"></script>
  <script src="../../js/jquery.waypoints.min.js"></script>
  <script src="../../js/jquery.animateNumber.min.js"></script>
  <script src="../../js/jquery.fancybox.min.js"></script>
  
  
<!-- 上介面連結動畫 -->
  <script src="../../js/jquery.easing.1.3.js"></script>
  
  <!-- 重要廣告界面 -->
  <script src="../../js/aos.js"></script>
  
  <script src="../../js/main.js"></script>
    
  </body>
</html>