<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
  
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" 
 integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    
<title>Insert title here</title>


<style>


#center {
/* 	border: 1px solid black; */
	width: 1300px;
	height: 800px;
	margin: auto;
}

#line {
	border: 0.5px solid gray;
	width: 1300px;
	margin: auto;
}
<!--회원관리내역-->
#text1 {
	width: 180px;
	height: 30px;
	margin-left: 70px;
	
}

#search{

	border: 1px solid gray; 
	width: 1200px;
	height:150px;
	margin-left:50px;
	border-top-left-radius:8px;
	border-top-right-radius:8px;
	border-bottom-left-radius:8px;
	border-bottom-right-radius:8px;
	
}

#users1{
width: 500px;
height:150px;
margin-left:50px;
}


#users4{

width: 100px;
height:150px;
margin-left:700px;
margin-top:-150px;

}

#users5{

width: 100px;
height:150px;
margin-left:800px;
margin-top:-150px;

}


#userno{
	width: 100px;
	margin-left:10px;
	margin-top:30px;
	
}
#input{
	width: 110px;
	margin-left:100px;
	margin-top:-32px;
}

#input1{
	width: 110px;
	margin-left:250px;
	margin-top:-26px;
}

#wave{ 
	width: 10px;
	margin-left:220px;
	margin-top:-28px;
	
}

#assent{
	background:red;
	width: 100px;
	margin-left:0px;
	margin-bottom:30px;
	
}

#leave{
	width: 100px;
	margin-left:100px;
	margin-top:-30px;
}

.col-sm-2{
	width: 100px;
	margin-top:25px;
}

#select{
	width: 100px;
	margin-left:-15px;
	margin-top:25px;
}
#searchbutton{
	margin-left:330px;
	margin-top:40px;
}

.button{
width: 35px;
background: E6E6E6;
border:none;
border-radius: 6px 6px 6px 6px;

}
</style>

</head>
<body>
<jsp:include page="/views/common/header.jsp" />
	<div id="center" class="fram">
	<!-- 타이틀 -->
		<h2 id="text1">
			<strong>대관 등록 권한 설정</strong>
			
		</h2>
		<!-- 회원관리내역과 검색창 사이의 선 -->
		<div id="line"></div>
		<br>
		
		<!--검색영역 -->
		<div id="search">
		<div id="users1">
		<label id="userno">회원번호</label>
		 <div id="input"><input class="form-control" id="ex1" type="text"style="width:100px;"></div> 
		 <div id="wave">~</div>
		 <div id="input1"><input class="form-control" id="ex1" type="text"style="width:100px;"></div> 
		
		<label id="userno">회원명</label>
		 <div id="input"><input class="form-control" id="ex1" type="text"style="width:250px;"></div> 
		
		</div>
		
			
        
        
        
        <div id="users4">
        <label id="userno">등록구분</label>
        </div>
        
        
        <div id="users5">
          <div class="col-sm-2" id="select" >
        <select class="form-control" id="gender1" style="width:100px">
          <option>선택</option>
          <option>승인대기</option>
          <option>승인완료</option>
        </select>       
           
		</div>









          <button type="button" class="btn btn-warning" id="searchbutton">검색</button>
          
          
        </div> 
		</div>
		
		<br><br>
<div class="container">
           
  <table class="table">
    <thead>
      <tr>
        <th>회원번호</th>
        <th>이름</th>
        <th>연락처</th>
        <th>공연장등록증첨부파일</th>
        <th>등록구분</th>
        <th>승인유무</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>00001</td>
        <td>안정웅</td>
        <td>010-1111-1111</td>
        <td>an.jpg</td>
        <td>승인대기</td>
      	<td>
      	<input type="button" value="O" class="button">
      	<input type="button" value="X" class="button">
      	</td>
 <tr>
        <td>00001</td>
        <td>안정웅</td>
        <td>010-1111-1111</td>
        <td>an.jpg</td>
        <td>승인대기</td>
      	<td>
      	<input type="button" value="O" class="button">
      	<input type="button" value="X" class="button">
      	</td>
        
 <tr>
        <td>00001</td>
        <td>안정웅</td>
        <td>010-1111-1111</td>
        <td>an.jpg</td>
        <td>승인대기</td>
      	<td>
      	<input type="button" value="O" class="button">
      	<input type="button" value="X" class="button">
      	</td>
  
    </tbody>
  </table>
</div>
</div>

		
		

		
		
	



<jsp:include page="/views/common/footer.jsp" />
</body>
</html>