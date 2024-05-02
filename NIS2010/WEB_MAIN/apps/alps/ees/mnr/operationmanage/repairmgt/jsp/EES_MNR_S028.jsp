<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S028.jsp
*@FileTitle : M&R Repair Inquiry
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.09.24 
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.24 박명신		   		
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnrS028Event"%>
<%@ page import="org.apache.log4j.Logger" %>
		 
<%
	EesMnrS028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
				 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 		 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
								        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd(); 
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
						
		event = (EesMnrS028Event)request.getAttribute("Event"); 
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
<title>Repair Inquiry</title>     
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--MNR 공용 사용  -->	                
<script language="javascript"> 
    var strVndrSeq = "<%=strVndr_seq%>";
    strVndrSeq = ComLpad(strVndrSeq,6,"0");
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
<input type="hidden" name="tpb_only" value="N">
<input type="hidden" name="rpr_rqst_seq">   
<input type="hidden" name="rpr_rqst_ver_no">   	
<input type="hidden" name="user_nm" value="<%=strUsr_nm%>">     	
		
<!-- RD용  --> 
<input type="hidden" name="com_mrdPath" value="">  
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" value="">
  		
<!-- 개발자 작업	-->    
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Repair Inquiry</td></tr>
		</table>	
		<!--Page Title, Historical (E)--> 
				
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
					<td width="67">W/O Type </td>	
					<td width="150" style="padding-left:0;"><script language="javascript">ComComboObject('wo_type', 1, 95, 1, 0,0,false,0);</script></td> 
					<td width="60">EQ Type</td>	
					<td width="140" style="padding-left:0;"><script language="javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 0,0,false,0);</script></td> 
					<td width="70">Input Dt.</td>		   
					<td width="240"><input style="width:80" required type="text" name="fm_est_dt" dataformat="ymd" caption="from date"  maxlength="8"  size="9"  cofield="to_est_dt" value="" class="input1" style="text-align:center">   
	                              	~ <input style="width:80" required type="text" name="to_est_dt" dataformat="ymd" caption="to date"    maxlength="8"  size="9"  cofield="fm_est_dt" class="input1" style="text-align:center">&nbsp;<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>		
					<td width="45">Status</td>		    
					<td><script language="javascript">ComComboObject('status_cd', 1, 110, 1, 0,0,false,0);</script>
					</td>		 		 	  	
				</tr>			  
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">     
					<td width="67">EQ No.</td>
					<td width="150"><input name="rqst_eq_no" type="text" style="width:98" class="input" dataformat="engup" value="">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>   
					<td width="60">EST No.</td>
					<td width="140"><input name="rqst_ref_no" type="text" style="width:74" class="input" dataformat="engup" value="">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi2"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td> 
					<td width="70">W/O No.</td> 
					<td width="240"><input name="wo_no" type="text" style="width:132" class="input" dataformat="engup" value="">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi3"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>     
					<td width="">TPB Request Only <input name="temp_tpb_only" type="checkbox" value="Y" class="trans"></td> 
				</tr>  
				</table>	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">	  
				<td width="100">Service Provider</td> 
				<td width="317"><input type="text" name="vndr_seq" caption="Service Provider" style="width:55;text-align:center;" class="input2" value="" readonly>&nbsp;<input type="text" name="vndr_nm" caption="Service Provider" style="width:215;" class="input2" value="<%=strVndr_nm %>" readonly></td>	 
				<td width="70">C.Office</td>     
				<td width=""><input name="cost_ofc_cd" type="text" style="width:98" class="input2" dataformat="engup" value="<%=strOfc_cd %>" readOnly></td>
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
					<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn2_right"></td>
					</tr> 
					</table></td>
						
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Detail">Detail(s)</td> 
					<td class="btn2_right"></td> 
					</tr>
					</table></td>
						 	
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Print">Print</td>
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