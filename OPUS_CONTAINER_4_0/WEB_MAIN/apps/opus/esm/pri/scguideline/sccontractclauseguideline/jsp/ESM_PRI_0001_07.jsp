<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_07.jsp
*@FileTitle  : SC Guideline Contract Clause
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.event.EsmPri000107Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000107Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCContractClauseGuideline");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri000107Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="" id="gline_seq" />
<input type="hidden" name="ctrt_cluz_seq" value="" id="ctrt_cluz_seq" />
<input name="cd" type="hidden" value="" id="cd" />
<input name="etc1" type="hidden" value="" id="etc1" />
<input name="etc2" type="hidden" value="" id="etc2" />
<input name="etc3" type="hidden" value="" id="etc3" />
<input name="etc4" type="hidden" value="" id="etc4" />
<input name="etc5" type="hidden" value="" id="etc5" />

<div class="opus_design_title clear">
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>

<!-- <div class="wrap_result"> -->
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	 <div class="layout_vertical_2"  style = "width: 37%">	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" id="mainTable" >
		<div class="opus_design_btn">		
				<button type="button" class="btn_normal" name="btn_RowAdd1" id="btn_RowAdd1">Row Add</button>
				<button type="button" class="btn_normal" name="btn_Delete1" id="btn_Delete1">Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div class="layout_vertical_2" align="center" style = "width: 3%">
	<div style="height: 150px;"></div>
	<button type="button" class="btn_right"></button>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="layout_vertical_2" style = "width: 60%">	
	<div class="opus_design_grid clear" id="mainTable" >
		<div class="opus_design_btn">		
				<button type="button" class="btn_normal" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button>
				<button type="button" class="btn_normal" name="btn_Delete2" id="btn_Delete2">Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	</div>
	</div>
	<!-- opus_design_grid(E) -->
<!-- </div> -->
</form>