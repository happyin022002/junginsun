<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_pri_0001_01.jsp
*@FileTitle  : Sales Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.event.EsmPri000101Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri000101Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri000101Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd">
<input type="hidden" name="gline_seq" id="gline_seq">


<div class="opus_design_title clear">
	<!-- opus_grid_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_grid_btn(E) -->
</div>

<!-- <div class="wrap_result"> -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd" suppressWait="Y">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_rowcopy" id="btn_rowcopy" suppressWait="Y">Row Copy</button><!--
			--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete" suppressWait="Y">Delete</button>
		</div>
		<!-- opus_grid_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_data">
	    <table class="grid2">    
			<tr>
				<th width="70px">Content</th>
				<td width="*"><textarea name="ref_ctnt" id="ref_ctnt"  caption="Content" maxlength="4000" style="height:130px;"></textarea></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
<!-- </div> -->

</form>