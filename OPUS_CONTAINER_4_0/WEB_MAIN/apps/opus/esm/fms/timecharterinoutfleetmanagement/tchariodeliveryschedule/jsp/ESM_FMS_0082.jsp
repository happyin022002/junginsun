<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0082.jsp
*@FileTitle  : Ship Yard Select – Pop up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0082Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0082Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
//	int rowCount	 = 0;						//Number of DB ResultSet List

//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutFleetManagement.TCharIODeliverySchedule");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0082Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<!-- page_title_area(S) -->
 <div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Ship Yard Select</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn1_Confirm" 	id="btn1_Confirm">Confirm</button><!--  
			--><button type="button" class="btn_normal" name="btn1_Close"  		id="btn1_Close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>	
</div>
</form>
