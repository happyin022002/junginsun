
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0064.jsp
	 *@FileTitle : (Korea) Terminal GIRO Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.04.27
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.04.27 정휘택
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0064Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	FnsInv0064Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsInv0064Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>(Korea) Terminal GIRO Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form">
    <input type="hidden" name="f_cmd"> 
    <input type="hidden" name="pagerows"> 
<!-- 개발자 작업	--> 
    <input type="hidden" name="pagetype" value="I"> 
    <input type="hidden" name="ar_ofc_cd2">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>

		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="88">Issue Date</td>
						<td width="500">
							<input type="text" style="width: 75"
							dataformat="ymd" required caption="start date" value=""
							class="input1" name="iss_dt1" maxlength="8" cofield="iss_dt2">							
							<img class="cursor" src="img/btns_calendar.gif" width="19"
							height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;							
							<input type="text" style="width: 75" 
							dataformat="ymd" required caption="end date" value="" 
							class="input1" name="iss_dt2" maxlength="8" cofield="iss_dt1">&nbsp;							
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btns_calendar2"></td>
						<td width="50">Office</td>
						<td width="" style="padding-left: 2"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0);</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="88">Cust Code</td>
						<td width="500"><input type="text" style="width: 38" value=""
							class="input" name="cust_cnt_cd" maxlength="2" dataformat="engup">&nbsp;-&nbsp;
						<input type="text" style="width: 61" value="" class="input"
							name="cust_seq" maxlength="6" dataformat="hms"
							onfocusout="javascript:getCustNm();">&nbsp;<img
							class="cursor" src="img/btns_search.gif" width="19" height="20"
							border="0" align="absmiddle"
							onclick="javascript:openFnsInv0013();">&nbsp;<input
							type="text" style="width: 229" value="" class="input2"
							name="cust_nm" readonly>&nbsp;<img class="cursor"
							src="img/btns_search.gif" width="19" height="20" border="0"
							align="absmiddle" onclick="javascript:openFnsInv0086();"></td>
						<td width="50">B/L No.</td>
						<td width="150"><input type="text" dataformat="engup"
							style="width: 100" value="" class="input" name="bl_src_no"></td>
						<td width="50">Giro No.</td>
						<td width=""><input type="text" dataformat="engup"
							style="width: 110" value="" class="input" name="giro_no"></td>
					</tr>
				</table>
				<!-- biz_1 (E) -->
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>
				<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%" style="display: none">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
		<!-- Tab BG Box(E) --> <!--biz page (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				<!--Button (E) --></td>
			</tr>
		</table>

		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 --></form>
</body>
</html>