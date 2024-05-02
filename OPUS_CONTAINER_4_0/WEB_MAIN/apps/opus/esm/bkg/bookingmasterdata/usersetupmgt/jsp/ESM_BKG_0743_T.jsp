<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0743.jsp
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
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	boolean bBtn_Disabled = true;

	String bkg_no = "";
	String bl_no  = "";
	String form_manifest = "";
	String form_hiddeData = "";
	String cnt_cd = "";

	String form_remark = "";

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

		//  If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkg_no = StringUtil.xssFilter(request.getParameter("bkg_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("bkg_no"));
		bl_no = StringUtil.xssFilter(request.getParameter("bl_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("bl_no"));

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
<div id="debug"></div>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
<input type="hidden" name="bl_no" value="<%=bl_no%>" id="bl_no" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="upd_usr_id" value="<%=strUsr_id%>" id="upd_usr_id" />
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>" id="ofc_cd" />
<input type="hidden" name="bl_prn_dvc_nm" value="" id="bl_prn_dvc_nm" />
<input type="hidden" name="obl_rlse_flg" value="" id="obl_rlse_flg" />

<input type="hidden" name="corr_no" value="" id="corr_no" />
<input type="hidden" name="form_manifest" value="<%=form_manifest%>" id="form_manifest" />
<input type="hidden" name="form_remark" value="<%=form_remark%>" id="form_remark" />
<input type="hidden" name="bl_knt_flg" id="bl_knt_flg" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>B/L Print Option</span></h2>

		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_Print" id="http://localhost:7001/opuscntr/ESM_BKG_0743.do?bkg_no=AME300005600&form_manifest=N&form_hiddeData=&form_remark=" type="button">Print</button><!--
			--><button class="btn_normal" name="btn_Print_Release" id="btn_Print_Release" type="button">Print & Release</button><!--
			--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save Print Setup</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table class="search_sm2">
				<tbody>
					<colgroup>
						<col width="70">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th class="sm" style="text-align:left;">Type</th>
						<td class="sm">
							<input type="radio" name="paper_type" value="1"	class="trans" checked>&nbsp;A4&nbsp;&nbsp;&nbsp;
							<input type="radio" name="paper_type" value="4" class="trans" >&nbsp;Letter&nbsp;&nbsp;&nbsp;
							<input type="radio" name="paper_type" value="10" class="trans" disabled>&nbsp;DOT&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="90">
						<col width="120">
						<col width="150">
						<col width="70">
						<col width="*">
					</colgroup>
					<tr>
						<td width="90"><input type="checkbox" value="Y" name="preview_yn" class="trans" checked>&nbsp;Preview</td>
						<td style="text-align:left;"><input type="checkbox" value="Y" name="hiddenData" class="trans" <% if (form_hiddeData.equals("Y")) {%>checked<%}%>>&nbsp;Display Hidden Data</td>
					</tr>
					<tr>
						<td><input type="checkbox" value="Y" name="rider_only_yn" class="trans">&nbsp;Rider Only</td>
						<td><input type="checkbox" value="Y" name="nvocc_only_yn" class="trans">&nbsp;NVOCC H/BL only</td>
						<td style="text-align:left;"><input type="checkbox" value="Y" name="rider_nvocc_yn" class="trans">&nbsp;Rider + NVOCC H/BL</td>
						<td style="text-align:left;"><input type="checkbox" value="" name="signed_yn" class="trans">&nbsp;Signed</td>
						<td style="text-align:left;"><input type="checkbox" value="" name="copy_signed_yn" class="trans">&nbsp;Signed Copy</td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<tbody>
					<colgroup>
						<col width="90">
						<col width="250">
						<col width="20">
						<col width="*">
					</colgroup>
					<tr>
						<th class="tr2_head" style="text-align:center;"><strong>B/L Type</strong></th>
						<td colspan="3" class="input"><script type="text/javascript">ComComboObject('form_type', 1, 202, 1, 0);</script></td>
					</tr>
					<tr><th class="tr2_head" style="text-align:center;"><strong>Charge Type</strong></th>
						<td colspan="3" class="input"><script type="text/javascript">ComComboObject('form_Rate', 1, 202, 1, 0);</script></td>
					</tr>
					<tr>
						<th class="tr2_head" style="text-align:center;"><strong>Container Type</strong></th>
						<td colspan="3" class="input"><script type="text/javascript">ComComboObject('form_Cntr', 1, 202, 1, 0);</script></td>
					</tr>
					<tr>
						<th class="tr2_head" nowrap style="text-align:center;"><strong>Print Setup (Face)</strong></th>
						<td class="input" style="padding-left:5px" nowrap><script type="text/javascript">ComComboObject('bl_face_prn_dvc_nm', 1, 200, '');</script><!--
							--><!-- chrme 기능 오류로 인하여 임시 삭제 <button type="button" class="input_seach_btn" name="btn_Print_Setup" id="btn_Print_Setup"></button> -->
						</td>
						<td class="input"><%=JSPUtil.getCodeCombo("face_print_cnt", "", "", "CD20057", 0, "")%></td>
						<td class="input"><input type="text" id="bl_cpy_no" name="bl_cpy_no" style="width: 30px;" readonly/></td>
					</tr>
					<tr><th class="tr2_head" nowrap style="text-align:center;"><strong>Print Setup (Rider)</strong></th>
						<td class="input" style="padding-left:5px" nowrap><script type="text/javascript">ComComboObject('bl_ridr_prn_dvc_nm', 1, 200, '');</script><!--
							--><!-- chrme 기능 오류로 인하여 임시 삭제 <button type="button" class="input_seach_btn" name="btn_Print_Setup1" id="btn_Print_Setup1"></button> -->
						</td>
						<td class="input" colspan="2"><%=JSPUtil.getCodeCombo("rider_print_cnt", "", "", "CD20057", 0, "")%></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="150">
						<col width="*">
					</colgroup>
					<tr>
						<td class="stm"><input type="checkbox" value="Y"	name="bl_ca_yn" class="trans">&nbsp;B/L before C/A</td>
						<td>C/A No&nbsp;<script type="text/javascript">ComComboObject('ca_no', 1, 120, true, '');</script></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
<div  style="width:0px;height:0px"><script language="javascript">comRdObject('report1');</script></div>
<div  style="width:0px;height:0px"><script language="javascript">comRdObject('report2');</script></div>
<div  style="width:0px;height:0px"><script language="javascript">comRdObject('report3');</script></div>
<div  style="width:0px;height:0px"><script language="javascript">comRdObject('report4');</script></div>
</form>
<div style="display:none"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
<div style="width:0px;height:0px"><script type="text/javascript">comRdObjectPopup("Rdviewer");</script></div>
<%@include file="/bizcommon/include/common_opus.jsp"%>

