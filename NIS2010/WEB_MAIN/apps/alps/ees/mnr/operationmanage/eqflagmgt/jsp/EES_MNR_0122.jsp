<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0122.jsp
*@FileTitle : Damage Flagging/Unflagging
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0122Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0122Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 
	String strUsr_id		= ""; 
	String strUsr_nm		= ""; 
	String workApp 		    = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.EQFlagMgt");
	      
	try {    
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();      
		strUsr_nm = account.getUsr_nm();   
		workApp = account.getAccess_system(); 
	     
		event = (EesMnr0122Event)request.getAttribute("Event"); 
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
   
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">  
<input type="hidden" name="pagerows">   
<input type="hidden" name="eq_no">        
<input type="hidden" name="mnr_dmg_flg_dt" value=""> 
<input type="hidden" name="mnr_flg_tp_cd" value="">  
	        
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
					<td class="btn1" name="btn_retrive">Retrieve</td> 
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
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23"> 
					<td width="55">EQ Type</td>	  
					<td width="120"><script language="javascript">ComComboObject('eq_knd_cd',1, 100 , 1,1)</script></td>
					<td width="30">Yard</td>         
					<td width="105">	                    
					<input style="width:60;" type="text" name="mnr_dmg_flg_yd_cd" value='' dataformat="engup" maxlength="7" caption="yard cd" class="input" value="">&nbsp;<img src="img/btns_search.gif" name="btns_popup" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:pointer;cursor:hand"></td>
					<td width="45">EQ No.</td>	 		
					<td width="140"><input type="text" name="eq_list" style="width:100;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="65">Flag Type</td>  	  
					<td width="95"><script language="javascript">ComComboObject('flag_type',1, 80 , 1,1)</script></td>
					<td width="40">TP/SZ</td>  
					<td width="140">      
					<script language="javascript">ComComboObject('eq_tpsz_cd', 2, 120 ,0)</script>
					</td>     
					<td width="65">Over Days</td>	      
					<td><input name="mnr_dmg_flg_dt_over_day" type="text" style="width:60" class="input" value="" dataformat="int"></td>    
				</tr>		 	           
				</table>	 				
				<!--  biz_1   (E) -->		 
								
		</td></tr></table>	
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- 1 (E) -->

		
		<!-- 2 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
			<!-- grid box (S) -->
			<table class="search" > 
			<tr><td valign="top" width="58%" rowspan="4">	
					<table style="height:5"><tr><td></td></tr></table>	
					<!-- Grid-1  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%"> 
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>  
						</tr>
					</table> 	 				
					<!-- Grid-1 (E) -->	 
       				        
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_downExcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_loadExcel">Load Excel</td>   
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
				</td>
				<td valign="top" width="42%" style="padding-left:10px;" colspan="2">	

					<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">Equipment General Information</td></tr>
					</table>  
					
					<!-- Equipment General Information - 1 (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
						<tr>
							<td width="100%" style="padding-top:3px;" >
							<script language="javascript">ComSheetObject('sheet3');</script>
							</td> 
						</tr> 
						<tr> 
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table> 
					<!-- Equipment General Information - 1 (E) -->		
								
				</td>
			</tr>
			<tr><td valign="top" style="padding-left:10px;padding-top:5">	
					<table class="search">         
					<tr><td class="title_h"></td> 
						<td class="title_s"> Damage Flagging History</td></tr>
					</table>    
					<!-- Grid - Damage Flagging History (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
							</td>
						</tr>
					</table> 					
					<!-- Grid - Damage Flagging History (E) -->	
				</td></tr>    
			</table>
			<!-- grid box (E) -->
		</td></tr> 
		</table>			
		<!-- 2 (E) -->
		<!--biz page (E)--> 
	</td></tr>
		</table>

<!-- 개발자 작업  끝 -->     
</form>   
</body>   
</html> 