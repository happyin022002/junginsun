<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0445.jsp
*@FileTitle  : Booking Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0445Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesCtm0445Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RestuffingMgtSC.RestuffingContainerRegistration");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0445Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


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
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="yd" value="<%=StringUtil.xssFilter(request.getParameter("yd"))%>" id="yd" />
<input type="hidden" name="reson_cd" id="reson_cd" />
<input type="hidden" name="evnt_dt" id="evnt_dt" />
<input type="hidden" name="unload_flag" value="close" id="unload_flag" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Container Movement History</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_select" id="btn_select">Select</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60">
					<col width="120">
					<col width="30">
					<col width="50">
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Container No.</th>
						<td><input type="text" style="width:90px;" class="input1" name="p_cntrno" maxlength="11" tabindex="1" id="p_cntrno" /><!-- 
						 <input type="text" style="width:18px;" class="input1" name="check_digit" readonly tabindex="2" id="check_digit" />--></td>
						<th>TP/SZ</th>
						<td><input type="text" style="width:30px;" class="input2" name="ctnr_tpsz_cd" readonly id="ctnr_tpsz_cd" /></td>
						<th><button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_etc">Retrieve</button></th>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>