<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG-0737.jsp
*@FileTitle      : Cargo Release Order Auto Pop-up Remark
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-07-16
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009-07-16 임진영
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0954Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0954Event event     = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //서버에서 발생한 에러
    String strErrMsg = "";                    //에러메세지
    int rowCount     = 0;                     //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";

    String strUsr_id   = "";
    String strUsr_nm   = "";

    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.FullReleaseOrder");
    SignOnUserAccount account= null;
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0954Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Cargo Release Order Auto Pop-up Remark</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
    function setupPage(date){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage('<%=DateTime.getTimeStampString2()%>', '<%=account.getUsr_id()%>');
    }
</script>

<body  onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="h_rmk">
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type="hidden" name="remark" value="<%=JSPUtil.getNull(request.getParameter("remark"))%>">
<input type="hidden" name="evnt_dt" value="<%=JSPUtil.getNull(request.getParameter("evnt_dt"))%>">
<input type="hidden" name="evnt_usr_id" value="<%=JSPUtil.getNull(request.getParameter("evnt_usr_id"))%>">
<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0">
<tr>
    <td class="top"></td>
</tr>
<tr>
    <td valign="top">
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Cargo Release Order Auto Pop-up Remark</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->
        <table class="search">
        <tr>
            <td class="bg">
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
                </table>
                <!-- : ( Grid ) (E) -->
            </td>
        </tr>
        </table>
        <!-- : ( Search Options ) (E) -->
    </td>
</tr>
</table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr>
    <td height="71" class="popup">
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
            <td class="btn3_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td id="id_save">
                        <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn1_Save">Save</td>
                            <td class="btn1_right">
                        </tr>
                        </table>
                    </td>

                    <td>
                        <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn1_Close">Close</td>
                            <td class="btn1_right">
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
            </td>
        </tr>
        </table>
    </td>
</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</body>
</html>