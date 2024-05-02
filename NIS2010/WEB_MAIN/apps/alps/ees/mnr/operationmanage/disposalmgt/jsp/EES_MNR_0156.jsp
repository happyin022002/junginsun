<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0156.jsp
*@FileTitle : Disposal Request 
*Open Issues :     
*Change history :   
*@LastModifyDate : 2009.09.08
*@LastModifier : 박명신 
*@LastVersion : 1.0 
* 2009.07.01 박명신		   		
* 1.0 Creation 	 	   
* 2011.03.03 김영오  Start Date/End Date Logic, 제목 수정 기존 YYYY-MM-DD에서 뒤에 시분초 까지 보여지도록 수정
* 2012.07.03 김창헌 [CHM-201218462-01] Load Excel 보턴/Format 및 Load Excel 기능 개발
* 2013.04.25 조경완 [CHM-201324321-01] [MNR] 동일 장비에 대해 중복 Disposal Request되는 현상 제거를 위한 기능 보완
=========================================================*/
%>
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0156Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	  
<%
	EesMnr0156Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	    
		event = (EesMnr0156Event)request.getAttribute("Event"); 
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
	var ofcCd = "<%=strOfc_cd%>";	  
	function setupPage(){  		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if	 	 
		loadPage();
	}
</script> 
<script language="javascript">ComSheetObject('sheet1');</script> 
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
<input type="hidden" name="disp_eml_flg" value="Y">    
<input type="hidden" name="disp_search_type" value="request">              	              
<input type="hidden" name="self_ofc_cd" value="<%=strOfc_cd%>">              	              
<input type="hidden" name="rqst_ofc_cd" value="<%=strOfc_cd%>">              	              
<input type="hidden" name="eq_no_list" value="">
<input type="hidden" name="selected_buyer" value="">

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
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
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
					<td width="220" valign="top">
						<table class="search_" border="0" style="width:200;"> 
							<tr class="h23"> 
								<td width="">SaleType</td> 
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('in_disp_tp_cd', 1, 100, 1, 1,0,false,0);</script>
								</td> 
								</tr> 
							<tr class="h23"> 
								<td width="85">Req. Office</td>   
								<td width=""><input type="text" name="in_rqst_ofc_cd" style="width:100" value="<%=strOfc_cd%>" class="input2" dataformat="engup" readOnly></td>
							</tr>   
							<tr class="h23"> 
								<td width="">User ID</td>
								<td width=""><input type="text" name="in_rqst_usr_id" style="width:100" value="<%=strUsr_id%>" class="input2" dataformat="engup" readOnly></td> 
							</tr>	 
						</table>	
					</td>
					<td width="759"> 
					<!-- Grid  1(S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%"> 
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid  1(E) -->
					</td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
       		<table class="search" border="0">
       		<tr>
       			<td width="605" valign="top"> 
       				<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Disposal Information
							</td>
						</tr>    
					</table>
       			</td> 
       			<td width="" align ="left">    
       				<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Buyer Selection</td>
							<td>
							<table width="100" border="0" cellpadding="0" cellspacing="0" class="button" align="right">
								<tr>
									<td class="btn2_left" style="border:0 !important; padding:0 !important;"></td>
									<td class="btn2" name="btn_buyerPopUp" style="border:0 !important; padding:0 !important;">Buyer Inquiry</td>
									<td class="btn2_right" style="border:0 !important; padding:0 !important;"></td>
								</tr>
							</table>
							</td>
						</tr>  
					</table>
       			</td>
       		</tr>
       		</table>
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="605" valign="top">
						<table class="search" border="0" style="width:600;"> 
							<tr class="h23">  
								<td width="75">Disposal No.</td>
								<td width="120"><input type="text" name="disp_no" style="width:100" value="" class="input2" readOnly></td>
								<td width="75">Request DT</td>
								<td width="128"><input type="text" name="rqst_dt" style="width:100" value="" class="input2" readOnly></td>
								<td width="75">Status</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('disp_sts_cd', 1, 102, 1, 3,0,false,0);</script></td>
							</tr> 
							<tr class="h23"> 
								<td width="">EQ Type</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('eq_knd_cd', 1, 102, 1, 1,0,false,0);</script></td>
								<td width="">SaleType</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('disp_tp_cd', 1, 102, 1, 1,0,false,0);</script></td>
								<td width="">App Office</td> 
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('apro_ofc_cd', 1, 102, 1, 1,0,false,0);</script></td>
							</tr> 
							<tr class="h23">
								<td width="">Currency</td>	 	 
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('curr_cd', 1, 102, 1, 1,0,false,0);</script></td>
								<td width="">Total Q'ty</td> 
								<td width=""><input type="text" name="disp_qty" style="width:100;text-align:right" value="" class="input2" dataformat="int" readOnly></td>
								<td width="">Total AMT</td>
								<td width=""><input type="text" name="disp_st_prc" style="width:100;text-align:right" value="" class="input2" dataformat="float" pointcount="2" readOnly></td>
							</tr>			   
						</table> 	
						<table border="0" style="width:575; background-color:white;" class="grid2"> 
							<tr>
							<td class="tr2_head" colspan="2">Open Bidding Requirement</td> 
							<td class="tr2_head2" width="90">Start/Close Time</td>
							<td colspan="2">
							<input type="text" name="disp_st_dt" dataformat="ymdhms"    caption="from date"        maxlength="14"  size="18"  cofield="disp_end_dt" value="" class="input">   
	                              	~ <input type="text" name="disp_end_dt" dataformat="ymdhms"    caption="to date"        maxlength="14"  size="18"  cofield="disp_st_dt" class="input">&nbsp;<img name="btn_biding_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
	                        </td>       	
							</tr>  	 
							<tr> 	
							<td class="tr2_head2" width="80">Posting DT</td>
							<td width="100">   
							<input type="text" class="input" name="disp_bultn_dt" dataformat="ymd" maxlength="8"  size="9">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="btn_postdt" align="absmiddle">
							</td> 
							<td class="tr2_head2" width="90" style="color:black">Pick Up Period</td> 
							<td>      
							<input type="text" name="disp_pkup_st_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="10"  cofield="disp_pkup_end_dt" value="" class="input">   
	                              	~ <input type="text" name="disp_pkup_end_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="10"  cofield="disp_pkup_st_dt" class="input">&nbsp;<img name="btn_pickup_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>        
							<td width=""><input name="disp_eml_flg_temp" type="checkbox" class="trans">E-mail Notice</td>
							</tr>   
						</table>	
					</td>		
					<td width="474">
					<!-- Grid  2(S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- Grid 2 (E) -->
					</td>
					</tr> 
				</table>
				<!--  biz_2   (E) -->
				
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
		
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
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg"> 
				<table border="0" cellpadding="0" cellspacing="0"><tr class="h23">
						
						
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_loadExcel">Load Excel</td>
						<td class="btn2_right">
					</tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><img class="cursor" src="img/btn_file.gif" width="17" height="18" border="0" align="absmiddle" name="btns_DownFile" alt="Load Excel Templet File DownLoad!">&nbsp;&nbsp;&nbsp;
					</tr>
					</table></td>
						
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>   
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Excel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Inquiry">Candidate EQ Inq.</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td> 
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    
		<table class="line_bluedot"><tr><td></td></tr></table>
		
		
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
			<td width="620" valign="top" style="padding: 20 0 0 0">
				
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td class="tr2_head" width="14%">Remark(s)</td>  
					<td>     
					<textarea name="mnr_disp_rmk" wrap="off" style="width:100%;height:60;" maxLength="4000"></textarea>
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
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>
			<!-- Grid 4(E) -->		
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">  
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr class="h23">

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_FileAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_FileDelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td> 
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->	
			</td></tr></table>
		
		<!--biz page (E)-->
	</td></tr>  
		</table> </td></tr>  
		</table>   

<div style="display:none">
<script language="javascript">ComSheetObject('sheet5');</script> 
<script language="javascript">ComSheetObject('sheet6');</script>
</div> 
</form>
</html>