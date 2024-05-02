<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0038.jsp
*@FileTitle  : Revenue VVD Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0038Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0038Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBasicRegister");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0038Event)request.getAttribute("Event");
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

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_savetofile" id="btn_savetofile" type="button">Down&nbsp;Excel</button><!--
	--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table class="mar_btm_4">
			<colgroup>
				<col width="90px" />				
				<col width="150px" />
				<col width="90px" />				
				<col width="100px" />
				<col width="*" />
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Revenue Month</th>
					<td><input type="text" name="rev_yrmon_from" style="width:60px;;text-align:center;ime-mode:disabled;" class="input1" maxlength="6" dataformat="ym" required caption="Period(From)" id="rev_yrmon_from" /><button type="button" id="btn_period_from" name="btn_period_from" class="calendar ir"></button>~ <!--
					--><input type="text" name="rev_yrmon_to" style="width:60px;;text-align:center;ime-mode:disabled;" class="input1" maxlength="6" dataformat="ym" required caption="Period(To)" id="rev_yrmon_to" /><button type="button" id="btn_period_to" name="btn_period_to" class="calendar ir"></button></td>
		   			<th>Service Lane</th>
					<td><input type="text" name="slan_cd" maxlength="3" style="width:60px;;text-align:center;ime-mode:disabled;" dataformat="engup" class="input" value="" id="slan_cd" /><!--
					--><button type="button" id="btn_lanepop" name="btn_lanepop" class="input_seach_btn"></button></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>