<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0097.jsp
*@FileTitle  : Mis Use In & Out Cancel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.event.EesLse0093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0093Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesLse0093Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_New" id="btn_New" >New</button><!--
		--><button class="btn_normal" type="button" name="btn_cancel" id="btn_cancel" >Cancel</button><!--
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
		<table>
			<colgroup>
				<col width="120" />				
				<col width="323" />				
				<col width="120" />				
				<col width="60" />				
				<col width="80" />
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Request OFC</th>
					<td><input type="text" name="rqst_ofc_cd" id="rqst_ofc_cd" caption="Request OFC" style="width:80px;text-align:center;ime-mode:disabled;" value="" class="input" maxlength="6" dataformat="engup"><!-- 
					 --><button type="button" name="btns_search" id="btns_search"  class="input_seach_btn"></button></td>
					<th class="sm">Approval Case</th>
					<td class="sm"><input type="radio" name="mss_rqst_io_mod_cd" id="mss_rqst_io_mod_cd" value="" class="trans" checked><label>All</label></td>
					<td class="sm"><input type="radio" name="mss_rqst_io_mod_cd" id="mss_rqst_io_mod_cd" value="O" class="trans"><label>MUO</label></td>
					<td class="sm"><input type="radio" name="mss_rqst_io_mod_cd" id="mss_rqst_io_mod_cd" value="I" class="trans"><label>MUI</label></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="120" />				
				<col width="323" />				
				<col width="120" />				
				<col width="60" />				
				<col width="80" />
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Request Duration</th>
					<td><input type="text" name="str_rqst_dt" caption="Request Duration" style="width:80px;text-align:center;" class="input" value="" dataformat="ymd" !cofield="end_rqst_dt"><!-- 
					 -->~ <!-- 
					  --><input type="text" name="end_rqst_dt" caption="Request Duration" style="width:80px;text-align:center;" class="input" value="" dataformat="ymd" !cofield="str_rqst_dt"><!-- 
					   --><button type="button" name="btns_calendar" id="btns_calendar"  class="calendar ir"></button>
					</td>
					<th class="sm">Approval Status</th>
					<td class="sm"><input type="radio" name="mss_usd_apro_flag" value="" class="trans" checked><label>All</label></td>
					<td class="sm"><input type="radio" name="mss_usd_apro_flag" value="R" class="trans"><label>Request</label></td>
					<td class="sm"><input type="radio" name="mss_usd_apro_flag" value="A" class="trans"><label>Inspect</label></td>
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
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_downExcel" id="btn_downExcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</form>