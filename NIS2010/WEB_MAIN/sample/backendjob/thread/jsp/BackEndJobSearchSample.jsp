<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BACKENDJOB.jsp
*@FileTitle : BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.09.14 김정훈
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
<%@ page import="com.hanjin.sample.backendjob.thread.event.BackEndJobSampleEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BackEndJobSampleEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BackEndJob.UsingTimer");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (BackEndJobSampleEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>BackEndJob</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="backendjob_key">
<!-- 개발자 작업	-->
<table width="100%" id="mainTable">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
	</tr>
</table>
MDM_VANDOR Table을 전체 조회 한 후 전체 로우 수를 가져오는 BackEndJob 수행
<p>
<!--Button (S) -->

<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
	<tr>     
		<td class="btn1_left"></td>
		<td class="btn1" name="btn_DoJob">Fire</td>
		<td class="btn1_right"></td>
	</tr>
</table>
<p>
<input type="text" name="result">
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>