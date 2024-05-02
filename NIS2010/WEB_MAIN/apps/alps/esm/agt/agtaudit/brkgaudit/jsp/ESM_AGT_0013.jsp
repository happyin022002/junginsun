<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_013.jsp
*@FileTitle : Brokerage Commission Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-11
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-11 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event.EsmAgt0013Event"%>
<%
EsmAgt0013Event event = null; //PDTO(Data Transfer Object including Parameters)
Exception serverException = null; //서버에서 발생한 에러
DBRowSet rowSet = null; //DB ResultSet
String strErrMsg = ""; //에러메세지

try {
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	event = (EsmAgt0013Event) request.getAttribute("Event");
	serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
} catch (Exception e) {
	out.println(e.toString());
}
%>

<html>
<head>
<title>Brokerage Commission Maintenance</title>
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
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form name="hiddenF" mehhod="post"><input type="hidden" name="sheetId"> <input type="hidden" name="f_cmd"> <input type="hidden" name="cust_cd"> <input type="hidden" name="row"> <input type="hidden" name="colNm1"> <input type="hidden" name="colNm2"></form>
<form method="post" name="form" onSubmit="return false;"><input type="hidden" name="f_cmd"> <!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>


						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>


						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_recalculate">Re-calculate</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- Repeat Pattern -->

					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

				<table class="search_in" border="0">
					<tr class="h23">
						<td width="54%">
						<table border="0" style="height: 15; width: 90%;">
							<tr>
								<td width="250" style="padding-left: 10;"><input type="radio" name="date_option" class="trans" value="E" checked>ETD&nbsp;&nbsp;&nbsp;<input type="radio" name="date_option" class="trans" value="C">Creation&nbsp;&nbsp;&nbsp;<input type="radio" name="date_option" value="I" class="trans">Interface</td>
								<td class="sm" style="padding-left: 1;"><input type="text" name="search_dt_fr" style="width: 75; ime-mode: disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_fr">&nbsp;~&nbsp;<input type="text" name="search_dt_to" style="width: 75; ime-mode: disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_to"></td>
							</tr>
						</table>
						</td>
						<td width="14%">Interface Option</td>
						<td style="padding-left: 6;"><select name="sts_cd" style="width: 100;">
							<option value="I">IF</option>
							<option value="N">Not IF</option>
							<option value="A" selected>All</option>
						</select></td>
					</tr>
				</table>
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="5%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VVD</td>
						<td width="24%"><input type="text" name="vvd" style="width: 94; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="10"></td>
						<td width="9%">F/Forwarder</td>
						<td width="16%"><input type="text" name="ff_cnt_cd" style="width: 75; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="8"><img src="" width="3" height="1" border="0"><a href="javascript:openWindowCustomer(document.form);" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
						<td width="4%">B/L</td>
						<td><input type="text" name="bl_no" style="width: 100; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum');setBlNo(this);" onKeyUp="checkEnterOffice(this);" maxlength="12">&nbsp;<input type="text" name="bl_nos" style="width: 300; ime-mode: disabled;" onkeypress="checkEnterOffice(this);" onKeyUp="checkEnterOffice(this);setDateEmpty();"></td>
					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->

		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg"><!-- : ( BKG Information ) (S) --> <!-- : ( grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table>
				<!-- : ( grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) --></td>
	</tr>
</table>
<!-- Outer Table (E)--></form>
</body>
</html>