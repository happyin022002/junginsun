<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0471.jsp
	 *@FileTitle : ESM_BKG-0478
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate :
	 *@LastModifier :
	 *@LastVersion :
	 * 1.0 Creation
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0478Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0478Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String jpSndLogId= "";
	String sndDt= "";
	String logSeq= "";
	String ofcCd= "";
	String blNo= "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		jpSndLogId = JSPUtil.getParameter(request, "jpSndLogId");
		sndDt = JSPUtil.getParameter(request, "sndDt");
		logSeq = JSPUtil.getParameter(request, "logSeq");
		ofcCd = JSPUtil.getParameter(request, "ofcCd");
		blNo = JSPUtil.getParameter(request, "blNo");

		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0478Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}


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
<input type="hidden" name="jp_snd_log_id" value="<%=jpSndLogId%>">
<input type="hidden" name="msg_snd_dt" value="<%=sndDt%>">
<input type="hidden" name="log_seq" value="<%=logSeq%>">
<input type="hidden" name="ofc_cd" value="<%=ofcCd%>">
<input type="hidden" name="bl_no" value="<%=blNo%>">

<div class="layer_popup_contents">
	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Transmit History to SEA-NACCS _ View Send File</span></h2>
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

	<!-- popup_contens_area(S) -->
	<div class="wrap_result">
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<div class="opus_design_grid">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script language="javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	</div>
</div>

</form>
