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
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<html>
<head>
<title>Admin Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">


<!-- 개발자 작업 -->
<!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10" style="border: 1px solid"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
    
    
    
    
    
    
    

        <!-- : ( Title ) (E) -->
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;전표 실적,예산 데이타 정규화</td></tr>
        </table>
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:100%;"> 
                    <tr class="h23">
                        <td width="60">실적년월:</td>
                        <td width="100" align="left"><input type="text" class="input1" fullfill required style="ime-mode:disabled" name="rslt_yrmon" size="10" maxlength="6" dataformat="engup"></td>
                        <td width="120">FROM 오피스코드:</td>
                        <td width="100"><input type="text" name="from_ofc_cd" class="input1" required style="ime-mode:disabled" size="20" maxlength="100" dataformat="engup"></td>
                        <td width="100">TO 오피스코드:</td>                        
                        <td width="100"><input type="text" name="to_ofc_cd" class="input1" required style="ime-mode:disabled" size="20" maxlength="100" dataformat="engup"></td>
                        <td width="60">비용코드:</td>
                        <td width="100"><input type="text" name="gen_expn_cd" class="input1" required style="ime-mode:disabled" size="10" maxlength="100" dataformat="engup"></td>
                        <td>                        
		                <table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
		                    <tr>
		                        <td class="btn1_left"></td>
		                        <td class="btn1" name="btn1_Save01">Save</td>
		                        <td class="btn1_right"></td>
		                    </tr>
		                </table>
                        </td>
                    </tr>
                </table>    
                <!--  biz_1   (E) -->
            </td>
            </tr>
            <tr><td height="50"></td></tr>        
        </table>
        <!--biz page (E)--> 
</form>


<form name="form2" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;년월  누적금액갱신</td></tr>
        </table> 
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:100%;"> 
                    <tr class="h23">
                        <td width="60">실적년월:</td>
                        <td width="100" align="left"><input type="text" class="input1" fullfill required style="ime-mode:disabled" name="rslt_yrmon" size="10" maxlength="6" dataformat="engup"></td>                        
                        <td>                        
                        <table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                                <td class="btn1_left"></td>
                                <td class="btn1" name="btn1_Save02">Save</td>
                                <td class="btn1_right"></td>
                            </tr>
                        </table>
                        </td>
                    </tr>
                </table>    
                <!--  biz_1   (E) -->
            </td>
            </tr>
            <tr><td height="50"></td></tr>        
        </table>
        <!--biz page (E)--> 
</form>






</td></tr></table>
<table class="height_5"><tr><td></td></tr></table>
<!-- 개발자 작업  끝 -->
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>

</body>
</html>