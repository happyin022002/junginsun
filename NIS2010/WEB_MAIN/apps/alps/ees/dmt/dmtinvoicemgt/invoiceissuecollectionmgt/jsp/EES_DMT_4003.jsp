<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4003.jsp
*@FileTitle : Invoice Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 김태균
*@LastVersion : 1.0 
* 2009.09.11 김태균
* 1.0 최초 생성 
* 2011.11.09 권   민 [CHM-201114143] [DMT] Manual Invoice with no detail 조건의 Print Preview 개발 
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4003Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%
	
	Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
    
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
	
	String inv_new_rpt_flg      = "";
	String cond_ida_sac_cd      = "";
	
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strOfc_cd	= account.getOfc_cd();
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
	
	inv_new_rpt_flg         = JSPUtil.getParameter(request,"inv_new_rpt_flg");
	cond_ida_sac_cd         = JSPUtil.getParameter(request,"cond_ida_sac_cd");
	
	String mrd_path = "";
    
    //apps\alps\ees\dmt\dmtinvoicemgt\invoiceissuecollectionmgt\report
    if (invoice_LR.equals("L")) {
    	if (inc_cntr_dtail.equals("N")) {
        	if (cre_cnt_cd.equals("IN")) {
        		// india office 전용 2012.05.18	
        		mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4914.mrd";
        	}
        	/*
        	else if (cre_cnt_cd.equals("MY") && inv_new_rpt_flg.equals("Y")) {
            	mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4918.mrd";
        	}
        	*/
        	else {
    		    mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
        	}
    	}
    	else {
    		//if(rhq_ofc_cd.equals("HAMRU")){
    		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
    		if (cre_ofc_cd.equals("ANRSO")||cre_ofc_cd.equals("HAMSC")||cre_ofc_cd.equals("LEHSC")||cre_ofc_cd.equals("PRGSC")||cre_ofc_cd.equals("RTMSC")) {		
    			mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4910.mrd";
    		}
    		else {
    			if (cre_cnt_cd.equals("IN")) {
            		// india office 전용 2012.05.18	
            		mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";	
        		}
        		/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
        		else if (cre_cnt_cd.equals("MY") && inv_new_rpt_flg.equals("Y")) {
            		mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4916.mrd";
    			}
    			*/
    			else {
    		        mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
    			}    
    		}   
    	}
    		
    }
    else if (invoice_LR.equals("R")) {
    	if (inc_cntr_dtail.equals("N")) {
         	if (cre_cnt_cd.equals("IN")) {
        		// india office 전용 2012.05.18
        	  	 mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4915.mrd";
    		}
    		/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
    		else if (cre_cnt_cd.equals("MY") && inv_new_rpt_flg.equals("Y")) {
        		 mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4919.mrd";
        	}
        	*/
        	else {
    		     mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4909.mrd";
        	}     
    	}
    	else {
    		//if(rhq_ofc_cd.equals("HAMRU")){
    		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
    		if (cre_ofc_cd.equals("ANRSO")||cre_ofc_cd.equals("HAMSC")||cre_ofc_cd.equals("LEHSC")||cre_ofc_cd.equals("PRGSC")||cre_ofc_cd.equals("RTMSC")) {		
    			mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4911.mrd";
    		}
    		else {
     			if (cre_cnt_cd.equals("IN")) {
            		// india office 전용 2012.05.18
            	  	 mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4913.mrd";
        		}
        		/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
        		else if (cre_cnt_cd.equals("MY") && inv_new_rpt_flg.equals("Y")) {
           		 	 mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4917.mrd";
            	}
            	*/
            	else {
    		         mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4902.mrd";
            	}     
    		}
    	}

    }
    else {
    	if (inc_cntr_dtail.equals("N")) {
    		if (cre_cnt_cd.equals("IN")) {
        		// india office 전용 2012.05.18	
        		mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4914.mrd";
    		}
    		/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
    		else if (cre_cnt_cd.equals("MY") && inv_new_rpt_flg.equals("Y")) {
      		 	mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4918.mrd";
        	}
        	*/
        	else {
      		    mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4908.mrd";
        	}    
    	}
    	else {
    		//if(rhq_ofc_cd.equals("HAMRU")){
    		// RHQ 기중에서  특정 Office로 변경됨. 2012.01.11
    		if (cre_ofc_cd.equals("ANRSO")||cre_ofc_cd.equals("HAMSC")||cre_ofc_cd.equals("LEHSC")||cre_ofc_cd.equals("PRGSC")||cre_ofc_cd.equals("RTMSC")) {
       			mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4910.mrd";
    		}
    		else {
    			if (cre_cnt_cd.equals("IN")) {
            		// india office 전용 2012.05.18	
            		mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4912.mrd";	
        		}
        		/* 2017.04.11 수정요청:PREVIEW 와 INV PRINT 동일한 RD 문서를 사용하도록 요청함.(박경문대리)
        		else if (cre_cnt_cd.equals("MY") && inv_new_rpt_flg.equals("Y")) {
          		 	mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4916.mrd";
    			}
    			*/
    			else {
    		        mrd_path="apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4901.mrd";
    			}    
    		}
    	}
       		
    }
    
    //String mrd_param = "/rv cntr_no["+cntrNo+"] st_evnt_dt["+stEvntDt+"] ed_evnt_dt["+edEvntDt+"]";
    //조건에 따라 Where 절을 컨트롤 할 수 있는 동적 쿼리를 만들기 위해서는 반드시 /rp 방식을 사용해야 한다.rv방식은 ##인식못한다.
    //String mrd_param = "/rp ["+invoice_no+"]";
    //String param = new String(C.process(mrd_param, type));
%>

<html>
<head>
<title>Invoice Issue Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    function setupPage(){
	    loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="mrd"					value="<%=mrd_path %>">
<input type="hidden" name="invoice_no"			value="<%=invoice_no %>">
<input type="hidden" name="cre_ofc_cd"			value="<%=cre_ofc_cd %>">
<input type="hidden" name="payer_cd"			value="<%=payer_cd %>">
<input type="hidden" name="pod_cd"				value="<%=pod_cd %>">
<input type="hidden" name="dmdt_trf_cd"			value="<%=dmdt_trf_cd %>">
<input type="hidden" name="bkg_no"				value="<%=bkg_no %>">
<input type="hidden" name="bl_no"				value="<%=bl_no %>">
<input type="hidden" name="invoice_LR"			value="<%=invoice_LR %>">
<input type="hidden" name="session_ofc_cd"		value="<%=strOfc_cd%>">
<input type="hidden" name="session_email"		value="<%=strUsr_eml%>">
<input type="hidden" name="session_usr_nm"		value="<%=strUsr_nm%>">
<input type="hidden" name="session_usr_id"		value="<%=strUsr_id%>">
<input type="hidden" name="bil_to_loc_div_cd"	value="<%=invoice_LR %>">

<input type="hidden" name="inc_cntr_dtail"	 value="<%=inc_cntr_dtail %>">

<input  type="hidden" name="rhq_ofc_cd"		 value="<%=rhq_ofc_cd %>">
<input  type="hidden" name="cre_cnt_cd"      value="<%=cre_cnt_cd%>">

<input  type="hidden" name="inv_new_rpt_flg" value="<%=inv_new_rpt_flg%>">
<input  type="hidden" name="cond_ida_sac_cd" value="<%=cond_ida_sac_cd%>">

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
<input type="hidden" name="act_payr_cust_nm">

<input type="hidden" name="jspno" value="<%=jspno %>"> 
<input type="hidden" name="ofc_cd">
<input type="hidden" name="has_sheetset">
<input type="hidden" name="dmdt_sh_tp_cd">

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

<!-- 인도 TAX RATIO 변경 전 필드 -->
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
<!-- 인도 TAX RATIO 변경 후 필드 ( 2017.07.26 ) -->
<input type="hidden" name="rd_ida_tax_appl_tm">
<input type="hidden" name="rd_ida_cgst_rto">
<input type="hidden" name="rd_ida_cgst_amt">
<input type="hidden" name="rd_ida_sgst_rto">
<input type="hidden" name="rd_ida_sgst_amt">
<input type="hidden" name="rd_ida_igst_rto">
<input type="hidden" name="rd_ida_igst_amt">
<input type="hidden" name="rd_ida_ugst_rto">
<input type="hidden" name="rd_ida_ugst_amt">
<!-- 인도 TAX 공통 -->
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

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Issue Preview</td></tr>
	</table>
	<!-- : ( Title ) (E) -->

	
	
		<table class="search">
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table border="1" style="width:100%;" height="545" class="grid"> 
				<tr><td><script language='javascript'>comRdObject('rd_invoice');</script></td></tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr>
						<td width="60">Attention</td>
						<td width="180"><input type="text" name="dmdt_payr_cntc_pnt_nm" style="width:150;" class="input2" readOnly></td>
						<td width="25">Tel.</td>
						<td width="180"><input type="text" name="payr_cntc_pnt_phn_no" style="width:150;" class="input2" value="<%=payr_cntc_pnt_phn_no %>" readOnly></td>
						<td width="25">Fax</td>
						<td width="180"><input type="text" name="payr_cntc_pnt_fax_no"  style="width:150;" class="input2" value="<%=payr_cntc_pnt_fax_no %>" readOnly></td>
						<td width="40">E-mail</td>
						<td width=""><input type="text" name="payr_cntc_pnt_eml"  style="width:200;" class="input2" value="<%=payr_cntc_pnt_eml %>" readOnly></td>						
					</tr>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	<!-- Tab BG Box  (S) -->
	<table class="height_5"><tr><td></td></tr></table>		
			</td></tr>
		</table>
	<!--biz page (E)-->
	
	<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->	
	
</td></tr>
</table>
<table width="100%"  id="mainTable" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet1');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>
</form>
</body>
</html>
