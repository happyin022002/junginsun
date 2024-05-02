<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0026.jsp
*@FileTitle  : Immediate Exit Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.event.EesLse0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0025Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strPgm_no		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strPgm_no = (String)request.getAttribute("UI_NUMBER");

		event = (EesLse0025Event)request.getAttribute("Event");
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
<input type="hidden" name="pgm_no" value="<%= strPgm_no %>" id="pgm_no" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="150">
				<col width="105">
				<col width="160">
				<col width="90">
				<col width="180">
				<col width="111">
				<col width="*">
			</colgroup>
			<tr>
				<th>AGMT No.</th>
				<td><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:60px;text-align:center;" class="input2" value="HHO" readonly id="agmt_cty_cd" /><input type="text" caption="AGMT No." name="agmt_seq" style="width:60px;text-align:right;" class="input1" value="" maxlength="6" dataformat="num" id="agmt_seq" /><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button></td>
				<th>Contract No.</th>
				<td><input type="text" name="ctrt_no" style="width:130px;" class="input2" readonly id="ctrt_no" /></td>
				<th>Ref. No.</th>
				<td><input type="text" name="ref_no" style="width:181px;" class="input2" readonly id="ref_no" /></td>
				<th>Lease Term</th>
				<td><input type="text" name="lstm_cd" style="width:50px;" class="input2" readonly id="lstm_cd" /></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80">
				<col width="400">
				<col width="113">
				<col width="170">
				<col width="111">
				<col width="*">
			</colgroup>
			<tr>
				<th>Lessor</th>
				<td><input type="text" name="vndr_seq" style="width:60px;" class="input2" readonly id="vndr_seq" /><input type="text" name="vndr_nm" style="width:331px;" class="input2" readonly id="vndr_nm" /> </td>
				<th>Effective Date</th>
				<td><input type="text" name="eff_dt" style="width:80px;text-align:center;" class="input2" readonly id="eff_dt" /> ~ <input type="text" name="exp_dt" style="width:80px;text-align:center;" class="input2" readonly id="exp_dt" /> </td>
				<th>Free Day</th>
				<td><input type="text" name="free_dys" style="width:50px;text-align:right" class="input2" readonly id="free_dys" /> </td>
			</tr>
		</table>
		<table >
			<colgroup>
				<col width="80">
				<col width="116">
				<col width="120">
				<col width="50">
				<col width="85">
				<col width="113">
				<col width="*">
			</colgroup>
			<tr>
				<th>AGMT Office</th>
				<td><input type="text" name="ofc_cd" style="width:60px;" class="input2" readonly id="ofc_cd" /> </td>
				<th>LOC</th>
				<td><select name="loc_tp" style="margin-right:1px"><!--  
				--><option value="">ALL</option><!--  
				--><option value="1">RCC</option><!--  
				--><option value="2">LCC</option><!--  
				--><option value="4">SCC</option><!--  
				--><option value="5">Yard</option></select></td>
				<td><input type="text" name="loc_cd" style="width:70px;text-align:center;" class="input2" value="" maxlength="7" dataformat="engup" readonly id="loc_cd" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
				<th><input type="checkbox" name="chk_cntr" value="Y" class="trans" id="chk_cntr" /> CNTR No.</th>
				<td><input type="text" name="cntr_no" style="width:181px;" class="input2" value="" dataformat="engup" otherchar="," readonly id="cntr_no" />&nbsp;<img src="img/btns_multisearch.gif" name="cntr_no_multi" id="cntr_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="sheetTable">
		<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_normal" name="btn_downExcel" 	id="btn_downExcel">Down Excel</button></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="div_sheet2" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>