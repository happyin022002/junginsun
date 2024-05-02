<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0077.jsp 
*@FileTitle  : Booking Copy 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0077Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0077Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingReceipt");

	String bkgNo = "";
	String bkgStsCd = "";
	String bdrFlg = "";	
// 	String bkgWtChkFlg = "";	
	String caFlg = "";
// 	String ediHldFlg = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0077Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		bkgStsCd  = JSPUtil.getParameter(request, "bkg_sts_cd");
		bdrFlg  = JSPUtil.getParameter(request, "bdr_flg");
// 		bkgWtChkFlg  = JSPUtil.getParameter(request, "bkg_wt_chk_flg");
		caFlg  = JSPUtil.getParameter(request, "ca_flg");
// 		ediHldFlg  = JSPUtil.getParameter(request, "edi_hld_flg");
		
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<style type="text/css">
	.tb_incld tr td {
		padding: 4px;
	}
</style>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bkg_sts_cd" value="<%= bkgStsCd%>" id="bkg_sts_cd" />
<input type="hidden" name="bdr_flg" value="<%= bdrFlg%>" id="bdr_flg" />
<input type="hidden" name="bkg_wt_chk_flg" id="bkg_wt_chk_flg" />
<input type="hidden" name="edi_hld_flg" id="edi_hld_flg" />
<input type="hidden" name="ca_flg" value="<%= caFlg%>" id="ca_flg" />
<input type="hidden" name="trunkSeq" id="trunkSeq" />
<input type="hidden" name="s_cust_cnt_cd" id="s_cust_cnt_cd" />
<input type="hidden" name="s_cust_seq" id="s_cust_seq" />
<input type="hidden" name="c_cust_cnt_cd" id="c_cust_cnt_cd" />
<input type="hidden" name="c_cust_seq" id="c_cust_seq" />
<input type="hidden" name="f_cust_cnt_cd" id="f_cust_cnt_cd" />
<input type="hidden" name="f_cust_seq" id="f_cust_seq" />
<input type="hidden" name="bkg_trunk_vvd" id="bkg_trunk_vvd" />
<input type="hidden" name="por_cd" id="por_cd" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<input type="hidden" name="del_cd" id="del_cd" />
<input type="hidden" name="pc_inq_flg" id="pc_inq_flg" />
<input type="hidden" name="rfa_no_old" id="rfa_no_old" />
<input type="hidden" name="sc_no_old" id="sc_no_old" />
<input type="hidden" name="taa_no_old" id="taa_no_old" />
<input type="hidden" name="vvd_modify_flg" id="vvd_modify_flg" />
<input type="hidden" name="close_bkg_flag" id="close_bkg_flag" />
<input type="hidden" name="cbf_bkg_flag" id="cbf_bkg_flag" />
<input type="hidden" name="mail_open_flag" id="mail_open_flag" />
<input type="hidden" name="pctl_no" id="pctl_no" />
<input type="hidden" name="mnl_flg" id="mnl_flg" />
<input type="hidden" name="save_fin_flg" id="save_fin_flg" />
<input type="hidden" name="bkg_ctrl_pty_cust_cnt_cd" id="bkg_ctrl_pty_cust_cnt_cd" />
<input type="hidden" name="bkg_ctrl_pty_cust_seq" id="bkg_ctrl_pty_cust_seq" />

<!-- Groupmail Hidden --> 
<input type="hidden" name="gw_subject" id="gw_subject" />
<input type="hidden" name="gw_contents" id="gw_contents" />
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html" id="gw_template" />
<input type="hidden" name="gw_args" value="reqcontents;" id="gw_args" />
<!-- start	-->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Booking Copy</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Copy</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<div class="layer_popup_contents">
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="10" />
				<col width="30" />
				<col width="10" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Original booking number</th>
					<td><input type="text" style="width:130px;" class="input2" name="bkg_no" value="<%= bkgNo%>" readonly></td> 
					<th>Number of Copy</th>
					<td width=""><input type="text" style="width:35;" class="input1" name="copy_cnt" value=""  maxlength="2" style="ime-mode:disabled" dataformat="num" tabindex="2"></td>
					<td width=""><input type="checkbox" name="mnl_flg_chk" id="mnl_flg_chk" value="Y"  tabindex="3"><label for="mnl_flg_chk" ></label></td>
					<th>Manual Copy</th>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_data">
	    <table class="grid2"> 
			<colgroup>
				<col width="50" />
				<col width="150" />
				<col width="50" />
				<col width="150" />
				<col width="50" />
				<col width="150" />
			</colgroup>
			<tbody>
				<tr>
					<th>S/C No.</th>
					<td><!--
					--><input type="text" style="width:100px;" class="input" name="sc_no" value=""  maxlength="9"  style="ime-mode:disabled" dataformat="engup" tabindex="7"><!--
					--><button type="button" class="input_seach_btn" name="btn_ScNo" id="btn_ScNo"></button></td> 
					<th>RFA No.</th>
					<td><!--
					--><input type="text" style="width:100px;" class="input" name="rfa_no" value="" maxlength="11" style="ime-mode:disabled" dataformat="engup" tabindex="8"><!--
					--><button type="button" class="input_seach_btn" name="btn_RfaNo" id="btn_RfaNo"></button></td>
					<th>TAA No.</th>
					<td><!--
					--><input type="text" style="width:100px;" class="input" name="taa_no" value="" maxlength="10" style="ime-mode:disabled" dataformat="engup" tabindex="9"><!--
					--><button type="button" class="input_seach_btn" name="btn_TtaNo" id="btn_TtaNo"></button></td>					 
				</tr>
			</tbody>
		</table>
	</div>

	<div class="opus_design_data">
		<h3 class="title_design">Include</h3>
	    <table class="sm tb_incld grid2"> 
			<colgroup>
				<col width="33%"/>
				<col width="33%"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<td id="dcgoFlg"><input type="checkbox" class="trans" name="dcgo_flg" id="dcgo_flg" value="Y">&nbsp;<label for="dcgo_flg">Danger</label></td>
					<td id="stowageFlg"><input type="checkbox" class="trans" name="stowage_flg" id="stowage_flg" value="Y">&nbsp;<label for="stowage_flg">Stowage</label></td>
					<td id="hotDeFlg"><input type="checkbox" class="trans" name="hot_de_flg" id="hot_de_flg"value="Y" >&nbsp;<label for="hot_de_flg">Premium</label></td>
				</tr>
				<tr>
					<td id="rcFlg"><input type="checkbox" class="trans" name="rc_flg" id="rc_flg" value="Y">&nbsp;<label for="rc_flg">Reefer</label></td>
					<td id="hngrFlg"><input type="checkbox" class="trans" name="hngr_flg" id="hngr_flg" value="Y">&nbsp;<label for="hngr_flg">Hanger</label></td>
					<td id="spclHideFlg"><input type="checkbox" class="trans" name="spcl_hide_flg" id="spcl_hide_flg" value="Y">&nbsp;<label for="spcl_hide_flg">Hide</label></td>
				</tr>
				<tr>
					<td id="awkCgoFlg"><input type="checkbox" class="trans" name="awk_cgo_flg" id="awk_cgo_flg" value="Y">&nbsp;<label for="awk_cgo_flg">Awkward</label></td>
					<td id="stopOffFlg"><input type="checkbox" class="trans" name="stop_off_flg" id="stop_off_flg" value="Y">&nbsp;<label for="stop_off_flg">Stop Off Cargo</label></td>
					<td id="fdGrdFlg"><input type="checkbox" class="trans" name="fd_grd_flg" id="fd_grd_flg" value="Y">&nbsp;<label for="fd_grd_flg">Food Grade</label></td>
				</tr>
				<tr>
					<td id="bbCgoFlg"><input type="checkbox" class="trans" name="bb_cgo_flg" id="bb_cgo_flg" value="Y">&nbsp;<label for="bb_cgo_flg">Break Bulk</label></td>
					<td id="bulkRailFlg"><input type="checkbox" class="trans" name="bulk_rail_flg" id="bulk_rail_flg" value="Y">&nbsp;<label for="bulk_rail_flg">Bulk Rail</label></td>
					<td id="prctFlg"><input type="checkbox" class="trans" name="prct_flg" id="prct_flg" value="Y">&nbsp;<label for="prct_flg">Precaution</label></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id ="new_bkg_sheet">
		<h3 class="title_design mar_btm_8">New booking numbers</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<div class="opus_design_grid" style="Display :none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>

	<div class="opus_design_grid" id ="mnl_bkg_sheet" style="Display :none">
		<h3 class="title_design mar_btm_8">Manual booking numbers</h3>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	
	<div class="opus_design_grid" style="Display :none">
		<h3 class="title_design mar_btm_8">Manual booking numbers Status</h3>
		<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
</div>
</div>
</form>
