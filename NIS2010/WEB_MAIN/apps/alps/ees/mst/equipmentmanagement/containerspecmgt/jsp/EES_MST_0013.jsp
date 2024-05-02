<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0013.jsp
*@FileTitle : Equipment Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.28 김석준
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0013Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesMst0013Event)request.getAttribute("Event");
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
<title>Equipment Organization Chart</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

 	<!--Page Title, Historical (S)-->
 		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
 			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
 			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
 		</table>
 	<!--Page Title, Historical (E)-->
 	<!--biz page (S)-->
	
		
	<table class="search" border=0>
	<tr><td class="bg" style="height:516;" valign="top">		

		<table class="search" border=0 style="width:979;">
			<tr><td width="75%" style="padding-right:15; padding-top:0;" valign="top">
		
		<!-- Grid BG Box  (S) -->
				<table style="height:9;"><tr><td></td></tr></table>
			<!-- Grid 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> </td>	
			<!-- Grid 1(E) -->
			
				<td valign="top">	

				<!--  biz_ (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td align="right">SCC</td>
					<td align="right" width="97"><input type="text" style="width:90;" class="input" name="scc_cd" readonly style="text-align:center"></td>
					</tr>
				<tr><td height="2"></td></tr>
				</table>
				<!--  biz_ (E) -->
		
			<!-- Grid 2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> </td>	
			<!-- Grid 2(E) -->
			
				</td></tr>
		</table>	
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>