<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4003.jsp
*@FileTitle  : Invoice Issue Preview
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4003Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%

	Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

	String strOfc_cd 	="";
	String strUsr_id 	= "";
	String strUsr_nm 	= "";
	String strUsr_eml	= "";

	//Parameter
	String payr_cntc_pnt_phn_no = "";
	String payr_cntc_pnt_fax_no = "";
	String payr_cntc_pnt_eml 	= "";
	String invoice_no 			= "";
	String invoice_LR			= "";
	String cre_ofc_cd			= "";
	String payer_cd				= "";
	String bkg_no				= "";
	String pod_cd				= "";
	String dmdt_trf_cd			= "";
	String jspno				= "";
	String bl_no				= "";
	String inc_cntr_dtail		= "";
	
	String rhq_ofc_cd			= "";
	String cre_cnt_cd           = "";

	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strOfc_cd  =	account.getOfc_cd();
	strUsr_id 	= account.getUsr_id();
	strUsr_nm 	= account.getUsr_nm();
	strUsr_eml 	= account.getUsr_eml();	

	payr_cntc_pnt_phn_no	= JSPUtil.getParameter(request,"payr_cntc_pnt_phn_no");
	payr_cntc_pnt_fax_no	= JSPUtil.getParameter(request,"payr_cntc_pnt_fax_no");
	payr_cntc_pnt_eml		= JSPUtil.getParameter(request,"payr_cntc_pnt_eml");
	invoice_no				= JSPUtil.getParameter(request,"invoice_no");
	invoice_LR				= JSPUtil.getParameter(request,"invoice_LR");
	cre_ofc_cd				= JSPUtil.getParameter(request,"cre_ofc_cd");
	payer_cd				= JSPUtil.getParameter(request,"payer_cd");
	bkg_no					= JSPUtil.getParameter(request,"bkg_no");
	pod_cd					= JSPUtil.getParameter(request,"pod_cd");
	dmdt_trf_cd				= JSPUtil.getParameter(request,"dmdt_trf_cd");
	jspno					= JSPUtil.getParameter(request,"jspno");
	bl_no					= JSPUtil.getParameter(request,"bl_no");

	inc_cntr_dtail			= JSPUtil.getParameter(request,"inc_cntr_dtail");
	rhq_ofc_cd				= JSPUtil.getParameter(request,"rhq_ofc_cd");
	cre_cnt_cd              = JSPUtil.getParameter(request,"cre_cnt_cd");
	
	String mrd_path = "";
	//=========================================
	//2015.10.27 #7995 comment start
	//2017.01.12 #23259 India Invocie
    if(invoice_LR.equals("L")){
    	if(inc_cntr_dtail.equals("N")){
        	if(cre_cnt_cd.equals("IN")){
        		// india office 전용 2012.05.18
        		mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4914.mrd";
        	}else{
    		    mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
        	}
    	}else{
    			if(cre_cnt_cd.equals("IN")){
            		// india office 전용 2012.05.18
            		mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";	
    			}else{
    		        mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
    			}
    	}
    }else if(invoice_LR.equals("R")){
    	if(inc_cntr_dtail.equals("N")){
         	if(cre_cnt_cd.equals("IN")){
        		// india office 전용 2012.05.18
        	  	 mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4915.mrd";
        	}else{
    		     mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4909.mrd";
        	}
    	}else{
     			if(cre_cnt_cd.equals("IN")){
            		// india office 전용 2012.05.18
            	  	 mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4913.mrd";
            	}else{
    		         mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
            	}
    	}
    }else{
    	if(inc_cntr_dtail.equals("N")){
    		if(cre_cnt_cd.equals("IN")){
        		// india office 전용 2012.05.18
        		mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4914.mrd";
        	}else{
      		    mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
        	}
    	}else{
    			if(cre_cnt_cd.equals("IN")){
            		// india office 전용 2012.05.18
            		mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";	
    			}else{
    		        mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
    			}
    	}
    } 
    /*
    if(invoice_LR.equals("L")){
    	if(inc_cntr_dtail.equals("N")){
   		    mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
    	}else{
	        mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
    	}
    }else if(invoice_LR.equals("R")){
    	if(inc_cntr_dtail.equals("N")){
   		     mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4909.mrd";
    	}else{
	         mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
    	}
    }else{
    	if(inc_cntr_dtail.equals("N")){
   		    mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
    	}else{
	        mrd_path="apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
    	}
    }
    */
  	//2015.10.27 #7995 comment e n d
  	//=========================================

%>



<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    function setupPage(){
	    loadPage();
	}
</script>
<form name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="mrd" value="<%=mrd_path %>" id="mrd" />
<input type="hidden" name="invoice_no" value="<%=invoice_no %>" id="invoice_no" />
<input type="hidden" name="cre_ofc_cd" value="<%=cre_ofc_cd %>" id="cre_ofc_cd" />
<input type="hidden" name="payer_cd" value="<%=payer_cd %>" id="payer_cd" />
<input type="hidden" name="pod_cd" value="<%=pod_cd %>" id="pod_cd" />
<input type="hidden" name="dmdt_trf_cd" value="<%=dmdt_trf_cd %>" id="dmdt_trf_cd" />
<input type="hidden" name="bkg_no" value="<%=bkg_no %>" id="bkg_no" />
<input type="hidden" name="bl_no" value="<%=bl_no %>" id="bl_no" />
<input type="hidden" name="invoice_LR" value="<%=invoice_LR %>" id="invoice_LR" />
<input type="hidden" name="session_ofc_cd" value="<%=strOfc_cd%>" id="session_ofc_cd">
<input type="hidden" name="session_email" value="<%=strUsr_eml %>" id="session_email" />
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>" id="session_usr_nm" />
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>" id="session_usr_id" />
<input type="hidden" name="bil_to_loc_div_cd" value="<%=invoice_LR %>" id="bil_to_loc_div_cd" />

<input type="hidden" name="inc_cntr_dtail"	value="<%=inc_cntr_dtail %>" id="inc_cntr_dtail">

<input  type="hidden" name="rhq_ofc_cd"		value="<%=rhq_ofc_cd %>" id="rhq_ofc_cd">
<input  type="hidden" name="cre_cnt_cd"      value="<%=cre_cnt_cd%>" id="cre_cnt_cd">

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
<input type="hidden" name="act_payr_cust_nm" id="act_payr_cust_nm">

<input type="hidden" name="jspno" value="<%=jspno %>" id="jspno" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="has_sheetset" id="has_sheetset" />
<input type="hidden" name="dmdt_sh_tp_cd" id="dmdt_sh_tp_cd" />

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

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Invoice Issue Preview</span></h2>
	
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
				 <button type="button" class="btn_accent" name="btn_print" id="btn_print">INV Print</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_fax" id="btn_fax">Fax Send</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_email" id="btn_email">Email Send</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		 --></div>
	<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title(E) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
    	<div class="opus_design_RD" style="height:88%!important">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
		 <div style="position:relative;top:88%">
			 <div class="opus_design_inquiry wFit">
				<table> 
					<tr>
		                <th width="100px">Attention<th>
		                <td width="170px"><input type="text" style="width:154px;" class="input2" name="dmdt_payr_cntc_pnt_nm" value="" readonly id="dmdt_payr_cntc_pnt_nm" /> </td>
		                <th width="100px">Tel.<th>
		                <td width="170px"><input type="text" style="width:150px;" class="input2" name="payr_cntc_pnt_phn_no" value="<%=payr_cntc_pnt_phn_no %>" readonly id="payr_cntc_pnt_phn_no" /> </td>
		                <th width="40px">Fax<th>
		                <td width="170px"><input type="text" style="width:150px;" class="input2" name="payr_cntc_pnt_fax_no" value="<%=payr_cntc_pnt_fax_no %>" readonly id="payr_cntc_pnt_fax_no" /> </td>
		                <th width="40px">E-mail<th>
		                <td width="*"><input type="text" style="width:180px;" class="input2" name="payr_cntc_pnt_eml" value="<%=payr_cntc_pnt_eml %>" readonly id="payr_cntc_pnt_eml" /> </td>
	            	</tr>
				</table>
			</div>
		</div>
		<div class="opus_design_grid" id="mainTable2" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>