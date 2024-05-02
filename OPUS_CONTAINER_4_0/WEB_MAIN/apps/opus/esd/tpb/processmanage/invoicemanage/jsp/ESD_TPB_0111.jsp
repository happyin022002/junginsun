<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0111.jsp
*@FileTitle  : Invoice Revision
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0111Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	response.setHeader("expires", "-1"); 
	response.setHeader("pragma", "no-cache"); 
	response.setHeader("cache-control", "no-cache");
%>
<%
	GeneralEventResponse eventResponse = null;
	EsdTpb0111Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	Map<String,String> rowSet = null;
	Map<String,String> rowSetOtsGrpInfo = null;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.InvoiceManage");

	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";

	String s_length_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("s_length_n3pty_bil_tp_cd")).trim();
	int s_length_n3pty_bil_tp_cd_int = 1;    //Sheet Maxinum count
	try {
		s_length_n3pty_bil_tp_cd_int = Integer.parseInt(s_length_n3pty_bil_tp_cd);
	}catch(Exception e) {
		s_length_n3pty_bil_tp_cd_int = 1;
	}

	String ida_tax_seq = JSPUtil.getNull(request.getParameter("s_ida_tax_seq"));

	String s_detail_n3pty_no = JSPUtil.getNull(request.getParameter("s_detail_n3pty_no"));
	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code"));
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd"));
	String s_correction_yn = JSPUtil.getNull(request.getParameter("s_correction_yn"));
	String s_inquiryOnly_yn = JSPUtil.getNull(request.getParameter("s_inquiryOnly_yn"));
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");

	String s_n3pty_inv_no = JSPUtil.getNull(request.getParameter("s_n3pty_inv_no"));
	String s_n3pty_inv_rmd_cd = JSPUtil.getNull(request.getParameter("s_n3pty_inv_rmd_cd"));
	String s_n3pty_inv_his_seq = JSPUtil.getNull(request.getParameter("s_n3pty_inv_his_seq"));
	String s_n3pty_ofc_cd = JSPUtil.getNull(request.getParameter("s_n3pty_ofc_cd"));
	String s_cnt_cd = JSPUtil.getNull(request.getParameter("s_cnt_cd"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

		event = (EsdTpb0111Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

			// Add logic information data from the server when loading the initial screen
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

			if (eventResponse != null) {
				rowSet = eventResponse.getETCData();
				if(rowSet != null){
					rowCount = eventResponse.getDataCntList().size();
				} // end if
				rowSetOtsGrpInfo = eventResponse.getETCData();

				if (eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
					s_length_n3pty_bil_tp_cd_int = Integer.parseInt(rowSetOtsGrpInfo.get("length_n3pty_bil_tp_cd"));
				}
				//log.debug("s_length_n3pty_bil_tp_cd_int====>"+s_length_n3pty_bil_tp_cd_int);
			}
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	if (s_n3pty_inv_no.trim().length() == 0 ) {
		s_length_n3pty_bil_tp_cd_int = 0;
	}

	if ( s_n3pty_ofc_cd.trim().length() >  0 ) {
		ofc_cd = s_n3pty_ofc_cd;
	}

	if ( s_cnt_cd.trim().length() >  0 ) {
		cnt_cd = s_cnt_cd;
	}

	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
	boolean isHAMURs = false;
	if ( !"".equals(rhq_cd) && OfficeCodeMgr.checkContainOfficeCode("000006","TPB",rhq_cd) ){
		isHAMURs = true;
	}

%>

<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00582", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
<style>
.wrap {
    min-width: 1247px;
    height:100%;
    padding-top:89px;
}
</style>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="load_num" value="0" id="load_num" />
<input type="hidden" name="s_dao_n3pty_bil_tp_cd" id="s_dao_n3pty_bil_tp_cd" />
<input type="hidden" name="s_trd_party_code" value="<%=s_trd_party_code%>" id="s_trd_party_code" />
<input type="hidden" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>" id="s_h_vndr_cust_div_cd" />
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-mm-dd") %>" id="sdate" />
<input type="hidden" name="edate" value="<%=currentDay%>" id="edate" />
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="<%=s_length_n3pty_bil_tp_cd_int%>" id="s_length_n3pty_bil_tp_cd" />
<input type="hidden" name="s_vndr_cnt_cd" id="s_vndr_cnt_cd" />
<input type="hidden" name="s_vndr_seq" id="s_vndr_seq" />
<input type="hidden" name="s_cust_cnt_cd" id="s_cust_cnt_cd" />
<input type="hidden" name="s_cust_seq" id="s_cust_seq" />
<input type="hidden" name="s_n3pty_ofc_cd" id="s_n3pty_ofc_cd" />
<input type="hidden" name="s_trd_party_nm" id="s_trd_party_nm" />
<input type="hidden" name="s_sum_inv_amt" id="s_sum_inv_amt" />
<input type="hidden" name="s_phn_no" id="s_phn_no" />
<!-- <input type="hidden" name="s_vndr_cust_addr"> -->
<!-- <input type="hidden" name="s_vndr_cust_nm"> -->
<input type="hidden" name="s_inv_rmk1" id="s_inv_rmk1" />
<input type="hidden" name="s_inv_rmk2" id="s_inv_rmk2" />
<input type="hidden" name="s_bil_loc" id="s_bil_loc" />
<input type="hidden" name="s_clt_agn_rmk" id="s_clt_agn_rmk" />
<input type="hidden" name="s_his_seq" id="s_his_seq" />
<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>" id="s_ofc_cd" />
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>" id="s_rhq_cd" />
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>" id="s_cnt_cd" />

<input type="hidden" name="s_detail_n3pty_no" value="<%=s_detail_n3pty_no%>" id="s_detail_n3pty_no" />
<input type="hidden" name="s_detail_ots_sts_cd" id="s_detail_ots_sts_cd" />
<input type="hidden" name="s_vndr_cust_eml" id="s_vndr_cust_eml" />
<input type="hidden" name="s_final_flg" id="s_final_flg" />
<input type="hidden" name="s_vat_xch_rt" id="s_vat_xch_rt" />
<input type="hidden" name="s_france" id="s_france" />
<input type="hidden" name="s_from_curr_cd" id="s_from_curr_cd" />

<input type="hidden" name="s_n3pty_inv_his_seq" value="<%=s_n3pty_inv_his_seq%>" id="s_n3pty_inv_his_seq" />
<input type="hidden" name="s_same_version_yn" value="N" id="s_same_version_yn" />
<input type="hidden" name="s_inv_iss_rhq_cd" value="" id="s_inv_iss_rhq_cd" />
<input type="hidden" name="s_n3pty_inv_sts_cd" value="" id="s_n3pty_inv_sts_cd" />
<input type="hidden" name="erpif_yn" value="N" id="erpif_yn" />

<input type="hidden" name="s_correction_yn" value="<%=s_correction_yn%>" id="s_correction_yn" />
<input type="hidden" name="s_inquiryOnly_yn" value="<%=s_inquiryOnly_yn%>" id="s_inquiryOnly_yn" />
<input type="hidden" name="s_invoice_cancel_remark" value="" id="s_invoice_cancel_remark" />

<input type="hidden" name="prcs_cnt" id="prcs_cnt" />

<input type="hidden" name="org_due_date" id="org_due_date" />
<input type="hidden" name="org_adm_chrg" id="org_adm_chrg" />
<input type="hidden" name="org_ddct_amt" id="org_ddct_amt" />
<input type="hidden" name="org_tot_amt" id="org_tot_amt" />
<input type="hidden" name="inv_amt_sts" id="inv_amt_sts" />
<input type="hidden" name="org_inv_desc" id="org_inv_desc" />
<input type="hidden" name="org_clt_agn_flg" id="org_clt_agn_flg" />

<input type="hidden" name="org_usr_inp_ctnt1" id="org_usr_inp_ctnt1" />
<input type="hidden" name="org_vndr_cust_addr" id="org_vndr_cust_addr" />
<input type="hidden" name="org_cty_nm" id="org_cty_nm" />
<input type="hidden" name="org_ste_cd" id="org_ste_cd" />
<input type="hidden" name="org_zip_cd" id="org_zip_cd" />
<input type="hidden" name="org_usr_inp_ctnt2" id="org_usr_inp_ctnt2" />
<input type="hidden" name="org_vndr_cust_ref_rmk" id="org_vndr_cust_ref_rmk" />

<input type="hidden" name="cnt_cd" value="<%=cnt_cd%>" id="cnt_cd" />
<input type="hidden" name="s_ida_tax_seq" value="<%=ida_tax_seq%>" id="s_ida_tax_seq" />
<!--<input type="text" name="expn_tax">-->
<!--<input type="text" name="edu_tax">-->
<!--<input type="text" name="high_edu_tax">-->
<!--<input type="text" name="rgst_no">-->
<!--<input type="text" name="svc_cate_rmk">-->
<!--<input type="text" name="pmnt_acct_no">-->


<%=JSPUtil.getIncludeString(request) %>

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button" style="display:none;">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_accent" type="button" name="btn_cancel" id="btn_cancel" style="display:none;">Invoice Cancel</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button" style="display:none;">Save</button><!--
		--><button class="btn_normal" name="btn_erpInterface" id="btn_erpInterface" type="button" style="display:none;">AR Interface</button><!--
		--><button class="btn_normal" type="button" name="btn_settlement" id="btn_settlement" style="display:none;">SettlementDown Excel</button><!--
		--><button class="btn_normal" type="button" name="btn_settlement" id="btn_settlement" style="display:none;">SettlementDown Excel</button><!--
		--><button class="btn_normal" type="button" name="btn_preview" id="btn_preview" style="display:none;">Preview</button>
		</div>
		<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="80" />								
				<col width="" />				
		   </colgroup> 
		 	<tbody>
				<tr>
					<th><font color="red">TPB No.</font></th>
					<td><input type="text" name="s_n3pty_no" id="s_n3pty_no" value="<%=s_detail_n3pty_no%>" maxlength="14" style="width:122px;"></td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="80" />				
				<col width="200" />				
				<col width="200" />				
				<col width="140" />						
				<col width="*" />				
		   </colgroup> 
			<tbody>
				<tr>
					<th>Invoice No.</th>
					<td><input name="s_n3pty_inv_no" id="s_n3pty_inv_no" type="text" class="" style="width:85px;" value="<%=s_n3pty_inv_no%>" readonly><!-- 
					 --><input type="text" class="" style="width:33px;" name="s_n3pty_inv_rmd_cd" id="s_n3pty_inv_rmd_cd" value="<%=s_n3pty_inv_rmd_cd%>" readonly></td>
					<th>Currency</th>
					<td><select class="input1" style="width:100px;" name="s_curr_cd" id="s_curr_cd" required caption="Currency" onchange='changeCurrency(this.value)'></select></td>
					<td style="display:none"><b>VAT</b>&nbsp;<!-- 
					 --><input <%if(cnt_cd.equals("IN")){ %>style="display:none"<%}%> type="checkbox"  id="s_vat_xch_rt_chk" name="s_vat_xch_rt_chk" class="trans" style="display:none" onclick="amtReCalculate();" value="Y"></td><!-- Final Invoice&nbsp; --><!-- 
				     --><input type="checkbox" name="s_final_flg_checkbox" id="s_final_flg_checkbox" class="trans" onclick="tpb_set_final_invoice(this.checked);" style="display:none;"></td>
					<td><button class="btn_etc" type="button" name="btn_invoicesheetset" id="btn_invoicesheetset" style="display:none;">Preview</button></td>
				</tr>
				<tr>
				    <th>Fax Number</th>
					<td><input type="text" class="input" style="width:122px;" name="s_fax_no" id="s_fax_no" maxlength="20" readonly></td>
					<th>Collection Agency / Legal Action</th>
					<td><input type="checkbox" name="s_clt_agn_flg" id="s_clt_agn_flg" value="Y" class="trans"></td>
					<td><button type="button" class="btn_etc" name="btn_caremarks" id="btn_caremarks">C/L Remarks</button>&nbsp;<!-- 
						 --><button type="button" class="btn_etc" name="btn_collectionactivity" id="btn_collectionactivity">Recovery Activity</button>						
					</td>
	
				</tr>
			</tbody>
		</table>		
		<!-- : ( Year ) (S) -->
		<div class="line_bluedot"></div>
		
		<table class="grid_2 wFit">
			<colgroup>
				<col  width="450" />				
				<col  width="130" />				
				<col  width="130" />				
				<col  width="132" />				
				<col  width="113" />							
		   </colgroup> 
			<tbody>
      			<tr class="align_center">
      				<th class="align_center">Bill To</th>
      				<th class="align_center">Code</th>
      				<th class="align_center">Reference</th>
					<th class="align_center">Due Date</th>
      				<th class="align_center">VAT No.</th>
      			</tr>
				<tr>
      				<td align='left'><!-- 
      					 --><input name="s_usr_inp_ctnt1" id="s_usr_inp_ctnt1" type="text" class="input mar_btm_4" style="width:447px;" maxlength='100'><!-- 1 --><br><!-- 
      					 --><input name="s_vndr_cust_nm" id="s_vndr_cust_nm" type="text" class="input mar_btm_4" style="width:447px;" readonly><!-- vendor / customer name --><br><!-- 
      					 --><input name="s_vndr_cust_addr" id="s_vndr_cust_addr" type="text" class="input mar_btm_4" style="width:447px;" maxlength='100'><br><!-- 
      					 --><b>City :</b> <input name="s_cty_nm" id="s_cty_nm" type="text" class="input mar_btm_4" style="width:203px;" maxlength='50'><!-- city name 50 --><!-- 
      					 --><b>State :</b> <input name="s_ste_cd" id="s_ste_cd" type="text" class="input mar_btm_4" style="width:45px;" maxlength='3'><!-- state code 3 --><!-- 
      					 --><b>Zip :</b> <input name="s_zip_cd" id="s_zip_cd" type="text" class="input mar_btm_4" style="width:87px;" maxlength='10'><!-- zip code 10 --><br><!-- 
      					 --><input name="s_usr_inp_ctnt2" id="s_usr_inp_ctnt2" type="text" class="input" style="width:447px;" maxlength='100'><!-- 2 -->
					</td>
					<% if (s_correction_yn.equals("Y-IGNORE")){  /// Changed ... In 2008-11-12
						%><td>
							<%=TPBUtils.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:80px;'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|", "C|V")%><!-- 
							 -->&nbsp;<input type="text" style="width:70px;" name="s_trd_party_val" id="s_trd_party_val" maxlength="8"><!-- 
							 --><button type="button" id="btn_3rdParty" name="btn_3rdParty" class="input_seach_btn"></button>
						</td><%
					   } else {
					   	%><td><input name="s_trd_party_val" id="s_trd_party_val" type="text" class="noinput" style="width:95px;" readonly><input type="hidden" name="s_vndr_cust_div_cd" value=""></td><%  //s_trd_party_code_detail
					   } %>

      				<td align='center'><!-- <input name="s_vndr_cust_ref_rmk" type="text" class="noinput" style="width:180">
      				 --><textarea name="s_vndr_cust_ref_rmk" id="s_vndr_cust_ref_rmk" class=""  style="width:100%;height:100px;overflow-y:auto;overflow-x:auto" onblur="checkLength(this,150,'Reference')"></textarea></td>
					<td align='center'><input name="s_rcv_due_dt" id="s_rcv_due_dt" type="text" class="noinput" style="width:70px" maxlength="10" value="<%=DateTime.addDays(currentDay, 15, "yyyy-MM-dd")%>" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"><!-- 
					 --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
      				<td align='center'><!-- <input name="s_rgst_no" type="text" class="noinput" style="width:90" maxlength="20">
      				 --><textarea name="s_rgst_no" id="s_rgst_no" class="<% if(!isHAMURs){out.print("noinput");}else{out.print("input");}%>"  style="width:100%;height:100px;overflow-y:auto;overflow-x:auto" onblur="checkLength(this,20,'VAT No.')"<% if(!isHAMURs){out.print(" readonly");} %>></textarea></td></tr>
			</tbody>
     	</table>
     	<!-- : ( Year ) (E) -->
     	
     	<%/* %>
     	<table class="grid_2">
     		<tbody>
				<tr>
					<td class="tr2_head" width="">Bill to</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Attention</th>
					<td><input name="s_usr_inp_ctnt1" id="s_usr_inp_ctnt1" type="text" class="" style="width: 440px; font-size: 8pt"></td>
				</tr>
				<tr>
					<th>Company</th>
					<td>
						<% if (s_correction_yn.equals("Y-IGNORE")){   %>
							<%=TPBUtils.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:50;'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|", "C|V")%>
							<input type="text" style="width:70px;" name="s_trd_party_val" id="s_trd_party_val" maxlength="8"><!-- 
							 --><button type="button" id="btn_3rdParty" name="btn_3rdParty" class="input_seach_btn"></button>
						<%
					   } else {
					   	%><input name="s_trd_party_val" id="s_trd_party_val" type="text" class="tr3_head" style="width:50px;" readonly>
					   	<% } //s_trd_party_code_detail%>&nbsp;<!-- 
						 --><input name="s_vndr_cust_nm" id="s_vndr_cust_nm" type="text" class="noinput" style="width: 385px; font-size: 8pt" readonly>
					</td>
				</tr>
				<tr>
					<td><input type="radio" name="s_rch" id="s_rch" class="noinput" value="addr1" checked>&nbsp;Address 1.</td>
					<td><input name="s_vndr_cust_addr" id="s_vndr_cust_addr" type="text" class="" style="width: 440px; font-size: 8pt" maxlength='100'>
					</td>
				</tr>
				<tr>
					<td align="right"><input type="radio" name="s_rch" id="s_rch" class="noinput" value="addr2">&nbsp;<b>Address 2.</b></td>
					<td><input name="s_vndr_cust_addr2" id="s_vndr_cust_addr2" type="text" class="" style="width: 440px; font-size: 8pt" maxlength='100'>
					</td>
				</tr>
				<tr>
					<td colspan="2"><b>City :</b>&nbsp;<input name="s_cty_nm"  id="s_cty_nm" type="text" class="" style="width: 200px;" maxlength='50'><!-- city name 50 --> &nbsp;&nbsp;<!-- 
					 --><b>State :</b>&nbsp;<input name="s_ste_cd" id="s_ste_cd" type="text" class="" style="width: 40px;" maxlength='3'><!-- state code 3 --><!-- 
					 -->&nbsp;&nbsp;<b>Zip :</b>&nbsp;<input name="s_zip_cd" id="s_zip_cd" type="text" class="" style="width: 90px;" maxlength='10'><!-- zip code 10 -->
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2"><input name="s_usr_inp_ctnt2" id="s_usr_inp_ctnt2" type="text" class="" style="width: 412px; font-size: 8pt"></td>
				</tr>
			</tbody>
		</table>
		<table class="gri_2">
			<colgroup>
				<col width="70"/>
				<col width="150"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Reference</th>
					<td><textarea name="s_vndr_cust_ref_rmk" id="s_vndr_cust_ref_rmk" class="" style="width: 100%; height: 60px; overflow-y: auto; overflow-x: auto" onblur="checkLength(this,50,'Reference')"></textarea></td>
				</tr>
				<tr>
					<th>Due Date</th>
					<td><input name="s_rcv_due_dt" type="text" class="noinput" style="width:70px;" maxlength="10" value="<%=DateTime.addDays(currentDay, 15, "yyyy-MM-dd")%>" data_format="ymd"><!-- 
						--><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button>
					</td>
				</tr>
				<tr>
					<th>VAT No.</th>
					<td><textarea name="s_rgst_no" id="s_rgst_no" class="<% if(!isHAMURs){out.print("noinput");}else{out.print("input");}%>"  style="width:100%;height:60px;overflow-y:auto;overflow-x:auto" onblur="checkLength(this,20,'VAT No.')"<% if(!isHAMURs){out.print(" readonly");} %>></textarea></td>
				</tr>
			</tbody>
		</table>
   		<%*/ %>
		<table>
			<colgroup>
				<col width="70" />				
				<col width="100" />				
				<col width="70" />				
				<col width="100" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<% for(int i=0;i<s_length_n3pty_bil_tp_cd_int;i++){ %>
	<div id="tabSheet1">
		<!-- opus_design_tab(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab<%=i+1%>')</script>
		</div>
		<!-- opus_design_tab(E) -->
		
		<div class="opus_design_grid">
	 	  <script type="text/javascript">ComSheetObject('sheet<%=i+1%>');</script>
		</div>
		<table class="height_10"><tr><td></td></tr></table>
	</div>
	<% } %>	
	
	<div class="opus_design_inquiry wFit">  
		<% if(!cnt_cd.equals("IN")){ %>
		<table class="grid_2">	
			<colgroup>
				<col width="120"/>
				<col width="*"/>
			</colgroup>	
			<tbody>	
			 	<tr>
					<th><font color="red">Confirmed Amount</font></th>
					<td><input name="s_net_amt" id="s_net_amt" type="text" class="noinput" style="width:99%;text-align:right" readonly></td>
				</tr>
				<tr>
					<th><font color="red">Administration Charge</font></th>
					<td><input name="s_add_amt"  id="s_add_amt" type="text"  class="input" style="width:99%;text-align:right" onclick="this.select()" onblur="tpb_otherAmountReCalculate(this);"></td>
				</tr>
				<tr>
					<th><font color="red">Deducted Amount</font></th>
					<td><input name="s_ddct_amt" id="s_ddct_amt" type="text" class="input" style="width:99%;text-align:right" onclick="this.select()" onblur="tpb_otherAmountReCalculate(this);"></td>
				</tr>
				<tr>
					<th><font color="red">VAT Amount</font></th>
					<td><input  name="s_vat_amt" id="s_vat_amt" type="text"  class="noinput" style="width:99%;text-align:right" onclick="this.select()" onblur="amtReCalculate()" readonly></td>
				</tr>
				<tr>
					<th><font color="red">Total Amount</font></th>
					<td><input name="s_total_amt" id="s_total_amt" type="text" class="noinput" style="width:99%;text-align:right" readonly></td>
				</tr>
			</tbody>	
		</table>
		<%}else{ %>
			<div class="opus_design_data ">
				<h3 class="title_design mar_top_12">[ Expense ]</h3>
				<table class="grid_2  wFit">
					<colgroup>
						<col width="150"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>Net Amount</th>
							<td><input name="s_net_amt" id="s_net_amt" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
						</tr>
						<tr>
							<th>Administration Charge</th>
							<td><input name="s_add_amt" id="s_add_amt" type="text" class="input" style="text-align: right;width:96%" onclick="this.select();" onblur="tpb_otherAmountReCalculate(this);calculateForIndiaInvoice();"></td>
						</tr>
						<tr>
							<th>Deducted Amount</th>
							<td><input name="s_ddct_amt" id="s_ddct_amt" type="text" class="input" style="text-align: right;width:96%" onclick="this.select();" onblur="tpb_otherAmountReCalculate(this);calculateForIndiaInvoice();"></td>
						</tr>
						<tr style="display:none">
							<th>VAT Amount</th>
							<td><input name="s_vat_amt" id="s_vat_amt" type="text" style="width:96%" class="noinput" style="text-align: right; width:96%" onclick="this.select()" onblur="amtReCalculate()" readonly></td>
						</tr>
						<tr>
							<th>Total Amount</th>
							<td><input name="s_total_amt" id="s_total_amt" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
						</tr>
					</tbody>
				</table>
				<h3 class="title_design mar_top_12">[ Tax ]</h3>
				<table  class="grid_2">
					<colgroup>
						<col width="120"/>
						<col  width="50"/>
						<col width="300"/>
						<col  width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>Service Tax @</th>
							<td><input class="noinput" type="text" name="expn_tax" id="expn_tax" style="width:25px; text-align:center" readonly>%</td>
							<td><input name="tot_expn_tax" id="tot_expn_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
							<td> </td>
						</tr>
						<tr>
							<th>Swachh Bharat @<th>
							<td><input class="noinput" type="text" name="edu_tax" id="edu_tax" style="width:20px; text-align:center" readonly>&nbsp;<b>% Tax</b></td>
							<td><input name="tot_edu_tax" id="tot_edu_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
							<td> </td>
						</tr>
						<tr>
							<th>Krishi Kalyan @</th>
							<td><input class="noinput" type="text" name="high_edu_tax" id="high_edu_tax" style="width:20px; text-align:center" readonly><b>% Tax</b></td>
							<td><input name="tot_high_edu_tax"  id="tot_high_edu_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
							<td> </td>
						</tr>
						<tr>
							<th>Total Service Tax (Rs)</th>
							<td colspan="2"><input name="tot_svc_tax" id="tot_svc_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
							<td> </td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td>Service Tax Registration No. : <input class="noinput" type="text" name="tax_rgst_no" id="tax_rgst_no" readonly style="width:238px"/>
							<br>
							Service Category : <input class="noinput" type="text" name="svc_cate_rmk" id="svc_cate_rmk" readonly style="width:300px"/>
							<br>
							PAN No. : <input class="noinput" type="text" name="pmnt_acct_no" id="pmnt_acct_no" readonly style="width:346px"/>
						</td>
					</tr>
				</table>	
				<h3 class="title_design mar_top_12">[ Invoice Amount ]</h3>
				<table class="grid_2">
					<colgroup>
						<col width="90"/>
						<col width="*"/>
					</colgroup>
					<tbody>				
						<tr>
							<th>Expense</th>
							<td><input name="lst_expense" id="lst_expense" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
						</tr>
						<tr>
							<td class="stm" align="left">Tax</td>
							<td class="stm">
								<input name="lst_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly>
							</td>
						</tr>
						<tr>
							<th>Invoice Total</th>
							<td><input name="lst_invoice_total" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
						</tr>
					</tbody>
				</table>
			</div>
		<%} %>
		
	</div>	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design mar_top_12">Descriptions</h3>
			<table>
				<tr>
					<td><textarea name="s_inv_desc" id="s_inv_desc" class="input3"  style="width:100%;height:35px;overflow-y:auto;overflow-x:auto"
					<%if(cnt_cd.equals("FR")){ %>
					onblur="checkLength(this,500,'Descriptions')"
					<%} else{ %>
					onblur="checkLength(this,1000,'Descriptions')"
					<%} %>>
					</textarea>

					</td></tr>

       	</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


</form>
<div style="display: none">
	<!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <script type="text/javascript">ComSheetObject('sheet0');</script>
    </div>
    <!-- opus_design_grid(e) -->
</div>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
<div id='div_processing' name='div_processing' style='position: absolute; left: 0; top: 0; z-index: 100; display: none; width: 100%; height: 100%'>

</div>

<SCRIPT type="text/javascript">
<!--
	  /*
		Showing screent of user input info by event
	  */
<% for(int i=0;i<s_length_n3pty_bil_tp_cd_int;i++){ %>
	function sheet<%=i+1%>_OnPopupClick(sheetObj,Row,Col,Value){
		var colName=sheetObj.ColSaveName(Col);
		if(colName == "occr_dt" || colName == "damage_dt"
			|| colName == "lst_free_dt" || colName == "pkup_dt"){
		 var cal=new ComCalendarGrid();
		 cal.select(sheetObj, Row,Col,'yyyy-MM-dd');
	}
	if(colName == "new_vsl_cd"){
		var param='?sdate='+form.sdate.value+'&edate='+form.edate.value;
		ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD_sheet', '1,0,1,1,1,1,1,1',Row,Col);
	}
}
function sheet<%=i+1%>_OnChange(sheetObj,Row,Col,Value){
	_sheet_onchange();
	var colName=sheetObj.ColSaveName(Col);
	if( colName == "inv_dtl_amt" || colName == "vat_dtl_amt" || colName == "vat_dtl_chk" )
	{
		var prcsCnt=document.all.prcs_cnt.value;
			var amtPrcs=1;
			if( prcsCnt >= 3 ) prcsCnt=2;
			for(var j=0;j<prcsCnt;j++)
			{
				amtPrcs=amtPrcs * 10;
			}
		if( colName == "inv_dtl_amt" )
		{
			var invAmt=sheetObj.GetCellValue(Row, "inv_dtl_amt");
  			var fltAmt=Math.round(invAmt * amtPrcs) / amtPrcs;
  			sheetObj.SetCellValue(Row, "inv_dtl_amt",fltAmt,0);
			//Compare the amount in case of not Auto Update
			if( sheetObj.GetCellValue(Row, "so_if_seq") == 0 ){
				if(parseFloat(sheetObj.GetCellValue(Row, "ots_amt")) < parseFloat(sheetObj.GetCellValue(Row, colName))){
//					ComShowCodeMessage("TPB90032","Invoice AMT","Original AMT"); // under
//					sheetObj.SetCellValue(Row, colName,sheetObj.GetCellValue(Row, "original_inv_dtl_amt"),0);
					//return;
				} else if ( parseFloat(sheetObj.GetCellValue(Row, colName)) <= 0 ) { // over
					ComShowCodeMessage("TPB90035","Invoice AMT","0.00");
					sheetObj.SetCellValue(Row, colName,sheetObj.GetCellValue(Row, "original_inv_dtl_amt"),0);
					//return;
				}
			}
			var vatXchRt=document.all.s_vat_xch_rt.value;
			var vatChk=sheetObj.GetCellValue(Row, "vat_dtl_chk");
			if( vatChk == 1 )
			{
				sheetObj.SetCellValue(Row, "vat_dtl_amt",Math.round((invAmt * (vatXchRt / 100)) * amtPrcs) / amtPrcs,0);
			}
		}
		if(colName == "vat_dtl_amt")
		{
			var vatAmt=sheetObj.GetCellValue(Row, "vat_dtl_amt");
  			var fltAmt=Math.round(vatAmt * amtPrcs) / amtPrcs;
  			sheetObj.SetCellValue(Row, "vat_dtl_amt",fltAmt,0);
  		}
		//Detail VAT
		if( colName == "vat_dtl_chk" )
		{
			var vatXchRt=document.all.s_vat_xch_rt.value;
			var inv_amt=sheetObj.GetCellValue(Row, "inv_dtl_amt")
			if( Value == 1 )
			{
				sheetObj.SetCellValue(Row, "vat_dtl_amt",Math.round((inv_amt * (vatXchRt / 100)) * amtPrcs) / amtPrcs,0);
				sheetObj.SetCellEditable(Row, "vat_dtl_amt",1);
			}
			else
			{
				sheetObj.SetCellValue(Row, "vat_dtl_amt",0,0);
				sheetObj.SetCellEditable(Row, "vat_dtl_amt",0);
			}
		}
		amtReCalculate();
	}
	//Checking Auto Update of Outstanding Amount
	tpb_chgColor_ots_amt(sheetObj, 49, 30, Row);
	if(sheetObj.GetRowStatus(Row) == 'U' ){
		document.form.inv_amt_sts.value='U';
	}
}
function sheet<%=i+1%>_OnSearchEnd(sheetObj,errMsg){
	if ( document.all.cnt_cd.value == 'IN' )
	{
		sheetObj.SetColHidden("vat_dtl_chk",1);
		sheetObj.SetColHidden("vat_dtl_amt",1);
	}
	for ( var i=1; i <= sheetObj.RowCount(); i++ ){
		//Point rounding
		var invAmt=sheetObj.GetCellValue(i, "inv_dtl_amt");
		var prcsCnt=document.all.prcs_cnt.value;
		var amtPrcs=1;
		if( prcsCnt >= 3 ) prcsCnt=2;
		for(var j=0;j<prcsCnt;j++)
		{
			amtPrcs=amtPrcs * 10;
		}
		var fltAmt=Math.round(invAmt * amtPrcs) / amtPrcs;
		sheetObj.SetCellValue(i, "inv_dtl_amt",fltAmt,0);
	}
	for ( var idx=1; idx <= sheetObj.RowCount(); idx++ )
	{
		if( sheetObj.GetCellValue(idx,"vat_dtl_chk") == 1 )
		{
			sheetObj.SetCellEditable(idx, "vat_dtl_amt",1);
		}
		else
		{
			sheetObj.SetCellEditable(idx, "vat_dtl_amt",0);
		}
	}
}
<% } %>
-->
</SCRIPT>