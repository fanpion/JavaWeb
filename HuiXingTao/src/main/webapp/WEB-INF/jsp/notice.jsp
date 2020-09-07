<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告主页</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body background="#FFFFF0">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">彗星淘</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="loginSuccess">主页 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="info">个人信息</a></li>
				<c:if test="${ shoppinger != null && shoppinger.lv == 2}">
					<li class="nav-item"><a class="nav-link" href="shoppingerManage">用户管理</a></li>
					<li class="nav-item"><a class="nav-link" href="noticeManage">公告管理</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="orderManage?shoppingerId=${ shoppinger.shoppingerID}">订单管理</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 购物选择 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<c:forEach items="${productTypeList}" var="typeName">
							<a class="dropdown-item" href="#">${typeName}</a>
						</c:forEach>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">其他</a>
					</div></li>
			</ul>
			<form class="form-inline my-2 my-lg-0" style="color: red">
				<c:if test="${ shoppinger != null }">
				${shoppinger.shoppingerName},
			</c:if>
			</form>
			欢迎您!
			<li class="form-inline my-2 my-lg-0"><a class="nav-link"
				href="login"><c:if test="${ shoppinger != null }">重新</c:if>登录 <span
					class="sr-only">(current)</span> </a> <a class="nav-link"
				href="register">注册<span class="sr-only">(current)</span>
			</a></li>
		</div>
	</nav>
	<!-- 展示公告 -->
	<div align="center">
		<h3>公告列表</h3>
		<td><a href="addNotice" class="btn btn-primary">添加</a>
		<table style="text-align: center" class="table">
			<thead class="thead-dark">
				<tr>
					<th>编号</th>
					<th>主题</th>
					<th>内容</th>
					<th>时间</th>
					<th>查看</th>
				</tr>
			</thead>
			<c:forEach items="${ noticeList }" var="notice">
				<tr>
					<td>${ notice.noticeNumber }</td>
					<td>${ notice.noticeTheme }</td>
					<td>${ notice.noticeDetail }</td>
					<td>${ notice.noticeDate }</td>
					<td><a href="viewNotice?noticeNumber=${ notice.noticeNumber }">详情</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>