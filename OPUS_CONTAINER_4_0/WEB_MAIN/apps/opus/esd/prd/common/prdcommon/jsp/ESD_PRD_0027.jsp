<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0027.jsp
*@FileTitle : s/p
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.event.EsdPrd0027Event"%>
<%
	EsdPrd0027Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	String sDisplay = "";
	String intgCdId = "";
	String selectVal = "";
	try {
		event = (EsdPrd0027Event)request.getAttribute("Event");
		sDisplay  = JSPUtil.getParameter(request, "display".trim(), "");		
		intgCdId  = JSPUtil.getParameter(request, "intg_cd_id", "");	
		selectVal  = JSPUtil.getParameter(request, "select_val", "");	
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
			ComShowMessage(errMessage);
		}
        loadPage("<%=sDisplay%>");
    }

</script>
<form name="form">
<input	type="hidden" name="f_cmd">
<input	type="hidden" name="intg_cd_id" id="intg_cd_id" value="<%= intgCdId %>" />
<input	type="hidden" name="select_val" id="select_val" value="<%= selectVal %>" />
<div class="layer_popup_title">
	<!-- popup_title_area(S) -->
		<div class="page_title_area clear">
			<h2 class="page_title"><span></span></h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_ok" 			id="btn_ok">OK</button><!-- 
				--><button type="button" class="btn_normal" name="btn_close"   	id="btn_close">Close</button>
			</div>
		</div>
	<!-- popup_title_area(E) -->
</div>
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_result">		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script>ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
