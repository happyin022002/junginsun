<%--
 - Copyright(c) 2016 CyberLogitec
 - @FileName : ESM_ACM_0040.jsp
 - @FileTitle : Group Customer Inquiry.
 - Open Issues :
 - Change history :
 - @LastModifyDate :
 - @LastModifier :
 - @LastVersion :
 - 2016.05.20 김상현 1.0 Creation.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.event.EsmAcm0040Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmAcm0040Event event = null;     // PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // 서버에서 발생한 에러
	String strErrMsg = "";            // 에러메세지
	int rowCount = 0;                 // DB ResultSet 리스트의 건수

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsmAcm0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>

	<head>
		<title>Group Customer Inquiry</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			var sFunc = "<%=JSPUtil.getParameter(request, "func") %>";
			var iSheetIdx = "<%=JSPUtil.getParameter(request, "sheetIdx") %>";
			var iRow = "<%=JSPUtil.getParameter(request, "row") %>";
			var iCol = "<%=JSPUtil.getParameter(request, "col") %>";

			function setupPage() {
				var errMessage = "<%=strErrMsg %>";
				if (errMessage.length >= 1) {
					showErrMessage(errMessage);
				}
				loadPage();
			}
		</script>
	</head>

	<body onLoad="setupPage();">
		<form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')">
		<input type="hidden" name="f_cmd"> 
		<input type="hidden" name="pagerows">

		<table width="400" class="popup" cellpadding="10" border="0">
			<tr><td class="top"></td></tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0">
						<tr>
							<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Group Customer Inquiry</td>
						</tr>
					</table>

					<table class="search">
						<tr>
							<td class="bg">
								<table class="search" border="0" style="width: 600;">
									<tr class="h23">
										<td width="27%">Group Customer Code</td>
										<td width="">
											<input type="text" name="cust_grp_id" align="center"  maxlength="20" maxlength="20" class="input" />
										</td>
									</tr>
									<tr class="h23">
										<td width="">Group Customer Name</td>
										<td width=""><input type="text" name="cust_grp_nm" maxlength="100" style="width: 200; ime-mode:disabled" class="input" value=""></td>
									</tr>
								</table>
								<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
								<table width="100%" id="mainTable">
									<tr><td width="100%"><script type="text/javascript">ComSheetObject("sheet1");</script></td></tr>
								</table>
								<table width="100%" class="button" border="0">
									<tr>
										<td class="btn2_bg">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr><td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td></tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<table class="height_5">
			<tr><td></td></tr>
		</table>

		<table width="100%" class="sbutton">
			<tr>
				<td height="71" class="popup">
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
						<tr>
							<td class="btn3_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="72">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_ok">OK</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
										<td class="btn1_line"></td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_close">Close</td>
													<td class="btn1_right"></td>
												</tr>	
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</form>
	</body>

</html>
