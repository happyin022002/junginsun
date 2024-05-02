<%
/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : ESD_TPB_0106.jsp
*@FileTitle : TPB Handling
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-09-16 Sun, Choi 1.1 ALPS Migration
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0106Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0106Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.InvoiceManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		//out.println(strOfc_cd);

		event = (EsdTpb0106Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
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
	if( strUsr_id.equals("21702010") || strUsr_id.equals("21702004") ){
		strUsr_id ="TPBADM" ;
	}
%>
<html>
<head>
<title>TPB Handling</title>
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

<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<input type="hidden" name="s_user_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="s_user_id" value="<%=strUsr_id%>">
<input type="hidden" name="s_bkg_no">
<input type="hidden" name="s_bkg_no_split">
<input type="hidden" name="s_bl_no_chk">
<input type="hidden" name="s_bl_no">
<input type="hidden" name="s_bl_no_tp">
<input type="hidden" name="s_vsl_cd">
<input type="hidden" name="s_skd_voy_no">
<input type="hidden" name="s_skd_dir_cd">
<!--  -->
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
<!--  -->
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
<%if (strUsr_id.equals("TPBADM")){%>
<input name="n3pty_if_tp_cd" value="">
<input name="if_flag" value="">
<%}else{%>
<input type="hidden" name="n3pty_if_tp_cd" value="">
<input type="hidden" name="if_flag" value="">
<%} %>
<input type="hidden" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>"><%// for button link %>

<%=JSPUtil.getIncludeString(request) %>

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
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_modification_left" style="display:none;"></td><td class="btn1" name="btn_modification" id="btn_modification" style="display:none;">Modification</td><td class="btn1_right" id="btn_modification_right" style="display:none;"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_invoice_left" style="display:none;"></td><td class="btn1" name="btn_invoice" id="btn_invoice" style="display:none;">Invoice Creation</td><td class="btn1_right" id="btn_invoice_right" style="display:none;"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_roc_left" style="display:none;"></td><td class="btn1" name="btn_roc" id="btn_roc" style="display:none;">ROC</td><td class="btn1_right" id="btn_roc_right" style="display:none;"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_writeoff_left" style="display:none;"></td><td class="btn1" name="btn_writeoff" id="btn_writeoff" style="display:none;">Write-Off</td><td class="btn1_right" id="btn_writeoff_right" style="display:none;"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_revise_left" style="display:none;"></td><td class="btn1" name="btn_revise" id="btn_revise" style="display:none;">Revision Detail</td><td class="btn1_right" id="btn_revise_right" style="display:none;"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_erpif_left" style="display:none;"></td><td class="btn1" name="btn_erpif" id="btn_erpif" style="display:none;">ERP Interface</td><td class="btn1_right" id="btn_erpif_right" style="display:none;"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_rollback_left" style="display:none;"></td><td class="btn1" name="btn_rollback" id="btn_rollback" style="display:none;">RollbackROC</td><td class="btn1_right" id="btn_rollback_right" style="display:none;"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_allif_left" style="display:none;"></td><td class="btn1" name="btn_allif" id="btn_allif" style="display:none;">ALL Interface</td><td class="btn1_right" id="btn_allif_right" style="display:none;"></td></tr></table></td>
								
							<td><table><tr><td></td><td>&nbsp;&nbsp;&nbsp;</td><td></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
					<td width="425"><input class="input1" type="text" name="s_sdate" style="width:70" value="<%=prevDay%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<!--
						--><input class="input1" type="text" name="s_edate" style="width:70" value="<%=currentDay%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<!--
						--><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="100">3rd Party</td>
					<td width="" style="padding-left:5">
						<%//=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:90'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
						<!--<input type="text" style="width:90;" name="s_trd_party_val">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">-->
						<%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:90'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%> <input type="text" style="width:70;" name="s_trd_party_val" maxlength="8" !readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">
					</td>
					<td width=""></td>
					</tr>
				</table>
				<table class="search_in" border="0">
				<tr class="h23">
					<td width=""><img class="nostar">Status</td>
					<td width="">
						<SELECT name="s_status" style='width:120'>
							<OPTION value="">ALL</OPTION>
							<OPTION value="O" Selected>Confirmed</OPTION>
							<OPTION value="I">Invoiced</OPTION>
							<OPTION value="E">Closed</OPTION>
						</SELECT>
					</td>
					<td width="">Expense Type</td>
					<td width="">
						<%//=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "style='width:160'", "CD00580", 0, "001: :ALL|")%>
						<%=TPBUtils.getCodeCombo("s_n3pty_expn_tp_cd", "", "style='width:160'", "CD00580", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%>
					</td>
					<td width=""></td>
					<td width=""></td>
				</tr>
				<tr class="h23">
					<td width="110"><img class="nostar">TPB No.</td>
					<td width="140"><input type="text" style="width:120;" name="s_n3pty_no" maxlength="14" value="<%=JSPUtil.getNull(request.getParameter("s_n3pty_no"))%><%//=s_n3pty_no_strs_link%>"></td>
					<td width="105">Invoice No.</td>
					<td width="180"><input type="text" style="width:160;" name="s_n3pty_inv_no_search" maxlength="11"></td>
					<td width="105">S/P Invoice No.</td>
					<td width="110"><input type="text" style="width:90;" name="s_n3pty_src_no" maxlength="30" ></td>
					<td width="100">VVD</td>
					<td><input type="text" style="width:90;" name="s_vvd" maxlength="9">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"></td>
				</tr>
				<tr class="h23">
					<td width=""><img class="nostar">Booking No.</td>
					<td width=""><input type="text" style="width:120;" name="s_bkg_no_all" maxlength="13" onblur="getBLNo(this.form,this,'s_')"></td>
					<td width="">B/L No.</td>
					<td width=""><input type="text" style="width:160;" name="s_bl_no_all" maxlength="12"></td>
					<td width="">Equipment Type</td>
					<td width="">
						<%=TPBUtils.getCodeCombo("s_eq_knd_cd", "", "style='width:90'", "CD01132", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%>
					</td>
					<td width="">Equipment No.</td>
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
					<tr>
						<td>
					  		<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
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