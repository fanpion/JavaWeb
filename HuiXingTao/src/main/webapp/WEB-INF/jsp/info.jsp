<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
	
	<div style="margin: auto; text-align: center">
		个人头像: <img alt="个人头像" border="3" src="${(empty shoppinger.shoppingerPicture) ? ("img/default.jpg") : (shoppinger.shoppingerPicture)}"
			heigh="150px" width="150px" class="img-thumbnail"> <br> <a href="download">下载头像</a>
		<form action="uploadPicture" enctype="multipart/form-data"
			method="post">
			上传头像:<input type="file" name="fileName" /> <input type="submit"
				value="提交" />
		</form>
		ID: <span style="color:red">${shoppinger.shoppingerID}</span> <br> 用户名: <span style="color:red">${shoppinger.shoppingerName}</span>
		<br>
		<a href="loginSuccess">返回购物</a>
	</div>
</body>
</html>