<%/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : COM_SEC_0002.jsp
*@FileTitle : ALPS Role Request
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.role.event.ComSec0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	ComSec0002Event event = null;
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfcOrgCd = "";
	Logger log = Logger.getLogger("com.hanjin.syscommon.management.alps.UserRoleApprovalSC");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfcOrgCd = account.getOfc_org_cd();
		event = (ComSec0002Event)request.getAttribute("Event");
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
<title>ALPS Role Request</title>
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
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr class="h23">
								<td width="200">User ID&nbsp;
									<input name="rqst_usr_id" value="<%=strUsr_id%>" type="text"  maxlength="10" class="input2" style="ime-mode:abled; width:120;" readOnly>
								</td>
								<td>Office&nbsp;
									<input name="rqst_ofc_cd" value="<%=strOfcOrgCd%>" type="text" dataformat="engup" maxlength="10" class="input2" style="ime-mode:abled; width:120;" readOnly>
								</td>
								<td>&nbsp;</td>
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
						<!-- Tab_1_Button (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table  border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Add">Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_delete">Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>

										</tr>
									</table>
								</td>
							</tr>
						</table>
						
						<!-- biz_2 (E) -->
						<div id="request_area">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr class="h23">
									<td>Request Reason&nbsp;</td>
									<td><textarea name="rqst_rmk" class="input1" style="width:750px;height:55px" maxlength="1000"  fulfill caption="Request Reason"></textarea></td>
								</tr>
							</table>
						</div>
						
						<!-- Tab_1_Button (E) -->

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
											<td class="btn1" name="btn_request">Request</td>
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