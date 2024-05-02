<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0005.js
*@FileTitle  : Term Change Creation
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
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.termchange.event.EesLse0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0005Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.termchange");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesLse0005Event)request.getAttribute("Event");
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
<input id="eff_dt" name="eff_dt" type="hidden" />
<input id="exp_dt" name="exp_dt" type="hidden" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!--  
	--><button type="button" class="btn_normal" name="btn_Load_Excel" 	id="btn_Load_Excel">Load Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
<h3 class="title_design" style="margin:10px 0 0 0;">Current Status</h3>
	<table>
		<colgroup>
			<col width="140">
			<col width="*">
		</colgroup>
		<tr>			
			<td  id="div_diFlag" name="div_diFlag" style="display:none" ><input type="checkbox" name="di_flag" value="Y" class="trans" id="di_flag" /> DI Flag    </td>
			<td></td>
		</tr>
	</table>	
		<table>
			<colgroup>
				<col width="60">
				<col width="160">
				<col width="80">
				<col width="140">
				<col width="50">
				<col width="140">
				<col width="70">
				<col width="80">
				<col width="40">
				<col width="*">
			</colgroup>
			<tr>
				<th>AGMT No.</th>
				<td><input type="text" name="cur_agmt_cty_cd" caption="AGMT No." style="width:40px;text-align:center;" class="input2" value="HHO" readonly id="cur_agmt_cty_cd" /><input type="text" caption="Current AGMT No." name="cur_agmt_seq" style="width:55px;ime-mode:disabled;text-align:right;" class="input1" value="" maxlength="6" dataformat="num" required="" id="cur_agmt_seq" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
				<th>Contract No.</th>
				<td><input type="text" name="cur_ctrt_no" caption="Contract No." style="width:100px;" class="input2" value="" readonly id="cur_ctrt_no" /></td>
				<th>Ref. No.</th>
				<td><input type="text" name="cur_ref_no" caption="Ref. No." style="width:100px;" class="input2" value="" readonly id="cur_ref_no" /> </td>
				<th>Lease Term</th>
				<td><input type="text" name="cur_lstm_cd" caption="Lease Term" style="width:35px;text-align:center;" class="input2" value="" readonly id="cur_lstm_cd" /> </td>
				<th>Lessor</th>
				<td> <input type="text" name="cur_vndr_seq" caption="Lessor" style="width:50px;text-align:center;" class="input2" value="" readonly id="cur_vndr_seq" /><input type="text" name="cur_vndr_nm" caption="Lessor" style="width:180px;" class="input2" value="" readonly id="cur_vndr_nm" /></td>
			</tr>
		</table>
	</div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="65">
				<col width="*">
			</colgroup>
			<tr>
				<th>CNTR No.</th>
				<td><input type="text" name="cntr_list" style="width:100px;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="cntr_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				
			</tr>
		</table>
	</div>
	<h3 class="title_design" style="margin:10px 0 0 0;">After Status</h3>
	<table class="search" border="0">
		<colgroup>
			<col width="130">
			<col width="*">
		</colgroup>
		</table>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="160">
				<col width="80">
				<col width="140">
				<col width="50">
				<col width="140">
				<col width="70">
				<col width="80">
				<col width="40">
				<col width="*">
			</colgroup>
			<tr>
				<th>AGMT No.</th>
				<td><input type="text" name="aft_agmt_cty_cd" caption="AGMT No." style="width:40px;text-align:center;" class="input2" value="HHO" readonly id="aft_agmt_cty_cd" /><input type="text" caption="After AGMT No." name="aft_agmt_seq" style="width:55px;text-align:right;" class="input1" value="" maxlength="6" dataformat="num" required="" id="aft_agmt_seq" /><button type="button" id="btns_search3" name="btns_search3" class="input_seach_btn"></button></td>
				<th>Contract No.</th>
				<td><input type="text" name="aft_ctrt_no" caption="Contract No." style="width:100px;" class="input2" value="" readonly id="aft_ctrt_no" /></td>
				<th>Ref. No.</th>
				<td><input type="text" name="aft_ref_no" caption="Ref. No." style="width:100px;" class="input2" value="" readonly id="aft_ref_no" /></td>
				<th>Lease Term</th>
				<td><input type="text" name="aft_lstm_cd" caption="Lease Term" style="width:35px;text-align:center;" class="input2" value="" readonly id="aft_lstm_cd" /></td>
				<th>Lessor</th>
				<td> <input type="text" name="aft_vndr_seq" caption="Lessor" style="width:50px;text-align:center;" class="input2" value="" readonly id="aft_vndr_seq" /><input type="text" name="aft_vndr_nm" caption="Lessor" style="width:180px;" class="input2" value="" readonly id="aft_vndr_nm" /> </td>
			</tr>
		</table>
	</div>
	
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70">
				<col width="164">
				<col width="65">
				<col width="*">
			</colgroup>
			<tr>
				<th>Activity Date</th>
				<td><input type="text" name="act_dt" caption="Activity Date" style="width:87px;text-align:center;" class="input1" value="" dataformat="ymd" required="" id="act_dt" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
				<th>Office</th>
				<td><input type="text" name="ofc_cd" caption="Office" style="width:70px;text-align:center;ime-mode:disabled;" class="input1" value="<%= strOfc_cd %>" maxlength="6" dataformat="engup" required="" id="ofc_cd" /><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button></td>
				<th id="div_dcond1" name="div_dcond1" style="display:none">DI Vender</th>
				<td id="div_dcond2" style="display:none"><!--  
				--><input type="text" name="di_vndr_seq" caption="DI Vender" style="width:57px;text-align:center;" class="input1" value="" maxlength="6" dataformat="num" id="di_vndr_seq" /><!--  
				--><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button><!--  
				--><input type="text" name="di_vndr_nm" style="width:240px;" class="input2" value="" readonly="" id="di_vndr_nm" /></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid" id="mainTable" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>