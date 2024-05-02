<%
/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : ESD_TPB_0812.jsp
*@FileTitle : Taxation Control
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.2
* 2009-05-28 O Wan-Ki 1.0 최초 생성 - [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
* 2009-08-12 O Wan-Ki 1.1 ALPS 최초생성
* 2009-09-28 Park Sung-Jin 1.2 ALPS Migration 적용
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0812Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	String ofc_cd = "";
	String cnt_cd = "";
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	ofc_cd = account.getOfc_cd();
	//cnt_cd = account.getCnt_cd();
	cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd)); //2009-05-08 : Office change기능 추가로 인해 cnt_cd는 session이 아닌  TPB 자체적으로 가져오도록 변경한다.
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form method="post" name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<!-- ______________________________________________ Start Hidden Value -->
<!-- | -->
<!-- | --><input type="hidden" name="iPage">
<!-- | --><input type="hidden" name="s_ofc_grd" value="T">
<!-- | --><input type="hidden" name="s_cnt_cd" value="<%=cnt_cd %>">
<!-- |______________________________________________ End Hidden Value -->


<!-- <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0"><tr><td valign="top" class="bodyright"> -->
<!-- OUTER - POPUP (S)tart -->
<!-- table width="600" class="popup" cellpadding="10" border="0"  -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!-- ______________________________________________ Start Page Navigation & Title -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- 
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Taxation Control</td></tr>
			</table>
	| -->
	<!-- |______________________________________________ End Page Navigation & Title -->

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_save_t">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
			</table>


	<!-- ______________________________________________ Start Search Option -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table class="search" border="0" width="100%"">
	<!-- | -->			<tr class="h23">

	<!-- | -->				<td width="100"><img class="nostar">Effective Date</td>
	<!-- | -->				<td>
	<!-- | -->				    <input type="text" name="s_calendar_date1" style="width:75" value="" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);" >
	<!-- | -->					<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
	<!-- | -->				</td>

	<!-- | -->				<td width="90"><img class="nostar"><!-- Office Code --></td>
	<!-- | -->				<td width="150">
	<!-- | -->				    <select name="s_ofc_cd" style="width:100;display:none">
	<!-- | -->					</select>
	<!-- | -->				</td>

	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Search Option -->

	<table class="height_10"><tr><td></td></tr></table>

	<!-- ______________________________________________ Start Result Gr	id -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table width="100%" id="mainTable">
	<!-- | -->			<tr>
	<!-- | -->				<td>
	<!-- | -->					<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->
			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>

							<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_add_t">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_add" id="btn_add">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_reset" id="btn_reset">Reset</td>
								<td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


							</tr>
						</table>
					</td></tr>
			</table>

	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Result Grid -->





</td></tr></table>
<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
</td></tr>
</table>





</form>
</body>
</html>