<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_PPL_0001.jsp
*@FileTitle : paperless
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.09.01 차상영
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
<%@ page import="com.hanjin.bizcommon.paperless.event.ComPpl0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComPpl0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.bizcommon.BizCommonSC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (ComPpl0001Event)request.getAttribute("Event");
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
<title>paperless</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="90"><img class="nostar">Booking No.</td>
					<td width="230">
						<input type="text" style="width:200;ime-mode:disabled;" name="bkg_no" class="input1" value="" maxlength="13" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
					</td>
					<td width="60">T/VVD</td>
					<td width="140">
						<input type="text" style="width:100;ime-mode:disabled;" name="t_vvd" value="" maxlength="9"  onKeyPress="ComKeyOnlyAlphabet('uppernum');">
					</td>
					<td width="50">POL</td>
					<td width="140">
						<input type="text" style="width:80;ime-mode:disabled;" name="pol_cd" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper');">
					</td>
					<td width="50">POD</td>
					<td>
						<input type="text" style="width:80;ime-mode:disabled;" name="pod_cd" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper');">
					</td>
				</tr>
				<tr class="h23">
					<td><img class="nostar">Period</td>
					<td>
						<input name="fr_cre_dt" type="text" style="width:80;text-align:center;" class="input1" value="" dataformat="ymd" required>&nbsp;~&nbsp;<input name="to_cre_dt" type="text" style="width:80;text-align:center;" class="input1" value="" maxlength="10" dataformat="ymd" required>&nbsp;<img src="img/btns_calendar.gif" class="cursor" align="absmiddle" name="btn_calendar" valign="bottom">
					</td>
					<td>Office</td>
					<td>
						<input type="text" style="width:100;ime-mode:disabled;" name="ofc_cd" value="" maxlength="6" onKeyPress="ComKeyOnlyAlphabet('upper');">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_office">
					</td>
					<td>Customer</td>
					<td>
						<input type="text" style="width:80;ime-mode:disabled;" name="shpr" value="">
					</td>
					<td>Lane</td>
					<td>
						<input type="text" style="width:80;ime-mode:disabled;" name="slan_cd" value="" maxlength="3" onKeyPress="ComKeyOnlyAlphabet('upper');">
					</td>
				</tr>
				<tr class="h23">
					<td><img class="nostar">Type</td>
					<td>
						<script language="javascript">ComComboObject('pprl_eml_rcv_cd',1,90, 1, 0, 0, 'true');</script>
					</td>
					<td>E-Mail</td>
					<td>
						<input type="text" style="width:170;ime-mode:disabled;" name="sndr_eml" value="">
					</td>
					<td>User ID</td>					
					<td colspan="3">
						<input type="text" style="width:80;ime-mode:disabled;" name="snd_usr_id" value="">
					</td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

			<!-- : ( grid ) (S) -->
			<table  border="0" class="search">
				<tr><td>
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>
				</td></tr>
			</table>
			<!-- : ( grid ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->
</form>

<form name="form1" method="post">
</form>
<!-- 개발자 작업  끝 -->
</body>
</html>