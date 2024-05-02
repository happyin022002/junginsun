<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4002.jsp
*@FileTitle  : Invoice Creation & Issue - Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id 	= "";
	String strUsr_nm 	= "";
	String strUsr_ofc 	= "";
	String strCnt_cd 	= "";
	String strUsr_eml	= "";
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	// setting button authority of Save, Cancel, A/R I/F
	int i_cnt = 0;
	Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

	//Parameter
	String s_group_by = "";
	String s_chg_type = "";
	String s_ofc_cd = "";
	String s_bkg_no = "";
	String s_dmdt_trf_cd = "";
	String s_cntr_no = "";
	String invoice_issue = "";
	String s_invoice_no = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		strCnt_cd 	= account.getCnt_cd();
		strUsr_eml 	= account.getUsr_eml();
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();

		//check authority- if Role of login User if not  DMT01, DMT02, DMT03, DMT04
		//					no authority: disply alert "You have no authority to XXXX!" 
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

		event = (EesDmt4002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		s_group_by		= JSPUtil.getParameter(request,"group_by");
		s_chg_type		= JSPUtil.getParameter(request,"chg_type");
		s_ofc_cd		= JSPUtil.getParameter(request,"ofc_cd");
		s_bkg_no		= JSPUtil.getParameter(request,"bkg_no");
		s_dmdt_trf_cd	= JSPUtil.getParameter(request,"dmdt_trf_cd");
		s_cntr_no		= JSPUtil.getParameter(request,"cntr_no");
		invoice_issue	= JSPUtil.getParameter(request,"invoice_issue");	//1:before, 2:after
		s_invoice_no	= JSPUtil.getParameter(request,"invoice_no");

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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!--  select condition -->
<input type="hidden" name="s_group_by" value="<%=s_group_by %>" id="s_group_by" />
<input type="hidden" name="s_chg_type" value="<%=s_chg_type %>" id="s_chg_type" />
<input type="hidden" name="s_ofc_cd" value="<%=s_ofc_cd %>" id="s_ofc_cd" />
<input type="hidden" name="s_bkg_no" value="<%=s_bkg_no %>" id="s_bkg_no" />
<input type="hidden" name="s_dmdt_trf_cd" value="<%=s_dmdt_trf_cd %>" id="s_dmdt_trf_cd" />
<input type="hidden" name="s_cntr_no" value="<%=s_cntr_no %>" id="s_cntr_no" />
<input type="hidden" name="s_cust_gubun" id="s_cust_gubun" />
<input type="hidden" name="s_cust_cd" id="s_cust_cd" />
<input type="hidden" name="invoice_issue" value="<%=invoice_issue %>" id="invoice_issue" />
<input type="hidden" name="s_invoice_no" value="<%=s_invoice_no %>" id="s_invoice_no" />
<input type="hidden" name="dmdt_payr_cntc_pnt_nm" id="dmdt_payr_cntc_pnt_nm" />
<input type="hidden" name="cust_cntc_pnt_seq" id="cust_cntc_pnt_seq" />
<input type="hidden" name="vndr_cd" id="vndr_cd" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="rfa_no" id="rfa_no" />
<input type="hidden" name="chg_type" id="chg_type" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="svr_id" id="svr_id" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="tax_rto" id="tax_rto" />
<input type="hidden" name="session_cnt_cd" value="<%=strCnt_cd %>" id="session_cnt_cd" />
<input type="hidden" name="bil_to_loc_div_cd" id="bil_to_loc_div_cd" />
<input type="hidden" name="dmdt_chg_sts_cds" value="C" id="dmdt_chg_sts_cds" />
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc %>" id="session_ofc_cd" />
<input type="hidden" name="session_email" value="<%=strUsr_eml %>" id="session_email" />
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>" id="session_usr_nm" />
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>" id="session_usr_id" />
<input type="hidden" name="success_yn" id="success_yn" />
<input type="hidden" name="ar_usr_id" id="ar_usr_id" />
<input type="hidden" name="ar_ofc_cd" id="ar_ofc_cd" />
<input type="hidden" name="usr_cnt_cd" id="usr_cnt_cd" />
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
<!-- searchCurrentDateByOffice -->
<input type="hidden" name="ofc_curr_date" id="ofc_curr_date" />
<!-- INVOICE TAX_RTO -->
<input type="hidden" name="inv_tax_rto" id="inv_tax_rto" />
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
<!-- sheet set -->
<input type="hidden" name="dmdt_sh_tp_cd" id="dmdt_sh_tp_cd" />
<input type="hidden" name="has_sheetset" id="has_sheetset" />
<!-- preview -->
<input type="hidden" name="org_payer_cd" id="org_payer_cd" />
<input type="hidden" name="org_dmdt_payr_cntc_pnt_nm" id="org_dmdt_payr_cntc_pnt_nm" />
<input type="hidden" name="org_payr_cntc_pnt_phn_no" id="org_payr_cntc_pnt_phn_no" />
<input type="hidden" name="org_payr_cntc_pnt_fax_no" id="org_payr_cntc_pnt_fax_no" />
<input type="hidden" name="org_payr_cntc_pnt_eml" id="org_payr_cntc_pnt_eml" />
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
<input type="hidden" name="rd_ida_expn_tax_rt" id="rd_ida_expn_tax_rt" />
<input type="hidden" name="rd_ida_expn_tax" id="rd_ida_expn_tax" />
<input type="hidden" name="rd_ida_edu_tax_rt" id="rd_ida_edu_tax_rt" />
<input type="hidden" name="rd_ida_edu_tax" id="rd_ida_edu_tax" />
<input type="hidden" name="rd_ida_high_edu_tax_rt" id="rd_ida_high_edu_tax_rt" />
<input type="hidden" name="rd_ida_high_edu_tax" id="rd_ida_high_edu_tax" />
<input type="hidden" name="rd_tax_rgst_no" id="rd_tax_rgst_no" />
<input type="hidden" name="rd_svc_cate_rmk" id="rd_svc_cate_rmk" />
<input type="hidden" name="rd_pmnt_acct_no" id="rd_pmnt_acct_no" />

<!-- payer check -->
<input type="hidden" name="h_payer_cd" id="h_payer_cd">
<input type="hidden" name="h_payer_nm" id="h_payer_nm">
<input type="hidden" name="act_payr_cust_nm" id="act_payr_cust_nm"> <!-- E-mail Send용 Customer Name -->
<!-- RD check -->
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

<!-- page_title_area(S) -->
<div class="layer_popup_title">  
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Invoice Creation & Issue - Booking</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_set" 	id="btn_set">Sheet Set</button><!--  
		--><button type="button" class="btn_normal" name="btn_option"  		id="btn_option">Sheet Option</button><!--  
		--><button type="button" class="btn_normal" name="btn_sendinghistory" 		id="btn_sendinghistory">Sending History</button><!--  
		--><button type="button" class="btn_normal" name="btn_cremark" 	id="btn_cremark" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()">C. Remark</button>
		<button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_cancel"  		id="btn_cancel">Cancel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_preview" 		id="btn_preview">Preview</button><!--
		--><button type="button" class="btn_normal" name="btn_print" 	id="btn_print">INV Print</button><!-- 
		--><button type="button" class="btn_normal" name="btn_fax" 		id="btn_fax">Fax Send</button><!-- 
		--><button type="button" class="btn_normal" name="btn_email" 		id="btn_email">Email Send</button><!-- 
		--><button type="button" class="btn_normal" name="btn_payerfaxemail" 		id="btn_payerfaxemail">Payer  Info.</button><!-- 
		--><button type="button" class="btn_normal" name="btn_arif" 		id="btn_arif">A/R I/F</button><!-- 
		--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!-- 
		 --></div>
	</div>
</div>


<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />
					<col width="110" />
					<col width="150" />
					<col width="330" />
					<col width="90" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Invoice No.</th>
						<td><input type="text" name="dmdt_inv_no" style="width:78px;" class="input2" value="" readonly id="dmdt_inv_no" /><input type="text" name="inv_prt_flg" style="width:20px;" class="input2" value="" readonly="" id="inv_prt_flg" /></td>
						<th>Issue Date/OFC/Name</th>
						<td><input type="text" name="cre_dt" style="width:80px;" class="input2" value="" readonly id="cre_dt" /><input type="text" name="cre_ofc_cd" style="width:50px;" class="input2" value="" readonly id="cre_ofc_cd" /><input type="hidden" name="cre_cnt_cd" id="cre_cnt_cd" /><input type="hidden" name="cre_usr_id" id="cre_usr_id" /><input type="text" name="cre_usr_nm" style="width:180px;" class="input2" value="" readonly id="cre_usr_nm" /></td>
						<th>Status</th>
						<td><input type="hidden" name="dmdt_inv_sts_cd" id="dmdt_inv_sts_cd" /><input type="text" name="dmdt_inv_sts_nm" style="width:95px;" class="input2" value="" readonly id="dmdt_inv_sts_nm" /></td>
						<td></td>
					</tr>
		  		</tbody>
	   		</table>
	   		<table>
				<colgroup>
					<col width="70" />
					<col width="110" />
					<col width="150" />
					<col width="330" />
					<col width="90" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>A/R I/F</th>
						<td><input type="text" name="dmdt_ar_if_cd" style="width:103px;" class="input2" value="" readonly id="dmdt_ar_if_cd" /></td>
						<th>A/R I/F Date/OFC/Name</th>
						<td><input type="text" name="ar_if_dt" style="width:80px;" class="input2" value="" readonly id="ar_if_dt" /><input type="text" name="ar_if_ofc_cd" style="width:50px;" class="input2" value="" readonly id="ar_if_ofc_cd" /><input type="hidden" name="ar_if_usr_id" id="ar_if_usr_id" /><input type="text" name="ar_if_usr_nm" style="width:180px;" class="input2" value="" readonly id="ar_if_usr_nm" /></td>
						<th><div id="cr_nm">Credit Note</div></th>
						<td><input type="text" name="cr_inv_no" style="width:95px;" class="input2" value="" readonly id="cr_inv_no" /><input type="text" name="cr_ar_yn" style="width:60px;" class="input2" value="" readonly id="cr_ar_yn" /></td>
						<td></td>
					</tr>
				</tbody>
	   		</table>
	   		<table>
				<colgroup>
					<col width="70" />
					<col width="110" />
					<col width="150" />
					<col width="110" />
					<col width="81" />
					<col width="119" />
					<col width="110" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>BKG No.</th>
						<td><input type="text" name="bkg_no" style="width:103px;" class="input2" value="" readonly id="bkg_no" /></td>
						<th>B/L No.</th>
						<td><input type="text" name="bl_no" style="width:100px;" class="input2" value="" readonly id="bl_no" /></td>
						<th>Tariff Type</th>
						<td><input type="text" name="dmdt_trf_cd" style="width:59px;" class="input2" value="" readonly id="dmdt_trf_cd" /></td>
						<th>S/C No.</th>
						<td><input type="text" name="sc_no" style="width:95px;" class="input2" value="" readonly id="sc_no" /></td>
						<td></td>
					</tr>
				</tbody>
	   		</table>
	   		<table>
				<colgroup>
					<col width="70" />
					<col width="110" />
					<col width="40" />
					<col width="40" />
					<col width="40" />
					<col width="38" />
					<col width="40" />
					<col width="40" />
					<col width="35" />
					<col width="40" />
					<col width="31" />
					<col width="40" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>VVD CD</th>
						<td><input type="text" name="vvd_cd" style="width:103px;" class="input2" value="" readonly id="vvd_cd" /></td>
						<th title="Place of Receipt">POR</th>
						<td><input type="text" name="por_cd" style="width:55px;text-align:center;" class="input2" value="" readonly id="por_cd" /></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" name="pol_cd" style="width:55px;text-align:center;" class="input2" value="" readonly id="pol_cd" /></td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" name="pod_cd" style="width:55px;text-align:center;" class="input2" value="" readonly id="pod_cd" /></td>
						<th title="Place of Delivery">DEL</th>
						<td><input type="text" name="del_cd" style="width:59px;text-align:center;" class="input2" value="" readonly id="del_cd" /></td>
						<th>R/D</th>
						<td><input type="text" name="rd" style="width:33px;" class="input2" value="" readonly id="rd" /></td>
						<td></td>
					</tr>
				</tbody>
	   		</table>
	   		<table>
				<colgroup>
					<col width="70" />
					<col width="120" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>BKG Cust.</th>
						<td><input type="text" name="bkg_cust_cd" style="width:103px;" class="input2" value="" readonly id="bkg_cust_cd" /><input type="text" name="bkg_cust_nm" style="width:403px;" class="input2" value="" readonly id="bkg_cust_nm" /></td>
						<td></td>
					</tr>
					<tr>
						<th>A/R Cust.</th>
						<td><input type="text" name="act_cust_cd" style="width:103px;" class="input2" value="" readonly id="act_cust_cd" /><input type="text" name="act_cust_nm" style="width:403px;" class="input2" value="" readonly id="act_cust_nm" /></td>
						<td></td>
					</tr>
					<tr>
						<th>Payer</th>
						<td><input type="text" name="payer_cd" style="width:73px;" dataformat="engup" class="input1" caption="Payer" maxlength="8" value="" onkeypress="ComKeyOnlyAlphabet('uppernum')" id="payer_cd" /><button type="button" id="btn_payer_cd" name="btn_payer_cd" class="input_seach_btn"></button><input type="text" name="payer_nm" style="width:403px;" class="input2" value="" readonly id="payer_nm" /></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="70" />
					<col width="160" />
					<col width="60" />
					<col width="140" />
					<col width="50" />
					<col width="190" />
					<col width="80" />
					<col width="240" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Attention</th>
						<td><script type="text/javascript">ComComboObject('combo1', 4, 150 , 1, 0, 0, true)</script></td>
						<th>Tel.</th>
						<td ><input type="text" name="payr_cntc_pnt_phn_no" style="width:100px;" class="input2" value="" readonly id="payr_cntc_pnt_phn_no" /></td>
						<th>Fax</th>
						<td><input type="text" name="payr_cntc_pnt_fax_no" style="width:99px;" class="input2" value="" readonly id="payr_cntc_pnt_fax_no" /></td>
						<th>E-mail</th>
						<td ><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" value="" readonly id="payr_cntc_pnt_eml" /></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<table>
					<colgroup>
						<col width="70" />
						<col width="620" />
						<col width="60" />
						<col width="90" />
						<col width="60" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Trucker</th>
							<td><input type="text" name="trucker_cd" maxlength="6" style="width:73px;" dataformat="engup" class="input" value="" caption="Trucker" id="trucker_cd" /><button type="button" id="btn_trucker_cd" name="btn_trucker_cd" class="input_seach_btn"></button><input type="text" name="trucker_nm" style="width:403px;" class="input2" value="" readonly id="trucker_nm" /></td>
							<th>Due Date</th>
							<td><input type="text" name="due_date" style="width:80px;" class="input2" value="" readonly id="due_date" /></td>
							<th>Credit Term</th>
							<td><input type="text" name="cr_term_dys" style="width:30px;" class="input2" value="" readonly id="cr_term_dys" />day</td>
						</tr>
						<tr>
							<th id="txt_remark" name="txt_remark" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()">Invoice<br>Remark(s)</th>
							<td><input type="text" name="inv_rmk1" maxlength="85" style="width:606px;" class="input" value="" id="inv_rmk1" /></td>
							<th>Notice</th>
							<td><select name="ntc_knt_cd" id="ntc_knt_cd" style="width:70px;">
								<option value=""></option>
								<option value="1">1st</option>
								<option value="2">2nd</option>
								<option value="3">3rd</option>
								<option value="9">Final</option>
								</select></td>
							<th>INV Over Day</th>
							<td><input type="text" name="over_day" style="width:30px;" class="input2" value="" readonly id="over_day" />day</td>
						</tr>
						<tr>
							<th></th>
							<td><input type="text" name="inv_rmk2" maxlength="85" style="width:606px;" class="input" value="" id="inv_rmk2" /></td>
							<th>Cust. Ref</th>
							<td colspan="3"><input type="text" name="inv_ref_no" style="width:238px;" maxlength="20" class="input" value="" id="inv_ref_no" /></td>
						</tr>
				</tbody>
			</table>
			
			<!-- layout_wrap(S) -->
			<div class="layout_wrap mar_top_12" style="height: 170px; width:997px;">
			 	<div class="layout_vertical_2 pad_rgt_4">
			 		<h3 class="title_design">Charge Notice</h3>
			 		<div class="layout_wrap">
			 			<div class="layout_flex_fixed" style="width: 140px">
							<table>
								<colgroup>
									<col width="70" />				
									<col width="*" />				
							   </colgroup> 
							   <tbody>
							   		<tr>
										<th>Charge Cur.</th>
										<td><input type="text" name="chg_curr_cd" style="width:50px;text-align:center" class="input2" value="" readonly id="chg_curr_cd" /></td>
									</tr>
							   </tbody>
							</table>
			 			</div>
			 			<div class="layout_flex_flex" style="padding-left:148px">
			 				<table class="grid_2 wAuto">
								<colgroup>
									<col width="140" />				
									<col width="*" />				
							   </colgroup> 
							  	<tr>
									<th><b>Incurred AMT</b></th>
									<td class="noinput2"><input type="text" name="mn_org_chg_amt" style="width:160px;text-align:right" class="noinput2" value="" readonly id="mn_org_chg_amt" /></td>
								</tr>
								<tr>
									<th><b>Exception AMT</b></th>
									<td class="noinput2"><input type="text" name="dmdt_expt_amt" style="width:160px;text-align:right" class="noinput2" value="" readonly id="dmdt_expt_amt" /></td>
								</tr>
								<tr>
									<th><b>Discount AMT</b></th>
									<td class="noinput2"><input type="text" name="chg_dc_amt" style="width:160px;text-align:right" class="noinput2" value="" readonly id="chg_dc_amt" /></td>
								</tr>
								<tr>
									<th><b>Billable AMT</b></th>
									<td class="noinput2"><input type="text" name="mn_bil_amt" style="width:160px;text-align:right" class="noinput2" value="" readonly id="mn_bil_amt" /></td>
								</tr>
								<tr>
									<th id="txt_aft_inv_adj_amt" name="txt_aft_inv_adj_amt"  onmouseover="obj_mouseover()" onmouseout="obj_mouseout()"><b>Adjusted AMT after INV</b></th>
									<td class="noinput2"><input type="text" name="aft_inv_adj_amt" style="width:160px;text-align:right" class="noinput2" value="" readonly id="aft_inv_adj_amt" /></td>
								</tr>
							</table>
			 			</div>
			 		</div>
			 	</div>
			 	
			 	<div class="layout_vertical_2">
			 		<h3 class="title_design">Invoice</h3>
			 		<div class="layout_wrap">
			 			<div class="layout_flex_fixed" style="width: 200px">
			 				<div class="opus_design_inquiry">
			 				<table>
							   <colgroup>
									<col width="70" />				
									<col width="*" />				
							   </colgroup> 
							   	<tr>
									<th>INV Cur.</th>
									<td><div id="inv_cur"><input type="text" name="inv_curr_cd" style="width:40px;text-align:center" class="input2" value="" readonly></div></td>
								</tr>
								<tr>
									<th>Ex. Rate</th>
									<td><input type="text" name="inv_xch_rt" style="width:90px;text-align:right" class="input2" value="" readonly id="inv_xch_rt" /></td>
								</tr>
								<tr>
									<th>CNTR Q’ty</th>
									<td><input type="text" name="cntr_cnt" style="width:90px;text-align:right" class="input2" value="" readonly id="cntr_cnt" /></td>
								</tr>
							</table>
							</div>
						</div>
						<div class="layout_flex_flex" style="padding-left:180px">
			 				<table class="grid2 wAuto">
								<colgroup>
									<col width="120" />				
									<col width="*" />				
							   	</colgroup> 
						   		<tr>
									<th><b>Total AMT</b></th>
									<td class="noinput2" colspan="2"><input type="text" name="tot_amt" style="width:180px;text-align:right" class="noinput2" value="" readonly id="tot_amt" /></td>
								</tr>
								<tr>
									<th><b>D/C by AMT or %</b></th>
									<td class="noinput2" colspan="2"><input type="text" name="dc_amt" style="width:180px;text-align:right" class="noinput2" value="" readonly id="dc_amt" /></td>
								</tr>
								<tr>
									<th><b>Billing AMT</b></th>
									<td class="noinput2" colspan="2"><input type="text" name="inv_chg_amt" style="width:180px;text-align:right" class="noinput2" value="" readonly id="inv_chg_amt" /></td>
								</tr>
								<tr>
									<th><b>Tax Rate/ AMT</b></th>
									<td class="noinput2"><input type="checkbox" name="chk_tax" value="" class="trans" onclick="setTax();" id="chk_tax" /><input type="text" name="tax_rto_dis" style="width:50px;text-align:right" class="noinput2" value="" readonly id="tax_rto_dis" />%</td>
									<td class="noinput2"><input type="text" name="tax_amt" style="width:95px;text-align:right" class="noinput2" value="" readonly id="tax_amt" /></td>
								</tr>
								<tr>
									<th><b>Payable AMT</b></th>
									<td class="noinput2" colspan="2"><input type="text" name="inv_amt" style="width:180px;text-align:right" class="noinput2" value="" readonly id="inv_amt" /></td>
								</tr>
							</table>
						</div>
			 		</div>
			 	</div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<!-- opus_tab_btn(S) -->
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_tab_btn(E) -->
		<!-- opus_tab_btn(S) -->
		<div class="opus_design_grid clear" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet2')</script>
		</div>
		<!-- opus_tab_btn(E) -->
		<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
	</div>
</div>
</form>			