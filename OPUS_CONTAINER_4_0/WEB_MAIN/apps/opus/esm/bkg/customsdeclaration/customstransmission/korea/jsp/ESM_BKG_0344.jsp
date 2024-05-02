<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_0344.jsp
*@FileTitle : Korea Manifest Transmit
*@author : CLT
*@version : 1.0
*@since : 2014/09/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0344Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
String in_vvd = JSPUtil.getParameter(request, "in_vvd");
String in_pol = JSPUtil.getParameter(request, "in_pol");
String in_pol_yd = JSPUtil.getParameter(request, "in_pol_yd");
String in_pod = JSPUtil.getParameter(request, "in_pod");
String in_tml = JSPUtil.getParameter(request, "in_tml");
String in_type = JSPUtil.getParameter(request, "in_type");
String in_blno = JSPUtil.getParameter(request, "in_blno");
String in_bound = JSPUtil.getParameter(request, "in_bound");
String ib_vvd = JSPUtil.getParameter(request, "ib_vvd");
String ib_seq = JSPUtil.getParameter(request, "ib_seq");
String ib_cblno = JSPUtil.getParameter(request, "ib_cblno");
String ib_port = JSPUtil.getParameter(request, "ib_port");
String ib_bkgno = JSPUtil.getParameter(request, "ib_bkgno");
String ib_type = JSPUtil.getParameter(request, "ib_type");
String dwell = JSPUtil.getParameter(request, "dwell");

String[] isChecked = new String[2];
isChecked[0] = "";
isChecked[1] = "";
if ("O".equals(in_bound)) {
	isChecked[1] = "checked";
} else {
	isChecked[0] = "checked";
}


// InBound T/S 관련 변수들 처리
String[] ib_ts_seq = request.getParameterValues("ib_ts_seq");
String[] ib_ts_cblno = request.getParameterValues("ib_ts_cblno");
String[] ib_ts_port = request.getParameterValues("ib_ts_port");
String[] ib_ts_bkgno = request.getParameterValues("ib_ts_bkgno");
String[] ib_ts_type = request.getParameterValues("ib_ts_type");
String[] ib_ts_vvd = request.getParameterValues("ib_ts_vvd");
int ib_ts_cnt = 0;
%>

<script type="text/javascript">
	var selType = "<%=in_type%>";
	function setupPage() {
		loadPage();
	}
</script>
<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vvd_seq" id="vvd_seq" />
<input type="hidden" name="in_receiver" id="in_receiver" />
<input type="hidden" name="receiver" id="receiver" />
<input type="hidden" name="none_bl_in_type" id="none_bl_in_type" />
<input type="hidden" name="ib_seq" value="<%=ib_seq%>" id="ib_seq" />
<input type="hidden" name="ib_cblno" value="<%=ib_cblno%>" id="ib_cblno" />
<input type="hidden" name="ib_port" value="<%=ib_port%>" id="ib_port" />
<input type="hidden" name="ib_bkgno" value="<%=ib_bkgno%>" id="ib_bkgno" />
<input type="hidden" name="ib_type" value="<%=ib_type%>" id="ib_type" />
<input type="hidden" name="trans_pre_cnt" id="trans_pre_cnt" />
<input type="hidden" name="kt_pa" id="kt_pa" />
<input type="hidden" name="dchg_mzd_cd" id="dchg_mzd_cd" />
<input type="hidden" name="in_chg_meth" id="in_chg_meth" />
<input type="hidden" name="in_chg_port" id="in_chg_port" />
<input type="hidden" name="in_chg_comp" id="in_chg_comp" />
<input type="hidden" name="in_chg_eta" id="in_chg_eta" />
<input type="hidden" name="old_snd_chk" id="old_snd_chk" />
<input type="hidden" name="cancel_flg" id="cancel_flg" />
<input type="hidden" name="call_year" id="call_year" />
<input type="hidden" name="old_eta_dt" id="old_eta_dt" />
<!-- //↓↓↓↓↓↓↓↓↓↓/////////////////////////// -->
<input type="hidden" name="ff_div" id="ff_div" />
<!-- //↑↑↑↑↑↑↑↑↑↑/////////////////////////// -->

<%
if (ib_ts_seq != null) {
	ib_ts_cnt = ib_ts_seq.length;
	for(int i=0; i < ib_ts_seq.length; i++) {
%>
<input type="hidden" name="tsinfo_ibflag" value="A" id="tsinfo_ibflag" />
<input type="hidden" name="tsinfo_ib_ts_seq" value="<%=ib_ts_seq[i]%>" id="tsinfo_ib_ts_seq" />
<input type="hidden" name="tsinfo_ib_ts_cblno" value="<%=ib_ts_cblno[i]%>" id="tsinfo_ib_ts_cblno" />
<input type="hidden" name="tsinfo_ib_ts_port" value="<%=ib_ts_port[i]%>" id="tsinfo_ib_ts_port" />
<input type="hidden" name="tsinfo_ib_ts_bkgno" value="<%=ib_ts_bkgno[i]%>" id="tsinfo_ib_ts_bkgno" />
<input type="hidden" name="tsinfo_ib_ts_type" value="<%=ib_ts_type[i]%>" id="tsinfo_ib_ts_type" />
<input type="hidden" name="tsinfo_ib_ts_vvd" value="<%=ib_ts_vvd[i]%>" id="tsinfo_ib_ts_vvd" />
<%
	}
}
%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_DeleteManifest" id="btn_DeleteManifest" type="button">Delete Manifest</button><!--
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
		--><button class="btn_normal" name="btn_TransManifest_3G" id="btn_TransManifest_3G" type="button">Trans Manifest [3G]</button><!--
		--><button class="btn_normal" name="btn_TransManifest" id="btn_TransManifest" type="button">Trans Manifest [4G]</button><!--
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
		--><!-- button class="btn_normal" name="btn_trans_cancell_popup" id="btn_trans_cancell_popup" type="button">Trans Cancellation to Korean</button><br / --><!--
		--><button class="btn_normal" name="btn_TransperBL" id="btn_TransperBL">Trans per B/L</button><!--
		--><!-- button class="btn_normal" name="btn_CancelperBL" id="btn_CancelperBL">Cancel per B/L</button --><!--
		--><!-- button class="btn_normal" name="btn_TransAmendToPA" id="btn_TransAmendToPA">Trans Amendment to PA</button --><!--
		--><!-- button class="btn_normal" name="btn_TransCancellationToPA" id="btn_TransCancellationToPA">Trans Cancellation to PA</button --><!--
		--><!-- span id="emptyAmend_btn"><button class="btn_normal" name="btn_TransEmptyAmend" id="btn_TransEmptyAmend">Empty Amend</button></span -->
	</div>
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
		<table style="width:1000px; height:25px;">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px; text-align:center;" class="input1" value="<%=in_vvd%>" name="vvd" id="vvd" dataformat="engup" maxlength="9"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px; text-align:center;" class="input" value="<%=in_pol%>" name="pol_cd" id="pol_cd" dataformat="engup" maxlength="5"><!--
						--><input type="text" style="width:30px; text-align:center;" class="input" name="pol_yd_cd" id="pol_yd_cd" dataformat="engup" maxlength="2" value="<%=in_pol_yd%>"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px; text-align:center;" value="<%=in_pod%>" class="input1" name="pod_cd" id="pod_cd" dataformat="engup" maxlength="5"><!--
						--><input type="text" style="width:30px; text-align:center;" class="input" name="tml_cd" id="tml_cd" dataformat="engup" maxlength="2" value="<%=in_tml%>"></td>
					<th>Type</th>
					<td><select style="width:105px;" class="input" name="in_type" id="in_type"></select></td>
					<th>B/L No.</th>
					<td><input type="text" style="width:100px; text-align:center;" value="<%=in_blno%>" class="input" name="bl_no" id="bl_no" dataformat="engup" maxlength="12"></td>
					<td class="sm pad_left_4"><input type="radio" value="I" class="trans" name="io_bnd_cd" id="io_bnd_cd" <%=isChecked[0]%> > <label for="io_bnd_cd"><strong>I/B</strong></label> </td>
					<td class="sm"><input type="radio" value="O" class="trans" name="io_bnd_cd" id="io_bnd_cd" <%=isChecked[1]%> > <label for="io_bnd_cd"><strong>O/B</strong></label> </td>
					<th style="visibility:hidden;">Receiver</th>
					<td style="visibility:hidden;"><script type="text/javascript">ComComboObject("combo1", 2, 50, 1);</script></td>
					<th style="visibility:hidden; text-align:left;"><span id="span_trans">Trans &nbsp; <select name="trans_target" id="trans_target" onChange="javascript:transTargetChange()";>
						<option value="A" selected>All</option>
						<option value="D">Discharge</option>
						<option value="M">Manifest</option>
						</select></span></th>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_inquiry">
		<h3 class="title_design">Vessel Information</h3>
		<table>
			<colgroup>
				<col width="110" />
				<col width="230" />
				<col width="90" />
				<col width="90" />
				<col width="120" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Vessel Full Name</th>
					<td><input type="text" style="width:220px;" class="input" maxlength="50" name="vsl_nm" id="vsl_nm"></td>
					<th>VSL Country</th>
					<td><input type="text" style="width:50px;" class="input" value="" name="vsl_cnt_cd" id="vsl_cnt_cd"></td>
					<th>Shipping Co. Code</th>
					<td><input type="text" style="width:100px;" value="" class="input" maxlength="4" name="shp_co_cd" id="shp_co_cd"></td>
				</tr>
				<tr style="display:none">
					<th>Discharge Company</th>
					<td><input type="text" style="width:150px;" class="input" name="cstms_dchg_cd" id="cstms_dchg_cd" value="030197004" onchange="javascript:funcChange('ZH3');"></td>
					<th></th>
					<td></td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>Call Sign</th>
					<td><input type="text" style="width:100px;" value="" class="input" name="vsl_call_sgn_cd" id="vsl_call_sgn_cd"></td>
					<th>ETA</th>
					<td><input type="text" style="width:100px;" class="input" maxlength="10" name="eta_dt" id="eta_dt" dataformat="ymd" onChange="javascript:funcChange('AI');"></td>
					<th>ETD</th>
					<td><input type="text" style="width:120px;" maxlength="16" class="input" name="etd_dt" id="etd_dt" dataformat="ymdhm"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="8"></td></tr></table></div>
	<div class="opus_design_inquiry ">
		<h3 class="title_design">Manifest Information</h3>
		<table>
			<colgroup>
				<col width="130">
				<col width="190">
				<col width="90">
				<col width="145">
				<col width="120">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Send Date/Time</th>
					<td><input type="text" style="width:80px;" class="input2" value="" name="f_date" id="f_date" ReadOnly><!--
						--><input type="text" style="width:65px;" class="input2" value="" name="t_date" id="t_date" ReadOnly><!--
						--><input type="text" style="width:30px;" class="input2" value="" name="mf_snd_rcvr_id" id="mf_snd_rcvr_id" ReadOnly></td>
					<th>MRN No.</th>
					<td><input type="text" style="width:100px;" class="input2" value="" name="mrn_no" id="mrn_no" ReadOnly></td>
					<th>Bond Area Code</th>
					<td><input type="text" style="width:100px;" class="input2" value="" name="bd_area_cd" id="bd_area_cd"><!--
						--><button type="button" class="input_seach_btn" name="btn_searchBondArea" id="btn_searchBondArea"></button></td>
				</tr>
				<tr>
					<th>입항 횟수</th>
					<td><input type="text" style="width:40px; text-align:center" class="input1" value="" name="call_knt" id="call_knt" maxlength="3" dataformat="int"></td>
					<th>하역방법 Code</th>
					<td><script type="text/javascript">ComComboObject("combo2", 2, 50, 1);</script></td>
					<th>반출입부두 Code</th>
					<td><input type="text" style="width:80px; text-align:center" class="input1" maxlength="5" dataformat="engup" name="io_tml_loc_cd" id="io_tml_loc_cd" onchange="javascript:funcChange('ZH2');"><!--
						--><button type="button" class="input_seach_btn" name="btn_searchTmlLoc" id="btn_searchTmlLoc"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="8"></td></tr></table></div>
	<div class="opus_design_inquiry">
		<h3 class="title_design">Detail(s) Information</h3>
		<table>
			<colgroup>
				<col width="120">
				<col width="170">
				<col width="120">
				<col width="95">
				<col width="120">
				<col width="150">
				<col width="115">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Local Customs</th>
					<td><input type="text" style="width:40px;" class="input" value="" name="locl_cstms_cd" id="locl_cstms_cd" maxlength="3"><!--
						--><input type="text" style="width:35px;" class="input" value="" name="locl_cstms_prt_cd" id="locl_cstms_prt_cd" maxlength="2"></td>
					<th>Master B/L Total</th>
					<td><input type="text" style="width:70px; text-align:right;" class="input2" value="" name="mst_bl_knt" id="mst_bl_knt" ReadOnly></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>Weight</th>
					<td><input type="text" style="width:110px;text-align:right" class="input2" value="" name="ttl_wgt" id="ttl_wgt" ReadOnly><!--
						--><input type="text" style="width:35px;" class="input2" name="ttl_wgt_ut_cd" id="ttl_wgt_ut_cd" ReadOnly></td>
					<th>Empty B/L Total</th>
					<td><input type="text" style="width:70px; text-align:right;" class="input2" value="" name="mty_bl_knt" id="mty_bl_knt" ReadOnly></td>
					<td></td>
					<td><input type="text" style="width:40px;text-align:right;  background-Color:#E3D9C9; font-weight:bold; " value="20`" class="input2" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right;  background-Color:#E3D9C9; font-weight:bold;" value="40`" class="input2"><!--
						--><input type="text" style="width:40px;text-align:right; background-Color:#E3D9C9; font-weight:bold;" value="45`" class="input2" ReadOnly></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>Package</th>
					<td><input type="text" style="width:110px;text-align:right" class="input2" value="" name="ttl_pck_qty" id="ttl_pck_qty" ReadOnly><!--
						--><input type="text" style="width:35px;" class="input2" name="ttl_pck_ut_cd" id="ttl_pck_ut_cd" ReadOnly></td>
					<th>Consol B/L Total</th>
					<td><input type="text" style="width:70px; text-align:right;" class="input2" value="" name="cnsl_bl_knt" id="cnsl_bl_knt" ReadOnly></td>
					<th>Local Container</th>
					<td><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_lc_teu_qty" id="ttl_lc_teu_qty" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_lc_feu_qty" id="ttl_lc_feu_qty" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_lc_45ft_qty" id="ttl_lc_45ft_qty" ReadOnly></td>
					<th><span id="whf_notice_txt">I/B WHF 허가번호</span></th>
					<td><input type="text" style="width:80px; text-align:right;" class="input2" value="" name="whf_notice" id="whf_notice" ReadOnly></td>
				</tr>
				<tr>
					<th>Measure</th>
					<td><input type="text" style="width:110px;text-align:right" class="input2" value="" name="ttl_meas_qty" id="ttl_meas_qty" ReadOnly><!--
						--><input type="text" style="width:35px;" class="input2" name="ttl_meas_ut_cd" id="ttl_meas_ut_cd" ReadOnly></td>
					<th>Simple B/L Total</th>
					<td><input type="text" style="width:70px; text-align:right;" class="input2" value="" name="smp_bl_knt" id="smp_bl_knt" ReadOnly></td>
					<th>T/S Container</th>
					<td><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_ts_teu_qty" id="ttl_ts_teu_qty" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_ts_feu_qty" id="ttl_ts_feu_qty" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_ts_45ft_qty" id="ttl_ts_45ft_qty" ReadOnly></td>
					<th><span id="ib_vvd_txt">Inbound VVD</span></th>
					<td><input type="text" style="width:80px; text-align:right;" class="input2" value="<%=ib_vvd%>" name="ib_vvd" id="ib_vvd" ReadOnly></td>
				</tr>
				<tr>
					<th>Joint Ship Count</th>
					<td><input type="text" style="width:30px;text-align:right" class="input2" value="" name="jo_crr_knt" id="jo_crr_knt" ReadOnly></td>
					<th>Full CNTR Total</th>
					<td><input type="text" style="width:70px; text-align:right" class="input2" value="" name="ttl_full_knt" id="ttl_full_knt" ReadOnly></td>
					<th>Empty Container</th>
					<td><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_mty_teu_qty" id="ttl_mty_teu_qty" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_mty_feu_qty" id="ttl_mty_feu_qty" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_mty_45ft_qty" id="ttl_mty_45ft_qty" ReadOnly></td>
					<th><span id="dwell_txt">Dwell</span></th>
					<td><input type="text" style="width:80px; text-align:right;" class="input2" value="<%=dwell%>" name="dwell" id="dwell" ReadOnly></td>
				</tr>
				<tr>
					<td colspan="2"></td>
					<th>Empty CNTR Total</th>
					<td><input type="text" style="width:70px; text-align:right" class="input2" value="" name="ttl_mty_knt" id="ttl_mty_knt" ReadOnly></td>
					<th>T/S Empty CNTR</th>
					<td><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_ts_mty_teu_qty" id="ttl_ts_mty_teu_qty" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_ts_mty_feu_qty" id="ttl_ts_mty_feu_qty" ReadOnly><!--
						--><input type="text" style="width:40px;text-align:right" value="" class="input2" name="ttl_ts_mty_45ft_qty" id="ttl_ts_mty_45ft_qty" ReadOnly></td>
					<th><span id="ib_bl_cnt_txt">B/L</span></th>
					<td><input type="text" style="width:80px; text-align:right;" class="input2" value="<%=ib_ts_cnt%>" name="ib_bl_cnt" id="ib_bl_cnt" ReadOnly></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
</div>
</form>
