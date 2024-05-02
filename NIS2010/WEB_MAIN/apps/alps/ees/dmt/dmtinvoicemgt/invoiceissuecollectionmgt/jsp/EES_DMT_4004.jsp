<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4004.jsp
*@FileTitle : Manual Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.30 이성훈
* 1.0 Creation
* 2011.11.09 권   민 [CHM-201114143] [DMT] Manual Invoice with no detail 조건의 Print Preview 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4004Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_cnt		= "";
	String strCnt_cd		= "";
	String strUsr_eml		= "";
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//Save, Cancel, A/R I/F 버튼 권한 부여
	int i_cnt = 0;
	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt");
	
	String invoiceNo = request.getParameter("dmdt_inv_no")  != null ? (String)request.getParameter("dmdt_inv_no") 	: "" ;
	String caller 	 = request.getParameter("caller") 		!= null ? (String)request.getParameter("caller") 		: "" ;
	
	String bodyTag	 = null;
	String tableTag	 = null;
	
	String ctrt_flg = "";
	
	if (invoiceNo.length() > 0 && caller.length() > 0) {
		//PopUp 화면일 경우
		bodyTag		= "<body class=\"popup_bg\" onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" class=\"popup\" cellpadding=\"5\" border=\"0\">";
	}
	else {
		//Main 화면일 경우
		bodyTag		= "<body onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding-top:2;padding-left:5;\">";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		strUsr_cnt 	= account.getCnt_cd();
		strCnt_cd 	= account.getCnt_cd();
		strUsr_eml 	= account.getUsr_eml();		
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();
		
		//권한부여 체크 추가(2010.04.08)-- 로그인 User의 Role이 DMT01, DMT02, DMT03, DMT04가 아닐 경우
		//							   "You have no authority to XXXX!" alert 창을 띄우며 막음
		/************************************
		if(arrUsrAuth == null){
			sec_invoice = "N";
		}else{
			for(int i = 0; i < arrUsrAuth.length; i++) {
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
		*********************************/
		
		event = (EesDmt4004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		sec_invoice = eventResponse.getETCData("ROLE_AUTH_FLAG"); // 화면별 사용자 Role 권한 Flag 반환

		ctrt_flg = JSPUtil.getParameter(request,"ctrt_flg");
		log.debug("\n[USER_AUTH] = "+ sec_invoice);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Manual Invoice Creation & Issue</title>
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

<%= bodyTag %>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="caller" value="<%= caller %>">
<!-- Charge Cur list 조회 용 -->
<input type="hidden" name="cnt_cd" value="<%= strUsr_cnt %>">
<!-- Invoice Cur list 조회 용 -->
<input type="hidden" name="ofc_cd" value="<%= strUsr_ofc %>">
<!-- Invoice No. 로 조회시 사용하는 매개변수 -->
<input type="hidden" name="dmdt_inv_no">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="mnl_inv_snd_flg">
<input type="hidden" name="cre_ofc_cd">
<!-- CNTR No. 의 정확성을 체크하기 위한 변수 -->
<input type="hidden" name="cntr_no">
<!-- 조회나 체크 후 결과값이나 상태를 저장하기 위한 변수 -->
<input type="hidden" name="result">
<input type="hidden" name="result2">
<!-- 저장시 사용하는 매개변수 -->
<input type="hidden" name="rcv_term_cd">
<input type="hidden" name="de_term_cd">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<!-- INVOICE TAX_RTO -->
<input type="hidden" name="tax_rto">
<input type="hidden" name="inv_tax_rto">
<input type="hidden" name="act_payr_cust_cd">
<input type="hidden" name="act_payr_cnt_cd">
<input type="hidden" name="act_payr_cust_nm2"> <!-- E-mail Send용 Customer Name -->
<input type="hidden" name="act_payr_seq">
<input type="hidden" name="ntc_knt_cd">
<input type="hidden" name="bkg_cntr_qty">
<input type="hidden" name="bil_amt">
<input type="hidden" name="dmdt_mnl_inv_rsn_cd">
<input type="hidden" name="mnl_inv_rmk">
<input type="hidden" name="sc_no">
<input type="hidden" name="rfa_no">
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
<input type="hidden" name="arIfId">
<!-- Calling Port 체크를 위해서 사용하는 매개변수 -->
<input type="hidden" name="vps_port_cd">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="session_ofc_cd" 	value="<%= strUsr_ofc %>">
<input type="hidden" name="session_cnt_cd" 	value="<%= strUsr_cnt %>">
<input type="hidden" name="session_email" 	value="<%= strUsr_eml %>">
<input type="hidden" name="session_usr_nm" 	value="<%= strUsr_nm %>">
<input type="hidden" name="session_usr_id" 	value="<%= strUsr_id %>">

<input type="hidden" name="ctrt_flg" value="<%=ctrt_flg%>">
<!--  기타,공통적으로 사용되는 매개변수 -->
<input type="hidden" name="vndr_cd">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="cre_cnt_cd">
<input type="hidden" name="inv_ref_no">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="dmdt_inv_sts_cd">
<input type="hidden" name="cust_cntc_pnt_seq" >
<input type="hidden" name="dmdt_payr_cntc_pnt_nm">
<input type="hidden" name="dflt_tax_rto"><!-- Sheet Option Tax Ratio -->
<input type="hidden" name="bil_to_loc_div_cd"><!-- 0:left, 1:right, default:left -->
<input type="hidden" name="loc_cd"><!-- Location(POR, POD, POL, DEL) 코드의 유효성 체크를 위해서 사용 -->
<!-- searchCurrentDateByOffice -->
<input type="hidden" name="ofc_curr_date">
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
<input type="hidden" name="rd_fxeml_doc_tp"> 		<!-- I : Invoice D : Demend G : GroupDemand O : OTS //-->
<input type="hidden" name="invno">
<input type="hidden" name="payc">
<!-- 심천 Invoice 인지를 구분해 주는 매개변수 //-->
<input type="hidden" name="suth_chn_iss_flg"> 		
<!-- SHEET SET 이 존재하는지 확인하기 위해서 사용하는 매개변수 -->
<input type="hidden" name="has_sheetset">
<input type="hidden" name="dmdt_sh_tp_cd">  
<!-- RCV TERM, DE TERM, REASON 정보를 조회하기 위해서 사용하는 매개변수 -->
<input type="hidden" name="intg_cd_id">
<!-- Preview Sending Data -->
<input type="hidden" name="org_dmdt_payr_cntc_pnt_nm">
<input type="hidden" name="org_payr_cntc_pnt_phn_no">
<input type="hidden" name="org_payr_cntc_pnt_fax_no">
<input type="hidden" name="org_payr_cntc_pnt_eml">
<input type="hidden" name="org_payer_cd">
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

<input type="hidden" name="usr_cnt_cd"><!--  invoice 전 cnt_cd //2010.04.04.-->
<!-- 날짜의 차이를 구하는 함수에서 사용하는 매개변수 -->
<input type="hidden" name="from_dt">
<input type="hidden" name="to_dt">
<input type="hidden" name="ovr_dys">
<input type="hidden" name="use_rt_curr" value="N">
<!-- RD 구분 -->
<input type="hidden" name="rhq_ofc_cd">

<input type="hidden" name="inv_new_rpt_flg">
<input type="hidden" name="auto_ar_inf_yn">

<input type="hidden" name="col_charge">
<input type="hidden" name="col_tax">
<input type="hidden" name="vt_collected">
<input type="hidden" name="ots_clt_flg">
<input type="hidden" name="col_over_day">

<input type="hidden" name="inv_uncol_amt">
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
<input type="hidden" name="pgm_id" value="4004">
<!-- 인도 TAX 관련 공통함수 구현에 따른 추가 필드 -->
<input type="hidden" name="invoice_issue"> <!-- 1(before), 2(after) -->
<!-- invoice 발행 후 조회 시 등록된 정보로 초기화를 시켜줘야 되기 때문에 계산 로직을 실행하지 않도록 제어해주는 변수 -->
<input type="hidden" name="inv_amt_calc_tp">
<!-- 인도 TAX Calculation 은 Tax Amount 변경에 의해서 실행됨을 알려주는 변수 ( 이 경우는 Tax Amount 를 계산하지 않고 입력된 금액으로 계산이 수행됩니다. ) -->
<input type="hidden" name="calc_by_cng_ida_tax_amt" value="N">
<!-- 인도 TAX RD 출력시 사용할 필드 -->
<input type="hidden" name="ida_bank_acct_no">
<input type="hidden" name="ida_bank_ifsc_cd">


<%= tableTag %>
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<script language="javascript">DmtComPageTitle(<%=(caller.length() > 0 ? "true" : "false")%>);</script>
		</table>
	<!--Page Title, Historical (E)-->	
	
		<table class="search"> 
       	<tr>
       		<td class="bg">
				
				<div id="conditionLayer" style="display:block">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Invoice No. </td>
					<td width="120"><input type="text" name="invoiceNo" style="width:100;ime-mode:disabled" value="<%= invoiceNo %>" class="input2" dataformat="engup" maxlength="9" readOnly></td>
					<td width="150">Issue Date/OFC/Name </td>
					<td width="350"><input type="text" name="issueDate" style="width:80;" class="input2" readOnly>&nbsp;<input type="text" name="issueOfcCd" style="width:50;" class="input2" readOnly>&nbsp;<input type="text" name="issueName" style="width:180;" class="input2" readOnly></td>
					<td width="50">Status</td>
					<td width=""><input type="text" name="status" style="width:75;" class="input2" readOnly></td>
					<td width="100"> &nbsp;ERP Col. Date</td>
					<td width=""><input type="text" name="colDate" style="width:85;" class="input2" readOnly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">A/R I/F</td>
					<td width="120"><input type="text" name="dmdt_ar_if_cd" style="width:100;" class="input2" readOnly></td>
					<td width="150">A/R I/F Date/OFC/Name </td>
					<td width="350"><input type="text" name="arIfDate" style="width:80;" class="input2" readOnly>&nbsp;<input type="text" name="arIfOfc" style="width:50;" class="input2" readOnly>&nbsp;<input type="text" name="arIfName" style="width:180;" class="input2" readOnly></td>
					<td width="70"><span id="creditNoteCaption">Credit Note</span></td>
					<td width=""><input type="text" name="creditNote" style="width:85;" class="input2" readOnly>&nbsp;<input type="text" name="creditNoteArIf" style="width:60;" class="input2" readOnly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">BKG No.</td>
					<td width="120"><input type="text" name="bkgNo" style="width:100;ime-mode:disabled" class="input2"  dataformat="engup" maxlength="13" readOnly></td>
					<td width="50">B/L No.</td>
					<td width="168" class="stm"><input type="text" name="blNo" style="width:100;ime-mode:disabled" class="input2" dataformat="engup" maxlength="12" readOnly></td>
					<td width="70">Tariff Type</td>
					<td width="110">&nbsp;<script language="javascript">ComComboObject('cboTariff', 2, 80, 0, 1)</script></td>
					<td width="105" id="tdInclCNTRDetail">Incl. CNTR Detail</td>
					<td width="67"><select name="incCntrDtail" style="width:50;" class="input2" onChange="changeChargeRate()" disabled>
					<option value="Y" selected>Yes </option>
					<option value="N">No</option>
					</select></td>
					<td>
						<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2_1" name="no_btn_display">Data Display</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
		
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">VVD CD</td>
					<td width="120"><input type="text" name="vvd_cd"  id="vvd_cd" style="width:80;ime-mode:disabled" class="input2" dataformat="engup" maxlength="9" OnKeyUp="checkValidation()" readOnly></td>
					<td width="50">POR</td>
					<td width="75"><input  type="text" name="por_cd" id="por_cd" style="width:50;ime-mode:disabled" class="input2" dataformat="engup" maxlength="5" OnKeyUp="checkValidation()" readOnly></td>
					<td width="25">POL</td>
					<td width="70"><input  type="text" name="pol_cd" id="pol_cd" style="width:50;ime-mode:disabled" class="input2" dataformat="engup" maxlength="5" OnKeyUp="checkValidation()" readOnly></td>
					<td width="25">POD</td>
					<td width="66"><input  type="text" name="pod_cd" id="pod_cd" style="width:50;ime-mode:disabled" class="input2" dataformat="engup" maxlength="5" OnKeyUp="checkValidation()" readOnly></td>
					<td width="25">DEL</td>
					<td width="62"><input  type="text" name="del_cd" id="del_cd" style="width:50;ime-mode:disabled" class="input2" dataformat="engup" maxlength="5" OnKeyUp="checkValidation()" readOnly></td>
					<td width="27">R/D</td>
				
					<% if( strUsr_ofc.equals("PKGSC")||  strUsr_ofc.equals("PENSO") ||  strUsr_ofc.equals("PGUSO")) { %>
						<td width="200"><select name="rcvTermCd" style="width:80;" class="input2" disabled></select>
						&nbsp;/&nbsp;<select name="deTermCd"  style="width:80;" class="input2" disabled></select></td>
						<td width="60">New Print</td>
						<td width=""><input type="checkbox" name="inv_new_rpt" style="width:33;" class="trans" value="" onclick="setRpt();"></td>
					<% } else { %>
						<td width=""><input type="hidden" name="inv_new_rpt" style="width:33;" class="trans" value="" ></td>
						<td width=""><select name="rcvTermCd" style="width:80;" class="input2" disabled></select>
						&nbsp;/&nbsp;<select name="deTermCd"  style="width:80;" class="input2" disabled></select></td>
					<% }%>
					
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">BKG Cust.</td>
					<td width=""><input type="text" name="bkg_cust_cd" style="width:100;" class="input2" readOnly>&nbsp;<input type="text" name="bkg_cust_nm" style="width:403;" class="input2" readOnly></td>
				</tr>
				<tr class="h23">
					<td width="70">A/R Cust.</td>
					<td width=""><input type="text" name="act_cust_cd" style="width:100;" class="input2" readOnly>&nbsp;<input type="text" name="act_cust_nm" style="width:403;" class="input2" readOnly></td>
				</tr>
				</table>

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Payer</td>
					<td width=""><input type="text" name="payer_cd" style="width:77;ime-mode:disabled" dataformat="engup" class="input2" caption="Payer" maxlength="8" onKeyPress="ComKeyOnlyAlphabet('uppernum')" readOnly>&nbsp;<img src="img/btns_search.gif" name="btn_payer_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="payer_nm" style="width:403;" class="input2" readOnly></td>
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
					<td width="191" style="padding-left:2"><script language="javascript">ComComboObject('cboAttention', 4, 152 , 1, 0, 0, true)</script></td>
					<td width="25">Tel.</td>
					<td width="205"><input type="text" name="payr_cntc_pnt_phn_no" style="width:160;" class="input2" readOnly></td>
					<td width="25">Fax</td>
					<td width="178"><input type="text" name="payr_cntc_pnt_fax_no" style="width:157;" class="input2" readOnly></td>
					<td width="61">E-mail</td>
					<td width="" class="stm"><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" readOnly></td>
				</tr>
				</table>
		
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Trucker</td>
					<td width="625"><input type="text" name="trucker_cd" style="width:77;" dataformat="int" class="input2" maxlength="6" readOnly>&nbsp;<img src="img/btns_search.gif" name="btn_trucker_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="trucker_nm" style="width:403;" class="input2" readOnly></td>
					<td width="62">Due Date</td>
					<td width="85"><input type="text" name="dueDate" style="width:80;" class="input2" readOnly></td>
					<td width="79"> Credit Term</td>
					<td width="" class="stm"><input type="text" name="creditTerm" style="width:30;" class="input2" readOnly>&nbsp;day</td>
				</tr>
				</table>
						
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="695" rowspan="2">
						<table class="search" border="0" style="width:695;"> 
						<tr class="h23">
							<td width="72" valign="top" name="txt_Remark" id="txt_Remark">Invoice<br>Remark(s)</td>
							<td width="">
								<table border="0" style="width:606; background-color:white;" class="grid2"> 
								<tr class="h23">
									<td><input type="text" name="inv_rmk1" style="width:100%;" class="input2" maxlength="85" readOnly></td>
								</tr>
								<tr class="h23">
									<td><input type="text" name="inv_rmk2" style="width:100%;" class="input2" maxlength="85" readOnly></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
					<td width="">
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="62">Notice</td>
							<td width="80"><select name="notice" style="width:70;" class="input2" disabled>
							<option value=""></option>
							<option value="1">1st</option>
							<option value="2">2nd</option>
							<option value="3">3rd</option>
							<option value="9">Final</option>
							</select></td>
							<td width="84">INV Over Day</td>
							<td width="" class="stm"><input type="text" name="invoiceOverDay" style="width:30;" class="input2" readOnly>&nbsp;day</td>
						</tr>
						<tr class="h23">
							<td width="62">Cust. Ref</td>
							<td width="" colspan="3"><input type="text" name="custRef" style="width:100%;" class="input2" maxlength="20" readOnly></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				</div>
				
				<table class="height_2"><tr><td></td></tr></table>
		
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="520" valign="top">
						<table class="search" border="0">
						<tr class="h23">
							<td class="title_h"></td>
							<td class="title_s" width="120">Charge</td>
							<td width="150">Charge Cur.&nbsp;<select name="chg_curr_cd" style="width:70;" class="input2" onChange="changeChargeCurrency()" readOnly></select></td>
							<td align="right">
								<table class="grid2" border="0" width="240" >
								<tr>
									<td width="80" class="tr2_head">Billable AMT</td>
									<td class="noinput2"><input type="text" name="mn_bil_amt" style="width:100%;text-align:right"" class="noinput2" readOnly></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
		
						<!-- Grid  (S) -->
						<table class="height_2"><tr><td></td></tr></table>
						
						<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
						</tr>
						</table>
						<!-- Grid  (e) -->
						
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
			       		<tr>
			       			<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2_1" name="no_btn_AddCharge">Row&nbsp;Add</td>
											<td class="btn2_right"></td>
										</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2_1" name="no_btn_CopyCharge">Row&nbsp;Copy</td>
											<td class="btn2_right"></td>
										</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2_1" name="no_btn_DelCharge">Row&nbsp;Delete</td>
											<td class="btn2_right"></td>
										</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2_1" name="no_btn_InqMVMT">MVMT Inq.</td>
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
			    				
						<table style="height:5;"><tr><td></td></tr></table>			
								
					</td>
					<td width="20">&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td width="180" valign="top">
					
						<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">Invoice</td>
						</tr>
						</table>
						
						<table class="search" border="0">
						<tr class="h23">
							<td width="70">INV Cur.</td>
							<td><select name="inv_curr_cd" style="width:50;" class="input2" onChange="changeChargeCurrency()" ></td>
						</tr>
						<tr class="h23">
							<td width="70">Ex. Rate</td>
							<td><input type="text" name="inv_xch_rt" style="width:90;text-align:right" class="input2" readOnly></td>
						</tr>
						<tr class="h23">
							<td width="70">CNTR Q’ty</td>
							<td><input type="text" name="cntrQty" style="width:90;text-align:right" class="input2" readOnly></td>
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
		
					<td width="280" valign="top">
						<table class="grid2" border="0" width="280">
						<tr class="h23">
							<td class="tr2_head" width="120"> Total AMT</td>
							<td colspan="3" class="input2" align="right"><input type="text" name="tot_amt" style="width:150;text-align:right" class="noinput2" dataformat="float" size="16" pointcut="2" maxlength="18" readOnly></td>
						</tr>
						<tr class="h23">
							<td class="tr2_head"> D/C by AMT or %</td>
							<td colspan="3" class="input2" align="right"><input type="text" name="dc_amt" style="width:150;text-align:right" class="noinput2" dataformat="float2" size="16" pointcut="2" maxlength="18" readOnly></td>
						</tr>
						<tr class="h23">
							<td class="tr2_head"> Billing AMT </td>
							<td colspan="3" class="input2" align="right"><input type="text" name="inv_chg_amt" style="width:150;text-align:right" class="noinput2" dataformat="float" size="16" pointcut="2" maxlength="18" readOnly></td>
						</tr>
						<tr class="h23">
							<td class="tr2_head"> Tax Rate/ AMT </td>
							<td class="input2"><input type="checkbox" name="chk_tax" class="trans" onClick="DmtComApplTaxRto()">&nbsp;<input type="text" name="tax_rto_dis" style="width:30;text-align:right" class="noinput2" readOnly>&nbsp;% </td>
							<td colspan="2" class="input2" align="right"><input type="text" name="tax_amt" style="width:70;text-align:right" class="noinput2"></td>
						</tr>
						<tr class="h23">
							<td class="tr2_head"> Payable AMT </td>
							<td colspan="3" class="input2" align="right"><input type="text" name="inv_amt" style="width:150;text-align:right" class="noinput2" readOnly></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
						
				<!--  biz_1  (E) -->
				<table class="height_2"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="520" valign="top">
						<table class="search" border="0">
						<tr class="h23">
							<td class="title_h"></td>
							<td class="title_s"  width="">Rate Detail</td>
						</tr>
						</table>
		
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
						</tr>
						</table>
							
						<!-- Grid  (e) -->
						<table style="height:5;"><tr><td></td></tr></table>			
					</td>
		
					<td width="20">&nbsp;&nbsp;&nbsp;&nbsp;</td>
								
					<td width="" valign="top">
						<table class="search" border="0">
						<tr class="h23">
							<td class="title_h"></td>
							<td class="title_s">Manual Invoice Reason</td>
						</tr>
						</table>
						<table class="grid2" border="0" width="100%">
						<tr class="h23">
							<td class="tr2_head" width="100"> Reason</td>
							<td class="input1"><select name="reason" style="width:99%;" class="input2" disabled></select></td>
						</tr>
						<tr class="h23">
							<td class="tr2_head">Remark(s)</td>
							<td><textarea name="remark" style="width:100%;height:55" class="textarea2" disabled></textarea></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_1  (E) -->
			</td>
		</tr>
		</table>
		<!-- : ( Search Options ) (E) -->
		
		<!-- Tab BG Box  (S) -->
		<!--biz page (E)-->
		<!--Button (S) -->
		<!-- : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:2;"> 
		<tr>
			<td class="btn1_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
		    	<% if (!"Y".equals(ctrt_flg)) { %>	 
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_set">Sheet Set</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_option">Sheet Option</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				<% } %>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_sendinghistory">Sending History</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_cremark" id="btn_cremark">C. Remark</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_hremark" id="btn_hremark">H. Remark</td>
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
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:5;"> 
		<tr>
			<td class="btn1_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Minimize">Minimize</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
		    	<% if (!"Y".equals(ctrt_flg)) { %>	 
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_cancel">Cancel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				<% } %>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_preview">Preview</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_print">INV Print</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_fax">Fax Send</a></td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_email">E-mail Send</a></td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					
		    	<% if (!"Y".equals(ctrt_flg)) { %>	 
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_payer">Payer Info</a></td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				<% } %>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_arif">A/R I/F</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<div id="btnCloseLayer" style="display:none">
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
			</tr>
		</table>

	</td></tr>
	</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>
<!--Button (E) -->
<table width="100%"  id="mainTable2" style=display:none;> 
<tr>
	<td width="100%">
	<!-- hidden 처리 (S)--> 
	<script language="javascript">ComSheetObject('sheet3');</script>
	<!-- hidden 처리 (E)-->
	</td>
</tr>
</table>
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
<!-- RD OBJECT -->		
<table width="100%" height="1" id="mainTable"> 
<tr>
	<td width="100%"><script language='javascript'>comRdObject('invPreview',0,0);</script></td>
</tr>
</table>
</form>
</body>
</html>
