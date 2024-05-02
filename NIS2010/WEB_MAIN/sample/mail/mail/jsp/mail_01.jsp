<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : mail_01.jsp
*@FileTitle : Mail Sample
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.22 
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
<%@ page import="com.hanjin.sample.mail.mail.event.Mail01Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<html>
<head>
<title>Mail Sample</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>
<script language="javascript" type="text/javascript" src="apps/nis2010/esm/bkg/CoBkg.js"></script>

<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<bod>
<form name="form" action="MAIL_01GS.do">
<input type="hidden" name="f_cmd" value="11">
<input type="hidden" name="pagerows">
 <input type="button" value="Fire" onclick="form.submit()">
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>