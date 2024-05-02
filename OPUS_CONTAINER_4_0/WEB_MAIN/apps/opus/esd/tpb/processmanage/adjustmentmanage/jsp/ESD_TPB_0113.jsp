<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0113.jsp
*@FileTitle  : Response Office Change 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0113Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
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
	String prevDay = "";
	if(cfm_dt.equals("")){
		if (cfm_dt_prev.equals("") || cfm_dt_last.equals("")){
			prevDay = DateTime.addDays(currentDay, -7, "yyyy-MM-dd");
		} else{
			prevDay = cfm_dt_prev;
			currentDay = cfm_dt_last;
		}
	}else{
		prevDay = cfm_dt;
		currentDay = cfm_dt;
	} 
%>

<script type="text/javascript">
	function setupPage(){
		<% if ( ofc_lvl.equals("R") ) { %>getTPBGenCombo('s_if_ctrl_cd','searchCtrlOffice','F','','2', new Array("s_if_rhq_cd","s_office_level"));<% } %>
		loadPage("<%=n3pty_no_strs%>");
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<input id="s_user_ofc_cd" name="s_user_ofc_cd" value="<%=ofc_cd%>" type="hidden" />
<!-- | --><input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<!-- | --><input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<!-- | --><input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input id="s_n3pty_no_strs" name="s_n3pty_no_strs" type="hidden" />
<input id="s_file_no" name="s_file_no" type="hidden" />
<input id="s_ra_rmk1" name="s_ra_rmk1" type="hidden" />
<input id="s_ra_rmk2" name="s_ra_rmk2" type="hidden" />
<!--<input type="hidden" name="stl_rqst_rmk"> -->
<input id="n3pty_stl_tp_cd" name="n3pty_stl_tp_cd" value="O" type="hidden" />
<input id="s_date_kind_flag" name="s_date_kind_flag" value="R" type="hidden" />
<input id="s_s_trd_party_val" name="s_s_trd_party_val" type="hidden" />
<input id="s_s_vndr_cust_div_cd" name="s_s_vndr_cust_div_cd" type="hidden" />
<input id="s_n3pty_no_strs_link" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>" type="hidden" />
<input id="stl_to_clt_cng_ofc_cd" name="stl_to_clt_cng_ofc_cd" type="hidden" />
<input id="priv_cd" name="priv_cd" value="<%=priv_cd%>" type="hidden" />
<input id="calllback" name="calllback" value="callback0804" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<div style="display: none">
			<button type="button" id="btn_new" name="btn_cancel_left" id="btn_cancel_left"></button>
			<button type="button" id="btn_new" name="btn_cancel" id="btn_cancel">Cancel</button>
			<button type="button" id="btn_new" name="btn_cancel_right" id="btn_cancel_right">Cancel</button>
		</div>
		<button type="button" name="btn_retrieve" id="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" name="btn_new" id="btn_new" class="btn_normal">New</button><!--
		--><button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button><!--
		--><button type="button" name="btn_downexcel" id="btn_downexcel" class="btn_normal">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search ">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="35">
					<col width="50">
					<col width="70">
					<col width="120">
					<col width="150">
					<col width="120">
					<col width="*">
				</colgroup>
				<tr>
					<td></td>
					<th><input id="c_date_kind_flag" name="c_date_kind_flag" style="border:0" value="R" checked="" type="radio" /> ROC Request</th>
					<td width="200">
						<select name="s_date_flag_r" id="s_date_flag_r" style="width:75px;">
<!--											<option value="AL">ROC-All</option>-->
							<option value="IN" <%if(ofc_lvl.equals("R")||ofc_lvl.equals("H")){%>selected<%}%>>ROC-In</option>
							<%if(!ofc_lvl.equals("R")&&!ofc_lvl.equals("H")){%>
							<option value="OT" <%if(s_n3pty_no_strs_link.length()>=14){ %>selected<%} %>>ROC-Out</option>
							<%} %>
						</select>
					</td>
					<td></td>
					<th><input id="c_date_kind_flag" name="c_date_kind_flag" style="border:0" value="I" type="radio" /> Inquiry of ROC Request</th>
					<td>
						<select name="s_date_flag_i" style="width:130px;">
							<option value="IL">ROC-in All</option>
							<option value="IA">ROC-in Accepted</option>
							<option value="IR">ROC-in Rejected</option>
							<option value="OL">ROC-out All</option>
							<option value="OA">ROC-out Accepted</option>
							<option value="OR">ROC-out Rejected</option>
						</select>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		</div>
		
		<div class="opus_design_inquiry">
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		</div>
		
		<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="50" />
					<col width="150" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th><input id="date_type" name="date_type" readonly value="Confirmed Date" style="width:110px; text-align:right; background-color:#F3F2F8" type="text"/></th>
					<td class="sm"><!-- 
						 --><input id="s_calendar_date1" name="s_calendar_date1" style="width:75px;" value="" onkeydown="tpb_isNumD(this, 'Y');" onblur="tpb_validateDateObj(this);" type="text" /><button class="calendar ir" name="btns_calendar1" id="btns_calendar1" type="button"></button>~  <!-- 
						 --><input id="s_calendar_date2" name="s_calendar_date2" style="width:75px;" value="" onkeydown="tpb_isNumD(this, 'Y');" onblur="tpb_validateDateObj(this);" type="text" /><button class="calendar ir" name="btns_calendar2" id="btns_calendar2" type="button"></button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<tbody>
				<colgroup>
					<col width="70" />
					<col width="30" />
					<col width="400" />
					<col width="50" />
					<col width="250" />
					<col width="50" />
					<col width="250" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>RHQ</th>
					<td>
						<select style="width: 100px" class="input1" name="s_if_rhq_cd" id="s_if_rhq_cd">
							<option value="" selected>&lt;&lt;Select&gt;&gt;</option>
						</select>
					</td>
					<th>Control Office</th>
					<td>
						<% if ( ofc_lvl.equals("C") ) { %>
<!-- | -->				<select style="width: 130px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd">
<!-- | -->					<option value="<%=ofc_cd%>" selected><%=ofc_cd%></option>
<!-- | -->				</select>
						<% } else { %>
<!-- | -->				<select style="width: 130px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd">
<!-- | -->					<option value="" selected>&lt;Select&gt;</option>
<!-- | -->				</select>
						<% } %>
					</td>
					<th>Office</th>
					<td>
						<select style="width: 110px;" name="s_if_ofc_cd" id="s_if_ofc_cd"><!-- Office -->
							<option value="" selected>&lt;Select&gt;</option>
						</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>3rd Party</th>
					<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:98'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;") %><input id="s_trd_party_val" name="s_trd_party_val" style="width: 98px;" value="" type="text" /><button class="input_seach_btn" name="btn_3rdParty" id="btn_3rdParty" type="button"></button></td>
					<th>TPB No.</th>
					<td><input id="s_n3pty_no" name="s_n3pty_no" style="width: 130px;" value="" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Currency</th>
					<td>
					<select style="width: 100px;" name="s_curr_cd_tp" id="s_curr_cd_tp"><!-- Office -->
						<option value="" selected>Local</option>
						<option value="U">USD</option>
					</select>
<%-- 					<td style="display: none"><%=JSPUtil.getCodeCombo("n3pty_stl_tp_cd","","style='width:182'","CD00589",0,"000000: :&lt;&lt;Select&gt;&gt;") %></td> --%>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>