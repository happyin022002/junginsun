<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0753.js
*@FileTitle  : VVD Selection Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0753Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0753Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0753Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
		document.form.vps_port_cd.focus();
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="vsl_cd" value="" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" value="" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" value="" id="skd_dir_cd" />
<input type="hidden" name="vps_eta_dt" value="" id="vps_eta_dt" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>VVD Selection Inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">OK</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="30">
			<col width="60">
			<col width="120">
			<col width="200">
			<col width="50">
			<col width="60">
			<col width="100">
			<col width="90">
			<col width="100">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th>Port</th>
				<td><input type="text" name="vps_port_cd" style="width:50px;" class="input1" value="" onkeyup="javascript:upper(this);" id="vps_port_cd" /></td>
				<td class="sm pad_left_8"><input type="radio" name="check_op" value="0" class="trans" checked="" id="check_op1" /><label for ="check_op1">ETD</label><!--    
					 --><input type="radio" name="check_op" value="1" class="trans" id="check_op2" /><label for ="check_op2">ETA</label></td>
				<td class="sm"><input type="text" name="vps_etb_dt" style="width:75px;" class="input" value="" dataformat="ymd" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" id="vps_etb_dt" />~ <input type="text" name="vps_etd_dt" style="width:75px;" class="input" value="" dataformat="ymd" onbeforedeactivate="ComAddSeparator(this)" onbeforeactivate="ComClearSeparator(this)" id="vps_etd_dt" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
				<th>Lane</th>
				<td><input type="text" name="slan_cd" style="width:40px;" class="input" value="" maxlength="3" onkeyup="javascript:upper(this);" id="slan_cd" /></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" name="vvd" style="width:80px;" class="input" value="" maxlength="9" onkeyup="javascript:upper(this);" id="vvd" /></td>
				<th>Vessel Name</th>
				<td><input type="text" name="vsl_eng_nm" style="width:120px;" class="input" value="" maxlength="50" onkeyup="javascript:upper(this);" id="vsl_eng_nm" /></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
<div class="wrap_result">
<!-- layout_wrap(S) -->
<div class="layout_wrap">
   <!-- layout_flex_fixed(S) -->
   <div class="layout_flex_fixed" style="width:500px"> <!-- setting : FIXED width(400px) -->
       <!-- opus_design_grid(S) -->
       <div class="opus_design_grid" style="margin-top:30px">
           <script type="text/javascript">ComSheetObject('sheet1');</script>
       </div>
       <!-- opus_design_grid(E) -->
   </div>
   <!-- layout_flex_fixed(E) -->
   <!-- layout_flex_fixed(S) -->
   <div class="layout_flex_fixed" style="width:80px" style="padding-left:550px"> <!-- setting : FIXED width(400px) -->
   <div style="margin:auto;width:10px;margin-top:100px">
   			<button type="button" class="btn_right" name="btn_add" id="btn_add"></button></br></br><!-- 
   		 --><button type="button" class="btn_left" name="btn_del" id="btn_del"></button>
   </div>
   </div>
   <!-- layout_flex_fixed(E) -->
   <!-- layout_flex_flex(S) -->
   <div class="layout_flex_flex" style="padding-left:590px" style="width:300px"> <!-- (fixed Width) + (padding 8px) = 408 -->
        <!-- opus_design_grid(S) -->
       <div class="opus_design_grid">
       		<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
				<button class="btn_accent" name="btn_rowAdd" id="btn_rowAdd" type="button">Row Add</button><!--
				--><button class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" type="button">Load Excel</button><!--
				--><button class="btn_normal" name="btns_up" id="btns_up" type="button">Up</button><!--
				--><button class="btn_normal" name="btns_down" id="btns_down" type="button">Down</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
           <script type="text/javascript">ComSheetObject('sheet2');</script>
       </div>
       <!-- opus_design_grid(E) -->
   </div>
   <!-- layout_flex_flex(E) -->
</div>
<!-- layout_wrap(E) -->
</div>
<!-- wrap_result(E) -->
</form>
