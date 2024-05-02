<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5001.jsp
*@FileTitle : A/R Interface Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.03 최성환
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt5001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.invoiceissuecollectionmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();


		event = (EesDmt5001Event)request.getAttribute("Event");
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
<title>A/R Interface Status Inquiry</title>
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
<input type="hidden" name="button_mode">
<input type="hidden" name="tab_order">
<input type="hidden" name="init_flg">

<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_ofc_cd_t2" value="<%=strUsr_ofc%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="ofc_cd_t1">
<input type="hidden" name="ofc_cd_t2">
<input type="hidden" name="ofc_cd_t3">

<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="ofc_tp">
<input type="hidden" name="dmdt_trf_cd_t1">
<input type="hidden" name="dmdt_trf_cd_t3">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="s_cust_gubun_t2">
<input type="hidden" name="s_cust_cd_t2">
<input type="hidden" name="btn_id">

<input type="hidden" name="login_ofc_cd" value="<%=strUsr_ofc%>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

	
		<!--biz page (S)-->
		
		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
		<!-- Tab (E) -->
		<!-- Tab1 (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search">
					<tr>
						<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="60">Office</td>
							<td width="96">
								<select name="r_office" style="width:90;" class="input">
									<option value="1"  selected>A/R I/F</option>
									<option value="2">Issue</option>
								</select></td>
							<td width="262" class="stm">
								<script language="javascript">ComComboObject('office', 2, 80, 0, 1, 0, true);</script>
							&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"><input type="checkbox" name="chk_sub_ofc" value="Y" class="trans" onClick="doInclSubOfc()">Incl. Sub Office</td>
							<td >I/F Date</td>
							<td width="240" class="stm">
								<input type="text" style="width:80;" class="input1" name="fm_dt" maxlength="8" dataformat="ymd"  caption="From Date" >&nbsp;~&nbsp;
								<input type="text" style="width:80;" class="input1" name="to_dt" maxlength="8" dataformat="ymd"  caption="To Date" >&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >
							</td>
							<td width="72">Tariff Type</td>
							<td width="">
								<script language="javascript">ComComboObject('tariff_type_t1', 2, 156, 0, 1);</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
							</td>
							
						</tr> 
						</table>
						<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="60">Customer</td>
							<td>
								<!-- Customer -->
								<select name="cust_type" style="width:90;" class="input">
								<option value="P" selected>Payer</option>
								<option value="S">SHPR</option>
								<option value="C">CNEE</option>
								<option value="N">NTFY</option>
								</select>&nbsp;<input type="text" name="cust_cd" style="width:80;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" >
								<img src="img/btns_search.gif" name="btns_search1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('cust_cd')">
								<input type="text" name="cust_nm" style="width:260;" class="input2" readOnly>
								<!-- Customer //-->
							</td>
							<td width="70">Invoice No.</td>
							<td width="160"><input type="text" style="width:120" name="s_invoice_no" dataformat="engup2" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch1" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand;"></td>
							<td width="50">BKG No.</td>
							<td width="160"><input type="text" name="s_bkg_no" dataformat="engup2" style="width:120" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch2" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand;"></td>
						</tr> 
						</table>
						<!--  biz_1   (E) -->
						<!-- : ( Grid ) (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet1');</script>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
			</div>
			<!-- Tab1 (E) -->
			<!-- Tab2 (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search">
					<tr>
						<td class="bg">
							<!--  biz_1  (S) -->
							<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="112">A/R  Office</td>
								<td width="292" class="stm">
								<script language="javascript">ComComboObject('office_t2', 2, 80, 0, 1, 0, true);</script>
								&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"><input type="checkbox" name="chk_sub_ofc_t2" value="Y" class="trans" onClick="doInclSubOfcT2()">Incl. Sub Office</td>
								
								<td width="57">I/F Date</td>
								<td width="255" class="stm">
								<input type="text" style="width:80;" class="input1" name="fm_dt_t2" maxlength="8" dataformat="ymd"  caption="From Date">&nbsp;~&nbsp;
								<input type="text" style="width:80;" class="input1" name="to_dt_t2" maxlength="8" dataformat="ymd"  caption="To Date" >
								<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >
								</td>
								<td width="45">Charge</td>
								<td width="75">
									<select name="chg_cd" style="width:51;" class="input1">
										<option value="" selected>All</option>
										<option value="DEM">DEM</option>
										<option value="DET">DET</option>
									</select>
								<td width="45">Bound</td>
								<td width="">
									<select name="io_bnd_cd" style="width:86;" class="input1">
										<option value="" selected>All</option>
										<option value="O">Outbound</option>
										<option value="I">Inbound</option>
									</select></td>
								
							</tr> 
							</table>
							<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="110">A/R Actual Cust.</td>
								<td width="724">
								<input type="text" name="act_cust_cd" style="width:80;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" > <img src="img/btns_search.gif" name="btns_search1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('act_cust_cd')">&nbsp;<input type="text" name="act_cust_nm" style="width:594" class="input2" readOnly>
								</td>
								<td width="46">Type</td>
								<td width="">
									<select name="type" style="width:86;" class="input">
										<option value="" selected>All</option>
										<option value="BKG">BKG</option>
										<option value="MRI">MRI</option>
									</select>
									</td>
							</tr> 	
							</table>
							<!--  biz_1   (E) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet1');</script>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
			</div>
			<!-- Tab2 (E) -->
			<!-- Tab3 (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search">
					<tr>
						<td class="bg">
							<!--  biz_1  (S) -->
							<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="50">Office</td>								
								<td width="86">
								<select name="erp_ofc" style="width:80;" class="input">
									<option value="coll"  selected>Collected</option>
									<option value="dmdt">DMDT</option>
								</select></td>								
								<td width="240" class="stm">
								<script language="javascript">ComComboObject('office_t3', 2, 80, 0, 1, 0, true);</script>
								&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"><input type="checkbox" name="chk_sub_ofc_t3" value="Y" class="trans" onClick="doInclSubOfcT3()">Incl. Sub Office</td>
								<td width="30">Date</td>															
								<td width="86">
								<select name="erp_dt" style="width:80;" class="input">
									<option value="if"  selected>IF</option>
									<option value="coll">Collected</option>
								</select></td>		
								<td width="230" class="stm">
								<input type="text" style="width:72;" class="input1" name="fm_if_dt" maxlength="8" dataformat="ymd"  caption="From Date">&nbsp;~&nbsp;
								<input type="text" style="width:72;" class="input1" name="to_if_dt" maxlength="8" dataformat="ymd"  caption="To Date" >
								<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >
								</td>
								<td width="72">Tariff Type</td>
								<td width="">
								<script language="javascript">ComComboObject('tariff_type_t3', 2, 156, 0, 1);</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
								</td>
							</table>
							<table class="search" border="0" style="width:979;"> 
							</tr> 
							<tr class="h23">								
								<td width="70">Invoice No.</td>
								<td width="305" class="stm"><input type="text" style="width:177" name="invoice_no" dataformat="engup2" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch3" width="19" height="20" alt="" border="0" align="absmiddle"></td>
								<td width="57">BKG No.</td>
								<td width="" class="stm"><input type="text" name="bkg_no" dataformat="engup2" style="width:177" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch4" width="19" height="20" alt="" border="0" align="absmiddle"></td>
							</tr>
							</table>
							<!--  biz_1   (E) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t3sheet1');</script>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
			</div>
			<!-- Tab3 (E) -->						
			</td></tr>
		</table>
		<!--biz page (E)-->
		
		<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr><td class="btn1_bg">
				
				    <table border="0" cellpadding="0" cellspacing="0">
				    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
						
						<td>
							<div id="sch_cond_div" style=display:block;>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_detail">Detail</td>
							<td class="btn1_right"></td>
							</tr>
							</table>
							</div>
						</td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						</tr>
					</table>
				</td></tr>
				</table>
		    	<!--Button (E) -->	


				<table width="100%"  id="mainTable2" style=display:none;> 
					<tr>
						<td width="100%">
				<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet3');</script> <!-- hidden 처리 (E)-->
						</td>
					</tr>
				</table>
				
<!-- Copyright (S) -->

<!-- Copyright(E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>