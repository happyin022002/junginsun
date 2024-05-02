<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0019.jsp
*@FileTitle  : Container Master Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesMst0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String popup_mode = "";
	popup_mode = JSPUtil.getParameter(request, "popup_mode".trim(), "");
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_off_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffHire");
	String cntr_no = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_off_cd = account.getOfc_cd();
		event = (EesMst0019Event)request.getAttribute("Event");
		cntr_no = StringUtil.xssFilter((String)request.getParameter("cntr_no"));
		if (cntr_no == null) cntr_no ="";
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
 
<script type="text/javascript">
<%=OfficeCodeMgr.getOfficeCodeListToJS("000001", "LSE")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form id="form" name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="hid_off_hire_avail" name="hid_off_hire_avail" type="hidden" />
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_off_cd %>" id="usr_ofc_cd" />
	<% if(popup_mode.equals("Y") ){ %>
		<div class="layer_popup_title">
			<div class="page_title_area clear">
				<h2 class="page_title"><span>Container Master Inquiry</span></h2>
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
					--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
					--><button type="button" class="btn_normal" name="btn_spec" id="btn_spec">SPEC</button><!-- 
					--><button type="button" class="btn_normal" name="btn_mvmt" id="btn_mvmt">Movement</button><!-- 
					--><button type="button" class="btn_normal" name="btn_status" id="btn_status">Status</button><!-- 
					--><button type="button" class="btn_normal" name="btn_mnr" id="btn_mnr">M&R</button><!-- 
					--><button type="button" class="btn_normal" name="btn_doldoc" id="btn_doldoc">AGMT</button><!-- 
					--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
				</div>
			</div>
		</div>
	<%} else{%>
		<div class="page_title_area clear">
			<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
				--><button type="button" class="btn_normal" name="btn_spec" id="btn_spec">SPEC</button><!-- 
				--><button type="button" class="btn_normal" name="btn_mvmt" id="btn_mvmt">Movement</button><!-- 
				--><button type="button" class="btn_normal" name="btn_status" id="btn_status">Status</button><!-- 
				--><button type="button" class="btn_normal" name="btn_mnr" id="btn_mnr">M&R</button><!-- 
				--><button type="button" class="btn_normal" name="btn_doldoc" id="btn_doldoc">AGMT</button>
			</div>
			<div class="location">
				<span id="navigation"></span>
			</div>
		</div>
	<%} %>
<!-- page_title_area(E) -->

<% if(popup_mode.equals("Y") ){ %><div class="layer_popup_contents"><%}%>
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="83">
			<col width="40">
			<col width="30">
			<col width="20">
			<col width="107">
			<col width="83">
			<col width="70">
			<col width="60">
			<col width="60">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th>CNTR No.</th>
				<td>
					<input type="text" style="width: 110px; ime-mode: disabled; text-align: center; text-transform: uppercase;" class="input1" dataformat="engup" maxlength="10" name="cntr_no" id="cntr_no" value="<%=cntr_no%>"><!--
				 --><input type="text" style="width: 15px;" class="input"  readOnly value="" dataformat="num" name="chk_dgt" id="chk_dgt"><!--
				 --><div id="div_dcond1" style="display:inline"><input type="text" style="width: 55px;text-align: center" class="input"  readOnly value="" name="aciac_div_cd1" id="aciac_div_cd1"  style=""></div><!--
				 --><div id="div_dcond2" style="display:none"><input type="text" style="width:53px;text-align:center;color:yellow;background-color:FF0000;font-weight:bold;" class="input"  readOnly value="" name = "aciac_div_cd2" id="aciac_div_cd2" style=""></div>
				</td> 
				<th>TP/SZ</th>
				<td><input type="text" style="width: 30px;text-align: center" class="input"  readOnly value="" name="cntr_tpsz_cd" id="cntr_tpsz_cd" ></td>
				<th>ISO Code</th>
				<td><input type="text" style="width: 80px;text-align: center" class="input"  readOnly value="" name="cntr_tpsz_iso_cd" id="cntr_tpsz_iso_cd" ></td>
				<th>Material</th>
				<td><input type="text" style="width: 80px;text-align: center" class="input"  readOnly value="" name="cntr_mtrl_cd" id="cntr_mtrl_cd" ></td>
				<th>Gross Weight</th>
                <td><input type="text" style="width: 80px;text-align: right" class="input"  readOnly value="" name="cntr_grs_wgt" id="cntr_grs_wgt" style="text-align:right"> KG<label></label><input type="text" style="width: 80px;text-align:right" class="input"  readOnly value="" name="cntr_grs_wgt_lbs" id="cntr_grs_wgt_lbs" dataformat="int" style="text-align:right"> LBS</td>
                
				</tr>
			<tr>
				<th>Lease Term</th>
				<td colspan="3"><input type="text" style="width: 110px;text-align:center" class="input"  readOnly value="" name="sub_lstm_cd" id="sub_lstm_cd"></td>
				<th>Owner Lease Term</th>
				<td><input type="text" style="width: 80px;text-align:center" class="input"  readOnly value="" name="lstm_cd" id="lstm_cd" ></td>
				<th>Current</th>
                <td><input type="text" style="width: 80px;text-align:center" class="input"  readOnly value="" name="cntr_use_co_cd" id="cntr_use_co_cd" style=""></td>
                <th>Tare Weight</th>
                <td><input type="text" style="width: 80px;text-align: right" class="input"  readOnly value="" name="tare_wgt" id="tare_wgt" style="text-align:right"> KG<label></label><input type="text" style="width: 80px;text-align:right" class="input"  readOnly value="" name="tare_wgt_lbs" id="tare_wgt_lbs" dataformat="int" style="text-align:right"> LBS<input type="hidden" name="cntr_spec_no" id="cntr_spec_no"></td>
				</tr>
			<tr>
				<th>Manufacturer</th>
				<td colspan="3"><input type="text" style="width: 110px;text-align:center" class="input"  readOnly value="" name="vndr_abbr_nm" id="vndr_abbr_nm" style=""><input type="text" style="width: 225px;" class="input"  readOnly value="" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" style="text-align:left"></td>
				<th>Manufacture Date</th>
				<td><input type="text" style="width: 80px;text-align:center" class="input"  readOnly value="" name="mft_dt" id="mft_dt"></td>
				<th>Ownership</th>
                <td><input type="text" style="width: 220px;text-align:left" class="input"  readOnly value="" name="ownr_co_cd" id="ownr_co_cd" style=""></td>
				<th>Pay Load</th>
                <td><input type="text" style="width: 80px;text-align: right" class="input"  readOnly value="" name="pay_load" id="pay_load" style="text-align:right"> KG<label></label><input type="text" style="width: 80px;text-align:right" class="input"  readOnly value="" name="pay_load_lbs" id="pay_load_lbs" dataformat="int" style="text-align:right"> LBS</td>
				<th><input type="checkbox" class="trans"  readOnly name="d2_payld_flg" id="d2_payld_flg" onClick="return false" style="display:none;"><label for="d2_payld_flg" style="display:none;">D2 H/P</label></th>
				<td colspan="3"><input style="display:none; background-color:#D3DBFF; font-weight:bold; width:278px; text-decoration:blink; text-align:center;" type="text" class="input" readOnly value="" name="off_hire_avail" id="off_hire_avail"></td>
			</tr>
			<tr>
				<th>BKG Info.</th>
				<td colspan="3"><input type="text" style="width: 110px; text-decoration: underline; color: blue; cursor: hand;text-align:center" class="input"  readOnly value="" name="bkg_no1" id="bkg_no1" style=""><input type="text" style="width: 110px; text-decoration: underline; color: blue; cursor:hand;text-align :center" class="input"  readOnly value="" name="bkg_no2" id="bkg_no2" style=""><input type="text" style="width: 110px; text-decoration: underline; color: blue; cursor: hand;text-align:center" class="input"  readOnly value="" name="bkg_no3" id="bkg_no3" style=""></td>
				<th>CSC No.</th>
				<td><input type="text" style="width: 80px" style="text-align: center" class="input" value="" name="apro_csc_no" id="apro_csc_no" readOnly></td>
				<th>TIR No.</th>
				<td><input type="text" style="width: 115px" style="text-align: center" class="input" value="" name="apro_tir_no" id="apro_tir_no" readOnly></td>
				<th>CERTI No.</th>
				<td><input type="text" style="width: 80px" style="text-align:center" class="input" value="" name="certi_no" id="certi_no" readOnly></td>
			</tr>
		</tbody>
	</table>
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid wFit" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
<div class="opus_design_inquiry wFit">
	<h3 class="title_design">RF Unit</h3>
	<table>
		<colgroup>
			<col width="40">
			<col width="160">
			<col width="60">
			<col width="160">
			<col width="60">
			<col width="110">
			<col width="60">
			<col width="*">
		</colgroup>
		<tbody>
			<tr> 
				<!-- <th>Type</th>
				<td><input type="text" style="width: 50px;text-align:center" class="input"  readOnly value="" name="rf_tp_cd" id="rf_tp_cd" style=""></td> -->
				<th>Maker</th>
				<td><input type="text" style="width: 170px;text-align:Left" class="input"  readOnly value="" name="rf_mkr_seq" id="rf_mkr_seq" style="text-align:Left"></td>
				<th>Model No.</th>
				<td><input type="text" style="width: 170px;text-align:Left" class="input"  readOnly value="" name="rf_mdl_nm" id="rf_mdl_nm" style="text-align:Left"></td>
				<th>Refrigerant</th>
				<td><input type="text" style="width: 100px;text-align:Left" class="input"  readOnly value="" name="rf_rfr_no" id="rf_rfr_no" style="text-align:Left"></td>
				<th>Temperature</th>
				<td><input type="text" style="width: 50px;text-align:Right" class="input"  readOnly value="" name="min_temp" name="min_temp"  style="text-align:Right"> ~ <input type="text" style="width: 50px;text-align:Right" class="input"  readOnly value="" name="max_temp" id="max_temp" style="text-align:Right">℃</td>
			</tr>
			 <tr>
					<th>Unit Type</th>
					<td>
						<input type="text" style="width: 170px;text-align:Left" class="input"  readOnly value="" name="rf_tp_cd" id="rf_tp_cd">
					</td>
					<th>Humidity Control</th>
					<td>
						<input type="text" style="width: 170px;text-align:center" class="input"  readOnly value="" name="rf_humid_ctrl_val_cd" id="rf_humid_ctrl_val_cd" style="">
					</td>
					<th>Compressor</th>
					<td colspan="3">
						<input type="text" style="width: 310px;text-align:left" class="input"  readOnly value="" name="rf_cmpr_ctnt" id="rf_cmpr_ctnt" style="">
					</td>
				</tr> 
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Current Status</h3>
		<table>
			<colgroup>
				<col width="100">
				<col width="80">
				<col width="30">
				<col width="110">
				<col width="60">
				<col width="150">
				<col width="60">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Movement Status</th>
					<td><input type="text" style="width: 55px;text-align:center" class="input"  readOnly value="" name="cnmv_sts_cd" id="cnmv_sts_cd" style="text-align:center"></td>
					<th>Yard</th>
					<td><input type="text" style="width: 80px;text-align:center" class="input"  readOnly value="" name="crnt_yd_cd" id="crnt_yd_cd"  style="text-align:center"></td>
					<th>VVD Code</th>
					<td><input type="text" style="width: 50px;text-align:center" class="input"  readOnly value="" name="vsl_cd" id="vsl_cd" style="text-align:center"><input type="text" style="width: 50px;text-align:center" class="input" readOnly value="" name="skd_voy_no" id="skd_voy_no" style="text-align:center"><input type="text" style="width: 25px;text-align:center" class="input"  readOnly value="" name="skd_dir_cd" id="skd_dir_cd" style="text-align:center"></td>
					<th>Act Date</th>
					<td><input type="text" style="width: 120px;text-align:center" class="input"  readOnly value="" name="cnmv_dt" id="cnmv_dt"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="80">
				<col width="60">
				<col width="30">
				<col width="60">
				<col width="60">
				<col width="60">
				<col width="60">
				<col width="60">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th class="sm">
						<input type="checkbox" value="Y" name="full_flg" id="full_flg" onClick="return false"><label for="full_flg">Full</label><!--
					 --><input type="checkbox" value="Y" name="dmg_flg" id="dmg_flg" onClick="return false"><label for="dmg_flg">Damaged</label><!--
					 --><input type="checkbox" value="Y" name="imdt_ext_flg" id="imdt_ext_flg" onClick="return false"><label for="imdt_ext_flg">Immediate Exit</label>
					</th>
					<th class="sm">H/Rack TP</th>
					<td class="sm"><input type="text" style="width: 50px;text-align:center" class="input" readOnly name="cntr_hngr_rck_cd" id="cntr_hngr_rck_cd" style="text-align:center"></td>
					<th class="sm">H/B TP</th>
					<td class="sm"><input type="text" style="width: 50px;text-align:center" class="input" readOnly name="mnr_hngr_bar_tp_cd" id="mnr_hngr_bar_tp_cd" style="text-align:center"></td>
					<th class="sm">H/B Qty</th>
					<td class="sm"><input type="text" style="width: 30px;text-align:right" class="input" readOnly name="cntr_hngr_bar_atch_knt" id="cntr_hngr_bar_atch_knt" style="text-align:right"></td>
					<th align="center" class="sm"><input type="checkbox" value="Y" class="trans" name="plst_flr_flg" id="plst_flr_flg" onClick="return false" style="display:none"><label for="plst_flr_flg" style="display:none">P/F</label><!--
					--><input type="checkbox" value="Y" class="trans" name="disp_flg" id="disp_flg"  onClick="return false"><label for="disp_flg">DISP</label><!-- 
					--><input type="checkbox" value="Y" class="trans" name="ls_flg" id="ls_flg" onClick="return false"><label for="ls_flg">L/S</label><!--
					--><input type="checkbox" value="Y" class="trans" name="uc_flg" id="uc_flg" onClick="return false"><label for="uc_flg">U/C</label>
					</th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">RU Label Information</h3>
		<table>
			<colgroup>
				<col width="950">				
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td>
					<input type="text" style="width:460px;text-align:left" class="input"  readOnly value="" name="rstr_usg_lbl_tp"  id="rstr_usg_lbl_tp" style="text-align:left">
					<input type="text" style="width:460px;text-align:left" class="input"  readOnly value="" name="rstr_usg_lbl_desc"  id="rstr_usg_lbl_desc" style="text-align:left">
					</td>
					<td><button type="button" class="btn_etc" name="btn_ru_label_info" id="btn_ru_label_info">RU Label Inquiry</button></td>
				</tr>
			</tbody>
		</table>
		
	</div>
	
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Entry</h3>
		<table>
			<colgroup>
				<col width="60">
				<col width="100">
				<col width="60">
				<col width="50">
				<col width="75">
                <col width="80">	
                <col width="78">             			
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Date</th>
					<td><input type="text" style="width: 80px;text-align:center" class="input"  readOnly value="" name="onh_dt" id="onh_dt"></td>
					<th>Status</th>
					<td><input type="text" style="width: 40px;text-align:center" class="input"  readOnly value="" name="onh_cntr_sts_cd" id="onh_cntr_sts_cd" style="text-align:center"></td>
					<th>AGMT No.</th>
					<td><input type="text" style="width: 90px;text-align:center" class="input"  readOnly value="" name="onh_agmt_no" id="onh_agmt_no" style="text-align:center"></td>
                    <th>Auth No.</th>
                    <td><input type="text" style="width: 150px;text-align:center" class="input"  readOnly value="" name="cntr_auth_no" id="cntr_auth_no" style="text-align:center"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="60">
				<col width="400">
				<col width="60">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Lessor</th>
					<td><input type="text" style="width: 80px;text-align:center" class="input"  readOnly value="" name="vndr_seq" id="vndr_seq" style="text-align:Center"><input type="text" style="width: 293px;text-align:leftr" class="input" readOnly value="" name="lessor_nm" id="lessor_nm" style="text-align:Left"></td>
					<th>URL</th>
					<td><input type="text" class="input"  readOnly value="" name="lse_vndr_url" id="lse_vndr_url" style="width: 293px; text-decoration: underline; color: blue; cursor :hand; text-align: left;"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Exit</h3>
		<table>
			<colgroup>
				<col width="60">
                <col width="100">
                <col width="60">
                <col width="50">
                <col width="75">
                <col width="80">    
                <col width="78">                        
                <col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Date</th>
					<td><input type="text" style="width: 80px;text-align:center" class="input"  readOnly value="" name="cntr_sts_evnt_dt" id="cntr_sts_evnt_dt"></td>
					<th>Status</th>
					<td><input type="text" style="width: 40px;text-align:center" class="input"  readOnly value="" name="cntr_sts_cd" id="cntr_sts_cd" style="text-align:center"></td>
					<th>AGMT No.</th>
					<td><input type="text" style="width: 90px;text-align:center" class="input"  readOnly value="" name="exit_agmt_no" id="exit_agmt_no" style="text-align:center"></td>
					<th>Auth No.</th>
                    <td><input type="text" style="width: 150px;text-align:center" class="input"  readOnly value="" name="cntr_offh_auth_no" id="cntr_offh_auth_no" style="text-align:center"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="60">
				<col width="400">
				<col width="60">
				<col width="50">
				<col width="140">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Lessor</th>
					<td><input type="text" style="width: 80px;text-align:center" class="input"  readOnly value="" name="exit_vndr_seq" id="exit_vndr_seq" style="text-align:Center"><input type="text" style="width: 293px;text-align:Left" class="input"  readOnly value="" name="exit_vndr_eng_nm" id="exit_vndr_eng_nm" style="text-align:Left"></td>
					<th>DPP</th>
					<td><input type="text" style="width: 50px;text-align:right" class="input"  readOnly value="" name="dpp_tp_cd" id="dpp_tp_cd" style="text-align:center"></td>
					<th>DPP Coverage</th>
					<td><input type="text" style="width: 100px;text-align:right" class="input"  readOnly value="" style="text-align:right" name="dpp_amt" id="dpp_amt" style="text-align:center"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Value & Cost</h3>
		<table>
			<colgroup>
				<col width="60">
				<col width="120">
				<col width="100">
				<col width="120">
				<col width="60">
				<col width="100">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>D/Value</th>
					<td><input type="text" style="width: 70px;text-align:right" class="input"  readOnly value="" name="dpc_val" id="dpc_val"  style="text-align:right"></td>
					<th>Total Using Days</th>
					<td><input type="text" style="width: 65px;text-align:right" class="input"  readOnly value="" name="using_days" id="using_days" style="text-align:right"></td>
					<th>Total Rental Charge</th>
					<td><input type="text" style="width: 65px;text-align:right" class="input"  readOnly value="" name="rntl_chg_amt" id="rntl_chg_amt" style="text-align:right"></td>
					<th>Total M&R Cost</th>
					<td><input type="text" style="width: 100px;text-align:right" class="input"  readOnly value="" name="cost_amt" id="cost_amt" style="text-align:right"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="200">
				<col width="250">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Created</th>
					<td><input type="text" style="width: 75px;text-align:center" class="input"  readOnly value="" name="cre_dt" id="cre_dt"><input type="text" style="width: 120px;" class="input"  readOnly value="" name="cre_usr_id" id="cre_usr_id" style="text-align:center"></td>
					<th>Updated</th>
					<td><input type="text" style="width: 75px;text-align:center" class="input"  readOnly value="" name="upd_dt" id="upd_dt"><input type="text" style="width: 120px;" class="input"  readOnly value="" name="upd_usr_id" id="upd_usr_id" style="text-align:center"></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->		
</div>	
<% if(popup_mode.equals("Y") ){ %></div><%}%>
</form>