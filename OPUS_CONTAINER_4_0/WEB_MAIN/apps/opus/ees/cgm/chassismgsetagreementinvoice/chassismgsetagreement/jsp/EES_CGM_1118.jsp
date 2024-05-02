<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1118.jsp
*@FileTitle  : Lease Term Change Summary Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1118Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	EesCgm1118Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm1118Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Lease Term Change Summary Inquiry</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" type="button">Down Excel</button><!--
		-->
	</div>
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
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100" />
				<col width="200" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
				<th>Change Office</th>
				<td><input type="text" name="sts_evnt_ofc_cd" dataformat="engup" style="width:150px;ime-mode:disabled" class="input" value="" id="sts_evnt_ofc_cd" /><button type="button" id="btns_office2" name="btns_office2" class="multiple_inq ir"></button></td>
				<th>Change Period</th>
				<td><input type="text" name="sts_evnt_dt_fr" dataformat="ymd" maxlength="10" style="width:75px;text-align:center;ime-mode:disabled" class="input1" value="" id="sts_evnt_dt_fr" />~ <input type="text" name="sts_evnt_dt_to" dataformat="ymd" maxlength="10" style="width:75px;text-align:center;ime-mode:disabled" class="input1" value="" id="sts_evnt_dt_to" /><button type="button" id="btns_sts_evnt_dt" name="btns_sts_evnt_dt" class="calendar ir"></button></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />
				<col width="200" />
				<col width="100" />
				<col width="200" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Lessor</th>
					<td><input type="text" name="vndr_seq" dataformat="eng" style="width:150px;ime-mode:disabled" class="input" value="" id="vndr_seq" /><button type="button" id="btns_vndr2" name="btns_vndr2" class="multiple_inq ir"></button></td>
					<th>Old Term</th>
					<td><script type="text/javascript">ComComboObject('old_agmt_lstm_cd', 1, 193, 0, 0, 0, false);</script><!--input type="text" name="old_agmt_lstm_cd_text" style="width:145" class="input" value=""--></td>
					<th>New Term</th>
					<td><script type="text/javascript">ComComboObject('new_agmt_lstm_cd', 1, 199, 0, 0, 0, false);</script><!--input type="text" name="new_agmt_lstm_cd_text" style="width:145" class="input" value=""--></td>
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
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>