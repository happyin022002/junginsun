<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0050.jsp
*@FileTitle  : Inquiry of Bank Balance
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0130Event"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0130Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0130Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg    = "";   				//에러메세지

	String strUsr_id    = "";
	String strUsr_nm    = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSap0130Event)request.getAttribute("Event");
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
<form  name="form">
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
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="45">				
				<col width="125">				
				<col width="120">				
				<col width="160">				
				<col width="220">				
				<col width="70">				
				<col width="*">				
		   </colgroup>
		   <tbody>
		   		<tr>
					<th class="sm">Office</th>
					<td class="sm"><!--
					--><input type="radio" name="ctrl_ofc" value="AP" class="trans" id="ctrl_ofc" checked><label for="ctrl_ofc">AP</label><!--
					--><input type="radio" name="ctrl_ofc" value="AR" id="ctrl_ofc_1" class="trans"><label for="ctrl_ofc_1">AR</label><!--
					--><input type="radio" name="ctrl_ofc" value="ALL" id="ctrl_ofc_2" class="trans"><label for="ctrl_ofc_2">ALL</label></td>
           			<td class="sm"><input type="text" style="width:80px;text-align:left;" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" id="ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button></td>
           			<th>Inquiry Date</th>
	                <td><input type="text" style="width:90px;text-align:left;" class="input1" name="bank_stmt_dt" dataformat="ymd" maxlength="10" id="bank_stmt_dt" /><button type="button" id="btns_calStmtDt" name="btns_calStmtDt" class="calendar ir"></button></td>
	                <th>Currency</th>
	                <td><script type="text/javascript">ComComboObject('inv_curr_cd', 1, 70, 0, 0, 0, false, 1);</script>
		   		</tr>
		   		
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">				
				<col width="240">				
				<col width="122">				
				<col width="*">				
		   </colgroup>
			<tbody>
				<tr>
	   			    <th>Account Type(L)</th>
                    <td><script type="text/javascript">ComComboObject('bank_acct_tp_mn_cd', 2, 50, 0, 0, 0, false ,1);</script><input type="text" style="width:120;" class="input2"  name="bank_acct_tp_mn_desc" readOnly></td>	                            
                    <th>Account Type(M)</th>
                    <td><script type="text/javascript">ComComboObject('bank_acct_tp_sub_cd', 2, 50, 0, 0, 0, false ,1);</script><input type="text" style="width:120;" class="input2"  name="bank_acct_tp_sub_desc" readOnly></td>   
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
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
<%@ include file="/bizcommon/include/common_opus.jsp"%>