<%@page import="java.net.URLDecoder"%>
<%@page import="weblogic.wsee.wsdl.http.UrlEncoded"%>
<%
	/*=========================================================
	 *Copyright(c) 2015 CyberLogitec. All Rights Reserved.
	 *@FileName   : ESD_TRS_0983.jsp
	 *@FileTitle  : Transport Status Update History
	 *@author     : CLT
	 *@version    : 1.0
	 *@since      :
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event.EsdTrs0983Event"%>
<%
	String strErrMsg = "";
	try {
		EsdTrs0983Event event = (EsdTrs0983Event) request.getAttribute("Event");
		Exception serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd" id="f_cmd" /> 
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title">
				<span>Transport Status Update History</span>
			</h2>
			<div class="opus_design_btn">
				<button type="button" id="btn_close" name="btn_close" class="btn_accent">Close</button>
			</div>
		</div>
	</div>
	<div class="layer_popup_contents">
		<div class="wrap_result">
			<div class="opus_design_grid">
				<script type="text/javascript">
					ComSheetObject('sheet1');
				</script>
			</div>
		</div>
	</div>
</form>