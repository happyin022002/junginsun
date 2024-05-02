<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0330.JSP
*@FileTitle  : Payment Detail Inquiry
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
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0330Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	StmSap0330Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		

		event = (StmSap0330Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_new" name="btn_new" class="btn_normal">New</button><!--
		--><button type="button" id="btn_downexcel" name="btn_downexcel" class="btn_normal">Down Excel</button><!--
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
				<col width="100">
				<col width="250">
				<col width="120">
				<col width="*">				
			</colgroup>
			<tr>
				<th style = "text-align:left;">Payment Office</th>
				<td><input id="ofc_cd" style="width:75px;" value="" class="input1" required="" caption="Payment Office" dataformat="engup" name="ofc_cd" maxlength="7" type="text" /><button class="input_seach_btn" name="btn_payment_office" id="btn_payment_office" type="button"></button></td>
				<th style = "text-align:left;">Supplier</th>
				<td><input id="vndr_no" style="width:75px;" value="" dataformat="engup" name="vndr_no" maxlength="7" type="text" onchange="vndr_no_onchange()"/><button class="input_seach_btn" name="btn_supplier" id="btn_supplier" type="button"></button><input id="vndr_lgl_eng_nm" style="width:225px;" class="input2" readonly value="" name="vndr_lgl_eng_nm" type="text" /></td>
			</tr> 
			<tr>
				<th style = "text-align:left;">Payment Date</th>
				<td>
					<input id="from_pay_dt" name="from_pay_dt" required class="input1" cofield="to_pay_dt" caption="start date" caption="Payment Date(from)" dataformat="ymd" style="width:75px;" value="" maxlength="8" type="text" /><!-- 
					 --><button class="calendar ir" name="btns_calendar_fr"  id="btns_calendar_fr" type="button"></button><span class="dash">~</span><!--
					 --><input name="to_pay_dt" type="text" class="input1" required cofield="from_pay_dt" caption="end date" caption="Payment Date(to)" dataformat="ymd"  class="input" style="width:75px;" value="" maxlength="8"><!--
					 --><button class="calendar ir" name="btns_calendar_to" id="btns_calendar_to" type="button"></button>
				</td> 														
				<th style = "text-align:left;">Payment Method</th>
				<td><input id="pay_mzd_lu_cd" style="width:150px;" dataformat="engup" value="" name="pay_mzd_lu_cd" maxlength="20" type="text" /><button class="input_seach_btn" name="btn_payment_method" id="btn_payment_method" type="button"></button></td>
			</tr>  
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<!-- opus_design_grid(S) -->

	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
		<script type="text/javascript" >ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>