<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0020.jsp
*@FileTitle : VSL SKD Inquiry by Port to Port
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.23 Jung Jinwoo
* 1.0 Creation
*
* History
* 2011.04.15 진마리아 padding-right 설정
* 2011.07.04 진마리아 CHM-201112011-01 VSL SKD Inquiry by Port to Port 로직 수정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (VopVsk0020Event)request.getAttribute("Event");
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
<input type="hidden" name="pagerows">
<input type="hidden" name="loc_cd">
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
					<td width="50">Period</td>
					<td width="230"><input type="text" name="fm_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" name="to_dt" dataformat="ymd" style="width:75;text-align:center;" class="input1" value="" maxlength="8" size="10">&nbsp;<img class="cursor" name="btn_period" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="30">POL</td>
					<td width="100"><input type="text" name="pol_port" style="width:50;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_pol" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~</td>
					<td width="30">POD</td>
					<td width="120"><input type="text" name="pod_port" style="width:50;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_pod" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="70">Lane Code</td>
					<td width="100" ><input type="text" name="vsl_slan_cd" style="width:40;text-align:center;ime-mode:disabled;" value="" maxlength="3" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_lane_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width=""><input type="checkbox" name="inc_vir_pol" class="trans" value="Y">&nbsp;Include Virtual POL</td>
					</tr>
				
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
						</table> 
						<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
				
				
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
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
