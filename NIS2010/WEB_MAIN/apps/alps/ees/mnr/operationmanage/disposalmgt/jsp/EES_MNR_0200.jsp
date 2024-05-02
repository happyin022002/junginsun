<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0200.jsp
*@FileTitle : Disposal Detail Information Popup
*Open Issues :      
*Change history :   
*@LastModifyDate : 2009.09.28
*@LastModifier : 함형석     
*@LastVersion : 1.0    
* 2009.09.28  함형석		   		
* 1.0 Creation 	 	 
* History
* 2011.03.03 김영오 [CHM-201110721-01] Start Date/End Date Logic, 제목 수정 기존 YYYY-MM-DD에서 뒤에 시분초 까지 보여지도록 수정  
=========================================================*/
%>
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0200Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	  
<%
	EesMnr0200Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	
	String dispTpCd = ((request.getParameter("disp_tp_cd")==null )?"":request.getParameter("disp_tp_cd"));	
	String dispNo = ((request.getParameter("disp_no")==null )?"":request.getParameter("disp_no"));
	String eqKndCd = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));
	String dispQty = ((request.getParameter("disp_qty")==null )?"":request.getParameter("disp_qty"));
	String dispStPrc = ((request.getParameter("disp_st_prc")==null )?"":request.getParameter("disp_st_prc"));
	String dispBultnDt = ((request.getParameter("disp_bultn_dt")==null )?"":request.getParameter("disp_bultn_dt"));
	String rqstOfcCd = ((request.getParameter("rqst_ofc_cd")==null )?"":request.getParameter("rqst_ofc_cd"));
	String rqstUsrId = ((request.getParameter("rqst_usr_id")==null )?"":request.getParameter("rqst_usr_id"));
	String rqstDt = ((request.getParameter("rqst_dt")==null )?"":request.getParameter("rqst_dt"));
	String dispStsCd = ((request.getParameter("disp_sts_cd")==null )?"":request.getParameter("disp_sts_cd"));
	String dispStDt = ((request.getParameter("disp_st_dt")==null )?"":request.getParameter("disp_st_dt"));
	String dispEndDt = ((request.getParameter("disp_end_dt")==null )?"":request.getParameter("disp_end_dt"));
	String dispPkupStDt = ((request.getParameter("disp_pkup_st_dt")==null )?"":request.getParameter("disp_pkup_st_dt"));
	String dispPkupEndDt = ((request.getParameter("disp_pkup_end_dt")==null )?"":request.getParameter("disp_pkup_end_dt"));
	String aproOfcCd = ((request.getParameter("apro_ofc_cd")==null )?"":request.getParameter("apro_ofc_cd"));
	String currCd = ((request.getParameter("curr_cd")==null )?"":request.getParameter("curr_cd"));
	String dispEmlFlg = ((request.getParameter("disp_eml_flg")==null )?"":request.getParameter("disp_eml_flg"));
	String fileSeq = ((request.getParameter("file_seq")==null )?"":request.getParameter("file_seq"));
	String mnrDispRmk = ((request.getParameter("mnr_disp_rmk")==null )?"":request.getParameter("mnr_disp_rmk"));
		
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.DisposalMgt");
				        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
	    strRhq_cd = account.getRhq_ofc_cd();  
	    
		event = (EesMnr0200Event)request.getAttribute("Event");  
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
<title>Disposal Detail Infomation</title>	    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!--MNR 공용 사용  -->                
<script language="javascript">    
	function setupPage(){  
		var formObj = document.form; 
		formObj.disp_no.value = "<%=dispNo%>";
	 	formObj.app_ofc_cd.value = "<%=aproOfcCd%>";
		formObj.disp_qty.value = ComAddComma2("<%=dispQty%>", "#,###");				
		formObj.disp_st_prc.value = ComAddComma2("<%=dispStPrc%>", "#,###");
		formObj.rqst_ofc_cd.value = "<%=rqstOfcCd%>";    
		formObj.rqst_usr_id.value = "<%=rqstUsrId%>";     
																
		//Combo는 IBCLEAR 에서 다시 세팅		 																			
		formObj.temp1.value   = "<%=dispTpCd%>";							
		formObj.temp2.value   = "<%=eqKndCd%>";		
		formObj.temp3.value   = "<%=dispStsCd%>";
		formObj.temp4.value   = "<%=currCd%>";	   	
													        													
		loadPage();	
												
		formObj.disp_pkup_st_dt.value = "<%=dispPkupStDt%>";
		formObj.disp_pkup_end_dt.value = "<%=dispPkupEndDt%>";
		formObj.disp_st_dt.value = "<%=dispStDt%>";
		formObj.disp_end_dt.value = "<%=dispEndDt%>";
		formObj.rqst_dt.value = "<%=rqstDt%>";
		formObj.disp_bultn_dt.value = "<%=dispBultnDt%>";
		
		if("<%=dispEmlFlg%>" == 'Y'){ 	 
			formObj.disp_eml_flg.value = 'Y'; 	
			formObj.disp_eml_flg_temp.checked = true; 	
		} else {		
			formObj.disp_eml_flg.value = 'N'; 
			formObj.disp_eml_flg_temp.checked = false; 
		}	
		formObj.mnr_disp_rmk.value = "<%=mnrDispRmk%>";
			
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} 
	}
</script> 
<script language="javascript">ComSheetObject('sheet1');</script> 
<script language="javascript">ComSheetObject('sheet2');</script> 
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
		<input type="hidden" name="delt_flg" value="delete">  
		<input type="hidden" name="disp_search_type" value="approval">               	              
		<input type="hidden" name="self_ofc_cd" value="<%=strOfc_cd%>">               	              
		<input type="hidden" name="rqst_ofc_cd" value="">                  	              
		<input type="hidden" name="rqst_usr_id" value="">                	              
		<input type="hidden" name="fileSeq" value="<%=fileSeq%>">  
		
		<input type="hidden" name="temp1" value="">  	
		<input type="hidden" name="temp2" value=""> 	 
		<input type="hidden" name="temp3" value="">  	
		<input type="hidden" name="temp4" value="">  	

<!-- 개발자 작업	-->     
		<table width="800" cellpadding="" cellspacing=0 border="0"> 
			<tr>
				<td class="top">
	
		<!-- OUTER - POPUP (S)tart -->
		<table width="100%" class="popup" cellpadding="10" border="0"> 
			<tr><td class="top"></td></tr>
			<tr>
				<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Disposal Detail Information </td></tr>
		</table>  
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
       		<table class="search" border="0">
       		<tr>
       			<td width="750" valign="top"> 
       				<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Disposal Information
							</td>
						</tr>    
					</table>
       			</td>
       			<td width="474">  
       				<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Buyer Selection</td>
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
									<td width="120"><input type="text" name="disp_no" style="width:100"  class="input2" readOnly></td>
									<td width="75">Request DT</td>
									<td width="120"><input type="text" name="rqst_dt" style="width:100"  class="input2" readOnly></td>
									<td width="75">Status</td>
									<td width=""><script language="javascript">ComComboObject('disp_sts_cd', 1, 104, 1, 3,0,false,0);</script></td>
								</tr> 
								<tr class="h23"> 
									<td width="">EQ Type</td>
									<td width=""><script language="javascript">ComComboObject('eq_knd_cd', 1, 104, 1, 1,0,false,0);</script></td>
									<td width="65">SaleType</td>	
									<td width=""><script language="javascript">ComComboObject('disp_tp_cd', 1, 104, 1, 1,0,false,0);</script></td>
									<td width="65">APP Office</td>	
									<td width=""><input type="text" name="app_ofc_cd" style="width:104"  class="input2" readOnly></td>
								</tr> 
								<tr class="h23">
									<td width="">Currency</td>	 	
									<td width=""><script language="javascript">ComComboObject('curr_cd', 1, 104, 1, 1,0,false,0);</script></td>
									<td width="75">Total Qty</td> 
									<td width="120"><input type="text" name="disp_qty" style="width:100;text-align:right" value="" class="input2" dataformat="int" readOnly></td>
									<td width="75">Total AMT</td>
									<td width=""><input type="text" name="disp_st_prc" style="width:100;text-align:right" value="" class="input2" dataformat="float" pointcount="2" readOnly></td>
								</tr>			   
							</table> 	
							<table border="0" style="width:575; background-color:white;" class="grid2"> 
								<tr>
								<td class="tr2_head" colspan="2">Public Bid Setting</td>
								<td class="tr2_head2" width="90">Start/Close Time</td>
								<td colspan="2">
								<input type="text" name="disp_st_dt" dataformat="ymdhms"    caption="from date"        maxlength="14"  size="20"  cofield="disp_end_dt" value="" class="input">   
		                              	~ <input type="text" name="disp_end_dt" dataformat="ymdhms"    caption="to date"        maxlength="14"  size="20"  cofield="disp_st_dt" class="input">&nbsp;<img name="btn_biding_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
		                        </td>       	
								</tr>  	 
								<tr> 	
								<td class="tr2_head2" width="80">Posting DT</td>
								<td width="100">   
								<input type="text" class="input" name="disp_bultn_dt" dataformat="ymd" maxlength="8"  size="10">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="btn_postdt" align="absmiddle">
								</td> 
								<td class="tr2_head2" width="90" style="color:red">Pick Period</td>
								<td>      
								<input type="text" name="disp_pkup_st_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="10"  cofield="disp_pkup_end_dt" value="" class="input">   
		                              	~ <input type="text" name="disp_pkup_end_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="10"  cofield="disp_pkup_st_dt" class="input">&nbsp;<img name="btn_pickup_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td>        
								<td width=""><input name="disp_eml_flg_temp" type="checkbox" class="trans" disabled="true">E-mail Notice</td>
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
				</td>
			</tr>
		</table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">	
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="600" valign="top">
								<!-- Tab (S) -->
						     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
						            <tr>
						            	<td width="100%">
											<script language="javascript">ComTabObject('tab1')</script>
											<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
										</td>
									</tr>
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
							</td>
							<td width="10">&nbsp;</td>
							<td valign="top" width="469" style="padding-top:4">   
								<table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s">Result Info.</td>
									</tr>  
								</table>
										
								<script language="javascript">ComSheetObject('sheet5');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
				
		<table class="height_5"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">	
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td class="search" width="585" valign="top" style="padding: 20 0 0 0">
								<table border="0" style="width:100%; background-color:white;" class="grid2"> 
									<tr>
										<td class="tr2_head" width="14%">Remark(s)</td>  
										<td>     
											<textarea name="mnr_disp_rmk" style="width:100%;height:65;" maxLength="4000"></textarea>
										</td>  
									</tr> 
								</table>
							</td>
							<td width="10">&nbsp;</td>
							<td valign="top" width="width:100%;" style="padding-top:4">   
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">File Attach</td>
									</tr>  
								</table>
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		<table class="height_5"><tr><td></td></tr></table>
		<!-- : ( Button : pop ) (S) -->
		<table width="100%" class="sbutton">
			<tr>
				<td height="71" class="popup">
			    	<!--Button (S) -->	
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
						<tr>
							<td class="btn3_bg">
								 <table border="0" cellpadding="0" cellspacing="0">
								    <tr>	
										<td class="btn3_bg">
										    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td>
													<td class="btn1" name="btn_Close">Close</td>
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
				</td>
			</tr>
		</table>
				</td>
			</tr>  
		</table>
		<!-- : ( Button : pop ) (E) -->	
				</td>
			</tr>  
		</table>
		</form>
	</body>
</html>