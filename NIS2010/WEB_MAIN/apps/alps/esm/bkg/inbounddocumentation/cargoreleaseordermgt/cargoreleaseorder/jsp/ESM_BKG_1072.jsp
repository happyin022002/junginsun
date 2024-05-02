<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_1072.jsp
*@FileTitle      : Korea Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.22
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.05.22 임진영
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    Exception serverException = null;         //서버에서 발생한 에러
    String strErrMsg = "";                    //에러메세지
    int rowCount     = 0;                     //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";

    String strUsr_id   = "";
    String strUsr_nm   = "";
    String strOfcCd    = "";
    String strCntCd    = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
        strCntCd  = account.getCnt_cd();

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Cargo Release Order Demurrage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    /**************************************
        전역 변수 선언
    **************************************/

    var lginOfcCd = "<%=strOfcCd %>"; //로그인 사용자 오피스 코드
    var lginCntCd = "<%=strCntCd %>"; //로그인 사용자 국가 코드
    var strUsr_id = "<%=strUsr_id%>"; //로그인 사용자 아이디

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<body class="popup_bg"  onLoad="setupPage()">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Cargo Release Order Demurrage </td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->

        <table class="search">
        <tr>
            <td class="bg">
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
                </tr>
                </table>
                <!-- Grid (E) -->
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
                <tr>
                    <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                        <td class="btn1" name="btn_close">Close</td>
                        <td class="btn1_right"></td>
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
</table>
<!-- : ( Button : pop ) (E) -->
<input type="hidden" name='cntr_no' value ='<%=JSPUtil.getNull(request.getParameter("cntr_no"))%>'>
</form>
</body>
</html>