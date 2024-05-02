<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0193.jsp
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신  
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0193Event"%>
<%@ page import="org.apache.log4j.Logger" %>
  	 
<%
	EesMnr0193Event  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";	 					//에러메세지
 	 
 	String strUsr_id		= "";     
 	String strUsr_nm		= "";      
	   		  
 	String recEqKndCd = ((request.getParameter("rec_eq_knd_cd")==null )?"":request.getParameter("rec_eq_knd_cd"));
 	String recKeyValue = ((request.getParameter("rec_key_value")==null )?"":request.getParameter("rec_key_value"));
 	   
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
	  	   	     
 		event = (EesMnr0193Event)request.getAttribute("Event");
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
<title>Location Code Inquiry</title>              
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
			
<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">    
<input type="hidden" name="f_type">       
<input type="hidden" name="pagerows">    
<input type="hidden" name="rec_eq_knd_cd" value="<%=recEqKndCd%>">   
<input type="hidden" name="rec_key_value" value="<%=recKeyValue%>">   
<!-- 개발자 작업	--> 
 
<!-- OUTER - POPUP (S)tart --> 
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Location Code Inquiry</td></tr>
		</table>
		<!--Page Title, Historical (E)-->  
		
		<!-- : ( Search Options ) (S) -->
			<table class="search">  
       		<tr><td class="bg">
				<table class="search" border="0" style="width:779;"> 
				<tr class="h23"> 
					<td width="60">EQ Type</td>      	
					<td width="120"><script language="javascript">ComComboObject('eq_knd_cd',1,104,1,1,0,false,0);</script></td>
					<td width="120">1st Location Code</td>	
					<td width=""><script language="javascript">ComComboObject('key_value',2,180,1,1)</script>      
					</tr>	
				</table> 
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- Grid 1,2,3 (S) -->
			<table class="search"> 
			<tr><td valign="top" width="28%">	

					<!-- Title -->
					<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">1st Location Code</td></tr>
					</table>
					<!-- Title -->
					  
					<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
					<!-- Grid - 1 (E) -->
				
					
	
				</td>
				
				<td valign="top" width="22%" style="padding-left:10px;">	

					<!-- Title -->
					<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">2nd Location Code</td></tr>
					</table>
					<!-- Title -->
					
					<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
					<!-- Grid - 2 (E) -->	
				
					
				
				</td>
				
				<td valign="top" width="25%" style="padding-left:10px;">	

					<!-- Title -->
					<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">3rd Location Code</td></tr>
					</table>
					<!-- Title -->
					
					<!-- Grid - 3 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
					<!-- Grid - 3 (E) -->	
				
				
				</td>
				
				<td valign="top" style="padding-left:10px;">	

					<!-- Title -->
					<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">4th Location Code</td></tr>
					</table>
					<!-- Title -->
					
					<!-- Grid - 4 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
					<!-- Grid - 4 (E) -->	
				
					
				
				</td></tr>
			</table>
			<!-- Grid 1,2,3 (E) -->
			</td></tr>
			</table>
	    	
<table class="height_5"><tr><td></td></tr></table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"> 
				</tr></table></td>
			</tr>  
		</table></td>    
			</tr>  
		</table>
    <!--Button (E) -->
	
	</td></tr> 
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->  
</form>
</body>
</html>	 
