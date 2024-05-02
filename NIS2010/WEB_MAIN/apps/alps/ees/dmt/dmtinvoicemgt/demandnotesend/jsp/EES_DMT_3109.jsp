<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3109.jsp
*@FileTitle : Demand Note Issue by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.25 최성환
* 1.0 Creation
* 2011.02.08 김태균 [CHM-201108612-01] [EES-DMT] [DMT] Demand Note 환율 표기 관련
* 2012.07.09 김현화 [CHM-201218976] 인도 Demand Note Issue - GST 적용.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3109Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3109Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id 	= "";
	String strUsr_nm 	= "";
	String strUsr_ofc 	= "";
	String strCnt_cd 	= "";
	String strUsr_eml	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.demandnotesend");

	//Parameter
	String s_group_by 		= "";
	String s_chg_type 		= "";
	String s_ofc_cd 		= "";
	String dmdt_chg_sts_cds	= "";
	String s_bkg_no 		= "";
	String s_dmdt_trf_cd 	= "";
	String s_cntr_no 		= "";
	String invoice_issue 	= "";
	String s_invoice_no 	= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		strCnt_cd 	= account.getCnt_cd();
		strUsr_eml 	= account.getUsr_eml();


		event = (EesDmt3109Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		s_group_by		= JSPUtil.getParameter(request,"group_by");
		s_chg_type		= JSPUtil.getParameter(request,"chg_type");
		s_ofc_cd		= JSPUtil.getParameter(request,"ofc_cd");
		dmdt_chg_sts_cds= JSPUtil.getParameter(request,"dmdt_chg_sts_cd");
		s_bkg_no		= JSPUtil.getParameter(request,"bkg_no");
		s_dmdt_trf_cd	= JSPUtil.getParameter(request,"dmdt_trf_cd");
		s_cntr_no		= JSPUtil.getParameter(request,"cntr_no");
		invoice_issue	= JSPUtil.getParameter(request,"invoice_issue");	//1:before, 2:after
		s_invoice_no	= JSPUtil.getParameter(request,"dmdt_inv_no");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Demand Note Issue - Booking</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc %>">
<input type="hidden" name="session_email" value="<%=strUsr_eml %>">
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>">
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="session_cnt_cd" value="<%=strCnt_cd %>">
<!-- country code -->
<input type="hidden" name="tax_nm"><!-- AU(GST) / 이외 (VAT) -->
<!--  select 조건 -->
<input type="hidden" name="s_group_by" value="<%=s_group_by %>">
<input type="hidden" name="s_chg_type" value="<%=s_chg_type %>">
<input type="hidden" name="s_ofc_cd" value="<%=s_ofc_cd %>">
<input type="hidden" name="s_bkg_no" value="<%=s_bkg_no %>">
<input type="hidden" name="s_dmdt_trf_cd" value="<%=s_dmdt_trf_cd %>">
<input type="hidden" name="s_cntr_no" value="<%=s_cntr_no %>">
<input type="hidden" name="s_cust_gubun" >
<input type="hidden" name="s_cust_cd" >
<input type="hidden" name="invoice_issue" value="<%=invoice_issue %>"> <!-- 1(before), 2(after) -->
<input type="hidden" name="s_invoice_no" value="<%=s_invoice_no %>"> 
<input type="hidden" name="vndr_cd" >
<input type="hidden" name="curr_cd">
<input type="hidden" name="rfa_no"><!-- invoice save 용 -->
<input type="hidden" name="chg_type"><!-- invoice save 용 -->
<input type="hidden" name="ofc_cd" value="<%=strUsr_ofc %>"><!-- session시 조회 용 -->
<input type="hidden" name="svr_id"><!-- Attention -->
<input type="hidden" name="usr_cnt_cd"><!--  invoice 전 cnt_cd //2010.04.04.-->

<input type="hidden" name="cust_cntc_pnt_seq">	<!-- Attention -->
<input type="hidden" name="dmdt_payr_cntc_pnt_nm" >
<input type="hidden" name="cust_cnt_cd"><!-- Attention -->
<input type="hidden" name="cust_seq">	<!-- Attention -->

<input type="hidden" name="tax_rto">
<input type="hidden" name="dmdt_chg_sts_cds" value="<%=dmdt_chg_sts_cds %>"> 

<input type="hidden" name="call_to_rd_tp" value="booking"><!-- rd 호출용 데이터 -->

<input type="hidden" name="org_curr_cd"><!-- 자체 페이지 rd(preview/fax/email) -->
<input type="hidden" name="tot_org_amt"><!-- 자체 페이지 rd(preview/fax/email) -->
<input type="hidden" name="ex_rate"><!-- 자체 페이지 rd(preview/fax/email) -->
<input type="hidden" name="cntr_no"><!-- 자체 페이지 rd(preview/fax/email) -->

<!-- ETC 데이터 -->
<input type="hidden" name="cust_vat">
<input type="hidden" name="ofc_add01">
<input type="hidden" name="ofc_add02">
<input type="hidden" name="ofc_add03">
<input type="hidden" name="cust_nm">
<input type="hidden" name="address01">
<input type="hidden" name="address02">
<input type="hidden" name="address03">
<input type="hidden" name="address04">
<input type="hidden" name="header01">
<input type="hidden" name="header02">
<input type="hidden" name="header03">
<input type="hidden" name="header04">
<input type="hidden" name="header05">
<input type="hidden" name="header06">
<input type="hidden" name="header07">
<input type="hidden" name="header08">
<input type="hidden" name="header09">
<input type="hidden" name="header10">
<input type="hidden" name="sh_num">
<input type="hidden" name="hjs_ref">
<input type="hidden" name="print_date">
<input type="hidden" name="dmdt_trf_nm">

<!-- Demand Note Issue Preview - Booking -->
<!-- ETC 데이터 -->
<input type="hidden" name="sheet_remark01">
<input type="hidden" name="sheet_remark02">
<input type="hidden" name="sheet_remark03">
<input type="hidden" name="sheet_remark04">
<input type="hidden" name="sheet_remark05">
<input type="hidden" name="sheet_remark06">
<input type="hidden" name="sheet_remark07">
<input type="hidden" name="sheet_remark08">
<input type="hidden" name="sheet_remark09">
<input type="hidden" name="sheet_remark10">
<input type="hidden" name="sheet_remark11">
<input type="hidden" name="sheet_remark12">
<input type="hidden" name="sheet_remark13">
<input type="hidden" name="sheet_remark14">

<input type="hidden" name="vvd_nm">
<input type="hidden" name="arr">
<input type="hidden" name="dep">
<input type="hidden" name="cmdt_cd">
<input type="hidden" name="cmdt_nm">
<input type="hidden" name="bkg_rcv_term_cd">
<input type="hidden" name="bkg_rcv_term_nm">
<input type="hidden" name="bkg_del_term_cd">
<input type="hidden" name="bkg_del_term_nm">
<input type="hidden" name="pod">
<input type="hidden" name="pod_nm">
<input type="hidden" name="del">
<input type="hidden" name="del_nm">
<input type="hidden" name="trucker">

<!-- rd hidden 처리 flag -->
<input type="hidden" name="bil_to_loc_div_cd"><!-- 0:left, 1:right, default:left -->
<input type="hidden" name="cust_ref_prn_flg">
<input type="hidden" name="phn_fax_prn_flg">
<input type="hidden" name="cust_vat_prn_flg">
<input type="hidden" name="tax_amt_prn_flg">
<input type="hidden" name="dc_amt_prn_flg">
<input type="hidden" name="title">
<!-- PAYER INFO FAX,EMAIL SETTING -->
<input type="hidden" name="payr_faxnos">
<input type="hidden" name="payr_emailnos">

<input type="hidden" name="tmp_payer_cd">

<!-- rd data set -->
<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- RD FILE NAME 파일 이름만 *.  //-->
<input type="hidden" name="rd_fxeml_bat_flg"        > <!-- N //-->
<input type="hidden" name="rd_fxeml_title"          > <!-- 제목 //-->
<input type="hidden" name="rd_fxeml_rd_param"       > <!-- RD REPORT PARAMETER //-->
<input type="hidden" name="rd_fxeml_fax_no"         > <!-- RECIEVER FAX NO ex) NAME:5336  //-->
<input type="hidden" name="rd_fxeml_fax_sndr_id"    > <!-- SENDER ID //-->
<input type="hidden" name="rd_fxeml_eml_sndr_nm"    > <!-- EMAIL SENDER NAME  //-->
<input type="hidden" name="rd_fxeml_eml_sndr_add"   > <!-- SENDER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_rcvr_add"   > <!-- RECIEVER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_atch_file"  > <!-- ATTACH FILE NAME //-->
<input type="hidden" name="rd_fxeml_eml_templt"     > <!-- C:/sitectx/ALPS/APP-INF/config/template/mailtemplate/ TEMPLETE FILE 메일본문 //-->
<input type="hidden" name="rd_fxeml_eml_tmplt_param"> <!-- MAILETEMPLETE PARAM ex) name;mjchang|message;DMT EMAIL SEND TEST //-->
<input type="hidden" name="rd_fxeml_doc_tp"			> <!-- DEMAND 구분 //-->
<input type="hidden" name="invno"					> <!-- invoice no //-->		
<input type="hidden" name="payc"					> <!-- payer code //-->	
<!-- rd data set //-->

<!-- payer check -->
<input type="hidden" name="h_payer_cd">
<input type="hidden" name="h_payer_nm">
<!-- 인도 TAX RATIO 변경 전 필드 -->
<input type="hidden" name="ida_expn_tax_rt">
<input type="hidden" name="ida_expn_tax">
<input type="hidden" name="ida_edu_tax_rt">
<input type="hidden" name="ida_edu_tax">
<input type="hidden" name="ida_high_edu_tax_rt">
<input type="hidden" name="ida_high_edu_tax">
<input type="hidden" name="ida_locl_tax_rt">
<input type="hidden" name="ida_n2nd_locl_tax_rt">
<input type="hidden" name="tax_rgst_no">
<input type="hidden" name="svc_cate_rmk"> 
<input type="hidden" name="pmnt_acct_no">
<!-- 인도 TAX RATIO 변경 후 필드 ( 2017.07.26 ) -->
<input type="hidden" name="ida_tax_appl_tm">
<input type="hidden" name="cust_vndr_div_cd">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="cond_ida_sac_cd">
<input type="hidden" name="port_cd">
<input type="hidden" name="ida_cgst_rto">
<input type="hidden" name="ida_sgst_rto">
<input type="hidden" name="ida_igst_rto">
<input type="hidden" name="ida_ugst_rto">
<!-- 인도 TAX 관련 공통함수 구현에 따른 추가 필드 (어떤 화면에서 호출되었는지 구분하기 위함) ( 2017.07.26 ) -->
<input type="hidden" name="pgm_id" value="3109">
<!-- invoice 발행 후 조회 시 등록된 정보로 초기화를 시켜줘야 되기 때문에 계산 로직을 실행하지 않도록 제어해주는 변수 -->
<input type="hidden" name="inv_amt_calc_tp">
<!-- 인도 TAX Calculation 은 Tax Amount 변경에 의해서 실행됨을 알려주는 변수 ( 이 경우는 Tax Amount 를 계산하지 않고 입력된 금액으로 계산이 수행됩니다. ) -->
<input type="hidden" name="calc_by_cng_ida_tax_amt" value="N">
<!-- invoice A/R I/F 여부를 나타냄 ( 공통함수 사용에 따라 추가됨 ) -->
<input type="hidden" name="dmdt_ar_if_cd" value="N">

<!-- 인도 TAX RD 출력시 사용할 필드 -->
<input type="hidden" name="ida_bank_acct_no">
<input type="hidden" name="ida_bank_ifsc_cd">
<input type="hidden" name="ida_tax_cin">
<input type="hidden" name="ida_ofc_ste_cd">

<!-- Preview / Demand Print / Fax Send / Email Send 를 위해 RD 출력 전, 필요한 정보 조회시 조회결과 필드명 앞에 rd 붙일지 여부  -->
<!-- Preview 화면에서 실행된 경우에는 무조건 Y, 그렇지 않으면 무조건 N  -->
<input type="hidden" name="rd_var_nm_flg" value="N">


<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Demand Note Issue - Booking</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">BKG No.</td>
						<td width="120"><input type="text" name="bkg_no" style="width:100;" class="input2" value="" readonly></td>
						<td width="50">B/L No.</td>
						<td width="150"><input type="text" name="bl_no" style="width:100;" class="input2" value="" readonly></td>
						<td width="68">Tariff Type</td>
						<td width="225"><input type="text" name="dmdt_trf_cd" style="width:50;" class="input2" value="" readonly></td>
						<td width="">&nbsp;</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">VVD CD</td>
						<td width="120"><input type="text" name="vvd_cd" style="width:100;" class="input2" value="" readonly></td>
						<td width="25">POR</td>
						<td width="75"><input type="text" name="por_cd" style="width:55;text-align:center;" class="input2" value="" readonly></td>
						<td width="25">POL</td>
						<td width="75"><input type="text" name="pol_cd" style="width:55;text-align:center;" class="input2" value="" readonly></td>
						<td width="25">POD</td>
						<td width="75"><input type="text" name="pod_cd" style="width:55;text-align:center;" class="input2" value="" readonly></td>
						<td width="30">DEL</td>
						<td width="75"><input type="text" name="del_cd" style="width:55;text-align:center;" class="input2" value="" readonly></td>
						<td width="38">R/D</td>
						<td width="50"><input type="text" name="rd" style="width:33;" class="input2" value="" readonly></td>
						<td width="55">S/C No.</td>
						<td width=""><input type="text" name="sc_no" style="width:95;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">BKG Cust.</td>
						<td width=""><input type="text" name="bkg_cust_cd" style="width:100;" class="input2" value="" readonly>&nbsp;<input type="text" name="bkg_cust_nm" style="width:227;" class="input2" value="" readonly></td>
					</tr>
					<tr class="h23">
						<td width="70">A/R Cust.</td>
						<td width=""><input type="text" name="act_cust_cd" style="width:100;" class="input2" value="" readonly>&nbsp;<input type="text" name="act_cust_nm" style="width:227;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Payer</td>
						<td width=""><input type="text" name="payer_cd" style="width:77;" dataformat="engup" class="input1" caption="Payer" maxlength="8" value="" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btn_payer_cd" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >&nbsp;<input type="text" name="payer_nm" style="width:403;" class="input2" value="" readonly></td>
					</tr>
				</table>				
				<table id="ida_gst_info" class="search" border="0" style="width:979;display:none;">
					<tr class="h23">
						<td width="70">GST Reg.</td>
						<td width="100"><input type="text" name="ida_gst_rgst_sts_nm" style="width:100;" class="input2" readonly></td>
						<td width="20">&nbsp;</td>
						<td width="80">GSTIN/UIN</td>
						<td width="120"><input type="text" name="ida_gst_rgst_no" style="width:120;" class="input2" readonly></td>
						<td width="20">&nbsp;</td>
						<td width="25">State</td>
						<td width="261"><input type="text" name="ida_ste_cd" style="width:30;" class="input2" readonly>&nbsp;<input type="text" name="ida_ste_nm" style="width:200;" class="input2" readonly></td>
						<td width="60">SAC</td>
						<td width=""><input type="text" name="ida_sac_cd" style="width:50;" class="input2" readonly>&nbsp;<input type="text" name="ida_sac_nm" style="width:160;" class="input2" readonly></td>						
					</tr>
				</table>				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Attention</td>
						<td width="181"><script language="javascript">ComComboObject('combo1', 4, 150 , 1, 0, 0, true)</script></td>
						<td width="25">Tel.</td>
						<td width="180"><input type="text" name="payr_cntc_pnt_phn_no" style="width:130;" class="input2" value="" readOnly></td>
						<td width="25">Fax</td>
						<td width="180"><input type="text" name="payr_cntc_pnt_fax_no" style="width:131;" class="input2" value="" readOnly></td>
						<td width="40">E-mail</td>
						<td width="" class="stm"><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" value="" readOnly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="68">Trucker</td>
						<td width=""><input type="text" name="trucker_cd" maxlength="6"  style="width:77;" dataformat="engup" class="input" value="" caption="Trucker">&nbsp;<img src="img/btns_search.gif" name="btn_trucker_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="trucker_nm" style="width:440;" class="input2" value="" readOnly></td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="120" valign="top">
						
							<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Charge</td></tr>
							</table>
							<table class="search" border="0">
							<tr class="h23">
								<td width="80">Charge Cur.</td>
								<td><input type="text" name="chg_curr_cd" style="width:30;text-align:right" class="input2" value=""  readOnly></td>
							</tr>
							</table>
							
						
						</td>
						<td width="300" valign="top">
						<table class="grid2" border="0" width="320">
							<tr class="h23">
								<td class="tr2_head" width="150">Incurred AMT</td>
								<td class="input2" align="right"><input type="text" name="mn_org_chg_amt" style="width:100;text-align:right" class="noinput2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head">Exception AMT </td>
								<td class="input2" align="right"><input type="text" name="dmdt_expt_amt" style="width:100;text-align:right" class="noinput2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head">Discount AMT</td>
								<td class="input2" align="right"><input type="text" name="chg_dc_amt" style="width:100;text-align:right" class="noinput2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> Billable AMT</td>
								<td class="input2" align="right"><input type="text" name="mn_bil_amt" style="width:100;text-align:right" class="noinput2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head" id="txt_aft_inv_adj_amt" name="txt_aft_inv_adj_amt">Adjusted AMT after INV</td>
								<td class="input2" align="right"><input type="text" name="aft_inv_adj_amt"  style="width:100;text-align:right" class="noinput2" value="" readOnly></td>
							</tr>
						</table>
						
						
						</td>
						<td width="10">&nbsp;</td>
						<td width="180" valign="top">
						
							<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Invoice</td></tr>
							</table>
							<table class="search" border="0">
							<tr class="h23">
								<td width="70">INV Cur.</td>
								<!-- 2011.01.26. JS:searchARCurrencyList() ,function getExRate()
								<td><input type="text" name="inv_curr_cd" style="width:40;text-align:center" class="input2" value="" readOnly>
								 -->
								<td><select name="inv_curr_cd" style="width:80;" class="input1" onchange="DmtComCalcInvAmtByTaxAmt()">&nbsp;
									</select>
								</td>
							</tr>
							</table>
							<table class="search" border="0">
							<tr class="h23">
								<td width="70">Ex. Rate</td>
								<td><input type="text" name="inv_xch_rt" style="width:75;text-align:right" class="input2" value="" readOnly></td>
							</tr>
							</table>
							<table class="search" border="0">
							<tr class="h23">
								<td width="70">CNTR Q’ty</td>
								<td><input type="text" name="cntr_cnt" style="width:75;text-align:right" class="input2" value="" readOnly></td>
							</tr>
							</table>
							
							<table id="ida_tax_bef_tm" class="search" border="0" style="display:none;">
								<tr class="h23">
									<td width="70">SBC AMT</td>
									<td><input type="text" name="ida_locl_tax" style="width:75;text-align:right" class="input2" readonly></td>
								</tr>
								<tr class="h23">
									<td width="70">KKC AMT</td>
									<td><input type="text" name="ida_n2nd_locl_tax" style="width:75;text-align:right" class="input2" readonly></td>
								</tr>
							</table>
						
							<table id="ida_tax_aft_tm" class="search" border="0" style="display:none;">
								<tr class="h23">
									<td width="70">SGST AMT</td>
									<td><input type="text" name="ida_sgst_amt" style="width:90;text-align:right" class="input2" dataformat="float2" size="16" pointcut="2" maxlength="18"></td>
								</tr>
								<tr class="h23">
									<td width="70">CGST AMT</td>
									<td><input type="text" name="ida_cgst_amt" style="width:90;text-align:right" class="input2" dataformat="float2" size="16" pointcut="2" maxlength="18"></td>
								</tr>
								<tr class="h23">
									<td width="70">IGST AMT</td>
									<td><input type="text" name="ida_igst_amt" style="width:90;text-align:right" class="input2" dataformat="float2" size="16" pointcut="2" maxlength="18"></td>
								</tr>
								<tr class="h23">
									<td width="70">UGST AMT</td>
									<td><input type="text" name="ida_ugst_amt" style="width:90;text-align:right" class="input2" dataformat="float2" size="16" pointcut="2" maxlength="18"></td>
								</tr>
							</table>						
						
						</td>
						<td width="320" valign="top">
						<table class="grid2" border="0" width="320">
							
							<tr class="h23">
								<td width="140" class="tr2_head">Total AMT</td>
								<td colspan="3" class="input2" align="right"><input type="text" name="tot_amt" style="width:180;text-align:right" class="noinput2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> D/C by AMT or %</td>
								<td colspan="3" class="input2" align="right"><input type="text" name="dc_amt" style="width:180;text-align:right" class="noinput2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> Billing AMT </td>
								<td colspan="3" class="input2" align="right"><input type="text" name="inv_chg_amt" style="width:180;text-align:right" class="noinput2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> Tax Rate/ AMT </td>
								<td class="input2"><input type="checkbox" name="chk_tax" value="1" class="trans" onclick="DmtComApplTaxRto();">&nbsp;<input type="text" name="tax_rto_dis" style="width:40;text-align:right" class="noinput2" value="" readonly>&nbsp;% </td>
								<td colspan="2" class="input2" align="right"><input type="text" name="tax_amt" style="width:100;text-align:right" class="noinput2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> Payable AMT </td>
								<td colspan="3" class="input2" align="right"><input type="text" name="inv_amt" style="width:180;text-align:right" class="noinput2" value="" readonly></td>
							</tr>							
						</table>
						</td>
					</tr>
				
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!--  grid   (E) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>

				<!--  grid   (E) -->
	
					
					</td>
				</tr>
				</table>
				
		
				
			
<!-- : ( Search Options ) (E) -->

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_set">Sheet  Set</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_option">Sheet Option</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_sendinghistory">Sending History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
		</td></tr>
		</table>
    <!--Button (E) -->
    
	
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Demand Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_fax">Fax Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_email">Email Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_payerfaxemail">Payer  Info.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				
				
		</td></tr>
		</table>
    <!--Button (E) -->
    </td></tr>
		</table>
    </td></tr>
		</table>	
	
	</td></tr>
</table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>	


<!-- : ( Button : pop ) (E) -->
<table width="100%"  id="mainTable2" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet2');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>	
<!-- 개발자 작업  끝 -->
<!-- RD OBJECT -->		
                    <table width="100%" height="0" id="mainTable"> 
                        <tr>
                            <td width="100%">
<script language='javascript'>comRdObject('Demand',0,0);</script>
                            </td>
                        </tr>
                    </table>
</form>
</body>
</html>