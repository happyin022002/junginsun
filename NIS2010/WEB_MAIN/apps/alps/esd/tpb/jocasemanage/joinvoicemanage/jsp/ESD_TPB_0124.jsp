<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0124.jsp
*@FileTitle : JO TPB Handling
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-09
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.2
* 2008-09-11 O Wan-Ki 1.0 최초 생성
* 2008-11-18 O Wan-Ki 1.1 타 페이지로부터 Link 받는 기능 추가
* 2009-11-09 Park Sung-Jin 1.2 ALPS Migration 작업
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0124Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
/*
	EsdTpb0124Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.PerformanceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0124Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
*/
	String strErrMsg = "";						//에러메세지
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	String cfm_dt = JSPUtil.getNull(request.getParameter("s_cfm_dt"));
	String cfm_dt_prev = JSPUtil.getNull(request.getParameter("s_cfm_dt_prev"));
	String cfm_dt_last = JSPUtil.getNull(request.getParameter("s_cfm_dt_last"));
	
	String s_n3pty_no_strs_link = JSPUtil.getNull(request.getParameter("s_n3pty_no_strs_link"));
	
	String prevDay = "";
	if(cfm_dt.equals("")){
		if(cfm_dt_prev.equals("") || cfm_dt_last.equals("")){
			prevDay = DateTime.addDays(currentDay, -7, "yyyy-MM-dd");
		}else{
			prevDay = cfm_dt_prev;
			currentDay = cfm_dt_last;
		}
	}else{
		prevDay = cfm_dt;
		currentDay = cfm_dt;
	}	
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="s_bkg_no">
<input type="hidden" name="s_bl_no">
<input type="hidden" name="s_vsl_cd">
<input type="hidden" name="s_skd_voy_no">
<input type="hidden" name="s_skd_dir_cd">
<%--
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
--%>
<input type="hidden" name="s_detail_n3pty_no" value="">
<input type="hidden" name="s_trd_party_code">
<input type="hidden" name="s_h_vndr_cust_div_cd">
<input type="hidden" name="s_dao_n3pty_no" value="<%=JSPUtil.getNull(request.getParameter("s_dao_n3pty_no"))%>">

<input type="hidden" name="s_correction_yn" value="">
<input type="hidden" name="s_n3pty_inv_no" value="">
<input type="hidden" name="s_n3pty_inv_his_seq" value="">
<input type="hidden" name="s_n3pty_inv_rmd_cd" value="">
<input type="hidden" name="s_n3pty_inv_no_for_search" value="">
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="">

<input type="hidden" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>"><%// for button link %>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->
	<!-- | -->	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->
		<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_modification_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_modification" id="btn_modification">Modification</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_invoice_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_invoice" id="btn_invoice">Invoice Creation</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_roc_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_roc" id="btn_roc">ROC</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_writeoff_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_writeoff" id="btn_writeoff">Write-Off</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_revise_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_revise" id="btn_revise">Revision Detail</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_erpif_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_erpif" id="btn_erpif">ERP Interface</td><td class="btn1_right"></td></tr></table></td>
							<td><table><tr><td></td><td>&nbsp;&nbsp;&nbsp;</td><td></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_retrieve_t" >
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_new_t" >
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_downexcel_t" >
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110"><img class="nostar">Confirmed Date</td>
					<td width="369"><input class="input1" type="text" name="s_sdate" style="width:70" value="<%=prevDay%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<!--
						--><!-- <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"> -->~ <!--
						--><input class="input1" type="text" name="s_edate" style="width:70" value="<%=currentDay%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<!--
						--><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="101">3rd Party</td>
					<td width="" style="padding-left:5"><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:88'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
						<input type="text" style="width:75;" name="s_trd_party_val">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty"></td>

					</tr>
				</table>
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110"><img class="nostar">Status</td>
					<td width="361"><SELECT name="s_status" style='width:105'>
							<OPTION value="">ALL</OPTION>
							<OPTION value="O" Selected>Confirmed</OPTION>
							<OPTION value="I">Invoiced</OPTION>
							<OPTION value="E">Closed</OPTION>
						</SELECT>
					</td>
					<td width="114"><img class="nostar">Expense Type</td>
					<td width=""><%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "style='width:167'", "CD00580", 0, "001: :ALL|")%></td>

				</tr>
				</table>
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110"><img class="nostar">TPB No.</td>
					<td width="145"><input type="text" style="width:105;" name="s_n3pty_no" maxlength="14" value="<%=JSPUtil.getNull(request.getParameter("s_n3pty_no"))%>"></td>
					<td width="75">Invoice No.</td>
					<td width="150"><input type="text" style="width:100;" name="s_n3pty_inv_no_search" maxlength="11"></td>
					<td width="105"	>S/P Invoice No.</td>
					<td width="160"><input type="text" style="width:100;" name="s_n3pty_src_no" maxlength="30" ></td>
					<td width="95">VVD</td>
					<td><input type="text" style="width:90;" name="s_vvd" maxlength="9">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"></td>
				</tr>
				</table>
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110"><img class="nostar">Booking No.</td>
					<td width="145"><input type="text" style="width:105;" name="s_bkg_no_all" maxlength="13" onblur="getBLNo(this.form,this,'s_')"></td>
					<td width="75">B/L No.</td>
					<td width="150"><input type="text" style="width:100;" name="s_bl_no_all" maxlength="12"></td>
					<td width="105">Equipment Type</td>
					<td width="160"><%=JSPUtil.getCodeCombo("s_eq_knd_cd", "", "style='width:100'", "CD01132", 0, "001: :&lt;&lt;Select&gt;&gt;|")%></td>
					<td width="95">Equipment No.</td>
					<td><input type="text" style="width:90" name="s_eq_no" maxlength="11"></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		              </td></tr>
				</table>
				<!-- : ( POR ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>


</body>
</html>
