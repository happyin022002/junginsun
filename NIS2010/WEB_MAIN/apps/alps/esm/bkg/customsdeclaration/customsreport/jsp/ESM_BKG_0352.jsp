<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0352.jsp
*@FileTitle : ESM_BKG_0352
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.07 임재택
* 1.0 Creation
* 1.1 2015.04.27 소스보안[CWE-080]으로 수정 ->2015.11.05 live반영
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%	 
	String bl_no = "";	  	
	try {	 
		bl_no = (StringUtil.xssFilter(request.getParameter("bl_no")) == null) ? "" : StringUtil.xssFilter(request.getParameter("bl_no"));		 				
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){		 
		loadPage();
	}
</script>
</head>

<body class="popup" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bl_no" value="<%= bl_no %>">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">	
		<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  I/B B/L Print File_Print Preview</td></tr>
			</table>
		<!-- : ( Title ) (E) -->		
		



			    <!--biz page 2 (S)-->
			    <table width="100%" height="450" >
			        <tr>
			            <td width="100%"><script language="javascript">comRdObject('report1');</script></td>
			            <td width="10">&nbsp;</td>
			        </tr>
			    </table>
			    <!--biz page 2 (E)--></td>
	</tr>
</table>
</form>
</body>
</html>