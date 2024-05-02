﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TPB_0138.jsp
*@FileTitle : TPB Write-Off Review
*Open Issues :
*Change history :
*@LastModifyDate : 2014-09-11
*@LastModifier : 
*@LastVersion : 1.0
* 2014-09-11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0138Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %> 

<%
	///----- From Outstanding -----
	String n3pty_no_strs = JSPUtil.getNull(request.getParameter("n3pty_no"));
	String s_n3pty_no_strs_link = JSPUtil.getNull(request.getParameter("s_n3pty_no_strs_link"));

	///----- Gett Office Info  -----
	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String ofc_cd = account.getOfc_cd(); // User Office Code
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	String rhq_cd = JSPUtil.getNull( officeInfo[2] );  // R.HQ Code

	// * 2009-01-08 O Wan-Ki 1.2 Control Office 추가로 인한 Office별 Privilege 정보
	String priv_cd = JSPUtil.getNull( officeInfo[4] );
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD03040", 0, " ")%>

	function setupPage(){		
		loadPage("<%=n3pty_no_strs%>");
		_text_ChangeUpperCase(); // automatic change to uppercase 
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="s_user_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">

<input type="hidden" name="s_n3pty_no_strs">
<input type="hidden" name="s_file_no">
<input type="hidden" name="s_ra_rmk1">
<input type="hidden" name="s_ra_rmk2">
<input type="hidden" name="s_wrtf_rsn_cd">

<!--<input type="hidden" name="stl_rqst_rmk"> -->
<input type="hidden" name="n3pty_stl_tp_cd" value="W">
<input type="hidden" name="s_date_kind_flag" value="R">

<input type="hidden" name="s_s_trd_party_val">
<input type="hidden" name="s_s_vndr_cust_div_cd">
<input type="hidden" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>">

<!--* 2009-01-08 O Wan-Ki 1.2 Control Office 추가로 인한 Office별 Privilege 정보-->
<input type="hidden" name="priv_cd" value="<%=priv_cd%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>



		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<%
		// <table width="100%" class="title">
		// <tr><td class="history"><img src="/hanjin/img/enis/ico_hystory.gif" width="8" height="9" align="absmiddle">Service Delivery > 3rd Party Billing > Adjustment Management</td></tr>
		// <tr><td class="title"><img src="/hanjin/img/enis/ico_t1.gif" width="20" height="12"> Adjustment Request</td></tr>
		// </table>
		%>
	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->
	<!-- | -->	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->
		<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left" id="btn_cancel_left" style="display:none;"></td>
										<td class="btn1" name="btn_cancel" id="btn_cancel" style="display:none;">Cancel</td>
										<td class="btn1_right" id="btn_cancel_right" style="display:none;"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" >Retrieve</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td>
							</td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
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
						<td>

							<table class="search" border="0" width="100%">
								<tr class="h23">
									<td width="25"><input type="radio" name="c_date_kind_flag" style="border:0" value="R" checked /></td>
									<td width="110">W/O Request</td>
									<td width="200">
										<select name="s_date_flag_r" style="width:75;">
											<option value="IN" selected>W/O-In</option>											
										</select>
									</td>
									<td width="25"><input type="radio" name="c_date_kind_flag" style="border:0" value="I" ></td>
									<td width="155">Inquiry of W/O Request</td>
									<td>
										<select name="s_date_flag_i" style="width:130;">
<!--											<option value="IL">W/O-in All</option>-->
<!--											<option value="IA">W/O-in Accepted</option>-->
<!--											<option value="IR">W/O-in Rejected</option>-->
											<option value="OL">W/O All</option>
											<option value="OA">W/O Approved</option>
											<option value="OR">W/O Rejected</option>
											<option value="OREQ">W/O Requested</option>
										</select>
									</td>
								</tr>
							</table>


						</td>
					</tr>
					<tr class="h23">
						<td class="line_bluedot" colspan="15"></td>
					</tr>
				<tr class="h23">
					<td>
						<table class="search" border="0" width="100%">
							<tr class="h23">
								<td width="25"></td>
								<td width="110">Confirmed Date</td>
								<!-- <td width="115"><input name="date_type" type="text" readonly value="Confirmed Date" style="width:110; text-align:right; border=0; background-color:#F3F2F8"></td> -->
								<td width="" class="stm">
									<input type="text" name="s_calendar_date1" style="width:75" value="" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">
									<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;
									<input type="text"  name="s_calendar_date2"style="width:75" value="" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">
									<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr class="h23">
					<td>

						<table class="search" border="0" width="100%">
							<tr class="h23">
								<td width="25"></td>
								<td width="110">RHQ</td>
								<td width="290">
									<select style="width:98;" class="input1" name="s_if_rhq_cd"><!-- RHQ -->
										<option value="" selected>&lt;Select&gt;</option>
									</select>
								</td>
								<td width="90">Control Office</td>
								<td width="250">
									<% if ( ofc_lvl.equals("C") ) { %>
			<!-- | -->				<select style="width:130;" name="s_if_ctrl_cd" caption="Control Office">
			<!-- | -->					<option value="<%=ofc_cd%>" selected><%=ofc_cd%></option>
			<!-- | -->				</select>
									<% } else { %>
			<!-- | -->				<select style="width:130;" name="s_if_ctrl_cd" caption="Control Office">
			<!-- | -->					<option value="" selected>ALL</option>
			<!-- | -->				</select>
									<% } %>
								</td>
								<td width="50"><img class="nostar">Office</td>
								<td>
									<select style="width:110;" name="s_if_ofc_cd"><!-- Office -->
										<option value="" selected>ALL</option>
									</select>
								</td>
							</tr>
						</table>

					</td>
				</tr>
				</table>
				<table class="search_in" border="0">
					<tr class="h23">
					<td>

							<table class="search" border="0" width="100%">
								<tr class="h23">
									<td width="25"></td>
									<td width="110">3rd Party</td>
									<td width="102"><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:98'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;")%><!-- 3rd Party --></td>
									<td width="188"><input type="text" name="s_trd_party_val" style="width:97;" value="">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty"></td>
									<td width="90">TPB No.</td>
									<td width=""><input type="text" name="s_n3pty_no" style="width:130" value=""><!-- TPBPUS06070001 --></td>


								</tr>
							</table>

							<!-- * 2009-01-22 O Wan-Ki 1.3 Currency Select Box 추가 -->
							<table class="search" border="0" width="100%">
								<tr class="h23">
									<td width="25"></td>
									<td width="110">Currency</td>
									<td width="">
									<select style="width:98;" name="s_curr_cd_tp"><!-- Office -->
										<option value="" selected>Local</option>
										<option value="U">USD</option>
									</select>
									</td>
								</tr>
							</table>
					</td>
					</tr>
				</table>

				<table class="search_in" border="0">

<!--				<tr class="h23" style="display:none">-->
<!--					<td width="39%">Adjustment Type&nbsp;-->
<!--						<%=JSPUtil.getCodeCombo("n3pty_stl_tp_cd","","style='width:182'","CD00589",0,"000000: :&lt;&lt;Select&gt;&gt;") %>-->
<!--					</td>-->
<!--					<td width="7%" style="padding-left:4;">R.O.C To</td>-->
<!--					<td width="14%" style="padding-left:5;"><input type="text" name="stl_to_clt_cng_ofc_cd" style="width:70" class="noinput" value="" disabled>-->
<!--						&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_rocto" id="btn_rocto"><%// Added By Kim Jin-seung In 2007-08-31%>-->
<!--					</td>-->
<!--					<td width="40%" style="padding-left:8"> Remarks&nbsp; <input type="text" name="stl_rqst_rmk" style="display:none;width:252" value=""></td>-->
<!--				</tr>-->
				</table>
				<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>
				<!--
				<table class="search" border="0">
				<tr><td class="gray">(USD)</td></tr>
				</table>
				 -->

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		                     <!--그리드안에 들어갈 버튼 입니다. Collection Activity 컬럼안에 들어갈 버튼 이미지입니다.
				<img class="cursor" src="/hanjin/img/button/btng_collectionactivity.gif" width="113" height="19" border="0">-->
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