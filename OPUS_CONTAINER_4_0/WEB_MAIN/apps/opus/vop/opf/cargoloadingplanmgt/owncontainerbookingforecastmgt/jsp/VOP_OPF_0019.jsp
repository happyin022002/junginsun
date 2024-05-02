<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0019.jsp
*@FileTitle  : CBF for Own Booking (Creation) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
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
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	VopOpf0019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopOpf0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	var userId = '<%=strUsr_id%>';
	function setupPage(){ 
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.form.crr_cd.value = ConstantMgr.getCompanyCode();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bk_st" name="bk_st" type="hidden" />
<input id="bkg_shpr_ownr_flg" name="bkg_shpr_ownr_flg" value="Y" type="hidden" />
<input id="crr_cd" name="crr_cd" type="hidden" />
<input id="cre_dt" name="cre_dt" type="hidden" />

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
		--><button type="button" id="btn_Delete" name="btn_Delete" class="btn_normal">Delete</button><!--
		--><button type="button" id="btn_Save" name="btn_Save" class="btn_normal">Save</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50" />
					<col width="320" />
					<col width="50" />
					<col width="170" />
					<col width="50" />
					<col width="150" />
					<col width="30" />
					<col width="86" />
					<col width="*" />
				</colgroup>
				<tr> 
					<th>VVD CD</th>
					<td><input name="vsl_cd" id="vsl_cd" type="text" style="width:55px;" class="input1" value="" caption="VVD CD" required fullfill maxlength="4" dataformat="engup" style="ime-mode: disabled"><!--  
						--><input name="skd_voy_no" id="skd_voy_no" type="text" style="width: 40px; ime-mode: disabled" class="input1" value="" caption="VVD CD" required fullfill maxlength="4" dataformat="num"><!--  
						--><input name="skd_dir_cd" id="skd_dir_cd" type="text" style="width: 20px; ime-mode: disabled" class="input1" value="" caption="VVD CD" fullfill required maxlength="1" dataformat="enguponly"><!--  
						--><button type="button" class="input_seach_btn" name="btn_vvd" id="btn_vvd"></button><input name="vsl_eng_nm" id="vsl_eng_nm" type="text" style="width: 130px;" class="input2" value="" readonly></td>
					<th title="Port of Loading">POL</th>
					<td><script type="text/javascript">ComComboObject('yd_cd', 1, 80, 1, 1);</script><input type="text" style="width:80;" class="input2" name="loc_nm" readOnly><input type="text" style="width:150;" class="input2" name="yd_nm" readOnly></td> 
					<th>ETA</th>
					<td><input id="eta" style="width:110px;" class="input2" name="eta" readonly type="text" /> </td>
					<th class="wrap_search_tab">CBF</th>
					<td class="wrap_search_tab"><label></label><input id="cbf_ind_flg1" value="P" name="cbf_ind_flg" class="trans" type="radio" /><label for="cbf_ind_flg1">Pre</label><input id="cbf_ind_flg2" value="F" name="cbf_ind_flg" class="trans" type="radio" /><label for="cbf_ind_flg2">Final</label></td>
					<td></td>
				</tr>
				<tr>
					<th>Lane</th>
					<td><input id="slan_cd" name="slan_cd" style="width: 40px;" class="input2" value="" readonly type="text" /><input id="slan_nm" name="slan_nm" style="width: 227px;" class="input2" value="" readonly type="text" /> </td>
					<th>Last Created</th>
					<td><input id="upd_usr_id" style="width: 65px; text-align:center;" class="input2" name="upd_usr_id" readonly type="text" /><input id="upd_dt" style="width:110px; text-align:center;" class="input2" name="upd_dt" readonly type="text" /></td> 
					<th></th>
					<td><button type="button" class="btn_etc" id="btn_BookingClosingStatus" name="btn_BookingClosingStatus">Booking Closing Status</button></td>
					<th></th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">	
		<table>
			<tbody>
				<colgroup>
					<col width="55" />
					<col width="120" />
					<col width="50" />
					<col width="20" />
					<col width="10" />
					<col width="100" />
					<col width="472" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<th class="wrap_search_tab">Booking Status</th>
					<td class="wrap_search_tab"><input id="cbf_bkg_sts_cd1" value="" class="trans" name="cbf_bkg_sts_cd" type="radio" /><label for="cbf_bkg_sts_cd1">All</label><input id="cbf_bkg_sts_cd2" value="F" class="trans" name="cbf_bkg_sts_cd" type="radio" /><label for="cbf_bkg_sts_cd2">Firm</label></td>
					<th class="wrap_search_tab">Actual Cntr only</th>
					<td class="wrap_search_tab"><input id="ac_cntr_flg" value="C" class="trans" name="ac_cntr_flg" type="checkbox" /></td>
					<th class="wrap_search_tab"></th>
					<td class="wrap_search_tab"><button type="button" class="btn_etc" id="btn_Display" name="btn_Display">Import BKG Data</button></td> 
					<th></th>
					<td style="text-align: right;"><button type="button" class="btn_etc" id="btn_SummaryPreview" name="btn_SummaryPreview">Summary Preview</button></td>
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
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
</div>	
</form>