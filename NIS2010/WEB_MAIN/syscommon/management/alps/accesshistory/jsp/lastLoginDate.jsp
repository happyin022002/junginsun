<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ACCESSHISTORY.jsp
*@FileTitle : AccessHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.02.01 김경범
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
<%@ page import="com.hanjin.syscommon.management.alps.accesshistory.event.LastLoginDateEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	LastLoginDateEvent  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccessHistory.AccessHistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (LastLoginDateEvent)request.getAttribute("Event");
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
<title>AccessHistory</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	    form.dateFrom.value = ComGetDateAdd(null,"D",-7);
	    form.dateTo.value = ComGetDateAdd(null,"D",0);
	}
    function popCal(calObj){
    	 //달력 열기
    	var cal = new ComCalendar();
    	cal.select(calObj, 'yyyy-MM-dd');
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

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="120">Last Login Date</td>
					<td width="300">
						<input type="text" name="dateFrom" dataformat="ymd" maxlength="8" size="10">
						<img src="img/btns_calendar.gif" align="absmiddle" style="cursor:hand" onClick="popCal(dateFrom);">
						&nbsp;~&nbsp;
						<input type="text" name="dateTo" dataformat="ymd" maxlength="8" size="10">
						<img src="img/btns_calendar.gif" align="absmiddle" style="cursor:hand" onClick="popCal(dateTo);">
					</td>
					<td width="140">Use Flag</td>
					<td><select name="useFlg" style="width:80;" class="input1">
						<option value=""selected>All</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
						</select></td>
					<td width="80">User ID</td>
					<td width="150"><input name="usrId" type="text" style="width:100;" class="input"></td>
				</tr>
				<tr class="h23">
					<td>Program No.</td>
					<td><input name="pgmNo" dataformat="engup" type="text" style="width:100;" class="input" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');" onmouseover="this.title = this.value;">&nbsp;<img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pgm_no"></td>
					<td>RHQ</td>
					<td><select name="rhq" style="width:80;" class="input1">
						<option value=""selected>All</option>
						<option value="SELHO">SELHO</option>
						<option value="HAMUR">HAMUR</option>
						<option value="SINWA">SINWA</option>
						<option value="SHAAS">SHAAS</option>
						<option value="NYCNA">NYCNA</option>
						</select>
					</td>
					<td>Office Code</td>
					<td>
						<input type="text" style="width:80;" dataformat="engup" class="input" name= "ofcCd" value="" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');">&nbsp;<img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ofc_cd">
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

		</td></tr></table>
		<!-- 1 (E) -->


		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>