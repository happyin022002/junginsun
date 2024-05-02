<%--
 - Copyright(c) 2012 CyberLogitec
 - @FileName : FNS_INV_0126.jsp
 - @FileTitle :  EDI Submission (Honey Well)
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2012.05.17
 - @LastModifier : Sang-Hyun Kim
 - @LastVersion : 1.0
 - 1.0 Creation 2012.05.17 Sang-Hyun Kim
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO" %>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0126Event" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    Logger logger = Logger.getLogger("apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.FNS_INV_0126");
    Exception exception = null;
    FnsInv0126Event event = null;
    String exceptionMsg = null;
    SignOnUserAccount sessionAcount = null;

    String pageRows  = "100";

    try {
    	event = (FnsInv0126Event)request.getAttribute("Event");
        sessionAcount = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        exception = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (exception != null) {
            exceptionMsg = new ErrorHandler(exception).loadPopupMessage();
        }
    } catch(Exception e) {
        logger.error(e.getMessage());
    }
%>

<html>

<head>
    <title>EDI Submission (Honey Well)</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
    	var selRow = "";
    	var orderNos = "";
        /**
         * Checking error message from server.
         */
        function setupPage() {
            var exceptionMsg = "<%=exceptionMsg %>";
            if (exceptionMsg != "null") {
                ComShowMessage(exceptionMsg);
            }

            selRow = "<%=event.getRow() %>";
            orderNos = "<%=event.getOrderNos() %>";

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
                    <!-- <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> -->
                    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;EDI Submission Order No Multi Input</td></tr>
                </table>
                <!--Page Title, Historical (E)-->
                <!--biz page (S)-->
                <table width="100%" class="search">
                    <tr>
                        <td class="bg" align="center">
                            <!-- Grid  (S) -->
                            <table width="70%" id="mainTable">
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
                                    <td class="btn2_left"></td>
                                    <td class="btn2" name="btn_add">Row Add</td>
                                    <td class="btn2_right"></td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn2_left"></td>
                                    <td class="btn2" name="btn_remove">Row Delete</td>
                                    <td class="btn2_right"></td>
                                </tr>
                            </table>
                        </td>
                        <td class="btn1_line"></td>
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn1_left"></td>
                                    <td class="btn1" name="btn_apply">Apply</td>
                                    <td class="btn1_right"></td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn1_left"></td>
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
    </form>
</body>

</html>
