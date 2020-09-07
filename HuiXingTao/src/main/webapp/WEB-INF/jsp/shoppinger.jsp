<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户主页</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#search').click(
				function() {
					$('#search').val("正在查询")
					$.ajax({
						type : 'post',
						url : 'search',
						data : {
							'searchInfo' : $('#searchInfo').val() == '' ? 0
									: $('#searchInfo').val()
						},
						success : function(check) {
							location.reload(true);
						}
					});
					$('#search').val("搜索")
				})
	})
</script>
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
	<!-- 展示用户 -->
	<div align="center">
		<h3>用户列表</h3>
		<td><a href="addShoppinger" class="btn btn-primary">添加</a>
		<table style="text-align: center" class="table">
			<thead class="thead-dark">
				<tr>
					<th>用户ID</th>
					<th>用户密码</th>
					<th>用户名</th>
					<th>查看</th>
				</tr>
			</thead>
			<c:forEach items="${ shoppingerList }" var="shoppinger">
				<tr>
					<td>${ shoppinger.shoppingerID }</td>
					<td>${ shoppinger.shoppingerPassword }</td>
					<td>${ shoppinger.shoppingerName }</td>
					<td><a href="viewShoppinger?shoppingerID=${ shoppinger.shoppingerID }">详情</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>