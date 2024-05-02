<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0136.jsp
*@FileTitle : Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.09.10 이수빈
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
	String strUsr_id		= "";
	String strUsr_nm		= "";
    
	String strBlMkDesc    = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {        
		strBlMkDesc = JSPUtil.getNullNoTrim(request.getParameter("bl_mk_desc"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Remark</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<form name="form" method="post">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Remark</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
        <table class="search"> 
        <tr><td class="bg">
            
                <table class="search" border="0" style="width:280;"> 
                <tr class="h23">
                    <td width="100%"><textarea name="mark_desc" Style="width:100%" rows="9"><%=strBlMkDesc%></textarea></td>
                </tr>
                </table>
                
            </td></tr>
        </table>
		<!-- : ( Search Options ) (E) -->

</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_accept">Accept</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
                    <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                    </tr></table>
            </td></tr>
            </table>
		</td></tr>
		</table>
		
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>