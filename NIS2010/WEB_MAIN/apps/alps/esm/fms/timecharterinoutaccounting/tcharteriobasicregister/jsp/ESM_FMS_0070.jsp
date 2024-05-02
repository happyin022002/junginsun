<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0070.jsp
*@FileTitle : Vendor Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.16 윤세영
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0070Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0070Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBasicRegister");

    String condFlag = request.getParameter("condFlag")==null?"":request.getParameter("condFlag");

    String agmtFlag = request.getParameter("agmtFlag")==null?"":request.getParameter("agmtFlag");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0070Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		log.error("err " + e.toString(), e);
	}
%>
<html>
<head>
<title>Vendor / Customer Inquiry</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="agmt_flag" value="<%=agmtFlag%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Vendor / Customer Inquiry Pop Up </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:484;"> 
				<tr class="h23">
					<td width="110"> &nbsp;&nbsp;Search Keyword </td>   
					<td width="374"><input type="text" style="width:145;" class="input1" name="search_name" required  value=""  style="ime-mode:disabled"></td></tr>
				</table>
				<table class="search" border="0" style="width:484;"> 
				<tr class="h23">
					<td  style="width:264;">
						<table class="search_sm" border="0"  style="width:98%;">
						<tr class="">
							<td width="100"><strong>Condition</strong></td>   
							<td width="170" class="noinput1">
							<input type="radio" name="cond_flag" value="VP" class="trans" disabled <%=condFlag.equals("VP")?"checked":""%>>Vendor&nbsp;&nbsp;
							<input type="radio" name="cond_flag" value="CP" class="trans" disabled <%=condFlag.equals("CP")?"checked":""%>>Customer</td>
						</tr></table>
					</td>
					<td><table border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_retrieve" id="btn_retrieve">Search</td>
								<td class="btn2_right"></td></tr></table></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<!-- : ( Grid ) (S) -->
							<table width="100%" class="search" id="mainTable"> 
								<tr>
									<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
							</table>
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				  <td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr></table>
			</td>
		</tr></table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>