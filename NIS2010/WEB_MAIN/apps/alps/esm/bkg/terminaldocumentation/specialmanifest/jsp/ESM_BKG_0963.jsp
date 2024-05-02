<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0963.jsp
*@FileTitle : ESM_BKG_0963
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.27 경종윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0963Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0963Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.SpecialManifest");
	
	String vvdCd 	= "";
	String portCd 	= "";
	String etaDate 	= "";
	String etaTime 	= "";
	String etdDate 	= "";
	String etdTime 	= "";
	String openType = "";
	String currMainPageListCnt = "0";

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0963Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		// 부모창에서 넘오온 파라메터 셋팅
		vvdCd 	= (request.getParameter("vvdCd") == null) 	? "" : request.getParameter("vvdCd");
		portCd 	= (request.getParameter("portCd") == null) 	? "" : request.getParameter("portCd");
		etaDate = (request.getParameter("etaDate") == null) ? "" : request.getParameter("etaDate");
		etaTime = (request.getParameter("etaTime") == null) ? "" : request.getParameter("etaTime");
		etdDate = (request.getParameter("etdDate") == null) ? "" : request.getParameter("etdDate");
		etdTime = (request.getParameter("etdTime") == null) ? "" : request.getParameter("etdTime");
		openType = (request.getParameter("openType") == null) ? "" : request.getParameter("openType");
		currMainPageListCnt = (request.getParameter("currMainPageListCnt") == null) ? "0" : request.getParameter("currMainPageListCnt");
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>


<body class="popup_bg" onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="openType" value=<%=openType %>>
<input type="hidden" name="currMainPageListCnt" value=<%=currMainPageListCnt %>>

<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;Bay plan Setup</td>
			</tr>
		</table>
		<!--Page Title, Historical (E)-->	
		
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="50">VVD</td> 
					<td width="170"><input type="text" style="width:80" class="input2" name="vvd_cd" readOnly value="<%= vvdCd %>"></td>
					<td width="65">Port</td> 
					<td width=""><input type="text" style="width:50" class="input2" name="port_cd" readOnly value="<%= portCd %>"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="50">Arrival</td> 
					<td width="170">
						<input type="text" style="width:80" class="input2" readOnly name="eta_date" value="<%= etaDate %>">&nbsp;<input type="text" style="width:50" class="input2" readOnly name="eta_time" value="<%= etaTime %>">
					</td>
					<td width="65">Departure</td> 
					<td width="">
						<input type="text" style="width:80" class="input2" readOnly name="etd_date" value="<%= etdDate %>">&nbsp;<input type="text" style="width:50" class="input2" readOnly name="etd_time" value="<%= etdTime %>">
					</td>
				</tr>
			</table>
			<br>
			<!-- : ( Grid ) (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- : ( Grid ) (E) -->	
		
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<% if("1".equals(openType)) { %>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<% } else  { %>
				<td><table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Detail">Bay-Plan Detail</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<% } %>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	
			
		
<!-- 개발자 작업  끝 -->
</form>
			
</body>
</html>
