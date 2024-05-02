<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3106.jsp
*@FileTitle  : Manual Batch by POD ETA
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3106Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3106Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3106Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var CURR_DATE = '<%=DateTime.getDateString().replace(".","")%>';
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="call_flag" id="call_flag"			value="<%=JSPUtil.getParameter(request, "call_flag", "")%>">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="backendjob_id" id="backendjob_id" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Manual Batch by POD ETA</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_GetVDMVMT" 	id="btn_GetVDMVMT">Get VD MVMT</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
		</div>
		<!-- opus_design_btn(E) -->
	</div>
<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents" style="overflow:hidden!important">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr>
						<th width="80">Tariff Type</th>
						<td width="40"><input type="text" style="width:40px;" class="input2" value="DMIF"></td>
						<th width="80">From Date</th>
						<td><input type="text" style="width:80px;" class="input1" name="upd_fm_dt" dataformat="ymd" id="upd_fm_dt" /><!-- 
						 --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Update" id="btn_Update">Update</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" style="display:none">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>