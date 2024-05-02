<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0012.jsp
*@FileTitle  : Rental payable invoice inquiry and Cancel
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
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0012Event)request.getAttribute("Event");
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
<input type="hidden" name="tysz" id="tysz" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="115">
				<col width="*">
			</colgroup>
			<tr>
				<th>Search Type</th>
				<td><!--  
				--><select style="width:120px;" name="search_tp" class="input1"><!--  
				--><option value="01" selected>Cost Month</option><!--  
				--><option value="02" >Invoice Month</option><!--  
				--><option value="03" >Invoice No</option><!--  
				--><option value="04" >Register No</option></select></td>			   
 				<td id="fixLayer1" style="position:absolute; visibility:visible;"><input type="text" name="cost_st_month" style="width:60px;ime-mode:disabled;text-align:center;" value="" class="input1" maxlength="6" dataformat="ym" id="cost_st_month" /><!--  
 				--><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>&nbsp;~&nbsp;<!--  
 				--><input type="text" name="cost_ed_month" style="width:60px;ime-mode:disabled;text-align:center;" value="" class="input1" maxlength="6" dataformat="ym" id="cost_ed_month" /><!--  
 				--><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
 				<td id="fixLayer2" style="position:absolute; visibility:hidden;"><input type="text" name="invoice_st_month" style="width:60px;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="ym" id="invoice_st_month" /><!--  
 				--><button type="button" id="btns_calendar3" name="btns_calendar3" class="calendar ir"></button>&nbsp;~&nbsp;<!--  
 				--><input type="text" name="invoice_ed_month" style="width:60px;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="ym" id="invoice_ed_month" /><!--  
 				--><button type="button" id="btns_calendar4" name="btns_calendar4" class="calendar ir"></button></td>
				<td id="fixLayer3" style="position:absolute; visibility:hidden;"><input type="text" name="invoice_no" style="width:100px;" value="" class="input1" maxlength="20" id="invoice_no" /></td>
                <td id="fixLayer4" style="position:absolute; visibility:hidden;"><input type="text" name="register_no" style="width:100px;" value="" class="input1" maxlength="20" id="register_no" /></td>	
			</tr>	
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>	
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="76">
				<col width="420">
				<col width="70">
				<col width="200">
				<col width="100">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
			    <th>Lessor</th>
			    <td><input type="text" style="width:70px;text-align:center;" name="vndr_seq" value="" class="input" dataformat="num" maxlength="6" id="vndr_seq" /><!--  
			    --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><!--  
			    --><input type="text" name="vndr_nm" style="width:270px;" class="input2" readonly="" id="vndr_nm" /></td>
			    <th>Lease Term</th>
			    <td><script type="text/javascript" >ComComboObject('combo1', 1, 150, 1 );</script><input type="hidden" name="lstm_cd" value="" id="lstm_cd" /></td>
                <th>Lease Payment Type</th>
                <td><script type="text/javascript" >ComComboObject('lse_pay_tp_cd', 2, 70, 1 );</script><input type="hidden" name="lse_pay_tp_cd" value="" id="lse_pay_tp_cd" /></td>
			    <th>Invoice User</th>
			    <td><input type="text" name="invoice_user" style="width:80px;" maxlenght="20" class="input" id="invoice_user" /></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>