<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1150.jsp
*@FileTitle : Shipper's Chassis Movement Management
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.30 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1150Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1150Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String form_day         = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		form_day  = DateTime.getDateString().replace(".","-");


		event = (EesCgm1150Event)request.getAttribute("Event");
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
<title>Shipper's Chassis Movement Management</title>
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
<!-- form name="form" onkeyup="ComKeyEnter('search');"-->
<form name="form"   >
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


		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="70">&nbsp;Chss No.</td>
					<td width="200"><input type="text" name="p_chss_no" caption="Chss No." style="width:100;text-align:center;ime-mode:disabled" dataformat="engup" maxlength="10" class="input"></td>
					<td width="45">Date</td>
					<td width="200">
					   <input type="text" name="p_mvmt_dt" caption="Date" style="width:80;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input" fullfill>
					   <img class="cursor" name="btns_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="40">LOC</td>
					<td width="200">
	                    <input type="text" name="p_loc_cd" caption="LOC" style="width:58;text-align:center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5" fullfill>
	                    <img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="50">Yard</td>
					<td width="">
						<input type="text" name="p_yd_cd" caption="Yard" style="width:80;text-align:center;ime-mode:disabled;" class="input" maxlength="7" dataformat="engup" fullfill>
						<img src="img/btns_search.gif" name="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

		</td></tr></table>
		<!-- 1 (E) -->


		<!-- 2 (S) -->
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">



			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid - 1 (E) -->	<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<!--
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete" id='btn_delete'>Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						-->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_downexcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->



			</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->


		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
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