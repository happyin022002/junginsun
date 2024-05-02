<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0200.jsp
*@FileTitle  : Criteria for out guage calculation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0200Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>

<%
	EsmBkg0200Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String isInquiry = "N";	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//inquiry mode
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");
	String bkgNo = "";
	String screenName = "";
	
	isInquiry = "N";	
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	
	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	String pgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0200Event)request.getAttribute("Event");
		bkgNo = event.getBkgNo();
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
	function setupPage(){	
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input id="com_mrdPath" name="com_mrdPath" type="hidden" />
<input id="com_mrdArguments" name="com_mrdArguments" type="hidden" />
<input id="com_mrdTitle" name="com_mrdTitle" type="hidden" />
<input id="com_mrdBodyTitle" name="com_mrdBodyTitle" type="hidden" />
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="dg_cntr_seq" name="dg_cntr_seq" type="hidden" />
<input id="temp_cntr_no" name="temp_cntr_no" type="hidden" />
<input id="cntr_no" name="cntr_no" type="hidden" />
<input id="cntr_tpsz_cd" name="cntr_tpsz_cd" type="hidden" />
<input id="in_imdg_pck_cd1" name="in_imdg_pck_cd1" type="hidden" />
<input id="in_imdg_pck_cd2" name="in_imdg_pck_cd2" type="hidden" />
<input id="intmd_imdg_pck_cd1" name="intmd_imdg_pck_cd1" type="hidden" />
<input id="intmd_imdg_pck_cd2" name="intmd_imdg_pck_cd2" type="hidden" />
<input id="out_imdg_pck_cd1" name="out_imdg_pck_cd1" type="hidden" />
<input id="out_imdg_pck_cd2" name="out_imdg_pck_cd2" type="hidden" />
<input id="in_imdg_pck_desc1" name="in_imdg_pck_desc1" type="hidden" />
<input id="in_imdg_pck_desc2" name="in_imdg_pck_desc2" type="hidden" />
<input id="intmd_imdg_pck_desc1" name="intmd_imdg_pck_desc1" type="hidden" />
<input id="intmd_imdg_pck_desc2" name="intmd_imdg_pck_desc2" type="hidden" />
<input id="out_imdg_pck_desc1" name="out_imdg_pck_desc1" type="hidden" />
<input id="out_imdg_pck_desc2" name="out_imdg_pck_desc2" type="hidden" />
<input id="in_imdg_pck_qty1" name="in_imdg_pck_qty1" type="hidden" />
<input id="in_imdg_pck_qty2" name="in_imdg_pck_qty2" type="hidden" />
<input id="intmd_imdg_pck_qty1" name="intmd_imdg_pck_qty1" type="hidden" />
<input id="intmd_imdg_pck_qty2" name="intmd_imdg_pck_qty2" type="hidden" />
<input id="out_imdg_pck_qty1" name="out_imdg_pck_qty1" type="hidden" />
<input id="out_imdg_pck_qty2" name="out_imdg_pck_qty2" type="hidden" />
<input id="max_in_pck_qty" name="max_in_pck_qty" type="hidden" />
<input id="max_in_pck_tp_cd" name="max_in_pck_tp_cd" type="hidden" />
<input id="hcdg_intmd_bc_rstr_desc" name="hcdg_intmd_bc_rstr_desc" type="hidden" />
<input id="hcdg_pck_rstr_desc" name="hcdg_pck_rstr_desc" type="hidden" />
<input id="hcdg_tnk_rstr_desc" name="hcdg_tnk_rstr_desc" type="hidden" />
<input id="ltd_qty" name="ltd_qty" type="hidden" />
<input id="imdg_lmt_qty_desc" name="imdg_lmt_qty_desc" type="hidden" />
<input id="imdg_expt_qty_cd" name="imdg_expt_qty_cd" type="hidden" />
<input id="imdg_expt_qty_desc" name="imdg_expt_qty_desc" type="hidden" />
<input id="ems_no" name="ems_no" type="hidden" />
<input id="emer_rspn_gid_no" name="emer_rspn_gid_no" maxlength="3" type="hidden" />
<input id="emer_rspn_gid_chr_no" name="emer_rspn_gid_chr_no" type="hidden" />
<input id="ctrl_temp_ctnt" name="ctrl_temp_ctnt" type="hidden" />
<input id="emer_temp_ctnt" name="emer_temp_ctnt" type="hidden" />
<input id="title_id" name="title_id" value="dg" type="hidden" />
<input id="button" name="button" value="N" type="hidden" />
<input id="diff_rmk" name="diff_rmk" type="hidden" />
<input id="clod_flg" name="clod_flg" type="hidden" />
<input id="rc_flg" name="rc_flg" type="hidden" />
<input id="awk_cgo_flg" name="awk_cgo_flg" type="hidden" />
<input id="bb_cgo_flg" name="bb_cgo_flg" type="hidden" />
<input id="hcdg_flg" name="hcdg_flg" type="hidden" />
<input id="meas_qty" name="meas_qty" type="hidden" />
<input id="hcdg_dpnd_qty_flg" name="hcdg_dpnd_qty_flg" type="hidden" />
<input id="spcl_rqst_flg" name="spcl_rqst_flg" type="hidden" />
<input id="temp_grs_wgt" name="temp_grs_wgt" type="hidden" />
<input id="temp_net_wgt" name="temp_net_wgt" type="hidden" />
<input id="crr_cd" name="crr_cd" type="hidden" />
<input id="dcgo_seq" name="dcgo_seq" type="hidden" />
<input id="slan_cd" name="slan_cd" type="hidden" />
<input id="vessel_nm" name="vessel_nm" type="hidden" />
<input id="isInquiry" name="isInquiry" value="<%=isInquiry%>" type="hidden" />
<input id="imdg_amdt_no" name="imdg_amdt_no" type="hidden" />
<input id="erap_no" name="erap_no" type="hidden" />
<input id="erap_cntc_no" name="erap_cntc_no" type="hidden" />
<input id="erap_apro_ref_no" name="erap_apro_ref_no" type="hidden" />
<input id="dot_exp_no" name="dot_exp_no" type="hidden" />
<input id="dot_spcl_apro_no" name="dot_spcl_apro_no" type="hidden" />
<input id="dot_auth_no" name="dot_auth_no" type="hidden" />
<input id="dcgo_yn" name="dcgo_yn" type="hidden" />
<input id="imdg_un_no_spcl_provi_ctnt" name="imdg_un_no_spcl_provi_ctnt" type="hidden" />
<input id="save_button" name="save_button" value="N" type="hidden" />
<input id="old_bkg_no" name="old_bkg_no" type="hidden">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<% if("true".equals(mainPage)){ %>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<% } else { %>
		<h2 class="page_title"><span>Dangerous Cargo Application</span></h2>
	<% } %>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_attach" id="btn_attach">Attach File</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_request" id="btn_request">Request</button><!--
		--><button type="button" class="btn_normal" name="btn_email" id="btn_email">E-mail</button><!--
		--><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="70" />
					<col width="200" />
					<col width="40" />
					<col width="150" />
					<col width="120" />
					<col width="400" />
					<col width="70" />
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>BKG No.</th>
					<td><input id="bkg_no" name="bkg_no" style="width: 105px;" class="input1" value="<%=bkgNo%>" maxlength="13" type="text" dataformat="engup"/><!-- 
					 --><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button></td>
					<th>B/L No.</th>
					<td><input id="bl_no" name="bl_no" style="width: 105px;" class="input1" value="" type="text" /></td>
					<th>Requested By/Date</th>
					<td><input id="rqst_usr_id" name="rqst_usr_id" style="width: 90px;" class="input2" value="" readonly type="text" /><input id="rqst_dt" name="rqst_dt" style="width: 115px;" class="input2" value="" readonly type="text" /><input id="rqst_gdt" name="rqst_gdt" style="width: 115px;" class="input2" value="" readonly type="text" />  (GMT)</td>
					<th>Approval</th>
					<td><input id="spcl_cgo_auth_cd" name="spcl_cgo_auth_cd" style="width: 20px;text-align:center;" class="input2_1" value="" readonly type="text" /><button class="input_seach_btn" name="btn_approval" id="btn_approval" type="button"></button></td>
					<td></td>
				</tr>
					<tr>
					<th>T/VVD</th>
					<td><input id="vsl_cd" name="vsl_cd" style="width: 105px;" class="input2" value="" readonly type="text" /></td>
					<th title="Port of Loading">POL</th>
					<td><input id="pol_cd" name="pol_cd" style="width: 50px;" class="input2" value="" readonly type="text" /><input id="pol_nod_cd" name="pol_nod_cd" style="width: 30px;" class="input2" value="" readonly type="text" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input id="pod_cd" name="pod_cd" style="width: 50px;" class="input2" value="" readonly type="text" /><input id="pod_nod_cd" name="pod_nod_cd" style="width:  30px;" class="input2" value="" readonly type="text" /><button type="button" class="btn_etc" id="ts_route_vvd_btn" name="ts_route_vvd_btn" >Route Detail</button><button type="button" class="btn_etc" id="pre_checking_reports_btn" name="pre_checking_reports_btn" >Pre Checking Reports</button></td>
					<td colspan="3"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width:30%;">
	    	 <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	       	    <div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_declarant" id="btn_declarant">Declarant</button>
					<button type="button" class="btn_accent" name="row_add" id="row_add">Row Add</button>
					<button type="button" class="btn_normal" name="row_delete" id="row_delete">Row Delete</button>
					<button type="button" class="btn_normal" name="btn_copy1" id="btn_copy1">Copy</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	         <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid" style="display: none;">
				<script type="text/javascript">ComSheetObject('sheet3');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	         <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid" style="display: none;">
				<script type="text/javascript">ComSheetObject('sheet4');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	         <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid" style="display: none;">
				<script type="text/javascript">ComSheetObject('sheet5');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    <div class="layout_vertical_2 mar_left_12" style="width:68%">
	    	<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table style="width:820px;">
					<tbody>
						<colgroup>
							<col width="70" />
							<col width="150" />
							<col width="*" />
							<col width="70" />
							<col width="355" />
						</colgroup>
						<tr>
							<th>Cargo Seq.</th>
							<td><!--
							--><input id="cntr_cgo_seq_sum" name="cntr_cgo_seq_sum" style="width: 40px; text-align:right;" class="input2" value="" readonly type="text" /><!--
							--><select id="cntr_cgo_seq" name="cntr_cgo_seq" style="width: 55px;" class="input1" dir="rtl"></select></td>
							<th>DG Ref No.</th>
							<td><input id="dcgo_ref_no" name="dcgo_ref_no" style="width: 100px;" class="input2" value="" type="text" maxlength="12" readonly/></td>
							<td id="approved"></td>
							<td style="text-align: right;"><button type="button" class="btn_etc" id="un_information_btn" name="un_information_btn" >UN Information</button><!--
							--><button type="button" class="btn_etc" id="restrictions_btn" name="restrictions_btn" >Restrictions</button><!--
							--><button type="button" class="btn_etc" id="pkg_qty_type" name="pkg_qty_type"  style="color:red;">PKG Q'ty / Type</button></td>
						</tr>
					</tbody>
				</table>
		
			<!-- opus_design_inquiry(E) -->
	    	
	    	<!-- opus_design_inquiry(S) -->
				<table style="width:820px">
					<tbody>
						<colgroup>
							<col width="85" />
							<col width="100" />
							<col width="60" />
							<col width="75" />
							<col width="75" />
							<col width="85" />
							<col width="145" />
							<col width="75" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>UN No.</th>
							<td><input id="imdg_un_no" name="imdg_un_no" style="width: 40px; text-align:center;" class="input1" value="" maxlength="4" type="text" dataformat="num"/><input id="imdg_un_no_seq" name="imdg_un_no_seq" style="width: 35px; text-align:center;" class="input2" value="" readonly type="text" /><button class="input_seach_btn" name="imdg_class_button" id="imdg_class_button" type="button"></button></td>
							<td><input type="checkbox" name="cfr_flg" class="input2" value="Y" id="cfr_flg"  onclick="return false;"/> CFR</td>
							<th>IMDG Class</th>
							<td><input id="imdg_clss_cd" name="imdg_clss_cd" style="width: 30px; text-align:center;" class="input1" value="" maxlength="3" readonly type="text" /><input id="imdg_comp_grp_cd" name="imdg_comp_grp_cd" style="width: 20px; text-align:center;" class="input2" value="" maxlength="1" readonly type="text" /></td>
							<th>Gross Weight</th>
							<td><input id="grs_wgt" name="grs_wgt" style="width: 85px; text-align:right;" class="input1" value="" dataformat="float" pointcount="3" maxlength="11" type="text" /><!-- 
							 --><input style="width: 40px;text-align: center;" class="input2" value=" KGS" readonly type="text" /></td>
							<th>Net Weight</th>
							<td><input id="net_wgt" name="net_wgt" style="width: 85px; text-align:right;" class="input1" value="" dataformat="float" pointcount="3" maxlength="11" type="text" /><!-- 
							 --><input style="width: 40px;text-align: center;" class="input2" value=" KGS" readonly type="text" /></td>
						</tr>
					</tbody>
				</table>
			<!-- opus_design_inquiry(E) -->
			
			<!-- opus_design_inquiry(S) -->
				<table style="width:820px">
					<tbody>
						<colgroup>
							<col width="130" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Proper Shipping Name</th>
							<td><input id="prp_shp_nm" name="prp_shp_nm" style="width: 678px;" class="input1" value="" type="text" maxlength="500" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"/></td>
						</tr>
						<tr>
					  		<th>Technical Name</th>
							<td><input id="hzd_desc" name="hzd_desc" style="width: 678px;" class="input1" value="" type="text" maxlength="4000" dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"/></td>
						</tr>
					</tbody>
				</table>
			<!-- opus_design_inquiry(E) -->
			
			<!-- opus_design_inquiry(S) -->
				<table style="width:820px">
					<tbody>
						<colgroup>
							<col width="70" />
							<col width="142" />
							<col width="50" />
							<col width="120" />
							<col width="70" />
							<col width="142" />
							<col width="70" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Flash Point</th>
							<td><input id="flsh_pnt_cdo_temp" name="flsh_pnt_cdo_temp" style="width: 50px; text-align:right;" class="input" value="" maxlength="6" type="text"/>  <input style="width: 22px;" class="input" value="ºC" readonly type="text" /></td>
							<th>Packing Group</th>
							<td><script type="text/javascript">ComComboObject('imdg_pck_grp_cd', 1, 60, 1, 0, 0)</script></td>
							<th>PSA Group</th>
							<td><input id="psa_no" name="psa_no" style="width: 40px;" class="input" value="" type="text" /><input style="width: 40px;" class="input" value="" type="text" /></td>
							<th>Limited Q'ty</th>
							<td><select style="width: 55px;" name="imdg_lmt_qty_flg" id="imdg_lmt_qty_flg" class="input1">
								<option value=""></option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select><!-- 
							--><input id="hcdg_flag" name="hcdg_flag" style="width: 45px;" class="input2_1" value="" readonly type="text" /></td>
						</tr>
					</tbody>
				</table>
			<!-- opus_design_inquiry(E) -->
			
			<!-- opus_design_inquiry(S) -->
				<table style="width:820px">
					<tbody>
						<colgroup>
							<col width="70" />
							<col width="150" />
							<col width="51" />
							<col width="120" />
							<col width="70" />
							<col width="102" />
							<col width="70" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Sub Label</th>
							<td><input id="imdg_subs_rsk_lbl_cd1" name="imdg_subs_rsk_lbl_cd1" style="width: 30px;" class="input" value="" maxlength="3" type="text" /><input id="imdg_subs_rsk_lbl_cd2" name="imdg_subs_rsk_lbl_cd2" style="width: 30px;" class="input" value="" maxlength="3" type="text" /><input id="imdg_subs_rsk_lbl_cd3" name="imdg_subs_rsk_lbl_cd3" style="width: 30px;" class="input" value="" maxlength="3" type="text" /><input id="imdg_subs_rsk_lbl_cd4" name="imdg_subs_rsk_lbl_cd4" style="width: 30px;" class="input" value="" maxlength="3" type="text" /></td>
							<th>Cargo Status</th>
							<td><script type="text/javascript">ComComboObject('dcgo_sts_cd', 2, 60, 1, 0, 0)</script></td>
							<th>Marine Pollutant</th>
							<td><select name="mrn_polut_flg" id="mrn_polut_flg" style="width: 55px;" class="input1"><option value="Y">Y</option><option value="N" >N</option></select></td>
							<th>Excepted Q'ty</th>
							<td><select name="imdg_expt_qty_flg" style="width: 55px;"><option value=""></option><option value="Y">Y</option><option value="N">N</option></select></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				
				<table style="width:820px">
					<tbody>
						<colgroup>
							<col width="140" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Residue Last Contained</th>
							<td><select style="width: 55px;" name="rsd_flg" id="rsd_flg" class="input">
								<option value=""></option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select></td>
							<th>Special Provisions</th>
							<td><!-- 
								 --><input type="text" name="frm_imdg_spcl_provi_no1" id="frm_imdg_spcl_provi_no1" caption="Special Provisions 1" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
								--><button type="button" id="btn_imdg_spcl_provi_no1" name="btn_imdg_spcl_provi_no1" class="input_seach_btn"></button><!--
								--><input type="text" name="frm_imdg_spcl_provi_no2" id="frm_imdg_spcl_provi_no2" caption="Special Provisions 2" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
								--><button type="button" id="btn_imdg_spcl_provi_no2" name="btn_imdg_spcl_provi_no2" class="input_seach_btn"></button><!--
								--><input type="text" name="frm_imdg_spcl_provi_no3" id="frm_imdg_spcl_provi_no3" caption="Special Provisions 3" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
								--><button type="button" id="btn_imdg_spcl_provi_no3" name="btn_imdg_spcl_provi_no3" class="input_seach_btn"></button><!--
								--><input type="text" name="frm_imdg_spcl_provi_no4" id="frm_imdg_spcl_provi_no4" caption="Special Provisions 4" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
								--><button type="button" id="btn_imdg_spcl_provi_no4" name="btn_imdg_spcl_provi_no4" class="input_seach_btn"></button><!--
								--><input type="text" name="frm_imdg_spcl_provi_no5" id="frm_imdg_spcl_provi_no5" caption="Special Provisions 5" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
								--><button type="button" id="btn_imdg_spcl_provi_no5" name="btn_imdg_spcl_provi_no5" class="input_seach_btn"></button><!--
								--><input type="text" name="frm_imdg_spcl_provi_no6" id="frm_imdg_spcl_provi_no6" caption="Special Provisions 6" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
								--><button type="button" id="btn_imdg_spcl_provi_no6" name="btn_imdg_spcl_provi_no6" class="input_seach_btn"></button><!--
								--><input type="text" name="frm_imdg_spcl_provi_no7" id="frm_imdg_spcl_provi_no7" caption="Special Provisions 7" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
								--><button type="button" id="btn_imdg_spcl_provi_no7" name="btn_imdg_spcl_provi_no7" class="input_seach_btn"></button><!--
								--><input type="text" name="frm_imdg_spcl_provi_no8" id="frm_imdg_spcl_provi_no8" caption="Special Provisions 8" dataformat="num" maxlength="3" style="width:30px;text-align:right;ime-mode:disabled;" class="input" value="" /><!--
								--><button type="button" id="btn_imdg_spcl_provi_no8" name="btn_imdg_spcl_provi_no8" class="input_seach_btn"></button><!-- 
							 --></td>
						</tr>
					</tbody>
				</table>

				<table style="width:820px">
					<tbody>
						<colgroup>
							<col width="120" />
							<col width="120" />
							<col width="130" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Segregation Group</th>
							<td><script type="text/javascript">ComComboObject('imdg_segr_grp_no', 2, 160, 1, 0, 1)</script></td>
							<th>Segregation Groups</th>
							<td><input id="imdg_segr_grp_no1" name="imdg_segr_grp_no1" style="width:40px; text-align:center;" class="input" value="" maxlength="4" type="text" readonly /><input id="imdg_segr_grp_no2" name="imdg_segr_grp_no2" style="width:40px; text-align:center;" class="input" value="" maxlength="4" type="text" readonly /><input id="imdg_segr_grp_no3" name="imdg_segr_grp_no3" style="width:40px; text-align:center;" class="input" value="" maxlength="4" type="text" readonly /><input id="imdg_segr_grp_no4" name="imdg_segr_grp_no4" style="width:40px; text-align:center;" class="input" value="" maxlength="4" type="text" readonly /></td>
					</tbody>
				</table>
			<!-- opus_design_inquiry(E) -->
			
			<!-- opus_design_inquiry(S) -->
				<table style="width:820px">
					<tbody>
						<colgroup>
							<col width="120px" />
							<col width="242px" />
							<col width="120px" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Emergency Contact #</th>
							<td><input id="emer_cntc_phn_no_ctnt" name="emer_cntc_phn_no_ctnt" style="width: 220px;" class="input1" value="" type="text" maxlength="200" dataformat="num" otherchar="-"/></td>
							<th>Certificate Number</th>
							<td><input id="certi_no" name="certi_no" style="width: 200px;" class="input" value="" maxlength="15" type="text" /></td>
						</tr>
						<tr>
							<th>Contact Person</th>
							<td><input id="emer_cntc_pson_nm" name="emer_cntc_pson_nm" style="width: 220px;" class="input1" value="" type="text" maxlength="100" /></td>
							<td></td>
							<td><button type="button" class="btn_etc" id="btn_emer_info" name="btn_emer_info" style="width: 250px;">Other Emergency and Reefer Information</button></td>
						</tr>
						<tr class="h23">
							<th>Approval Ref. No.</th>
							<td><input id="aply_no" name="aply_no" style="width: 220px;" class="input" value="" readonly type="text" /> </td>
							<td></td>
							<td><button type="button" class="btn_etc" id="btn_dot_info" name="btn_dot_info" style="width: 250px;">DOT References</button></td>
						</tr>
					</tbody>
				</table>
				<!-- <table class="search">
						<tbody>
							<colgroup>
								<col width="200px">
								<col width="242px" />
								<col width="120px" />
								<col width="*">
							</colgroup> 
							<tr class="h23">
								<th>Approval Ref. No.</th>
								<td><input id="aply_no" name="aply_no" style="width: 220px;" class="input" value="" readonly type="text" /> </td>
								<td></td>
								<td><button type="button" class="btn_etc" id="btn_dot_info" name="btn_dot_info" style="width: 250px;">DOT References</button></td>
							</tr>
						</tbody>
					</table>	 -->
			</div>
			<!-- opus_design_inquiry(E) -->
			
			<div class="layout_wrap" style="vertical-align: middle;">
	    				<!-- opus_tab_btn(S) -->
						<div class="opus_design_tab mar_left_4">
							<script type="text/javascript">ComTabObject('tab1')</script>
						</div>
						<!-- opus_tab_btn(E) -->
						
						<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
							<table style="width: 500px;" class="grid2"> 
								<tr>
									<th class="tr2_head" rowspan="2">Class 1 Only</th>
									<th>Consignee Detail</th>
									<td><input id="cnee_dtl_desc" name="cnee_dtl_desc" style="width: 220px; text-align:left;" class="noinput" value="" type="text" maxlength="4000" /> </td>
								</tr>
								<tr>
									<th>Net Explosive Weight</th> 
									<td><input id="net_explo_wgt" name="net_explo_wgt" style="width: 180px; text-align:right;" class="noinput" value="" maxlength="8" type="text" /><input style="width: 100px;" class="noinput" value="KGS" type="text" /></td>
								</tr>
							</table>
						</div>
						
						<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
							<table style="width: 500px;" class="grid2"> 
								<tr>
									<th style="width: 25%" class="tr2_head" rowspan="3">Class 7<br>Only</th>
									<th colspan="5">Radio Active Commodities</th>
								</tr>
								<tr>
									<td width="20%" class="tr2_head">Schedule</td> 
									<td><input id="rada_skd_no" name="rada_skd_no" style="border:0;" value="" type="text" maxlength="5" /> </td>
									<th>Activity</th>
									<td><input id="rada_amt" name="rada_amt" style="width: 60px; text-align:right;" class="noinput" value="" maxlength="8" type="text" /> </td>
									<td><script type="text/javascript">ComComboObject('rada_ut_cd', 1, 60, 1, 0, 0)</script></td>
								</tr>
								<tr>
									<td class="tr2_head" colspan="2" style="text-align: center;"> Transportation Index</td> 
									<td><input id="rada_trsp_no" name="rada_trsp_no" style="width: 100px; text-align:center;" class="noinput" value="" maxlength="5" type="text" /> </td>
									<td colspan="2"></td>
								</tr>
							</table>						
						</div>
			
			    
				
			</div>
			
			<div class="opus_design_grid" style="width: 820px;text-align:right;">
	       	    <div class="opus_design_grid">
					<button type="button" class="btn_etc" name="btn_Remark" id="btn_Remark">Remark(s)</button><!--
					 --><button type="button" class="btn_etc" name="btn_add" id="btn_add">Add</button><!--
					 --><button type="button" class="btn_etc" name="btn_copy2" id="btn_copy2">Copy</button><!--
					 --><button type="button" class="btn_etc" name="btn_cancel" id="btn_cancel">Request Cancel</button><!--
					 --><button type="button" class="btn_etc" name="btn_delete" id="btn_delete">Delete</button>
				</div>
	       	</div>
	       	
	    </div>
	</div>
	<!-- layout_wrap (E) -->
	
	<span id="progressPop"></span>
	
	<!-- opus_design_grid(S) -->
	   <div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet6');</script>
	   </div>
	<!-- opus_design_grid(E) -->
	<div id="layList" name="layList" style="position: fixed; z-index: 999; display: none">
		<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html" width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid"></IFRAME>
	</div>
</div>

<input id="com_from" name="com_from" value="" type="hidden" />
<input id="com_fromName" name="com_fromName" value="" type="hidden" />
<input id="com_recipient" name="com_recipient" value="" type="hidden" />
<input id="com_carbonCopy" name="com_carbonCopy" value="" type="hidden" />
<input id="com_blindCarbonCopy" name="com_blindCarbonCopy" value="" type="hidden" />
<input id="com_subject" name="com_subject" value="" type="hidden" />
<input id="com_fileKey" name="com_fileKey" value="" type="hidden" />
<input id="com_content" name="com_content" value="" type="hidden" />
<input id="com_smtp" name="com_smtp" value="203.246.130.40" type="hidden" />
</form>
<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>