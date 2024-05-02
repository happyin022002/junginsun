﻿<%--
/*========================================================= 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0028.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	String strCntCd			= "";
	String strCustoms		= "";
	String strPgmNo = request.getParameter("pgmNo");
	if ("ESM_BKG_0028_1".equals(strPgmNo) || "ESM_BKG_0028_2".equals(strPgmNo)) {
		strCustoms = strPgmNo.endsWith("_1") ? "Origin" : "US";
		strCntCd = "US";
	} else {
		strCustoms = strPgmNo.endsWith("_3") ? "Origin" : "CA";
		strCntCd = "CA";
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

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="customs" value="<%=strCustoms%>" id="customs" />
<input type="hidden" name="cnt_cd" value="<%=strCntCd%>" id="cnt_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_StartAI" id="btn_StartAI">Start AI</button><!--
		 --><button type="button" class="btn_normal" name="btn_DeleteAI" id="btn_DeleteAI">Immediate Delete & AI</button><!--
		 --><button type="button" class="btn_normal" name="btn_Modify" id="btn_Modify">Modify</button><!--
		 --><button type="button" class="btn_normal" name="btn_BlInquiry" id="btn_BlInquiry">Manifest(B/L)</button><!--
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		 --><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button><!--
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table style="width:670px;">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th class="sm" style="text-align:left; padding-left:15px;" height="30px"><input type="radio" name="ai_div" id="ai_div" value="GEN" class="trans" checked>&nbsp;&nbsp;General AI</th>
					<th class="sm">AI Type</th>
					<td class="sm"><%=JSPUtil.getCodeCombo("ai_type", "", "style='width:70px;'", "CD20040", 0, "")%>
						<script>
						ComAddBeginComboItem(document.form.ai_type, "All", "");
						//document.getElementById('ai_type').innerHTML = ('<option value="">All</option>');
						form.ai_type.options[0].selected = true;
						</script></td>
					<td width="50px"></td>
					<th class="sm" style="text-align:left; padding-left:15px;"><input type="radio" name="ai_div" id="ai_div" value="DEL" class="trans">&nbsp;&nbsp;Immediate Delete & AI</th>
					<th class="sm">Status</th>
					<td class="sm">
						<select style="width:70px;" class="input" name="sts_div" id="sts_div" disabled>
							<option value="A" selected>Active</option>
							<option value="D">Delete</option>
						</select></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:90px;ime-mode:disabled" class="input1" name="vvd_cd" dataformat="engup" maxlength="9" minlength="9" caption="VVD"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;ime-mode:disabled" class="input" name="pol_cd" dataformat="engup" maxlength="5" minlength="5" caption="POL"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px;ime-mode:disabled" class="input" name="pod_cd" dataformat="engup" maxlength="5" minlength="5" caption="POD"></td>
					<th><input type="checkbox" name="snd_dt_flg" class="trans" value="true" id="snd_dt_flg" />&nbsp;Send Date</th>
					<td colspan="3">
						<input type="text" style="width:90px;ime-mode:disabled" class="input" maxlength="10" dataformat="ymd" name="s_snd_dt" caption="Send Date" cofield="e_snd_dt" id="s_snd_dt" /><!--
						 -->~ <!--
						 --><input type="text" style="width:90px;ime-mode:disabled" class="input" maxlength="10" dataformat="ymd" name="e_snd_dt" caption="Send Date" cofield="s_snd_dt" id="e_snd_dt" /><!--
						 --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
					<td></td>
					<td></td>
					<th class="sm" id="hub_area" style="visibility:hidden">
						<table style="width:277px;">
							<tr>
								<th align="right" style="width:35px;">HUB</th>
								<td align="left"><input type="text" style="width:60px;ime-mode:disabled" class="input" name="hub_loc_cd" dataformat="engup" maxlength="5"></td>
								<td align="right"><button type="button" class="btn_etc" style="width:60px;" name="btn2_edit" id="btn2_edit">Edit</button></td>
							</tr>
						</table></th>
				</tr>
				<tr>
					<th>Cargo Type</th>
					<td><%=JSPUtil.getCodeCombo("full_mty_cd", "", "style='width:60;'", "CD00748", 0, "")%>
						<script>
						ComAddBeginComboItem(form.full_mty_cd,"All","")
						form.full_mty_cd.options[0].selected = true;
						</script></td>
					<th>B/OFC</th>
					<td><input type="text" style="width:60px;ime-mode:disabled" class="input" name="bkg_ofc_cd" dataformat="enguponly" maxlength="6" caption="B/OFC"></td>
					<th>B/Staff</th>
					<td><input type="text" style="width:90px;ime-mode:disabled" class="input"  name="doc_usr_id" dataformat="engup" maxlength="20" caption="B/Staff"></td>
					<th>L/Rep.</th>
					<td><input type="text" style="width:60px;ime-mode:disabled" class="input" name="ob_srep_cd" dataformat="engup" maxlength="5" caption="L/Rep."></td>
					<th>Booking No.</th>
					<td><input type="text" style="width:100px;ime-mode:disabled" class="input" name="bkg_no" dataformat="engup" maxlength="13" minlength="11" caption="Booking No."></td>
					<th>M.B/L No.</th>
					<td><input type="text" style="width:100px;ime-mode:disabled" class="input" name="mbl_no" dataformat="engup" maxlength="12"></td>
					<th class="sm" id="locGood_area" style="visibility:hidden">
						<table>
							<tr>
								<th align="right">Location of Goods</th>
								<td align="left"><input type="text" style="width:150px;ime-mode:disabled" class="input" name="ibd_loc_gds_desc" maxlength="100"></td>
							</tr>
						</table></th>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
	<div class="opus_design_inquiry" style="padding-bottom:10px;">
		<input type="text" style="width:500px;" class="input3" name="action_desc"  readonly id="action_desc" />
	</div>
</div>
</form>
