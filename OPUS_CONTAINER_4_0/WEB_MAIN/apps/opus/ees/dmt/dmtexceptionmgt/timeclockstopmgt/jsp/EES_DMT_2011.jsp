<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_dmt_2011.jsp
*@FileTitle : Time Clock Stop Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.event.EesDmt2010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2010Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTExceptionMgt.TimeClockStopMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt2010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();

	}
	
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="date_period">
<input type="hidden" name="office">
<input type="hidden" name="clk_stop_ofc_cd">
<input type="hidden" name="dmdt_trf_cd">

<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
   
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New"      id="btn_New">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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

<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="40px" />
	            <col width="200px" />
	            <col width="265px" />
	            <col width="70px" />
	            <col width="120px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10">&nbsp;Date</th>
					<td class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10">
						<input type="radio" name="r_date" value="1" class="trans" checked>Creation&nbsp;&nbsp;&nbsp;
						<input type="radio" name="r_date" value="2" class="trans">Stop Period</td>
					<td class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10">
						<input type="text" style="width:80px;" class="input1" name="fm_dt" dataformat="ymd"  caption="From Date">&nbsp;~
						<input type="text" style="width:80px;" class="input1" name="to_dt" dataformat="ymd"  caption="To Date" ><!--
					--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
						<!--<img src="img/btns_calendar.gif" name="btns_calendar" width="19px" height="20px" alt="" border="0" align="absmiddle" style="cursor:hand" >-->
					
					</td>
					<th>Status</th>
					<td>
						<select name="cxl_flg" style="width:100px;" class="input1">
						<option value="" selected>All</option>
						<option value="N">Live</option>
						<option value="Y">Cancelled</option>
						</select>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
	        <colgroup>
	            <col width="75px" />
	            <col width="428px" />
	            <col width="72px" />
	            <col width="270px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Stop Office </th>
					<td>
						<script language="javascript">ComComboObject('combo2', 2, 100 , 0)</script><!-- 
						--><button type="button" class="multiple_inq"></button>
						<input type="checkbox" name="chk_sub_ofc" value="Y" class="trans" onClick="doInclSubOfc()">Incl. Sub Office
					</td>
							
					<th>Tariff type </th>
					<td>
						<script language="javascript">ComComboObject('combo1', 2, 250 , 0)</script><!-- 
						--><button type="button" class="multiple_inq"></button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
		</div>
	<!-- opus_design_grid(E) -->
</form>