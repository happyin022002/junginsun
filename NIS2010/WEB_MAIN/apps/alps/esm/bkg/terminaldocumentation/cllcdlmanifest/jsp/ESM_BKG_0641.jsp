<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0641.jsp
*@FileTitle : ESM_BKG_0641
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0641Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0641Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String toDate = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		Date to = new Date();
		toDate = DateTime.getDateString();
		toDate = toDate.replace(".","-");
		
		event = (EsmBkg0641Event)request.getAttribute("Event");
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
<title>ESM_BKG_0641</title>
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
	<!--top menu (S)-->
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
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">In Date</td>
					<td width="240"><input type="text" style="width:75;" class="input1" name="in_edi_rpt_msg_rcv_dt_start" maxlength="10" dataformat="ymd" value="" style="ime-mode:disabled">&nbsp;~&nbsp;<input type="text" style="width:75;" class="input1" maxlength="10" dataformat="ymd" name="in_edi_rpt_msg_rcv_dt_end" value="" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="110">Discharging Date</td>
					<td width="240"><input type="text" style="width:75;" class="input" name="in_cntr_ldis_dt_start" maxlength="10" dataformat="ymd" value="" style="ime-mode:disabled">&nbsp;~&nbsp;<input type="text" style="width:75;" class="input" maxlength="10" dataformat="ymd" name="in_cntr_ldis_dt_end" value="" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="30">Yard</td>
					<td width="80"><input type="text" style="width:65;" class="input" name="in_event_yd_cd" value="" maxlength="9" dataformat="uppernum" style="ime-mode:disabled"></td>
					<td width="25">POL</td>
					<td width="80"><input type="text" style="width:60;" class="input" name="in_pol_cd"  value="" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
					<td width="25">POD</td>
					<td width=""><input type="text" style="width:50;" class="input" name="in_pod_cd"  value="" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">VVD</td>
					<td width="240"><input type="text" style="width:97;" class="input" name="in_tml_vvd_id" maxlength="9" dataformat="uppernum" value="" style="ime-mode:disabled"></td>
					<td width="55">Call Sign</td>
					<td width="70"><input type="text" style="width:45;" class="input" name="in_call_sgn_no" maxlength="5" dataformat="uppernum" value="" style="ime-mode:disabled"></td>
					<td width="60">VSL Name</td>
					<td width="165"><input type="text" style="width:140;" class="input" name="in_vsl_nm" value="" dataformat="uppernum2" style="ime-mode:disabled"></td>
					<td width="95">Container No.</td>
					<td width=""><input type="text" style="width:100;" class="input" name="in_cntr_no" maxlength="11" dataformat="uppernum" value="" style="ime-mode:disabled"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				
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
				
				
				</td></tr>
			</table>
				
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
		</table>
	
</form>
</body>
</html>