<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0135.jsp
*@FileTitle  : Activity - TPB Confirmation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event.EsdTpb0135Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String strErrMsg = "";						//Error message
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";	
	String ofc_cd = "";
	String rhq_cd = "";
	String priv_cd = "";
	String ofc_lvl = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

	} catch(Exception e) {
		out.println(e.toString());
	}
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
	priv_cd = JSPUtil.getNull( officeInfo[4] );
	String s_state = JSPUtil.getNull(request.getParameter("s_state"));
	String p_sdate = "";
	String p_edate = "";
	p_sdate = DateTime.addMonths(currentDay, -1, "yyyy-MM-dd");
	p_edate = currentDay;
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_n3pty_no" id="s_n3pty_no" />
<input type="hidden" name="s_ctrl_ofc_cd" id="s_ctrl_ofc_cd" />
<input type="hidden" name="s_state" id="s_state" value="<%=s_state%>">
<input type="hidden" name="priv_cd" id="priv_cd" value="<%=priv_cd%>">
<input type="hidden" name="sdate" id="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" id="edate" value="<%=currentDay%>">
<input type="hidden" name="s_user_ofc_cd" id="s_user_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_office_level" id="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" id="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" id="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
		
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100"/>								
					<col width="97"/>				
					<col width="150"/>				
					<col width="100"/>				
					<col width="*" />				
				</colgroup> 
				<tr>
					<th><h3 class="title_design">Confirmation</h3></th>
				    <th>RHQ</th>
					<td><select style="width:120px;" name="s_if_rhq_cd" id="s_if_rhq_cd" OnChange="javascript:if_rhq_cd_OnChange();" required caption="RHQ"></select></td>
					<th>Confirmed Date</th>
					<td><input type="text" name="s_sdate" id="s_sdate" style="width: 100px" value="<%=p_sdate%>" caption="Date" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"> ~ <input type="text" name="s_edate" id="s_edate" style="width: 100px" value="<%=p_edate%>"  caption="Date" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
				</tr>
			</table>
			<table>
				<colgroup>			
					<col width="200"/>				
					<col width="150"/>				
					<col width="100"/>							
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>Control Office</th>
					<td><select style="width:120px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" OnChange="if_ctrl_cd_OnChange();" caption="Control Office"></select></td>
					<th>Currency</th>
					<td><%=TPBUtils.getCodeCombo("s_curr_cd_tp", "", "style='width: 60px' ", "CD01382", 0, "", "")%></td>
				</tr>
			</table>
			<table>
				<colgroup>						
					<col width="200"/>							
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>Office</th>
					<td><select style="width:120px;" name="s_if_ofc_cd" id="s_if_ofc_cd"><option value="" selected>All</option></select></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">		
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>
