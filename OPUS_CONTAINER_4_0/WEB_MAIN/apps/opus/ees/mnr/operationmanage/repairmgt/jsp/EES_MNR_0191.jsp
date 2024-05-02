<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0191.js
*@FileTitle  : Repair History_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0191Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0191Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String workApp 			= "";
	String eq_no = ((request.getParameter("eq_no")==null )?"":request.getParameter("eq_no"));
	String mnr_wo_tp_cd = ((request.getParameter("mnr_wo_tp_cd")==null )?"":request.getParameter("mnr_wo_tp_cd"));
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		workApp = account.getAccess_system();

		event = (EesMnr0191Event)request.getAttribute("Event");
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
<!--Use a common at MNR  -->
<script type="text/javascript">
	//workApp ALP or SPP
	var workApp = '<%=workApp%>';
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
<input type="hidden" name="mnr_wo_tp_cd" value="<%=mnr_wo_tp_cd%>" id="mnr_wo_tp_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Repair History</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="10" />
			<col width="100" />
			<col width="100" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr class="h23">
				<th>EQ No.</th>
				<td>
				<input style="width:120px;" required type="text" name="eq_no" dataformat="engup" caption="EQ No" class="input1" value="<%=eq_no%>" id="eq_no" />
				</td>
				<th>Input Period</th>
				<td>
				<input type="text" name="fm_mnr_inp_dt" dataformat="ymd" caption="from date" maxlength="10" size="10" cofield="to_mnr_inp_dt" value="" id="fm_mnr_inp_dt" />~ <input type="text" name="to_mnr_inp_dt" dataformat="ymd"    caption="to date"        maxlength="10"  size="10"  cofield="fm_mnr_inp_dt"><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button>
				</td>
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
</div>
<!-- wrap_result(E) -->
</form>