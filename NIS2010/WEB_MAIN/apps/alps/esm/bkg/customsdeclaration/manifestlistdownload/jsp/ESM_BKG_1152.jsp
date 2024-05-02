<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1152.jsp
*@FileTitle : Europe Advanced Manifest - EXS Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.22
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.22 김보배
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1152Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1152Event  event = null;
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	    
		event = (EsmBkg1152Event)request.getAttribute("Event");
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
<title></title>
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="call_type" value="ESM_BKG_1152">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->	
			
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="450">
					  EU POL ETB &nbsp
					  <input type="text" style="width:80" value="" class="input1"  name="p_from_dt"  maxlength='10' dataformat="ymd" >
					  <input type="text" name="p_from_mt" style="width:40" value="00:00" class="input1" dataformat="hm"  maxlength="5" required>
					   &nbsp;~&nbsp;
					  <input type="text" style="width:80" value="" class="input1"  name="p_to_dt"  maxlength='10' dataformat="ymd" >
					  <input type="text" name="p_to_mt" style="width:40" value="23:59" class="input1" dataformat="hm"  maxlength="5" required >
					  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_date">
				   	<td width=""><input type="radio" name="p_rhq_gb" value="PO" class="trans" checked>POL Office &nbsp
						<input type="radio" name="p_rhq_gb" value="BO"   class="trans">BKG Office</td>
					<td width=""></td>
					<td width=""></td>
					<td width="70">Type</td>
					<td width="80">
						<select style="width: 65;" name="p_type">
							<option value="" selected>EXS</option>
						</select>
					</td>
					</td>
				</tr>	
				</table> 
				<table class="" border="0"> 
				<tr class="h23">
					<td width="50">EU POL</td>
					<td width="80"><input type="text" style="width:60;" class="input" name="p_pol" value="" maxlength='7' dataformat='engupnum' style="ime-mode:disabled" ></td>
					<td width="65" style="display:inline" id="p_pol_ofc">POL OFC</td><td width="65" style="display:none" id="p_bkg_ofc">BKG OFC</td>
					<td width="90"><input type="text" style="width:70;" class="input" name="p_b_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>					
					<td width="50"> &nbsp;&nbsp;VVD</td>
					<td width="100"><input type="text" style="width:80;" class="input" name="p_vvd" value=""  maxlength='9' dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width="40"> &nbsp;&nbsp;LANE</td>
					<td width="40"><input type="text" style="width:30;" class="input" name="cond_lane" value=""  maxlength='3' dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width="150"></td>
				</tr>	
				</table>
				
				</td></tr>
			</table>
			<!--  biz_1   (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>	
		
			<!--Grid (s)-->
	<table class="search"> 
       	<tr><td class="bg">						
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!--Grid (E)-->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Sent B/L</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2" name="div_sent_bl_cnt" readonly></td>
					<td width="20" align='center'> = </td>
					<td width="50">Accepted</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_acc_bl_cnt" readonly></td>
					<td width="20" align='center'> + </td>
					<td width="60" style='color:red'>Rejected</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_rej_bl_cnt" readonly style='color:red'></td>
					<td width="20" align='center'> + </td>
					<td width="80" style='color:red'>Not-received</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_nrcv_bl_cnt" readonly style='color:red'></td>
					<td width="20" align='center'> + </td>
					<td width="80" style='color:red'>Do Not Load</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_donld_bl_cnt" readonly style='color:red'></td>
					<td width="20" align='center'> + </td>
					<td width="30" style='color:red'>Hold</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_hold_bl_cnt" readonly style='color:red'></td>
					<td width="20" align='center'> + </td>
					<td width="50">Released</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_rel_bl_cnt" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">	
				<tr class="h23">
					<td width="510"></td>
					<td width="60">Total B/L</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_bl" readonly></td>
					<td width="35"></td>
					<td width="37"> VVD </td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_vvd" readonly></td>
					<td width="35"></td>
					<td width="115"> &nbsp; EXS Amendment</td>
					<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_amd_cnt" readonly></td>
				</tr>	
				</table>
			</td></tr>
		</table>		
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
	<tr>
		<td>
	<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
		      <tr>
				<td class="">
				
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-bottom:0;padding-left:5;"> 
			       	<tr><td class="" align="right">
					    <table border="0" cellpadding="0" cellspacing="0">
					    <tr>			
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
								<td class="btn1" name="btn_DownExcel">Down Excel</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							
						</tr>
						</table>
					</td></tr>
					</table>
				
				</td>
			  </tr>
			</table>
    <!--Button (E) -->
    	
		</td>
	</tr>
	</table>
	 
<!--  Body table end -->

</form>
</body>
</html>