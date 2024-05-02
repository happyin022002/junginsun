<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1120.jsp
*@FileTitle : Europe Advanced Manifest - ENS Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 이재위
*@LastVersion : 1.0
* 2011.03.28 이재위
* 1.0 Creation
*--------------------------------------------------------
* History
* 2011.03.28 이재위 [] [ESM-BKG] Europe Advanced Manifest-ENS Monitoring : Retrieve,File Download 
* 2012.05.15 김보배 [CHM-201217766] [BKG] ENS Monitoring 화면상 Lane 조회값 추가요청
* 2012.09.03 김보배 [CHM-201219738] [BKG] EXS Monitor 화면 (UI_BKG_1148) 개발 요청 (UI_BKG_1148 기존재로 인해 UI_BKG_1152 로 생성)
* 2014.12.22 [CHM-201432800]ENS 화면 보완 요청
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1120Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1120Event  event = null;
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
	    
		event = (EsmBkg1120Event)request.getAttribute("Event");
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
<input type="hidden" name="call_type" value="ESM_BKG_1120">

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
					<td width="180">
						<table class="search_sm2" border="0" style="width:100%;"> 
						<tr class="stm">
				   	    <td width=""><input type="radio" name="p_date_gb" value="B" class="trans" checked>POL ETB &nbsp
						<input type="radio" name="p_date_gb" value="A"   class="trans">POFE ETA</td>
						</tr>	
						</table>
				    </td>
					<td width="330">
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
							<option value="" selected>ENS</option>
						</select>
					</td>
					</td>
				</tr>	
				</table> 
				<table class="" border="0"> 
				<tr class="h23">
					<td width="30">RHQ</td>
					<td width="90">
						<script language="javascript">ComComboObject('rhq', 1, 70, 0,0,1);</script>
					</td>
					<td width="65" style="display:inline" id="p_pol_ofc">POL OFC</td><td width="65" style="display:none" id="p_bkg_ofc">BKG OFC</td>
					<td width="90"><input type="text" style="width:70;" class="input" name="p_b_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>					
					<td width="40">POL</td>
					<td width="116"><input type="text" style="width:60;" class="input" name="p_pol" value="" maxlength='5' dataformat='engup' style="ime-mode:disabled" >
					           &nbsp<input type="text" style="width:25"  class="input" name="p_pol_yd"  value=""  maxlength='2' dataformat='engupnum' style="ime-mode:disabled">
					</td>
					<td width="50">POFE</td>
					<td width="85"><input type="text" style="width:65;" class="input" name="p_pofe" maxlength='7' dataformat='engupnum' style="ime-mode:disabled"></td>					
					<td width="50"> &nbsp;&nbsp;VVD</td>
					<td width="100"><input type="text" style="width:80;" class="input" name="p_vvd" value=""  maxlength='9' dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width="40"> &nbsp;&nbsp;LANE</td>
					<td width="40"><input type="text" style="width:30;" class="input" name="cond_lane" value=""  maxlength='3' dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width="30"><input type="checkbox" name="p_fdr_yn" value="Y" class="trans"></td>
					<td width="70">Incl. FDR</td>
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
				<td width="72">Total B/L</td>
				<td width="60"><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_bl_cnt" readonly></td>
				<td width="40" align='center'> = </td>
				<td width="58">Accepted</td>
				<td width="60"><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_acc_bl_cnt" readonly></td>
				<td width="720"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="80"></td>
				<td width="60"></td>
				<td width="40" align='center'> + </td>
				<td width="60" style="color:red;">Rejected</td>
				<td width="60"><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_rej_bl_cnt" readonly style='color:red'></td>
				<td width="40" align='center'> + </td>
				<td width="60" style="color:red;">Not-received</td>
				<td width="60"><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_nrcv_bl_cnt" readonly style='color:red'></td>
				<td width="40" align='center'> + </td>
				<td width="90" style="color:red;">Do Not Load</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_donld_bl_cnt" readonly style='color:red'></td>
				<td width="40" align='center'> + </td>
				<td width="90" style="color:red;">Un-Sent B/L</td>
				<td width="60"><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_unsent_bl_cnt" readonly style='color:red'></td>
				<td width="40" align='center'></td>
				<td width="80" style="color:red;">To Send B/L</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_tosend_bl_cnt" readonly style='color:red'></td>
				</tr>	
				<tr class="h23">
				<td width="80">Total ENS (USD)</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_ens_amt" readonly></td>
				<td width="40" align='center'> = </td>
				<td width="60">SHARC</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_shaas_ens" readonly></td>
				<td width="40" align='center'> + </td>
				<td width="60">NYCRA</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_nycna_ens" readonly></td>
				<td width="40" align='center'> + </td>
				<td width="60" >HAMRU</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_hamur_ens" readonly></td>
				<td width="40" align='center'> + </td>
				<td width="60" >SINRS</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_sinwa_ens" readonly></td>
				<td width="40"></td>
				<td width="40" >VVD</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_vvd_cnt" readonly></td>
				</tr>	
				<tr class="h23">
				<td width="80">Total MCF (USD)</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_mcf_amt" readonly></td>
				<td width="40" align='center'> = </td>
				<td width="60">SHARC</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_shaas_mcf" readonly></td>
				<td width="40" align='center'> + </td>
				<td width="60">NYCRA</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_nycna_mcf" readonly></td>
				<td width="40" align='center'> + </td>
				<td width="60" >HAMRU</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_hamur_mcf" readonly></td>
				<td width="40" align='center'> + </td>
				<td width="60" >SINRS</td>
				<td width="60"><input type="text" style="width:60;text-align:right;" value="" class="input2"  name="div_total_sinwa_mcf" readonly></td>
				<td width="40"></td>
				<td width="45" >ENS Amendment</td>
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
			<table width="100%" align='left' class='search'>
				<tr>
					<td width="100%"> * ENS surcharge should be rated for feeder ENS cases as well.</td>
				</tr>
				<tr>
					<td width="100%"> * MCF surcharge should be rated for ENS original case sent  more than one time due to customer’s fault/request.</td>
				</tr>
				<tr>
					<td width="100%"> * Comparison : <font color="red">Un-Sent B/L</font> (Original transmission required) <font color="red">To Send B/L</font> (Amendment transmission required because of B/L change)</td>
				</tr>
			</table>						
		</td>
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
	 

	</td></tr>
 </table><!--  Body table end -->

</form>
</body>
</html>