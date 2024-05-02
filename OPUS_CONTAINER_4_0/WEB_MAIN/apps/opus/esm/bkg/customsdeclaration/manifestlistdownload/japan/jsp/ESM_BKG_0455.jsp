<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0455.jsp
*@FileTitle  : SEA-NACCS_B/L Correction_Container Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/30
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0455Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0455Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	//int rowCount = 0; //count of DB resultSET list

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no= "";
	String gubun= "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		bl_no= JSPUtil.getParameter(request, "bl_no");
		gubun= JSPUtil.getParameter(request, "gubun");

		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0455Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// get data from server when load page ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bl_number" value="<%=bl_no%>">
<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title(S) -->
		<div class="page_title_area clear">
			<h2 class="page_title"><span>SEA-NACCS_B/L Correction_Container Info</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
				--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->

			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
		</div>
	</div>
	<!-- page_title_area(E) -->

	<div class="wrap_result">
		<div class="wrap_result" id="mainTable">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject("sheet1");</script>
			</div>
			<!-- opus_design_grid(S) -->
		</div>
	</div>
</div>
</form>