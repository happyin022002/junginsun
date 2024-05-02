<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_076.jsp
*@FileTitle : Exception Norification Inquuery
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page import="com.clt.framework.component.util.DateTime" %>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>

<%
	SignOnUserAccount account = null; 
	int    rowSize = 50 ;
	account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
%>
<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">

    function setupPage(){

        loadPage();
    }

</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
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
							<td width="110">Notification date</td>
							<td width="75">
							<input name="act_dt1" type="text" style="width:70" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"></td>
							<td width="" colspan="2">&nbsp;~&nbsp;
							<input name="act_dt2" type="text" style="width:70" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"> <img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" name = "btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
						</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>


					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>

				<!-- : ( grid ) (E) -->


			</td></tr>
		</table>

		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->


    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

