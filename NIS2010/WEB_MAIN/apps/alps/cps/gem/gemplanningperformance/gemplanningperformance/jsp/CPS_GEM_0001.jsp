<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0001.jsp
     *@FileTitle : [CPS_GEM-0001] Expense Request
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
GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
String authFlg = (String)eventResponse.getCustomData("auth_flg");
if (authFlg == null ) {
	authFlg = "";
}
%>
<html>
<head>
<title>Expense Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>
<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="auth_flg" value="<%=authFlg%>">
<!-- 개발자 작업 -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
    <td valign="top" height="100%">
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">Expense Request</span></td></tr>
        </table>
         <!--Page Title, Historical (E)-->
    
            
        <!--biz page (S)-->
   
        <!-- Tab (S) -->
        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr><td><script language="javascript">ComTabObject('tab1','white','100%',27,false)</script></td></tr>
        </table>
        <!-- Tab (E) -->
                    
        <!-- iFrame (S) -->
        <div id="tabLayer" style="display:inline;">
        <iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="560" src="CPS_GEM_0001_01.do"></iframe>
        </div>
        <div id="tabLayer" style="display:none">
        <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="810" src=""></iframe>
        </div>
        <div id="tabLayer" style="display:none;overflow: visible;">
        <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%"  height="500" src=""></iframe>
        </div>
        <!-- iFrame (E) -->
           
       <!--biz page (E)-->
    
    </td></tr>
    </table>
</form>
</body>
</html>