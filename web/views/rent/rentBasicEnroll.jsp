<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!-- bootstrap toggle -->
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

<!-- semantic ui -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

<!-- 도로명 주소 -->
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

<!-- 아이콘 -->
<link href="/happyPlaystage/css/common/all.min.css" rel="stylesheet">
<script src="/happyPlaystage/js/common/all.min.js"></script>

<!-- 켈린더 -->
<!--
<link rel="stylesheet" media="screen" type="text/css" href="/happyPlaystage/css/common/datepicker.css" />
<script type="text/javascript" src="/happyPlaystage/js/common/datepicker.js"></script>
 -->
<script type="text/javascript" src="/happyPlaystage/js/common/moment.min.js"></script>
<link rel="stylesheet" href="/happyPlaystage/css/common/daterangepicker.min.css">
<script type="text/javascript" src="/happyPlaystage/js/common/jquery.daterangepicker.min.js"></script>

<!-- 외부 JS/CSS -->
<link rel="stylesheet" href="/happyPlaystage/css/rent/rentEnroll.css">
<script src="/happyPlaystage/js/rent/rentEnroll.js"></script>


</head>
<body>
<jsp:include page="/views/common/header.jsp" />

	<div class="container">
		<div class="row">
			<section>
	        <div class="wizard">
	            <div class="wizard-inner">
	                <div class="connecting-line"></div>
	                <ul class="nav nav-tabs" role="tablist">

	                    <li role="presentation" class="active">
	                        <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Step 1">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-folder-open"></i>
	                            </span>
	                        </a>
	                    </li>

	                    <li role="presentation" class="disabled">
	                        <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Step 2">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-phone"></i>
	                            </span>
	                        </a>
	                    </li>
	                    <li role="presentation" class="disabled">
	                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Step 3">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-calendar"></i>
	                            </span>
	                        </a>
	                    </li>

	                    <li role="presentation" class="disabled">
	                        <a href="#step4" data-toggle="tab" aria-controls="step4" role="tab" title="Step 4">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-picture"></i>
	                            </span>
	                        </a>
	                    </li>

	                    <li role="presentation" class="disabled">
	                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Complete">
	                            <span class="round-tab">
	                                <i class="glyphicon glyphicon-ok"></i>
	                            </span>
	                        </a>
	                    </li>

	                </ul>
	            </div>

	           <form action="<%=request.getContextPath() %>/moveRentBasicInfo.rent" method="post" enctype="multipart/form-data" id="enrollForm">
	                <div class="tab-content">

						<!-- step1 -->
						<div class="tab-pane active" role="tabpanel" id="step1">
							<%@include file="step1.jsp" %>
						</div>
	           <!-- </form> -->
						<!-- Step2 -->
						<div class="tab-pane" role="tabpanel" id="step2">
							<%@include file="step2.jsp" %>
						</div>
						<!-- step3 -->
						<div class="tab-pane" role="tabpanel" id="step3">
							<%@include file="step3.jsp" %>
						</div>
						<!-- step4 -->
						<div class="tab-pane" role="tabpanel" id="step4">
							<%@include file="step4.jsp" %>
						</div>
						<!-- complete -->
						<%@include file="complete.jsp" %>

	                    <div class="clearfix"></div>
	                </div>
	            </form>
	        </div>
	    </section>
	   </div>
	</div>

	<script type="text/javascript">
		/*주소 API 관련*/
		$("#search_button").postcodifyPopUp({
			insertAddress : $("#address")
		});

		$("#search_button2").postcodifyPopUp({
			insertAddress : $("#corpAddress1")
		});

	</script>

	<jsp:include page="/views/common/footer.jsp" />
</body>
</html>