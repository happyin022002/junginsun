<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0110.jsp
*@FileTitle  : Invoice Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0110Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	
	EsdTpb0110Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null; 	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;
	//Map<String,String> rowSet = new HashMap<String,String>();
	Map<String,String> rowSet = null;
	Map<String,String> rowSetOtsGrpInfo = null;

	Map<String,String> rowSetIndiaTaxInfo = null;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.InvoiceManage");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String s_dao_n3pty_no = "";
	
	String[] s_dao_n3pty_no_arr;
	
	
	String s_length_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("s_length_n3pty_bil_tp_cd")).trim();
	int s_length_n3pty_bil_tp_cd_int = 1; //Sheet Maxinum count
	try {
		s_length_n3pty_bil_tp_cd_int = Integer.parseInt(s_length_n3pty_bil_tp_cd);
	} catch (Exception e) {
		s_length_n3pty_bil_tp_cd_int = 1;
		out.println(e.toString());
	}

	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code"));
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd"));
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	String indiaTaxForm = JSPUtil.getNull(request.getParameter("indiaTaxForm"));
	
	s_dao_n3pty_no = JSPUtil.getNull(request.getParameter("s_dao_n3pty_no"));
	s_dao_n3pty_no_arr = s_dao_n3pty_no.split("\\|");
	
	String ida_tax_seq = "";
	String expn_tax = "";
	String edu_tax = "";
	String high_edu_tax = "";
	String tax_rgst_no = "";
	String svc_cate_rmk = "";
	String pmnt_acct_no = "";

	String [] user_auth = null;
	
	//log.debug("s_length_n3pty_bil_tp_cd_int====>"+s_length_n3pty_bil_tp_cd_int);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		user_auth = account.getUserAuth();
		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

		event = (EsdTpb0110Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if( !indiaTaxForm.equals("Y")&&!indiaTaxForm.equals("N")&&cnt_cd.equals("IN") ){
			indiaTaxForm = "Y";
		}

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		//eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
				rowSet = eventResponse.getETCData();
				
				if (rowSet != null) {
					rowCount = eventResponse.getDataCntList().size();
				} // end if
				
				rowSetOtsGrpInfo = eventResponse.getETCData();

				if (eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
					s_length_n3pty_bil_tp_cd_int = Integer.parseInt(rowSetOtsGrpInfo.get("length_n3pty_bil_tp_cd"));
				}
				
				rowSetIndiaTaxInfo = eventResponse.getETCData();
				if (eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
					ida_tax_seq = eventResponse.getETCData("ida_tax_seq");
					expn_tax = eventResponse.getETCData("expn_tax");
					edu_tax = eventResponse.getETCData("edu_tax");
					high_edu_tax = eventResponse.getETCData("high_edu_tax");
					tax_rgst_no = eventResponse.getETCData("tax_rgst_no");
					svc_cate_rmk = eventResponse.getETCData("svc_cate_rmk");
					pmnt_acct_no = eventResponse.getETCData("pmnt_acct_no");
				}
			} // end if
		} // end else
			
		

	}catch(Exception e) {
		out.println(e.toString());
	}
	String[] officeInfo = com.clt.apps.opus.esd.tpb.common.TPBUtils
			.getHandleOfficeLevel(ofc_cd); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	// String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd = JSPUtil.getNull(officeInfo[2]); // RHQ Code

%>
<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00582", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//_text_ChangeUpperCase(); // automatic change to uppercase
	}
	
<%=OfficeCodeMgr.getOfficeCodeListToJS("000006", "TPB")%>	
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->

<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="load_num" value="0" id="load_num" />
<input type="hidden" name="s_dao_n3pty_no" value="<%=s_dao_n3pty_no%>" id="s_dao_n3pty_no" />
<input type="hidden" name="s_dao_n3pty_bil_tp_cd" id="s_dao_n3pty_bil_tp_cd" />
<input type="hidden" name="s_trd_party_code" value="<%=s_trd_party_code%>" id="s_trd_party_code" />
<input type="hidden" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>" id="s_h_vndr_cust_div_cd" />
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-mm-dd") %>" id="sdate" />
<input type="hidden" name="edate" value="<%=currentDay%>" id="edate" />
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="<%=s_length_n3pty_bil_tp_cd%>" id="s_length_n3pty_bil_tp_cd" />
<input type="hidden" name="s_vndr_cnt_cd" id="s_vndr_cnt_cd" />
<input type="hidden" name="s_vndr_seq" id="s_vndr_seq" />
<input type="hidden" name="s_cust_cnt_cd" id="s_cust_cnt_cd" />
<input type="hidden" name="s_cust_seq" id="s_cust_seq" />
<input type="hidden" name="s_sum_inv_amt" id="s_sum_inv_amt" />
<input type="hidden" name="s_phn_no" id="s_phn_no" />
<input type="hidden" name="s_inv_rmk1" id="s_inv_rmk1" />
<input type="hidden" name="s_inv_rmk2" id="s_inv_rmk2" />
<input type="hidden" name="s_sheet_set_count" id="s_sheet_set_count" />
<input type="hidden" name="s_bil_loc" id="s_bil_loc" />
<input type="hidden" name="s_his_seq" id="s_his_seq" />
<input type="hidden" name="s_vndr_cust_eml" id="s_vndr_cust_eml" />
<input type="hidden" name="s_vat_xch_rt" id="s_vat_xch_rt" />
<input type="hidden" name="s_from_curr_cd" id="s_from_curr_cd" />
<input type="hidden" name="s_n3pty_inv_his_seq" value="" id="s_n3pty_inv_his_seq" />
<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>" id="s_ofc_cd" />
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>" id="s_rhq_cd" />
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>" id="s_cnt_cd" />

<input type="hidden" name="s_ida_tax_seq" value="<%=ida_tax_seq%>" id="s_ida_tax_seq" />
<input type="hidden" name="cnt_cd" value="<%=cnt_cd%>" id="cnt_cd" />
<input type="hidden" name="expn_tax" value="<%=expn_tax %>" id="expn_tax" />
<input type="hidden" name="edu_tax" value="<%=edu_tax %>" id="edu_tax" />
<input type="hidden" name="high_edu_tax" value="<%=high_edu_tax %>" id="high_edu_tax" />
<input type="hidden" name="tax_rgst_no" value="<%=tax_rgst_no %>" id="tax_rgst_no" />
<input type="hidden" name="svc_cate_rmk" value="<%=svc_cate_rmk %>" id="svc_cate_rmk" />
<input type="hidden" name="pmnt_acct_no" value="<%=pmnt_acct_no %>" id="pmnt_acct_no" />
<input type="hidden" name="prcs_cnt" id="prcs_cnt" />

<input type="hidden" name="s_n3pty_no" id="s_n3pty_no"  value="<%=s_dao_n3pty_no_arr[0]%> "/>


<%=JSPUtil.getIncludeString(request)%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Invoice Creation</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_erpInterface" style="display:none;" id="btn_erpInterface">AR Interface</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" style="display:none;" id="btn_revisiondetail">Revision Detail</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_preview" 	id="btn_preview">Preview</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

	<!-- page_title_area(E) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="80">
				<col width="190">
				<col width="70">
				<col width="130">
				<col width="130">
				<col width="*">
			</colgroup>
			<tr>
				<th>Invoice No.</th>
				<td><input name="s_n3pty_inv_no" id="s_n3pty_inv_no" type="text" class="input" style="width: 95px; . background-color: #EEEEEE;" value="" readonly> <input type="text" class="input" style="width: 33; . background-color: #EEEEEE;" name="s_n3pty_inv_rmd_cd" id="s_n3pty_inv_rmd_cd" value="" readonly></td>
				<th>Currency</th>
				<td>
					<select class="input1" style="width:95px;" name="s_curr_cd" id="s_curr_cd" caption="Currency" onchange='changeCurrency(this.value)'>
					</select>
				</td>
				<%if(cnt_cd.equals("IN")){%>
					<td width="55">SVC Tax</td>
					<td width="25"><input type="checkbox" class="trans" name="indiaTaxForm" <%if(indiaTaxForm.equals("Y")){%>checked value="Y"<%}%> onclick="onclick_indiaTaxForm_checkbox();">
					</td>
				<%}else{ %>
					<td><input type="hidden" name="indiaTaxForm" value="<%=indiaTaxForm %>"></td>
				<%} %>
				<td><button type="button" class="btn_etc" id="btn_invoicesheetset" name="btn_invoicesheetset" style="display: none;">Invoice Setting</button></td>
				<th>Fax Number</th>
				<td><input type="text" style="width: 90px;" name="s_fax_no" id="s_fax_no" maxlength="20" readonly></td>
				<td <%if(cnt_cd.equals("IN")){ %>style="display:none"<%}%>><input type="checkbox" name="s_vat_xch_rt_chk" id="s_vat_xch_rt_chk" class="trans" onclick="amtReCalculate();" value="Y" style="display:none"></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 50%">
			<div class="opus_design_data">
				<table class="grid_2">
					<colgroup>
						<col width="120px">
						<col width="555px">
					</colgroup>
					<tr>
						<th align="center" colspan="2"><strong>Bill to</strong></th>
					</tr>
					<tr>
						<th align="center">Attention</th>
						<td class="noinput"><input name="s_usr_inp_ctnt1" id="s_usr_inp_ctnt1"  type="text" class="" style="width: 100%; font-size: 8pt"></td>
					</tr>
					<tr>
						<th align="center">Company</th>
						<td class="noinput"><input name="s_trd_party_code_detail" id="s_trd_party_code_detail" type="text" class="tr3_head" style="width: 100px" readonly><!--  
						--><input name="s_vndr_cust_nm" id="s_vndr_cust_nm" type="text" class="noinput" style="width: 398px; font-size: 8pt" readonly></td>
					</tr>
					<tr>
						<th align="center"><input type="radio" name="s_rch" id="s_rch" class="noinput" value="addr1" checked>&nbsp;Address 1.</th>
						<td class="noinput"><input name="s_vndr_cust_addr" id="s_vndr_cust_addr" type="text" class="" style="width: 100%; font-size: 8pt" maxlength='100'></td>
					</tr>
					<tr>
						<th align="center"><input type="radio" name="s_rch" id='s_rch' class="noinput" value="addr2">&nbsp;Address 2.</th>
						<td class="noinput"><input name="s_vndr_cust_addr2" id="s_vndr_cust_addr2" type="text" class="" style="width: 100%; font-size: 8pt" maxlength='100'></td>
					</tr>
					<tr>
						<th align="center"></th>
						<td class="noinput">City :<input name="s_cty_nm" id="s_cty_nm" type="text" class="" style="width: 135px" maxlength='50'><!-- city name 50 --> &nbsp;&nbsp;<!--  
						-->State : <input name="s_ste_cd" id="s_ste_cd" type="text" class="" style="width: 50px" maxlength='3'><!-- state code 3 -->&nbsp;&nbsp;<!--  
						-->Zip : <input name="s_zip_cd" id="s_zip_cd" type="text" class="" style="width: 110px" maxlength='10'><!-- zip code 10 -->
						</td>
					</tr>
					<tr>
						<th></th><td class="noinput"><input name="s_usr_inp_ctnt2" id="s_usr_inp_ctnt2" type="text" class="" style="width: 100%; font-size: 8pt"></td>
					</tr>
				</table>
			</div>
		</div>
		<!-- layout_vertical_2(E) -->
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 50%; height: 187px">
			<table class="grid_2">
				<colgroup>
					<col width="70">
					<col width="*">
				</colgroup>
				<tr>
					<th><strong>Reference</strong></th>
					<td  class="noinput"><textarea name="s_vndr_cust_ref_rmk" id="s_vndr_cust_ref_rmk" class="" style="width: 100%; height: 76px; resize:none; overflow-y: auto; overflow-x: auto" onblur="tpb_chkLenByByte(this,150,'Reference')"></textarea></td>
				</tr>
				<tr>
					<th><strong>Due Date</strong></th>
					<td  class="noinput"><input name="s_rcv_due_dt" id='s_rcv_due_dt' type="text" class="noinput" style="width: 70px; resize:none;" maxlength="10" value="<%=DateTime.addDays(currentDay, 15, "yyyy-MM-dd")%>" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
					</td>
				</tr>
				<tr>
					<th><strong>VAT No.</strong></th>
					<td><textarea name="s_rgst_no" id="s_rgst_no" class="" style="width: 100%; height: 60px; resize:none; overflow-y: auto; overflow-x: auto" onblur="tpb_chkLenByByte(this,20,'VAT No.')"></textarea></td>
				</tr>
			</table>
		</div>
		<!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->

</div>
<div class="wrap_result">
<% for (int i = 0; i < s_length_n3pty_bil_tp_cd_int; i++) { %>
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript"> ComTabObject ('tab<%=i+1%>')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet<%=i+1%>');</script>
	</div>
<%}%>
<% if(!(cnt_cd.equals("IN")&&indiaTaxForm.equals("Y"))){//* 2009-06-07 %>
	<div class="opus_design_data"  style="width: 450px">
		<table class="grid_2">
			<colgroup>
				<col width="140">
				<col width="*">
			</colgroup>
			<tr>
				<th>Net Amount</th>
				<td  class="noinput"><input name="s_net_amt" id="s_net_amt" type="text" class="noinput input1" style="width: 95%; text-align: right" readonly></td>
			</tr>
			<tr>
				<th>Administration Charge</th>
				<td  class="noinput"><input name="s_add_amt" id="s_add_amt" type="text" class="input" style="width: 95%; text-align: right" onclick="this.select()" onblur="tpb_otherAmountReCalculate(this);"></td>
			</tr>
			<tr>
				<th>Deducted Amount</th>
				<td  class="noinput"><input name="s_ddct_amt" id="s_ddct_amt" type="text" class="input" style="width: 95%; text-align: right" onclick="this.select()" onblur="tpb_otherAmountReCalculate(this);"></td>
			</tr>
			<tr>
				<th>VAT Amount</th>
				<td><input name="s_vat_amt" id="s_vat_amt" type="text" class="noinput" style="width: 95%; text-align: right" onclick="this.select()" onblur="amtReCalculate()" readonly></td>
			</tr>
			<tr>
				<th>Total Amount</th>
				<td  class="noinput"><input name="s_total_amt" id="s_total_amt" type="text" class="noinput" style="width: 95%; text-align: right" readonly></td>
			</tr>
		</table>
	</div>
<%}else{ // ########### India Case ############%>
	<div class="opus_design_inquiry wFit">
		<h3><b>[ Expense ]</b></h3>
		<table class="grid_2">
			<tr>
				<th>Net Amount</th>
				<td  class="noinput"><input name="s_net_amt" id="s_net_amt" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
			</tr>
			<tr>
				<th>Administration Charge</th>
				<td  class="noinput"><input name="s_add_amt" id="s_add_amt" type="text" class="input" style="text-align: right;width:96%" onclick="this.select();" onblur="tpb_otherAmountReCalculate(this);calculateForIndiaInvoice();"></td>
			</tr>
			<tr>
				<th>Deducted Amount</th>
				<td  class="noinput"><input name="s_ddct_amt" id="s_ddct_amt" type="text" class="input" style="text-align: right;width:96%" onclick="this.select();" onblur="tpb_otherAmountReCalculate(this);calculateForIndiaInvoice();"></td>
			</tr>
			<tr style="display:none">
				<th>VAT Amount</th>
				<td  class="noinput"><input name="s_vat_amt" id="s_vat_amt" type="text" class="noinput" style="text-align: right; width:96%" onclick="this.select()" onblur="amtReCalculate()" readonly></td>
			</tr>
			<tr>
				<th>Total Amount</th>
				<td  class="noinput"><input name="s_total_amt" id="s_total_amt" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
			</tr>
		</table>
	</div>
	<div class="opus_design_inquiry wFit">
		<h3><b>[ Tax ]</b></h3>
		<table class="grid_2">
			<tr>
				<th>Service Tax @ <span id="expn_tax_text"></span>%</th>
				<td><input name="tot_expn_tax" id="tot_expn_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
			</tr>
			<tr>
				<th>Swachh Bharat @ <span id="edu_tax_text"></span>% Tax</th>
				<td><input name="tot_edu_tax" id="tot_edu_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
			</tr>
			<tr>
				<th>Krishi Kalyan @ <span id="high_edu_tax_text"></span>% Tax</th>
				<td><input name="tot_high_edu_tax" id="tot_high_edu_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
			</tr>
			<tr>
				<th>Total Service Tax (Rs)</th>
				<td><input name="tot_svc_tax" id="tot_svc_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
			</tr>
		</table>
	</div>
	Service Tax Registration No. : <span id="tax_rgst_no_text"></span>
	<br>
	Service Category : <span id="svc_cate_rmk_text"></span>
	<br>
	PAN No. : <span id="pmnt_acct_no_text"></span>
	<div class="opus_design_inquiry wFit">
		<h3><b>[ Invoice Amount ]</b></h3>
		<table class="grid_2">
			<tr>
				<th>Expense</th>
				<td  class="noinput"><input name="lst_expense" id="lst_expense" type="text" class="noinput" style="text-align: right; width:96%" readonly>
				</td>
			</tr>
			<tr>
				<th>Tax</th>
				<td><input name="lst_tax" id="lst_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
			</tr>
			<tr>
				<th>Invoice Total</th>
				<td  class="noinput"><input name="lst_invoice_total" id="lst_invoice_total" type="text" class="noinput" style="text-align: right; width:96%" readonly></td>
			</tr>

		</table>
	</div>
<%} %>
				<h3 class="title_design">Descriptions</h3>
				
			<div class="opus_design_data" >
			<table>      			
	   			<tr><td>
					<textarea name="s_inv_desc" id="s_inv_desc" class="input" style="width: 977px; height:35px; resize:none; overflow-y: auto; overflow-x: auto;"
					<%if(cnt_cd.equals("FR")){ %>
					onblur="tpb_chkLenByByte(this,500,'Descriptions')" 
					<%} else{ %>
					onblur="tpb_chkLenByByte(this,1000,'Descriptions')"
					<%} %>>
					</textarea>
				</td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" style="display: ;" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>
</div>
<div id='div_processing' name='div_processing' style='position: absolute; left: 0; top: 0; z-index: 100; display: none; width: 100%; height: 100%'>
	<table>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><img src="/opuscntr/img/opus/processing.gif"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</div>
</form>
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
		ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD_sheet', '1,0,1,1,1,1,1,1',true, false, Row, Col);
	}
}
function sheet<%=i+1%>_OnSearchEnd(sheetObj,errMsg){
	if ( document.all.cnt_cd.value == 'IN' )
	{
		sheetObj.SetColHidden("vat_dtl_chk",1);
		sheetObj.SetColHidden("vat_dtl_amt",1);
	}
	for ( var i=1; i <= sheetObj.RowCount(); i++ ){
var eqNo=sheetObj.GetCellValue(i, "eq_no");
var tpbExpnTpCd=sheetObj.GetCellValue(i, "n3pty_expn_tp_cd");
var tpbIfTpCd=sheetObj.GetCellValue(i, "n3pty_if_tp_cd");
var estmSeqNo=sheetObj.GetCellValue(i, "estm_seq_no");
var estmRvisNo=sheetObj.GetCellValue(i, "estm_rvis_no");
			if(eqNo != null && eqNo !="" && tpbExpnTpCd == "MNR" && tpbIfTpCd == "S"){
//parameter changed[check again]CLT
			sheetObj.SetCellFontUnderline(i, "eq_no",1);
			}
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
}
function sheet<%=i+1%>_OnClick(sheetObj,Row,Col,Value){
	var colName=sheetObj.ColSaveName(Col);
	if(colName == "eq_no"){
		var param;
			var theURL;
			var winName;
			var features;
var eqNo=sheetObj.GetCellValue(Row, "eq_no");
var tpbExpnTpCd=sheetObj.GetCellValue(Row, "n3pty_expn_tp_cd");
var tpbIfTpCd=sheetObj.GetCellValue(Row, "n3pty_if_tp_cd");
var estmSeqNo=sheetObj.GetCellValue(Row, "estm_seq_no");
var estmRvisNo=sheetObj.GetCellValue(Row, "estm_rvis_no");
var eqKndCd=sheetObj.GetCellValue(Row, "eq_knd_cd")
		if(eqNo != null && eqNo !="" && tpbExpnTpCd == "MNR" && tpbIfTpCd == "S"){
			//param = "?pgmNo=EES_MNR_0192&rqst_eq_no=HJCU8304358&rpr_rqst_seq=1&rpr_rqst_ver_no=3&eq_knd_cd=U";
			param="?pgmNo=EES_MNR_0192&rqst_eq_no="+eqNo+"&rpr_rqst_seq="+estmSeqNo+"&rpr_rqst_ver_no="+estmRvisNo+"&eq_knd_cd="+eqKndCd;
			ComOpenPopup('/opuscntr/EES_MNR_0192.do'+param, 1024, 768, '', '0,0', false);
		}
	}
}
function sheet<%=i+1%>_OnChange(sheetObj,Row,Col,Value){
	/* _sheet_onchange( sheetObj,Row,Col,Value ); */
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
		if(colName == "inv_dtl_amt"){
			//Point rounding
var invAmt=sheetObj.GetCellValue(Row, "inv_dtl_amt");
  			var fltAmt=Math.round(invAmt * amtPrcs) / amtPrcs;
  			sheetObj.SetCellValue(Row, "inv_dtl_amt",fltAmt,0);
			//Compare the amount in case of not Auto Update
if( sheetObj.GetCellValue(Row, "so_if_seq") == 0 ){
if(parseFloat(sheetObj.GetCellValue(Row, "ots_amt")) < parseFloat(sheetObj.GetCellValue(Row, colName))){
} else if ( parseFloat(sheetObj.GetCellValue(Row, colName)) <= 0 ) { // over
					ComShowCodeMessage("TPB90035","Invoice AMT","0.00");
sheetObj.SetCellValue(Row, colName,sheetObj.GetCellValue(Row, "original_inv_dtl_amt"),0);
					return;
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
	//Outstanding Amount 의 Auto Upate check
	tpb_chgColor_ots_amt(sheetObj, 44, 27, Row);
}
<%}%>
</SCRIPT>