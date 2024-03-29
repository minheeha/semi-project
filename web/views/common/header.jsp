<%@page import="com.kh.hp.account.model.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserVO user = (UserVO) session.getAttribute("user");
%>
<!DOCTYPE html>
<!-- 아이콘 -->
<link href="/happyPlaystage/css/common/all.min.css" rel="stylesheet">
<script src="/happyPlaystage/js/common/all.min.js"></script>

<style>
.navbar-inverse {
	background-color: white;
    border-color: white;
}
.navbar-inverse .navbar-nav>li>a {
    color: #303030;
    font-size:15px;
}
.navbar-inverse .navbar-nav>li>a:hover {
    color:black;
}
.navbar-inverse .navbar-nav>.open>a, .navbar-inverse .navbar-nav>.open>a:focus, .navbar-inverse .navbar-nav>.open>a:hover {
    color: black;
    background-color: gold;
}
</style>
	<!-- Header_Navigator -->
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid" style="background-color:white; border:0px solid; border-bottom:0.5px solid lightgray">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="<%=request.getContextPath() %>/moveMain.main" style="padding-left:30px;"><i class="fas fa-home" style="color:black;"></i></a>
	    </div>

	    <ul class="nav navbar-nav">

	      <!-- 대관 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">대관<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        <%if(user == null){ %>
		          <li><a href="<%=request.getContextPath() %>/views/account/login.jsp">대관 등록하기</a></li>
			<%}else if((user != null && user.getUserGradeCd() == 0) || (user != null && user.getUserGradeCd() == 2)) { %>
		          <li><a href="<%=request.getContextPath() %>/MoveRentEnroll.rt">대관 등록하기</a></li>
			<%} else {%>
		          <li><a href="<%=request.getContextPath() %>/levelUp">대관 등록하기</a></li>
          	<%} %>

	          <li><a href="<%=request.getContextPath() %>/moveRentList.rt">대관 신청하기</a></li>
	        </ul>
	      </li>

		  <!-- 리뷰 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">리뷰<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/reviewMain.acc">리뷰 보기</a></li>
	          <%if(user == null){ %>
		          <li><a href="<%=request.getContextPath() %>/views/account/login.jsp">대관 등록하기</a></li>
			  <%} else {%>
		          <li><a href="<%=request.getContextPath() %>/reviewEnoll.acc">리뷰 등록하기</a></li>
          	  <%} %>
	        </ul>
	      </li>

		  <!-- 고객센터 관련 -->
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">고객센터<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/notice.sc">공지사항</a></li>
	          <li><a href="<%=request.getContextPath() %>/faq.sc">자주 묻는 질문</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/serviceCenter/introduce.jsp">회사 소개</a></li>
	          <%if(user == null){ %>
	          	<li><a href="<%=request.getContextPath() %>/views/account/login.jsp">1:1 문의</a></li>
			  <%} else {%>
	          	<li><a href="<%=request.getContextPath() %>/moveRealtimeQnA.sc">1:1 문의</a></li>
          	  <%} %>

	          <li><a href="<%=request.getContextPath() %>/views/serviceCenter/terms.jsp">약관 및 개인정보 보호</a></li>
	        </ul>
	      </li>

		  <!-- 관리자 관련 -->
		  <%if(user != null && user.getUserGradeCd() == 0){ %>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">관리자<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/searchUser.ad?userSeq1=&userSeq2=&userNm=&userGradeCd=선택&leaveTf=선택">회원 관리</a></li>
	          <li><a href="<%=request.getContextPath() %>/SetRegPermissions.ad">대관등록 권한설정</a></li>
	          <li><a href="<%=request.getContextPath() %>/inspectionList.ad">대관등록 검수</a></li>
	          <%--
	          <li><a href="<%=request.getContextPath() %>/views/admin/06_salesStatus.jsp">매출 통계</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/07_statistics.jsp">회원 수 통계</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/08_calculate.jsp">매출 정산</a></li>
	          <li><a href="<%=request.getContextPath() %>/views/admin/09_refund.jsp">환불 정산</a></li>
	           --%>
	          <li><a href="<%=request.getContextPath() %>/SelectNotice">공지사항-관리자</a></li>
	          <li><a href="<%=request.getContextPath() %>/moveRealTimeAdmin.ad">1:1 문의 관리</a></li>
	        </ul>
	      </li>
		<%} %>
	    </ul>

		<!-- 검색 관련 -->
		<ul class="nav navbar-nav navbar-right">
			<li>
				<form class="navbar-form navbar-left" action="<%=request.getContextPath() %>/moveRentList.rt">
					<div class="input-group">
						<input type="text" class="form-control" name="searchString" style="background:#ffbf00; border:0.5px solid #ffbf00;">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit" style="background:#ffbf00; border:1px solid #ffbf00;">
								<i class="glyphicon glyphicon-search" style="color:white"></i>
							</button>
						</div>
					</div>
				</form>
			</li>

			<!-- 회원가입 및 로그인 관련 -->


			<!-- 로그인이 안됐을 경우 -->
 			<%if(user == null){ %>
			<li><a href="<%=request.getContextPath() %>/views/account/signUp.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
 			<li><a href="<%=request.getContextPath() %>/views/account/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>

			<!-- 로그인 됐을 경우 -->
			<%} else { %>
			<%-- <li><a href="<%=request.getContextPath() %>/views/account/signUp.jsp"><span class="glyphicon glyphicon-user"></span> <%=user.getUserNick() %>님 환영합니다. </a></li> --%>

			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-pencil"></span> <%=user.getUserNick() %></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath() %>/myPage.mp">마이 페이지</a></li>
	          <li><a href="<%=request.getContextPath() %>/registList.mp">대관 등록 내역</a></li>
	          <li><a href="<%=request.getContextPath() %>/usingInfo">대관 사용 내역</a></li>
	          <li><a href="<%=request.getContextPath() %>/applyInfo1">대관 신청 내역</a></li>
	          <%if(user.getUserGradeCd() != 2 && user.getUserGradeCd() != 0){ %>
	          <li><a href="<%=request.getContextPath() %>/levelUp">등업 신청</a></li>
	          <%} %>
	        </ul>
	      </li>
 			<li><a href="<%=request.getContextPath() %>/logout.acc"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
 			<%} %>
		</ul>
	  </div>
	</nav>