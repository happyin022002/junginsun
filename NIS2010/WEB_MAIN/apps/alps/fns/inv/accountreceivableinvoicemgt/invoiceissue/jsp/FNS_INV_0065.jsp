<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0065.jsp
*@FileTitle : (Vietnam) Invoice History Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.26 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0065Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0065Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0065Event)request.getAttribute("Event");
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
<title>(Vietnam) Invoice History Inquiry </title>
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
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="office">
<input type="hidden" name="upd_usr_id" value="<%=strUsr_id%>">

<input type="hidden" name="invs_email">
<input type="hidden" name="f_inv">
<input type="hidden" name="t_inv">
<input type="hidden" name="copy_cnt">
<input type="hidden" name="ar_ofc_cd2">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable">
		<tr>
			<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="100">Invoice No.</td>
					<td width="150"><input name="inv_no" type="text" class="input" style="width:112;" value="" dataformat="engup" maxlength="10"></td>
					<td width="50">B/L No.</td>
					<td width="140"><input name="bl_src_no" type="text" class="input" style="width:100;" value="" dataformat="engup" maxlength="12"></td>
					<td width="70">Issue Date</td>
					<td width="260"><input type="text" name="iss_fm_dt" dataformat="ymd" maxlength="8" style="width:85" class="input" required cofield="iss_to_dt" caption="start date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" name="iss_to_dt" dataformat="ymd" maxlength="8" style="width:85" class="input" required cofield="iss_fm_dt" caption="end date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"><input type="text" name="iss_dt_blank" maxlength="8" style="width:0" class="input" readOnly value="blank"></td>
					<td width="60">Office</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0);</script></td>
				</tr>
				<tr class="h23">
					<td width="100">Actual Cust.&nbsp;</td>
					<td colspan="5"><input name="cust_cnt_cd" type="text" style="width:25;" value="" class="input" maxlength="2" dataformat="engup">&nbsp;-&nbsp;<input name="cust_seq" type="text" style="width:50;" value="" class="input" maxlength="6" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:378;" value="" class="input2" value="" readonly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust2"></td>
					<td>VVD</td>
					<td><input name="vvd" type="text" style="width:100;" class="input" value="" dataformat="engup" maxlength="9" minlength="9"></td>
				</tr>
				<tr class="h23">
					<td>Actual INV No.</td>
					<td><input name="act_inv_no" type="text" class="input" style="width:112;" value="" dataformat="engup"></td>
					<td>Type</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('inv_type', 1, 100, 1);</script></td>
					<td>Issue Office</td>
					<td><input name="iss_ofc_cd" type="text" class="input" style="width:85;" value="" dataformat="engup" maxlength="6"></td>
					<td>User ID</td>
					<td><input name="usr_id" type="text" class="input" style="width:100;" value=""></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- Grid (E) -->
			</td>
		</tr>
		</table>
		<!--biz page (E)-->
	</td>
</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
<tr>
	<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table>
			</td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
				</tr></table>
			</td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right">
				</tr></table>
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save Actual INV No.</td>
					<td class="btn1_right">
				</tr></table>
			</td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_gotosend">Go to Send</td>
					<td class="btn1_right">
				</tr></table>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<div style="display:none">
<input type="radio" class="trans" value="S" name="sel_option" checked>&nbsp;Single
<input type="radio" class="trans" value="M" name="sel_option">&nbsp;Multi			
<!-- Grid (E) -->
</div>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>