<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0711.jsp
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.04
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.05.04 임진영
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0711Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0711Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.FullReleaseOrder");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg0711Event)request.getAttribute("Event");
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
<title>Cargo Release Order History</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input name='bkg_no' type="hidden" value='<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>'>
<input name='bl_no' type="hidden" value='<%=JSPUtil.getNull(request.getParameter("bl_no"))%>'>
<input name='h_bl_tp_cd' type="hidden" value='<%=JSPUtil.getNull(request.getParameter("bl_tp_cd"))%>'>
<!-- 개발자 작업    -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr>
    <td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr>
            <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Cargo Release Order History</td>
        </tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!--biz page (S)-->
        <table class="search" id="mainTable">
        <tr>
            <td class="bg">

                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:760">
                <tr class="h23">
                    <td width="60">B/L No.</td>
                    <td>
                        <input name='h_bl_no' type="text" style="width:110;" class="input2" maxlength='12' readonly value=''>&nbsp;
                    </td>
                    <!--
                    <td width="118">
                        <input name='rdo_flag' type="radio" class="trans" value='CON'>&nbsp;Container No.</td>
                    <td width="130">
                        <input name='cntr_no' type="text" style="width:120;" class="input1" maxlength='14'></td>
                    <td width="82">
                        <input name='rdo_flag'  type="radio" class="trans" value='BKG'>&nbsp;BKG No.</td>
                    <td width=""><input name='bkg_no' type="hidden" style="width:100;" class="input1" maxlength='13'></td>
                    -->
                </tr>
                </table>
                <!--  biz_1   (E) -->
            </td>
        </tr>
        </table>

        <table class="height_8"><tr><td></td></tr></table>

        <table class="search" id="mainTable">
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
        <!--biz page (E)-->
        <table class="height_5"><tr><td></td></tr></table>
    </td>
</tr>
</table>



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr>
    <td height="71" class="popup">
        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
            <td class="btn3_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <!--
                    <td>
                        
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_retrieve">Retrieve</td>
                            <td class="btn1_right"></td>
                        </tr>
                        </table>
                    </td>
                    <td class="btn1_line"></td>
                    -->
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>