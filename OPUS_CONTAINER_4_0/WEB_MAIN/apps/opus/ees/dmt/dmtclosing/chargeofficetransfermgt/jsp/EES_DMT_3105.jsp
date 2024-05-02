<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3105.jsp
*@FileTitle  : Office Transfer History - CNTR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3105Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3105Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeOfficeTransferMgt");   

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3105Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- Developer's task	-->
<input type="hidden" name="svr_id" id="svr_id"				value="<%=JSPUtil.getParameter(request, "svr_id", "")%>">
<input type="hidden" name="cntr_no" id="cntr_no"				value="<%=JSPUtil.getParameter(request, "cntr_no", "")%>">
<input type="hidden" name="cntr_cyc_no" id="cntr_cyc_no"			value="<%=JSPUtil.getParameter(request, "cntr_cyc_no", "")%>">
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd"			value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>">
<input type="hidden" name="dmdt_chg_loc_div_cd" id="dmdt_chg_loc_div_cd"	value="<%=JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", "")%>">
<input type="hidden" name="chg_seq" id="chg_seq"				value="<%=JSPUtil.getParameter(request, "chg_seq", "")%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Office Transfer History - CNTR</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
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
			<tbody>
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tr class="h23">
						<th>Current  DEM/DET Office</th>
						<td><input type="text" name="ofc_cd" id="ofc_cd" readonly style="width:60px;" class="input2" value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>"></td>
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
<!-- Developer's task end -->
</form>
