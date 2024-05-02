<%--
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_AGT_0060.jsp
*@FileTitle : Agent Commission AP Interface for S.America
*Open Issues :
*Change history :
*@LastModifyDate : 2011-04-27
*@LastModifier : SungJin, Park
*@LastVersion : 1.0
* 2011-04-27 SungJin, Park
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event.EsmAgt0060Event"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmAgt0060Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	DBRowSet rowSet = null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String userId = "";
	String sbOfcCd = "";
	String ofc_cd = "";
	
	String cost_ofc_cd = "";
	String inv_sub_sys_cd = "";
	cost_ofc_cd 		= JSPUtil.getParameter(request, "cost_ofc_cd 			".trim(), "");	
	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		sbOfcCd = account.getOfc_cd();

		event = (EsmAgt0060Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
	//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
	ofc_cd = ComboUtil.getCodeCombo("ofc_cd", sbOfcCd, " style='width:100', class='input1'", "arOfcAgmtCmpn", sbOfcCd, "&lt;&lt;select&gt;&gt;", "");
%>

<html>
<head>
<title>Brokerage AP Actual Interface</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
RdReport = "/hanjin/apps/alps/esm/agt/common/jsp/ESM_AGT_RDReport.jsp" ;
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> <input type="hidden" name="iPage">
<input type="hidden" name="param1"> <!-- Detail Grid 조회를 위한 vendor_seq -->
<input type="hidden" name="param2"> <!-- Detail Grid 조회를 위한 F.Forwarder -->
<input type="hidden" name="param3"> <!-- Detail Grid 조회를 위한 CSR No -->
<input type="hidden" name="param4"> <!-- Detail Grid 조회를 위한 AP OFC CD -->
<input type="hidden" name="h_csrno"> <!-- grid에서 선택된 csrNo -->
<input type="hidden" name="ofcCd" value="<%=sbOfcCd%>"> <!-- 로그인한 유저의 오피스 -->
<input type="hidden" name="vndr_seq"> <!-- Detail Grid 조회를 위한 vendor_seq -->
<input type="hidden" name="fwdr"> <!-- Detail Grid 조회를 위한 F.Forwarder -->
<input type="hidden" name="csr_no"> <!-- Detail Grid 조회를 위한 CSR No -->
<input type="hidden" name="ap_ofc_cd"> <!-- Detail Grid 조회를 위한 AP OFC CD -->
<input type="hidden"    name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(cost_ofc_cd, inv_sub_sys_cd) %>">



<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->

		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_request">Approval Request</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_cancel">Cancel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_print">Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_csrprint">CSR Print</td>
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
						<td width="12%">Office</td>
						<td width="12%"><%= ofc_cd %></td>
						<td width="5%">Status</td>
						<td width="35%" class="sm"><SELECT name="sts_option" style="width: 100">
							<OPTION value="1" selected>ETD</OPTION>
							<OPTION value="2">Create</OPTION>
						</SELECT>&nbsp;<input type="text" style="width: 75" maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="search_dt_fr"> <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btn_cal_fr">&nbsp;~&nbsp;<input type="text" style="width: 75" maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="search_dt_to"><img src="" width="2" height="1" border="0"><img class="cursor"
							src="/hanjin/img/button/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btn_cal_to"></td>
						<td width="12%">Interface Option</td>
						<td width="12%"><select class="input1" style="width: 100;" name="if_option" onchange="if_option_OnChange(this)">
							<option value="BF" selected>Before</option>
							<option value="NC">Not Condition</option>
							<option value="IF">Interfaced</option>
						</select></td>
						<td width="10%">&nbsp;&nbsp;EFF Date</td>
						<td align="right"><input type="text" class="input1" style="width: 70" maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="eff_date"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_eff_dt"></td>
					</tr>
					<tr class="h23">
						<td>AGMT Customer</td>
						<td><input type="text" name="ff_cnt_cd"
							style="width: 79; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="8"><img
							src="" width="2" height="1" border="0"><a
							href="javascript:openWindowCustomer(document.form);"
							class="purple"><img class="cursor"
							src="/hanjin/img/button/btns_search.gif" width="19" height="20"
							border="0" align="absmiddle"></a></td>
						<td>B/L</td>
						<td><input type="text" name="bl_no" style="width: 100; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum');setBlNo(this);" maxlength="12">&nbsp;<input type="text" name="bl_nos" style="width: 205; ime-mode: disabled;"  onkeypress="setBlNos(this);" onKeyUp="setBlNos(this);"></td>
						<td>Interface Cnt</td>
						<td ><SELECT name="if_cnt"
							onChange="if_cnt_OnChange()" style="width: 100;">
							<OPTION value="SEL" selected></OPTION>
							<OPTION value="10">10</OPTION>
							<OPTION value="30">30</OPTION>
							<OPTION value="50">50</OPTION>
							<OPTION value="100">100</OPTION>
						</SELECT></td>
						<td>&nbsp;&nbsp;VAT (%)</td>
                        <td><input type="text" style="width:90;text-align:right" maxlength = "8" name="inv_tax_rt" value="0.00" onfocus="invTaxRt_onfocus(this)" onblur="invTaxRt_validate(this)"></td>
					</tr>
				</table>

				<table class="search_in" border="0">
					<tr>
						<td colspan="3">
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr class="h23">
						<td width="107">Approval Step</td>
						<td width="630"><input name="apro_step" type="text" class="input1" style="width: 604;" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(sbOfcCd, "AGT")%>" disabled><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_popup"></td>
						<td><!--  Button_Sub (S) -->
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_clear">Clear</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
						<!--  Button_Sub (E) --></td>
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
				<td class="bg"><!-- : ( Brokerage AP Interface ) (S) --> <!-- : ( grid ) (S) -->
				<table width="100%" class="search">
					<tr>
						<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Master</td>
						<td align="right" style="padding-bottom: 3;"><!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btng_editapprovalstep">Edit Approval Step</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
								</td>
							</tr>
						</table>
						<!--  Button_Sub (E) --></td>
					</tr>
				</table>
				<table width="100%" id="mainTable">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table>
				<table width="100%" class="search">
					<tr>
						<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Detail</td>
					</tr>
				</table>
				<table width="100%" id="mainTable">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet2');</script></td>
					</tr>
				</table>

				<!-- : ( grid ) (E) --> <!-- : ( Brokerage AP Interface ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) --></td>
	</tr>
</table>
<!-- Outer Table (E)--></form>
</body>

</html>
<!-- PRINT (S)tart -->
<DIV style="display: none"><!-- : ( Grid : AP_INV_HDR ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet3');</script></td>
	</tr>
</table>
<!-- : ( Grid : AP_INV_HDR ) (E) --> <!-- : ( Grid : AP_INV_DTRB ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet4');</script></td>
	</tr>
</table>
<!-- : ( Grid : AP_INV_DTRB ) (E) --> <!-- : ( Grid : Brokerage Interfaced Status ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet5');</script></td>
	</tr>
</table>
<!-- : ( Grid : Brokerage Interfaced Status ) (E) --> <!-- : ( Grid : Brokerage DownExcel ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet6');</script></td>
	</tr>
</table>
<!-- : ( Grid : Brokerage DownExcel ) (E) --></DIV>
<!-- PRINT (E)nd -->




