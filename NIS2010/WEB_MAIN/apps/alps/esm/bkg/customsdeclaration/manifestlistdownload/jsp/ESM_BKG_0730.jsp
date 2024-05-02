
<%
	/*=========================================================
	 *Copyright(c) 2017 Hi-Plus Card
	 *@FileName : esm_bkg_0730.jsp
	 *@FileTitle : ESM_BKG-0730
	 *Open Issues :
	 *Change history :
		 2017.08.08 하대성 2017 Renewal Version Transmit 반영
	 *@LastModifyDate : 2017.08.08
	 *@LastModifier : 하대성
	 *@LastVersion : 1.0
	 * 2009.05.26 김승민
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
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
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0730Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0730Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0730Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0730</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="in_msg_tp" value="MFR"> 
<input type="hidden" name="in_msg_flag" value="9"> 
<input type="hidden" name="in_mfr_gubun" value="Y"> 
<input type="hidden" name="KEY"><!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
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
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="150"><input type="text" style="width: 90;"
							class="input1" name="in_vvd_cd" value="" maxlength="9"
							dataformat="uppernum" style="ime-mode:disabled"></td>
						<td width="80">Voyage No</td>
						<td width="80"><input type="text" style="width: 50;"
							class="input" name="in_voyage_no" dataformat="uppernum" maxlength="5" value=""
							style="ime-mode:disabled"></td>
						<td width="60">Call Sign</td>
						<td width="120"><input type="text" style="width: 50;"
							class="input" name="in_call_sgn_no" dataformat="uppernum" malength="15" value=""
							style="ime-mode:disabled"></td>
						<td width="30">POD</td>
						<td width="140"><input type="text" style="width: 45;"
							class="input1" name="in_pod_cd" value="" maxlength="5"
							dataformat="upper" style="ime-mode:disabled">&nbsp;<input
							type="text" style="width: 30;" class="input1"
							name="in_pod_split_cd" maxlength="2" dataformat="uppernum"
							value="" style="ime-mode:disabled"></td>
						<td width="30">POL</td>
						<td width=""><input type="text" style="width: 45;"
							class="input" name="in_pol_cd" value="" maxlength="5"
							dataformat="uppernum" style="ime-mode:disabled"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="30">ETA</td>
						<td width="150"><input type="text" style="width: 90;"
							class="input" name="in_vps_eta_dt" dataformat="ymd"
							maxlength="10" value="">&nbsp;<img class="cursor"
							src="img/btns_calendar.gif" width="19" height="20" border="0"
							align="absmiddle" name="btns_calendar"></td>
						<td width="60">B/L Type</td>
						<td width="100">&nbsp;<select style="width: 70;"
							name="in_bl_type">
							<option value="0" selected>ALL</option>
							<option value="1">Local</option>
							<option value="2">T/S</option>
						</select></td>
						<td width="170">
						<table class="search_sm2" border="0" style="width: 120;">
							<tr class="h23">
								<td class="stm"><input type="radio" value="A" class="trans"
									name="in_err_gb">&nbsp;All&nbsp;&nbsp;&nbsp;<input
									type="radio" value="E" class="trans" name="in_err_gb" checked>&nbsp;Error</td>
							</tr>
						</table>
						</td>
						<td width="100">CY Operator CD</td>
						<td><input type="text" style="width: 50;" class="input"
							value="" name="in_cy_opr_cd" maxlength="5" dataformat="uppernum"
							style="ime-mode:disabled"></td>
					</tr>
				</table>
				<!--  biz_1   (E) --></td>
			</tr>
		</table>
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>


		<!-- Grid BG Box  (S) -->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--Grid (S)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--Grid (E)--> <!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td width="">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_add">B/L Add</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
							<td width="">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_delete">Row Delete</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) --></td>
			</tr>
		</table>
		<!-- Grid BG Box  (S) --> <!--biz page (E)-->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">

			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_customer">Customer</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_cntr">CNTR</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_marks">Marks & Desc</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
<!-- 						<td>
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_trans">Trans to SEA-NACCS</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td> -->
						<td>
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_trans_new_naccs">Trans to SEA-NACCS</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!--Button (E) --></td>
			</tr>
		</table>

		</td>
	</tr>
</table>
</form>
</body>
</html>