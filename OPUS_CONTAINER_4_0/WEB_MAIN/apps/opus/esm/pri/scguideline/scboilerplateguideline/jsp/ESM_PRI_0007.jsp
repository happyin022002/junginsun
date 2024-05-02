<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0007.jsp
*@FileTitle  :  Boiler Plate Guideline
*@author     : CLT
*@version    : 1.0
*@since      : 2014/5/9
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.event.EsmPri0007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCBoilerPlateGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
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
<input type="hidden" name="f_cmd" id="f_cmd" value=" ">
<input type="hidden" name="pagerows" id="pagerows" value=" ">
<input type="hidden" name="blpl_hdr_seq" id="blpl_hdr_seq" value=" ">
<input type="hidden" name="blpl_seq" id="blpl_seq" value="">
<input type="hidden" name="blpl_nm" id="blpl_nm" value=" ">
<!-- seleted Duration -->
<input type="hidden" name="eff_dt_hidden" id="eff_dt_hidden" value=" ">
<input type="hidden" name="exp_dt_hidden" id="exp_dt_hidden" value=" ">

<input type="hidden" name="blpl_hdr_seq_copy" id="blpl_hdr_seq_copy" value=" ">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button">
			<span id="title"></span>
		</button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 	
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_confirmcancel" id="btn_confirmcancel">Confirm Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->

<!-- wrap_search(S) -->  
<div class="wrap_search">
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit">
	
		<table class="search">
			<colgroup>
				<col width="30">
				<col width="150">
				<col width="60">
				<col width="240">
				<col width="80">			
				<col width="*">
			</colgroup>
			<tr>
				<th>Year</th>
				<td><input name="blpl_ref_yr" maxlength="4" type="text" style="width:40px;text-align:center;"  value="" class="input1"
				onkeyup="javascript:searchDuration();"/>Boiler Plate</td>
				<th>Duration</th>			
				<td>
				<span class="inquiry_calendar">
	      	 		<input name="eff_dt" id="eff_dt" type="text" style="width:75px;text-align:center;"  value="" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required>~ <!-- 
		       		 --><input name="exp_dt" id="exp_dt" type="text" style="width:75px;text-align:center;"  value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required><!--
		       		 --><button type="button" class="calendar" id="btns_calendar" name="btns_calendar" ></button>
	      		</span>					
				</td>			
				<th>Confirmation</th>
				<td><input name="cfm_flg" type="text" style="width:58px;text-align:center;"  value="" class="input2" readonly caption="Confirmation"></td>
			</tr>
			
		</table>
	</div>
	<!-- opus_design_inquiry (E) -->
</div>

<!-- wrap_result(S) -->  
<div class="wrap_result">
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
		<!-- Content -->
			<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_rowcopy" id="btn_rowcopy">Row Copy</button>
			<button type="button" class="btn_normal" name="btn_rowdelete" id="btn_rowdelete">Delete</button>
		
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<div class="opus_design_grid"><table class="line_bluedot"><tr><td></td></tr></table></div>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
		<!-- Content -->
			<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2">Row Add</button>
			<button type="button" class="btn_normal" name="btn_rowcopy2" id="btn_rowcopy2">Row Copy</button>
			<button type="button" class="btn_normal" name="btn_rowdelete2" id="btn_rowdelete2">Delete</button>	
		</div>
		<!-- opus_design_btn(e) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid" style="display:none;" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>