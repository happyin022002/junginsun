<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0440.jsp
*@FileTitle : ROCS Main Menu
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0440Event"%><%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0440Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}						 

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>ROCS Main Menu</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vvd_nm">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" id="mainTable" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">CRN Number</td>
					<td width="879">
					<input name="frm_crn_number"  style="ime-mode: disabled" id="frm_crn_number" maxlength="13"  dataformat="uppernum" type="text" style="width:200" value="" class="input" >
					</td>
				</tr>
				<tr class="h23">
					<td width="">VVD</td>
					<td width=""><input name="frm_vvd_number"   style="ime-mode: disabled" id="frm_vvd_number" maxlength="9" dataformat="uppernum" type="text" style="width:200" value="" class="input"></td>
				</tr>
				<tr class="h23">
					<td width="">POD</td>
					<td width=""><input name="pod_cd" type="text"  style="ime-mode: disabled" dataformat="engnum" style="width:150" value=" NLRTM" readonly class="input2">
									<input name="frm_pod_clpt_ind_seq" id="frm_pod_clpt_ind_seq" maxlength="1" type="text"  style="ime-mode: disabled; width:45" dataformat="int" value="" class="input"></td>
				</tr>
				<tr class="h23">
					<td width="">Call Date (ETA)</td>
					<td width=""><input name="frm_vps_eta_dt" type="text" style="width:200" value="" class="input2" readonly></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Stage 1 : Manifest Transmission</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_1" style="text-align:left"> 
						 1. CRN Creation						 						
						</td>				
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_2" style="text-align:left"> 
						2. CRN List</a>
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_3" style="text-align:left"> 
						3. Manifest Transmit 
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_4" style="text-align:left"> 
						4. B/L Inquiry 
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Stage 2 : ROCS Closing</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_5_1" style="text-align:left"> 
						5. Transmit History</a>
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_6_1" style="text-align:left"> 
						6. Received History
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				  
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Stage 3 : Report</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_7" style="text-align:left"> 
						7. Notify Letter Send</a>
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_8" style="text-align:left">   
						8. Integrated Customer Data Management </a>
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_9" style="text-align:left"> 
						9. I/B B/L File
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_10" style="text-align:left"> 
						10. Maintain Address </a>
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_11" style="text-align:left"> 
						11. Notice Sent History </a>
						</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>								
				
			</td></tr>
			</table>			
	</td></tr>
</table>

<div style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				
			</tr>
			</table>
		</td></tr>
		</table>
<!-- Copyright (S) -->
 
<!-- Copyright(E)-->
</form>
</body>
</html>