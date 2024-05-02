<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_GEM_0102.jsp
     *@FileTitle :  [CPS_GEM_0102] Note
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0007Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
String text = JSPUtil.getParameter(request,"text",""); 
String type = JSPUtil.getParameter(request,"type","");
String saveYn =JSPUtil.getParameter(request,"saveYn","Y");
String title = "";

if ("A".equals(type)) {
	title = "Request Item";
} else if ("B".equals(type)) {
	title = "Calculation Basis";
} else if ("C".equals(type)) {
	title = "Requester's Opinion";
} else if ("D".equals(type)) {
	title = "Request Item";	
}

%>
<html>
<head>
<title>Note</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var type = "<%=type%>";
        loadPage(type);
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="type" value="<%=type%>">
<input type="hidden" name="text" value="<%=text%>">
<input type="hidden" name="saveYn" value="<%=saveYn%>">
<!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10" style="border: 0px solid"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=title %></td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:100%;"> 
                    <tr class="h23">
                        <td><textarea name="note" class="textarea" style="width:100%;height:200"><%=text%></textarea></td>
                    </tr>
                </table> 
                            
                <!--  biz_1   (E) -->
                
            
        </td></tr></table>
        <!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>    
</td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
            <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <%
                if (!"D".equals(type) && "Y".equals(saveYn)) {                	
                %>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Save">Save</td>
                    <td class="btn1_right"></td>
                </tr></table></td>      
                 <td class="btn1_line"></td>
                <%
                }   
                %>    
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                
            </tr>
            </table>
        <!--Button (E) -->    
        </td></tr>
        </table>
    </td></tr>    
</table>

 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>