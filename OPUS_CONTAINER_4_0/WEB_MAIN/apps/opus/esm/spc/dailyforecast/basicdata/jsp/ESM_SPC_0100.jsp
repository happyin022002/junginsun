<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0100.jsp
*@FileTitle  : Lane-Office-POL
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11 
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.dailyforecast.basicdata.event.EsmSpc0100Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0100Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DailyForecast.BasicData");
	String ofc_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0100Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		ofc_cd = event.getSignOnUserAccount().getOfc_cd();

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
</head>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_rowadd" id="btn_rowadd" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
		 <tbody>
			<colgroup>
				<col width="80">				
				<col width="130">				
				<col width="100">				
				<col width="70">				
				<col width="80">				
				<col width="70">				
				<col width="80">				
				<col width="70">	
				<col width="100">				
				<col width="*">				
		   	</colgroup>
			<tr>
			    <th>Week</th>
				<td>
					<select class="input1" name="year" id="year" style="width:70px;"></select><!-- 
					 --><select class="input1" name="week" id="week" style="width:50px;"></select>
				</td>
				<th>RHQ</th>
				<td>
					<script type="text/javascript">ComComboObject("rhq", 2, 80, 0, 1);</script>
				</td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:85px;ime-mode:disabled;" dataformat="engup" name="vvd" value="" maxlength="9" onkeypress="eventKeyChangeChar(UPPER_CASE);" id="vvd" /> </td>
			</tr>
			<tr>
				<th>Rep. Trade</th>
				<td>
					<script type="text/javascript">ComComboObject("trade", 2, 124, 0, 1);</script>
				</td>
				<th>Rep. SubTrade</th>
				<td>
					<script type="text/javascript">ComComboObject("subtrade", 3, 80, 0, 0, 1);</script>
				</td>
				<th>Lane</th>
				<td>
					<script type="text/javascript">ComComboObject("lane", 4, 85, 0, 0, 2);</script>
				</td>
				<th>Bound</th>
				<td>
					<select name="bound" id="bound" style="width:50px;"></select>
				</td>
				<th>OCN/IPC/TS</th>
				<td>
					<select name="ocnipc" id="ocnipc" style="width:75px;"></select>
				</td>
			</tr>
		</table>
	</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_tab sm"  id="tabObj">
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:inline">
    	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
    </div>
	<div class="opus_design_grid"  id="tabLayer" style="display:none">
    	<script type="text/javascript">ComSheetObject('t2sheet2');</script>
    </div>
</div>
</form>