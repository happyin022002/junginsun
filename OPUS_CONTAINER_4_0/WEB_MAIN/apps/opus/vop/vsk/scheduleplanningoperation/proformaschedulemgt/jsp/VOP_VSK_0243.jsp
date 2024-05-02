<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0243.jsp
*@FileTitle  : EOTP 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0243Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Enumeration" %>

<%
	VopVsk0243Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopVsk0243Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eventNav">
<input type="hidden" name="portNm">
<!-- 개발자 작업-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>EOTP Creation</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_New" name="btn_New" class="btn_normal">New</button><!--
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="80"/>
				<col width="60"/>
				<col width="55"/>
				<col width="50"/>
				<col width="250"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>History Performance </th>   
				<td>
					<select style="width: 80px;" class="input1" name="hist_yr">
						<option value="365" selected>1 Year</option>
						<option value="730">2 Years</option>
					</select>
				</td>
				<td></td>
				<th>VSL Class</th>
				<td><input type="text" style="width: 50px; text-align:center" class="input2" name="n1st_vsl_clss_cd" value="" readOnly><input type="text" style="width: 20px; text-align:right" class="input2" name="n1st_vsl_clss_knt" value="" readOnly><input type="text" style="width: 50px; text-align:center" class="input2" name="n2nd_vsl_clss_cd" value="" readOnly><input type="text" style="width: 20px; text-align:right" name="n2nd_vsl_clss_knt" class="input2" value="" readOnly><input type="text" style="width: 50px; text-align:center" class="input2" name="n3rd_vsl_clss_cd" value="" readOnly><input type="text" style="width: 20px; text-align:right" class="input2" name="n3rd_vsl_clss_knt" value="" readOnly></td>
				<td></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<div class="opus_design_grid">
		<!-- layout_wrap (S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width: 50%">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid" style="width: 99%">
		            <script type="text/javascript">ComSheetObject('sheet1');</script>
					<script type="text/javascript">ComSheetObject('sheet2');</script>
					<script type="text/javascript">ComSheetObject('sheet3');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		    
		    <div class="layout_vertical_2" style="width: 50%">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		           <script type="text/javascript">ComSheetObject('sheet4');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		        <div class="opus_design_data">
			        <table class="grid_2"> 
			        	<colgroup>
							<col width="50"/>
							<col width="120"/>
							<col width="50"/>
							<col width="120"/>
							<col width="*"/>
						</colgroup>
						<tr>
							<th>EOTP1</th>   
							<td><input type="text" style="width:70;text-align:right" name="eotp01" class="input2" value="" readOnly></td>
							<th>EOTP2</th>   
							<td><input type="text" style="width:70;text-align:right" name="eotp02" class="input2" value="" readOnly></td>
							<td></td>
						</tr>
					</table>
		        </div>
		    </div>
		</div>
		<!-- layout_wrap (E) -->
	</div>
</div>	
</form>