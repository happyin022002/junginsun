<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_COM_SYS_014.jsp
*@FileTitle : Role 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-02-19
*@LastModifier : Seungyol Lee
*@LastVersion : 1.0
* 2007-01-10 SeongWook Kim
* 1.0 최초 생성
*  2009-02-19 Seungyol Lee 수정 
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>사용자 조직 조회</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/alps_menu.css" rel="stylesheet" type="text/css">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/hanjin/script/wait.js"></script>
<script language="javascript">
  function setupPage(){
      loadPage();
 	 }
</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">  


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Role Code</td></tr>
        </table>

        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
        <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:484;"> 
                <tr class="h23">
                    <td width="80">Role Code</td>
                    <td width="150"><input type="text" style="width:70;" class="input" required fullfill name="role_cd" maxlength="4" style="ime-mode:disabled"></td>
                    <td width="75">Role Name</td>
                    <td width="">&nbsp;<input type="text" style="width:150;" class="input" value="" name="role_nm" maxlength="30" ></td> 
                </tr>
                </table>
                <!--  biz_1  (E) -->
                <table class="height_8"><tr><td colspan="6"></td></tr></table>
                <!--  biz_2  (S) -->
                <!-- Grid  (S) -->
                    <table width="100%" class="search"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table> 
                        
                
                <!--  biz_2   (E) -->
                
                
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 
    
            </td></tr>
        </table>
<table class="height_5"><tr><td></td></tr></table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_confirm">Confirm</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
                
            </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>
