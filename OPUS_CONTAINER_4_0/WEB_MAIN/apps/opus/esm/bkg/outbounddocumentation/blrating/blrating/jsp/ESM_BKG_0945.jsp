
<%
	/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0945.js
*@FileTitle  : Exchange Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0945Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0945Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0945Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="bkg_no" id="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Exchange Rate</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_close" id="btn_close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

	<!-- opus_design_inquiry(S) -->
<div class="wrap_result">
	<div class="layout_wrap">
		<table>
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr><th style="text-align:left;">Prepaid</th></tr>
			</tbody>
		</table>
		<div class="opus_design_grid" id="p_" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr><th style="text-align:left;">Collect</th></tr>
			</tbody>
		</table>
		<div class="opus_design_grid" id="c_" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr><th style="text-align:left;">Third - Prepaid</th></tr>
			</tbody>
		</table>
		<div class="opus_design_grid" id="tp_" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr><th style="text-align:left;">Third - Collectd</th></tr>
			</tbody>
		</table>
		<div class="opus_design_grid" id="cp_" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	</div>
</div>
	<!-- opus_design_inquiry(E) -->

<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet5');</script></div>
</form>
