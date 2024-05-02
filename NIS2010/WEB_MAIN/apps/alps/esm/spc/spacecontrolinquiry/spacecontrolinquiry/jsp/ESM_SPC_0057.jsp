<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SPC_0057.jsp
*@FileTitle      : Space Utilization Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.10.30
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발
* 2014.10.10 Arie IM [CHM-201432357] Space utilization inquiry 메뉴 로직 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0057Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0057Event  event		= null;			// PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// 서버에서 발생한 에러
	String strErrMsg = "";						// 에러메세지
	int rowCount	 = 0;						// DB ResultSet 리스트의 건수
	
	String successFlag	= "";
	String codeList  	= "";
	String pageRows		= "100";
	
	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log 			= Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmSpc0057Event)request.getAttribute("Event");
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
<title>Space Utilization Inquiry</title>
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
<input type="hidden" name="login_user_id" value= "<%=strUsr_id%>">


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
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcelall" id="btn_downexcelall">Down Excel All</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr>
				</table>
			
			</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
    	
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="50"><img class="nostar">Date</td>
					<td width="235">
						<input class="input1" type="text" style="width:72;ime-mode:disabled;" value="" name="sDate" maxlength="8" onkeypress="checkDateFormat();" onfocus="initDate();" onchange="checkDate();" onblur="convertDateFnc();">
						&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" name="btn_calendar1" align="absmiddle">
						&nbsp;~&nbsp;
						<input class="input1" type="text" style="width:72;ime-mode:disabled;" value="" name="eDate" maxlength="8" onkeypress="checkDateFormat();" onfocus="initDate();" onchange="checkDate();" onblur="convertDateFnc();">
						&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" name="btn_calendar2" align="absmiddle">
					</td>
					<td width="155">
						<input type="radio" class="trans" name="view_type11" value="P" checked>by Port
						<input type="radio" class="trans" name="view_type11" value="L">by Lane
					</td>
					<td width="40"><img class="nostar">POL</td>
					<td width="85">
						<input class="input1" name="pol_cd" type="text" maxlength="5" style="width:50;ime-mode:disabled;" value="" onkeypress="eventKeyChangeChar(UPPER_CASE)">
						&nbsp;<img class="cursor" name="btn_popup_pol_cd" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					<td width="15">~</td>
					<td width="30">POD</td>
					<td width="95">
						<input class="input1" name="pod_cd" type="text" maxlength="5" style="width:50;ime-mode:disabled;" value="" onkeypress="eventKeyChangeChar(UPPER_CASE)">
						&nbsp;<img class="cursor" name="btn_popup_pod_cd" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="80"><img class="nostar">Lane Code</td>
					<td>
						<input class="input4" name="lane" type="text" maxlength="5" style="width:50;ime-mode:disabled;" value="" onkeypress="eventKeyChangeChar(UPPER_CASE)">
						&nbsp;<img class="cursor" name="btn_popup_lane_cd" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
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
				<table width="100%" id="mainTable1">
					<tr><td>
							<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( grid ) (E) -->
				
				<table width="100%">
					<tr> <td height="30">* Lane selected within 30 days, unless within 14 days.</td>
					 </tr>
				</table>
		
		</td></tr>
		
		</table>

</td></tr>

</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>