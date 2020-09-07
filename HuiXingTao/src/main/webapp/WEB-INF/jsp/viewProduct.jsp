<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ product.pname }详细信息</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#shopping').click(function() {
			$.ajax({
				type : 'post',
				url : 'addToCart',
				data : {
					'quantity' : $('#quantity').val(),
					'pname' : "${product.pname }",
				},
				success : function(check) {
					window.location.href = 'showCart';
				}
			});

		});

		$('#addButton').click(function() {
			$.ajax({
				type : 'post',
				url : 'addProduct',
				data : {
					'newProductName' : $('#newProductName').val(),
					'newProductPrice' : $('#newProductPrice').val(),
				},
				success : function(check) {
					window.location.href = 'viewProduct?pname='
						+ $('#newProductName').val();
				}
			});
		});

		$('#modifyButton').click(
				function() {
					$.ajax({
						type : 'post',
						url : 'modifyProduct',
						data : {
							'pname' : "${product.pname }",
							'newProductName' : $('#newProductName').val(),
							'newProductPrice' : $('#newProductPrice').val(),
						},
						success : function(check) {
							window.location.href = 'viewProduct?pname='
									+ $('#newProductName').val();
						}
					});
				});

		$('#deleteButton').click(function() {
			$.ajax({
				type : 'post',
				url : 'deleteProduct',
				data : {
					'pname' : "${product.pname }",
				},
				success : function(check) {
					window.location.href = 'loginSuccess';
				}
			});
		})
	})
</script>
</head>
<body>



	<div style="margin: auto; text-align: center">
		<p>商品详细信息</p>
		<input type="hidden" name="pname" value="${ product.pname }">
		<table border="1" align="center" class="table">

			<tr>
				<td>商品名:</td>
				<td colspan="2">${product.pname }</td>
			</tr>
			<tr>
				<td>价格:</td>
				<td colspan="2">${product.price }</td>
			</tr>
			<tr>
				<td>购买数量</td>
				<td><input type="text" name="quantity" id="quantity"></td>
				<td><button id="shopping" class="btn btn-primary">购买</button></td>
			</tr>
			<c:if test="${ shoppinger != null && shoppinger.lv == 2}">
				<tr>
					<td colspan="3">管理员操作</td>
				</tr>
				<tr>
					<td>新商品名</td>
					<td colspan="1"><input type="text" value=""
						id="newProductName"></td>
					<td><button id="addButton" class="btn btn-success">添加</button></td>
				</tr>
				<tr>
					<td>新价格</td>
					<td colspan="1"><input type="text" value=""
						id="newProductPrice"></td>
					<td><button id="modifyButton" class="btn btn-warning">修改</button></td>
				</tr>
				<tr>
					<td colspan="3"><button id="deleteButton" class="btn btn-danger">删除商品</button></td>
				</tr>
			</c:if>
			<tr>
				<td colspan="3"><a href="loginSuccess">显示商品列表</a>
			</tr>
		</table>

	</div>
</body>
</html>