<%/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_0152.jsp
*@FileTitle : Korea MOF Filing (Base Table)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0152Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0152Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmPri0152Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			log.debug(serverException);
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Korea MOF Filing (Base Table)</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- Hidden sheet for Transaction (S) -->
			<script language="javascript">ComSheetObject('sheet1');</script>
			<!-- Hidden sheet for Transaction (E) -->
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
			
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0"> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
				</td></tr>
			</table>
			<!-- Tab ) (E) -->
		
			<!-- iFrame (S) -->
            <div id="tabLayer" style="display:none">
            <iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="650" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="650" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="650" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="650" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="650" src="about:blank"></iframe>
            </div>
			<!-- iFrame (E) -->
			
	</td></tr>
</table>
</form>
</body>
</html>