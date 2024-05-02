<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0110.js
*@FileTitle  : C/A Performance Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/30
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0110Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0110Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0110Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rea_val">

<!-- Developer Work(S) -->

<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>        
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button>		 
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	</div>
<!-- page_title_area(E) -->

<!-- 검색영역 -->
<div class="opus_design_inquiry">		
	<!--  biz_1 (S) -->
	<table class="search" border="0" style="width:979px;"> 
		<tr class="h23">
			<td width="580px">
				<table border="0" style="width:550px;" class="search_sm2"> 
				<tr class="h23">
					<th width="110px" style="text-align:left" class="sm">
						<input type="radio" name="tab_tp" class="trans" value="1" onClick="javascript:changeTab(1);">&nbsp;By Customer</th>
					<td width="220px" class="sm">
						<input type="radio" name="cust_tp" class="trans" value="S">&nbsp;Shipper&nbsp;&nbsp;
						<input type="radio" name="cust_tp" class="trans" value="F" checked>&nbsp;Forwarder&nbsp;<input type="text" name="cust_nm" style="width:70px;" value=""></td>
					<th width="*" class="sm">
						<input type="radio" name="tab_tp" class="trans" value="0" onClick="javascript:changeTab(0);" checked>&nbsp;By Booking Office&nbsp;<input type="text" name="bkg_ofc_cd" style="width:60px;" value="" dataformat="engup" maxlength="6"></th>
				</tr>
				</table>
			</td>
			<th width="69px">C/A Staff</th>
			<td><input type="text" name="corr_usr_id" style="width:105px;" value=""></td>
		</tr>
	</table>
	<table class="search" border="0" style="width:979px;"> 
	<tr><td height="3"></td></tr>
		<tr class="h23">
			<td width="580px">
				<table border="0" style="width:550px;" class="search_sm2"> 
				<tr class="h23">
					<th width="100px" style="text-align:left" class="sm">
						<input type="radio" name="cho_dt" class="trans" value="0">&nbsp;C/A Date</th>
					<th width="120px" class="sm align_center">
						<input type="radio" name="cho_dt" class="trans" value="1" checked>&nbsp;Booking Date</th>
					<td class="sm align_center"><input type="text"  name="cho_from_dt" style="width:75px;" value="" dataformat="ymd" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<!-- img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar" -->&nbsp;~&nbsp;<input type="text" name="cho_to_dt" style="width:75px;" value="" dataformat="ymd" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19px" height="20px" border="0" align="absmiddle" name="btn_calendar1"></td>
				</tr>
				</table>
			</td>
			<th width="100px">On Board Date</th>
			<td><input type="text" name="bl_obrd_from_dt" style="width:75px;" value="" dataformat="ymd" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<!-- img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" -->&nbsp;~&nbsp;<input type="text" name="bl_obrd_to_dt" style="width:75;" value="" dataformat="ymd" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19px" height="20px" border="0" align="absmiddle" name="btn_calendar2"></td>
		</tr>
	</table>
	<!--table class="search" border="0" style="width:979;"> 
	<tr><td height="3"></td></tr>
		<tr class="h23">
			<td width="510">
				<table border="0" style="width:500;" class="search_sm2"> 
				<tr class="h23">
					<td width="100">
						<input type="radio" name="cho_dt" class="trans" value="0">&nbsp;C/A Date</td>
					<td width="120">
						<input type="radio" name="cho_dt" class="trans" value="1" checked>&nbsp;Booking Date</td>
					<td><input type="text"  name="cho_from_dt" style="width:75;" value="" maxlength="7">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar">&nbsp;~&nbsp;<input type="text" name="cho_to_dt" style="width:75;" value="" maxlength="7">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar1"></td>
				</tr>
				</table>
			</td>
			<td width="100">Booking Office</td>
			<td><input type="text" name="bkg_ofc_cd" style="width:105;" value="" dataformat="engup" maxlength="6"></td>
		</tr>
	</table>
	<table class="search" border="0" style="width:979;"> 
	<tr><td height="3"></td></tr>
		<tr class="h23">						
			<td width="213" align="right">On Board Date</td>
			<td width="297">&nbsp;&nbsp;&nbsp;<input type="text" name="bl_obrd_from_dt" style="width:75;" value="">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;<input type="text" name="bl_obrd_to_dt" style="width:75;" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar2"></td>
			<td width="100" align="left">C/A Staff</td>
			<td><input type="text" name="corr_usr_id" style="width:105;" value=""></td>
		</tr>
	</table-->
	<table class="search" border="0" style="width:979px;"> 
		<tr><td height="3"></td></tr>
		<tr class="h23">
			<th width="80px" style="text-align:left">&nbsp;&nbsp;&nbsp;Lane / Dir</th>
			<td width="125px"><input type="text" name="slan_cd" style="width:50px;" value="" dataformat="engup" maxlength="3">&nbsp;<input type="text" name="lan_skd_dir_cd" style="width:20px;" value="" dataformat="engup" maxlength="1"></td>
			<th width="30px">VVD</th>
			<td width="190px"><input type="text" name="vsl_cd" style="width:50px;" value="" dataformat="engup" maxlength="4">&nbsp;<input type="text" name="skd_voy_no" style="width:50px;" value="" dataformat="engup" maxlength="4">&nbsp;<input type="text" name="skd_dir_cd" style="width:20px;" value="" dataformat="engup" maxlength="1"></td>
			<th width="49px">Route</th>
			<th>&nbsp;POR&nbsp;<input type="text" name="por_cd" style="width:70px;" value="" dataformat="engup" maxlength="5">&nbsp;POL&nbsp;<input type="text" name="pol_cd" style="width:70px;" value="" dataformat="engup" maxlength="5">&nbsp;POD&nbsp;<input type="text" name="pod_cd" style="width:70px;" value="" dataformat="engup" maxlength="5">&nbsp;DEL&nbsp;<input type="text" name="del_cd" style="width:70px;" value="" dataformat="engup" maxlength="5">&nbsp;</th>
		</tr>
	</table>
	
	<table class="search" border="0" style="width:979px;"> 
		<tr><td height="3"></td></tr>
		<tr class="h23">
			<td width="305px">
				<table border="0" style="width:285px;" class="search_sm2"> 
				<tr class="h23">
					<th width="70px" style="text-align:left">&nbsp;&nbsp;&nbsp;Reason</th>
					<td class="sm">
						<input type="checkbox" name="ca_rsn_cd" class="trans" value="M">&nbsp;M&nbsp;&nbsp;
						<input type="checkbox" name="ca_rsn_cd" class="trans" value="C">&nbsp;C&nbsp;&nbsp;
						<input type="checkbox" name="ca_rsn_cd" class="trans" value="G">&nbsp;G&nbsp;&nbsp;
						<input type="checkbox" name="ca_rsn_cd" class="trans" value="A">&nbsp;A&nbsp;&nbsp;
						<input type="checkbox" name="ca_rsn_cd" class="trans" value="R">&nbsp;R</td>
				</tr>
				</table>
			</td>
			<th width="120px" class="align_center">Kind&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('ca_knd', 2, 50, true);</script></th>
			<td>
				<table border="0" style="width:225px;" class="search_sm2"> 
				<tr class="h23">
					<th width="100px"  class="sm align_center">&nbsp;&nbsp;<input type="checkbox" name="rat_flg" class="trans" value="Y" onClick="javascript:changeRat(0)">&nbsp;Revenue</th>
					<th  class="sm align_center"><input type="checkbox" name="rat_flg" class="trans" value="N" onClick="javascript:changeRat(1)">&nbsp;Non Revenue</th>
				</tr>
				</table>
			</td>
		</tr>
	</table>
	<!--  biz_1   (E) -->		
</div>
<!-- 검색영역 -->

<!-- opus_tab_btn(E) -->

<div class="opus_design_tab">
	<script language="javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- 시트영역 -->
<div id="tabLayer" style="display:inline">		
<div class="opus_design_grid">	
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- 시트영역 -->
</div>
<!-- 시트영역 -->
<div id="tabLayer" style="display:none">		
<div class="opus_design_grid">	
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
</div>
<!-- 시트영역 -->
		
</form>