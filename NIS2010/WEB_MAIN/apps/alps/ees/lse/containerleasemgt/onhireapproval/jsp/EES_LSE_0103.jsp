<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_LSE_0103.jsp
*@FileTitle : Requst List Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.29
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.07.29 채창호
* 1.0 Creation
* @Create         : Ver 1.0   
* *************************************************
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0103Event"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchRequestListVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesLse0103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String main_page = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SimulationManage.CodSimulate");
	
	String userId ="";
	String userName = "";
	String currnetTime = JSPUtil.getKSTDateTime();

	String tpsz = "";
	main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		tpsz = eventResponse.getCustomData("title").toString();
		
		

	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Req No. Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var tpszname = "<%=tpsz%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(<%=main_page%>);
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
	<form method="post" name="form" onSubmit="return false;">
		<input	type="hidden" name="f_cmd">
		<input	type="hidden" name="titlelist" vale ="<%=tpsz%>">
		<!-- OUTER - POPUP (S)tart -->
		<table width="1000" class="popup" cellpadding="10" border="0">
			<tr><td class="top"></td></tr>
			<tr><td valign="top">

				<!-- : ( Title ) (S) -->
				<table width="100%" border="0">
					<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Req No. Inquiry</td></tr>
				</table>
				<!-- : ( Title ) (E) -->

				<!-- : ( Button : Main ) (S) -->
			   	<!-- : ( Button : Main ) (E) -->

				<!-- : ( Search Options ) (S) EesLse0103Event
				<!-- : ( Search Options ) (E) -->

				<table class="height_10"><tr><td></td></tr></table>


				<table class="search">
					<tr><td class="bg">
						<table class="search"><tr><td class="height_2"></td></tr></table>

						<!-- : ( Grid ) (S) -->
	                    <table width="100%" id="mainTable">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('sheet1');</script>
	                        </td></tr>
	                    </table>
						<!-- : ( Grid ) (E) -->
						</td>
					</tr>
				</table></td>
			</tr>
			<tr>
				<td>
				<!-- : ( Button : Sub ) (S) -->
				<table class="height_10"><tr><td></td></tr></table>


				<table width="100%" class="sbutton">
						<tr><td height="71" class="popup">

							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
					       		<tr><td class="btn3_bg">
							    <table border="0" cellpadding="0" cellspacing="0">
							    <tr>

									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_select" id="btn_select" >Select</td><td class="btn1_right"></td></tr></table></td>
								
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close" onClick="javascript:closeWindow();">Close</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr>
							</table>

						</td></tr>
				</table>
				<!-- : ( Button : Sub ) (E) -->

				</td>
			</tr>
		</table>
		<!-- OUTER - POPUP (E)nd -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>