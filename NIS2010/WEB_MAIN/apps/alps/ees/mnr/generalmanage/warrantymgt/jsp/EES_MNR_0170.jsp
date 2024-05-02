<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0170.jsp
*@FileTitle : Reefer Unit Warranty Period  
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.05 박명신
* 1.0 Creation
=========================================================*/%>
   
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.event.EesMnr0170Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
  	          
<%
	EesMnr0170Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";     
	String strUsr_nm		= "";    
	   
	try {  
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id(); 
		strUsr_nm = account.getUsr_nm(); 
	   
		event = (EesMnr0170Event)request.getAttribute("Event");
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table> 
    	<!--Button (E) -->
		 
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="125">Manufacturing Year</td>
					<td width="">   
					<input required fulfill name="fm_lot_pln_yr" maxlength="4" type="text" style="width:50;text-align:center;" class="input1" value="" dataformat="yyyy" cofield="to_lot_pln_yr">
					<img src="img/btns_calendar.gif" class="cursor" name="dpc_yr_cal1" width="19" height="20" alt="" border="0" align="absmiddle"> 
					&nbsp;~&nbsp;<input required fulfill name="to_lot_pln_yr" maxlength="4" type="text" style="width:50;text-align:center;" class="input1" value="" dataformat="yyyy" cofield="fm_lot_pln_yr">
					<img src="img/btns_calendar.gif" class="cursor" name="dpc_yr_cal2" width="19" height="20" alt="" border="0" align="absmiddle">    
					</td>         
					</tr>  
				</table>  				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
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
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>   
						</tr></table></td>   
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>   
						<td class="btn2" name="btn_RowDel">Row Delete</td>
						<td class="btn2_right"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td> 
						<td class="btn2" name="btn_downexcel">Down Excel</td>
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
	</td></tr>
		</table> 
	<table class="height_10"><tr><td colspan="8"></td></tr></table> 
	
</form>
</body>
</html>