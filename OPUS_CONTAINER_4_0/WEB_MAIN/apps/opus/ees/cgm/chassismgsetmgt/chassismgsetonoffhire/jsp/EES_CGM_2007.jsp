<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2007.jsp
*@FileTitle  : Chassis On-Hire Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2007Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EesCgm2007Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String form_day         = "";
	String form_hs          = "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		form_day  = DateTime.getDateString().replace(".","-");  
		form_hs   = DateTime.getShortTimeString();
		form_hs   = form_hs.substring(0,2) + ":" + form_hs.substring(2,4);

		event = (EesCgm2007Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<title>M.G.Set On-Hire Creation</title>


<script type="text/javascript">

    function setupPage(){
	    loadPage();
    }

</script>


<form name="form">
<input type="hidden" name="eq_knd_cd" value="G" id="eq_knd_cd" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="agmt_ver_no" id="agmt_ver_no" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="agmt_no" id="agmt_no" />
<input type="hidden" name="eq_no" id="eq_no" />
<input type="hidden" name="eq_spec_no" id="eq_spec_no" />
<input type="hidden" name="own_lse" value="O" id="own_lse" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="cre_id" value="<%=strUsr_id %>" id="cre_id" />
<input type="hidden" name="form_day" value="<%=form_day %>" id="form_day" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>  
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="New" id="New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_verify" id="btn_verify" type="button">Verify</button><!--
		--><button class="btn_normal" name="Save" id="Save" type="button">On-Hire Confirm</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="120" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
			   <tr>
			   		<th class="sm"><input type="radio" value="" class="trans" name="ownleas" onclick="chk('O')" checked id="ownleas" />&nbsp;Own&nbsp;&nbsp;<input type="radio" value="" class="trans" name="ownleas" onclick="chk('L')" id="ownleas" />&nbsp;Leased</th>
			   		<td></td>
			   </tr>
		   </tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="210" />				
				<col width="100" />				
				<col width="120" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
			   <tr>
			   		<th>Created Office</th>
					<td><input type="text" style="width:100px;ime-mode:disabled; text-align:center;" class="input1" dataformat="engup" maxlength="6" name="onh_ofc_cd" id="onh_ofc_cd"><button type="button" id="ComOpenPopupWithTargetOffice" name="ComOpenPopupWithTargetOffice" class="input_seach_btn"></button></td>
					<th>Yard</th>
					<td><input type="text" style="width:100px;ime-mode:disabled; text-align:center;" class="input1" dataformat="engup" maxlength="7" name="onh_yd_cd" id="onh_yd_cd"><button type="button" id="ComOpenPopupWithTargetYard" name="ComOpenPopupWithTargetYard" class="input_seach_btn"></button></td>
					<th>Date</th>
					<td><input type="text" style="width:100px;ime-mode:disabled; text-align:center;" class="input1" name="onh_dt" dataformat="ymd"><button type="button" id="btn_Calendar_a" name="btn_Calendar_a" class="calendar ir"></button></td>
			   </tr>
			   <tr>
			   		<th>Agreement No.</th>
					<td><input type="text" style="width:100px; ime-mode:disabled; text-align:center;" class="input1" dataformat="engup" maxlength="10" name="agreement_no" maxlength="9"><button type="button" id="ComOpenPopupWithTargetAgree" name="ComOpenPopupWithTargetAgree" class="input_seach_btn"></button></td>
					<th>Reference No.</th>
					<td><input type="text" style="width:100px; text-align:center;;"  class="input2" readonly name="agmt_ref_no"></td>
					<th>Lease Term</th>
					<td><input type="text" style="width:100px; text-align:center;;" class="input2" readonly name="agmt_lstm_cd"></td>
			   </tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
			   <tr>
			   		<th>Lessor</th>
					<td><input type="text" style="width:410px;" class="input2" readonly name="vndr_lgl_eng_nm"></td>
			   </tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="Row_Add" id="Row_Add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="Delete" id="Delete" type="button">Row Delete</button><!--
			--><button class="btn_normal" name="btn_excel" id="btn_excel" type="button">Load Excel</button><!--
			--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>