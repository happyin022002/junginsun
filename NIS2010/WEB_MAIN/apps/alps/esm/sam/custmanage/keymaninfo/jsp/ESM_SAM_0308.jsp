<%
	/*=========================================================
	 *Hipluscard 2017
	 *@FileName : esm_bkg_0308.jsp
	 *@FileTitle : Integrated Customer Data Management
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2017.07.10
	 *@LastModifier : 임진영
	 *@LastVersion : 1.0
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.event.EsmSam0308Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	EsmSam0308Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_email = "";
	String strOfc_cd = "";

	String strPodCd = "";

	Logger log = Logger.getLogger("com.hanjin.apps.custmanage.keymaninfo");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();
		strPodCd = request.getParameter("pod_cd");

		event = (EsmSam0308Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<%
	String arrColNames ="keyman_seq";
	int x = 0;
%>
<html>
<head>
<title>KeyMan Info Setup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var strUsr_nm    = "<%=strUsr_nm%>";
	var strUsr_email = "<%=strUsr_email%>";
	var strOfc_cd    = "<%=strOfc_cd%>";

	var arrColValues = "<%=JSPUtil.getNull(request.getParameter(arrColNames))%>";

	function setupPage() {
		//var errMessage = "<%=strErrMsg%>";
		//if (errMessage.length >= 1) {
		//	showErrMessage(errMessage);
		//} // end if
		loadPage();
	}


</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
	<form name="form">
		<input name="f_cmd" type="hidden" /> <input type="hidden"
			name="pagerows" value="<%=pageRows%>">

		<!-- 개발자 작업	-->

		<%-- <input type="hidden" name="ofc_cd" value="<%=strOfc_cd %>"> --%>
		<input type="hidden" name="pod_cd"
			value="<%=StringUtil.xssFilter(strPodCd)%>"> <input
			type="hidden" name="row"
			value="<%=StringUtil.xssFilter(request.getParameter("row"))%>"></input>

		<input type="hidden" name="cust_cnt_cd"> <input type="hidden"
			name="cust_seq"> <input type="hidden" name="keyman_seq">
		<input type="hidden" name="ibflag">

		<!-- OUTER - POPUP (S)tart -->
		<table width="100%" class="popup" cellpadding="10" border="0">
			<tr>
				<td class="top"></td>
			</tr>
			<tr>
				<td valign="top">
					<!-- : ( Title ) (S) -->
					<table width="100%" border="0">
						<tr>
							<td class="title"><img src="img/icon_title_dot.gif"
								align="absmiddle">&nbsp;KeyMan Info.Setup</td>
						</tr>
					</table> <!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) -->

					<table class="search">
						<tr>
							<td class="bg">
								<!--biz 1 (S)-->
								<table class="search" border="0" style="width: 680;">
									<tr class="h23">
										<td width="355" valign="top">

											<table class="search" border="0" style="width: 420;">

												<tr class="h23">
													<td width="">&nbsp;First Name</td>
													<td width="210"><input type="text"
														style="width: 100%;" class="input1" value=""
														name="fst_name" id="fst_name" maxlength="100"
														dataformat='engup'></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Last Name</td>
													<td width="210"><input type="text"
														style="width: 100%;" class="input1" value=""
														name="last_name" id="last_name" maxlength="100"
														dataformat='engup'></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Mr/Ms</td>
													<td width="" style="padding-left: 2"><select
														style="width: 60%;" name="per_title" id="per_title">
															<option value=""></option>
															<option value="Mr">Mr</option>
															<option value="Ms">Ms</option>
													</select></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Job Title</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="job_title" id="job_title"
														dataformat="ymdhm" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;</td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;In Charge Of</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="pager_pin" id="pager_pin"
														dataformat="ymdhm" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;</td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Department</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="occupation" id="occupation"
														dataformat="ymdhm" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;</td>
												</tr>

												<tr class="h23">
													<td width="">&nbsp;Significance</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="eye_color" id="eye_color"
														maxlength="10">&nbsp;&nbsp;&nbsp;&nbsp;</td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Birthday</td>
													<td width="230"><input type="text" style="width: 75"
														dataformat="ymd" minlength="8" maxlength="8" value=""
														class="input" caption="Birthday" name="birth_dt"
														style="width:100;ime-mode:disabled"
														onKeyPress="ComKeyOnlyNumber(this);">&nbsp;&nbsp;&nbsp;<img
														class="cursor" src="img/btns_calendar.gif" width="19"
														height="20" border="0" align="absmiddle" name="birth_btn" />
													</td>

												</tr>
												<tr class="h23">
													<td width="">&nbsp;Wedding Anniversary Date</td>
													<td width=""><input type="text" style="width: 75"
														dataformat="ymd" minlength="8" maxlength="8" value=""
														class="input" caption="Wedding Anniversary Date"
														name="wed_anvrsry_dt" style="width:100;ime-mode:disabled"
														onKeyPress="ComKeyOnlyNumber(this);">&nbsp;&nbsp;&nbsp;<img
														class="cursor" src="img/btns_calendar.gif" width="19"
														height="20" border="0" align="absmiddle"
														name="wed_anvrsry_btn" /></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Single/Married</td>
													<td width="" style="padding-left: 2"><select
														style="width: 60%;" name="hair_color" id="hair_color">
															<option value=""></option>
															<option value="S">Single</option>
															<option value="M">Married</option>
													</select></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Spouse Name</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="spouse_name" id="spouse_name"
														onKeyPress="ComKeyOnlyAlphabet('upper');" maxlength="7"></td>
												</tr>


											</table>
										</td>
										<td width="20">&nbsp;</td>
										<td width="330" valign="top">
											<table class="search" border="0" style="width: 340;">

												<tr class="h23">
													<td width="">&nbsp;Customer</td>
													<td width="210"><input type="text"
														style="width: 100%;" class="input2" value=""
														name="cust_lgl_eng_nm" id="cust_lgl_eng_nm"
														maxlength="100" readonly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Customer Code</td>
													<td width=""><input type="text" style="width: 60%"
														class="input1" value="" name="cust_cd" id="cust_cd"
														maxlength="100" dataformat='engupnum'> <img
														src="img/btns_search.gif" name="btn_com_ens_041"
														width="19" height="20" alt="" border="0" align="absmiddle"
														class="cursor"></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Email</td>
													<td width="210"><input type="text"
														style="width: 100%;" class="input" value=""
														name="email_addr" id="email_addr" /></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;S.Rep</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="srep_cd" id="srep_cd"
														dataformat='engupnum' style="ime-mode:disabled"
														maxlength="16"> <img src="img/btns_search.gif"
														name="btn_com_ens_043" width="19" height="20" alt=""
														border="0" align="absmiddle" class="cursor"></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;S.Rep Name</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input2" value="" name="srep_nm" id="srep_nm"
														style="ime-mode:disabled" maxlength="16"
														readonly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Character</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="con_manager_name"
														id="con_manager_name" style="ime-mode:disabled"
														maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;</td>
												</tr>

												<tr class="h23">
													<td width="">&nbsp;Work Phone #</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="work_ph_num" id="work_ph_num"
														onKeyPress="ComKeyOnlyNumber(this,'-');" maxlength="16"
														style="ime-mode:disabled"></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Work Fax #</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="fax_ph_num" id="fax_ph_num"
														onKeyPress="ComKeyOnlyNumber(this,'-');" maxlength="16"
														style="ime-mode:disabled"></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Mobile Phone #</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="cell_ph_num" id="cell_ph_num"
														onKeyPress="ComKeyOnlyNumber(this,'-');" maxlength="16"
														style="ime-mode:disabled"></td>
												</tr>
												<tr class="h23">
													<td width="">&nbsp;Home Phone #</td>
													<td width=""><input type="text" style="width: 60%;"
														class="input" value="" name="home_ph_num" id="home_ph_num"
														onKeyPress="ComKeyOnlyNumber(this,'-');" maxlength="16"
														style="ime-mode:disabled"></td>
												</tr>
											</table>

										</td>
									</tr>
								</table> <!--biz 1 (E)-->

							</td>
						</tr>
					</table> <!-- : ( Search Options ) (E) -->
					<table class="height_5">
						<tr>
							<td></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>






		<!-- : ( Button : pop ) (S) -->
		<table width="100%" class="sbutton">
			<tr>
				<td height="71" class="popup">

					<table width="100%" class="button" border="0" cellpadding="0"
						cellspacing="0" style="padding-top: 5; padding-bottom: 10;">
						<tr>
							<td class="btn3_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td></td>
										<td>
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_save">Save</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
										<td class="btn1_line"></td>
										<td><table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_close">Close</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
									</tr>
								</table> <!--Button (E) -->

							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<!-- : ( Button : pop ) (E) -->


		<!-- Grid  (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">
					ComSheetObject('sheet1');
				</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->
				<!-- Grid  (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">
					ComSheetObject('sheet2');
				</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->
		<!-- : ( Button : pop ) (E) -->

		<!-- 개발자 작업  끝 -->
	</form>
</body>
</html>