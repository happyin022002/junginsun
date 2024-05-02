<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0908.jsp
*@FileTitle  : Container Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.common.containerselectpopup.event.EsdTrs0908Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	EsdTrs0908Event  event = null;				
	Exception serverException   = null;			
	DBRowSet rowSet	  = null;							  
	String strErrMsg = "";								
	int rowCount	 = 0;								 
	try {
		event = (EsdTrs0908Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String mainSheetArrayNo = request.getParameter("mainSheetArrayNo");
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="mainSheetArrayNo" value="<%=StringUtil.xssFilter(mainSheetArrayNo)%>" id="mainSheetArrayNo" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Container Select</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_apply" 	id="btn_apply">Apply</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	    </div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" id="subTable" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class="opus_design_grid clear" id="subTable2" >
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<div class="opus_design_grid clear" id="subTable3" >
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>