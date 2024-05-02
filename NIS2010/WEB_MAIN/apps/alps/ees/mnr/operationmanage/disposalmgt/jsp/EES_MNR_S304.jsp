<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S304.jsp
*@FileTitle : My Bidding List 
*Open Issues :     
*Change history :   
*@LastModifyDate : 2009.12.03
*@LastModifier : 김완규 
*@LastVersion : 1.0 
* 2009.12.03 김완규		   	  	
* 1.0 Creation 	 	   
* 2011-04-11 김영오
* 1.LEFT TIME 현지 OFFICE 시각에서 로컬타임 구하는 function 변경으로 변경
GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, SYSDATE, @OFC_CD)
->GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@OFC_CD)
* 2. disposal Local Time 항목추가하여 사용자 로그인 로컬타임을 화면에 표시
=========================================================*/
%>
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnrS304Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	  
<%
	EesMnrS304Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	
		
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.DisposalMgt");
					        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();        
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
	    strRhq_cd = account.getRhq_ofc_cd();   
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
	    
		event = (EesMnrS304Event)request.getAttribute("Event"); 
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
<title>My Bidding List</title>	    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!--MNR 공용 사용  -->                
<script language="javascript">  
    var strVndrSeq	= "<%=strVndr_seq%>";
    var strVndrNm	= "<%=strVndr_nm%>";
    var userNm		= "<%=strUsr_nm%>";
    var spPtalId    = "<%=strUsr_id %>";
    var ofcCd 		= "<%=strOfc_cd%>";
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if	 	 
		loadPage();
	}
</script> 
<script language="javascript">ComSheetObject('sheet1');</script> 
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>    
</head>	 
    
<body  onLoad="setupPage();"> 
<form name="form">  
<input type="hidden" name="f_cmd">    
<input type="hidden" name="pagerows"> 	   
<input type="hidden" name="sp_ptal_id" value="<%=strUsr_id %>"> 
<input type="hidden" name="selected_disp_no"> 
<input type="hidden" name="file_seq" value=""> 
<input type="hidden" name="program_id" value="S304">     	              
<input type="hidden" name="ofc_cd" value="">    	              
<!-- RD용  --> 
<input type="hidden" name="com_mrdPath" value="">  
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" value="My Bidding List">

<!-- 개발자 작업	-->    
<!-- OUTER - POPUP (S)tart -->
<table width="755" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   My Bidding List</td></tr>
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
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23"> 
						<td width="90">Starting Date</td>
						<td width="210" style="padding-left:1">
						<input type="text" name="disp_st_dt_fm" dataformat="ymd" caption="from date" maxlength="8" size="9" cofield="disp_st_dt_to" value="" class="input">   
                         ~ <input type="text" name="disp_st_dt_to" dataformat="ymd" caption="to date" maxlength="8"  size="9"  cofield="disp_st_dt_fm" class="input">&nbsp;<img name="disp_st_dt_cal" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                        </td>       	
						<td width="75">Bidding No.</td>   
						<td width="175"><input type="text" name="disp_no" style="width:140" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="disp_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width="45">EQ No.</td>
						<td><input type="text" name="eq_no" style="width:140;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23"> 
						<td width="88">Result</td> 
						<td width="193"> 
						<script language="javascript">ComComboObject('result', 1, 90, 1, 0);</script>
						</td> 
						<td width="100">Bidding Status</td> 
						<td width="140"> 
						<script language="javascript">ComComboObject('bidding_status', 1, 113,0);</script>
						</td>       	
						<td width="70">&nbsp;Local Time</td>   
						<td width="140"><input type="text" name="disp_local_dt" style="width:140;text-align:left;ime-mode:disabled" class="input2" readonly></td>
					</tr>   
				</table>				
				<!--  biz_1   (E) -->
				
		<table class="line_bluedot"><tr><td></td></tr></table>	
	       		<table class="search" border="0">
	       		<tr>
	       			<td width="100%" valign="top"> 
	       				<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">My List
								</td>
							</tr>    
						</table>
	       			</td>
	       		</tr>
	       		</table>
       		
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				    <td width="100%">
						<!-- Grid  2(S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid 2 (E) -->
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
				       	<tr><td class="btn2_bg"> 
							<table border="0" cellpadding="0" cellspacing="0"><tr class="h23">
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_BiddingDetail">Bidding Detail</td>
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
						
					</td>
					</tr> 
				</table>
				<!--  biz_2   (E) -->
				
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
		    <table class="search" border="0">
       		<tr>
       			<td width="100%" valign="top"> 
       				<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Bidding Detail & My Offer
							</td>
						</tr>    
					</table>
       			</td>
       		</tr>
       		</table>
		
			<!-- Tab (S) -->
	     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
	            <tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
			</table>
			<!-- Tab (E) -->

			<!-- Grid  3(S) -->
			<div id="tabLayer" style="display:inline">
				<table width="100%"  id="mainTable"> 
					<tr> 
						<td width="100%">
							<script language="javascript">ComSheetObject('t1_sheet1');</script>
						</td>
					</tr>
				</table>
			</div>

			<div id="tabLayer" style="display:none">
				<table width="100%"  id="mainTable"> 
					<tr>			
						<td width="100%">
							<script language="javascript">ComSheetObject('t2_sheet1');</script>
						</td>
					</tr>
				</table>
			</div>
			<!-- Grid (E) -->
			
			<table class="line_bluedot"><tr><td></td></tr></table>
		
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			<td width="420" valign="top" style="padding: 20 0 0 0">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td class="tr2_head" width="14%">Bidding<br>Remark(s)</td>  
					<td>     
					<textarea name="mnr_disp_rmk" wrap="off" style="width:100%;height:60;" readOnly ></textarea>
					</td>  
				</tr> 
				</table>
			</td>
			<td width="20">&nbsp;</td> 
			<td width="">  
			<table class="search" border="0"> 
				<tr><td class="title_h"></td>  
					<td class="title_s">File Attachment</td></tr>
			</table>
			<!-- Grid 4 (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
			<!-- Grid 4(E) -->		
			
			</td></tr></table>
		
		<!--biz page (E)-->
		
		</td></tr>  
		</table> 
		<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">	
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcelDetail">Detail&nbsp;Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Submit">Submit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cancel">Cancel</td>
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
	
	</td></tr>
	</table>   
</form>
</body>
</html>