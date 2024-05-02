<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0009.jsp
*@FileTitle : Drop-off Charge Collection Performance
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0009Event"%>

<%

	SignOnUserAccount account = null; //Session
	String ctrl_user_id = "";
	String old_ofc_cd = "";
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		ctrl_user_id = account.getUsr_id();
		old_ofc_cd = account.getOfc_cd();
	}catch(Exception e) {
		out.println("<!-- acount ... error -->");
	}
%>


<html>
<head>
<title>Drop-off Charge Collection Performance</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_user_id" value="<%=ctrl_user_id%>">
<input type="hidden" name="old_ofc_cd" value="<%=old_ofc_cd%>">

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
			                        <td width="110"><%//<img class="nostar">%>M/H TRO Office</td>
			                        <td width="200">
			                          <input  type="text" name="ctrl_ofc_cd" id="ctrl_ofc_cd" style="width:60;" value="<%=account.getOfc_cd()%>" onChange="javascript:fun_officeText();" onKeyup="javascript:upperCase(this);">
						  <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office" >
			                        </td>
						<td width="105">M/H TRO Period</td>
						<td width="250" class="stm"><input type="text" style="width:65" name="fromtrodate" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); pointAutoMove(this.value);" maxlength="8" >
						&nbsp;~&nbsp;
						<input type="text" style="width:65" name="totrodate" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8)" maxlength="8" ></td>
						<td width="130">MT Return Location</td>
						<td width=""><input type="text" name="location" style="width:65" onKeyup="javascript:upperCase(this);" maxlength="5"></td>
					</tr>
				</table>
				<!-- : ( Week ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
			<tr><td class="bg">

				<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		              </td></tr>
				</table>
				<!-- : ( POR ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
