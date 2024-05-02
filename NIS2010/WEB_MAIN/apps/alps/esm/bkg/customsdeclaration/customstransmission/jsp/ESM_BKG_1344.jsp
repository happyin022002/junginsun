<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1344.jsp
 *@FileTitle : Korea Manifest Transmit
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.02
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.02 손윤석
 * 1.0 Creation
 *---------------------------------------------------------
 * history
 =========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%

String in_vvd = request.getParameter("in_vvd");
String in_pol = request.getParameter("in_pol");
String in_pod = request.getParameter("in_pod");
String in_type = request.getParameter("in_type");
String in_blno = request.getParameter("in_blno");
String in_bound = request.getParameter("in_bound");
String in_tml    = request.getParameter("in_tml");
String ib_vvd    = request.getParameter("ib_vvd");
String ib_seq    = request.getParameter("ib_seq");
String ib_cblno    = request.getParameter("ib_cblno");
String ib_port    = request.getParameter("ib_port");
String ib_bkgno    = request.getParameter("ib_bkgno");
String ib_type    = request.getParameter("ib_type");
String dwell    = request.getParameter("dwell");

if(in_vvd   == null) in_vvd   = "";
if(in_pol   == null) in_pol   = "";
if(in_pod   == null) in_pod   = "";
if(in_type  == null) in_type  = "";
if(in_blno  == null) in_blno  = "";
if(in_bound == null) in_bound = "";
if(in_tml   == null) in_tml   = "";
if(ib_vvd   == null) ib_vvd   = "";
if(ib_seq   == null) ib_seq   = "";
if(ib_cblno   == null) ib_cblno   = "";
if(ib_port   == null) ib_port   = "";
if(ib_bkgno   == null) ib_bkgno   = "";
if(ib_type   == null) ib_type   = "";
if(dwell   == null) dwell   = "";
String[] isSelected = new String[5];

for(int i=0;i<5;i++)
{
	isSelected[i] = "";
}
if("A".equals(in_type)) isSelected[1] = "selected";
else if("B".equals(in_type)) isSelected[2] = "selected";
else if("C".equals(in_type)) isSelected[3] = "selected";
else if("D".equals(in_type)) isSelected[4] = "selected";
else	isSelected[0] = "selected";

String[] isChecked = new String[2];
isChecked[0] = "";
isChecked[1] = "";
if("O".equals(in_bound)) isChecked[1] = "checked";
else				     isChecked[0] = "checked";


// InBound T/S 관련 변수들 처리
String[] ib_ts_seq = request.getParameterValues("ib_ts_seq");
String[] ib_ts_cblno = request.getParameterValues("ib_ts_cblno");
String[] ib_ts_port = request.getParameterValues("ib_ts_port");
String[] ib_ts_bkgno = request.getParameterValues("ib_ts_bkgno");
String[] ib_ts_type = request.getParameterValues("ib_ts_type");
String[] ib_ts_vvd = request.getParameterValues("ib_ts_vvd");
int ib_ts_cnt = 0;
%>

<html>
<head>
<title>Welcome to Alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<script language="javascript">
    function setupPage()
    {
	    loadPage();
    }
</script>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvd_seq">
<input type="hidden" name="in_receiver">
<input type="hidden" name="receiver">
<input type="hidden" name="none_bl_in_type">
<input type="hidden" name="in_type" 	value="<%=in_type%>">
<input type="hidden" name="ib_seq" 		value="<%=ib_seq%>">
<input type="hidden" name="ib_cblno"	value="<%=ib_cblno%>">
<input type="hidden" name="ib_port" 	value="<%=ib_port%>">
<input type="hidden" name="ib_bkgno" 	value="<%=ib_bkgno%>">
<input type="hidden" name="ib_type" 	value="<%=ib_type%>">
<input type="hidden" name="trans_pre_cnt">
<input type="hidden" name="kt_pa">
<input type="hidden" name="dchg_mzd_cd">
<input type="hidden" name="in_chg_meth">
<input type="hidden" name="in_chg_port">
<input type="hidden" name="in_chg_comp">
<input type="hidden" name="in_chg_eta">
<input type="hidden" name="old_snd_chk">
<input type="hidden" name="cancel_flg">
<input type="hidden" name="call_year">
<input type="hidden" name="old_eta_dt">
<%
if (ib_ts_seq!=null) {
	ib_ts_cnt = ib_ts_seq.length;
	for(int i=0; i < ib_ts_seq.length; i++)
	{
%>
<input type="hidden" name="tsinfo_ibflag" 		value="A">
<input type="hidden" name="tsinfo_ib_ts_seq" 	value="<%=ib_ts_seq[i]%>">
<input type="hidden" name="tsinfo_ib_ts_cblno" 	value="<%=ib_ts_cblno[i]%>">
<input type="hidden" name="tsinfo_ib_ts_port" 	value="<%=ib_ts_port[i]%>">
<input type="hidden" name="tsinfo_ib_ts_bkgno" 	value="<%=ib_ts_bkgno[i]%>">
<input type="hidden" name="tsinfo_ib_ts_type" 	value="<%=ib_ts_type[i]%>">
<input type="hidden" name="tsinfo_ib_ts_vvd"	value="<%=ib_ts_vvd[i]%>">
<%
	}
}
%>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->


		<!--Button (S) -->

    	<!--Button (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

			<!--  biz_1 (S) -->

				<table border="0" cellpadding="0" cellspacing="0">
					<tr class="h23">
						<td width="40" align='right'>VVD</td>
						<td width="100"><input type="text" style="width:100%; text-align:center;" class="input1" value="<%=in_vvd%>" name='vvd' dataformat="eng"  maxlength="9"></td>
						<td width="40" align='right' style="display:none;">POL</td>
						<td width="60" style="display:none;"><input type="text" style="width:100%; text-align:center;" class="input" value="<%=in_pol%>" name='pol_cd' dataformat="eng" maxlength="5"></td>
						<td width="40" align='right'>POD</td>
						<td width="110"><input type="text" style="width:60; text-align:center;" value="<%=in_pod%>" class="input1" name='pod_cd' dataformat="eng" maxlength="5">
						<input type="text" style="width:30; text-align:center;" class="input" name='tml_cd' dataformat="eng" maxlength="2" value="<%=in_tml%>">
						</td>
						<td width="40" align='right'>Type&nbsp;</td>
						<td width="100"><script language="javascript">ComComboObject('combo2', 2, 50, 1, 1);</script></td>
						<td width="60" align='right'>B/L No.</td>
						<td width="140"><input type="text" style="width:120; text-align:center;" value="<%=in_blno %>" class="input" name='bl_no' dataformat="eng" maxlength="12"></td>
						<td width="80">
							<table class="search_sm2" border="0" style="width:100%;">
							<tr class="h23">
								<td class="">
									<input type="radio" value="I" class="trans" name='io_bnd_cd' <%=isChecked[0] %>>&nbsp;I/B&nbsp;
									<input type="radio" value="O" class="trans" name='io_bnd_cd' <%=isChecked[1] %> style="display:none;">
<!--
									&nbsp;O/B
-->
									</td>
							</tr>
							</table></td>
						<td width="60" style="display:none;">Receiver</td>
						<td width="60" style="display:none;">
						<script language="javascript">ComComboObject('combo1', 2, 50, 1);</script>
						</td>
						<td width="160" style="display:none;"><span id="span_trans">Trans &nbsp; <select name="trans_target" onChange="transTargetChange()">
						<option value="A" SELECTED>All</option>
						<option value="D">Discharge</option>
						<option value="M">Manifest</option>
						</select>
						</span>
						</td>
					</tr>
				</table>
				</td></tr></table>
				<!--  biz_1 (E) -->

		<table class="height_8"><tr><td></td></tr></table>

		<!--biz 2 (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Vessel Information</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="110">Vessel Full Name</td>
						<td width="230"><input type="text" style="width:220;" class="input" maxlength="50" name="vsl_nm"></td>
						<td width="90">VSL Country</td>
						<td width="90"><input type="text" style="width:50;" class="input" name="vsl_cnt_cd"></td>
						<td width="120">Shipping Co. Code</td>
						<td width="140"><input type="text" style="width:100;" class="input" maxlength="4" name="shp_co_cd"></td>
						<td width="55">Call Sign</td>
						<td align="right"><input type="text" style="width:100;" class="input" name="vsl_call_sgn_cd"></td>
					</tr>
					<tr class="h23">
						<td>Discharge Company</td>
						<td><input type="text" style="width:150;" class="input" name="cstms_dchg_cd" value="030197004" onchange="javascript:funcChange('ZH3');"></td>
						<td>ETA</td>
						<td><input type="text" style="width:100;" class="input" maxlength="10" name="eta_dt" dataformat="ymd" onChange="javascript:funcChange('AI');"></td>
						<td>ETD</td>
						<td><input type="text" style="width:100;" maxlength="10" class="input" name="etd_dt" dataformat="ymd"></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				<!--  biz_2   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--biz 2 (S)-->

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Manifest Information</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="129">Send Date/Time</td>
						<td width="190"><input type="text" style="width:80;" class="input2" name="f_date" ReadOnly>&nbsp;<input type="text" style="width:65;" class="input2" name="t_date" ReadOnly>&nbsp;<input type="text" style="width:30;" class="input2" name="mf_snd_rcvr_id" ReadOnly></td>
						<td width="90">MRN No.</td>
						<td width="145"><input type="text" style="width:100;" class="input2" name="mrn_no" ReadOnly></td>
						<td width="120">Bond Area Code</td>
						<td><input type="text" style="width:100;" class="input2" name="bd_area_cd">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_searchBondArea"></td>
					</tr>
					<tr class="h23">
						<td style="visibility:hidden;">입항 횟수</td>
						<td style="visibility:hidden;"><input type="text" style="width:40; text-align:center;" class="input1" name="call_knt" maxlength="3" dataformat="int" onChange="javascript:call_knt_change()"></td>
						<td>하역방법 Code</td>
						<td style="padding-left:2;"><script language="javascript">ComComboObject('combo3', 2, 50, 1);</script></td>
						<td style="visibility:hidden;">반출입부두 Code</td>
						<td style="visibility:hidden;"><input type="text" style="width:80; text-align:center" class="input1" maxlength="5" dataformat="eng" name="io_tml_loc_cd" onchange="javascript:funcChange('ZH2');">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_searchTmlLoc"></td>
					</tr>
				</table>
				<!--  biz_2   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--biz 2 (S)-->

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Detail(s) Information</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td>Local Customs</td>
						<td>
							<input type="text" style="width:40;" class="input" name="locl_cstms_cd" maxlength="3">&nbsp;
							<input type="text" style="width:35;" class="input" name="locl_cstms_prt_cd" maxlength="2">
						</td>
						<td>Master B/L Total</td>
						<td><input type="text" style="width:70; text-align:right;" class="input2" name="mst_bl_knt" ReadOnly></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="h23">
						<td width="120">Weight</td>
						<td width="170"><input type="text" style="width:110;text-align:right" class="input2" name="ttl_wgt" ReadOnly>&nbsp;<input type="text" style="width:35;" class="input2" name="ttl_wgt_ut_cd" ReadOnly></td>
						<td width="120">Empty B/L Total</td>
						<td width="95"><input type="text" style="width:70; text-align:right;" class="input2" name="mty_bl_knt" ReadOnly></td>
						<td width="120"></td>
						<td width="150"><input type="text" style="width:40;text-align:right;  background-Color:#E3D9C9; font-weight:bold; " value="20`" class="input2" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right;  background-Color:#E3D9C9; font-weight:bold;" value="40`" class="input2">&nbsp;<input type="text" style="width:40;text-align:right; background-Color:#E3D9C9; font-weight:bold;" value="45`" class="input2" ReadOnly></td>
						<td width="115"></td>
						<td width="89"></td>
					</tr>
					<tr class="h23">
						<td>Package</td>
						<td><input type="text" style="width:110;text-align:right" class="input2" name="ttl_pck_qty" ReadOnly>&nbsp;<input type="text" style="width:35;" class="input2" name="ttl_pck_ut_cd" ReadOnly></td>
						<td>Consol B/L Total</td>
						<td><input type="text" style="width:70; text-align:right;" class="input2" name="cnsl_bl_knt" ReadOnly></td>
						<td>Local Container</td>
						<td><input type="text" style="width:40;text-align:right" class="input2" name="ttl_lc_teu_qty" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right" class="input2" name="ttl_lc_feu_qty" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right" class="input2" name="ttl_lc_45ft_qty" ReadOnly></td>
						<td><span id="whf_notice_txt">I/B WHF 허가번호</span></td>
						<td><input type="text" style="width:80; text-align:right;" class="input2" name="whf_notice" ReadOnly></td>
					</tr>
					<tr class="h23">
						<td>Measure</td>
						<td><input type="text" style="width:110;text-align:right" class="input2" name="ttl_meas_qty" ReadOnly>&nbsp;<input type="text" style="width:35;" class="input2" name="ttl_meas_ut_cd" ReadOnly>
						</td>
						<td>Simple B/L Total</td>
						<td><input type="text" style="width:70; text-align:right;" class="input2" name="smp_bl_knt" ReadOnly></td>
						<td>T/S Container</td>
						<td><input type="text" style="width:40;text-align:right" class="input2" name="ttl_ts_teu_qty" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right" class="input2" name="ttl_ts_feu_qty" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right" class="input2" name="ttl_ts_45ft_qty" ReadOnly></td>
						<td><span id="ib_vvd_txt">Inbound VVD</span></td>
						<td><input type="text" style="width:80; text-align:right;" class="input2" value="<%=ib_vvd%>" name="ib_vvd" ReadOnly></td>
					</tr>
					<tr class="h23">
						<td>Joint Ship Count</td>
						<td><input type="text" style="width:30;text-align:right" class="input2" name="jo_crr_knt" ReadOnly></td>
						<td>Full CNTR Total</td>
						<td><input type="text" style="width:70; text-align:right" class="input2" name="ttl_full_knt" ReadOnly></td>
						<td>Empty Container</td>
						<td><input type="text" style="width:40;text-align:right" class="input2" name="ttl_mty_teu_qty" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right" class="input2" name="ttl_mty_feu_qty" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right" class="input2" name="ttl_mty_45ft_qty" ReadOnly></td>
						<td><span id="dwell_txt">Dwell</span></td>
						<td><input type="text" style="width:80; text-align:right;" class="input2" value="<%=dwell%>" name="dwell" ReadOnly></td>
					</tr>
					<tr class="h23">
						<td colspan="2"></td>
						<td>Empty CNTR Total</td>
						<td><input type="text" style="width:70; text-align:right" class="input2" name="ttl_mty_knt" ReadOnly></td>
						<td>T/S Empty CNTR</td>
						<td><input type="text" style="width:40;text-align:right" class="input2" name="ttl_ts_mty_teu_qty" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right" class="input2" name="ttl_ts_mty_feu_qty" ReadOnly>&nbsp;<input type="text" style="width:40;text-align:right" class="input2" name="ttl_ts_mty_45ft_qty" ReadOnly></td>
						<td><span id="ib_bl_cnt_txt">B/L</span>&nbsp;</td>
						<td><input type="text" style="width:80; text-align:right;" class="input2" value="<%=ib_ts_cnt%>" name="ib_bl_cnt" ReadOnly></td>
					</tr>
				</table>
				<!--  biz_2   (E) -->
				</td></tr></table>



		<!--biz page (E)-->
		<table width="100%"  id="mainTable">
			<tr><td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
		</table>

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; display:none;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransperBL">Trans per B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CancelperBL">Cancel per B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransAmendToPA">Trans Amendment to PA</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransCancellationToPA">Trans Cancellation to PA</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line" id="emptyAmend_line"></td>

				<td id="emptyAmend_btn"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransEmptyAmend">Empty Amend</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DeleteManifest">Delete Manifest</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransManifest" id="btn_TransManifest">Trans Manifest</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

    <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:15; display:none;">
       	<tr><td>
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_trans_cancell_popup">Trans Cancellation to Korean</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>

</td></tr></table>

</form>
</body>
</html>
