
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ui_bkg_0123.jsp
	 *@FileTitle : ACI_Vessel Information
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.25
	 *@LastModifier : 정재엽
	 *@LastVersion : 1.0
	 * 2009.04.24 정재엽
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
	import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0123Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0123Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0123Event) request.getAttribute("Event");
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
%>
<html>
<head>
<title>Wharfage Cargo Classification - Add Booking Data</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> <input type="hidden"
	name="attr_ctnt2"> <!-- 개발자 작업	--> <%
 	String vvd = (request.getParameter("vvd") == null) ? "" : request
 			.getParameter("vvd");
 	String portCd = (request.getParameter("port_cd") == null) ? ""
 			: request.getParameter("port_cd");
 	String whfBndCd = (request.getParameter("whf_bnd_cd") == null) ? ""
 			: request.getParameter("whf_bnd_cd");
 	String whfRate = (request.getParameter("whf_rate") == null) ? ""
 			: request.getParameter("whf_rate");
 	String blNo = (request.getParameter("bl_no") == null) ? ""
 			: request.getParameter("bl_no");
 	String bkgNo = (request.getParameter("bkg_no") == null) ? ""
 			: request.getParameter("bkg_no");
 	String popup = (request.getParameter("popup") == null) ? ""
 			: request.getParameter("popup");
 	String options = vvd + portCd + whfBndCd + "w" + whfRate;
 %> <input type="hidden" name="vvd" value="<%=vvd%>"> 
 	<input type="hidden" name="port_cd" value="<%=portCd%>"> 
 	<input type="hidden" name="whf_bnd_cd" value="<%=whfBndCd%>"> 
 	<input type="hidden" name="whf_rate" value="<%=whfRate%>"> 
 	<input type="hidden" name="options" value="<%=options%>"> 
 	<input type="hidden" name="popup" value="<%=popup%>"> 
 	<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;Wharfage Cargo Classification - Add
				Booking Data</td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 766;">
					<tr class="h23">
						<td width="250"><!-- : ( biz ) (S) -->
						<table border="0" style="width: 220; background-color: white;"
							class="grid2">
							<tr>
								<td width="100" class="tr2_head">B/L No.</td>
								<td width="125" colspan="2" class="input1"><input
									class="noinput1" type="text" style="width: 100%" name="frm_bl_no"
									maxlength="12" dataformat="ennum" value="<%=blNo%>"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Booking No.</td>
								<td width="" colspan="2" class="input1"><input
									class="noinput1" style="width: 100%; ime-mode: disabled"
									type="text" name="frm_bkg_no" maxlength="13" dataformat="ennum"
									value="<%=bkgNo%>"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">VVD</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_vvd" dataformat="ennum" maxlength="9"
									value="<%=vvd%>"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">POL</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%;ime-mode: disabled" name="frm_pol_cd" dataformat="engupnum"
									maxlength="5"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">POD</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%;ime-mode: disabled" name="frm_pod_cd" dataformat="engupnum"
									maxlength="5"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">POR</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%;ime-mode: disabled" name="frm_por_cd" dataformat="engupnum"
									maxlength="5"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">DEL</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%;ime-mode: disabled" name="frm_del_cd" dataformat="engupnum"
									maxlength="5"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Booking<br>
								Status</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_bkg_sts_cd" dataformat="engup"
									maxlength="1"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">R/D</td>
								<td width="" colspan="2" align="center"><input
									class="noinput" type="text" style="width: 40"
									name="frm_rcv_term_cd" dataformat="engup" maxlength="1"> <input
									class="noinput" type="text" style="width: 40" name="frm_de_term_cd"
									dataformat="engup" maxlength="1"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Package</td>
								<td width="" align="right"><input class="noinput"
									type="text" style="width: 90; text-align: right;"
									name="frm_pck_qty" dataformat="float" maxlength="16"
									onkeyup="PointNumberFixed()"></td>
								<td width=""><input class="noinput" type="text"
									style="width: 30" name="frm_pck_tp_cd" dataformat="engup"
									maxlength="2"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Tran Mode</td>
								<td width="" colspan="2"><select style="width: 100%;"
									class="input" name="frm_whf_bnd_cd">
									<option value="II">II</option>
									<option value="IT">IT</option>
									<option value="OO">OO</option>
									<option value="OT">OT</option>
								</select></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Weight</td>
								<td width="" align="right"><input class="noinput"
									type="text" style="width: 100%" name="frm_act_wgt"
									style="width:100%;text-align:right;" dataformat="float"
									maxlength="22" onkeyup="PointNumberFixed()"></td>
								<td width=""><input class="noinput" type="text"
									style="width: 40" name="frm_wgt_ut_cd" dataformat="engup"
									maxlength="3"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Measure</td>
								<td width="" align="right"><input class="noinput"
									type="text" style="width: 100%" name="frm_meas_qty"
									style="width:100%;text-align:right;" dataformat="float"
									maxlength="16" onkeyup="PointNumberFixed()"></td>
								<td width=""><input class="noinput" type="text"
									style="width: 40" name="frm_meas_ut_cd" dataformat="engup"
									maxlength="3"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Revenue</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_revenue"
									style="width:100%;text-align:right;" dataformat="float"
									maxlength="23" onkeyup="PointNumberFixed()"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Amount</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_amount"
									style="width:100%;text-align:right;" dataformat="float"
									maxlength="23" onkeyup="PointNumberFixed()"></td>
							</tr>
						</table>
						<!-- : ( biz ) (E) --></td>
						<td width="" valign="top"><!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) --> <!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_new1">New</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
									<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_add1">Row Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
									<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_del1">Row Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
								</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) --> <!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_new2">New</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
									<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_add2">Row Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
									<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_del2">Row Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									</td>
								</table>
								<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) --></td>
					</tr>
				</table>
				<!-- : ( Button : Grid ) (S) --> <!--  Button_Sub (S) --> <!-- Button_Sub (E) -->
				<!-- : ( Button : Grid ) (E) --></td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->
		

			<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td width="">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td width="">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
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
				<!--Button (E) --></td>
			</tr>
		</table>
		<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
		</form>
</body>
</html>