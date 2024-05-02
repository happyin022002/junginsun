<%--
 - Copyright(c) 2013 CyberLogitec
 - @FileName : EES_CTM_0465.jsp
 - @FileTitle : Multi Container(VGM) Inquiry
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2013.12.09
 - @LastModifier : 문동선
 - @LastVersion : 1.0
 - 2013.12.09 문동선 (EES_CTM_0408 화면 Copy 로 생성)
 - 2016.06.07 김상현 [CHM-201641849] VGM Report 기능 추가
 -  - VGM Report 화면으로 사용할 수 있도록 보완.
 - 2016.07.29 김상현 [CHM-201642497] Multi Container(VGM) Inquiry에 Tab 추가하여 MVMT error+ignored 인경우 별도 tab에서 조회
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0465Event" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesCtm0465Event event = null;     // PDTO(Data Transfer Object including Parameters)
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

		event = (EesCtm0465Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}

	// Container No.
	String pCntrno = (request.getParameter("p_cntrno") == null)? "": request.getParameter("p_cntrno");
	// checkDigit
	String checkDigit = (request.getParameter("check_digit") == null)? "": request.getParameter("check_digit");
	// ctnrTpszCd
	String ctnrTpszCd = (request.getParameter("ctnr_tpsz_cd") == null)? "": request.getParameter("ctnr_tpsz_cd");

	// Duration 종료일 (Hidden - 오늘날짜)
	String tempDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
	// Duration 시작일 (Hidden - 6개월 이전날짜)
	String tempDate1 = DateTime.addMonths(tempDate2, -6, "yyyy-MM-dd");

	String toDt = (request.getParameter("p_date2") == null)? tempDate2: request.getParameter("p_date2"); // Duration 종료일 (request가 없다면 tempDate2)
	String fromDt = (request.getParameter("p_date1") == null)? tempDate1: request.getParameter("p_date1"); // Duration 시작일 (request가 없다면 tempDate1)

	tempDate1 = DateTime.addDays(tempDate2, -7, "yyyy-MM-dd");
	String eventToDt = tempDate2;
	String eventFromDt = tempDate1;
	

	// pop_mode
	String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>
<html>

	<head>
		<title>Multi Container(VGM) Inquiry</title>
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

<% if (popMode.equals("Y")) { %>
	<body class="popup_bg" onLoad="setupPage();">
		<form name="form">
		<table width="100%" class="popup" cellpadding="10" border="0">
			<tr><td class="top"></td></tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0">
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Multi Container(VGM) Inquiry</td></tr>
					</table>
<% } else { %>
	<body onLoad="setupPage();">
		<form name="form">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
					</table>
<% } %>
					<input type="hidden" name="f_cmd" />
					<input type="hidden" name="pagerows" value="1" />
					<input type="hidden" name="temp_date1" value="<%=tempDate1 %>" />
					<input type="hidden" name="temp_date2" value="<%=tempDate2 %>" />
					<input type="hidden" name="fromDt" value="<%=fromDt %>" />
					<input type="hidden" name="toDt" value="<%=toDt %>" />
					<input type="hidden" name="eventFromDt" value="<%=eventFromDt %>" />
					<input type="hidden" name="eventToDt" value="<%=eventToDt %>" />
					<input type="hidden" name="cntr_no" />
					<input type="hidden" name="p_date1" />
					<input type="hidden" name="p_date2" />

					<table class="search">
						<tr>
							<td class="bg">
								<table class="search" border="0" style="width:979;">
									<tr class="h23">
										<td width="34%">
											<table class="search" border="0" style="width:100%;">
												<tr>
													<td width="3"><input type="radio" name="divflag" value="1" class="trans" OnClick="classToggle();" checked /></td>
													<td width="60" class="stm"><B>Event&nbsp;Date</B></td>
													<td>
														<input type="text" style="width:80;" class="input1" value="<%=eventFromDt %>" tabindex="1" name="event_from_dt" dataformat="y-m-d" />
														&nbsp;~&nbsp;
														<input type="text" style="width:80;" class="input1" value="<%=eventToDt %>" tabindex="2" name="event_to_dt" dataformat="ymd" />
														<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar01" />
													</td>
												</tr>
												<tr>
													<td><input type="radio" name="divflag" value="2" class="trans" OnClick="classToggle();" /></td>
													<td class="stm"><B>Received&nbsp;Date</B></td>
													<td>
														<input type="text" style="width:80;" class="input1" value="<%=eventFromDt %>" tabindex="1" name="cre_from_dt" />
														&nbsp;~&nbsp;
														<input type="text" style="width:80;" class="input1" value="<%=eventToDt %>" tabindex="2" name="cre_to_dt" />
														<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar02">
													</td>
												</tr>
												<tr>
													<td><input type="radio" name="divflag" value="3" class="trans" OnClick="classToggle();" /></td>
													<td class="stm"><B>CNTR No.</B></td>
													<td>
														<input type="text" style="width:85;" class="input1" maxlength="10" value="<%=pCntrno%>" name="cntrno_disp">
														<input type="hidden" value="<%=pCntrno%>" name="p_cntrno" />
														<input type="text" style="width:20;" class="input1" value="<%=checkDigit %>" maxlength="1" name="check_digit">
														<img src="img/btns_multisearch.gif" name="btns_multisearch" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="doProcessPopup('m_cntr_no')">
													</td>
												</tr>
											</table>
										</td>
										<td width="32%">
											<table class="search" border="0" style="width:100%;">
												<tr>
													<td width="85" class="stm"><B>BKG(B/L) No.</B></td>
													<td>
														<input type="text" style="width:100px;" class="input" value="" name="bkg_no" />
														&nbsp;
														<B>TP/SZ</B>
														<span style="width:2px;"></span>
														<script type="text/javascript">ComComboObject("tpsz", 1, 50, 1, 0, 0, 0, 11);</script>
														<input type="hidden" name="cntr_tpsz_cd" />
													</td>
												</tr>
												<tr>
													<td class="stm"><b>Status</b></td>
													<td>
														<span style="width:2px;"></span><script type="text/javascript">ComComboObject("statusCombo", 1, 50, 1, 0, 0, 0, 3);</script>
														<input type="hidden" name="mvmt_sts_cd" />
														<span style="width:50px;"></span>
														<B>RCC</B>
														<span style="width:2px;"></span><script type="text/javascript">ComComboObject("rcc_cd", 1, 70, 0, 0, 2, 0, 7)</script>
													</td>
												</tr>
												<tr>
													<td class="stm"><B>Duration</B></td>
													<td>
														<input type="text" style="width:80;" class="input1" value="<%=fromDt %>" tabindex="3" name="from_dt" />
														&nbsp;~&nbsp;
														<input type="text" style="width:80;" class="input1" value="<%=toDt %>" tabindex="4" name="to_dt" />
														<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar03">
													</td>
												</tr>
											</table>
										</td>
										<td width="16%">
											<table class="search" border="0" style="width:100%;">
												<tr>
													<td width="63" class="stm"><B>VVD</B></td>
													<td><input type="text" style="width:80;" class="input" value="" name="vvd_cd" /></td>
												</tr>
												<tr>
													<td class="stm"><B>LCC</B></td>
													<td>
														<span style="width:2px;"></span><script type="text/javascript">ComComboObject("p_lcc_cd", 1, 70, 0, 0, 2, 0, 8)</script>
														<input type="hidden" name="lcc_cd" value="" />
													</td>
												</tr>
												<tr>
													<td class="stm"><B>Result All</B></td>
													<td>
														<select name="mvmt_inp_tp_cd">
															<option value="" selected>ALL</option>
															<option value="EDI">EDI</option>
															<option value="MAN">Manual</option>
														</select>
													</td>
												</tr>
											</table>
										</td>
										<td width="*">
											<table class="search" border="0" style="width:100%;">
												<tr>
													<td width="68" class="stm"><B>VGM</B></td>
													<td>
														<select name="vgm_wgt_qty">
															<option value="Y" selected>Yes</option>
															<option value="N">No</option>
															<option value="">ALL</option>
														</select>
													</td>
												</tr>
												<tr>
													<td class="stm"><B>Yard</B></td>
													<td>
														<input type="text" maxlength="5" style="width:55;" class="input" tabindex="9" name="yard_cd1">
														<span style="width:1px;"></span>
														<script type="text/javascript">ComComboObject("yard_cd2", 2, 45, 0, 0, 2, 0, 10)</script>
														<input type="hidden" name="org_yd_cd" value="" />
													</td>
												</tr>
												<tr>
													<td class="stm"><B>Show VGM</B></td>
													<td>
														<input type="checkbox" name="show_vgm" value="1" onClick="JavaScript:showVgm();" />
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

		<!-- <table class="height_8"><tr><td colspan="8"></td></tr></table> -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tab">
			<tr><td width="100%"><script type="text/javascript">ComTabObject("tab1");</script></td></tr>
		</table>

		<div id="tabLayer" style="display:inline;">
			<table class="search">
				<tr>
					<td class="bg"  style="height:427;" valign="top">
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
											<td class="btn1" name="btn_more">More</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
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
											<td class="btn1" name="btn_eachbkg">Each&nbsp;BKG</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
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
		</div>

		<div id="tabLayer" style="display:none;">
			<table class="search">
				<tr>
					<td class="bg"  style="height:427;" valign="top">
						<table width="100%"  border="0" id="mainTable">
							<tr>
								<td width="100%"><script type="text/javascript">ComSheetObject("sheet2");</script></td>
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
											<td class="btn1" name="btn_more2">More</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_retrieve2">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new2">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_downexcel2">Down&nbsp;Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>

<% if (popMode.equals("Y")) { %>
		<table width="100%" class="sbutton">
			<tr>
				<td height="71" class="popup">
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
						<tr>
							<td class="btn3_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="72">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_close">Close</td>
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
<% } %>
	</form>
	</body>

</html>
