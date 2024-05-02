<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0120.jsp
*@FileTitle  : Performance - Non-TPB
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.event.EsdTpb0120Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0120Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String ofc_cd = "";
	String rhq_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	Logger log = Logger.getLogger("com.clt.apps.StatusInquiry.PerformanceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0120Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		<% if ( ofc_lvl.equals("R") ) { %>getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','2', new Array("s_if_rhq_cd","s_office_level"));<% } %>
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
	

<%=OfficeCodeMgr.getOfficeCodeListToJS("000004", "TPB")%>
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="iPage" id="iPage">
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
		<table class="search_in" border="0">
			<colgroup>
				<col width="50"/>
				<col width="100"/>
				<col width="20"/>
				<col width="*" />				
		   	</colgroup> 
			<tr>
				<th>Period</th>
				<td class="sm pad_left_4 pad_rgt_4"><input type="radio" name="s_date_type" id="s_date_type" value="L" class="trans" checked>Local <input type="radio" name="s_date_type" id="s_date_type" value="G" class="trans">GMT</td>
				<td></td>
				<td><input class="input1" name="s_sdate" type="text" style="width:75px" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>" dataformat="ymd" required caption='Date'>~ <input class="input1" name="s_edate" type="text" style="width:75px" value="<%=currentDay%>" dataformat="ymd" required caption='Date'><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
			</tr>
			</table>
			<table>
				<colgroup>
					<col width="50"/>
					<col width="100"/>
					<col width="100"/>
					<col width="150"/>
					<col width="50"/>
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>RHQ</th>
					<td><select class="input1" style="width:100px;" name="s_if_rhq_cd" id="s_if_rhq_cd" required caption="RHQ"><option value="" selected>&lt;Select&gt;</option></select></td>
					<th>Control Office</th>
					<td><select style="width:106px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" caption="Control Office" ><option value="" selected>&lt;Select&gt;</option></select></td>
					<th>Office</th>
					<td><select style="width:110px;" name="s_if_ofc_cd" id="s_if_ofc_cd"><option value="" selected>&lt;Select&gt;</option></select></td>
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