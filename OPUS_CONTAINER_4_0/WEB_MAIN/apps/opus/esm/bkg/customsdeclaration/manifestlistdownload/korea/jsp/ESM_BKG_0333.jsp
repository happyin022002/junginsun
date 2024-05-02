<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0333.jsp
*@FileTitle  : Warehouse Assign by B/L
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String blNo = request.getParameter("bl_no")==null ? "":request.getParameter("bl_no");
%>

<script type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd" value="" id="f_cmd" />
<input type="hidden" name="io_bnd_cd" value="I" id="io_bnd_cd" />
<input type="hidden" name="mrn_bl_ts_cd" id="mrn_bl_ts_cd" />
<input type="hidden" name="bd_tp_cd" id="bd_tp_cd" />
<input type="hidden" name="kr_cstms_bl_tp_cd" id="kr_cstms_bl_tp_cd" />
<input type="hidden" name="bkg_rt_whf_expt_cd" id="bkg_rt_whf_expt_cd" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="clt_ofc_cd" id="clt_ofc_cd" />
<input type="hidden" name="yard" id="yard" />
<input type="hidden" name="grp_mrn" id="grp_mrn" />
<input type="hidden" name="grp_mrn_chk" id="grp_mrn_chk" />
<input type="hidden" name="grp_vvd" id="grp_vvd" />
<input type="hidden" name="grp_pol" id="grp_pol" />
<input type="hidden" name="grp_pod" id="grp_pod" />
<input type="hidden" name="grp_etd" id="grp_etd" />
<input type="hidden" name="grp_eta" id="grp_eta" />
<input type="hidden" name="grp_eta_dtl" id="grp_eta_dtl" />
<input type="hidden" name="viaWebMsg" id="viaWebMsg" />
<input type="hidden" name="upd_usr_id" id="upd_usr_id" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_GroupMSN" id="btn_GroupMSN" type="button">Edit MSN/Customs Inform</button><!--
		--><button class="btn_normal" name="btn_CargoRelease" id="btn_CargoRelease" type="button">Cargo Release</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="85">
				<col width="130" />
				<col width="85" />
				<col width="*" />
		   </colgroup>
		   <tbody>
				<tr>
					<th class ="sm"><input type="radio" name="search_type" value="search_by_bl_no" class="trans" checked="" id="search_type1" /><label for="search_type1">B/L No.</label></th>
					<td class ="sm"><input type="text" name="bl_no" style="width:110px; text-align:center;" maxlength="12" class="input1" dataformat="engup" value="<%=blNo%>" id="bl_no" /></td>
					<th class ="sm"><input type="radio" name="search_type" value="search_by_bkg_no" class="trans" id="search_type2" /><label for="search_type2">BKG No.</label></th>
					<td class ="sm"><input type="text" name="bkg_no" style="width:110px; text-align:center;" maxlength="12" class="input1" dataformat="engup" id="bkg_no" /></td>
				</tr>
		   </tbody>
		</table>
	</div>

	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="85">
				<col width="130" />
				<col width="85" />
				<col width="80" />
				<col width="60" />
				<col width="140" />
				<col width="60" />
				<col width="170" />
				<col width="90" />
				<col width="*" />
		   </colgroup>
		   <tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:110px;" name="vvd" class="input2" readonly id="vvd" /></td>
					<th>Type</th>
					<td><input type="text" style="width:60px;" name="local_ts" class="input2" readonly id="local_ts" /></td>
					<th>MRN</th>
					<td><input type="text" style="width:90px;" name="mf_ref_no" class="input2" readonly id="mf_ref_no" /><span class="dash">-</span><!--
					--><input type="text" style="width:25px" name="mrn_chk_no" class="input2" readOnly></td>
					<th>MSN</th>
					<td><input type="text" style="width:60px;" name="mf_seq_no" class="input2" readonly id="mf_seq_no" /></td>
					<th>Confirm</th>
					<td><input type="text" style="width:30px;" name="mf_cfm_flg" class="input2" readonly id="mf_cfm_flg" /></td>
				</tr>
		   </tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<table>
			<colgroup>
				<col width="85">
				<col width="450" />
				<col width="105" />
				<col width="*" />
		   </colgroup>
		   <tbody>
				<tr>
					<th>Consignee</th>
					<td><input type="text" style="width:410px;" name="cnee" class="input2" readonly id="cnee" /></td>
					<th>ETA</th>
					<td><input type="text" style="width:130px;" name="grp_eta_dtl" class="input2" readonly id="grp_eta_dtl" /></td>
				</tr>
				<tr>
					<th>Notify</th>
					<td colspan="3"><input type="text" style="width:410px;" name="nfty" class="input2" readonly id="nfty" /></td>
				</tr>
		   </tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<table>
			<colgroup>
				<col width="85">
				<col width="450" />
				<col width="105" />
				<col width="170" />
				<col width="90" />
				<col width="*" />
		   </colgroup>
		   <tbody>
				<tr>
					<th>Package</th>
					<td><input type="text" style="width:100px;text-align:right" name="pck_qty" class="input2" readonly id="pck_qty" /><input type="text" style="width:25px;" name="pck_tp_cd" class="input2" readonly id="pck_tp_cd" /></td>
					<th>Weight</th>
					<td><input type="text" style="width:100px;text-align:right" name="act_wgt" class="input2" readonly id="act_wgt" /><input type="text" style="width:35px;" name="wgt_ut_cd" class="input2" readonly id="wgt_ut_cd" /></td>
					<th>Measure</th>
					<td><input type="text" style="width:60px;text-align:right" name="meas_qty" class="input2" readonly="" id="meas_qty" />&nbsp;<input type="text" style="width:35px" name="meas_ut_cd" class="input2" readOnly></td>
				</tr>
				<tr>
					<th>Description</th>
					<td><input type="text" style="width:410px;" name="cstms_desc" class="input2" readonly id="cstms_desc" /></td>
					<th>D/O No.</th>
					<td><input type="text" style="width:100px; text-align:center;" name="do_no" class="input2" readonly id="do_no" /></td>
					<th>Update Time</th>
					<td><input type="text" style="width:110; text-align:center;" name="evnt_dt" class="input2" readOnly></td>
				</tr>
				<tr>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" style="width:54px; text-align:center;" name="bkg_del_cd" class="input2" readonly id="bkg_del_cd" /><!--
					--><input type="text" style="width:120px; text-align:center;" name="mdm_loc_nm" class="input2" readonly="" id="mdm_loc_nm" /></td>
					<th>Term</th>
					<td colspan="3"><input type="text" style="width:100px; text-align:center;" name="del_term_cd" class="input2" readonly id="del_term_cd" /></td>
				</tr>
		   </tbody>
		</table>
		</div>
		<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="85">
				<col width="450">
				<col width="105">
				<col width="270">
				<col width="95">
				<col width="*">
		   </colgroup>
		   <tbody>
				<tr>
					<th>Entry Type</th>
					<td><input type="text" style="width:30px;" name="cstms_clr_tp_cd" class="input" id="cstms_clr_tp_cd" /><!--
					--><button type="button" id="btn_SearchEntryType" name="btn_SearchEntryType" class="input_seach_btn"></button></td>
					<th>Disch. CY</th>
					<td><input type="text" style="width:70px;" name="cstms_dchg_loc_wh_cd" class="input" id="cstms_dchg_loc_wh_cd" /><!--
					--><button type="button" id="btn_SearchDischCYCode" name="btn_SearchDischCYCode" class="input_seach_btn"></button><!--
					--><input type="text" style="width:148px;" name="loc_nm" class="input2" readonly disabled="true" id="loc_nm" /></td>
					<th>B/L Type</th>
					<td><script type="text/javascript">ComComboObject('combo2', 2, 40, 1);</script></td>
				</tr>
				<tr>
					<th>Bonded W/H</th>
					<td><input type="text" size="11" name="cstms_clr_wh_cd" class="input" maxlength="10" dataformat="num" id="cstms_clr_wh_cd" /><button type="button" id="btn_SearchWareHouse" name="btn_SearchWareHouse" class="input_seach_btn"></button><input type="text" style="width:200px;" name="wh_nm" class="input2" readonly disabled="true" id="wh_nm" /><input type="text" style="width:54px; text-align:center;" name="loc_cd" class="input2" readonly disabled="true" id="loc_cd" /></td>
					<th>Bonded Type</th>
					<td><script type="text/javascript">ComComboObject('combo1', 2, 40, 0, 1);</script></td>
					<td colspan="3"><font color="red"><div id="viaWebMsgDiv"></div></font></td>
				</tr>
		   </tbody>
		</table>
		</div>
		<div class="opus_design_inquiry" style="display:none;">
		<table>
			<colgroup>
				<col width="85">
				<col width="30">
				<col width="85">
				<col width="50">
				<col width="69">
				<col width="*">
		   </colgroup>
		   <tbody>
				<tr class="sm">
					<th>WHARFAGE Wave</th>
					<td><input type="radio" name="wharfage_wave" value="" class="trans" checked="" id="wharfage_wave1" /><label for="wharfage_wave1">Nill</label></td>
					<td><input type="radio" name="wharfage_wave" value="S" class="trans" id="wharfage_wave2" /><label for="wharfage_wave2">면제화주</label></td>
					<td><label for="whf_shpr_rgst_no">사업자등록번호</label><input type="text" style="width:100px;" name="whf_shpr_rgst_no" class="input" id="whf_shpr_rgst_no" /></td>
					<td><button type="button" id="btn_bizno" name="btn_bizno" class="input_seach_btn"></button></td>
					<td><input type="radio" name="wharfage_wave" value="N" class="trans" id="wharfage_wave3" /><label for="wharfage_wave3">Incl. OFT</label></td>
				</tr>
				</tbody>
			</table>
		<table>
			<colgroup>
				<col width="200">
				<col width="30">
				<col width="50">
				<col width="85">
				<col width="90">
				<col width="*">
		   </colgroup>
		   <tbody>
				<tr class="sm">
					<td style="padding-left:109px;"><input type="radio" name="wharfage_wave" value="D" class="trans" id="wharfage_wave4" /><label for="wharfage_wave4">Empty B/L</label></td>
					<td><input type="radio" name="wharfage_wave" value="X" class="trans" id="wharfage_wave5" /><label for="wharfage_wave5">화주 T/S</label></td>
					<td><input type="radio" name="wharfage_wave" value="I" class="trans" id="wharfage_wave6" /><label for="wharfage_wave6">우체국</label></td>
					<td><input type="radio" name="wharfage_wave" value="J" class="trans" id="wharfage_wave7" /><label for="wharfage_wave7">군화물</label></td>
					<td><input type="radio" name="wharfage_wave" value="K" class="trans" id="wharfage_wave8" /><label for="wharfage_wave8">조달청</label></td>
					<td><input type="radio" name="wharfage_wave" value="B" class="trans" id="wharfage_wave9" /><label for="wharfage_wave9">Bulk</label></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="layer1" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>