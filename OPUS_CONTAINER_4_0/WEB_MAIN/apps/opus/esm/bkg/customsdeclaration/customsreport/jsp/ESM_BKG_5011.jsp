<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_5011.jsp
*@FileTitle : ESM_BKG_5011
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.07 김승민
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0951Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	//EsmBkg5011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String inVvdCd = "";
	String inPolCd = "";
	String inPolYdCd = "";
	String inBkgOfcCd = "";
	String setText1 = "";
	String setText2 = "";
	String remark = "";
	String vvdCd = "";
	String unLocCd = "";
	String vpsEtdDt = "";	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
/*	   
		event = (EsmBkg5011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
*/		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		/* 부모창에서 넘오온 파라메터 셋팅
		inVvdCd = (request.getParameter("inVvdCd") == null) ? "" : request.getParameter("inVvdCd");
		inPolCd = (request.getParameter("inPolCd") == null) ? "" : request.getParameter("inPolCd");
		inPolYdCd = (request.getParameter("inPolYdCd") == null) ? "" : request.getParameter("inPolYdCd");
		inBkgOfcCd = (request.getParameter("inBkgOfcCd") == null) ? "" : request.getParameter("inBkgOfcCd");
		setText1 = (request.getParameter("setText1") == null) ? "" : request.getParameter("setText1");
		setText2 = (request.getParameter("setText2") == null) ? "" : request.getParameter("setText2");
		remark = (request.getParameter("remark") == null) ? "" : request.getParameter("remark");
		vvdCd = (request.getParameter("vvdCd") == null) ? "" : request.getParameter("vvdCd");
		unLocCd = (request.getParameter("unLocCd") == null) ? "" : request.getParameter("unLocCd");
		vpsEtdDt = (request.getParameter("vpsEtdDt") == null) ? "" : request.getParameter("vpsEtdDt");
		*/
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<input type="hidden" name="inVvdCd" value="<%= inVvdCd %>">
<input type="hidden" name="inPolCd" value="<%= inPolCd %>">
<input type="hidden" name="inPolYdCd" value="<%= inPolYdCd %>">
<input type="hidden" name="inBkgOfcCd" value="<%= inBkgOfcCd %>">
<input type="hidden" name="setText1" value="<%= setText1 %>">
<input type="hidden" name="setText2" value="<%= setText2 %>">
<input type="hidden" name="remark" value="<%= remark %>">
<input type="hidden" name="vvdCd" value="<%= vvdCd %>">
<input type="hidden" name="unLocCd" value="<%= unLocCd %>">
<input type="hidden" name="vpsEtdDt" value="<%= vpsEtdDt %>">


<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="1024" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Load Summary by POD Print</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		

</td></tr></table>



			    <!--biz page 2 (S)-->
			    <table width="100%" height="450">
			        <tr>
			            <td width="10">&nbsp;</td>
			        </tr>
			    </table>
			    <!--biz page 2 (E)-->


<table class="height_5"><tr><td></td></tr></table>
	
</form>			
</body>
</html>

		