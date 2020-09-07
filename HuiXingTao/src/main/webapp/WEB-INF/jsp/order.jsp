<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单主页</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#modifyButton').click(function() {
			$.ajax({
				type : 'post',
				url : 'orderModify',
				data : {
					'oID' : $('#modifyButton').id,
				},
				success : function(check) {
					window.location.href = 'orderManage?oID=' + $
					{
						shoppinger.shoppingerID
					}
					;
				}
			});
		});

		$('#deleteButton').click(function() {
			$.ajax({
				type : 'post',
				url : 'deleteNotice',
				data : {
					'noticeNumber' : "${notice.noticeNumber }",
				},
				success : function(check) {
					window.location.href = 'noticeManage';
				}
			});
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
					<li class="nav-item"><a class="nav-link"
						href="shoppingerManage">用户管理</a></li>
					<li class="nav-item"><a class="nav-link" href="noticeManage">公告管理</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link"
					href="orderManage?shoppingerId=${ shoppinger.shoppingerID}">订单管理</a></li>
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
		<h3>订单列表</h3>
		<c:if test="${ shoppinger != null && shoppinger.lv == 2}">
			<input type="text" id="searchOrder">
			<input type="submit" value="搜索" id="search" class="btn btn-primary">
		</c:if>
		<table style="text-align: center" class="table">
			<thead class="thead-dark">
				<tr>
					<th>编号</th>
					<th>用户ID</th>
					<th>商品名</th>
					<th>时间</th>
					<th>数量</th>
					<th>金额</th>
					<th>发货状态</th>
					<c:if test="${ shoppinger != null && shoppinger.lv == 2}">
						<th>点击发货</th>
					</c:if>
					<th>删除</th>
				</tr>
			</thead>
			<c:forEach items="${ orderList }" var="order">
				<tr>
					<td>${ order.oID }</td>
					<td>${ order.shoppingerId }</td>
					<td>${ order.pname }</td>
					<td>${ order.oTime }</td>
					<td>${ order.oQuality }</td>
					<td>${ order.oSum }</td>
					<td>${ order.oSend }</td>
					<c:if test="${ shoppinger != null && shoppinger.lv == 2}">
						<form action="orderModify" method="POST">
							<input type="hidden" value="${ order.oID }" name="oID"> <input
								type="hidden" value="${ shoppinger.shoppingerID }"
								name="shoppingerId">
							<td><input type="submit" value="发货" class="btn btn-primary"></td>
						</form>
					</c:if>
					<form action="orderDelete" method="POST">
						<input type="hidden" value="${ order.oID }" name="oID"> <input
							type="hidden" value="${ shoppinger.shoppingerID }"
							name="shoppingerId">
						<td><input type="submit" value="删除" class="btn btn-danger"></td>
					</form>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>