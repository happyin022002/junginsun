<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0190.jsp
*@FileTitle : Local Tariff File Import_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.22 김완규
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0190Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0190Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String eqTypeCd 		= JSPUtil.getParameter(request, "eqTypeCd");
	String programId		= "";
	String stdTrfNo			= "";

	programId = JSPUtil.getParameter(request, "programId");
	stdTrfNo = JSPUtil.getParameter(request, "stdTrfNo");
	
	Logger log = Logger.getLogger("com.hanjin.apps.AgreementManage.TariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0190Event)request.getAttribute("Event");
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
<title>Tariff File Import</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<body  class="popup_bg" onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="eq_knd_cd" value="<%=eqTypeCd %>">
<input type="hidden" name="program_id" value="<%=programId %>">
<input type="hidden" name="std_trf_no" value="<%=stdTrfNo %>">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title" id="title1"><img src="img/icon_title_dot.gif" align="absmiddle">   Tariff File Import</td></tr>
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
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td id="title2" class="title_s">Local Tariff File Format</td></tr>
				</table>
				
				<!-- : ( Grid ) (S) -->
				<table class="grid2" border="0" style="width:860;">  
					<tr class="tr2_head">
						<td width="100">Cost Group Code</td> 
						<td width="">Component</td> 
						<td width="">Repair</td>  
						<td width="">Div</td>
						<td width="">Description</td>
						<td width="">Range Type</td>
						<td width="">Type</td>
						<td width="">QTY</td>
						<td width="">SIZE</td>
						<td width="">Fm</td>
						<td width="">To</td>
						<td width="">Man-Hour</td>
						<td id="materialName" width="">Material</td>
						<td width="">Remark</td>
					</tr>  
					<tr align="center"> 
						<td width="100">MRDR</td>       
						<td width="">RBO</td>       
						<td width="">AJ</td>             
						<td width="">CC</td>
						<td width="">[RBO] - [AJ]Adjust - [CC]</td>
						<td width="">F</td>
						<td width="">Q</td>
						<td width="">1</td>
						<td width="">0</td>
						<td width="">0</td>
						<td width="">0</td>
						<td width="">11.00</td>
						<td id="materialValue" width="">0.00</td>
						<td width=""></td>
					</tr>       
				</table> 				
				<!-- : ( Grid ) (E) -->
			</td></tr>
			</table>
	    	
			

<table class="height_5"><tr><td></td></tr></table>
	
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr>
			<td class="btn3_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"> 
				</tr></table></td> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Format Down Excel</td>
					<td class="btn1_right"> 
				</tr></table></td> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_loadExcel">Load Excel</td>
					<td class="btn1_right"> 
				</tr></table></td> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">Ok</td> 
					<td class="btn1_right"> 
				</tr></table></td>
			<td class="btn1_line"></td>	
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>  
					<td class="btn1_right">
				</tr></table></td>				
			</tr>
		</table></td> 		  	
			</tr>
		</table>
		<!--Butt
		on (E) --> 
</td></tr>
</table> 
<!-- : ( Button : pop ) (E) -->
			
</form>
<script language="javascript">ComSheetObject('sheet2');</script>			
</body>
</html>
