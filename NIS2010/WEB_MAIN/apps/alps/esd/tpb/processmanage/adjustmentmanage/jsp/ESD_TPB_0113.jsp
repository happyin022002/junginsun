<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0113.jsp
*@FileTitle : Response Office Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-27
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-09-27 Sun, Choi 1.1 ALPS Migration
* -------------------------------------------------------
* History
* 2010.10.01 변종건 [CHM-201005566-01] [TPB] 지역본부/본사의 ROC 결정 후 2ND REVIEW를 위한 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%> 
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0113Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>

<%@ page import="org.apache.log4j.Logger" %>

<%
	String n3pty_no_strs = JSPUtil.getNull(request.getParameter("n3pty_no"));
	String s_n3pty_no_strs_link = JSPUtil.getNull(request.getParameter("s_n3pty_no_strs_link"));
	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String ofc_cd = account.getOfc_cd(); // User Office Code
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	String rhq_cd = JSPUtil.getNull( officeInfo[2] );  // R.HQ Code
	String priv_cd = JSPUtil.getNull( officeInfo[4] );
	
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	String cfm_dt = JSPUtil.getNull(request.getParameter("s_cfm_dt"));
	String cfm_dt_prev = JSPUtil.getNull(request.getParameter("s_cfm_dt_prev"));
	String cfm_dt_last = JSPUtil.getNull(request.getParameter("s_cfm_dt_last"));
	String pop_yn = JSPUtil.getNull(request.getParameter("pop_yn"));
	
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
		<% if ( ofc_lvl.equals("R") ) { %><% } %>
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
<!-- | --><input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<!-- | --><input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<!-- | --><input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">

<input type="hidden" name="s_n3pty_no_strs">
<input type="hidden" name="s_file_no">
<input type="hidden" name="s_ra_rmk1">
<input type="hidden" name="s_ra_rmk2">
<!--<input type="hidden" name="stl_rqst_rmk"> -->
<input type="hidden" name="n3pty_stl_tp_cd" value="O">
<input type="hidden" name="s_date_kind_flag" value="R">
<input type="hidden" name="s_s_trd_party_val">
<input type="hidden" name="s_s_vndr_cust_div_cd">
<input type="hidden" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>">
<input type="hidden" name="n2nd_rvw_chk" value="N">
<input type="hidden" name="rollback_chk" value="N">

<input type="hidden" name="stl_to_clt_cng_ofc_cd">

<!--* 2009-01-08 O Wan-Ki 1.2 Control Office 추가로 인한 Office별 Privilege 정보-->
<input type="hidden" name="priv_cd" value="<%=priv_cd%>">

<input type="hidden" name="pop_yn" value="<%=pop_yn%>">

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
							<% if ( ofc_lvl.equals("H") || ofc_lvl.equals("R") || ofc_lvl.equals("S") ) { %>
							<td>
							     <table id="btn_2ndReview" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_review" id="btn_review">2nd Review</td><td class="btn1_right"></td></tr>
                                 </table>
                            </td>
								<% if ( ofc_lvl.equals("H") ) { %>
								<!-- 
								<td>
								     <table id="btn_rollbackROC" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_rollback" id="btn_rollback">Rollback Retrieve</td><td class="btn1_right"></td></tr>
	                                 </table>
	                            </td>   
								<td>
								     <table id="btn_rollbackSave" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                    <tr><td class="btn1_left"></td><td class="btn1" name="btn_rollsave" id="btn_rollsave">Rollback Save</td><td class="btn1_right"></td></tr>
	                                 </table>
	                            </td>   
	                             -->
	                            <% } %>                                                     
                            <td class="btn1_line"></td>
                            <% } %>
                            
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" id="btn_cancel_left" style="display:none;"></td><td class="btn1" name="btn_cancel" id="btn_cancel" style="display:none;">Cancel</td><td class="btn1_right" id="btn_cancel_right" style="display:none;"></td></tr></table></td>
<!--  
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left" style="display:none"></td><td class="btn1" name="btn_cancel" id="btn_cancel" style="display:none">Cancel</td><td class="btn1_right" style="display:none"></td></tr></table></td>
-->
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
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       		<tr>
       			<td class="bg">
					<!-- : ( Year ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td>
								<table class="search" border="0" width="100%">
									<tr class="h23">
										<td width="25"><input type="radio" name="c_date_kind_flag" style="border:0" value="R" checked></td>
										<td width="120">ROC Request</td>
										<td width="200">
											<select name="s_date_flag_r" style="width:75;">
	<!--										<option value="AL">ROC-All</option>-->
												<option value="IN" <%if(ofc_lvl.equals("R")||ofc_lvl.equals("H")){%>selected<%}%>>ROC-In</option>
												<%if(!ofc_lvl.equals("R")&&!ofc_lvl.equals("H")){%>
												<option value="OT" <%if(s_n3pty_no_strs_link.length()>=14){ %>selected<%} %>>ROC-Out</option>
												<%} %>
											</select>
										</td>
										<td width="25"><input type="radio" name="c_date_kind_flag" style="border:0" value="I"></td>
										<td width="155">Inquiry of ROC Request</td>
										<td>
											<select name="s_date_flag_i" style="width:130;">
												<option value="IL">ROC-in All</option>
												<option value="IA">ROC-in Accepted</option>
												<option value="IR">ROC-in Rejected</option>
												<option value="OL">ROC-out All</option>
												<option value="OA">ROC-out Accepted</option>
												<option value="OR">ROC-out Rejected</option>
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
										<td width="120" id="date_type">Confirmed Date</td>
										<td width="" class="stm">
											<input class="input1" type="text" name="s_calendar_date1" style="width:70" value="<%=prevDay%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<!--
											--><!-- <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"> -->~&nbsp;<!--
											--><input class="input1" type="text" name="s_calendar_date2" style="width:70" value="<%=currentDay%>" data_format="ymd" required caption='Date' OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">&nbsp;<!--
											--><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
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
										<td width="120">RHQ</td>
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
										<td width="120">3rd Party</td>
										<td width="102">
											<%//=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:98'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;")%><!-- 3rd Party -->
											<%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:98'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%><!-- 3rd Party -->
										</td>
										<td width="188">
											<!--<input type="text" name="s_trd_party_val" style="width:97;" value="">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">-->
											<input type="text" style="width:70;" name="s_trd_party_val" maxlength="8" !readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">
										</td>
										<td width="90">TPB No.</td>
										<td width=""><input type="text" name="s_n3pty_no" maxlength="14" style="width:130" value=""><!-- TPBPUS06070001 --></td>
	
	
									</tr>
								</table>
	
								<!-- * 2009-01-22 O Wan-Ki 1.3 Currency Select Box 추가 -->
								<table class="search" border="0" width="100%">
									<tr class="h23">
										<td width="25"></td>
										<td width="120">Currency</td>
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
				</td>
			</tr>
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

<!-- : ( Button : pop ) (S) -->
<div id="btnCloseLayer" style="display:none">
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table>
		</td></tr>
	</table>
	</td></tr>
</table>
</div>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>