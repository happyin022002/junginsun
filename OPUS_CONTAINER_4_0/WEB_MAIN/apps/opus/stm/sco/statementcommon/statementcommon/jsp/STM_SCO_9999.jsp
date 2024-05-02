<%--
=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SCO_9999.jsp
*@FileTitle  : Closing Accrual Monthly Job Execute
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco9999Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	StmSco9999Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// Errors from server.
	String strErrMsg = "";						// Error message.
	int rowCount	 = 0;						// DB ResultSet list count
 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();

		event = (StmSco9999Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 		 
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Get data from server. ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form" id="form">
<div style="display:none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="job_nm" id="job_nm" />
<input type="hidden" name="accl_ym" id="accl_ym" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">Closing Accrual Monthly Job Execute</button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button>
		<button class="btn_normal" name="btn_all_refresh" id="btn_all_refresh" type="button">All Refresh</button>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />				
				<col width="50" />				
				<col width="50" />				
				<col width="200" />	 			
				<col width="250" />	 			
		   </colgroup> 
		   <tbody>
		         <tr>
		             <th style="text-align:left;">1. TES Accrual Creation </th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>Accrual Month</th> 
		             <td><input name="tes_ym" type="text" style="width:60px;" class="input" value="<%=JSPUtil.getKST("yyyy-MM")%>" dataformat="ym" maxlength="6" id="tes_ym" onChange="javascript:ComCalendar_EndFunction_acclYm('ACCLTES');" /><!-- 
		              --><button type="button" id="btnTesYm" name="btnTesYm" class="calendar ir"></button><button class="btn_normal" name="btn_exeTES" id="btn_exeTES" type="button">Execute</button></td>
		          	 <td><input name="tesStatus" type="text" style="width:150px;vertical-align:middle;text-align:center;background-color:#FFFFFF;border-style:hidden;font-weight:bold" value="_____________" id="tesStatus" /><button class="btn_normal" name="btn_refreshTES" id="btn_refreshTES" type="button">Refresh</button></td>
		          	 <!--<td><button class="btn_normal" name="btn_TesDataDownExcel" id="btn_TesDataDownExcel" type="button">Raw Data Export</button></td>-->
		         </tr>	
		         <tr>
		             <th style="text-align:left;">2. TRS Accrual Creation</th>
		             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		             <th>Accrual Month</th> 
		             <td><input name="trs_ym" type="text" style="width:60px;" class="input" value="<%=JSPUtil.getKST("yyyy-MM")%>" dataformat="ym" maxlength="6" id="trs_ym"  onChange="javascript:ComCalendar_EndFunction_acclYm('ACCLTRS');" /><!-- 
		              --><button type="button" id="btnTrsYm" name="btnTrsYm" class="calendar ir"></button><button class="btn_normal" name="btn_exeTRS" id="btn_exeTRS" type="button">Execute</button></td>
		          	 <td><input name="trsStatus" type="text" style="width:150px;vertical-align:middle;text-align:center;background-color:#FFFFFF;border-style:hidden;font-weight:bold" value="_____________" id="trsStatus" /><button class="btn_normal" name="btn_refreshTRS" id="btn_refreshTRS" type="button">Refresh</button></td>
		          	 <!--<td><button class="btn_normal" name="btn_TrsDataDownExcel" id="btn_TrsDataDownExcel" type="button">Raw Data Export</button></td>-->
		         </tr>	
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_alps.jsp"%>