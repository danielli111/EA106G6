<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>搜尋</title>
</head>
<body>
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
		<li><a href='listAllGame.jsp' >List</a> all Games. <br></li>


		<li>
			<FORM METHOD="post" ACTION="game.do">
				<b>輸入遊戲名稱關鍵字 (如狼人殺):</b> <input type="text" name="gmname">
				<input type="hidden" name="action" value="getSome_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<jsp:useBean id="gameSvc" scope="page"
			class="com.game.model.GameService" />

		<li>
			<FORM METHOD="post" ACTION="game.do">
				<b>選擇遊戲編號:</b> <select size="1" name="gmno">
					<c:forEach var="gameVO" items="${gameSvc.all}">
						<option value="${gameVO.gmno}">${gameVO.gmno}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="game.do">
				<b>選擇遊戲名稱:</b> <select size="1" name="gmno">
					<c:forEach var="gameVO" items="${gameSvc.all}">
						<option value="${gameVO.gmno}">${gameVO.gmname}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>


</body>
</html>