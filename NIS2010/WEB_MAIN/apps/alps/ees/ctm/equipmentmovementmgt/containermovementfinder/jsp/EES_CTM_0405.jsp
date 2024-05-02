<%--
 - Copyright(c) 2009 CyberLogitec
 - @FileName : ees_ctm_0405.jsp
 - @FileTitle : Empty VL List without BKG
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2009.05.14
 - @LastModifier : 김상수
 - @LastVersion : 1.0
 - 2009.05.14 김상수 1.0 Creation.
 - 2016.06.22 김상현 [CHM-201641960] Correction Reason 항목 추가화면 기능 추가
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0405Event" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesCtm0405Event event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    //서버에서 발생한 에러
	String strErrMsg = "";               //에러메세지
	int rowCount = 0;                    //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMasterDataMgt");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

	    event = (EesCtm0405Event)request.getAttribute("Event");
	    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}

	// Corr Reason
	String cnmvCorrRsn = JSPUtil.getIBCodeCombo("", "", "CD03488", 0, "");
	String cnmvCorrRsnCode = "";
	String cnmvCorrRsnValue = "";

	if (cnmvCorrRsn != null && cnmvCorrRsn.length() > 0) {
		cnmvCorrRsnCode = cnmvCorrRsn.substring(cnmvCorrRsn.indexOf("Code = \"") + 8, cnmvCorrRsn.lastIndexOf("\""));
		cnmvCorrRsnValue = cnmvCorrRsn.substring(cnmvCorrRsn.indexOf("Text = \"") + 8, cnmvCorrRsn.indexOf("\";"));
	}

	// 현재날짜
	String pDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
	// 1개월 이전날짜
	String pDate1 = DateTime.addMonths(pDate2, -1, "yyyy-MM-dd");
%>
<html>

	<head>
		<title>Empty VL List without BKG</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			var cnmvCorrRsnCode = "<%=cnmvCorrRsnCode %>";
			var cnmvCorrRsnValue = "<%=cnmvCorrRsnValue %>";

			function setupPage() {
				var errMessage = "<%=strErrMsg%>";
				if (errMessage.length >= 1) {
					showErrMessage(errMessage);
				}
				loadPage();
			}
		</script>
	</head>

	<body onLoad="setupPage();">
		<form name="form">
		<input type="hidden" name="f_cmd" />
		<input type="hidden" name="pagerows" />

		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
					</table>

					<table class="search">
						<tr>
							<td class="bg" style="height:516" valign="top">
								<table class="search" border="0" style="width:979;">
									<tr class="h23">
										<td width="30"> LCC</td>
										<td width="80"><input type="text" style="width:50;" class="input1" maxlength="5" style="ime-mode:disabled;" tabindex="1" name="lcc_cd"></td>
										<td width="30"> Yard</td>
										<td width="60" style="padding-top:1;">
											<input type="text" style="width:55;text-align:center;" class="input" maxlength="5" style="ime-mode:disabled;" tabindex="2" name="yd_cd_disp" />
											<input type="hidden" name="p_yard1" />
										</td>
										<td width="70"> <script type="text/javascript">ComComboObject("p_yard2", 2, 50, 0, 0, 0, 0, 3);</script></td>
										<td width="60"> Duration</td>
										<td width="260">
											<input type="text" style="width:75;" class="input1" value="<%=pDate1%>" style="ime-mode:disabled;" tabindex="4" name="p_date1">
											&nbsp;~
											<input type="text" style="width:75;" class="input1" value="<%=pDate2%>" style="ime-mode:disabled;" tabindex="5" name="p_date2">
											<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar">
										</td>
										<td width="95"> Call Sign/Lloyd </td>
										<td><input type="text" style="width:90;" class="input" style="ime-mode:disabled;" tabindex="6" name="lloyd_no"></td>
									</tr>
								</table>
								<table class="line_bluedot"><tr><td></td></tr></table>
								<table width="100%" id="mainTable">
									<tr><td width="100%"><script type="text/javascript">ComSheetObject("sheet1");</script></td></tr>
								</table>
							</td>
						</tr>
					</table>

					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
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
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_new">New</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
										<td class="btn1_line"></td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_delete">Delete</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
										<td class="btn1_line"></td>
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
				</td>
			</tr>
		</table>

		<script type="text/javascript"> ComUploadObject("upload", "<%=session.getId() %>"); </script>
		</form>
	</body>

</html>
