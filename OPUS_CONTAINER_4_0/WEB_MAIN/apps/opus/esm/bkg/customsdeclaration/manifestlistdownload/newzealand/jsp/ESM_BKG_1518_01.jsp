<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1518_01.jsp
*@FileTitle  : Transmit Result Error Report
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.event.EsmBkg1518Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1518Event event = null;        // PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1518Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage() {
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
<input type="hidden" name="vvd" id="vvd" value='<%=JSPUtil.getParameter(request, "vvd")%>'>
<input type="hidden" name="bl_no" id="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'>
<input type="hidden" name="cntr_no" id="cntr_no" value='<%=JSPUtil.getParameter(request, "cntr_no")%>'>
<input type="hidden" name="vvd_pod_cd" id="vvd_pod_cd" value='<%=JSPUtil.getParameter(request, "vvd_pod_cd")%>'>

	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Transmit Result Error Report</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" type="button" name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn (E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<div class="layer_popup_contents" style="overflow:hidden;">
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
	</div>

</form>