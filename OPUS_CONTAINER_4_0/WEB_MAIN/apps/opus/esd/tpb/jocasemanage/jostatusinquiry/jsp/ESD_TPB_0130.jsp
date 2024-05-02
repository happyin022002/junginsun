<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0130.jsp
*@FileTitle  : JO TPB Process Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0130Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	EsdTpb0130Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StatusInquiry.PerformanceInquiry");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd));

		event = (EsdTpb0130Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>" id="s_office_level" />
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>" id="s_rhq_cd_for_rhq" />
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>" id="s_ofc_cd_for_rhq" />

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
					<col width="50"/>
					<col width="100"/>
					<col width="50"/>
					<col width="100"/>
					<col width="50"/>
					<col width="*" />				
			</colgroup>
			<tr>
				<th>Period</th>
				<td><input type="text" name="s_sdate" style="width:75px" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>"  caption="Date" dataformat="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);">~ <input type="text" name="s_edate" style="width:75px" value="<%=currentDay%>"  caption="Date" dataformat="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
				<th>RHQ</th>
				<td><select class="input1" style="width:100px;" name="s_if_rhq_cd" id="s_if_rhq_cd" required caption="RHQ"><option value="" selected>&lt;Select&gt;</option></select></td>
				<th>Office</th>
				<td title="Cost Office"><select class="input1" style="width:100px;" name="s_if_ofc_cd" required caption="Office"><option value="" selected>&lt;Select&gt;</option></select></td>
			</tr>
		</table>
		<table>
			<colgroup>
					<col width="100"/>
					<col width="130"/>
					<col width="90"/>
					<col width="137"/>
					<col width="100"/>
					<col width="*" />				
			</colgroup>
			<tr>
				<td class="sm pad_left_4"><input type="radio" name="s_cd_kind" value="C" style="border:0;" checked id="s_cd_kind" /><label for="s_cd_kind">CSR No.</label></td>
				<td class="sm"><input type="radio" name="s_cd_kind" value="S" style="border:0;" id="s_cd_kind" /><label for="s_cd_kind">S/P Invoice No.</label></td>
				<td class="sm"><input type="radio" name="s_cd_kind" value="T" style="border:0;" id="s_cd_kind" /><label for="s_cd_kind">TPB No.</label></td>
				<td class="sm"><input type="radio" name="s_cd_kind" value="I" style="border:0;" id="s_cd_kind" /><label for="s_cd_kind">TPB Invoice No.</label></td>
				<td class="sm"><input type="text" size="28" name="s_cd_value" id="s_cd_value" /></td>
				<td></td>
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