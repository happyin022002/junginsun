<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0038.jsp
*@FileTitle : Office code info
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.event.EsmAgt0038Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmAgt0038Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String usrOfcCd = "";
	String hqOfcCd = "";
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.AGTMaster.AGTSecurity");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		usrOfcCd = account.getOfc_cd();

		event = (EsmAgt0038Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//Retrieving H/Q Office Code of Login User 
		hqOfcCd = CodeUtil.getInstance().getHQOfficeInfo(usrOfcCd);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Office code info</title>
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
<script language="javascript">
<%= BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "0: :ALL") %>
</script>
</head>

<body  onLoad="setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage"> 
<input type="hidden" name="param1">	<!-- Insert Office -->
<input type="hidden" name="param2"> <!-- A/R Office of Insert Office  -->

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
                                <td width="5%">H/Q</td>
                                <td><input type="text" style="width:100" class="input1" value="<%= hqOfcCd %>" name="hqofccd" disabled></td>
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

                        <!-- : ( A/R Office Info) (S) -->

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
                                <tr><td class="btn2_left"></td><td class="btn2" name="btn_rowadd">Row&nbsp;Add</td><td class="btn2_right"></td></tr></table></td>
                                <!-- Repeat Pattern -->


                            </tr></table>
                        </td></tr>
                        </table>
                        <!-- : ( Button : Sub ) (E) -->
                        <!-- : ( A/R Office Info ) (E) -->
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