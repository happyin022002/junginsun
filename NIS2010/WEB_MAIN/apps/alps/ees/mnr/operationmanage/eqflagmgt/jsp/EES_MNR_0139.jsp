<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0139.jsp
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신	
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0139Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0139Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	//기존소스용    
 	String eqType = ((request.getParameter("eq_type")==null )?"":request.getParameter("eq_type"));
	//String dmgFlag = ((request.getParameter("dmg_flag")==null )?"":request.getParameter("returntitle"));
    	     
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
 	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.EQFlagMgt");
	 
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id(); 
		strUsr_nm = account.getUsr_nm(); 
	     
		event = (EesMnr0139Event)request.getAttribute("Event");
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
<title>Damage Flagging/Unflagging</title>
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
<input type="hidden" name="eq_type" value="<%=eqType%>">     
<!-- 개발자 작업	-->     

<table width="100%" cellpadding="" cellspacing=0 border="0"> 
<tr><td class="top">
	
				<!-- OUTER - POPUP (S)tart -->
				<table width="100%" class="popup" cellpadding="10" border="0"> 
				<tr><td class="top"></td></tr>
				<tr><td valign="top">
						
						<!--Page Title, Historical (S)-->
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Damage Flagging/Unflagging</td></tr>
						</table>  
						<!--Page Title, Historical (E)-->
						         
						<!--biz page (S)-->
						<table class="search" id="mainTable"> 
							<tr><td class="bg">
								<!--  biz_1  (S) --> 
								<table class="search" border="0" style="width:100%;">  
								<tr class="h23">      
									<td width="80">&nbsp;&nbsp;EQ Type</td>                  
									<td width="200"><script language="javascript">ComComboObject('combo1',1, 100 ,1,1)</script></td>            
									<td width="100" class="sm"><input name="dmg_flag" value="Y" type="radio" class="trans" checked>&nbsp;Flagging</td>     
									<td width="" class="sm"><input name="dmg_flag" value="N" type="radio" class="trans">&nbsp;Unflagging</td></tr>  
								</table>                         	 			
								<!--  biz_1   (E) -->   
						</td></tr></table> 
						 
						<table class="height_8"><tr><td></td></tr></table>	
						
						<table class="search" id="mainTable"> 
							<tr><td class="bg">	  
							<!-- Grid  (S) -->
									<table width="100%" class="search"  id="mainTable"> 
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
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td> 
							<td class="btn2" name="btn_Save">Verify</td> 
							<td class="btn2_right"></td>     
							</tr>
							</table></td> 
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td> 
							<td class="btn2" name="btn_RowAdd">Row Add</td>      
							<td class="btn2_right"></td>            
							</tr> 	
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td> 
							<td class="btn2" name="btn_RowDel">Row Del</td>        
							<td class="btn2_right"></td>            
							</tr> 
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->	
			    	<table class="search" border="0">
				<tr><td class="title_h"></td>
				<td class="title_s">Damage Flagging/Unflagging File Format </td></tr>
				</table>			
				<table class="grid2" border="0" style="width:350;">  
								<tr class="tr2_head">
									<td width="100">EQ No.</td> 
									<td width="">Yard</td>  
									<td width="">Date</td></tr>  
								<tr align="center"> 
									<td width="100">SMCU1234567</td>       
									<td width="">KRPUSR1</td>             
									<td width=""><script language="javascript">document.writeln(ComGetNowInfo());</script></td></tr>       
								</table> 				
							</td></tr> 
						</table>
						<!--biz page (E)--> 
					<table class="height_5"><tr><td></td></tr></table>
				</td></tr></table>

				
					
				<!-- : ( Button : pop ) (S) -->
				<table width="100%" class="sbutton">
				<tr><td height="71" class="popup">

						<!--Button (S) -->	
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
						<tr>
							<td class="btn3_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_new">New</td>
									<td class="btn1_right"> 
								</tr></table></td> 
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_loadExcel">Load Excel</td>
									<td class="btn1_right"> 
								</tr></table></td> 
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_ok">Ok</td> 
									<td class="btn1_right"> 
								</tr></table></td>
							<td class="btn1_line"></td>	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>  
									<td class="btn1_right">
								</tr></table></td>				
							</tr>
						</table></td> 		  	
							</tr>
						</table></td> 		  	
							</tr>
						</table>
						<!--Butt
						on (E) --> 
				<!-- : ( Button : pop ) (E) --> 

<!-- 개발자 작업  끝 --> 
</form>  
</body>
</html> 