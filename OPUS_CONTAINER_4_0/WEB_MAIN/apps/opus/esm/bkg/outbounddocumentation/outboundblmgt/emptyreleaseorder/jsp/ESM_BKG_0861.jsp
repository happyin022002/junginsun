<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0861.jsp
*@FileTitle : Empty Container Release Order(RD)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.16 최도순
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event.EsmBkg0861Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0861Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps..OutboundBLMgt.EmptyReleaseOrder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0861Event)request.getAttribute("Event");
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
<title>Empty Container Release Order</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		var ClientWidth = document.body.clientWidth ;
		var ClientHeight = document.body.clientHeight - 100 ;
		//document.all.rdTable.width = ClientWidth ;
		//document.all.rdTable.height = ClientHeight ;
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<br>
<table border="0">
	<tr>
		<td width="25" rowspan="2"></td>
		<td><img src="/opuscntr/img/opus/report_opus_logo.jpg"></td>
	</tr>
	<tr>
		<td>
		<link href="/opuscntr/css/opus_contents.css" rel="stylesheet" type="text/css">
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
<table id="rdTable" width="100%" height="100%">
	<tr>
		<td><script language="javascript">
		comRdObject('report1');
//comRdObjectPopup("report1");
</script></td>
	</tr>
</table>
<br>
<br>
<SCRIPT ID="clientEventHandlersJS" LANGUAGE="JavaScript">

	img_cnt = 9;
	first_img =new Array(img_cnt + 1);
	for (var i = 1; i<=img_cnt; i++) {first_img[i] = new Image() }
	first_img[1].src = "/opuscntr/img/menu/save_1.gif"
	first_img[2].src = "/opuscntr/img/menu/print_1.gif"
	first_img[3].src = "/opuscntr/img/menu/first_1.gif"
	first_img[4].src = "/opuscntr/img/menu/back_1.gif"
	first_img[5].src = "/opuscntr/img/menu/next_1.gif"
	first_img[6].src = "/opuscntr/img/menu/last_1.gif"
	first_img[7].src = "/opuscntr/img/menu/zoomin_1.gif"
	first_img[8].src = "/opuscntr/img/menu/zoomout_1.gif"
	first_img[9].src = "/opuscntr/img/menu/close_1.gif"

	over_img =new Array(img_cnt + 1);
	for (var i = 1; i<=img_cnt; i++) { over_img[i] = new Image() }
	over_img[1].src = "/opuscntr/img/menu/save_2.gif"
	over_img[2].src = "/opuscntr/img/menu/print_2.gif"
	over_img[3].src = "/opuscntr/img/menu/first_2.gif"
	over_img[4].src = "/opuscntr/img/menu/back_2.gif"
	over_img[5].src = "/opuscntr/img/menu/next_2.gif"
	over_img[6].src = "/opuscntr/img/menu/last_2.gif"
	over_img[7].src = "/opuscntr/img/menu/zoomin_2.gif"
	over_img[8].src = "/opuscntr/img/menu/zoomout_2.gif"
	over_img[9].src = "/opuscntr/img/menu/close_2.gif"

	function msover(num) {
		document.images[num].src = over_img[num].src
	}

	function msout(num) {
		document.images[num].src =first_img[num].src
	}

	function Save_OnClick() {
		report1.SaveAsDialog();
	}

	function Print_OnClick() {
		report1.PrintDialog();
	}

	function First_OnClick() {
		report1.FirstPage();
	}

	function Prev_OnClick() {
		report1.PrevPage();
	}

	function Next_OnClick() {
		report1.NextPage();
	}

	function Last_OnClick() {
		report1.LastPage();
	}

	function ZoomIn_OnClick() {
		report1.ZoomIn();
	}

	function ZoomOut_OnClick() {
		report1.ZoomOut();
	}

	function Close_OnClick() {
		window.close();
	}
</SCRIPT>
<!-- 개발자 작업  끝 -->
</body>
</html>