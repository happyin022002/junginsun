<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : CPS_CNI_0003.jsp
*@FileTitle  : Claim Main 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%
    Exception serverException = null;
    String strErrMsg = "";

    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    String roles = "";
    String area = "";
    
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    
    String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no" , "");
    
    String xml = "";
    String popupYn = ""; 
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
        
        xml = HttpUtil.makeXML(request,response);  
        
        //세션에 Claim No가 존재하면
        String ssCgoClmNo =  eventResponse.getETCData("CGO_CLM_NO");
        if ( cgoClmNo.equals("") && !ssCgoClmNo.equals("")) {
        	cgoClmNo = ssCgoClmNo;
        }
 
        // ----------------------------------------------------------------
        // 해당 초기 파라미터 설정
        // ----------------------------------------------------------------
        popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
        
    } catch (Exception e) {
        out.println(e.toString());
    }
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
  
%>
<script type="text/javascript">
    function setupPage(){ 
    	var errMessage = "<%=strErrMsg.replace("\"","'")%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
	    loadPage();
    }
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ofc_cd" value="<%=userOffice%>" id="ofc_cd" readonly="readonly"/>
<input type="hidden" name="trns_seq" value="" id="trns_seq" />
<input type="hidden" name="bfr_cgo_clm_sts_cd" value="" id="bfr_cgo_clm_sts_cd" />
<input type="hidden" name="cgo_clm_clz_cd" value="" id="cgo_clm_clz_cd" />
<input type="hidden" name="pre_cgo_clm_clz_cd" value="" id="pre_cgo_clm_clz_cd" />
<input type="hidden" name="mn_bl_flg" value="" id="mn_bl_flg" />
<input type="hidden" name="clss_clm_misc_cd" id="clss_clm_misc_cd" />
<input type="hidden" name="clm_misc_cd" id="clm_misc_cd" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" readonly="readonly"/>
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" readonly="readonly"/>
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" readonly="readonly"/>
<input type="hidden" name="usr_office" value="<%=userOffice%>" id="usr_office" readonly="readonly"/>
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
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Retrieve" 	id="btn1_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn1_New" 		id="btn1_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn1_Save" 		id="btn1_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn1_Cancel" 		id="btn1_Cancel">Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn1_Payment" 		id="btn1_Payment">Payment</button><!--
		--><button type="button" class="btn_normal" name="btn1_Handling_Costs"  		id="btn1_Handling_Costs">Handling Costs</button>	
	</div>
	<!-- opus_design_btn(E) -->
<% if (!"Y".equals(popupYn)) {%>	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
<% } %>	
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Claim No.</th>
					<td><input type="text" name="cgo_clm_no" dataformat="engup" maxlength="10" style="width: 85px; ime-mode: disabled" value="<%=cgoClmNo%>" fullfill="" caption="Claim No." id="cgo_clm_no" /><input type="text" name="clm_area_cd" style="width: 20px;" value="" class="input2" readonly="readonly" id="clm_area_cd" /> </td>
					<th title="Handling Office">HOFC</th>
					<td><input type="text" name="hdlr_ofc_cd" style="width: 60px;text-align:center" value="<%=userOffice%>" class="input2" readonly="readonly" id="hdlr_ofc_cd" /> </td>
					<th>Handler</th>
					<td><input type="text" name="hdlr_usr_id" style="width: 75px;text-align:center" value="<%=userId%>" class="input2" readonly="readonly" id="hdlr_usr_id" /><button type="button" id="btns_hanlder_history" name="btns_hanlder_history" class="input_seach_btn"></button></td>
					<th title="Date Of Updated">DOU</th>
					<td><input type="text" name="upd_dt" dataformat="ymd" style="width: 75px;text-align:center" value="" class="input2" readonly="readonly" id="upd_dt" /> </td>
					<th>Incident No.</th>
					<td><input type="text" name="cgo_clm_inci_no" dataformat="engup" fullfill="" caption="Incident No." maxlength="13" style="width: 115px;" value="" id="cgo_clm_inci_no" /> </td>
					<th>VOC No.</th>
					<td><input type="text" name="crm_voc_no" dataformat="engup" maxlength="15" style="width: 100px;%;" value="" id="crm_voc_no" /> </td>
				</tr>	
				<tr>
					<th>Status</th>
					<td><input type="hidden" name="cgo_clm_sts_cd" id="cgo_clm_sts_cd" /><input type="text" name="cgo_clm_sts_nm" style="width: 110px;text-align:center" value="" class="input2" readonly="readonly" id="cgo_clm_sts_nm" /> </td>
					<th><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></th>
					<td><input type="text" name="hpd" style="width: 40px;text-align:center" value="" class="input2" readonly="readonly" id="hpd" /><b>/</b>&nbsp;<input type="text" name="nhp" style="width: 40px;text-align:center" value="" class="input2" readonly="readonly" id="nhp" /> </td>
					<th title="Type Of Settlement">TOS</th>
					<td><input type="text" name="cgo_clm_stl_tp_cd" style="width: 44px;text-align:center" value="" class="input2" readonly="readonly" id="cgo_clm_stl_tp_cd" /> </td>
					<th title="Date Of Close">DOC</th>
					<td  title="Date Of Time Barred" colspan="3"><input type="text" name="cs_clz_dt" dataformat="ymd" maxlength="10" class="input2" readonly="readonly" style="width: 75px; text-align: center; ime-mode: disabled" value="" id="cs_clz_dt" /><button type="button" class="btn_etc" name="btns_TB_Date" 	id="btns_TB_Date">DOTB</button><input type="text" name="clm_tm_bar_dt" dataformat="ymd" maxlength="10" style="width: 75px; text-align: center; ime-mode: disabled" value="" id="clm_tm_bar_dt" /><button type="button" id="btns_clm_tm_bar_dt" name="btns_clm_tm_bar_dt" class="calendar ir"></button></td>
					<th>Summons Served Date</th>
					<td><input name="smns_sve_dt" type="text" dataformat="ymd" maxlength="10" style="width: 75px; text-align: center; ime-mode: disabled" value="" id="smns_sve_dt" /><button type="button" id="btns_smns_sve_dt" name="btns_smns_sve_dt" class="calendar ir"></button></td>
				</tr>
				<tr class="line_bluedot"><td colspan="12"></td></tr>
				<tr>
					<th title="Date Of Acknowledgement" colspan="3">DOACK</th>
					<td><input type="text" name="cgo_clm_acknak_dt" dataformat="ymd" maxlength="10" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input" id="cgo_clm_acknak_dt" /><button type="button" id="btns_cgo_clm_acknak_dt" name="btns_cgo_clm_acknak_dt" class="calendar ir"></button></td>
					<th title="Date Of Fact Finding">DOFF</th>
					<td><input name="fact_fnd_dt" type="text" dataformat="ymd" maxlength="10" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input" id="fact_fnd_dt" /><button type="button" id="btns_fact_fnd_dt" name="btns_fact_fnd_dt" class="calendar ir"></button></td>
					<th title="LP Time Barred Date">LP DOTB</th>
					<td><input type="text" name="labl_tm_bar_dt" style="width: 75px;" value="" class="input2" readonly="readonly" id="labl_tm_bar_dt" /> </td>						
					<td colspan="2"><b>Transfer</b><input type="checkbox" name="trns_flg" value="Y" class="trans" id="trns_flg" /><input type="text" name="clm_trns_auth_cd" readonly="readonly" style="width: 30px;" value="" class="input2" id="clm_trns_auth_cd" /> </td>
					<th>Reopen</th>
					<td><input name="cs_clz_ropn_dt" dataformat="ymd" maxlength="10" type="text" readonly="readonly" class="input2" style="width: 75px; text-align: center; ime-mode: disabled" value="" id="cs_clz_ropn_dt" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab ">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer1" name="tabLayer1" style="display: inline">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="150"/>
						<col width="40"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="60"/>
						<col width="60"/>
						<col width="80"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<td class="sm pad_left_8"><input name="cgo_clm_div_cd" id="cgo_clm_div_cd" type="radio" value="G" class="trans" checked>&nbsp;&nbsp;GEN</td>
						<th>B/L No.</th>
						<td><input type="text" dataformat="engup" name="cgo_clm_ref_bl_no" required="" caption="B/L No." tabidx="0" style="width: 100px; text-align:center" maxlength="12" value="" class="input1" id="cgo_clm_ref_bl_no" /><!--
							--><button type="button" class="btn_etc" name="btns_BL_Get" 	id="btns_BL_Get">Get</button><!--
							--><button type="button" class="btn_etc" name="btns_BL_Preview" 	id="btns_BL_Preview">View</button></td>
						<th title="Date of Loading">DOL</th>
						<td><input type="text" name="lodg_dt" dataformat="ymd" maxlength="10" style="width: 75px;text-align:center" value="" class="input" id="lodg_dt" /><button type="button" id="btns_lodg_dt" name="btns_lodg_dt" class="calendar ir"></button></td>
						<th><span title="Place of Delivery">DEL</span>/<span title="Date of Delivery">DDL</span></th>
						<td><input type="text" name="del_cd" dataformat="engup" maxlength="5" style="width: 50px;text-align:center" value="" class="input1" caption="Place of Delivery" required="" tabidx="0" id="del_cd" />&nbsp;/&nbsp;<input type="text" name="de_dt" dataformat="ymd" maxlength="10" style="width: 75px;ime-mode:disabled" value="" class="input" id="de_dt" /><button type="button" id="btns_de_dt" name="btns_de_dt" class="calendar ir"></button></td>
						<th>Term</th>
						<td><script type="text/javascript">ComComboObject("crr_term_cd", 2, 47, 1,1);</script></td>
						<th>Surveyed Date</th>
						<td><input type="text" style="width: 75px;text-align:center;" name="svey_inp_dt" dataformat="ymd" maxlength="10" value="" class="input" id="svey_inp_dt" /><button type="button" id="btns_svey_inp_dt" name="btns_svey_inp_dt" class="calendar ir"></button></td>
					</tr>	

					<tr>
						<td class="sm pad_left_8"><input name="cgo_clm_div_cd" id="cgo_clm_div_cd" type="radio" value="I" class="trans" >&nbsp;&nbsp;INC</td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td colspan="4"><input type="text" name="trnk_ref_vvd_no" maxlength="20" dataformat="engup" style="width: 80px;text-align:center" value="" class="input1" required="" caption="VVD" tabidx="0" id="trnk_ref_vvd_no" /><button type="button" id="btns_vvd" name="btns_vvd" class="input_seach_btn"></button><input type="text" name="vsl_eng_nm" style="width: 193px;" value="" class="input2" readonly="readonly" id="vsl_eng_nm" /><!--
						--><input type="text" name="insur_vsl_tp_cd" style="width: 100px;" value="" class="input2" readonly="readonly" id="insur_vsl_tp_cd" /><!--
						--><input type="text" name="insur_vsl_oshp_cd" style="width: 50px;" value="" class="input2" readonly="readonly" id="insur_vsl_oshp_cd" /> </td>
						<th>C/P &amp; Dated</th>
						<td colspan="4"><input type="text" name="cp_desc" style="width: 350px;" maxlength="500" value="" class="input" id="cp_desc" /> </td>
					</tr>
					<tr>
						<td class="sm pad_left_8"><input name="cgo_clm_div_cd" id="cgo_clm_div_cd" type="radio" value="O" class="trans">&nbsp;&nbsp;OTH</td>
						<th>Claimant</th>
						<td colspan="4"><input type="text" name="clmt_clm_pty_abbr_nm" maxlength="8" dataformat="engup" style="width: 80px;text-align:center" value="" class="input1" required="" caption="Claimant" readonly="readonly" id="clmt_clm_pty_abbr_nm" /><button type="button" id="btn1_Claimant" name="btn1_Claimant" class="input_seach_btn"></button><input type="text" name="clmt_clm_pty_nm" maxlength="200" style="width: 298px;" value="" class="input" id="clmt_clm_pty_nm" /><input type="hidden" name="clmt_clm_pty_no" id="clmt_clm_pty_no" /><!--
							--><button type="button" class="btn_etc" name="btn1_Style" 	id="btn1_Style">Style</button></td>
						<th>Type</th>
						<td><script type="text/javascript">ComComboObject("clmt_clm_tp_cd", 2, 47, 1,1);</script></td>
						<th>Claimant Ref No.</th>
						<td colspan="2"><input type="text" name="clmt_ref_no" style="width: 192px;" maxlength="20" value="" class="input" id="clmt_ref_no" /> </td>
					</tr>	
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="60"/>
						<col width="80"/>
						<col width="60"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th title="Date of Preliminary Notice">DON</th>
						<td colspan="2"><input type="text" name="prlm_clm_ntc_dt" dataformat="ymd" maxlength="10" required="" caption="DON" style="width: 75px; text-align: center; ime-mode: disabled" value="" class="input1" tabidx="0" id="prlm_clm_ntc_dt" /><button type="button" id="btns_prlm_clm_ntc_dt" name="btns_prlm_clm_ntc_dt" class="calendar ir"></button></td>
						<th><span title="Received Office">ROFC</span>/<span title="Date of Formal Claim">DOF</span></th>
						<td colspan="3"><input type="text" name="fmal_clm_rcv_ofc_cd" style="width: 59px;text-align:center" dataformat="engup" value="" class="input2" readonly="readonly" caption="ROFC" maxlength="6" id="fmal_clm_rcv_ofc_cd" /><!--
						--><button type="button" id="btns_ofc_cd" name="btns_ofc_cd" class="input_seach_btn"></button>/&nbsp;<input type="text" name="fmal_clm_rcv_dt" dataformat="ymd" maxlength="10" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" caption="DOF" id="fmal_clm_rcv_dt" /><button type="button" id="btns_fmal_clm_rcv_dt" name="btns_fmal_clm_rcv_dt" class="calendar ir" disabled></button></td>
						<td><div id="div_btn2" style="display:none;width:20px;padding:0px;margin:0px;"><button type="button" id="btns_fmal_clm_rcv_dt" name="btns_fmal_clm_rcv_dt" class="calendar ir"></button></div></td>
						<th>Insurer</th>
						<td><input type="text" name="insur_clm_pty_abbr_nm" style="width: 80px;text-align:center" maxlength="10" dataformat="engup" value="" class="input1" required="" caption="Insurer" tabidx="0" readonly="readonly" id="insur_clm_pty_abbr_nm" /><button type="button" id="btn1_Insurer" name="btn1_Insurer" class="input_seach_btn"></button><input type="hidden" name="insur_clm_pty_no" value="" id="insur_clm_pty_no" /> </td>
						<th>Insurer Ref No.</th>
						<td colspan="4"><input type="text" name="insur_ref_no" style="width: 223px;text-align:left" maxlength="20" value="" class="input" id="insur_ref_no" /> </td>	
					</tr>	
					<tr>
						<th title="Type of Cargo Claim">TOC</th>
						<td><script type="text/javascript">ComComboObject("cgo_clm_tp_cd", 2, 75, 1,1);</script></td>
						<th title="Cause of Damage / Loss">CODL 1</th>
						<td><script type="text/javascript">ComComboObject("mjr_clm_dmg_lss_cd", 2, 80, 1);</script></td>
						<th title="Cause of Damage / Loss">2</th>
						<td><script type="text/javascript">ComComboObject("minr_clm_dmg_lss_cd", 2, 80, 1);</script></td>
						<th title="Place of Incident">POI</th>
						<td><script type="text/javascript">ComComboObject("inci_plc_tp_cd", 2, 80, 1,1);</script></td>
						<th title="Date of Incident">DOI</th>
						<td><input type="text" name="inci_occr_dt" dataformat="ymd" maxlength="10" style="width: 80px; text-align: center; ime-mode: disabled" value="" class="input" id="inci_occr_dt" /><button type="button" id="btns_inci_occr_dt" name="btns_inci_occr_dt" class="calendar ir"></button></td>
						<th>Cargo</th>
						<td><input type="text" name="clm_cgo_tp_cd" style="width: 34px;text-align:center" dataformat="engup" value="" class="input1" required="" caption="Cargo" tabidx="0" readonly="readonly" id="clm_cgo_tp_cd" /><button type="button" id="btn1_Cargo" name="btn1_Cargo" class="input_seach_btn"></button><input type="text" name="cgo_qlty_desc" style="width: 156px;" value="" class="input1" required="" caption="Cargo Description" tabidx="0" id="cgo_qlty_desc" /> </td>
					</tr>	
					<tr>
						<th>Lane</th>
						<td><input type="text" name="slan_cd" id="slan_cd" style="width: 75px;text-align:center" dataformat="engup" value="" maxlength="3" class="input1" required="" caption="Lane" tabidx="0"  /> </td>
						<th>Claim Amount</th>
						<td colspan="5"><input type="text" name="clmt_locl_amt" dataformat="float" style="width: 180px; text-align: right" value="" class="input" id="clmt_locl_amt" /><input type="text" name="clmt_locl_curr_cd" dataformat="engup" maxlength="3" style="width: 35px; text-align:center" value="" class="input" id="clmt_locl_curr_cd" /><button type="button" id="btns_currency" name="btns_currency" class="input_seach_btn"></button></td>
						<th title="Rate of Exchange">R.O.E</th>
						<td colspan="3"><input type="text" name="clmt_locl_xch_rt" dataformat="float" style="width: 80px; text-align: right" value="" class="input" id="clmt_locl_xch_rt" /><button type="button" id="btns_roe" name="btns_roe" class="input_seach_btn"></button><input type="text" name="clmt_usd_amt" dataformat="float" style="width: 142px; text-align: right" value="" class="input2" readonly="readonly" id="clmt_usd_amt" /> USD</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="tabLayer1"  name="tabLayer1" style="display: none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="*"/>						
					</colgroup>
					<tr>
						<th>CNTR No.</th>
						<td colspan="3"><input type="text" name="cgo_clm_ref_cntr_no" style="width: 387px;" value="" class="input2" readonly="readonly" id="cgo_clm_ref_cntr_no" /> </td>
						<th>O.FRT</th>
						<td><input type="text" name="clm_ofrt_amt" dataformat="float" style="width: 140px; text-align: right" value="" readonly="readonly" class="input2" id="clm_ofrt_amt" /> </td>
						<th>USD /</th>
						<td><input type="text" name="clm_ofrt_term_cd" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly" id="clm_ofrt_term_cd" /><input type="text" name="clm_ofrt_flg" style="width: 26px;text-align:center" value="" class="input2" readonly="readonly" id="clm_ofrt_flg" /> </td>
					</tr>
					<tr>
						<th title="Place of Receipt/Date of Receipt">POR/DOR</th>
						<td><input type="text" name="por_cd" style="width: 45px;" value="" class="input2" readonly="readonly" id="por_cd" /><b>/</b>&nbsp;<input type="text" name="rct_dt" dataformat="ymd" style="width:80px; text-align: center" value="" class="input2" readonly="readonly" id="rct_dt" /> </td>
						<th>POL/DOL</th>
						<td><input type="text" name="pol_cd" style="width: 46px;" value="" class="input2" readonly="readonly" id="pol_cd" /><b>/</b>&nbsp;<input type="text" name="lodg_dt1" dataformat="ymd" style="width: 75px; text-align:center" value="" class="input2" readonly="readonly" id="lodg_dt1" /> </td>
						<th>POD/DOD</th>
						<td><input type="text" name="pod_cd" style="width: 45px;text-align:center" value="" class="input2" readonly="readonly" id="pod_cd" /><b>/</b>&nbsp;<input type="text" name="dchg_dt" dataformat="ymd" style="width: 80px;text-align: center" value="" class="input2" readonly="readonly" id="dchg_dt" /> </td>
						<th>DEL/DDL</th>
						<td><input type="text" name="del_cd1" style="width: 50px;text-align:center" value="" class="input2" readonly="readonly" id="del_cd1" /><b>/</b>&nbsp;<input type="text" name="de_dt1" dataformat="ymd" style="width: 80px;text-align: center" value="" class="input2" readonly="readonly" id="de_dt1" /> </td>
					</tr>
					<tr>
						<th>Pre-VVD 1</th>
						<td colspan="3"><input type="text" style="width:80px;" name="n1st_pre_ref_vvd_no" value="" class="input2" readonly="readonly" id="n1st_pre_ref_vvd_no" /><!--
						-->&nbsp;&nbsp;&nbsp;&nbsp;<b>2</b>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width: 80px;" name="n2nd_pre_ref_vvd_no" value="" class="input2" readonly="readOnly" id="n2nd_pre_ref_vvd_no" /><!--
						-->&nbsp;&nbsp;&nbsp;&nbsp;<b>3</b>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width: 80px;" name="n3rd_pre_ref_vvd_no" value="" class="input2" readonly="readonly" id="n3rd_pre_ref_vvd_no" /> </td>
						<th>On-VVD 1</th>
						<td colspan="3"><input type="text" name="n1st_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly" id="n1st_pst_ref_vvd_no" /><!--
						-->&nbsp;&nbsp;&nbsp;&nbsp;<b>2</b>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="n2nd_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly" id="n2nd_pst_ref_vvd_no" /><!--
						-->&nbsp;&nbsp;&nbsp;&nbsp;<b>3</b>&nbsp;&nbsp;&nbsp;<input type="text" name="n3rd_pst_ref_vvd_no" style="width: 80px;" value="" class="input2" readonly="readonly" id="n3rd_pst_ref_vvd_no" /> </td>
					</tr>
					<tr>
						<th>Pre-POT 1</th>
						<td><input type="text" name="n1st_pre_ts_loc_cd" style="width: 45px;" value="" class="input2" readonly="readonly" id="n1st_pre_ts_loc_cd" />/&nbsp;<input type="text" name="n1st_pre_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="n1st_pre_ts_dt" /> </td>
						<th>Pre-POT 2</th>
						<td><input type="text" name="n2nd_pre_ts_loc_cd" style="width:46px;" value="" class="input2" readonly="readonly" id="n2nd_pre_ts_loc_cd" />/&nbsp;<input type="text" name="n2nd_pre_ts_dt" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="n2nd_pre_ts_dt" /> </td>
						<th>On-POT1</th>
						<td><input type="text" name="n1st_pst_ts_loc_cd" style="width: 45px;" value="" class="input2" readonly="readonly" id="n1st_pst_ts_loc_cd" />/&nbsp;<input type="text" name="n1st_pst_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="n1st_pst_ts_dt" /> </td>
						<th>On-POT2</th>
						<td><input type="text" name="n2nd_pst_ts_loc_cd" style="width: 50px;" value="" class="input2" readonly="readonly" id="n2nd_pst_ts_loc_cd" />/&nbsp;<input type="text" name="n2nd_pst_ts_dt" dataformat="ymd" style="width: 80px;text-align:center" value="" class="input2" readonly="readonly" id="n2nd_pst_ts_dt" /> </td>
					</tr>
					<tr>
						<th>Surveyor</th>
						<td colspan="7">
							<input type="hidden" name="svey_clm_pty_no" value="" id="svey_clm_pty_no" /><input type="text" name="svey_clm_pty_abbr_nm" style="width: 387px;" value="" class="input2" readonly="readonly" id="svey_clm_pty_abbr_nm" /><input style="width: 25px;" value="" class="input2" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<th>Liable Party</th>
						<td colspan="3"><input type="hidden" name="labl_clm_pty_no" value="" id="labl_clm_pty_no" /><input type="text" name="labl_clm_pty_abbr_nm" style="width: 387px;" value="" class="input2" readonly="readonly" id="labl_clm_pty_abbr_nm" /></td>
						<th title="LP Date of Formal Claim">LP DOF</th>
						<td colspan="3"><input type="text" name="labl_pty_fmal_clm_dt" dataformat="ymd" style="width: 80px; text-align:center" value="" class="input2" readonly="readonly" id="labl_pty_fmal_clm_dt" /><input type="text" name="labl_pty_dmnd_usd_amt" dataformat="float" caption="LP DOF" style="width: 140px;text-align:right" value="" class="input2" readonly="readonly" id="labl_pty_dmnd_usd_amt" /><b>USD</b></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div id="tabLayer1" name="tabLayer1" style="display: none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="135"/>
						<col width="600"/>
						<col width="100"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Plaintiff</th>
						<td colspn="3"><input type="text" name="plt_nm" style="width: 587px;" value="" class="input" id="plt_nm" /><button type="button" class="btn_etc" name="btn3_FileUpload"  		id="btn3_FileUpload">File Upload</button></td>
					</tr>	
					<tr>
						<th>Defendant</th>
						<td><input type="text" name="deft_nm" style="width: 587px;" maxlength="200" value="" class="input" id="deft_nm" /> </td>
						<th>LT Updated</th>
						<td><input type="text" name="ligt_upd_dt" dataformat="ymd" style="width:80px;text-align:center" value="" class="input2" readonly="readOnly" id="ligt_upd_dt" /> </td>
					</tr>
					<tr>
						<th>Def. Attorney</th>
						<td><input type="hidden" name="deft_atty_clm_pty_no" value="" id="deft_atty_clm_pty_no" /><!--
							--><input type="text" name="deft_atty_clm_pty_abbr_nm" readonly="readonly" style="width: 80px;text-align:center" value="" class="input" id="deft_atty_clm_pty_abbr_nm" /><!--
							--><button type="button" id="btns_Attorney" name="btns_Attorney" class="input_seach_btn"></button><input type="text" name ="deft_atty_clm_pty_nm" id ="deft_atty_clm_pty_nm" style="width: 475px;" value="" class="input"><button type="button" id="btn3_Style" name="btn3_Style" class="btn_etc">Style</button></td>
						<th>LT Updater</th>
						<td><input type="text" name="ligt_upd_usr_id" style="width: 80px; text-align:center" value="" class="input2" readonly="readonly" id="ligt_upd_usr_id" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="135"/>
						<col width="100"/>
						<col width="150"/>
						<col width="210"/>
						<col width="185"/>
						<col width="*"/>
					</colgroup>		
					<tr>
						<th>Appointed Date</th>
						<td><input name="deft_atty_apnt_dt" type="text" dataformat="ymd" maxlength="10" style="width: 80px; text-align:center" value="" class="input" id="deft_atty_apnt_dt" /><button type="button" id="btns_deft_atty_apnt_dt" name="btns_deft_atty_apnt_dt" class="calendar ir"></button></td>
						<th>Def. Attorney's Ref No.</th>
						<td colspan="3"><input type="text" name="ref_deft_atty_no" style="width: 152px;" value="" class="input" id="ref_deft_atty_no" /> </td>
					</tr>
					<tr>
						<th>Court</th>
						<td><input type="text" name="crt_nm" style="width: 230px;" value="" class="input" id="crt_nm" /> </td>
						<th>Case No.</th>
						<td><input type="text" name="crt_cs_no" style="width: 152px;" value="" class="input" id="crt_cs_no" /> </td>
						<th>Filed Date</th>
						<td><input name="cpln_file_dt" type="text" dataformat="ymd" maxlength="10" style="width: 80px;text-align:center" value="" class="input" id="cpln_file_dt" /><button type="button" id="btns_cpln_file_dt" name="btns_cpln_file_dt" class="calendar ir"></button></td>
					</tr>
					<tr>
						<th>Final Judgment / Date /</th>
						<td colspan="5"><script type="text/javascript">ComComboObject("jmt_rslt_cd", 2, 47, 1);</script>/&nbsp;<input name="jmt_rslt_dt" type="text" dataformat="ymd" maxlength="10" style="width: 77px;text-align:center" value="" class="input" id="jmt_rslt_dt" /><button type="button" id="btns_jmt_rslt_dt" name="btns_jmt_rslt_dt" class="calendar ir"></button></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>	
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab ">
			<script type="text/javascript">ComTabObject('tab2')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer2" name="tabLayer2" style="display: inline">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>				
					<tr>
						<td><textarea name="clm_cuz_desc" style="width: 100%" rows="8" class="textarea1" required="" tabidx="3" caption="Cause of Claim"></textarea></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="tabLayer2" name="tabLayer2" style="display: none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>				
					<tr>
						<td><textarea style="width: 100%" rows="8" class="textarea1" name="fact_fnd_desc" required="" tabidx="4" caption="Fact Findings &amp; Assessment"></textarea></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="tabLayer2" name="tabLayer2" style="display: none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>				
					<tr>
						<td><textarea style="width: 100%" rows="8" class="textarea" tabidx="5" caption="Main Issue Review &amp; DV" name="clm_rvw_desc"></textarea></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="tabLayer2" name="tabLayer2" style="display: none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>	
					<colgroup>
						<col width="110"/>
						<col width="501"/>
						<col width="160"/>
						<col width="176"/>
						<col width="50"/>
						<col width="*"/>
					</colgroup>				
					<tr>
						<th>Claimant's Agent</th>
						<td><input type="hidden" name="clm_agn_clm_pty_no" value="" id="clm_agn_clm_pty_no" /><input type="text" name="clm_agn_clm_pty_abbr_nm" style="width: 60px;" dataformat="engup" value="" class="input" id="clm_agn_clm_pty_abbr_nm"/><button type="button" id="btn4_Claimant_Agent" name="btn4_Claimant_Agent" class="input_seach_btn"></button><input type="text" name="clm_agn_clm_pty_nm" style="width: 230px;" value="" class="input2" readonly="readonly" id="clm_agn_clm_pty_nm" /><button type="button" class="btn_etc" name="btn4_Style" 		id="btn4_Style">Style</button></td>
						<th>Type</th>
						<td><script type="text/javascript">ComComboObject("clmt_agn_tp_cd", 2, 47, 1);</script></td>
						<th>CA Appointed Date</th>
						<td><input type="text" name="clmt_agn_apnt_dt" dataformat="ymd" maxlength="10" style="width: 80px;text-align:center" value="" class="input" id="clmt_agn_apnt_dt" /><button type="button" id="btns_clmt_agn_apnt_dt" name="btns_clmt_agn_apnt_dt" class="calendar ir"></button></td>	
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>	
					<colgroup>
						<col width="110"/>
						<col width="150"/>
						<col width="50"/>
						<col width="200"/>
						<col width="160"/>
						<col width="*"/>
					</colgroup>				
					<tr>
						<th>Tel.</th>
						<td><input type="text" name="clm_agn_intl_phn_no" style="width: 35px;" value="" class="input2" readonly="readonly" id="clm_agn_intl_phn_no" /><input type="text" name="clm_agn_phn_no" style="width: 160px;" value="" class="input2" readonly="readonly" id="clm_agn_phn_no" /> </td>
						<th>E-Mail</th>
						<td><input type="text" name="clm_agn_pty_eml" style="width: 236px;" value="" class="input2" readonly="readonly" id="clm_agn_pty_eml" /> </td>
						<th>Claimant's Agent Ref No.</th>
						<td><input type="text" name="clmt_agn_ref_no" style="width: 400px;" value="" class="input" id="clmt_agn_ref_no" /> </td>
					</tr>
				</tbody>
			</table>			
		</div>
	</div>
	
	<div id="tabLayer2" name="tabLayer2" style="display: none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="110"/>
						<col width="501"/>
						<col width="160"/>
						<col width="182"/>
						<col width="50"/>
						<col width="*"/>
					</colgroup>	
					<tr>
						<th>Insurer's Agent</th>
						<td><input type="hidden" name="insur_agn_clm_pty_no" value="" id="insur_agn_clm_pty_no" /><input type="text" name="insur_agn_clm_pty_abbr_nm"  style="width: 60px;" dataformat="engup" value="" class="input" id="insur_agn_clm_pty_abbr_nm" /><button type="button" id="btn5_Insurer_Agent" name="btn5_Insurer_Agent" class="input_seach_btn"></button><input type="text" name="insur_agn_clm_pty_nm" style="width: 230px;" value="" class="input2" readonly="readonly" id="insur_agn_clm_pty_nm" /><button type="button" class="btn_etc" name="btn5_Style"  		id="btn5_Style">Style</button></td>
						<th>Type</th>
						<td><script type="text/javascript">ComComboObject("agn_crspn_tp_cd", 2, 47, 1);</script></td>
						<th>IA Appointed Date</th>
						<td><input type="text" name="agn_crspn_apnt_dt" dataformat="ymd" maxlength="10" style="width:80px;text-align:center" value="" class="input" id="agn_crspn_apnt_dt" /><button type="button" id="btns_agn_crspn_apnt_dt" name="btns_agn_crspn_apnt_dt" class="calendar ir"></button></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="110"/>
						<col width="150"/>
						<col width="50"/>
						<col width="200"/>
						<col width="160"/>
						<col width="*"/>
					</colgroup>	
					<tr>
						<th>Tel.</th>
						<td><input type="text" name="insur_agn_intl_phn_no" style="width: 35px;" value="" class="input2" readonly="readonly" id="insur_agn_intl_phn_no" /><input type="text" name="insur_agn_phn_no" style="width: 160px;" value="" class="input2" readonly="readonly" id="insur_agn_phn_no" /></td>
						<th>E-Mail</th>
						<td><input type="text" name="insur_agn_pty_eml" style="width: 236px;" value="" class="input2" readonly="readonly" id="insur_agn_pty_eml" /></td>
						<th>Insurer's Agent Ref No.</th>
						<td><input type="text" name="agn_crspn_ref_no" style="width: 400px;" value="" class="input" id="agn_crspn_ref_no" /> </td>
					</tr>	
				</tbody>
			</table>			
		</div>
	</div>
	
	<div id="tabLayer2" name="tabLayer2" style="display: none">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>				
					<tr>
						<td><textarea name="ltgt_cs_desc" style="width: 100%" caption="Case Summary &amp; DV" rows="9" class="textarea"></textarea></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
</div>		
</form>
<form name="form2">
<textarea name="sXml" style="width:0px;height:0px;display:none;" ><%=xml%></textarea>
</form>
<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>	
