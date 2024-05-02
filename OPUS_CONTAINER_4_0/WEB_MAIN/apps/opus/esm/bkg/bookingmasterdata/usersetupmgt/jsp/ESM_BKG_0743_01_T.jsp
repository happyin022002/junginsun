<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0743_01.jsp
*@FileTitle  :  B/L Print Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0743Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	EsmBkg0743Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	boolean bBtn_Disabled = true;

	String bkg_no = "";
	String form_manifest = "";
	String form_hiddeData = "";
	String cnt_cd = "";

	String form_remark = ""; //  Remark value of Draft B/L

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		cnt_cd = account.getCnt_cd();

		event = (EsmBkg0743Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkg_no = StringUtil.xssFilter(request.getParameter("bkg_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("bkg_no"));

		form_manifest = StringUtil.xssFilter(request.getParameter("form_manifest")) == null ? "N" : StringUtil.xssFilter(request.getParameter("form_manifest"));

		form_hiddeData = StringUtil.xssFilter(request.getParameter("form_hiddeData")) == null ? "N" : StringUtil.xssFilter(request.getParameter("form_hiddeData"));

		form_remark = StringUtil.xssFilter(request.getParameter("form_remark")) == null ? "" : StringUtil.xssFilter(request.getParameter("form_remark"));

		/*
		out.println("########################################<br>");
		out.println("<br>");
		out.println("bkg_no : [" + bkg_no + "]<br>");
		out.println("form_manifest : [" + form_manifest + "]<br>");
		out.println("form_hiddeData : [" + form_hiddeData + "]<br>");
		out.println("form_remark : [" + form_remark + "]<br>");
		out.println("<br>");
		out.println("########################################");
		*/

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/opuscntr/rpt/script/rdviewer50.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<style type="text/css">
	.specialCase {
		background-position: -151px -34px !important;
		padding: 5px 10px 5px !important;
		width: 25px !important;
		height: 25px !important;
	}
</style>
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" name="p_bkg_no" value="<%=bkg_no%>" id="p_bkg_no" />
	<input type="hidden" name="bkg_no" value="" id="bkg_no" />
	<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
	<input type="hidden" name="upd_usr_id" value="<%=strUsr_id%>" id="upd_usr_id" />
	<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>" id="ofc_cd" />
	<input type="hidden" name="bl_prn_dvc_nm" value="" id="bl_prn_dvc_nm" />
	<input type="hidden" name="obl_rlse_flg" value="" id="obl_rlse_flg" />
	<input type="hidden" name="corr_no" value="" id="corr_no" />
	<input type="hidden" name="form_manifest" value="<%=form_manifest%>" id="form_manifest" />
	<input type="hidden" name="form_remark" value="<%=form_remark%>" id="form_remark" />
	<div class="layer_title clear">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>B/L Print Option</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
					<button type="button" 		class="btn_accent" name="btn_Print" id="btn_Print">Print</button><!--
				 --><button type="button" 	    class="btn_normal"  name="btn_Print_Release" id="btn_Print_Release">Print & Release</button><!--
				 --><button type="button" 		class="btn_normal" name="btn_save" id="btn_save">Save Print Setup</button><!--
				 --><button type="button" 		class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<div class="layout_wrap">
		<div class="layout_vertical_2 pad_rgt_8">
			<div class="wrap_search">
				<div class="opus_design_inquiry">
					<table id="mainTable"  class="mar_btm_12">
						<tbody>
							<colgroup>
								<col width="40">
								<col width="100">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th class="sm">Type</th>
									<td class="sm">
										<input type="radio" name="paper_type" id="paper_type1" value="1"	class="trans pad_rgt_8" checked><label for="paper_type1">A4</label>
										<input type="radio" name="paper_type"  id="paper_type2" value="4" class="trans pad_rgt_8" ><label for="paper_type2">Letter</label>
										<input type="radio" name="paper_type"  id="paper_type3" value="10" class="trans" disabled><label for="paper_type3">DOT</label>
									</td>
									<td></td>
								</tr>
							</tbody>
					</table>
					<table class="mar_btm_12">
						<tbody>
							<colgroup>
								<col width="70">
								<col width="120">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<td><input type="checkbox" value="Y" name="preview_yn" id="preview_yn" class="trans pad_rgt_8" checked><label for="preview_yn">Preview</label></td>
									<td><input type="checkbox" value="Y" name="hiddenData" id="hiddenData" class="trans" <% if (form_hiddeData.equals("Y")) {%>checked<%}%>><label for="hiddenData">Display Hidden Data</label></td>
									<td></td>
								</tr>
								<tr style="display:none">
									<th><input type="checkbox" value="Y" name="rider_only_yn" id="rider_only_yn" class="trans pad_rgt_8"><label for="rider_only_yn">Rider Only</label></th>
									<td><input type="checkbox" value="Y" name="nvocc_only_yn" id="nvocc_only_yn" class="trans pad_rgt_8"><label for="nvocc_only_yn">NVOCC H/BL only</label></td>
									<td><input type="checkbox" value="Y" name="rider_nvocc_yn" id="rider_nvocc_yn" class="trans"><label for="rider_nvocc_yn">Rider + NVOCC H/BL</label></td>
								</tr>
						</tbody>
					</table>
					<table class="grid2">
						<tbody>
							<colgroup>
								<col width="120">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th><strong>B/L Type</strong></th>
									<td>
										<script type="text/javascript">ComComboObject('form_type', 1, 202, true, '');</script>
									</td>
								</tr>
								<tr>
									<th><strong>Charge Type</strong></th>
									<td>
										<script type="text/javascript">ComComboObject('form_Rate', 1, 202, true, '');</script>
									</td>
								</tr>
								<tr>
									<th><strong>Container Type</strong></th>
									<td>
										<script type="text/javascript">ComComboObject('form_Cntr', 1, 202, true, '');</script>
									</td>
								</tr>
								<tr>
									<th><strong>Print Setup (Face)</strong></th>
									<td>
										<script type="text/javascript">ComComboObject('bl_face_prn_dvc_nm', 1, 200, '');</script><!--
										 --><button class="input_seach_btn specialCase" type="button"  name="btn_Print_Setup" id="btn_Print_Setup"></button><!--
										 --><%=JSPUtil.getCodeCombo("face_print_cnt", "", "", "CD20057", 0, "")%>
									</td>

								</tr>
								<tr>
									<th><strong>Print Setup (Rider)</strong></th>
									<td>
										<script type="text/javascript">ComComboObject('bl_ridr_prn_dvc_nm', 1, 200, '');</script><!--
										 --><button class="input_seach_btn specialCase" type="button" name="btn_Print_Setup"  id="btn_Print_Setup"></button><!--
										 --><%=JSPUtil.getCodeCombo("rider_print_cnt", "", "", "CD20057", 0, "")%>
									</td>
								</tr>
							</tbody>
						</table>
						<table  style="display:none">
							<colgroup>
								<col width="120">
								<col width="120">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th><input type="checkbox" value="Y"	name="bl_ca_yn" id="bl_ca_yn" class="trans">&nbsp;B/L before C/A</th>
									<th>C/A No.&nbsp;<script type="text/javascript">ComComboObject('ca_no', 1, 120, true, '');</script></th>
									<td></td>
								</tr>
							</tbody>
						</table>
				</div>
			</div>
		</div>

		<div class="layout_vertical_2">
			<div class="wrap_result">
				<div class="opus_design_grid"  id="mainTable">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
					<div class="opus_design_data">
						<table class="grid2">
							<colgroup>
								<col width="90">
								<col width="100">
								<col width="120">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th><b>Result</b></th>
									<td>Total: <span id="div_total"></span></td>
									<td>Success: <span id="div_success">0</span></td>
									<td>Failure: <span id="div_failure">0</span></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<div class="opus_design_grid">
					<table>
						<tr>
							<td>
							<script type="text/javascript">comRdObject('report1');</script>
							</td>
						</tr>
						<tr>
							<td>
							<script type="text/javascript">comRdObject('report2');</script>
							</td>
						</tr>
						<tr>
							<td>
							<script type="text/javascript">comRdObject('report3');</script>
							</td>
						</tr>
						<tr>
							<td>
							<script type="text/javascript">comRdObject('report4');</script>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</form>
<div style="width:1px;height:1px">
	<script type="text/javascript">
	comRdObjectPopup("Rdviewer");
	</script>
</div>
<%@include file="/bizcommon/include/common_opus.jsp"%>