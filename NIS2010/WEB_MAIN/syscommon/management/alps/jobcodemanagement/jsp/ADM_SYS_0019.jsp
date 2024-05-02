<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ADM_SYS_0019.jsp
*@FileTitle : Job Code Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.05.24 김상수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	AdmSys0019Event event = null;
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
		event = (AdmSys0019Event)request.getAttribute("Event");
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
<title>Job Code Approval</title>
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
<!-- 개발자 작업 -->


<input name="apro_rqst_no" type="hidden">
<input name="apsts_cd" type="hidden">


<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:700px">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">


			<!-- Page Title (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Job Code Approval</td></tr>
			</table>
			<!-- Page Title (E) -->


			<!-- biz page (S) -->
			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_1 (S) -->
						<table border="0" cellpadding="0" cellspacing="0">
							<tr class="h23">
								<td style="padding-right:100px">User ID&nbsp;
									<input name="rqst_usr_id" type="text" class="input2" style="width:120;" readOnly>
								</td>
								<td>Office Code&nbsp;
									<input name="rqst_ofc_cd" type="text" class="input2" style="width:100;" readOnly>
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
						<!-- biz_3 (S) -->
						<table border="0" cellpadding="0" cellspacing="0">
							<tr class="h23" valign="top">
								<td>Requestor&nbsp;</td>
								<td style="padding-right:30px"><input name="rqst_usr_nm" type="text" class="input2" style="width:120;" readOnly></td>
								<td>Comment&nbsp;</td>
								<td><textarea name="rqst_rmk" class="input2" style="width:350px;height:36px" maxlength="200" readOnly></textarea></td>
							</tr>
							<tr class="h23" valign="top">
								<td>Approver&nbsp;</td>
								<td><input name="apro_usr_nm" type="text" class="input2" style="width:120px;" value="<%=strUsr_nm%>" readOnly></td>
								<td>Comment&nbsp;</td>
								<td><textarea name="apro_rmk" class="input1" style="width:350px;height:36px" maxlength="200" required caption="Comment"></textarea></td>
							</tr>
						</table>
						<!-- biz_3 (E) -->
						<table class="height_8"><tr><td></td></tr></table>
						<!-- Button (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
							<tr>
								<td class="btn1_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_approval">Approval</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_reject">Reject</td>
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
			<!-- biz page (E) -->


		</td>
	</tr>
</table>


<table class="height_2"><tr><td></td></tr></table>


<!-- ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
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
<!-- ( Button : pop ) (E) -->


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
