<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0115.jsp
*@FileTitle  : TPB Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
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
<%@ page import="com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0115Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0115Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StatusInquiry.StatusInquiry");
	String ofc_cd = "";
	String n3pty_no = "";
	String ots_sts_cd = JSPUtil.getNull(request.getParameter("s_h_ots_sts_cd"));
	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code"));
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd"));
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		event = (EsdTpb0115Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level 
	boolean isReadOnly = false;
	String strReadOnly = ""; 
	String strBgColor = "";
	String flagReadOnly = JSPUtil.getNull(request.getParameter("s_readonly"));
	if ( n3pty_no.trim().equals("") || flagReadOnly.equals("Y") ) { 
		isReadOnly = true;
		strReadOnly = " readonly";
		strBgColor = ".background-color:#EEEEEE;";
	} 
    String s_direct_tpb_no = JSPUtil.getNull(request.getParameter("s_direct_tpb_no"));
    if ( s_direct_tpb_no.length() > 0 ) {
    	n3pty_no = s_direct_tpb_no;
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<input id="s_detail_n3pty_no" name="s_detail_n3pty_no" value="<%=n3pty_no%>" type="hidden" />
<input id="s_usr_ofc_cd" name="s_usr_ofc_cd" value="<%=ofc_cd%>" type="hidden" />
<input id="s_ots_sts_cd" name="s_ots_sts_cd" value="<%=ots_sts_cd%>" type="hidden" />
<input id="s_h_ots_sts_cd" name="s_h_ots_sts_cd" value="<%=ots_sts_cd%>" type="hidden" />
<input id="s_n3pty_bil_tp_cd" name="s_n3pty_bil_tp_cd" value="" type="hidden" />
<input id="s_length_n3pty_bil_tp_cd" name="s_length_n3pty_bil_tp_cd" value="1" type="hidden" />
<input id="s_trd_party_code" name="s_trd_party_code" value="<%=s_trd_party_code%>" type="hidden" />
<input id="s_h_vndr_cust_div_cd" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>" type="hidden" />
<input id="s_last_vndr_cust_div_cd" name="s_last_vndr_cust_div_cd" value="" type="hidden" />
<input id="s_vndr_cnt_cd" name="s_vndr_cnt_cd" type="hidden" />
<input id="s_vndr_seq" name="s_vndr_seq" type="hidden" />
<input id="s_cust_cnt_cd" name="s_cust_cnt_cd" type="hidden" />
<input id="s_cust_seq" name="s_cust_seq" type="hidden" />
<input id="s_n3pty_ofc_cd" name="s_n3pty_ofc_cd" type="hidden" />
<input id="toEmail" name="toEmail" type="hidden" />
<input id="s_process_close_message" name="s_process_close_message" value="" type="hidden" />
<input id="s_readonly" name="s_readonly" value="<% if(isReadOnly){out.print("Y");}%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<% if(!isReadOnly){ // %>
			 <button style="display: none" type="button" class="btn_normal" name="btn_invoicecreation" id="btn_invoicecreation">Invoice Creation</button><!-- 
			 --><button style="display: none" type="button" class="btn_normal" name="btn_settlement" id="btn_settlement">Settlement</button>
		<% } %>
		<% if(!isReadOnly){ // %>
		<% if(ofc_lvl.equals("R")){ //RHQ %>
			<button style="display: none" type="button" class="btn_normal" name="btn_cancel_process" id="btn_cancel_process">Cancel Process</button>
		<% } %>
		<% if(ofc_lvl.equals("G") || ofc_lvl.equals("")){ //General Office %>
			<button style="display: none" type="button" class="btn_normal" name="btn_close_process" id="btn_close_process">Close Process</button>
		<% } %>
			<button style="display: none" type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
		<% } %>
			 <button type="button" class="btn_normal"  name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_recoveryactivity" id="btn_recoveryactivity">Recovery Activity</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class="wrap_search ">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="30" />
					<col width="50" />
					<col width="362" />
					<col width="50" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr >
					<td></td>
					<th>TPB No.</th>
					<td><input id="s_n3pty_no" style="width:154px;" name="s_n3pty_no" maxlength="14" value="<%=n3pty_no%>" type="text" /></td>
					<th>Invoice No.</th>
					<td><input id="s_n3pty_inv_no" style="width:140px;" name="s_n3pty_inv_no" maxlength="11" type="text" /> </td>
					<td></td> 
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="30" />
					<col width="50" />
					<col width="362" />
					<col width="50" />
					<col width="300" />
					<col width="50" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr >
					<td></td>
					<th>Office</th>
					<td><input id="s_ofc_cd" style="width:154px; background-color:#EEEEEE" name="s_ofc_cd" <%=strReadOnly%> type="text" /></td>
					<th>TPB Status</th>
					<td><input id="s_ots_sts_nm" style="width:138px; background-color:#EEEEEE" name="s_ots_sts_nm" <%= strReadOnly%> type="text"/></td>
					<th>Overdue</th>
					<td><input id="s_overdue" style="width: 150px; background-color:#EEEEEE" name="s_overdue" <%= strReadOnly %> type="text"/></td>
					<td></td> 
				</tr>
			</tbody>
		</table>
		
		<table>
			<tbody>
				<colgroup>
					<col width="23" />
					<col width="50" />
					<col width="733" />
					<col width="50" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr >
					  <td></td>
				      <th>3rd Party</th>
				      <td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:100px;"+strBgColor+"'"+(isReadOnly?" disabled":"")+"", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%><input type="text" style="width: 70px; <%=strBgColor%>" name="s_trd_party_val" maxlength="8" <%=strReadOnly%>><% if(!isReadOnly){ // %><button type="button" class="input_seach_btn" name="btn_3rdParty" id="btn_3rdParty"></button><% } %><input type="text" style="width: 390px; <%=strBgColor%>" name="s_trd_party_nm" readonly>
				      </td>
				      <th>CSR No.</th>
				      <td><input type="text" style="width: 150px; background-color:#EEEEEE" name="s_csr_no" value="" <%=strReadOnly%>></td>
				      <td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<tbody>
				<colgroup>
					<col width="13" />
					<col width="50" />
					<col width="340" />
					<col width="60" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr >
					<td></td>
					<th>Res. Office</th>
					<td><input id="s_roc_in" style="width: 155px;.background-color:#EEEEEE" name="s_roc_in" <%= strReadOnly%> type="text" /></td>
					<th>ROC-out (from)</th>
					<td><input id="s_roc_out" style="width: 135px;.background-color:#EEEEEE" name="s_roc_out" <%= strReadOnly%> type="text" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>	
</form>