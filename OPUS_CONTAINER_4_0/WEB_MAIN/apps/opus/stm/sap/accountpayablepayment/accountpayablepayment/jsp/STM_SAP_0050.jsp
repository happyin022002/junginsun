<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0050.jsp
*@FileTitle  : Payment Schedule Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0050Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0050Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg    = "";   				//에러메세지
	int rowCount	    = 0;					//DB ResultSet Count of list

	String strUsr_id    = "";
	String strUsr_nm    = "";
	String strUsr_ofc   = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (StmSap0050Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
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

<form  name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
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
				<col width="60" />				
				<col width="200" />				
				<col width="60" />				
				<col width="420" />				
				<col width="60" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
                     <th>Office</th>
                     <td><input type="text" style="width:80px;" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" id="ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button></td>
                     <th>Due Date</th>
                     <td><input type="text" style="width:80px;" class="input1" name="due_dt_fr" dataformat="ymd" maxlength="10" required cofield="due_dt_to" caption="start date" id="due_dt_fr"/><button type="button" id="btns_calDueFr" name="btns_calDueFr" class="calendar ir"></button>~&nbsp;<!-- 
                         --><input type="text" style="width:80px;" class="input1" name="due_dt_to" dataformat="ymd" maxlength="10" required cofield="due_dt_fr" caption="end date" id="due_dt_to" /><button type="button" id="btns_calDueTo" name="btns_calDueTo" class="calendar ir"></button></td>
                     <th>Pay Group</th>
                     <td><input type="text" style="width:160px;" class="input" name="ap_pay_grp_lu_cd" maxlength="25" dataformat="engup" id="ap_pay_grp_lu_cd" /><button type="button" id="btns_search_paygroup" name="btns_search_paygroup" class="input_seach_btn"></button></td>
                 </tr>
                 <tr>
                     <th>Currency</th>
                     <td><script type="text/javascript">ComComboObject('inv_curr_cd', 1, 80, 0, 0, 0, false, 1);</script></td>
                     <th>Supplier</th>
                     <td><input type="text" style="width:80px;" class="input" name="vndr_no" maxlength="6" dataformat="engup" id="vndr_no" onchange="vndr_no_onchange();"/><button type="button" id="btns_search_supplier" name="btns_search_supplier" class="input_seach_btn"></button><!-- 
                      --><input type="text" style="width:260px;" class="input2" name="vndr_nm" maxlength="100" dataformat="engup" style="ime-mode:disabled" readonly></td>
                     <th>Payment Method</th>
                     <td><input type="text" style="width:160px;" class="input" name="pay_mzd_lu_cd" maxlength="20" dataformat="engup" id="pay_mzd_lu_cd" /><button type="button" id="btns_search_paymethod" name="btns_search_paymethod" class="input_seach_btn"></button></td>
                 </tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>

<%@ include file="/bizcommon/include/common_opus.jsp"%>