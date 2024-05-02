<%@page import="com.clt.framework.component.util.StringUtil"%>
<%
	/*=========================================================
	 *Copyright(c) 2015 CyberLogitec. All Rights Reserved.
	 *@FileName   : ESD_TRS_0973.jsp
	 *@FileTitle  : JOEDI History 
	 *@author     : CLT
	 *@version    : 1.0
	 *@since      :
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.vendorcm.event.EsdTrs0973Event"%>
<%
	EsdTrs0973Event  event = null;
	Exception serverException   = null;	
	String strErrMsg = "";	
	SignOnUserAccount account= null;
	String so_no = "";
	try {
	   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   event = (EsdTrs0973Event)request.getAttribute("Event");
	   serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	   so_no = StringUtil.xssFilter(request.getParameter("so_no"));
	   if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	   } 
	 } catch(Exception e) {
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
<input type="text" name="so_no" value="<%= so_no %>" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title">
			<span>WO EDI HISTORY</span>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_close" name="btn_close" class="btn_accent">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>