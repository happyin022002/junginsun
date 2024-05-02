<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0137.jsp
*@FileTitle : Cargo Release Order의 Office Default From Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.19 안진응
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0137Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0137Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOff_cd        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOff_cd = account.getOfc_cd();

        event = (EsmBkg0137Event)request.getAttribute("Event");
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
<title>Cargo Release Remark Template</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업    -->

<input type="hidden" name="office_cd" value="<%=strOff_cd %>">
<input type="hidden" name="qryFlag" value="">


<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Delete">Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
        <!-- Tab ) (S) -->

        <!-- Tab ) (E) -->

        <!-- Grid BG Box  (S) -->

            <table class="search">
            <tr><td class="bg">

            <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="50">&nbsp;Office</td>
                    <td width=""><input type="text" name = "office" style="width:120;" class="input1" value="<%=JSPUtil.getNull(request.getParameter("office"))%>" maxlength="6" dataformat="engup" style="ime-mode:disabled"></td>
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;">
                    <tr class="h23">
                        <td width="500">
                            <table class="search_sm2" border="0">
                                <tr class="h23">
                                    <td width="200">Delivery Drder Preview Form</td>
                                    <td class="stm">
                                        <input type="radio" name = "do_fom_prv_cd" value="DO" class="trans" onclick="fnRadioCheck()" checked >&nbsp;D/O Form&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name = "do_fom_prv_cd" value="BL" class="trans" onclick="fnRadioCheck()">&nbsp;B/L Form&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name = "do_fom_prv_cd" value="EU" class="trans" onclick="fnRadioCheck()">&nbsp;EU Form
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td width="160">Delivery Order Language</td>
                        <td width="" style="padding-left:2"><select style="width:120;" name="locl_lang_flg">
                            <option value="Y" selected>English</option>
                            <option value="N">Local Language</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <table class="height_5"><tr><td></td></tr></table>
                <table border="0" style="width:979; background-color:white;" class="grid2">
                    <tr class="tr2_head">
                        <td width="100%">Address</td>
                    </tr>
                    <tr><td>
                        <textarea  rows="2"style="width:100%" name = "addr_ctnt" maxlength="4000"></textarea></td>
                    </tr>
                </table>
                <!--Grid (s)-->

                <!--Grid (E)-->

                <table class="height_5"><tr><td></td></tr></table>
                    <table border="0" style="width:979; background-color:white;" class="grid2">
                    <tr class="tr2_head">
                        <td width="100%">External Remark</td>
                    </tr>
                    <tr><td>
                        <textarea  rows="7"style="width:100%" name = "do_prn_rmk" maxlength="4000"></textarea></td>
                    </tr>
                </table>

                <table class="height_5"><tr><td></td></tr></table>
                <table border="0" style="width:979; background-color:white;" class="grid2">
                    <tr class="tr2_head">
                        <td width="100%">Authorization contents</td>
                    </tr>
                    <tr><td>
                        <textarea  rows="2"style="width:100%" name = "auth_ctnt" maxlength="4000"></textarea></td>
                    </tr>
                </table>

            </td></tr>

            <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
            <!-- Grid (E) -->
            
            <table class="height_5"><tr><td></td></tr></table>
             </td>
                    </tr>
        </table>
    <!-- Grid BG Box  (S) -->
    <!--biz page (E)-->

 

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>