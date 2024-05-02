<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0923.jsp
*@FileTitle : USA Rail Invoice 등록 및 Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-08
*@LastModifier : chkong
*@LastVersion : 1.0
* 2006-10-13 chkong
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0923Event"%>
<%
	EsdTrs0923Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String userId = "";
	String ofcId = "";
	SignOnUserAccount account = null;

	try {

	   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofcId=account.getOfc_cd();
	   
		event = (EsdTrs0923Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String mode = JSPUtil.getNull(request.getParameter("mode"));

	String inv_no				= JSPUtil.getNull(request.getParameter("inv_no"));
	String rail_road_code		= JSPUtil.getNull(request.getParameter("rail_road_code"));
	String rail_road_name		= JSPUtil.getNull(request.getParameter("rail_road_name"));
	String payment_vndr_code	= JSPUtil.getNull(request.getParameter("payment_vndr_code"));
	String payment_vndr_name	= JSPUtil.getNull(request.getParameter("payment_vndr_name"));
	String receive_dt			= JSPUtil.getNull(request.getParameter("receive_dt"));
	String issue_dt				= JSPUtil.getNull(request.getParameter("issue_dt"));
	String invoice_amt			= JSPUtil.getNull(request.getParameter("invoice_amt"));
	String vat_amt				= JSPUtil.getNull(request.getParameter("vat_amt"));
	String currency				= JSPUtil.getNull(request.getParameter("currency"));
%>
<html>
<head>
<title>USA Rail</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="receive_dt" value='<%=receive_dt%>'>
<input type="hidden" name="issue_dt" value='<%=issue_dt%>'>
<input type="hidden" name="invoice_amt" value='<%=invoice_amt%>'>
<input type="hidden" name="vat_amt" value='<%=vat_amt%>'>
<input type="hidden" name="currency" value='<%=currency%>'>
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="mode" value='<%=mode%>'>


<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; USA Rail Invoice File Import</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options, Grid ) (S) -->
		<table class="search">
			<tr><td class="bg">

					<!-- : ( Search Options ) (S) -->
					<table class="search" border="0">
						<tr class="h23">
							<td width="9%">Invoice No. </td>
							<td width="40%"><input name="inv_no" value="<%=inv_no%>" type="text" style="width:285;" readOnly class="input2"></td>
							<td width="13%"></td>
							<td></td>
							</tr>
						<tr class="h23">
							<td>Rail Road</td>
							<td>
								<input name="rail_road_code" type="text" style="width:100;" value='<%=rail_road_code%>' readOnly class="input2">
								<input name="rail_road_name" type="text" style="width:180;" value='<%=rail_road_name%>' readOnly class="input2"></td>
							<td>Payment Vendor</td>
							<td>
								<input name="payment_vndr_code" type="text" style="width:100;" value='<%=payment_vndr_code%>' readOnly class="input2">
								<input name="payment_vndr_name" type="text" style="width:220;" value='<%=payment_vndr_name%>' readOnly class="input2"></td>
						</tr>
					</table>
					<!-- : ( Search Options ) (E) -->


					<table class="line_bluedot"><tr><td></td></tr></table>


					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
				              <tr><td>
							  <script language="javascript">ComSheetObject('sheet1');</script>
							  </td></tr>
					</table>
					<!-- : ( Grid ) (E) -->

					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td id='msg_td'>
	                             &nbsp;
		                    </td>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_select"" name="btng_select""add">Select</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_verify" name="btng_verify">Verify</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options, Grid ) (E) -->


		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

<!--<table height="100"><tr><td></td></tr></table>-->


</form>
</body>
</html>
