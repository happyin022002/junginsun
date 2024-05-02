<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0077.jsp 
*@FileTitle  : Selection USIOR COLUMN
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%-- <%@ page import="com.clt.apps.opus.esd.sce.exceptionmanage.exceptionsearch.event.EsdSce0011Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>
<%
String strErrMsg = "";
%>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="report_list" id="report_list" />
<input type="hidden" name="save_list" id="save_list" />
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Customized Report Form</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->	
</form>