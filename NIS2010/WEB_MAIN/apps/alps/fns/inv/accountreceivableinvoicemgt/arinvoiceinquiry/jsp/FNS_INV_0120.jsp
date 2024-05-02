<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName   : FNS_INV_0120.jsp
*@FileTitle  : Report for Reverse Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.18
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.04.18 최도순
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0120Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0120Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (FnsInv0120Event)request.getAttribute("Event");
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
<title>Transaction Data Comparison Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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
<input type="hidden" name="pagetype" value = "">
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="ofc_cd">

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
					<td width="100" align="">Effective Date</td>
					<td width="0">
								<input type="text" name="fm_dt" required dataformat="ymd" maxlength="8" style="width:85" class="input1" cofield="to_dt" caption="start date">
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;
								<input type="text" name="to_dt" required dataformat="ymd" maxlength="8" style="width:85" class="input1" cofield="fm_dt" caption="end date">
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
								<input type="text" name="date_blank" maxlength="8" style="width:0" class="input" readOnly value="blank"></td>
					
					<td width="40" align="">Office&nbsp;</td>
					<td width="105"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0, 1);</script></td>				   
				</tr>
				</table>
				
				<!--  biz_2   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable1" style="display:block"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			 

	</td></tr>
</table>	
			</td></tr>
		</table>
		<!--biz page (E)-->
		
	

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
<tr>
	
	<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
    	<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_retrive">Retrieve</td>
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
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_downExcel">Down Excel</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>