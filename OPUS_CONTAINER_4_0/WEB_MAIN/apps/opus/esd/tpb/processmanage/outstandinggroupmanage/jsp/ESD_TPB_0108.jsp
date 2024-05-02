<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0108.jsp
*@FileTitle  : TPB Modification 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0108Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0108Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.OutstandingGroupmanage");
	String s_n3pty_no_strs_link = JSPUtil.getNull(request.getParameter("s_n3pty_no_strs_link"));
	String ofc_cd = "";
	String rhq_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		event = (EsdTpb0108Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<!-- 개발자 작업	-->
<input id="s_trd_party_val" name="s_trd_party_val" type="hidden" />
<input id="s_vndr_cust_div_cd" name="s_vndr_cust_div_cd" type="hidden" />
<input id="s_office_level" name="s_office_level" value="<%=ofc_lvl%>" type="hidden" />
<input id="s_rhq_cd_for_rhq" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>" type="hidden" />
<input id="s_ofc_cd_for_rhq" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>" type="hidden" />
<input id="s_n3pty_no_strs_link" name="s_n3pty_no_strs_link" value="<%=s_n3pty_no_strs_link%>" type="hidden" />
<input id="s_user_ofc_cd" name="s_user_ofc_cd" value="<%=ofc_cd%>" type="hidden" />
<input id="s_user_id" name="s_user_id" value="<%=strUsr_id%>" type="hidden" />
<input id="s_bkg_no" name="s_bkg_no" type="hidden" />
<input id="s_bl_no_all" name="s_bl_no_all" type="hidden" />
<input id="s_vvd" name="s_vvd" type="hidden" />
<input id="otherObjs" name="otherObjs" value="<%=ofc_cd%>" type="hidden" />
<input id="calllback" name="calllback" value="callback0809" type="hidden" />

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
		<button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_new" name="btn_new" class="btn_normal">New</button><!--
		--><button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
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
					<th>TPB No.</th>
					<td><input id="s_n3pty_no" class="input1" name="s_n3pty_no" type="text" /></td>
					<td></td> 
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