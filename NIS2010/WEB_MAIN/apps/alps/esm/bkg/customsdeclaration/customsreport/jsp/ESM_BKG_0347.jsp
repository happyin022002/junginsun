<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0416.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0347Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmBkg0347Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String port_cd 	= "";
	Logger log = Logger.getLogger("customsreport.korea.event.EsmBkg0347Event");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		port_cd 	= StringUtil.xssFilter(request.getParameter("port_cd"));
		if (port_cd==null) port_cd = "";
		
		event = (EsmBkg0347Event)request.getAttribute("Event");
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
<title>Discharge Company Code</title>
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<%
	String keyAddr     = (request.getParameter("keyAddr") == null)? "":request.getParameter("keyAddr");
%>


<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="10" cellspacing="0" >
	<tr><td valign="top">
	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" class="title">
			
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Discharge Company Code</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0"> 
					<tr class="h23">
						<td width="35">Port</td>
						<td><input type="text" maxlength="5" style="width:60;ime-mode: disabled" class="input" name="port_cd" value="<%=port_cd%>" dataformat="engup"></td>
					</tr> 
				</table>
				<!--  biz_1   (E) -->
			
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
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
					<td class="btn2" name="btn_add">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_del">Row Delete</td>
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

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_select">Select</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>