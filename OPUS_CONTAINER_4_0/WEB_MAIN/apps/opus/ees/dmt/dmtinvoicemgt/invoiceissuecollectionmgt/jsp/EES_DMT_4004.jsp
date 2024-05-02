<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_4004.jsp
*@FileTitle  : Manual Invoice Creation & Issue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4004Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
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
	String sec_invoice	= "Y";	//Save, Cancel, A/R I/F Button authorization
	int i_cnt = 0;
	
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt");
	
	String invoiceNo = request.getParameter("dmdt_inv_no")  != null ? (String)request.getParameter("dmdt_inv_no") 	: "" ;
	String caller 	 = request.getParameter("caller") 		!= null ? (String)request.getParameter("caller") 		: "" ;
	String main_page  = request.getParameter("main_page") 	!= null ? (String)request.getParameter("main_page")		: "" ;
	
	String bodyTag	 = null;
	String tableTag	 = null;
	
	if (invoiceNo.length() > 0 && caller.length() > 0) {
		//in case of PopUp 
		bodyTag		= "<body class=\"popup_bg\" onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" class=\"popup\" cellpadding=\"5\" border=\"0\">";
	}
	else {
		//in case of Main
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
		
		//Additional authorization check(2010.04.08)-- if Role of login User is not DMT01, DMT02, DMT03, DMT04
		//							   "You have no authority to XXXX!" showing an alert window preventing
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
		
		event = (EesDmt4004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<%= bodyTag %>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="caller" value="<%= caller %>" id="caller" />
<!-- Charge Cur list retrieving -->
<input type="hidden" name="cnt_cd" value="<%= strUsr_cnt %>" id="cnt_cd" />
<!-- Invoice Cur list retrieving -->
<input type="hidden" name="ofc_cd" value="<%= strUsr_ofc %>" id="ofc_cd" />
<!-- Invoice No. when viewed with the parameters used -->
<input type="hidden" name="dmdt_inv_no" id="dmdt_inv_no" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="bl_no" id="bl_no" />
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" />
<input type="hidden" name="mnl_inv_snd_flg" id="mnl_inv_snd_flg" />
<input type="hidden" name="cre_ofc_cd" id="cre_ofc_cd" />
<!-- CNTR No. For checking the accuracy of the variable -->
<input type="hidden" name="cntr_no" id="cntr_no" />
<!-- After checking query or a variable to store the result or status -->
<input type="hidden" name="result" id="result" />
<input type="hidden" name="result2" id="result2" />
<!-- parameters used when saving -->
<input type="hidden" name="vvd_cd" id="vvd_cd" />
<input type="hidden" name="por_cd" id="por_cd" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<input type="hidden" name="del_cd" id="del_cd" />
<input type="hidden" name="rcv_term_cd" id="rcv_term_cd" />
<input type="hidden" name="de_term_cd" id="de_term_cd" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="act_payr_cust_cd" id="act_payr_cust_cd" />
<input type="hidden" name="act_payr_cnt_cd" id="act_payr_cnt_cd" />
<input type="hidden" name="act_payr_seq" id="act_payr_seq" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="ntc_knt_cd" id="ntc_knt_cd" />
<input type="hidden" name="chg_curr_cd" id="chg_curr_cd" />
<input type="hidden" name="inv_curr_cd" id="inv_curr_cd" />
<input type="hidden" name="inv_xch_rt" id="inv_xch_rt" />
<input type="hidden" name="bkg_cntr_qty" id="bkg_cntr_qty" />
<input type="hidden" name="inv_chg_amt" id="inv_chg_amt" />
<input type="hidden" name="tax_rto" id="tax_rto" />
<input type="hidden" name="tax_amt" id="tax_amt" />
<input type="hidden" name="inv_amt" id="inv_amt" />
<input type="hidden" name="inv_rmk1" id="inv_rmk1" />
<input type="hidden" name="inv_rmk2" id="inv_rmk2" />
<input type="hidden" name="bil_amt" id="bil_amt" />
<input type="hidden" name="dmdt_mnl_inv_rsn_cd" id="dmdt_mnl_inv_rsn_cd" />
<input type="hidden" name="mnl_inv_rmk" id="mnl_inv_rmk" />
<input type="hidden" name="sc_no" id="sc_no" />
<input type="hidden" name="rfa_no" id="rfa_no" />
<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>" id="sec_invoice" />
<!-- C.REMARK, H.REMARK -->
<input type="hidden" name="dmdt_cxl_rsn_cd" id="dmdt_cxl_rsn_cd" />
<input type="hidden" name="dmdt_cxl_rsn_nm" id="dmdt_cxl_rsn_nm" />
<input type="hidden" name="cxl_rmk" id="cxl_rmk" />
<input type="hidden" name="inv_hld_rsn_cd" id="inv_hld_rsn_cd" />
<input type="hidden" name="inv_hld_rsn_nm" id="inv_hld_rsn_nm" />
<input type="hidden" name="inv_hld_rmk" id="inv_hld_rmk" />
<input type="hidden" name="upd_dt" id="upd_dt" />
<input type="hidden" name="upd_ofc_cd" id="upd_ofc_cd" />
<input type="hidden" name="upd_usr_id" id="upd_usr_id" />
<input type="hidden" name="upd_usr_nm" id="upd_usr_nm" />
<input type="hidden" name="arIfId" id="arIfId" />
<!-- Calling Port To check the parameters used -->
<input type="hidden" name="vps_port_cd" id="vps_port_cd" />
<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
<input type="hidden" name="session_ofc_cd" value="<%= strUsr_ofc %>" id="session_ofc_cd" />
<input type="hidden" name="session_cnt_cd" value="<%= strUsr_cnt %>" id="session_cnt_cd" />
<input type="hidden" name="session_email" value="<%= strUsr_eml %>" id="session_email" />
<input type="hidden" name="session_usr_nm" value="<%= strUsr_nm %>" id="session_usr_nm" />
<input type="hidden" name="session_usr_id" value="<%= strUsr_id %>" id="session_usr_id" />
<!--  Other, commonly used parameters -->
<input type="hidden" name="payer_cd" id="payer_cd" />
<input type="hidden" name="vndr_cd" id="vndr_cd" />
<input type="hidden" name="s_cust_cd" id="s_cust_cd" />
<input type="hidden" name="cre_cnt_cd" id="cre_cnt_cd" />
<input type="hidden" name="inv_ref_no" id="inv_ref_no" />
<input type="hidden" name="s_cust_gubun" id="s_cust_gubun" />
<input type="hidden" name="dmdt_inv_sts_cd" id="dmdt_inv_sts_cd" />
<input type="hidden" name="cust_cntc_pnt_seq" id="cust_cntc_pnt_seq" />
<input type="hidden" name="dmdt_payr_cntc_pnt_nm" id="dmdt_payr_cntc_pnt_nm" />
<input type="hidden" name="dflt_tax_rto" id="dflt_tax_rto" />
<input type="hidden" name="bil_to_loc_div_cd" id="bil_to_loc_div_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<!-- searchCurrentDateByOffice -->
<input type="hidden" name="ofc_curr_date" id="ofc_curr_date" />
<!-- PAYER INFO FAX,EMAIL SETTING -->
<input type="hidden" name="payr_faxnos" id="payr_faxnos" />
<input type="hidden" name="payr_emailnos" id="payr_emailnos" />
<!-- EMAIL, FAX SENDING -->
<input type="hidden" name="rd_fxeml_sys_cd" id="rd_fxeml_sys_cd" />
<input type="hidden" name="rd_fxeml_file_name" id="rd_fxeml_file_name" />
<input type="hidden" name="rd_fxeml_bat_flg" id="rd_fxeml_bat_flg" />
<input type="hidden" name="rd_fxeml_title" id="rd_fxeml_title" />
<input type="hidden" name="rd_fxeml_rd_param" id="rd_fxeml_rd_param" />
<input type="hidden" name="rd_fxeml_fax_no" id="rd_fxeml_fax_no" />
<input type="hidden" name="rd_fxeml_fax_sndr_id" id="rd_fxeml_fax_sndr_id" />
<input type="hidden" name="rd_fxeml_eml_sndr_nm" id="rd_fxeml_eml_sndr_nm" />
<input type="hidden" name="rd_fxeml_eml_sndr_add" id="rd_fxeml_eml_sndr_add" />
<input type="hidden" name="rd_fxeml_eml_sndr_fixed" id="rd_fxeml_eml_sndr_fixed" />
<input type="hidden" name="rd_fxeml_eml_rcvr_add" id="rd_fxeml_eml_rcvr_add" />
<input type="hidden" name="rd_fxeml_eml_atch_file" id="rd_fxeml_eml_atch_file" />
<input type="hidden" name="rd_fxeml_eml_templt" id="rd_fxeml_eml_templt" />
<input type="hidden" name="rd_fxeml_eml_tmplt_param" id="rd_fxeml_eml_tmplt_param" />
<input type="hidden" name="rd_fxeml_doc_tp" id="rd_fxeml_doc_tp" />
<input type="hidden" name="invno" id="invno" />
<input type="hidden" name="payc" id="payc" />
<!-- Parameters that distinguish Simcheon Invoice//-->
<input type="hidden" name="suth_chn_iss_flg" id="suth_chn_iss_flg" />
<!-- SHEET SET In order to verify that all the parameters used -->
<input type="hidden" name="has_sheetset" id="has_sheetset" />
<input type="hidden" name="dmdt_sh_tp_cd" id="dmdt_sh_tp_cd" />
<!-- RCV TERM, DE TERM, REASON Which is used to retrieve information parameters -->
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<!-- Preview Sending Data -->
<input type="hidden" name="org_dmdt_payr_cntc_pnt_nm" id="org_dmdt_payr_cntc_pnt_nm" />
<input type="hidden" name="org_payr_cntc_pnt_phn_no" id="org_payr_cntc_pnt_phn_no" />
<input type="hidden" name="org_payr_cntc_pnt_fax_no" id="org_payr_cntc_pnt_fax_no" />
<input type="hidden" name="org_payr_cntc_pnt_eml" id="org_payr_cntc_pnt_eml" />
<input type="hidden" name="org_payer_cd" id="org_payer_cd" />
<!-- Master RD -->
<input type="hidden" name="rd_sh_addr1" id="rd_sh_addr1" />
<input type="hidden" name="rd_sh_addr2" id="rd_sh_addr2" />
<input type="hidden" name="rd_sh_addr3" id="rd_sh_addr3" />
<input type="hidden" name="rd_invoice_title" id="rd_invoice_title" />
<input type="hidden" name="rd_cancel_note" id="rd_cancel_note" />
<input type="hidden" name="rd_cust_nm" id="rd_cust_nm" />
<input type="hidden" name="rd_payr_addr" id="rd_payr_addr" />
<input type="hidden" name="rd_attn_nm" id="rd_attn_nm" />
<input type="hidden" name="rd_phn_no" id="rd_phn_no" />
<input type="hidden" name="rd_fax_no" id="rd_fax_no" />
<input type="hidden" name="rd_dmdt_inv_no" id="rd_dmdt_inv_no" />
<input type="hidden" name="rd_issue_day" id="rd_issue_day" />
<input type="hidden" name="rd_due_date" id="rd_due_date" />
<input type="hidden" name="rd_due_day" id="rd_due_day" />
<input type="hidden" name="rd_ntc_knt_cd" id="rd_ntc_knt_cd" />
<input type="hidden" name="rd_cre_usr_nm" id="rd_cre_usr_nm" />
<input type="hidden" name="rd_cust_cd" id="rd_cust_cd" />
<input type="hidden" name="rd_inv_ref_no" id="rd_inv_ref_no" />
<input type="hidden" name="rd_cust_vat_no" id="rd_cust_vat_no" />
<input type="hidden" name="rd_sh_hd_n1st_msg" id="rd_sh_hd_n1st_msg" />
<input type="hidden" name="rd_sh_hd_n2nd_msg" id="rd_sh_hd_n2nd_msg" />
<input type="hidden" name="rd_sh_hd_n3rd_msg" id="rd_sh_hd_n3rd_msg" />
<input type="hidden" name="rd_sh_hd_n4th_msg" id="rd_sh_hd_n4th_msg" />
<input type="hidden" name="rd_sh_hd_n5th_msg" id="rd_sh_hd_n5th_msg" />
<input type="hidden" name="rd_vvd_cd" id="rd_vvd_cd" />
<input type="hidden" name="rd_vsl_eng_nm" id="rd_vsl_eng_nm" />
<input type="hidden" name="rd_arr" id="rd_arr" />
<input type="hidden" name="rd_dep" id="rd_dep" />
<input type="hidden" name="rd_bl_no" id="rd_bl_no" />
<input type="hidden" name="rd_bkg_no" id="rd_bkg_no" />
<input type="hidden" name="rd_cmdt_nm" id="rd_cmdt_nm" />
<input type="hidden" name="rd_dmdt_trf_cd" id="rd_dmdt_trf_cd" />
<input type="hidden" name="rd_dmdt_trf_nm" id="rd_dmdt_trf_nm" />
<input type="hidden" name="rd_bkg_rcv_term_nm" id="rd_bkg_rcv_term_nm" />
<input type="hidden" name="rd_bkg_del_term_nm" id="rd_bkg_del_term_nm" />
<input type="hidden" name="rd_pod" id="rd_pod" />
<input type="hidden" name="rd_pod_nm" id="rd_pod_nm" />
<input type="hidden" name="rd_del" id="rd_del" />
<input type="hidden" name="rd_del_nm" id="rd_del_nm" />
<input type="hidden" name="rd_trucker_nm" id="rd_trucker_nm" />
<input type="hidden" name="rd_org_chg_amt" id="rd_org_chg_amt" />
<input type="hidden" name="rd_org_curr_cd" id="rd_org_curr_cd" />
<input type="hidden" name="rd_inv_xch_rt" id="rd_inv_xch_rt" />
<input type="hidden" name="rd_tot_amt" id="rd_tot_amt" />
<input type="hidden" name="rd_inv_curr_cd" id="rd_inv_curr_cd" />
<input type="hidden" name="rd_dc_amt" id="rd_dc_amt" />
<input type="hidden" name="rd_inv_chg_amt" id="rd_inv_chg_amt" />
<input type="hidden" name="rd_tax_rto" id="rd_tax_rto" />
<input type="hidden" name="rd_tax_amt" id="rd_tax_amt" />
<input type="hidden" name="rd_inv_amt" id="rd_inv_amt" />
<input type="hidden" name="rd_inv_rmk1" id="rd_inv_rmk1" />
<input type="hidden" name="rd_inv_rmk2" id="rd_inv_rmk2" />
<input type="hidden" name="rd_sh_rmk1" id="rd_sh_rmk1" />
<input type="hidden" name="rd_sh_rmk2" id="rd_sh_rmk2" />
<input type="hidden" name="rd_sh_rmk3" id="rd_sh_rmk3" />
<input type="hidden" name="rd_sh_rmk4" id="rd_sh_rmk4" />
<input type="hidden" name="rd_sh_rmk5" id="rd_sh_rmk5" />
<input type="hidden" name="rd_sh_rmk6" id="rd_sh_rmk6" />
<input type="hidden" name="rd_sh_rmk7" id="rd_sh_rmk7" />
<input type="hidden" name="rd_sh_rmk8" id="rd_sh_rmk8" />
<input type="hidden" name="rd_sh_rmk9" id="rd_sh_rmk9" />
<input type="hidden" name="rd_sh_rmk10" id="rd_sh_rmk10" />
<input type="hidden" name="rd_sh_rmk11" id="rd_sh_rmk11" />
<input type="hidden" name="rd_sh_rmk12" id="rd_sh_rmk12" />
<input type="hidden" name="rd_sh_rmk13" id="rd_sh_rmk13" />
<input type="hidden" name="rd_sh_rmk14" id="rd_sh_rmk14" />
<input type="hidden" name="rd_tax_amt_prn_flg" id="rd_tax_amt_prn_flg" />
<input type="hidden" name="rd_phn_fax_prn_flg" id="rd_phn_fax_prn_flg" />
<input type="hidden" name="rd_cust_vat_prn_flg" id="rd_cust_vat_prn_flg" />
<input type="hidden" name="rd_dc_amt_flg" id="rd_dc_amt_flg" />
<input type="hidden" name="rd_cust_ref_prn_flg" id="rd_cust_ref_prn_flg" />
<input type="hidden" name="rd_days_disp" id="rd_days_disp" />
<input type="hidden" name="rd_dmdt_inv_sts_cd" id="rd_dmdt_inv_sts_cd" />
<input type="hidden" name="rd_cre_cnt_cd" id="rd_cre_cnt_cd" />
<!-- india tax-->
<input type="hidden" name="rd_ida_expn_tax_rt" id="rd_ida_expn_tax_rt">
<input type="hidden" name="rd_ida_expn_tax" id="rd_ida_expn_tax">
<input type="hidden" name="rd_ida_edu_tax_rt" id="rd_ida_edu_tax_rt">
<input type="hidden" name="rd_ida_edu_tax" id="rd_ida_edu_tax">
<input type="hidden" name="rd_ida_high_edu_tax_rt" id="rd_ida_high_edu_tax_rt">
<input type="hidden" name="rd_ida_high_edu_tax" id="rd_ida_high_edu_tax">
<input type="hidden" name="rd_tax_rgst_no" id="rd_tax_rgst_no">
<input type="hidden" name="rd_svc_cate_rmk" id="rd_svc_cate_rmk">
<input type="hidden" name="rd_pmnt_acct_no" id="rd_pmnt_acct_no">

<input type="hidden" name="usr_cnt_cd" id="usr_cnt_cd" />
<!-- Date of the differences in the function parameters that are used to obtain -->
<input type="hidden" name="from_dt" id="from_dt" />
<input type="hidden" name="to_dt" id="to_dt" />
<input type="hidden" name="ovr_dys" id="ovr_dys" />
<input type="hidden" name="use_rt_curr" value="N" id="use_rt_curr" />
<!-- RD division -->
<input type="hidden" name="rhq_ofc_cd" id="rhq_ofc_cd">

<!-- India tax -->
<input type="hidden" name="ida_expn_tax_rt" id="ida_expn_tax_rt">
<input type="hidden" name="ida_expn_tax" id="ida_expn_tax">
<input type="hidden" name="ida_edu_tax_rt" id="ida_edu_tax_rt">
<input type="hidden" name="ida_edu_tax" id="ida_edu_tax">
<input type="hidden" name="ida_high_edu_tax_rt" id="ida_high_edu_tax_rt">
<input type="hidden" name="ida_high_edu_tax" id="ida_high_edu_tax">

<!-- Check Payer & RepCust -->
<input type="hidden" name="rep_cust_seq" id="rep_cust_seq">

<%if (!"true".equals(main_page)){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Manual Invoice Creation & Issue</span></h2>
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_SheetSet" 	id="btn_SheetSet">Sheet Set</button><!--  
			--><button type="button" class="btn_normal" name="btn_SheetOption"  		id="btn_SheetOption">Sheet Option</button><!--  
			--><button type="button" class="btn_normal" name="btn_SendingHistory" 		id="btn_SendingHistory">Sending History</button><!--  
			--><button type="button" class="btn_normal" name="btn_CRemark" 	id="btn_CRemark" onmouseover="" onmouseout="obj_mouseout()">C. Remark</button><!--  
			<button type="button" class="btn_normal" name="btn_HRemark" 		id="btn_HRemark" onmouseover="" onmouseout="obj_mouseout()">H. Remark</button> 
			--><button type="button" class="btn_accent" name="btn_New" 	id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_Minimize"  		id="btn_Minimize">Minimize</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Cancel" 	id="btn_Cancel">Cancel</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Preview" 		id="btn_Preview">Preview</button><!-- 
			--><button type="button" class="btn_normal" name="btn_InvPrint" 		id="btn_InvPrint">INV Print</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Fax" 		id="btn_Fax">Fax Send</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Email" 		id="btn_Email">E-mail Send</button><!-- 
			--><button type="button" class="btn_normal" name="btn_PayerInfo" 		id="btn_PayerInfo">Payer Info</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Arif" 		id="btn_Arif">A/R I/F</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<%}else {%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_SheetSet" 	id="btn_SheetSet">Sheet Set</button><!--  
		--><button type="button" class="btn_normal" name="btn_SheetOption"  		id="btn_SheetOption">Sheet Option</button><!--  
		--><button type="button" class="btn_normal" name="btn_SendingHistory" 		id="btn_SendingHistory">Sending History</button><!--  
		--><button type="button" class="btn_normal" name="btn_CRemark" 	id="btn_CRemark" onmouseover="" onmouseout="obj_mouseout()">C. Remark</button><!--  
		<button type="button" class="btn_normal" name="btn_HRemark" 		id="btn_HRemark" onmouseover="" onmouseout="obj_mouseout()">H. Remark</button>
		--><button type="button" class="btn_accent" name="btn_New" 	id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Minimize"  		id="btn_Minimize">Minimize</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_Cancel" 	id="btn_Cancel">Cancel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Preview" 		id="btn_Preview">Preview</button><!-- 
		--><button type="button" class="btn_normal" name="btn_InvPrint" 		id="btn_InvPrint">INV Print</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Fax" 		id="btn_Fax">Fax Send</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Email" 		id="btn_Email">E-mail Send</button><!-- 
		--><button type="button" class="btn_normal" name="btn_PayerInfo" 		id="btn_PayerInfo">Payer Info</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Arif" 		id="btn_Arif">A/R I/F</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<%} %>

<%if (!"true".equals(main_page)){%>
<div class="layer_popup_contents">
<%} %>
<!-- page_title_area(E) -->

<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit" id="conditionLayer" style="display:block; ">
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="110">
				<col width="138">
				<col width="340">
				<col width="90">
				<col width="*">
		    </colgroup>
			<tr>
				<th>Invoice No.</th>
				<td><input type="text" name="invoiceNo" id="invoiceNo" style="width:100px;ime-mode:disabled" value="<%= invoiceNo %>" class="input2" dataformat="engup" maxlength="9" readOnly></td>
				<th>Issue Date/OFC/Name</th>
				<td><input type="text" name="issueDate" id="issueDate" style="width:80px;" class="input2" readOnly><!--
					--><input type="text" name="issueOfcCd" id="issueOfcCd" style="width:52px;" class="input2" readOnly><!--
					--><input type="text" name="issueName" id="issueName" style="width:180px;" class="input2" readOnly></td>
				<th>Status</th>
				<td><input type="text" name="status" id="status" style="width:85px;" class="input2" readOnly></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="111">
				<col width="132">
				<col width="340">
				<col width="90">
				<col width="*">
		    </colgroup>
			<tr>
				<th>A/R I/F</th>
				<td><input type="text" name="arIf" id="arIf" style="width:100px;" class="input2" readOnly></td>
				<th>A/R I/F Date/OFC/Name </th>
				<td><input type="text" name="arIfDate" id="arIfDate" style="width:80px;" class="input2" readOnly><!-- 
					 --><input type="text" name="arIfOfc" id="arIfOfc" style="width:52px;" class="input2" readOnly><!-- 
					 --><input type="text" name="arIfName" id="arIfName" style="width:180px;" class="input2" readOnly></td>
				<th><span id="creditNoteCaption">Credit Note</span></th>
				<td><input type="text" name="creditNote" id="creditNote" style="width:85px;" class="input2" readOnly><!-- 
					 --><input type="text" name="creditNoteArIf" id="creditNoteArIf" style="width:60px;" class="input2" readOnly></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="110">
				<col width="50">
				<col width="130">
				<col width="85">
				<col width="90">
				<col width="120">
				<col width="*">
		    </colgroup>
			<tr>
				<th>BKG No.</th>
				<td><input type="text" name="bkgNo" id="bkgNo" style="width:100px;ime-mode:disabled" class="input2"  dataformat="engup" maxlength="13" readOnly onchange="obj_change()"></td>
				<th>B/L No.</th>
				<td><input type="text" name="blNo" id="blNo" style="width:100px;ime-mode:disabled" class="input2" dataformat="engup" maxlength="12" readOnly onchange="obj_change()"></td>
				<th>Tariff Type</th>
				<td><script type="text/javascript">ComComboObject('cboTariff', 2, 80, 0, 1)</script></td>
				<th id="tdInclCNTRDetail" onmouseover="" onmouseout="obj_mouseout()" >Incl. CNTR Detail</th>
				<td>
					<select name="incCntrDtail" id="incCntrDtail" style="width:55px;" class="input2" onChange="changeChargeRate()" disabled>
						<option value="Y" selected>Yes </option>
						<option value="N">No</option>
					</select><!-- 
				 --><button type="button" class="btn_etc" name="btn_DataDisplay" id="btn_DataDisplay" onmouseover="" onmouseout="obj_mouseout()">Data Display</button>
					<div id="topdeck" style="position:absolute;visibility:hidden;BGCOLOR=#000000;z-index:200;"></div>
				</td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="70">   
				<col width="110">
				<col width="50">
				<col width="55">
				<col width="36">
				<col width="55">
				<col width="40">
				<col width="55">
				<col width="42">
				<col width="60">
				<col width="50">
				<col width="*">
		    </colgroup>
			<tr>
				<th>VVD CD</th>
				<td><input type="text" name="vvdCd" id="vvdCd" style="width:80px;ime-mode:disabled" class="input2" dataformat="engup" maxlength="9" OnKeyUp="checkValidation()" readOnly onchange="obj_change()"></td>
				<th title="Place of Receipt">POR</th>
				<td><input  type="text" name="porCd" id="porCd" style="width:52px;ime-mode:disabled" class="input2" dataformat="engup" maxlength="5" OnKeyUp="checkValidation()" readOnly onchange="obj_change()"></td>
				<th title="Port of Loading">POL</th>
				<td><input  type="text" name="polCd" id="polCd" style="width:52px;ime-mode:disabled" class="input2" dataformat="engup" maxlength="5" OnKeyUp="checkValidation()" readOnly onchange="obj_change()"></td>
				<th title="Port of Discharging">POD</th>
				<td><input  type="text" name="podCd" id="podCd" style="width:52px;ime-mode:disabled" class="input2" dataformat="engup" maxlength="5" OnKeyUp="checkValidation()" readOnly onchange="obj_change()"></td>
				<th title="Place of Delivery">DEL</th>
				<td><input  type="text" name="delCd" id="delCd" style="width:52px;ime-mode:disabled" class="input2" dataformat="engup" maxlength="5" OnKeyUp="checkValidation()" readOnly onchange="obj_change()"></td>
				<th>R/D</th>
				<td><select name="rcvTermCd" id="rcvTermCd" style="width:80px;" class="input2" disabled></select>/&nbsp;<!-- 
					 --><select name="deTermCd" id="deTermCd"  style="width:80px;" class="input2" disabled></select></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="*">
		    </colgroup>
			<tr>
				<th>BKG Cust.</th>
				<td><input type="text" name="bkgCustCd" id="bkgCustCd" style="width:100px;" class="input2" readOnly><!-- 
					 --><input type="text" name="bkgCustNm" id="bkgCustNm" style="width:403px;" class="input2" readOnly></td>
			</tr>
			<tr>
				<th>A/R Cust.</th>
				<td><input type="text" name="arCustCd" id="arCustCd" style="width:100px;" class="input2" readOnly><!-- 
					 --><input type="text" name="arCustNm" id="arCustNm" style="width:403px;" class="input2" readOnly></td>
			</tr>
			<tr>
				<th>Payer</th>
				<td><input type="text" name="payerCd" id="payerCd" style="width:70px;ime-mode:disabled" dataformat="engup" class="input2" caption="Payer" maxlength="8" onKeyPress="ComKeyOnlyAlphabet('uppernum')" readOnly><!-- 
				 --><button type="button" class="input_seach_btn" name="btn_PayerCd" id="btn_PayerCd"></button><!-- 
				 --><input type="text" name="payerNm" í="payerNm" style="width:403px;" class="input2" readOnly>
			</td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="160">
				<col width="42">
				<col width="130">
				<col width="80">
				<col width="100">
				<col width="65">
				<col width="230">
				<col width="*">
		    </colgroup>
			<tr>
				<th>Attention</th>
				<td><script type="text/javascript">ComComboObject('cboAttention', 4, 152 , 1, 0, 0, true)</script></td>
				<th>Tel.</th>
				<td><input type="text" name="tel" id="tel" style="width:160px;" class="input2" readOnly></td>
				<th>Fax</th>
				<td><input type="text" name="fax" id="fax" style="width:157px;" class="input2" readOnly></td>
				<th>E-mail</th>
				<td><input type="text" name="email" id="email" style="width:203px;" class="input2" readOnly></td>
				<td> </td>
			</tr>
		</tbody>
	</table>
	<table >
		<tbody>
			<colgroup>
				<col width="70">
				<col width="610">
				<col width="66">
				<col width="91">
				<col width="80">
				<col width="*">
		    </colgroup>
			<tr>
				<th>Trucker</th>
				<td><input type="text" name="truckerCd" id="truckerCd" style="width:70px;" dataformat="num" class="input2" maxlength="6" readOnly><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_TruckerCd" id="btn_TruckerCd"></button><!-- 
					 --><input type="text" name="truckerNm" id="truckerNm" style="width:503px;" class="input2" readOnly>
				</td>
				<th>Due Date</th>
				<td><input type="text" name="dueDate" id="dueDate" style="width:80px;" class="input2" readOnly></td>
				<th>Credit Term</th>
				<td><input type="text" name="creditTerm" id="creditTerm" style="width:30px;" class="input2" readOnly>&nbsp;<b>day</b></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="610">
				<col width="70">
				<col width="85">
				<col width="83">
				<col width="*">
		    </colgroup>
			<tr>
				<th valign="top" name="txt_Remark" id="txt_Remark" rowspan="2" onmouseover="" onmouseout="">Invoice<br>Remark(s)</th>
				<td><input type="text" name="invoiceRemark1" id="invoiceRemark1" style="width:100%;" class="input2" maxlength="85" readOnly></td>
				<th>Notice</th>
				<td>
					<select name="notice" id="notice" style="width:80px;" class="input2" disabled>
						<option value=""></option>
						<option value="1">1st</option>
						<option value="2">2nd</option>
						<option value="3">3rd</option>
						<option value="9">Final</option>
					</select>
				</td>
				<th>INV Over Day</th>
				<td><input type="text" name="invoiceOverDay" id="invoiceOverDay" style="width:30px;" class="input2" readOnly>&nbsp;<b>day</b></td>
			</tr>
			<tr>				
				<td><input type="text" name="invoiceRemark2" id="invoiceRemark2" style="width:100%;" class="input2" maxlength="85" readOnly></td>
				<th>Cust. Ref</th>
				<td colspan="3"><input type="text" name="custRef" id="custRef" style="width:200px;" class="input2" maxlength="20" readOnly></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
<!-- opus_design_inquiry(E) -->
<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2" style="width:520px;" >
    	<div class="opus_design_grid" id="mainTable" style="width:510px;">
			<div class="opus_design_data">		
		        <table>
					<tbody>
						<colgroup>
							<col width="100">
							<col width="160">
							<col width="*">
					    </colgroup>
						<tr>
							<td><h3 class="title_design" style="margin-top:-20px;">Charge</h3></td>
							<td>Charge Cur.&nbsp;<select name="chargeCurrency" id="chargeCurrency" style="width:70px;" class="input2" onChange="changeChargeCurrency()" readOnly></select></td>
							<td>
								<table class="grid_2">
								<tr>
									<th>Billable AMT</th>
									<td class="noinput2"><input type="text" name="billableAmt" id="billableAmt" style="width:100%;text-align:right" class="noinput2" readOnly></td>
								</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_AddCharge" 		id="btn_AddCharge">Row Add</button><!--  
				--><button type="button" class="btn_accent" name="btn_CopyCharge" 	id="btn_CopyCharge">Row Copy</button><!--  
				--><button type="button" class="btn_accent" name="btn_DelCharge" 	id="btn_DelCharge">Row Delete</button><!--  
				--><button type="button" class="btn_accent" name="btn_InqMVMT" 		id="btn_InqMVMT">MVMT Inq.</button>
			</div>
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
    </div>
    <div class="layout_vertical_2" style="width:490px;">
   		<div class="layout_wrap" style="width:100%;">
		    <div class="layout_vertical_2" style="width:166px;">
		    	<div class= "opus_design_inquiry">
		    	<table>
					<tr>
						<td><h3 class="title_design">Invoice</h3></td>
					</tr>
				</table>
	    		<table>
					<tbody>
						<colgroup>
							<col width="70">
							<col width="*">
					    </colgroup>
						<tr>
							<th>INV Cur.</th>
							<td><select name="invoiceCurrency" id="invoiceCurrency" style="width:60px;" class="input2" onChange="changeChargeCurrency()" ></select></td>
						</tr>
						<tr>
							<th>Ex. Rate</th>
							<td><input type="text" name="exRate" id="exRate" style="width:80px;text-align:right" class="input2" readOnly></td>
						</tr>
						<tr>
							<th>CNTR Q’ty</th>
							<td><input type="text" name="cntrQty" id="cntrQty" style="width:80px;text-align:right" class="input2" readOnly></td>
						</tr>
					</tbody>
				</table>
				</div>
		    </div>
		    <div class="layout_vertical_2" style="width:275px;">
		    	<div class= "opus_design_inquiry">
		        <table  class="grid_2" style="width:260px;">
					<tbody>
						<colgroup>
							<col width="110">
							<col width="80">
							<col width="*">
					    </colgroup>
						<tr>
							<th>Total AMT</th>
							<td colspan="2">
								<input type="text" name="totalAmt" id="totalAmt" style="width:100%; text-align:right" class="noinput2" dataformat="float" size="16" pointcut="2" maxlength="18" readOnly>
							</td>
						</tr>
						<tr>
							<th>D/C by AMT</th>
							<td colspan="2">
								<input type="text" name="dcAmtRate" id="dcAmtRate" style="width:100%;text-align:right" class="noinput2" dataformat="float" size="16" pointcut="2" maxlength="18" readOnly>
							</td>
						</tr>
						<tr>
							<th>Billing AMT </th>
							<td colspan="2">
								<input type="text" name="billingAmt" id="billingAmt" style="width:100%;text-align:right" class="noinput2" dataformat="float" size="16" pointcut="2" maxlength="18" readOnly>
							</td>
						</tr>
						<tr>
							<th>Tax Rate/ AMT </th>
							<td>
								<input type="checkbox" name="chkTaxRateAmt" class="trans" onClick="changeTaxRate()">&nbsp;<!-- 
								 --><input type="text" name="taxRate" id="taxRate" style="width:50px;text-align:right;" class="noinput2" readOnly>&nbsp;%
							</td>
							<td>
								<input type="text" name="taxAmt" id="taxAmt" style="width:100%;text-align:right" class="noinput2">
							</td>
						</tr>
						<tr>
							<th>Payable AMT </th>
							<td colspan="3">
								<input type="text" name="payableAmt" id="payableAmt" style="width:100%;text-align:right" class="noinput2" readOnly>
							</td>
						</tr>
					</tbody>
				</table>
				</div>
		    </div>
		</div>
	 </div>
	</div>
	
<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	

	<div class="layout_wrap">
    <div class="layout_vertical_2" style="width:520px;">
   		<div class="opus_design_grid" id="mainTable" style="width:510px;">
            <div class="opus_design_data" style="margin-top:-8px">
            	<table>
					<tr>
						<td><h3 class="title_design mar_top_12">Rate Detail</h3></td>
					</tr>
				</table>
            </div>
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
    </div>
    <div class="layout_vertical_2" style="width:500px;">
		<div class="opus_design_data" style="width:436px;">
     		<table>
			<tr>
			<td><h3 class="title_design mar_top_12">Manual Invoice Reason</h3></td>
			</tr>
			</table>
			<table class="grid_2" style="margin-top:-7px">
				<tbody>
					<colgroup>
						<col width="100">
						<col width="*">
				    </colgroup>
					<tr>
						<th style="text-align:center;">Reason</th>
						<td><select name="reason" style="width:100%;" class="input2" disabled></select></td>
					</tr>
					<tr>
						<th style="text-align:center;">Remark(s)</th>
						<td><textarea name="remark" style="width:100%;height:57px;resize:none;" class="textarea2" disabled></textarea></td>
					</tr>
				</tbody>
			</table>
       </div>
        <div id="mainTable" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	    </div>
       </div>
	</div>
	
	<!-- layout_wrap(E) -->
</div>
<%if (!"true".equals(main_page)){%>
</div>
<%} %>

<%= tableTag %>


</form>