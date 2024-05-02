<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4001.jsp
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strUsr_rhq = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
	String today = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsr_rhq 	= account.getRhq_ofc_cd();

		event = (EesDmt4001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		today = eventResponse.getETCData("OFC_CURR_DAY");	//session office code 에 대한 date
		
		log.debug("###########################[ofc_curr_day]"+today);

	}catch(Exception e) {
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

<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="s_ofc_cd">
<input type="hidden" name="s_dmdt_trf_cd">
<input type="hidden" name="today_dt" value="<%=today %>">
<input type="hidden" name="s_cust_gubun">

<!-- 권한체크를 위해 사용되는 변수 -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">
<input type="hidden" name="usr_id" 		value="<%= strUsr_id %>">
<input type="hidden" name="usr_role_cd" value="DMT01,DMT02,DMT03">
<input type="hidden" name="pgm_no" 		value="EES_DMT_4001">
<input type="hidden" name="usr_rhq_cd" 	value="<%= strUsr_rhq%>">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<table class="search"> 
       		<tr><td class="bg">
       		<div id="showMin" style="display: inline"><!--  biz_1  (S) -->
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="54">&nbsp;&nbsp;Office </td>
						<td width="120"><script language="javascript">ComComboObject('office',2,80,0,1,0,true);</script></td>
						<td width="70">Tariff type </td>
						<td width="160"><script language="javascript">ComComboObject('tariff_type',2,95,0,1);</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="60">Group by</td>
						<td width="170"><select name="s_group_by" style="width:120;" class="input">
							<option value="1" selected>B/L No.(BKG No.)</option>
							<option value="2">CNTR No.</option>
						</select></td>
						<td width="80">Charge Type </td>
						<td width=""><select name="s_chg_type" style="width:75;" class="input">
						<option value="A" selected>All</option>
						<option value="G">General</option>
						<option value="B">Balance</option>
						</select></td>
					</tr>
				
				</table>
				
				
				
				<table class="search_sm2" border="0" style="width:790;"> 
					<tr class="h23">
						<td width="">
						
				<table class="search" border="0" style="width:700;"> 
					<tr class="h23">
						<td width="65"><input type="radio" name="s_cont_type" class="trans" checked onclick="condType_click()">Date</td>
						<td width="90" class="stm">Confirmed Date</td>
						<td width=""><input type="text" style="width:80;" class="input1" name="fm_cfm_dt" 
							maxlength="10" dataformat="ymd"  caption="Confirmed From Date">&nbsp;~&nbsp;<input type="text" style="width:80;" class="input1" name="to_cfm_dt" value=''  
							maxlength="10" dataformat="ymd"  caption="Confirmed To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" ></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:700;"> 
					<tr class="h23">
						<td width="65"><input type="radio" name="s_cont_type" class="trans" onclick="condType_click()">CNTR</td>
						<td width="50" class="stm">BKG No.</td>
						<td width="200" class="sm"><input type="text" name="s_bkg_no" dataformat="engup2" maxlength="" style="width:100;ime-mode;" class="input" value="" onKeyPress="DmtComKeyOnlyAlphabet('uppernum',',')">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bkg_no')"></td>
						<td width="50" class="stm">B/L No.</td>
						<td width="150" class="stm"><input type="text" name="s_bl_no" dataformat="engup2" maxlength="" style="width:100;ime-mode;" class="input" value="" onKeyPress="DmtComKeyOnlyAlphabet('uppernum',',')">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bl_no')"></td>
						<td width="60" class="stm">CNTR No.</td>
						<td width="" class="stm"><input type="text" name="s_cntr_no" dataformat="engup2" maxlength=""  style="width:100;ime-mode;" class="input" value="" onKeyPress="DmtComKeyOnlyAlphabet('uppernum',',')">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch3" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('cntr_no')"></td>
					</tr>
				</table>
				
				
				
					</td></tr>
				</table>
				
				
				
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">&nbsp;&nbsp;Payer</td>
						<td width="270"><input type="text" name="s_cust_cd" style="width:65;" dataformat="engup" class="input" caption="Payer" maxlength="8" minlength="8" style="236;" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btns_cust_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="s_cust_name" style="width:150;" class="input2" readOnly></td>
						<td width="50">S/C No.</td>
						<td width="150" class="stm"><input type="text" name="s_sc_no" style="width:100;" dataformat="engup" class="input" caption="S/C No" maxlength="9" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
						<td width="59">RFA No.</td>
						<td width="" class="stm"><input type="text" name="s_rfa_no" style="width:100;" dataformat="engup" class="input" caption="RFA No" maxlength="11" minlength="11" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
					</tr>
				</table>
				<!--  biz_1  (E) --></div>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					
				<!-- Grid  (e) -->
				
				
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
 
			
			
					
					
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_minimize">Minimize</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_billing">Billing</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_group_billing">Group Invoice Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>