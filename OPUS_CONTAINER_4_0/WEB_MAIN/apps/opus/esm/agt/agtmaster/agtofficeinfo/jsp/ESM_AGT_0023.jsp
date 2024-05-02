<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_023.jsp
*@FileTitle : China Inbound Agent Information Management
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
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0023Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
		EsmAgt0023Event  event = null;                                 //PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//error from server
		String strErrMsg = "";						//error message
		int rowCount	 = 0;						//count of DB resultSET list

		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";

		String strUsr_id		= "";
		String strUsr_nm		= "";
		Logger log = Logger.getLogger("com.clt.apps.AGTMaster.AGTOfficeInfo");

        try {
           SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
           strUsr_id=account.getUsr_id();
           strUsr_nm=account.getUsr_nm();
                event = (EsmAgt0023Event)request.getAttribute("Event");
                serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

                if (serverException != null) {
                        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
                }else{
                	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
                } // end else
        }catch(Exception e) {
                out.println(e.toString());
        }
%>
<html>
<head>
<title>중국 Inbound 대리점 정보 관리 화면</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
        function setupPage(){
                var errMessage = "<%=strErrMsg%>";
                if (errMessage.length >= 1) {
                        ComShowMessage(errMessage);
                } // end if
                // InitTab();
                loadPage();
        }
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">

<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="changeCol" value=""><!-- Column changed from Combo List , value: stnd_cost_tp_cd, mgrp_cost_cd -->
<input type="hidden" name="sRow" value=""><!-- row changed from Combo List -->
<input type="hidden" name="changeValue" value=""><!-- value of Column changed from Combo List -->
</form>

<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd">
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
                <tr><td class="bg">
                                <table class="search_in" border="0">
                                        <tr class="h23">
                                                <td width="9%">A/R Office</td>
                                                <td><%=JSPUtil.getCodeCombo("agn_finc_ofc_cd", "", "style='width:110;'", "CD00848", 0, "")%></td>
                                        </tr>
                                </table>
                        </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->
                <table class="height_10"><tr><td></td></tr></table>

                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search">
                <tr><td class="bg">

			                <table class="height_5"><tr><td></td></tr></table>
			                <!-- : ( grid ) (S) -->
			                                                <table width="100%" id="mainTable">
			                                                          <tr><td>
			                                                         <script language="javascript">ComSheetObject('sheet1');</script>
			                                                          </td></tr>
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

                        </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>