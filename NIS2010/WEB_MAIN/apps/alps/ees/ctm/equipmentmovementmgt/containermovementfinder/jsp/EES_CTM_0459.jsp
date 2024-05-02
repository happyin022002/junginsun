<%
/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1949.jsp
*@FileTitle : Load Factor by Trade-RD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.09.21 우경민
* 1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<html>
<head>
<title>Movement History by Detail Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<%
	SignOnUserAccount act = new SignOnUserAccount();
	String cntCd = act.getCnt_cd();
%>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="user_id" value="<%=act.getUsr_id() %>">
<input type="hidden" name="ofc_cd" value="<%=act.getOfc_cd() %>">
<input type="hidden" name="cnt_cd" value="<%=act.getCnt_cd() %>">

<script language='javascript'>comRdObject('csrPrevie');</script>
</form>
</body>
</html>

