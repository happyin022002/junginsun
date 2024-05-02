<%
/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : ESD_TPB_0115.jsp
*@FileTitle : TPB Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-06
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki 			1.0 최초 생성
* 2009-10-06 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0115Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0115Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.StatusInquiry");
	
	String ofc_cd = "";
	String n3pty_no = "";

	String ots_sts_cd = JSPUtil.getNull(request.getParameter("s_h_ots_sts_cd"));
	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code"));
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0115Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// office level
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level 
	
	// retrieve only ( 별도 menu로부터 )
	boolean isReadOnly = false;
	String strReadOnly = ""; 
	String strBgColor = "";
	String flagReadOnly = JSPUtil.getNull(request.getParameter("s_readonly"));
	String popUpFlg =  JSPUtil.getNull(request.getParameter("popUpFlg"));

	if ( n3pty_no.trim().equals("") || flagReadOnly.equals("Y") ) { 
		isReadOnly = true;
		strReadOnly = " readonly";
		strBgColor = ".background-color:#EEEEEE;";
	} 

    String s_direct_tpb_no = JSPUtil.getNull(request.getParameter("s_direct_tpb_no"));
    if ( s_direct_tpb_no.length() > 0 ) {
    	n3pty_no = s_direct_tpb_no;
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
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="iPage">
<input type="hidden" name="s_detail_n3pty_no" value="<%=n3pty_no%>">
<input type="hidden" name="s_usr_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_ots_sts_cd" value="<%=ots_sts_cd%>">
<input type="hidden" name="s_h_ots_sts_cd" value="<%=ots_sts_cd%>">
<input type="hidden" name="s_n3pty_bil_tp_cd" value=""><%-- JO Case Blocking ... Added By Kim Jin-seung In 2007-10-29 --%>
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="1">
<input type="hidden" name="s_trd_party_code" value="<%=s_trd_party_code%>">
<input type="hidden" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>">
<input type="hidden" name="s_last_vndr_cust_div_cd" value="">
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
<input type="hidden" name="toEmail">
<input type="hidden" name="s_process_close_message" value="">
<input type="hidden" name="s_readonly" value="<% if(isReadOnly){out.print("Y");} %>">

<%
	if(!("Y").equals(popUpFlg)){
%>
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
								<% if(!isReadOnly){ // %>
								<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_invoicecreation" id="btn_invoicecreation">Invoice Creation</td><td class="btn1_right"></td></tr></table></td>
								<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_settlement" id="btn_settlement">Settlement</td><td class="btn1_right"></td></tr></table></td>
								<% } %>
								<% if(!isReadOnly){ // %>
								<% if(ofc_lvl.equals("R")){ //RHQ %>
								<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_cancel_process" id="btn_cancel_process">Cancel Process</td><td class="btn1_right"></td></tr></table></td>
								<% } %>
								<% if(ofc_lvl.equals("G") || ofc_lvl.equals("")){ //General Office %>
								<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_close_process" id="btn_close_process">Close Process</td><td class="btn1_right"></td></tr></table></td>
								<% } %>
								<td style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
								<% } %>
								<% //if(n3pty_no.trim().length()==14){ %>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
								<td class="btn1_line"></td>
								<% //} %>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_recoveryactivity" id="btn_recoveryactivity">Recovery Activity</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

<%
	}
	else {
%>
<table width="1000" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="540" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;TPB Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%
	}
%>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="80">TPB No.</td>
						<td width="300"><input type="text" style="width:154;" name="s_n3pty_no" maxlength="14" value=<%=n3pty_no %>></td>
						<td width="100">Invoice No.</td>
						<td><input type="text" style="width:140;" name="s_n3pty_inv_no" maxlength="11"></td>
					</tr>
				</table>

				<table class="line_bluedot"><tr><td></td></tr></table>

				<table class="search_in" border="0">
					<tr class="h23">
						<td width="80">Res. Office</td>
						<td width="300"><input type="text" style="width:154;.background-color:#EEEEEE" name="s_ofc_cd" <%=strReadOnly%>></td>
						<td width="100">TPB Status</td>
						<td width="250"><input type="text" style="width:138;.background-color:#EEEEEE" name="s_ots_sts_nm"<%=strReadOnly%>></td>
						<td width="65">Overdue</td>
						<td><input type="text" style="width:150;.background-color:#EEEEEE" name="s_overdue" <%=strReadOnly%>></td>
					</tr>
					<tr class="h23">
						<td>3rd Party</td>
						<td colspan="3">
						<%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:80;"+strBgColor+"'"+(isReadOnly?" disabled":"")+"", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
						<input type="text" style="width:70;<%=strBgColor%>" name="s_trd_party_val" maxlength="8" <%=strReadOnly%>> <% if(!isReadOnly){ // %>
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">
						<% } %>
						<input type="text" style="width:380;<%=strBgColor%>" name="s_trd_party_nm" readonly>
						<td>CSR No.</td>
						<td><input type="text" style="width:150;.background-color:#EEEEEE" name="s_csr_no" value="" <%=strReadOnly%>></td>
					</tr>
					<tr class="h23">
						<td width="">ROC-out (from)</td>
						<td width=""><input type="text" style="width:138;.background-color:#EEEEEE" name="s_roc_out" <%=strReadOnly%>></td>
						<td width="">&nbsp;</td>
						<td>&nbsp;</td>
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



				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( POR ) (E) -->

				<div style="display:none">
					<script language="javascript">ComSheetObject('sheet2');</script><!-- hidden information for 3rd Party -->
				</div>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

<% if(("Y").equals(popUpFlg)){%>
<table class="height_10"><tr><td></td></tr></table>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_recoveryactivity" id="btn_recoveryactivity">Recovery Activity</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
				</tr>
			</table>
		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
<%}%>
</form>
</body>
</html>