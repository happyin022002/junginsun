<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_NTC_0002.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.07 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================
* History
=========================================================*/
%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.agreementnotice.event.ComNtc0002Event"%>

<%
	ComNtc0002Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String sys_cd		= "";
	String ctrt_ofc_cd	= "";
	String agmt_mapg_no		= "";
	String ofc_tp_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.bizcommon.BizCommonSC.AgreementNoticeBC"); 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		
		event = (ComNtc0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		sys_cd      = request.getParameter("sys_cd");
		ctrt_ofc_cd	= request.getParameter("ctrt_ofc_cd");
		agmt_mapg_no		= request.getParameter("agmt_mapg_no");
		ofc_tp_cd	= request.getParameter("ofc_tp_cd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Contract Update Users </title>
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
<input type="hidden" name="sys_cd" value="<%=sys_cd%>" >
<input type="hidden" name="ctrt_ofc_cd" value="<%=ctrt_ofc_cd%>" >
<input type="hidden" name="agmt_mapg_no" value="<%=agmt_mapg_no%>" >
<input type="hidden" name="ofc_tp_cd" value="<%=ofc_tp_cd%>" >
<!-- 개발자 작업	-->
<table width="800" class="popup" cellpadding="10" border="0"> 
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Contract Update Users</td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
	<table class="search"> 
	    <tr><td class="bg">
					  	
		<!-- Grid  (S) -->
		<table width="100%"  id="mainTable">
			<tr><td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
		</table>
		<!-- Grid (E) -->
	
		</td></tr>
	</table>
	<!--biz page (E)-->	
	
	<table class="height_10"><tr><td></td></tr></table>

	<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
		<tr>
			<td height="71" class="popup">		
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 5;">
				<tr>
					<td class="btn3_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>						
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right">
								</tr>
							</table>
							</td>						
						</tr>
					</table>
					</td>
				</tr>
			</table>
		</td>		
		</tr>
	</table>
	<!-- : ( Button : pop ) (E) -->

    <table class="height_8"><tr><td></td></tr></table>    	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>