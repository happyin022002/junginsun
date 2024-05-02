<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0758.jsp
*@FileTitle  : C/A Kind Detail 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.event.EsmBkg0758Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0758Event  event           = null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage

	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.BdrCorrection");
	
	try {	
		event = (EsmBkg0758Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
 
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- Developer Work	-->
<input type="hidden" name="bkg_no" id="bkg_no" value="">
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>C/A Kind Detail</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
</form>
<SCRIPT type="text/javascript">
<!--
      /* 
       * when user insert info, through event info display screen
       */
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo = event.getBkgBlNoVO().getBkgNo();
        %>
            eval("bkg_no").value = "<%=bkgNo%>"; 
        <% } %>
     }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_opus.jsp"%>
