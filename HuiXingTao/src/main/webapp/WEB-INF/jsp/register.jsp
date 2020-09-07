<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>彗星淘</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#check').click(
					function() {
						$('#checkRe').html("正在查询");
						$.ajax({
							type : 'post',
							url : 'check',
							data : {
								'username' : $('#username').val() == '' ? 0
										: $('#username').val()
							},
							success : function(check) {
								if (check != 0) {
									$('#checkRe').html("存在此用户");
								} else {
									$('#checkRe').html("不存在此用户");
								}
							}
						});

					})
		})
	</script>
	<div class="form-group" style="width: 50%;">
		<form action="register" method="post">
			<div class="form-group">
			<input type="hidden" name="way" id="way" value="0">
				用户名<input type="text" name="username" id="username"
					class="form-control"> <input type="button" id="check"
					value="检测"><span id="checkRe"></span><br> <span
					style="color: red">${registererror}</span><br>
			</div>
			密码<input type="password" name="password" class="form-control">
			<br> id<input type="text" name="id" id="id" class="form-control"><input
				type="submit" id="submit" value="注册" class="btn btn-primary">
		</form>
		<a href="loginSuccess">返回主页</a>
	</div>
</body>
</html>