<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0027.jsp
*@FileTitle : Container Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.26 민정호
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
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentLeaseHistory.LeaseSublease");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0027Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
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
<input type="hidden" name="evnt_dt1">
<input type="hidden" name="evnt_dt2">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->	
	<!--biz page (S)-->		
		<!-- Grid BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg" style="height:515;" valign="top">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="45">Period</td>
					<td width="270"><input type="text" style="width:60" class="input1" value="" maxlength="7" name="evnt_dt11" dataformat="ym" onfocus='domFunFocusDel(this)' style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;<input type="text" style="width:60" class="input1" value="" maxlength="7" name="evnt_dt22" dataformat="ym" onfocus='domFunFocusDel(this)' style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="45">Location</td>
					<td width="61"><select style="width:60;" class="input1" name="loc_tp_cd">
						<option value="A" selected>All</option>
						<option value="R">RCC</option>
						<option value="L">LCC</option>
						<option value="S">SCC</option>
						</select>
					<td width="120"><input type="text" style="width:60;" value="" name="loc_cd" class="input" maxlength="5" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ComOpenPopupWithTargetLoc"></td>
					<td width=""><input type="checkbox" value="N" class="trans" name="ls_flg">Latest Lost Only</td>
				</tr> 
			</table>
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
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="Down_Excel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="New">New</td>
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