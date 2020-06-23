<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.gmlist.model.*"%>
<%@ page import="com.shop.model.*"%>
<%@ page import="com.game.model.*"%>

<style>
body {
	background-position: center;
}
table {
	width: 80%;
	margin-top: 10px;
	margin-left: auto;
	margin-right: auto;
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
h3 {
	margin-left: auto;
	margin-rghit: auto;
}
ul {
	margin-top: 2px;
	margin-left: center;
	margin-right: center;
}
li {
	margin-top: 15px;
}
</style>
</head>
<body bgcolor='white'>
	<h3 style="margin-left:20px;">資料查詢:</h3>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li><a href='listAllGmlist.jsp' >List</a> all Gmlist. <br></li>
<jsp:useBean id="gmlistSvc" scope="page" class="com.gmlist.model.GmlistService" />
<jsp:useBean id="gameSvc" scope="page" class="com.game.model.GameService" />
<jsp:useBean id="shopSvc" scope="page" class="com.shop.model.ShopService" />
<!-- 		<li> -->
<!-- 			<FORM METHOD="post" ACTION="gmlist.do"> -->
<!-- 				<b>選擇遊戲名稱:</b> <select size="1" name="gmno1"> -->
<%-- 					<c:forEach var="gameVO" items="${gameSvc.getAll()}"> --%>
<%-- 						<option value="${gameVO.gmno}">${gameVO.gmname} --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<!-- 				<b>選擇店家名稱:</b> <select size="1" name="shopno1"> -->
<%-- 					<c:forEach var="shopVO" items="${shopSvc.getAllowedShop()}"> --%>
<%-- 						<option value="${shopVO.shopno}">${shopVO.shopname} --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> -->
<!-- 				<input type="hidden" name="action" value="getOne_For_Display"> -->
<!-- 				<input type="submit" value="送出"> -->
<!-- 			</FORM> -->
<!-- 		</li> -->


		<li>
			<FORM METHOD="post" ACTION="gmlist.do">
				<b>選擇遊戲名稱:</b> <select size="1" name="gmno">
					<c:forEach var="gameVO" items="${gameSvc.getAll()}">
						<option value="${gameVO.gmno}">${gameVO.gmname}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getSome_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="gmlist.do">
				<b>選擇店家名稱:</b> <select size="1" name="shopno">
					<c:forEach var="shopVO" items="${shopSvc.getAllowedShop()}">
						<option value="${shopVO.shopno}">${shopVO.shopname}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getSome_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>


</body>
</html>