<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0300.jsp
*@FileTitle : ESM_BKG_0300
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0296Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vvdCd = (request.getParameter("vvd_cd") == null) ? "" : request.getParameter("vvd_cd");
		polCd = (request.getParameter("pol_cd") == null) ? "" : request.getParameter("pol_cd");
		podCd = (request.getParameter("pod_cd") == null) ? "" : request.getParameter("pod_cd");

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

<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Manifest Generation _ Form Setting</span></h2>

		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class=" " border="0" style="width:100%;">
				<tr class="h23">
					<th width="120">Office</th>
					<td style="padding-left:1;">
						<input type="text" style="width:80px;" class="input" name="ofc_cd" value="<%=strOfc_cd%>"
							required dataformat="engup" maxlength="6" caption="Office">
					</td>
				</tr>
				<tr class="line_bluedot"><td colspan="2"></td></tr>
				<tr class="h23">
					<th>Agent</th>
					<td><textarea style="width:99%; height:50px;" name="form1_hdr_ctnt"></textarea></td>
				</tr>
				<tr class="h23">
					<th>Footer</th>
					<td><textarea style="width:99%; height:50px;" name="form1_ftr_ctnt"></textarea></td>
				</tr>
				<tr class="h23">
					<th>TP Permit Address</th>
					<td><textarea style="width:99%; height:50px;" name="form1_decl_addr"></textarea></td>
				</tr>
				<tr class="h23">
					<th>TP Body</th>
					<td><textarea style="width:99%; height:50px;" name="form1_bod_ctnt"></textarea></td>
				</tr>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid" style="display:none;">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>
