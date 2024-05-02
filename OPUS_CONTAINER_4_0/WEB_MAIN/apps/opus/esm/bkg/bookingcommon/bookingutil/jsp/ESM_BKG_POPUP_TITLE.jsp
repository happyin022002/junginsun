<%

	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));

%>
<% 
if(mainPage.equals("true")){
%>
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	   	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->

    	<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	    </div>
	    <!-- opus_design_btn(E) -->
	    

	   	<!-- page_location(S) -->
	    <div class="location">
	        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->	
<%
}else {
%>
<div class="layer_popup_title">	
	<!-- page_title_area(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	   	<h2 class="page_title"><span id="title"></span></h2>
	    <!-- page_title(E) -->

    	<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close">Close</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    	</div>
	<!-- page_title_area(E) -->
</div>
<%
}
%>                   