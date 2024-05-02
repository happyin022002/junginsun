<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0078.jsp
*@FileTitle  : Offhire Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0078Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0078Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id = "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id = account.getUsr_id();

	   	event = (EsmFms0078Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}

	String fletCtrtNo = StringUtil.xssFilter(request.getParameter("flet_ctrt_no"));
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="flet_ctrt_no" value="<%=fletCtrtNo%>" id="flet_ctrt_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Offhire Selection</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Confirm" 		id="btn1_Confirm">Confirm</button><!--
		--><button type="button" class="btn_normal" name="btn1_Close" 			id="btn1_Close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>