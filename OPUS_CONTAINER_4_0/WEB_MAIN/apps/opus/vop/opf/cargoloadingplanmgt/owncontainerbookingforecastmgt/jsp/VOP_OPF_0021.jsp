<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0021.jsp
*@FileTitle  : Own Container Booking Forecast Management 
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/06/19
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.syscommon.common.table.VskCarrierVO"%>

<%
	VopOpf0021Event event = null; 		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//error from server
	String strErrMsg = ""; 				//error message
	int rowCount = 0; 					//count of DB resultSET list
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	//Combo String
	StringBuffer vslOprComboItem = new StringBuffer();
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopOpf0021Event) request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="head_opr_list" name="head_opr_list" value="" type="hidden" />
<input id="st_1" name="st_1" type="hidden" />
<input id="st_2" name="st_2" type="hidden" />
<input id="st_3" name="st_3" type="hidden" />
<input id="st_4" name="st_4" type="hidden" />
<input id="st_5" name="st_5" type="hidden" />
<input id="st_6" name="st_6" type="hidden" />
<input id="st_7" name="st_7" type="hidden" />
<input id="st_8" name="st_8" type="hidden" />
<input id="st_9" name="st_9" type="hidden" />
<input id="st_10" name="st_10" type="hidden" />
<input id="st_11" name="st_11" type="hidden" />
<input id="st_12" name="st_12" type="hidden" />
<input id="st_13" name="st_13" type="hidden" />
<input id="st_14" name="st_14" type="hidden" />
<input id="st_15" name="st_15" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_New" name="btn_New" class="btn_normal">New</button><!--
		--><button type="button" id="btn_WeightGroup" name="btn_WeightGroup" class="btn_normal">Weight Group(Inquiry)</button><!--
		--><button type="button" id="btn_Print" name="btn_Print" class="btn_normal">Print</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry it">
		<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="30" />
					<col width="300" />
					<col width="50" />
					<col width="350" />
					<col width="50" />
					<col width="120" />
					<col width="65" />
					<col width="120" />
					<col width="*" />
				</colgroup>
				<tr class="h23">
					<td></td>
					<th>VVD CD</th>
					<td><input id="vsl_cd" name="vsl_cd" required="" fullfill="" style="width:55px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="engup" type="text" /><input id="skd_voy_no" name="skd_voy_no" required="" fullfill="" style="width: 40px;" class="input1" value="" caption="VVD CD" maxlength="4" dataformat="num" type="text" /><input id="skd_dir_cd" name="skd_dir_cd" required="" fullfill="" style="width: 20px;" class="input1" value="" caption="VVD CD" maxlength="1" dataformat="enguponly" type="text" /><button class="input_seach_btn" name="btn_vvd" id="btn_vvd" type="button"></button><input id="vsl_eng_nm" name="vsl_eng_nm" style="width: 130px;" class="input2" value="" readonly type="text" /></td>
					<th title="Port of Loading">POL</th>
					<td width="340"><script type="text/javascript">ComComboObject('yd_cd', 1, 80, 1, 1);</script><input type="text" style="width: 80;" class="input2" name="loc_nm" readOnly><input type="text" style="width: 150px;"	class="input2" name="yd_nm" readOnly></td>
					<th>ETA</th>
					<td><input id="eta" style="width: 110px;" class="input2" name="eta" readonly type="text" /></td>
					<th>CBF</th>
					<td><input id="cbf_ind_flg" style="width: 100px;" class="input2" name="cbf_ind_flg" readonly type="text" /> </td>
					<td></td>
				</tr>
				<tr class="h23">
					<td></td>
					<th>Lane</th>
					<td><input id="slan_cd" name="slan_cd" style="width: 40px;" class="input2" value="" readonly type="text" /><input id="slan_nm" name="slan_nm" style="width: 227px;" class="input2" value="" readonly type="text" /> </td>
					<th>Booking Status</th>
					<td><input id="cbf_bkg_sts_cd" style="width: 80px;" class="input2" name="cbf_bkg_sts_cd" readonly type="text" /><strong style="padding-left:26px;">Last Created</strong> <input id="upd_usr_id" style="width: 67px;text-align:center;" class="input2" name="upd_usr_id" readonly type="text" /><input id="upd_dt" style="width: 120px;" class="input2" name="upd_dt" readonly type="text" /></td>
					<th></th> 
					<td></td>
					<td></td>
					<td><button type="button" class="btn_etc" id="btn_BookingClosingStatus" name="btn_BookingClosingStatus" >Booking Closing Status</button></td>
					<td></td>
				</tr>
			</tbody>
		</table>

		<table>
			<tbody>
				<colgroup>
					<col width="31" />
					<col width="20" />
					<col width="70" />
					<col width="20" />
					<col width="70" />
					<col width="20" />
					<col width="70" />
					<col width="195" />
					<col width="250" />
					<col width="*" />
				</colgroup>
				<tr class="h23">
					<td></td>
					<th>OPR</th>
					<td width="80"><script type="text/javascript">ComComboObject('crr_cd', 1, 70, 1, 0, 0, false);</script></td>
					<th title="Port of Discharging">POD</th>
					<td width="80"><script type="text/javascript">ComComboObject('pod_cd', 1, 70, 1);</script></td>
					<th>MLB</th>
					<td width="400"><script type="text/javascript">ComComboObject('mlb_cd', 1, 70, 1);</script></td>
					<td></td>
					<td class="wrap_search_btn">
						<input id="all_flg" value="Y" class="trans" name="all_flg" checked type="checkbox"/><label for="all_flg"><strong>ALL</strong></label>
						<label></label>
						<input id="dcgo_flg" value="Y" class="trans pad_left_12" name="dcgo_flg" type="checkbox"/><label for="dcgo_flg"><strong>DG</strong></label>
						<label></label>
						<input id="rc_flg" value="Y" class="trans pad_left_12" name="rc_flg" type="checkbox" /><label for="rc_flg"><strong>RF</strong></label>
						<label></label>
						<input id="awk_cgo_flg" value="Y" class="trans pad_left_12" name="awk_cgo_flg" type="checkbox" /><label for="awk_cgo_flg"><strong>AK</strong></label>
						<label></label>
						<input id="bb_cgo_flg" value="Y" class="trans pad_left_12" name="bb_cgo_flg" type="checkbox" /><label for="bb_cgo_flg"><strong>BB</strong></label>
						<label></label>
						<input id="stwg_cgo_flg" value="Y" class="trans pad_left_12" name="stwg_cgo_flg" type="checkbox" /><label for="stwg_cgo_flg"><strong>STWG</strong></label>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->

	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_DownExcel1" name="btn_DownExcel1" class="btn_accent">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<h3 class="title_design">Special Cargo</h3>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_DownExcel2" name="btn_DownExcel2" class="btn_accent">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		
		
		<div class="opus_design_grid"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
		
		<h3 class="title_design">Stowage Request</h3>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_DownExcel3" name="btn_DownExcel3" class="btn_accent">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('t2sheet2');</script>
		
		<div class="opus_design_grid"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
		
		<h3 class="title_design">Detail</h3>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_DownExcel4" name="btn_DownExcel4" class="btn_accent">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('t2sheet3');</script>
	</div>
</div>	
</form>