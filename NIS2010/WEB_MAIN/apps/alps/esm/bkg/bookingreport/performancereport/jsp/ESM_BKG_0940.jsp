
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0940.jsp
	 *@FileTitle : I/B DOC Performance Report
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
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0940Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0940Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String cnt_cd = "";
	String strOfc_cd = "";
	
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cnt_cd = account.getCnt_cd();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0940Event) request.getAttribute("Event");
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
</script>
</head>

<body onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="ch_usr_id">
	<input type="hidden" name="curr_page"      value="1">
	<input type="hidden" name="rows_per_page"  value="50">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
		<!--Page Title, Historical (S)-->
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

			<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Duration(ETA)</td>
					<td width="260"><input type="text" style="width:70;" class="input1" value=""  maxlength='10' dataformat="ymd" name="eta_from_dt">&nbsp;&nbsp;-&nbsp;&nbsp;
						              <input type="text" style="width:70;" class="input1" value=""  maxlength='10' dataformat="ymd" name="eta_to_dt">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_period_date"></td>
					<td width="55">Country</td>
					<td width="60"><input type="text" style="width:30;ime-mode:disabled" class="input1" value="<%=cnt_cd%>" name="cntr_cd" maxlength='2' dataformat='engup'></td>
					<td width="40">Office</td>
					<td width="90"><input type="text" style="width:50;ime-mode:disabled" class="input1" value="<%=strOfc_cd%>" name="ofc_cd" maxlength='6' dataformat='engup'></td>
					<td width="50">Staff ID</td>
					<td width="90"><input type="text" style="width:60;ime-mode:disabled" class="input" value="" name="staff_id" maxlength='20' dataformat='engnum'></td>
					<td width="40">LANE</td>
					<td width="90"><input type="text" style="width:40;ime-mode:disabled" class="input" value="" name="lane_cd" maxlength='3' dataformat='engup'></td>
					<td width="30">VVD</td>
					<td width=""><input type="text" style="width:80;ime-mode:disabled" class="input" value="" name="vvd_cd" maxlength='9' dataformat='engupnum'></td>
				</tr>
				</table> 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">POD</td>
					<td width="130"><input type="text" style="width:50;ime-mode:disabled" class="input" value="" name="pod_cd" maxlength='5' dataformat='engupnum'></td>
					<td width="25">DEL</td>
					<td width="310"><input type="text" style="width:50;ime-mode:disabled" class="input" value="" name="del_cd" maxlength='5' dataformat='engupnum'></td>
					<td width="" align="right">
						<table class="search_sm2" border="0" style="width:330;"> 
							<tr class="h23">
							<td width="110">Duration Option</td>
							<td class="stm"><input type="radio" value="W" class="trans" name="dura_cd" checked>&nbsp;Weekly Base&nbsp;&nbsp;&nbsp;<input type="radio" value="P" class="trans" name="dura_cd">&nbsp;Period Base</td>
							</tr>
						</table> 
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->		
			

				
				<table class="line_bluedot"><tr><td></td></tr></table>	
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				</td>
			</tr>
		</table>
		
			</td>
		</tr>
	</table>		

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; ">
			<tr>
				<td class="btn1_bg">
				
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table width="72" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_New">New</td>
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
										<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
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
<!-- 개발자 작업  끝 -->
</form>
<form name="form2" method="POST">
	<input type="hidden" name="message"> 
</form>	
</body>
</html>