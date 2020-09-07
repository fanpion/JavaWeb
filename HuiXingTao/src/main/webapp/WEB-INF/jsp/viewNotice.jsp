<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ notice.noticeDetail }详细信息</title>
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
						url : 'modifyNotice',
						data : {
							'noticeNumber' : "${notice.noticeNumber }",
							'noticeTheme' : $('#noticeTheme').val(),
							'noticeDetail' : $('#noticeDetail').val(),
							'noticeDate' : $('#noticeDate').val(),
						},
						success : function(check) {
							window.location.href = 'viewNotice?noticeNumber='
								+ ${notice.noticeNumber };
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
		<p>公告详细信息</p>
		<input type="hidden" name="noticeNumber" value="${ notice.noticeNumber }">
		<table border="1" align="center" class="table">

			<tr>
				<td>公告编号</td>
				<td colspan="3">${notice.noticeNumber }</td>
			</tr>
			<tr>
				<td>公告主题</td>
				<td colspan="3"><input type="text" name="noticeTheme" id="noticeTheme" value="${notice.noticeTheme }"></td>
			</tr>
			<tr>
				<td>公告内容</td>
				<td colspan="3"><input type="text" name="noticeDetail" id="noticeDetail" value="${notice.noticeDetail }"></td>
			</tr>
			<tr>
				<td>发布时间</td>
				<td colspan="3"><input type="date" name="noticeDetail" id="noticeDate" value="${notice.noticeDate }"></td>
			</tr>
				<tr>
					<td>操作</td>
					<td><button id="modifyButton" class="btn btn-warning">确认修改</button></td>
					<td><button id="deleteButton" class="btn btn-danger">删除公告</button></td>
					<td><a href="noticeManage" class="btn btn-primary">返回</a>
			</tr>
		</table>

	</div>
</body>
</html>