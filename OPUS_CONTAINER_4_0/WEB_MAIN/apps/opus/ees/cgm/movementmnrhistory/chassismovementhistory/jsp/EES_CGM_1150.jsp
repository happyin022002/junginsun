<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1150.jsp
*@FileTitle  : Shipper's Chassis Movement Management
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
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1150Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1150Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String form_day         = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		form_day  = DateTime.getDateString().replace(".","-");


		event = (EesCgm1150Event)request.getAttribute("Event");
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

<!-- form name="form" onkeyup="ComKeyEnter('search');"-->
<form name="form"   >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
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
				<col width="1" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Chss No.</th>
					<td><input type="text" name="p_chss_no" caption="Chss No." style="width:100px;text-align:center;ime-mode:disabled" dataformat="engup" maxlength="10" class="input1" id="p_chss_no" /></td>
					<th>Date</th>
					<td><input type="text" name="p_mvmt_dt" caption="Date" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" class="input" id="p_mvmt_dt" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					<th>LOC</th>
					<td><input type="text" name="p_loc_cd" caption="LOC" style="width:58px;text-align:center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5" id="p_loc_cd" /><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button></td>
					<th>Yard</th>
					<td><input type="text" name="p_yd_cd" caption="Yard" style="width:80px;text-align:center;ime-mode:disabled;" class="input" maxlength="7" dataformat="engup" id="p_yd_cd" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
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
			<button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>