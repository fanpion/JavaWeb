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
			$('#addButton').click(function() {
				$.ajax({
					type : 'post',
					url : 'addNotice',
					data : {
						'noticeNumber' : $('#noticeNumber').val(),
						'noticeTheme' : $('#noticeTheme').val(),
						'noticeDetail' : $('#noticeDetail').val(),
						'noticeDate' : $('#noticeDate').val(),
					},
					success : function(check) {
						window.location.href = 'viewNotice?noticeNumber=' + $('#noticeNumber').val()
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
	<div class="form-group" style="width: 50%;">
		<div class="form-group">
			公告编号<input type="text" name="noticeNumber" id="noticeNumber"
				class="form-control">
		</div>
		公告主题<input type="text" name="noticeTheme" id="noticeTheme"
			class="form-control"> <br> 公告内容<input type="text"
			name="noticeDetail" id="noticeDetail" class="form-control">
		公告时间<input type="date" name="noticeDate" id="noticeDate"
			class="form-control"> <input type="submit" id="addButton"
			value="添加" class="btn btn-primary"> <a href="noticeManage">返回</a>
	</div>
</body>
</html>