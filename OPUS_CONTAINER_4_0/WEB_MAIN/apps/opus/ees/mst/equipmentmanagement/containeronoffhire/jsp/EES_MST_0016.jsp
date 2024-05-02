<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0016.jsp
*@FileTitle  : Own Container Creation (New Van) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================
*/  
%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffhire");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("sange", "01", "CD20095", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="cntr_mtrl_cd" name="cntr_mtrl_cd" value="" type="hidden" />
<!-- agreement no., manufacture date, hanger rack, Plasti Floor -->
<input id="org_agmt_no" name="org_agmt_no" type="hidden" />
<input id="org_mft_dt" name="org_mft_dt" type="hidden" />
<input id="org_de_dt" name="org_de_dt" type="hidden" />
<input id="org_cntr_hngr_rck_cd" name="org_cntr_hngr_rck_cd" type="hidden" />
<input id="org_plst_flr_flg" name="org_plst_flr_flg" type="hidden" />
<input id="org_fctry_spec_no" name="org_fctry_spec_no" type="hidden" />
<input id="org_de_yrmon" name="org_de_yrmon" type="hidden" />
<input id="org_certi_no" name="org_certi_no" type="hidden" />
<input id="org_diff_rmk" name="org_diff_rmk" type="hidden" />
<input id="org_mft_vndr_seq" name="org_mft_vndr_seq" type="hidden" />
<input id="org_apro_csc_no" name="org_apro_csc_no" type="hidden" />
<input id="org_apro_tir_no" name="org_apro_tir_no" type="hidden" />
<input id="org_apro_uic_no" name="org_apro_uic_no" type="hidden" />
<input id="org_apro_tct_no" name="org_apro_tct_no" type="hidden" />
<input id="mft_vndr_seq" name="mft_vndr_seq" type="hidden" />
<input id="org_unit_type" name="org_unit_type" type="hidden" />
<input id="org_rf_mkr_seq" name="org_rf_mkr_seq" type="hidden" />
<input id="org_rf_mdl_nm" name="org_rf_mdl_nm" type="hidden" />
<input id="org_rf_rfr_no" name="org_rf_rfr_no" type="hidden" />
<input id="org_min_temp" name="org_min_temp" type="hidden" />
<input id="org_max_temp" name="org_max_temp" type="hidden" />
<input id="org_rf_humid_ctrl_val_cd" name="org_rf_humid_ctrl_val_cd" type="hidden" />
<input id="org_rf_cmpr_ctnt" name="org_rf_cmpr_ctnt" type="hidden" />
<input id="org_mft_yd_cd" name="org_mft_yd_cd" type="hidden" />
<input id="org_lot_no" name="org_lot_no" type="hidden" />

<input type="hidden" name="fa_if_grp_sts_cd" id="fa_if_grp_sts_cd">
<!-- agreement no., manufacture date -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
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
		<tbody>
			<tr>
				<th width="106">Lot No.</th>
				<td><input type="text" style="width: 130px" class="input" value="" name="lot_no" id="lot_no" style="text-align:center" readonly><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget1" id="ComOpenPopupWithTarget1"></button></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Agreement</h3>
		<table>
			<tbody>
				<tr>
					<th width="106">AGMT No.</th>
					<td width="255"><input type="text" style="width: 130px" class="input1" value="" name="agmt_no" id="agmt_no" readonly style="text-align:center"><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget2" id="ComOpenPopupWithTarget2"></button></td>
					<th width="80">Lease Term</th>
					<td width="60"><input type="text" style="width: 50px" class="input2" value="" name="lstm_cd" id="lstm_cd" style="text-align:center" readonly></td>
					<th width="80">Effective Date</th>
					<td><input type="text" style="width: 80px" class="input2" value="" name="eff_dt"  id="eff_dt"  style="text-align:center" readonly>~ <input type="text" style="width: 80px" class="input2" value="" name="exp_dt" id="exp_dt" style="text-align:center" readonly></td>
				</tr>
				<tr>
					<th>Financier</th>
					<td colspan="5"><input type="text" style="width: 75px" class="input2" value="" name="vndr_seq" id="vndr_seq" readonly style="text-align:center"><input type="text" style="width: 589px" class="input2" value="" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" readonly style="text-align:center"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Owners Inspection</h3>
		<table>
			<tbody>
				<tr>
					<th width="106">SPEC No.</th>
					<td width="120"><input type="text" style="width: 130px" class="input1" value="" name="cntr_spec_no" id="cntr_spec_no" readonly style="text-align:center"><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget3" id="ComOpenPopupWithTarget3"></button></td>
					<th width="90">TP/SZ</th>
					<td width="120"><input type="text" style="width: 50px" class="input2" value="" name="cntr_tpsz_cd" id="cntr_tpsz_cd" style="text-align:center" readonly></td>
					<th width="60">CERTI No.</th>
					<td><input type="text" style="width: 180px" class="input1" value="" name="certi_no" id="certi_no" maxlength="25" style="ime-mode:disabled" dataformat="engup" otherchar="- "></td>
				</tr>
				<tr>
					<th>M/Facturer</th>
					<td><input type="text" style="width: 159px" class="input2" value="" name="vndr_abbr_nm" id="vndr_abbr_nm" readonly></td>
					<th>F. Spec. No.</th>
					<td><input type="text" style="width: 110px" class="input" value="" name="fctry_spec_no" id="fctry_spec_no" maxlength="20" dataformat="engup"></td>
					<th>CSC No.</th>
					<td><input type="text" style="width: 180px" class="input1" value="" name="apro_csc_no" id="apro_csc_no" style="ime-mode:disabled" maxlength="30" dataformat="engup" otherchar="- "></td>
				</tr>
				<tr>
					<th style="display:none">M/Facturer Place</th>
					<td style="display:none"><script type="text/javascript">ComComboObject('lot_loc_cd01',1,60,1,1,0);</script> <input type="text" name="lot_loc_cd" style="width:70px;text-align:center;" class="input1" value="" maxlength="7" dataformat="engup" readonly id="lot_loc_cd" /></td>
					<th>M/Facture Yard</th>
					<td><input type="text" name="mft_yd_cd" style="width:100px;text-align:center;" class="input1" value="" maxlength="7" dataformat="engup" id="mft_yd_cd" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
					<th>M/Facture Date</th>
					<td><input type="text" style="width: 81px" class="input1" name="mft_dt" id="mft_dt" style="text-align:center" dataformat="ymd"><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1">></td>
					<th>TIR No.</th>
					<td><input type="text" style="width: 180px" class="input1" value="" name="apro_tir_no" id="apro_tir_no" style="ime-mode:disabled" maxlength="30" dataformat="engup" otherchar="- "></td>
				</tr>
				<tr>
					<th>S/N Range</th>
					<td colspan="3">
					<input type="text" style="width: 60px" class="input1" value="" name="lot_cntr_pfx_cd" id="lot_cntr_pfx_cd" maxlength="4" dataformat="enguponly" style="text-align:center">
					<input type="text" style="width: 60px" class="input1" value="" name="fm_ser_no" id="fm_ser_no" maxlength="6" dataformat="num" style="ime-mode:disabled" style="text-align:center">- <input type="text" style="width: 55px" class="input1" value="" name="to_ser_no" id="to_ser_no" maxlength="6" dataformat="num" style="ime-mode:disabled" style="text-align:center"><input type="text" style="width: 40px" class="input2" value="" name="range_count" id="range_count" readonly style="text-align:center"></td>
					<th>UIC No.</th>
					<td><input type="text" style="width: 180px" class="input" value="" name="apro_uic_no" id="apro_uic_no" style="ime-mode:disabled" maxlength="30" dataformat="engup" otherchar="- "></td>
				</tr>
				<tr>
					<th>Delivery Date</th>
                    <td><input type="text" style="width: 81px" class="input1" name="de_dt0" id="de_dt0" style="text-align:center" dataformat="ymd"><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button><!--
                    --><input type="text" style="width:50px;ime-mode:disabled" maxlength="4" class="input1" tabindex="5" id="p_time" name="p_time" dataformat="hm"><!--
                    --><input type="hidden" style="width:112px;ime-mode:disabled" maxlength="16" class="input1" id="de_yrmon" name="de_yrmon"><!--
                    --><input type="hidden" style="width:112px;ime-mode:disabled" maxlength="16" class="input1" id="de_dt" name="de_dt"></td>    
                    <td colspan="2"></td>               
					<th>TCT No.</th>
					<td><input type="text" style="width: 180px" class="input" value="" name="apro_tct_no" id="apro_tct_no" maxlength="30" dataformat="engup" otherchar="- "></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="checkbox" value="Y" class="trans" name="plst_flr_flg" id="plst_flr_flg" style="display: none;"><label for="plst_flr_flg" style="display: none;">Plastic Floor</label><!--
				     --><input type="checkbox" value="O" class="trans" name="cntr_hngr_rck_cd" id="cntr_hngr_rck_cd"><label for="cntr_hngr_rck_cd">Hanger Rack</label></td>
					<!-- <th>Unit Type</th>
					<td colspan="3"><script type="text/javascript">ComComboObject('unit_type',1,108,1,0,0);</script></td> -->
					<!-- <th>ERP I/F</th>
					<td><input type="text" style="width: 180px" class="input" value="" name="fa_if_grp_sts_cd" readOnly id="fa_if_grp_sts_cd" maxlength="30" dataformat="engup"></td> -->
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">RF Unit</h3>	
		<table>
			<tbody>
				<tr>
					<th width="106">Maker</th>
					<td width="120"><script type="text/javascript">ComComboObject('rf_mkr_seq',2,170,0,1,1);</script></td>
					<th width="80">Model No.</th>
					<td width="120"><input type="text" style="width: 150px;" class="input2" maxlength=20 readOnly value="" name="rf_mdl_nm" id="rf_mdl_nm" style="text-align:center"></td>
					<th width="80">Refrigerant</th>
					<td width="120"><input type="text" style="width: 120px;" class="input2" maxlength=10 readOnly value="" name="rf_rfr_no" id="rf_rfr_no" style="text-align:center"></td>
					<th width="60">Max Setting Temp</th>
					<td style="font-weight: bold;"><input type="text" style="width: 45px;" class="input2" dataformat="singledFloat" caption="float(min/max)" readOnly value="" pointcount="2" maxlength="6"  size="6" name="min_temp" id="min_temp" style="text-align:right">~ <input type="text" style="width: 45px;" class="input2" dataformat="singledFloat" caption="float(min/max)" readOnly value="" pointcount="2" maxlength="6"  size="6" name="max_temp" id="max_temp" style="text-align:right">℃</td>
				</tr>
				<tr>
					<th width="106">Unit Type</th>
					<td width="120">
						
						<script type="text/javascript">ComComboObject('unit_type',1,170,1,0,0);</script>
					</td>
					<th width="60">Humidity Control</th>
					<td width="120"> 
						<script type="text/javascript">ComComboObject('rf_humid_ctrl_val_cd',1,149,1,0,0);</script>
					</td>
					<th width="60">Compressor</th>
					<td width="120" colspan="3"><input type="text" style="width: 345px;" class="input" value="" readOnly name="rf_cmpr_ctnt" id="rf_cmpr_ctnt" style="text-align:center"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Remark(s)</h3>	
			<table>
				<tbody>
					<tr>
						<td width="1%" class="tr2_head" style="text-align: center; font-weight: bold;"></td>
						<td width="%"><textarea style="resize:none; width: 80%; height: 80px;" name="diff_rmk" id="diff_rmk" style="ime-mode:disabled" maxlength="1000"></textarea></td>
					</tr>
				</tbody>
			</table> 
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>