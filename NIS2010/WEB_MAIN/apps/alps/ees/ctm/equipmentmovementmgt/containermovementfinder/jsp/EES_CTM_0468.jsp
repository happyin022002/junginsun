<%--
 - Copyright(c) 2016 CyberLogitec
 - @FileName : EES_CTM_0466.jsp
 - @FileTitle : Terminal e-VGM Received Monitoring
 - Open Issues :
 - Change history :
 - @LastModifyDate :
 - @LastModifier :
 - @LastVersion :
 - 2016.07.15 김상현 1.0 Creation.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0468Event" %>
<%
	EesCtm0468Event event = null;     // PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // 서버에서 발생한 에러
	String strErrMsg = "";            // 에러메세지
	int rowCount = 0;                 // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCtm0468Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}

	// Default 설정할 date 값 지정
	String defaultToDate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
	String defaultFromDate = DateTime.addMonths(defaultToDate, -1, "yyyy-MM-dd");

	String defaultLongToDate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
	String defaultLongFromDate = DateTime.addMonths(defaultToDate, -6, "yyyy-MM-dd");
%>
<html>

	<head>
		<title>Terminal e-VGM Received Monitoring</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<script type="text/javascript">
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
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
					</table>
					<input type="hidden" name="f_cmd" />
					<input type="hidden" name="pagerows" value="1" />
					<input type="hidden" name="defaultFromDate" value="<%=defaultFromDate %>" />
					<input type="hidden" name="defaultToDate" value="<%=defaultToDate %>" />
					<input type="hidden" name="defaultLongFromDate" value="<%=defaultLongFromDate %>" />
					<input type="hidden" name="defaultLongToDate" value="<%=defaultLongToDate %>" />
					<input type="hidden" name="p_date1" />
					<input type="hidden" name="p_date2" />

					<table class="search">
						<tr>
							<td class="bg">
								<table class="search" border="0" style="width:979;">
									<tr class="h23">
										<td width="20%">
											<table class="search" border="0" style="width:100%;">
												<tr>
													<td class="stm"><B>BKG No.</B></td>
													<td>
														<input type="text" style="width:110;" maxlength="10" value="" name="bkgNoDisp" />
														<input type="hidden" value="" name="bkg_no" />
													</td>
													<td>
														<img src="img/btns_multisearch.gif" name="btns_multisearch" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="doProcessPopup('m_bkg_no')">
													</td>
												</tr>
												<tr>
													<td class="stm"><B>CNTR No.</B></td>
													<td>
														<input type="text" style="width:85;" maxlength="11" value="" name="cntrno_disp" />
														<input type="text" style="width:20;" value="" maxlength="1" name="check_digit" />
														<input type="hidden" value="" name="cntr_no" />
													</td>
													<td>
														<img src="img/btns_multisearch.gif" name="btns_multisearch" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="doProcessPopup('m_cntr_no')">
													</td>
												</tr>
											</table>
										</td>
										<td width="40%" align="center">
											<table class="search" border="0" style="width:90%;">
												<tr>
													<td>
														<B>RCC</B>
														<span style="width:2px;"></span><script type="text/javascript">ComComboObject("rcc_cd", 1, 70, 0, 0, 2, 0, 7)</script>
														<span style="width:2px;"></span><B>LCC</B>
														<span style="width:2px;"></span><script type="text/javascript">ComComboObject("p_lcc_cd", 1, 70, 0, 0, 2, 0, 8)</script>
														<input type="hidden" name="lcc_cd" value="" />
														<span style="width:2px;"></span><B>Yard</B>
														<input type="text" maxlength="5" style="width:55;" class="input" tabindex="9" name="yard_cd1" />
														<span style="width:2px;"></span><script type="text/javascript">ComComboObject("yard_cd2", 2, 45, 0, 0, 2, 0, 10)</script>
														<input type="hidden" name="org_yd_cd" value="" />
													</td>
												</tr>
												<tr>
													<td>
														<B>Show VGM</B>
														<input type="checkbox" name="show_vgm" value="1" onClick="JavaScript:showVgm();" checked />
													</td>
												</tr>
											</table>
										</td>
										<td width="40%">
											<table class="search" border="0" style="width:100%;">
												<tr>
													<td width="3"><input type="radio" name="divflag" value="1" class="trans" OnClick="classToggle();" checked /></td>
													<td class="stm"><B>Received Date</B></td>
													<td>
														<input type="text" style="width:80;" class="input1" value="<%=defaultFromDate %>" name="cre_from_dt" />
														&nbsp;~&nbsp;
														<input type="text" style="width:80;" class="input1" value="<%=defaultToDate %>" name="cre_to_dt" />
														<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar01">
													</td>
												</tr>
												<tr>
													<td width="3"><input type="radio" name="divflag" value="2" class="trans" OnClick="classToggle();" /></td>
													<td class="stm"><B>Verified Date</B></td>
													<td>
														<input type="text" style="width:80;" class="input1" value="<%=defaultFromDate %>" name="vgm_vrfy_from_dt" />
														&nbsp;~&nbsp;
														<input type="text" style="width:80;" class="input1" value="<%=defaultToDate %>" name="vgm_vrfy_to_dt" />
														<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar02">
													</td>
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

		<table class="height_8"><tr><td colspan="8"></td></tr></table>

		<table class="search">
			<tr>
				<td class="bg"  style="height:467" valign="top">
					<table width="100%"  border="0" id="mainTable">
						<tr>
							<td width="100%"><script type="text/javascript">ComSheetObject("sheet1");</script></td>
						</tr>
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
										<td class="btn1_left">
										<td class="btn1" name="btn_retrieve">Retrieve</td>
										<td class="btn1_right">
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
										<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	</body>

</html>
