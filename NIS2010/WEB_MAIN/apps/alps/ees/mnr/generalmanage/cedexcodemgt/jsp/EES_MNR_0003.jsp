<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0003.jsp
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
       
<% 
 	EesMnr0003Event  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";						//에러메세지
 	 
 	String strUsr_id		= ""; 
 	String strUsr_nm		= "";  
	String strAccess_System		= "";
	String rhqOfcCd         = ""; 
	String currOfcCd       = "";
	String currOfcEngNm     = ""; 	
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm(); 
		strAccess_System = account.getAccess_system();
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();		
 	      
 		event = (EesMnr0003Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>          
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
      
<script language="javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	var rhqOfcCd  = "<%=rhqOfcCd.trim()%>";
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
<input type="hidden" name="f_type">      
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
	  
		<!--Button (S) --> 
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg"> 
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>  
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td> 
					</tr>
				</table></td>
				<%if(strAccess_System.equals("ALP")){ %>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<%}%>
				</tr>
			</table>
		</td></tr> 
		</table>
    	<!--Button (E) -->
    	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg"> 
			
				<!--  biz  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">  
					<td width="60">EQ Type</td>        	
					<td width="120"><script language="javascript">ComComboObject('eq_knd_cd',1,104,1,1,0,false,0);</script></td>
					<td width="120">1st Location Code</td> 	
					<td width=""><script language="javascript">ComComboObject('key_value',2,180,1,1)</script>      
					</tr>	     
				</tr> 
				</table> 				
							
				<!--  biz   (E) -->

		</td></tr></table>	
		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	 
			<!-- Grid 1,2,3 (S) -->
			<table class="search">  
			<tr><td valign="top" width="31%">	 
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
				<%if(strAccess_System.equals("ALP")){ %>
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd1">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowDel1">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Excel1">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
															
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
				<%}%>
				</td>
				
				<td valign="top" width="23%" style="padding-left:10px;">	

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
				<%if(strAccess_System.equals("ALP")){ %>
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd2">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowDel2">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Excel2">D</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
															
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
				<%}%>
				</td>
				
				<td valign="top" width="23%" style="padding-left:10px;">	

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
				<%if(strAccess_System.equals("ALP")){ %>
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd3">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowDel3">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Excel3">D</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
																
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
				<%}%>
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
				<%if(strAccess_System.equals("ALP")){ %>
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd4">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowDel4">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>  
							</table></td> 

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Excel4">D</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
																 
							</tr></table>
					</td></tr>
					</table>   
			    	<!-- Button_Sub (E) -->
			    <%}%>
				</td></tr>
			</table>
			<!-- Grid 1,2,3 (E) -->
			
		</td></tr> 
		</table>			
		<!--biz page (E)--> 
	</td></tr>
		</table>
	<table class="height_10"><tr><td colspan="8"></td></tr></table> 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>