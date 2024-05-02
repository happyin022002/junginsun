<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3007.jsp
*@FileTitle  : Demand Note Issue Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3007Event"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event.EES_DMT_3007HTMLAction"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDmt3007Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.DMTInvoiceMgt.demandnotesend");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		strCnt_cd 	= account.getCnt_cd();
		strUsr_eml 	= account.getUsr_eml();

		event = (EesDmt3007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    function setupPage(){
        loadPage();     
    }
</script>

<form method="post" name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc %>" id="session_ofc_cd" />
<input type="hidden" name="session_email" value="<%=strUsr_eml %>" id="session_email" />
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>" id="session_usr_nm" />
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>" id="session_usr_id" />
<!-- country code -->
<input type="hidden" name="tax_nm" id="tax_nm" />

<!-- Calling type of  group/booking -->
<input type="hidden" name="call_to_rd_tp" id="call_to_rd_tp" />
<!-- Demand Note Issue Preview - Group -->
<!-- data of Parents screen  -->
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" />
<input type="hidden" name="dmdt_chg_sts_cd" id="dmdt_chg_sts_cd" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="payer_cd" id="payer_cd" />
<input type="hidden" name="tmp_payer_cd" id="tmp_payer_cd" />
<input type="hidden" name="payer_nm" id="payer_nm" />

<input type="hidden" name="org_curr_cd" id="org_curr_cd" />
<input type="hidden" name="inv_curr_cd" id="inv_curr_cd" />
<input type="hidden" name="ex_rate" id="ex_rate" />
<input type="hidden" name="tot_org_amt" id="tot_org_amt" />
<input type="hidden" name="tot_dc_amt" id="tot_dc_amt" />
<input type="hidden" name="tot_bil_amt" id="tot_bil_amt" />
<input type="hidden" name="tot_tax_amt" id="tot_tax_amt" />
<input type="hidden" name="tot_payable_amt" id="tot_payable_amt" />
<input type="hidden" name="tax_rto_dis" id="tax_rto_dis" />
<!-- ETC -->
<input type="hidden" name="cust_vat" id="cust_vat" />
<input type="hidden" name="ofc_add01" id="ofc_add01" />
<input type="hidden" name="ofc_add02" id="ofc_add02" />
<input type="hidden" name="ofc_add03" id="ofc_add03" />
<input type="hidden" name="cust_nm" id="cust_nm" />
<input type="hidden" name="address01" id="address01" />
<input type="hidden" name="address02" id="address02" />
<input type="hidden" name="address03" id="address03" />
<input type="hidden" name="address04" id="address04" />
<input type="hidden" name="header01" id="header01" />
<input type="hidden" name="header02" id="header02" />
<input type="hidden" name="header03" id="header03" />
<input type="hidden" name="header04" id="header04" />
<input type="hidden" name="header05" id="header05" />
<input type="hidden" name="header06" id="header06" />
<input type="hidden" name="header07" id="header07" />
<input type="hidden" name="header08" id="header08" />
<input type="hidden" name="header09" id="header09" />
<input type="hidden" name="header10" id="header10" />
<input type="hidden" name="sh_num" id="sh_num" />
<input type="hidden" name="com_ref" id="com_ref" />
<input type="hidden" name="print_date" id="print_date" />
<input type="hidden" name="dmdt_trf_nm" id="dmdt_trf_nm" />

<!-- Demand Note Issue Preview - Booking -->
<!--  data of Parents screen -->
<input type="hidden" name="tot_amt" id="tot_amt" />
<input type="hidden" name="dc_amt" id="dc_amt" />
<input type="hidden" name="inv_chg_amt" id="inv_chg_amt" />
<!-- <input type="hidden" name="tax_rto_dis"> -->
<input type="hidden" name="tax_amt" id="tax_amt" />
<input type="hidden" name="inv_amt" id="inv_amt" />
<!-- ETC  -->
<input type="hidden" name="sheet_remark01" id="sheet_remark01" />
<input type="hidden" name="sheet_remark02" id="sheet_remark02" />
<input type="hidden" name="sheet_remark03" id="sheet_remark03" />
<input type="hidden" name="sheet_remark04" id="sheet_remark04" />
<input type="hidden" name="sheet_remark05" id="sheet_remark05" />
<input type="hidden" name="sheet_remark06" id="sheet_remark06" />
<input type="hidden" name="sheet_remark07" id="sheet_remark07" />
<input type="hidden" name="sheet_remark08" id="sheet_remark08" />
<input type="hidden" name="sheet_remark09" id="sheet_remark09" />
<input type="hidden" name="sheet_remark10" id="sheet_remark10" />
<input type="hidden" name="sheet_remark11" id="sheet_remark11" />
<input type="hidden" name="sheet_remark12" id="sheet_remark12" />
<input type="hidden" name="sheet_remark13" id="sheet_remark13" />
<input type="hidden" name="sheet_remark14" id="sheet_remark14" />

<input type="hidden" name="vvd_cd" id="vvd_cd" />
<input type="hidden" name="vvd_nm" id="vvd_nm" />
<input type="hidden" name="arr" id="arr" />
<input type="hidden" name="dep" id="dep" />
<input type="hidden" name="bl_no" id="bl_no" />
<input type="hidden" name="cmdt_cd" id="cmdt_cd" />
<input type="hidden" name="cmdt_nm" id="cmdt_nm" />
<input type="hidden" name="bkg_rcv_term_cd" id="bkg_rcv_term_cd" />
<input type="hidden" name="bkg_rcv_term_nm" id="bkg_rcv_term_nm" />
<input type="hidden" name="bkg_del_term_cd" id="bkg_del_term_cd" />
<input type="hidden" name="bkg_del_term_nm" id="bkg_del_term_nm" />
<input type="hidden" name="pod" id="pod" />
<input type="hidden" name="pod_nm" id="pod_nm" />
<input type="hidden" name="del" id="del" />
<input type="hidden" name="del_nm" id="del_nm" />
<input type="hidden" name="trucker" id="trucker" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />

<!-- rd hidden  flag -->
<input type="hidden" name="bil_to_loc_div_cd" id="bil_to_loc_div_cd" />
<input type="hidden" name="cust_ref_prn_flg" id="cust_ref_prn_flg" />
<input type="hidden" name="phn_fax_prn_flg" id="phn_fax_prn_flg" />
<input type="hidden" name="cust_vat_prn_flg" id="cust_vat_prn_flg" />
<input type="hidden" name="tax_amt_prn_flg" id="tax_amt_prn_flg" />

<input type="hidden" name="dc_amt_prn_flg" id="dc_amt_prn_flg" />
<input type="hidden" name="title" id="title" />
<!-- PAYER INFO FAX,EMAIL SETTING -->
<input type="hidden" name="payr_faxnos" id="payr_faxnos" />
<input type="hidden" name="payr_emailnos" id="payr_emailnos" />
<!-- rd data set -->
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

<!-- india tax-->
<input type="hidden" name="rd_usr_cnt_cd" id="rd_usr_cnt_cd" />
<input type="hidden" name="rd_ida_expn_tax_rt" id="rd_ida_expn_tax_rt" />
<input type="hidden" name="rd_ida_expn_tax" id="rd_ida_expn_tax" />
<input type="hidden" name="rd_ida_edu_tax_rt" id="rd_ida_edu_tax_rt" />
<input type="hidden" name="rd_ida_edu_tax" id="rd_ida_edu_tax" />
<input type="hidden" name="rd_ida_high_edu_tax_rt" id="rd_ida_high_edu_tax_rt" />
<input type="hidden" name="rd_ida_high_edu_tax" id="rd_ida_high_edu_tax" />
<input type="hidden" name="rd_tax_rgst_no" id="rd_tax_rgst_no" />
<input type="hidden" name="rd_svc_cate_rmk" id="rd_svc_cate_rmk" />
<input type="hidden" name="rd_pmnt_acct_no" id="rd_pmnt_acct_no" />

	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Demand Note Issue Preview</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_print" 	 id="btn_print">Demand Print</button><!--
				--><button type="button" class="btn_normal" name="btn_fax" 	 id="btn_fax">Fax Send</button><!--
				--><button type="button" class="btn_normal" name="btn_email" id="btn_email">Email Send</button><!--
				--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
		
	<!-- opus_design_grid(S) -->
	<div class="layer_popup_contents">	
		<div class="wrap_result">
			<div class="opus_design_RD" style="height:88%!important">
			<script  type="text/javascript">rdViewerObject();</script>
			</div>
			 <div style="position:relative;top:88%">
				<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
					<table> 
						<tr>
							<th width="30">Attention</th>
							<td width="150"><input type="text" name="dmdt_payr_cntc_pnt_nm" style="width:140px;" class="input2" value="" id="dmdt_payr_cntc_pnt_nm" /> </td>
							<th width="30">Tel.</th>
							<td width="160"><input type="text" name="payr_cntc_pnt_phn_no" style="width:150px;" class="input2" value="" id="payr_cntc_pnt_phn_no" /> </td>
							<th width="30">Fax</th>
							<td width="160"><input type="text" name="payr_cntc_pnt_fax_no" style="width:150px;" class="input2" value="" id="payr_cntc_pnt_fax_no" /> </td>
							<th width="40">E-mail</th>
							<td><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" value="" id="payr_cntc_pnt_eml" /> </td>					
						</tr>	
				</table>
			</div>
			<div class="opus_design_grid" style="display:none">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<div class="opus_design_grid" style="display:none">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->	
</form>		