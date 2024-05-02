<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0065.jsp
*@FileTitle : VSL SKD history Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.29 Jung Jinwoo
* 1.0 Creation
*
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.10.26 김민아 [CHM-201114112-01] VSL SKD History Inquiry 화면 로직 변경
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0065Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0065Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VSKCommon.VSKCodeFinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0065Event)request.getAttribute("Event");
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
<title>Port Code Inquiry</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="1000">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="loc_cd">
<input type="hidden" name="inc_del_vsl" value="Y">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
	<table class="search"> 
    <tr><td class="bg">
		<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
			<td width="45">Period</td>
			<td width="230"><input type="text" name="fm_dt" style="width:80;text-align:center;" class="input" value="" maxlength="8" size="10">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:80;text-align:center;" class="input" value="" maxlength="8" size="10">&nbsp;<img class="cursor" name="btn_period" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
			<td width="30">VVD</td>
			<td width="170"><input type="text" name="vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="4">&nbsp;<input type="text" name="skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="4">&nbsp;<input type="text" name="skd_dir_cd" style="width:22;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="1">&nbsp;<img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
			<td width="70">Lane Code</td>
			<td width="100"><input type="text" name="vsl_slan_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="3">&nbsp;<img class="cursor" name="btn_slan_cd" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
			<td width="35">Port</td>
			<td width=""><input type="text" name="vps_port_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5">&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td> 
		</tr>
		</table>
		<!--  biz_1   (E) -->
	</td></tr>
	</table>
	<!--biz page (E)-->
			
	<table class="height_8"><tr><td></td></tr></table>
	
	<!-- Tab ) (S) -->
   	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
    <tr><td width="100%">
		<script language="javascript">ComTabObject('tab1');</script>
	</td></tr>
	</table>
	<!-- Tab ) (E) -->
		
<!--TAB Coastal SKD (S) -->
<div id="tabLayer" style="display:inline">
		<!--  biz_2  (S) -->
		<!-- Grid  (S) -->
		<table class="search"> 
    	<tr><td class="bg">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('t1sheet1');</script>
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
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_t1Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_t1New">New</td>
						<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_t1DownExcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		<!--  biz_2   (E) -->
	
</div>
<!--TAB Coastal SKD (E) -->

<!--TAB Actual SKD (S) -->
<div id="tabLayer" style="display:none">
	<table class="search"> 
    <tr><td class="bg">
		<!-- Grid  (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('t2sheet1');</script>
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
					<td class="btn1" name="btn_t2Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_t2New">New</td>
						<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_t2DownExcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		<!--  biz_2   (E) -->
</div>
<!--TAB Actual SKD (E) -->

	</td></tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" style="display: none">
	<tr>
		<td class="btn1_left"></td>
		<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
		<td class="btn1_right"></td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
