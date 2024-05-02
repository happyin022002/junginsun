<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0009.jsp
*@FileTitle : Invoice Inquiry by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.08 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0009Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm	= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	String view_bl_src_no = request.getParameter("bl_src_no");
	if(view_bl_src_no == null){
		view_bl_src_no = "";
	}
	
	String view_ar_ofc_cd = request.getParameter("ar_ofc_cd");
	if(view_ar_ofc_cd == null){
		view_ar_ofc_cd = "";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (FnsInv0009Event)request.getAttribute("Event");
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
<title>Invoice Inquiry by B/L No</title>
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

<%
	if(view_bl_src_no.equals("") && view_ar_ofc_cd.equals("")){
%>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="office">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="view_bl_src_no" value="<%=view_bl_src_no%>">
<input type="hidden" name="view_ar_ofc_cd" value="<%=view_ar_ofc_cd%>">

<input type="hidden" name="bl_tp_cd" value = "">
<input type="hidden" name="rev_type" value = "">
<input type="hidden" name="rev_type_A" value = "A">
<input type="hidden" name="rev_type_B" value = "">
<input type="hidden" name="rev_type_C" value = "">
<input type="hidden" name="rev_type_D" value = "">
<input type="hidden" name="rev_type_M" value = "">

<input type="hidden" name="dp_prcs_knt" value="0">
<input type="hidden" name="dp_prcs_knt_local" value="0">

<input type="hidden" name="inv_dup_flg" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)--> 
<%
	}
	else {
%>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="office">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="view_bl_src_no" value="<%=view_bl_src_no%>">
<input type="hidden" name="view_ar_ofc_cd" value="<%=view_ar_ofc_cd%>">

<input type="hidden" name="bl_tp_cd" value = "">
<input type="hidden" name="rev_type" value = "">
<input type="hidden" name="rev_type_A" value = "A">
<input type="hidden" name="rev_type_B" value = "">
<input type="hidden" name="rev_type_C" value = "">
<input type="hidden" name="rev_type_D" value = "">
<input type="hidden" name="rev_type_M" value = "">

<input type="hidden" name="dp_prcs_knt" value="0">
<input type="hidden" name="dp_prcs_knt_local" value="0">

<input type="hidden" name="inv_dup_flg" value="">

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr> <!-- POP UP Title line  -->
<tr>
	<td valign="top">
		
		<!-- : ( Title ) (S) -->
		<table width="540" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Inquiry by B/L No</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%
	}
%>		
							
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">B/L No.&nbsp;</td>
					<td width="165"><input name="bl_src_no" type="text" style="width:105;" class="input1" value="" dataformat="engup" maxlength="12"></td>
					<td width="50">BKG No.</td>
					<td width="162"><input name="bkg_no" type="text" style="width:105;" class="input1" value="" dataformat="engup" maxlength="13">&nbsp;<!-- <input name="bkg_no_split" type="text" style="width:26;" class="input1" value="" dataformat="engup" maxlength="2"> --></td> 
					<!-- 
					<td width="80">B/L Type</td>
					<td width="100" class="stm"><input name="chk_bl_tp_cd" type="checkbox" value="" class="trans" disabled tabIndex="-1">Waybil</td>
					 -->
					<td width="40">Office</td>   
					<td>
						<div id="arOfcCdDiv1" style="display:block">
							<input name="ar_ofc_cd_text" type="text" style="width:65;" class="input2" value="" readonly>
						</div>
						<div id="arOfcCdDiv2" style="display:none">
							<script language="javascript">ComComboObject('ar_ofc_cd', 1, 80, 1, 3);</script>
						</div>
					</td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Actual Cust.&nbsp;</td>
					<td width="125"><input name="act_cust_cnt_cd" type="text" style="width:30;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="act_cust_seq" type="text" style="width:60;" class="input2" value="" readOnly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust"></td> 
					<td width="425"><input name="cust_lgl_eng_nm" type="text" style="width:300;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="cust_rgst_no" type="text" style="width:110;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td>
						<table class="search_sm2" border="0" style="width:350;"> 
						<tr class="h23">
							<td width="80">Rev. Type</td>
							<td width="" class="stm"><input name="chk_rev_type" type="checkbox" value="A" class="trans" checked>All&nbsp;&nbsp;<input name="chk_rev_type" type="checkbox" value="B" class="trans" disabled="true">B/L&nbsp;&nbsp;<input name="chk_rev_type" type="checkbox" value="C" class="trans" disabled="true">C/A&nbsp;&nbsp;<input name="chk_rev_type" type="checkbox" value="D" class="trans" disabled="true">DEM/DET&nbsp;&nbsp;<input name="chk_rev_type" type="checkbox" value="M" class="trans" disabled="true">Mis</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Credit Limit&nbsp;</td>
					<td width="150"><input name="cr_curr_cd" type="text" style="width:30;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="cr_amt" type="text" style="width:80;text-align:right;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90">Credit Term&nbsp;</td> 
					<td width="130" class="stm">O/B&nbsp;<input name="ob_cr_term_dys" type="text" style="width:25;text-align:right;" class="input2" value="" readOnly tabIndex="-1">&nbsp;I/B&nbsp;<input name="ib_cr_term_dys" type="text" style="width:25;text-align:right;" class="input2" value="" readOnly tabIndex="-1">
					<td width="120">Credit Office&nbsp;</td>
					<td width="140"><input name="cr_clt_ofc_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="50">Good</td> 
					<td width="60"><input name="good" type="text" style="width:45;text-align:right;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="60">No-Good</td> 
					<td width=""><input name="nogood" type="text" style="width:45;text-align:right;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>	
				</table>
						
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Local VVD&nbsp;</td>
					<td width="150"><input name="vvd" type="text" style="width:114;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90">Scope&nbsp;</td>
					<td width="130"><input name="svc_scp_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="120">Bound&nbsp;</td>
					<td width="140"><input name="io_bnd_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="80">S/A Date&nbsp;</td>
					<td width="" colspan="5"><input name="sail_arr_dt" type="text" style="width:72;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				</table>
						
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Trunk VVD&nbsp;</td>
					<td width="150"><input name="trunk_vvd" type="text" style="width:114;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90">Lane&nbsp;</td> 
					<td width="130"><input name="slan_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="120">POR / POL&nbsp;</td>
					<td width="140"><input name="por_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"> / <input name="pol_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="80">POD / DEL&nbsp;</td>
					<td width=""><input name="pod_cd" type="text"style="width:50;" class="input2" value="" readOnly tabIndex="-1"> / <input name="del_cd" type="text"style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				</table>
						
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Weight&nbsp;</td>
					<td width="150"><input name="cgo_wgt" type="text" style="width:114;text-align:right;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="90">Measure&nbsp;</td>
					<td width="130"><input name="cgo_meas_qty" type="text" style="width:104;text-align:right;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="120">Ex. Rate(USD:LCL)&nbsp;</td> 
					<td width="140"><input name="usd_xch_rt" type="text" style="width:70;text-align:right;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="xch_rt_usd_tp_cd" type="text" style="width:30;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="80">TEU / FEU&nbsp;</td> 
					<td width=""><input name="bkg_teu_qty" type="text" style="width:50;text-align:right;" class="input2" value="" readOnly tabIndex="-1"> / <input name="bkg_feu_qty" type="text" style="width:50;text-align:right;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_container"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Sales Rep.&nbsp;</td>
					<td width="150"><input name="srep_cd" type="text" style="width:114;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90">RFA No.&nbsp;</td>
					<td width="130"><input name="rfa_no" type="text" style="width:104;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="120">S/C No.&nbsp;</td>
					<td width="140"><input name="sc_no" type="text" style="width:104;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="80">CTRT Office&nbsp;</td>
					<td width=""><input name="ctrt_ofc_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				</table>	
			</td>
		</tr>
		</table>
	
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
   		<tr><td width="100%">
			<script language="javascript">ComTabObject('tab1')</script>
			<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
		</td></tr>
		</table>
		<!-- Tab ) (E) --> 

		
		<!--TAB Total Amount (S) -->
		<div id="tabLayer" style="display:inline">		
		
		<table class="search"> 
       	<tr>
       		<td class="bg">	
				<!-- Grid (S) -->

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="379" rowspan="7" valign="top">
						<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
						</table> 
					</td>
					<td width="20" rowspan="7"></td>
					<td width="580" rowspan="7">
						<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet2');</script>
							</td>
						</tr>
						</table> 
				<!-- Grid (E) -->
					</td>
				</tr>
				</table>				
			
			</td>
		</tr>
		</table>
	<!-- Tab BG Box(E) -->
	<!--biz page (E)-->	

<%
	if(view_bl_src_no.equals("") && view_ar_ofc_cd.equals("")){
%>	
		
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
       	<tr>
       		<td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_t1new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td>
		</tr>
		</table> 
    <!--Button (E) -->
<%
	}
	else {
%>

	<!-- : ( Button : Sub ) (S) -->
		<table width="100%" class="sbutton">
		<tr>
			<td height="71" class="popup">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
    					<table border="0" cellpadding="0" cellspacing="0">
    					<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_t1new">New</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- : ( Button : Sub ) (E) -->
<%
	}
%>

	
		</div>

<!--TAB Total Amount (E) --> 

<!--TAB History (S) -->
<div id="tabLayer" style="display:none">
<table class="search"> 
     	<tr><td class="bg">	
		<!-- Grid (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
					</td>
				</tr>
			</table>
			<table width="100%"> 
				<tr align="right">
					<td width="">&nbsp;</td>
					<td width="445">
						<table width="100%"  id="mainTable2"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet2');</script>
							</td>
						</tr>
						</table>
					</td>
				</tr>
			</table>
<!-- Grid (E) -->
</td></tr>
</table> 


<!-- Tab BG Box(E) -->
<!--biz page (E)-->

<%
	if(view_bl_src_no.equals("") && view_ar_ofc_cd.equals("")){
%>	

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
<tr>
	<td class="btn1_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_t2new">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_t2downexcel">Down Excel</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_t2history">History</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_t2sysclear">Hide Sys Clear</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	</td>
</tr>
</table>

<%
	}
	else {
%>

<!-- : ( Button : Sub ) (S) -->
		<table width="100%" class="sbutton">
		<tr>
			<td height="71" class="popup">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
    					<table border="0" cellpadding="0" cellspacing="0">
    					<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_t2new">New</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_t2downexcel">Down Excel</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_t2history">History</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_t2sysclear">Hide Sys Clear</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- : ( Button : Sub ) (E) -->
<%
	}
%>

</div>


</td></tr>
</table> 
<!--TAB History (E) --> 
<!-- Container (S) -->

<table width="1" > 
	<tr>
		<td width="100%" style="display:none">
			<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table> 				

<!-- Container (E) -->	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>