<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ADM_SYS_0017.jsp
*@FileTitle : Job Code Approver
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.15
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2012.07.15 최덕우
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.jobcodemanagement.event.AdmSys0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	AdmSys0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.syscommon.management.alps.JobCodeManagement");

	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (AdmSys0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Program Office Mapping</title>
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
<input type="hidden" name="ofc_cd" value="<%=JSPUtil.getParameter(request,"ofc_cd") %>">


<!-- 개발자 작업 -->
<table width="100%" class="popup" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; width:700px">
<tr><td class="top"></td></tr>
<tr><td valign="top">

   <!-- : ( Title ) (S) -->
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	   <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Job Code Approver</td></tr>
   </table>

		<table class="height_15"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0" width=580>
				<tr><td class="bg_b1">

				<table class="height_10"><tr><td></td></tr></table>

				<table class="search" border="0" width="580">
					<tr>
						<td width="100%" valign="top">
						
							<!-- : ( Grid ) (S) -->
							<table width="100%" id="mainTable">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
								</tr>
							</table>
							<!-- : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_2"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
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
											<td class="btn1" name="btn_submit">Submit</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right">
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
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업 끝 -->


</body>
</form>
</html>

<%@ include file="/bizcommon/include/common_nis2010.jsp" %>