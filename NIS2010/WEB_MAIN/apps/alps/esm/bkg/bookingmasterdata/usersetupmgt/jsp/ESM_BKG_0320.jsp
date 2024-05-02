
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0320.jsp
	 *@FileTitle : Internet O/BL Release Authority
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>

<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1008Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1008Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger
			.getLogger("com.hanjin.apps.CustomsDeclaration.CndManifestListDownload");
	String screenName = ""; 
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1008Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
	function setActualCustomer(p_cust_cnt_cd){
	   alert(p_cust_cnt_cd);
		form.cust_cnt_cd.value= p_cust_cnt_cd;
	//	form.cust_seq.value= p_cust_seq;
	}	
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="ch_usr_id">
<!-- 개발자 작업	-->
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
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

		<table class="search">
			<tr>
				<td class="bg">

				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="55">User ID</td>
						<td width="120"><input type="text" name="usr_id" style="width: 80" value="" class="input" maxlength='20' dataformat='engupnum' style="ime-mode:disabled"></td>
						<td width="65">User Name</td>
						<td width="120"><input type="text" name="usr_nm" style="width: 80" value="" class="input" maxlength='20' dataformat='engupnum' style="ime-mode:disabled"></td>
						<td width="40">Office</td>
						<td width=""><input type="text" name="ofc_cd" style="width: 65" value="" class="input" maxlength='6'  dataformat="engup"  style="ime-mode:disabled"></td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
								
				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) --> <!--  Button_Sub (S) -->
				<% if (screenName.indexOf("Q") < 0){ %>
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowDelete">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>

							</tr>
						</table>
						</td>
					</tr>
				</table>
				<% } %>
				<!-- Button_Sub (E) --></td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) --></td>
	</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
		<% if (screenName.indexOf("Q") < 0){ %>
				<td class="btn1_line"></td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_Save">Save</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
		<% } %>				
				<td>
				<table width="" border="0" cellpadding="0" cellspacing="0"
					class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_DownExcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!--Button (E) --> <!--biz page (E)-->
<!-- 개발자 작업  끝 --></form>
</body>
</html>