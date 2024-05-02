﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0018.js
*@FileTitle  : Land Inventory With CNTR List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	
    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim0018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//multi combo for MVMT Status
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }						
	    
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

    function setupPage(){  

	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>");
    }

</script>

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="head_cntr_tpsz_cd" value="" id="head_cntr_tpsz_cd" />
<input type="hidden" name="cnt_cd" value="" id="cnt_cd" />
<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="cnmv_sts_cd" id="cnmv_sts_cd" />
<input type="hidden" name="lstm_cd" id="lstm_cd" />
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">DownExcel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100px" />
				<col width="110px" />
				<col width="130px" />
				<col width="80px" />
				<col width="180px" />
				<col width="90px" />
				<col width="10px" />
				<col width="80px" />
                <col width="140px" />
				<col width="80px" />
                <col width="80px" />
                <col width="80px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Search Type</th>
					<td><select style="width:100px;" name="loc_type_code" id="loc_type_code" class="input" >
						<option value="2"> LCC</option>
						<option value="3"> ECC</option>
						<option value="4"> SCC</option>
						<option value="5"> Yard</option>
						<option value="6"> RU Label</option>
						<option value="7"> BKG No.</option>
						<option value="8"> EQR Ref No.</option>
						<option value="9"> Container No.</option>
					</select>					
					</td>
					<td>
					<div id="locTpCdInput" style="display:;"><input type="text" class="input1" id="loc_cd" name="loc_cd" style="ime-mode:inactive;width:78px;" dataformat="engup" size="7" maxlength="7" fulfill  class="input" value=""> <button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button><button type="button" style="display:none;" id="btn_loc_multi_cd" name="btn_loc_multi_cd" class="multiple_inq ir"></button></div>
					<div id="locTpCdCombo" style="display:none;"></div>
					</td>
					<div style="display:none;"><script language="javascript">ComComboObject('ru_lable_type1', 1, 92, 0, 1);</script></div>
					<td style="display:none;"><script language="javascript" >ComComboObject('rstr_usg_lbl1', 1, 140, 1 );</script></td>
					<th id="locRuLabelTitle">RU Label</th>
					<td id="locRuLabelInput"><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"   style="ime-mode:inactive;"  style="width:150px;" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
					<th class="pad_right_4">IMM. Exit <input type="checkbox" name="imdt_ext_flg" value="Y" class="trans" id="imdt_ext_flg" /> </th>
					<th class="pad_right_4"><div style="display:none">Plastic Floor<input type="checkbox" name="plst_flr_flg" value="Y" class="trans" id="plst_flr_flg" /></th>
					<th>DMG</th>
					<td><select name="dmg_flg" id="dmg_flg" style="width:75px;" class="input"><option value="" selected>Include</option><option value="N">Exclude</option><option value="Y">Only</option></select></td>
					<th>F/M</th>
					<td><select name="full_flg" id="full_flg" style="width:80px;" class="input"><option value="" selected></option><option value="Y">Full</option><option value="N">MTY</option></select></td>
					<th>Cargo Type</th>
                    <td><select name="cgo_tp_cd" id="cgo_tp_cd" style="width:100px;" class="input"><option value="A" selected>ALL</option><option value="F">F(Full)</option><option value="P">P(Repositioned)</option><option value="R">R(Empty Revenue)</option></select></td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />
				<col width="240" />
				<col width="80" />
				<col width="270" />
				<col width="10" />
				<col width="80" />
				<col width="140" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>TP/SZ</th>
					<td><script type="text/javascript">ComComboObject('combo_cntr_tpsz_cd', 1, 220, 1);</script></td>
					<th class="sm">Reefer</th>
					<td class="sm"><input type="checkbox" name="rf_tp_cd_c" value="C" class="trans" id="rf_tp_cd_c" /><label>CA</label><input type="checkbox" name="rf_tp_cd_h" value="M" class="trans" id="rf_tp_cd_h" /><label>MA</label><input type="checkbox" name="rf_tp_cd_m" value="W" class="trans" id="rf_tp_cd_m" /><label>WE</label><input type="checkbox" name="rf_cntr" value="N" class="trans" id="rf_cntr" /><label>Reefer</label><input type="checkbox" name="rd_cgo_flg" value="Y" class="trans" id="rd_cgo_flg" /><label>R/D</label></td>
					<td></td>
					<th>S.O.C</th>
					<td><select name="soc_cd" id="soc_cd" style="width:75px;" class="input"><option value="1">Exclude</option><option value=""selected>Include</option><option value="2">Only</option></select></td>
					<th>Unclaim</th>
					<td><select name="uclm_ls_div_cd" id="uclm_ls_div_cd" style="width:80px;" class="input"><option value="E">Exclude</option><option value="I" selected>Include</option><option value="O">Only</option></select></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />
				<col width="240" />
				<col width="80" />
				<col width="270" />
				<col width="10" />
				<col width="80" />
				<col width="140" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>MVMT Status</th>
					<td><script type="text/javascript">ComComboObject('combo_cnmv_sts_cd', 1, 220, 1);</script></td>
					<th class="sm">EQ MGMT</th>
					<td class="sm"><input type="checkbox" name="cntr_hngr_rck_cd" value="Y" class="trans" id="cntr_hngr_rck_cd" /><label>Hanger Rack/Bar</label><input type="checkbox" name="disp_flg" value="Y" class="trans" id="disp_flg" /><label>DPSL</label><input type="checkbox" name="d2_payld_flg" value="Y" class="trans" id="d2_payld_flg" style="display:none;"/><label style="display:none;">D2-HP</label></td>
					<td></td>
					<th>Staying Day</th>
					<td><input type="text" name="over_stay_days" style="width:75px; text-align:right;" dataformat="num" class="input" value="" id="over_stay_days" />&nbsp;or over</td>
					<th>Prefix</th>
					<td><input type="text" name="cntr_no" style="width:40px;" dataformat="engup" size="4" maxlength="4" fulfill="" class="input" value="" id="cntr_no" /> </td>
				</tr> 
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />
				<col width="240" />
				<col width="80" />
				<col width="100" />
				<col width="400" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Lease Term</th>
					<td><script type="text/javascript">ComComboObject('combo_lstm_cd', 1, 220, 1);</script></td>
					<th class="sm">View</th>
					<td class="sm"><input type="radio" name="view_flg" id="view_flg" onclick="javascript:view_flg_click();" value="eq" checked class="trans"><label>EQ</label><input type="radio" name="view_flg" id="view_flg" onclick="javascript:view_flg_click();" value="bkg" class="trans"><label>BKG</label></td>
					<td><div id = "div_eq" style="display:"><label><b>M/Date</b></label><input type="text" style="width:50px;text-align:center;" class="input" value="" name="froms" id="froms" caption="M/Date FM"  dataformat="yyyy" maxlength="4">~<input type="text" style="width:50px;text-align:center;" class="input" value="" name="tos" id="tos" caption="M/Date TO"  dataformat="yyyy"  maxlength="4"></div>
						<div id = "div_bkg" style = "display:none" ><input type="checkbox" onclick="javascript:ts_cntr_behind_click();" name="ts_cntr_behind" id="ts_cntr_behind" disabled=true class="trans" value="Y"> T/S Behind ATD of Load VVD <input type="text" name="next_vvd" id="next_vvd" disabled=true style="ime-mode:inactive" dataformat="engup" size="9" maxlength="9" fulfill style="width:80px;" class="input2" value="" ></div>
					</td>
					<th class="sm">Add Info</th>
					<td class="sm"><input type="checkbox" name="view_customer" value="Y" class="trans"><label>Customer</label><input type="checkbox" name="view_commodity" value="Y" class="trans"><label>CMDT</label></td>

					
					<!-- <th>Speed</th>
					<td><input type="checkbox" name="speed" checked value="Y"></td> -->
				</tr>
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--
			--><button class="btn_accent" name="btn_movement" id="btn_movement" type="button">Movement</button><!--
			--><button class="btn_normal" name="btn_master" id="btn_master" type="button">Master</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
