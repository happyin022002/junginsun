<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0220.jsp
*@FileTitle : Disposal Price File Import_Pop Up
*Open Issues :      
*Change history :   
*@LastModifyDate : 
*@LastModifier :      
*@LastVersion : 1.0   	   
=========================================================*/
%>
		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0220Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	  
<% 
	EesMnr0220Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list
	     	 		 
	String successFlag = ""; 
	String codeList  = "";
	String pageRows  = "100"; 
 		 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= ""; 
	String strRhq_cd 		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.DisposalMgt");
				        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
	    strRhq_cd = account.getRhq_ofc_cd();  
	    
		event = (EesMnr0220Event)request.getAttribute("Event");  
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 				
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}        
	       		 
		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	 			   	   	
	}catch(Exception e) {   	  
		out.println(e.toString());
	}		
%>	
<html>
<head>
<title>Disposal Price File Import</title>	    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!-- common use in MNR -->                 
<script language="javascript">    
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if	 	 
		loadPage();
	}
</script> 
</head>	 
    
<body class="popup_bg"  onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_gubuns">
<input type="hidden" name="mnr_disp_trf_grp_cd">
<input type="hidden" name="mnr_disp_trf_seq">
<input type="hidden" name="mnr_inp_tp_cd" value="M">
<input type="hidden" name="mnr_disp_trf_sts_cd" value="S">
<input type="hidden" name="mnr_trf_rmk" value="">
<input type="hidden" name="mnr_disp_trf_lst_ver_flg" value="N">	
<input type="hidden" name="pagerows">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Disposal Price File Import</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
		<table class="search"> 
       		<tr><td class="bg">
			
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
								<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td> 
							<td class="btn2" name="btn_Save">Verify</td> 
							<td class="btn2_right"></td>     
							</tr>
							</table></td> 
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td> 
							<td class="btn2" name="btn_RowAdd">Row Add</td>      
							<td class="btn2_right"></td>            
							</tr> 	
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td> 
							<td class="btn2" name="btn_RowDel">Row Delete</td>        
							<td class="btn2_right"></td>            
							</tr> 
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->	
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Disposal Price File Format</td></tr>
				</table>
				<!--  biz_1 (S) -->
				<table class="grid2" border="0" style="width:100%;"> 
					<tr class="tr2_head">
						<td width="40">Seq.</td>
						<td width="70">LOCATION	</td>
						<td width="70">Currency	 </td>
						<td width="60">D2</td>
						<td width="60">D4</td>
						<td width="60">D5</td>
						<td width="60">D7</td>
						<td width="60">F2</td>
						<td width="60">F4</td>
						<td width="60">O2</td>
						<td width="60">R5</td>
						<td width="60">R2</td>
					</tr>
					<tr align="center">
						<td>Seq.</td>
						<td>USLGB</td>
						<td>USD</td>
						<td align="right">1250</td>
						<td align="right">1250</td>
						<td align="right">1250</td>
						<td align="right">1250</td>
						<td align="right">1250</td>
						<td align="right">1250</td>
						<td align="right">1250</td>
						<td align="right">1250</td>
						<td align="right">1300</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->	
				
				
			</td></tr>
			</table>
	    	
<table class="height_5"><tr><td></td></tr></table>
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Format Down Excel</td>
					<td class="btn1_right"> </td>
				</tr></table></td> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_FileImport">File Import</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td></tr>
</table> 
		
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form> 			
</body>
</html>
