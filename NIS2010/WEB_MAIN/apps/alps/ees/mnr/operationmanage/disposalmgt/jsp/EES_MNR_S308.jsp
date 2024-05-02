<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S308.jsp
*@FileTitle : Disposal Invoice Inquiry
*Open Issues :      
*Change history :   
*@LastModifyDate : 2009.09.30
*@LastModifier : 함형석     
*@LastVersion : 1.0    
* 2009.09.30  함형석		   		
* 1.0 Creation 	 	   
* --------------------------------------------------------
* History
* 2011.11.03 신혜정 [CHM-201114270-01] Disposal Invoice Inquiry 화면 Invoice No. 체크박스 선택해서 Detail 정보 조회 가능하게 추가 요청
=========================================================*/
%>
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnrS308Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	  
<%
	EesMnrS308Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
				 
	String successFlag = ""; 
	String codeList  = "";
	String pageRows  = "100"; 
 		 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= ""; 
	String strRhq_cd 		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.DisposalMgt");
				        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
	    strRhq_cd = account.getRhq_ofc_cd();  
	    
		event = (EesMnrS308Event)request.getAttribute("Event");  
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
<title>Disposal Invoice Inquiry</title>	    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!--MNR 공용 사용  -->                
<script language="javascript">    
	var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if	 	 
		loadPage();
	}
</script> 
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>    
</head>	 
    
<body  onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">    
<input type="hidden" name="pagerows"> 	   
<!-- App Office를 구하기 위한 -->    
<input type="hidden" name="rhq_cd" value="<%=strRhq_cd%>">      	              
<input type="hidden" name="mnr_grp_tp_cd" value="DSP">        	              
<input type="hidden" name="file_seq" value="">      	              
<input type="hidden" name="disp_eml_flg" value="N">   
<input type="hidden" name="disp_search_type" value="">               	              
<input type="hidden" name="self_ofc_cd" value="<%=strOfc_cd%>">               	              
<input type="hidden" name="rqst_ofc_cd" value="">                 	              
<input type="hidden" name="rqst_usr_id" value="">                	              
<input type="hidden" name="in_disp_tp_cd" value="C">  
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="inv_no_list">

<!-- 개발자 작업	-->     
<!-- OUTER - POPUP (S)tart --> 
<table width="760" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Disposal Invoice Inquiry</td></tr>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">


				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="110">INV Date</td>
					<td width="230">
						<input name="from_dt" type="text" style="width:80;" dataformat="ymd" cofield="to_dt">&nbsp;~&nbsp;<input name="to_dt" type="text" style="width:80;" dataformat="ymd" cofield="from_dt">&nbsp;<img name="btn_period" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="80">Buyer</td>
					<td colspan="3">
						<input type="text" name="cust_cd" style="width:65;text-align:center" class="input2" readOnly="true" dataformat="engup" maxlength="6">&nbsp;<input type="text" name="cust_lgl_eng_nm" style="width:300" class="input2" readOnly="true"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="110">Invoice Number</td>
					<td width="230"><input name="inv_no" type="text" style="width:90;" class="input" dataformat="engup">&nbsp;<img name="btn_t1_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="150">Disposal(Bidding) No</td>
					<td width="120">
						<input name="disp_no" type="text" style="width:90;" class="input" dataformat="engup">&nbsp;<img name="btn_t2_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="90">	
						&nbsp;&nbsp;Release No</td>
					<td>	
						&nbsp;<input name="disp_rlse_no" type="text" style="width:90;" class="input" dataformat="engup">&nbsp;<img name="btn_t3_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr> 
				</table>			
				<!--  biz_1   (E) -->

		</td></tr>
		</table>	
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s"> Disposal Invoice List</td></tr>
				</table>
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
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Detail">Invoice&nbsp;Detail(s)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Collection">Collection&nbsp;Info</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
															
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">  Disposal Invoice Detail Information</td></tr>
				</table>
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
							<script language="javascript">ComSheetObject('sheet3');</script>
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
					<td class="btn2" name="btn_DownExcelDtl">Down Excel</td>
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

		<table class="height_8"><tr><td></td></tr></table>	
		
		</td></tr>
		</table>
		<!--biz page (E)-->
	</td></tr>  
</table>  
</form>
</html>