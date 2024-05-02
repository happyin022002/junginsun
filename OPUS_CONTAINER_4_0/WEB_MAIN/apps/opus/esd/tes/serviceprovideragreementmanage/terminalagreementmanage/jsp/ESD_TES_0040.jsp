<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0040.jsp
*@FileTitle : TerminalAgreement - Detail(Terminal Rate)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0040Event"%>
<%
	EsdTes0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count
	String cre_ofc_cd 	= "";
	String agmt_no 		= "";
	String agmt_ver_no 	= "";
	agmt_no 	= JSPUtil.getNull(request.getParameter("agmt_no"));
	agmt_ver_no = JSPUtil.getNull(request.getParameter("agmt_ver_no"));
	try {
	    SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    cre_ofc_cd 		= account.getOfc_cd();
		event = (EsdTes0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

<%= JSPUtil.getIBCodeCombo("thc_tp_cd", "01", "CD00161", 2, "1::")%>
	var agmt_no = '<%=JSPUtil.getNull(agmt_no)%>';
	var agmt_ver_no = '<%=JSPUtil.getNull(agmt_ver_no)%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<SCRIPT LANGUAGE="javascript" FOR="document" EVENT="onkeydown">

</SCRIPT>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="yd_nm">
<!-- Add ofc_cd permission -->
<input type="hidden" name="no_ofc_cd" value="">
<input type="hidden" name="act_tp" value="AGMT">
<input type="hidden" name="no_yd_cd" value="">
<input type="hidden" name="auth_ofc_cd" value="">
<input type="hidden" name="cre_ofc_cd" value="<%=cre_ofc_cd %>">

<!-- interface values.. Deleted after the completion of the test :: lgs_cost_cd-->
<input type="hidden" name="lgs_cost_cd" value="TMNDTS">
<input type="hidden" name="pop_cost_cd">
<input type="hidden" name="pop_sheetObj">
<input type="hidden" name="pop_row">
<input type="hidden" name="pop_agmt_rmk">
<input type="hidden" name="pop_mode">

<!-- 제목 -->
<div class="page_title_area clear">
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal"name="btn_new" id="btn_new">New</button><!--  
	    --><button type="button" class="btn_normal" name="btng_adjustmentscreen" id="btng_adjustmentscreen">Adjustment Screen</button><!--  
	    --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--  
	    --><button type="button" class="btn_normal" name="btng_print" id="btng_print" style="display:none;">Print</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search_tab">
<!-- 검색영역 -->
<div class="opus_design_inquiry">		
	<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     <table class="search" width="100%">
       	<tr><td>
			<!-- : ( Week ) (S) -->
			<table class=" wFit">
				<tr class="h23">
					<th width="138px"><!-- img class="nostar" -->Agreement No.</th>
					<td width="150px">&nbsp;
					<input class="input1" type="text" style="width:100px" value="" name="tml_agmt_ofc_cty_cd" maxlength=8 dataformat="engup"></td>
					<th width="140px"><!-- img class="nostar" -->Agreement Version</th>
					<td width="*">
					<input class="input1" type="text" style="width:78px" value="" name="tml_agmt_ver_no" maxlength=5 onKeyUp ='isAlpha(this);isNumPod(this);addPeriod(this);' onKeyDown='isNumPod(this);' >
					</td>
				</tr>
			</table>
			<!-- : ( Week ) (E) -->
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options : ) (E) -->
	<div class="line_bluedot"></div>
	<!-- TABLE '#D' : ( Search Options : Related COP Information  ) (S) -->
	<table>
        <tr><td>
	     <table class="wFit grid2" >
	     	<tr>
	     		<th colspan="2" style="font-weight: bold;">Yard Code</th>
	     		<td ><input name="yd_cd" value="" type="text" class="input2" style="width:75px" readonly></td>
	     		<th style="font-weight: bold;">Contract Office</th>
				<td><input name="ctrt_ofc_cd" type="text" class="input2" style="width:80px" readonly></td>
	     		<th style="font-weight: bold;">S/P Code</th>
	     		<td><input name="vndr_seq" type="text" class="input2" style="width:80px" readonly></td>
				<th style="font-weight: bold;">S/P Name(Abbr.)</th>
	     		<td><input name="vndr_abbr_nm" type="text" class="input2" style="width:70px" readonly></td>
	     	</tr>
			<tr>
	     		<th class="tr2_head align_center" rowspan="2" style="font-weight: bold;">Effective<br>Date</th>
				<th class="tr2_head align_center" style="font-weight: bold;">From</th>
	     		<td><input name="eff_fm_dt" type="text" class="input2" style="width:75px" readonly></td>
	     		<th class="tr2_head align_center" style="font-weight: bold;">Creation Date</th>
				<td><input name="cre_dt" type="text" class="input2" style="width:80px" readonly></td>
	     		<th class="tr2_head align_center" style="font-weight: bold;">Update Date</th>
	     		<td><input name="upd_dt" type="text" class="input2" style="width:80px" readonly></td>
				<th class="tr2_head align_center" style="font-weight: bold;">Auto Extension YN</th>
	     		<td><input name="auto_xtd_flg" type="text" class="input2" style="width:70px" readonly></td>
	     	</tr>
			<tr>
				<th class="tr2_head align_center" style="font-weight: bold;">To</th>
	     		<td><input name="eff_to_dt" type="text" class="input2" style="width:75px" readonly></td>
	     		<th class="tr2_head align_center" style="font-weight: bold;">Creation User ID</th>
				<td><input name="cre_usr_id" type="text" class="input2" style="width:100px" readonly></td>
	     		<th class="tr2_head align_center" style="font-weight: bold;">Update User ID</th>
	     		<td><input name="upd_usr_id" type="text" class="input2" style="width:100px" readonly></td>
				<th class="tr2_head align_center" style="font-weight: bold;">Creation Office</th>
	     		<td><input name="no_cre_ofc_cd" type="text" class="input2" style="width:70px" value="" readonly></td>
	     	</tr>
		</table>
	</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options : Related COP Information) (E) -->
</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(E) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<div class="opus_design_grid clear" style="display:none" name="tabLayer" id="tabLayer">	
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	
	<div class="opus_design_grid clear" style="display:none" name="tabLayer" id="tabLayer">	
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
	
	<div class="opus_design_grid clear" style="display:none" name="tabLayer" id="tabLayer">	
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
		
	<div id="main_hidden_sheets" style="display:none">
	<!--// HIDDEN SHEET : Temporary header information	//-->
	<script type="text/javascript">ComSheetObject('main_hidden');</script>
	</div>
</div>
</form>
