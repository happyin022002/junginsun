<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0171.jsp
*@FileTitle : Temp T/S Route
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.29 송호진
* 1.0 Creation
* History
* 1.0 최초 생성
* 2009-06-01 박상희  N200905110270 COA_Pre CM/OP Simulation : Temp T/S Route 입력기능
* 2009-10-08 송호진 ALPS 전환
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.event.EsmCoa0171Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmCoa0171Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.PreCMSimulation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


//		event = (EsmCoa0171Event)request.getAttribute(Event);
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
<title>Temp T/S Route</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
        sheetObjects[0].SelectCell(3, 1); 
	}
</script>
</head>

<!-- 개발자 작업	-->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr>
	<td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Temp T/S Route</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

				<table width="100%" id="mainTable">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
						</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

	</td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Apply</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>