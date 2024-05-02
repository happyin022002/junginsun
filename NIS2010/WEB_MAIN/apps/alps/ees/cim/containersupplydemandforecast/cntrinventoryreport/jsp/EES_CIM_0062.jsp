<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_CIM_0062.jsp
*@FileTitle : Mailing Service Setting
*Open Issues : 장비 과부족현황 Mailing (2014.03 ~ 2014.04)
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : Kim Chang Young
*@LastVersion : 1.0
* 2014.03.31 Kim Chang Young
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
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0062Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0062Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strOfc_cd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");
	
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		
		event = (EesCim0062Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title> Mailing Service Setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="select_type">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
		<tr><td class="btn1_bg">
		
		<table border="0" cellpadding="0" cellspacing="0">
		<tr><td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_new">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
		</td></tr>
		</table>
		
		</td></tr>
	</table>
	<!--Button (E) -->
	
	<!-- Grid (S) -->
	<table class="search"> 
		<tr><td class="bg">
		<table width="100%" class="search"  id="mainTable">
			<tr><td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
		</table>
		</td></tr>
	</table>
	<!-- Grid (E) -->
	
	
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
		<tr><td class="btn" align="left">
	
		<table border="0" cellpadding="0" cellspacing="0">
		<tr><td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_check" id="btn_check">Check</td>
				<td class="btn2_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_uncheck" id="btn_uncheck">Uncheck</td>
				<td class="btn2_right"></td>
				</tr>
			</table></td>
		</td></tr>
		</table>
		
		</td></tr>
	</table>
	
	</td></tr>
</table>
</form>
</body>
</html>
