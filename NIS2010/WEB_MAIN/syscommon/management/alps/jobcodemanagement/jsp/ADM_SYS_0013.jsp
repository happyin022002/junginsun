<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ADM_SYS_0013.jsp
*@FileTitle : Job Code Prgram Assign
*Open Issues :
*Change history :
*@LastModifyDate : 2012-05-27
*@LastModifier : DukWoo Choi
*@LastVersion : 1.0
* 2012-05-27 DukWoo Choi
* 1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	AdmSys0013Event  event = null;
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.syscommon.management.alps.JobCodeManagement");

	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (AdmSys0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Job Code Program Assign</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/alps_menu.css" rel="stylesheet" type="text/css">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">

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
<input type="hidden" name="prnt_pgm_no" value="000_000_M000">
<input type="hidden" name="pgm_no_form">


<!-- 개발자 작업 -->

<table width="100%" class="popup" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; width:700px">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Job Code Program Assign</td></tr>
		</table>

		<!-- : ( Title ) (E) -->

		<table class="search">
			<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
					<tr class="h23">
						<td style="paading-right:30px">Job Code&nbsp;
							<input type="text" style="ime-mode:disabled; width:70px;" class="input2" required fullfill name="usr_role_cd" value="<%=JSPUtil.getParameter(request,"usr_role_cd")%>" maxlength="5" readOnly></td>
						<td>Job Name&nbsp;
							<input type="text" style="ime-mode:disabled; width:250px;" class="input2" name="usr_role_nm" value="<%=JSPUtil.getParameter(request,"usr_role_nm")%>" maxlength="30" readOnly></td>
				 	</tr>
				</table>

		<!-- : ( Scenario ID ) (E) -->

	  </tr>
	</table>
	<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->


	<table class="height_15"><tr><td></td></tr></table>

	<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	  <table class="search" border="0" width="580" style="table-layout:fixed">
		<tr><td class="bg_b1" valign="top">

		<table class="height_10"><tr><td></td></tr></table>

		<table class="search" border="0" width="580">
			<tr>
				<td width="100%" valign="top">
					<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">Menu List</td>
						</tr>
					</table>
					<table width="100%" id="mainTable">
						<tr>
							<td><script language="javascript">ComSheetObject('sheet1');</script></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		</td>
		<td class="bg_b1" valign="top">

		<table class="height_10"><tr><td></td></tr></table>

		<table class="search" border="0" width="580">
			<tr>
				<td width="100%" valign="top">
					<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Program List</td>
							<td align="right"><input type="checkbox" name="showAll1" class="trans">&nbsp;Show mapped program only</td>
						</tr>
					</table>
					<table width="100%" id="mainTable">
						<tr>
							<td><script language="javascript">ComSheetObject('sheet2');</script></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		</td></tr>
	</table>


<table class="height_2"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr><td class="btn3_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<%if(JSPUtil.getParameter(request,"prnt_no").equals("0011")){ %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
				<%} %>
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
	<!--Button (E) -->
  </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>