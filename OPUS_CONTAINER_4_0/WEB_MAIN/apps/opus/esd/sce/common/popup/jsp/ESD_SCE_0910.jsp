<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0910.jsp
*@FileTitle  : CY & Door S/O Creation Matchmaking Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error On Server Side
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.common.popup");
	String selfccd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		selfccd = StringUtil.xssFilter(request.getParameter("sel_ofc_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("sel_ofc_cd"));
		
		event = (CommonPopUpManageEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// The data obtained from the server side on load.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
	function OnSubmit(){
		return false;
	}
</script>
<form method="post" name="form" onSubmit="OnSubmit()">
<input	type="hidden" name="f_cmd" id="f_cmd"/>
<input type="hidden" name="iPage" id="iPage"/>
<input type="hidden" name="sel_ofc_cd" id="sel_ofc_cd" value="<%=selfccd%>"/>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span class="title">Office Select</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_apply" id="btn_apply" type="button">Apply</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
