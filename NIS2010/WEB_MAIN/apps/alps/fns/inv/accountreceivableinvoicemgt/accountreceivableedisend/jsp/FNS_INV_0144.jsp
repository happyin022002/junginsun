<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0144.jsp
*@FileTitle :  EDI Submission (MGB)
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.21
*@LastModifier : 백승일
*@LastVersion : 1.0
* 2015.12.21 [CHM-201006644] 백승일 MGB Invoice EDI 신규 개발 요청
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0144Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0144Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.AccountReceivableEDISend");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0144Event)request.getAttribute("Event");
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
<title>EDI Submission (NIKE)</title>
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

<input type="hidden" name="ofc" value="">
<input type="hidden" name="ofc_cd" value="">
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="upd_usr_id" value="<%=strUsr_id%>">

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
					<td width="110">Retrieve Option&nbsp;</td>
					<td width="100">
						<script language="javascript">ComComboObject('retr_opt', 1, 150, 1, 1);</script>
					</td>
					<td width="130"><input name="retr_input" type="text" dataformat="engup" style="width:120" class="input1" value="" maxlength="13">&nbsp;</td>
					<td width="85" align="">Sent Status&nbsp;</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('sent_stat', 1, 150, 1, 1);</script></td>
					<td width="85">Office</td>
					<td style="padding: 2"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 101, 1,1);</script></td>
					</td>
				</tr>
				<tr class="h23">
				    <td width="110"></td>
					<td width="250" colspan = "4"><input type="text" style="width: 75" value="" name="fm_dt" onBlur="fn_ComGetMaskedValue('fm_dt');" onKeyUp="javascript:checkFmDtLeng(this.value)" class="input2" readOnly>
										<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;
										<input type="text" style="width: 75" value="" name="to_dt"	onBlur="fn_ComGetMaskedValue('to_dt');" class="input2" readOnly>
										<img class="cursor" src="img/btns_calendar.gif" width="19" height="20"	border="0" align="absmiddle" name="btns_calendar2"></td>
				</tr>
				<tr class="h23">
					<td width="110">Customer</td>
					<td width="" colspan = "6"><input type="text" style="ime-mode: disabled; width: 30" value="CN" class="input2" dataformat="engup" name="cust_cnt_cd" maxlength="2" readonly >
						<input type="text" style="width: 49" value="136478" name="cust_seq" dataformat="num" class="input2" onChange="fn_cust_nm();" maxlength="6" readonly>
						<img class="cursor" src="img/btns_search.gif" name="btn_actcust" width="19" height="20" border="0" align="absmiddle" >
						<input type="text" style="width: 500" value="MGB METRO GROUP BUYING HK LIMITED" class="input2" name="cust_nm" readonly>
						<img class="cursor" src="img/btns_search.gif" name="btn_custNm"	width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->
			</td>
		</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
		<tr>
			<td class="bg">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!--biz page (E)-->
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
<tr>
	<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SendBL">Send</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>			
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			
		</tr>
		</table>
	</td>
</tr>
</table>
<div style="display:none">
<table width="100%"  id="mainTable">
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet2');</script>
	</td>
</tr>
</table>
</div>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>