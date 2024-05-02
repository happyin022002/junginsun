<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1108.jsp
*@FileTitle : Europe Advanced Manifest - ENS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
*--------------------------------------------------------
* History
* 2010.10.13 김경섭 [CHM-201005134] [ESM-BKG] Europe Advanced Manifest-ENS Download  & Transmit : Retrieve,EDI File Download , EDI Transmit 반영
* 2011.04.14 김경섭 [CHM-201109994] [ESM-BKG] ENS Report: 엑셀다운시 CNTR NO별 분리(Download용 sheet추가 및 복제),POFE 체크로직 수정
* 2013.05.13 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
* 2015.12.01 [CHM-201538926]	[ENS] WAND1543N 항차 / POFE calling seq 적용 로직 테스트
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strPgmNo			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
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
<input type="hidden" name="call_type" value="ESM_BKG_1108">
<input type="hidden" name="pgmNo"  value="<%=strPgmNo%>">
<input type="hidden" name="eu_1st_port_clpt_seq">

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
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;Type</td>
					<td width="120">
						<script language="javascript">ComComboObject('p_type', 1, 110, 1, '');</script>
					</td>
					<td width="800"></td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- ENS start-->
				<div id="ensView" style="display:inline">
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="40"> &nbsp;&nbsp;VVD</td>
					<td width="200"><input type="text" style="width:100;" class="input1" name="p_vvd" value=""  maxlength='9' dataformat='engupnum' style="ime-mode:disabled">
									<input type="text" style="width:50;" class="input2" name="p_lane" value=""  maxlength='3'  dataformat='engupnum' style="ime-mode:disabled" readonly>
					</td>
					<td width="30">POL</td>
					<td width="116"><input type="text" style="width:70;" class="input1" name="p_pol" value="" maxlength='5' dataformat='engup' style="ime-mode:disabled" >
					           &nbsp<input type="text" style="width:25"  class="input" name="p_pol_yd"  value=""  maxlength='2' dataformat='engupnum' style="ime-mode:disabled">
					</td>
					<td width="65">BKG OFC</td>
					<td width="90"><input type="text" style="width:70;" class="input" name="p_b_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>					
					<td width="160">POFE (Port of First Entry)</td>
					<td width="120"><script language="javascript">ComComboObject('p_pofe_yd_temp', 1, 100, '');</script>
								<input type="hidden" name="p_pofe" value="">
								<input type="hidden" name="p_pofe_yd" value="">
								<input type="hidden" name="p_search_pofe_yard_cd" value="">
					           &nbsp<!-- input type="text" style="width:25"  class="input" name="p_pofe_yd"  value=""  maxlength='2' dataformat='engupnum' style="ime-mode:disabled" readonly-->
					</td>
					<td width='140'>Incl. Canceled Booking</td>
					<td><input type="checkbox" name="p_cancel_yn" value="Y" class="trans"></td>
				</tr>	
				</table> 
				</div>
				<!-- ENS end -->

				<!-- Finland start -->
				<div id="fiView" style="display:inline">
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="40"> &nbsp;&nbsp;VVD</td>
					<td width="200"><input type="text" style="width:100;" class="input1" name="p_fi_vvd" value=""  maxlength='9' dataformat='engupnum' style="ime-mode:disabled">
									<input type="text" style="width:50;" class="input2" name="p_fi_lane" value=""  maxlength='3'  dataformat='engupnum' style="ime-mode:disabled" readonly>
					</td>
					<td width="80">Pre EU Port</td>
						<td width="110">
							<input type="text" style="width:50;" class="input2" name="p_fi_pol" value="" maxlength='5' dataformat='engup' style="ime-mode:disabled" ReadOnly>
							<input type="text" style="width:30;" class="input2" name="p_fi_pol_yd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled" ReadOnly></td>
					<td width="65">BKG OFC</td>
					<td width="100"><input type="text" style="width:70;" class="input" name="p_fi_b_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>					
					<td width="30">POD</td>  
						<td width="120"><input type="text" style="width:50;" class="input1" name="p_fi_pofe" value="FIKTK" maxlength='5' dataformat='engup' style="ime-mode:disabled" >
						<input type="text" style="width:30;" class="input" name="p_fi_pofe_yd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width='140'>Incl. Canceled Booking</td>
					<td><input type="checkbox" name="p_fi_cancel_yn" value="Y" class="trans"></td>
				</tr>	
				</table> 
				</div>
				<!-- Finland end -->
				
				
					<table class="" border="0"> 
				<tr class="h23">
					<td width="60">&nbsp;&nbsp;BL/No</td>
					<td width="120"><input type="text" style="width:100;" class="input" name="p_bl_no" value=""  maxlength='12' dataformat='engupnum' style="ime-mode:disabled">
					</td>
					<td width="180">
						<table class="search_sm2" border="0" style="width:100%;"> 
						<tr class="stm">
				   	    <td width=""><input type="radio" name="p_date_gb" value="S" class="trans" checked>Send &nbsp
						<input type="radio" name="p_date_gb" value="R"   class="trans">Receive Date</td>
						</tr>	
						</table>
				    </td>
					<td width="350">
					  <input type="text" style="width:80" value="" class="input"  name="p_from_dt"  maxlength='10' dataformat="ymd" >
					  <input type="text" name="p_from_mt" style="width:40" value="00:00" class="input" dataformat="hm"  maxlength="5" required>
					   &nbsp;~&nbsp;
					  <input type="text" style="width:80" value="" class="input"  name="p_to_dt"  maxlength='10' dataformat="ymd" >
					  <input type="text" name="p_to_mt" style="width:40" value="23:59" class="input" dataformat="hm"  maxlength="5" required >
					  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_date">
					</td>
					<td width="80">Sent Type</td>
					<td width="80">
						<select style="width: 65;" name="p_sent_type">
							<option value="" selected>All</option>
							<option value="O">Original</option>
							<option value="U">Amend</option>
							<option value="DL">D/L</option>
							<option value="NA">N/A</option>
						</select>
					</td>
					<td width="80">Ack. Status</td>
					<td width="">
						<select style="width: 120;" name="p_ack_status">
							<option value="" selected>All</option>
							<option value="A">Accepted</option>
							<option value="R">Rejected</option>
							<option value="DNL">Do Not Load</option>
							<option value="NR">Not Received</option>
							<option value="NA">N/A</option>
						</select>
					</td>
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
				<td width="80">Total B/L</td>
				<td width="70"><input type="text" style="width:70;" value="" class="input2" name="div_total_bl_cnt" readonly></td>
				<td width="20" align='center'> = </td>
				<td width="60" >Sent B/L</td>
				<td width="70"><input type="text" style="width:70;" value="" class="input2"  name="div_sent_bl_cnt" readonly></td>
				<td width="20" align='center'> + </td>
				<td width="80" style='color:red'>Un-Sent B/L</td>
				<td width="70"><input type="text" style="width:70;" value="" class="input2"  name="div_unsent_bl_cnt" readonly style='color:red'></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				</tr>	
				<tr class="h23">
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width="" >Sent B/L</td>
				<td width=""><input type="text" style="width:70;" value="" class="input2"  name="div_sent_bl_cnt2" readonly></td>
				<td width="20" align='center'> = </td>
				<td width="" >Accepted</td>
				<td width=""><input type="text" style="width:70;" value="" class="input2"  name="div_a_cnt" readonly></td>
				<td width="20" align='center'> + </td>
				<td width="" style='color:red'>Rejected</td>
				<td width=""><input type="text" style="width:70;" value="" class="input2"  name="div_r_cnt" readonly style='color:red'></td>
				<td width="20" align='center'> + </td>
				<td width="" style='color:red'>Do Not Load</td>
				<td width=""><input type="text" style="width:70;" value="" class="input2"  name="div_dnl_cnt" readonly style='color:red'></td>
				<td width="20" align='center'> + </td>
				<td width="" style='color:red'>Not Received</td>
				<td width=""><input type="text" style="width:70;" value="" class="input2"  name="div_nr_cnt" readonly style='color:red'></td>
				</tr>	
				</table>
<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
		<td class="">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Inquiry">B/L Inquiry</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_History">Transmit & Receive History</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_viewMsg">View Message</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
		
		</td></tr>
		</table>
    <!--Button (E) -->					
			</td></tr>
		</table>		
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr>
			<td>	
				<table width="100%" align='left' class='search'>
					<tr>
						<td width="100%"> * EORI No Validation : <a target='_blank' href="http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp" target="_blank">http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp  </a>	</td>
					</tr>
					<tr>
						<td width="100%"> * HS Code Validation : <a target='_blank' href="http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en" target="_blank">http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en  </a>	</td>
					</tr>
				</table>						
			</td>
			<td>
	<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		      <tr>
				<td class="">
				
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;,padding-left:5;"> 
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
								<td class="btn1" name="btn_DownExcel">Down Excel
								</td>
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
	 

	</td></tr>
 </table><!--  Body table end -->

</form>
<table width="100%" id="mainTable" style="display:none">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
	</tr>
</table>
<table width="100%" id="mainTable" style="display:none">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script></td>
	</tr>
</table>
<table width="100%" id="mainTable" style="display:none">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet4');</script></td>
	</tr>
<table width="100%" id="mainTable" style="display:none">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheetDownload');</script></td>
	</tr>
</table>
</table>
</body>
</html>
