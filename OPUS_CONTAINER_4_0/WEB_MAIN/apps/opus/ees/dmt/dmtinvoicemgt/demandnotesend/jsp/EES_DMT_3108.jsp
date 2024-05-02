<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3108.jsp
*@FileTitle  : Demand Note Issue by Group
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
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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
	String ofcCd 			= "";
	String dmdtTrfCd 		= "";
	String dmdtChgStsCds	= "";
	String dmdtChgStsCds2	= "";
	String bkgNo 			= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		strCnt_cd 	= account.getCnt_cd();
		strUsr_eml 	= account.getUsr_eml();


		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		ofcCd				= JSPUtil.getParameter(request,"ofc_cd");
		dmdtTrfCd			= JSPUtil.getParameter(request,"dmdt_trf_cd");
		dmdtChgStsCds		= JSPUtil.getParameter(request,"dmdt_chg_sts_cd");   //name
		dmdtChgStsCds2		= JSPUtil.getParameter(request,"dmdt_chg_sts_cd_2"); //code
		//bkgNo				= JSPUtil.getParameter(request,"bkg_no");
		
		//invoice_issue	= JSPUtil.getParameter(request,"invoice_issue");	//1:before, 2:after
		//s_invoice_no	= JSPUtil.getParameter(request,"dmdt_inv_no");
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
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
<input type="hidden" name="tax_rto" id="tax_rto" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="s_ofc_cd" value="<%=ofcCd %>" id="s_ofc_cd" />
<input type="hidden" name="ofc_cd" value="<%=ofcCd %>" id="ofc_cd" />
<input type="hidden" name="chrg_ofc_cd" value="<%=ofcCd %>" id="chrg_ofc_cd" />
<input type="hidden" name="s_dmdt_trf_cd" value="<%=dmdtTrfCd %>" id="s_dmdt_trf_cd" />
<input type="hidden" name="dmdt_trf_cd" value="<%=dmdtTrfCd %>" id="dmdt_trf_cd" />
<input type="hidden" name="s_dmdt_chg_sts_cd2" value="<%=dmdtChgStsCds %>" id="s_dmdt_chg_sts_cd2" />
<input type="hidden" name="dmdt_chg_sts_cds" value="<%=dmdtChgStsCds2 %>" id="dmdt_chg_sts_cds" />
<input type="hidden" name="dmdt_chg_sts_cd" value="<%=dmdtChgStsCds2 %>" id="dmdt_chg_sts_cd" />
<input type="hidden" name="s_bkg_no" value="<%=bkgNo %>" id="s_bkg_no" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="usr_cnt_cd" id="usr_cnt_cd" />
<input type="hidden" name="s_cust_gubun" id="s_cust_gubun" />
<input type="hidden" name="s_cust_cd" id="s_cust_cd" />
<input type="hidden" name="s_cust_name" id="s_cust_name" />
<input type="hidden" name="payr_faxnos" id="payr_faxnos" />
<input type="hidden" name="payr_emailnos" id="payr_emailnos" />
<input type="hidden" name="cust_cntc_pnt_seq" id="cust_cntc_pnt_seq" />
<input type="hidden" name="dmdt_payr_cntc_pnt_nm" id="dmdt_payr_cntc_pnt_nm" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="call_to_rd_tp" value="group" id="call_to_rd_tp" />
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
<input type="hidden" name="tot_amt" id="tot_amt" />
<input type="hidden" name="dc_amt" id="dc_amt" />
<input type="hidden" name="inv_chg_amt" id="inv_chg_amt" />
<input type="hidden" name="tax_amt" id="tax_amt" />
<input type="hidden" name="inv_amt" id="inv_amt" />
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
<!--  input type="hidden" name="bkg_no"> -->
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
<!-- rd hidden handling flag -->
<input type="hidden" name="bil_to_loc_div_cd" id="bil_to_loc_div_cd" />
<input type="hidden" name="cust_ref_prn_flg" id="cust_ref_prn_flg" />
<input type="hidden" name="phn_fax_prn_flg" id="phn_fax_prn_flg" />
<input type="hidden" name="cust_vat_prn_flg" id="cust_vat_prn_flg" />
<input type="hidden" name="tax_amt_prn_flg" id="tax_amt_prn_flg" />
<input type="hidden" name="dc_amt_prn_flg" id="dc_amt_prn_flg" />
<input type="hidden" name="title" id="title" />

<input type="hidden" name="tmp_payer_cd" id="tmp_payer_cd" />

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
<!-- rd data set //-->

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

<!-- <div class="layer_popup_title"> -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Demand Note Issue - Group</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_set" 	id="btn_set">Sheet  Set</button><!--
			--><button type="button" class="btn_normal" name="btn_option" 		id="btn_option">Sheet Option</button><!--
			--><button type="button" class="btn_normal" name="btn_sendinghistory"  		id="btn_sendinghistory">Sending History</button><!--
	  		--><button type="button" class="btn_accent" name="btn_preview" 	id="btn_preview">Preview</button><!--
			--><button type="button" class="btn_normal" name="btn_print" 		id="btn_print">Demand Print</button><!--
			--><button type="button" class="btn_normal" name="btn_fax"  		id="btn_fax">Fax Send</button><!-- 
			--><button type="button" class="btn_normal" name="btn_email" 		id="btn_email">Email Send</button><!--
			--><button type="button" class="btn_normal" name="btn_payerfaxemail" 		id="btn_payerfaxemail">Payer  Info</button><!--
			--><button type="button" class="btn_normal" name="btn_down_excel" 		id="btn_down_excel">Down Excel</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>

	
<!-- <div class="layer_popup_contents"> -->	
	<!-- layer_popup_title(E) -->
	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="40"/>
						<col width="120"/>
						<col width="80"/>
						<col width="120"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Office  </th>
						<td><input type="text" style="width:100px;;" class="input2" value="<%=ofcCd %>" /> </td>
						<th>Tariff Type</th>
						<td><input type="text" style="width:100px;;" class="input2" value="<%=dmdtTrfCd %>" /> </td>
						<th>Status</th>
						<td><input type="text" style="width:100%;" class="input2" value="<%=dmdtChgStsCds %>" /> </td>
					</tr>	
					
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	
		<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry" style="height:0px">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="160"/>
						<col width="80"/>
						<col width="170"/>
						<col width="80"/>
						<col width="220"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<td colspan="2"><h3 class="title_design">Selected Total</h3></td>
						<th>INV Cur.</th>
						<td colspan="5"><input type="text" name="inv_curr_cd" style="width:40px;text-align:center;" class="input2" value="" readonly id="inv_curr_cd" /> </td>
					</tr>	
					<tr>
						<th>CNTR Q'ty</th>
						<td><input type="text" name="cntr_qty" style="width:77px;text-align:right;" class="input2" value="" readonly id="cntr_qty" /> </td>
						<th>Billing AMT</th>
						<td><input type="text" name="tot_bil_amt" style="width:150px;text-align:right;" class="input2" value="" readonly id="tot_bil_amt" /> </td>
						<th>Tax Rate/AMT</th>
						<td><input type="checkbox" name="chk_tax_rto" value="" readonly class="trans" onclick="setTax();" id="chk_tax_rto" /><input type="text" name="tax_rto_dis" style="width:50px;text-align:center;" class="input2" value="" readonly id="tax_rto_dis" /><b>%</b><!-- 
						 	--><input type="text" name="tot_tax_amt" style="width:155px;text-align:right;" class="input2" value="" readonly id="tot_tax_amt" /></td>
						<th>INV AMT</th>
						<td><input type="text" name="tot_payable_amt" style="width:100%;text-align:right;" class="input2" value="" readonly id="tot_payable_amt" /> </td>
					</tr>
					<tr>
						<th>Payer</th>
						<td colspan="7"><input type="text" name="payer_cd" style="width:78px;" dataformat="engup" caption="Payer_cd" maxlength="8" class="input1" value="" onkeypress="ComKeyOnlyAlphabet('uppernum')" id="payer_cd" /><!-- 
						 --><button type="button" id="btn_payer_cd" name="btn_payer_cd" class="input_seach_btn"></button><!-- 
						 --><input type="text" name="payer_nm" style="width:618px;" class="input2" value="" readonly id="payer_nm" /></td>
					</tr>
					<tr>
							<th>Attention</th>
							<td><script  type="text/javascript">ComComboObject('combo1', 4, 152 , 1, 0, 0, true)</script></td>
							<th>Tel.</th>
							<td><input type="text" name="payr_cntc_pnt_phn_no" style="width:150px;" class="input2" value="" readonly id="payr_cntc_pnt_phn_no" /> </td>
							<th>Fax</th>
							<td><input type="text" name="payr_cntc_pnt_fax_no" style="width:233px;" class="input2" value="" readonly id="payr_cntc_pnt_fax_no" /> </td>
							<th>E-mail</th>
							<td><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" value="" readonly id="payr_cntc_pnt_eml" /> </td>	
					</tr>	
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result" style="display:none;height:0px">
		<div class="opus_design_grid clear">
			<script  type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>

	<div  id="topdeck" name="topdeck" style="position:absolute;visibility:hidden;z-index:200;height:0px;"></div>

<!-- </div> -->

</form>