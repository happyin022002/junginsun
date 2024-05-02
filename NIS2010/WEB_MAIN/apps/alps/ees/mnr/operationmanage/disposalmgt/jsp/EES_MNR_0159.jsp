<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0159.jsp
*@FileTitle : Disposal Management 
*Open Issues :      
*Change history :   
*@LastModifyDate : 2009.09.17  
*@LastModifier : 박명신     
*@LastVersion : 1.0    
* 2009.07.01 박명신		   		
* 1.0 Creation 	 	   
* 2011.03.03 김영오  Start Date/End Date Logic, 제목 수정 기존 YYYY-MM-DD에서 뒤에 시분초 까지 보여지도록 수정
* 2012.01.12 신혜정 [CHM-201215612-01] Bidding 프로세싱중인 데이터 Confirm 불가토록 로직 수정   
* 2013.09.27 조경완 [CHM-201326609-01] ALPS MNR-Disposal-Disposal Management에서 비딩 결과를 이메일로 통보해주는 기능
* 2015.08.24 박정민 [CHM-201537246] Disposal RQST 삭제 권한 조정- DISPOSAL MANAGEMENT에서 본사는 OFC 수정해서 사용하도록 적용 
=========================================================*/
%>
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0159Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	  
<% 
	EesMnr0159Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	     	 		 
	String successFlag = ""; 
	String codeList  = "";
	String pageRows  = "100"; 
 		 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= ""; 
	String strRhq_ofc_cd 		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.DisposalMgt");
				        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
	    strRhq_ofc_cd = account.getRhq_ofc_cd();  
	    
		event = (EesMnr0159Event)request.getAttribute("Event");  
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
var currOfcCd = '<%=strOfc_cd %>';
var rhqOfcCd  = '<%=strRhq_ofc_cd %>';

	// Delete등 삭제후 다시 사용할때 잠시 사용하게되는 보관용 ofcCd
	var tmpOfcCd = "";
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
<input type="hidden" name="rhq_cd" value="<%=strRhq_ofc_cd%>">      	              
<input type="hidden" name="mnr_grp_tp_cd" value="DSP">        	              
<input type="hidden" name="file_seq" value="">      	              
<input type="hidden" name="disp_eml_flg" value="N">   
<input type="hidden" name="disp_search_type" value="manage">                	              
<input type="hidden" name="apro_ofc_cd" value="">                     	              
<input type="hidden" name="rqst_usr_id" value="">                 	              
<input type="hidden" name="apro_dt" value="">                     	              
<input type="hidden" name="apro_usr_id" value="">       
<input type="hidden" name="org_disp_end_dt" value="">
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
					<td class="btn1" name="btn_ReBidding">Re-Bidding</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>      
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_send">Email Send</td>
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
					<td width="270" valign="top">
						<table class="search_" border="0" style="width:270;">
							<tr class="h23">  
								<td width="77">App. DT</td>	     
								<td width=""> 	
									<input type="text" name="in_apro_st_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="9"  cofield="in_apro_end_dt" value="" class="input">      
      									~ <input type="text" name="in_apro_end_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="9"  cofield="in_apro_st_dt" class="input">&nbsp;<img name="btn_apro_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td> 	
							</tr>    
							<tr class="h23">     	 
								<td width="">Disposal No.</td> 
								<td width=""><input type="text" name="disp_no_list" style="width:162;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="disp_no_multi"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>	 
							<tr class="h23">     	 
								<td width="">EQ No.</td> 
								<td width=""><input type="text" name="eq_no_list" style="width:162;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>	  
							<tr class="h23">  
								<td width="">Sale Type</td>  
								<td width="" style="padding-left:2"> 
								<script language="javascript">ComComboObject('in_disp_tp_cd', 1, 125, 1, 1,0,false,0);</script>
								</td>	 
							</tr>	 
							<tr class="h23">    
								<td width="">Status</td>     
								<td width="" style="padding-left:2">  
								<script language="javascript">ComComboObject('in_disp_sts_cd', 1, 125, 1, 1,0,false,0);</script> 
								</td> 
							</tr> 
							<tr class="h23">    
								<td width="">Office</td>     
								<td width="">  
								<input type="text" name="self_ofc_cd" style="width:100px;" class="input2" readonly value="<%=strOfc_cd %>" dataformat="engup"> 
								</td> 
							</tr> 
						</table>	
					</td>
					<td width="709"> 
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
       		<table class="search" border="0" style="width:979;"> 
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
								<td width="65">SaleType</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('disp_tp_cd', 1, 102, 1, 1,0,false,0);</script></td>
								<td width="65">Req Office</td>    
								<td width=""><input type="text" name="rqst_ofc_cd" style="width:100" value="" class="input2" readOnly></td> 
							</tr> 
							<tr class="h23"> 
								<td width="">Currency</td>	 	
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('curr_cd', 1, 102, 1, 1,0,false,0);</script></td>
								<td width="75">Total Q'ty</td> 
								<td width="120"><input type="text" name="disp_qty" style="width:100;text-align:right" value="" class="input2" dataformat="int" readOnly></td>
								<td width="75">Total AMT</td>
								<td width=""><input type="text" name="disp_st_prc" style="width:100;text-align:right" value="" class="input2" dataformat="float" pointcount="2" readOnly></td>
							</tr>			   
						</table> 	
						<table border="1" style="width:575; background-color:white;" class="grid2"> 
							<tr>
							<td class="tr2_head" colspan="2">Open Bidding Requirement</td>  
							<td class="tr2_head2" width="114">Start&nbsp;Time/Close&nbsp;Time</td>
							<td colspan="2">
							<input type="text" name="disp_st_dt" dataformat="ymdhms"    caption="from date"        maxlength="14"  size="16"  cofield="disp_end_dt" value="" class="input">   
	                              	~ <input type="text" name="disp_end_dt" dataformat="ymdhms"    caption="to date"        maxlength="14"  size="16"  cofield="disp_st_dt" class="input">&nbsp;<img name="btn_biding_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
	                        </td>       	
							</tr>  	 
							<tr> 	
							<td class="tr2_head2" width="70">Posting DT</td>
							<td width="100">   
							<input type="text" class="input" name="disp_bultn_dt" dataformat="ymd" maxlength="8"  size="9">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="btn_postdt" align="absmiddle">
							</td> 
							<td class="tr2_head2" width="90" style="color:black">Pick Up Period</td>
							<td>       
							<input type="text" name="disp_pkup_st_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="9"  cofield="disp_pkup_end_dt" value="" class="input">   
	                              	~ <input type="text" name="disp_pkup_end_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="9"  cofield="disp_pkup_st_dt" class="input">&nbsp;<img name="btn_pickup_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>        
							<td width=""><input name="disp_eml_flg_temp" type="checkbox" class="trans">E-mail Notice</td>
							</tr>   
						</table>	
					</td>		
					<td width="100%">  
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
			
			
		<table class="search" border="0" style="width:979;">  
		<tr class="h23">
		<td width="500" valign="top">
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
						<td class="btn2" name="btn_ResultInfo">Result&nbsp;Info</td> 
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
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		</td>
		<td width="10"></td>
		   
		<td valign="top" width="469" style="padding-top:4">   
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Result Info.</td>
				</tr>  
			</table>
					
			<script language="javascript">ComSheetObject('sheet4');</script>
		</td>
		
		<table class="line_bluedot"><tr><td></td></tr></table>	
			<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
		<td width="620" valign="top" style="padding: 20 0 0 0">
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
			<tr><td class="tr2_head" width="14%">Remark(s)</td>  
				<td>     
				<textarea name="mnr_disp_rmk" wrap="off"  style="width:100%;height:60;" maxLength="4000"></textarea>
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
						<script language="javascript">ComSheetObject('sheet5');</script>
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
	</td></tr>
		</table>
		<!--biz page (E)-->
	</td></tr>  
		</table>
</td>
</tr>
</table>		  
</form>
</html>