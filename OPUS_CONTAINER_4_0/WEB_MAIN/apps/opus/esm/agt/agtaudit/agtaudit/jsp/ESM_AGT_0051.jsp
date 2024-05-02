<%--
/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESM_AGT_051.jsp
 *@FileTitle : Agent Commission Calculation
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
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0051Event"%>
<%
EsmAgt0051Event event = null; //PDTO(Data Transfer Object including Parameters)
Exception serverException = null; //error from server
DBRowSet rowSet = null; //DB ResultSet
String strErrMsg = ""; //error message
int rowCount = 0; //count of DB resultSET list
//String successFlag = "";
//String codeList  = "";
//String pageRows  = "100";

	String userId = "";
	String ofcCd = "";
	String arOfcCd = "";
	String ar_ofc_cd = "";
	String agn_cd = "";

try {
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	userId = account.getUsr_id();
	ofcCd = account.getOfc_cd();

	event = (EsmAgt0051Event) request.getAttribute("Event");
	serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	// adding logic to get data from server when first loading ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
} catch (Exception e) {
	out.println(e.toString());
}

//Retrieving A/R Office Code of Login User's division.
arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);

//Combo Data : getCodeCombo('Tag Name','Init Value', 'Additional Properties', 'Biz name', 'Condition Code', 'Whole check', 'Additional Option')
ar_ofc_cd = ComboUtil.getCodeCombo("ar_ofc_cd", arOfcCd, " onChange='ar_ofc_cd_OnChange(this);' style='width:85', class='input1'", "arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
//agn_cd = ComboUtil.getCodeCombo("agn_cd", ofcCd, " style='width:100'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
agn_cd = ComboUtil.getCodeCombo("agn_cd",arOfcCd," onChange='agn_cd_OnChange(this);' style='width:100', class='input1'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
%>

<html>
<head>
<title>Agent Commission Calculation</title>
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

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;"><input type="hidden" name="f_cmd"> <input type="hidden" name="iPage"> <input type="hidden" name="param1"> <!-- ComboUtil에서 사용하는 codeItem --> <input type="hidden" name="param2"> <!-- All Display 유무(Y, N, [All]) --> <input type="hidden" name="param3"> <!-- Object Name --> <input type="hidden" name="param4"> <!-- arOfcCd Code --> <input type="hidden" name="param5"> <!-- BL No --> <input type="hidden" name="param6"> <!-- Detail Grid Retrieve를 위한 Bkg No --> <!-- Outer Table (S)-->
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
						<table class="button">
							<tr>
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
				<table class="search" border="0" style="width: 737;">
					<tr class="h23">
						<td width="6%">Office</td>
						<td width="13%"><%=ar_ofc_cd%></td>
						<td width="10%">Sub Office</td>
						<td width="13%">
						<div id="div_sbOfcCd"><%=agn_cd%></div>
						</td>
						<td width="5%">Status</td>
						<td width="15%"><select name="sts_cd" style="width: 90;" >
							<option value="0" selected>ALL</option>
							<option value="1">Created</option>
							<!-- CS,CE,IC,CA -->
							<option value="2">Requested</option>
							<!-- RS,RM -->
							<option value="3">Audited</option>
							<!-- AS -->
							<option value="4">Interfaced</option>
							<!-- IF -->
						</select></td>
						<td width="8%">BKG Date</td>
						<td><input type="text" name="search_dt_fr" style="width: 75; ime-mode: disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_fr"> ~ <input type="text" name="search_dt_to" style="width: 75; ime-mode: disabled;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_to"></td>
					</tr>
					<tr class="h23">
						<td colspan="1">B/L</td>
						<td colspan="7" >&nbsp;<input type="text" name="s_bl_no" class='input1' style="width: 100; ime-mode: disabled;" onKeyUp="ComKeyOnlyAlphabet('upper');" maxlength="12"> % <!-- setBlNo(this); --> <img src="/opuscntr/img/button/btng_plus.gif" alt="Like and List Search" width="19" height="20" border="0" align="absmiddle"> &nbsp;<input type="text" name="bl_nos" style="width: 280; ime-mode: disabled;" onKeyUp="ComKeyOnlyAlphabet('upper');"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg"><!-- : (SHEET#1) (S) -->
				<table width="100%" class="search">
					<tr>
						<td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Booking</td>
					</tr>
				</table>
				<table width="100%" id="mainTable1">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table>
				<!-- : (SHEET#1) (E) --> <!-- : (SHEET#2) (S) -->
				<table width="100%" class="search">
					<tr>
						<td class="gray_tit"><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Agent Commission</td>
					</tr>
				</table>
				<table width="100%" id="mainTable2">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet2');</script></td>
					</tr>
				</table>
				<!-- : (SHEET#2) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) --></td>
	</tr>
</table>
<!-- Outer Table (E)--></form>
</body>

</html>

