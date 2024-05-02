<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0236.jsp
*@FileTitle : MNR PFMC by Agreement/Tariff 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0236Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
					   
<% 					
	EesMnr0236Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= ""; 
	String strUsr_nm		= "";   
	String rhqOfcCd         = ""; 
	String currOfcCd       = "";
	String currOfcEngNm     = ""; 
	Logger log = Logger.getLogger("com.clt.apps.reportmanage.performancereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0236Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
			
		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	} 
%>
<script  type="text/javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	var defRhqOfc = "<%=rhqOfcCd.trim()%>"; 
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">   
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="curr_cd" id="curr_cd">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="150">
				<col width="80">
				<col width="50">
				<col width="60">
				<col width="60">
				<col width="65">
				<col width="60">
				<col width="60">								
		  	</colgroup>				
			<tr>
					<th>Tariff Type</th>
					<td><script  type="text/javascript">ComComboObject('cost_grp_cd', 1, 140, 1, 1);</script></td>
					<th>Regional HQ</th>
					<td><script  type="text/javascript">ComComboObject('ar_hd_qtr_ofc_cd', 2, 70, 0, 1);</script></td>
					<th>Office</th>					
					<td><script  type="text/javascript">ComComboObject('rqst_ofc_cd', 2, 70, 0, 1);</script></td>
					<th>S/P Code</th>
					<td colspan="3"><input type="text" name="vndr_seq" id="vndr_seq" style="width:60px;text-align:center" class="input" dataformat="num" maxlength="6"><!-- 
						 --><button type="button" name="provider_popup" id="provider_popup" class="input_seach_btn"></button><!-- 
						 --><input type="text" name="vndr_nm" id="vndr_nm" style="width:160px" class="input2" readonly="readonly">
					</td>
				</tr> 		
				<tr>
					<th>Component</th>
					<td><script  type="text/javascript">ComComboObject('eq_cmpo_cd', 2, 50 , 0, 0);</script></td>
					<th>Repair</th>
					<td><script  type="text/javascript">ComComboObject('eq_rpr_cd', 2, 50 , 0, 0);</script></td>
					<th>Division</th>
					<td><script  type="text/javascript">ComComboObject('trf_div_cd', 2, 70 , 0, 0);</script></td>
					<th>Status</th>
					<td><script  type="text/javascript">ComComboObject('mnr_trf_sts_cd', 2, 100 , 0, 0);</script></td>
					<th>USD Only</th>
					<td><input  name="check_usd_only" id="check_usd_only" type="checkbox" class="trans"></td>					
				</tr> 
				
		</tbody>
	</table>	
</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer">	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button>							
	</div>
	<!-- opus_design_btn(E) -->

	<script type="text/javascript">ComSheetObject('sheet1');</script>	
</div>
</div>
<!-- opus_design_grid(E) -->
</form>