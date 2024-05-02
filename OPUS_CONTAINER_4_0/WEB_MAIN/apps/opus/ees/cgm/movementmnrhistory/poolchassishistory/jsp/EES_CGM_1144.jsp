<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1144.jsp
*@FileTitle  : Pool Chassis M&R Performance
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
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1144Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	EesCgm1144Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.PoolChassisHistory");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1144Event)request.getAttribute("Event");
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
<title>Pool Chassis M&R Performance</title>


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

<body  onLoad="setupPage();" onkeyup="ComKeyEnter('search');">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
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
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
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
		<table class="wFit">
			<colgroup>
				<col width="50" />
				<col width="510" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Pool</th>
					<td><script type="text/javascript">ComComboObject('chss_pool_cd', 1, 150, 0, 1, 0);</script><input type="text" style="width:366px;" class="input2" name="chss_pool_nm" readonly="readonly" id="chss_pool_nm" /></td>
					<th>MGMT</th>
					<td><input type="text" style="width:60%" class="input2" name="pool_mgmt_co_nm" readonly="readonly" id="pool_mgmt_co_nm" /></td>					
				</tr>
			</tbody>
		</table>		
		<table class="wFit">
			<colgroup>
				<col width="50" />
				<col width="160" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Sort by</th>
 					<td><select style="width:150;" class="input1" onchange="sort_OnChange()" name="sort"><option value="0"selected>Invoice Month</option><option value="1" >Repair Request Date</option></select></td>
				    <th>Period</th>
				    <td><input type="text" style="width:90;text-align:center;ime-mode:disabled" dataformat="ym" name='mvmt_dt_fr' id='mvmt_dt_fr' class="input1" value="" maxlength='7'><button type="button" id="btns_Calendar1" name="btns_Calendar1" class="calendar ir"></button>~ <input type="text" style="width:90px;text-align:center;ime-mode:disabled" dataformat="ym" name="mvmt_dt_to" class="input1" value="" maxlength="7" id="mvmt_dt_to" /><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button></td>
				</tr>
			</tbody>
		</table>
		


	<div class="line_bluedot"></div>
	<!-- opus_design_data (S) -->
		<table class="grid2 wFit"> 
			<tr>
				<th></th>
				<th>Cases/Units	</th>
				<th>Labor Total</th>
				<th>Material Total</th>
				<th>Tax Total</th>
				<th>Total Amount</th>
				<th>Unit Cost</th>
			</tr>
			<tr>
				<th>Chassis Repair Cases</th>
				<td><input type="text" name="chss_cnt" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" dataformat="num" id="chss_cnt" /></td>
				<td><input type="text" name="chss_lbr" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" dataformat="num" id="chss_lbr" /></td>
				<td><input type="text" name="chss_mtrl" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" dataformat="num" id="chss_mtrl" /></td>
				<td><input type="text" name="chss_amt" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" dataformat="num" id="chss_amt" /></td>
				<td><input type="text" name="chss_ttl" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" dataformat="num" id="chss_ttl" /></td>
				<td><input type="text" name="chss_cost" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" dataformat="num" id="chss_cost" /></td>
			</tr>
			<tr>
				<th>Repaired Chassis Units</th>
				<td><input type="text" name="un_chss_cnt" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" id="un_chss_cnt" /></td>
				<td><input type="text" name="un_chss_lbr" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" id="un_chss_lbr" /></td>
				<td><input type="text" name="un_chss_mtrl" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" id="un_chss_mtrl" /></td>
				<td><input type="text" name="un_chss_amt" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" id="un_chss_amt" /></td>
				<td><input type="text" name="un_chss_ttl" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" id="un_chss_ttl" /></td>
				<td><input type="text" name="un_chss_cost" style="width:100%;text-align:right" class="input2" value="" readonly="readonly" id="un_chss_cost" /></td>
			</tr>
		</table>
	
	<!-- opus_design_data (E) -->
</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>