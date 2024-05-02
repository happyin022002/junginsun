<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0005.jsp
*@FileTitle : Cancelled BKG’s Cntr Tracing
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil" %>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0005Event" %>

<%
	SignOnUserAccount account = null; //Session 
	EsdEas0005Event  event = null; //
	Exception serverException   = null; //error from server
	DBRowSet rowSet	  = null; //DB ResultSet
	String strErrMsg = ""; //error message
	int rowCount	 = 0; //count of DB resultSET list

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEas0005Event)request.getAttribute("Event");
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
<title>Cancelled BKG’s Cntr Tracing</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
    function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
    }
</script>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
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
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

									<td class="btn1_line"></td>

									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr></table>

						</td></tr>
					</table>
				<!-- TABLE '#D' : ( Button : Main ) (E) -->




		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="25"><input type="radio" value="" class="trans" name="search_choice" onClick="selectWhere();"  ></td>
					<td width="150">Cancelled Booking No.</td>
					<td width="180"><input type="text" name="bkgno" style="width:110" onClick="selectText(this);" onKeyUp="chkField(this, 'eng_num', true, 13)" maxlength="13" > </td>
					<td width="25"><input type="radio" value="" class="trans" name="search_choice" onClick="selectWhere();"  ></td>
					<td width="120">Cancelled B/L No.</td>
					<td width=""><input type="text"name="blno" style="width:110" onClick="selectText(this);" onKeyUp="chkField(this, 'eng_num', true, 13)" maxlength="13" ></td>

				</tr>

				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->




		<table class="height_10"><tr><td></td></tr></table>




		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




			<table class="height_10"><tr><td></td></tr></table>




			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

							<table width="100%" id="mainTable">
                      <tr>
                      	<td>
                           <script language="javascript">ComSheetObject('sheet1');</script>
                      	</td>
                      </tr>
	            </table>
			<!-- : ( Grid : Week ) (E) -->
			<!-- : ( Button : Sub ) (S) -->

	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->






    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
