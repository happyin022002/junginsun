<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0046.jsp
*@FileTitle  : BR 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EqavailAbilityFinder.EqavailAbilityFinder");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesCim0046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="loc_cd" value="<%=event.getAvailOptionVO().getLocCd() %>" id="loc_cd" />
<input type="hidden" name="loc_type_code" value="<%=event.getAvailOptionVO().getLocTypeCode() %>" id="loc_type_code" />
<input type="hidden" name="cntr_tpsz_cd" value="<%=event.getAvailOptionVO().getCntrTpszCd() %>" id="cntr_tpsz_cd" />
<input type="hidden" name="fcast_dt" value="<%=event.getAvailOptionVO().getFcastDt() %>" id="fcast_dt" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>BR Information</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Downexcel" name="btn_Downexcel" class="btn_accent">Down Excel</button><!--  
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>