<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0192.jsp
*@FileTitle : Repair Estimate Creation Pop up
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.07.01
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.07.01 박명신		   		
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0192Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EesMnr0192Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	String rqstEqNo = ((request.getParameter("rqst_eq_no")==null )?"":request.getParameter("rqst_eq_no"));
	String rprRqstSeq = ((request.getParameter("rpr_rqst_seq")==null )?"":request.getParameter("rpr_rqst_seq"));
	String rprRqstVerNo = ((request.getParameter("rpr_rqst_ver_no")==null )?"":request.getParameter("rpr_rqst_ver_no"));
	String eqKndCd = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));
	String recentRprTpCd = ((request.getParameter("recent_rpr_tp_cd")==null )?"":request.getParameter("recent_rpr_tp_cd"));
	String estTemp = ((request.getParameter("est_temp")==null )?"":request.getParameter("est_temp"));
    	   								
	//String rqstEqNo = "SMCU3400507";             
	//String rprRqstSeq = "1";   
	//String rprRqstVerNo = "2";               
	//String eqKndCd = "U";             
				
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();	       
		strUsr_nm = account.getUsr_nm(); 	   
	    strOfc_cd = account.getOfc_cd();   	 
			
		event = (EesMnr0192Event)request.getAttribute("Event"); 
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
<title>Estimate Detail Info</title>
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
    
<body class="popup_bg"  onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">   
<input type="hidden" name="pagerows">   
<!-- 견적서발급과 감사를 구분하기위한 rqst_cre/rqst_aud-->
<input type="hidden" name="rqst_type" value="rqst_cre">    
<!-- 이화면에서 입력되는 데이타는 전부  Manual -->  
<input type="hidden" name="mnr_inp_tp_cd" value="M">      
<input type="hidden" name="eq_tpsz_cd" value="">	 			         
 
<!-- AGMT데이타 콤보용  -->
<input type="hidden" name="trsm_mod_cd">	   
<input type="hidden" name="eq_knd_cd" value="<%=eqKndCd%>">     
<input type="hidden" name="edi_id">   
			
<!-- AGMT추출용  -->
<input type="hidden" name="agmt_ofc_cty_cd">   
<input type="hidden" name="agmt_seq">   
<input type="hidden" name="agmt_ver_no"> 
	  
<!-- 견적서 저장용 키값  -->
<input type="hidden" name="rpr_rqst_seq" value="<%=rprRqstSeq%>">      	 
<input type="hidden" name="rpr_rqst_ver_no" value="<%=rprRqstVerNo%>">  	
<input type="hidden" name="rpr_sts_cd">                 
<input type="hidden" name="rpr_offh_flg" value="N">	          
<input type="hidden" name="disp_flg" value="N"> 	          
<input type="hidden" name="rpr_rqst_tmp_seq" value="1">    	          
<input type="hidden" name="rpr_rqst_lst_ver_flg" value="Y">  	    	          
<input type="hidden" name="n3pty_flg" value="N"> 	     	          
<input type="hidden" name="file_seq" value="">   	     	          
<input type="hidden" name="rqst_usr_id" value="">    	     	                
		 
<!-- notice 구분용  -->	  
<input type="hidden" name="recent_rpr_tp_cd" value="<%=recentRprTpCd%>">      

<!-- EDI로 들어온 TEMP	견적서를 보여주기 위한 구분  -->   	  
<input type="hidden" name="est_temp" value="<%=estTemp%>">      
				 
<!-- 개발자 작업	-->	   
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Estimate Detail Info</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!--biz page (S)-->
		<!-- 2 (S) --> 	  	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!--  biz_2  (S) -->	
			<table class="grid2" border="0" style="width:979;">  
					<tr class="h23">
						<td  class="tr2_head"width="50">Notice</td>  
						<td width=""><textarea name="notice" style="width:100%;height:30"></textarea></td>
					</tr> 	 	
			</table> 
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" border="0" style="width:979;">
					<tr class="h23">		  
					<td width="105">Service Provider</td>			 
					<td width="421"><input type="text" name="vndr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input2" value="" dataformat="engup" maxlength="6" readonly>&nbsp;<input type="text" name="vndr_nm" caption="Service Provider" style="width:241;" class="input2" value="" readonly></td>	 
					<td width="75">C.OFC</td>	 				 	  	 
					<td width="138">												 	 	 		
					<input name="cost_ofc_cd" type="text" style="width:80" class="input2" dataformat="engup" value="" readonly>
					</td>	 				
					<td width="">&nbsp;</td>  
					</tr>	  
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">	
				<td width="70">EQ No.</td>  
				<td width="140">
				<input required maxlength="14" style="width:120;" type="text" name="rqst_eq_no" dataformat="engup" caption="EQ No" class="input1" value="<%=rqstEqNo%>"> 
				</td>  
				<td width="90">Estimate No.</td>  
				<td width="140" colspan="2">  
				<input maxlength="20" style="width:170;" type="text" name="rqst_ref_no" dataformat="engup" caption="Estimate No" class="input1" value="">
				</td>			   
				<td width="75">Repair Yard</td>	
				<td width="138">		
				<input style="width:80;" type="text" name="rpr_yd_cd" dataformat="engup" maxlength="7" caption="yard cd" class="input1" value="">  
				</td> 			
				<td width="90">Repair Status</td>	 		
				<td width="150"><script language="javascript">ComComboObject('rpr_wrk_tp_cd', 1, 120, 1, 1, 0, false, 0);</script></td>	
			</tr>				 
			<tr class="h23">
				<td width="">Damage Date</td>   	 
				<td width="">
				<input name="eq_dmg_dt" type="text" style="width:80" class="input" value="" dataformat="ymd" maxlength="8">&nbsp;<img name="btns_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
				</td>	
				<td width="">Input User</td>				      
				<td width="" colspan="2">			
				<input type="text" style="width:170;" name="rqst_usr_nm" dataformat="engup" maxlength="50"  class="input2" size="10"  value="" readonly>  
				</td>			
				<td width="" >Input Date</td>    	 	   
				<td width="">   	
				<input type="text" style="width:80;" name="rqst_dt" dataformat="ymd" maxlength="8"  class="input2" size="10"  value="" readonly>  
				</td>		 
				<td width="" colspan="2">Off-hire&nbsp;<input name="rpr_offh_flg_temp" type="checkbox" value="Y" class="trans"></td>   
			</tr>		 	 			
			</table>  	 			
			<!--  biz_2   (E) -->
			</td></tr>		
		</table>
		<!--  biz_2  (E) -->	
		<!-- 3 (S) -->		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
				
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Equipment Information</td></tr>
			<tr><td class="height_5"></td></tr>
			</table> 
			
			<!--  biz_3  (S) -->
			<table border="0" style="width:979; background-color:white;" class="grid2"> 
			<tr><td width="8%" class="tr2_head">Repair </td>
				<td width="11%" align="center" style="padding-left:3;" id="Repair"> </td>
				<td width="4%"><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left" style="border:0 !important; padding:0 !important;"></td>
						<td class="btn2" name="btn_detail" style="border:0 !important; padding:0 !important;">Detail(s)</td>
						<td class="btn2_right" style="border:0 !important; padding:0 !important;"></td></tr>
					</table> 
				</td> 	
				<td width="10%" class="tr2_head">IMM.EXIT</td>
				<td width="3%" align="center" id="ImmExit"> </td>
				<td width="8%" class="tr2_head">Off-hire</td>
				<td width="3%" align="center" id="OffHire"> </td>
				<td width="7%" class="tr2_head">Disposal</td>
				<td width="3%" align="center" id="Disposal"> </td>
				<td width="9%" class="tr2_head">DPP&nbsp;(USD)</td>
				<td width="9%" align="right" id="DPP"> </td>
				<td width="12%" class="tr2_head">DV Value(USD)</td>
				<td align="right" id="DvValue"> </td> 
			</tr>
			<tr><td class="tr2_head">MANU.DT</td>
				<td colspan="2" id="ManuDt"> </td> 
				<td class="tr2_head">TP/SZ</td>
				<td align="center" id="TpSz"> </td>
				<td class="tr2_head"> Term</td>
				<td align="center" id="Term"> </td>
				<td class="tr2_head">Lessor</td>
				<td align="left" colspan="3" id="Lessor"> </td> 
				<td class="tr2_head">Warranty</td>  
				<td align="center" id="Warranty"> </td>     
			</tr>
							
			</table>
			<!--  biz_3   (E) -->
			
			</td></tr>
		</table>
		<!-- 3 (E) -->	
		
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		<!-- Tab (E) -->
		<!-- 4 (S) -->
		<table class="search" id="mainTable">
       	<tr><td class="bg" width="979" valign="top">
       	
       	
		
		<!-- Tab1 (S) -->
<div id="tabLayer" style="display:inline">
        
			<!-- : ( Grid ) (S) -->     

				<table width="100%"  id="mainTable">  
					<tr>
						<td width="100%"> 
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_calc">Caculation</td>
							<td class="btn2_right"></td> 
							</tr> 
							</table></td>        
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td> 	
							<td><table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowDel">Row Del</td> 
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownExcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
				</table>
			</td></tr>
			</table>
			    	<!-- Button_Sub (E) -->
			 <table class="height_8"><tr><td></td></tr></table>
				
				
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23"> 
			<td width="65">Desc.</td>			 			      
			<td style="padding-left:1"><input readonly name="mnr_desc" type="text" style="width:910;" class="input2" value=""></td>
			</tr>		 
			<tr class="h23">		
			<td width="">Remark(s)</td>		 		 
			<td><textarea name="mnr_rpr_rmk" wrap="off" style="width:910;background-color:beige;" rows="1">
			</textarea></td>
			</tr>
			</table> 
</td></tr>
			</table>
		</div>
<!-- Tab1 (E) -->

<!-- Tab2 (S) -->
<div id="tabLayer" style="display:none"> 
			<div id="t2_selection1"> 
			<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
						<td width="150">Damage Location Code</td>	 
						<td><input type="text" name="damageLocationCode" style="width:533;" class="input2" value="" readOnly></td> 
						</tr>
			</table>
			</div>	    
			<table class="search" width="979"  border="0">
			<tr>	  
			<td width="700" valign="top" style="padding-right:20;" rowspan="2">
			<!-- Grid 2 - Damage images (S) -->	
										
					<table border="0" style="width:100%; height:285; border:#A6C3CB 1px solid" class="search"> 
					
					<tr class="tr2_head"> 
						<td style="padding:1,5,1,5;">
						<div id="t2_selection2"> 
						<table width=100% style="" cellspacing="8"> 
						<tr height="25">
							<td width="140" valign="top">
								<!-- : ( Grid ) (S) -->
								<table width="100%"  id="mainTable">
									<tr>
										<td width="20">
											<font size="5">D</font>
										</td>
										<td width="140" border="0" style="height:140;" valign="top">  
											<script language="javascript">ComSheetObject('t2_sheet1');</script>
										</td>
									</tr>
									<tr>  
										<td width="20">
											<font size="5">F</font>
										</td>
										<td width="140" style="height:140;" valign="top">  
											<script language="javascript">ComSheetObject('t2_sheet2');</script>
										</td>
									</tr>
								</table>
							</td>  
							<td width="240" valign="top">
								<table width="100%"  id="mainTable">
									<tr>
										<td width="20">
											<font size="5">L</font>
										</td>
										<td width="220" colspan="2" border="0" style="height:100;" valign="top">  
											<script language="javascript">ComSheetObject('t2_sheet3');</script>
										</td>
									</tr>
									<tr>
										<td width="20"></td>
										<td width="110" align="left">Front</td>
										<td width="110" align="right">Door</td>
									</tr>
									<tr>
										<td style="height:22"></td>
									</tr>
									<tr>
										<td width="20">
											<font size="5">R</font>
										</td>
										<td width="220" colspan = "2" style="height:100;" valign="top"> 
											<script language="javascript">ComSheetObject('t2_sheet4');</script>
										</td>
									</tr>
									<tr>
										<td width="20"></td>
										<td width="110" align="left">Door</td>
										<td width="110" align="right">Front</td>
									</tr>
									<tr>
										<td style="height:22"></td>
									</tr>
								</table>
								</td>
							<td width="240" valign="top">
								<table width="100%"  id="mainTable">
									<tr>
										<td width="20">
											<font size="5">T</font>
										</td>
										<td width="220" colspan = "2" style="height:60;" valign="top">
											<script language="javascript">ComSheetObject('t2_sheet5');</script>
										</td>
									</tr>
									<tr>
										<td width="20"></td>
										<td width="110" align="left">Door</td>
										<td width="110" align="right">Front</td>
									</tr>
									<tr>
										<td style="height:10"></td>
									</tr>
									<tr>
										<td width="20">
											<font size="5">B</font>
										</td>
										<td width="220" colspan = "2" style="height:60;" valign="top">
											<script language="javascript">ComSheetObject('t2_sheet6');</script>
										</td>
									</tr>
									<tr>
										<td width="20"></td>
										<td width="110" align="left">Door</td>
										<td width="110" align="right">Front</td>
									</tr>
									<tr>
										<td style="height:10"></td>
									</tr>
									<tr>
										<td width="20">
											<font size="5">U</font>
										</td>
										<td width="220" colspan = "2">
											<script language="javascript">ComSheetObject('t2_sheet7');</script>
										</td>
									</tr>
								</table>
								</td>
						</tr>
						</table>
						</div>  
						</td>
					</tr>
					</table>
					<!-- Grid 2 - Damage images (E) -->
				 
				</td> 
				<td width="279" valign="top">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
				<td class="title_s">Photo </td></tr> 
				</table> 	
					<!-- Grid 3 - photo Before (S) -->									
					<table width="100%"  id="mainTable"> 
						<tr>			
							<td width="100%">
								<script language="javascript">ComSheetObject('t2_sheet8');</script>   
							</td>	
						</tr>	
					</table>
					<!-- Grid 3 - photo Before (E) -->
						
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
				</td>
				
				</tr>
			</table>	
			<!-- Expense for / Evidence attached (E) -->
			
</div>						
<!-- Tab2 (E) -->    
		<!-- 5 (E) -->		
			</td></tr>
		</table>		
		<!-- 4 (E) -->		
		<!--biz page (E)-->
		
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