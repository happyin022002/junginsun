<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0740.jsp
*@FileTitle : Group Update for B/L Issue And Onboard Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.07.15 김영출
* 1.0 Creation
===============================================================================
 History
 2011.03.22 이일민 [CHM-201109424-01] B/L Issue and On-Board Date Update 기능 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0740Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0740Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_id        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();

		event = (EsmBkg0740Event)request.getAttribute("Event");
		
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
<title>B/L Issue & On-Board Date Adjust</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="eta" value="<%=JSPUtil.getParameter(request, "eta", "")%>">
<input type="hidden" name="etd" value="<%=JSPUtil.getParameter(request, "etd", "")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; B/L Issue & On-Board Date Adjust</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="130"><input type="checkbox" name="ob_chk" class="trans" checked>&nbsp;On-Board Date</td>
					<td><input type="text" name="ob_date" value="" dataformat="ymd" maxlength="8" size="10">&nbsp;<img class="cursor" name="img_ob_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr> 
				</table>
				<table class="line_bluedot">
				<tr>
					<td></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="130"><input type="checkbox" name="issue_chk" class="trans" checked>&nbsp;B/L Issue Date</td>
					<td><input type="text" name="issue_date" value="" dataformat="ymd" maxlength="8" size="10">&nbsp;<img class="cursor" name="img_issue_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="20" align="right" class="stm">AT&nbsp;</td>
					<td width="73"><input type="text" name="ussue_at" maxlength="6" value="<%=strOfc_id%>" style="ime-mode:disabled;width:50" class="input"></td>
					<td width="20" class="stm">BY</td>
					<td width="90"><input type="text" name="ussue_by" maxlength="20" value="<%=strUsr_id%>" style="ime-mode:disabled;width:80;" class="input"></td>
					<td width="60" class="stm">PPD Credit</td>
					<td width="22"><input type="checkbox" name="credit_chk" class="trans"></td>
					<td><input type="text" name="ppd_rcv_ofc_cd" maxlength="6" value="<%=strOfc_id%>" style="ime-mode:disabled;width:60;" class="input"></td>
				</tr> 
				</table>				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100%"><input type="checkbox" name="ofc_chk" class="trans">&nbsp;Leave B/L Issue Office & Issuer as it is.</td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
					
			
			</td></tr>
		</table>
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Ok</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>		
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>				
			</tr>
		</table></td>				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


		
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>