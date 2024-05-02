<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0517.jsp
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.10 김종옥
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.event.VopVsk0517Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>
<%
	VopVsk0517Event  	event 				= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException   	= null;		//서버에서 발생한 에러
	String 				strErrMsg 			= "";		//에러메세지
	int 				rowCount	 		= 0;		//DB ResultSet 리스트의 건수

	String 				successFlag 		= "";
	String 				codeList  			= "";
	String 				pageRows  			= "100";

	String 				strUsr_id			= "";
	String 				strUsr_nm			= "";
	Logger 				log 				= Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.VesselOperationSupportMonitoring");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopVsk0517Event)request.getAttribute("Event");
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
<title>VOSI Update Monitoring</title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:505" valign="top">	
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<!-- td width="60">CTRL HQ</td>
					<td width="130"><select style="width:80;" class="input1">
						<option value="0" selected></option>
						<option value="1"></option>
						</select></td>
					<td width="35">Port</td>
					<td width="610"><input type="text" style="width:70;" class="input">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td-->
					<td width="30">Date</td>
					<input type="hidden" name="nowDate" style="width:50;" class="input2" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>">
					<td width="140"><input type="text" name="sel_date" style="width:80;text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="Date" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
				
					<td width="65">Port Code</td>					
					<td width="120"><input type="text" name="loc_cd" style="width:60;text-align:center;" class="input" dataformat="uppernum"  style="ime-mode:disabled" maxlength="5" caption="Port Code">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_loc_cd" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="35">RHQ </td>
					<td width="">
						<script language="javascript">ComComboObject('rhq', 1, 80, 1);</script>
					</td>					
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td></td></tr></table>	
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%" align="right" valign="bottom">Unit(%)</td>
					</tr>				
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
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Monitoring_Port">Monitoring Port</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>	
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Excel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>			
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
						
			</td></tr>
		</table>
		<!--biz page (E)-->

		<!-- TAB [ Gang Structure ] (E) -->
		<div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">			
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t10sheet1');</script>
						</td>
					</tr>
				</table>
			</td></tr>
			</table>
		</div>
<!-- TAB [ Gang Structure ] (E) -->	

		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
				
			</tr>
			</table>
			<!-- Button (E) -->

	<table class="height_10"><tr><td colspan="8"></td></tr></table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>