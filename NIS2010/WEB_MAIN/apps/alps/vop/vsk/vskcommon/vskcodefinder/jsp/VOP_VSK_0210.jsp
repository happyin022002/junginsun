<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0043.jsp
*@FileTitle : Country Code Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.13 유혁
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VskGloEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vskcommon.vskcodefinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VskGloEvent)request.getAttribute("Event");
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
<title>Schedule Modify Help</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>

<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="srcdate" value="<%=JSPUtil.replaceForHTML(request.getParameter("srcdate")) %>" >
<input type="hidden" name="port" 	value="<%=JSPUtil.replaceForHTML(request.getParameter("port")) %>" >
<input type="hidden" name="est" 	value="<%=JSPUtil.replaceForHTML(request.getParameter("est")) %>" >
<input type="hidden" name="oldday" dataformat="ymd">
<input type="hidden" name="oldtime" dataformat="hm">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" height="307" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Schedule Modify Help</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr>
       			<!--  biz_1  (S) -->
       			<td class="bg">
				</td>
				<!--  biz_1   (E) -->
			</tr>	
			</table>
				
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search"> 
   			<tr><td class="bg">
       		
			<!-- : ( Grid ) (S) -->
			<!-- : ( Grid ) (E) -->
				
			<table width="100%" id="mainTable">
				<tr class="h23">
					<td width="80">PORT</td>
					<td><input type="text" class="input2" style="width:50;text-align:center" tabindex='-1' value="<%=JSPUtil.replaceForHTML(request.getParameter("port")) %>" readonly></td>
				</tr>
				<tr class="h23">
					<td><%=JSPUtil.replaceForHTML(request.getParameter("est"))%></td>
					<td>
						<input type='text' name='src_day' caption='날짜' dataformat='ymd'  style='width:80;text-align:center' class='input'  maxlength="8" size="10" tabindex="1">
						<img class="cursor" name="btn_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						<input type='text' name='src_time' caption='시간' dataformat='hm' style='width:40;' class='input' maxlength="4" size="5" tabindex="2">
					</td>
				</tr>
			</table>
				
			</td></tr>
			</table>	
				
		    <!-- : ( Button : Grid ) (E) -->
			
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok" tabindex="3">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close" tabindex="4">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>