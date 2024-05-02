<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EES_MNR_0261.jsp
*@FileTitle : Not Pick-up Container No Pop Up
*Open Issues :     
*Change history :  
*@LastModifyDate : 2012.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.12 신혜정   
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0261Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0261Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.disposalmgt");

	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		
		event = (EesMnr0261Event)request.getAttribute("Event"); 
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
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var opener = window.dialogArguments;
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
			
		document.form.disp_no_list.value = opener.dispNoList;
	
		loadPage();
	}
	
</script>
</head>
    
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="disp_no_list" >
<input type="hidden" name="f_cmd">

<table width="990" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Not Pick-up Container No</td>
				</tr>
			</table>
 			
			<table class="search" > 
       			<tr>
       				<td class="bg">
						<table width="100%"  id="mainTable" > 
							<tr>	
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<table width="100%" class="button" >
					    	<tr>
					    		<td class="btn2_bg">
						        	<table border="0" cellpadding="0" cellspacing="0">
						        		<tr>
						            		<td>
						            			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					            					<tr><td class="btn2_left"></td>
					            						<td class="btn2" name="btn_downexcel">Down Excel</td>
					            						<td class="btn2_right"></td>
					            					</tr>
					            				</table>
					            			</td>
					          			</tr>
					          		</table>
					      	 	</td>
					      	</tr>
						</table>						
		</td>
	</tr>
</table>
<table class="height_5" >
	<tr><td></td>
	</tr>
</table>
	
<table width="100%" class="sbutton">
	<tr>
		<td height="35" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    		   	<tr>
    		   		<td class="btn3_bg">
		   				<table border="0" cellpadding="0" cellspacing="0">
		   					<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
		
</form>			
			
</body>
</html>
