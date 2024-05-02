<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0922.jsp
*@FileTitle : Transportation Service Order를 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-23
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-01-23 poong_yeon
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event"%>
<%
	EsdTrs0033Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	SignOnUserAccount account= null;
	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0033Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String wo_vndr_cd = JSPUtil.getNull(request.getParameter("wo_vndr_cd"));
	String wo_vndr_nm = JSPUtil.getNull(request.getParameter("wo_vndr_nm"));
	String payment_vndr_cd = JSPUtil.getNull(request.getParameter("payment_vndr_cd"));
	String payment_vndr_nm = JSPUtil.getNull(request.getParameter("payment_vndr_nm"));
	String invoice_no = JSPUtil.getNull(request.getParameter("invoice_no"));
	String apply_currency = JSPUtil.getNull(request.getParameter("apply_currency"));
%>
<html>
<head>
<title>Transportation Service Order를 관리</title>
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
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="apply_currency" value="<%=apply_currency%>">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice File Import</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search" border="0">
				<tr class="h23">
					<td>W/O Vendor</td>
					<td colspan="7">
						<input type="text" name='wo_vndr_cd' value='<%=wo_vndr_cd%>' readonly style="width:70;">
						<input type="text" name='wo_vndr_nm' value='<%=wo_vndr_nm%>' readonly style="width:200;"></td></tr>
				<tr class="h23">
					<td width="14%">Payment Vendor</td>
					<td width="39%">
						<input type="text" name='payment_vndr_cd' value='<%=payment_vndr_cd%>' readonly style="width:70;">
						<input type="text" name='payment_vndr_nm' value='<%=payment_vndr_nm%>' readonly style="width:200;"></td>
				<td width="10%">Invoice No.</td>
					<td><input type="text" name='invoice_no' value='<%=invoice_no%>' readonly style="width:99%;"></td></tr>
				</table>

				<table class="search"><tr><td class="line_bluedot"></td></tr></table>

				<!-- : ( Node / Link ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
					<table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>
				<!-- : ( Node / Link ) (E) -->
					<table width="100%" id="messageTable">
                        <tr><td id='msg_td'>
                             &nbsp;
                        </td></tr>
                    </table>

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_fileselect" id="btn_fileselect">File Select</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_verify" id="btn_verify">Verify</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btng_downexcel" id="btng_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->



</form>
</body>
</html>
