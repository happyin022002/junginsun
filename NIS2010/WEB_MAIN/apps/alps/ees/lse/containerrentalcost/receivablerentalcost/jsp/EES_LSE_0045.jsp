<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0045.jsp
*@FileTitle : Receivable Invoice Inquiry and Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.17 장준우
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strQtyMonth	= "";
	String strOfc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd  = account.getOfc_cd();
		strQtyMonth = EesLse0045Event.getCurrAddMonths("yyyy-MM", -1);

		event = (EesLse0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Receivable Invoice Inquiry and Cancel</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	</td></tr>
	<tr><td valign="top">


		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_cancel">Cancel</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

	<table class="search">
       		<tr><td class="bg">

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="110">Revenue Month</td>
					<td width="150"><input type="text" name="qty_yrmon" caption="Cost Month" style="width:75;text-align:center;ime-mode:disabled;" class="input1" value="<%= strQtyMonth %>" maxlength="6" dataformat="ym" required fullfill>&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="110">Lessee</td>
					<td width="">
						<input type="text" name="vndr_seq" caption="Lessor" style="width:60;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="6" dataformat="int">
						<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
						<input type="text" name="vndr_abbr_nm" style="width:100;text-align:center;"  class="input2" value="" readonly>
						<input type="text" name="vndr_nm" style="width:341" class="input2" value="" readonly>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="110">Invoice No.</td>
					<td width="150"><input type="text" name="inv_no" caption="Invoice No." style="width:98;text-align:center;ime-mode:disabled;" style="width:82" class="input" value="" maxlength="12" dataformat="engup"></td>
					<td width="110">Invoice Status</td>
					<td width=""><select name="bl_inv_if_flg" caption="Invoice Status" style="width:83;" class="input">
						<option value="" selected>All</option>
						<option value="Y">ERP I/F</option>
						<option value="N">Not I/F</option>
						<option value="E">INV ERR</option>
						</select></td>
				</tr>
				</table>
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">
       			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downexcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
<!-- : ( Search Options ) (E) -->


			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->

	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
