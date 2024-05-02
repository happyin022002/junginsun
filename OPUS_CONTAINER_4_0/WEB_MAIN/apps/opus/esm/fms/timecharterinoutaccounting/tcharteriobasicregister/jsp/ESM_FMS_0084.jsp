<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0084.jsp
*@FileTitle  : E-mail List Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0084Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0084Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBasicRegister");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0084Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>E-mail List Select</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Confirm" 		id="btn_Confirm">Confirm</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->	
		
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>