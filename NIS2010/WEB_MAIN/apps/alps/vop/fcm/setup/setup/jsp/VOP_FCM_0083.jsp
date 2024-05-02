<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VOP_FCM_0083.jsp
*@FileTitle : Departure Report Error Rate Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.00
*@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.vop.fcm.setup.setup.event.VopFcm0083Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0083Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	try {
		event = (VopFcm0083Event)request.getAttribute("Event");
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
<title>Departure Report Error Rate Setting</title>
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
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	<!-- Title, Navigation 고정 -->
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
 
<!-- mainTable (S) -->
		
		<table class="search"> 
       	<tr><td class="bg">
       		 <!--  biz_1  (S) -->
					<table class="search" border="0" style="width:382;"> 
					<tr class="h23">			
						<td width="75">Vessel Code</td>
						<td width="235"><input type="text" style="width:60;ime-mode:disabled;text-align:center" name="vsl_cd" class="input" maxlength="4" dataformat="uppernum" value="">
						&nbsp;<img src="img/btns_search.gif" name="btn_vslpop"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">
						</td>	
					</tr>
					</table>
				<!--  biz_1   (E) -->
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<!--시트-->
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
				<!-- Grid (E) -->
				<!--  Button_Sub (S) -->
		 			<table width="100%" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Row_Delete">Row Delete</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>						
							</tr></table>
						</td></tr>
					</table>
		    	<!-- Button_Sub (E) width:979; 886 -->
			</td></tr>
		</table>	
	<!--biz page (E)-->
	
<!-- mainTable (E) -->
 	<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    <tr>
        <td class="btn1_bg">
	        <table border="0" cellpadding="0" cellspacing="0">
	    		<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				
				</tr>
			</table>
		</td>
	</tr>
</table>  
</td></tr>
</table>
  	
</form>			
</body>
</html>