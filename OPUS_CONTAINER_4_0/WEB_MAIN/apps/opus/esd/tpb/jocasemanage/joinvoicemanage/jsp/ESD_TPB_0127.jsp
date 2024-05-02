<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0127.jsp
*@FileTitle  : JO TPB Invoice Revision & Cancel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
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
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0127Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	GeneralEventResponse eventResponse = null;
	EsdTpb0127Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count
	
	Map<String,String> rowSet = null;
	Map<String,String> rowSetOtsGrpInfo = null;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Jocasemanage.Joinvoicemanage");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	int s_length_n3pty_bil_tp_cd = 1;    //Sheet Maxinum count

	String s_detail_n3pty_no = JSPUtil.getNull(request.getParameter("s_detail_n3pty_no"));
	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code"));
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd"));
	String s_correction_yn = JSPUtil.getNull(request.getParameter("s_correction_yn"));
	String s_inquiryOnly_yn = JSPUtil.getNull(request.getParameter("s_inquiryOnly_yn"));
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	//n3pty_inv_rvis_seq
	String s_n3pty_inv_no = JSPUtil.getNull(request.getParameter("s_n3pty_inv_no"));
	String s_n3pty_inv_rmd_cd = JSPUtil.getNull(request.getParameter("s_n3pty_inv_rmd_cd"));
	String s_n3pty_inv_his_seq = JSPUtil.getNull(request.getParameter("s_n3pty_inv_his_seq"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

		event = (EsdTpb0127Event)request.getAttribute("Event");
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
				if(eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
					s_length_n3pty_bil_tp_cd = Integer.parseInt(rowSetOtsGrpInfo.get("length_n3pty_bil_tp_cd"));
				}
			} // end if
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	if (s_n3pty_inv_no.trim().length() == 0 ) {
		s_length_n3pty_bil_tp_cd = 0;
	}

	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	// String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
	boolean isHAMURs = false;
	if (!"".equals(rhq_cd) && OfficeCodeMgr.checkContainOfficeCode("000006","TPB",rhq_cd) ){
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
		//_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="load_num" value="0" id="load_num" />
<input type="hidden" name="s_dao_n3pty_bil_tp_cd" id="s_dao_n3pty_bil_tp_cd" />
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
<input type="hidden" name="s_detail_ots_sts_cd" id="s_detail_ots_sts_cd" />
<input type="hidden" name="s_vndr_cust_eml" id="s_vndr_cust_eml" />
<input type="hidden" name="s_final_flg" id="s_final_flg" />
<input type="hidden" name="s_vat_xch_rt" id="s_vat_xch_rt" />
<input type="hidden" name="s_france" id="s_france" />
<input type="hidden" name="s_from_curr_cd" id="s_from_curr_cd" />
<input type="hidden" name="s_same_version_yn" value="N" id="s_same_version_yn" />
<input type="hidden" name="s_inv_iss_rhq_cd" value="" id="s_inv_iss_rhq_cd" />
<input type="hidden" name="s_n3pty_inv_sts_cd" value="" id="s_n3pty_inv_sts_cd" />
<input type="hidden" name="erpif_yn" value="N" id="erpif_yn" />
<input type="hidden" name="org_due_date" id="org_due_date" />
<input type="hidden" name="org_adm_chrg" id="org_adm_chrg" />
<input type="hidden" name="org_ddct_amt" id="org_ddct_amt" />
<input type="hidden" name="org_tot_amt" id="org_tot_amt" />
<input type="hidden" name="inv_amt_sts" id="inv_amt_sts" />
<input type="hidden" name="org_inv_desc" id="org_inv_desc" />
<input type="hidden" name="prcs_cnt" id="prcs_cnt" />

<input type="hidden" name="s_ofc_cd" id="s_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_rhq_cd" id="s_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="s_cnt_cd" id="s_cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="s_trd_party_code" id="s_trd_party_code" value="<%=s_trd_party_code%>">
<input type="hidden" name="s_h_vndr_cust_div_cd" id="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>">
<input type="hidden" name="sdate" id="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" id="edate" value="<%=currentDay%>">
<input type="hidden" name="s_length_n3pty_bil_tp_cd" id="s_length_n3pty_bil_tp_cd" value="<%=s_length_n3pty_bil_tp_cd%>">
<input type="hidden" name="s_detail_n3pty_no" id="s_detail_n3pty_no" value="<%=s_detail_n3pty_no%>">
<input type="hidden" name="s_correction_yn" id="s_correction_yn" value="<%=s_correction_yn%>">
<input type="hidden" name="s_inquiryOnly_yn" id="s_inquiryOnly_yn" value="<%=s_inquiryOnly_yn%>">
<input type="hidden" name="s_n3pty_inv_his_seq" id="s_n3pty_inv_his_seq" value="<%=s_n3pty_inv_his_seq%>">
<%=JSPUtil.getIncludeString(request) %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
			<button class="btn_accent"  style="display:none;" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" style="display:none;" name="btn_cancel" id="btn_cancel" type="button">Invoice Cancel</button><!--
		--><button class="btn_normal"  style="display:none;" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" style="display:none;" name="btn_erpInterface" id="btn_erpInterface" type="button">AR Interface</button><!--
		--><button class="btn_normal" style="display:none;" name="btn_settlement" id="btn_settlement" type="button">Settlement</button><!--
		--><button class="btn_normal" style="display:none;" name="btn_preview" id="btn_preview" type="button">Preview</button><!--
		--></div>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />								
				<col width="" />				
		   </colgroup> 
			<tr>
				<th><font color="red">TPB No.</font></th>
				<td><input type="text" name="s_n3pty_no" id="s_n3pty_no" value="<%=s_detail_n3pty_no%>" maxlength="14" style="width:122px;"></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80" />				
				<col width="200" />				
				<col width="200" />				
				<col width="140" />						
				<col width="*" />				
		   </colgroup> 
			<tr>
				<th>Invoice No.</th>
				<td><input name="s_n3pty_inv_no" id="s_n3pty_inv_no" type="text" class="" style="width:85px" value="<%=s_n3pty_inv_no%>" readonly><input type="text" class="" style="width:33px;" name="s_n3pty_inv_rmd_cd" id="s_n3pty_inv_rmd_cd" value="<%=s_n3pty_inv_rmd_cd%>" readonly></td>
				<th>Currency</th>
				<td><select class="input1" style="width:95px;" name="s_curr_cd" id="s_curr_cd"  caption="Currency" onchange='changeCurrency(this.value)'></select></td>
				<th style="display:none">VAT</th>
				<td><input type="checkbox" name="s_vat_xch_rt_chk" id="s_vat_xch_rt_chk" class="trans" onclick="amtReCalculate();" value="Y" style="display:none"><input type="checkbox" name="s_final_flg_checkbox" id="s_final_flg_checkbox" class="trans" onclick="tpb_set_final_invoice(this.checked);" style="display:none;"><button class="btn_etc" name="btn_invoicesheetset" id="btn_invoicesheetset" style="display:none">Invoice Setting</button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80" />				
				<col width="200" />				
				<col width="200" />				
				<col width="140" />						
				<col width="*" />				
		   </colgroup> 
			<tr>
		    	<th>Fax Number</th>
				<td><input type="text" class="input" style="width:122px;" name="s_fax_no" id="s_fax_no" maxlength="20" readonly></td>
				<th>Collection Agency / Legal Action</th>
				<td><input type="checkbox" name="s_clt_agn_flg" id="s_clt_agn_flg" value="Y" class="trans"></td>
				<td><button type="button" class="btn_etc" name="btn_caremarks" id="btn_caremarks">C/L Remarks</button>&nbsp;<!-- 
				--><button type="button" class="btn_etc" name="btn_collectionactivity" id="btn_collectionactivity">Recovery Activity</button></td>								
			</tr>
		</table>
	</div>
	<div class="line_bluedot mar_btm_8"></div>
		<table class="grid_2 wFit">
 		   <colgroup>
				<col  width="450" />				
				<col  width="130" />				
				<col  width="130" />				
				<col  width="132" />				
				<col  width="113" />							
		   </colgroup> 
 			<tr class="tr2_head">
     			<th class="align_center">Bill To</th>
     			<th class="align_center">Code</th>
   				<th class="align_center">Reference</th>
				<th class="align_center">Due Date</th>
   				<th class="align_center">VAT No.</th>
   			</tr>
  			<tr>
				<td>
                    <input name="s_usr_inp_ctnt1" type="text" class="" style="width:447px;" id="s_usr_inp_ctnt1" /><br> 
   					<input name="s_vndr_cust_nm" type="text" class="input2 mar_top_4" style="width:447px;" readonly id="s_vndr_cust_nm" /><br>  
					<input name="s_vndr_cust_addr" type="text" class="mar_top_4" style="width:447px;" maxlength="100" id="s_vndr_cust_addr" /><br>  
					<b>City :</b> <input name="s_cty_nm" type="text" class="mar_top_4" style="width:203px" maxlength='50'>	<b>State :</b> <input name="s_ste_cd" type="text" class="input mar_top_4" style="width:45px" maxlength='3'> <b>Zip :</b> <input name="s_zip_cd" type="text" class="input mar_top_4" style="width:79px" maxlength='10'><br> 
					<input name="s_usr_inp_ctnt2" type="text" class="mar_top_4" style="width:447px;" maxlength="100" id="s_usr_inp_ctnt2" />
				</td>
				<% if (s_correction_yn.equals("Y-IGNORE")){  /// Changed ... In 2008-11-12
				%>
				<td><%=TPBUtils.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:80px;'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|", "C|V")%><input type="text" style="width:70x;" name="s_trd_party_val" maxlength="8"><button type="button" id="btn_3rdParty" name="btn_3rdParty" class="input_seach_btn"></button></td>
				<%} else {%>
			   	<td><input name="s_trd_party_val" type="text" class="noinput" style="width:95px" readonly><input type="hidden" name="s_vndr_cust_div_cd" value=""></td><%  //s_trd_party_code_detail
			   	} %>
				<td><textarea name="s_vndr_cust_ref_rmk" id="s_vndr_cust_ref_rmk" class=""  style="width:100%;height:100px;overflow-y:auto;overflow-x:auto;resize:none" onblur="checkLength(this,50,'Reference')"></textarea></td>
				<td align='center'><input name="s_rcv_due_dt" id="s_rcv_due_dt" type="text" class="noinput" style="width:70px" maxlength="10" value="<%=DateTime.addDays(currentDay, 60, "yyyy-MM-dd")%>" data_format="ymd"  onBlur="tpb_validateDateObj(this);"><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
      			<td><textarea name="s_rgst_no" class="<% if(!isHAMURs){out.print("noinput");}else{out.print("input");}%>"  style="width:100%;height:100px;overflow-y:auto;overflow-x:auto;resize:none" onblur="checkLength(this,20,'VAT No.')"<% if(!isHAMURs){out.print(" readonly");} %>></textarea></td>
      		</tr>
		</table>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
		<% for(int i=0;i<s_length_n3pty_bil_tp_cd;i++){ %>
	
		<div class="opus_design_tab">
			<script type="text/javascript">	ComTabObject('tab<%=i+1%>')</script>	
		</div>
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet<%=i+1%>')</script>		
		</div>
		<!-- opus_design_grid(E) -->
		<% } %>
		<div class="opus_design_data wFit" >
			<table class="grid_2">
				<colgroup>
					<col width="140" />
					<col width="*" />
				</colgroup>
				<tr>
					<th><font color="red">Confirmed Amount</font></th>
					<td><input name="s_net_amt" id="s_net_amt" type="text" class="noinput" style="width:99%;text-align:right" readonly></td>
				</tr>
				<tr>
					<th><font color="red">Administration Charge</font></th>
				    <td><input name="s_add_amt" id="s_add_amt" type="text" class="noinput" style="width:99%;text-align:right" readonly></td>
				</tr>
				<tr>
					<th><font color="red">Deducted Amount</font></th>
				    <td><input name="s_ddct_amt" id="s_ddct_amt" type="text" class="noinput" style="width:99%;text-align:right" readonly></td>
				</tr>
				<tr>
					<th><font color="red">VAT Amount</font></th>
					<td><input name="s_vat_amt" id="s_vat_amt" type="text"  class="noinput" style="width:99%;text-align:right" onclick="this.select()" onblur="amtReCalculate()"></td>
				</tr>
				<tr>
					<th><font color="red">Total Amount</font></th>
					<td><input name="s_total_amt" id="s_total_amt" type="text" class="noinput" style="width:99%;text-align:right" readonly></td>
				</tr>
			</table>
		</div>
		
		<h3 class="title_design mar_top_12">Descriptions</h3>
		
		<div class="opus_design_data wFit" >
			<table>      			
	   			<tr>
	   				<td><textarea name="s_inv_desc" id="s_inv_desc" class="input3"  style="width:100%;height:35px;overflow-y:auto;overflow-x:auto;resize:none"
					<%if(cnt_cd.equals("FR")){ %>
					onblur="checkLength(this,500,'Descriptions')"
					<%} else{ %>
					onblur="checkLength(this,1000,'Descriptions')"
					<%} %>>
				</textarea>
				</td></tr>
	   		</table>
		</div>
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet0')</script>		
		</div>
		<!-- opus_design_grid(E) -->		
</div>
</form>
<script type="text/javascript">
<!--
	  /*
		Showing screent of user input info by event
	  */
<% for(int i=0;i<s_length_n3pty_bil_tp_cd;i++){ %>
	function sheet<%=i+1%>_OnPopupClick(sheetObj,Row,Col,Value){
		var colName = sheetObj.ColSaveName(Col);
		if(colName == "occr_dt" || colName == "damage_dt"
			|| colName == "lst_free_dt" || colName == "pkup_dt"){
			 var cal = new ComCalendarGrid();
			 cal.select(sheetObj, Row,Col,'yyyy-MM-dd');
		}
		if(colName == "new_vsl_cd"){
			var param = '?sdate='+form.sdate.value+'&edate='+form.edate.value;
			ComOpenPopup('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD_sheet', '1,0,1,1,1,1,1,1',Row,Col);
		}
	}

	function sheet<%=i+1%>_OnChange(sheetObj,Row,Col,Value){
		_sheet_onchange();
		var colName = sheetObj.ColSaveName(Col);

		//if(colName == "inv_dtl_amt" || colName == "delChkBox"){ // Del. 클릭시 처리; By Kim Jin-seung In 2007-06-20
		if( colName == "inv_dtl_amt" || colName == "vat_dtl_amt" || colName == "vat_dtl_chk" )
		{
			//Point rounding
			var prcsCnt = document.all.prcs_cnt.value;
  			var amtPrcs = 1;
  			if( prcsCnt >= 3 ) prcsCnt = 2;
  			for(var j=0;j<prcsCnt;j++)
  			{
  				amtPrcs = amtPrcs * 10;
  			}  			
  			
			if ( colName == "inv_dtl_amt" ) {
				var invAmt = sheetObj.GetCellValue(Row, "inv_dtl_amt");
	  			var fltAmt = Math.round(invAmt * amtPrcs) / amtPrcs;
	  			sheetObj.SetCellValue(Row, "inv_dtl_amt", fltAmt, 0);
	  			
				//Compare the amount in case of not Auto Update
				if( sheetObj.GetCellValue(Row, "so_if_seq") == 0 ){
					if(parseFloat(sheetObj.GetCellValue(Row, "ots_amt")) < parseFloat(sheetObj.GetCellValue(Row, colName))){
//						ComShowCodeMessage("TPB90032","Invoice AMT","Original AMT"); // 이하
//						sheetObj.SetCellValue(Row, colName, sheetObj.GetCellValue(Row, "original_inv_dtl_amt"), 0);
//						return;
					} else if ( parseFloat(sheetObj.GetCellValue(Row, colName)) <= 0 ) { // 초과
						ComShowCodeMessage("TPB90035","Invoice AMT","0.00");
						sheetObj.SetCellValue(Row, colName, sheetObj.GetCellValue(Row, "original_inv_dtl_amt"), 0);
						return;
					}
				}
				
				var vatXchRt = document.all.s_vat_xch_rt.value;
				var vatChk = sheetObj.GetCellValue(Row, "vat_dtl_chk");
			
				if( vatChk == 1 )
				{
					sheetObj.SetCellValue(Row, "vat_dtl_amt", Math.round((invAmt * (vatXchRt / 100)) * amtPrcs) / amtPrcs, 0);
				}
			}
			
			if(colName == "vat_dtl_amt")
			{
				var vatAmt = sheetObj.GetCellValue(Row, "vat_dtl_amt");
	  			var fltAmt = Math.round(vatAmt * amtPrcs) / amtPrcs;
	  			sheetObj.SetCellValue(Row, "vat_dtl_amt" , fltAmt, 0);
	  		}
			
			//Detail VAT
			if( colName == "vat_dtl_chk" )
			{
				var vatXchRt = document.all.s_vat_xch_rt.value;
				var inv_amt = sheetObj.GetCellValue(Row, "inv_dtl_amt")

				if( Value == 1 )
				{
					sheetObj.SetCellValue(Row, "vat_dtl_amt", Math.round((inv_amt * (vatXchRt / 100)) * amtPrcs) / amtPrcs, 0);
					sheetObj.SetCellEditable(Row, "vat_dtl_amt",1);
				}
				else
				{
					sheetObj.SetCellValue(Row, "vat_dtl_amt", 0, 0);
					sheetObj.SetCellEditable(Row, "vat_dtl_amt",0);
				}
			}

			amtReCalculate();
		}

		//Outstanding Amount 의 Auto Upate check
		tpb_chgColor_ots_amt(sheetObj, 49, 30, Row);

		/* Possible to save in case of amount of sheetObj inv_amt_dtl*/
		if(sheetObj.GetRowStatus(Row) == 'U' ){
			document.form.inv_amt_sts.value = 'U';
		}
		
		
		//Detail VAT
		if( colName == "vat_dtl_chk" )
		{
			var vatXchRt = document.all.s_vat_xch_rt.value;
			var invAmt = sheetObj.GetCellValue(Row, "inv_dtl_amt")
			var prcsCnt = document.all.prcs_cnt.value;
			var amtPrcs = 1;
			
			if( prcsCnt >= 3 ) prcsCnt = 2;
			
			for(var j=0;j<prcsCnt;j++)
			{
				amtPrcs = amtPrcs * 10;
			}
		
			if( Value == 1 )
			{
				invAmt = Math.round(invAmt * (vatXchRt / 100) * amtPrcs) / amtPrcs;
				sheetObj.SetCellValue(Row, "vat_dtl_amt", invAmt, 0);
				sheetObj.SetCellEditable(Row, "vat_dtl_amt",1);
			}
			else
			{
				sheetObj.SetCellValue(Row, "vat_dtl_amt", 0);
				sheetObj.SetCellEditable(Row, "vat_dtl_amt",0);
			}
			amtReCalculate();
		}
		
		if( colName == "vat_dtl_amt" )
		{
			amtReCalculate();
		}
		
	}
	
	
	function sheet<%=i+1%>_OnSearchEnd(sheetObj,errMsg){
		for ( var idx = 1; idx <= sheetObj.RowCount; idx++ )
  		{
  			if( sheetObj.GetCellValue(idx,"vat_dtl_chk") == 1 )
			{
				sheetObj.SetCellEditable(idx, "vat_dtl_amt", 1);
			}
			else
			{
				sheetObj.SetCellEditable(idx, "vat_dtl_amt", 0);
			}
		}
	}
	
	<%-- function sheet<%=i+1%>_OnMouseDown(Button, Shift, X, Y){
		var curCol = sheetObjects[<%=i%>].MouseCol;
		var curRow = sheetObjects[<%=i%>].MouseRow;

		if ( curCol == 53 && curRow == 0 && sheetObjects[<%=i%>].CheckAll(53) == 1 )
		{
			sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 0;
			
			for ( var idx = 1; idx <= sheetObjects[<%=i%>].RowCount; idx++ )
			{
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 0;
				sheetObjects[<%=i%>].CellEditable(idx, "vat_dtl_chk") = true;
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 0;
			}
		}
		else if ( curCol == 53 && curRow == 0 && sheetObjects[<%=i%>].CheckAll(53) == 0 )
		{
			for ( var idx = 1; idx <= sheetObjects[<%=i%>].RowCount; idx++ )
			{
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 1;
				sheetObjects[<%=i%>].CellEditable(idx, "vat_dtl_chk") = false;
			}
			
			sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 1;
		}
	} --%>
	

<% } %>
-->
</script>