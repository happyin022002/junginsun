<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0123.jsp
*@FileTitle : Vessel Information
*Open Issues :
*Change history :
* 2007-01-17 Kim Jong Beom
* 2009.10.23 김기대 New FrameWork 적용
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
*@LastModifyDate : 2010.06.10
*@LastModifier : 송호진
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Vessel Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage() {
        loadPage();
        btn_Retrieve.focus();
    }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- OUTER - POPUP (S)tart -->
<table width="650" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">


        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Vessel Information</td></tr>
        </table>
        <!-- : ( Title ) (E) -->


        <!--Button_L (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
            <tr><td class="btn1_bg">

                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <!-- Repeat Pattern -->
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

                    <td class="btn1_line"></td>
                    <!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_Save" name="btn_Save">Save</td><td class="btn1_right"></td>
                        </tr>
                        </table>
                    </td -->
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td><td class="btn1_right"></td>
                        </tr>
                        </table>
                    </td>
                    <!-- Repeat Pattern -->

                </tr></table>

            </td></tr>
        </table>
        <!--Button_L (E) -->

        <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
        <table class="search">
        <tr>
            <td class="bg">


                <!-- : ( Location ) (S) -->
                <table class="search" border="0">
                <tr class="h23">
                    <td width="7%">Vessel</td>
                    <td width="20%">
                        <input type="text" name="f_vsl_cd" style="width:80;text-align:center;" maxlength="4"
                           onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                           onFocus="this.select();" ></td>
                    <td width="7%">Carrier</td>
                    <td><input type="text" name="f_crr_cd" style="width:80;text-align:center;" maxlength="4"
                           onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                           onFocus="this.select();" >
                    </td>
                </tr>
                </table>
                <!-- : ( Location ) (E) -->

                <table class="line_bluedot"><tr><td></td></tr></table>

                <!-- : ( Speed ) (S) -->
                <table width="100%" id="mainTable">
                <tr>
                    <td><script language="javascript">ComSheetObject('sheet1');</script></td>
                </tr>
                </table>
                <!-- : ( Speed ) (E) -->

            </td>
        </tr>
        </table>
        <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

    </td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>

                <!-- Repeat Pattern -->
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
                <!-- Repeat Pattern -->

            </tr>
        </table>

    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>

<script language="javascript">
<!--
    with(document.form) {
    }
-->
</script>
