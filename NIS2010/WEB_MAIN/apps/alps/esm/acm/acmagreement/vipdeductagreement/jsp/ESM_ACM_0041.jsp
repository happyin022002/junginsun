<%--
 - Copyright(c) 2016 CyberLogitec
 - @FileName : ESM_ACM_0041.jsp
 - @FileTitle : Container Type/Size
 - Open Issues :
 - Change history :
 - @LastModifyDate :
 - @LastModifier :
 - @LastVersion :
 - 2016.05.24 김상현 1.0 Creation.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.event.EsmAcm0041Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmAcm0041Event event = null;     // PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // 서버에서 발생한 에러
	String strErrMsg = "";            // 에러메세지
	int rowCount = 0;                 // DB ResultSet 리스트의 건수

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsmAcm0041Event)request.getAttribute("Event");
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
		<title>Container Type/Size</title>
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
		<form name="form">
		<input type="hidden" name="f_cmd"> 
		<input type="hidden" name="pagerows">

		<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:742px">
			<tr><td class="top"></td></tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr><td class="title"><img src="img/ico_t1.gif" width="20" height="12">Container TP/SZ Selection</td></tr>
      				</table>
					<table class="search">
						<tr>
							<td class="bg" valign="top">
								<table class="search" border="0">
									<tr><td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">User Set List</td></tr>
									<tr>
										<td style="padding-left:2px;">
											<table width="100%" id="mainTable1">
												<tr><td width="100%"><script type="text/javascript">ComSheetObject("sheet1");</script></td></tr>
											</table>
										</td>
									</tr>
								</table>
								<table class="line_bluedot"><tr><td></td></tr></table>
								<table class="search" border="0">
									<tr><td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">Selected TP/SZ</td></tr>
									<tr>
										<td><textarea name="slct_tpsz" style="width:700px; height:34" class="input2" readOnly><%=JSPUtil.getParameter(request, "cntr_tpsz_cd")%></textarea></td>
									</tr>
									<tr><td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">Container TP/SZ Code</td></tr>
									<tr>
										<td style="padding-left:2px;">
											<table width="100%" id="mainTable2">
												<tr><td width="100%"><script type="text/javascript">ComSheetObject("sheet2");</script></td></tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

					<table class="height_8"><tr><td></td></tr></table>

					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
						<tr>
							<td class="btn1_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_clear">Clear</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_select">Select</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
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
