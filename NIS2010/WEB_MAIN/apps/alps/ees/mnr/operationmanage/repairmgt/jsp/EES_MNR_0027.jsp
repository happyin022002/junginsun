<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0027.jsp
*@FileTitle : Repair Cancellation and Deletion
*Open Issues :     
*Change history :  
*@LastModifyDate : 2012.11.08
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.07.01 박명신		   		
* 1.0 Creation	
* History
* 2012.11.08 조경완 [CHM-201220892-01] ALPS MNR-Repair ->M&R Repair cancellation and deletion 에서 Repair Inquiry 조회 조건 보완 건
* 									  - by eq No, by period 추가        	
=========================================================*/
%>
			
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	 
<%
	EesMnr0027Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
				 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 		 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
								        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
						
		event = (EesMnr0027Event)request.getAttribute("Event"); 
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
<title><span id="title"></span></title>     
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
<script language="javascript">ComSheetObject('sheet1');</script>     
</head>	 
    
<body  onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">    
<input type="hidden" name="pagerows"> 	   
<!-- 견적서발급과 감사를 구분하기위한 rqst_cre/rqst_aud--> 
<input type="hidden" name="cost_ofc_cd" value="<%=strOfc_cd%>"> 	     
<input type="hidden" name="tpb_only" value="N">     	     
<input type="hidden" name="edi_error_only" value="N">    	     
<input type="hidden" name="screen_flag" value="DEL">	     	     
			 			
<!-- 개발자 작업	-->	 	   
<!-- OUTER - POPUP (S)tart -->	
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
				<td class="btn1_line"></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Cancel</td>
					<td class="btn1_right"></td>	
					</tr>	
				</table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				</tr>
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
					<td width="80">W/O Type </td>	
					<td width="150" style="padding-left:2;"> 	
					<script language="javascript">ComComboObject('wo_type', 1, 130, 1, 1,0,false,0);</script>  
					</td> 
					<td width="70">EQ Type</td>	
					<td width="150" style="padding-left:0;">	
					<script language="javascript">ComComboObject('eq_knd_cd', 1, 130, 1, 1,0,false,0);</script>
					</td>  
					<td width="78">Input Date</td>	 			   
					<td width="210">		  					
						<input type="text" name="fm_est_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="10"  cofield="to_est_dt" value="" class="input">    
	                              	~ <input type="text" name="to_est_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="10"  cofield="fm_est_dt" class="input">&nbsp;<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>				
					<td width="55">Status</td>			    
					<td><script language="javascript">ComComboObject('status_cd', 1, 140, 1, 1,0,false,0);</script>
					</td>		 		 	  	
				</tr>			  
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">     
					<td width="80">EQ No.</td>
					<td width="150"><input name="rqst_eq_no" type="text" style="width:105" class="input" dataformat="engup" value="">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>   
					<td width="70">EST No.</td>
					<td width="150"><input name="rqst_ref_no" type="text" style="width:105" class="input" dataformat="engup" value="">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi2"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td> 	 
					<td width="80">W/O No.</td> 
					<td width="210"><input name="wo_no" type="text" style="width:100" class="input" dataformat="engup" value="">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi3"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>   
					<td width="">TPB Request Only&nbsp;<input name="temp_tpb_only" type="checkbox" value="Y" class="trans"></td>  
					<td width="">&nbsp;</td>	 
				</tr>	     
				</table>  	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23"> 	  
				<td width="105">Service Provider</td>	 	
				<td width="345"><input type="text" name="vndr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_nm" caption="Service Provider" style="width:241;" class="input2" value="" readonly></td>	 
				<td width="200">EDI Error Only&nbsp;<input name="temp_edi_error_only" type="checkbox" value="Y" class="trans"></td>  
				<td width="80">&nbsp;</td>
				<td>
				<input type="radio" name="srch_type" value="E" class="trans" checked>By EQ No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="srch_type" value="P" class="trans"  >By Period&nbsp;&nbsp;&nbsp;
				</td>   
				</tr>  
				</table>
				
				<!--  biz_1   (E) -->

		</td></tr></table>	
		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid - 1  (S) -->
			<table width="100%" id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
			</table> 
			<!-- Grid - 1 (E) -->	
						
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr> 
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Detail">Detail(s)</td> 
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
</html>