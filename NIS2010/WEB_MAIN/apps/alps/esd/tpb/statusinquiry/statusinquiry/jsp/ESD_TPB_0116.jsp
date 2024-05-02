<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0116.jsp
*@FileTitle : Status By TPB
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-19
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-10-19 Sun, Choi 1.1 ALPS Migration
*
* History
* 2014.02.18 박다은[CHM-201428813] Status by TPB - Multi. BKG & EQ No. 기능 추가
* 2015.06.03 김현화[CHM-201536161]Status by TPB 화면 오류 수정 요청- EQ No별 금액정보가 맞지 않아 BKG & EQ No.옵션제거 및 항목 수정
* 2016.06.03 김현화[CHM-201641683]Status by TPB 화면 Non-TPB도 조회 가능하도록 수정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0116Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EsdTpb0116Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String ofc_cd = "";
	String rhq_cd = "";
	String priv_cd = "";
	String ofc_lvl = "";
	
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.StatusInquiry");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0116Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
	priv_cd = JSPUtil.getNull( officeInfo[4] );
	
	String s_state = JSPUtil.getNull(request.getParameter("s_state"));
	//out.println(s_state);
	String p_sdate = "";
	String p_edate = "";
	String p_bkg_no_all = "";
	String p_n3pty_src_sub_sys_cd = "";
	String p_n3pty_src_sub_sys_cd_check = "";
	String p_n3pty_src_sub_sys_cd_check_trs = "";
	String p_n3pty_src_sub_sys_cd_check_tes = "";
	String p_n3pty_src_sub_sys_cd_check_mnr = "";
	String p_n3pty_src_sub_sys_cd_check_pso = "";
	String p_ots_sts_cd = "";

	if (s_state.equals("BKG")){
		p_sdate = JSPUtil.getNull(request.getParameter("s_sdate"));
		p_edate = JSPUtil.getNull(request.getParameter("s_edate"));
		p_bkg_no_all = JSPUtil.getNull(request.getParameter("s_bkg_no_all"));
		p_n3pty_src_sub_sys_cd = JSPUtil.getNull(request.getParameter("s_n3pty_src_sub_sys_cd"));
		p_n3pty_src_sub_sys_cd_check = JSPUtil.getNull(request.getParameter("s_n3pty_src_sub_sys_cd_check"));
		if (p_n3pty_src_sub_sys_cd_check.equals("TRS")){
			p_n3pty_src_sub_sys_cd_check_trs = "checked";
			p_n3pty_src_sub_sys_cd_check_tes = "unchecked";
			p_n3pty_src_sub_sys_cd_check_mnr = "unchecked";
			p_n3pty_src_sub_sys_cd_check_pso = "unchecked";
		} else if (p_n3pty_src_sub_sys_cd_check.equals("TES")){
			p_n3pty_src_sub_sys_cd_check_trs = "unchecked";
			p_n3pty_src_sub_sys_cd_check_tes = "checked";
			p_n3pty_src_sub_sys_cd_check_mnr = "unchecked";
			p_n3pty_src_sub_sys_cd_check_pso = "unchecked";
		} else if (p_n3pty_src_sub_sys_cd_check.equals("MNR")){	
			p_n3pty_src_sub_sys_cd_check_trs = "unchecked";
			p_n3pty_src_sub_sys_cd_check_tes = "unchecked";
			p_n3pty_src_sub_sys_cd_check_mnr = "checked";
			p_n3pty_src_sub_sys_cd_check_pso = "unchecked";
		} else if (p_n3pty_src_sub_sys_cd_check.equals("PSO")){	
			p_n3pty_src_sub_sys_cd_check_trs = "unchecked";
			p_n3pty_src_sub_sys_cd_check_tes = "unchecked";
			p_n3pty_src_sub_sys_cd_check_mnr = "unchecked";
			p_n3pty_src_sub_sys_cd_check_pso = "checked";
		}
		p_ots_sts_cd = JSPUtil.getNull(request.getParameter("s_ots_sts_cd"));
	} else {
		p_sdate = DateTime.addMonths(currentDay, -1, "yyyy-MM-dd");
		p_edate = currentDay;
		p_bkg_no_all = "";
		//p_n3pty_src_sub_sys_cd = "001: :ALL|";
		p_n3pty_src_sub_sys_cd_check = "unchecked";
		//p_ots_sts_cd = "T";
	}
	//out.println(p_ots_sts_cd);
	//out.println(JSPUtil.getNull(request.getParameter("s_ots_sts_cd")));
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("combo02", "02", "CD00902", 0, "")%>

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
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<input type="hidden" name="s_n3pty_no">
<input type="hidden" name="s_dao_n3pty_no">
<input type="hidden" name="s_h_ots_sts_cd">
<input type="hidden" name="s_trd_party_code">
<input type="hidden" name="s_h_vndr_cust_div_cd">
<input type="hidden" name="s_h_n3pty_inv_no">
<input type="hidden" name="s_cfm_dt">
<input type="hidden" name="s_cfm_dt_prev">
<input type="hidden" name="s_cfm_dt_last">
<input type="hidden" name="s_user_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_state" value="<%=s_state%>">

<!--* 2009-01-08 O Wan-Ki 1.2 Control Office 추가로 인한 Office별 Privilege 정보-->
<input type="hidden" name="priv_cd" value="<%=priv_cd%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>


	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->
	<!-- | -->	
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<% if(s_state.equals("BKG")){ %>
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  Status By TPB</td>
				</tr>
				<% }else{ %>
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
				<% } %>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->
	<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>


			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new" id="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td style="display:none;">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_settlement" id="btn_settlement">Settlement</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td style="display:none;">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_invoicecreation" id="btn_invoicecreation">Invoice Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
    		<!-- TABLE '#D' : ( Button : Main ) (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table class="search">
	       		<tr>
	       			<td class="bg">
						<table class="search_in" border="0" bordercolor="red">
							<tr class="h23">
							    <td width="80"><img class="nostar" id="period_class">Period</td>
								<td width="250"><input type="text" name="s_sdate" style="width:70" value="<%=p_sdate%>" caption="Date" dataformat="ymd">&nbsp;~&nbsp;<input type="text" name="s_edate" style="width:70" value="<%=p_edate%>"  caption="Date" dataformat="ymd">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
								<td width="86"><img class="nostar">RHQ</td>
								<td width="185">
								<% if(s_state.equals("BKG")){ %>
								<%//=JSPUtil.getCodeCombo("s_if_rhq_cd", "", "style='width:120'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
									<select style="width:120;" name="s_if_rhq_cd" required caption="RHQ">
										<option value="<%=rhq_cd%>" selected>&lt;Select&gt;</option>
									</select>
								<% }else{ %>
									<select class="input1" style="width:120;" name="s_if_rhq_cd" required caption="RHQ">
										<option value="" selected>&lt;Select&gt;</option>
										
									</select>
								<% } %>
								</td>
								<td width="108">Control Office</td>
								<td width="132">
									<% if ( ofc_lvl.equals("C") ) { %>
									<select style="width:100;" name="s_if_ctrl_cd" caption="Control Office">
										<option value="<%=ofc_cd%>" selected><%=ofc_cd%></option>
									</select>
									<% } else { %>
									<select style="width:100;" name="s_if_ctrl_cd" caption="Control Office">
										<option value="" selected>ALL</option>
									</select>
									<% } %>
								</td>
								<td width="40">Office</td>
								<td>
									<select style="width:90;" name="s_if_ofc_cd" >
										<option value="" selected>ALL</option>
									</select>
								</td>
							</tr>
						</table>

						<table class="search_in" border="0">
							<tr class="h23">
								<td width="80"><img class="nostar">TPB Status</td>
								<td width="250"><%//=JSPUtil.getCodeCombo("s_ots_sts_cd", "", "style='width:140' onchange=checkPeriod(this.value)", "CD00952", 0, "")%>
								<% if(s_state.equals("BKG")){ %>
									<SELECT name="s_ots_sts_cd" style='width:110' onchange=checkPeriod(this.value)>
										<OPTION value="T" <% if (p_ots_sts_cd.equals("T")) {%> selected <% } %>>Open</OPTION>
										<OPTION value="P" <% if (p_ots_sts_cd.equals("P")) {%> selected <% } %>>Closed</OPTION>
									</SELECT>
								<% }else{ %>
									<%=TPBUtils.getCodeCombo("s_ots_sts_cd", "", "style='width:125' onchange=checkPeriod(this.value)", "CD00952", 0, "0:ALL:ALL(except Non-TPB)|999998:P:Closed|999999:N:Non-TPB", "T") %>
								<% } %>
									<%=TPBUtils.getCodeCombo("s_ots_sts_cd_detail_open", "", "style='width:110' ", "CD00588", 0, "0:ALL:ALL", "R|I|Y|J|O") %><!--
									 --><%=TPBUtils.getCodeCombo("s_ots_sts_cd_detail_close", "", "style='width:110;display:none' ", "CD00588", 0, "0:ALL:ALL", "E") %>
									<%=TPBUtils.getCodeCombo("s_ots_sts_cd_detail_non", "", "style='width:110;display:none' ", "0000000", 0, "0:ALL:ALL|999997:N:Under Review|999998:R:Rejected|999999:D:Deleted", "0") %>
								</td>
								<td width="86"><img class="nostar">3rd Party</td>
								<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:80'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
									<input type="text" style="width:70;" name="s_trd_party_val" maxlength="8">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">
								</td>
							</tr>
						</table>

						<table class="search_in" border="0">
							<tr class="h23">
								<td width="80"><img class="nostar">Exp. Type</td>
								<td width="250">
								<% if(s_state.equals("BKG")){ %>
									<SELECT name = "s_n3pty_src_sub_sys_cd" onchange='setSource(this);tpb_searchBillingCaseByExpenseType()' style='width:140'>	
										<OPTION  value=""> ALL</OPTION>
										<OPTION  value="TRS" <% if(p_n3pty_src_sub_sys_cd.equals("TRS")){ %> selected <% } %>> Transportation</OPTION>
										<OPTION  value="TES" <% if(p_n3pty_src_sub_sys_cd.equals("TES")){ %> selected <% } %>> Terminal S/O</OPTION>
										<OPTION  value="MNR" <% if(p_n3pty_src_sub_sys_cd.equals("MNR")){ %> selected <% } %>> Maintenance and Repair</OPTION>
									</SELECT>
									<%//=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "onchange='setSource(this);tpb_searchBillingCaseByExpenseType()' style='width:140'", "CD00580", 0, "001: :ALL|")%>
								<% }else{ %>
									<%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "onchange='setSource(this);tpb_searchBillingCaseByExpenseType()' style='width:140'", "CD00580", 0, "001: :ALL|")%>				
								<% } %>
								</td>
								<td width="86"><img class="nostar">Invoice No.</td>
								<td width="177"><input type="text" style="width:120" name="s_n3pty_inv_no"></td>
								<td width="115"><img class="nostar">Overdue</td>
								<td class="stm">&nbsp;<input type="text" style="width:100" name="s_overdue" dataformat="int"> Days</td>
							</tr>
						</table>
		
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="80"><img class="nostar">Billing Case</td>
								<td width="250">
									<select name="s_n3pty_bil_tp_cd" style="width:140;">
										<option value=''>&lt;&lt;Select&gt;&gt;</option>
									</select>
								</td>
								<td width="86"><img class="nostar">Booking No.</td>
								<td width="177"><input type="text" style="width:120" name="s_bkg_no_all" value="<%=p_bkg_no_all%>" maxlength="13" onblur="getBLNo(this.form,this,'s_')"></td>
								<td width="115"><img class="nostar">B/L No.</td>
								<td>&nbsp;<input type="text" style="width:100" name="s_bl_no_all" maxlength="12"></td>
							</tr>
						</table>
		
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="80"><img class="nostar">VVD</td>
								<td width="250"><input type="text" style="width:117" name="s_vvd" maxlength="9">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"></td>
								<td width="86"><img class="nostar">TPB No</td>
								<td width="177"><input type="text" style="width:120" name="s_n3pty_no_search" maxlength="14"></td>
								<td width="117"><img class="nostar">EAC Type</td>
								<td><%=TPBUtils.getCodeCombo("s_edn_tp_cd", "", "style='width:140'", "CD00587", 0, "001: :&lt;&lt;Select&gt;&gt;|002:A:ALL|", "") %></td>
							</tr>
						</table>
		
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="80"><img class="nostar">ROC From</td>
								<td width="250"><input type="text" style="width:140" name="s_fm_clt_cng_ofc_n3pty_no"></td>
								<td width="86"><img class="nostar">ROC To</td>
								<td width="290"><input type="text" style="width:120" name="s_stl_to_clt_cng_ofc_cd"></td>
								<td width="90" ><input type="radio" name="s_if_type" value="S" class="trans" checked>TPB</td>
								<td width="" ><input type="radio" name="s_if_type" value="R" class="trans" >Logistics Revenue</td>
							</tr>
						</table>
		
						<table class="search_in" border="0">
							<tr class="h23">
							    <td width="80"><img class="nostar">Currency</td>
								<td width="250"><%=TPBUtils.getCodeCombo("s_curr_cd_tp", "", "style='width:60' ", "CD01382", 0, "", "")%></td>
							    <td width="86"><img class="nostar">Amount</td>
								<td><input type="text" style="width:120" name="s_ots_amt_from" dataformat="int"> ~ <input type="text" style="width:118" name="s_ots_amt_to" dataformat="int"></td>
								<td width="120" style="display:none;"><img class="nostar">BKG & CNTR No.</td>
								<td width="70" class="stm" style="display:none;"><input type="radio" name="bkg_cntr_no" value="H" class="trans" checked>hide</td>
								<td width="80" class="stm" style="display:none;"><input type="radio" name="bkg_cntr_no" value="S" class="trans" >show</td>
							</tr>
						</table>
		
						<table class="line_bluedot"><tr><td></td></tr></table>
		
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="75"><img class="nostar">Source No.</td>
								<td width="350" class="stm">
									<input type="radio" name="s_n3pty_src_sub_sys_cd_check" value="TES" class="trans" onclick='setSource(this)' <%=p_n3pty_src_sub_sys_cd_check_tes%> onchange='setSource(this);tpb_searchBillingCaseByExpenseType()'>TES&nbsp;
									<input type="radio" name="s_n3pty_src_sub_sys_cd_check" value="TRS" class="trans" onclick='setSource(this)' <%=p_n3pty_src_sub_sys_cd_check_trs%> onchange='setSource(this);tpb_searchBillingCaseByExpenseType()'>TRS&nbsp;
									<input type="radio" name="s_n3pty_src_sub_sys_cd_check" value="MNR" class="trans" onclick='setSource(this)' <%=p_n3pty_src_sub_sys_cd_check_mnr%> onchange='setSource(this);tpb_searchBillingCaseByExpenseType()'>MNR&nbsp;
									<input type="radio" name="s_n3pty_src_sub_sys_cd_check" value="PSO" class="trans" onclick='setSource(this)' <%=p_n3pty_src_sub_sys_cd_check_pso%> onchange='setSource(this);tpb_searchBillingCaseByExpenseType()'>PSO&nbsp;
									<input type="text" style="width:100" name="s_n3pty_src_no" maxlength="30">
								</td>
								<td width="65"><img class="nostar">CSR No.</td>
								<td class="stm"><input type="text" style="width:142" name="s_csr_no"></td>
								<td width="105"><img class="nostar">Equipment No.</td>
								<td class="stm"><input type="text" style="width:108" name="s_eq_no" maxlength="11"></td>
							</tr>
						</table>
		
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		
			<table class="height_10"><tr><td></td></tr></table>
		
		
			<!-- TABLE '#D' : ( Grid ) (S) -->
		    <table class="search">
		    	<tr>
		    		<td class="bg">
						<table width="100%" id="mainTable">
				              <tr><td>
				                     <script language="javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    	</td>
    </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>