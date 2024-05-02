<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_BKG_1503.jsp
*@FileTitle : Departure Time Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.06.28 김상수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1503Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1503Event event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    //서버에서 발생한 에러
	String strErrMsg = "";               //에러메세지
	int rowCount = 0;                    //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1503Event)request.getAttribute("Event");
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
<title>Departure Time Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage() {
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


<input type="hidden" name="send_div" value="1"><!-- 1503화면 : 1 / BATCH_ETD : 2 / BATCH_ATD : 3 -->


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
					<td class="bg">
						<!-- biz_1 (S) -->
						<table class="search" border="0" style="width:500;">
							<tr class="h23">
								<td width="50">VVD</td>
								<td><input type="text" style="width:110; ime-mode:disabled;" class="input1" name="vvd" maxlength="9" required caption="VVD" dataformat="eng"></td>
								<td width="135">POL&nbsp;&nbsp;<input type="text" style="width:60; ime-mode:disabled;" required caption="POL" class="input1" name="pol_cd" maxlength="5" dataformat="engup">
									<select style="width:35px;" class="input" name="pol_split_no">
										<option value="" selected></option>
<% for (int k=1; k<10; k++) { %>
										<option value="<%=k%>"><%=k%></option>
<% } %>
									</select></td>
								</td>
							</tr>
						</table>

						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0" style="width:500;">
							<tr class="h23">
								<td width="50">ETD</td>
								<td><input type="text" style="width:75px;" name="etd_date" class="input" dataformat="ymd" maxlength="10" caption="ETD DATE">
									<img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
									<input type="text" style="width:45px;" name="etd_time" class="input" dataformat="hm" maxlength="10" caption="ETD TIME">
								</td>
								<td width="135">Relaxed&nbsp;&nbsp;<input type="checkbox" name="rlx_div" class="trans" value="1"></td>
							</tr>
						</table>
						<!-- biz_1 (E) -->
					</td>
				</tr>
			</table>


			<!-- biz_2 (S) -->
			<!-- Grid (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" id="mainTable">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<!-- biz_2 (E) -->
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
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_transmit">Transmit</td>
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


			<table height="300" border="0" cellpadding="0" cellspacing="0"><tr><td><!-- document.clientHeight가 달력팝업 높이보다 작으면 버그가 발생하여 강제로 임의 높이를 부여 --></td></tr></table>


		</td>
	</tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
