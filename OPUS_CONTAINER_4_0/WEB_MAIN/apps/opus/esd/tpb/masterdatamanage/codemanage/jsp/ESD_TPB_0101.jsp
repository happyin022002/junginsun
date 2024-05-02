<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0101.jsp
*@FileTitle  : TPB Code Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
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
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.event.EsdTpb0101Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0101Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MasterDataManage.CodeManage");
	String userId = "";
	String ofc_cd = "";
	String rhq_cd = "";
	String ofc_lvl = "";
	StringBuffer codeSb = new StringBuffer();
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		event = (EsdTpb0101Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
		ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level  
		rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code  
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00904", 0, "")%>
<%= JSPUtil.getIBCodeCombo("combo02", "01", "CD00579", 0, "")%>
<%= JSPUtil.getIBCodeCombo("combo03", "01", "CD00581", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<input id="s_codeAll" name="s_codeAll" value="<%=codeSb%>" type="hidden" />
<input id="s_office_level" name="s_office_level" value="<%=ofc_lvl%>" type="hidden" />
<input id="s_rhq_cd_for_rhq" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>" type="hidden" />
<input id="s_ofc_cd_for_rhq" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>" type="hidden" />
<input id="s_n3pty_bil_tp_cd" name="s_n3pty_bil_tp_cd" type="hidden" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 --><%-- if ( ofc_lvl.equals("H") && OfficeCodeMgr.checkContainOfficeCode("000004","TPB",ofc_cd) ) { --%>
	 <% if (ofc_lvl.equals("H")) { %><!-- 
		  --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			 --><% } %><!-- 
		  --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="10" />
				<col width="30" />
				<col width="200" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>Billing Type Code</th>
				<td><select name="s_billing_case_cd" id="s_billing_case_cd" style="width: 100px;"></select></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
 <!-- opus_design_grid(S) -->
       <div class="opus_design_grid">
            <div class="opus_design_btn">
			 	<% if ( ofc_lvl.equals("H")) { %> 
					<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
		 		<% } %>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
       </div>
<!-- opus_design_grid(E) -->
</div>
</form>