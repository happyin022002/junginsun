<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4016.jsp
*@FileTitle : SZPSC DEM Calculation &amp; Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.13 황효근
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt4016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_Cnt_cd	= "";
	String strUsr_eml		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm 		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strUsr_Cnt_cd	= account.getCnt_cd();
		strUsr_eml		= account.getUsr_eml();

		event = (EesDmt4016Event)request.getAttribute("Event");
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
<title>SZPSC DEM Calculation &amp; Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="fm_mvmt_yd_cd">
<input type="hidden" name="to_mvmt_yd_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="fm_mvmt_dt">
<input type="hidden" name="to_mvmt_dt">
<input type="hidden" name="yd_cd1">
<input type="hidden" name="loc_cd">
<input type="hidden" name="chk_yd_cd"	value="Y">
<input type="hidden" name="chk_loc_cd"	value="Y">
<input type="hidden" name="backendjob_key">		<!-- BackEndJob Key -->
<input type="hidden" name="backendjob_id">		<!-- BackEndJob 구분 ID -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
	<!-- Tab (E) -->

	<!-- ********************* 	Tab-1 START 	********************** -->
	<div id="tabLayer" style="display:inline">
	<table class="search"> 
       		<tr><td class="bg">
       		
				<div id="sch_cond_div" style=display:inline;>
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="75">&nbsp;&nbsp;&nbsp;Office </td>
						<td width="116"><input type="text" name="ofc_cd" style="width:60;text-align:center;" value="SZPSC" readonly class="input2"></td>
						<td width="70">Tariff Type</td>
						<td width="145"><script language="javascript">ComComboObject('tariff_type',2,80,1,1);</script></td>
						<td width="50">Status</td>
						<td width="" class="stm"><input type="checkbox" name="incl_inv" value="Y"  class="trans">&nbsp;Incl. Invoiced</td>
					</tr>
				</table>
				
				<table class="search_sm2" border="0" style="width:100%;"> 
					<tr class="h23"><td>
			
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="date" class="trans">Date</td>
						<td width="50" class="stm">Period</td>
						<td width="245">
						<input type="text" name="fm_mvmt_dt1" maxlength="8" dataformat="ymd" style="width:80;" class="input1">&nbsp;~&nbsp;
						<input type="text" name="to_mvmt_dt1" maxlength="8" dataformat="ymd" style="width:80;" class="input1">&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="50" class="stm">Yard</td>
						<td width="" class="sm"><input type="radio" name="yard_fmto" value="yard_fm"  checked class="trans" checked>From&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" 
							name="yard_fmto" value="yard_to" class="trans">To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="yd_cd" dataformat="engup" maxlength="5" 
							OnKeyUp="obj_keyup()" style="width:79;" class="input">&nbsp;<script language="javascript">ComComboObject('yd_cd2', 2, 60, 0);</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="vvd_cd" checked class="trans">VVD CD</td>
						<td width="50" class="stm">VVD CD</td>
						<td width="245" class="sm"><input type="text" name="vvd_cd" dataformat="engup"  maxlength="9"  style="width:100;" class="input"></td>
						<td width="45" class="stm">Port</td>
						<td width="" class="stm"><input type="text" name="tmnl_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:50;" class="input"></td>
						</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="cntr" class="trans">CNTR</td>
						<td width="50" class="stm">BKG No.</td>
						<td width="245" class="sm"><input type="text" name="bkg_no" dataformat="engup2" style="width:100;" class="input">&nbsp;<img src="img/btns_multisearch.gif" 
							name="btns_multisearch1" onClick="doProcessPopup('m_bkg_no')" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="45" class="stm">B/L No.</td>
						<td width="140" class="stm"><input type="text" name="bl_no" dataformat="engup2" style="width:100;" class="input">&nbsp;<img src="img/btns_multisearch.gif" 
							name="btns_multisearch2" onClick="doProcessPopup('m_bl_no')" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="60" class="stm">CNTR No.</td>
						<td width="" class="stm"><input type="text" name="cntr_no" dataformat="engup2"  style="width:100;" class="input">&nbsp;<img src="img/btns_multisearch.gif" 
							name="btns_multisearch3" onClick="doProcessPopup('m_cntr_no')" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						</tr>
				</table>
				</td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="75">&nbsp;&nbsp;&nbsp;Customer</td>
						<td width="245"><select name="cust_type" style="width:55;" class="input">
						<option value="" selected>ALL</option>
						<option value="P">Payer</option>
						<option value="S">SHPR</option>
						<option value="C">CNEE</option>
						<option value="N">NTFY</option>
						<option value="A">A/R</option>
						</select>&nbsp;<input type="text" name="cust_cd"  dataformat="engup"  maxlength=8 style="width:100;" class="input" value="">&nbsp;<img src="img/btns_search.gif"
							name="btns_cust_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="104">Service Provider</td>
						<td width="150" class="stm"><input type="text" name="svc_provdr" maxlength="6"  dataformat="int" fulfill  style="width:100;" class="input" value="">&nbsp;<img src="img/btns_search.gif"
							name="btns_svc_provdr" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="50">S/C No.</td>
						<td width="135" class="stm"><input type="text" name="sc_no" dataformat="engup" maxlength=20 style="width:100;" class="input" value=""></td>
						<td width="55">RFA No.</td>
						<td width="" class="stm"><input type="text" name="rfa_no"  dataformat="engup" maxlength=11 style="width:100;" class="input" value=""></td>
					</tr>
				</table>
				<!--  biz_1  (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				</div>
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table> 
				<!-- Grid  (e) -->
				
				<!-- Hidden Grid  (S) -->
				<table width="50%"  id="mainTable2" style=display:none;> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->
				
				<!-- Hidden Grid  (S) -->
				<table width="100%"  id="mainTable3" style=display:none;> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet3');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->
			
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
 		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
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
					<td class="btn1" name="btn_Minimize">Minimize</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_GetToMVMT">Get To MVMT</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Calculate">Calculate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_MBilling">Manual Billing</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
    <!--Button (E) -->
    <!--Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ROInfo" id="btn_ROInfo">R/O Info.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_MVMTInq">MVMT Inq.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ExptInq">Exception Inq.</td>
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
    <!--Button (E) -->
			
		</td></tr>
	</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

	</form>
	</div>
	<!-- ********************* Tab-1 END ********************** -->

	<!-- ******************** Tab_2 (S) START **************************** -->
	 <div id="tabLayer" style="display:none">
	 <table class="search"> 
 		<tr><td class="bg">
		<form name="form2">
				<div id="conditionLayer" style="display:inline">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Invoice No. </td>
						<td width="150"><input type="text" name="dmdt_inv_no" style="width:100;" class="input2" readonly></td>
						<td width="150">Issue Date/OFC/Name </td>
						<td width="370"><input type="text"	name="cre_dt" style="width:80;" class="input2" readonly>&nbsp;<input type="text" name="cre_ofc_cd" 	style="width:50;" class="input2" readonly>&nbsp;<input type="text"	name="cre_usr_nm" 	style="width:180;" class="input2" readonly></td>
						<td width="50">Status</td>
						<td width=""><input type="text" name="dmdt_inv_sts_nm" style="width:184;" class="input2" readonly><input type="hidden" name="dmdt_inv_sts_cd"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">A/R I/F</td>
						<td width="150"><input type="text" name="dmdt_ar_if_cd" style="width:100;" class="input2" readonly></td>
						<td width="150">A/R I/F Date/OFC/Name </td>
						<td width="370"><input type="text" name="ar_if_dt" style="width:80;" class="input2" readonly>&nbsp;<input type="text" name="ar_if_ofc_cd" style="width:50;" class="input2" readonly>&nbsp;<input type="hidden" name="ar_if_usr_id"><input type="text" name="ar_if_usr_nm" style="width:180;" class="input2" readonly></td>
						<td width="75"><span id="cr_nm">Credit Note</span></td>
						<td width=""><input type="text" name="cr_inv_no" style="width:95;" class="input2" readonly>&nbsp;<input type="text" name="cr_ar_yn" style="width:60;" class="input2" readonly></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">BKG No.</td>
						<td width="150"><input type="text" name="s_bkg_no" readonly style="width:100;" class="input2"></td>
						<td width="50">B/L No.</td>
						<td width="170" class="stm"><input type="text" name="bl_no" readonly style="width:100;" class="input2" value=""></td>
						<td width="70">Tariff Type</td>
						<td width="110"><input type="text" name="dmdt_trf_cd" readonly style="width:50;" class="input2" value=""></td>
						<td width="112">Incl. CNTR Detail</td>
						<td width=""><select name="incCntrDtail" disabled style="width:50;" class="input2">
						<option value="Y" selected>Yes </option>
						<option value="N">No</option>
						</select></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">VVD CD</td>
						<td width="150"><input type="text" name="vvd_cd" readonly style="width:100;" class="input2" value=""></td>
						<td width="50">POR</td>
						<td width="75"><input type="text" name="por_cd" readonly style="width:50;" class="input2" value=""></td>
						<td width="25">POL</td>
						<td width="70"><input type="text" name="pol_cd" readonly style="width:50;" class="input2" value=""></td>
						<td width="25">POD</td>
						<td width="66"><input type="text" name="pod_cd" readonly style="width:50;" class="input2" value=""></td>
						<td width="25">DEL</td>
						<td width="68"><input type="text" name="del_cd" readonly style="width:50;" class="input2" value=""></td>
						<td width="27">R/D</td>
						<td width=""><input type="text"  name="rd" readonly style="width:33;" class="input2" value=""></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">BKG Cust.</td>
						<td width=""><input type="text" name="bkg_cust_cd" style="width:100;" class="input2" readonly>&nbsp;<input type="text" name="bkg_cust_nm" style="width:433;" class="input2" readonly></td>
						
					</tr>
					<tr class="h23">
						<td width="70">A/R Cust.</td>
						<td width=""><input type="text" name="act_cust_cd" style="width:100;" class="input2" readonly>&nbsp;<input type="text" name="act_cust_nm" style="width:433;" class="input2" readonly></td>
						
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Payer</td>
						<td width=""><input type="text" name="payer_cd" dataformat="engup" style="width:77;" class="input1" maxlength="8" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="btns_payer_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="payer_nm" style="width:433;" class="input2" readonly></td>
						</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Attention</td>
						<td width="191" style="padding-left:2;"><script language="javascript">ComComboObject('attention', 4, 152, 1, 0, 0, true)</script></td>
						<td width="25">Tel.</td>
						<td width="205"><input type="text" name="payr_cntc_pnt_phn_no" style="width:160;" class="input2" readonly></td>
						<td width="25">Fax</td>
						<td width="180"><input type="text" name="payr_cntc_pnt_fax_no" style="width:160;" class="input2" readonly></td>
						<td width="59">E-mail	</td>
						<td width="" class="stm"><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Trucker</td>
						<td width="626"><input type="text" name="trucker_cd" dataformat="engup" maxlength="6" style="ime-mode:disabled" style="width:77;" class="input" value="">&nbsp;<img src="img/btns_search.gif" name="btns_trucker_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="trucker_nm" readonly style="width:433;" class="input2" value=""></td>
						<td width="62">Due Date</td>
						<td width="85"><input type="text" name="due_date" style="width:80;" class="input2" readOnly></td>
						<td width="79"> Credit Term</td>
						<td width="" class="stm"><input type="text" name="cr_term_dys" style="width:30;" class="input2" readOnly>&nbsp;day</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="695" rowspan="2">
						<table class="search" border="0" style="width:695;"> 
						<tr class="h23">
							<td width="72" valign="top" name="txt_remark" id="txt_remark">Invoice<br>Remark(s)</td>
							<td width="">
								<table border="0" style="width:606; background-color:white;" class="grid2"> 
								<tr class="h23">
								<td><input type="text" name="inv_rmk1" maxlength="85" style="width:100%;" class="noinput" value=""></td>
								</tr>
								<tr class="h23">
								<td><input type="text" name="inv_rmk2" maxlength="85" style="width:100%;" class="noinput" value=""></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
					<td width="">
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="62">Notice</td>
						<td width="80"><select name="ntc_knt_cd" style="width:70;">
						<option value=""></option>
						<option value="1">1st</option>
						<option value="2">2nd</option>
						<option value="3">3rd</option>
						<option value="9">Final</option>
						</select></td>
						<td width="85">INV Over Day</td>
						<td width="" class="stm"><input type="text" name="over_day" readOnly style="width:30;" class="input2" value="">&nbsp;day</td>
					
					</tr>
					<tr class="h23">
						<td width="62">Cust. Ref</td>
						<td width="" colspan="3"><input type="text" name="inv_ref_no" maxlength="20" style="width:100%;" class="input" value=""></td>
					
					</tr>
					</table>
					</td>
				</tr>
				</table>
				</div>
				
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						
					<td width="520" valign="top">
						<table class="search" border="0">
							<tr class="h23"><td class="title_h"></td>
								<td class="title_s" width="120">Charge</td>
								<td width="150">Charge Cur.&nbsp;<input type="text" name="chg_curr_cd" style="width:70;" class="input2" readOnly></td>
								<td align="right">
									<table class="grid2" border="0" width="240" >
									<tr>
										<td width="80" class="tr2_head">Billable AMT</td>
										<td class="noinput2"><input type="text" name="mn_bil_amt"  readOnly style="width:100%;text-align:right"" class="noinput2"></td>
									</tr>
									</table>
								</td>
								
								</tr>
						</table>
						<!-- Grid  (S) -->
						<table class="height_2"><tr><td></td></tr></table>
						<table width="100%"  id="mainTable4"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table>
					
					
				<!-- Grid  (e) -->
				<!--  Button_Sub (S) -->
			<!--
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_row_add"><a href="javascript:ComOpenWindow2('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/dmt/jsp/UI_DMT_4008.jsp','p','scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=605,height=566,left=0,top=0');">MVMT Inq.</a> </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
					</td></tr>
			</table>
			-->
	    				<!-- Button_Sub (E) -->		
					<table style="height:5;"><tr><td></td></tr></table>			
						
						</td>
						<td width="20">&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width="" valign="top">
						
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Invoice</td></tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="60">INV Cur.</td>
								<td><input type="text" name="inv_curr_cd" style="width:80;text-align:left" class="input2" value="" readOnly>
								<!-- 
								<select name="inv_curr_cd" style="width:80;" class="input1" onchange="getExRate()"></select>
								-->
								</td>
								<td width="10"></td>
							</tr>
							<tr class="h23">
								<td width="80">Ex. Rate</td>
								<td><input type="text" name="inv_xch_rt" readOnly style="width:80;text-align:right" class="input2" value=""></td>
							</tr>
							<tr class="h23">
								<td width="80">CNTR Q’ty</td>
								<td><input type="text" name="cntr_cnt" readOnly style="width:80;text-align:right" class="input2" value=""></td>
							</tr>
						</table>
						
						
						</td>
						<td width="280" valign="top">
						
						<table class="grid2" border="0" width="280">
							
							<tr class="h23">
								<td class="tr2_head" width="100"> Total AMT</td>
								<td colspan="3" class="input2" align="right"><input type="text" name="tot_amt" style="width:120;text-align:right" class="noinput2" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> D/C by AMT or %</td>
								<td colspan="3" class="input2" align="right"><input type="text" name="dc_amt"  style="width:120;text-align:right" class="noinput2" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> Billing AMT </td>
								<td colspan="3" class="input2" align="right"><input type="text" name="inv_chg_amt" style="width:120;text-align:right" class="noinput2" readOnly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> Tax Rate/ AMT </td>
								<td class="input2"><input type="checkbox" name="chk_tax"  checked value="" onclick="setTax()" class="trans">&nbsp;<input type="text" name="tax_rto_dis" readOnly style="width:30;text-align:right" class="noinput2" readOnly>&nbsp;% </td>
								<td colspan="2" class="input2" align="right"><input type="text" name="tax_amt" readOnly style="width:60;text-align:right" class="noinput2" value=""></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head"> Payable AMT </td>
								<td colspan="3" class="input2" align="right"><input type="text" name="inv_amt" readOnly style="width:120;text-align:right" class="noinput2" value=""></td>
							</tr>
						</table>
						
						
						</td>
					</tr>
				
				</table>
				
				
				<!--  biz_1  (E) -->
				
				
				
				
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						
					<td width="520" valign="top">
						<table class="search" border="0">
							<tr class="h23"><td class="title_h"></td>
								<td class="title_s"  width="">Rate Detail</td>
								
								
							</tr>
						</table>
						<!-- Grid  (S) -->

						<table width="100%"  id="mainTable5"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet2');</script>
							</td>
						</tr>
					</table>
					
					
				<!-- Grid  (e) -->
					<table style="height:5;"><tr><td></td></tr></table>			
						
						</td>
						<td width="20">&nbsp;&nbsp;&nbsp;&nbsp;</td>
						
						<td width="" valign="top">
						<table class="search" border="0">
							<tr class="h23"><td class="title_h"></td>
								<td class="title_s">Manual Invoice Reason</td>
							</tr>
						</table>
						<table class="grid2" border="0" width="100%">
							
							<tr class="h23">
								<td class="tr2_head" width="100"> Reason</td>
								<td class="input2"><input type="text" name="reason" value="SZPSC DEM Billing" style="width:100%;" class="input2" readonly></td>
							</tr>
							<tr class="h23">
								<td class="tr2_head">Remark(s)</td>
								<td ><textarea name="mnl_inv_rmk" style="width:100%;height:55;"></textarea></td>
							</tr>
						</table>
						
						
						</td>
					</tr>
				</table>
				
				<!--  biz_1  (E) -->
				
				

			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
			
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
      	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SheetSet">Sheet Set</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SheetOpt">Sheet Option</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SendingHistory">Sending History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CRemark" id="btn_CRemark" style="color:;">C. Remark</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_HRemark" id="btn_HRemark" style="color:;">H. Remark</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
		</tr>
		</table>
    <!--Button (E) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New2">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Minimize2">Minimize</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_InvPrint">INV Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_FaxSend">Fax Send</a></td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EmailSend">E-mail Send</a></td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_PayerInfo">Payer Info</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ARIF">A/R I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
    
    	</td></tr>
	</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
    
    </div>
    <!--  Tab_2 (E) -->
	<!-- ******************** Tab_2 END **************************** -->
    
   </td></tr>
</table>


<!-- hidden 처리 (S)--> 
<table width="100%"  id="mainTable6" style=display:none;> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('t2sheet3');</script>
		</td>
	</tr>
</table>
<!-- hidden 처리 (E)-->

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

<!-- RD OBJECT -->		
<table width="100%" height="1" id="mainTable7"> 
	<tr>
		<td width="100%">
			<script language='javascript'>comRdObject('invPreview',0,0);</script>
		</td>
	</tr>
</table>


<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="chg_dc_amt">
<input type="hidden" name="reason" value="SCM">
<input type="hidden" name="success_yn">

<!--  select 조건 -->
<input type="hidden" name="s_ofc_cd" 		value="SZPSC"> <!-- Invoice Curr Cd 조회용(DEM/DET Office Code) -->
<input type="hidden" name="s_chg_type">
<input type="hidden" name="s_dmdt_trf_cd">
<input type="hidden" name="s_cntr_no">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd" >
<input type="hidden" name="invoice_issue"> <!-- 1(before), 2(after) -->
<input type="hidden" name="s_invoice_no"> 
<input type="hidden" name="dmdt_payr_cntc_pnt_nm">
<input type="hidden" name="cust_cntc_pnt_seq" >
<input type="hidden" name="vndr_cd">
<input type="hidden" name="curr_cd">
<input type="hidden" name="rfa_no">			<!-- invoice save 용 -->
<input type="hidden" name="chg_type">		<!-- invoice save 용 -->
<input type="hidden" name="ofc_cd" > 		<!-- Invoice Cur list 조회 용 -->
<input type="hidden" name="svr_id">			<!-- Attention -->
<input type="hidden" name="cust_cnt_cd">	<!-- Attention -->
<input type="hidden" name="cust_seq">		<!-- Attention -->
<input type="hidden" name="tax_rto">
<input type="hidden" name="session_cnt_cd" 		value="<%=strUsr_Cnt_cd%>">
<input type="hidden" name="bil_to_loc_div_cd">	<!-- 0:left, 1:right, default:left -->
<input type="hidden" name="dmdt_chg_sts_cds"	value="">
<input type="hidden" name="session_ofc_cd" 		value="<%=strUsr_ofc%>">
<input type="hidden" name="session_email"		value="<%=strUsr_eml %>">
<input type="hidden" name="session_usr_nm"		value="<%=strUsr_nm %>">
<input type="hidden" name="session_usr_id"		value="<%=strUsr_id%>">
<input type="hidden" name="cre_cnt_cd">
<input type="hidden" name="cre_usr_id">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="vndr_nm">

<!-- Charge Cur list 조회 용 -->
<input type="hidden" name="cnt_cd" value="<%=strUsr_Cnt_cd%>">
<!-- Reason list 조회 용 -->
<input type="hidden" name="intg_cd_id" value="CD01975">

<!-- 저장용 -->
<input type="hidden" name="bkg_no">
<input type="hidden" name="caller">
<input type="hidden" name="ofc_curr_date">

<!-- C.REMARK, H.REMARK -->
<input type="hidden" name="dmdt_cxl_rsn_cd">
<input type="hidden" name="dmdt_cxl_rsn_nm">
<input type="hidden" name="cxl_rmk">
<input type="hidden" name="inv_hld_rsn_cd">
<input type="hidden" name="inv_hld_rsn_nm">
<input type="hidden" name="inv_hld_rmk">
<input type="hidden" name="upd_dt">
<input type="hidden" name="upd_ofc_cd">
<input type="hidden" name="upd_usr_id">
<input type="hidden" name="upd_usr_nm">

<!-- INVOICE TAX_RTO -->
<input type="hidden" name="inv_tax_rto">

<!-- PAYER INFO FAX,EMAIL SETTING -->
<input type="hidden" name="payr_faxnos">
<input type="hidden" name="payr_emailnos">
<input type="hidden" name="act_payr_cust_nm"> <!-- E-mail Send용 Customer Name -->

<!-- EMAIL, FAX SENDING -->
<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- RD FILE NAME 파일 이름만 *.mrd //-->
<input type="hidden" name="rd_fxeml_bat_flg"        > <!-- N //-->
<input type="hidden" name="rd_fxeml_title"          > <!-- 제목 //-->
<input type="hidden" name="rd_fxeml_rd_param"       > <!-- RD REPORT PARAMETER //-->
<input type="hidden" name="rd_fxeml_fax_no"         > <!-- RECIEVER FAX NO ex) NAME:5336  //-->
<input type="hidden" name="rd_fxeml_fax_sndr_id"    > <!-- SENDER ID //-->
<input type="hidden" name="rd_fxeml_eml_sndr_nm"    > <!-- EMAIL SENDER NAME  //-->
<input type="hidden" name="rd_fxeml_eml_sndr_add"   > <!-- SENDER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_rcvr_add"   > <!-- RECIEVER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_atch_file"  > <!-- ATTACH FILE NAME //-->
<input type="hidden" name="rd_fxeml_eml_templt"     > <!-- C:/sitectx/ALPS/APP-INF/config/template/mailtemplate/ TEMPLETE FILE 메일본문 //-->
<input type="hidden" name="rd_fxeml_eml_tmplt_param"> <!-- MAILETEMPLETE PARAM ex) name;mjchang|message;DMT EMAIL SEND TEST //-->
<input type="hidden" name="rd_fxeml_doc_tp"			> <!-- I : Invoice D : Demend G : GroupDemand O : OTS //-->
<input type="hidden" name="payc">					<!-- payer code  -->
<input type="hidden" name="invno">					<!-- invoice no 는 다수개는 , 로 붙여주세요 -->


<!-- SHEET SET 이 존재하는지 확인하기 위해서 사용하는 매개변수 -->
<input type="hidden" name="has_sheetset">
<input type="hidden" name="dmdt_sh_tp_cd">

<!-- preview -->
<input type="hidden" name="org_dmdt_payr_cntc_pnt_nm" >
<input type="hidden" name="org_payr_cntc_pnt_phn_no" >
<input type="hidden" name="org_payr_cntc_pnt_fax_no" >
<input type="hidden" name="org_payr_cntc_pnt_eml" >

<!-- Master RD -->
<input type="hidden" name="rd_sh_addr1">
<input type="hidden" name="rd_sh_addr2">
<input type="hidden" name="rd_sh_addr3">
<input type="hidden" name="rd_invoice_title">
<input type="hidden" name="rd_cancel_note">
<input type="hidden" name="rd_cust_nm">
<input type="hidden" name="rd_payr_addr">
<input type="hidden" name="rd_attn_nm">
<input type="hidden" name="rd_phn_no">
<input type="hidden" name="rd_fax_no">
<input type="hidden" name="rd_dmdt_inv_no">
<input type="hidden" name="rd_issue_day">
<input type="hidden" name="rd_due_date">
<input type="hidden" name="rd_due_day">
<input type="hidden" name="rd_ntc_knt_cd">
<input type="hidden" name="rd_cre_usr_nm">
<input type="hidden" name="rd_cust_cd">
<input type="hidden" name="rd_inv_ref_no">
<input type="hidden" name="rd_cust_vat_no">
<input type="hidden" name="rd_sh_hd_n1st_msg">
<input type="hidden" name="rd_sh_hd_n2nd_msg">
<input type="hidden" name="rd_sh_hd_n3rd_msg">
<input type="hidden" name="rd_sh_hd_n4th_msg">
<input type="hidden" name="rd_sh_hd_n5th_msg">
<input type="hidden" name="rd_vvd_cd">
<input type="hidden" name="rd_vsl_eng_nm">
<input type="hidden" name="rd_arr">
<input type="hidden" name="rd_dep">
<input type="hidden" name="rd_bl_no">
<input type="hidden" name="rd_bkg_no">
<input type="hidden" name="rd_cmdt_nm">
<input type="hidden" name="rd_dmdt_trf_cd">
<input type="hidden" name="rd_dmdt_trf_nm">
<input type="hidden" name="rd_bkg_rcv_term_nm">
<input type="hidden" name="rd_bkg_del_term_nm">
<input type="hidden" name="rd_pod">
<input type="hidden" name="rd_pod_nm">
<input type="hidden" name="rd_del">
<input type="hidden" name="rd_del_nm">
<input type="hidden" name="rd_trucker_nm">
<input type="hidden" name="rd_org_chg_amt">
<input type="hidden" name="rd_org_curr_cd">
<input type="hidden" name="rd_inv_xch_rt">
<input type="hidden" name="rd_tot_amt">
<input type="hidden" name="rd_inv_curr_cd">
<input type="hidden" name="rd_dc_amt">
<input type="hidden" name="rd_inv_chg_amt">
<input type="hidden" name="rd_tax_rto">
<input type="hidden" name="rd_tax_amt">
<input type="hidden" name="rd_inv_amt">
<input type="hidden" name="rd_inv_rmk1">
<input type="hidden" name="rd_inv_rmk2">
<input type="hidden" name="rd_sh_rmk1">
<input type="hidden" name="rd_sh_rmk2">
<input type="hidden" name="rd_sh_rmk3">
<input type="hidden" name="rd_sh_rmk4">
<input type="hidden" name="rd_sh_rmk5">
<input type="hidden" name="rd_sh_rmk6">
<input type="hidden" name="rd_sh_rmk7">
<input type="hidden" name="rd_sh_rmk8">
<input type="hidden" name="rd_sh_rmk9">
<input type="hidden" name="rd_sh_rmk10">
<input type="hidden" name="rd_sh_rmk11">
<input type="hidden" name="rd_sh_rmk12">
<input type="hidden" name="rd_sh_rmk13">
<input type="hidden" name="rd_sh_rmk14">
<input type="hidden" name="rd_tax_amt_prn_flg">
<input type="hidden" name="rd_phn_fax_prn_flg">
<input type="hidden" name="rd_cust_vat_prn_flg">
<input type="hidden" name="rd_dc_amt_flg">
<input type="hidden" name="rd_cust_ref_prn_flg">
<input type="hidden" name="rd_days_disp">
<input type="hidden" name="rd_dmdt_inv_sts_cd">
<input type="hidden" name="rd_cre_cnt_cd">
</form>

<!-- 개발자 작업  끝 -->
</body>
</html>