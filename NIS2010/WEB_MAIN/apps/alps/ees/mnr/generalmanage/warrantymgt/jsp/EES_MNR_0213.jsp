<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0213.jsp
*@FileTitle : Warranty Alert_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.03 박명신
* 1.0 Creation
=========================================================*/%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.event.EesMnr0213Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
           
<%
	EesMnr0213Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
					
	String strUsr_id		= "";      
	String strUsr_nm		= "";    
	//기존소스용       
 	String eq_no = ((request.getParameter("eq_no")==null )?"":request.getParameter("eq_no")); 
	// String eq_no = "SMCU1234562";      
	try { 
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm(); 
	   
		event = (EesMnr0213Event)request.getAttribute("Event");
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
<title>Warranty Alert</title> 
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
<input type="hidden" name="pagerows">      
<input type="hidden" name="eq_no" value="<%=eq_no%>">   
        
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Warranty Alert</td></tr>
		</table>  
		<!--Page Title, Historical (E)-->
			
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<table border="0" style="width:100%;" class="grid2"> 
				
				<tr class="tr_head">
					<td colspan="3">Warranty Warning!<br>
					(This EQ is in Warranty Service of Maker.)</td>
				</tr>    
				<tr class="input" align="center"> 
					<td width="40%" class="tr2_head2">Warranty Period</td>
					<td width="30%"><input name="fm_warr_dt" type="text" style="width:100%;" class="input2" readonly></td>
					<td><input name="to_warr_dt" type="text" style="width:100%;" class="input2" readonly></td>
				</tr>
				<tr class="input" align="center"> 
					<td width="40%" class="tr2_head2">Maker	</td>
					<td colspan="2"><input name="eq_mkr_nm"  type="text" style="width:100%;text-align:center;" class="input2" readonly></td>
				</tr>
				<tr class="input" align="center"> 
					<td width="40%" class="tr2_head2">Unit Model	</td>
					<td colspan="2"><input name="eq_mdl_nm"  type="text" style="width:100%;text-align:center;" class="input2" readonly></td>
				</tr>  
				<tr class="input" align="center">  
					<td width="40%" class="tr2_head2">Remark</td> 
					<td colspan="2"><input name="warr_rmk"  type="text" style="width:100%;text-align:left;" class="input2" readonly></td>
				</tr>      
				</table>
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
					<td class="btn1" name="btn1_Close">Close</td> 
					<td class="btn1_right"> 
				</tr></table></td>
			</tr>  
			</table>
			</td></tr>
			</table> 
    	<!--Button (E) -->  
	      
		</td></tr>
		</table>
<!-- : ( Button : pop ) (E) -->  
</form>
<script language="javascript">ComSheetObject('sheet1');</script>
</body>
</html>