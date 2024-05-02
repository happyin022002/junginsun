<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0806.jsp
*@FileTitle : Loading Confirmation by Shipper Preview And Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.06 김기종
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0806Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0806Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0806Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Loading Confirmation by Shipper Preview & Print</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<br>
<table border="0">
	<tr>
		<td width="25" rowspan="2"></td>
		<td><img src="img/alps/report_hanjin_logo.jpg"></td>
	</tr>
	<tr>
		<td>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="Save_OnClick()"><a href="#">Save</a></td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="Print_OnClick()"><a href="#">Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="First_OnClick()"><a href="#">First</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="Prev_OnClick()"><a href="#">Back</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="Next_OnClick()"><a href="#">Next</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="Last_OnClick()"><a href="#">Last</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="ZoomIn_OnClick()"><a href="#">Zoom In(+)</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="ZoomOut_OnClick()"><a href="#">Zoom Out(-)</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="" OnClick="Close_OnClick()"><a href="#">Close</td>
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
<script language="javascript">comRdObject('Rdviewer');</script>

<!-- 개발자 작업  끝 -->
</form>
<SCRIPT ID="clientEventHandlersJS" LANGUAGE="JavaScript">

	img_cnt = 9;
	first_img =new Array(img_cnt + 1);
	for (var i = 1; i<=img_cnt; i++) {first_img[i] = new Image() }
	first_img[1].src = "/hanjin/img/menu/save_1.gif"
	first_img[2].src = "/hanjin/img/menu/print_1.gif"
	first_img[3].src = "/hanjin/img/menu/first_1.gif"
	first_img[4].src = "/hanjin/img/menu/back_1.gif"
	first_img[5].src = "/hanjin/img/menu/next_1.gif"
	first_img[6].src = "/hanjin/img/menu/last_1.gif"
	first_img[7].src = "/hanjin/img/menu/zoomin_1.gif"
	first_img[8].src = "/hanjin/img/menu/zoomout_1.gif"
	first_img[9].src = "/hanjin/img/menu/close_1.gif"

	over_img =new Array(img_cnt + 1);
	for (var i = 1; i<=img_cnt; i++) { over_img[i] = new Image() }
	over_img[1].src = "/hanjin/img/menu/save_2.gif"
	over_img[2].src = "/hanjin/img/menu/print_2.gif"
	over_img[3].src = "/hanjin/img/menu/first_2.gif"
	over_img[4].src = "/hanjin/img/menu/back_2.gif"
	over_img[5].src = "/hanjin/img/menu/next_2.gif"
	over_img[6].src = "/hanjin/img/menu/last_2.gif"
	over_img[7].src = "/hanjin/img/menu/zoomin_2.gif"
	over_img[8].src = "/hanjin/img/menu/zoomout_2.gif"
	over_img[9].src = "/hanjin/img/menu/close_2.gif"

	var Rdviewer	=	rdObjects[0];
	function msover(num) {
		document.images[num].src = over_img[num].src
	}

	function msout(num) {
		document.images[num].src =first_img[num].src
	}

	function Save_OnClick() {
		Rdviewer.SaveAsDialog();
	}

	function Print_OnClick() {
		Rdviewer.PrintDialog();
	}

	function First_OnClick() {
		Rdviewer.FirstPage();
	}

	function Prev_OnClick() {
		Rdviewer.PrevPage();
	}

	function Next_OnClick() {
		Rdviewer.NextPage();
	}

	function Last_OnClick() {
		Rdviewer.LastPage();
	}

	function ZoomIn_OnClick() {
		Rdviewer.ZoomIn();
	}

	function ZoomOut_OnClick() {
		Rdviewer.ZoomOut();
	}

	function Close_OnClick() {
		window.close();

	}
</SCRIPT>


</body>
</html>