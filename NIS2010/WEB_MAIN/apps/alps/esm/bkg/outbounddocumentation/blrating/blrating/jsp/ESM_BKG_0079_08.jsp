<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0079_08.jsp
 *@FileTitle : Freight & Charge
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.26 이진서
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.11.01 이일민 [CHM-201006493-01] Charge Save시 Self Audit 자동 실행 요청 - Self-Audit 는 취소를 누른 경우 다시 뜨지 않도록 함, frt_term 컬럼 수정시는 제외
 2011.03.03 정선용 [CHM-201109023-01] Booking 의 Volumn 과 Container Volumn 이 일치 하지 않는 경우 Application Date 를 빨강색으로 표시
 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 2013.04.19 김진주 [CHM-201323704] [Charge Adjustment] 팝업 개발 및 오토레이팅 연계 요청
 ==========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg007908Event"%>
<%
	EsmBkg007908Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");
	String sXml = null;
	String rTerm = "";
	String dTerm = "";
	String isInquiry = "N";	
	String bkg_no ="";
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg007908Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		
		bkg_no      = event.getBkg_no();
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		  rTerm =  (String)eventResponse.getCustomData("rTerm");
		  dTerm =  (String)eventResponse.getCustomData("dTerm");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);		
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Freight & Charge</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="frm">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
</form>

<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<!-- 개발자 작업	--> 
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 
<input type="hidden" name="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'> 
<input type="hidden" name="application_date" value='<%=JSPUtil.getParameter(request, "application_date")%>'> 

<input type="hidden" name="frm_t10sheet1_rmark_yn" value="" >
<input type="hidden" name="frm_t10sheet1_rfa_yn" value="" >
<input type="hidden" name="sc_no" value="">
<input type="hidden" name="caflag" value="">
<input type="hidden" name="autoRate" value="N">
<input type="hidden" name="removeAll" value="N">
<input type="hidden" name="bdrflag" value="">
<input type="hidden" name="rOfc_cd" value="">
<input type="hidden" name="sc_available" value="">
<input type="hidden" name="sc_available_red" value="">
<input type="hidden" name="rfa_available" value="">
<input type="hidden" name="taa_available" value="">

<input type="hidden" name="frm_t10sheet1_bkg_sts_cd" value="" >
<input type="hidden" name="frm_t10sheet1_bkg_rt_whf_expt_cd" value="" >
<input type="hidden" name="frm_t10sheet1_dhf_loc_cd" value="" >
<input type="hidden" name="frm_t10sheet1_ddc_curr_cd" value="" >
<input type="hidden" name="frm_t10sheet1_dhf_curr_cd" value="" >
<input type="hidden" name="frm_t10sheet1_bkg_svc_scp_cd" value="" >
<input type="hidden" name="flex_hgt_flg">
<input type="hidden" name="frm_rcv_term_cd" value="<%=rTerm%>">
<input type="hidden" name="frm_de_term_cd" value="<%=dTerm%>">
<input type="hidden" class="noinput" name="modify_flag" value="N">

<input type="hidden" name="frm_t10sheet1_hngr_flg" value="" >
<input type="hidden" name="frm_t10sheet1_rc_flg" value="" >
<input type="hidden" name="frm_t10sheet1_rt_bl_tp_cd_old" value="">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="page_type" value="ESM_BKG_0079_08" >
<input type="hidden" name="oblIssFlg" value="N" >

<input type="hidden" name="frm_t10sheet1_rt_aply_dt_bak">
<input type="hidden" name="ctrt_ofc_cd" value="">
<input type="hidden" name="ctrt_srep_cd" value="">
<input type="hidden" name="bkg_ofc_cd" value="">
<input type="hidden" name="old_bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>">
<input type="hidden" name="aloc_sts_cd" value="">

<input type="hidden" name="frm_t10sheet1_sc_no_old">
<input type="hidden" name="frm_t10sheet1_rfa_no_old">
<input type="hidden" name="frm_t10sheet1_taa_no_old">
<input type="hidden" name="frm_t10sheet1_rtro_flg">
<input type="hidden" name="frm_t10sheet1_rtro_knd_cd">
<input type="hidden" name="frm_t10sheet1_oft_amdabl_flg">
<input type="hidden" name="frm_t10sheet1_old_oft_amt">

<input type="hidden" name="frm_t10sheet1_bkg_ctrt_tp_cd">

<!--TAB Charge (S) --> 
<!--biz page - TOP (S)-->
<table class="search" id="mainTable" style="width: 998;">
	<tr>
		<td class="bg"><!-- biz_frame - 1 (S) -->
		<table class="search" style="width: 979;" border="0">
			<tr>
				<td valign="top" width="51%" style="padding-right: 10;"><!--  biz_1 (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="55">BKG No.</td>
						<td width="253">
							<input type='text' style='width: 110;' class='input1' dataformat="uppernum" style="ime-mode:disabled" maxlength="13" name='frm_t10sheet1_bkg_no' value='<%=JSPUtil.getParameter(request, "bkg_no")%>'>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
							<!-- 
							<img name="pop_bkg_no" class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
							<div id="span_bkg_no" name="span_bkg_no" style="position:absolute;z-index:999;display:none;"></div>
							 -->
							 
						</td>
						<td width="50">B/L No.</td>
						<td width="" align="right"><input type="text" style="width: 120;"  dataformat="uppernum" style="ime-mode:disabled" maxlength="13"  name='frm_t10sheet1_bl_no' value='' class="input"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
		
					<tr class="h23">
						<td width="57">Bill Type</td>
						<td width="51">
								<script language="javascript">ComComboObject('rt_bl_tp_cd', 2, 40, 1)</script>
								<input type="hidden" name="frm_t10sheet1_rt_bl_tp_cd" value="">
						</td>
						<td width="70"><span id="covered_name"></span></td>
						<td width="200">
								<!--  MASTER -->
								<span id="covered_id_m" style="display:none">
								<input type="hidden" name="covered_name_m" value="">
								<img name="pop_covered" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</span>
								<!--  COVERED -->
								<span id="covered_id_c" style="display:none">
								<input type="text" style="width: 110;" name="covered_name_c" value="" dataformat="uppernum" style="ime-mode:disabled" maxlength="13" class="input">&nbsp;
								</span>
								<input type="hidden" name="frm_t10sheet1_mst_cvrd_bl" value="">
								
								<!--  B TYPE -->
								<span id="covered_id_b" style="display:none">
								<input type="text" style="width: 40;" name="inrAuth1" value="COBIZ"  															class="input2" readonly>
								<input type="text" style="width: 20;" name="inrAuth2" value="" 		dataformat="engup" style="ime-mode:disabled" maxlength="2" 	class="input">
								<input type="text" style="width: 20;" name="inrAuth3" value="" 		dataformat="int" style="ime-mode:disabled" maxlength="2" 	class="input">
								<input type="text" style="width: 20;" name="inrAuth4" value="INR/"   															class="input2" readonly>
								<input type="text" style="width: 20;" name="inrAuth5" value="" 		dataformat="engup" style="ime-mode:disabled" maxlength="1" 	class="input">
								<input type="text" style="width: 40;" name="inrAuth6" value="" 		dataformat="int" style="ime-mode:disabled" maxlength="4" 	class="input">
								</span>
								<input type="hidden" name="frm_t10sheet1_cobiz_auth_no" value="">
						</td>
						<td width="76" align="center">FRT Term</td>
						<td>
								<script language="javascript">ComComboObject('frt_term_cd', 2, 40, 1)</script>
								<input type="hidden" name="frm_t10sheet1_frt_term_cd" value="">
						</td>
					</tr>
					
						
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="55">Weight</td>
						<td width="155"><input type="text" style="width: 103;text-align:right;" name = "frm_t10sheet1_act_wgt" value=""  class="input2" readonly>&nbsp;<input type="text" style="width: 35;" name = "frm_t10sheet1_wgt_ut_cd" value="" class="input2" readonly></td>
						<td width="55">Measure</td>
						<td width="145"><input type="text" style="width: 80;text-align:right;" name = "frm_t10sheet1_meas_qty" value=""  class="input2" readonly>&nbsp;<input type="text" style="width: 35;" name = "frm_t10sheet1_meas_ut_cd" value="" class="input2" readonly></td>
						<td width="40">Special</td>
						<td align="right"><input type="text" style="width: 25;" name = "frm_t10sheet1_special" value="" class="input2" readonly></td>
					</tr>
				</table>
				
				<!--  biz_1   (E) --></td>

				<td width="49%" valign="top" style="padding-left: 15;"><!--  biz_2 (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="113">Application Date</td>
						<td width="112"><input type="text" style="width: 105;" name = "frm_t10sheet1_rt_aply_dt" id="frm_t10sheet1_rt_aply_dt" value=""  class="input1" maxlength="10" dataformat="ymd" style="ime-mode:disabled" onFocus="viewAppDtMsg();" onBlue="setTxtColor();"></td>

						<td width="100">
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10search_date" id='btn_t10search_date'>Search</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="50"></td>
						<td width="93">Audit Status</td>
						<td width="" align="right"><input type="text" style="width: 25;" name = "frm_t10sheet1_aud_sts_cd" value="" class="input2" readonly ></td>
						
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="70">Route</td>
						<td width="230">
							<input type="text" style="width: 45;" name = "frm_t10sheet1_por_cd" value=""  class="input2" readonly>&nbsp;
							<input type="text" style="width: 45;" name = "frm_t10sheet1_pol_cd" value=""  class="input2" readonly>&nbsp;
							<input type="text" style="width: 45;" name = "frm_t10sheet1_pod_cd" value=""  class="input2" readonly>&nbsp;
							<input type="text" style="width: 45;" name = "frm_t10sheet1_del_cd" value=""  class="input2" readonly>&nbsp;
						</td>
						<td width="25">Pre</td>
						<td width="70"><input type="text" style="width: 50;" name = "frm_t10sheet1_pre_rly_port_cd" value=""  class="input2" readonly></td>
						<td width="30">Post</td>
						<td width=""><input type="text" style="width: 50;" name = "frm_t10sheet1_pst_rly_port_cd" value=""  class="input2" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="70">R/D Term</td>
						<td width="90">
						<input type="text" style="width: 25;" name = "frm_t10sheet1_rcv_term_cd" value="" class="input2" readonly>&nbsp;
						<input type="text" style="width: 25;" name = "frm_t10sheet1_de_term_cd" value="" class="input2" readonly>
						</td>
						<td width="105">Service Scope</td>
						<td>
						<select style="width: 210;" name ="svc_scp_cd" class="input2" readonly></select>
						<input type="hidden" name="frm_t10sheet1_svc_scp_cd"> 
						</td>
					</tr>
				</table>
				

				<!--  biz_2   (E) --></td>
			</tr>
		</table>
		
		<table class="line_bluedot">
			<tr>
				<td colspan="6"></td>
			</tr>
		</table>
				
				
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90">Customs Desc</td>
						<td width="255"><input type="text" style="width: 240;" name = "frm_t10sheet1_cstms_desc" value="" class="input2" readonly></td>
						<td width="70">Rep. CMDT</td>
						<td>
							<input type="text" style="width: 47; text-align: center;" value="" class="input2" name="frm_t10sheet1_rep_cmdt_cd" readonly> 
							<input type="text" style="width: 200;" value="" class="input2" name="frm_t10sheet1_rep_cmdt_nm" readonly>
						</td>
						<td width="40">CMDT</td>
						<td width="255">
							<input type="text" style="width: 47; text-align: center;" value="" class="input2" name="frm_t10sheet1_cmdt_cd" readonly> 
							<input type="text" style="width: 200;" value="" class="input2" name="frm_t10sheet1_cmdt_nm" readonly>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="48">S/C No.</td>
						<td width="145">
							<input type="text" style="width: 85;" name = "frm_t10sheet1_sc_no1" value="" dataformat="uppernum" maxlength="9" style="ime-mode:disabled" class="input">
							<input type="text" style="width: 25;" value="" class="input2" readonly>
							<img name="pop_sc_no" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<input type="hidden" name="frm_t10sheet1_sc_no2">
						<td width="53">
						<table width="52" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10note" id='btn_t10note'>Note</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						
						<td width="100">Break Down
							<input type="checkbox" class="trans" name = "brk_dwn_flg" value="">
							<input type="hidden" name="frm_t10sheet1_brk_dwn_flg">
						</td>
						<td width="48">RFA No.</td>
						<td width="142">
							<input type="text" style="width: 85;" name = "frm_t10sheet1_rfa_no" value="" dataformat="uppernum"  maxlength="11" style="ime-mode:disabled" class="input">
							<input type="text" style="width: 25;" name = "frm_t10sheet1_sp_prop_sts_cd" value="" class="input2" readonly>
							<img name="pop_rfa_no" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<td>
						<table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10RoutId" id='btn_t10RoutId'>R.ID</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="50">TAA No.</td>
						<td width="" align="center">
							<input type="text" style="width: 100;" name = "frm_t10sheet1_taa_no" value="" dataformat="uppernum"  maxlength="10" style="ime-mode:disabled" class="input">
							<input type="text" style="width: 25;" value="" class="input2" readonly>
							<img name="pop_tta_no" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<td width="40" align="center">Mode</td>
						<td>
								<input type="text" style="width: 65;" name="frm_t10sheet1_org_trns_mod_cd" value="" class="input2" readonly>
								<input type="text" style="width: 65;" name="frm_t10sheet1_dest_trns_mod_cd" value="" class="input2" readonly>
						</td>
						
					</tr>
				</table>
				
				
				
				
				
		<!-- biz_frame - 1 (E) -->
		<table class="line_bluedot">
			<tr>
				<td colspan="6"></td>
			</tr>
		</table>




		<!-- Grid  (S) -->
		<script language="javascript">ComSheetObject('t10sheet1');</script>
		<div style="display:none;"></div>
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject('t10sheet2');</script></td>
				</tr>
			</table>
		<script language="javascript">ComSheetObject('t10sheet3');</script>
		<script language="javascript">ComSheetObject('t10sheet4');</script>
		<script language="javascript">ComSheetObject('t10sheet5');</script>
		<script language="javascript">ComSheetObject('t10sheet6');</script>
		<script language="javascript">ComSheetObject('t10sheet7');</script>		
		<!-- Grid (E) --> <!--  Button_Sub (S) -->
		
		
		
		
		<table width="100%" class="button">
			<tr>
				<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10add">Row Add</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10del">Row Delete</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10merge">Merge</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10surcharge_Inquiry">Surcharge Inquiry</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10adj" id="btn_t10adj">Surcharge Adjustment</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t10bkg_qty">Vol. detail</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>



					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- Button_Sub (E) -->
		<table class="line_bluedot">
			<tr>
				<td colspan="6"></td>
			</tr>
		</table>

		<!-- biz_frame - 3,4,5 (S) -->
		<table class="search" style="width: 979;">
			<tr>
				<td valign="top" width="26%" style="padding-right: 53;"><!--  biz_3 (S) -->
				<table border="0" style="width: 100%; background-color: white;" class="grid2">
					<tr class="tr2_head">
						<td colspan="2">Prepaid</td>
					</tr>
					<tr>
						<td class="tr2_head3" align="center">Total</td>
						<td class='input2' id="TOTAL_PPD"></td>
					</tr>					
					<tr>
						<td class="tr2_head2">At</td>
						<td style="width: 165;" >
							<input type="text" style="width: 55;" class="input" name="frm_p_t10sheet3_ofc_cd" value="" dataformat="uppernum" maxlength="6" style="ime-mode:disabled">
							<input type="text" style="width: 25;" class="input" name="frm_p_t10sheet3_cnt_cd" value="" dataformat="uppernum" maxlength="2" style="ime-mode:disabled" >
							<input type="text" style="width: 55;" class="input" name="frm_p_t10sheet3_cust_seq" value="" dataformat="int" maxlength="6" style="ime-mode:disabled" >
							<img name="pop_prepaid" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td><input type="hidden" name="frm_p_t10sheet3_ofc_cd_enable"><input type="hidden" name="frm_p_t10sheet3_cust_seq_enable"/>
					</tr>
				</table>
				<!--  biz_3   (E) --></td>
				<td valign="top" width="26%" style="padding-right: 53;"><!--  biz_4 (S) -->
				<table border="0" style="width: 100%; background-color: white;" class="grid2">
					<tr class="tr2_head">
						<td colspan="2">Collect</td>
					</tr>
					<tr>
						<td class="tr2_head3" align="center">Total</td>
						<td class='input2' id="TOTAL_CCT"></td>
					</tr>
					<tr>
						<td class="tr2_head2">At</td>
						<td style="width: 165;" >
						<input type="text" style="width: 55;" class="input" name="frm_c_t10sheet3_ofc_cd" value=""  dataformat="uppernum" maxlength="6" style="ime-mode:disabled">
						<input type="text" style="width: 25;" class="input" name="frm_c_t10sheet3_cnt_cd" value=""  dataformat="uppernum" maxlength="2" style="ime-mode:disabled">
						<input type="text" style="width: 55;" class="input" name="frm_c_t10sheet3_cust_seq" value=""  dataformat="int" maxlength="6" style="ime-mode:disabled">
						<img name="pop_collect" id="pop_collect" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td><input type="hidden" name="frm_c_t10sheet3_ofc_cd_enable"><input type="hidden" name="frm_c_t10sheet3_cust_seq_enable">
					</tr>
				</table>
				<!--  biz_4   (E) --></td>

				<td valign="top" width="26%" style="padding-right: 53;"><!--  biz_4 (S) -->
				<table border="0" style="width: 100%; background-color: white;" class="grid2">
					<tr class="tr2_head">
						<td colspan="2">3rd Party - PPD</td>
					</tr>
					<tr>
						<td class="tr2_head3"  align="center">Total</td>
						<td class='input2' id="TOTAL_3rdPPD"></td>
					</tr>					
					<tr>
						<td class="tr2_head2">At</td>
						<td style="width: 165;" >
						<select name='select_3rdPPD' style="width: 98%;">
							
						</select></td>
					</tr>
				</table>
				<!--  biz_4   (E) --></td>

				<td valign="top" width="%" style="padding-left: 14;"><!--  biz_4 (S) -->
				<table border="0" style="width: 100%; background-color: white;" class="grid2">
					<tr class="tr2_head">
						<td colspan="2">3rd Party - CCT</td>
					</tr>
					<tr>
						<td class="tr2_head3"  align="center">Total</td>
						<td class='input2' id="TOTAL_3rdCCT"></td>
					</tr>
					<tr>
						<td class="tr2_head2">At</td>
						<td style="width: 165;" >
						<select name='select_3rdCCT' style="width: 98%;">
							
						</select></td>
					</tr>
				</table>
				<!--  biz_4   (E) --></td>
			</tr>
		</table>
		<!-- biz_frame - 3,4,5 (E) -->
		</td>
			</tr>
		</table>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_t103rdBLReq" id="btn_t103rdBLReq">3rd Party B/L Request</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>	
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10retrieve" id="btn_t10retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10save" id="btn_t10save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10cntr_rate">CNTR Rate</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10auto_rating" id="btn_t10auto_rating">Auto-Rating</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- <td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10chg_amend">CHG Amend</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td> -->					
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10exchange_rating">Exchange Rate</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10clear">Clear</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10remark" id='btn_t10remark'>Remark(s)</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10self"  id='btn_t10self'>Self Audit</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10tpb_link">TPB Link</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t10cust_link">Cust. Rate</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
<!--biz page - BOTTOM (E)--> <!-- 개발자 작업  끝 -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>
</form>
</body>
</html>