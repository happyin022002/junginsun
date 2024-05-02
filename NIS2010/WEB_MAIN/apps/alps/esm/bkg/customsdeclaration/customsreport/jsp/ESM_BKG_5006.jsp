<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_5006.jsp
*@FileTitle : ESM_BKG_5006
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.08.07 김승민
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

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	String jpMsgTpCd = "";
	String userId = "";
	String errorCheck = "";
	String dateCheck = "";
	String inVvdCd = "";
	String inPodCd = "";
	String startRcvDt = "";
	String startRcvDt2 = "";
	String endRcvDt = "";
	String endRcvDt2 = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
		/*
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} 
		*/
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="1024" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Container Loading List(KOREA)_Print Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		

</td></tr></table>



			    <!--biz page 2 (S)-->
			    <table width="100%" height="570">
			        <tr>
			            <td width="100%"><script language="javascript">comRdObject('report1');</script></td>
			            <td width="10">&nbsp;</td>
			        </tr>
			    </table>
			    <!--biz page 2 (E)-->


<table class="height_5"><tr><td></td></tr></table>
	
</form>			
</body>
</html>

		