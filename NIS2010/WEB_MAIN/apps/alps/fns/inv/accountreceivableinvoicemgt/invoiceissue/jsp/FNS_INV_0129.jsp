<%--
 - Copyright(c) 2012 CyberLogitec
 - @FileName : FNS_INV_0129.jsp
 - @FileTitle :  EDI Submission (Honey Well)
 - Open Issues :
 - Change history :
 - @LastModifyDate :
 - @LastModifier : 
 - @LastVersion : 1.0
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO" %>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0129Event"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    Logger logger = Logger.getLogger("apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.FNS_INV_0129");
    FnsInv0129Event event = null;
    Exception exception = null;
    String exceptionMsg = null;
    SignOnUserAccount sessionAcount = null;
    String loginOfcCd = "";
    
    String pageRows  = "100";

    try {
        sessionAcount = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        
        loginOfcCd = sessionAcount.getOfc_cd();
        
        event = (FnsInv0129Event)request.getAttribute("Event");
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
    <title>Customer registration for Invoice issue by E-mail</title>
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
    <input type="hidden" name="ar_ofc_cd" value="">
    <input type="hidden" name="pagetype" value = "E">
    <input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>">
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
                                    <td width="85">Office</td>
                                    <td style="padding: 2"><script language="javascript">ComComboObject('ar_ofc_cd_all', 1, 101, 1,1);</script></td>
									<td><input type="text" style="width: 80" value="" class="input2" name="ofc_opt" readonly></td>
                                    <td width="80">Cust.Code</td>
                                    <td >
										<input type="text" style="ime-mode: disabled; width: 30" value="" class="input1" dataformat="engup" name="cust_cnt_cd" maxlength="2" onKeyUp="if(ComChkLen(this, 2)==2){ComSetNextFocus();}">
										<input type="text" style="width: 49" value="" name="cust_seq" dataformat="num" class="input1"  onchange="fn_cust_nm();" maxlength="6">
										<img class="cursor" src="img/btns_search.gif" name="btn_actcust" width="19" height="20" border="0" align="absmiddle">
										<input type="text" style="width: 450" value="" class="input2" name="cust_nm" readonly>
										<img class="cursor" src="img/btns_search.gif" name="btn_custNm"	width="19" height="20" border="0" align="absmiddle">
                                    </td>
                                </tr>
                               
                                <tr class="h23">
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
                          	<!-- Grid (S) -->
							<table width="100%" id="mainTable">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) --> <!--  Button_Sub (S) -->
							<table width="100%" class="button">
								<tr>
									<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0"
												class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
											</td>
											<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0"
												class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
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
                                    <td class="btn1" name="btn_New">New</td>
                                    <td class="btn1_right"></td>
                                </tr>
                            </table>
                        </td>
                        <td class="btn1_line"></td>
                        <td>
                            <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn1_left"></td>
                                    <td class="btn1" name="btn_Save">Save</td>
                                    <td class="btn1_right"></td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                    <td class="btn1_left"></td>
                                    <td class="btn1" name="btn_DownExcel">Down Excel</td>
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
