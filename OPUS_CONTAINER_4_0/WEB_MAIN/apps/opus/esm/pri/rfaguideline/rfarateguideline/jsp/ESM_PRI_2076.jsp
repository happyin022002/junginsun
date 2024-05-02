<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2076.jsp
*@FileTitle  : RFA Guideline Creation - Rate(Commodity)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAGuideline.RFARateGuideline");
	
	String svcScpCd = "";
	String glineSeq = "";
	String cmdtHrdSeq = "";
	//String cmdtSeq = "";

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		svcScpCd = request.getParameter("svc_scp_cd");
		glineSeq = request.getParameter("gline_seq");
		cmdtHrdSeq = request.getParameter("cmdt_hdr_seq");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="cd" value="">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(svcScpCd)%>" >
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(glineSeq)%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(cmdtHrdSeq)%>">
<input type="hidden" name="isEditable" value="<%=StringUtil.xssFilter(request.getParameter("isEditable"))%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>RFA Guideline Creation - Rate(Commodity)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid">
			<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
				<button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>
			</div>
			<!-- opus_grid_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>