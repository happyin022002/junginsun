<%
/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : ESM_BKG_1501.jsp
*@FileTitle : Advance Cargo Information Download & Transmit
*Open Issues :
*Change history :
	2017.08.08 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.08.08
*@LastModifier : 하대성
*@LastVersion : 1.1
* 2013.06.28 김상수
* 1.0 Creation
* 1.1 [CHM-201430566] JAFR ATD후의 CMR 5, 1  전송 조건 개선 요청 / hannah lee
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1501Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1501Event event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    //서버에서 발생한 에러
	String strErrMsg = "";               //에러메세지
	int rowCount = 0;                    //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1501Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Advance Cargo Information Download & Transmit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var strUsrId = "<%=strUsr_id%>";

	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" name="del_trasmit_flag">
<input type="hidden" name="vvd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pol_split_no">
<input type="hidden" name="rlx_div">
<input type="hidden" name="hid_rcv_dt">

<!-- 2017.07.30 Daesung Ha Start -->
<input type="hidden" name="del_new_trasmit_flag">
<input type="hidden" name="del_cd">
<input type="hidden" name="del_reason">
<!-- 2017.07.30 Daesung Ha End -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px;">
	<tr>
		<td valign="top">


			<!-- Page Title, Historical (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- Page Title, Historical (E) -->

			<!-- biz page (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td valign="top" style="width:550px">
						<table class="search">
							<tr>
								<td class="bg" valign="top">
									<!-- biz_1 (S) -->
									<table width="100%" class="search_ssm1" border="0">
										<tr class="h23">
											<td>Retrieve from (source)
												<select style="width:120px;" class="input1" name="search_div">
													<option value="BL" selected>B/L Data</option>
													<option value="DN">Download Data</option>
												</select></td>
											<td>All or Error only
												<select style="width:90px;" class="input1" name="error_div">
													<option value="" selected>All</option>
													<option value="ERR">Error B/L</option>
												</select></td>
										</tr>
									</table>

									<table width="100%" class="search_ssm" border="0">
										<tr class="h23">
											<td><input type="radio" name="vvd_date_div" value="VVD" class="trans" checked>VVD
												<input type="text" class="input1" style="width:75px; ime-mode:disabled;" name="vvd_hdr" maxlength="9" required caption="VVD" fullfill dataformat="engupnum"></td>
											<td>Call Sign
												<input type="text" class="input2" style="width:70px;" name="call_sgn_no" readOnly></td>
											<td><input type="radio" name="vvd_date_div" value="DATE" class="trans"><select class="input" name="vps_dt_div" style="width:50px; font-weight:bold;">
													<option value="ETD" selected>ETD</option>
													<option value="ETA">ETA</option>
												</select>
												<input type="text" class="input2" style="width:70px;" name="date_fm" dataformat="ymd" maxlength="10" caption="From Date" cofield="date_to" readOnly>&nbsp;~
												<input type="text" class="input2" style="width:70px;" name="date_to" dataformat="ymd" maxlength="10" caption="To Date" cofield="date_fm" readOnly>
												<img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;"></td>
										</tr>
									</table>

									<table class="search" border="0">
										<tr class="h23" style="height:29px;">
											<td><select class="input" name="pol_div" style="width:65x; font-weight:bold;">
													<option value="VVD_POL" selected>V/POL</option>
													<option value="BKG_POL">B/POL</option>
												</select>
												<input type="text" class="input" style="width:50px; ime-mode:disabled;" caption="POL" name="pol_cd_hdr" maxlength="5" dataformat="engup"></td>
											<td>V/POD
												<input type="text" class="input2" style="width:15px; border-right-style:none;" name="pod_prefix" value="JP" readOnly><input type="text" style="width:35; ime-mode:disabled; border-left-style:none;" class="input" name="pod_postfix" maxlength="3" dataformat="engup">
												<select name="pod_split_no" class="input" style="width:35px;">
													<option value="" selected></option>
<% for (int k=1; k<10; k++) { %>
													<option value="<%=k%>"><%=k%></option>
<% } %>
												</select></td>
											<td>BKG OFC
												<input type="text" class="input" style="width:50px; ime-mode:disabled;" name="bkg_ofc_cd" maxlength="6" dataformat="engupnum"></td>
											<td>L/T
												<select style="width:55;" class="input" name="lt_div">
													<option value="" selected>All</option>
													<option value="L">Local</option>
													<option value="T">T/S</option>
												</select></td>
										</tr>
									</table>

									<table class="search" border="0">
										<tr class="h23" style="height:29px;">
											<td>B/L No.
												<input type="text" class="input" style="width:90px; ime-mode:disabled;" name="bl_no" maxlength="12" dataformat="engupnum"></td>
											<td>Customs Results
												<select style="width:70px;" class="input" name="cstms_rslts">
													<option value="" selected></option>
													<option value="ALL_RSLT">All Result</option>
													<option value="SAS111">SAS111</option>
													<option value="SAS108">SAS108</option>
													<option value="SAMR">SAMR</option>
													<option value="SCMR">SCMR</option>
												</select></td>
											<td>BKG Staff
												<input type="text" class="input" style="width:100px; ime-mode:disabled;" name="doc_usr_id" maxlength="20" dataformat="engupnum"></td>
										</tr>
									</table>
									<!-- biz_1 (E) -->
								</td>
							</tr>
						</table>


						<!-- Button (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
							<tr>
								<td class="btn1_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left">
														<td class="btn1" name="btn_retrieve">Retrieve</td>
														<td class="btn1_right">
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
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Button (E) -->
					</td>


					<td style="width:5px"></td>


					<td valign="top">
						<table class="search">
							<tr>
								<td class="bg" valign="top">
									<!-- biz_2 (S) -->
									<!-- Grid (S) -->
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject("sheet1");</script></td>
										</tr>
									</table>
									<!-- Grid (E) -->
									<!-- biz_2 (E) -->
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>


			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_2 (S) -->
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject("sheet2");</script></td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!-- biz_2 (E) -->
						<!-- biz_4 (S) -->
						<table border="0" cellpadding="0" cellspacing="0">
							<tr class="h23">
								<td>Transmission Status :&nbsp;</td>
								<td>
									<table border="0" cellpadding="0" cellspacing="0">
										<tr class="h23">
											<td>Total B/L&nbsp;&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_ttl_bl"></td>
											<td>&nbsp;=&nbsp;</td>
											<td>Success B/L&nbsp;&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_snt_scc_bl" readonly></td>
											<td>&nbsp;+&nbsp;</td>
											<td style="color:red;">Error B/L&nbsp;&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_snt_err_bl" readonly></td>
											<td>&nbsp;+&nbsp;</td>
											<td style="color:red;">Missing B/L&nbsp;&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_miss_bl" readonly></td>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td style="color:red;">* SML' Error B/L&nbsp&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_hjs_err_bl" readonly></td>
										</tr>
									</table></td>
							</tr>
							<tr class="h23">
								<td>JP customs enforcement :&nbsp;</td>
								<td>
									<table width="450" border="0" cellpadding="0" cellspacing="0">
										<tr class="h23">
											<td align="center" style="color:red">DNL&nbsp;&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_dnl" readonly></td>
											<td align="center" style="color:red">DNU&nbsp;&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_dnu" readonly></td>
											<td align="center" style="color:red">SPD&nbsp;&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_spd" readonly></td>
											<td align="center" style="color:red">HLD&nbsp;&nbsp;<input type="text" class="input2" style="width:50px; text-align:right;" id="disp_hld" readonly></td>
										</tr>
									</table></td>
							</tr>
						</table>
						<!-- biz_4 (E) -->
					</td>
				</tr>
			</table>
			<!-- biz page (E) -->


			<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_send_email">Send Email</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_bl_inquiry">B/L Inquiry</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td style="display:none;">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_detail">Detail</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_data_download">Data Download</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_down_excel">Down Excel</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<!-- <td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_transmit">Transmit</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_del_transmit">DEL Transmit</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td> -->
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new_transmit">Transmit</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_del_new_transmit">DEL Transmit</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_view_file">View Send File</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- Button (E) -->


		</td>
	</tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
