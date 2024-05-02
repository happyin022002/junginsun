<%/*=========================================================
			 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
			 *@FileName : ESM_BKG_1190.jsp
			 *@FileTitle : ESM_BKG_1190
			 *@author     : CLT
			 *@version    : 1.0
			 *@since      : 2014/12/29
			 =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.event.EsmBkg1191Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1191Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String strPgmNo = "";
	String bl_no = JSPUtil.getNull(request.getParameter("bl_no"));
	String io_bnd_cd = JSPUtil.getNull(request.getParameter("io_bnd_cd"));

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1191Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bl_no" value="<%= bl_no%>">
<input type="hidden" name="io_bnd_cd" value="<%=io_bnd_cd %>">

<div class="layer_popup_contents">
	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>View Send File</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
