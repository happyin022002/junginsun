<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0470.jsp
*@FileTitle  : ESM_BKG-0470
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0470Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0470Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	//int rowCount = 0; //count of DB resultSET list

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no= "";
	String vvd_cd= "";
	String pod_cd= "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		bl_no= request.getParameter("bl_no")==null?"":request.getParameter("bl_no");
		vvd_cd= request.getParameter("vvd_cd")==null?"":request.getParameter("vvd_cd");
		pod_cd= request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");

		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0470Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="in_vvd_cd" id="in_vvd_cd" />
<input type="hidden" name="in_pod_cd" id="in_pod_cd" />
<input type="hidden" name="in_pod_cd_split" id="in_pod_cd_split" />
<input type="hidden" name="form1_eta_dt2" id="form1_eta_dt2" />
<input type="hidden" name="form1_etb_dt1" id="form1_etb_dt1" />
<input type="hidden" name="form1_etb_dt2" id="form1_etb_dt2" />
<input type="hidden" name="form1_arr_yd_cd" id="form1_arr_yd_cd" />
<input type="hidden" name="form1_lodg_wgt" id="form1_lodg_wgt" />
<input type="hidden" name="form1_cstms_mf_cd" id="form1_cstms_mf_cd" />
<input type="hidden" name="form1_in_joint_flg" id="form1_in_joint_flg" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_transmit" id="btn_transmit" type="button">Transmit</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />
				<col width="120" />
				<col width="70" />
				<col width="150" />
				<col width="70" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px;" name="form1_in_vvd_cd" dataformat="engup" maxlength="9" class="input1" id="form1_in_vvd_cd" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px;" name="form1_in_pod_cd" class="input1" dataformat="engup" maxlength="5" id="form1_in_pod_cd" /><!--
					--><input type="text" style="width:30px;" name="form1_in_pod_cd_split" maxlength="2" dataformat="engup" class="input" id="form1_in_pod_cd_split" /></td>
					<th title="Joint Operation Flag">Joint Flag</th>
					<td><input type="checkbox" name="in_joint_flg" class="trans" value="J" id="in_joint_flg" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>ETA</th>
					<td colspan="3"><input type="text" style="width:75px;text-align:center;" name="form1_eta_dt1" dataformat="ymd" class="input" maxlength="8" id="form1_eta_dt1" caption="ETA" /><!--
						--><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
				</tr>
				<tr>
					<th>Remark(s)</th>
					<td colspan="3"><input type="text" style="width:500px;" name="form1_mf_rmk" class="input" maxlength="4000" id="form1_mf_rmk" onkeyup="document.form.form1_mf_rmk.value = document.form.form1_mf_rmk.value.toUpperCase();"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>