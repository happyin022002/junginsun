<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0093.jsp
*@FileTitle : Mis Use In & Out Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.event.EesLse0093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0093Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesLse0093Event)request.getAttribute("Event");
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
<title>Mis Use In & Out Inquiry</title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	</td></tr>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	<!-- : ( Search Options ) (S) -->
 <table class="search">
       		<tr><td class="bg">
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="120">Request OFC</td>
					<td width="323"><input type="text" name="rqst_ofc_cd" caption="Request OFC" style="width:80;text-align:center;ime-mode:disabled;" value="" class="input" maxlength="6" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">
						<table class="search_sm2" border="0" style="width:350;">
							<tr class="h23">
								<td width="120">&nbsp;Approval Case</td>
								<td width="60" class="stm"><input type="radio" name="mss_rqst_io_mod_cd" value="" class="trans" checked>All</td>
								<td width="80" class="stm"><input type="radio" name="mss_rqst_io_mod_cd" value="O" class="trans">MO</td>
								<td width="" class="stm"><input type="radio" name="mss_rqst_io_mod_cd" value="I" class="trans">MI</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="height_2"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="120">Request Duration</td>
					<td width="323">
						<input type="text" name="str_rqst_dt" caption="Request Duration" style="width:80;text-align:center;" class="input" value="" maxlength="8" dataformat="ymd" !cofield="end_rqst_dt"> ~
						<input type="text" name="end_rqst_dt" caption="Request Duration" style="width:80;text-align:center;" class="input" value="" maxlength="8" dataformat="ymd" !cofield="str_rqst_dt">
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle" dataformat="ymd">
					<td width="">
						<table class="search_sm2" border="0" style="width:350;">
							<tr class="h23">
								<td width="120">&nbsp;Approval Status</td>
								<td width="60" class="stm"><input type="radio" name="mss_usd_apro_flag" value="" class="trans" checked>All</td>
								<td width="80" class="stm"><input type="radio" name="mss_usd_apro_flag" value="R" class="trans">Request</td>
								<td width="" class="stm"><input type="radio" name="mss_usd_apro_flag" value="A" class="trans">Inspect</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

		</td></tr>
</table>
	<!--biz page (E)-->

		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg" style="height:425" valign="top">
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
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downExcel">Down&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    </td></tr>
		</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table></td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
	</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>