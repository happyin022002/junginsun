<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0037.jsp
*@FileTitle  : [CPS_CNI_0037] Claim Reopen
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
    Exception serverException = null;
    String strErrMsg = "";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String roles = "";
    String area = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
    String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no" , "");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        // 사용자 roles
        roles = CniUtil.getRoles(account);
        area =  CniUtil.getAreaInfo(account);

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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="clss_clm_misc_cd" id="clss_clm_misc_cd" />
<input type="hidden" name="ofc_cd" value="<%=userOffice%>" id="ofc_cd" readonly="readonly"/>
<input type="hidden" name="trns_seq" value="" id="trns_seq" />
<input type="hidden" name="bfr_cgo_clm_sts_cd" value="" id="bfr_cgo_clm_sts_cd" />
<input type="hidden" name="pre_cgo_clm_clz_cd" value="" id="pre_cgo_clm_clz_cd" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" readonly="readonly"/>
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" readonly="readonly"/>
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" readonly="readonly"/>
<input type="hidden" name="usr_office" value="<%=userOffice%>" id="usr_office" readonly="readonly"/>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn1_Reopen" id="btn1_Reopen" type="button">Reopen</button><!--
	--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
	--><button class="btn_normal" name="btn1_Payment" id="btn1_Payment" type="button">Payment</button><!--
	--><button class="btn_normal" name="btn1_Handling_Costs" id="btn1_Handling_Costs" type="button">Handling Costs</button><!--
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
	<div class="opus_design_inquiry">
		<table>
		   <tbody> 
			<colgroup>
				<col width="65" />				
				<col width="120" />				
				<col width="70" />				
				<col width="115" />				
				<col width="80" />				
				<col width="120" />				
				<col width="29" />				
				<col width="100" />				
				<col width="55" />				
				<col width="110" />				
				<col width="140" />				
				<col width="*" />				
		   </colgroup> 
		   		<tr>
					<th>Claim No.</th>
					<td><input type="text" style="width:85px;text-align:center" name="cgo_clm_no" value="<%=cgoClmNo%>" required maxlength="10" caption="Claim No" dataformat="engup" class="input1" id="cgo_clm_no" /><input type="text" style="width:20px;" name="clm_area_cd" value="" class="input2" readonly id="clm_area_cd" /></td>
					<th title="Handling Office">HOFC</th>
					<td><input type="text" name="hdlr_ofc_cd" id="hdlr_ofc_cd" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly"></td>
					<th>Handler</th>
					<td><input type="text" name="hdlr_usr_id" id="hdlr_usr_id"  style="width: 80px;text-align:center" value="" class="input2" readonly="readonly"><button type="button" name="btns_hanlder_history" id="btns_hanlder_history"  class="input_seach_btn"></button></td>
					<th title="Date Of Updated">DOU</th>
					<td><input type="text" name="upd_dt" id="upd_dt" dataformat="ymd" style="width: 75px;text-align:center" value="" class="input2" readonly="readonly"></td>
					<th>Incident No.</th>
					<td><input type="text" name="cgo_clm_inci_no" dataformt="engup" maxlength="13" style="width: 90px;" value="" class="input2" readonly="readonly" id="cgo_clm_inci_no" /> </td>
					<th>VOC No.</th>
					<td><input type="text" name="crm_voc_no" dataformt="engup" maxlength="15" style="width: 159px;" value="" class="input2" readonly="readonly" id="crm_voc_no" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="65" />				
				<col width="120" />				
				<col width="70" />				
				<col width="115" />				
				<col width="80" />				
				<col width="122" />				
				<col width="29" />				
				<col width="100" />				
				<col width="75" />				
				<col width="110" />				
				<col width="140" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
   					<th>Status</th>
					<td><input type="hidden" name="cgo_clm_sts_cd" id="cgo_clm_sts_cd" /> <input type="text" name="cgo_clm_sts_nm" style="width: 110px;text-align:center" value="" class="input2" readonly="readonly" id="cgo_clm_sts_nm" /> </td>
					<th><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></th>
					<td><input type="text" name="hpd" style="width: 40px;text-align:center" value="" class="input2" readonly="readonly" id="hpd" />/ <input type="text" name="nhp" style="width: 40px;text-align:center" value="" class="input2" readonly="readonly" id="nhp" /> </td>
					<th title="Type Of Settlement">TOS</th>
					<td><input type="text" name="cgo_clm_stl_tp_cd" style="width: 44px;text-align:center" value="" class="input2" readonly="readonly" id="cgo_clm_stl_tp_cd" /> </td>
					<th title="Date Of Close">DOC</th>
					<td><input type="text" name="cs_clz_dt" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly" id="cs_clz_dt" />  </td>
					<th title="Time Bar Date">DOTB</th>
					<td><input type="text" name="clm_tm_bar_dt" dataformat="ymd" maxlength="8" style="width: 89px; text-align: center; ime-mode: disabled" class="input2" readonly="readonly" value="" id="clm_tm_bar_dt" />  </td>
					<th>Summons Served Date</th>
					<td><input name="smns_sve_dt" type="text" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly" id="smns_sve_dt" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table class="line_bluedot">  <tr><td></td></tr></table>
		<table class="pad_btm_8">
			<colgroup>
				<col width="65" />				
				<col width="120" />				
				<col width="70" />				
				<col width="115" />				
				<col width="80" />				
				<col width="120" />				
				<col width="29" />				
				<col width="108" />				
				<col width="*" />				
					
		   </colgroup> 
		   <tbody>
		   		<tr>
   					
					<th>DOACK</th>
					<td><input type="text" name="cgo_clm_acknak_dt" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly" id="cgo_clm_acknak_dt" /> </td>
					<th>DOFF</th>
					<td><input name="fact_fnd_dt" type="text" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly" id="fact_fnd_dt" /> </td>
					<th title="LP Time Barred Date">LP DOTB</th>
					<td><input type="text" dataformat="ymd" name="labl_tm_bar_dt" style="width: 75px;" value="" class="input2" readonly="readonly" id="labl_tm_bar_dt" /> </td>
					<td>Transfer <input type="checkbox" name="trns_flg" value="Y" class="trans" onclick="javascript:return false" onfocus="this.blur" id="trns_flg" />  <input type="text" name="clm_trns_auth_cd" readonly="readonly" style="width: 30px;" value="" class="input2" id="clm_trns_auth_cd" /> </td>
					<th>Reopen</th>
					<td><input type="hidden" name="cs_clz_ropn_flg" value="" id="cs_clz_ropn_flg" /> <input name="cs_clz_ropn_dt" dataformat="ymd" maxlength="8" type="text" style="width: 86px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly" id="cs_clz_ropn_dt" /> </td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">

<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->
<!--Tab 1 (S)-->
<div id="tabLayer1" style="display: inline">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap" style="width:100%">
		<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:120px">
				<!-- wrap_search_tab(S) -->
				<div class="wrap_result">
					<div class="opus_design_inquiry wFit">
						<table class="sm" style="width:100px">
							<tr><td class="pad_left_8"><input name="cgo_clm_div_cd" type="radio" value="G" class="trans" disabled="" id="cgo_clm_div_cd" />   GEN</td></tr>
							<tr><td class="pad_left_8"><input name="cgo_clm_div_cd" type="radio" value="I" class="trans" disabled="" id="cgo_clm_div_cd" />   INC</td></tr>
							<tr><td class="pad_left_8"><input name="cgo_clm_div_cd" type="radio" value="O" class="trans" disabled="" id="cgo_clm_div_cd" />   OTH</td></tr>
						</table>
					</div>
				</div>
				<!-- wrap_search_tab(E) -->
			</div>
		<!--Content-->
		<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:*">
				<!-- wrap_search_tab(S) -->
				<div class="wrap_result">
					<div class="opus_design_inquiry wFit">
						<table>
							<colgroup>
								<col width="65">					
								<col width="80">				
								<col width="30">				
								<col width="102">				
								<col width="57">				
								<col width="260">				
								<col width="35">				
								<col width="100">				
								<col width="90">				
								<col width="*">				
						   </colgroup> 
							<tr>
								<th>B/L No.</th>
								<td><input type="text" dataformat="engup" name="cgo_clm_ref_bl_no" caption="B/L No." style="width: 100px; text-align:center" maxlength="12" value="" class="input2" readonly="readonly" id="cgo_clm_ref_bl_no" /> </td>
								<th title="Date of Loading">DOL</th>
								<td><input type="text" name="lodg_dt" dataformat="ymd" maxlength="8" style="width: 75px;text-align:center" value="" class="input2" readonly="readonly" id="lodg_dt" /> </td>
								<th><span title="Place of Delivery">DEL</span>/<span title="Date of Delivery">DDL</span></th>
								<td><input type="text" name="del_cd" dataformat="engup" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly" caption="Place of Delivery" id="del_cd" />/ <input type="text" name="de_dt" dataformat="ymd" maxlength="8" style="ime-mode:disabled" value="" class="input2" readonly="readonly" id="de_dt" /> </td>
								<th>Term</th>
								<td><input type="text" name="crr_term_cd" style="width:50px;text-align:center" value="" class="input2" readonly="readonly" id="crr_term_cd" /> </td>
								<th>Surveyed Date</th>
								<td><input type="text" style="width: 194px;%;text-align:center;" name="svey_inp_dt" dataformat="ymd" maxlength="8" value="" class="input2" readonly="readonly" id="svey_inp_dt" /> </td>
							</tr>
						</table>
						<table>
							<colgroup>
								<col width="65" />				
								<col width="514" />				
								<col width="57" />				
								<col width="*" />	
						   </colgroup> 
							<tr>
								<th title="Vessel Voyage Direction">VVD</th>
								<td>
						    		<input type="text" name="trnk_ref_vvd_no" maxlength="20" dataformat="engup" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="trnk_ref_vvd_no" /><!--
						    	 --><input type="text" name="vsl_eng_nm" style="width: 193px;" value="" class="input2" readonly="readonly" id="vsl_eng_nm" /><!--
						    	 --><input type="text" name="insur_vsl_tp_cd" style="width: 100px;%;" value="" class="input2" readonly="readonly" id="insur_vsl_tp_cd" /><!--
						    	 --><input type="text" name="insur_vsl_oshp_cd" style="width: 53px;" value="" class="input2" readonly="readonly" id="insur_vsl_oshp_cd" />
								</td>

								<th>C/P &amp; Dated</th>
								<td><input type="text" name="cp_desc" style="width: 382px;" maxlength="500" value="" class="input2" readonly="readonly" id="cp_desc" /> </td>
							</tr>
						</table>
						<table>
							<colgroup>
								<col width="65" />				
								<col width="361" />				
								<col width="200" />				
								<col width="32" />				
								<col width="80" />				
								<col width="109" />				
								<col width="*" />				
						   </colgroup> 
							<tr>
								<th>Claimant</th>
								<td><input type="text" name="clmt_clm_pty_abbr_nm" maxlength="8" dataformat="engup" style="width: 80px;text-align:center" value="" class="input2" caption="Claimant" readonly="readonly" id="clmt_clm_pty_abbr_nm" /><input type="text" name="clmt_clm_pty_nm" maxlength="200" style="width: 269px;" value="" readonly="readonly" class="input2" id="clmt_clm_pty_nm" /><input type="hidden" name="clmt_clm_pty_no" id="clmt_clm_pty_no" />  </td>
								<td><button class="btn_etc" type="button" name="btn1_Style" id="btn1_Style">Style</button></td>
								<th>Type</th>
								<td><input type="text" name="clmt_clm_tp_cd" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly" id="clmt_clm_tp_cd" /> </td>
								<th>Claimant Ref No.</th>
								<td><input type="text" name="clmt_ref_no" style="width: 192px" value="" class="input2" readonly="readonly" id="clmt_ref_no" /> </td>
							</tr>
						</table>
					</div>
				</div>
				<!-- wrap_search_tab(E) -->
			</div>
		<!--Content-->
		</div>
     <!-- layout_vertical_2(E) -->
     <div class="line_bluedot"></div>
     <!-- wrap_search_tab(S) -->
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="45" />				
					<col width="127" />				
					<col width="100" />				
					<col width="250" />				
					<col width="52" />				
					<col width="135" />				
					<col width="100" />				
					<col width="*" />				
			   </colgroup>
				<tr>
					<th>&nbsp;&nbsp;DON</th>
					<td><input type="text" name="prlm_clm_ntc_dt" dataformat="ymd" maxlength="8" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly" id="prlm_clm_ntc_dt" /> </td>
					<th><span title="Received Office">ROFC</span>/<span title="Date of Formal Claim">DOF</span></th>
					<td><input type="text" name="fmal_clm_rcv_ofc_cd" style="width: 59px;text-align:center" dataformat="engup" value="" class="input2" readonly="readonly" id="fmal_clm_rcv_ofc_cd" />/ <input type="text" name="fmal_clm_rcv_dt" dataformat="ymd" maxlength="8" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="fmal_clm_rcv_dt" /> </td>
					<th>Insurer</th>
					<td><input type="text" name="insur_clm_pty_abbr_nm" style="width: 80px;text-align:center" maxlength="10" dataformat="engup" value="" class="input2" readonly="readonly" caption="Insurer" id="insur_clm_pty_abbr_nm" />  <input type="hidden" name="insur_clm_pty_no" value="" id="insur_clm_pty_no" />  </td>
					<th>Insurer Ref No.</th>
					<td><input type="text" name="insur_ref_no" style="width: 182px;text-align:center" maxlength="20" value="" class="input2" readonly="readonly" id="insur_ref_no" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="45">				
					<col width="127">				
					<col width="100">				
					<col width="1">				
					<col width="1">				
					<col width="67">				
					<col width="25">				
					<col width="99">				
					<col width="34">				
					<col width="90">				
					<col width="145">				
					<col width="*">				
			   </colgroup>
				<tr>
					<th>&nbsp;&nbsp;TOC</th>
					<td><input type="text" name="cgo_clm_tp_cd" style="width: 75px;text-align:center" dataformat="engup" value="" maxlength="3" class="input2" readonly="readonly" caption="TOC" id="cgo_clm_tp_cd" />  </td>
					<th title="Cause of Damage or Loss">CODL 1</th>
					<td><input type="text" name="mjr_clm_dmg_lss_cd" style="width: 50px;text-align:center" dataformat="engup" value="" maxlength="2" class="input2" readonly="readonly" id="mjr_clm_dmg_lss_cd" />  </td>
					<th title="Cause of Damage / Loss">2</th>
					<td><input type="text" name="minr_clm_dmg_lss_cd" style="width: 50px;text-align:center" dataformat="engup" value="" maxlength="3" class="input2" readonly="readonly" id="minr_clm_dmg_lss_cd" />  </td>
					<th title="Place of Incident">POI</th>
					<td><input type="text" name="inci_plc_tp_cd" style="width: 35px;text-align:center" dataformat="engup" value="" maxlength="3" class="input2" readonly="readonly" id="inci_plc_tp_cd" />  </td>
					<th title="Date of Incident">DOI</th>
					<td><input type="text" name="inci_occr_dt" dataformat="ymd" maxlength="8" style="width: 80px; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly" id="inci_occr_dt" /> </td>
					<th>Cargo</th>
					<td><input type="text" name="clm_cgo_tp_cd" style="width: 34px;text-align:center" dataformat="engup" value="" class="input2" readonly="readonly" caption="Cargo" id="clm_cgo_tp_cd" /><input type="text" name="cgo_qlty_desc" style="width: 212px;" value="" class="input2" readonly="readonly" caption="Cargo Description" id="cgo_qlty_desc" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="45" />				
					<col width="127" />				
					<col width="100" />				
					<col width="262" />				
					<col width="40" />				
					<col width="*" />				
			   </colgroup>
				<tr>
					<th>&nbsp;&nbsp;Lane</th>
					<td><input type="text" name="slan_cd" style="width: 75px;text-align:center" dataformat="engup" value="" maxlength="3" class="input2" readonly="readonly" caption="Lane" id="slan_cd" /> </td>
					<th>Claim Amount</th>
					<td><input type="text" name="clmt_locl_amt" dataformat="float" style="width: 165px; text-align: right" value="" class="input2" readonly="readonly" id="clmt_locl_amt" /><input type="text" name="clmt_locl_curr_cd" dataformat="engup" maxlength="3" style="width: 35px; text-align:center" value="" class="input2" readonly="readonly" id="clmt_locl_curr_cd" />  </td>
					<th title="Rate of Exchange">R.O.E</th>
					<td><input type="text" name="clmt_locl_xch_rt" dataformat="float" style="width: 60px; text-align: right" value="" class="input2" readonly="readonly" id="clmt_locl_xch_rt" /><input type="text" name="clmt_usd_amt" dataformat="float" style="width: 142px; text-align: right" value="" class="input2" readonly="readonly" id="clmt_usd_amt" />  USD</td>
				</tr>
			</table>
		</div>
	</div>
		</div>
<!-- wrap_search_tab(E) -->
     
</div>
<!--Tab 1 (E)-->
<!--Tab 2 (S)-->

<div class="wrap_result">
<div id="tabLayer1" style="display: none">
	<!-- wrap_search_tab(S) -->
	
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="75" />				
					<col width="483" />				
					<col width="65" />				
					<col width="212" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>CNTR No.</th>
					<td><input type="text" name="cgo_clm_ref_cntr_no" style="width: 395px;" value="" class="input2" readonly="readonly" id="cgo_clm_ref_cntr_no" /> </td>
					<th>O.FRT</th>
					<td><input type="text" name="clm_ofrt_amt" dataformat="float" style="width: 140px; text-align: right" value="" readonly="readonly" class="input2" id="clm_ofrt_amt" /> </td>
					<td><b>USD /</b>  <input type="text" name="clm_ofrt_term_cd" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly" id="clm_ofrt_term_cd" />  <input type="text" name="clm_ofrt_flg" style="width: 26px;text-align:center" value="" class="input2" readonly="readonly" id="clm_ofrt_flg" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="75" />				
					<col width="200" />				
					<col width="63" />				
					<col width="220" />				
					<col width="65" />				
					<col width="196" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th title="Place of Receipt/Date of Receipt">POR/DOR</th>
					<td><input type="text" name="por_cd" style="width: 45px;" value="" class="input2" readonly="readonly" id="por_cd" />/ <input type="text" name="rct_dt" dataformat="ymd" style="width:80px; text-align: center" value="" class="input2" readonly="readonly" id="rct_dt" /> </td>
					<th>POL/DOL</th>
					<td><input type="text" name="pol_cd" style="width: 46px;" value="" class="input2" readonly="readonly" id="pol_cd" />/ <input type="text" name="lodg_dt" dataformat="ymd" style="width: 75px; text-align:center" value="" class="input2" readonly="readonly" id="lodg_dt" /> </td>
					<th>POD/DOD</th>
					<td><input type="text" name="pod_cd" style="width: 45px;text-align:center" value="" class="input2" readonly="readonly" id="pod_cd" />/ <input type="text" name="dchg_dt" dataformat="ymd" style="width: 80px;text-align: center" value="" class="input2" readonly="readonly" id="dchg_dt" /> </td>
					<td><b>DEL/DDL</b>&nbsp;&nbsp;<input type="text" name="del_cd" style="width: 45px;text-align:center" value="" class="input2" readonly="readonly" id="del_cd" />/ <input type="text" name="de_dt" dataformat="ymd" style="width: 80px;text-align: center" value="" class="input2" readonly="readonly" id="de_dt" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="75" />				
					<col width="90" />				
					<col width="15" />				
					<col width="95" />				
					<col width="63" />				
					<col width="220" />				
					<col width="65" />				
					<col width="90" />				
					<col width="16" />				
					<col width="133" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>Pre-VVD 1</th>
					<td><input type="text" style="width:80px;" name="n1st_pre_ref_vvd_no" value="" class="input2" readonly="readonly" id="n1st_pre_ref_vvd_no" /> </td>
					<th title="Cause of Damage / Loss">2</th>
					<td><input type="text" style="width: 80px;" name="n2nd_pre_ref_vvd_no" value="" class="input2" readonly="readOnly" id="n2nd_pre_ref_vvd_no" /> </td>
					<th>3</th>
					<td><input type="text" style="width: 80px;" name="n3rd_pre_ref_vvd_no" value="" class="input2" readonly="readonly" id="n3rd_pre_ref_vvd_no" /> </td>
					<th>On-VVD 1</th>
					<td><input type="text" name="n1st_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly" id="n1st_pst_ref_vvd_no" /> </td>
					<th title="Cause of Damage / Loss">2</th>
					<td><input type="text" name="n2nd_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly" id="n2nd_pst_ref_vvd_no" /> </td>
					<td><b>3</b>&nbsp;&nbsp;<input type="text" name="n3rd_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly" id="n3rd_pst_ref_vvd_no" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="75" />				
					<col width="182" />				
					<col width="81" />				
					<col width="221" />				
					<col width="64" />				
					<col width="195" />				
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>Pre-POT 1</th>
					<td><input type="text" name="n1st_pre_ts_loc_cd" style="width: 45px;" value="" class="input2" readonly="readonly" id="n1st_pre_ts_loc_cd" />/ <input type="text" name="n1st_pre_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="n1st_pre_ts_dt" /> </td>
					<th>Pre-POT 2</th>
					<td><input type="text" name="n2nd_pre_ts_loc_cd" style="width:46px;" value="" class="input2" readonly="readonly" id="n2nd_pre_ts_loc_cd" />/ <input type="text" name="n2nd_pre_ts_dt" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="n2nd_pre_ts_dt" /> </td>
					<th>On-POT1</th>
					<td><input type="text" name="n1st_pst_ts_loc_cd" style="width: 45px;" value="" class="input2" readonly="readonly" id="n1st_pst_ts_loc_cd" />/ <input type="text" name="n1st_pst_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="n1st_pst_ts_dt" /> </td>
					<td><b>On-POT2</b>&nbsp;&nbsp;<input type="text" name="n2nd_pst_ts_loc_cd" style="width: 45px;" value="" class="input2" readonly="readonly" id="n2nd_pst_ts_loc_cd" />/ <input type="text" name="n2nd_pst_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="n2nd_pst_ts_dt" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="75" />				
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>Surveyor</th>
					<td><input type="hidden" name="svey_clm_pty_no" value="" id="svey_clm_pty_no" /><input type="text" style="width: 399px;" name="svey_clm_pty_abbr_nm" value="" class="input2" readonly="readonly" id="svey_clm_pty_abbr_nm" /><input type="text" name="svyr_tp_cd" style="width: 25px;" value="" class="input2" readonly="readonly" id="svyr_tp_cd" /></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="75" />				
					<col width="482" />				
					<col width="65" />				
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>Liable Party</th>
					<td><input type="hidden" name="labl_clm_pty_no" value="" id="labl_clm_pty_no" /><input type="text" name="labl_clm_pty_abbr_nm" style="width: 397px;" value="" class="input2" readonly="readonly" id="labl_clm_pty_abbr_nm" /> </td>
					<th title="LP Date of Formal Claim">LP DOF</th>
					<td><input type="text" name="labl_pty_fmal_clm_dt" dataformat="ymd" style="width: 80px; text-align:center" value="" class="input2" readonly="readonly" id="labl_pty_fmal_clm_dt" /><input type="text" name="labl_pty_dmnd_usd_amt" dataformat="float" caption="LP DOF" style="width: 140px;text-align:right" value="" class="input2" readonly="readonly" id="labl_pty_dmnd_usd_amt" />  <b>USD</b></td>
				</tr>
			</table>
		</div>
	</div>
<!-- wrap_search_tab(E) -->
</div>
<!--Tab 2 (E)-->
<!--Tab 3 (S)-->
<div id="tabLayer1" style="display: none">
	<!-- wrap_search_tab(S) -->
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="140" />				
					<col width="716" />				
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>Plaintiff</th>
					<td><input type="text" name="plt_nm" style="width: 587px;" value="" class="input2" readonly="readonly" id="plt_nm" /> </td>
					<td><b>LT Updated</b> <input type="text" name="ligt_upd_dt" dataformat="ymd" style="width:80px;text-align:center" value="" class="input2" readonly="readonly" id="ligt_upd_dt" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="140" />				
					<col width="719" />				
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>Defendant</th>
					<td><input type="text" name="deft_nm" style="width: 587px;" value="" class="input2" readonly="readonly" id="deft_nm" /> </td>
					<td><b>LT Updater</b> <input type="text" name="ligt_upd_usr_id" style="width: 80px; text-align:center" value="" class="input2" readonly="readonly" id="ligt_upd_usr_id" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="140" />				
					<col width="595" />				
					<col width="100" />				
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>Def. Attorney</th>
					<td><input type="hidden" name="deft_atty_clm_pty_no" value="" id="deft_atty_clm_pty_no" /><input type="text" name="deft_atty_clm_pty_abbr_nm" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="deft_atty_clm_pty_abbr_nm" /><input type="text" name="deft_atty_clm_pty_nm" style="width: 503px;" value="" class="input2" readonly="readonly" id="deft_atty_clm_pty_nm" /></td>
					<td><button class="btn_etc" type="button" name="btn3_Style" id="btn3_Style">Style</button></td>
					<td align="right">&nbsp;</td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="140" />				
					<col width="282" />				
					<col width="153" />				
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>Appointed Date</th>
					<td><input name="deft_atty_apnt_dt" type="text" dataformat="ymd" maxlength="8" style="width: 80px; text-align:center" value="" class="input2" readonly="readonly" id="deft_atty_apnt_dt" /> </td>
					<th>Def. Attorney's Ref No.</th>
					<td><input type="text" name="ref_deft_atty_no" style="width: 152px;" value="" class="input2" readonly="readonly" id="ref_deft_atty_no" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="140" />				
					<col width="282" />				
					<col width="153" />				
					<col width="180" />				
					<col width="*" />				
		   		</colgroup>
				<tr>
					<th>Court</th>
					<td><input type="text" name="crt_nm" style="width: 230px;" value="" class="input2" readonly="readonly" id="crt_nm" /> </td>
					<th>Case No.</th>
					<td><input type="text" name="crt_cs_no" style="width: 152px;" value="" class="input2" readonly="readonly" id="crt_cs_no" /> </td>
					<td><b>Filed Date</b> <input name="cpln_file_dt" type="text" dataformat="ymd" maxlength="8" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="cpln_file_dt" /> </td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="140" />				
					<col width="*" />				
		   		</colgroup>
				<tr class="h23">
					<th>Final Judgment / Date</th>
					<td><input type="text" name="jmt_rslt_nm" style="width: 120px;" value="" class="input2" readonly="readonly" id="jmt_rslt_nm" />/ <input name="jmt_rslt_dt" type="text" dataformat="ymd" maxlength="8" style="width: 77px;text-align:center" value="" class="input2" readonly="readonly" id="jmt_rslt_dt" /> </td>
				</tr>
			</table>
		</div>
	</div>
</div>	
<!--Tab 3 (E)-->

<!-- wrap_search(E) -->  
	<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript"> ComTabObject ('tab2')</script>
</div>
</div>
<!-- opus_tab_btn(E) -->

<div id="tabLayer2" style="display: inline">
	<!-- wrap_search_tab(S) -->
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<textarea name="clm_cuz_desc" id="clm_cuz_desc" style="width: 100%" rows="8" class="textarea2"  caption="Cause of Claim" readonly="readonly"></textarea>
		</div>
	</div>
	<!-- wrap_search_tab(E) -->
</div>
<div id="tabLayer2" style="display: none">
	<!-- wrap_search_tab(S) -->
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<textarea style="width: 100%" rows="8" class="textarea2" name="fact_fnd_desc" id="fact_fnd_desc"  caption="Fact Findings & Assessment" readonly="readonly"></textarea>
		</div>
	</div>
	<!-- wrap_search_tab(E) -->
</div>
<div id="tabLayer2" style="display: none">
	<!-- wrap_search_tab(S) -->
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<textarea style="width: 100%" rows="8" class="textarea2"  caption="Main Issue Review & DV" name="clm_rvw_desc" id="clm_rvw_desc"  readonly="readonly"></textarea>
		</div>
	</div>
	<!-- wrap_search_tab(E) -->
</div>

<div id="tabLayer2" style="display: none;background-color:#f7f8fa;" >
	<!-- wrap_search_tab(S) -->
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="110" />				
					<col width="325" />				
					<col width="335" />				
					<col width="40" />				
					<col width="150" />				
					<col width="120" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>Claimant's Agent</th>
					<td><input type="hidden" name="clm_agn_clm_pty_no" value="" id="clm_agn_clm_pty_no" /><input type="text" name="clm_agn_clm_pty_abbr_nm" style="width: 60px;" dataformat="engup" value="" class="input2" readonly="readonly" id="clm_agn_clm_pty_abbr_nm" /><input type="text" name="clm_agn_clm_pty_nm" style="width: 249px;" value="" class="input2" readonly="readonly" id="clm_agn_clm_pty_nm" /></td>
					<td><button class="btn_etc" type="button" name="btn4_Style" id="btn4_Style">Style</button></td>
					<th>Type</th>
					<td><input type="text" name="clmt_agn_tp_cd" style="width: 50px;" value="" class="input2" readonly="readonly" id="clmt_agn_tp_cd" /> </td>
					<th>CA Appointed Date</th>
					<td><input type="text" name="clmt_agn_apnt_dt" dataformat="ymd" maxlength="8" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="clmt_agn_apnt_dt" /> </td>
				</tr>
			</table>
			
			<table>
				<colgroup>
					<col width="110" />				
					<col width="210" />				
					<col width="40" />				
					<col width="290" />				
					<col width="160" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>Tel.</th>
					<td><input type="text" name="clm_agn_intl_phn_no" style="width: 35px;" value="" class="input2" readonly="readonly" id="clm_agn_intl_phn_no" /><input type="text" name="clm_agn_phn_no" style="width: 160px;" value="" class="input2" readonly="readonly" id="clm_agn_phn_no" /> </td>
					<th>E-Mail</th>
					<td><input type="text" name="clm_agn_pty_eml" style="width: 236px;" value="" class="input2" readonly="readonly" id="clm_agn_pty_eml" /> </td>
					<th>Claimant's Agent Ref No.</th>
					<td><input type="text" name="clmt_agn_ref_no" style="width: 100%;" value="" class="input2" readonly="readonly" id="clmt_agn_ref_no" /> </td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="tabLayer2" style="display: none">
	<!-- wrap_search_tab(S) -->
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="110" />				
					<col width="325" />				
					<col width="335" />				
					<col width="40" />				
					<col width="150" />				
					<col width="120" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>Insurer's Agent</th>
					<td><input type="hidden" name="insur_agn_clm_pty_no" value="" id="insur_agn_clm_pty_no" /><input type="text" name="insur_agn_clm_pty_abbr_nm" style="width: 60px;" dataformat="engup" value="" class="input2" readonly="readonly" id="insur_agn_clm_pty_abbr_nm" /><input type="text" name="insur_agn_clm_pty_nm" style="width: 249px;" value="" class="input2" readonly="readonly" id="insur_agn_clm_pty_nm" /> </td>
					<td><button class="btn_etc" type="button" name="btn5_Style" id="btn5_Style">Style</button></td>
					<th>Type</th>
					<td><input type="text" name="agn_crspn_tp_cd" id="agn_crspn_tp_cd" style="width: 50px;" value=""	class="input2" readonly="readonly"> </td>
					<th>IA Appointed Date</th>
					<td><input type="text" name="agn_crspn_apnt_dt" dataformat="ymd" maxlength="8" style="width:80px;text-align:center" value="" class="input2" readonly="readonly" id="agn_crspn_apnt_dt" /> </td>
				</tr>
			</table>
			
			<table>
				<colgroup>
					<col width="110" />				
					<col width="210" />				
					<col width="40" />				
					<col width="290" />				
					<col width="160" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>Tel.</th>
					<td><input type="text" name="insur_agn_intl_phn_no" style="width: 35px;" value="" class="input2" readonly="readonly" id="insur_agn_intl_phn_no" /><input type="text" name="insur_agn_phn_no" style="width: 160px;" value="" class="input2" readonly="readonly" id="insur_agn_phn_no" /> </td>
					<th>E-Mail</th>
					<td><input type="text" name="insur_agn_pty_eml" style="width: 236px;" value="" class="input2" readonly="readonly" id="insur_agn_pty_eml" /> </td>
					<th>Insurer's Agent Ref No.</th>
					<td><input type="text" name="agn_crspn_ref_no" style="width: 100%;" value="" class="input2" readonly="readonly" id="agn_crspn_ref_no" /> </td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="tabLayer2" style="display: none">
	<!-- wrap_search_tab(S) -->
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<textarea name="ltgt_cs_desc" id="ltgt_cs_desc" style="width: 100%"  caption="Case Summary & DV" rows="9" class="textarea2" readonly="readonly"></textarea>
		</div>
	</div>
	<!-- wrap_search_tab(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
