<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0023.jsp
*@FileTitle : Repair Estimate Auditing
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.07.01
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.07.01 박명신		   		
* 1.0 Creation	 	   
* History
* 2012.11.23 조경완 [CHM-201220893-01] Estimate Group Auditing 모듈에서 Repair code 및 division code 수정 기능 추가	
=========================================================*/
%>
	
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0023Event"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EesMnr0023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
		 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
	
	String sXml = null;
 		 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
	
	//팝업용 데이타			 	
	String paramRqstEqNo = ((request.getParameter("rqst_eq_no")==null )?"":request.getParameter("rqst_eq_no"));
	String paramRqstRefNo = ((request.getParameter("rqst_ref_no")==null )?"":request.getParameter("rqst_ref_no"));
	String paramPopFlag = ((request.getParameter("pop_flag")==null )?"":request.getParameter("pop_flag"));		        
	
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
			
		event = (EesMnr0023Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
	 	   	   	
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
	var selfOfcCd = "<%=strOfc_cd%>";  
	var paramRqstEqNo = "<%=paramRqstEqNo%>";
	var paramRqstRefNo = "<%=paramRqstRefNo%>";
	var popFlag = "<%=paramPopFlag%>";
	
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if  
		loadPage();
	}
	
	function tablevisible(){
		var div1 = document.getElementById("div1");	
		var div2 = document.getElementById("div2");	
		
		if(div1.style.display=="block"){
			div1.style.display="none";
			div2.style.display="block";
		}else{
			div1.style.display="block";
			div2.style.display="none";
			}
	}				
 
</script> 
<script language="javascript">ComSheetObject('sheet1');</script>     
</head> 
     
<body  onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">   
<input type="hidden" name="pagerows">   
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<!-- 견적서발급과 감사를 구분하기위한 rqst_cre/rqst_aud-->
<input type="hidden" name="rqst_type" value="rqst_aud">     
<!-- 이화면에서 입력되는 데이타는 전부  Manual -->  
<input type="hidden" name="mnr_inp_tp_cd" value="M">      
<input type="hidden" name="eq_tpsz_cd" value="">	 			 
 
<!-- AGMT데이타 콤보용  -->  
<input type="hidden" name="edi_id">   
	
<!-- AGMT추출용  -->	
<input type="hidden" name="agmt_ofc_cty_cd">   
<input type="hidden" name="agmt_seq">   
<input type="hidden" name="agmt_ver_no"> 
	  
<!-- 견적서 저장용 키값  -->
<input type="hidden" name="rpr_rqst_seq">  	    	 
<input type="hidden" name="rpr_rqst_ver_no"> 	 	
<input type="hidden" name="rpr_sts_cd">                 
<input type="hidden" name="rpr_offh_flg" value="N">	          
<input type="hidden" name="disp_flg" value="N"> 	          
<input type="hidden" name="rpr_rqst_tmp_seq" value="1">    	          
<input type="hidden" name="rpr_rqst_lst_ver_flg" value="Y"> 		    	          
<input type="hidden" name="n3pty_flg" value="N"> 	     	          
<input type="hidden" name="file_seq" value=""> 	  	
<input type="hidden" name="rqst_usr_id">           	          
<input type="hidden" name="rpr_dtl_sts_cd">	               	          
<input type="hidden" name="vndr_seq">             
<input type="hidden" name="apro_ofc_cd" value="<%=strOfc_cd%>"> 	
<input type="hidden" name="dup_chk">
<input type="hidden" name="file_seq_tmp" value="">       
		   
<!-- RD용  --> 
<input type="hidden" name="com_mrdPath" value="apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0181.mrd">  
<input type="hidden" name="com_mrdArguments" value="">         
<input type="hidden" name="com_mrdBodyTitle" value="">         

<!-- 오디팅용 컬럼  --> 		
<input type="hidden" name="auto_amt">        	 
<input type="hidden" name="appoval_amt">	   	
<input type="hidden" name="uppr_ofc_cd">        

<!-- sorting용 --> 	
<input type="hidden" name="sorting" value=""> 	        

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
		    <tr>
<%
if ( paramRqstEqNo.equals("")&&paramPopFlag.equals("")){
%>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>						
					<td class="btn1" name="btn_Later">Audit it Later</td>	
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Counteroffer">Counteroffer</td>
				<td class="btn1_right"></td>
				</tr>
				</table></td>
<%
}
%>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Reject">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Approval">Approval</td> 
					<td class="btn1_right"></td>  
					</tr>
				</table></td> 
				<td class="btn1_line"></td>
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
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="41%" valign="top">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:399;"> 
				<tr class="h23">	
					<td width="110">Service Provider</td>		 	     
					<td width=""><input type="text" name="vndr_nm" style="width:265" class="input2" value="" readOnly></td>
					</tr>   
				</table>  
				
				<table class="search" border="0" style="width:399;"> 		   	
				<tr class="h23"> 	
					<td width="78">Tariff No.</td>       
					<td width="150"><input type="text" name="trf_no" style="width:129" class="input2" value="" readOnly></td>
					<td width="70">Cost Office</td>  		    
					<td width="" style="padding-left:0px"><input tabindex="0" type="text" name="cost_ofc_cd"  style="width:75;" class = "input2" value = "" readOnly></td>  
				</tr>			
				<tr class="h23">     
					<td width="78">EQ Type</td>       	    
					<td width="150" style="padding-left:2px"><script language="javascript">ComComboObject('eq_knd_cd', 1, 130, 1, 3,0,false,0);</script></td>
					<td width="70">Currency</td>    
					<td width="" style="padding-left:0px"><input type="text" name="curr_cd" style="width:75" class="input2" value="" readOnly></td>
				</tr>	
				<tr class="h23">     
					<td width="78">Transmission</td> 	 	 
					<td width="150" style="padding-left:2px"><script language="javascript">ComComboObject('trsm_mod_cd', 1, 130, 1, 3,0,false,0);</script></td>
					<td width="70">Measure</td>          	    
					<td width=""><input type="text" name="mnr_meas_ut_nm" style="width:75" class="input2" value="" readOnly></td>
					
				</tr>	
				<tr class="h23">     
					<td width="78">Sorting by</td> 	 	
					<td width="150" style="padding-left:2px"><script language="javascript">ComComboObject('sorting_by', 2, 130, 1, 0, 0, false, 0);</script></td>	
				</tr>						 
				</table>
				<!--  biz_1   (E) --> 
				</td>	
				<td width="59%">
					
				<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%"> 
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>	
					</tr>
				</table>
				 	
				<!-- Grid - 1 (E) -->	

				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			    	<tr>
			    		<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_DownExcel2">Down Excel</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
		    	<!-- Button_Sub (E) -->
			
		</td></tr>
		</table>	
		<!-- 1 (E) -->
		
		<table class="line_bluedot"><tr><td></td></tr></table>
		<!-- 2 (S) -->		
		
			<!--  biz_2  (S) -->	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70">EQ No.</td>
				<td width="140">
				<input required maxlength="14" style="width:120;" type="text" name="rqst_eq_no" value='' dataformat="engup" caption="EQ No" class="input2" readonly>
				</td> 
				<td width="85">Estimate No.</td>  
				<td width="140" colspan="2">  
				<input required maxlength="20" style="width:170;" type="text" name="rqst_ref_no" value='' dataformat="engup" caption="Estimate No" class="input2" readonly>
				</td>			   
				<td width="75">Repair Yard</td>	
				<td width="138">    	 
				<input style="width:80;" type="text" name="rpr_yd_cd" value='' dataformat="engup" maxlength="7" caption="yard cd" class="input2" readonly>&nbsp;<img src="img/btns_search.gif" name="btn_popup" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:pointer;cursor:hand">
				</td>	 			
				<td width="90">Repair Status</td> 	
				<td width=""><script language="javascript">ComComboObject('rpr_wrk_tp_cd', 1, 120, 1, 1, 0, false, 0);</script></td>	
			</tr>				 
			<tr class="h23">	
				<td width="">Damage Date</td>    	 
				<td width="">			
				<input name="eq_dmg_dt" type="text" style="width:80" class="input2" value="" dataformat="ymd" maxlength="8" readonly>
				</td>		
				<td width="">Input User</td>		      
				<td width="" colspan="2">		
				<input type="text" style="width:170;" name="rqst_usr_nm" dataformat="engup" maxlength="50"  class="input2" size="10"  value="" readonly>     
				</td>		
				<td width="" >Input Date</td> 	 	   
				<td width="">   	
				<input type="text" style="width:83;" name="rqst_dt" dataformat="ymd" maxlength="8"  class="input2" size="10"  value="" readonly>  
				</td>		 
				<td width="" colspan="2">Off-hire&nbsp;<input name="rpr_offh_flg_temp" type="checkbox" value="Y" class="trans"></td>   
			</tr> 	 			
			</table> 	 			
			<!--  biz_2   (E) -->
			
		<table class="line_bluedot"><tr><td></td></tr></table>
			
			<!--  biz_3  (S) -->
			<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr>
					<td width="8%" class="tr2_head">Repair </td>
					<td width="13%" align="center" style="padding-left:3;" id="Repair"> </td>
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
				<tr>
					<td class="tr2_head">Lessor</td>
					<td colspan="2" align="left" id="Lessor"> </td>
					<td class="tr2_head">Warranty</td>
					<td align="center" id="Warranty"> </td>
					<td class="tr2_head">Duplicated EOR</td>
					<td align="center" id="rctRprFlg"> </td>
					<td class="tr2_head">TP/SZ</td>
					<td align="center" id="TpSz"> </td>
					<td class="tr2_head"> Term</td>
					<td align="center" id="Term"> </td>
					<td class="tr2_head">MANU.DT</td>
					<td align="center" id="ManuDt"> </td>
				</tr>	
								
			</table>
			<!--  biz_3   (E) -->
			
			</td></tr>
		</table>
		<!-- 3 (E) -->	
		 <table class="height_8"><tr><td></td></tr></table>
				
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
       	<tr><td class="bg" width="100%" valign="top">
       	
       	
		
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
							<td class="btn2" name="btn_Verify">Verify</td>
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
							<td class="btn2" name="btn_RowDel">Row Delete</td> 
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownExcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
				</tr></table>
			</td></tr>
			</table>
			    	<!-- Button_Sub (E) -->
			 <table class="height_8"><tr><td></td></tr></table>
				
				
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			<td width="65">Desc.</td>		      
			<td style="padding-left:1"><input readonly name="mnr_desc" type="text" style="width:99%;" class="input2" value=""></td>
			</tr>		
			<tr class="h23">		
			<td width="">Remark(s)</td>		 		 
			<td><textarea name="mnr_rpr_rmk" wrap="off" style="width:99%;height:22;background-color:beige;">
			</textarea></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:100%;">
				<tr class="h23">		
					<td width="200">Remark(s) for verify result error</td>
					<td width="" style="padding-left:1"><input name="vrfy_rslt_rmk" type="text" style="width:99%;" maxlength="500" value=""></td>
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
										
					<table border="0" style="width:100%; height:; border:#A6C3CB 1px solid" class="search">
					
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
				<!-- <table class="search" border="0">
				<tr><td class="title_h"></td>
				<td class="title_s">Photo </td></tr>
				</table> --> 	
					<!-- Grid 3 - photo Before (S) -->		
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
						<td class="title_h"></td>
						<td class="title_s">Photo</td>
						<td>
						<table width="150" border="0" cellpadding="0" cellspacing="0" class="button" align="right">
					    <tr><td class="btn2_left" style="border:0 !important; padding:0 !important;"></td>
						<td class="btn2" name="btn_oneClickDownload" style="border:0 !important; padding:0 !important;">One Click Download</td>
						<td class="btn2_right" style="border:0 !important; padding:0 !important;"></td></tr>
					    </table>
					    </td>
						</tr>
					</table>		
					<table width="100%"  id="mainTable"> 
						<tr>			
							<td width="100%">
								<script language="javascript">ComSheetObject('t2_sheet8');</script>   
							</td>	
						</tr>	
					</table>
					<!-- Grid 3 - photo Before (E) -->
						
					<!--  Button_Sub (S) -->
					<!-- <table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_FileAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_FileDel">Row Delete</td>  
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table> -->
			    	<!-- Button_Sub (E) -->
				
				</td>
				
				</tr>
			</table>	
			<!-- Expense for / Evidence attached (E) -->
			
		<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
			</table> 	  
</div>					
<!-- Tab2 (E) -->
	
		<!-- 5 (E) -->		
			</td></tr>

		</table>
<div id="thumbnail_sheet"; style="overflow:scroll; height:150px; padding:10px;">


</div>	
<%
if ( !paramRqstEqNo.equals("")&& !paramPopFlag.equals("")){
%>
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">

      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
             <tr>
               <td class="btn3_bg">
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Close">Close</td>
                      <td class="btn1_right"></td>
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
<%
}
%>	
		<!-- 4 (E) -->		
		<!--biz page (E)-->


	<!--Image Info(E)-->
	
	</td></tr>
		</table>
<table class="height_10"><tr><td colspan="8"></td></tr></table>
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>

<!-- 개발자 작업  끝 -->  
</form>	
</body>
</html>
