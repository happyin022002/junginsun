<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4002.jsp
*@FileTitle : Invoice Creation & Issue - Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2010.11.11 김태균 [CHM-201007006-01] [EES-DMT] [DMDT] Invoice Currency 선택 기능 추가
* 2011.03.31 김태균 [CHM-201109784-01] [DMT] Invoice Creation & Issue의 Payer 정보 확인 절차 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//Save, Cancel, A/R I/F 버튼 권한 부여
	int i_cnt = 0;
	Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
	
	//Parameter
	String s_group_by = "";
	String s_chg_type = "";
	String s_ofc_cd = "";
	String s_bkg_no = "";
	String s_dmdt_trf_cd = "";
	String s_cntr_no = "";
	String invoice_issue = "";
	String s_invoice_no = "";
	String dmdtVtInvYn = "";
	String dmdtVtInvNo = "";
	String dmdtVtInvStsCd = "";

	String ctrt_flg = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		strCnt_cd 	= account.getCnt_cd();
		strUsr_eml 	= account.getUsr_eml();
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();
		
		//권한부여 체크 추가(2010.04.08)-- 로그인 User의 Role이 DMT01, DMT02, DMT03, DMT04가 아닐 경우
		//							   "You have no authority to XXXX!" alert 창을 띄우며 막음
		/******************************
		if(arrUsrAuth == null){
			log.debug("[USER_AUTH] null");
			sec_invoice = "N";
		}else{
			log.debug("[USER_AUTH] "+arrUsrAuth.length);
			for(int i = 0; i < arrUsrAuth.length; i++) {
				//test
				sb.append(arrUsrAuth[i]).append("===");
				
				if(arrUsrAuth[i].equals("DMT01") 
						|| arrUsrAuth[i].equals("DMT02") 
						|| arrUsrAuth[i].equals("DMT03")
						|| arrUsrAuth[i].equals("DMT04"))
				{
					i_cnt++;
				}
			}
			if(i_cnt == 0 ){
				sec_invoice = "N";
			}
		}
		
		log.debug("[USER_AUTH]"+sb.toString());
        ******************************/

		event = (EesDmt4002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		s_group_by		= JSPUtil.getParameter(request,"group_by");
		s_chg_type		= JSPUtil.getParameter(request,"chg_type");
		s_ofc_cd		= JSPUtil.getParameter(request,"ofc_cd");
		s_bkg_no		= JSPUtil.getParameter(request,"bkg_no");
		s_dmdt_trf_cd	= JSPUtil.getParameter(request,"dmdt_trf_cd");
		s_cntr_no		= JSPUtil.getParameter(request,"cntr_no");
		invoice_issue	= JSPUtil.getParameter(request,"invoice_issue");	//1:before, 2:after
		s_invoice_no	= JSPUtil.getParameter(request,"invoice_no");
		dmdtVtInvYn		= JSPUtil.getParameter(request,"dmdt_vt_inv_yn");
		dmdtVtInvNo		= JSPUtil.getParameter(request,"dmdt_vt_inv_no");
		dmdtVtInvStsCd  = JSPUtil.getParameter(request,"dmdt_vt_inv_sts_cd");
		
		ctrt_flg = JSPUtil.getParameter(request,"ctrt_flg");
		
		sec_invoice     = eventResponse.getETCData("ROLE_AUTH_FLAG"); // 화면별 사용자 Role 권한 Flag 반환
		log.debug("\n[USER_AUTH] = "+ sec_invoice);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice Creation & Issue - Booking</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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
<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Virtual Invoice -->
<input type="hidden" name="dmdt_vt_inv_yn" value="<%=dmdtVtInvYn%>">
<input type="hidden" name="dmdt_vt_inv_no" value="<%=dmdtVtInvNo%>">
<input type="hidden" name="dmdt_vt_inv_sts_cd" value="<%=dmdtVtInvStsCd%>">
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
<input type="hidden" name="dmdt_payr_cntc_pnt_nm" >
<input type="hidden" name="cust_cntc_pnt_seq" >
<input type="hidden" name="vndr_cd" >
<input type="hidden" name="curr_cd">
<input type="hidden" name="rfa_no"><!-- invoice save 용 -->
<input type="hidden" name="chg_type"><!-- invoice save 용 -->
<input type="hidden" name="ofc_cd"><!-- Invoice Cur list 조회 용 -->
<input type="hidden" name="svr_id"><!-- Attention -->
<input type="hidden" name="cust_cnt_cd"><!-- Attention -->
<input type="hidden" name="cust_seq"><!-- Attention -->
<input type="hidden" name="session_cnt_cd" value="<%=strCnt_cd %>">
<input type="hidden" name="bil_to_loc_div_cd"><!-- L:left, R:right, default:left -->
<input type="hidden" name="dmdt_chg_sts_cds" value="C">
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc %>">
<input type="hidden" name="session_email" value="<%=strUsr_eml %>">
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>">
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>">

<input type="hidden" name="ctrt_flg" value="<%=ctrt_flg%>">

<input type="hidden" name="success_yn">
<input type="hidden" name="ar_usr_id">
<input type="hidden" name="ar_ofc_cd">
<input type="hidden" name="usr_cnt_cd"><!--  invoice 전 cnt_cd //2010.04.04.-->
<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>"><!-- invoice 저장 권한 코드 -->
<!-- C.REMARK, H.REMARK -->
<input type="hidden" name="dmdt_cxl_rsn_cd">
<input type="hidden" name="dmdt_cxl_rsn_nm">
<input type="hidden" name="cxl_rmk">
<input type="hidden" name="inv_hld_rsn_cd">
<input type="hidden" name="inv_hld_rsn_nm">
<input type="hidden" name="inv_hld_rmk">
<input type="hidden" name="upd_dt">
<input type="hidden" name="upd_ofc_cd">
<input type="hidden" name="upd_usr_id">
<input type="hidden" name="upd_usr_nm">
<!-- searchCurrentDateByOffice -->
<input type="hidden" name="ofc_curr_date">
<!-- INVOICE TAX_RTO -->
<input type="hidden" name="tax_rto">
<input type="hidden" name="inv_tax_rto">
<!-- PAYER INFO FAX,EMAIL SETTING -->
<input type="hidden" name="payr_faxnos">
<input type="hidden" name="payr_emailnos">
<!-- EMAIL, FAX SENDING -->
<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- RD FILE NAME 파일 이름만 *.mrd //-->
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
<input type="hidden" name="rd_fxeml_doc_tp"> <!-- I : Invoice D : Demend G : GroupDemand O : OTS //-->
<input type="hidden" name="invno">
<input type="hidden" name="payc">
<!-- sheet set -->
<input type="hidden" name="dmdt_sh_tp_cd">
<input type="hidden" name="has_sheetset">
<!-- preview -->
<input type="hidden" name="org_payer_cd" >
<input type="hidden" name="org_dmdt_payr_cntc_pnt_nm" >
<input type="hidden" name="org_payr_cntc_pnt_phn_no" >
<input type="hidden" name="org_payr_cntc_pnt_fax_no" >
<input type="hidden" name="org_payr_cntc_pnt_eml" >
<!-- Master RD -->
<input type="hidden" name="rd_sh_addr1">
<input type="hidden" name="rd_sh_addr2">
<input type="hidden" name="rd_sh_addr3">
<input type="hidden" name="rd_invoice_title">
<input type="hidden" name="rd_cancel_note">
<input type="hidden" name="rd_cust_nm">
<input type="hidden" name="rd_payr_addr">
<input type="hidden" name="rd_attn_nm">
<input type="hidden" name="rd_phn_no">
<input type="hidden" name="rd_fax_no">
<input type="hidden" name="rd_dmdt_inv_no">
<input type="hidden" name="rd_issue_day">
<input type="hidden" name="rd_due_date">
<input type="hidden" name="rd_due_day">
<input type="hidden" name="rd_ntc_knt_cd">
<input type="hidden" name="rd_cre_usr_nm">
<input type="hidden" name="rd_cust_cd">
<input type="hidden" name="rd_inv_ref_no">
<input type="hidden" name="rd_cust_vat_no">
<input type="hidden" name="rd_sh_hd_n1st_msg">
<input type="hidden" name="rd_sh_hd_n2nd_msg">
<input type="hidden" name="rd_sh_hd_n3rd_msg">
<input type="hidden" name="rd_sh_hd_n4th_msg">
<input type="hidden" name="rd_sh_hd_n5th_msg">
<input type="hidden" name="rd_vvd_cd">
<input type="hidden" name="rd_vsl_eng_nm">
<input type="hidden" name="rd_arr">
<input type="hidden" name="rd_dep">
<input type="hidden" name="rd_bl_no">
<input type="hidden" name="rd_bkg_no">
<input type="hidden" name="rd_cmdt_nm">
<input type="hidden" name="rd_dmdt_trf_cd">
<input type="hidden" name="rd_dmdt_trf_nm">
<input type="hidden" name="rd_bkg_rcv_term_nm">
<input type="hidden" name="rd_bkg_del_term_nm">
<input type="hidden" name="rd_pod">
<input type="hidden" name="rd_pod_nm">
<input type="hidden" name="rd_del">
<input type="hidden" name="rd_del_nm">
<input type="hidden" name="rd_trucker_nm">
<input type="hidden" name="rd_org_chg_amt">
<input type="hidden" name="rd_org_curr_cd">
<input type="hidden" name="rd_inv_xch_rt">
<input type="hidden" name="rd_tot_amt">
<input type="hidden" name="rd_inv_curr_cd">
<input type="hidden" name="rd_dc_amt">
<input type="hidden" name="rd_inv_chg_amt">
<input type="hidden" name="rd_tax_rto">
<input type="hidden" name="rd_tax_amt">
<input type="hidden" name="rd_inv_amt">
<input type="hidden" name="rd_inv_rmk1">
<input type="hidden" name="rd_inv_rmk2">
<input type="hidden" name="rd_sh_rmk1">
<input type="hidden" name="rd_sh_rmk2">
<input type="hidden" name="rd_sh_rmk3">
<input type="hidden" name="rd_sh_rmk4">
<input type="hidden" name="rd_sh_rmk5">
<input type="hidden" name="rd_sh_rmk6">
<input type="hidden" name="rd_sh_rmk7">
<input type="hidden" name="rd_sh_rmk8">
<input type="hidden" name="rd_sh_rmk9">
<input type="hidden" name="rd_sh_rmk10">
<input type="hidden" name="rd_sh_rmk11">
<input type="hidden" name="rd_sh_rmk12">
<input type="hidden" name="rd_sh_rmk13">
<input type="hidden" name="rd_sh_rmk14">
<input type="hidden" name="rd_tax_amt_prn_flg">
<input type="hidden" name="rd_phn_fax_prn_flg">
<input type="hidden" name="rd_cust_vat_prn_flg">
<input type="hidden" name="rd_dc_amt_flg">
<input type="hidden" name="rd_cust_ref_prn_flg">
<input type="hidden" name="rd_days_disp">
<input type="hidden" name="rd_dmdt_inv_sts_cd">
<input type="hidden" name="rd_cre_cnt_cd">
<!-- [ RD ] 인도 TAX RATIO 변경 전 필드 -->
<input type="hidden" name="rd_ida_expn_tax_rt">
<input type="hidden" name="rd_ida_expn_tax">
<input type="hidden" name="rd_ida_edu_tax_rt">
<input type="hidden" name="rd_ida_edu_tax">
<input type="hidden" name="rd_ida_high_edu_tax_rt">
<input type="hidden" name="rd_ida_high_edu_tax">
<!-- SBC ( Swacha Bharat Cess ) -->
<input type="hidden" name="rd_ida_locl_tax_rt">
<input type="hidden" name="rd_ida_locl_tax">
<!-- KCC ( Krishi Kalyan Cess ) -->
<input type="hidden" name="rd_ida_n2nd_locl_tax_rt">
<input type="hidden" name="rd_ida_n2nd_locl_tax"> 
<!-- [ RD ] 인도 TAX RATIO 변경 후 필드 ( 2017.07.26 ) -->
<input type="hidden" name="rd_ida_tax_appl_tm">
<input type="hidden" name="rd_ida_cgst_rto">
<input type="hidden" name="rd_ida_cgst_amt">
<input type="hidden" name="rd_ida_sgst_rto">
<input type="hidden" name="rd_ida_sgst_amt">
<input type="hidden" name="rd_ida_igst_rto">
<input type="hidden" name="rd_ida_igst_amt">
<input type="hidden" name="rd_ida_ugst_rto">
<input type="hidden" name="rd_ida_ugst_amt">
<!-- [ RD ] 인도 TAX 공통 -->
<input type="hidden" name="rd_tax_rgst_no">
<input type="hidden" name="rd_svc_cate_rmk"> 
<input type="hidden" name="rd_pmnt_acct_no"> 
<input type="hidden" name="rd_ida_bank_acct_no">
<input type="hidden" name="rd_ida_bank_ifsc_cd">
<input type="hidden" name="rd_ida_gst_rgst_no">
<input type="hidden" name="rd_ida_ste_cd">
<input type="hidden" name="rd_ida_ste_nm">
<input type="hidden" name="rd_ida_sac_cd">
<input type="hidden" name="rd_ida_tax_cin">
<input type="hidden" name="rd_ida_ofc_ste_cd">
<input type="hidden" name="rd_ida_ofc_ste_nm">

<!-- payer check -->
<input type="hidden" name="h_payer_cd">
<input type="hidden" name="h_payer_nm">
<input type="hidden" name="act_payr_cust_nm"> <!-- E-mail Send용 Customer Name -->
<!-- RD check -->
<input type="hidden" name="rhq_ofc_cd">

<input type="hidden" name="inv_new_rpt_flg">

<input type="hidden" name="col_charge">
<input type="hidden" name="col_tax">
<input type="hidden" name="col_amt">
<input type="hidden" name="ots_clt_flg">
<input type="hidden" name="col_over_day">
<input type="hidden" name="vt_collected">
<!-- AUTO INF. -->
<input type="hidden" name="auto_ar_inf_yn">

<input type="hidden" name="chg_uncol_amt">
<input type="hidden" name="inv_col_charge">
<input type="hidden" name="inv_col_tax">
<input type="hidden" name="chg_col_charge">
<input type="hidden" name="chg_col_tax">

<!-- 인도 TAX RATIO 변경 전 필드 -->
<input type="hidden" name="ida_expn_tax_rt">
<input type="hidden" name="ida_expn_tax">
<input type="hidden" name="ida_edu_tax_rt">
<input type="hidden" name="ida_edu_tax">
<input type="hidden" name="ida_high_edu_tax_rt">
<input type="hidden" name="ida_high_edu_tax">
<input type="hidden" name="ida_locl_tax_rt">
<input type="hidden" name="ida_n2nd_locl_tax_rt">
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
<input type="hidden" name="pgm_id" value="4002">
<!-- invoice 발행 후 조회 시 등록된 정보로 초기화를 시켜줘야 되기 때문에 계산 로직을 실행하지 않도록 제어해주는 변수 -->
<input type="hidden" name="inv_amt_calc_tp">
<!-- 인도 TAX Calculation 은 Tax Amount 변경에 의해서 실행됨을 알려주는 변수 ( 이 경우는 Tax Amount 를 계산하지 않고 입력된 금액으로 계산이 수행됩니다. ) -->
<input type="hidden" name="calc_by_cng_ida_tax_amt" value="N">
<!-- 인도 TAX RD 출력시 사용할 필드 -->
<input type="hidden" name="ida_bank_acct_no">
<input type="hidden" name="ida_bank_ifsc_cd">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Creation & Issue - Booking</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	<table class="search"> 
		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Invoice No. </td>
						<td width="130"><input type="text" name="dmdt_inv_no" style="width:100;" class="input2" value="" readonly>
										<input type="text" name="inv_prt_flg" style="width:20;" class="input2" value="" readonly>
						</td>
						<td width="150">Issue Date/OFC/Name </td>
						<td width="353"><input type="text" name="cre_dt" style="width:80;" class="input2" value="" readonly>&nbsp;<input type="text" name="cre_ofc_cd" style="width:50;" class="input2" value="" readonly><input type="hidden" name="cre_cnt_cd">&nbsp;<input type="hidden" name="cre_usr_id"><input type="text" name="cre_usr_nm" style="width:180;" class="input2" value="" readonly></td>
						<td width="90">Status</td>
						<td width=""><input type="hidden" name="dmdt_inv_sts_cd"><input type="text" name="dmdt_inv_sts_nm" style="width:95;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">A/R I/F</td>
						<td width="130"><input type="text" name="dmdt_ar_if_cd" style="width:100;" class="input2" value="" readonly></td>
						<td width="150">A/R I/F Date/OFC/Name </td>
						<td width="353"><input type="text" name="ar_if_dt" style="width:80;" class="input2" value="" readonly>&nbsp;<input type="text" name="ar_if_ofc_cd" style="width:50;" class="input2" value="" readonly>&nbsp;<input type="hidden" name="ar_if_usr_id"><input type="text" name="ar_if_usr_nm" style="width:180;" class="input2" value="" readonly></td>
						<td width="90">ERP Col. Date</td>
						<td width=""><input type="text" name="col_date" style="width:95;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">BKG No.</td>
						<td width="130"><input type="text" name="bkg_no" style="width:100;" class="input2" value="" readonly></td>
						<td width="50">B/L No.</td>
						<td width="170"><input type="text" name="bl_no" style="width:100;" class="input2" value="" readonly></td>
						<td width="68">Tariff Type</td>
						<td width="215"><input type="text" name="dmdt_trf_cd" style="width:50;" class="input2" value="" readonly></td>
						<td width="90"><div id="cr_nm">Credit Note</div></td>
						<td width=""><input type="text" name="cr_inv_no" style="width:95;" class="input2" value="" readonly>&nbsp;<input type="text" name="cr_ar_yn" style="width:60;" class="input2" value="" readonly></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">VVD CD</td>
						<td width="130"><input type="text" name="vvd_cd" style="width:100;" class="input2" value="" readonly></td>
						<td width="25">POR</td>
						<td width="75"><input type="text" name="por_cd" style="width:55;text-align:center;" class="input2" value="" readonly></td>
						<td width="25">POL</td>
						<td width="75"><input type="text" name="pol_cd" style="width:55;text-align:center;" class="input2" value="" readonly></td>
						<td width="25">POD</td>
						<td width="75"><input type="text" name="pod_cd" style="width:55;text-align:center;" class="input2" value="" readonly></td>
						<td width="30">DEL</td>
						<td width="75"><input type="text" name="del_cd" style="width:55;text-align:center;" class="input2" value="" readonly></td>
						<td width="31">R/D</td>
						<% if( s_ofc_cd.equals("PKGSC") ||  s_ofc_cd.equals("PENSO") ||  s_ofc_cd.equals("PGUSO")) { %>
							<td width="67"><input type="text" name="rd" style="width:33;" class="input2" value="" readonly></td>
							<td width="75">New Print</td>
							<td width=""><input type="checkbox" name="inv_new_rpt" style="width:33;" class="trans" value="" onclick="setRpt();"></td>
						<% } else { %>
							<td width=""><input type="hidden" name="inv_new_rpt" style="width:33;" class="trans" value="" ></td>
							<td width=""><input type="text" name="rd" style="width:33;" class="input2" value="" readonly></td>
						<% }%>
						<td width="">S/C No.</td>
						<td width=""><input type="text" name="sc_no" style="width:95;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">BKG Cust.</td>
						<td width=""><input type="text" name="bkg_cust_cd" style="width:100;" class="input2" value="" readonly>&nbsp;<input type="text" name="bkg_cust_nm" style="width:227;" class="input2" value="" readonly></td>
						<td width="90">RFA No.</td>
						<td width=""><input type="text" name="rfa_no" style="width:95;" class="input2" value="" readonly></td>
					</tr>
					<tr class="h23">
						<td width="70">A/R Cust.</td>
						<td width=""><input type="text" name="act_cust_cd" style="width:100;" class="input2" value="" readonly>&nbsp;<input type="text" name="act_cust_nm" style="width:227;" class="input2" value="" readonly></td>
						<td width="90">TAA No.</td>
						<td width=""><input type="text" name="taa_no" style="width:95;" class="input2" value="" readonly></td>
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
						<td width="191" style="padding-left:2"><script language="javascript">ComComboObject('combo1', 4, 150 , 1, 0, 0, true)</script></td>
						<td width="25">Tel.</td>
						<td width="205"><input type="text" name="payr_cntc_pnt_phn_no" style="width:160;" class="input2" value="" readonly></td>
						<td width="25">Fax</td>
						<td width="180"><input type="text" name="payr_cntc_pnt_fax_no" style="width:160;" class="input2" value="" readonly></td>
						<td width="60">E-mail</td>
						<td width="" class="stm"><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Trucker</td>
						<td width="626"><input type="text" name="trucker_cd" maxlength="6"  style="width:77;" dataformat="engup" class="input" value="" caption="Trucker">&nbsp;<img src="img/btns_search.gif" name="btn_trucker_cd" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand">&nbsp;<input type="text" name="trucker_nm" style="width:403;" class="input2" value="" readOnly></td>
						<td width="62">Due Date</td>
						<td width="85"><input type="text" name="due_date" style="width:80;" class="input2" value="" readonly></td>
						<td width="79"> Credit Term</td>
						<td width="" class="stm"><input type="text" name="cr_term_dys" style="width:30;" class="input2" value="" readonly>&nbsp;day</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="695" rowspan="2">
						<table class="search" border="0" style="width:695;"> 
						<tr class="h23">
							<td width="72" valign="top" name="txt_remark" id="txt_remark">Invoice<br>Remark(s)</td>
							<td width="">
								<table border="0" style="width:606; background-color:white;" class="grid2"> 
								<tr class="h23">
								<td><input type="text" name="inv_rmk1" maxlength="85" style="width:606;" class="noinput" value=""></td><!-- noinput -->
								</tr>
								<tr class="h23">
								<td><input type="text" name="inv_rmk2" maxlength="85" style="width:606;" class="noinput" value=""></td>
								</tr>
								<!-- 
								<tr class="h23">
								<td><input type="text" name="inv_rmk1" maxlength="85" style="width:100%;" class="noinput" value=""></td>
								</tr>
								<tr class="h23">
								<td><input type="text" name="inv_rmk2" maxlength="85" style="width:100%;" class="noinput" value=""></td>
								</tr>
								 -->
								</table>
							</td>
						</tr>
						</table>
					</td>
<!-- 					
						<table class="search" border="0" style="width:695;"> 
						<tr class="h23">
							<td width="69">Invoice<br>Remark(s)</td>
							<td width=""><p><font face="Courier New"><textarea name="inv_rmk" style="width:605;" rows="3"></textarea></font></p></td>
						</tr>
						</table>
 -->					
					<td width="">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="62">Notice</td>
						<td width="80"><select name="ntc_knt_cd" style="width:70;">
						<option value=""></option>
						<option value="1">1st</option>
						<option value="2">2nd</option>
						<option value="3">3rd</option>
						<option value="9">Final</option>
						</select></td>
						<td width="85">INV Over Day</td>
						<td width="" class="stm"><input type="text" name="over_day" style="width:30;" class="input2" value="" readonly>&nbsp;day</td>
					
					</tr>
					<tr class="h23">
						<td width="62">Cust. Ref</td>
						<td width="" colspan="3"><input type="text" name="inv_ref_no" style="width:100%;" maxlength="20" class="input" value=""></td>
					
					</tr>
					</table>
					</td>
				</tr>
				</table>
				<table><tr><td style="height:2"></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="140" valign="top">
						
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Charge</td></tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="80">Charge Cur.</td>
								<td><input type="text" name="chg_curr_cd" style="width:50;text-align:center" class="input2" value="" readonly></td>
							</tr>
						</table>
						
						</td>
						<td width="320" valign="top">
						
						<table class="grid2" border="0" width="320">
							<tr class="h23">
								<td width="150" class="tr2_head">Incurred AMT	</td>
								<td class="input2"><input type="text" name="mn_org_chg_amt" style="width:160;text-align:right" class="noinput2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="150" class="tr2_head">Exception AMT	</td>
								<td class="input2"><input type="text" name="dmdt_expt_amt" style="width:160;text-align:right" class="noinput2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="150" class="tr2_head">Discount AMT	</td>
								<td class="input2"><input type="text" name="chg_dc_amt" style="width:160;text-align:right" class="noinput2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="150" class="tr2_head">Billable AMT	</td>
								<td class="input2"><input type="text" name="mn_bil_amt" style="width:160;text-align:right" class="noinput2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="150" class="tr2_head" id="txt_aft_inv_adj_amt" name="txt_aft_inv_adj_amt">Adjusted AMT after INV	</td>
								<td class="input2"><input type="text" name="aft_inv_adj_amt" style="width:160;text-align:right" class="noinput2" value="" readonly></td>
							</tr>
						</table>					
						</td>
						<td width="19">&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width="180" valign="top">
						
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Invoice</td></tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="70">INV Cur.</td>
								<td><div id="inv_cur"><input type="text" name="inv_curr_cd" style="width:40;text-align:center"  class="input2" value="" readonly></div>
								</td>
								
								<!-- invoice issue 수정 불가 처리
								<td><select name="inv_curr_cd" style="width:80;" class="input1" onchange="getExRate()">&nbsp;
									</select>
								</td>
								 -->
							</tr>
							<tr class="h23">
								<td width="">Ex. Rate</td>
								<td><input type="text" name="inv_xch_rt" style="width:90;text-align:right" class="input2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="">CNTR Q’ty</td>
								<td><input type="text" name="cntr_cnt" style="width:90;text-align:right" class="input2" value="" readonly></td>
							</tr>
						</table>
						
						<table id="ida_tax_bef_tm" class="search" border="0" style="display:none;">
							<tr class="h23">
								<td width="70">SBC AMT</td>
								<td><input type="text" name="ida_locl_tax" style="width:90;text-align:right" class="input2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="70">KKC AMT</td>
								<td><input type="text" name="ida_n2nd_locl_tax" style="width:90;text-align:right" class="input2" value="" readonly></td>
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
								<td class="tr2_head" width="140"> Total AMT</td>
								<td colspan="3" class="input2" align="right"><input type="text" name="tot_amt" style="width:180;text-align:right" class="noinput2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> D/C by AMT or %</td>
								<td colspan="3" class="input2" align="right"><input type="text" name="dc_amt" style="width:180;text-align:right" class="noinput2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> Billing AMT </td>
								<td colspan="3" class="input2" align="right"><input type="text" name="inv_chg_amt" style="width:180;text-align:right" class="noinput2" value="" readonly></td>
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

				<!--  biz_1  (E) -->
				
				<table><tr><td style="height:2"></tr></table>
				
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				

				<!-- Grid  (e) -->
				
			
			
			
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
 <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<% if (!"Y".equals(ctrt_flg)) { %>	 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_set">Sheet Set</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_option">Sheet Option</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<% } %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_sendinghistory">Sending History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_cremark" name="btn_cremark" >C. Remark(s)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_hremark" name="btn_hremark" >H. Remark(s)</td>
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
		    	<% if (!"Y".equals(ctrt_flg)) { %>	 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<% } %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">INV Print</td>
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
				
		    	<% if (!"Y".equals(ctrt_flg)) { %>	 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_payer">Payer  Info.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<% } %>
				
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_arif">A/R I/F</td>
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
		<table class="height_5"><tr><td></td></tr></table>			
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="50" class="popup">
	
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
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>
<table width="100%"  id="mainTable2" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet2');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>	
<!-- RD OBJECT -->		
                    <table width="100%" height="1" id="mainTable"> 
                        <tr>
                            <td width="100%">
<script language='javascript'>comRdObject('invPreview',0,0);</script>
                            </td>
                        </tr>
                    </table>

</form>			
</body>
</html>