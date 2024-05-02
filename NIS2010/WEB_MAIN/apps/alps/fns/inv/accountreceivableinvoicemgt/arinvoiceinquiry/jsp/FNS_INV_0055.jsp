<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0055.jsp
*@FileTitle : Invoice Issue Report by Date (for TVA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.03 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0055Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0055Event)request.getAttribute("Event");
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
<title>Invoice Issue Report by Date (for TVA)</title>
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
				<table class="search" border="0" style="width:500;"> 
				<tr class="h23">
					<td width="90">Office&nbsp;</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 108, 0);</script></td>
				</tr>
				<tr style="height:5;"><td colspan="2"></td></tr>
				<tr class="h23">
					<td>Issue Date&nbsp;</td>
					<td><input name="iss_fm_dt" type="text" required dataformat="ymd" maxlength="8" style="width:80" class="input1" cofield="iss_to_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input name="iss_to_dt" type="text" required dataformat="ymd" maxlength="8" style="width:80" class="input1" cofield="iss_fm_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
				</tr>
				<tr style="height:5;"><td colspan="2"></td></tr>
				<tr class="h23">
					<td>Actual Cust.&nbsp;</td>
					<td><input name="act_cust_cnt_cd" type="text" style="width:25" class="input" value="" maxlength="2" dataformat="engup">&nbsp;<input name="act_cust_seq" type="text" style="width:56" maxlength="6" class="input" value="" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:260" class="input2" value="" readOnly tabIndex="-1">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust2"></td>
				</tr>
				<tr style="height:5;"><td colspan="2"></td></tr>
				<tr class="h23">
					<td>VVD&nbsp;</td>
					<td><input name="vvd" type="text" class="input" style="width:110;" value="" maxlength="9" minlength="9" dataformat="engup"></td>
				</tr>
				<tr style="height:5;"><td colspan="2"></td></tr>
				<tr class="h23">
					<td>Port Code&nbsp;</td>
					<td><input name="port" type="text" style="width:85" class="input" maxlength="5" minlength="5" value="" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_port"></td>
				</tr>
				<tr style="height:5;"><td colspan="2"></td></tr>
				<tr class="h23">
					<td>Bound&nbsp;</td>
					<td><select name="bound" style="width:110;" class="input">
							<option value="" selected>All</option>
							<option value="O">O/B</option>
							<option value="I">I/B</option>
						</select>
					</td>
				</tr>
				<tr style="height:5;"><td colspan="2"></td></tr>
				<tr class="h23">				
					<td>
<div id="categories1" style="display:none">					
					Categories&nbsp;
</div>
					</td>
					<td>
<div id="categories2" style="display:none">						
					<select name="categories" style="width:110;" class="input">
							<option value="" selected>All</option>
							<option value="HJS">HJS</option>
							<option value="HJV">HJV</option>
						</select>
</div>						
					</td>					
				</tr>
				
				<tr style="height:100;"><td colspan="2"></td></tr>
				</table>				
				<!--  biz_1   (E) -->
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
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Down Excel</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!--Button (E) -->
<div style="display:none">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>