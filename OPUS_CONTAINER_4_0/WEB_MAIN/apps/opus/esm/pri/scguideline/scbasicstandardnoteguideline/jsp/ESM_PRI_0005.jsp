<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ui_pri_0005.jsp
 *@FileTitle  :  Standard Note Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/5/9
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCBasicStandardNoteGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input name="note_hdr_seq" id="note_hdr_seq" type="hidden" value="">
<input name="note_seq" id="note_seq" type="hidden" value="">
<input name="cd" id="cd" type="hidden" value="">

<!-- seleted year -->
<input type="hidden" name="note_ref_yr_hidden" id="note_ref_yr_hidden" value="">
<!-- svc_scp_cd -->
<input type="hidden" name="svc_scp_cd_hidden" id="svc_scp_cd_hidden" value="">
<!-- seleted Duration -->
<input type="hidden" name="eff_dt_hidden" id="eff_dt_hidden" value="">
<input type="hidden" name="exp_dt_hidden" id="exp_dt_hidden" value="">
<!-- seleted note nm -->
<input type="hidden" name="note_nm_hidden" id="note_nm_hidden" value="">
<!-- cust type nm -->
<input type="hidden" name="prc_cust_tp_cd_hidden" id="prc_cust_tp_cd_hidden" value="">
<!-- note_nm -->
<input type="hidden" name="note_nm" id="note_nm" value="">



<input type="hidden" name="svc_scp_cd_copy" id="svc_scp_cd_copy" value="">
<input type="hidden" name="prc_cust_tp_cd_copy" id="prc_cust_tp_cd_copy" value="">
<input type="hidden" name="note_hdr_seq_copy" id="note_hdr_seq_copy" value="">

<!-- ett_dt_before -->
<input type="hidden" name="exp_dt_before" id="exp_dt_before" value="">
<!-- dt combo select 여부 -->
<input type="hidden" name="exp_dt_hidden_select" id="exp_dt_hidden_select" value="">

<!-- developer job	-->
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
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Confirm Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete3" id="btn_delete3">Delete</button><!-- 
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
	<table>
		<colgroup>
			<col width="92">
			<col width="48">
			<col width="90">
			<col width="300">
			<col width="100">
			<col width="183">
			<col width="100">
			<col width="*">
		</colgroup>
		<tr>
			<th>Year</th>
			<td><input name="note_ref_yr" id="note_ref_yr" type="text" maxlength="4" style="width: 40px; text-align: center;" value="" class="input1" ></td>
			<th>Service Scope</th>
			<td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 55, 0, 1, 0, false);</script><input name="svc_scp_nm" type="text" style="width: 242px" value="" class="input2" readonly>					</td>							
			<th>Duration</th>
			<td>				
				<script type="text/javascript">ComComboObject("gline_seq", 3, 108, 0, 1, 0, true);</script>				
		 	 	<input name="eff_dt" id="eff_dt" type="hidden" class="input1" caption="Effective Date" dataformat="ymd" cofield="exp_dt" /> <!-- -->
		 		<span class="dash">~</span><!-- -->
			 	<!-- <input name="eff_dt_hidden" 	id="eff_dt_hidden" 	type="hidden" value="" class="input1"> -->
			 	<input name="exp_dt" id="exp_dt" type="text" style="width:75px;" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" cofield="eff_dt" required><!--  -->
				<button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>														
			<th>Confirmation</th>
			<td><input name="cfm_flg" id="cfm_flg" type="text" style="width: 50px; text-align: center;" class="input2" readOnly></td>
		</tr>
		<tr>
			<th>Standard Note</th>
			<td colspan="3"><script type="text/javascript">ComComboObject('note_nm_cd', 1, 439, 0, 1, 0, true);</script></td>													
			<th>Cust. Type</th>
			<td colspan="3"><script type="text/javascript">ComComboObject('prc_cust_tp_cd', 2, 90, 0, 0, 0, false);</script></td>				
		</tr>
	</table>
</div>
<!-- opus_design_inquiry (E) -->	
</div>

<!-- wrap_result(S) -->  
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<!-- Content -->
		<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>		
		</div>
		<!-- opus_design_btn(e) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->		
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_add2" id="btn_add2">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button>		
		</div>
		<!-- opus_design_btn(e) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(S) -->  
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hiddenSheetLayer" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
</form>

<!-- developer job  end -->
