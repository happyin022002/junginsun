<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0118.jsp
*@FileTitle : TPB Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-05
*@LastModifier : Sun, CHOI
*@LastVersion : 1.3
* 2008-09-11 O Wan-Ki 			1.0	최초 생성
* 2009-01-28 O Wan-Ki 			1.1	타페이지 로부터의  링크를 위한 설정. 
* 2009-10-19 Jong-Geon Byeon	1.2 ALPS Migration
* 2010-03-05 Sun, CHOI			1.3 TPB Invoice Inquiry 에서 호출하는 방법 보완
* 2011.03.31 변종건 [CHM-201109756-01] [TPB] Billing Type 특정case 조회 이상 현상 수정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0118Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>
 
<%
	EsdTpb0118Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	
	String ofc_lvl 		= "";
	String rhq_cd 		= "";
	String ofc_cd 		= "";
	String cnt_cd 		= "";
	
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.StatusInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

		event = (EsdTpb0118Event)request.getAttribute("Event");
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
<!-- 개발자 작업	-->

<input type="hidden" name="iPage">

<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">

<input type="hidden" name="s_length_n3pty_bil_tp_cd">
<input type="hidden" name="s_cnt_cd">
<input type="hidden" name="s_trd_party_code">
<input type="hidden" name="s_h_vndr_cust_div_cd">

<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_usr_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_ofc_cnt_cd" value="<%=cnt_cd%>">

<input type="hidden" name="s_detail_n3pty_no" value="">
<input type="hidden" name="s_n3pty_inv_no" value="">
<input type="hidden" name="s_n3pty_inv_his_seq" value="">
<input type="hidden" name="s_n3pty_inv_rmd_cd" value="">

<input type="hidden" name="s_correction_yn" value="N">
<input type="hidden" name="s_inquiryOnly_yn" value="Y">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>


			<!-- ______________________________________________ Start Page Navigation & Title -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
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
											<td class="btn1" name="btn_cancellationinv" id="btn_cancellationinv">Cancel Lation Inv.</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td style="display:none;">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_correctioninv" id="btn_correctioninv">Correction Inv.</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td style="display:none;">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_erpInterface" id="btn_erpInterface">ERP Interface</td>
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
	
						<!-- : ( Invoice No. ) (S) -->
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="25"><input type="radio" name="s_cond" value="1" class="trans" checked></td>
								<td width="90">Invoiced Date</td>
								<td width="250"><input type="text" name="s_sdate" style="width:70" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<!-- <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"> -->&nbsp;~&nbsp;<input type="text" name="s_edate" style="width:70" value="<%=currentDay%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
								<td width="25"><input type="radio" name="s_cond" value="2" class="trans"></td>
								<td width="75">Invoice No.</td>
								<td width="220"><input type="text" style="width:110;" name="s_n3pty_inv_no_for_search" maxlength="11"> <input type="text" class="" style="width:33;" name="s_n3pty_inv_rmd_cd_for_search" value=""></td>
								<td width="25"><input type="radio" name="s_cond" value="3" class="trans"></td>
								<td width="95">Equipment No.</td>
								<td><input type="text" style="width:162;" name="s_eq_no" maxlength="11"></td>
							</tr>
						</table>
		
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="25"></td>
								<td width="90">RHQ</td>
								<td width="150">
									<select style="width:90;" class="input1" name="s_if_rhq_cd" required caption="RHQ">
										<option value="" selected>&lt;&lt;Select&gt;&gt;</option>
									</select>
								</td>
			
								<!-- 2009-03-02 Control Office 추가 -->
								<td width="90">Control Office</td>
								<td width="160">
									<select style="width:90;" name="s_if_ctrl_cd" caption="Control Office" >
										<option value="" selected>ALL</option>
									</select>
								</td>
								<td width="45">Office</td>
								<td width="150">
									<select style="width:90;" name="s_if_ofc_cd">
										<option value="" selected>ALL</option>
									</select>
								</td>
								<td width="70">3rd Party</td>
								<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:85'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
									<input type="text" style="width:75;" name="s_trd_party_val">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">
								</td>
							</tr>
						</table>
		
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="25"></td>
								<td width="205">Collection Agency  / Legal Action</td>
								<td width="135"><%=JSPUtil.getCodeCombo("s_clt_agn_flg", "", "style='width:80'", "CD00877", 0, "")%></td>
								<td width="100"><input type="radio" name="s_if_type" value="S" class="trans" checked>TPB</td>
								<td width="140"><input type="radio" name="s_if_type" value="R" class="trans">Logistics Revenue</td>
								<td width="80">
								<td width="120"><input type="radio" name="r_rpt_tp" id="r_rpt_tp_g" value="G" class="trans" checked>General</td>
								<td width=""><input type="radio" name="r_rpt_tp" id="r_rpt_tp_i" value="I" class="trans" >TAX INV Summary</td>
							</tr>
						</table>
						<!-- : ( Year ) (E) -->
		
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
	
			<table class="height_10"><tr><td></td></tr></table>
	
	
			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search">
	       		<tr>
	       			<td class="bg">
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
			            	<tr>
			            		<td>
			            			<script language="javascript">ComSheetObject('sheet1');</script>
			            		</td>
			              	</tr>
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