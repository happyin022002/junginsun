<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5002.jsp
*@FileTitle : Invoice Interface to A/R 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.09 최성환
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt5002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd    = "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.invoiceissuecollectionmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();


		event = (EesDmt5002Event)request.getAttribute("Event");
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
<title>Invoice Interface to A/R</title>
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
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="rhq_ofc_cd" value="<%=strRhq_ofc_cd%>">

<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="ofc_tp">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="chk_hold">

<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<!-- 개발자 작업	-->
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
       			<div id="sch_cond_div" style=display:block;>
				<!--  biz_1  (S) -->				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="86">&nbsp;&nbsp;Issue Office</td>
						<td width="174"><script language="javascript">ComComboObject('office', 2, 80, 0, 1, 0, true);</script></td>
						<td width="70">Tariff type </td>
						<td width="360"><script language="javascript">ComComboObject('tariff_type', 2, 250, 0, 1);</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
<% if( strRhq_ofc_cd.equalsIgnoreCase("NYCRA") || strRhq_ofc_cd.equalsIgnoreCase("SELHO") ) { %>						
						<td width="295" align="right"><input type="checkbox" name="chk_hold_box" value="" class="trans">Include INV Hold&nbsp;&nbsp;</td>
<% } else { %>					
						<td width="295" align="right"><input type="hidden" name="chk_hold_box" value="" class="trans"></td>
<% } %>	
					</tr>
				
				</table>
				
				
				
				<table class="search_sm" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="">
						
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="65"><input type="radio" name="cond_type" value="date" class="trans" checked>Date</td>
						<td width="70" class="stm">Issued Date</td>
						<td width="">				
						<input type="text" style="width:79;" class="input1" name="fm_dt" maxlength="8" dataformat="ymd"  caption="From Date">&nbsp;~&nbsp;<input type="text" style="width:79;" class="input1" name="to_dt" maxlength="8" dataformat="ymd"  caption="To Date">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >
						</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="65"><input type="radio" name="cond_type" value="inv" class="trans">INV</td>
						<td width="70" class="stm">INV No.</td>
						<td width="228" class="sm"><input type="text" name="inv_no" dataformat="engup2" maxlength="" style="width:177;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_inv_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('inv_no')"></td>
						<td width="50" class="stm">BKG No.</td>
						<td width="153" class="stm"><input type="text" name="bkg_no" dataformat="engup2" maxlength="" style="width:100;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_bkg_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bkg_no')"></td>
						<td width="46" class="stm">B/L No.</td>
						<td width="" class="stm"><input type="text" name="bl_no" dataformat="engup2" maxlength="" style="width:100;ime-mode:disabled;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_bl_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bl_no')"></td>
					</tr>
				</table>
				
				
				
					</td></tr>
				</table>
				
				
				
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="69">&nbsp;&nbsp;Payer</td>
						<td width=""><input type="text" name="cust_cd" style="width:69;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" >&nbsp;<img src="img/btns_search.gif" name="btns_search1"  width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('cust_cd')">
						<input type="text" name="cust_nm" style="width:554;" class="input2" readOnly></td>
					</tr>
				</table>
				<!--  biz_1  (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				</div>
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_detail">Detail</td>
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
	</td></tr>
</table>
<!-- Copyright (S) -->

<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>