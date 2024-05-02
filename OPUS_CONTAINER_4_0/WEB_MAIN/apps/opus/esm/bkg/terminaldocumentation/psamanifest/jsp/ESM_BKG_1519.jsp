<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1519.jsp
*@FileTitle  : PSA Inbound Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/01
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg1519Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1519Event event = null;
	Exception serverException = null;    //error from server
	String strErrMsg = "";               //Error message
	int rowCount = 0;                    //DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) strErrMsg = new ErrorHandler(serverException).loadPopupMessage();

	} catch(Exception e) {
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

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button><!--
		--><button class="btn_normal" type="button" name="btn_transmit" id="btn_transmit">Transmit</button>
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
	<div class="opus_design_inquiry">
		<table id="mainTable">
			<colgroup>
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th style="text-align:left">Please specify the SVVD to trigger data extraction for the Port of Singapore Authority (PSA).</th>
				</tr>
			</tbody>
		</table>

		<table class="line_bluedot"><tr><td></td></tr></table>

		<table style="width:600px;">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>VVD</th>
					<td><input type="text" class="input1" style="width:120px; ime-mode:disabled;" name="vvd" id="vvd" maxlength="9" required caption="VVD" fullfill dataformat="engup"></td>
					<th>PSA VSL Name/Voyage</th>
					<td><input type="text" style="width:100px; text-align:center" name="vsl_nm" id="vsl_nm" class="input2" readonly /><!--
						--><input type="text" style="width:50px; text-align:center;" name="vsl_voyage" id="vsl_voyage" class="input2" readonly /></td>
				</tr>
			</tbody>
		</table>

	</div>
</div>


<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
