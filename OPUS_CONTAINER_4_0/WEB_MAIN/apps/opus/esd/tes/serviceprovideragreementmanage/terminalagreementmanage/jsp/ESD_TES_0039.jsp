<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0039.jsp
*@FileTitle : Terminal Agreement Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes0039Event	event			= null;				//PDTO(Data Transfer Object including Parameters)
	Exception		serverException	= null;				// Errors from server.
	String			strErrMsg		= "";				// Error message.
	String			ofc_cd			= "";
	int				rowCount		= 0;				// DB ResultSet list count.

	try {

	    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    ofc_cd = account.getOfc_cd();

		event = (EsdTes0039Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

	String effAgmt = JSPUtil.getCodeCombo("eff_agmt", "01", "", "CD00740", 0, "");
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}

	var ofc_cd = "<%=ofc_cd%>";
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="is_valid_yd_cd">
<input type="hidden" name="yd_cd_hidden">
<input type="hidden" name="yd_cd_deltflg">
<input type="hidden" name="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden">
<input type="hidden" name="vndr_seq_deltflg">

<input type="hidden" name="no_ofc_cd" id="no_ofc_cd">
<input type="hidden" name="no_yd_cd" id="no_yd_cd">
<input type="hidden" name="act_tp" id="act_tp" value="AGMT">
<input type="hidden" name="auth_ofc_cd" id="auth_ofc_cd" value="">
<input type="hidden" name="cre_ofc_cd" id="cre_ofc_cd" value="<%=ofc_cd%>">

<input type="hidden" name="tml_agmt_ofc_cty_cd" id="tml_agmt_ofc_cty_cd">
<input type="hidden" name="tml_agmt_ver_no" id="tml_agmt_ver_no">

<input type="hidden" name="vndr_abbr_nm" id="vndr_abbr_nm">
<input type="hidden" name="eff_fm_dt" id="eff_fm_dt">

<input type="hidden" name="cre_dt" id="cre_dt">
<input type="hidden" name="upd_dt" id="upd_dt">
<input type="hidden" name="auto_xtd_flg" id="auto_xtd_flg">
<input type="hidden" name="eff_to_dt" id="eff_to_dt">
<input type="hidden" name="cre_usr_id" id="cre_usr_id">
<input type="hidden" name="upd_usr_id" id="upd_usr_id">
<input type="hidden" name="no_cre_ofc_cd" id="no_cre_ofc_cd">


<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!--  
	    --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 	    
	    --><button type="button" class="btn_normal" name="btng_adjustmentscreen" id="btng_adjustmentscreen">Adjustment Screen</button><!-- 
	    --><button type="button" class="btn_normal" name="btng_detail" id="btng_detail">Detail</button><!-- 
	    --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!-- 
	    --><button type="button" class="btn_normal" name="btng_print" id="btng_print" style="display:none;">Print</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<!-- 검색영역 -->
	<div class="opus_design_inquiry wFit">		
	<table>
		<colgroup>
			<col width="105" />				
			<col width="420" />				
			<col width="110" />				
			<col width="*" />				
	   </colgroup> 
		   <tbody>
			<tr>
				<th>Yard</th>
				<td><input type="text" name="yd_cd" id="yd_cd" style="width:87px" maxlength="7" onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);' onBlur='getYardName();'><!--
				 --><button type=button class="input_seach_btn" name="btn_yard" id="btn_yard"></button><input type="text" name="yd_cd_name" id="yd_cd_name" style="width:230px" readonly></td>
				<th>Service Provider</th>
				<td><input type="text" name="vndr_seq" id="vndr_seq" style="width:78px" maxlength="6" onKeyUp='isNum(this);' onKeyDown='tes_chkInput(this);' onBlur='validateVendorCode();'><!--
				--><button type=button class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button><input type="text" name="vndr_seq_name"  id="vndr_seq_name" style="width:205px" readonly></td>
			</tr>
		</table>
		<table>
		<colgroup>
			<col width="105">				
			<col width="159">				
			<col width="110">	
			<col width="150">				
			<col width="110">		
			<col width="110">	
			<col width="*">			
	   </colgroup> 
		   <tbody>
			<tr>
				<th>Effective AGMT</th>
				<td><%=effAgmt%></td>
				<th>Effective On</th>
				<td><input type="text" style="width:81px" name="eff_on" id="eff_on" maxlength="10" dataformat="ymd" onKeyDown='tes_chkInput(this);'><!--
				--><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button></td>
				<th>Contract Office</th>
				<td><input type="text" name="ctrt_ofc_cd" id="ctrt_ofc_cd" maxlength="6" style="width:78px" onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);'></td>
				<th>Cost Code</th>
				<td><input type="text" name="lgs_cost_cd" id="lgs_cost_cd" maxlength="6" style="width:78px" onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);'></td>
			</tr>
			<tr>
				<th>Deleted Y/N</th>
				<td width="121px"><SELECT name = "delt_flg" id = "delt_flg"  style="width:72px">
						<OPTION  value="N"> Live</OPTION>
						<OPTION  value="Y"> Deleted</OPTION>
						<OPTION  value=""> All</OPTION></SELECT></td>
				<th>AGMT Status</th>
				<td><SELECT name = "tml_agmt_sts_cd" id = "tml_agmt_sts_cd"  style="width:80px">
						<OPTION  value=""> All</OPTION>
						<OPTION  value="P"> Processing</OPTION>
						<OPTION  value="C"> Registered</OPTION></SELECT></td>
				<th>Creation &nbsp;Office</th>
				<td><input type="text" name="cre_ofc_cd2" id="cre_ofc_cd2" maxlength="6" style="width:78px" value="" onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);'></td>
			</tr>
			</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" >		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

	<div class="opus_design_grid" id="MiniLayer">
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
</div>
</form>
