<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0019.jsp
*@FileTitle : ECC별 기여도 적용 위한 표준 단가 생성_MT 회송비 조회
*Open Issues :
*Change history : REPO UC 조회화면(0019) LCC레벨 추가
*               : CSR No. R200804296329 내부 경로 변경
*@LastModifyDate : 2007-10-10
*                : 2008-05-06
*                : 2009-08-28
*@LastModifier : Ari
*              : 전윤주
*              : 박수훈
*@LastVersion : 1.0
* 2006-11-09 Sangwook_nam
* 2008-05-06 전윤주
* 2009-08-28 박수훈
* 1.0 최초 생성
=========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.04.20 전윤주 N200904070092 COA_CM 계산 수식 변경 (장비비 조회 메뉴에서 제외)
* 2009.08.28 0019 화면 New FrameWork 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        }catch(Exception e) {
        out.println(e.toString());
    }
    Logger log = Logger.getLogger("com.hanjin.apps.EQBalance.EQBalance");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Repo U/C </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form  method="post" name="form"  onKeyDown="changeSearchSheet();">
<input type="hidden" name="f_cmd">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


        <!-- TABLE '#D' : ( Button : Main ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

        <!-- TABLE '#D' : ( Button : Main ) (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
            <tr><td class="btn1_bg">

                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <!-- Repeat Pattern -->
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
                    <!-- Repeat Pattern -->

                </tr></table>

            </td></tr>
        </table>
        <!-- TABLE '#D' : ( Button : Main ) (E) -->

        <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
        <tr><td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
            <tr class="h23">
                <td width="62">YYYY-MM</td>
                <td width="100"><input type="text" name="f_cost_yrmon" style="width:60" value="" maxlength="6" class="input1"
                onBlur="addDash(this , 4);"
                onKeyPress="ComKeyOnlyNumber(window);"
                onFocus="this.value=ComReplaceStr(this.value, '-', '');" ></td>
                <td width="75">Group Cost</td>
                <td width="190">
                    <select style="width:150;" name="p_choice" class="input1" onChange="eqholding(this.value);">
                    <option value="0" selected="true">Empty Steve. / Trans.</option>
                    </select>
                </td>
                <td width="65">Type/Size</td>
                <td width="90">&nbsp;<script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 50 , 0 )</script></td>
                <td width="60"><div id="lblloc" style="visibility:visible">Location</div></td>
                <td>
                    <div id="loc_selbox" style="visibility:visible">
                    <select name="f_cost_loc_grp_cd"  style='width:60' onChange="changeLocationHierarchy(this.value)">
                        <OPTION value="E">ECC</OPTION>
                        <OPTION value="L">LCC</OPTION>
                        <OPTION value="R">RCC</OPTION>
                    </select>
                    </div>
                </td>
                <td>
                    <div id="ecc_selbox" style="display:inline">
                    &nbsp;<script language="javascript">ComComboObject('f_mty_ecc_cd',1, 80 , 0 )</script>
                    </div>
                </td>
                <td>
                    <div id="lcc_selbox" style="display:none">
                    &nbsp;<script language="javascript">ComComboObject('f_mty_lcc_cd',1, 80 , 0 )</script>
                    </div>
                </td>
                <td>
                    <div id="rcc_selbox" style="display:none">
                    &nbsp;<script language="javascript">ComComboObject('f_mty_rcc_cd',1, 80 , 0 )</script>
                    </div>
                </td>
                <td>&nbsp;</td>
                </tr>
            </table>
            <!-- : ( Year ) (E) -->
        </td></tr>
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->

        <table class="height_10"><tr><td></td></tr></table>

        <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
        <tr><td class="bg">
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s" style="padding-bottom:0;">EQ Repo-contribution Unit Cost Inquiry</td>
                    <td rowspan="2" class="gray">(Days, USD)</td></tr>
                </table>
                <div id="Layer" style="display:inline">
                <table width="100%" id="mainTable">
                      <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                      </td></tr>
                </table>
                </div>

            </td></tr>
        </table>
        <!-- TABLE '#D' : ( Button : Main )f (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>