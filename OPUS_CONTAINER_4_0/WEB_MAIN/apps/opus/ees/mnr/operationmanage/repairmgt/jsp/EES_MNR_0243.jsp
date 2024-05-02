<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0243.jsp
*@FileTitle  : EDI & Excel Estimate Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0243Event"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO"%>
<%@ page import="com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0243Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.operationmanage.repairmgt");
	
	//호출 화면 구분 
	String reqUi = ((request.getParameter("req_ui")==null )?"":request.getParameter("req_ui"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_cd = account.getOfc_cd();

		event = (EesMnr0243Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<%@page import="java.util.List"%><html>
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
<input type="hidden" name="req_ui" value="<%=reqUi%>">	  
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>EDI & Excel Estimate Upload</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_loadExcel" id="btn_loadExcel" type="button">Load Excel</button>
		<button class="btn_accent" name="btns_DownFile" id="btns_DownFile" type="button">Down Format</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Confirm</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="50" />
				<col width="100" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tr>
				<th class="sm">EDI Type</th>
				<td class="sm"><input type="radio" name="edi_tp" id="edi_tp" value="E" class="trans" checked disabled="true">Excel&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="edi_tp" id="edi_tp" value="T" class="trans" disabled="true">Text&nbsp;&nbsp;&nbsp;</td>
<!-- 				<th>Vendor</th> -->
<!-- 				<td width=""> -->
<!-- 					<select name="vndr_seq" id="vndr_seq" style="width:62px" class="input2" dataformat="num" disabled="true"> -->
<!-- 						<option value=""></option> -->
<!-- 						<option value="A">A</option> -->
<!-- 						<option value="B">B</option> -->
<!-- 						<option value="C">C</option> -->
<!-- 						<option value="D">D</option> -->
<!--                     </select> -->
<!-- 				</td> -->
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
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
<!-- wrap_result(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>