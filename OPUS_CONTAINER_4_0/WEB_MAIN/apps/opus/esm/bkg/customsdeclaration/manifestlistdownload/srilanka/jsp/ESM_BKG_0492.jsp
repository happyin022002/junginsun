<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0492.jsp
*@FileTitle : Sri Lanka Customs Manifest_Customs Response
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%

	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sr_sts_cd    	= "";
	String vsl_auth_no		= "";
	String rgst_dt			= "";
	String rjct_dt			= "";
	String decl_bl_qty	    = "";
	String sr_sts_desc 		= "";
	String sr_cmt_desc		= "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		sr_sts_cd = JSPUtil.getParameter(request, "sr_sts_cd");
		vsl_auth_no = JSPUtil.getParameter(request, "vsl_auth_no");
		rgst_dt = JSPUtil.getParameter(request, "rgst_dt");
		rjct_dt = JSPUtil.getParameter(request, "rjct_dt");
		decl_bl_qty = JSPUtil.getParameter(request, "decl_bl_qty");
		sr_sts_desc = JSPUtil.getParameter(request, "sr_sts_desc");
		sr_cmt_desc = JSPUtil.getParameter(request, "sr_cmt_desc");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


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

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pgNo">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="sr_sts_cd">
<input type="hidden" name="rgst_dt">
<input type="hidden" name="rjct_dt">
<input type="hidden" name="vsl_auth_no">
<input type="hidden" name="sr_sts_desc">
<input type="hidden" name="sr_cmt_desc">
<input type="hidden" name="decl_bl_qty">
<!-- 개발자 작업	-->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Sri Lanka Customs Manifest_Customs Response</span></h2>
		<!-- page_title(E) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="opus_design_inquiry">
		<table class="search" border="0">
			<tr><td class="title_h"></td>
			<td class="title_s">View  Sri  Lanka  Customs  Response</td></tr>
			<tr><td class="height_5"></td></tr>
		</table>

		<table class="search" border="0" style="width:100%;">
			<tr class="h23">
				<td width="130px">Status</td>
				<td><input type="text" style="width:230px;" class="input" value="<%=sr_sts_cd%>" readonly></td></tr>
			<tr class="h23">
				<td>Vessel Auth No.</td>
				<td><input type="text" style="width:230px;" class="input" value="<%=vsl_auth_no%>" readonly></td></tr>
			<tr class="h23">
				<td>Registered Date</td>
				<td><input type="text" style="width:230px;" class="input" value="<%=rgst_dt%>" readonly></td></tr>
			<tr class="h23">
				<td>Rejected Date</td>
				<td><input type="text" style="width:230px;" class="input" value="<%=rjct_dt%>" readonly></td></tr>
			<tr class="h23">
				<td>B/L Count</td>
				<td><input type="text" style="width:80px; text-align:right;" class="input" value="<%=decl_bl_qty%>" readonly></td></tr>
			<tr><td colspan="2" height="8"></td></tr>
			<tr class="h23">
				<td>Status Description</td>
				<td><textarea style="width:230px; height:50px;" readonly><%=sr_sts_desc%></textarea></td></tr>
			<tr class="h23">
				<td>Comment</td>
				<td><textarea style="width:230px; height:50px;" readonly><%=sr_cmt_desc%></textarea></td></tr>
		</table>
	</div>
</div>
</form>
