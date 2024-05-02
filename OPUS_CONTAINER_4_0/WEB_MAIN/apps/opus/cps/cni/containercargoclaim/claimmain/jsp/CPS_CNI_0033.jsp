<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0033.js
*@FileTitle  : [CPS_CNI_0033] View-Claim Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    Exception serverException = null;
    String strErrMsg = "";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    
    String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no" , "");
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
  		
        //세션에 Claim No가 존재하면
        String ssCgoClmNo =  eventResponse.getETCData("CGO_CLM_NO");
        if ( cgoClmNo.equals("") && !ssCgoClmNo.equals("")) {
        	cgoClmNo = ssCgoClmNo;
        }
        
    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    //log.debug("popupYn=" + popupYn);
%>

<script type="text/javascript">
	 
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
<input type="hidden" name="clss_clm_misc_cd" id="clss_clm_misc_cd" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" />
<input type="hidden" name="ofc_cd" value="<%=userOffice%>" id="ofc_cd" />
<input type="hidden" name="trns_seq" value="" id="trns_seq" />
<input type="hidden" name="bfr_cgo_clm_sts_cd" value="" id="bfr_cgo_clm_sts_cd" />
<input type="hidden" name="pre_cgo_clm_clz_cd" value="" id="pre_cgo_clm_clz_cd" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />

<!--RD 를 위한변수-->
<input type="hidden" name="rd_title" value="" id="rd_title" />
<input type="hidden" name="rd_title_nm" value="" id="rd_title_nm" />
<input type="hidden" name="rd_report_by" value="" id="rd_report_by" />

<input type="hidden" name="popupYn" id="popupYn" value="<%=popupYn%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<% if (!"Y".equals(popupYn)) { %>
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	<% } else { %>
		<h2 class="page_title">Claim Main View</h2>
	<% } %>	
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
			--><button class="btn_normal" name="btn1_Payment" id="btn1_Payment" type="button">Payment</button><!--
			--><button class="btn_normal" name="btn1_Handling_Costs" id="btn1_Handling_Costs" type="button">Handling Costs</button>
			<% if ("Y".equals(popupYn)) {%>
				<button class="btn_normal" name="btn1_Close" id="btn1_Close" type="button">Close</button>
			<%} %>
		</div>
		<!-- opus_design_btn (E) -->
	<% if (!"Y".equals(popupYn)) { %>
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	<% } %>	
</div>
<!-- page_title_area(E) -->

 <div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="60">
					<col width="120">
					<col width="65">
					<col width="70">
					<col width="50">
					<col width="120">
					<col width="30">
					<col width="100">
					<col width="75">
					<col width="100">
					<col width="55">
					<col width="*">
				</colgroup>
				<tr>
					<th>Claim No.</th>
					<td><input type="text" name="cgo_clm_no" id="cgo_clm_no" dataformat="engup"  maxlength="10" class="input1" style="width: 85px; ime-mode: disabled" value="<%=cgoClmNo%>" required><!--  
						--><input type="text" name="clm_area_cd" id="clm_area_cd" style="width: 21px;" value="" class="input2" readonly="readonly"></td>
					<th title="Handling Office">HOFC</th>
					<td><input type="text" name="hdlr_ofc_cd" id="hdlr_ofc_cd" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly"></td>
					<th>Handler</th>
					<td><input type="text" name="hdlr_usr_id" id="hdlr_usr_id" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"><!--  
						--><button type="button" class="input_seach_btn" name="btns_hanlder_history" id="btns_hanlder_history"></button></td>
					<th title="Date Of Updated">DOU</th>
					<td><input type="text" name="upd_dt" id="upd_dt" dataformat="ymd" style="width: 75px;text-align:center" value="" class="input2" readonly="readonly"></td>
					<th>Incident No.</th>
					<td><input type="text" name="cgo_clm_inci_no" id="cgo_clm_inci_no" dataformt="engup"  maxlength="13" style="width: 90px;" value="" class="input2" readonly="readonly"></td>
					<th>VOC No.</th>
					<td><input type="text" name="crm_voc_no" id="crm_voc_no" dataformt="engup" maxlength="15" style="width: 100%;" value="" class="input2" readonly="readonly"></td>
				</tr>
			
				<tr>
					<th>Status</th>
					<td><input type="hidden" name="cgo_clm_sts_cd" is="cgo_clm_sts_cd"/><input type="text" name="cgo_clm_sts_nm" id="cgo_clm_sts_nm" style="width: 110px;text-align:center" value="" class="input2" readonly="readonly"></td>
					<th><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></th>
					<td><input type="text" name="hpd" id="hpd" style="width: 40px;text-align:center" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="nhp" id="nhp" style="width: 40px;text-align:center" value="" class="input2" readonly="readonly"></td>
					<th title="Type Of Settlement" >TOS</th>
					<td><input type="text" name="cgo_clm_stl_tp_cd" id="cgo_clm_stl_tp_cd" style="width: 49px;text-align:center" value="" class="input2" readonly="readonly"></td>
					<th title="Date Of Close">DOC</th>
					<td><input type="text" name="cs_clz_dt" id="cs_clz_dt" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly"></td>
					<th title="Date Of Time Barred">DOTB</th>
					<td><input type="text" name="clm_tm_bar_dt" id="clm_tm_bar_dt" dataformat="ymd" maxlength="8" style="width: 90px; text-align: center; ime-mode: disabled" class="input2" readonly="readonly" value=""></td>
					<th>Summons Served Date </th>
					<td><input name="smns_sve_dt" id="smns_sve_dt" type="text" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry">
		<table class="line_bluedot"><tr><td></td></tr></table>
	</div>
	<div class="opus_design_inquiry wFit">	
		<table>
			<tbody>
				<colgroup>
					<col width="180">
					<col width="45">
					<col width="120">
					<col width="30">
					<col width="125">
					<col width="80">
					<col width="110">
					<col width="125">
					<col width="60">
					<col width="*">
				</colgroup>
				<tr>
					<td></td>
					<th title="Date Of Acknowledgement">DOACK</th>
					<td><input type="text" name="cgo_clm_acknak_dt" id="cgo_clm_acknak_dt" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly" dataformat="ymd"></td>
					<th title="Date Of Fact Finding">DOFF</th>
					<td><input name="fact_fnd_dt" id="fact_fnd_dt" type="text" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly"></td>
					<th title="LP Time Barred Date">LP DOTB</th>
					<td><input type="text" dataformat="ymd" name="labl_tm_bar_dt" id="labl_tm_bar_dt" style="width: 75px;" value="" class="input2" readonly="readonly"></td>
					<th>Transfer&nbsp;<input type="checkbox" name="trns_flg" id="trns_flg" value="Y" class="trans" onclick = "javascript:return false"  onfocus="this.blur">&nbsp;<!--  
						--><input type="text" name="clm_trns_auth_cd" id="clm_trns_auth_cd" readonly="readonly" style="width: 30px;" value="" class="input2"></th>
					<th>Reopen</th>
					<td><input type="hidden" name="cs_clz_ropn_flg" id="cs_clz_ropn_flg" value=""><!--  
						--><input name="cs_clz_ropn_dt" id="cs_clz_ropn_dt" dataformat="ymd" maxlength="8" type="text" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	
	<div class="opus_design_grid clear" style="display: inline" id="tabLayer">
		<div class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
			    <div class="layout_vertical_2" style="width: 100px;">
			        <table class="search_sm2" style="width: 80px;">
						<tbody>
							<colgroup>
								<col width="75">
							</colgroup>
							<tr class="h23">
								<td><input name="cgo_clm_div_cd" type="radio" value="G"	class="trans" disabled>&nbsp;&nbsp;GEN</td>
							</tr>
							<tr class="h23">
								<td><input name="cgo_clm_div_cd" type="radio" value="I"	class="trans" disabled>&nbsp;&nbsp;INC</td>
							</tr>
							<tr class="h23">
								<td><input name="cgo_clm_div_cd" type="radio" value="O"	class="trans" disabled>&nbsp;&nbsp;OTH</td>
							</tr>
						</tbody>
					</table>
			    </div>
			    <div class="layout_vertical_2" style="width:90%">
			        <table style="width:979px;">
						<tbody>
							<colgroup>
								<col width="60">
								<col width="105">
								<col width="85">
								<col width="30">
								<col width="105">
								<col width="60">
								<col width="170">
								<col width="35">
								<col width="70">
								<col width="90">
								<col width="*">
							</colgroup>
							<tr class="h23">
								<th>B/L No.</th>
								<td><input type="text" dataformat="engup" name="cgo_clm_ref_bl_no" id="cgo_clm_ref_bl_no"  caption="B/L No." style="width: 100px; text-align:center" maxlength="12" value="" class="input2" readonly="readonly"></td>
								<td><button class="btn_etc" name="btns_BL_Preview" id="btns_BL_Preview">B/L View</button></td>
								<th title="Date of Loading">DOL</th>
								<td><input type="text" name="lodg_dt" id="lodg_dt" dataformat="ymd" maxlength="8" style="width: 75px;text-align:center" value="" class="input2" readonly="readonly"></td>
								<th><span title="Place of Delivery">DEL</span>/<span  title="Date of Delivery">DDL</span></th>
								<td><input type="text" name="del_cd" id="del_cd" dataformat="engup" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly" caption="Place of Delivery" >&nbsp;/&nbsp;&nbsp;<input type="text" name="de_dt" id="de_dt" dataformat="ymd" maxlength="8" style="ime-mode:disabled; width: 75px; text-align:center" value="" class="input2" readonly="readonly"></td>
								<th>Term</th>
								<td><input type="text" name="crr_term_cd" id="crr_term_cd" style="width:50px;text-align:center" value="" class="input2" readonly="readonly"></td>
								<th>Surveyed Date</th>
								<td><input type="text" style="width: 100%;text-align:center;" name="svey_inp_dt" id="svey_inp_dt" dataformat="ymd" maxlength="8" value="" style="ime-mode:disabled" class="input2" readonly="readonly"></td>
							</tr>
						</tbody>
					</table>
			        <table style="width:979px;">
						<tbody>
							<colgroup>
								<col width="60">
								<col width="285">
								<col width="60">
								<col width="125">
								<col width="80">
								<col width="*">
							</colgroup>
							<tr class="h23">
								<th title="Vessel Voyage Direction">VVD</th>
								<td><input type="text" name="trnk_ref_vvd_no" id="trnk_ref_vvd_no" maxlength="20" dataformat="engup" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"><!--  
									--><input type="text" name="vsl_eng_nm" id="vsl_eng_nm" style="width: 193px;" value="" class="input2" readonly="readonly"></td>
								<td><input type="text" name="insur_vsl_tp_cd" id="insur_vsl_tp_cd" style="width: 100%;" value="" class="input2" readonly="readonly"></td>
								<td><input type="text" name="insur_vsl_oshp_cd" id="insur_vsl_oshp_cd" style="width: 53px;" value="" class="input2" readonly="readonly"></td>
								<th>C/P & Dated</th>
								<td><input type="text" name="cp_desc" id="cp_desc" style="width: 100%;"	maxlength="500" value="" class="input2" readonly="readonly"></td>
							</tr>
						</tbody>
					</table>
			        <table style="width:979px;">
						<tbody>
							<colgroup>
								<col width="60">
								<col width="365">
								<col width="70">
								<col width="35">
								<col width="125">
								<col width="110">
								<col width="*">
							</colgroup>
							<tr class="h23">
								<th>Claimant</th>
								<td><input type="text" name="clmt_clm_pty_abbr_nm" id="clmt_clm_pty_abbr_nm" maxlength="8" dataformat="engup" style="width: 80px;text-align:center" value="" class="input2" caption="Claimant" readonly="readonly"><!--  
									--><input type="text" name="clmt_clm_pty_nm" id="clmt_clm_pty_nm" maxlength="200" style="width: 269px;" value="" readonly="readonly" class="input2"><!--  
									--><input type="hidden" name="clmt_clm_pty_no" id="clmt_clm_pty_no" >
								</td>
								<td><button class="btn_etc" name="btn1_Style" id="btn1_Style">Style</button></td>
								<th>Type</th>
								<td><input type="text" name="clmt_clm_tp_cd" id="clmt_clm_tp_cd" style="width: 50px;text-align:center" value=""	class="input2" readonly="readonly"></td>
								<th>Claimant Ref No.</th>
								<td><input type="text" name="clmt_ref_no" id="clmt_ref_no" style="width: 100%;" value="" class="input2" readonly="readonly"></td>
							</tr>
						</tbody>
					</table>
			    </div>
			</div>
			<!-- layout_wrap(E) -->
			<table style="width:1079px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="125">
						<col width="80">
						<col width="310">
						<col width="55">
						<col width="135">
						<col width="100">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th title="Notice Of Preliminary Claim">&nbsp;&nbsp;DON</th>
						<td><input type="text" name="prlm_clm_ntc_dt" id="prlm_clm_ntc_dt" dataformat="ymd" maxlength="8"style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly"></td>
						<th><span title="Received Office">ROFC</span>/<span title="Date of Formal Claim">DOF</span></th>
						<td><input type="text" name="fmal_clm_rcv_ofc_cd" id="fmal_clm_rcv_ofc_cd" style="width: 59px;text-align:center" dataformat="engup" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="fmal_clm_rcv_dt" id="fmal_clm_rcv_dt" dataformat="ymd" maxlength="8" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"></td>
						<th>Insurer</th>
						<td><input type="text" name="insur_clm_pty_abbr_nm" id="insur_clm_pty_abbr_nm" style="width: 80px;text-align:center" maxlength="10" dataformat="engup" value="" maxlength="10" class="input2" readonly="readonly" caption="Insurer"><!--  
							--><input type="hidden" name="insur_clm_pty_no" id="insur_clm_pty_no" value="">
						</td>
						<th>Insurer Ref No.</th>
						<td><input type="text" name="insur_ref_no" id="insur_ref_no" style="width: 100%;text-align:center" maxlength="20" value="" class="input2" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="130">
						<col width="50">
						<col width="85">
						<col width="15">
						<col width="95">
						<col width="25">
						<col width="80">
						<col width="25">
						<col width="90">
						<col width="40">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th title="Type of Cargo Claim">&nbsp;&nbsp;TOC</th>
						<td><input type="text" name="cgo_clm_tp_cd" id="cgo_clm_tp_cd" style="width: 60px;text-align:center" dataformat="engup" value="" maxlength="3" class="input2" readonly="readonly" caption="TOC"></td>
						<th title="Cause of Damage / Loss">CODL 1</th>
						<td><input type="text" name="mjr_clm_dmg_lss_cd" id="mjr_clm_dmg_lss_cd" style="width: 50px;text-align:center" dataformat="engup" value="" maxlength="2" class="input2" readonly="readonly"></td>
						<th title="Cause of Damage / Loss">2</th>
						<td><input type="text" name="minr_clm_dmg_lss_cd" id="minr_clm_dmg_lss_cd" style="width: 50px;text-align:center" dataformat="engup" value="" maxlength="3" class="input2" readonly="readonly"></td>
						<th title="Place of Incident">POI</th>
						<td><input type="text" name="inci_plc_tp_cd" id="inci_plc_tp_cd" style="width: 35px;text-align:center" dataformat="engup" value="" maxlength="3" class="input2" readonly="readonly"></td>
						<th title="Date of Incident">DOI</th>
						<td><input type="text" name="inci_occr_dt" id="inci_occr_dt" dataformat="ymd" maxlength="8" type="text" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly"></td>
						<th>Cargo</th>
						<td><input type="text" name="clm_cgo_tp_cd" id="clm_cgo_tp_cd" style="width: 34px;text-align:center" dataformat="engup" value="" class="input2" readonly="readonly" caption="Cargo"><!--  
							--><input type="text" name="cgo_qlty_desc" style="width: 212px;" value="" class="input2" readonly="readonly" caption="Cargo Description"></td>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="130">
						<col width="100">
						<col width="250">
						<col width="40">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Lane</th>
						<td><input type="text" name="slan_cd" id="slan_cd" style="width: 60px;text-align:center" dataformat="engup" value="" maxlength="3" class="input2" readonly="readonly" caption="Lane"></td>
						<th>Claim Amount</th>
						<td><input type="text" name="clmt_locl_amt" id="clmt_locl_amt" dataformat="float" style="width: 165px; text-align: right" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="clmt_locl_curr_cd" id="clmt_locl_curr_cd"  dataformat="engup" maxlength="3" style="width: 35px; text-align:center" value="" class="input2" readonly="readonly"></td>
						<th title="Rate of Exchange">R.O.E</th>
						<td class="stm">
							<input type="text" name="clmt_locl_xch_rt" id="clmt_locl_xch_rt" dataformat="float" style="width: 60px; text-align: right" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="clmt_usd_amt" id="clmt_usd_amt" dataformat="float" style="width: 142px; text-align: right" value="" class="input2" readonly="readonly">&nbsp;USD</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="opus_design_grid clear" style="display: none;" id="tabLayer">
		<div class="opus_design_inquiry">
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="470">
						<col width="65">
						<col width="150">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>CNTR No.</th>
						<td><input type="text" name="cgo_clm_ref_cntr_no" id="cgo_clm_ref_cntr_no" style="width: 387px;" value="" class="input2" readonly="readonly"></td>
						<th>O.FRT</th>
						<td><input type="text" name="clm_ofrt_amt" id="clm_ofrt_amt" dataformat="float" style="width: 140px; text-align: right" value="" readonly="readonly" class="input2"></td>
						<th>USD /&nbsp;<input type="text" name="clm_ofrt_term_cd" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="clm_ofrt_flg" id="clm_ofrt_flg" style="width: 26px;text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="185">
						<col width="65">
						<col width="220">
						<col width="65">
						<col width="165">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th title="Place of Receipt/Date of Receipt">POR/DOR</th>
						<td><input type="text" name="por_cd" id="por_cd" style="width: 45px;" value="" class="input2" readonly="readonly" >&nbsp;/&nbsp;&nbsp;<input type="text" name="rct_dt" id="rct_dt"  dataformat="ymd" style="width:80px; text-align: center" value="" class="input2" readonly="readonly"></td>
						<th>POL/DOL</th>
						<td><input type="text" name="pol_cd" id="pol_cd" style="width: 46px;" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="lodg_dt" id="lodg_dt" dataformat="ymd" style="width: 75px; text-align:center" value="" class="input2" readonly="readonly"></td>
						<th>POD/DOD</th>
						<td><input type="text" name="pod_cd" id="pod_cd" style="width: 45px;text-align:center" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="dchg_dt" id="dchg_dt" dataformat="ymd" style="width: 80px;text-align: center" value="" class="input2" readonly="readonly"></td>
						<th align="right">DEL/DDL&nbsp;<input type="text" name="del_cd" id="del_cd" style="width: 45px;text-align:center" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="de_dt" id="de_dt" dataformat="ymd" style="width: 80px;text-align: center" value="" class="input2" readonly="readonly"></th>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="90">
						<col width="15">
						<col width="90">
						<col width="15">
						<col width="260">
						<col width="65">
						<col width="90">
						<col width="15">
						<col width="90">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Pre-VVD 1</th>
						<td><input type="text" style="width:80px;" name="n1st_pre_ref_vvd_no" id="n1st_pre_ref_vvd_no" value="" class="input2" readonly="readonly"></td>
						<th title="Cause of Damage / Loss">2</th>
						<td><input type="text" style="width: 80px;" name="n2nd_pre_ref_vvd_no" id="n2nd_pre_ref_vvd_no" value="" class="input2" readOnly="readOnly"></td>
						<th>3</th>
						<td><input type="text" style="width: 80px;"  name="n3rd_pre_ref_vvd_no" id="n3rd_pre_ref_vvd_no" value="" class="input2" readonly="readonly"></td>
						<th>On-VVD 1</th>
						<td><input type="text" name="n1st_pst_ref_vvd_no" id="n1st_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly"></td>
						<th title="Cause of Damage / Loss">2</th>
						<td><input type="text" name="n2nd_pst_ref_vvd_no" id="n2nd_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly"></td>
						<th>3&nbsp;<input type="text"  name="n3rd_pst_ref_vvd_no" id="n3rd_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly"></th>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="185">
						<col width="65">
						<col width="225">
						<col width="65">
						<col width="165">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Pre-POT 1</th>
						<td><input type="text" name="n1st_pre_ts_loc_cd" id="n1st_pre_ts_loc_cd" style="width: 45px;" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="n1st_pre_ts_dt" id="n1st_pre_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"></td>
						<th>Pre-POT 2</th>
						<td><input type="text" name="n2nd_pre_ts_loc_cd" id="n2nd_pre_ts_loc_cd" style="width:46px;" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="n2nd_pre_ts_dt" id="n2nd_pre_ts_dt" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"></td>
						<th>On-POT1</th>
						<td><input type="text" name="n1st_pst_ts_loc_cd" id="n1st_pst_ts_loc_cd" style="width: 45px;" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="n1st_pst_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"></td>
						<th align="right">On-POT2&nbsp;<input type="text" name="n2nd_pst_ts_loc_cd" id="n2nd_pst_ts_loc_cd" style="width: 45px;" value="" class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input type="text" name="n2nd_pst_ts_dt" id="n2nd_pst_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"></th>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Surveyor</th>
						<td><input type="hidden" name="svey_clm_pty_no" id="svey_clm_pty_no" value=""><!--  
							--><input type="text" style="width: 387px;" name="svey_clm_pty_abbr_nm" id="svey_clm_pty_abbr_nm" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="svyr_tp_cd" id="svyr_tp_cd" style="width: 25px;" value="" class="input2" readonly="readonly">
						</td>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="75">
						<col width="470">
						<col width="65">
						<col width="230">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Liable Party</th>
						<td><input type="hidden" name="labl_clm_pty_no" id="labl_clm_pty_no" value=""><!--  
							--><input type="text" name="labl_clm_pty_abbr_nm" id="labl_clm_pty_abbr_nm" style="width: 387px;" value="" class="input2" readonly="readonly"></td>
						<th title="LP Date of Formal Claim">LP DOF</th>
						<th><input type="text" name="labl_pty_fmal_clm_dt" id="labl_pty_fmal_clm_dt" dataformat="ymd" style="width: 80px; text-align:center" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="labl_pty_dmnd_usd_amt" id="labl_pty_dmnd_usd_amt" dataformat="float" caption="LP DOF" style="width: 140px;text-align:right" value="" class="input2" readonly="readonly">&nbsp;USD</th>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="opus_design_grid clear" style="display: none;" id="tabLayer">
		<div class="opus_design_inquiry">
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="100">
						<col width="670">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Plaintiff</th>
						<td><input type="text" name="plt_nm" id="plt_nm" style="width: 587px;" value="" class="input2" readonly="readonly"></td>
						<th align="right">LT Updated&nbsp;<input type="text" name="ligt_upd_dt" id="ligt_upd_dt" dataformat="ymd" style="width:80px;text-align:center" value="" class="input2" readOnly="readonly"></th>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="100">
						<col width="670">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Defendant</th>
						<td><input type="text" name="deft_nm" id="deft_nm" style="width: 587px;" value="" class="input2" readonly="readonly"></td>
						<th align="right">LT Updater&nbsp;<input type="text" name="ligt_upd_usr_id" id="ligt_upd_usr_id" style="width: 80px; text-align:center" value="" class="input2" readonly="readonly"></th>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="100">
						<col width="600">
						<col width="70">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Def. Attorney</th>
						<td><input type="hidden" name="deft_atty_clm_pty_no" id="deft_atty_clm_pty_no" value="" ><!--  
							--><input type="text" name="deft_atty_clm_pty_abbr_nm" id="deft_atty_clm_pty_abbr_nm" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name ="deft_atty_clm_pty_nm" id="deft_atty_clm_pty_nm" style="width: 503px;"value="" class="input2" readonly="readonly"></td>
						<td><button class="btn_etc" name="btn3_Style" id="btn3_Style">Style</button></td>
						<td align="right">&nbsp;</td>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="100">
						<col width="280">
						<col width="155">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Appointed Date</th>
						<td><input name="deft_atty_apnt_dt" id="deft_atty_apnt_dt" type="text" dataformat="ymd" maxlength="8" style="width: 80px; text-align:center" value="" class="input2" readonly="readonly"></td>
						<th>Def. Attorney's Ref No.</th>
						<td><input type="text" name="ref_deft_atty_no" id="ref_deft_atty_no" style="width: 152px;"	value="" class="input2" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
			<table style="width:979px;">
				<tbody>
					<colgroup>
						<col width="100">
						<col width="280">
						<col width="155">
						<col width="180">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Court</th>
						<td><input type="text" name="crt_nm" id="crt_nm" style="width: 230px;" value="" class="input2" readonly="readonly"></td>
						<th>Case No.</th>
						<td><input type="text" name="crt_cs_no" id="crt_cs_no" style="width: 152px;" value="" class="input2" readonly="readonly"></td>
						<th>Filed Date&nbsp;<input name="cpln_file_dt" id="cpln_file_dt" type="text" dataformat="ymd" maxlength="8" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"></th>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="140">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Final Judgment / Date</th>
						<td><input type="text" name="jmt_rslt_nm" id="jmt_rslt_nm" style="width: 120px;" value=""	class="input2" readonly="readonly">&nbsp;/&nbsp;&nbsp;<input name="jmt_rslt_dt" id="jmt_rslt_dt" type="text" dataformat="ymd" maxlength="8" style="width: 77px;text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>	
</div>
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab2')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<div class="opus_design_grid clear" style="display:inline;" id="tabLayer2">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr class="h23">
					<td><textarea name="clm_cuz_desc" id="clm_cuz_desc" style="width: 100%; resize:none;" rows="8" class="textarea2"  caption="Cause of Claim" readonly="readonly"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_grid clear" style="display:none;" id="tabLayer2">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr class="h23">
				    <td><textarea style="width: 100%; resize:none;" rows="8" class="textarea2" name="fact_fnd_desc" id="fact_fnd_desc"  caption="Fact Findings & Assessment" readonly="readonly"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_grid clear" style="display:none;" id="tabLayer2">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr class="h23">
					<td><textarea style="width: 100%; resize:none;" rows="8" class="textarea2"  caption="Main Issue Review & DV" name="clm_rvw_desc" id="clm_rvw_desc"  readonly="readonly"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_grid clear" style="display:none;" id="tabLayer2">
		<div class="opus_design_inquiry">
			<table class="search">
				<tbody>
					<colgroup>
						<col width="105">
						<col width="325">
						<col width="70">
						<col width="70">
						<col width="40">
						<col width="150">
						<col width="120">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Claimant's Agent</th>
						<td><input type="hidden" name="clm_agn_clm_pty_no" id="clm_agn_clm_pty_no" value=""><!--  
							--><input type="text" name="clm_agn_clm_pty_abbr_nm" id="clm_agn_clm_pty_abbr_nm" style="width: 60px;" dataformat="engup" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="clm_agn_clm_pty_nm" id="clm_agn_clm_pty_nm" style="width: 249px;" value="" class="input2" readonly="readonly"></td>
						<td><button class="btn_etc" name="btn4_Style" id="btn4_Style">Style</button></td>
						<td>&nbsp;</td>
						<th>Type</th>
						<td><input type="text" name="clmt_agn_tp_cd" id="clmt_agn_tp_cd" style="width: 50px;" value=""	class="input2" readonly="readonly"></td> 
						<th>CA Appointed Date</th>
						<td><input type="text" name="clmt_agn_apnt_dt" id="clmt_agn_apnt_dt" dataformat="ymd" maxlength="8" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
			<table class="search">
				<tbody>
					<colgroup>
						<col width="25">
						<col width="210">
						<col width="40">
						<col width="290">
						<col width="160">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Tel.</th>
						<td><input type="text" name="clm_agn_intl_phn_no" id="clm_agn_intl_phn_no" style="width: 35px;" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="clm_agn_phn_no" id="clm_agn_phn_no" style="width: 160px;" value="" class="input2" readonly="readonly"></td>
						<th>E-Mail</th>
						<td><input type="text" name="clm_agn_pty_eml" id="clm_agn_pty_eml" style="width: 236px;" value="" class="input2" readonly="readonly"></td>
						<th>Claimant's Agent Ref No.</th>
						<td><input type="text" name="clmt_agn_ref_no" id="clmt_agn_ref_no" style="width: 100%;" value="" class="input2" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="opus_design_grid clear" style="display:none;" id="tabLayer2">
		<div class="opus_design_inquiry">
			<table class="search">
				<tbody>
					<colgroup>
						<col width="95">
						<col width="340">
						<col width="70">
						<col width="70">
						<col width="40">
						<col width="150">
						<col width="120">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Insurer's Agent</th>
						<td><input type="hidden" name="insur_agn_clm_pty_no" id="insur_agn_clm_pty_no" value=""><!--  
							--><input type="text" name="insur_agn_clm_pty_abbr_nm" id="insur_agn_clm_pty_abbr_nm" style="width: 60px;" dataformat="engup" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="insur_agn_clm_pty_nm" id="insur_agn_clm_pty_nm" style="width: 249px;" value="" class="input2" readonly="readonly"></td>
						<td><button class="btn_etc" name="btn5_Style" id="btn5_Style">Style</button></td>
						<td>&nbsp;</td>
						<th>Type</th>
						<td><input type="text" name="agn_crspn_tp_cd" id="agn_crspn_tp_cd" style="width: 50px;" value="" class="input2" readonly="readonly"></td>
						<th>IA Appointed Date</th>
						<td><input type="text" name="agn_crspn_apnt_dt" id="agn_crspn_apnt_dt" dataformat="ymd"  maxlength="8" style="width:80px;text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
			<table class="search">
				<tbody>
					<colgroup>
						<col width="25">
						<col width="210">
						<col width="40">
						<col width="285">
						<col width="160">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Tel.</th>
						<td><input type="text" name="insur_agn_intl_phn_no" id="insur_agn_intl_phn_no" style="width: 35px;" value="" class="input2" readonly="readonly"><!--  
							--><input type="text" name="insur_agn_phn_no" id="insur_agn_phn_no" style="width: 160px;" value="" class="input2" readonly="readonly"></td>
						<th>E-Mail</th>
						<td><input type="text" name="insur_agn_pty_eml" id="insur_agn_pty_eml" style="width: 236px;" value="" class="input2" readonly="readonly"></td>
						<th>Insurer's Agent Ref No.</th>
						<td><input type="text" name="agn_crspn_ref_no" id="agn_crspn_ref_no" style="width: 100%;" value="" class="input2" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="opus_design_grid clear" style="display:none;" id="tabLayer2">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr class="h23">
					<td><textarea name="ltgt_cs_desc" id="ltgt_cs_desc" style="width: 100%; resize:none;"   caption="Case Summary & DV" rows="9" class="textarea2" readonly="readonly"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>      
</form>
<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
