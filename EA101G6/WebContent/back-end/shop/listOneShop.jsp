<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.model.*"%>

    <%
	ShopVO shopVO = (ShopVO) request.getAttribute("shopVO"); //shopServlet.java (Concroller) 存入req的shopVO物件 (包括幫忙取出的shopVO, 也包括輸入資料錯誤時的shopVO物件)
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
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
	width: 300px;
	height: 200px;
}

h4 {
	margin-left: 20px;
}
</style>
<table>
	<tr>
		<th>店家編號</th>
		<th>店家名稱</th>
		<th>位置</th>
		<th>場地</th>
		<th>電話</th>
		<th>店家圖片</th>
		<th>店家狀態</th>
	</tr>
	<tr>
		<td><%=shopVO.getShopno()%></td>
		<td><%=shopVO.getShopname()%></td>
		<td><%=shopVO.getShoploc()%></td>
		<td><%=shopVO.getShopcy()%></td>
		<td><%=shopVO.getShopphone()%></td>
		<td><%=shopVO.getStatus()%></td>
		<td><img src="<%=request.getContextPath()%>/ShopShowImg?shopno=${shopVO.shopno}" /></td>
	</tr>

</table>
</body>
</html>