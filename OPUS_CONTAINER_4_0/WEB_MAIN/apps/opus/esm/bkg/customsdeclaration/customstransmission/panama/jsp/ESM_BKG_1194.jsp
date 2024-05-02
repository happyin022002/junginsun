<%/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ESM_BKG_1194.jsp
 *@FileTitle : ESM_BKG_1194
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.event.EsmBkg1194Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1194Event event = null; //PDTO(Data Transfer Object including Parameters)
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
	String rcv_log_seq = JSPUtil.getNull(request.getParameter("rcv_log_seq"));
	String vst_no = JSPUtil.getNull(request.getParameter("vst_no"));
	String vvd_cd = JSPUtil.getNull(request.getParameter("vvd_cd"));
	String type   = JSPUtil.getNull(request.getParameter("type"));

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1194Event) request.getAttribute("Event");
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
<input type="hidden" name="vst_no" value="<%= vst_no%>">
<input type="hidden" name="rcv_log_seq" value="<%=rcv_log_seq %>">
<input type="hidden" name="vvd_cd" value="<%= vvd_cd %>">
<input type="hidden" name="type" value="<%= type %>">

<div class="layer_popup_contents">
	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>View Message</span></h2>
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
<%--
<textarea rows="2" name="rcv_msg" id="rcv_msg" maxlength="500" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden;resize:none;"  class="textarea_img2" wrap="physical"></textarea>
<button type="button" class="btn_accent" name="btn_rcv" id="btn_rcv">RCV TEST</button>
--%>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
