<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<style>
	.container{
		padding: 0 10% 0 10%;
	
	}
	
	td{
		
	}
	

</style>

<body>
<jsp:include page="/views/common/header.jsp" />
	<div class="container">
		<form>
			<h3>대관 관련 등업 신청</h3>
		
			<table class="table table-condensed">
				<thead>
					<tr>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>jogn@naver.com</td>

					</tr>
					<tr>
						<td>이름</td>
						<td>홍길동</td>

					</tr>
					<tr>
						<td>닉네임</td>
						<td>NINANO</td>

					</tr>
					<tr>
						<td>이메일</td>
						<td>3837479@naver.com</td>

					</tr>
					<tr>
						<td>연락처</td>
						<td>010-4159-7898</td>

					</tr>
					<tr>
						<td>공연장 등록증</td>
						<td><input type="text" name="perfomer">
					</tr>
					
					<tr>
					<td>
						<button onclick="alert('인증번호를 재전송 하였습니다.');" id="return"
							type="button" class="btn btn-default btn-lg btn-block">
							다시 보내기</button>
					</td>
					
					<td>
						<button onclick="alert('인증완료');" id="success"
							type="button" class="btn btn-default btn-lg btn-block">
							확인</button>
					</td>
				</tr>
				</tbody>
			</table>
		</form>
	</div>
<jsp:include page="/views/common/footer.jsp" />
</body>
</html>
