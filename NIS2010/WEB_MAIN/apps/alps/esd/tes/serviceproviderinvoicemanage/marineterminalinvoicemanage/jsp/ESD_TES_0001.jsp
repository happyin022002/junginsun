<%--
/*****
 * =========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : ESD_TES_0001GS.jsp
 * @FileTitle : Marine Terminal Invoice 등록 및 Confirm화면-Coincidence
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2007-02-20 
 * @LastModifier : kimjinjoo
 * @LastVersion : 1.0
 * 2007-02-20 kimjinjoo
 * 1.0 최초 생성
 *
 * 2009-05-07 [R200905060012] : TPB I/F SVXXJO COST CODE 누락건 방지
 * 2009-06-22 : [N200906220001] TES 소급처리용 invoice 기능 추가 및 LEA 처리 로직 추가
 * 2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가
 * 2011-03-11 : [CHM-201109193-01] iss_dt, rcv_dt 현재 office 날짜 이후로 입력 불가
 * 2011.08.10 [CHM-201112119-1] [TES] MR Invoice 입력시 FIO 조건 CNTR verification 결과 보완 요청
 * 2011.08.17 [E-mail요청] [TES] special character, characterSet problem
 * 2011.10.06 [CHM-201113485][TES] Invoice II7088112 --- detailed data 조회 관련
 * 2013.04.03 [CHM-201322399-01] Special Cargo Quotation Project (Break Bulk Cost 추가)
 * 2014-06-19 [CHM-201429999] TES: Cost Code SVXXHC Vol 계산시 TOR data참조 logic
 * 2015-01-20 [CHM-201430578] TMNL Invoice Manual 입력시 Vol validation 추가
 * =========================================================
 *****/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl"%>
<%
	EsdTes0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	//EsdTes0001EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String userId = "";
	String ofcCd = "";
	String db_date = "";

	String inv_no="";
	String vndr_seq="";
	String	successFlg	= "";
	inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq = JSPUtil.getNull(request.getParameter("vndr_seq"));
	
	String conti_cd = "";
	String ida_ofc_cd = "";

	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId = account.getUsr_id()!=null&&!account.getUsr_id().equals("")?account.getUsr_id():"";
	   ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():""; //test용 값..

	   conti_cd = JSPUtil.getNull(new TESInvoiceCommonBCImpl().searchContiCd(ofcCd));
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		db_date = JSPUtil.getNull(new TESCommonBCImpl().getDBdateStr(ofcCd));
		
		ida_ofc_cd = JSPUtil.getNull(new TESCommonBCImpl().getIndOfcCdChk(ofcCd));
			
	   //userAuth=account.getAuth();
		event = (EsdTes0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

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
<title>Marine Terminal Invoice 등록 및 Confirm화면-Coincidence</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("vol_tr_ut_cd"	, "01", "CD00177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_cd"		, "01", "CD00592", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("ioc_cd"			, "01", "CD00887", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dcgo_clss_cd"	, "01", "CD00167", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("tml_wrk_dy_cd"	, "01", "CD00168", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("locl_ts_ind_cd" , "01", "CD00889", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("tml_trns_mod_cd", "01", "CD00965", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("lc_trns_mod_cd" , "01", "CD00967", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("ts_trns_mod_cd" , "01", "CD00968", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dscr_ind_cd"    , "01", "CD00823", 0, "")%>
	var inv_no = '<%=JSPUtil.getNull(inv_no)%>';
	var vndr_seq = '<%=JSPUtil.getNull(vndr_seq)%>';
	var db_date = '<%=JSPUtil.getNull(db_date)%>';
	var ofc_cd = '<%=JSPUtil.getNull(ofcCd)%>';
	var conti_cd = '<%=JSPUtil.getNull(conti_cd)%>';
	var ida_ofc_cd = '<%=JSPUtil.getNull(ida_ofc_cd)%>';
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<!----------------------------------------------------------------------
	# yd_chr_inv_tp_cd : yard의 특성을 조회하기 위한 code값...
	1. Marine Terminal Invoice = 'MT'
	2. On-dock Rail Charge Invoice = 'ON'
	3. Off-dock CY Invoice(Terminal) = 'OT'
	4. Off-dock CY Invoice(Storage) = 'OS'
	5. Storage Invoice = 'ST'
------------------------------------------------------------------------>
<input type="hidden" 	name="f_cmd">
<input type="hidden" 	name="iPage">
<input type="hidden"	name="tml_so_ofc_cty_cd"		value="">
<input type="hidden"	name="tml_so_seq"				value="">
<input type="hidden"	name="temp_val"					value="">
<input type="hidden"	name="vvd_val_arr"				value="">
<input type="hidden"	name="tml_inv_tp_cd"			value="TM">
<input type="hidden"	name="temp_lgs_cost_cd"			value="">
<input type="hidden"	name="agmtCurrCd"				value="">
<input type="hidden"	name="agmtSts"					value="">
<input type="hidden"	name="laneCode"					value="">
<input type="hidden"	name="delete_mode"				value="">
<input type="hidden"	name="cost_calc_mode"			value="R"> <!--cost calculation mode (R : 기존저장된 calc list read, N: New Calculation ) -->
<input type="hidden"	name="yd_chr_inv_tp_cd"			value=""><!--// OFF-DOCK은 Terminal와 Storage 두가지가 존재... //-->
<input type="hidden"	name="calcTerminalComboItems" 	value="">
<input type="hidden"	name="cntrTpszComboItems"		value="">
<input type="hidden"	name="laneComboItems"			value="">
<input type="hidden"	name="carrComboItems"			value="">
<input type="hidden"	name="tmp_common_code"			value="">
<!--<input type="hidden"	name="tml_so_dtl_seq"			value="">-->
<input type="hidden"	name="is_valid_err_inv_no"		value="">
<input type="hidden"	name="tmp_cost_cd"				value="">
<input type="hidden"	name="curr_cd_tmp" 				value="">
<input type="hidden" 	name="whld_tax_amt_mode" 		value="">
<input type="hidden" 	name="tmp_dtl_seq" 				value="">
<input type="hidden" 	name="tmp_if_amt" 				value="">
<input type="hidden" 	name="tmp_calc_vol_qty"			value="">
<input type="hidden" 	name="tmp_rvis_vol_qty"			value="">
<input type="hidden" 	name="tmp_ctrt_rt" 				value="">
<input type="hidden" 	name="tmp_inv_xch_rt" 			value="">
<input type="hidden"	name="edi_flg"					value="">
<input type="hidden"	name="is_valid_cost_ofc_cd"		value="">
<input type="hidden"	name="reverify_yn"				value="">
<input type="hidden"	name="manual_lgs_cost_cd"		value="">
<input type="hidden"	name="calc_cost_grp_cd"			value="MT">
<input type="hidden"	name="bound_lgs_cost_cd"		value="">
<!--	TPB IF SVXXJO N3PTY_FLG 누락 방지위한 Confirm 구분값 ( 2009-05-07 ) C : Confirm	-->
<input type="hidden"	name="costCalcFlg"				value="">

<!--	Retroactive Invoice 처리를 위한 추가 - 변경시 비교를 위해 조회시 값. ( 2009-06-16 )	-->
<input type="hidden"	name="rtro_tml_inv_flg_old"		value=""> 

<!-- 2011.08.12 ������ special character, characterSet problem. //-->
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

<input name="tempTorCnt" type="hidden" value="">

<input type="hidden"	name="vol_rt_chk_flg" value="">
<input type="hidden"	name="cost_row" value="">
<input type="hidden"	name="param_lgs_cost_cd" value="">
<input type="hidden"	name="rmk_chk_flg" value="">
<input type="hidden"	name="sheet_idx" value="">
<input type="hidden"	name="clpt_ind_seq" value="">
<input type="hidden"	name="param_call_yd_ind_seq" value="">

<input type="hidden"	name="calcTerminalComboItemsDesc" 	value="">
<input type="hidden"	name="chk_ofc_cd" value="">
<input type="hidden"	name="ida_sac_cd" value="">
<input type="hidden"	name="valid_ida_sac_cd" value="">
<input type="hidden"	name="ida_gst_rto" value="">
<input type="hidden"	name="ida_row" value="">
<input type="hidden"	name="tot_cgst_amt" value="">
<input type="hidden"	name="tot_sgst_amt" value="">
<input type="hidden"	name="tot_igst_amt" value="">
<input type="hidden"	name="tot_ugst_amt" value="">

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
							<!-- <td><div id="EDILayer01" style="display:none"><img src="/hanjin/img/button/btn_EDIinvoiceview.gif" width="120" height="20" border="0" align="absmiddle" name='btn_EDIinvoiceview'></div></td> -->
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
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td></tr></table>
							</td>
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


	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<!--<td width="10%"><img class="nostar">User ID</td>
					<td width="14%">&nbsp;<input type="text" style="width:90" value="<%=userId%>"  name ="user_id" valid="1" desc= "USER ID" class="noinput1" readOnly ></td>
					-->
					<td width="70"><img class="nostar">S/P Code</td>
					<td width="100" class="stm">
						<input class="input1" type="text" style="width:68" name="vndr_seq" value='' valid="1" desc= "VNDR Code" value='' maxlength=6 tabindex='1' onKeyUp='tes_isNum(this);' onKeyDown='tes_isNum(this);' onBlur='validateVndrSeq();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btn_vndr"></td>
									  <input type="hidden" name="vndr_seq_hidden" value=''>
									  <input type="hidden" name="is_valid_vndr_seq" value=''>

					<td width="75"><img class="nostar">S/P Name</td>
					<td width="90"><input type="text" style="width:115" value=""  name ="vndr_seq_nm" valid="1" class="input2" readOnly ></td>
					<td width="62"><img class="nostar">INV No</td>
					<td width="100"><input class="input1" type="text" style="width:128" name="inv_no"  value='' maxlength=30 valid="1" tabindex='2' desc= "Inv. No." onKeyPress='enterCheck("retrieveEvent");' onBlur='validateInvDupChk();'></td>
									  <input type="hidden" name="inv_no_hidden" value=''>
									  <input type="hidden" name="is_dup_inv_no" value=''>
					<td width="100"><img class="nostar">Error INV No</td>
					<td width="110"><input class="input3" type="text" style="width:93;" name="err_inv_no" maxlength="30" onKeyDown='tes_chkInput(this);' onBlur='validateErrInvNo();'></td>
					<%--	Invoice 소급처리용 추가 ( 2009-06-16 )	--%>
					<td width="130">Retroactive INV&nbsp;<input type="checkbox" name="rtro_tml_inv_flg" value="Y" class="trans"></td>
					<td width="110">Reverse CHG&nbsp;<input type="checkbox" name="ap_rvs_cng_flg" value="Y" class="trans" disabled="disabled" ></td>
				</tr>
				</table>
				<div id="IndiaLayer01" style="display:none">
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="68"><img class="nostar">GST Reg.</td>
					<td width="75" class="stm"><input type="text" style="width:90" value=""  name ="ida_gst_rgst_ste" valid="1" class="input2" readOnly ></td>
					<td width="35"><img class="nostar">GSTIN/UIN</td>
					<td width="90"><input type="text" style="width:115" value=""  name ="ida_gst_rgst_no" valid="1" class="input2" readOnly ></td>
					<td width="60"><img class="nostar">State</td>
					<td width="132"><input class="input2" type="text" style="width:20" name="ida_ste_cd" valid="1" readOnly >&nbsp;<input class="input2" type="text" style="width:105" name="ida_ste_nm" valid="1" readOnly ></td>
					<td width="98"><img class="nostar">Debit Note No</td>
					<td width="105"><input class="input1" type="text" style="width:93;" name="dbt_note_no" maxlength="30" onKeyDown='tes_chkInput(this);''></td>
					<td width="130"></td>
					<td width="110"></td>
				</tr>
				</table>
				</div>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->
     	<table class="search" style="width:997;">
       	<tr><td class="bg" valign="top">

				<!-- : ( Week ) (S) -->
				<table class="search" border="0" width="100%">

				<tr class="h23">
					<td width="80"><img class="nostar">Yard Code</td>
					<td width="100">&nbsp;<input class="input1" type="text" style="width:68" name="yd_cd" valid="1" desc= "Yard Code"  maxlength=7  onKeyUp='tes_isApNum(this);upper(this);' onBlur='validateYardCode();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_yard">
										<input type="hidden" name="yd_cd_hidden" value=''>
										<input type="hidden" name="is_valid_yd_cd" value=''>
										<input type="hidden" name="yd_chr_cd" value=''>
										<input type="hidden" name="yd_fcty_tp_mrn_tml_flg" value=''>
										<input type="hidden" name="yd_fcty_tp_cy_flg" value=''>
										<input type="hidden" name="yd_fcty_tp_cfs_flg" value=''>
										<input type="hidden" name="yd_fcty_tp_rail_rmp_flg" value=''>
										<input type="hidden" name="yd_oshp_cd" value=''>
					</td>
					<td width="80"><img class="nostar">Yard Name</td>
					<td width="120">&nbsp;<input type="text" style="width:100" name="yd_nm" class="input2"  readOnly ></td>
				</tr>
				<tr class="h23">
					<td><img class="nostar">Cost OFC</td>
					<td>&nbsp;<input class="input1" type="text" style="width:68" name="cost_ofc_cd"  value='' maxlength=6  onKeyUp='tes_isApNum(this);upper(this);' onBlur='validateCostOFC();' readOnly >&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cost_ofc">
										<input type="hidden" name="cost_ofc_hidden" value=''>
										<input type="hidden" name="is_valid_cost_ofc" value=''>
					</td>
					<td><img class="nostar">INV OFC</td>
					<td>&nbsp;<input class="input1" type="text" style="width:100"name ="inv_ofc_cd" valid="1" desc= "Inv. OFC" class="input1" value="<%=ofcCd%>" readOnly ></td>
					</tr>
				<tr class="h23">
					<td><img class="nostar">Currency</td>
					<td>&nbsp;<script language="javascript">ComComboObject('curr_cd', 1, 91, 1, 1)</script></td>
					<td><img class="nostar">ACC VOL</td><!-- onFocus='canInputACCMVol();' -->
					<td>&nbsp;<input type="text" style="width:77;text-align:right;" name="pay_vol_qty"  onKeyUp='ComChkObjValid(this);ComIsNumber(this,",");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_accumulate"></td>
										<input type="hidden" name="accm_seq" value=''>
										<input type="hidden" name="revisedVol_sum" value=''>
										<input type="hidden" name="revisedVol_minus" value=''>
										<input type="hidden" name="pay_vol_qty_org" value=''>
					</tr>
				<tr class="h23">
					<td><img class="nostar">Hold</td>
					<td>
					<table class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><input type="checkbox" name="hld_flg" value="Y" class="trans"></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btns_remarks" id="btns_remarks">Remarks</td>
												<td class="btn2_right"></td></tr></table>
										</td>
										<td><input type="hidden" name="hld_rmk" maxlength=500 value=""></td>
										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
					</table>
					</td>

				</table>
				<!-- : ( Week ) (E) -->

			</td>
			<td width="10"></td>
			<td class="bg">

				<!-- : ( Week ) (S) -->
				<table class="search" border="0" width="100%">

				<tr class="h23">
					<td width="80"><img class="nostar">INV AMT</td>
					<td width="120">&nbsp;<input class="input1" type="text" style="width:92;text-align:right;" name="ttl_inv_amt"  valid="1" desc= "Inv. AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_total_amount();"></td>
					<td width="100"><img class="nostar">TAX</td>
					<td width="120">&nbsp;<input type="text" style="width:100;text-align:right;" name="vat_amt"valid="1" desc= "V.A.T" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_total_amount();"></td></tr>
				<tr class="h23">
					<td><img class="nostar">W.H.T</td>
					<td>&nbsp;<input type="text" style="width:92;text-align:right;" name="whld_tax_amt" maxlength=20 onKeyUp='tes_isMon(this,"Y",this.form.curr_cd.Code);' onKeyDown='tes_chkInput(this); tes_isMon(this,"Y",this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this,this.form.curr_cd.Code);set_total_amount();"></td>
					<td><img class="nostar">Total AMT</td>
					<td>&nbsp;<input class="input2" type="text" style="width:100;" name="total_amt" maxlength=20 style="width:92;text-align:right;" readonly></td></tr>
				<tr class="h23">
					<td><img class="nostar">Issued DT</td>
					<td>&nbsp;<input class="input1" type="text" style="width:69" name="iss_dt" valid="1" desc= "Issue Date" maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_isNumD(this,"Y");' onBlur="validDate(this); isValIssSys(this);">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>
					<td><img class="nostar">Received DT</td>
					<td>&nbsp;<input class="input1" type="text" style="width:77" name="rcv_dt"  valid="1" desc= "RCV Date" maxlength=10  onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_isNumD(this,"Y");' onBlur="validDate(this); isValIssSys(this);" >&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td></tr>
				<tr class="h23">
					<td><img class="nostar">INV STS</td>
					<td>&nbsp;<input type="text" style="width:92" name="tml_inv_sts_nm"  value="" class="input2" readonly ></td>
										<input type="hidden"   name="tml_inv_sts_cd" value="">
					<td><img class="nostar">Reject STS</td>
					<td>&nbsp;<input type="text" style="width:100" name="tml_inv_rjct_sts_nm"  valid="1" desc= "Reject STS" maxlength=2 value=""  class="input2" readonly >
					<input type="hidden" name="tml_inv_rjct_sts_cd"  valid="1" desc= "Reject STS"  value=""  class="noinput1" readonly >
										<input type="hidden" name="inv_rjct_rmk" maxlength=500 value="">
					</td></tr>
				</table>
				<!-- : ( Week ) (E) -->

			</td>
			<td>
				<div id="IndiaLayer02" style="display:none">
				<table class="search" border="0" width="100%">
					<tr>
						<td width="10"></td>
						<td class="bg">
							<table class="search" border="0" width="100%">
							<tr class="h23">
								<td width="40"><img class="nostar">CGST</td>
								<td width="100">&nbsp;<input class="input1" type="text" style="width:92;text-align:right;" name="ida_cgst_amt"  valid="1" desc= "CGST AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_vat_amount();"></td>
							</tr>
							<tr class="h23">
								<td width="40"><img class="nostar">SGST</td>
								<td width="100">&nbsp;<input class="input1" type="text" style="width:92;text-align:right;" name="ida_sgst_amt"  valid="1" desc= "SGST AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_vat_amount();"></td>
							</tr>
							<tr class="h23">
								<td width="40"><img class="nostar">IGST</td>
								<td width="100">&nbsp;<input class="input1" type="text" style="width:92;text-align:right;" name="ida_igst_amt"  valid="1" desc= "IGST AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_vat_amount();"></td>
							</tr>
							<tr class="h23">
								<td width="40"><img class="nostar">UGST</td>
								<td width="100">&nbsp;<input class="input1" type="text" style="width:92;text-align:right;" name="ida_ugst_amt"  valid="1" desc= "UGST AMT" onKeyUp='tes_isMon(this,"Y", this.form.curr_cd.Code);' onBlur="tes_chkAmtFmtObj(this, this.form.curr_cd.Code);set_vat_amount();"></td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				</div>
			</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="100">VVD/BND/SEQ</td>
					<td width="260"><input type="text" style="width:80" name="vvd" desc= "VVD" value="" maxlength=9  onKeyUp='tes_isApNum(this);upper(this);' onKeyDown='tes_isApNum(this);upper(this);' onBlur='getCallYdIndSeq(this);'> <input type="hidden" name="vvd_no_hidden" value=''> <input type="hidden" name="is_valid_vvd_no" value='Y'> <input type="hidden" name="vvd_type" value=''>
					<select style="width:40;"  value="0" name="io_bnd_cd" desc= "IO BOUND" onChange='getCallYdIndSeq(this);'>
						<option value="O" selected>O</option>
						<option value="I">I</option>
					</select>&nbsp;<script language="javascript">ComComboObject('call_yd_ind_seq', 1, 40, 1)</script>
					&nbsp;<img class="cursor" src="/hanjin/img/button/btng_plus.gif" width="18" height="19" alt="" border="0" align="absmiddle" name="btng_plus"> <img class="cursor" src="/hanjin/img/button/btng_minus.gif" width="18" height="19" alt="" border="0" align="absmiddle" name="btng_minus"></td>
					<td width="80">ATB (ETB)</td>
					<td width="200" class="stm">&nbsp;<input class="input2" type="text" style="width:75" name="atb_dt" desc= "ATB" readonly > <img class="cursor" src="/hanjin/img/button/btng_back.gif" width="18" height="19" alt="" border="0" align="absmiddle" name="btng_back"> <img class="cursor" src="/hanjin/img/button/btng_next.gif" width="18" height="19" alt="" border="0" align="absmiddle" name="btng_next"> <input class="input2" type="text" style="width:35;text-align:center;" name="page" value="" readOnly ></td>
					<td width="140">CALC AMT(VVD/TTL)</td>
					<td><input class="input2" type="text" style="width:95;text-align:right;" name="vvd_inv_amt" value="" readOnly >&nbsp;/&nbsp;<input class="input2" type="text" style="width:95;text-align:right;" name="tot_inv_amt" value="" readOnly ></td></tr>

				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->





		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
     		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">


		<!-- UI_ESD_TES_001 : THIS IS 1st TAB -->
		<div id="tabLayer" style="display:inline">
				<!-- TABLE '#D' : ( Tab BG Box ) (S) -->

							<!-- : ( Grid ) (S) -->
							<table width="100%"  id="mainTable">
								<tr><td>
									 <script language="javascript">ComSheetObject('t1sheet1');</script>
								</td></tr>
							</table>

							<!-- : ( Grid ) (E) -->

				<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

			<div id="SearchLayer01" style="display:inline">
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>
			<!-- TABLE '#D' : ( Search Options :  ) (S) -->


			<!-- : ( Button :Top ) (S) -->
			<table width="100%" class="sbutton">
	       	<tr><td class="align">

			    <table class="sbutton">
			    <tr>
					<td class="bt"><img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" onClick="reSize();"></td></tr>
				</table>

			</td></tr>
			</table>
	    	<!-- : ( Button : Top ) (E) -->

		<div id="SearchLayer02" style="display:inline">
			<table class="search_in" border="0">
				<tr class="h23">
					<td width="4%">Total</td>
					<td width="15%"><input class="input2" type="text" name="sht_01_ttl" style="width:80;text-align:right;" readOnly disabled></td>
					<td width="3%">Full</td>
					<td width="14%"><input class="input2" type="text" name="sht_01_full" style="width:80;text-align:right;" readOnly disabled></td>
					<td width="3%">Empty</td>
					<td width="15%"><input class="input2" type="text" name="sht_01_mt" style="width:80;text-align:right;" readOnly disabled></td>
					<td width="13%">TS(Same Yard)</td>
					<td><input class="input2" type="text" name="sht_01_ts_same_yard" style="width:80;text-align:right;" readOnly disabled></td></tr>
			</table>
			<table class="search_in" border="0">
				<tr class="h23">
					<td width="18">D2 </td><td width="40"><input class="input2" type="text" name="sht_01_D2" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">D4 </td><td width="40"><input class="input2" type="text" name="sht_01_D4" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">D5 </td><td width="40"><input class="input2" type="text" name="sht_01_D5" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">D7 </td><td width="40"><input class="input2" type="text" name="sht_01_D7" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">D8 </td><td width="40"><input class="input2" type="text" name="sht_01_D8" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">D9 </td><td width="40"><input class="input2" type="text" name="sht_01_D9" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">DW </td><td width="40"><input class="input2" type="text" name="sht_01_DW" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">DX </td><td width="40"><input class="input2" type="text" name="sht_01_DX" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">R2 </td><td width="40"><input class="input2" type="text" name="sht_01_R2" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">R4 </td><td width="40"><input class="input2" type="text" name="sht_01_R4" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">R5 </td><td width="40"><input class="input2" type="text" name="sht_01_R5" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">R7 </td><td width="40"><input class="input2" type="text" name="sht_01_R7" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">R8 </td><td width="40"><input class="input2" type="text" name="sht_01_R8" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">R9 </td><td width="40"><input class="input2" type="text" name="sht_01_R9" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">F2 </td><td width="40"><input class="input2" type="text" name="sht_01_F2" style="width:32;text-align:right;" readOnly disabled></td>
					<td width="18">F4 </td><td width="40"><input class="input2" type="text" name="sht_01_F4" style="width:32;text-align:right;" readOnly disabled></td>
					</tr>
				<tr class="h23">
					<td>F5</td><td><input class="input2" type="text" name="sht_01_F5" style="width:32;text-align:right;" readOnly disabled></td>
					<td>O2</td><td><input class="input2" type="text" name="sht_01_O2" style="width:32;text-align:right;" readOnly disabled></td>
					<td>O4</td><td><input class="input2" type="text" name="sht_01_O4" style="width:32;text-align:right;" readOnly disabled></td>
					<td>O5</td><td><input class="input2" type="text" name="sht_01_O5" style="width:32;text-align:right;" readOnly disabled></td>
					<td>O7</td><td><input class="input2" type="text" name="sht_01_O7" style="width:32;text-align:right;" readOnly disabled></td>
					<td>S2</td><td><input class="input2" type="text" name="sht_01_S2" style="width:32;text-align:right;" readOnly disabled></td>
					<td>S4</td><td><input class="input2" type="text" name="sht_01_S4" style="width:32;text-align:right;" readOnly disabled></td>
					<td>T2</td><td><input class="input2" type="text" name="sht_01_T2" style="width:32;text-align:right;" readOnly disabled></td>
					<td>T4</td><td><input class="input2" type="text" name="sht_01_T4" style="width:32;text-align:right;" readOnly disabled></td>
					<td>A2</td><td><input class="input2" type="text" name="sht_01_A2" style="width:32;text-align:right;" readOnly disabled></td>
					<td>A4</td><td><input class="input2" type="text" name="sht_01_A4" style="width:32;text-align:right;" readOnly disabled></td>
					<td>A5</td><td><input class="input2" type="text" name="sht_01_A5" style="width:32;text-align:right;" readOnly disabled></td>
					<td>P2</td><td><input class="input2" type="text" name="sht_01_P2" style="width:32;text-align:right;" readOnly disabled></td> 
					<td>P4</td><td><input class="input2" type="text" name="sht_01_P4" style="width:32;text-align:right;" readOnly disabled></td>
					<!-- 
					<td>Z2</td><td><input class="input2" type="text" name="sht_01_Z2" style="width:32;text-align:right;" readOnly disabled></td>
					<td>Z4</td><td><input class="input2" type="text" name="sht_01_Z4" style="width:32;text-align:right;" readOnly disabled></td>
					-->
					<td>C2</td><td><input class="input2" type="text" name="sht_01_C2" style="width:32;text-align:right;" readOnly disabled></td>
					<td>C4</td><td><input class="input2" type="text" name="sht_01_C4" style="width:32;text-align:right;" readOnly disabled></td>				
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
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_clear" id="t1btng_clear">List Clear</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_todiscrepancy" id="t1btng_todiscrepancy">To Discrepancy</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_getcntr" id="t1btng_getcntr">Get CNTR List</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_save" id="t1btng_save">Save</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_downexcel" id="t1btng_downexcel">Down Excel</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_costcalc" id="t1btng_costcalc">Cost Calc.</td>
							<td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->


		</div>


		<!-- UI_ESD_TES_001 : THIS IS 2st TAB -->
		<div id="tabLayer" style="display:none">
				<!-- TABLE '#D' : ( Tab BG Box ) (S) -->




			<!-- : ( Grid ) (S) -->
							<table width="100%"  id="mainTable">
								<tr><td>
									 <script language="javascript">ComSheetObject('t2sheet1');</script>
								</td></tr>
							</table>

			<!-- : ( Grid ) (E) -->







			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>

						<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_reverify" id="t2btng_reverify">Re-Verify</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_clear" id="t2btng_clear">List Clear</td>
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
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_downexcel" id="t2btng_downexcel">Down Excel</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_print" id="t2btng_print">Print</td>
							<td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->


		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

		</div>


		<!-- UI_ESD_TES_001 : THIS IS 3st TAB -->
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->


			<!-- : ( Grid ) (S) -->
							<table width="100%"  id="mainTable">
								<tr><td>
									 <script language="javascript">ComSheetObject('t3sheet1');</script>
								</td></tr>
							</table>

			<!-- : ( Grid ) (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>

						<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_costCal" id="t3btng_costCal">C/Calculation(AGMT)</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_bb" id="t3btng_bb">B/Bulk</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_clear" id="t3btng_clear">List Clear</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><input type="text" name="rowsadd" size="2" value="1" maxlength="4"></td></tr></table></td>
							<td><table border="0" cellpadding="0" cellspacing="0"><tr>
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

		</div>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




<!--
main_hidden : docObjects[3]
-->
<div id="hidden_sheets1" style="display:none;">
<!--Main_hidden-->
<script language="javascript">ComSheetObject('main_hidden');</script>
</div>
<!-- : docObjects[4]	-->
<div id="hidden_sheets3" style="display:none;">
<!--vvd_hidden-->
<script language="javascript">ComSheetObject('vvd_hidden');</script>
</div>
<!--accumulate_hidden : docObjects[5]-->
<div id="hidden_sheets4" style="display:none;">
<!--accm_hidden-->
<script language="javascript">ComSheetObject('accm_hidden');</script>
</div>
<!--	RVIS : docObjects[6]	-->
<div id="hidden_sheets6" style="display:none;">
<!--rvis_hidden-->
<script language="javascript">ComSheetObject('rvis_hidden');</script>
</div>
<!--	N3RD : docObjects[7]	-->
<div id="hidden_sheets7" style="display:none;">
<!--n3rd_hidden-->
<script language="javascript">ComSheetObject('n3rd_hidden');</script>
</div>
<!--	AMOUNT : docObjects[8]	-->
<div id="hidden_sheets8" style="display:none;">
<!--amt_hidden-->
<script language="javascript">ComSheetObject('amt_hidden');</script>
</div>
<div id="hidden_sheets9" style="display:none">
<!--etc_hidden-->
<script language="javascript">ComSheetObject('etc_hidden');</script>
</div>
<div id="hidden_sheets10" style="display:none">
<!--total_hidden-->
<script language="javascript">ComSheetObject('total_hidden');</script>
</div>
<div id="hidden_sheets11" style="display:none">
<!--vvd_check_hidden-->
<script language="javascript">ComSheetObject('vvd_check_hidden');</script>
</div>
</td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
