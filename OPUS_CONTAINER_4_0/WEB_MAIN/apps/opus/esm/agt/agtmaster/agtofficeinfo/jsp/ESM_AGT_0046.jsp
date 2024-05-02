<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_046.jsp
*@FileTitle : Office VS Vendor matching Info
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil" %>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.event.ESM_AGT_046Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.event.ESM_AGT_046EventResponse"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%
        ESM_AGT_046Event  event = null;                                 //PDTO(Data Transfer Object including Parameters)
        ESM_AGT_046EventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
        Exception serverException = null;                               //error from server
        DBRowSet rowSet  = null;                                                //DB ResultSet
        String strErrMsg = "";                                                  //error message
        int rowCount     = 0;                                                   //count of DB resultSET list
        String ofcCd = "";
        String arOfcCd = "";
        String cboOfcCd = "";
        String userId = "";

        try {
                SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
                userId=account.getUsr_id();
                ofcCd = account.getOfc_cd();
                //userAuth=account.getAuth();

                event = (ESM_AGT_046Event)request.getAttribute("Event");
                serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

                if (serverException != null) {
                        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
                } else {
                        eventResponse = (ESM_AGT_046EventResponse)request.getAttribute("EventResponse");
                        if (eventResponse != null) {
                                rowSet = eventResponse.getRs();
                                if(rowSet != null){
                                         rowCount = rowSet.getRowCount();
                                } // end if
                        } // end if
                } // end else

                //Retrieving A/R Office Code of Login User's division.
                arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);

                //Combo Data : getCodeCombo('Tag Name','Init Value', 'Additional Properties', 'Biz name', 'Condition Code', 'Whole check', 'Additional Option')
                cboOfcCd = ComboUtil.getCodeCombo("cboOfcCd", arOfcCd, " style='width:85'", "OfcVndrMachList", ofcCd, "&lt;&lt;select&gt;&gt;", "");

        }catch(Exception e) {
                out.println(e.toString());
        }
%>

<html>
<head>
<title>Office VS Vendor matching Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<%= BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "0: :ALL") %>
</script>

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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


                        <!-- TABLE '#D' : ( Button : Main ) (S) -->
                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
                        <tr><td class="btn1_bg">

                                        <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                                <!-- Repeat Pattern -->
                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

                                                <td class="btn1_line"></td>

                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
                                                <!-- Repeat Pattern -->

                                        </tr></table>

                                </td></tr>
                        </table>
                        <!-- TABLE '#D' : ( Button : Main ) (E) -->

                        <!-- TABLE '#D' : ( Search Options ) (S) -->
                        <table class="search">
                                <tr>
                                        <td class="bg">
                                                <table class="search_in" border="0">
                                                        <tr class="h23">
                                                                <td width="9%"><img class="star">OFFICE</td>
                                                                <td><div id="div_ofc_cd" style="display:block;"><%= cboOfcCd %></div></td>
                                                        </tr>
                                                </table>
                                        </td>
                                </tr>
                        </table>
                        <table class="height_10"><tr><td></td></tr></table>
                        <!-- TABLE '#D' : ( Search Options ) (E) -->

                        <!-- TABLE '#D' : ( Search Options ) (S) -->
                        <table class="search">
                                <tr><td class="bg">

                                                <!-- : ( Office VS Vendor matching Info) (S) -->
                                                <!-- <table class="height_5"><tr><td></td></tr></table> -->

                                                <!-- : ( grid ) (S) -->
                                                <table width="100%" id="mainTable">
                                                        <tr>
                                                                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
                                                        </tr>
                                                </table>
                                                <!-- : ( grid ) (E) -->
                                                <!-- : ( Button : Sub ) (S) -->
                                                <table width="100%" class="button">
                                                <tr><td class="btn2_bg">
                                                        <table border="0" cellpadding="0" cellspacing="0">
                                                        <tr>

                                                                <!-- Repeat Pattern -->
                                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                <tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd">Row&nbsp;Add</td><td class="btn2_right"></td></tr></table></td>
                                                                <!-- Repeat Pattern -->


                                                       </tr></table>
                                                </td></tr>
                                                </table>
                                                <!-- : ( Button : Sub ) (E) -->
                                                <!-- : ( Office VS Vendor matching Info ) (E) -->


                                        </td>
                                </tr>
                        </table>
                        <!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>

