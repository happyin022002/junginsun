<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : esm_bkg_0999.jsp
*@FileTitle      : Attorney Create Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.12
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.05.12 임진영
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0999Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0999Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strOfc_nm        = "";

    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.FullReleaseOrder");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        strUsr_id     = account.getUsr_id();
        strUsr_nm     = account.getUsr_nm();
        strOfc_cd     = account.getOfc_cd();
        strOfc_nm     = account.getOfc_eng_nm();

        event = (EsmBkg0999Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Attorney Create Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onKeyDown="enterKeySearch();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업    -->
<input type="hidden" name="insertRow" value='0'>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Attorney Create</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->
        <table class="search">
        <tr>
            <td class="bg">

                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="250">
                        <table class="search_sm2" border="0" style="width:90%;">
                        <tr class="h23">
                            <td>고객 Type</td>
                            <td class="stm"><input type="radio" name="rdo_flag" class="trans">수임자&nbsp;&nbsp;&nbsp;<input type="radio" name="rdo_flag" class="trans">위임자</td>
                        </tr>
                        </table>
                    </td>
                    <td width="40">고객명</td>
                    <td width="220">
                        <input type="text" style="width:140;" class="input" name='cust_name'>
                        <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='pop_attorney'>
                    </td>
                    <td width="100">사업자등록번호</td>
                    <td width=""><input type="text" style="width:140;" class="input" name='cust_biz_no' maxlength="12" value="<%=JSPUtil.getNull(request.getParameter("cust_biz_no"))%>"></td>
                </tr>
                </table>

                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
                </tr>
                </table>
                <!-- : ( Grid ) (E) -->
        
                <!--  Button_Sub (S) -->
                <table width="100%" class="button">
                <tr>
                    <td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                    <td class="btn2" name="btn_Row_Add">Row Add</td>
                                    <td class="btn2_right"></td>
                                </tr>
                                </table>
                            </td>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                    <td class="btn2" name="btn_Row_Copy">Row Copy</td>
                                    <td class="btn2_right"></td>
                                </tr>
                                </table>
                            </td>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                    <td class="btn2" name="btn_Row_Delete">Row Delete</td>
                                    <td class="btn2_right"></td>
                                </tr>
                                </table>
                            </td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
                <!-- Button_Sub (E) -->
            </td>
        </tr>
        </table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
    </td>
</tr>
</table>




<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr>
    <td height="71" class="popup">
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr><td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_Retrieve">Retrieve</td>
                            <td class="btn1_right">
                        </tr>
                        </table>
                    </td>
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_Register">Register</td>
                            <td class="btn1_right">
                        </tr>
                        </table>
                    </td>
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_Save">Save</td>
                            <td class="btn1_right">
                        </tr>
                        </table>
                    </td>
                    <td class="btn1_line"></td>
                    <td>
                        <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_Close">Close</td>
                            <td class="btn1_right">
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
            </td>
        </tr>
        </table>
    <!--Button (E) -->
    </td>
</tr>
</table><!-- : ( Button : pop ) (E) -->
<input type="hidden" name="user_id" value='<%=strUsr_nm%>'>
<input type="hidden" name="user_nm" value='<%=strUsr_nm%>'>
<input type="hidden" name="ofc_cd"  value='<%=strOfc_cd%>'>
<input type="hidden" name="ofc_nm"  value='<%=strOfc_nm%>'>
<input type="hidden" name="atty_cust_nm">
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>