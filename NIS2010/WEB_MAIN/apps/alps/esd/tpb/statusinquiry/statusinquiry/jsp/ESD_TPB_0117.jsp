<%/*=========================================================
*Copyright(c) Since 2008 CyberLogitec
*@FileName : ESD_TPB_0117.jsp
*@FileTitle : Status Summary - Aging
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-26
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.2
* 2008-09-16 O Wan-Ki 1.0 최초 생성
* 2008-11-25 Kim Jin-seung 1.1 수정 - Control Office 추가; 
* 2009-10-26 Park Sung-Jin 1.2 ALPS Migration 작업
* 2011.03.31 변종건 [CHM-201109756-01] [TPB] Billing Type 특정case 조회 이상 현상 수정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0117Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EsdTpb0117Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String ofc_lvl = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.StatusInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0117Event)request.getAttribute("Event");
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
	rhq_cd = JSPUtil.getNull( officeInfo[2] );  // R.HQ Code
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
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


	<!-- ______________________________________________ Start Page Navigation & Title -->
	
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
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

				<table class="search_in" border="0">
					<tr class="h23">
						<td width="40"><img class="nostar">RHQ</td>
						<td width="250">
							<select style="width:100;" class="input1" name="s_if_rhq_cd" required caption="RHQ"><!-- RHQ -->
								<option value="" selected>&lt;&lt;Select&gt;&gt;</option>
							</select>
						</td>
						<td width="90">Control Office</td>
						<td width="245">
					<select style="width:100;" name="s_if_ctrl_cd" caption="Control Office">
						<option value="" selected>ALL</option>
					</select>
						</td>
						<td width="55"><img class="nostar">Office</td>
						<td>
							<select style="width:110;" name="s_if_ofc_cd"><!-- Office -->
								<option value="" selected>ALL</option>
							</select>
						</td>
					</tr>
				</table>

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="25"><input type="radio" class="trans" name="s_exclude_jo" value="X" checked></td>
					<td width="90">Excluding JO</td>
					<td width="25"><input type="radio" class="trans" name="s_exclude_jo" value="O"></td>
					<td width="60">Only JO</td>
					<td width="25"><input type="radio" class="trans" name="s_exclude_jo" value="A"></td>
					<td width="60">All</td>
					<td width="25"><input type="checkbox" class="trans" name="s_exclude_roc_requested" value="Y"></td>
					<td width="315">Excluding ROC Requested</td>
					<td width="55"><img class="nostar">Option</td>
					<td><%//=JSPUtil.getCodeCombo("s_status", "", "onchange='changeTitle(this.value)' style='width:90'", "CD00813", 0, "")%>
						<SELECT name="s_status" style='width:110'>
							<OPTION  value="S">By Status </OPTION>
							<OPTION  value="E">By Expense Type </OPTION>
							<OPTION  value="A">By Aging </OPTION>
							<!--<OPTION  value="C">By Current Status</OPTION>-->
						</SELECT>
					</td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

<div id="tableGrid" style="display:inline">
		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search" name="">
       	<tr><td class="bg">

				<table class="height_10"><tr><td></td></tr></table>

				<table class="search" border="0">
				<tr id="tr_title1"><td class="title_h"></td><td class="title_s"><span id="divTitle">By Status</span></td></tr>
				<tr id="tr_title2" style="display:none;"><td class="title_h"></td><td class="title_s"><span id="divTitle">By Expense type</span></td></tr>
				<tr id="tr_title3" style="display:none;"><td class="title_h"></td><td class="title_s"><span id="divTitle">By Aging</span></td></tr>
				<tr id="tr_title4" style="display:none;"><td class="title_h"></td><td class="title_s"><span id="divTitle">By Current Status</span></td></tr>
				</table>

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
		              <tr id="tr_sheet1"><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
		              <tr id="tr_sheet2" style="display:none;"><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
		              <tr id="tr_sheet3" style="display:none;"><td><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
		              <tr id="tr_sheet4" style="display:none;"><td><script language="javascript">ComSheetObject('sheet4');</script></td></tr>
				</table>
				<!-- : ( POR ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->
</div>

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>


