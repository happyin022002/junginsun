<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2019.jsp
*@FileTitle  : M.G.Set Sstus Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm2019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String form_day         = "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		form_day  = DateTime.getDateString().replace(".","");  


		event = (EesCgm2019Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="aciac_div_cd" id="aciac_div_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="form_day" value="<%=form_day %>" id="form_day" />
<input type="hidden" name="sts_evnt_dt" style="width:80px;text-align:center;;text-align:center;" class="input2" readonly="readonly" size="10" id="sts_evnt_dt" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--></div>
<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="1">
				<col width="247">
				<col width="1">
				<col width="*">
			</colgroup>
			<tbody> 
				<tr>
					<th>M.G.Set No.</th>
					<td><input type="text" dataformat="engup" name="eq_no" style="width:100px;ime-mode:disabled" onkeypress="keychk();" class="input1" value="" maxlength="10" id="eq_no" /> </td>
					<th>Office</th>
					<td><input name="ofc_cd" dataformat="engup" type="text" style="width:70px;ime-mode:disabled;text-align:center" class="input" maxlength="6" value="<%=strOfc_cd%>" id="ofc_cd" /><button type="button" id="ComOpenPopupWithTarget2" name="ComOpenPopupWithTarget2" class="input_seach_btn"></button></td>
					<td></td>
				</tr> 
				<tr>
					<th>Type</th>
					<td><input type="text" name="eq_tpsz_cd" style="width:100px;text-align:center" class="input2" value="" readonly="readonly" id="eq_tpsz_cd" /> </td>
					<th>Lease Term</th>
					<td><input type="text" name="agmt_lstm_cd" style="width:70px;;text-align:center" class="input2" value="" readonly="readonly" id="agmt_lstm_cd" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table> 
			<tbody>
				<colgroup>
					<col width="100">
					<col width="1">
					<col width="*">
				</colgroup>
				<tr>
					<th>Lessor</th>
					<td><input type="text" style="width:100px;;text-align:center" name="vndr_seq" class="input2" value="" readonly="readonly" id="vndr_seq" /><input type="text" style="width:320px;" name="vndr_lgl_eng_nm" class="input2" value="" readonly="readonly" id="vndr_lgl_eng_nm" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">		
		<table class="sm"> 
			<colgroup>
					<col width="100">
					<col width="100">
					<col width="152">
					<col width="100">
					<col width="1">
					<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th><input type="radio" value="L" name="yardChk" onclick="javascript:yard_Chk()" disabled="" class="trans" readonly="readonly" checked="" id="yardChk" /> Lost</th>
					<th>Lost Date</th>
					<td><input type="text" name="l_evnt_dt" maxlength="10" style="width:80px;ime-mode:disabled" dataformat="ymd" class="input1" id="l_evnt_dt" /><button type="button" id="btns_Calendar1" name="btns_Calendar1" class="calendar ir"></button></td>
					<th>Lost Yard</th>
					<td><input type="text" dataformat="engup" maxlength="7" style="width:72px;ime-mode:disabled" class="input1" value="" name="l_evnt_yd_cd" id="l_evnt_yd_cd" /><button type="button" id="ComOpenPopupWithTargetYard1" name="ComOpenPopupWithTargetYard1" class="input_seach_btn"></button></td>
					<td></td>
				</tr>
				<tr>
					<th><input type="radio" value="F" class="trans" onclick="javascript:yard_Chk()" disabled="" name="yardChk" id="yardChk" /> Found</th>
					<th>Found Date</th>
					<td><input type="text" style="width:80px;ime-mode:disabled" dataformat="ymd" maxlength="10" name="f_evnt_dt" class="input1" value="" id="f_evnt_dt" disabled="disabled"/><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir" disabled="disabled"></button></td>
					<th>Found Yard</th>
					<td><input type="text" dataformat="engup" maxlength="7" style="width:72px;ime-mode:disabled" class="input1" value="" name="f_evnt_yd_cd" id="f_evnt_yd_cd" /><button type="button" id="ComOpenPopupWithTargetYard2" name="ComOpenPopupWithTargetYard2" class="input_seach_btn" disabled="disabled"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div id="tabLayer" style="display:none">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- developer working end -->
</form>
