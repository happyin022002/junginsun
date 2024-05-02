<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3109.jsp
*@FileTitle  : Demand Note Issue by Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3109Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3109Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		// in loading page, Get data from server.
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

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc %>" id="session_ofc_cd" />
<input type="hidden" name="session_email" value="<%=strUsr_eml %>" id="session_email" />
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>" id="session_usr_nm" />
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>" id="session_usr_id" />
<input type="hidden" name="session_cnt_cd" value="<%=strCnt_cd %>" id="session_cnt_cd" />
<input type="hidden" name="tax_nm" id="tax_nm" />
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
<input type="hidden" name="vndr_cd" id="vndr_cd" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="rfa_no" id="rfa_no" />
<input type="hidden" name="chg_type" id="chg_type" />
<input type="hidden" name="ofc_cd" value="<%=strUsr_ofc %>" id="ofc_cd" />
<input type="hidden" name="svr_id" id="svr_id" />
<input type="hidden" name="usr_cnt_cd" id="usr_cnt_cd" />

<input type="hidden" name="cust_cntc_pnt_seq" id="cust_cntc_pnt_seq" />
<input type="hidden" name="dmdt_payr_cntc_pnt_nm" id="dmdt_payr_cntc_pnt_nm" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />

<input type="hidden" name="tax_rto" id="tax_rto" />
<input type="hidden" name="dmdt_chg_sts_cds" value="<%=dmdt_chg_sts_cds %>" id="dmdt_chg_sts_cds" />

<input type="hidden" name="call_to_rd_tp" value="booking" id="call_to_rd_tp" />

<input type="hidden" name="org_curr_cd" id="org_curr_cd" />
<input type="hidden" name="tot_org_amt" id="tot_org_amt" />
<input type="hidden" name="ex_rate" id="ex_rate" />
<input type="hidden" name="cntr_no" id="cntr_no" />

<!-- ETC  -->
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

<input type="hidden" name="vvd_nm" id="vvd_nm" />
<input type="hidden" name="arr" id="arr" />
<input type="hidden" name="dep" id="dep" />
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

<!-- rd hidden flag -->
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

<input type="hidden" name="tmp_payer_cd" id="tmp_payer_cd" />

<!-- India tax -->
<input type="hidden" name="ida_expn_tax_rt">
<input type="hidden" name="ida_expn_tax">
<input type="hidden" name="ida_edu_tax_rt">
<input type="hidden" name="ida_edu_tax">
<input type="hidden" name="ida_high_edu_tax_rt">
<input type="hidden" name="ida_high_edu_tax">
<input type="hidden" name="tax_rgst_no">
<input type="hidden" name="svc_cate_rmk"> 
<input type="hidden" name="pmnt_acct_no">

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

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Demand Note Issue - Booking</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_set" id="btn_set" type="button">Sheet  Set</button><!--
			--><button class="btn_normal" name="btn_option" id="btn_option" type="button">Sheet Option</button><!--
			--><button class="btn_normal" name="btn_sendinghistory" id="btn_sendinghistory" type="button">Sending History</button><!--
			--><button class="btn_normal" name="btn_preview" id="btn_preview" type="button">Preview</button><!--
			--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Demand Print</button><!--
			--><button class="btn_normal" name="btn_fax" id="btn_fax" type="button">Fax Send</button><!--
			--><button class="btn_normal" name="btn_email" id="btn_email" type="button">Email Send</button><!--
			--><button class="btn_normal" name="btn_payerfaxemail" id="btn_payerfaxemail" type="button">Payer  Info.</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="100" />				
					<col width="70" />				
					<col width="130" />				
					<col width="70" />				
					<col width="80" />				
					<col width="70" />	
					<col width="80" />				
					<col width="70" />	
					<col width="80" />
					<col width="70" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th>BKG No.</th>
						<td><input type="text" name="bkg_no" style="width:100px;" class="input2" readonly id="bkg_no" /></td>
						<th>B/L No. </th>
						<td><input type="text" name="bl_no" style="width:110px;" class="input2" readonly id="bl_no" /></td>
						<th>Tariff Type</th>
						<td><input type="text" name="dmdt_trf_cd" style="width:70px;" class="input2" readonly id="dmdt_trf_cd" /></td>
						<th>S/C No.</th>
						<td><input type="text" name="sc_no" style="width:80px;" class="input2" readonly id="sc_no" /></td>
						<td></td>
						<td></td>
			   		</tr>
			   		<tr>
			   			<th>VVD CD</th>
						<td><input type="text" name="vvd_cd" style="width:100px;" class="input2" value="" readonly id="vvd_cd" /> </td>
						<th>POR </th>
						<td><input type="text" name="por_cd" style="width:110px;" class="input2" value="" readonly id="por_cd" /> </td>
						<th>POL </th>
						<td><input type="text" name="pol_cd" style="width:70px;" class="input2" value="" readonly id="pol_cd" /> </td>
						<th>POD </th>
						<td><input type="text" name="pod_cd" style="width:80px;" class="input2" value="" readonly id="pod_cd" /> </td>
						<th>DEL </th>
						<td><input type="text" name="del_cd" style="width:70px;" class="input2" value="" readonly id="del_cd" /> </td>
						<th>R/D</th>
						<td><input type="text" name="rd" style="width:33px;" class="input2" value="" readonly id="rd" /> </td>
			   		</tr>
			   		<tr>
			   			<th>BKG Cust.</th>
						<td colspan="11"><input type="text" name="bkg_cust_cd" style="width:100px;" class="input2" value="" id="bkg_cust_cd" /><input type="text" name="bkg_cust_nm" style="width:441px;" class="input2" value="" readonly id="bkg_cust_nm" /> </td>
			   		</tr>		
			   		<tr>
			   			<th>A/R Cust.</th>
						<td colspan="11"><input type="text" name="act_cust_cd" style="width:100px;" class="input2" value="" id="act_cust_cd" /><input type="text" name="act_cust_nm" style="width:441px;" class="input2" value="" readonly id="act_cust_nm" /> </td>
			   		</tr>
			   		<tr>
						<th>Payer</th>
						<td colspan="11"><input type="text" name="payer_cd" style="width:76px;" dataformat="engup" class="input1" caption="Payer" maxlength="8" value="" onkeypress="ComKeyOnlyAlphabet('uppernum')" id="payer_cd" /><button type="button" id="btn_payer_cd" name="btn_payer_cd" class="input_seach_btn"></button><input type="text" name="payer_nm" style="width:437px;" class="input2" value="" readonly id="payer_nm" /> </td>
					</tr>
			   		<tr>
			   			<th>Attention</th>
						<td><script type="text/javascript">ComComboObject('combo1', 4, 150 , 1, 0, 0, true)</script></td>
						<th>Tel.</th>
						<td><input type="text" name="payr_cntc_pnt_phn_no" style="width:130px;" class="input2" value="" readonly id="payr_cntc_pnt_phn_no" /> </td>
						<th>Fax</th>
						<td><input type="text" name="payr_cntc_pnt_fax_no" style="width:112px;" class="input2" value="" readonly id="payr_cntc_pnt_fax_no" /> </td>
						<th>E-mail</th>
						<td colspan="5"><input type="text" name="payr_cntc_pnt_eml" style="width:220px;" class="input2" value="" readonly id="payr_cntc_pnt_eml" /> </td>
			   		</tr>	
			   		<tr>
			   			<th>Trucker</th>
						<td colspan="11"><input type="text" name="trucker_cd" maxlength="6" style="width:78px;" dataformat="engup" class="input" value="" caption="Trucker" id="trucker_cd" /><button type="button" id="btn_trucker_cd" name="btn_trucker_cd" class="input_seach_btn"></button><input type="text" name="trucker_nm" style="width:436px;" class="input2" value="" readonly id="trucker_nm" /></td>
			   		</tr>
			   		<tr style="height:7px"></tr>
			   </tbody>
			</table>
			<div class="layout_wrap" style="width:850px"  style="padding-top:10px">
			 	<div class="layout_vertical_2 pad_rgt_4">
			 		<div class="layout_wrap">
			 			<div class="layout_vertical_2" style="width:27%;">
			 			<h3 class="title_design" style="margin-bottom:1px">Charge</h3>
							<table>
								<colgroup>
									<col width="70" />				
									<col width="*" />				
							   </colgroup> 
							   <tbody>
							   		<tr>
							   			<th>Charge Cur.</th>
										<td><input type="text" name="chg_curr_cd" style="width:35px;text-align:right" class="input2" value="" readonly id="chg_curr_cd" /> </td>
							   		</tr>
							   </tbody>
							</table>
			 			</div>
			 			<div class="layout_vertical_2" style="width:73%;padding-top:13px">
			 				<table class="grid2 wAuto">
								<colgroup>
									<col width="70" />				
									<col width="*" />				
							   </colgroup> 
							   <tbody>
							   		<tr>
										<th>Incurred AMT</th>
										<td><input type="text" name="mn_org_chg_amt" style="text-align:right" class="input2" value="" readonly id="mn_org_chg_amt" /> </td>
									</tr>
									<tr>
										<th>Exception AMT</th>
										<td><input type="text" name="dmdt_expt_amt" style="text-align:right" class="input2" value="" readonly id="dmdt_expt_amt" /> </td>
									</tr>
									<tr>
										<th>Discount AMT</th>
										<td><input type="text" name="chg_dc_amt" style="text-align:right" class="input2" value="" readonly id="chg_dc_amt" /> </td>
									</tr>
									<tr>
										<th>Billable AMT</th>
										<td><input type="text" name="mn_bil_amt" style="text-align:right" class="input2" value="" readonly id="mn_bil_amt" /> </td>
									</tr>
									<tr>
										<th  id="txt_aft_inv_adj_amt" name="txt_aft_inv_adj_amt" >Adjusted AMT after INV</th>
										<td><input type="text" name="aft_inv_adj_amt" style="text-align:right" class="input2" value="" readonly id="aft_inv_adj_amt" /> </td>
									</tr>
							   </tbody>
							</table>
			 			</div>
			 		</div>
			 	</div>
			 	
			 	<div class="layout_vertical_2">
			 		<div class="layout_wrap">
			 			<div class="layout_vertical_2" style="width:35%;">
			 			<div class="opus_design_inquiry">
			 			<h3 class="title_design"  style="margin-bottom:1px">Invoice</h3>
			 				<table>
							   <colgroup>
									<col width="70" />				
									<col width="*" />				
							   </colgroup> 
							   <tbody>
							   		<tr>
										<th>INV Cur.</th>
										<td><select name="inv_curr_cd" style="width:80px;" class="input1" onchange="getExRate()"></select></td>
									</tr>
									<tr>
										<th>Ex. Rate</th>
										<td><input type="text" name="inv_xch_rt" style="width:80px;text-align:right" class="input2" value="" readonly id="inv_xch_rt" /></td>
									</tr>
									<tr>
										<th>CNTR Q’ty</th>
										<td><input type="text" name="cntr_cnt" style="width:80px;text-align:right" class="input2" value="" readonly id="cntr_cnt" /></td>
									</tr>
							  	</tbody>
							</table>
						</div>
						</div>
						<div class="layout_vertical_2" style="width:65%;padding-top:13px">
			 				<table class="grid2 wAuto">
								<colgroup>
									<col width="70" />				
									<col width="*" />				
							   	</colgroup> 
						   		<tr>
									<th>Total AMT</th>
									<td><input type="text" name="tot_amt" style="width:201px;text-align:right" value="" readonly id="tot_amt" /> </td>
								</tr>
								<tr>
									<th> D/C by AMT or %</th>
									<td><input type="text" name="dc_amt" style="width:201px;text-align:right" value="" readonly id="dc_amt" /> </td>
								</tr>
								<tr>
									<th> Billing AMT </th>
									<td><input type="text" name="inv_chg_amt" style="width:201px;text-align:right" value="" readonly id="inv_chg_amt" /> </td>
								</tr>
								<tr>
									<th> Tax Rate/ AMT </th>
									<td><!--
									--><input type="checkbox" name="chk_tax" value="" class="trans" onclick="setTax();" id="chk_tax" /><!--
									--><input type="text" name="tax_rto_dis" style="width:50px;text-align:right" class="input2" value="" id="tax_rto_dis" readonly /><!--
									--><input type="text" name="tax_amt" style="width:134px;text-align:right" class="input2;wAuto" value="" readonly id="tax_amt" />
									</td>
								</tr>
								<tr>
									<th> Payable AMT </th>
									<td><input type="text" name="inv_amt" style="width:201px;text-align:right" class="input2" value="" readonly id="inv_amt" /> </td>
								</tr>
							</table>
						</div>
			 		</div>
			 	</div>
			</div>
		</div>
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>	
		
		<!-- RD OBJECT -->		
	</div>
</div>

</form>