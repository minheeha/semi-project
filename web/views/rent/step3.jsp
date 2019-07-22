<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="tab-pane" role="tabpanel" id="step3">
	<div class="container">
		<h2>A관의 이용 정보를 입력해주세요.</h2>
		<hr style="background: black">

		<!-- 이용 가능 시간 -->
		<div class="form-group">
			<label class="necessary">*</label><label for="availStartTm">이용 가능 시간</label>
			<br>

			<div class="ui checkbox">
				<input type="checkbox" name="example"><label>24시 운영</label>
			</div>

			<br>
			<select class="form-control" name="availStartTm" id="availStartTm" style="width: 150px; min-width: 150px; display:inline; margin: 0 2% 0 0">
				<%for(int i=0; i<=24; i++){ %>
					<%if (i / 10 == 0){%>
						<option><%="0" + i + ":00" %></option>
					<%} else {%>
						<option><%=i + ":00" %></option>
					<%} %>
				<%}%>
			</select>
			<label>~</label>
			<select class="form-control" name="availEndTm" id="availEndTm" style="width: 150px; min-width: 150px; display:inline; margin: 0 2% 0 2%">
				<%for(int i=0; i<=24; i++){ %>
					<%if (i / 10 == 0){%>
						<option><%="0" + i + ":00" %></option>
					<%} else {%>
						<option><%=i + ":00" %></option>
					<%} %>
				<%}%>
			</select>
		</div>

		<br>

		<!-- 최소 예약 시간 -->
		<div class="form-group" style="display: inline; width: 49%; float: left;">
			<label class="necessary">*</label><label for="minRsvTm">최소 예약 시간</label>
			<br><br>
			<select class="form-control" name="minRsvTm" id="minRsvTm" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0">
				<%for(int i=0; i<=24; i++){ %>
					<%if (i / 10 == 0){%>
						<option value="<%=i %>"><%=i  %> 시간</option>
					<%} else {%>
						<option value="<%=i %>"><%=i %> 시간</option>
					<%} %>
				<%}%>
			</select>
			<p style="margin-top: 2%">* 최소 예약 가능한 시간을 입력해주세요.</p>
		</div>

		<!-- 최소 예약 가능 인원 수 -->
		<div class="form-group" style="display: inline; width: 49%; float: right;">
			<label class="necessary">*</label><label for="maxHeadCount">예약 가능 인원 수</label>
			<br><br>
			<input id="maxHeadCount" type="number" class="form-control" name="maxHeadCount" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0" placeholder="예약 가능 인원 수">

			<%--
			<select class="form-control" name="maxHeadCount" id="maxHeadCount" style="width: 200px; min-width: 200px; display:inline; margin: 0 2% 0 0">
				<%for(int i=0; i<=24; i++){ %>
					<%if (i / 10 == 0){%>
						<option><%="0" + i + " 시간" %></option>
					<%} else {%>
						<option><%=i + " 시간" %></option>
					<%} %>
				<%}%>
			</select>
			 --%>

			<br>
			<p style="margin-top: 2%">* 예약 가능한 최대 인원수를 입력해주세요.</p>
		</div>

		<br><br><br><br><br><br><br><br>

		<!-- 시설 세부항목 -->
		<h2>시설 세부항목 설정</h2>
		<hr style="background: black">

		<span style="font-size: 3em; color: black;">
		  <i class="fas fa-camera"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-car-side"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-couch"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-bath"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-smoking-ban"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-desktop"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-wifi"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-toilet"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-microphone-alt"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-print"></i>
		</span>
		<span style="font-size: 3em; color: black;">
			<i class="fas fa-chalkboard"></i>
		</span>



		<br><br><br><br><br><br><br><br>

		<h2>휴무일 설정</h2>
		<hr style="background: black">

		<!-- 정기 휴무일 -->
		<div class="form-group">
			<label class="necessary">*</label><label for="regHoliday">정기 휴무</label>
			<br>

			<div class="ui checkbox">
				<input type="checkbox" name="example"><label>공휴일 휴무</label>
			</div>

			<br>
			<select class="form-control" name="regCloseCd" id=regCloseCd style="width: 200px; min-width: 200px;">
				<option value="1">휴무 없음</option>
				<option value="2">매주</option>
				<option value="3">격주(홀수주)</option>
				<option value="4">격주(짝수주)</option>
				<option value="5">매월 첫째주</option>
				<option value="6">매월 둘째두</option>
				<option value="7">매월 셋째주</option>
				<option value="8">매월 넷째주</option>
				<option value="9">매월 마지막주</option>
				<option value="10">매월 말일</option>
				<option value="11">매월 직접 입력</option>
			</select>
		</div>

		<script type="text/javascript">

		</script>

		<br><br>

		<div class="form-group">
			<label class="necessary">*</label><label for="startTime">사용자 지정 휴무일</label>
			<br><br>

			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="width: 100%;">휴무일 추가 +</button>

			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="background: #ad42f5;">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title" style="color:white">지정 휴무일 추가</h4>
						</div>
						<div class="modal-body">
							<p style="color: red; font-weight: bold ">* 휴무일 명</p>
							<input id="holTitle" type="text" class="form-control" name="holTitle" placeholder="휴무일 명을 입력하세요.">

							<hr>

							<p style="color: red; font-weight: bold ">* 날짜</p>
							<input id="holTitle" type="text" class="form-control" name="holTitle" placeholder="휴무일 명을 입력하세요.">

							<hr>
							<p style="color: red; font-weight: bold ">* 요일</p>
							<select class="form-control" id="regHoliday">
								<option>매일</option>
								<option>월요일</option>
								<option>화요일</option>
								<option>수요일</option>
								<option>목요일</option>
								<option>금요일</option>
								<option>토요일</option>
								<option>일요일</option>
							</select>


						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-success" data-dismiss="modal" style="width: 100%;">저장</button>
						</div>
					</div>
				</div>
			</div>
		</div>


		<br><br>
		<button type="button" class="btn btn-danger prev-step" style="width: 49%;">취소</button>
		<button type="button" class="btn btn-success next-step" style="width: 49%; float: right;">다음</button>
	</div>
</div>