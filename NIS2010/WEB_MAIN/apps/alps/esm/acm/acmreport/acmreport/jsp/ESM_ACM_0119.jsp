<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_ACM_0119.jsp
*@FileTitle : Agent Commission CSR Detail Popup
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : Park, Da-eun
*@LastVersion : 1.0
* 2014.06.02 Park, Da-eun
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event.EsmAcm0119Event"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmAcm0119Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	DBRowSet rowSet1 = null;						//DB ResultSet
	DBRowSet rowSet2 = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	//int rowCount	 = 0;							//DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	//String userId = "";
	String csrNo  = "";

	try {
		//SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	//userId = account.getUsr_id();

	   	event = (EsmAcm0119Event)request.getAttribute("Event");
	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} //else {
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
//			if (eventResponse != null) {
//				rowSet1 = eventResponse.getRs1();
//				rowSet2 = eventResponse.getRs2();
//			} // end if

			csrNo  = JSPUtil.getParameter(request, "csr_no");
		//}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Agent Commission CSR Detail Popup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="csr_no" value="<%= csrNo %>"> <!-- grid에서 선택된 csrNo -->
<div style="display:none">
<table width="100%" id="mainTable" >
	<tr>
		<td ><script language="javascript">ComSheetObject('sheet1');</script></td>
	</tr>
</table>
</div>
<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
	<tr><td class="top">
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Agent Commission CSR Detail</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- Search BG (S) -->
		 	<table class="search">
	   			<tr>
	   				<td class="bg">
						<table class="search" border="0">
							<tr class="h23">
								<td width="15%">Cost Office</td>
								<td width="35%"><input type="text" name="ofccd" style="width:100;" class="input2" readOnly="true" value=""></td>
								<td width="20%">Confirmed Date</td>
								<td><input type="text" name="confdt" style="width:100;" class="input2" readOnly="true" value=""></td>
							</tr>
							<tr class="h23">
								<td>Payment S/P</td>
								<td colspan="3">
									<input type="text" name="vndrno" style="width:100;" class="input2" readOnly="true" value="">
									<input type="text" name="vndrnm" style="width:360;" class="input2" readOnly="true" value="">
								</td>
							</tr>
							<tr class="h23">
								<td>No. of INV</td>
								<td><input type="text" name="cnt" style="width:100;" class="input2" readOnly="true" value=""></td>
								<td>INV Currency</td>
								<td><input type="text" name="currcd" style="width:100;" class="input2" readOnly="true" value=""></td>
							</tr>
							<tr class="h23">
								<td>Total Amount</td>
								<td><input type="text" name="totamt" style="width:100;" class="input2" readOnly="true" value=""></td>
								<td>Payment Due Date</td>
								<td><input type="text" name="paydt" style="width:100;" class="input2" readOnly="true" value=""></td>
							</tr>
							<tr class="h23">
								<td>ASA No.</td>
								<td><input type="text" name="asano" style="width:100;" class="input2" readOnly="true" value=""></td>
								<td></td>
								<td></td>
							</tr>
						</table>
						<table class="search" border="0" width="100%">
							<tr class="h23">
								<td width="15%">CSR No.</td>
								<td width="85%"><input type="text" name="csr_no" style="width:160;" class="input2" readOnly="true" value="<%= csrNo %>"></td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!-- : ( grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						<!-- : ( grid ) (E) -->
					</td>
				</tr>
			</table>
			<!-- Search BG (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    		   	<tr>
    		   		<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
