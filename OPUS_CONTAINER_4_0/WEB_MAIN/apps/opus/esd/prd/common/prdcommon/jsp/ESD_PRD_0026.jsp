<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0026.jsp
*@FileTitle : s/p
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
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.event.EsdPrd0026Event"%>
<%
	EsdPrd0026Event  event = null;				//PDTO(Data Transfer Object including Parameters)

	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list
	
	String ofcCd = "";
	try {

	  
		event = (EsdPrd0026Event)request.getAttribute("Event");
		ofcCd = JSPUtil.getNull(event.getServiceProviderVO().getOfcCd());

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to opus!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // 
        loadPage();
    }

</script>
</head>
<body onLoad="setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp;Service Provider Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:580;">
				<tr class="h23">
					<td width="90">Country</td>
					<td width="70">
						<input type="text" name="cnt_cd" style="width:50" onKeyUp="javascript:upper(this);">
						</td>
					<td width="140">Service Provider Name</td>
					<td width="80"><input type="text" name="vndr_nm_eng" style="width:60" value=""></td>
					<td width="135">Service Provider Type</td>
					<td width=""><select style="width:50;" name="vndr_tp" disabled style="background-color:#C0C0C0">&nbsp;
						<option value="0" selected>Rail</option>
						<option value="1"></option>
						</select></td></tr>
				</table>
				<table class="search" border="0" style="width:580;">
				<tr class="h23">
					<td width="90">Control Office</td>
					<td width="70"><input class="input1" type="text" name="ofc_cd" style="width:50" value="<%=ofcCd %>" onKeyUp="javascript:upper(this);"></td>
					<td width="180">Parent Service Provider Code</td>
					<td><input type="text" name="pts_vndr_cd" style="width:70" value="" onKeyUp="javascript:upper(this);"></td></tr>
				</table>

				<!-- : ( Scenario ID ) (E) -->

			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
		            </table>
			<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




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
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
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
