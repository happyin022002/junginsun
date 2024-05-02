<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0191.jsp
*@FileTitle : Repair History_Pop Up
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.03 박명신  	 		
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0191Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0191Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	  
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 	 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";   
	String workApp 			= "";
	String eq_no = ((request.getParameter("eq_no")==null )?"":request.getParameter("eq_no")); 
	String mnr_wo_tp_cd = ((request.getParameter("mnr_wo_tp_cd")==null )?"":request.getParameter("mnr_wo_tp_cd")); 
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
	         
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();   
		workApp = account.getAccess_system();
	       
		event = (EesMnr0191Event)request.getAttribute("Event"); 
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
<title>Repair History</title> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!--MNR 공용 사용  -->                
<script language="javascript">  
	//workApp ALP or SPP  
	var workApp = '<%=workApp%>';  
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
<input type="hidden" name="mnr_wo_tp_cd" value="<%=mnr_wo_tp_cd%>"> 
   
<!-- 개발자 작업	-->   
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Repair History</td></tr>
		</table>	  
		<!--Page Title, Historical (E)--> 
		
		<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		       	<tr>
		       		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
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
											<td class="btn1" name="btn_Acep_Pop">ACEP Check List</td>	
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

    	<!--Button (E) -->
		    
		<!-- : ( Search Options ) (S) -->
			<table class="search">      
       		<tr><td class="bg">    
				<!--  biz_1 (S) --> 
				<table class="search" border="0" style="width:680;"> 
					<tr class="h23"> 
						<td width="50">EQ No.</td>          
						<td width="150">       
						<input style="width:120;" required type="text" name="eq_no" dataformat="engup" caption="EQ No" class="input1" value="<%=eq_no%>" > 
						</td>     
						<td width="80">Input Period</td>       
						<td width=""> 					          
						<input type="text" name="fm_mnr_inp_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="10"  cofield="to_mnr_inp_dt" value="">   
	                              	~ <input type="text" name="to_mnr_inp_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="10"  cofield="fm_mnr_inp_dt">&nbsp;<img name="btns_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">  
						</td>       
					</tr>  
				</table>
				<!--  biz_1   (E) -->	 
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
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
					<td class="btn1" name="btn_close">Close</td> 
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
</form>			
</body>
</html>