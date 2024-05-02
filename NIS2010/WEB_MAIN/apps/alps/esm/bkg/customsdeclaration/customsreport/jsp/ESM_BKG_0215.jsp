<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName 			: ui_bkg_0215.jsp
*@FileTitle 		: DownLoad History
*Open Issues 		:
*Change history 	:
*@LastModifyDate 	: 2009.05.20
*@LastModifier 		: 손윤석
*@LastVersion 		: 1.0
* 2009.05.20 손윤석
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0215Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0215Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg 			= "";	//에러메세지
	int rowCount	 			= 0;	//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";

	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0215Event)request.getAttribute("Event");
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
<title>Korea : Download History</title>
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

<body  onLoad="javascript:setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="60"><input type="radio" class="trans" name="rad_mrn" checked>MRN</td>
						<td width="130"><input type="text" class="input1" style="width:100; text-align:center;" value="" dataformat="eng" caption="MRN No" name="txt_mrn"></td>
						<td width="30"><input type="radio" class="trans" name="rad_vvd">VVD</td>
						<td width="120"><input type="text" class="input2" style="width:90; text-align:center;" value="" dataformat="eng" caption="VVD" name="txt_vvd" readOnly></td>
						<td width="30">POL</td>
						<td width="100"><input type="text" class="input2" style="width:70; text-align:center;" value="" dataformat="eng" caption="POL" name="txt_pol" readOnly></td>
						<td width="30">POD</td>
						<td width="100"><input type="text" class="input2" style="width:70; text-align:center;" value="" dataformat="eng" caption="POD" name="txt_pod" readOnly></td>
						<td width="35"><input type="radio" class="trans" name="rad_dat">Date</td>
						
						<td width="290">
							<input type="text" style="width: 75; ime-mode: disabled; text-align:center;" class="input2" dataformat="ymd" name="date_from" caption="FromDate" cofield="date_to">
							&nbsp;~&nbsp; 
							<input type="text" style="width: 75; ime-mode: disabled; text-align:center;" class="input2" dataformat="ymd" name="date_to" caption="ToDate" cofield="date_from">
							<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar">
						</td>
						
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
			<!-- Grid  (S) -->		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
					
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
		<!--biz page (E)-->
	
		
	</td></tr>
		</table>
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
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
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>