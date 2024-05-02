<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1155.jsp
*@FileTitle  : Myanmar Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.event.EsmBkg1155Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1155Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String search_flg1 = "";
	String search_flg3 = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		String ofcCd = account.getOfc_cd();

		// Log-in ID 소속 Office 가 "MX" 인 경우 Default
		// 하동일 수석 가이드에 따라 조직코드의 앞 3자리가 MEX인 유저에 대해 로직을 적용함.
		if(ofcCd != null){
			if(ofcCd.substring(0, 3).equals("MEX")){
				search_flg1 = "checked";
			}
		}
		//Log-in ID 소속 Office 가 "MX" 가 아닌 경우 Default
		if( search_flg1.equals("")){
			search_flg3 = "checked";
		}

		event = (EsmBkg1155Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pageno" value="ESM_BKG_1155" id="pageno" />
<input type="hidden" name="frm_pol_cd" id="frm_pol_cd" />
<input type="hidden" name="frm_pod_cd" id="frm_pod_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent"  type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button class="btn_normal"  type="button" name="btn_down_excel" id="btn_Retrieve">Down Excel</button><!--
		--><button class="btn_normal"  type="button" name="btn_Transmit" id="btn_Transmit">EDI Transmit</button>
		<script type="text/javascript">ComComboObject('s_status', 1, 80, 1, 0, 0, true);</script>
	</div>
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
				<col width="90">
				<col width="120">
				<col width="60">
				<col width="60">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 80px; ime-mode:disabled;" class="input1" maxlength="9" value="" name="s_vvd" caption="VVD" dataformat="engup" required="" id="s_vvd" /></td>
					<th>
						<input type="radio" name="pol_gubun" value="1" class="trans" checked id="radio_pol_gubun1" /><label for="radio_pol_gubun1">POL</label>
						<input type="radio" name="pol_gubun" value="2" class="trans" id="radio_pol_gubun2" /><label for="radio_pol_gubun2">POD</label>
					</th>
					<td><input name="frm_port_cd" type="text" dataformat="engup" maxlength="5" style="ime-mode: disabled;width:50px;" class="input1" id="frm_port_cd" /></td>
					<th>B/L Total</th>
					<td>
						<input type="text" name="bl_tot_cnt" maxlength="5" style="width:50px;text-align:right" class="input2" dataformat="engup" value="" readonly="" id="bl_tot_cnt" />
					</td>
				</tr>
			</tbody>
		</table>
		<table>
				<colgroup>
					<col width="90">
					<col width="172">
					<col width="60">
					<col width="60">
					<col width="70">
					<col width="80">
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Vessel Name</th>
						<td><input type="text" name="vsl_nm" maxlength="100" style="width:150px;" class="input2" dataformat="engup" value="" id="vsl_nm" /></td>
						<th>Call Sign</th>
						<td><input type="text" name="vsl_callsign" maxlength="5" style="width:50px;" class="input2" dataformat="engup" value="" id="vsl_callsign" /></td>
						<th>ETD</th>
						<td><input type="text" name="etd" maxlength="10" style="width:80px;" class="input2" dataformat="engup" value="" id="etd" /></td>
						<th>ETA</th>
						<td><input type="text" name="eta" maxlength="10" style="width:80px;" class="input2" dataformat="engup" value="" id="eta" /></td>
					</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_data">
		<table class="grid2 wAuto">
			<colgroup>
				<col width="140">
				<col width="140">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th><strong>20'</strong></th>
					<th><strong>40'</strong></th>
					<th><strong>TOTAL</strong></th>
				</tr>
				<tr>
					<td><input type="text" name="tpsz_20_chk" style="width:100px; text-align: center" class="noinput" value="" readonly id="tpsz_20_chk" /> </td>
					<td><input type="text" name="tpsz_40_chk" style="width:100px; text-align: center" class="noinput" value="" readonly id="tpsz_40_chk" /> </td>
					<td><input type="text" name="tpsz_tot_chk" style="width:100px; text-align: center" class="noinput" value="" readonly id="tpsz_tot_chk" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</form>