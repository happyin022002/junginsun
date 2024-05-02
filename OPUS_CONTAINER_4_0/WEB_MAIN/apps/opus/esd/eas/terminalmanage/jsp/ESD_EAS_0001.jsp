<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0001.jsp
*@FileTitle : Rehandling Expense & TPB Check
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
<%@ page import="com.clt.apps.opus.esd.eas.terminalmanage.event.EsdEas0001Event"%>
<%
	EsdEas0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String ofc_cd="";

	SignOnUserAccount account= null;

	try {

	    account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    userId=account.getUsr_id();
	    ofc_cd=account.getOfc_cd();

	    event = (EsdEas0001Event)request.getAttribute("Event");

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
<title>Rehandling Expense & TPB Check</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
	var bnd_cdText = "IN|OUT|TS";
	var bnd_cdCode = "I|O|T";
	var agmt_rate_type_nmText = "|Pair|Distance";
	var agmt_rate_type_nmCode = "|P|D";

	<%= JSPUtil.getIBCodeCombo("way_type", "", "CD00929", 0, "")		%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}  // end if
		loadPage();
	}
</script>


<body  onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="iPage">
	<input type="hidden" name="login_ofc_cd" value="<%=ofc_cd%>">
	<input type="hidden" name="login_usr_id" value="<%=userId%>">
	<input type="hidden" name="login_date" value="<%=today%>">
	<!-- <input type="hidden" name="hid_period" value="P"> -->

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

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table width="100%" class="search">
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="150"><input type="radio" name="btns_radio_ofc" value="P" class="trans" Onclick="change_period();" checked>&nbsp;&nbsp;Rehandling Port&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td width="170"><input name="port" type="text" style="width:55;" maxlength="5" onBlur="setgetUpper(this);">
								</td>
								<td width="85">
									<input type="radio" name="btns_radio_date" value="M" class="trans" Onclick="change_period();" checked>&nbsp;&nbsp;Months
								</td>
								<td>
									<input type="text" style="width:50" name="fmMonth" value="YYYYMM" onKeyUp="chkField(this, 'num', true, 6)" maxlength="6">&nbsp;&nbsp;~&nbsp;&nbsp;
									<input type="text" style="width:50" name="toMonth" value="YYYYMM" onKeyUp="chkField(this, 'num', true, 6)" maxlength="6" >
								</td>
							</tr>
							<tr class="h23">
								<td width="150"><input type="radio" name="btns_radio_ofc" value="O" class="trans" Onclick="change_period();" unchecked>&nbsp;&nbsp;Request Office&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td width="170"><input name="office" type="text" style="width:55;" maxlength="6" onBlur="setgetUpper(this);">
								</td>
								<td width="85">
									<input name="btns_radio_date" type="radio" value="V" class="trans" Onclick="change_period();" unchecked>&nbsp;&nbsp;VVD
								</td>
								<td>
									<input name="vvd" type="text" style="width:80;" value="" maxlength="9" onBlur="setgetUpper(this);">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg">
		 				<table width="100%" id="mainTable">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('sheet1');</script>
	                        </td></tr>
	                    </table>
						<!-- : ( Grid ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>