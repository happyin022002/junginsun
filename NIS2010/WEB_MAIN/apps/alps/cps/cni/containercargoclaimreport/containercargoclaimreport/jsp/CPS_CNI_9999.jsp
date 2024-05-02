<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_9999.jsp
     *@FileTitle :  [CPS_CNI_9999] Rd View 공통 파일
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<% 
String param = JSPUtil.getParameter(request,"com_mrdArguments","");
String title = JSPUtil.getParameter(request,"com_mrdBodyTitle","");
String mrd = JSPUtil.getParameter(request,"com_mrdPath","");
%>
<html>
<head>
<title><%=title%></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    function setupPage(){      
        loadPage();
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="param" value="<%=param%>">
<input type="hidden" name="title" value="<%=title%>">
<input type="hidden" name="mrd" value="<%=mrd%>">

<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table class="popup" cellpadding="10" width="100%" height="88%"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=title%></td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        <table id="rdTable" width="100%" height="94%">
            <tr>
                <td height="100%" ><script language="javascript">
                    comRdObject('rd1');
                </script></td>
            </tr>
        </table>
        
        <!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->        
        <table class="height_5"><tr><td></td></tr></table>
        <!-- OUTER - POPUP (E)nd -->
</td></tr>
</table>  
    
    
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr><td class="btn1_left"></td>
                                <td class="btn1" name="btn_Close">Close</td>
                                <td class="btn1_right"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                </table>
            </td>
            </tr>
        </table>

    </td></tr>
</table>

</form>
</body>
</html>