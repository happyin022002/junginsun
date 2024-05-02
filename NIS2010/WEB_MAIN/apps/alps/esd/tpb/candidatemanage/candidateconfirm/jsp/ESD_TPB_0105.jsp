<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0105.jsp
*@FileTitle : TPB Candidate Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-31
*@LastModifier : Park Sung-Jin
*@LastVersion : 2.0
* 2008-09-01 O Wan-Ki 1.0 최초 생성
* 2009-08-11 O Wan-Ki 1.1 디자인변경
* 2009-08-31 Park Sung-Jin 2.0 NIS2010 시스템 적용
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.event.EsdTpb0105Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0105Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.PerformanceInquiry");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

		event = (EsdTpb0105Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
	String ofc_top_lvl = JSPUtil.getNull( TPBUtils.getOfficeTopLevel( ofc_cd ) );
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
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
<form method="post" name="form">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- ______________________________________________ Start Hidden Value -->
<!-- | -->
<!-- | --><input type="hidden" name="s_ofc_top_lvl" value="<%=ofc_top_lvl%>">
<!-- | --><input type="hidden" name="f_cmd">
<!-- | --><input type="hidden" name="iPage">
<!-- | --><input type="hidden" name="s_bkg_no">
<!-- | --><input type="hidden" name="s_bl_no">
<!-- | --><input type="hidden" name="s_vsl_cd">
<!-- | --><input type="hidden" name="s_skd_voy_no">
<!-- | --><input type="hidden" name="s_skd_dir_cd">
<!-- | --><input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<!-- | --><input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<!-- | --><input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<!-- | --><input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>">
<!-- | --><input type="hidden" name="s_trd_party_val"><%// for 3rd party %>
<!-- | --><input type="hidden" name="s_vndr_cust_div_cd"><%// for 3rd party %>
<!-- | --><input type="hidden" name="s_n3pty_no_strs_link"><%// for button link %>
<!-- | --><input type="hidden" name="s_vndr_cust_div_cd"><%// for s_vndr_cust_div_cd compare %>
<!-- |______________________________________________ End Hidden Value -->

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


	<!-- ______________________________________________ Start Main Button -->

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" name="btn_inv_t" id="btn_inv_t" style="display:none">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_inv" id="btn_inv" >Invoice</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" name="btn_roc_t" id="btn_roc_t" style="display:none">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_roc" id="btn_roc">ROC</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" name="btn_wo_t" id="btn_wo_t" style="display:none">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_wo" id="btn_wo">Write-Off</td><td class="btn1_right"></td></tr></table></td>
						    
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
			</table>
	<!-- |______________________________________________ End Main Button -->


	<!-- ______________________________________________ Start Search Option -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->	<table class="search_in" border="0">
	<!-- | -->		<tr class="h23">
	<!-- | -->			<td width="90"><img class="nostar">Period</td>
	<!-- | -->			<td>
	<!-- | -->				<input class="input1" type="text" name="s_sdate" style="width:70" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>" required caption="Date" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;~&nbsp;
	<!-- | -->				<input class="input1" type="text" name="s_edate" style="width:70" value="<%=currentDay%>" required caption="Date" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">
	<!-- | -->				<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
	<!-- | -->			</td>
	<!-- | -->		</tr>
	<!-- | -->	</table>
	<!-- | -->	<table class="search_in" border="0">
	<!-- | -->		<tr class="h23">
	<!-- | -->			<td width="90"><img class="nostar">RHQ</td>
	<!-- | -->			<td width="280">
							<% if ( ofc_lvl.equals("C") ) { %>
	<!-- | -->				<select class="input1" style="width:110;" name="s_if_rhq_cd" caption="RHQ">
	<!-- | -->					<option value="<%=rhq_cd%>" selected><%=rhq_cd%></option>
	<!-- | -->				</select>
							<% } else { %>
							<select class="input1" style="width:110;" name="s_if_rhq_cd" caption="RHQ">
	<!-- | -->					<option value="" selected>&lt;Select&gt;</option>
	<!-- | -->				</select>
							<% } %>
	<!-- | -->			</td>
	<!-- | -->			<td width="110"><img class="nostar">Control Office</td>
	<!-- | -->			<td width="300">
							<% if ( ofc_lvl.equals("C") ) { %>
	<!-- | -->				<select class="input1" style="width:100;" name="s_if_ctrl_cd" caption="Control Office">
	<!-- | -->					<option value="<%=ofc_cd%>" selected><%=ofc_cd%></option>
	<!-- | -->				</select>
							<% } else { %>
	<!-- | -->				<select class="input1" style="width:100;" name="s_if_ctrl_cd" caption="Control Office" disabled>
	<!-- | -->					<option value="" selected>&lt;Select&gt;</option>
	<!-- | -->				</select>
							<% } %>
	<!-- | -->			</td>
	<!-- | -->			<td width="60"><img class="nostar">Office</td>
	<!-- | -->			<td>
	<!-- | -->				<select class="input1" style="width:120;" name="s_if_ofc_cd" caption="Office">
	<!-- | -->					<option value="" selected>&lt;Select&gt;</option>
	<!-- | -->				</select>
	<!-- | -->			</td>
	<!-- | -->		</tr>
	<!-- | -->	</table>
	<!-- | -->	<table class="search_in" border="0">
	<!-- | -->		<tr class="h23">
	<!-- | -->			<td width="90"><img class="nostar">Candidate</td>
	<!-- | -->			<!-- <td width="140"><%=TPBUtils.getCodeCombo("s_cfm_status", (ofc_lvl.equals("R")?"O":"W"), "style='width:110', class='input1'   caption='Confirm Status'", "CD00739", 0, "100000:W:New & Review|999999:ALL:ALL|","") %></td> -->
	<!-- | -->			<td width="280">
	<!-- | -->				<select class="input1" name="s_nr" style="width:110;">
	<!-- | -->					<option value='IR'>New & Reviewed</option>
	<!-- | -->					<option value='I'>New</option>
	<!-- | -->					<option value='R'>Reviewed</option>
	<!-- | -->					<% if(ofc_lvl.equals("R")||ofc_lvl.equals("S")||ofc_lvl.equals("H")){ %><option value='N' selected>Non-TPB</option><% } %>
	<!-- | -->					<% if(ofc_lvl.equals("C") || ofc_lvl.equals("T")){ %><option value='N'>Non-TPB</option><% } %>
	<!-- | -->				</select>
	<!-- | -->			</td>
	<!-- | -->			<td width="110"><img class="nostar">Expense Type</td>
	<!-- | -->			<td>
	<!-- | -->				<%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "style='width:160'", "CD00580", 0, "001: :ALL|")%>
	<!-- | -->				<select name="s_n3pty_bil_tp_cd" style="width:120;">
	<!-- | -->				<option value=''>&lt;&lt;Select&gt;&gt;</option>
	<!-- | -->				</select>
	<!-- | -->			</td>
	<!-- | -->		</tr>
	<!-- | -->	</table>
	<!-- | -->	<table class="search_in" border="0">
	<!-- | -->		<tr class="h23">
	<!-- | -->			<td width="90"><img class="nostar">VVD</td>
	<!-- | -->			<td width="280"><input type="text" style="width:88" name="s_vvd" maxlength="9">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd"></td>
	<!-- | -->			<td width="110"><img class="nostar">Booking No.</td>
	<!-- | -->			<td width="300"><input type="text" style="width:100" name="s_bkg_no_all" maxlength="13" onblur="getBLNo(this.form,this,'s_')"></td>
	<!-- | -->			<td width="60"><img class="nostar">B/L No.</td>
	<!-- | -->			<td><input type="text" style="width:120" name="s_bl_no_all" maxlength="12"></td>
	<!-- | -->		</tr>
	<!-- | -->	</table>
	<!-- | -->	<table class="search_in" border="0">
	<!-- | -->		<tr class="h23">
	<!-- | -->			<td width="90"><img class="nostar">CSR No.</td>
	<!-- | -->			<td width="280"><input type="text" style="width:163" name="s_csr_no" maxlength="20"></td>
	<!-- | -->			<td width="110"><img class="nostar">S/P Inv. No.</td>
	<!-- | -->			<td>
	<!-- | -->				<input type="text" style="width:160" name="s_n3pty_src_no" maxlength="30">
	<!-- | -->				<input type="text" style="width:108;visibility:hidden;width:0" name="s_eq_no" maxlength="11">
	<!-- | -->				<%//=JSPUtil.getCodeCombo("s_eq_tp_cd", "", "style='width:100;visibility:hidden;width:0'", "CD01132", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
	<!-- | -->				<%=JSPUtil.getCodeCombo("s_eq_knd_cd", "", "style='width:100;visibility:hidden;width:0'", "CD01132", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
	<!-- | -->			</td>
	<!-- | -->		</tr>
	<!-- | -->	</table>
	<!-- | -->
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Search Option -->


	<table class="height_10"><tr><td></td></tr></table>

	<!-- ______________________________________________ Start Result Grid -->
	<!-- | -->
	<!-- | -->	<table class="search"><tr><td class="bg">
	<!-- | -->
	<!-- | -->		<table width="100%" id="mainTable">
	<!-- | -->			<tr>
	<!-- | -->				<td>
	<!-- | -->					<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- | -->				</td>
	<!-- | -->			</tr>
	<!-- | -->		</table>
	<!-- | -->
	<!-- | -->	</td></tr></table>
	<!-- |______________________________________________ End Result Grid -->



</td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>