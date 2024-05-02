<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FNS_INV_0137.jsp
*@FileTitle : Customer Inquiry by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2013.09.24 임옥영
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0137Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0137Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "500";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (FnsInv0137Event)request.getAttribute("Event");
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
<input type="hidden" name="bl_nos">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)--> 
		
		<table width="100%">
		<tr>
		<td width="100%">
		
				<!--biz page (S)-->
				<table class="search"> 
		       	<tr><td class="bg">
						<!-- biz_1  (S) -->
						<!-- biz_1 (E) -->
						<table class="height_8"><tr><td></td></tr></table>
					<!-- Grid (S) -->
					<table width="100%" >
						<tr>
							<td width="15%" id="mainTable1"><script language="javascript">ComSheetObject('sheet1');</script></td>
							<td width="85%" id="mainTable2"><script language="javascript">ComSheetObject('sheet2');</script></td>
						</tr>
						<tr>
							<td width="15%" align="right">
							<table><tr>
							
							<td class="btn2_bg">
							    <table border="0" cellpadding="0" cellspacing="0">
							    <tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_RowDelete">Row&nbsp;Delete</td>
												<td class="btn2_right"></td>
											</tr>
										</table></td>
								</tr>
								</table></td>
							
							</tr></table>
							</td>
							<td width="85%">
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->			
					</td></tr>
				</table>
				<!--biz page (E)-->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr><td class="btn1_bg">
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
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Import">Import</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
		
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
					</table></td></tr>
				</table>
				<!--Button (E) -->
		
		</td>
		</tr>
		</table>
		
	</td>
</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>