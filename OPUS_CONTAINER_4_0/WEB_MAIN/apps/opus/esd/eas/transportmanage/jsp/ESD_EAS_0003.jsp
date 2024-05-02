<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0003.jsp
*@FileTitle : Specail S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0003Event"%>
<%
	EsdEas0003Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //
	String strErrMsg = "";							//
	
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String ofc_cd="";

	SignOnUserAccount account= null;

	try {

	    account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    userId=account.getUsr_id();
	    ofc_cd=account.getOfc_cd();

	    event = (EsdEas0003Event)request.getAttribute("Event");

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
<title>Special S/O Check - Supplement & Other</title>
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
			ComShowMessage(errMessage);
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
	<input type="hidden" name="hid_period" value="M">

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
								<td width="30"><input name="btns_radio_kind" type="radio" value="A" class="trans" Onclick="change_val();" checked></td>
								<td width="165">Supplement S/O</td>
								<td width="30"><input name="btns_radio_kind" type="radio" value="B" class="trans" Onclick="change_val();" unchecked></td>
								<td width="">Other S/O</td>
							</tr>
						</table>
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="30"></td>
								<td width="75">S/O Office</td>
								<td width="120">
								<input name="so_ofc_cd" type="text" style="width:60" value='<%=ofc_cd%>' maxlength=6>
								<!-- <img class="cursor" img src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btns_office'> -->
								</td>
								<td width="50">Bound</td>
								<td width="100">
									<select name="bound" style="width:50">
									<option value="A">ALL</Option>
									<option value="I">IN</Option>
									<option value="O">OUT</Option>
									</select>
								</td>
								<td width="105"><input name="btns_radio_date" type="radio" value="C" class="trans" Onclick="change_period();" checked>S/O Months</td>
								<td width="120">
								<input name="so_month" type="text" style="width:60" value="YYYYMM"></td>
								<td width="90"><input name="btns_radio_date" type="radio" value="D" class="trans" Onclick="change_period();" unchecked>S/O Date</td>
								<td>
								<input name="fm_so_date" type="text" style="width:70" value="YYYYMMDD"> ~
								<input name="to_so_date" type="text" style="width:70" value="YYYYMMDD"> <img class="cursor" img src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" name='btns_calendar' align="absmiddle"></td>
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
		 				<div id="suppleLayer" style="display:inline">
						<table width="100%" id="mainTable1">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('sheet1');</script>
	                        </td></tr>
	                    </table>
						</div>
						<div id="otherLayer" style="display:none">
	                    <table width="100%" id="mainTable2">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('sheet2');</script>
	                        </td></tr>
	                    </table>
	                    </div>

						<!-- : ( Grid ) (E) -->
						<!-- : ( Button_ Sub ) (S) -->

						<!-- : ( Button_ Sub ) (E) -->
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