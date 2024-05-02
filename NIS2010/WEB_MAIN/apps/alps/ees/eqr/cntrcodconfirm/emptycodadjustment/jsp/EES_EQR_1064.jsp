<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1064.jsp
*@FileTitle : MTY Repo Inquiry by Period
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 문중철
*@LastVersion : 1.0 
* 2009.07.16 문중철
* 1.0 최초 생성 
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EES_EQR_1023HTMLAction"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1023Event"%>

<html>
<head>
<title>MTY Repo Inquiry by Period</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    function setupPage(){
        loadPage();     
    }
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
    <tr><td class="top"></td></tr>
    <tr><td valign="top">

    <!-- : ( Title ) (S) -->
    <table width="580" border="0">
    <tr><td class="title"><img src="/hanjin/img/alps/ico_t1.gif" width="20" height="12">MTY Repo Inquiry by Period</td></tr>
    </table>
    <!-- : ( Title ) (E) -->

    <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
        <table class="search">
        <tr><td class="bg_b1">

            <table class="height_10"><tr><td></td></tr></table>

            <!-- : ( Seq. ) (S) -->
            <table border="1" style="width:737;" height="545" class="grid" >
            <tr><td><script language='javascript'>comRdObject('csrPrevie');</script></td></tr>
            <!-- : ( Seq. ) (E) -->
 			</table>
            <!-- : ( Button : Sub ) (S) -->
            <table width="100%" class="sbutton">
            <tr><td class="align">

                <table class="sbutton">
                <tr><td class="bt"><img class="cursor" src="/hanjin/img/alps/button/btng_print.gif" width="65" height="19" border="0" name="btng_print"></td></tr>
                </table>

            </td></tr>
            </table>
            <!-- : ( Button : Sub ) (E) -->
        </td></tr>
    </table>
    <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
    
<table class="height_5"><tr><td></td></tr></table>
    
</td></tr>
</table>

<!-- OUTER - POPUP (E)nd -->
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <table class="sbutton">
        <tr><td class="p_bt"><img class="cursor" src="/hanjin/img/alps/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
        </table>

    </td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>

