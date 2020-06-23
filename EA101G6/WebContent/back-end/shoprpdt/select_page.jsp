<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.gmlist.model.*"%>
<%@ page import="com.shoprpdt.model.*"%>

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
		<li><a href='listAllShoprpdt.jsp' >List</a> all Shoprpdt. <br></li>
<jsp:useBean id="shoprpdtSvc" scope="page" class="com.shoprpdt.model.ShoprpdtService" />



		<li>
			<FORM METHOD="post" ACTION="shoprpdt.do">
				<b>選擇檢舉店家編號:</b> <select size="1" name="shoprpno">
					<c:forEach var="shoprpdtVO" items="${shoprpdtSvc.all}">
						<option value="${shoprpdtVO.shoprpno}">${shoprpdtVO.shoprpno}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getSome_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="shoprpdt.do">
				<b>選擇處理狀態:</b> <select size="1" name="status">
						<option value=0>未處理	
						<option value=1>已處理		
				</select> <input type="hidden" name="action" value="getSome_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>


</body>
</html>