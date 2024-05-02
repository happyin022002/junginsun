<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_BKG_1504.jsp
*@FileTitle : JMS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.08.26 김상수
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1504Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1504Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount = 0;					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList	= "";
	String pageRows	= "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1504Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>JMS Report</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px;">
	<tr>
		<td valign="top">


			<!-- Page Title, Historical (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- Page Title, Historical (E) -->


			<!-- biz page (S) -->
			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_1 (S) -->
						<table class="search" border="0" style="width:879px;">
							<tr class="h23">
								<td>&nbsp;&nbsp;VVD&nbsp;&nbsp;<input type="text" style="width:100px; ime-mode:disabled;" class="input1" name="vvd" maxlength="9" required caption="VVD" fullfill dataformat="engupnum"></td>
								<td>POL&nbsp;<input type="text" style="width:60px; ime-mode:disabled;" required caption="POL" class="input1" name="pol_cd" maxlength="5" dataformat="engup"></td>
								<td>BL/No&nbsp;<input type="text" style="width:90px; ime-mode:disabled;" class="input" name="bl_no" maxlength="12" dataformat="engupnum"></td>
							</tr>
						</table>

						<table class="search" border="0" style="width:879px;">
							<tr class="h23">
								<td>
									<table class="search_sm2">
										<tr class="stm">
											<td><input type="radio" name="period_div" value="SND_DT" class="trans" checked>Send Date&nbsp;
												<input type="radio" name="period_div" value="RCV_DT" class="trans">Received Date&nbsp;&nbsp;</td>
											<td><input name="date_fm" type="text" dataformat="ymd" maxlength="10" caption="From Date" cofield="date_to" class="input" style="width:80px;">&nbsp;~
												<input name="date_to" type="text" dataformat="ymd" maxlength="10" caption="To Date" cofield="date_fm" class="input" style="width:80px;">
												<img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;"></td>
										</tr>
									</table>
								</td>
								<td>Sent Type
									<select name="snt_tp" style="width:80px" class="input">
										<option value="" selected>All</option>
										<option value="AMR" selected>AMR</option>
										<option value="CMR">CMR</option>
									</select>
								</td>
								<td>Ack. Status
									<select name="ack_sts" style="width:80px" class="input">
										<option value="ACP" selected>Accepted</option>
										<option value="RJC">Rejected</option>
										<option value="DNL">DNL</option>
										<option value="DNU">DNU</option>
										<option value="STP">STP</option>
										<option value="HDL">HLD</option>
									</select>
								</td>
							</tr>
						</table>

						<!-- biz_1 (E) -->
					</td>
				</tr>
			</table>


			<table class="height_8"><tr><td></td></tr></table>


			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_2 (S) -->
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!-- biz_2 (E) -->
					</td>
				</tr>
			</table>
			<!-- biz page (E) -->


			<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_bl_inquiry">B/L Inquiry</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_down_excel">Down Excel</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- Button (E) -->


		</td>
	</tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
