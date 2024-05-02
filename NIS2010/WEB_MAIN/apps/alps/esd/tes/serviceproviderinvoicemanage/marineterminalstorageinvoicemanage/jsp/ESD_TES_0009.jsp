<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_009.jsp
*@FileTitle : Marine Terminal Strorage Invoice관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-27
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-27 byungheeyoo 
* 1.0 최초 생성
* 2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가
* 2011.08.17 박정일 [E-mail요청] [TES] special character, characterSet problem
* 2015-08-24 김영신 [CHM-201536553] ODCY, MR Storage관련 로직 및 UI 변경 요청건 
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0009Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tescommon.util.TESUtil"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl"%>
<%
	String strErrMsg = "";								 //에러메세지

	String userId = "";
	String ofc_cd = "";
	String db_date = "";
	String conti_cd = "";
	String ida_ofc_cd = "";
	
	String inv_no="";
	String vndr_seq="";
	inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq = JSPUtil.getNull(request.getParameter("vndr_seq"));

   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   userId = account.getUsr_id()!=null&&!account.getUsr_id().equals("")?account.getUsr_id():"";
   ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
   db_date = JSPUtil.getNull(new TESCommonBCImpl().getDBdateStr(ofc_cd));
   conti_cd = JSPUtil.getNull(new TESInvoiceCommonBCImpl().searchContiCd(ofc_cd));
   ida_ofc_cd = JSPUtil.getNull(new TESCommonBCImpl().getIndOfcCdChk(ofc_cd));

	/** 2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가    **/
	String pre_cond_inv_no 				= request.getParameter("pre_cond_inv_no")!=null&&!request.getParameter("pre_cond_inv_no").trim().equals("")?request.getParameter("pre_cond_inv_no"):"";
	String pre_cond_inv_date_type 		= request.getParameter("pre_cond_inv_date_type")!=null&&!request.getParameter("pre_cond_inv_date_type").trim().equals("")?request.getParameter("pre_cond_inv_date_type"):"";
	String pre_cond_fm_prd_dt 			= request.getParameter("pre_cond_fm_prd_dt")!=null&&!request.getParameter("pre_cond_fm_prd_dt").trim().equals("")?request.getParameter("pre_cond_fm_prd_dt"):"";
	String pre_cond_to_prd_dt 			= request.getParameter("pre_cond_to_prd_dt")!=null&&!request.getParameter("pre_cond_to_prd_dt").trim().equals("")?request.getParameter("pre_cond_to_prd_dt"):"";
	String pre_cond_yd_cd 				= request.getParameter("pre_cond_yd_cd")!=null&&!request.getParameter("pre_cond_yd_cd").trim().equals("")?request.getParameter("pre_cond_yd_cd"):"";
	String pre_cond_vndr_seq 			= request.getParameter("pre_cond_vndr_seq")!=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_cost_ofc_cd 		= request.getParameter("pre_cond_cost_ofc_cd")!=null&&!request.getParameter("pre_cond_cost_ofc_cd").trim().equals("")?request.getParameter("pre_cond_cost_ofc_cd"):"";
	String pre_cond_inv_ofc_cd 			= request.getParameter("pre_cond_inv_ofc_cd")!=null&&!request.getParameter("pre_cond_inv_ofc_cd").trim().equals("")?request.getParameter("pre_cond_inv_ofc_cd"):"";
	String pre_cond_tml_inv_sts_cd 		= request.getParameter("pre_cond_tml_inv_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_sts_cd"):"";
	String pre_cond_csr_no 				= request.getParameter("pre_cond_csr_no")!=null&&!request.getParameter("pre_cond_csr_no").trim().equals("")?request.getParameter("pre_cond_csr_no"):"";
	String pre_cond_csr_status 			= request.getParameter("pre_cond_csr_status")!=null&&!request.getParameter("pre_cond_csr_status").trim().equals("")?request.getParameter("pre_cond_csr_status"):"";
	String pre_cond_tml_inv_rjct_sts_cd = request.getParameter("pre_cond_tml_inv_rjct_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_rjct_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_rjct_sts_cd"):"";
	

%>
<html>
<head>
<title>Marine Terminal Strorage Invoice관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("vol_tr_ut_cd"	, "01", "CD00177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_cd"		, "01", "CD00592", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dcgo_clss_cd"	, "01", "CD00167", 0, "")%>
	var inv_no = '<%=JSPUtil.getNull(inv_no)%>';
	var vndr_seq = '<%=JSPUtil.getNull(vndr_seq)%>';
	var inv_ofc_cd = '<%=JSPUtil.getNull(ofc_cd)%>';
	var db_date = '<%=JSPUtil.getNull(db_date)%>';
	var conti_cd = '<%=JSPUtil.getNull(conti_cd)%>';
	var ida_ofc_cd = '<%=JSPUtil.getNull(ida_ofc_cd)%>';
    
	function setupPage(){
	
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>
<!--
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.
-->

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_cmd_rjct">
<input type="hidden" name="DB_DATE" value=''>

<input type="hidden" name="tml_so_ofc_cty_cd" value="">
<input type="hidden" name="tml_so_seq" value="">
<input type="hidden" name="tml_agmt_ofc_cty_cd" value="">
<input type="hidden" name="tml_agmt_seq" value="">
<input type="hidden" name="tml_agmt_ver_no" value="">
<input type="hidden" name="vrfy_rslt_ind_cd" value="">

<!----------------------------------------------------------------------
	# yd_chr_inv_tp_cd : yard의 특성을 조회하기 위한 code값...
	1. Marine Terminal Invoice = 'MT'
	2. On-dock Rail Charge Invoice = 'ON'
	3. Off-dock CY Invoice(Terminal) = 'OT'
	4. Off-dock CY Invoice(Storage) = 'OS'
	5. Storage Invoice = 'ST'
------------------------------------------------------------------------>
<input type="hidden" name="yd_chr_inv_tp_cd" value=""><!--// OFF-DOCK은 Terminal와 Storage 두가지가 존재... //-->
<input type="hidden" name="calcStorageComboItems" value="">
<input type="hidden" name="calcStorageComboItemsDesc" value="">

<input type="hidden" name="tml_inv_tp_cd" value="ST"><!--// STORAGE //-->
<input type="hidden" name="tml_cost_grp_cd" value="">
<input type="hidden" name="tml_calc_ind_cd" value="">
<input type="hidden" name="sto_dys_ind_cd" value="">

<input type="hidden" name="cost_calc_mode" value="">
<input type="hidden" name="dup_chk_mode" value="">
<input type="hidden" name="confirm_mode" value="">
<input type="hidden" name="dtl_by_day_only_mode" value="">
<input type="hidden" name="dtl_by_pool_only_mode" value="">

<input type="hidden" name="tmp_common_code" value="">

<input type="hidden" name="agmtCurrCd" value="">
<input type="hidden" name="agmtSts" value="">

<input type="hidden" name="is_valid_err_inv_no" value="">
<input type="hidden" name="whld_tax_amt_mode" value="">

<input type="hidden" name="curr_cd_tmp" value="">

<!--// eBilling - B //-->
<input type="hidden" name="edi_flg" value="">
<!--// eBilling - E //-->

<!-- 2011.08.12 박정일 special character, characterSet problem. //-->
<input type="hidden" name="inv_no_tmp" value= "<%=JSPUtil.getNull(inv_no)%>">

<!--	2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가    -->
<!--	Invoice 조회 화면에서 이동해 왔을 경우 바로 다시 Invoice 조회 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위한 값들. ( 2009-10-15 )	-->
<input name="pre_cond_inv_no" type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_no)%>">
<input name="pre_cond_inv_date_type" type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_date_type)%>">
<input name="pre_cond_fm_prd_dt" type="hidden" value="<%=JSPUtil.getNull(pre_cond_fm_prd_dt)%>">
<input name="pre_cond_to_prd_dt" type="hidden" value="<%=JSPUtil.getNull(pre_cond_to_prd_dt)%>">
<input name="pre_cond_yd_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_yd_cd)%>">
<input name="pre_cond_vndr_seq" type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_cost_ofc_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_cost_ofc_cd)%>">
<input name="pre_cond_inv_ofc_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_ofc_cd)%>">
<input name="pre_cond_tml_inv_sts_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_tml_inv_sts_cd)%>">
<input name="pre_cond_csr_no" type="hidden" value="<%=JSPUtil.getNull(pre_cond_csr_no)%>">
<input name="pre_cond_csr_status" type="hidden" value="<%=JSPUtil.getNull(pre_cond_csr_status)%>">
<input name="pre_cond_tml_inv_rjct_sts_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_tml_inv_rjct_sts_cd)%>">

<input type="hidden"	name="cost_row" value="">
<input type="hidden"	name="param_lgs_cost_cd" value="">
<input type="hidden"	name="rmk_chk_flg" value=""> 
<input type="hidden"	name="sheet_idx" value="">
<input type="hidden"	name="chk_ofc_cd" value="">

<input type="hidden"	name="ida_sac_cd" value="">
<input type="hidden"	name="valid_ida_sac_cd" value="">
<input type="hidden"	name="ida_gst_rto" value="">
<input type="hidden"	name="chg_row" value="">
<input type="hidden"	name="chg_sheet" value="">
<input type="hidden"	name="t3sht_tot_cgst_amt" value="">
<input type="hidden"	name="t3sht_tot_sgst_amt" value="">
<input type="hidden"	name="t3sht_tot_igst_amt" value="">
<input type="hidden"	name="t3sht_tot_ugst_amt" value="">
<input type="hidden"	name="t4sht_tot_cgst_amt" value="">
<input type="hidden"	name="t4sht_tot_sgst_amt" value="">
<input type="hidden"	name="t4sht_tot_igst_amt" value="">
<input type="hidden"	name="t4sht_tot_ugst_amt" value="">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>



		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<!--// eBilling - B //-->
							<!--td><div id="EDILayer01" style="display:none"><img src="/hanjin/img/button/btn_EDIinvoiceview.gif" width="120" height="20" border="0" align="absmiddle" name='btn_EDIinvoiceview'></div></td-->
							<td>
								<div id="EDILayer01" style="display:none">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_EDIinvoiceview" id="btn_EDIinvoiceview">EDI Invoice View</td>
								<td class="btn1_right"></td></tr></table>
								</div>
							</td>							
							<td>
								<div id="PreInquiryCondLayer01" style="display:none">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_pre_inquiry_cond" id="btn_pre_inquiry_cond">To Inv. Summary</td>
								<td class="btn1_right"></td></tr></table>
								</div>
							</td>							
							<!--// eBilling - E //-->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New INV</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_copy" id="btn_copy">Copy INV</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="75"><img class="nostar">S/P Code</td>
					<td width="115" class="stm"><input class="input1" type="text" name="vndr_seq" value="" tabindex='1' value='' maxlength=6 style="width:68" onKeyUp='tes_isNum(this);' onKeyDown='tes_isNum(this); tes_chkInput(this);' onBlur='this.value=tes_lpad(this.value,this.maxLength,"0"); validateVndrSeq();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr"><input type="hidden" name="vndr_seq_hidden" value=''><input type="hidden" name="is_valid_vndr_seq" value=''></td>
					<td width="80"><img class="nostar">S/P Name</td>
					<td width="135"><input class="input2" type="text" style="width:115" value=""  name ="vndr_seq_nm" valid="1" class="input2" readOnly ></td>
					<td width="81"><img class="nostar">INV No</td>
					<td width="135"><input class="input1" type="text" name="inv_no" value="" tabindex='2' maxlength="30" style="width:128" onKeyPress='tes_enterCheck("retrieve");' onKeyDown='tes_chkInput(this);' onBlur='validateInvDupChk();'></td>
									<input type="hidden" name="inv_no_hidden" value=''>
									<input type="hidden" name="is_dup_inv_no" value=''>
					<td width="100"><img class="nostar">Error INV No</td>
					<td width="150"><input type="text" name="err_inv_no" maxlength="30" style="width:93" onKeyDown='tes_chkInput(this);' onBlur='validateErrInvNo();'></td>
					<td !width="">Reverse CHG&nbsp;<input type="checkbox" name="ap_rvs_cng_flg" value="Y" disabled class="trans"></td>
				</tr>
				</table>
				<div id="IndiaLayer01" style="display:none">
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="75"><img class="nostar">GST Reg.</td>
					<td width="115" class="stm"><input type="text" style="width:105" value=""  name ="ida_gst_rgst_ste" valid="1" class="input2" readOnly ></td>
					<td width="80"><img class="nostar">GSTIN/UIN</td>
					<td width="135"><input type="text" style="width:115" value=""  name ="ida_gst_rgst_no" valid="1" class="input2" readOnly ></td>
					<td width="81"><img class="nostar">State</td>
					<td width="135"><input class="input2" type="text" style="width:20" name="ida_ste_cd" valid="1" readOnly >&nbsp;<input class="input2" type="text" style="width:105" name="ida_ste_nm" valid="1" readOnly ></td>
					<td width="100"><img class="nostar">Debit Note No</td>
					<td colspan="2"><input class="input" type="text" style="width:93;" name="dbt_note_no" maxlength="30" onKeyDown='tes_chkInput(this);''></td>
				</tr>
				</table>
				</div>
				<!-- : ( Week ) (E) -->

			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search" style="width:997;">
       	<tr><td class="bg" valign="top">

				<!-- : ( Week ) (S) -->
				<table class="search" border="0" width="100%">

				<tr class="h23">
					<td width="80"><img class="nostar">Yard Code</td>
					<td width="100">&nbsp;<input class="input1" type="text" name="yd_cd" value='' maxlength=7 style="width:67" onKeyUp='tes_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='tes_chkInput(this); this.value=this.value.toUpperCase();' onBlur='validateYardCode();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_yard">
								<input type="hidden" name="yd_cd_hidden" value=''>
								<input type="hidden" name="is_valid_yd_cd" value=''>
								<input type="hidden" name="yd_chr_cd" value=''>
								<input type="hidden" name="yd_fcty_tp_mrn_tml_flg" value=''>
								<input type="hidden" name="yd_fcty_tp_cy_flg" value=''>
								<input type="hidden" name="yd_fcty_tp_cfs_flg" value=''>
								<input type="hidden" name="yd_fcty_tp_rail_rmp_flg" value=''>
								<input type="hidden" name="yd_oshp_cd" value=''>
					</td>
					<td width="100"><img class="nostar">Yard Name</td>
					<td width="120">&nbsp;<input class="input2" type="text" name="yd_nm" class="input2" style="width:92" readonly></td></tr>
				<tr class="h23">
					<td><img class="nostar">Cost OFC</td>
					<td>&nbsp;<input class="input1" type="text" name="cost_ofc_cd" value='' maxlength=6 style="width:67" onKeyUp='tes_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='tes_chkInput(this); this.value=this.value.toUpperCase();' onBlur='validateCostOFC();' readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cost_ofc_cd"><input type="hidden" name="cost_ofc_cd_hidden" value=''><input type="hidden" name="is_valid_cost_ofc_cd" value=''></td>
					<td><img class="nostar">INV OFC</td>
					<td>&nbsp;<input class="input2" type="text" name="inv_ofc_cd" maxlength=6 style="width:92" class="input2" value="<%=ofc_cd%>" readonly></td>
					</tr>
				<tr class="h23">
					<td><img class="nostar">Currency</td>
					<td>&nbsp;<script language="javascript">ComComboObject('curr_cd', 1, 90, 1, 1)</script></td>
					<td><img class="nostar">Hold</td>
					<td>
					<table class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><input type="checkbox" name="hld_flg" value="" class="trans" onClick='setHldRmk();'></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btns_remarks" id="btns_remarks">Remarks</td>
												<td class="btn2_right"></td></tr></table>
										</td>
										<td><input type="hidden" name="hld_rmk" maxlength="500" value=""></td>
										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
					</table>
					</td>
				</tr>
					<!-- 
					<tr class="h23">
					<td><img class="nostar">Target Period</td>
					<td colspan="3">&nbsp;<input class="input1" type="text" name="fm_prd_dt" style="width:67" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_prd_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(validateDateObj(this)){period_ChkMod();}'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input class="input1" type="text" name="to_prd_dt" style="width:68" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(validateDateObj(this)){period_ChkMod();}'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2" ></td></tr>
				    -->
				<tr>
					<td colspan="4">
						<table>
							<tr class="h23">
								<td><img class="nostar">Target Period</td>
								<td>&nbsp;&nbsp;<input class="input" type="text" name="fm_prd_dt" style="width:69" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_prd_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(validateDateObj(this)){period_ChkMod();}'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input class="input1" type="text" name="to_prd_dt" style="width:69" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(validateDateObj(this)){period_ChkMod();}'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2" ></td>
							</tr>
							<tr class="h23">
								<td><img class="nostar">Actual G/In(Min) ~ G/Out(Max)</td>
								<td>&nbsp;&nbsp;<input class="input" type="text" name="mvmt_gate_in_dt" style="width:69" readonly>&nbsp;&nbsp;~&nbsp;&nbsp;<input class="input" type="text" name="mvmt_gate_out_dt" style="width:69" readonly></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- : ( Week ) (E) -->

			</td>
			<td width="10"></td>
			<td class="bg">

				<!-- : ( Week ) (S) -->
				<table class="search" border="0" width="100%">

				<tr class="h23">
					<td width="80"><img class="nostar">INV AMT</td>
					<td width="120">&nbsp;<input class="input1" type="text" name="ttl_inv_amt" maxlength=14 style="width:92;text-align:right;" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();"></td>
					<td width="100"><img class="nostar">TAX</td>
					<td width="120">&nbsp;<input type="text" name="vat_amt" maxlength=14 style="width:92;text-align:right;" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();"></td></tr>
				<tr class="h23">
					<td><img class="nostar">W.H.T</td>
					<td>&nbsp;<input type="text" name="whld_tax_amt" maxlength=20 style="width:92;text-align:right;" onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code); set_total_amount();"></td>
					<td><img class="nostar">Total AMT</td>
					<td>&nbsp;<input class="input2" type="text" name="total_amt" maxlength=22 style="width:92;text-align:right;" readonly></td></tr>
				<tr class="h23">
					<td><img class="nostar">Issued DT</td>
					<td>&nbsp;<input class="input1" type="text" style="width:69" maxlength=10 name="iss_dt" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj2(this); isValIssSys(this);'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar3"></td>
					<td><img class="nostar">Received DT</td>
					<td>&nbsp;<input class="input1" type="text" style="width:69" maxlength=10 name="rcv_dt" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj2(this); isValIssSys(this);'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar4"></td></tr>
				<tr class="h23">
					<td><img class="nostar">INV STS</td>
					<td>&nbsp;<input class="input2" type="text" name="tml_inv_sts_cd2" maxlength=2 value="" style="width:92" class="input2" readonly><input type="hidden" name="tml_inv_sts_cd" maxlength=2 value=""></td>
					<td><img class="nostar">Reject STS</td>
					<td>&nbsp;<input class="input2" type="text" name="tml_inv_rjct_sts_cd" maxlength=2 value="NL" style="width:92" class="input2" readonly><input type="hidden" name="inv_rjct_rmk" value=""></td></tr>
					<tr class="h23">
					<td></td>
					<td colspan="3">&nbsp;</td>
				</tr>
				</table>
				<!-- : ( Week ) (E) -->

			</td>
			<td width="10"></td>
			<td <%if(ida_ofc_cd.equals("Y")){ %>class="bg"<%} %>>
				<div id="IndiaLayer02" style="display:none">
				<table class="search" border="0" width="100%">
					<tr valign="top">
						<td>
							<table class="search" border="0" width="100%">
							<tr class="h23">
								<td width="40"><img class="nostar">CGST</td>
								<td width="100">&nbsp;<input class="input" type="text" style="width:92;text-align:right;" name="ida_cgst_amt" desc= "CGST AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_vat_amount();"></td>
							</tr>
							<tr class="h23">
								<td width="40"><img class="nostar">SGST</td>
								<td width="100">&nbsp;<input class="input" type="text" style="width:92;text-align:right;" name="ida_sgst_amt" desc= "SGST AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_vat_amount();"></td>
							</tr>
							<tr class="h23">
								<td width="40"><img class="nostar">IGST</td>
								<td width="100">&nbsp;<input class="input" type="text" style="width:92;text-align:right;" name="ida_igst_amt" desc= "IGST AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_vat_amount();"></td>
							</tr>
							<tr class="h23">
								<td width="40"><img class="nostar">UGST</td>
								<td width="100">&nbsp;<input class="input" type="text" style="width:92;text-align:right;" name="ida_ugst_amt" desc= "UGST AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_vat_amount();"></td>
							</tr>
							<tr class="h23">
								<td></td>
								<td>&nbsp;</td>
							</table>
						</td>
					</tr>
				</table>
				</div>
			</td>			
			</tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- : ( Week ) (S) -->
		<table class="search">
        		<tr><td class="bg">

        			<table border="0" class="grid2" background-color:white;>
        				<tr>
        					<td width="170" class="tr2_head">Cost Calc. Method</td>

        					<td width="790">&nbsp;&nbsp;<b>Storage(Day)</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        					<input type="radio" name="StorageFD" value="GIO" class="trans" onClick="setCalcCostCond();">Gate In & Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="StorageFD" value="Date" class="trans" onClick="setCalcCostCond();">Period</td>
        				</tr>

        			</table>
			</td></tr>
		</table>
		<!-- : ( Week ) (E) -->
		<!-- TABLE '#D' : ( Search Options ) (E) -->



		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calc.(TMNL) / Cost Calc.(SR by FD) / Cost Calc.(SR by FP) / -->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->
<!-- UI_ESD_TES_009 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




			<table class="height_10"><tr><td></td></tr></table>




			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet1');</script>
                        </td></tr>
		            </table>

			<!-- : ( Grid : Week ) (E) -->

		<div id="SearchLayer01" style="display:inline">
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		</div>

			<!-- : ( Button : Top ) (S) -->
			<table width="100%" class="sbutton">
	       	<tr><td class="align">
			    <table class="sbutton">
			    <tr>
					<td class="bt"><img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" onClick="reSize();"></td></tr>
				</table>

			</td></tr>
			</table>
	    	<!-- : ( Button : STop ) (E) -->

		<div id="SearchLayer02" style="display:inline">
			<!-- TABLE '#D' : ( Search Options :  ) (S) -->
			<table class="search_in" border="0">
				<tr class="h23">
					<td width="4%">Total</td>
					<td width="15%"><input type="text" name='sht_01_ttl_box' value='' style="width:80" class="input2" readonly></td>
					<td width="3%">Full</td>
					<td width="14%"><input type="text" name='sht_01_full' value='' style="width:80" class="input2" readonly></td>
					<td width="3%">Empty</td>
					<td width="15%"><input type="text" name='sht_01_mt' style="width:80" class="input2" readonly></td>
					<!--td width="7%">TS(BKG)</td>
					<td width="14%"><input type="text" name='sht_01_ts_bkg' style="width:80" class="input2" readonly></td-->
					<td width="13%">TS(Same Yard)</td>
					<td><input type="text" name='sht_01_ts_same_yard' style="width:80" class="input2" readonly></td></tr>
			</table>
			<table class="search_in" border="0">
				<tr class="h23">
					<td width="18">D2 </td><td width="40"><input type="text" name="sht_01_D2" style="width:32" class="input2" readonly></td>
					<td width="18">D4 </td><td width="40"><input type="text" name="sht_01_D4" style="width:32" class="input2" readonly></td>
					<td width="18">D5 </td><td width="40"><input type="text" name="sht_01_D5" style="width:32" class="input2" readonly></td>
					<td width="18">D7 </td><td width="40"><input type="text" name="sht_01_D7" style="width:32" class="input2" readonly></td>
					<td width="18">D8 </td><td width="40"><input type="text" name="sht_01_D8" style="width:32" class="input2" readonly></td>
					<td width="18">D9 </td><td width="40"><input type="text" name="sht_01_D9" style="width:32" class="input2" readonly></td>
					<td width="18">DW </td><td width="40"><input type="text" name="sht_01_DW" style="width:32" class="input2" readonly></td>
					<td width="18">DX </td><td width="40"><input type="text" name="sht_01_DX" style="width:32" class="input2" readonly></td>
					<td width="18">R2 </td><td width="40"><input type="text" name="sht_01_R2" style="width:32" class="input2" readonly></td>
					<td width="18">R4 </td><td width="40"><input type="text" name="sht_01_R4" style="width:32" class="input2" readonly></td>
					<td width="18">R5 </td><td width="40"><input type="text" name="sht_01_R5" style="width:32" class="input2" readonly></td>
					<td width="18">R7 </td><td width="40"><input type="text" name="sht_01_R7" style="width:32" class="input2" readonly></td>
					<td width="18">R8 </td><td width="40"><input type="text" name="sht_01_R8" style="width:32" class="input2" readonly></td>
					<td width="18">R9 </td><td width="40"><input type="text" name="sht_01_R9" style="width:32" class="input2" readonly></td>
					<td width="18">F2 </td><td width="40"><input type="text" name="sht_01_F2" style="width:32" class="input2" readonly></td>
					<td width="18">F4 </td><td width="40"><input type="text" name="sht_01_F4" style="width:32" class="input2" readonly></td></tr>
				<tr class="h23">
					<td>F5</td><td><input type="text" name="sht_01_F5" style="width:32" class="input2" readonly></td>
					<td>O2</td><td><input type="text" name="sht_01_O2" style="width:32" class="input2" readonly></td>
					<td>O4</td><td><input type="text" name="sht_01_O4" style="width:32" class="input2" readonly></td>
					<td>O5</td><td><input type="text" name="sht_01_O5" style="width:32" class="input2" readonly></td>
					<td>O7</td><td><input type="text" name="sht_01_O7" style="width:32" class="input2" readonly></td>
					<td>S2</td><td><input type="text" name="sht_01_S2" style="width:32" class="input2" readonly></td>
					<td>S4</td><td><input type="text" name="sht_01_S4" style="width:32" class="input2" readonly></td>
					<td>T2</td><td><input type="text" name="sht_01_T2" style="width:32" class="input2" readonly></td>
					<td>T4</td><td><input type="text" name="sht_01_T4" style="width:32" class="input2" readonly></td>
					<td>A2</td><td><input type="text" name="sht_01_A2" style="width:32" class="input2" readonly></td>
					<td>A4</td><td><input type="text" name="sht_01_A4" style="width:32" class="input2" readonly></td>
					<td>A5</td><td><input type="text" name="sht_01_A5" style="width:32" class="input2" readonly></td>
					<td>P2</td><td><input type="text" name="sht_01_P2" style="width:32" class="input2" readonly></td>
					<td>P4</td><td><input type="text" name="sht_01_P4" style="width:32" class="input2" readonly></td>
					<!-- 
					<td>Z2</td><td><input type="text" name="sht_01_Z2" style="width:32" class="input2" readonly></td>
					<td>Z4</td><td><input type="text" name="sht_01_Z4" style="width:32" class="input2" readonly></td>
					-->
					<td>C2</td><td><input type="text" name="sht_01_C2" style="width:32" class="input2" readonly></td>
					<td>C4</td><td><input type="text" name="sht_01_C4" style="width:32" class="input2" readonly></td>
					</tr>
			</table>
				<!-- : ( Week ) (E) -->
		</div>


			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>

						<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_listclear" id="t1btng_listclear">List Clear</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_fileimport" id="t1btng_fileimport">File Import</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_save" id="t1btng_save">Save</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_downexcel" id="t1btng_downexcel">Down Excel</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_todiscrepancy" id="t1btng_todiscrepancy">To Discrepancy</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_costcalc" id="t1btng_costcalc">Cost Calc.</td>
							<td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</div>

<!-- UI_ESD_TES_010 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">







			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t2sheet1');</script>
                        </td></tr>
		            </table>


			<!-- : ( Grid : Week ) (E) -->




			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>

						<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_listclear" id="t2btng_listclear">List Clear</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_print" id="t2btng_print">Print</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_downexcel" id="t2btng_downexcel">Down Excel</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_coincidence" id="t2btng_coincidence">To Coincidence</td>
							<td class="btn2_right"></td></tr></table></td>
							<!-- 
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_chkdgit" id="t2btng_chkdgit">CHK Dgit</td>
							<td class="btn2_right"></td></tr></table></td>		
							 -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_reject" id="t2btng_reject">Reject</td>
							<td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</div>

<!-- UI_ESD_TES_011 : THIS IS 3st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">






			<table class="search_in" border="0">
				<tr class="h23">
					<td align="right">Calculated AMT&nbsp;&nbsp;<input type="text" name='t3sht_tot_inv_amt' class="input2" style="width:150;text-align:right;" readonly></td></tr>
			</table>


			<table class="height_5"><tr><td></td></tr></table>




			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t3sheet1');</script>
                        </td></tr>
		            </table>


			<!-- : ( Grid : Week ) (E) -->







			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>

						<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_listclear" id="t3btng_listclear">List Clear</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table border="0" cellpadding="0" cellspacing="0">
							<tr><td><input type="text" name="t3rowsadd" size="2" value="1" maxlength="4"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_rowadd" id="t3btng_rowadd">Row Add</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_rowdel" id="t3btng_rowdel">Delete</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_save" id="t3btng_save">Save</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_totalamount" id="t3btng_totalamount">Total Amount</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_confirm" id="t3btng_confirm">Confirm</td>
							<td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</div>

<!-- UI_ESD_TES_012 : THIS IS 4st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">






			<table class="search_in" border="0">
				<tr class="h23">
					<td align="right">Calculated AMT&nbsp;&nbsp;<input type="text" name='t4sht_tot_inv_amt' class="input2" style="width:150;text-align:right;" readonly></td></tr>
			</table>


			<table class="height_5"><tr><td></td></tr></table>



					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t4sheet1');</script>
                        </td></tr>
		            </table>

			<!-- : ( Grid : Week ) (E) -->







			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>

						<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_listclear" id="t4btng_listclear">List Clear</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_fileimport" id="t4btng_fileimport">File Import</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table border="0" cellpadding="0" cellspacing="0">
							<tr><td><input type="text" name="t4rowsadd" size="2" value="1" maxlength="4"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_rowadd" id="t4btng_rowadd">Row Add</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_rowdel" id="t4btng_rowdel">Delete</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_save" id="t4btng_save">Save</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_totalamount" id="t4btng_totalamount">Total Amount</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_reject" id="t4btng_reject">Reject</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_confirm" id="t4btng_confirm">Confirm</td>
							<td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</div>

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>

<div id="main_hidden_sheets" style="display:none">
<!--// HIDDEN SHEET : header 정보 임시 보관용 //-->
main_hidden_sheets - sheet[4]
<script language="javascript">ComSheetObject('main_hidden');</script>
</div>
<!--br><br-->
<div id="rjct_hidden_sheets" style="display:none; width:50%">
<!--// HIDDEN SHEET : reject한 결과 임시 보관용 //-->
rjct_hidden_sheets - sheet[5]
<script language="javascript">ComSheetObject('rjct_hidden');</script>
</div>
<!--br><br-->
<div id="conf_hidden_sheets" style="display:none; width:50%">
<!--// HIDDEN SHEET : confirm한 결과 임시 보관용 //-->
conf_hidden_sheets - sheet[6]
<script language="javascript">ComSheetObject('conf_hidden');</script>
</div>
<!--br><br-->
<div id="dupchk_hidden_sheets" style="display:none;">
<!--// HIDDEN SHEET : confirm한 결과 임시 보관용 //-->
dupchk_hidden_sheets - sheet[7]
<script language="javascript">ComSheetObject('dupchk_hidden');</script>
</div>

<script>

	<%//=TESUtil.getCodeValue("DBdate", "TEST1818", "", "", "CntrTPSZCDList", "AutoTESTmlSoCostCDList", "", "", "", "")%>

</script>

