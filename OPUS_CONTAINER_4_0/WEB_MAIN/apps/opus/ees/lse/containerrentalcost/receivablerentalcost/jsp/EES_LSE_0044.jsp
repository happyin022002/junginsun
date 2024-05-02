<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0044.js
*@FileTitle  : Receivable Invoice - Container List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/22
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesLse0044Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String editMode	= request.getParameter("rcv_rntl_seq").equals("") ? "F" : "T";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesLse0044Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="edit_mode" id="edit_mode" value="<%= editMode %>">
<input type="hidden" name="cost_yrmon" id="cost_yrmon" value="<%= StringUtil.xssFilter(request.getParameter("cost_yrmon")) %>">
<input type="hidden" name="rcv_rntl_seq" id="rcv_rntl_seq" value="<%= StringUtil.xssFilter(request.getParameter("rcv_rntl_seq")) %>">
<input type="hidden" name="inv_agmt_seq" id="inv_agmt_seq" value="<%= StringUtil.xssFilter(request.getParameter("inv_agmt_seq")) %>">
<input type="hidden" name="inv_lstm_cd" id="inv_lstm_cd" value="<%= StringUtil.xssFilter(request.getParameter("inv_lstm_cd")) %>">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Receivable Invoice - container List</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_Save" name="btn_Save" class="btn_normal">Save</button><!--
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="70" />
					<col width="150" />
					<col width="70" />
					<col width="300" />
					<col width="70" />
					<col width="200" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Invoice No.</th>
					<td><input type="text" name="inv_no" style="width:100px;text-align:center;" class="input2" value="<%= StringUtil.xssFilter(request.getParameter("inv_no"))%>" id="inv_no" readonly="readonly"/></td>
					<th>Lessee</th>
					<td><input type="text" name="vndr_seq" id="vndr_seq" style="width: 60px; text-align:center;" class="input2" value="<%= StringUtil.xssFilter(request.getParameter("inv_vndr_seq")) %>" readonly><input type="text" name="vndr_abbr_nm" id="vndr_abbr_nm" style="width: 190px" class="input2" value="<%= StringUtil.xssFilter(request.getParameter("inv_vndr_abbr_nm")) %>" readonly></td>
					<th>Invoice Amount</th>
					<td><input type="text" name="inv_amt" id="inv_amt" style="width: 90px; text-align:right" class="input2" value="<%= StringUtil.xssFilter(request.getParameter("fm_chg_amt")) %>" readonly><input type="text" name="curr_cd" id="curr_cd" style="width: 40px; text-align:center" class="input2" value="<%= StringUtil.xssFilter(request.getParameter("fm_curr_cd")) %>" readonly></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<% if(editMode.equals("T")) { %>
				<button type="button" class="btn_normal" id="btn_RowAdd" name="btn_RowAdd">Row Add</button>
				<button type="button" class="btn_normal" id="btn_Delete" name="btn_Delete">Delete</button>
			<% } %>
			<button type="button" class="btn_normal" id="btn_DownExcel" name="btn_DownExcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>