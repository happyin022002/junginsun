<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String blNo = request.getParameter("bl_no")==null ? "":request.getParameter("bl_no");
%>
<html>
<head>
<title>Welcome to Alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){

	    loadPage();
    }

</script>
</head>
<body  onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="io_bnd_cd" value="I">
<input type="hidden" name="mrn_bl_ts_cd">
<input type="hidden" name="bd_tp_cd">
<input type="hidden" name="kr_cstms_bl_tp_cd">
<input type="hidden" name="bkg_rt_whf_expt_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="clt_ofc_cd">
<input type="hidden" name="yard">
<input type="hidden" name="grp_mrn">
<input type="hidden" name="grp_mrn_chk">
<input type="hidden" name="grp_vvd">
<input type="hidden" name="grp_pol">
<input type="hidden" name="grp_pod">
<input type="hidden" name="grp_etd">
<input type="hidden" name="grp_eta">
<input type="hidden" name="grp_eta_dtl">
<input type="hidden" name="viaWebMsg" id="viaWebMsg">
<input type="hidden" name="upd_usr_id">
<input type="hidden" name="bdr_flg">
<input type="hidden" name="whf_wave">
<input type="hidden" name="err_msg">
<input type="hidden" name="bfr_whf_wave" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->


	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search_sm2" border="0" style="width:636;">
				<tr class="h23">
					<td width="83"><input type="radio" name="search_type" value="search_by_bl_no" class="trans" checked>&nbsp;&nbsp;B/L No.</td>
					<td width="160"><input type="text" name="bl_no" style="width:110; text-align:center;" maxlength="12" class="input1" style="ime-mode:disabled" dataformat="engupnum" value="<%=blNo%>"></td>
					<td width="90"><input type="radio" name="search_type" value="search_by_bkg_no" class="trans">&nbsp;&nbsp;BKG No.</td>
					<td width=""><input type="text" name="bkg_no" style="width:110; text-align:center;" maxlength="12" class="input1" style="ime-mode:disabled" dataformat="engupnum"></td>
				</tr>
				</table>

		</td>
		</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>

		<table class="search">
       	<tr><td class="bg">

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;VVD</td>
					<td width="140"><input type="text" style="width:100" name="vvd" class="input2" readOnly></td>
					<td width="30">Type</td>
					<td width="105"><input type="text" style="width:60" name="local_ts" class="input2" readOnly></td>
					<td width="30">MRN</td>
					<td width="210"><input type="text" style="width:100" name="mf_ref_no" class="input2" readOnly>&nbsp;-&nbsp;<input type="text" style="width:25" name="mrn_chk_no" class="input2" readOnly></td>
					<td width="60">MSN</td>
					<td width="125"><input type="text" style="width:60" name="mf_seq_no" class="input2" readOnly></td>
					<td width="30">Confirm</td>
					<td width=""><input type="text" style="width:30" name="mf_cfm_flg" class="input2" readOnly></td>
				</tr>
				</table>

		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;Consignee</td>
					<td width=""><input type="text" style="width:405" name="cnee" class="input2" readOnly></td>
					<td width="65">&nbsp;&nbsp;ETA</td>
					<td width="315"><input type="text" style="width:130" name="grp_eta_dtl" class="input2" readOnly></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;&nbsp;Notify</td>
					<td width=""><input type="text" style="width:405" name="nfty" class="input2" readOnly></td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0">
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;Package</td>
					<td width="260"><input type="text" style="width:100;text-align:right" name="pck_qty" class="input2" readOnly>&nbsp;<input type="text" style="width:25" name="pck_tp_cd" class="input2" readOnly></td>
					<td width="50">Weight</td>
					<td width="210"><input type="text" style="width:101;text-align:right" name="act_wgt" class="input2" readOnly>&nbsp;<input type="text" style="width:35" name="wgt_ut_cd" class="input2" readOnly></td>
					<td>Measure&nbsp;
						<input type="text" style="width:60;text-align:right" name="meas_qty" class="input2" readOnly>&nbsp;<input type="text" style="width:35" name="meas_ut_cd" class="input2" readOnly></td>
				</tr>
				<tr class="h23">
					<td>&nbsp;&nbsp;Description</td>
					<td colspan="3"><input type="text" style="width:405" name="cstms_desc" class="input2" readOnly></td>
					<td rowspan="2">
						<table class="search_sm2" border="0">
							<tr class="h23">
								<td>D/O No.&nbsp;<input type="text" style="width:85; text-align:center;" name="do_no" class="input2" readOnly>
									&nbsp;&nbsp;Update Time&nbsp;<input type="text" style="width:110; text-align:center;" name="evnt_dt" class="input2" readOnly></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr class="h23">
					<td>&nbsp;&nbsp;DEL</td>
					<td><input type="text" style="width:54; text-align:center;" name="bkg_del_cd" class="input2" readOnly>
						<input type="text" style="width:120; text-align:center;" name="mdm_loc_nm" class="input2" readOnly></td>
					<td>&nbsp;&nbsp;Term</td>
					<td><input type="text" style="width:90; text-align:center;" name="del_term_cd" class="input2" readOnly></td>
				</tr>
				</table>
		</td>
		</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search">
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;Entry Type</td>
					<td width="80"><input type="text" style="width:30" name="cstms_clr_tp_cd" class="input">&nbsp;<img class="cursor" name="btn_SearchEntryType" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="80">Carry-in CY</td>
					<td width="360"><input type="text" style="width:70" name="cstms_dchg_loc_wh_cd" class="input">&nbsp;<img class="cursor" name="btn_SearchDischCYCode" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" style="width:148" name="loc_nm" class="input2" readOnly disabled="true"></td>
					<td width="70">Disch. CY</td>
					<td width="75"><input type="text" style="width:70" name="cstms_crr_in_loc_wh_cd" class="input2" readOnly></td>
					<td width="150" colspan="2"><input type="text" style="width:148" name="cstms_crr_in_loc_wh_nm" class="input2" readOnly disabled="true"></td>
					<td width="74"></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;&nbsp;Bonded W/H</td>
					<td width="" colspan="3"><input type="text" size="11" name="cstms_clr_wh_cd" class="input" maxlength="10" dataformat="int">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_SearchWareHouse">&nbsp;<input type="text" style="width:200" name="wh_nm" class="input2" ReadOnly disabled="true">&nbsp;<input type="text" style="width:54; text-align:center;" name="loc_cd" class="input2" ReadOnly disabled="true"></td>
					<td width="">B/L Type</td>
					<td width=""><script language="javascript">ComComboObject('combo2', 2, 40, 1);</script></td>
					<td width="">Bonded Type</td>
					<td width=""><script language="javascript">ComComboObject('combo1', 2, 40, 0, 1);</script></td>
					<td></td>
					<td><font color = "red"><div id="viaWebMsgDiv"></div></font></td>
				</tr>
				<tr class="h23">
					<td width=""> </td>
					<td width=""> </td>
					<td width=""> </td>
					<td width=""> </td>
					<td width="58">Total Vol.</td>
					<td colspan="4"><input type="text" name="total_vol" style="width:280;" class="input2" value="" readonly></td>
				</tr>
				</table>
		</td>
		</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search">
       	<tr><td class="bg">
				<table class="search_sm" border="0" style="width:850;">
				<tr class="h23">
					<td width="120" valign="top">WHARFAGE Waive</td>
					<td width="" class="stm"><input type="radio" name="wharfage_wave" id="wharfage_wave" value="" class="trans" checked>&nbsp;&nbsp;Nill&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="wharfage_wave" id="wharfage_wave" value="S" class="trans" >&nbsp;&nbsp;Exempted customer by BPA (면제화주)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사업자등록번호&nbsp;<input type="text" style="width:100" name="whf_shpr_rgst_no" class="input">&nbsp;<img class="cursor" name="btn_bizno" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="wharfage_wave" id="wharfage_wave" value="N" class="trans">&nbsp;&nbsp;Incl. OFT</td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;</td>
					<td width="" class="stm"><input type="radio" name="wharfage_wave" id="wharfage_wave" value="D" class="trans">&nbsp;&nbsp;Empty B/L&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="wharfage_wave" id="wharfage_wave" value="X" class="trans" >&nbsp;&nbsp;Customer's own T/S arrangement (화주 T/S)&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="wharfage_wave" id="wharfage_wave" value="I" class="trans">&nbsp;Mailbox (우체국)&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="wharfage_wave" id="wharfage_wave" value="J" class="trans" >&nbsp;&nbsp;Military Cargo (군화물)</td>
				</tr><tr class="h23">
					<td width="">&nbsp;</td>
					<td width="" class="stm"><input type="radio" name="wharfage_wave" id="wharfage_wave" value="K" class="trans" >&nbsp;&nbsp;Procurement (조달청)&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="wharfage_wave" id="wharfage_wave" value="C" class="trans">&nbsp;&nbsp;Sub-charter (기타 선사 자체 신고)&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="wharfage_wave" id="wharfage_wave" value="B" class="trans" >&nbsp;&nbsp;Bulk</td>
				</tr>
				</table>

			<!--  biz_1  (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_deleteWhf" id="btn_deleteWhf">DELETE WHF</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_adjustWhf" id="btn_adjustWhf">ADJUST WHF</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ARIF">A/R I/F</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_GotoInvoice">Go to Invoice</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<script language="javascript">ComSheetObject('sheet1');</script>
			<div id="layer1" style="border-width:1px; display:none; position:absolute; width:200; height=130; left:200; z-index:1;">
			<script language="javascript">ComSheetObject('sheet2');</script>
			</div>
		</td>
		</tr>
		</table>

	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_GroupMSN">Group MSN</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CargoRelease">Cargo Release</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
	</table>
</form>
</body>
</html>