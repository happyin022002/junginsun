<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_DMT_4109.jsp
*@FileTitle : Please Check the payer again.
*Open Issues : 이화면은 서버단을 타지 않는다 DmtComEvent 은 덤프 이벤트이다 
*Change history :  
*@LastModifyDate : 2011.03.31
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.31 김태균
* 1.0 Creation 
* 2011.03.31 김태균 [CHM-201109784-01] [DMT] Invoice Creation & Issue의 Payer 정보 확인 절차 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.event.DmtComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	DmtComEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg	= "";	 					//에러메세지
 	
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		event = (DmtComEvent)request.getAttribute("Event");
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
<title>Check the payer Pop up</title>              
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

<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage()">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">   
<input type="hidden" name="payerCode"> 
<input type="hidden" name="payerName"> 
<input type="hidden" name="checkValue"><!-- Right(R), Wrong(W) 선택 -->
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr> 
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="380" border="0">
		<tr> 
			<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Please Check the payer again. </td>
		</tr> 
		</table> 
		<!-- : ( Title ) (E) --> 
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100%"><div id="payer">&nbsp;&nbsp;&nbsp;Payer  :</div></td>
				  </tr>
				</table>
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                <!--  Button_Sub (S) -->
			<table width="100%"> 
	       	<tr><td class="btn2_bg" align="center">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Right">Right</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="10"></td>
						<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Wrong">Wrong</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						
				</table>
			</td></tr>
			</table>
			<!-- Button_Sub (E) -->
		</td>
		</tr>
	</table>
				<!-- : ( Button : Grid ) (S) -->
		    <!-- : ( Button : Grid ) (E) -->	
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) 
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="">Close</td>
					<td class="btn1_right"></td>
				</tr></table>
				</td>
			</tr>
		</table>
	
	</td></tr>
</table>
 : ( Button : pop ) (E) -->			
</form>
			
</body>
</html>		
