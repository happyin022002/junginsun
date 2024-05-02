<%
/*==============================================================================
*Copyright(c) 2011 CyberLogitec 
*@FileName : EES_DMT_2106.jsp
*@FileTitle : Warnibg message.
*Open Issues : 경고 메세지 Display 화면.서버단을 타지 않고 덤프 이벤트  DmtComEvent적용함. 
*Change history :  
*@LastModifyDate : 2011.12.07
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0  2011.12.07  KIM HYUN HWA
* 2011.12.07  KIM HYUN HWA
* 1.0 Creation 
* 2011.12.07 KIM HYUN HWA [CHM-201114630-01][DMT]After-BKG-DAR Request 화면/기능 보완 - DR & Balance 관련
==============================================================================*/
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
<title>WARNING</title>              
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
<body class="popup_bg" onLoad="setupPage();" >
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">   
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr> 
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<!--  
		<table width="380" border="0">
		<tr> 
		<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;WARNING</td>	
		</tr> 
		</table>   
		-->
		<!-- : ( Title ) (E) 
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100%" ><div id="warn_title"   align="center" ><font size= "6" >WARNING!!!</font></div></td>
				</tr>
				<tr class="h23">
					<td width="100%"><div id="warn_msg" align="center"><font size= "4" >After BKG-DAR is applied only for General Charge, <br> not for any charge gernereated after DR.</font></div></td>
				</tr>
				</table>
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                <!--  Button_Sub (S) -->
			<table width="100%"> 
	       	<tr><td class="btn1_bg" align="center">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width="100">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
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

<table class="height_5"><tr><td></td></tr></table>
	
	
	
</form>
			
</body>
</html>		
