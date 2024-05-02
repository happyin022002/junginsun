<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0064.jsp
 *@FileTitle : B/L List For Inward Foreign Cargo Manifest(V 3.00)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/29
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String cnt_cd = "";//국가코드
	String vvd_cd = JSPUtil.getNull(request.getParameter("vvd_cd"));
	String mode_type = JSPUtil.getNull(request.getParameter("mode_type"));
	String pol_cd = JSPUtil.getNull(request.getParameter("pol_cd"));
	String pod_cd = JSPUtil.getNull(request.getParameter("pod_cd"));
	String cargo_type = JSPUtil.getNull(request.getParameter("cargo_type"));
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt");

	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home !=null) fileDir.append(home);

	String separator = System.getProperty("file.separator");
	if (separator !=null) fileDir.append(separator);

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cnt_cd    = account.getCnt_cd();

		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;" target="if_print">
<input type="hidden" name="f_cmd">
<input type="hidden" name="vvd_cd" value="<%=vvd_cd%>">
<input type="hidden" name="bkg_no" value="">
<input type="hidden" name="mode_type" value="<%=mode_type%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="cargo_type" value="<%=cargo_type%>">
<input type="hidden" name="cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="bl_face_prn_dvc_nm" value="">
<input type="hidden" name="bl_ridr_prn_dvc_nm" value="">
<input type="hidden" name="ch_usr_id">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;General Cargo Manifest Print Setup</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
			<button type="button" class="btn_normal" name="btn_preview" id="btn_preview">Print Preview</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<!-- popup_contens_area(S) -->
	<div class="opus_design_inquiry">
		<table class="search" border="0" width="100%" id="mainTable">
			<tr>
				<th width="70px" class="align_left">&nbsp;&nbsp;Type</th>
				<td width="*" class="stm">
					<input type="radio" name="paper_type" value="1"	class="trans" checked>&nbsp;A4&nbsp;&nbsp;&nbsp;
					<input type="radio" name="paper_type" value="4" class="trans">&nbsp;Letter&nbsp;&nbsp;&nbsp;
					<input type="radio" name="paper_type" value="10" class="trans">&nbsp;DOT&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<th width="90px" class="align_left">&nbsp;&nbsp;Print Form</th>
				<td><%=JSPUtil.getCodeCombo("print_form", "", " style='width:70;'", "CD20094", 0, "")%>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="hbl_flag" value="1" checked>House B/L Print</td>
			</tr>
		</table>
	</div>
	<!-- inquiry_area(E) -->

	<!-- opus_design_grid(E) -->
	<div style="z-index: 1;width:1px;height:1px;left:1px;top:1px; position:absolute">
		<script type="text/javascript">rdViewerObject();</script>
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>
