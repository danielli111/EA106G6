<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
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
	<h3 style="margin-left:20px;">��Ƭd��:</h3>
	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
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
				<b>��J���a�s�� (�pDS00001):</b> <input type="text" name="gmno">
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<jsp:useBean id="gameSvc" scope="page"
			class="com.game.model.GameService" />

		<li>
			<FORM METHOD="post" ACTION="game.do">
				<b>��ܩ��a�s��:</b> <select size="1" name="gmno">
					<c:forEach var="gameVO" items="${shopSvc.all}">
						<option value="${gameVO.gmno}">${gameVO.gmno}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="game.do">
				<b>��ܩ��a�m�W:</b> <select size="1" name="gmno">
					<c:forEach var="gameVO" items="${gameSvc.all}">
						<option value="${gameVO.gameno}">${gameVO.gmname}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>
	</ul>


</body>
</html>