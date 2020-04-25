<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>商品列表</title>
</head>
<body>
	<div>商品列表:</div>
	<c:forEach var="item" items="${goodsList}">
         ${item.name}--${item.price}--${item.pic}
	</c:forEach>
</body>
</html>