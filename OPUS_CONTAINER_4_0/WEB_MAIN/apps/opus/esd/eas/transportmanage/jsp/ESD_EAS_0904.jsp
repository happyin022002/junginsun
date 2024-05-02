<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_920.jsp
*@FileTitle : CY & Door S/O Creation Matchmaking Popup
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0004Event" %>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0004EventResponse" %>
<%
	SignOnUserAccount account = null; //Session
	EsdEas0004Event  event = null; //
	EsdEas0004EventResponse eventResponse = null; //
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list
	String bkgno = request.getParameter("bkgno") == null ? "" : request.getParameter("bkgno");
	String ctrl_ofc_cd = request.getParameter("ctrl_ofc_cd") == null ? "" : request.getParameter("ctrl_ofc_cd");
	String s_type = request.getParameter("s_type") == null ? "" : request.getParameter("s_type");
	String s_bnd = request.getParameter("s_bnd") == null ? "" : request.getParameter("s_bnd");
	String somonth = request.getParameter("somonth") == null ? "" : request.getParameter("somonth");
	String invmonth = request.getParameter("invmonth") == null ? "" : request.getParameter("invmonth");
	String fromsodate = request.getParameter("fromsodate") == null ? "" : request.getParameter("fromsodate");
	String tosodate = request.getParameter("tosodate") == null ? "" : request.getParameter("tosodate");
	String frominvdate = request.getParameter("frominvdate") == null ? "" : request.getParameter("frominvdate");
	String toinvdate = request.getParameter("toinvdate") == null ? "" : request.getParameter("toinvdate");
	String vvdno = request.getParameter("vvdno") == null ? "" : request.getParameter("vvdno");

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEas0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
	eventResponse = (EsdEas0004EventResponse)request.getAttribute("EventResponse");
	if (eventResponse != null) {
		rowSet = eventResponse.getRowSet();
		if(rowSet != null){
	 rowCount = rowSet.getRowCount();
		} // end if
	} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>C/H Audit Popup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        loadPage();
        //_text_ChangeUpperCase(); // automatic change to uppercase;
    }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="bkgno" value="<%=bkgno%>">
<input type="hidden" name="ctrl_ofc_cd" value="<%=ctrl_ofc_cd%>">
<input type="hidden" name="s_type" value="<%=s_type%>">
<input type="hidden" name="s_bnd" value="<%=s_bnd%>">
<input type="hidden" name="somonth" value="<%=somonth%>">
<input type="hidden" name="invmonth" value="<%=invmonth%>">
<input type="hidden" name="fromsodate" value="<%=fromsodate%>">
<input type="hidden" name="tosodate" value="<%=tosodate%>">
<input type="hidden" name="frominvdate" value="<%=frominvdate%>">
<input type="hidden" name="toinvdate" value="<%=toinvdate%>">
<input type="hidden" name="vvdno" value="<%=vvdno%>">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp;C/H Audit Popup</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Node / Link ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Node / Link ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_10"><tr><td></td></tr></table>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>