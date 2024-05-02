	
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0066.jsp
	 *@FileTitle : B/L Processing Report
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0066Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0066Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0066Event) request.getAttribute("Event");
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
						<td width="37">Period</td>
						<td width="255"><input type="text" style="width:80;" class="input1" value=""  maxlength='10' dataformat="ymd" name="period_from_dt">&nbsp;&nbsp;-&nbsp;&nbsp;
						                <input type="text" style="width:80;" class="input1" value=""  maxlength='10' dataformat="ymd" name="period_to_dt">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_period_date"></td>
						<td>VVD</td>
						<td><input type="text" style="width:90;ime-mode:disabled" value="" name="vvd_cd" maxlength='9' dataformat='engupnum' class="input"></td>
						<td>BKG No.</td>
						<td><input type="text" style="width:110;ime-mode:disabled" value="" name="bkg_no" maxlength="13" dataformat='engupnum' class="input"></td>
						<td>POL</td>
						<td><input type="text" style="width:60;ime-mode:disabled" value="" name="pol_cd" maxlength='5' dataformat='engup' class="input"></td>
						<td>POD</td>
						<td><input type="text" style="width:60;ime-mode:disabled" value="" name="pod_cd" maxlength='5' dataformat='engup' class="input"></td>
						<td>Doc Part</td>
						<td align ="right"><script language="javascript">ComComboObject('doc_part', 1, 100, '');</script></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="150">Performance by Queue</td>
						<td width="146"><script language="javascript">ComComboObject('pfm_by_queue_cd', 1, 93, '');</script>
						<!--<select style="width:93;" class="input1" ><option value="0" selected>D/C ALL</option></select>--></td>
						<td width="150">Performance by PIC</td>
						<td width="160"><input type="text" style="width:110;" value="" name="pfm_by_pic" maxlength='20' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
						<td width="90">BKG OFC</td>
						<td width="123"><input type="text" style="width:60;ime-mode:disabled" value=""  name="bkg_ofc_cd" maxlength="6" dataformat='engup' class="input"></td>
						<td width="75">S/R Kind</td>
							<td align ="right"><script language="javascript">ComComboObject('sr_knd_cd', 1, 100, '');</script>
						<!--<select style="width:100;"><option value="0" selected>ALL</option></select>--></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			

				
				<table class="line_bluedot"><tr><td></td></tr></table>	
					<table><tr><td height="10"></td></tr></table>
			
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
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
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