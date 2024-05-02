<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0045.jsp
*@FileTitle  : Receivable Invoice Inquiry and Cancel 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0045Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strQtyMonth	= "";
	String strOfc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd  = account.getOfc_cd();
		strQtyMonth = EesLse0045Event.getCurrAddMonths("yyyy-MM", -1);

		event = (EesLse0045Event)request.getAttribute("Event");
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
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>" id="ofc_cd" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_cancel" 	id="btn_cancel">Cancel</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="80">
				<col width="60">
				<col width="60">
				<col width="*">
			</colgroup>
			<tr>
				<th>Revenue Month</th>
				<td><input type="text" name="qty_yrmon" caption="Cost Month" style="width:75px; text-align:center; ime-mode:disabled;" class="input1" value="<%= strQtyMonth %>" maxlength="7" dataformat="ym" required="required" id="qty_yrmon" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
				<th>Lessee</th>
				<td><!--  
				--><input type="text" name="vndr_seq" caption="Lessor" style="width:60px;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="6" dataformat="num" id="vndr_seq" /><!--  
				--><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button><!--  
				--><input type="text" name="vndr_abbr_nm" style="width:100px;text-align:center;" class="input2" value="" readonly="" id="vndr_abbr_nm" /><!--  
				--><input type="text" name="vndr_nm" style="width:341px;" class="input2" value="" readonly="" id="vndr_nm" /></td>
			</tr>
			<tr>
				<th>Invoice No.</th>
				<td><input type="text" name="inv_no" caption="Invoice No." style="width:105px;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="12" onkeypress="javascript:goKeyCheck();" dataformat="engup" id="inv_no" /> </td>
				<th>Invoice Status</th>
				<td><select name="bl_inv_if_flg" caption="Invoice Status" style="width:89px;" class="input"><!--  
				--><option value="" selected>All</option><!--  
				--><option value="Y">SAKURA I/F</option><!--  
				--><option value="N">Not I/F</option><!--  
				--><option value="E">INV ERR</option><!--  
				--></select></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>