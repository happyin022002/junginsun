<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1508.jsp
*@FileTitle : JMS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.05.14 김상수
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.event.EsmBkg1508Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1508Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount = 0;					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList	= "";
	String pageRows	= "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1508Event)request.getAttribute("Event");
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
<title>JMS Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


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
			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_1 (S) -->
						<table class="search" border="0" style="width:979px;">
							<tr class="h23">
								<td><table class="search_ssm">
										<tr class="h23">
											<td><input type="radio" name="search_div" value="PORT" class="trans" checked>&nbsp;Port SKD&nbsp;
												<input type="radio" name="search_div" value="PUBLIC" class="trans">&nbsp;Public SKD&nbsp;&nbsp;</td>
										</tr>
									</table></td>
								<td>PORT&nbsp;<input type="text" name="port_cd" maxlength="5" style="ime-mode:disabled; width:60px;" class="input1" required caption="PORT" fullfill dataformat="engup">&nbsp;&nbsp;</td>
								<td width="430"><table class="search_ssm">
										<tr class="h23">
											<td><input type="radio" name="date_vvd_div" value="DATE" class="trans" checked>&nbsp;ETB
												<input type="text" name="date_fm" maxlength="10" style="ime-mode:disabled; width:75px;" class="input1" required caption="From Date" cofield="date_to" dataformat="ymd">&nbsp;~
												<input type="text" name="date_to" maxlength="10" style="ime-mode:disabled; width:75px;" class="input1" required caption="To Date" cofield="date_fm" dataformat="ymd">
												<img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">&nbsp;&nbsp;
												<input type="radio" name="date_vvd_div" value="VVD" class="trans">&nbsp;VVD&nbsp;
												<input type="text" name="vvd" maxlength="9" style="ime-mode:disabled; width:90px;" class="input" dataformat="engupnum">&nbsp;&nbsp;</td>
										</tr>
									</table></td>
								<td>Lane&nbsp;<input type="text" name="slan_cd" maxlength="9" style="ime-mode:disabled; width:40px;" class="input" dataformat="engupnum"></td>
								<td>OPR&nbsp;<input type="text" name="crr_cd" maxlength="9" style="ime-mode:disabled; width:40px;" class="input" dataformat="engupnum"></td>
							</tr>
						</table>
						<!-- biz_1 (E) -->
					</td>
				</tr>
			</table>


			<table class="height_8"><tr><td></td></tr></table>


			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_2 (S) -->
						<!-- Grid (1) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
							</tr>
						</table>
						<!-- Grid (1) (E) -->
						<!-- Grid_button (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_selectall">Select All</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td class="btn1_line"></td>
											<td>
												<table border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_rowadd">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn2_delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Grid_button (E) -->
						<!-- biz_2 (E) -->
					</td>
				</tr>
			</table>
			<!-- biz page (E) -->


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
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
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
											<td class="btn1_left">
											<td class="btn1" name="btn_save">Save</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_down_excel">Download Excel</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_upload_excel">Upload Excel</td>
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


			<!-- Grid (2) (S) -->
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject("sheet2");</script></td>
				</tr>
			</table>
			<!-- Grid (2) (E) -->
		</td>
	</tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
