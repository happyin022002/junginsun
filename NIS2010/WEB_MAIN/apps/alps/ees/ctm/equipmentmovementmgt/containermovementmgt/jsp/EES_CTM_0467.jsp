<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_CTM_0467.jsp
*@FileTitle : Multi Cntr No input
*Open Issues : 
*Change history :  
*@LastModifyDate : 2014.03.11
*@LastModifier : Choi Duk Woo
*@LastVersion : 1.0
* 2014.03.11 Choi Duk Woo
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.event.CtmComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    CtmComEvent  event = null;				    //PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg	= "";	 				//에러메세지
 	String strUsr_id	= "";     
 	String strUsr_nm	= "";    
 	
 	//기존소스용
 	String returnVal	= JSPUtil.getParameter(request, "returnval", "");
	String returnTitle	= JSPUtil.getParameter(request, "returntitle", "");
	String orgVal 	    = JSPUtil.getParameter(request, "orgval", "");
	
	if(!returnTitle.equals("")) {
		returnTitle = " (" + returnTitle + ")";
	}
	
      	
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
	     	     
 		event = (CtmComEvent)request.getAttribute("Event");
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
<title>Multiple Input Pop up</title>              
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">   
<input type="hidden" name="returnval" value="<%=returnVal%>"> 
<input type="hidden" name="orgval" value="<%=orgVal%>"> 
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr> 
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="380" border="0">
		<tr> 
			<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Error List Selecting Popup </td>
		</tr> 
		</table> 
		<!-- : ( Title ) (E) --> 
        
		<!-- : ( Search Options ) (S) -->
		<table class="search" style="width:100%;" align="center"> 
			<tr> 
				<td class="bg">
					<!-- : ( Level Group ) (E) -->
					<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td> 
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr> 
		            </table>  
				<!-- : ( From Location ) (E) -->  
					<!-- : ( Level Group ) (E) -->
						
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) --> 	

  
<table class="height_2"><tr><td></td></tr></table> 
</td> 
</tr> 
</table> 
<!-- OUTER - POPUP (E)nd -->

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Apply">Apply</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</td></tr>
</table>
 	
<!-- 개발자 작업  끝 -->  
</form>
</body>
</html>