<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0126.jsp
*@FileTitle  : JO TPB Invoice Creation
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
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0126Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	EsdTpb0126Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count
	
	Map<String,String> rowSet = null;
	Map<String,String> rowSetOtsGrpInfo = null;
	Map<String,String> rowSetIndiaTaxInfo = null;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	
	
	String s_length_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("s_length_n3pty_bil_tp_cd")).trim();
	int s_length_n3pty_bil_tp_cd_int = 1;    //Sheet Maxinum count
	try {
		s_length_n3pty_bil_tp_cd_int = Integer.parseInt(s_length_n3pty_bil_tp_cd);
	}catch(Exception e) {
		s_length_n3pty_bil_tp_cd_int = 1;
		out.println(e.toString());
	}
	String s_dao_n3pty_no = JSPUtil.getNull(request.getParameter("s_dao_n3pty_no"));
	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code")); 
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd")); 
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Jocasemanage.Joinvoicemanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	ofc_cd = account.getOfc_cd();
	   	//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0126Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		if (eventResponse != null) {
			rowSet = eventResponse.getETCData();
			if(rowSet != null){
				 rowCount = eventResponse.getDataCntList().size();
			} // end if
			rowSetOtsGrpInfo = eventResponse.getETCData();
			if(eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
				s_length_n3pty_bil_tp_cd_int = Integer.parseInt(rowSetOtsGrpInfo.get("length_n3pty_bil_tp_cd"));
			}
		} // end if
	}catch(Exception e) {
		out.println(e.toString());
	}
	if(event != null){
		if(event.getAttribute("s_dao_n3pty_no") != null){
			s_dao_n3pty_no = event.getAttribute("s_dao_n3pty_no").toString();
		}
	}

	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	// String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level 
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code  

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

<%=OfficeCodeMgr.getOfficeCodeListToJS("000006", "TPB")%>	
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="load_num" value="0" id="load_num" />
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
<input type="hidden" name="prcs_cnt" id="prcs_cnt" />
<input type="hidden" name="s_ida_tax_seq" id="s_ida_tax_seq" />
<input type="hidden" name="s_dao_n3pty_bil_tp_cd" id="s_dao_n3pty_bil_tp_cd" />

<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="s_dao_n3pty_no" value="<%=s_dao_n3pty_no%>">
<input type="hidden" name="s_trd_party_code" value="<%=s_trd_party_code%>">
<input type="hidden" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>">
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="<%=s_length_n3pty_bil_tp_cd%>">

<%=JSPUtil.getIncludeString(request) %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title">JO TPB Invoice Creation</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn ">
		<button class="btn_normal" name="btn_confirm" id="btn_confirm" type="button">Confirm</button><!--
		--><button class="btn_normal" name="btn_erpInterface" id="btn_erpInterface" type="button"  style="display:none;">AR Interface</button><!--
		--><button class="btn_normal" name="btn_revisiondetail" id="btn_revisiondetail" type="button"  style="display:none;">Revision Detail</button><!--
		--><button class="btn_normal" name="btn_preview" id="btn_preview" type="button">Preview</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<!-- <div class="location">	
		<span id="navigation">Service Management > Booking/Documentation > Booking > Special Cargo > RF Cargo Application</span>
	</div> -->
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tr>
				<th>Invoice No.</th>
				<td><input name="s_n3pty_inv_no" type="text" class="input2" style="width:95px;.background-color:#EEEEEE;" value="" readonly id="s_n3pty_inv_no" /><input type="text" class="input" style="width:33px;.background-color:#EEEEEE;" name="s_n3pty_inv_rmd_cd" value="" readonly id="s_n3pty_inv_rmd_cd" /> </td>
				<th>Currency</th>
				<td><select class="input1" style="width:95px;" name="s_curr_cd" caption="Currency" onchange='changeCurrency(this.value)'></select></td>
				<td class="btn2_left"></td><td class="btn2" style="display:none" name="btn_invoicesheetset" id="btn_invoicesheetset">Invoice Setting</td>
				<th>Fax Number</th>
				<td><input class="input2" type="text" style="width:117px;" name="s_fax_no" maxlength="20" readonly id="s_fax_no" /> </td>
				<td><input type="checkbox" name="s_vat_xch_rt_chk" class="trans" onclick="amtReCalculate();" style="display:none" value="Y" id="s_vat_xch_rt_chk" /> </td>
			</tr>
		</table>
	</div>
	<div class="opus_design_inquiry wFit">
		<table class="grid_2">
			<tr class="align_center">
				<th class="align_center" style="width:450px;"><strong>Bill To</strong></th>
				<th class="align_center"><strong>Code</strong></th>
				<th class="align_center"><strong>Reference</strong></th>
				<th class="align_center"><strong>Due Date</strong></th>
				<th class="align_center"><strong>VAT No.</strong></th>
   			</tr>
   			<tr>
   				<td>
   					<table>
   						<tr>
   							<td class="noinput"><input name="s_usr_inp_ctnt1" type="text" class="input" style="width:447px;" id="s_usr_inp_ctnt1" /></td>
   						</tr>
   						<tr>
							<td><input name="s_vndr_cust_nm" type="text" class="noinput" style="width:447px;" readonly id="s_vndr_cust_nm" /></td>
						</tr>
						<tr>
							<td class="noinput"><input name="s_vndr_cust_addr" type="text" class="input" style="width:447px;" maxlength="100" id="s_vndr_cust_addr" /></td>
						</tr>
						<tr class="align_right">	
							<td class="noinput">City : <input name="s_cty_nm" type="text" class="input" style="width:120px" maxlength='50'>	State : <input name="s_ste_cd" type="text" class="input" style="width:45px" maxlength='3'> Zip : <input name="s_zip_cd" type="text" class="input" style="width:80px" maxlength='10'></td>
						</tr>
						<tr>
							<td class="noinput"><input name="s_usr_inp_ctnt2" type="text" class="" style="width:447px;" maxlength="100" id="s_usr_inp_ctnt2" /></td>
   						</tr>
   					</table>
   				</td>				
				<td valign="top"><input name="s_trd_party_code_detail" type="text" class="noinput" style="width:100%;" readonly id="s_trd_party_code_detail"/></td>
				<td><textarea name="s_vndr_cust_ref_rmk" class="" style="width:100% ;height:100% ;overflow-y:auto;overflow-x:auto" onblur="tpb_chkLenByByte(this,50,'Reference')"></textarea></td>
				<td>
				<input name="s_rcv_due_dt" id="s_rcv_due_dt" type="text" class="noinput" style="width:80px" maxlength="10" value="<%=DateTime.addDays(currentDay, 30, "yyyy-MM-dd")%>" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
				<td><textarea name="s_rgst_no" class="" style="width:100%;height:100%;overflow-y:auto;overflow-x:auto" onblur="tpb_chkLenByByte(this,20,'VAT No.')"></textarea></td>

		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<% for(int i=0;i<s_length_n3pty_bil_tp_cd_int;i++){ %>
	
		<div class="opus_design_tab">
			<script type="text/javascript">	ComTabObject('tab<%=i+1%>')</script>	
		</div>
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet<%=i+1%>')</script>		
		</div>
		<!-- opus_design_grid(E) -->
	<% } %>
		<div class="opus_design_inquiry" style="width:500px">
			<table class="grid_2">
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Net Amount</th>
					<th> <input name="s_net_amt" type="text" class="noinput" style="width:95px;;text-align:right" readonly id="s_net_amt" /></th>
				</tr>
				<tr>
					<th>Administration Charge</th>
					<th> <input name="s_add_amt" type="text" class="noinput" style="width:95px;;text-align:right" readonly id="s_add_amt" /> </th>
				</tr>
				<tr>
					<th>Deducted Amount</th>
					<th> <input name="s_ddct_amt" type="text" class="noinput" style="width:95px;;text-align:right" readonly id="s_ddct_amt" /> </th>
				</tr>
				<tr>
					<th>VAT Amount</th>
					<th> <input name="s_vat_amt" type="text" class="noinput" style="width:95px;;text-align:right" onclick="this.select()" onblur="amtReCalculate()" readonly id="s_vat_amt" /> </th>
				<tr>
					<th>Total Amount</th>
					<th> <input name="s_total_amt" type="text" class="noinput" style="width:95px;;text-align:right" readonly id="s_total_amt" /> </th>
				</tr>
			</table>
		</div>
		
		<h3 class="title_design">Descriptions</h3>
		
		<div class="opus_design_data" >
			<table>      			
	   			<tr>
	   				<td><textarea name="s_inv_desc" class="input3"  style="width:977;height=35;overflow-y:auto;overflow-x:auto"<%if(cnt_cd.equals("FR")){ %>onblur="tpb_chkLenByByte(this,500,'Descriptions')"	<%} else{ %> onblur="tpb_chkLenByByte(this,1000,'Descriptions')"<%} %>></textarea></td>
	   			</tr>
	   		</table>
		</div>
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet0')</script>		
		</div>
		<!-- opus_design_grid(E) -->		
</div>

<div id='div_processing' name='div_processing' style='position:absolute; left:0;top:0;z-index:100;display:none;width:100%;height:100%'>
	<table border='0' bordercolor='red' cellpadding='0' cellspacing='0' width='100%' height='100%'>
		<tr><td align='center' height='10'>&nbsp;</td></tr>
		<tr><td align='center' height='100'><img src="/opuscntr/img/opus/processing.gif"></td></tr>
		<tr><td align='center' height='*'>&nbsp;</td></tr>
	</table>
</div>
<SCRIPT LANGUAGE="javascript">
<!--
	  /*
		Showing screent of user input info by event
	  */
<% for(int i=0;i<s_length_n3pty_bil_tp_cd_int;i++){ %>
	function sheet<%=i+1%>_OnPopupClick(sheetObj,Row,Col,Value){
		var colName = sheetObj.ColSaveName(Col);
		if(colName == "occr_dt" || colName == "damage_dt"
			|| colName == "lst_free_dt" || colName == "pkup_dt"){
			 var cal = new ComCalendarGrid();
			 cal.select(sheetObj, Row,Col,'yyyy-MM-dd');
		}
		if(colName == "new_vsl_cd"){
			var param = '?sdate='+form.sdate.value+'&edate='+form.edate.value;
			comPopupInSheet('/opuscntr/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD_sheet', '1,0,1,1,1,1,1,1',Row,Col);
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
//						ComShowCodeMessage("TPB90032","Invoice AMT","Original AMT"); // 이하
//						sheetObj.SetCellValue(Row, colName, sheetObj.GetCellValue(Row, "original_inv_dtl_amt"), 0);
//						return;
						
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
	
	function sheet<%=i+1%>_OnMouseDown(Button, Shift, X, Y){
		var curCol = sheetObjects[<%=i%>].MouseCol;
		var curRow = sheetObjects[<%=i%>].MouseRow;

		if ( curCol == 55 && curRow == 0 && sheetObjects[<%=i%>].CheckAll(55) == 1 )
		{
			sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 0;
			
			for ( var idx = 1; idx <= sheetObjects[<%=i%>].RowCount; idx++ )
			{
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 0;
				sheetObjects[<%=i%>].CellEditable(idx, "vat_dtl_chk") = true;
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 0;
			}
		}
		else if ( curCol == 55 && curRow == 0 && sheetObjects[<%=i%>].CheckAll(55) == 0 )
		{
			for ( var idx = 1; idx <= sheetObjects[<%=i%>].RowCount; idx++ )
			{
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 1;
				sheetObjects[<%=i%>].CellEditable(idx, "vat_dtl_chk") = false;
			}
			
			sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 1;
		}
	}

<% } %>
-->
</SCRIPT>
</form>
