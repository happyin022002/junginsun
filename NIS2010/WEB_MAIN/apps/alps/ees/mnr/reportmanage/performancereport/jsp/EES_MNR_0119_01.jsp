<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0119_01.jsp
*@FileTitle : Repair Estimate Creation Pop up
*Open Issues : 
*Change history : 
*@LastModifyDate : 2014.10.14
*@LastModifier : 이덕환
*@LastVersion : 1.0
* 2014.10.14 이덕환
* 1.0 Creation
* ---------------------------------------------------------
* history
* 2015.01.19 Chang Young Kim 품질결함으로 인한 소스명변경을 이유로 소스 수정(EesMnr0119_01Event.java -> EesMnr011901Event.java)
=========================================================*
/%>
 	
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr011901Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
 	EesMnr011901Event  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";						//에러메세지
 	int rowCount	 = 0; 						//DB ResultSet 리스트의 건수
 				 
 	String successFlag = "";
 	String codeList  = "";
 	String pageRows  = "100"; 
  		 
 	String strUsr_id		= ""; 
 	String strUsr_nm		= "";  
 	String strOfc_cd		= "";  
 	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
 	
 	//팝업용 데이타			 	
 		
 	try {     
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();	       
 		strUsr_nm = account.getUsr_nm(); 	   
 	    strOfc_cd = account.getOfc_cd();   	 
 	
 		event = (EesMnr011901Event)request.getAttribute("Event"); 
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
<title>Detail Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!--MNR 공용 사용  -->                
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
<body class="popup_bg"  onLoad="javascript:setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">   
<input type="hidden" name="pagerows">   
<!-- 이화면에서 입력되는 데이타는 전부  Manual -->  
 
	  

<!-- 개발자 작업	-->	   
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Detail Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- biz page (S) -->
		<!-- 2 (S) 	  	 -->
		<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">M &amp; R Performance Detail Information</td>
					</tr>
					<tr><td class="height_5"></td>
					</tr>
				</table>
			
				<!-- Grid  (S) -->
				 <table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>	
						</td>
					</tr>
				</table>	
       			</td>
       		</tr>
		</table> 
		<!--  biz_2  (E) -->	
		
	<!--Image Info(E)-->
		
		<table class="height_5"><tr><td></td></tr></table>	
	</td></tr>
		</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table>
				</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td></tr>
		</table> 
    <!--Button (E) --></td></tr>
		</table>
	
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->  
</form>	
</body>
</html> 
