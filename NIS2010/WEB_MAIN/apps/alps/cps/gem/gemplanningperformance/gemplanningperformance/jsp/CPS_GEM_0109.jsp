<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0108.jsp
     *@FileTitle : [CPS_GEM-0108] Performance Inquiry_Additional
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.06.25
     *@LastModifier : 박창준
     *@LastVersion : 1.0
     * 2009.06.25 박창준
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
<html>
<head>
  <title>No Authority</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="body"> 

<!-- Outer Table - 1st (S) -->
<table valign="middle" align="center" height="95%" border="0">
<tr><td><br>
 
 
    <!-- Outer Table - 2nd (S) -->
    <table width="727"  border="0" cellpadding="0" cellspacing="0"> 
        <tr><td height="375" background="/hanjin/img/enis/work.gif" valign="top">
                <table border="0" cellpadding="0" cellspacing="0">
                    <tr><td width="420" valign="top"><img src="/hanjin/img/enis/login/tm.gif" width="420" height="1"></td>
                    <td width="277">
                        <table border="0" class="search">
                            <tr><td valign="top" style="padding-top:60;padding-bottom:20;"><font size="+2" color="#9E3699"><strong>No Authority</strong></font></td></tr>
                            <tr><td valign="top">
                            Your office has no authority to access GEM. <br>
                            If you need to access GEM system, <br>
                            please contact committee (PLP > Eunyoung Lee).
                            </td></tr>
                        </table>
                    </td>
                    <td width="20" valign="top"></td>
                    </tr>
                </table>
            
        </td></tr>
    </table>
        
        
    <!-- Outer Table - 2nd (E) -->


</td></tr>
</table>
<!-- Outer Table - 1st (E) -->
 
</body>
</html>
