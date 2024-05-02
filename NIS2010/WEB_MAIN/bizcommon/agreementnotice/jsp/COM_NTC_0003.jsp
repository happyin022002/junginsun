<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_NTC_0003.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.28
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2014.01.28 전윤주
* 1.0 Creation
=========================================================
* History
=========================================================*/
%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.agreementnotice.event.ComNtc0003Event"%>

<%
	ComNtc0003Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String inlandFlag = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	String fPgmNo = "";
	Logger log = Logger.getLogger("com.hanjin.bizcommon.BizCommonSC.AgreementNoticeBC"); 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (ComNtc0003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		fPgmNo = JSPUtil.getNull(request.getParameter("f_pgm_no"));
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Agreement Notification(hidden) </title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="f_pgm_no" value="<%=fPgmNo%>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

<!--biz page (S)-->
<table class="search"> 
    <tr><td class="bg">

	<!--  biz_1  (S) -->

	<!--  biz_1  (E) -->	     				  	
	<!-- Grid  (S) -->
	<table width="979"  id="mainTable">
		<tr><td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
		</td></tr>
	</table>
	<!-- Grid (E) -->

	</td></tr>
</table>

<!--biz page (E)-->	

    <table class="height_8"><tr><td></td></tr></table>    	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>