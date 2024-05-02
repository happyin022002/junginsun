<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2049.jsp
*@FileTitle : RFA Proposal Creation - Request Received and Sent
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.05 문동규
* 1.0 Creation
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정  
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만
자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2049Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri2049Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    String strRhq_ofc       = "";
    Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc = account.getOfc_cd();
        strRhq_ofc = account.getRhq_ofc_cd();


        event = (EsmPri2049Event)request.getAttribute("Event");
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
<title>RFA Proposal Creation - Request Received and Sent</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>">
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_rhq_ofc_cd" value="<%=strRhq_ofc%>">
<!-- 개발자 작업 -->

<%--
<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Search - Proposal and Amendment Status</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
--%>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->

        <!--biz page - 1 (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">

                <!--  biz  (S) -->
                <table class="search_sm2" border="0" style="width:200;">
                <tr class="h23">
                    <td><input type="radio" name="trans_tp_cd" value="R" class="trans" checked="checked" caption="Transfer Type" required>&nbsp;Received&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="trans_tp_cd" value="S" class="trans">&nbsp;Sent</td>
                </tr>
                </table>
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="56">&nbsp;&nbsp;Duration</td>
                    <td class="stm"><input type="text" style="width:75;text-align:center;" name="eff_dt" cofield="exp_dt" value="" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;&nbsp;through&nbsp;<input type="text" style="width:75;text-align:center;" name="exp_dt" cofield="eff_dt" value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_calendar2" width="19" height="20" border="0" align="absmiddle"></td>
                </tr>
                </table>
                <!--  biz   (E) -->

        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>


            <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid (E) -->

            </td></tr>
        </table>
        <!--biz page - 2 (E)-->

</td></tr></table>

<!-- table class="height_5"><tr><td></td></tr></table-->

<!-- : ( Button : pop ) (S) 
<table width="100%" class="sbutton">
<tr><td height="71" class="popup"> -->

        <!--Button (S) 
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Open</td>
                    <td class="btn1_right">
                </tr></table></td>

                <td class="btn1_line"></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
            </tr>
        </table></td>
            </tr>
        </table>
        Button (E) -->

    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left">
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td></tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left">
                    <td class="btn1" name="btn_Open">Open</td>
                    <td class="btn1_right"></td></tr>
                </table></td>

            </tr>
            </table>
        
    <!--Button (E) -->

    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>