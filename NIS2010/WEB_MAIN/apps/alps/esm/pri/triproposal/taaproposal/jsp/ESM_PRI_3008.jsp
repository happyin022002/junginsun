<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3008.jsp
*@FileTitle : TAA No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.07 문동규
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
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3008Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>

<%
    EsmPri3008Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String[] svcScpCds = null;
    Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TAAProposal");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri3008Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>TAA No Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var svcScpComboValue = "|<%=svcScpCds[0]%>";
    var svcScpComboText = " \t |<%=svcScpCds[1]%>";

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
<!-- 개발자 작업 -->
<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; TAA No. Inquiry</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!--biz page (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">

                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="85">Service Scope</td>
                    <td width="85"><script language="javascript">ComComboObject('svc_scp_cd', 2, 80, 0, 0, 0, false);</script></td>
                    <td width="" style="padding-bottom:1"><input name="svc_scp_nm" type="text" style="width:393;text-align:left;" class="input2" readonly="readonly" caption="Service Scope">
                    </td>
                </tr>
                </table>
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="85">Customer</td>
                    <td width="90"><input type="text" style="width: 25;"
                        dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd"
                        class="input" caption="Customer Code" required>&nbsp;<input
                        type="text" style="width: 55;" dataformat="int" name="ctrt_cust_seq"
                        maxlength="6" class="input" caption="Customer Sequence"
                        required>&nbsp;<input type="text" style="width:0;"></td>
                    <td width="20">
                        <table>
                            <tr>
                                <td><img src="img/btns_search.gif" width="19" height="20"
                                    alt="" border="0" align="absmiddle" name="btn_ctrt_cust"
                                    class="cursor"></td>
                            </tr>
                        </table>
                    </td>
                    <td width=""><input type="text" style="width: 187;"
                        name="ctrt_cust_nm" readonly="readonly" class="input2"></td>
                </tr>
                </table>
                <table class="line_bluedot"><tr><td></td></tr></table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <table width="100%"  id="mainTable" style="display:none;">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
                <table width="100%" class="button">
                            <tr><td class="btn2_bg">
                            <table border="0" cellpadding="0" cellspacing="0"><tr>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_Retrieve">Retrieve</td>
                                <td class="btn2_right"></td></tr>
                                </table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_New">New</td>
                                <td class="btn2_right"></td></tr>
                                </table></td>
                            </tr></table>
                        </td></tr>
                        </table>

        </td></tr></table>

        <!--biz page (E)-->

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_OK">OK</td>
                    <td class="btn1_right"></td></tr></table></td>
                <td class="btn1_line"></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td></tr></table></td>
            </tr>
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