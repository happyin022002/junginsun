<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_LSE_0007.jsp
*@FileTitle  : Container Rental Charge Creation
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/07/03 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0007Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsrId	    = "";
	String strUsrNm	    = "";
	String strUsrOfcCd  = "";
	String strCostYrmon = "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsrId     = account.getUsr_id();
		strUsrNm     = account.getUsr_nm();
		strUsrOfcCd  = account.getOfc_cd();
		strCostYrmon = DateTime.addMonths(DateTime.getShortDateString(), -1, "yyyyMMdd").substring(0, 6);

		event = (EesLse0007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
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
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="checkedRows" id="checkedRows" />
<input type="hidden" name="checkedChgSeqs" id="checkedChgSeqs" />
<input type="hidden" name="gen_pay_term_cd" id="gen_pay_term_cd" />
<input type="hidden" name="cost_yrmon" value="<%= strCostYrmon %>" id="cost_yrmon" />
<input type="hidden" name="usr_id" value="<%= strUsrId %>" id="usr_id" />
<input type="hidden" name="usr_ofc_cd" value="<%= strUsrOfcCd %>" id="usr_ofc_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_accent" name="btn_ChargeCreation" 	id="btn_ChargeCreation">Monthly Charge Creation</button><!--
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button>	 
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="60"/>
					<col width="300"/>
					<col width="60"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Cost Month</th>
					<td><input type="text" name="chg_cost_yrmon" caption="Cost Month" style="width:58px;text-align:center;" value="" class="input1" maxlength="6" dataformat="ym" required="" id="chg_cost_yrmon" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					<th>Lessor</th>
					<td><input type="text" name="vndr_seq" caption="Lessor" style="width:55px;text-align:center;" class="input1" value="" dataformat="num" maxlength="6" required="" id="vndr_seq" /><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button><input type="text" name="vndr_nm" caption="Lessor" style="width:270px;" class="input2" value="" readonly="" id="vndr_nm" /></td>
					<th>Term</th>
					<td><script type="text/javascript">ComComboObject('lstm_cd', 1, 75, 0);</script>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-weight:bold">Lease Payment Type&nbsp;<script type="text/javascript" >ComComboObject('lse_pay_tp_cd', 2, 70, 1 );</script><input type="hidden" name="lse_pay_tp_cd" value="" id="lse_pay_tp_cd" /></span>
                </td>
				</tr>	

			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<span style="width:15px;height:20px;text-align:left;background-color: #27415d;line-height:25px;line-width:25px;padding: 2px 0px 6px;"><button type="button" class="btn_down" name="btn_minimize1" id="btn_minimize1"></button></span>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_FileImport" id="btn_FileImport">Inv Import</button><!--
			--><button type="button" class="btn_normal" name="btn_ChgCreate" 	id="btn_ChgCreate">Charge Creation</button><!-- 
			--><button type="button" class="btn_normal" name="btn_ChgDelete" 	id="btn_ChgDelete">Charge Delete</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_DownExcel01" id="btn_DownExcel01">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->

	<div class="opus_design_grid clear" >
	<span style="width:10px;height:20px;text-align:left;background-color: #27415d;line-height:25px;line-width:25px;padding: 2px 0px 6px;"><button type="button" class="btn_down" name="btn_minimize2" id="btn_minimize2"></button></span>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Audit" id="btn_Audit">Audit & Result</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_DownExcel02" id="btn_DownExcel02">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<span style="width:10px;height:20px;text-align:left;background-color: #27415d;line-height:25px;line-width:25px;padding: 2px 0px 6px;"><button type="button" class="btn_down" name="btn_minimize3" id="btn_minimize3"></button></span>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_InvoiceCreation" id="btn_InvoiceCreation">Invoice Creation</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_DownExcel03" id="btn_DownExcel03">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>

<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100" />				
					<col width="80" />		
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Pay Vendor</th>
					<td colspan="9"><input type="text" name="pay_vndr_seq" caption="Pay Vendor" style="width:80px;text-align:center;" class="input1" value="" dataformat="num" maxlength="6" required="" id="pay_vndr_seq" /><!-- 
						--><button type="button" id="btns_search3" name="btns_search3" class="input_seach_btn"></button><input type="text" name="pay_vndr_nm" caption="Pay Vendor" style="width:308px;" class="input2" value="" readonly="" id="pay_vndr_nm" /></td>
				</tr>	
				<tr>
					<th>RCV Date</th>
					<td><input type="text" name="inv_rcv_dt" style="width:80px;text-align:center;" class="input1" dataformat="ymd" value="" id="inv_rcv_dt" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
					<th>Issue Date</th>
					<td><input type="text" name="inv_iss_dt" style="width:80px;text-align:center;" class="input1" dataformat="ymd" value="" id="inv_iss_dt" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
					<th>Invoice OFC.</th>
					<td><input type="text" name="inv_ofc_cd" style="width:70px;text-align:center" class="input2" value="" readonly="" id="inv_ofc_cd" /></td>
					<th>Cost OFC.</th>
					<td><input type="text" name="cost_ofc_cd" style="width:70px;text-align:center" class="input1" maxlength="6" dataformat="engup" value="" id="cost_ofc_cd" /><button type="button" id="btn_Office" name="btn_Office" class="input_seach_btn"></button></td>
					<th>V.A.Tax</th>
	                <td><input type="text" dataformat="float" pointcount="2" name="inv_vat_amt" readonly style="width:80px;text-align:right;" class="input" id="inv_vat_amt" value="" /><button type="button" id="btn_VaTax" name="btn_VaTax" class="input_seach_btn"></button> </td>
				</tr>	
				<tr>
					<th>Currency</th>
					<td>
					<input type="text" name="curr_cd" caption="Currency" style="width:80px;text-align:center;" class="input1" value="" maxlength="3" dataformat="engup" id="curr_cd" /><!-- 
					 --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
					<th>Net Amount</th>
					<td><input type="text" name="inv_amt" style="width:80px;text-align:right" class="input2" value="" readonly="" id="inv_amt" /><input type="hidden" name="cr_amt" style="width:80px;text-align:right" class="input2" value="" readonly="" id="cr_amt" /></td>
					<th>Pay Term</th>
					<td><input type="text" name="vndr_term_nm" style="width:70px;" class="input2" value="" readonly="" id="vndr_term_nm" /></td>
					<th>W.H.Tax</th>
	                <td><input type="text" dataformat="float" pointcount="2" name="whld_tax_amt" readonly style="width:70px;text-align:right;" class="input" id="whld_tax_amt" value="" /><button type="button" id="btn_WhTax" name="btn_WhTax" class="input_seach_btn"></button> </td>
	                <th>Total Amount</th>
	                <td><input type="text" dataformat="float" pointcount="2" name="inv_ttl_amt" readonly style="width:80px;text-align:right;" class="input" id="inv_ttl_amt" value="" /> </td>
				</tr>	
				<tr>
					<th>Remark</th>
					<td colspan="9"><textarea name="inv_rmk" id="inv_rmk" style="width:100%;ime-mode:disabled" rows="3"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>

<!-- opus_design_inquiry(E) -->	
</form>
