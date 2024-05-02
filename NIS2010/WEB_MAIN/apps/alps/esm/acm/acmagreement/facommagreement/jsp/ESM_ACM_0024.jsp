<%--
 - Copyright(c) 2012 CyberLogitec
 - @FileName : ESM_ACM_0024.jsp
 - @FileTitle : FAC Agreement Creation
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2015.08.05
 - @LastModifier : Sang-Hyun Kim
 - @LastVersion : 1.1
 - 2012.05.03 김봉균 1.0 Creation.
 - 2015.08.05 Sang-Hyun Kim 1.1 [CHM-201537067] Split01-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.event.EsmAcm0024Event" %>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmAcm0024Event event = null;        // PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String cntCd = "";
	String ofcCd = "";
	String ar_ofc_cd = "HAMRU";
	String modYn = "N";

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		cntCd = JSPUtil.getNull(account.getCnt_cd());
		ofcCd = JSPUtil.getNull(account.getOfc_cd());
		// strOfc_cd = account.getOfc_cd();
		event = (EsmAcm0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}

	// 로그인한 USER가 속한 부서의 A/R Office Code를 구한다.
	if (ofcCd.equals("HAMRUS") || ofcCd.equals("HAMRUG")) {
		ofcCd = "HAMRU";
	}

	// 수정가능여부를 설정한다.
	if (ar_ofc_cd.equals(ofcCd)) modYn = "Y";
%>
<html>

<head>
	<title>FAC Agreement Creation</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script language="javascript">
		// 공통코드 combo string 추출
		<%=JSPUtil.getIBCodeCombo("proTp", "", "CD00888", 0, "") %>
		<%=JSPUtil.getIBCodeCombo("facDivCd", "", "CD00993", 0, "") %>
		<%=JSPUtil.getIBCodeCombo("facTp", "", "CD00788", 0, "") %>
		<%=JSPUtil.getIBCodeCombo("bkgRcvTermCd", "", "CD00764", 0, "") %>
		<%=JSPUtil.getIBCodeCombo("bkgDeTermCd", "", "CD00765", 0, "") %>

		function setupPage() {
			var errMessage = "<%=strErrMsg %>";
			if (errMessage.length >= 1) {
				ComShowMessage(errMessage);
			} // end if
			loadPage();
		}
	</script>
</head>

<body onLoad="setupPage();">
	<iframe height="0" width="0" name="frmHidden"></iframe>

	<form name = "hiddenF" method="post">
	<input type="hidden" name="f_cmd" />
	<input type="hidden" name="cust_cd" />
	<input type="hidden" name="sheetId" />
	<input type="hidden" name="row" />
	<input type="hidden" name="colNm1" />
	<input type="hidden" name="colNm2" />
	<input type="hidden" name="newRow" />
	<input type="hidden" name="fac_ofc_cd" /><!-- Office Cd -->
	</form>

	<form name="form">
	<input type="hidden" name="f_cmd" />
	<input type="hidden" name="pagerows" />
	<input type="hidden" name="rowNum" />
	<input type="hidden" name="colNum" />
	<input name="ofc_cd" type="hidden" value="<%=ofcCd %>" /><!-- 로그인 한 사용자의 ofc_cd -->
	<input type="hidden" name="cntCd" value = "<%=cntCd %>" />
	<input type="hidden" name="ff_cnt_cd" />
	<input type="hidden" name="newRow" />
	<input type="hidden" name="recipients_eml" />
	<input type="hidden" name="recipients_name" />
	<input type="hidden" name="cnt" />
	<input type="hidden" name="mod" value="<%=modYn %>" />

	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px;">
		<tr>
			<td valign="top">

				<!-- Page Title, Historical (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
					<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
				<!-- Page Title, Historical (E) -->

				<!-- Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
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
												<td class="btn1" name="btn_save">Save</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_request">Request</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
<%
								if (ar_ofc_cd.equals(ofcCd)) {
									ar_ofc_cd = "HAMRU";
%>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_approve">Approve</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_reject">Reject</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
<%
								}
%>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_uploadexcel">Load Excel</td>
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
					</tr>
				</table>
				<!-- Button (E) -->

				<!-- biz page (S) -->
				<!-- 조회조건 상단 영역 -->
				<table class="search">
					<tr>
						<td class="bg" valign="top">
							<!-- biz_1 (S) -->
							<table width="100%" align="left" border="0" cellpadding="0" cellspacing="0">
								<tr class="h23">
									<td width="200px">Office&nbsp;
										<select name="ar_ofc_cd" style="width:100;" required caption="Office" class="input1" ></select>
										<!--<input type="text" name="fac_ofc_cd" style="width:100;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="8">-->
									</td>
									<td>Status&nbsp;
										<select name="fac_sts_cd" style="width:100;">
											<OPTION value="">All</OPTION>
											<OPTION value="RS">New</OPTION>
											<OPTION value="RR">Requested</OPTION>
											<OPTION value="RE">Rejected</OPTION>
											<OPTION value="PS">Approved</OPTION>
										</select>
									</td>
								</tr>
							</table>
							<!-- biz_1 (E) -->
						</td>
					</tr>
				</table>

				<table class="line_bluedot"><tr><td></td></tr></table>

				<table class="search">
					<tr>
						<td class="bg" valign="top">
            				<!-- biz_2 (S) -->
            				<!-- Grid (S) -->
            				<table width="100%" id="mainTable">
              					<tr><td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td></tr>
							</table>
							<!-- Grid (E) -->
							<!-- biz_2 (E) -->

							<!-- biz_3 (S) -->
							<table width="100%" class="button">
								<tr><td class="btn2_bg">
									<!-- Grid_button (S) -->
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_copy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<!-- Grid_button (E) -->
								</td></tr>
            				</table>
							<!-- biz_3 (E) -->
						</td>
					</tr>
				</table>
				<!-- biz page (E) -->
			</td>
  		</tr>
	</table>
	</form>
</body>

</html>
