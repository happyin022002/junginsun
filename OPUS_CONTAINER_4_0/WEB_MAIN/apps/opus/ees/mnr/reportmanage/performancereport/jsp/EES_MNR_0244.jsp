<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0244.jsp
*@FileTitle : Disposal Performance by RCC
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0244Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0244Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.reportmanage.performancereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0244Event)request.getAttribute("Event");
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
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Developer's task	-->
<input type="hidden" name="p_disp_rsn_cd" id="p_disp_rsn_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100"/>
				<col width="220"/>
				<col width="50"/>
				<col width="100"/>
				<col width="70"/>
				<col width="150"/>
				<col width="80"/>
				<col width="*"/>			
	  		</colgroup>				
			<tr>
					<th>Sold Period</th>
					<td><input type="text" name="p_str_evnt_dt" id="p_str_evnt_dt" caption="Start Duration" style="width:80px;text-align:center;ime-mode:disabled;" class="input1" value="" dataformat="ymd" !cofield="p_end_evnt_dt">~ <input type="text" name="p_end_evnt_dt" id="p_end_evnt_dt" caption="End Duration" style="width:80px;text-align:center;ime-mode:disabled;" class="input1" value="" dataformat="ymd" !cofield="p_str_evnt_dt"><button type="button" class="calendar ir"  name="btns_calendar" id="btns_calendar"></button></td>
					<th>EQ Type</th>
					<td><select name="p_eq_knd_cd" id="p_eq_knd_cd" caption="EQ Type" style="width:90px;" class="input1"><option value="U" selected>Container</option><option value="Z">Chassis</option><option value="G">M.G.Set</option></select></td>
					<th style="text-align:left;padding-left: 10px;">Location By</td>
					<td><select name="p_loc_tp" id="p_loc_tp" style="width:65px;" dataformat="engup"><option value="" selected>ALL</option><option value="RCC">RCC</option><option value="LCC">LCC</option><option value="SCC">SCC</option></select><input type="text" name="p_loc_cd" id="p_loc_cd" caption="Location" style="width:70px;ime-mode:disabled;" value="" class="input2"  dataformat="engup" maxlength="5" readonly fullfill><button type="button" name="btns_search" id="btns_search" class="input_seach_btn"></button></td>
					<td></td>
					<td><input type="checkbox" name="p_chk_expand" id="p_chk_expand" class="trans">  <strong>All Expanded</strong></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>
					<col width="216"/>
					<col width="50"/>				
					<col width="*"/>				
			  	</colgroup>			
				<tr>
					<th>Disposal Kind</th>
					<td><script  type="text/javascript">ComComboObject('combo1', 1, 201, 1, 0);</script></td>
					<th>Buyer By</th>
					<td><input type="text" name="p_cust_cd" id="p_cust_cd" caption="Buyer" style="width:65px;text-align:center" class="input" dataformat="engup" maxlength="8"><button type="button" name="btns_search2" id="btns_search2" class="input_seach_btn"></button><input type="text" name="p_vndr_nm" id="p_vndr_nm" style="width:247px" class="input2" readOnly></td>
				</tr>
		</table>	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">	
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>				
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>	
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
