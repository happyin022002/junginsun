<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0641.js
*@FileTitle  : Container Discharging Status Check
*@author     : CLT
*@version    : 
*@since      : 04/29/2014
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0641Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0641Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String toDate = "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		Date to = new Date();
		toDate = DateTime.getDateString();
		toDate = toDate.replace(".","-");
		
		event = (EsmBkg0641Event)request.getAttribute("Event");
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
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_downExcel" id="btn_downExcel" type="button">Down Excel</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60" />				
				<col width="200" />				
				<col width="100" />				
				<col width="200" />				
				<col width="60" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="60" />
				<col width="*" />				
		   	</colgroup> 
			<tbody>				
				<tr>
					<th>EDI Rcv. Date</th>
					<td><!--
					--><input type="text" style="width: 75px;" class="input1" name="in_edi_rpt_msg_rcv_dt_start" maxlength="10" dataformat="ymd" value="" id="in_edi_rpt_msg_rcv_dt_start" /><!--
					--><input type="text" style="width: 75px;" class="input1" maxlength="10" dataformat="ymd" name="in_edi_rpt_msg_rcv_dt_end" value="" id="in_edi_rpt_msg_rcv_dt_end" /><!--
					--><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button><!--
					--></td>
					<th>Discharging Date</th>
					<td><!--
					--><input type="text" style="width: 75px;" class="input" name="in_cntr_ldis_dt_start" maxlength="10" dataformat="ymd" value="" id="in_cntr_ldis_dt_start" /><!--
					-->~&nbsp;<input type="text" style="width: 75px;" class="input" maxlength="10" dataformat="ymd" name="in_cntr_ldis_dt_end" value="" id="in_cntr_ldis_dt_end" /><!--
					--><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
					</td>
					<th>Yard</th>
					<td><!--
					--><input type="text" style="width: 80px;" class="input" name="in_event_yd_cd" value="" maxlength="9" dataformat="engup" id="in_event_yd_cd" /><!--
					--></td>
					<th title="Port of Loading">POL</th>
					<td><!--
					--><input type="text" style="width: 60px;" class="input" name="in_pol_cd" value="" maxlength="5" dataformat="engup" id="in_pol_cd" /><!--
					--></td>
					<th title="Port of Discharging">POD</th>
					<td><!--
					--><input type="text" style="width: 60px;" class="input" name="in_pod_cd" value="" maxlength="5" dataformat="engup" id="in_pod_cd" /><!--
					--></td>
				</tr>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><!--
					--><input type="text" style="width: 100px;" class="input" name="in_tml_vvd_id" maxlength="9" dataformat="engup" value="" id="in_tml_vvd_id" />
					</td>
					<th>Call Sign</th>
					<td><!--
					--><input type="text" style="width: 60px;" class="input" name="in_call_sgn_no" maxlength="5" dataformat="engup" value="" id="in_call_sgn_no" /><!--
					--></td>
					<th>VSL Name</th>
					<td><input type="text" style="width: 140px;" class="input" name="in_vsl_nm" value="" dataformat="engupetc" id="in_vsl_nm" /></td>
					<th>Container No.</th>
					<td><input type="text" style="width: 100px;" class="input" name="in_cntr_no" maxlength="11" dataformat="engup" value="" id="in_cntr_no" /></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>