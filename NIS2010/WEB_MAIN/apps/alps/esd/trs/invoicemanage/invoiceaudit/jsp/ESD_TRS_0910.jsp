<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0910.jsp
*@FileTitle : Currency Change Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Lee_SangWoo
*@LastVersion : 1.0
* 2006-12-06 Lee_SangWoo
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
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0910Event"%>
<%
	EsdTrs0910Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	String r_wo_currency  = "";
	String r_wo_totamount  = "";
	String r_invoice_currency  = "";

	r_wo_currency = ((request.getParameter("wo_currency")==null )?"":request.getParameter("wo_currency"));
	r_wo_totamount = ((request.getParameter("wo_totamount")==null )?"":request.getParameter("wo_totamount"));
	r_invoice_currency = ((request.getParameter("invoice_currency")==null )?"":request.getParameter("invoice_currency"));

	String selINVOICE = ""; //RHQ Mode
	String optionStr = "000020:ALL:ALL";
	selINVOICE  = JSPUtil.getCodeCombo("sel_invoicemode", "01"		," onChange='invoice_OnChang(this);'","CURR_CD", 0, optionStr);

	try {

		event = (EsdTrs0910Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Currency Change Popup</title>
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

<input type="hidden" name="hid_woamount" value="D">
<input type="hidden" name="hid_invoicemode" value="<%=r_invoice_currency%>">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Currency Change </td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0">
						<tr class="h23">
							<td width="18%">W/O Currency </td>
							<td width="40%">&nbsp;<input name="wo_currency" value="<%=r_wo_currency%>"  class="input2" type="text" style="width:206;" readonly></td>
							<td width="19%">W/O Total Amount </td>
							<td width="23%">&nbsp;<input name="wo_totamount" value="<%=r_wo_totamount%>"  class="input2" type="text" style="width:120;"  readonly></td>
						</tr>
						<tr class="h23">
							<td>Invoice Currency</td>
							<td>&nbsp;<%= BizComUtil.getCodeCombo("sel_invoicemode","","style='width:206;' onChange='invoice_OnChang(this);'","CURR",1,"0::ALL") %></td>
							<td>Exchange Rate</td>
							<td>&nbsp;<input name="ex_rate" type="text" style="width:120;" onBlur="fn_check(this,'Exchange Rate');fun_addcomma();" onKeyup='enterCheck(this)'></td>
						</tr>
						<tr class="h23">
							<td valign="top">Invoice Amount </td>
							<td valign="top" colspan="3">&nbsp;<input name="invoice_amount"  class="input2"  type="text" style="width:206;"  onBlur="fn_check(this,'Invoice Amount');"   readonly></td>

						</tr>
						<tr class="h23">
							<td rowspan="2" valign="top">Calculation Logic</td>

							<td style="padding-left: 3px;" colspan="3">
							    <table border="0" style="width:90%;" >
				                    <tr>
				                        <td class="sm">&nbsp;<input name="woamount" type="radio" value="TM"  class="trans"  onClick="change_amount();" checked>
								W/O Amount X Exchange Rate<br>
								&nbsp;<input name="woamount" type="radio" value="DV"  class="trans" onClick="change_amount();">
								W/O Amount ÷ Exchange Rate</td>
					                </tr>
				                </table>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

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
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->



</form>
</body>
</html>
