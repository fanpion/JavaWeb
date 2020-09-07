<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.mydomain.com/sample" prefix="demo"%>
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
	<%
		String username = "";
		String password = "";
		Cookie[] c = request.getCookies();
		if (c != null) {
			for (int i = 0; i < c.length; i++) {
				if ("shoppingerId".equals(c[i].getName())) {
					username = c[i].getValue();
				} else if ("shoppingerPwd".equals(c[i].getName())) {
					password = c[i].getValue();
				}
			}
		}
	%>
	<div style="width:50%;">
		<form action="login" method="post">
			<div class="form-group">
			<demo:token />
			用户名 
			<input type="text" name="username" id="username"
				value="<%=username%>" class="form-control"><input type="button" id="check"
				value="检测" class="btn btn-warning"><span id="checkRe"></span><br> <span
				style="color: red">${error}</span><br>
			</div>
			<div class="form-group">
			<demo:token />
			密码<input type="password" name="password" value="<%=password%>" class="form-control">
			</div><br>
			<input type="checkbox" name="recordPwd" value="1">记住密码 <input
				type="submit" id="submit" value="登录" class="btn btn-primary">
		</form>
		<a href="loginSuccess">返回主页</a>
	</div>
	<p align="center" style="color: blue">该页面被访问了${ applicationScope.count }</p>
</body>
</html>