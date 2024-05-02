<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0134.jsp
*@FileTitle : TPB Status by Booking(B/L)
*Open Issues :
*Change history :
*@LastModifyDate : 2010-01-19
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2010-01-19 Sun, Choi 1.0 최초 생성
* 2010-01-19 Sun, Choi 1.1 ALPS Migration
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0134Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0134Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsdTpb0134Event)request.getAttribute("Event");
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
	String p_ots_sts_cd = "";
	String p_bkg_no_all = "";
	String p_bl_no_all = "";

	if (s_state.equals("BKG")){
		p_ots_sts_cd = JSPUtil.getNull(request.getParameter("s_ots_sts_cd"));
		p_bkg_no_all = JSPUtil.getNull(request.getParameter("s_bkg_no_all"));
		p_bl_no_all = JSPUtil.getNull(request.getParameter("s_bl_no_all"));
	} else {
		p_bkg_no_all = "";
		p_bl_no_all = "";
		//p_n3pty_src_sub_sys_cd = "001: :ALL|";
		//p_ots_sts_cd = "T";
	}
	//out.println(p_ots_sts_cd);
	//out.println(JSPUtil.getNull(request.getParameter("s_ots_sts_cd")));
%>
<html>
<head>
<title>TPB Status by Booking(B/L)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		<% if ( ofc_lvl.equals("R") ) { %>getTPBGenCombo('s_if_ctrl_cd','searchCtrlOffice','F','','2', new Array("s_if_rhq_cd","s_office_level"));<% } %>
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
<input type="hidden" name="s_ots_sts_cd" value="<%=p_ots_sts_cd%>">
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
<tr><td>


	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->
	<!-- | -->	
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"> Service Management > 3rd Party Billing > Status & Performance > TPB Status by Booking(B/L)</td></tr>
			    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;TPB Status by Booking(B/L)</td></tr>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->
	<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!--<td class="btn1_line"></td>-->
							<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_settlement" id="btn_settlement">Settlement</td><td class="btn1_right"></td></tr></table></td>
							<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_invoicecreation" id="btn_invoicecreation">Invoice Creation</td><td class="btn1_right"></td></tr></table></td>
							<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search_in" border="0">
				<tr class="h23">
					<td width="86">Booking No.</td>
					<td width="177"><input type="text" style="width:120" name="s_bkg_no_all" value="<%=p_bkg_no_all%>" maxlength="13" readonly onblur="getBLNo(this.form,this,'s_')"></td>
					<td width="115">B/L No.</td>
					<td>&nbsp;<input type="text" style="width:120" name="s_bl_no_all" value="<%=p_bl_no_all%>"  maxlength="12" readonly></td>
				</tr>
				</table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
       	<tr><td class="bg">



				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		              </td></tr>
				</table>
				<!--그리드안에 들어갈 버튼 입니다. Collection Activity 컬럼안에 들어갈 버튼 이미지입니다.
				<img class="cursor" src="/hanjin/img/button/btng_collectionactivity.gif" width="113" height="19" border="0">-->
				<!-- : ( POR ) (E) -->

				<!-- : ( Button : Grid ) (S) -->
				<!-- table width="100%" class="sbutton">
		       	<tr><td class="align">

				    <table class="sbutton">
					<tr><td class="bt"><img class="cursor" src="/hanjin/img/button/btng_detail.gif" width="65" height="19" border="0" name="btng_detail"></td></tr>
					</table>

				</td></tr>
				</table -->
		    	<!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>