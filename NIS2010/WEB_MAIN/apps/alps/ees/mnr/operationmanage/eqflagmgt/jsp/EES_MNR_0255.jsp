<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_MNR_0255.jsp
*@FileTitle : Hanger Rack & Bar Installation/Removal Load Excel_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.14
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2011.09.14 신혜정
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0255Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0255Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	
	String programId		= "";
	String stdTrfNo			= "";
	
	programId = JSPUtil.getParameter(request, "programId");
	stdTrfNo = JSPUtil.getParameter(request, "stdTrfNo");
	
	Logger log = Logger.getLogger("com.hanjin.apps.operationmanage.eqflagmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0255Event)request.getAttribute("Event");
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
<title>  Hanger Rack & Bar Installation/Removal File Import_Pop Up</title>
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
<input type="hidden" name="program_id" value="<%=programId %>">
<input type="hidden" name="std_trf_no" value="<%=stdTrfNo %>">
<input type="hidden" name="pagerows">
<input type="hidden" name="mnr_flg_tp_cd">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title" id="title1"><img src="img/icon_title_dot.gif" align="absmiddle">   Hanger Rack & Bar Installation/Removal File Import</td></tr>
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
						<td class="btn2" name="btn_retrieve">Verify</td> 
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
					<td id="title2" class="title_s">Hanger Rack & Bar Installation/Removal File Format</td></tr>
				</table>
				
				<!-- : ( Grid ) (S) -->
				<table class="grid2" border="0" style="width:100%;">  
					<tr class="tr2_head">
						<td width="80">EQ No.</td> 
						<td width="">Flag</td> 
						<td width="">Hanger Rack Type</td>  
						<td width="">Tariff Type</td>
						<td width="">Tariff<br>Desc</td>
						<td width="">Hanger Bar<br>Type</td>
						<td width="">Installation<br>Bar Qty</td>
						<td width="">Sound</td>
						<td width="">Repairable</td>
						<td width="">Missing</td>
						<td width="">Disposal</td>
						<td width="">Remark(s)</td>						
						<!-- <td id="materialName" width="">Material</td> -->
					</tr>
					<tr align="center" > 
						<td width="80">SMCU2934560</td>       
						<td width="">Y</td>       
						<td width="" align="left" style="height:48;">&nbsp;&nbsp;Permanent Hanger Rack_Single
							<br>&nbsp;&nbsp;&nbsp;Temporary Hanger Rack_Single
							<br>&nbsp;&nbsp;&nbsp;Temporary Hanger Rack_Double</td>             
						<td width="" align="left">&nbsp;SML offer HR CNTR & Bar
							<br>&nbsp;&nbsp;HR CNTR Only
							<br>&nbsp;&nbsp;SML&nbsp;&nbsp;offer HB Only
							<br>&nbsp;&nbsp;SML&nbsp;&nbsp;offer HB (Hook Type)
							<br>&nbsp;&nbsp;Vendor offer All(Hook Type)
							<br>&nbsp;&nbsp;Other</td>
						<td width=""></td>
						<td width="">&nbsp;Square
							<br>&nbsp;&nbsp;Round</td>
						<td width="">12</td>
						<td width="">8</td>
						<td width="">2</td>
						<td width="">2</td>
						<td width="">0</td>
						<td width="">By Repair Invoice</td>						
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
</body>
</html>