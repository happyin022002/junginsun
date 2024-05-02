<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0062.jsp
*@FileTitle : TEU Range Target
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event.EsmFms0062Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0062Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
//	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutFleetManagement.TCharterStandardPrimeCost");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0062Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TEU Range Target</title>
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
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
	<table class="search"> 
      	<tr><td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">TEU Range - Master</td></tr>
			</table>
			<table class="search" border="0" style="width:978;"> 
			<tr class="h23">
				<td width="40">&nbsp;&nbsp;Year</td>   
				<td><input type="text" style="width:40;" class="input1" name="rngYr" maxlength="4" dataformat="yyyy" required fullfill caption="Year" value="">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="rng_yr_cal" width="19" height="20" alt="" border="0" align="absmiddle"></td>
			</tr>
			
			</table>
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<!--  biz_2  (S) -->
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">TEU Range - Detail</td></tr>
			</table>
			<!-- Grid  (S) -->
			<table width="100%" class="search"   id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
			</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
     				<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_add">Row&nbsp;Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_ins">Row&nbsp;Ins</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_del">Row&nbsp;Del</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</table>
			</td></tr>
			</table>
    		<!-- Button_Sub (E) -->
			<!--  biz_2   (E) -->
			</td></tr>
	</table>
</td></tr>
</table>
	<!--biz page (E)-->
	
	
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
<tr><td class="btn1_bg">
    <table border="0" cellpadding="0" cellspacing="0">
    <tr>
	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_retrieve">Retrieve</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left">
			<td class="btn1" name="btn_new">New</td>
			<td class="btn1_right">
			</tr>
		</table></td>
		<!--<td class="btn1_line"></td>-->
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_save">Save</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_dataerase">Data&nbsp;Erase</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>
		
		<!--------------------------------------------------------------------------------->
		<!--<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_0012">0012</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_0021">0021</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>-->
		<!--------------------------------------------------------------------------------->
		
	</tr>
	</table>
</td></tr>
</table>
    <!--Button (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>