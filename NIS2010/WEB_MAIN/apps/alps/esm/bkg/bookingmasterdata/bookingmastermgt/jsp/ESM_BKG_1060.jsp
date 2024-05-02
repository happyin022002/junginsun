
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_1060.jsp
	 *@FileTitle : Manual Booking Number Create
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.18
	 *@LastModifier : 민동진
	 *@LastVersion : 1.0
	 * 2009.09.18 민동진
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
	import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1060Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1060Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";

	Logger log = Logger
			.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterData");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1060Event) request.getAttribute("Event");
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
<title>Manual Booking Number Create</title>
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
<form name="form"><input type="hidden" name="f_cmd"> <input
	type="hidden" name="pagerows"> <!-- 개발자 작업	--> <input
	type="hidden" name="usr_id" value="<%=strUsr_id%>"> <input
	type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">


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
		<!--Page Title, Historical (E)--> <!--Button (S) --> <!--Button (E) -->

		<!--biz page (S)-->

		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="50">B.Office</td>
						<td width="150"><input type="text"
							style="width: 60; ime-mode: disabled" class="input1"
							name="cre_ofc_cd" maxlength="6" dataformat="engupnum" value=""></td>
						<td width="77">Agent Code</td>
						<td width="60"><input type="text"
							style="width: 40; ime-mode: disabled" class="input"
							name="chn_agn_cd" maxlength="2" dataformat="engupnum" value=""></td>
						<td width="48">User ID</td>
						<td width="100"><input type="text"
							style="width: 70; ime-mode: disabled" class="input"
							name="cre_usr_id" maxlength="20" dataformat="eng" value=""></td>
						<td width="24">Use</td>
						<td width="90"><select style="width: 50;" class="input"
							name="bkg_no_use_flg">
							<option value="%" selected>All</option>
							<option value="N">No</option>
							<option value="Y">Yes</option>
						</select></td>
						<td width="88">Creation Date</td>
						<td width="" class="stm"><input type="text"
							style="width: 80; ime-mode: disabled" class="input1"
							id="fm_cre_dt" name="fm_cre_dt" cofield="fm_cre_dt"
							maxlength="10" dataformat="ymd" value="">&nbsp;~&nbsp;<input
							type="text" style="width: 80; ime-mode: disabled" class="input1"
							id="to_cre_dt" name="to_cre_dt" cofield="to_cre_dt"
							maxlength="10" dataformat="ymd" value="">&nbsp;<img
							class="cursor" name="btn_calendar" src="img/btns_calendar.gif"
							width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
					
				</table>


				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- Tab (S) --> <!-- Tab (E) --> <!--biz page (S)-->

		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="110">Number of BKG(s)</td>
						<td width="90"><input type="text"
							style="width: 60; text-align: right" class="input1"
							id="no_of_bkg" name="no_of_bkg" maxlength="8" dataformat="int"
							value="0"></td>
						<td width="77">Agent Code</td>
						<td width="60"><input type="text" style="width: 40;"
							class="input1" id="act_chn_agn_cd" name="act_chn_agn_cd"
							maxlength="2" dataformat="engupnum" value=""></td>
						<!-- <td width="47">Office</td>
						<td width="100"><input type="text" style="width: 70;"
							class="input2" id="act_cre_ofc_cd" name="act_cre_ofc_cd"
							maxlength="6" dataformat="engupnum" value="<%=strOfc_cd%>"
							readonly="readonly"></td>
						<td width="54">User ID</td>
						<td width=""><input type="text"
							style="width: 80;" class="input2" name="act_cre_usr_id"
							maxlength="20" dataformat="eng" value="<%=strUsr_id%>"
							readonly="readonly"></td> -->
							
							<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_create">Create</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
					</tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!--  Button_Sub (S) --> <!-- Button_Sub (E) --></td>
			</tr>
		</table>
		<!--biz page (E)--> <!--Button (S) --> <!--Button (E) --> <!--Button (S) -->
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
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_down_excel">Down Excel</td>
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





<!-- Copyright (S) --> <!-- Copyright(E)--> <!-- 개발자 작업  끝 --></form>
</body>
</html>