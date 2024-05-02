<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0250.jsp
*@FileTitle  : Open Interface Invoices
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0250Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0250Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableInvoiceSC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSap0250Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Interface & Batch Execute</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="200" />	
				<col width="80" />			
				<col width="140" />				
				<col width="80" />	
				<col width="100" />
				<col width="100" />	
				<col width="100" />
				<col width="*" />				
		   </colgroup> 
		   <tbody>
				<tr>
					<th style="text-align:left;" >1. Front S/O and A/P Invoice I/F</th>
		            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<th>Source Type</th>
                    <td><select name=value0>
                     		<option value="A/P">A/P</option>
                     		<option value="S/O" selected>S/O</option>
                     	</select>
                    </td>                            
                    <th>CSR No.</th>
                    <td><input type="text" style="width:200px;" name="value1" id="value1" class="input" dataformat="engup" value="" caption="CSR No"><!-- 12SLGBBB13052200001 --></td>
                    <td></td><td></td><td></td>
                    <td><button class="btn_normal" name="btn_save" id="btn_save" type="button">Execute</button></td>
				</tr>
				<tr class ="line_bluedot"><th><td colspan=9></td></th></tr>
				
				<tr>
					<th style="text-align:left;" >2. R3OP01 SAKURA Payment I/F</th>
		            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<th></th>
                    <td></td>                            
                    <th></th>
                    <td></td>
                    <td></td><td></td><td></td>
                    <td><button class="btn_normal" name="btn_payIF" id="btn_payIF" type="button">Execute</button></td>
				</tr>
				<tr class ="line_bluedot"><th><td colspan=9></td></th></tr>
				
				<tr>
					<th style="text-align:left;" >3. OPR305 SAKURA INVOICE I/F</th>
		            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<th>Sakura I/F CSR No.</th>
                    <td><input type="text" style="width:200px;" name="value2" id="value2" class="input" dataformat="engup" value="" caption="IF CSR No"><!-- 12SLGBBB13052200001 --></td>
                    <td></td><td></td><td></td><td></td><td></td>
                    <td><button class="btn_normal" name="btn_if_sakura" id="btn_if_sakura" type="button">Execute</button></td>
				</tr>
				<tr class ="line_bluedot"><th><td colspan=9></td></th></tr>
				
				<tr>
					<th style="text-align:left;" >4. OPR305 SAKURA INV I/F (INV DATE BASE)</th>
		            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<th>I/F Inv Date</th>
					<td><input type="text" style="width:80px;" value="" name="value3" caption="start date" id="value3" dataformat="ymd" maxlength="10" class="input"><!-- 
                    --><button type="button" class="calendar" name="btns_calInvFr" id="btns_calInvFr"></button>~&nbsp;
                    	<input type="text" style="width:80px" value="" name="value4" caption="end date" id="value4" dataformat="ymd" maxlength="10" class="input"><!-- 
                    --><button type="button" class="calendar" name="btns_calInvTo" id="btns_calInvTo"></button>
                    </td>
                    <td></td><td></td><td></td><td></td><td></td>
                    <td><button class="btn_normal" name="btn_all_if_sakura" id="btn_all_if_sakura" type="button">Execute</button></td>
				</tr>
				<tr class ="line_bluedot"><th><td colspan=9></td></th></tr>
				
				<tr>
					<th style="text-align:left;" >5. ASA Invoice Interface to AR</th>
		            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<th>ASA I/F CSR No.</th>
                    <td><input type="text" style="width:200px;" name="value5" id="value5" class="input" dataformat="engup" value="" caption="ASA CSR No"><!-- 12SLGBBB13052200001 --></td>
                    <td></td><td></td><td></td><td></td><td></td>
                    <td><button class="btn_normal" name="btn_asaIF" id="btn_asaIF" type="button">Execute</button></td>
				</tr>

		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hidSheetDiv"  style="display:none">
		<script type="text/javascript">ComSheetObject('sheet');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

</form>
