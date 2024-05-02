<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0106.jsp
*@FileTitle  : Rate Creation - Commodity 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
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
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCRateGuideline");

	String svcScpCd = "";
	String glineSeq = "";
	String prcCustTpCd = "";
	String cmdtHrdSeq = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		svcScpCd = request.getParameter("svc_scp_cd");
		glineSeq = request.getParameter("gline_seq");
		prcCustTpCd = request.getParameter("prc_cust_tp_cd");
		cmdtHrdSeq = request.getParameter("cmdt_hdr_seq");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Rate Creation - Commodity</title>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="cd" value="" id="cd" />
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(svcScpCd)%>" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(glineSeq)%>" id="gline_seq" />
<input type="hidden" name="prc_cust_tp_cd" value="<%=StringUtil.xssFilter(prcCustTpCd)%>" id="prc_cust_tp_cd" />
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(cmdtHrdSeq)%>" id="cmdt_hdr_seq" />
<input type="hidden" name="isEditable" value="<%=StringUtil.xssFilter(request.getParameter("isEditable")) %>" id="isEditable" />

 <div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Rate Creation - Commodity</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Ok" id="btn_Ok" type="button">OK</button>
			<button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" id="btn_RowAdd" type="button" name="btn_RowAdd">Row Add</button>
				<button class="btn_accent" name="btn_RowDel" id="btn_RowDel" type="button">Row Delete</button>
			</div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>