<%--
 - Copyright(c) 2012 CyberLogitec
 - @FileName : FNS_INV_0124.jsp
 - @FileTitle :  EDI Submission (DHL)
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2012.04.27
 - @LastModifier : Sang-Hyun Kim
 - @LastVersion : 1.0
 - 1.0 Creation 2012.04.27 Sang-Hyun Kim
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO" %>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0124Event" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    Logger logger = Logger.getLogger("apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.FNS_INV_0124");
    FnsInv0124Event event = null;
    Exception exception = null;
    String exceptionMsg = null;
    SignOnUserAccount sessionAcount = null;

    String pageRows  = "100";

    try {
        sessionAcount = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        event = (FnsInv0124Event)request.getAttribute("Event");
        exception = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (exception != null) {
            exceptionMsg = new ErrorHandler(exception).loadPopupMessage();
        }

        // Get data from server's result.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    } catch(Exception e) {
        logger.error(e.getMessage());
    }
%>

<html>

<head>
    <title>EDI Submission (DHL)</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        /**
         * Checking error message from server.
         */
        function setupPage() {
            var exceptionMsg = "<%=exceptionMsg %>";
            if (exceptionMsg != "null") {
                ComShowMessage(exceptionMsg);
            }
            loadPage();
        }
    </script>
</head>

<body onLoad="setupPage();">
    <form name="form">
    <input type="hidden" name="f_cmd">
    <input type="hidden" name="pagerows">
    <input type="hidden" name="ofc" value="">
    <input type="hidden" name="ofc_cd" value="">
    <input type="hidden" name="pagetype" value = "I">
    <input type="hidden" name="upd_usr_id" value="<%=sessionAcount.getUsr_id() %>">

    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
        <tr>
            <td valign="top">
                <!--Page Title, Historical (S)-->
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                    <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
                    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
                </table>
                <!--Page Title, Historical (E)-->
                <!--biz page (S)-->
                <table class="search">
                    <tr>
                        <td class="bg">
                            <!--  biz_1  (S) -->
                            <table class="search" border="0" style="width:100%;">
                                <tr class="h23">
                                    <td width="110">Retrieve Option&nbsp;</td>
                                    <td width="100"><script language="javascript">ComComboObject('retr_opt', 1, 150, 1, 1);</script></td>
                                    <td width="130"><input name="retr_input" type="text" dataformat="engup" style="width:120" class="input1" value="" maxlength="13">&nbsp;</td>
                                    <td width="85">Sent Status&nbsp;</td>
                                    <td width="" style="padding-left:2"><script language="javascript">ComComboObject('sent_stat', 1, 150, 1, 1);</script></td>
                                    <td width="85">Office</td>
                                    <td style="padding: 2"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 101, 1,1);</script></td>
                                </tr>
                                <tr class="h23">
                                    <td width="110"></td>
                                    <td width="250" colspan="4">
                                        <input type="text" style="width: 75" value="" name="fm_dt" onBlur="fn_ComGetMaskedValue('fm_dt');" onKeyUp="javascript:checkFmDtLeng(this.value)" class="input2" readOnly>
                                        <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;
                                        <input type="text" style="width: 75" value="" name="to_dt"  onBlur="fn_ComGetMaskedValue('to_dt');" class="input2" readOnly>
                                        <img class="cursor" src="img/btns_calendar.gif" width="19" height="20"  border="0" align="absmiddle" name="btns_calendar2">
                                    </td>
                                </tr>
                                <tr class="h23">
                                    <td width="110">Customer</td>
                                    <td colspan = "6">
                                        <input type="text" style="ime-mode: disabled; width: 30" value="" class="input1" dataformat="engup" name="cust_cnt_cd" maxlength="2" onKeyUp="if(ComChkLen(this, 2)==2){ComSetNextFocus();}" onChange="fn_cust_nm();">
                                        <input type="text" style="width: 49" value="" name="cust_seq" dataformat="num" class="input1" onChange="fn_cust_nm();" maxlength="6">
                                        <img class="cursor" src="img/btns_search.gif" name="btn_actcust" width="19" height="20" border="0" align="absmiddle">
                                        <input type="text" style="width: 500" value="" class="input2" name="cust_nm" readonly>
                                        <img class="cursor" src="img/btns_search.gif" name="btn_custNm" width="19" height="20" border="0" align="absmiddle">
                                    </td>
                                </tr>
                            </table>
                            <!--  biz_1   (E) -->
                        </td>
                    </tr>
                </table>
                <table class="height_8"><tr><td></td></tr></table>
                <table class="search">
                    <tr>
                        <td class="bg">
                            <!-- Grid  (S) -->
                            <table width="100%" id="mainTable">
                                <tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <!--biz page (E)-->

    <!--Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
            <td class="btn1_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
	                    <td>
	                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                            <tr>
	                                <td class="btn1_left"></td>
	                                <td class="btn1" name="btn_Retrieve">Retrieve</td>
	                                <td class="btn1_right"></td>
	                            </tr>
	                        </table>
	                    </td>
                        <td>
                            <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn1_left"></td>
                                    <td class="btn1" name="btn_SendBL">Send</td>
                                    <td class="btn1_right"></td>
                                </tr>
                            </table>
                        </td>
                        <td class="btn1_line"></td>         
                        <td>
                            <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn1_left"></td>
                                    <td class="btn1" name="btn_New">New</td>
                                    <td class="btn1_right"></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

    <div style="display:none">
        <table width="100%">
            <tr><td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
        </table>
    </div>

    </form>
</body>

</html>
