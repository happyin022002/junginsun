<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0132.jsp
*@FileTitle  : TPB Office Inquiry
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
<%@ page import="com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.event.EsdTpb0132Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0132Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhq_cd		= "";
	String ofc_cd		= "";

	Logger log = Logger.getLogger("com.clt.apps.MasterDataManage.OfficeManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0132Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	String[] officeInfo = com.clt.apps.opus.esd.tpb.common.TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level  
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code  
%>
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00961", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("combo02", "01", "CD01472", 0, "")%>

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
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" name="s_office_level" value="H" id="s_office_level" />
	<input type="hidden" name="s_rhq_cd_for_rhq" value="" id="s_rhq_cd_for_rhq" />
	<input type="hidden" name="s_ofc_cd_for_rhq" value="" id="s_ofc_cd_for_rhq" />
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_downexcel" 			id="btn_downexcel">Down Excel</button>		
		</div>
		<!-- opus_design_btn(E) -->
	
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
					<col width="110"/>				
					<col width="50"/>				
					<col width="100"/>				
					<col width="50"/>				
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>RHQ</th>
					<td><select style="width:80px;" name="s_if_rhq_cd" id="s_if_rhq_cd" onchange="if_rhq_cd_OnChange()"><option value="" selected>ALL</option></select></td>
					<th>TPB Office</th>
					<td><select style="width:80px;" name="s_if_ofc_cd" id="s_if_ofc_cd"><option value="" selected>ALL</option></select></td>
					<th>Office</th>
					<td><input type="text" style="width:80px;" name="s_ofc_cd" id="s_ofc_cd" maxlength="11" dataformat="engup"></td>
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
