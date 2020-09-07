<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物主页</title>
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
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
}

.news {
	height: 35px;
	background: #fff;
	overflow: hidden;
}

.news .t_news {
	height: 20px;
	color: #2a2a2a;
	margin-top: 15px;
	overflow: hidden;
	position: relative;
	width: 800px;
}

.news .news_li, .swap {
	line-height: 20px;
	display: inline-block;
	position: absolute;
	top: 0;
	right: 0;
	font-size: 20px;
	text-align: right;
	color: #585858
}

.news .swap {
	top: 20px;
}
</style>
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
	<!-- 公告轮播 -->
	<div class="news">
		<div class="t_news">
			<ul class="news_li">
			<c:forEach items="${ noticeList }" var="notice">
				<li>${notice.noticeTheme} ${ notice.noticeDetail } ${notice.noticeDate }</li>
			</c:forEach>
			</ul>
			<ul class="swap"></ul>
		</div>
	</div>
	<!-- 展示商品 -->
	<div align="center">
		<input type="text" id="searchInfo"><input type="submit"
			value="搜索" id="search" class="btn btn-primary">
		<h3>商品列表</h3>
		<table style="text-align: center" class="table">
			<thead class="thead-dark">
				<tr>
					<th>商品名</th>
					<th>商品价格</th>
					<th>详情</th>
				</tr>
			</thead>
			<c:forEach items="${searchList != null ? searchList : productList}"
				var="product">
				<tr>
					<td>${ product.pname }</td>
					<td>${ product.price }</td>
					<td><a href="viewProduct?pname=${ product.pname }">详情</a></td>
				</tr>
			</c:forEach>
		</table>
		<div align="center" style="width: 150px">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
		<a href="showCart">查看购物车</a>
	</div>
	<script type="text/javascript">
		$('.swap').html($('.news_li').html());
		x = $('.news_li');
		y = $('.swap');
		h = $('.news_li li').length * 20; //20为每个li的高度
		var hh = $('.news_li li').length;
		if (hh > 1)
			//setTimeout(b,3000);//滚动间隔时间 现在是3秒
			b();
		b();

		function b() {
			t = parseInt(x.css('top'));
			//alert(t)
			y.css('top', '20px');
			x.animate({
				top : t - 20 + 'px'
			}, 'slow'); //20为每个li的高度
			if (Math.abs(t) == h - 20) { //20为每个li的高度
				y.animate({
					top : '0px'
				}, 'slow');
				z = x;
				x = y;
				y = z;
			}
			setTimeout(b, 2000); //滚动间隔时间 现在是3秒
		}
	</script>

</body>
</html>