<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1112.jsp
*@FileTitle  : Eur24 Hour : View MSG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1112Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1112Event  event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	// error from server
	String strErrMsg = "";				// error message
	int rowCount	 = 0;				// count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmBkg1112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
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

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvd" value='<%= StringUtil.xssFilter(request.getParameter("vvd"))%>'>
<input type="hidden" name="bl_no" value='<%= StringUtil.xssFilter(request.getParameter("bl_no"))%>'>
<input type="hidden" name="cstms_port_cd" value='<%= StringUtil.xssFilter(request.getParameter("cstms_port_cd"))%>'>
<input type="hidden" name="edi_rcv_dt" value='<%= StringUtil.xssFilter(request.getParameter("edi_rcv_dt"))%>'>
<input type="hidden" name="edi_rcv_seq" value='<%= StringUtil.xssFilter(request.getParameter("edi_rcv_seq"))%>'>
<input type="hidden" name="cnt_cd" value='<%= StringUtil.xssFilter(request.getParameter("cnt_cd"))%>'>

	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Eur24 Hour : View MSG</span></h2>
			<!-- page_title(E) -->
				
			 <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->				
		       	<button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>
		    </div>
		    <!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->
	
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		    <script type="text/javascript">ComSheetObject('sheet1');</script>	
		</div>
		<!-- opus_design_grid(E) -->	
	</div>
</div>

</form>
