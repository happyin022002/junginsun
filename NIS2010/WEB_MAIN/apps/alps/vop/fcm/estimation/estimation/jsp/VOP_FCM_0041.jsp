<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0041.jsp
*@FileTitle : Monthly Estimation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
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
<%@ page import="com.hanjin.apps.alps.vop.fcm.estimation.estimation.event.VopFcm0041Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0041Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	Logger log = Logger.getLogger("com.hanjin.apps.vop.fcm.estimation.estimation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0041Event)request.getAttribute("Event");
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
<title>Fuel Consumption Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var gOfcCd = "<%=strOfc_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();"> 

<form name="form">
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 업무용 hidden -->
<input type="hidden" name="rev_yrmon">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="rev_dir_cd">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	<!-- Title, Navigation 고정 -->
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<!-- 메인 화면 : biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
       			<!-- 메인 조건부 : biz_1  (S) -->
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Execute Month</td>
					<td class="stm">&nbsp;<input type="text" name="exe_yrmon" style="width:60;text-align:center;ime-mode:disabled;" class="input1" dataformat="ym" size="7" maxlength="6">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarfm"  id="btns_calendarfm"></td>
					<td width="80">Status</td>
					<td><input type="text" name="status" style="width:100;text-align:center;" class="input2"></td>
								</tr>
				</table>				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>	

		<table class="search">
       	<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable" style="display:">
					<tr>
						<td width="100%">
							<!--request sheet-->
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<!--main sheet-->
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<!--main sheet-->
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
			</td></tr>
		</table>					
	<!--biz page (E)-->
	
</td></tr>
</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
  	
	<!-- 메인 화면 바깐쪽 화면 하단 버튼 부 -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Load" id="btn_Load">Load</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Creation">Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ROBEMList">ROB EM List</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>	
    <!--Button (E) -->	
    
</form>			
</body>
</html>