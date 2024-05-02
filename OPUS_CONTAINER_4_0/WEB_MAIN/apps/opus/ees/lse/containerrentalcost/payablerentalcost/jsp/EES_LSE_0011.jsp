<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0011.jsp
*@FileTitle  : Operational Lease Payable Invoice Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0011Event"%>
<%@ page import="com.clt.apps.opus.ees.lse.lsecommon.LSEUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0011Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsrId	    = "";
	String strUsrNm	    = "";
	String strUsrOfcCd  = "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerRentalCost.PayableRentalCost");

	//LP Term Lessor List를 가져오기위한 선언 
	String[] vndrSeq = null;		    //vndr_seq

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsrId     = account.getUsr_id();
		strUsrNm     = account.getUsr_nm();
		strUsrOfcCd  = account.getOfc_cd();

		event = (EesLse0011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST		
		vndrSeq 	= LSEUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("VNDR_SEQ"), false);


	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

	var vndrSeqComboValue = "<%=vndrSeq[0]%>";
	var vndrSeqComboText  = "<%=vndrSeq[1]%>";

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
<input type="hidden" name="usr_id" value="<%= strUsrId %>" id="usr_id" />
<input type="hidden" name="usr_ofc_cd" value="<%= strUsrOfcCd %>" id="usr_ofc_cd" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="gen_pay_term_cd" id="gen_pay_term_cd" />
<input type="hidden" name="cr_amt" value=""  id="cr_amt" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	-->
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->



<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30">
				<col width="260">
				<col width="60">
				<col width="60">
				<col width="*">
			</colgroup>
			<tr>
				<th style="display:none">Lessor</th>
				<td style="display:none"><script type="text/javascript">ComComboObject("tmp_vndr_seq", 2, 220, 0, 1, 1, false);</script></td>
				<!-- <th>AGMT No.</th>
			    <td><input type="text" style="width:72px;text-align:center;" name="agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly id="agmt_cty_cd" /> 
			   <input type="text" style="width:96px;text-align:center" name="agmt_seq" class="input" value="" maxlength="6" dataformat="num" id="agmt_seq" /> 
			    --><!--  
			   <input type="text" name="contract_no" style="width:100px;" class="input2" readonly id="contract_no" /></td> -->
			    
			    <th>Lessor</th>
			    <td><input type="text" style="width:72px;text-align:center;"  name="vndr_seq" value="" class="input1" dataformat="num" maxlength="6" id="vndr_seq" /><!--  
			    --><button type="button" id="btns_search3" name="btns_search3" class="input_seach_btn"></button><!--  
			    --><input type="text" name="abbr_nm" style="width:67px;" class="input2" readonly id="abbr_nm" /><!--  
			    --><input type="text" name="vndr_nm" style="width:274px;" class="input2" readonly id="vndr_nm" /></td>
				<th>Payment Period</th>
				<td><!--  
				--><input type="text" name="bil_fm_dt" caption="Payment Period" style="width:80px;text-align:center;" value="" dataformat="ymd" class="input1" !cofield="bil_fm_dt" required="" id="bil_fm_dt" /><!--  
				-->~&nbsp;<!--  
				--><input type="text" name="bil_to_dt" caption="Payment Period" style="width:80px;text-align:center;" value="" dataformat="ymd" class="input1" !cofield="bil_to_dt" required="" id="bil_to_dt" /><!--  
				--><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
</div>
<div class="wrap_result bg">
	<div class="opus_design_grid" id="mainTable">
		<span style="width:15px;height:20px;text-align:left;background-color: #27415d;line-height:25px;line-width:25px;padding: 2px 0px 6px;"><button type="button" class="btn_down" name="btn_minimize1" id="btn_minimize1"></button></span>
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--  
		--><button type="button" class="btn_normal" name="btn_RowDelete"  	id="btn_RowDelete">Row Delete</button><!--  
		--><button type="button" class="btn_normal" name="btn_SoCreate"  	id="btn_SoCreate">Save</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="mainTable">
	<span style="width:15px;height:20px;text-align:left;background-color: #27415d;line-height:25px;line-width:25px;padding: 2px 0px 6px;"><button type="button" class="btn_down" name="btn_minimize2" id="btn_minimize2"></button></span>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_InvoiceCreation" id="btn_InvoiceCreation">Invoice Creation</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="220">
				<col width="60">
				<col width="*">
			</colgroup>
			<tr>
				<th>Total Q'ty</th>
				<td><input type="text" name="lse_op_qty" style="width:80px;text-align:right;" value="" class="input2" dataformat="num" readonly id="lse_op_qty" /></td>
				<th>Total Amount</th>
				<td><input type="text" name="pay_amt" style="width:105px;text-align:right;" value="" class="input2" dataformat="float" readonly id="pay_amt" /></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="140">
				<col width="120">
				<col width="160">
				<col width="120">
				<col width="120">
				<col width="120">
				<col width="120">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<th>RCV Date</th>
				<td><input type="text" name="inv_rcv_dt" style="width:80px;text-align:center;" class="input1" dataformat="ymd" value="" id="inv_rcv_dt" /><button type="button" id="btns_calendar3" name="btns_calendar3" class="calendar ir"></button></td>
				<th>Issue Date</th>
				<td><input type="text" name="inv_iss_dt" style="width:80px;text-align:center;" class="input1" dataformat="ymd" value="" id="inv_iss_dt" /><button type="button" id="btns_calendar4" name="btns_calendar4" class="calendar ir"></button>
				<!--/
				<input type="text" name="inv_eff_dt" style="width:80px;text-align:center;" class="input2" value="" readonly id="inv_eff_dt" />
				--></td>
				<th>Invoice OFC.</th>
				<td><input type="text" name="inv_ofc_cd" style="width:70px;text-align:center" class="input2" value="" readonly id="inv_ofc_cd" /></td>
				<th>Cost OFC.</th>
				<td><input type="text" name="cost_ofc_cd" style="width:70px;text-align:center" class="input1" maxlength="6" dataformat="engup" value="" id="cost_ofc_cd" /><button type="button" id="btn_Office" name="btn_Office" class="input_seach_btn"></button></td>
				<th>V.A.Tax</th>
	            <td><input type="text" dataformat="float" pointcount="2" name="inv_vat_amt" readonly style="width:80px;text-align:right;" class="input" id="inv_vat_amt" value="" /><button type="button" id="btn_VaTax" name="btn_VaTax" class="input_seach_btn"></button> </td>
			</tr>
			<tr>
				<th>Currency</th>
				<td><input type="text" name="curr_cd" caption="Currency" style="width:80px;text-align:center;" class="input1" value="" maxlength="3" dataformat="engup" id="curr_cd" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
				<th>Net Amount</th>
				<td><input type="text" name="inv_amt" style="width:80px;text-align:right" class="input2" value="" readonly id="inv_amt" /><input type="hidden" name="cr_amt" style="width:80px;text-align:right" class="input2" value="" readonly id="cr_amt" /></td>
				<th>Pay Term</th>
				<td><input type="text" name="vndr_term_nm" style="width:70px;" class="input2" value="" readonly id="vndr_term_nm" /></td>
				<!-- <th>Credit Amt</th>
				<td><input type="text" name="cr_amt" style="width:80px;text-align:right" class="input2" value="" readonly id="cr_amt" /></td>
				 -->
	             <th>W.H.Tax</th>
	             <td><input type="text" dataformat="float" pointcount="2" name="whld_tax_amt" readonly style="width:70px;text-align:right;" class="input" id="whld_tax_amt" value="" /><button type="button" id="btn_WhTax" name="btn_WhTax" class="input_seach_btn"></button> </td>
	             <th>Total Amount</th>
	             <td><input type="text" dataformat="float" pointcount="2" name="inv_ttl_amt" readonly style="width:80px;text-align:right;" class="input" id="inv_ttl_amt" value="" /> </td>
			</tr>
		</table>
	</div>
	<div class="opus_design_data" style="width: 980px;">
		<table>
			<colgroup>
				<col width="60">
				<col width="*">
			</colgroup>
			<tr>
				<th>Remark</th>
				<td><textarea name="inv_rmk" id="inv_rmk" style="width:100%;ime-mode:disabled;resize:none;" rows="3"></textarea></td>
			</tr>
		</table>
	</div>
</div>

</form>