<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0125.jsp
*@FileTitle  : JO TPB Modification
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.event.EsdTpb0125Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String s_n3pty_no_strs_link = JSPUtil.getNull(request.getParameter("s_n3pty_no_strs_link"));

	EsdTpb0125Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

		event = (EsdTpb0125Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>


<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage" id="iPage">

<input type="hidden" name="s_trd_party_val" id="s_trd_party_val">
<input type="hidden" name="s_vndr_cust_div_cd" id="s_vndr_cust_div_cd">
<input type="hidden" name="sdate" id="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" id="edate" value="<%=currentDay%>">
<input type="hidden" name="s_office_level" id="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" id="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" id="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">

<input type="hidden" name="s_n3pty_no_strs_link" id="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>">

<input type="hidden" name="s_bkg_no" id="s_bkg_no">
<input type="hidden" name="s_bl_no_all" id="s_bl_no_all">
<input type="hidden" name="s_vvd" id="s_vvd">
<input type="hidden" name="otherObjs" id="otherObjs" value="<%=ofc_cd%>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_jotpbcancel" id="btn_jotpbcancel" type="button">JO TPB Cancel</button><!--
		--><button class="btn_normal" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
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
				<col width="*" />				
		   </colgroup> 
		   <tr>
		   		<th>TPB No.</th>
		    	<td><input class="input1" type="text" name="s_n3pty_no" id="s_n3pty_no" dataformat="engup"></td>
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