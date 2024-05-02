<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0002Event"%>
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
<title>Route UnMatch List </title>
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>

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
				<tr>
					<td class="bg">
						<!-- : ( Week ) (S) -->
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="21"></td>
								<td width="99"><%//<img class="nostar">%>S/O Office</td>
								<td width="130">
									<input  type="text" name="ctrl_ofc_cd" id="ctrl_ofc_cd" style="width:70;" value="<%=account.getOfc_cd()%>" onChange="javascript:fun_officeText();" onKeyup="javascript:upperCase(this);">
									<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">
								</td>
								<!-- 
								<td width="31"></td>
								<td width="69">Port</td>
								<td width="120"><input name="port" type="text" style="width:70" value="" onKeyup="javascript:upperCase(this);"></td>
								 -->
								<td width="50">Bound</td>
								<td width="130">
									<select style="width:70;" name="s_bnd" >
									<option value="A" selected>All</option>
									<option value="I">In</option>
									<option value="O">Out</option>
									</select>
								</td>
								<td width="60">B/L ORG</td>
								<td width="120"><input name="org" type="text" style="width:70" value="" onKeyup="javascript:upperCase(this);" maxlength="5"></td>
								<td width="65">B/L DEST</td>
								<td width=""><input name="dest" type="text" style="width:70" value="" onKeyup="javascript:upperCase(this);" maxlength="5"></td>
							</tr>
						</table>
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="120"><input type="radio" name="search_choice" value="MM" class="trans" onClick="selectWhere();" checked>&nbsp;&nbsp;S/O Month
								</td>
								<td width="130">
									<input type="text" style="width:70" name="somonth" value="" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 6)" maxlength="6" ></td>
								<td width="100"><input type="radio" name="search_choice" value="DD" class="trans" onClick="selectWhere();">&nbsp;&nbsp;S/O Date</td>
								<td>
									<input type="text" style="width:70" name="fromsodate" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); pointAutoMove(this.value);" maxlength="8" >&nbsp;~&nbsp;<input type="text" style="width:70" name="tosodate" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8)" maxlength="8" ></td>
							</tr>
						</table>
						<!-- : ( Week ) (E) -->
					</td>
				</tr>
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

					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_detail" id="btn_detail">Detail</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

								</tr>
							</table>
						</td></tr>
					</table>
			    	<!-- : ( Button : Grid ) (E) -->

				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
