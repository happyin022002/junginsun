<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0010.jsp
*@FileTitle : Invoice Inquiry by B/L No (History Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.11 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	String bl_src_no = request.getParameter("bl_src_no");
	if(bl_src_no == null){
		bl_src_no = "";
	}
	
	String bkg_no = request.getParameter("bkg_no");
	if(bkg_no == null){
		bkg_no = "";
	}
	
	String ar_ofc_cd = request.getParameter("ar_ofc_cd");
	if(ar_ofc_cd == null){
		ar_ofc_cd = "";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0010Event)request.getAttribute("Event");
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
<title>Invoice Inquiry by B/L No (History Pop-up)</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr>
	<td class="top"></td>
</tr>
<tr>
	<td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr>
			<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Inquiry by B/L No (History)</td>
		</tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		<table class="search">
		<tr>
			<td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:814;">
				<tr class="h23">
					<td width="70">B/L No.</td>
					<td width="130"><input name="bl_src_no" type="text" style="width:100;" class="input2" value="<%=bl_src_no %>" readOnly=true tabIndex="-1"></td>
					<td width="50">BKG No.</td>
					<td width="160"><input name="bkg_no" type="text" style="width:100;" class="input2" value="<%=bkg_no %>" readOnly=true tabIndex="-1"></td>
					<td width="40">Office</td>
					<td><input name="ar_ofc_cd" type="text" style="width:90;" class="input2" value="<%=ar_ofc_cd %>" readOnly=true tabIndex="-1"></td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<table width="100%">
				<tr align="right">
					<td width="">&nbsp;</td>
					<td width="310">
						<table width="100%"  id="mainTable2">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Grid (E) -->
			</td>
		</tr>
		</table>
	<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>

	</td>
</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr>
	<td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr>
			<td class="btn3_bg">
				<!--Button (S) -->
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="120"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_sysclear">Hide Sys Clear</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--Button (E) -->
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
