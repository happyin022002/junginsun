<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName :  ees_mnr_confirm.jsp
*@FileTitle : 멀티 컴폼창 2개이상 잇을때 이용 
*Open Issues : 이화면은 서버단을 타지 않는다 MnrComEvent 은 덤프 이벤트이다 
*Change history :   
*@LastModifyDate : 2009.09.04 
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.04 박명신    
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.event.MnrComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
	
				   
<%
 	MnrComEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";	 					//에러메세지
 	String strUsr_id		= "";     
 	String strUsr_nm		= "";    
 	
 	//기존소스용
 	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));
	    					
	String btnNms = ((request.getParameter("btnNms")==null )?"":request.getParameter("btnNms"));
 	String scrWidth =  ((request.getParameter("scrWidth")==null )?"":request.getParameter("scrWidth"));
 	scrWidth = "400";
 	 
	String[] arrbtnNms = btnNms.split(","); 
	
	//*****************넘겨야 될값 ********************//
	//returntitle 타이틀명 
	//btnNms 버튼갯수만큼 
	//scrWidth 화면 사이즈 (버튼의 갯수마다 틀리므로 알아서 입력 
	//*****************넘겨야 될값 ********************//
		
	try {   
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
	 		  	  	     
 		event = (MnrComEvent)request.getAttribute("Event");
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
<title>MNR MULTIFUL CONFIRM</title>                
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
<input type="hidden" name="returnval" value="<%=returnval%>"> 
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="<%=scrWidth%>" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr> 
<tr><td valign="top"> 
		
		<!-- : ( Title ) (S) -->
		<table width="380" border="0">
		<tr> 
			<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;<%=returntitle%> </td>
		</tr> 
		</table> 	 	
		<!-- : ( Title ) (E) --> 
        
		<!-- : ( Search Options ) (S) -->
		<table class="search" style="width:<%=Integer.parseInt(scrWidth) - 40%>;" align="center"> 
			<tr> 
				<td class="bg">
					<table width="100%" class="sbutton"> 
					<tr>
					<td height="19" class="popup">   
						
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
				       	<tr><td class="btn3_bg">
					        <table border="0" cellpadding="0" cellspacing="0">
					        <tr>
							<% for(int i = 0; i < arrbtnNms.length; i++) {%> 					    	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>		
								<td class="btn1" name="<%="btn_Row" + i%>"><%=arrbtnNms[i]%></td> 
								<td class="btn1_right">		
							</tr></table></td> 
							<% if(i != (arrbtnNms.length - 1)){ %>
							<td class="btn1_line"><td>  
							<% }  		
							} %>   	  	
						</tr>  
						</table>
					</td></tr> 
					</table>
					
					</td></tr> 				
					</table>
					
					<!-- : ( Button : Sub ) (E) -->
						
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) --> 	

</td>  
</tr>  
</table>	  
<table width="<%=scrWidth%>" height="11" class="popup" cellpadding="0" border="0"> 
<tr><td class="top"></td></tr> 
</table>
<!-- OUTER - POPUP (E)nd -->  
<table class="height_2"><tr><td></td></tr></table>
<!-- 개발자 작업  끝 -->  
</form>
</body>
</html>