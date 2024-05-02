<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_dmt_1007.jsp
*@FileTitle  : Holiday by Country Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1007Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTMasterDataMgt.HolidayMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt1007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hol_yr" id="hol_yr" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="rgn_cd" id="rgn_cd" />
<input type="hidden" name="ste_cd" id="ste_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="retry" id="retry" />

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
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
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
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="50">
	            <col width="90">
	            <col width="75">
	            <col width="70">
	            <col width="45">
	            <col width="">
	        </colgroup>
	        <tbody>
				<tr>
					<th>Country</th>
					<td><script type="text/javascript">ComComboObject('cboCountry', 2, 60 , 0, 1, 0, true)</script></td>
					<th><span id="Region">Region</span></th>
					<td><script type="text/javascript">ComComboObject('cboRegion', 2, 60 , 0, 0, 0, true)</script></td>
					<th>Location</th>
					<td><input type="text" name="location" id="location" style="width:60px;" class="input" value="" dataformat="engup" maxlength="5" OnKeyUp="checkLocation()"></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	        	<col width="51" />
	            <col width="120" />
	            <col width="230" />
	            <col width="*" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Year</th>
					<td><select name="year" id="year" style="width:100px;" class="input"></select></td>
					<td class="sm pad_left_4"><input id="satSun" name="wknd_tp_cd" type="radio" value="" class="trans" checked disabled><label for="satSun">SAT/SUN</label><!--
					--><input id="thuFri" name="wknd_tp_cd" type="radio" value="TF" class="trans" disabled><label for="thuFri">THU/FRI</label><!--
					--><input id="friSat" name="wknd_tp_cd" type="radio" value="FS" class="trans" disabled><label for="friSat">FRI/SAT</label>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	
	
<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear">
			   	<div class="opus_design_btn" style="margin-bottom:-4px;">
				<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_RowCopy" id="btn_RowCopy">Row Copy</button><!--
				--><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_LoadExcel" id="btn_LoadExcel">Load Excel</button>
		</div>
		
		<div class="layout_wrap">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2 mar_top_4" style="width: 9.99%;">  
				<!-- opus_design_grid(S) -->
					<script type="text/javascript">ComSheetObject('sheet1');</script>
			
				<!-- opus_design_grid(E) -->
			</div>
		     <!-- layout_vertical_2(E) -->
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2 mar_top_4 pad_left_12" style="width: 10%;">		
				<!-- opus_design_grid(S) -->
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				<!-- opus_design_grid(E) -->
			</div>
		     <!-- layout_vertical_2(E) -->
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2 mar_top_4 pad_left_12" style="width: 80%;">	 
				<!-- opus_design_grid(S) -->
					<!-- opus_grid_btn(E) -->
					<script type="text/javascript">ComSheetObject('sheet3');</script>
				<!-- opus_design_grid(E) -->
			</div>
		     <!-- layout_vertical_2(E) -->
		</div>
		<!-- layout_wrap(E) -->
	    <div class="wrap_result wFit">
	    	<table> 
    			<colgroup>
					<col width="150" />				
					<col width="*" />				
			   </colgroup> 
				<tr>
					<th>Update Date/OFC/Name</th>
					<td><input type="text" name="upd_dt" id="upd_dt" style="width:80px;" value=""><input type="text" name="upd_ofc_cd" id="upd_ofc_cd" style="width:60px;" value=""><input type="text" name="upd_usr_nm" id="upd_usr_nm" style="width:400px;" value=""></td>
				</tr>
			</table>
	    </div>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- Developer's task end -->
</form>