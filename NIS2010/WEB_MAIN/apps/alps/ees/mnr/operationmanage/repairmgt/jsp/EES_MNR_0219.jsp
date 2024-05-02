<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0219.jsp
*@FileTitle : M&R Simple WO File Import Pop_Up
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.08.18
*@LastModifier : 권영법	
*@LastVersion : 1.0
* 2009.08.18 권영법
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0219Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0219Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
	        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
	       
		event = (EesMnr0219Event)request.getAttribute("Event"); 
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
<title>M&R Simple WO File Import</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
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
<input type="hidden" name="pagerows">
<input type="hidden" name="retfld">
<input type="hidden" name="eq_type" value="">   
<input type="hidden" name="mnr_grp_tp_cd" value="">
<input type="hidden" name="mnr_wo_tp_cd" value="">

<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="cost_ofc_cd" value="">
<input type="hidden" name="vndr_seq" value="">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   M&R Simple WO File Import</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
			<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="60"><nobr>EQ Type </nobr></td>
					<td width="140"><input type="text" name="eq_knd_cd_text" style="width:100;" class="input2" value="Container" readonly><input type="hidden" name="eq_knd_cd"></td>
					<td width="70"><nobr>Cost Type </nobr></td>
					<td width="140"><input type="text" name="cost_cd_text" style="width:100;" class="input2" value="Cleaning" readonly><input type="hidden" name="cost_cd"></td>
					<td width="120"><nobr>Service Sub Type </nobr></td>
					<!--
					<td width=""><script language="javascript">ComComboObject('combo_cost_dtl_cd',2, 200 , 1, 1,2,false,1);</script>
					-->
					
					<td width="">
						<select name="combo_cost_dtl_cd" style="width:200;" dataformat="engup">
							<option value="" selected></option>
		            	</select>
		            </td>
		           
					<input type="hidden" name="cost_dtl_cd"></td></tr> 
				</table>				
				<!--  biz_1   (E) -->
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
							<td class="btn2" name="btn_RowDel">Row Del</td>        
							<td class="btn2_right"></td>            
							</tr> 
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->	
		
				<table class="height_10"><tr><td></td></tr></table>
				<!-- Title -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Simple Work Order File Format</td></tr>
				</table>
				<!-- Title -->
					
				
				<table width="400" class="grid2"> 
				<tr class="tr2_head">
					<td width="33%">EQ No.</td>
					<td width="33%">Yard</td>
					<td width="%">Work Date</td>
				</tr>
				<tr>
					<td width="33%"><input type="text" style="width:100%;text-align:center;" class="noinput" value="SMCU0523724"></td>
					<td width="33%"><input type="text" style="width:100%;text-align:center;" class="noinput" value="KRPUSY1"></td>
					<td width="%"><input type="text" style="width:100%;text-align:center;" class="noinput" value="2008-10-12"></td>
				</tr>
				</table>
				<!-- Grid (E) -->		

				
		
	
	</td></tr>
	</table>
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
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_FileImport">Load Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">Ok</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
			
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
