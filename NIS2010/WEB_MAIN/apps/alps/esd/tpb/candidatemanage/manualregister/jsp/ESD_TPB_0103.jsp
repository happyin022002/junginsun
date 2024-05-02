<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0103.jsp
*@FileTitle : TPB Manual Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.3
* 2009.08.12 Park Sung-Jin
* 1.0 Creation
* 2008-09-17 O Wan-Ki 1.0 최초 생성
* 2009-06-08 O Wan-Ki 1.1 VVD Checking 을 위한 isChecked 객체추가
* 2009-09-29 O Wan-Ki 1.2 CHM-200901008, s_n3pty_src_no 의 maxlength 20 -> 30
* 2009-08-12 Park Sung-Jin 1.3 ALPS Migration 작업
* 2010.12.14 변종건 [CHM-201007599-01] [TPB] Remark 입력 한도 설정
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
<%@ page import="com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0103Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	EsdTpb0103Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CandidateManage.ManualRegister");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	int p_state = 0;
	String p_n3pty_expn_tp_cd = "";
	String p_n3pty_bil_tp_cd = "";
	String p_bkg_no = JSPUtil.getNull(request.getParameter("p_bkg_no"));
	String p_bl_no = "";
	String p_trd_party_val = "";
	String p_curr_cd = "";
	String p_eq_no = "";
	String p_eq_tpsz_cd = "";
	String p_if_amt = "";
	
	
	
	if( p_bkg_no != null && p_bkg_no != "" ){
		p_state = 1;
		p_n3pty_expn_tp_cd = JSPUtil.getNull(request.getParameter("p_n3pty_expn_tp_cd"));
		p_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("p_n3pty_bil_tp_cd"));
		p_bl_no = JSPUtil.getNull(request.getParameter("p_bl_no"));
		p_trd_party_val = JSPUtil.getNull(request.getParameter("p_trd_party_val"));
		p_curr_cd = JSPUtil.getNull(request.getParameter("p_curr_cd"));
		p_curr_cd = "USD";
		p_eq_no = JSPUtil.getNull(request.getParameter("p_eq_no"));
		p_eq_tpsz_cd = JSPUtil.getNull(request.getParameter("p_eq_tpsz_cd"));
		p_if_amt = JSPUtil.getNull(request.getParameter("p_if_amt"));
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd)); //2009-05-08 : Office change기능 추가로 인해 cnt_cd는 session이 아닌  TPB 자체적으로 가져오도록 변경한다.
		
		event = (EsdTpb0103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code

	// 2015.12.10 송정인 [CHM-201539309] TPB Manual Registration 화면에서 NON TPB office 등록시 warning pop-up 개발
	String ofc_lvl = "";
	ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	
%>
<html>
<head>
<title>TPB Manual Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var p_state = "<%=p_state%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage(p_state); 
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

<body onLoad="setupPage();">
<form method="post" name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="p_state" value="<%=p_state%>">
<input type="hidden" name="p_curr_cd" value="<%=p_curr_cd%>">
<input type="hidden" name="p_eq_no" value="<%=p_eq_no%>">
<input type="hidden" name="p_eq_tpsz_cd" value="<%=p_eq_tpsz_cd%>">
<input type="hidden" name="p_if_amt" value="<%=p_if_amt%>">

<input type="hidden" name="s_tpb_seq">
<input type="hidden" name="s_bil_tp_cd">
<input type="hidden" name="s_bkg_no">
<input type="hidden" name="s_bl_no">
<input type="hidden" name="s_vsl_cd">
<input type="hidden" name="s_skd_voy_no">
<input type="hidden" name="s_skd_dir_cd">
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
<input type="hidden" name="s_src_vndr_cnt_cd">
<input type="hidden" name="s_src_vndr_seq">
<input type="hidden" name="s_eq_knd_cd">
<input type="hidden" name="s_eq_no">
<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="s_sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="s_edate" value="<%=currentDay%>">
<input type="hidden" name="s_jo_display" value="N"><%-- cannot be registerd in case of JO; Added By Kim Jin-seung In 2007-08-21 --%>

<!--* 2009-06-08 O Wan-Ki 1.1-->
<input type="hidden" name="isChecked" value="1">

<!-- 2015.12.10 송정인 [CHM-201539309] TPB Manual Registration 화면에서 NON TPB office 등록시 warning pop-up 개발   -->
<input type="hidden" name="s_ofc_lvl" value="<%=ofc_lvl%>">  

<%=JSPUtil.getIncludeString(request) %>

<div id="wait_img" style="position:absolute; visibility:hidden;">
<img src="/hanjin/img/processing.gif" width="343" height="121" border="0">
</div>


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


	<!-- ______________________________________________ Start Page Navigation & Title -->
	
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<% if(p_state == 1){ %>
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"> Service Management > 3rd Party Billing > TPB Candidate > TPB Manual Registration</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;TPB Manual Registration</td></tr>
		<% }else{ %>
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		<% } %>
		</table>
	<!-- |______________________________________________ End Page Navigation & Title -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_new_t">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line" id="btn1_line_t"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0" style="width:979;"> 
   					<tr class="h23">
					<td width="100"><img class="nostar">Interface Type</td>
					<td width="190">
					<%//=JSPUtil.getCodeCombo("s_n3pty_if_tp_cd", "", "style='width:110', class='input1'  onchange='changeExpenseType(this.form)' required caption='Interface Type'", "CD00581", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
					<%//=TPBUtils.getCodeCombo("s_n3pty_if_tp_cd", "", "style='width:110', class='input1'  onchange='changeExpenseType(this.form)' required caption='Interface Type'", "CD00581", 0, "", "!M|!R")%>
					<%=TPBUtils.getCodeCombo("s_n3pty_if_tp_cd", "", "style='width:110', class='input1'  onchange='changeExpenseType(this.form)' required caption='Interface Type'", "CD00581", 0, "", "!R")%>
					</td>
					<td width="120" style="padding-left:4px;"><img class="nostar">&nbsp;&nbsp;&nbsp;Expense Type</td>
					<% if(p_state == 1){ %>
					<td width="200" style="padding-left:1px;">
						<select class="input1" name="s_n3pty_expn_tp_cd" style="width:162;" required caption="Expense Type" onchange="changeBillingCase(this.form)">
						<option value=''>&lt;&lt;Select&gt;&gt;</option>
						<option value='TRS'>TRS</option>
						<option value='TES'>TES</option>
						<option value='MNR'>MNR</option>
						</select>
					</td>
					<% }else{ %>
					<td width="200" style="padding-left:1px;">
						<!--
						<select class="input1" name="s_n3pty_expn_tp_cd" style="width:100;" required caption="Expense Type" onchange="changeBillingCase(this.form)">
						<option value=''>&lt;&lt;Select&gt;&gt;</option>
						</select>
						-->
						<%=TPBUtils.getCodeCombo("s_n3pty_expn_tp_cd", "", "style='width:162'", "CD00580", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%>
					</td>
					<% } %>
					<td width="70"><img class="nostar">TPB Code</td>
					<td width="" style="padding-right: 10px;">
						<select class="input1" name="s_n3pty_bil_tp_cd" style="width:165; " required caption="Billing Case">
						<option value=''>&lt;&lt;Select&gt;&gt;</option>
						</select></td>
					<!--  <td width=""><input type="radio" name="s_mnl_inp_tp_cd" value="N" class="trans" disabled>NIS&nbsp;<input type="radio" name="s_mnl_inp_tp_cd" value="E" class="trans" disabled>eNIS</td>-->
					</tr>
					<tr><td class="line_bluedot" colspan="7"></td></tr>
				</table>

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90"><img class="nostar">Office</td>
					<td width="250" style="padding-left:1;"><input  class="input1"type="text" style="width:99;" value="<%=ofc_cd%>" required caption="Office" name="s_if_ofc_cd" readonly></td>
					<td width="119"><img class="nostar" id="sp_inv_no_class">S/P Invoice No.</td>
					<td width="270"><input  class="input1" type="text" style="width:129;" name="s_n3pty_src_no" maxlength="30"></td>
					<td width="50"><img class="nostar" id="sp_class">S/P</td>
					<td width=""><input  class="input1" type="text" style="width:78;" name="s_src_vndr_no" maxlength="6"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty_v"></td>
					</tr>
				<tr class="h23">
				    <td><img class="nostar" id="bkg_no_class">Booking No.</td>
					<td style="padding-left:1;"><input class="input1" type="text" style="width:99;" name="s_bkg_no_all" value="<%=p_bkg_no%>" maxlength="13"></td>
					<td><img class="nostar">Bill of Lading No.</td>
					<td><input type="text" style="width:129;" name="s_bl_no_all" value="<%=p_bl_no%>" maxlength="12"></td>
					<td><img class="nostar">Currency</td>
					
					<% if(p_state == 1){ %>
					<td colspan="3">
						<select class="input1" style="width:101;" name="s_curr_cd" required caption="Currency">
							<option value="<%=p_curr_cd%>" selected><%=p_curr_cd%></option>
						</select>
					</td>
					<% }else{ %>
					<td colspan="3">
						<select class="input1" style="width:101;" name="s_curr_cd" required caption="Currency">
							<option value="" selected>&lt;Select&gt;</option>
						</select>
					</td>
					<% } %>
				</tr>
				<tr class="h23">
					<td><img class="nostar">Date</td>
					<td style="padding-left:1;"><input type="text" name="s_if_dt" style="width:76" value="<%=currentDay%>" data_format="ymd"  caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>
					<td><img class="nostar">VVD</td>
					<td><input type="text" style="width:129;" name="s_vvd" maxlength="9"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"></td>

					<td><img class="nostar">Location</td>
					<td colspan="3"><input type="text" style="width:78;" name="s_yd_cd" maxlength="7"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_location"></td>
					</tr>
				<tr class="h23">
					<td><img class="nostar">3rd Party</td>
					<% if(p_state == 1){ %>
					<td colspan="7" style="padding-left:1;">
						<select name="s_vndr_cust_div_cd" style="width:75;">
							<option value='C' selected>Customer</option>
						</select> <input type="text" style="width:70;" name="s_trd_party_val" value="<%=p_trd_party_val%>" maxlength="8" !readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty"> <input type="text" style="width:710;" name="s_trd_party_nm" readonly>
					</td>
					<% }else{ %>
					<td colspan="7" style="padding-left:1;">
					<%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:75'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%> <input type="text" style="width:70;" name="s_trd_party_val" value="<%=p_trd_party_val%>" maxlength="8" !readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty"> <input type="text" style="width:710;" name="s_trd_party_nm" readonly></td>
					<% } %>
				</tr>
				<tr class="h23">
					<td><img class="nostar">Remarks</td>
					<td colspan="7">
					<textarea name="s_if_rmk" class="input" style="width:100%;height=70"></textarea>
					</td>
				</tr>

				<tr style="height:7;"><td colspan="8"></td></tr>

				<tr class="h23">
					<td colspan="8">
						<table width="100%" id="mainTable">
							<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
						</table>

						<!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="button">
							<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
									<!-- Repeat Pattern -->
										<td><input type="text" name="s_add_cnt" dataformat="int" maxlength="3" style="width:50px;text-right;ime-mode:disabled; margin-right:3px;" class="input" value="1"></td>	
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_add_t">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_add" id="btn_add">Row&nbsp;Add&nbsp;</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
									<!-- Repeat Pattern -->
									</tr>
								</table>
							</td></tr>
						</table>
				    	<!-- : ( Button : Sub ) (E) -->
					</td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>