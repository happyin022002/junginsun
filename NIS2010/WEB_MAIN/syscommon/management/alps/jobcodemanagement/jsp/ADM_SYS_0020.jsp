<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ADM_SYS_0020.jsp
*@FileTitle : User Job Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.05.17 김상수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	AdmSys0020Event event = null;
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
		event = (AdmSys0020Event)request.getAttribute("Event");
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
<title>User Job Code Inquiry</title>
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
<input type="hidden" name="pid" value="<%=JSPUtil.getParameter(request,"pid") %>">
<!-- 개발자 작업 -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; width:1002px">
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
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr class="h23">
								<td>User ID&nbsp;
									<input name="usr_id" value="<%=strUsr_id %>" type="text" dataformat="eng" maxlength="20" class="input" style="ime-mode:disabled; width:120;">
								</td>
								<td>User Name&nbsp;
									<input name="usr_nm" value="<%=strUsr_nm %>" type="text" dataformat="eng" maxlength="100" class="input" style="ime-mode:disabled; width:200;">
								</td>
								<td id="td_ofcCd" style="visibility:hidden">Office Code&nbsp;
									<input name="ofc_cd" type="text" dataformat="engup" maxlength="6" class="input" style="ime-mode:disabled; width:100;">
									<img name="btn_ofc_pop" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">&nbsp;</td>
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
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td id="td_new" style="display:none">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right"></td>
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
