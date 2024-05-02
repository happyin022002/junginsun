<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG-0737.jsp
*@FileTitle      : Korea Cargo Release (D/O)
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
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0737Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0737Event event     = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //서버에서 발생한 에러
    String strErrMsg = "";                    //에러메세지
    int rowCount     = 0;                     //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";

    String strUsr_id   = "";
    String strUsr_nm   = "";

    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.FullReleaseOrder");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0737Event)request.getAttribute("Event");
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
<title>eDO Transmit </title>
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

<body class="popup_bg" onLoad="loadPage()">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;eDO Transmit</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!-- : ( Search Options ) (S) -->
        <table class="search" id="mainTable">
        <tr>
            <td class="bg">
                <!-- : ( Grid ) (S) -->
                <table class="search" border="0" style="width:680;">
                <tr class="h23">
                    <td width="140">D/O 발급 신청서</td>
                    <td width="240"class="stm"><input type="radio" name='rdo_5JN' class="trans" disabled onClick="TransmitDataSet('N')">&nbsp;대상&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JN' class="trans" disabled onClick="TransmitDataSet('A')">&nbsp;승인&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JN' class="trans" disabled onClick="TransmitDataSet('R')">&nbsp;거부&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JN' class="trans" disabled onClick="TransmitDataSet('P')">&nbsp;보류</td>
                    <td width=""><!--edo_rjct_rsn--><input type="text" name='rej_rmk' style="width:100%;" class="input2" readonly onChange="rejRmkDataSet('1')"maxlength='1000'></td>
                </tr>
                <tr class="h23">
                    <td width="">자가운송 요청 동의서</td>
                    <td width=""class="stm"><input type="radio" name='rdo_5JM' class="trans" disabled onClick="TransmitDataSet('N')">&nbsp;대상&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JM' class="trans" disabled onClick="TransmitDataSet('A')">&nbsp;승인&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JM' class="trans" disabled onClick="TransmitDataSet('R')">&nbsp;거부&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JM' class="trans" disabled onClick="TransmitDataSet('P')">&nbsp;보류</td>
                    <td width=""><!--edo_rjct_rsn--><input type="text" name='rej_rmk' style="width:100%;" class="input2" readonly onChange="rejRmkDataSet('2')" maxlength='1000'></td>
                </tr>
                <tr class="h23">
                    <td width="">보세운송 요청 동의서</td>
                    <td width=""class="stm"><input type="radio" name='rdo_5JK' class="trans" disabled onClick="TransmitDataSet('N')">&nbsp;대상&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JK' class="trans" disabled onClick="TransmitDataSet('A')">&nbsp;승인&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JK' class="trans" disabled onClick="TransmitDataSet('R')">&nbsp;거부&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JK' class="trans" disabled onClick="TransmitDataSet('P')">&nbsp;보류</td>
                    <td width=""><!--edo_rjct_rsn--><input type="text" name='rej_rmk' style="width:100%;" class="input2" readonly onChange="rejRmkDataSet('3')" maxlength='1000'></td>
                </tr>
                </table>
                <!-- : ( Grid ) (E) -->
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
<tr><td height="71" class="popup">
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
            <td class="btn3_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                            <td class="btn1" name="btn_submit">전송</td>
                            <td class="btn1_right"></td>
                        </tr>
                        </table>
                    </td>
                    <td class="btn1_line"></td>
                    <td width="">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
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
<script language="javascript">ComSheetObject('sheet1');</script>
    </td>
</tr>
</table>
<!--O/BL 회수  여부 Hidden 속성 조회 시 불러온 값 -->
<input type='hidden' name ='h_approvals' value="<%=JSPUtil.getNull(request.getParameter("approvals"))%>">
<!--최종 D/O의 진행 상태 코드 -->
<input type='hidden' name ='h_last_rlse_sts_cd' value="<%=JSPUtil.getNull(request.getParameter("last_rlse_sts_cd"))%>">
<!--최종 D/O의 진행 상태 코드 -->
<input type='hidden' name ='rqst_no' value="<%=JSPUtil.getNull(request.getParameter("rqst_no"))%>">
<input type='hidden' name ='bkg_no' value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type='hidden' name ='edo_ack_cd_arr'>
<input type='hidden' name ='self_trans_chk_flg'>
<input type='hidden' name ='mrn_no' value="<%=JSPUtil.getNull(request.getParameter("mrn_no"))%>">
<input type='hidden' name ='msn_no' value="<%=JSPUtil.getNull(request.getParameter("msn_no"))%>">
<input type='hidden' name ='pod_cd' value="<%=JSPUtil.getNull(request.getParameter("pod_cd"))%>">
<input type='hidden' name ='del_cd' value="<%=JSPUtil.getNull(request.getParameter("del_cd"))%>">
<input type='hidden' name ='de_term_desc' value="<%=JSPUtil.getNull(request.getParameter("de_term_desc"))%>">
</form>
</body>
</html>