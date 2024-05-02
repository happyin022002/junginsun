<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0129.jsp
*@FileTitle  : JO TPB Invoice Inquiry
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
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0129Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0129Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0129Event)request.getAttribute("Event");
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

<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}


<%=OfficeCodeMgr.getOfficeCodeListToJS("000004", "TPB")%>
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_length_n3pty_bil_tp_cd" id="s_length_n3pty_bil_tp_cd" />
<input type="hidden" name="s_trd_party_code" id="s_trd_party_code" />
<input type="hidden" name="s_h_vndr_cust_div_cd" id="s_h_vndr_cust_div_cd" />

<input type="hidden" name="s_detail_n3pty_no" value="" id="s_detail_n3pty_no" />
<input type="hidden" name="s_n3pty_inv_no" value="" id="s_n3pty_inv_no" />
<input type="hidden" name="s_n3pty_inv_his_seq" value="" id="s_n3pty_inv_his_seq" />
<input type="hidden" name="s_n3pty_inv_rmd_cd" value="" id="s_n3pty_inv_rmd_cd" />

<input type="hidden" name="s_correction_yn" value="N" id="s_correction_yn" />
<input type="hidden" name="s_inquiryOnly_yn" value="Y" id="s_inquiryOnly_yn" />


<input type="hidden" name="s_office_level" id="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" id="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" id="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_usr_ofc_cd" id="s_usr_ofc_cd" value="<%=ofc_cd%>">


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
				<col width="16">
				<col width="85">
				<col width="230">
				<col width="10">
				<col width="70">
				<col width="200">
				<col width="10">
				<col width="70">
				<col width="*">
			</colgroup>
			<tr>
				<td><input type="radio" name="s_cond" value="1" class="trans" checked id="s_cond" /></td>
				<th>Invoiced Date</th>
				<td><input type="text" name="s_sdate" id="s_sdate" class="input" style="width:80px" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>" dataformat="ymd"  caption='Date'>~ <input type="text" class="input" name="s_edate" id="s_edate" style="width:80px" value="<%=currentDay%>" dataformat="ymd"  caption='Date'><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
				<td><input type="radio" name="s_cond" value="2" class="trans" id="s_cond" /></td>
				<th>Invoice No.</th>
				<td><input type="text" style="width:133px;" dataformat="engup" name="s_n3pty_inv_no_for_search" maxlength="11" id="s_n3pty_inv_no_for_search" /><input type="text" class="" style="width:33px;" name="s_n3pty_inv_rmd_cd_for_search" value="" id="s_n3pty_inv_rmd_cd_for_search" /> </td>
				<td><input type="radio" name="s_cond" value="3" class="trans" id="s_cond" /></td>
				<th>Equipment No.</th>
				<td><input type="text" style="width:160px;" name="s_eq_no" dataformat="engup" maxlength="11" id="s_eq_no"/></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="101">
				<col width="130">
				<col width="186">
				<col width="100">
				<col width="197">
				<col width="100">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<th>RHQ</th>
				<td><select class="input1" style="width:100px;" name="s_if_rhq_cd" id="s_if_rhq_cd" required caption="RHQ" onblur="if_rhq_cd_OnChange();"><option value="" selected>&lt;Select&gt;</option></select></td>
				<th>Control Office</th>
				<td><select style="width:100px;" name="s_if_ctrl_cd" id="s_if_ctrl_cd" caption="Control Office" onblur="if_ctrl_cd_OnChange();"><option value="" selected>&lt;Select&gt;</option></select></td>
				<th>Office</th>
				<td><select style="width:100px;" name="s_if_ofc_cd" id="s_if_ofc_cd"><option value="" selected>&lt;Select&gt;</option></select></td>
				<th>3rd Party</th>
				<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:85'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%><input type="text" style="width:75px;" name="s_trd_party_val" id="s_trd_party_val" /><button type="button" id="btn_3rdParty" name="btn_3rdParty" class="input_seach_btn"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="195"/>				
				<col width="100"/>				
				<col width="*"/>
			</colgroup>
			<tr>
				<th>Collection Agency  / Legal Action</th>
				<th><%=JSPUtil.getCodeCombo("s_clt_agn_flg", "", "style='width:80'", "CD00877", 0, "")%></th>
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
