<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_011.jsp
*@FileTitle : 프로그램별 역할 매핑
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-13 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0023Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	AdmSys0023Event event = null;
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.syscommon.management.alps.JobCodeManagement");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (AdmSys0023Event)request.getAttribute("Event");
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
<title>Job Mapping</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/hanjin/script/wait.js"></script>
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

<body class="popup_bg" onload="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; width:700px">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Program Job Code Mapping</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg_b1">
				<table class="height_10"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:100%;">
					<tr class="h23">
						<td width="15%">&nbsp;Program No</td>
						<td width="20%"><input name="pgm_no" value="<%=JSPUtil.getParameter(request,"pgm_no") %>" type="text" style="width:100" readOnly></td>
						<td width="15%">&nbsp;Program Name</td>
						<td><input name="pgm_nm" value="<%=JSPUtil.getParameter(request,"pgm_nm") %>" type="text" style="width:300" readOnly>&nbsp;</td>
					</tr>
				</table>
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0" width="580">
					<tr>
						<td width="100%" valign="top">
							<!-- : ( Grid ) (S) -->
							<table width="100%" id="mainTable">
								<tr><td>
									 <script language="javascript">ComSheetObject('sheet1');</script>
								</td></tr>
							</table>
							<!-- : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
<!-- OUTER - POPUP (E)nd -->

<table class="height_2"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr><td class="btn3_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
