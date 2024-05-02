<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4008.jsp
*@FileTitle : Issued Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.08 김태균
* 1.0 Creation
* 2011.05.20 김태균[CHM-201110830-01] [DMT] Issued Invoice Inquiry 화면 보완 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strRhq_ofc_cd= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
	
	String today = "";
	String idaTaxApplDt = "";
	String usrCntCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();


		event = (EesDmt4008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		today = eventResponse.getETCData("OFC_CURR_DAY");			// session office code 에 대한 date
		usrCntCd = eventResponse.getETCData("USR_CNT_CD");			// 로그인한 사용자의 COUNTRY CODE
		idaTaxApplDt = eventResponse.getETCData("IDA_TAX_APPL_DT");	// 인도세법 변경에 따른 시스템 적용일자
	} 
	catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Invoice Creation & Issue</title>
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
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="usr_ofc_cd"	value="<%=strUsr_ofc%>">
<input type="hidden" name="s_payer_gubun">
<input type="hidden" name="s_dmdt_trf_cd">
<input type="hidden" name="s_dmdt_ar_if_cd">
<input type="hidden" name="s_dmdt_inv_sts_cd">
<input type="hidden" name="s_issue_ofc">
<input type="hidden" name="s_inv_check">
<input type="hidden" name="intg_cd_id" value="CD01974" >
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="session_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc%>">
<!-- searchCurrentDateByOffice -->
<input type="hidden" name="today_dt" value="<%=today%>">
<input type="hidden" name="ida_tax_appl_dt" value="<%=idaTaxApplDt%>">
<input type="hidden" name="usr_cnt_cd" value="<%=usrCntCd%>">

<!-- subOfficeList -->
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">

<input type="hidden" name="btn_id">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></tr>
		</table>
	<!--Page Title, Historical (E)-->

	
		<!--biz page (S)-->
		
		<table class="search" border="0" id="mainTable"> 
       		<tr><td class="bg">

				<div id="showMin" style="display: inline">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">Tariff Type</td>
					<td width="150"><script language="javascript">ComComboObject('tariff_type',2,111,1,1);</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td  width="55">A/R I/F</td>
					<td  width="120">
						<script language="javascript">ComComboObject('ar_if',2,100,0,1,0,true);</script>
						<% if( strRhq_ofc_cd.equals("NYCRA") || strRhq_ofc_cd.equals("SELHO") ) { %>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"><% } %></td>
					<td  width="55">INV STS</td>
					<td  width="150">
					<script language="javascript">ComComboObject('invoice_status',2,115,0,1,0,true);</script>
						&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td  width="65">Search by</td>
					<td  width="145">
						<select name="srch_tp_cd" style="width:135;" class="input">
							<option value="G" selected>General</option>
						</select>&nbsp;</td> 						
					<td  width="60">Group by</td>
					<td align="right">
						<select name="s_group_by" style="width:90;" class="input">
							<option value="1" selected>B/L No.(BKG No.)</option>
							<option value="2">CNTR No.</option>
						</select>&nbsp;</td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr><td height="3"></td></tr>
				<tr class="h23">
					<td>
						<table border="0" style="width:100%;" class="search_sm2"> 
						<tr class="h23">
							<td width="70"><input type="radio" name="ofc_inv_chk" class="trans" checked onclick="ofc_inv_click()">&nbsp;OFC</td>
							<td width="60" class="stm">Issue OFC</td>
							<td width="250" class="stm" style="padding-left:2">
								<script language="javascript">ComComboObject('office',2,80,0,1,0,true);</script>&nbsp;<img src="img/btns_multisearch.gif" 
							width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"><input type="checkbox" 
							name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">&nbsp;Incl.Sub Office</td>
							<td width="70" class="stm">Issued Date</td>
							<td width="220" class="stm">
							<input type="text" style="width:75;" class="input1" name="s_issue_fm" 
							maxlength="10" dataformat="ymd"  caption="Issued Date From">&nbsp;~&nbsp;<input type="text" style="width:75;" class="input1" name="s_issue_to" value=''  
							maxlength="10" dataformat="ymd"  caption="Issued Date To" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >
							</td>
							<td width="90" class="stm">INV Over Days</td>
<!-- 
							<td width="60"><input type="text" name="s_inv_over" dataformat="int" maxlength="3" minnum='0' caption='F/Time Over Day' style="width:30;text-align:right;" class="input" value="0"></td>
 -->
							<td width="80"><input type="text" name="s_inv_over_fm" dataformat="int" maxlength="3" minnum='0' caption='F/Time Over Day' style="width:30;text-align:right;" class="input" value="0"> -
							<input type="text" name="s_inv_over_to" dataformat="int" maxlength="3" minnum='0' caption='F/Time Over Day' style="width:30;text-align:right;" class="input" value="0"></td>
							<td width="52" class="stm">Issue ID</td>
							<td align=""><input type="text" name="s_issue_usr_id" style="width:75" class="input" value="">&nbsp;<img src="img/btns_search.gif" name="btn_issue_usr" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						</tr>
						</table>	
						<table border="0" style="width:100%;" class="search_sm2"> 
						<tr class="h23">
							<td width="70"><input type="radio" name="ofc_inv_chk" class="trans" onclick="ofc_inv_click()">&nbsp;INV</td>
							<td width="70" class="stm">Invoice No.</td>
							<td width="175"><input type="text" style="width:130" name="s_invoice_no" dataformat="engup2" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch1" width="19" height="20" alt="" border="0" align="absmiddle"></td>
							<td width="50" class="stm">BKG No.</td>
							<td width="240" class="stm"><input type="text" name="s_bkg_no" dataformat="engup2" style="width:177" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch2" width="19" height="20" alt="" border="0" align="absmiddle"></td>
							<td width="50" class="stm">B/L No.</td>
							<td><input type="text" name="s_bl_no" dataformat="engup2" style="width:290" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch3" width="19" height="20" alt="" border="0" align="absmiddle"></td>
						</tr>
						</table>						
					</td>
				</tr> 
				<tr><td height="3"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;&nbsp;Payer</td>
					<td width="440"><input type="text"  name="s_payer_cd" dataformat="engup" caption="Payer" maxlength="8" minlength="8" style="width:70" class="input" value="" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btns_cust_cd" width="19" height="20" alt="" border="0" align="absmiddle">
						<input type="text" name="s_payer_nm" style="width:300" class="input2" value="" readOnly></td>
					<td width="50">S/C No.</td>
					<td ><input type="text" name="s_sc_no" style="width:80" dataformat="engup" class="input" caption="S/C No" maxlength="9" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
					<td align="right" width="50">RFA No.</td>
					<td align="right"><input type="text" name="s_rfa_no" style="width:100" dataformat="engup" class="input" caption="RFA No" maxlength="10" minlength="10" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;</td>
					<td align="right" width="50">TAA No.</td>
					<td align="right"><input type="text" name="s_taa_no" style="width:100" dataformat="engup" class="input" caption="TAA No" maxlength="10" minlength="10" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;</td>
					
				</table>
				<!--  biz_1   (E) --></div>

		</td></tr></table>	
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
				<table width="100%" id="mainTableG" style="display:'inline'"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
				<table width="100%" id="mainTableS" style="display:'none'"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>			
			</td></tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Detail">Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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
<table width="100%"  id="mainTable2" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet4');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>