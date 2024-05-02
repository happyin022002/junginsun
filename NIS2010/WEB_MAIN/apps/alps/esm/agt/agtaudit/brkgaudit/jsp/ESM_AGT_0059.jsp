<%--
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_AGT_059Event.java
*@FileTitle : Brokerage Maintenance & Audit for S.America
*Open Issues :
*Change history :
*@LastModifyDate : 2011-04-13
*@LastModifier : SungJin Park
*@LastVersion : 1.0
* 2011-04-13 SungJin Park
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
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event.EsmAgt0059Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%
EsmAgt0059Event event = null; //PDTO(Data Transfer Object including Parameters)
Exception serverException = null; //서버에서 발생한 에러
DBRowSet rowSet = null; //DB ResultSet
String strErrMsg = ""; //에러메세지
String ofcCd = "";
String ofc_cd = "";

try {
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	ofcCd = account.getOfc_cd();
	event = (EsmAgt0059Event) request.getAttribute("Event");
	serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
} catch (Exception e) {
	out.println(e.toString());
}
//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
ofc_cd = ComboUtil.getCodeCombo("ofc_cd", ofcCd, " style='width:85', class='input1'", "arOfcAgmtCmpn", ofcCd, "&lt;&lt;select&gt;&gt;", "");
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
<form method="post" name="form" onSubmit="return false;">

<input type="hidden" name="f_cmd">
<input type="hidden" name="sheet_vvd_no_row_chk">
<input type="hidden" name="rect_top">
<input type="hidden" name="rect_left">
<input type="hidden" name="multi_vvd">

 <!-- Outer Table (S)-->
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
						<!-- table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_recalculate">Re-calculate</td>
								<td class="btn1_right"></td>
							</tr>
						</table -->
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
						<td width="10%">Office</td>
						<td width="12%"><%= ofc_cd %></td>
						<td width="3%">VVD&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<!--
						<td width="11%"><input type="text" name="vvd" style="width: 100; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="10"></td>
						-->
						<td width="30%">
						<table border="0" style="height: 15; width: 85%;">
							<tr>
								<td id="td_vvd_no">
									<div id="vvd_input" style="display:block;">
									<input type="text" name="s_vvd" style="width:150 ; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="19">
									</div>
									<div id="vvd_sheet" style="display:none;width:150px;height:150px;position:absolute;left:0px;top:0px;">
                                      <script language="javascript">ComSheetObject('t1sheet1');</script>
                                    </div>
								</td>
								<td>
									<table border="0" cellpadding="0" cellspacing="0" class="button" align="right">				
										<td class="btn2_left"></td>
										<td class="btn2" id="tb1_btn_input_vvd_no" name="tb1_btn_input_vvd_no">Multi VVD No.</td>
										<td class="btn2_right"></td>
									</table>
								</td>
							</tr>
						</table>
						</td>
						
						
						<td width="6%">&nbsp;&nbsp;&nbsp;&nbsp;Status</td>
						<td width="30%">
						<table border="0" style="height: 15; width: 90%;">
							<tr>
								<td style="padding-left: 7;"><select name="date_option" style="width: 100;">
									<option value="E" selected>ETD</option>
									<option value="C">Creation</option>
									<option value="I">Interface</option>
								</select></td>
								<td class="sm" style="padding-left: 1;"><input type="text" name="search_dt_fr" style="width: 75; ime-mode: disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_fr">&nbsp;~&nbsp;<input type="text" name="search_dt_to" style="width: 75; ime-mode: disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_to"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="10%">AGMT Customer</td>
						<td width="13%">&nbsp;&nbsp;<input type="text" name="ff_cnt_cd" style="width: 75; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="8"><img src="" width="3" height="1" border="0"><a href="javascript:openWindowCustomer(document.form);" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
						<td width="3%">&nbsp;&nbsp;B/L</td>
						<td width="1%"></td><td>&nbsp;&nbsp;<input type="text" name="bl_no" style="width: 100; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum');setBlNo(this);" onKeyUp="checkEnterOffice(this);" maxlength="12">&nbsp;<input type="text" name="bl_nos" style="width: 365; ime-mode: disabled;" onkeypress="checkEnterOffice(this);" onKeyUp="checkEnterOffice(this);setDateEmpty();"></td>
						<td width="13%">&nbsp;&nbsp;&nbsp;&nbsp;Interface Option</td>
						<td style="padding-left: 6;"><select name="sts_cd" style="width: 100;">
							<option value="I">IF</option>
							<option value="N">Not IF</option>
							<option value="P">Paid</option>
							<option value="T">Not Paid</option>
							<option value="C">Payment Cancel</option>
							<option value="A" selected>All</option>
						</select></td>
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