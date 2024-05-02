
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0071.jsp
	 *@FileTitle : FNS_INV_0071
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.15
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.05.15 정휘택
	 * 1.0 Creation
	 * History
	 * -------------------------------------------------------- 
	 * 2011.04.06 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
	 * 2011.11.23 권 민 [CHM-201114430-01] MRI 생성 관련 CREDIT TERM 로직 보완 요청
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0071Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	FnsInv0071Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strCnt_cd = "";

	String arIfNo = "";
	String classId = "";
	String pArOfcCd = "";

	Logger log = Logger
			.getLogger("com.hanjin.apps.AccountReceivableInvoiceCreation.ManualARCreation");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();

		arIfNo = StringUtil.xssFilter(request.getParameter("ar_if_no"));
		if (arIfNo == null) {
			arIfNo = "";
		}

		classId = StringUtil.xssFilter(request.getParameter("classId"));
		if (classId == null) {
			classId = "";
		}

		pArOfcCd = StringUtil.xssFilter(request.getParameter("ar_ofc_cd"));
		if (pArOfcCd == null) {
			pArOfcCd = "";
		}

		event = (FnsInv0071Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>FNS_INV_0071</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
    <input type="hidden" name="f_cmd"> 
    <input type="hidden" name="pagerows"> 
<!-- 개발자 작업	--> 
    <input type="hidden" name="pagetype" value="E"> 
    <input type="hidden" name="ar_ofc_cd2"> 
    <input type="hidden" name="svr_id">
    <input type="hidden" name="rhq_cd"> 
    <input type="hidden" name="ofc_cd"> 
    <input type="hidden" name="bnd"> 
    <input type="hidden" name="p_chg_cd"> 
    <input type="hidden" name="inv_cust_cnt_cd"> 
    <input type="hidden" name="inv_cust_seq"> 
    <input type="hidden" name="curr_cd">
    <input type="hidden" name="lcl_curr"> 
    <input type="hidden" name="usd_exrate_type"> 
    <input type="hidden" name="third_exrate_type"> 
    <input type="hidden" name="ex_rate_date"> 
    <input type="hidden" name="ex_rate">
    <input type="hidden" name="str_usr_nm" value="<%=strUsr_nm%>"> 
    <input type="hidden" name="select_row"> 
    <input type="hidden" name="c_flag" value="Y"> 
    <input type="hidden" name="vvd">
    <input type="hidden" name="port"> 
    <input type="hidden" name="classId" value="<%=classId%>"> 
    <input type="hidden" name="p_ar_ofc_cd" value="<%=pArOfcCd%>"> 
    <input type="hidden" name="dp_prcs_knt" value=""> 
    <input type="hidden" name="delt_flg" value=""> 
    <input type="hidden" name="rev_src_cds" value=""> 
    <input type="hidden" name="local_time" value=""> 
    <input type="hidden" name="exist_yn" value=""> 
    <input type="hidden" name="blck_chg" value=""> 
    <input type="hidden" name="bl_inv_cfm_dt" value="">
    <input type="hidden" name="state" value=""> 
    <input type="hidden" name="bkg_no" value=""> 
    <input type="hidden" name="chg_cds" value=""> 
    <input type="hidden" name="curr_cds" value="">
    <input type="hidden" name="per_tp_cds" value=""> 
    <input type="hidden" name="inv_svc_scp_cd" value=""> 
    <input type="hidden" name="loc_cd" value=""> 
    <input type="hidden" name="eff_dt_tmp" value=""> 
    <input type="hidden" name="tmp_bl_src_no" value="">
    <input type="hidden" name="iva_rate" value="">
    <input type="hidden" name="ib_vvd" value="">
    <input type="hidden" name="ob_vvd" value="">
    <input type="hidden" name="eu_check" >
    
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- 1 (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="55">B/L No.</td>
						<td width="190"><input type="text" value="" class="input"
							style="width: 130;" name="bl_no" maxlength="12"
							dataformat="engup" style="ime-mode:disabled"></td>
						<td width="50">I/F No.</td>
						<td width="230"><input type="text" class="input2"
							style="width: 120;" value="<%=arIfNo%>" maxlength="11"
							name="ar_if_no" readonly> <!--<td width="55">BKG No.</td>
						<td width="230">
						<input type="text" class="input" style="width:120;" value="" maxlength="11" name="bkg_no" dataformat="engup" style="ime-mode: disabled" >
						<input type="hidden" class="input" style="width:45;" value="" maxlength="2" name="bkg_no_split" dataformat="engup" style="ime-mode: disabled">--></td>
						<td width="40">Office</td>
						<td><!--<select style="width:90;" class="input1">
							<option value="0" selected>HAMBB</option>
							<option value="1"></option>
							</select>--> <script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0);</script>
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) --></td>
			</tr>
		</table>
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- 1 (E)--> <!-- 2 (S)--> <!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0"
			width="100%">
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> <!--TAB Creation (S) -->
		<div id="tabLayer" style="display: inline">

		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90" align="right" style="padding-right: 5">Actual Cust.</td>
						<td width="632"><input type="text" style="width: 35"
							class="input1" name="cust_cnt_cd" maxlength="2"
							dataformat="engup" value="" style="ime-mode:disabled"> <input
							type="text" style="width: 60" class="input1" name="cust_seq"
							maxlength="6" dataformat="int" value="" style="ime-mode:disabled">
						<img src="img/btns_search.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" id="popup1"
							onclick="javascript:openFnsInv0013();"> <input type="text"
							style="width: 263" class="input2" value="" name="cust_nm"
							readonly> <input type="text" style="width: 124"
							class="input1" value="" name="cust_rgst_no" dataformat="int" maxlength="20"> <img
							src="img/btns_search.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" id="popup2"
							onclick="javascript:openFnsInv0086();"></td>
						<td width="68">Rev. Type</td>
						<td align="left"><input type="text" class="input2"
							style="width: 30;" name="rev_tp_cd" value="M" readonly> <!--<select style="width:46;" class="input1">
						<option value="0" selected>IV</option>
						<option value="1">IC</option>
						<option value="1">OC</option>
						<option value="1">TS</option>
						</select>--> <script language="javascript">ComComboObject('rev_src_cd', 1, 46, 1, 1);</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90" align="right" style="padding-right: 5">Credit Limit</td>
						<td width="290"><input type="text" style="width: 35"
							class="input2" value="" name="cr_curr_cd" readonly>&nbsp;<input
							type="text" style="width: 110; text-align: right;" class="input2"
							value="" name="cr_amt" readonly></td>
						<td width="93">Credit Term</td>
						<td width="233">O/B&nbsp;<input type="text"
							style="width: 40; text-align: right;" class="input2" value=""
							name="ob_cr_term_dys" readonly>&nbsp;I/B&nbsp;<input
							type="text" style="width: 40; text-align: right;" class="input2"
							value="" name="ib_cr_term_dys" readonly></td>
						<td width="85">Credit Office</td>
						<td align="left"><input type="text" style="width: 80"
							class="input2" value="" name="cr_clt_ofc_cd" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90" align="right" style="padding-right: 5">LCL VVD</td>
						<td width="127"><input type="text" style="width: 90;"
							class="input1" value="" name="lcl_vvd" maxlength="9"
							dataformat="engup" style="ime-mode:disabled"></td>
						<td width="40">Scope</td>
						<td width="127"><input type="text" style="width: 80;"
							class="input1" value="" name="svc_scp_cd" maxlength="3"
							dataformat="engup" style="ime-mode:disabled"></td>
						<td width="35">BND</td>
						<td width="132"><select style="width: 46;" class="input1"
							name="io_bnd_cd">
							<option value="O" selected>O/B</option>
							<option value="I">I/B</option>
						</select></td>
						<td width="64">S/A Date</td>
						<td width="100"><input type="text" style="width: 80" class="input2"
							value="" name="sail_arr_dt" readonly></td>
						<td width="70" align="right" style="padding-right: 5">Trunk	VVD</td>
						<td align="left"><input type="text" style="width: 90;"
							class="input" value="" name="trunk_vvd" maxlength="9"
							dataformat="engup" style="ime-mode:disabled"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90" align="right" style="padding-right: 5">Master I/F No.</td>
						<td width="127"><input type="text" style="width: 90;"
							class="input2" value="" name="mst_if_no" maxlength="11"
							dataformat="engup" style="ime-mode:disabled" readOnly></td>
						<td width="40">POR</td>
						<td width="127"><input type="text" style="width: 80;"
							class="input" value="" name="por_cd" maxlength="5"
							dataformat="engup" style="ime-mode:disabled"></td>
						<td width="35">POL</td>
						<td width="164"><input type="text" style="width: 80;"
							class="input1" value="" name="pol_cd" maxlength="5"
							dataformat="engup" style="ime-mode:disabled"></td>
						<td width="32">POD</td>
						<td width="144"><input type="text" style="width: 80"
							class="input1" value="" name="pod_cd" maxlength="5"
							dataformat="engup" style="ime-mode:disabled"></td>
						<td width="31">DEL</td>
						<td align="left"><input type="text" style="width: 80"
							class="input" value="" name="del_cd" maxlength="5"
							dataformat="engup" style="ime-mode:disabled"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90" align="right" style="padding-right: 5">Master INV</td>
						<td width="174"><input type="text" style="width: 120;"
							class="input" value="" name="master_inv"
							style="ime-mode:disabled"></td>
						<td width="80">SML Ref.</td>
						<td width="241"><input type="text" style="width: 160;"
							class="input" value="<%=strUsr_nm%>" name="hjs_ref"></td>
						<td width="30">TEU</td>
						<td width="144"><input type="text"
							style="width: 80; text-align: right;" class="input" value=""
							name="bkg_teu_qty" style="ime-mode:disabled"></td>
						<td width="31">FEU</td>
						<td align="left"><input type="text"
							style="width: 57; text-align: right;" class="input" value=""
							name="bkg_feu_qty" style="ime-mode:disabled"> <img
							src="img/btns_search.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor"
							onclick="javascript:openContainer();" id="popup3"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90" align="right" style="padding-right: 5">INV Ref. No.</td>
						<td width="174"><input type="text" style="width: 120;"
							class="input" value="" name="inv_ref_no"></td>
						<td width="80">BKG Ref. No.</td>
						<td width="192"><input type="text" style="width: 160;"
							class="input2" value="" name="bkg_ref_no" readonly></td>
						<td width="79">S/I Ref. No.</td>
						<td align="left"><input type="text" style="width: 255;"
							class="input2" value="" name="si_ref_no" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90" align="right" style="padding-right: 5">Description</td>
						<td><input type="text" style="width: 780;" class="input"
							value="" name="inv_rmk"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="90" align="right" style="padding-right: 5">Due Date</td>
						<td width="174"><input type="text" style="width: 80;"
							class="input2" value="" name="due_dt" readonly></td>
						<td width="80">Eff. Date</td>
						<td width="197"><input type="text" style="width: 80;"
							class="input2" value="" name="eff_dt" dataformat="ymd" maxlength="8" readonly></td>
						<td width="74">Input Date</td>
						<td><input type="text" style="width: 80;" class="input2"
							name="bl_inv_if_dt" value="" readonly></td>
					</tr>
				</table>
				<!--  biz_1   (E) --></td>
			</tr>
		</table>
		<!-- 2 (E)--></div>
		<!--TAB Creation (E) --> <!--TAB Charge (S) -->
		<div id="tabLayer" style="display: none">

		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Charge (S) -->

				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">By Charge</td>
					</tr>
				</table>

				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>

				<!-- Charge (E) --> <!--  Button_Sub (S) -->
				<table width="100%" class="button" border="0">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_add">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_del">Delete</td>
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
				<div id="btn_layer_ib" style="display: none;">
				<table width="100%" class="search" border="0">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ib_all">ALL</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ib_ats">ATS</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ib_dhs">DHS</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ib_sis">SIS</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ib_ahc">AHC</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ib_whs">WHS</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ib_psm">PSM</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ib_wht">WHT</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</div>
				<div id="btn_layer_ob" style="display: none;">
				<table width="100%" class="search" border="0">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ob_all">ALL</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ob_ats">ATS</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ob_dhs">DHS</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ob_bcu">BCU</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ob_whs">WHS</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ob_wht">WHT</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</div>
				<br>

				<!-- Summary (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">By Currency</td>
					</tr>
				</table>

				<table width="500" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				<!-- Summary (E) --> <!-- Container (S) -->
				<table width="200">
					<tr>
						<td width="100%" style="display: none"><script
							language="javascript">ComSheetObject('sheet3');</script></td>
					</tr>
				</table>
				<!-- Container (E) --></td>
			</tr>
		</table>
		<!-- 2 (E)--></div>
		<!--TAB Charge (E) --></td>
	</tr>
</table>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				
				<td width="72" >
				<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_auto">Auto B/L No.</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td width="712" >
				</td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right">
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right">
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!--Button (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>