
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0700.jsp
	 *@FileTitle : CAF Adjustment
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.03
	 *@LastModifier : 이진서
	 *@LastVersion : 1.0
	 * 2009.07.03 이진서
	 * 1.0 Creation
	 * 2013.04.19 김진주 [CHM-201323704] [Charge Adjustment] 팝업 개발 및 오토레이팅 연계 요청
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
	import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0700Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0700Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0700Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CAF Adjustment</title>
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
<input type="hidden" name="caf_sum">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->

		<!-- : ( Title ) (S) -->
		<!-- : ( Title ) (E) --> <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Grid frame (S) -->
				<table width="100%" class="search">
					<tr>
						<td width="50%"><!-- Grid  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) --> <!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg" >
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_add">Row Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>

										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_del">Row Delete</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>

									</tr>
								</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) --></td>
						<td width="25%" style="padding-left: 10;" valign="top"><!-- CAF Percentage (S) -->
						<table border="0" style="width: 100%; background-color: white;"
							class="grid2">
							<tr class="tr2_head">
								<td>CAF Percentage</td>
							</tr>
							<tr>
								<td><input type="text" style="width: 100%; text-align: right" class="noinput" name="caf_percentage" dataformat="float"  maxlength="5" value="" ></td>
							</tr>
						</table>
						<!-- CAF Percentage (E) --></td>
						<td width="25%" style="padding-left: 10;" valign="top"><!-- CAF Amount (S) -->
						<table border="0" style="width: 100%; background-color: white;"
							class="grid2">
							<tr class="tr2_head">
								<td colspan="2">CAF Amount</td>
							</tr>
							<tr>
								<td width="40%" align="center" class="input2"><input
									type="text" style="width: 100%; text-align: center"
									class="noinput2" name="caf_currency" value='' readonly>
								</td>
								<td align="right" class="input2"><input type="text"
									style="width: 100%; text-align: center" class="noinput2"
									name="caf_amount" value='' readonly></td>
							</tr>
						</table>
						<!-- CAF Amount (E) --></td>
					</tr>
				</table>
				<!-- Grid frame (S) --></td>
			</tr>
		</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_calc">Calc</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_apply">Apply</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right">
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
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>