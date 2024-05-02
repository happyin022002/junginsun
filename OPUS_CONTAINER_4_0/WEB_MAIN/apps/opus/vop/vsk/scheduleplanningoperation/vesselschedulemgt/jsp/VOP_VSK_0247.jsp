<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0247.jsp
*@FileTitle  : SHA Loadable weight 계산/조회
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0247Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0247Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");
	
	String vpsPortCd = "";
	String vslCd = "";
	String skdVoyNo = "";
	String skdDirCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0247Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vps_port_cd" id="vps_port_cd" />
<input type="hidden" name="clpt_ind_seq" id="clpt_ind_seq" />
<input type="hidden" name="call_ind_cd" id="call_ind_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="post_type" id="post_type" />
<input type="hidden" name="wgt_vsl_cd" id="wgt_vsl_cd" />
<input type="hidden" name="wgt_skd_voy_no" id="wgt_skd_voy_no" />
<input type="hidden" name="wgt_skd_dir_cd" id="wgt_skd_dir_cd" />
<input type="hidden" name="wgt_clpt_ind_seq" id="wgt_clpt_ind_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">SHA Loadable weight Calculation</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="30">
				<col width="100">
				<col width="90">
				<col width="100">
				<col width="90">
				<col width="100">
				<col width="110">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
						<th title="Vessel Voyage Direction">VVD</th>   
						<td><input type="text" name="vsl_cd" id="vsl_cd" style="width:45px;text-align:center;" class="input2" value="" readonly="readonly" maxlength="4"><!-- 
							 --><input type="text" name="skd_voy_no" id="skd_voy_no" style="width:45px;text-align:center;" class="input2" value="" readonly="readonly" maxlength="4"><!-- 
							 --><input type="text" name="skd_dir_cd" id="skd_dir_cd" style="width:20px;text-align:center;" class="input2" value="" readonly="readonly" maxlength="1">
						</td>
						<th>ETA Date</th>  
						<td><input type="text" name="vps_eta_dt" id="vps_eta_dt" style="width:115px;text-align:center;" class="input2" value="" readonly="readonly" maxlength=""></td>
						<th>ETD Date</th>  
						<td><input type="text" name="vps_etd_dt" id="vps_etd_dt" style="width:115px;text-align:center;" class="input2" value="" readonly="readonly" maxlength=""></td>
						<th>Call Indicator</th>
						<td><input type="text" name="call_ind_nm" id="call_ind_nm" style="width:60px;text-align:center;" class="input2" value="" readonly="readonly"></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
		<table>
			<colgroup>
				<col width="100">
				<col width="20">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th><input type="radio" name="rdo_tran" id="rdo_tran" value="" class="trans" checked="checked">&nbsp;ARRIVAL</th>
					<td></td>
					<th><input type="radio" name="rdo_tran" id="rdo_tran" value="" class="trans">&nbsp;DEPARTURE</th>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
		<h3 class="title_design" id="titleLayer">Calculation Cargo Weight for the ARR. Draft</h3>
	</div>
	<div class="opus_design_inquiry">
		<table class="grid_2">
			<tr>
				<th>Vessel Class</th>
				<td><input type="text" name="vsl_class" id="vsl_class" style="width:100%;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
				<th>Fuel Oil</th>
				<td><input type="text" name="fuel_oil" id="fuel_oil" style="width:100%;text-align:right;" class="noinput" value="" maxlength="10"></td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<th class="tr2_head">Light Ship</th>
				<td class="noinput2"><input type="text" name="light_ship" id="light_ship" style="width:100%;text-align:right;" class="noinput2" value="" readonly="readonly"></td>
				<th class="tr2_head">Diesel Oil</th>
				<td><input type="text" name="diesel_oil" id="diesel_oil" style="width:100%;text-align:right;" class="noinput" value="" maxlength="10"></td>
				<th>Draft(at FW)</th>
				<td><input type="text" name="draft" id="draft" style="width:100%;text-align:right;" class="noinput2" value="" readonly="readonly"></td>
			</tr>
			<tr>
				<th>TPC</th>
				<td><input type="text" name="tpc" id="tpc" style="width:100%;text-align:right;" class="noinput2" value="" readonly="readonly"></td>
				<th>Fresh Water</th>
				<td><input type="text" name="fresh_water" id="fresh_water" style="width:100%;text-align:right;" class="noinput" value="" maxlength="10"></td>
				<th>Cargo Weight</th>
				<td><input type="text" name="cargo_weight" id="cargo_weight" style="width:100%;text-align:right;color:red" class="noinput2" value="" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Constant</th>
				<td><input type="text" name="constant" id="constant" style="width:100%;text-align:right;" class="noinput1" value="" maxlength="10"></td>
				<th>Ballast</th>
				<td><input type="text" name="ballast" id="ballast" style="width:100%;text-align:right;" class="noinput" value="" maxlength="10"></td>
				<th>Displacement</th>
				<td><input type="text" name="displacement" id="displacement" style="width:100%;text-align:right;" class="noinput2" value="" readonly="readonly"></td>
			</tr>
		</table> 
		
	</div>
</div>

<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 10%">
			<div class="opus_design_inquiry wFit">
				<table  style="margin-top:25px">
					<tr>
						<th>Port</th>
						<td><script type="text/javascript">ComComboObject('wgt_port_cd', 3, 75, 1, 0, 1);</script></td>
					</tr>
				</table>
			</div>
		</div>
	     <!-- layout_vertical_2(E) -->
	     <!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 90%">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<div class="opus_design_btn"> 
					<button class="btn_normal" type="button" name="btn_calculaton" id="btn_calculaton">Calculation</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			<!-- opus_design_grid(E) -->
			</div>
		</div>
	     <!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>
</form>