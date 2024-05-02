<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_inv_0128.jsp
 *@FileTitle : S/C Customer Search
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion :
 * 1.0 Creation
 =========================================================*/%>

<%@ page contentType="text/html; charset=euc-kr" %>
<% 
request.setCharacterEncoding("euc-kr");
%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0128Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0128Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");
	
	String custCntCd = "";
	String custSeq = "";
	String custLglEngNm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsInv0128Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		custCntCd = request.getParameter("cust_cnt_cd") == null ? "" : request.getParameter("cust_cnt_cd");
		custSeq = request.getParameter("cust_seq") == null ? "" : request.getParameter("cust_seq");
		custLglEngNm = request.getParameter("cust_lgl_eng_nm") == null ? "" : request.getParameter("cust_lgl_eng_nm");

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Bad Customer History</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cust_cnt_cd" value="<%=custCntCd%>">
<input type="hidden" name="cust_seq"  value="<%=custSeq%>">
<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle">&nbsp; Bad Customer History</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 600;">
					<tr class="h23">
						<td width="70">Cust. Code</td>
						<td><input type="text" style="width: 40;" class="input2" value="<%=custCntCd%>" name="cust_cd1" readonly></td>
						<td><input type="text" style="width: 80;" class="input2" value="<%=custSeq%>" name="cust_cd2" readonly></td>
						<td><input type="text" style="width: 300;" class="input2" value="<%=custLglEngNm%>" name="cust_nm" readonly></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>


				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				<!-- Grid (E) --></td>
			</tr>
		</table>
		<!--biz page (E)-->

<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>
</td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!--Button (E) --></td>
			</tr>
		</table>
		<!-- : ( Button : pop ) (E) --></td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>