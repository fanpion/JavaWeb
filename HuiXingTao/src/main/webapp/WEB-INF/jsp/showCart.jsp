<%@page import="com.huixingtao.pojo.GoodsItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ shoppinger.shoppingerName }的购物车</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#orderAdd').click(function() {
			var mytable = document.getElementById("cart");
	        var data = [];
	        for(var i=0,rows=mytable.rows.length; i<rows-2; i++){
	            for(var j=0,cells=mytable.rows[i].cells.length; j<cells-1; j++){
	                if(!data[i]){
	                    data[i] = new Array();
	                }
	                data[i][j] = mytable.rows[i+1].cells[j].innerHTML;
	            }
	        }
			$.ajax({
				type : 'post',
				url : 'orderAdd',
				contentType : "application/json" ,
				data : JSON.stringify(data),
				success : function(check) {
					window.location.href = 'showCart';
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
<body>

	


	<div style="margin: auto; text-align: center">
		<p>您的购物车信息</p>
		<table border="2" id="cart" style="text-align: center" align="center" class="table table-bordered">
			<tr>
				<td>商品名</td>
				<td>数量</td>
				<td>价格</td>
				<td>小计</td>
				<td>是否删除</td>
			</tr>
			<c:forEach items="${items}" var="goodsItem">
				<tr>
					
					<td>${ goodsItem.product.pname }</td>
					<td>${ goodsItem.quantity }</td>
					<td>${ goodsItem.product.price }</td>
					<td>${ goodsItem.product.price * goodsItem.quantity}</td>
					<td><a href="deleteItem?pname=${ goodsItem.product.pname }">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2">总计:</td>
				<td colspan="1">${ sum }</td>
				<td colspan="2"><input id="orderAdd" type="submit" value="现在下单" class="btn btn-primary"></td>

			</tr>
		</table>
		<a href="loginSuccess">继续购物</a>
	</div>
</body>
</html>