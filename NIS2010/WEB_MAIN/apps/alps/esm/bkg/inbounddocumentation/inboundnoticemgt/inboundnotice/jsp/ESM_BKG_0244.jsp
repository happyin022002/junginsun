<%
/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ESM_BKG_0244.jsp
 *@FileTitle :  Also Notify Setup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.16
 *@LastModifier : 김수현
 *@LastVersion : 1.0
 * 2016.02.03 김수현
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0244Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0244Event event 	  = null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//서버에서 발생한 에러
	String strErrMsg 		  = ""; 	//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");

	String strUsr_id = "";


	// 다른화면에서 부터 요청받았을 때 처리할 변수 목록 (끝)
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();

		event = (EsmBkg0244Event) request.getAttribute("Event");
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
<title>Welcome to Alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){
		loadPage();
	}

</script>
</head>
<body  onLoad="setupPage();">

<form name="form">

<!-- hidden값 정의 -->
<input type="hidden" name="f_cmd" />
<input type="hidden" name="usr_id"     value="<%=strUsr_id%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->

			<!--biz page (S)-->
			<table class="search">
				<tr>
					<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="75">S/C Number </td>
								<td width="120"><input type="text" style="width:100px;" name="sc_no" class="input" maxlength="20"></td>
								<td width="95">Customer Code</td>
								<td width="100"><input type="text" style="width:80px;" name="antfy_cust_cd" class="input" maxlength="8"></td>
								<td width="30">POD</td>
								<td width=""><input type="text" style="width:50px;" name="pod_cd" class="input" maxlength="5"></td>
							</tr>
						</table>

						<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr>
						       	<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				    	<!-- Button_Sub (E) -->

					</td>
				</tr>
			</table>
			<!--biz page (E)-->

			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button (E) -->

		</td>
	</tr>
</table>

<!-- Grid BG Box  (S) -->
<!--biz page (E)-->
<table class="height_10"><tr><td colspan="8"></td></tr></table>

</form>
</body>
</html>