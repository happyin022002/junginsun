<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_AGT_043.jsp
*@FileTitle  : Agent Commission CSR Detail Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0043Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil" %>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmAgt0043Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//error from server
	DBRowSet rowSet1 = null;						//DB ResultSet
	DBRowSet rowSet2 = null;						//DB ResultSet
	String strErrMsg = "";							//error message
	//int rowCount	 = 0;							//count of DB resultSET list
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	//String userId = "";
	String csrNo  = "";

	try {
		//SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	//userId = account.getUsr_id();

	   	event = (EsmAgt0043Event)request.getAttribute("Event");
	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} //else {
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
//			if (eventResponse != null) {
//				rowSet1 = eventResponse.getRs1();
//				rowSet2 = eventResponse.getRs2();
//			} // end if

			//Receiving Parameters from ESM_AGT_017
			csrNo  = JSPUtil.getParameter(request, "csr_no");
		//}

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
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="csr_no" value="<%= csrNo %>"> <!-- grid Optional csrNo -->

 <div class="layer_popup_title">
	<div class="page_title_area clear">
	
		<h2 class="page_title"><span>Agent Commission CSR Detail Popup</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
		    <table>
		        <tbody>
					<tr>
						<th width="80px">Cost Office</th>
						<td width="300px"><input type="text" name="ofccd" style="width:100;" class="input2" readOnly="true" value=""></td>
						<th width="80px">Confirmed Date</th>
						<td><input type="text" name="confdt" style="width:100;" class="input2" readOnly="true" value=""></td>
					</tr> 
					<tr>
						<th>Payment S/P</th>
						<td colspan="3">
							<input type="text" name="vndrno" style="width:100;" class="input2" readOnly="true" value="">
							<input type="text" name="vndrnm" style="width:360;" class="input2" readOnly="true" value="">
						</td>
					</tr>
					<tr>
						<th>No. of INV</th>
						<td><input type="text" name="cnt" style="width:100;" class="input2" readOnly="true" value=""></td>
						<th>INV Currency</th>
						<td><input type="text" name="currcd" style="width:100;" class="input2" readOnly="true" value=""></td>
					</tr>
					<tr>
						<th>Total Amount</th>
						<td><input type="text" name="totamt" style="width:100;" class="input2" readOnly="true" value=""></td>
						<th>Payment Due Date</th>
						<td><input type="text" name="paydt" style="width:100;" class="input2" readOnly="true" value=""></td>
					</tr>
					<tr>
						<th>ASA No.</th>
						<td><input type="text" name="asano" style="width:100;" class="input2" readOnly="true" value=""></td>
					</tr>
					<tr>
						<th>CSR No.</th>
						<td><input type="text" name="csr_no" style="width:160;" class="input2" readOnly="true" value="<%= csrNo %>"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
			<script language="javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</form>