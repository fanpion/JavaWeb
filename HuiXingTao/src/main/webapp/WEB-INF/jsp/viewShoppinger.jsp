<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ shoppinger.shoppingerName }详细信息</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#modifyButton').click(
				function() {
					$.ajax({
						type : 'post',
						url : 'modifyShoopinger',
						data : {
							'shoppingerID' : "${shoppinger.shoppingerID }",
							'shoppingerPassword' : $('#shoppingerPassword').val(),
							'shoppingerName' : $('#shoppingerName').val(),
						},
						success : function(check) {
							window.location.href = 'viewShoppinger?shoppingerID='
								+ ${shoppinger.shoppingerID };
						}
					});
				});

		$('#deleteButton').click(function() {
			$.ajax({
				type : 'post',
				url : 'deleteShoopinger',
				data : {
					'shoppingerID' : "${shoppinger.shoppingerID }",
				},
				success : function(check) {
					window.location.href = 'shoppingerManage';
				}
			});
		})
	})
</script>
</head>
<body>



	<div style="margin: auto; text-align: center">
		<p>用户详细信息</p>
		<input type="hidden" name="shoppingerID" value="${ shoppinger.shoppingerID }">
		<table border="1" align="center" class="table">

			<tr>
				<td>用户ID</td>
				<td colspan="3">${shoppinger.shoppingerID }</td>
			</tr>
			<tr>
				<td>用户密码</td>
				<td colspan="3"><input type="text" name="shoppingerPassword" id="shoppingerPassword" value="${shoppinger.shoppingerPassword }"></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td colspan="3"><input type="text" name="shoppingerName" id="shoppingerName" value="${shoppinger.shoppingerName }"></td>
			</tr>
			<tr>
				<td>用户头像</td>
				<td colspan="3"><img alt="个人头像" border="3" src="${(empty shoppinger.shoppingerPicture) ? ("/HuiXingTao/img/1.jpg") : (shoppinger.shoppingerPicture)}"
			heigh="150px" width="150px" class="img-thumbnail"></td>
			</tr>
				<tr>
					<td>操作</td>
					<td><button id="modifyButton" class="btn btn-warning">确认修改</button></td>
					<td><button id="deleteButton" class="btn btn-danger">删除用户</button></td>
					<td><a href="shoppingerManage" class="btn btn-primary">返回</a>
			</tr>
		</table>

	</div>
</body>
</html>