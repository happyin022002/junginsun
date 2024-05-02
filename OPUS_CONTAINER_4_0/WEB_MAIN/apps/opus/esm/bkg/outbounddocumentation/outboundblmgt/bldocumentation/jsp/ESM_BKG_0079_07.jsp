<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079_07.jsp
*@FileTitle  : C/M by Booking 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007907Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>

<%
	EsmBkg007907Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server		
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String isInquiry = "N";	
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentationCM");

	// search Init
	String bkgNo      = "";
	String blNo       = "";
	String blTpCd     = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg007907Event)request.getAttribute("Event");
		bkgNo      = event.getBkgNo();
		blNo       = event.getBlNo();
		blTpCd     = event.getBlTpCd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//  extract additional data obtained from the server during Initial loading ..
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

<!-- to popup as POST method -->
<form name="form2">
<input type="hidden" name="func" id="func">
<input type="hidden" name="mk_desc" id="mk_desc">
<input type="hidden" name="gds_desc" id="gds_desc">
</form>
<!--  -->
<form name="form" onKeyDown="ComKeyEnter('search')">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="dirty_flag" 	id="dirty_flag">
<input type="hidden" name="bkg_pck_qty" id="bkg_pck_qty">
<input type="hidden" name="bkg_pck_unit" id="bkg_pck_unit">
<input type="hidden" name="bkg_wgt_qty" id="bkg_wgt_qty">
<input type="hidden" name="bkg_wgt_unit" id="bkg_wgt_unit">
<input type="hidden" name="bkg_meas_qty" id="bkg_meas_qty">
<input type="hidden" name="bkg_meas_unit" id="bkg_meas_unit">
<input type="hidden" name="bkg_mk_desc" id="bkg_mk_desc">
<input type="hidden" name="bkg_cstms_desc" id="bkg_cstms_desc">
<input type="hidden" name="bkg_cfm_flg" id="bkg_cfm_flg">
<input type="hidden" name="cntr_no" id="cntr_no">
<input type="hidden" name="cntr_mf_flag" id="cntr_mf_flag">
<input type="hidden" name="mf_cfm_flg" id="mf_cfm_flg">
<input type="hidden" name="pre_rly_port_cd" id="pre_rly_port_cd">
<input type="hidden" name="pst_rly_port_cd" id="pst_rly_port_cd">
<input type="hidden" name="bkg_sts_cd" id="bkg_sts_cd">
<input type="hidden" name="bdr_flg" id="bdr_flg">
<input type="hidden" name="corr_flg" id="corr_flg">
<input type="hidden" name="ca_exist_flg" id="ca_exist_flg">
<input type="hidden" name="hts_flg" id="hts_flg">
<input type="hidden" name="mypkg_flg" id="mypkg_flg">
<input type="hidden" name="isInquiry" id="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="obl_iss_flg" id="obl_iss_flg">
<input type="hidden" name="bl_tp_cd" id="bl_tp_cd" value="<%=blTpCd%>">
<input type="hidden" name="eur_flg" id="eur_flg">
<input type="hidden" name="hs_aply_dt" id="hs_aply_dt">
<input type="hidden" name="cntr_ttl_pack_qty" id="cntr_ttl_pack_qty">
<input type="hidden" name="cntr_ttl_wgt_qty" id="cntr_ttl_wgt_qty">
<input type="hidden" name="cntr_ttl_meas_qty" id="cntr_ttl_meas_qty">
<input type="hidden" name="cntr_update_flg" id="cntr_update_flg">
<input type="hidden" name="mlt_shp_flg" id="mlt_shp_flg"><!-- multiShipment flag : 'Y'/'N' -->


<!-- opus_design_btn(S) -->
<div class="opus_design_btn opus_design_normal2">
	<button type="button" class="btn_normal2" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal2" name="btn_t9Save" id="btn_t9Save">Save</button><!--
	--><button type="button" class="btn_normal2" name="btn_t9CMCopyCM" id="btn_t9CMCopyCM">Copy C/M</button><!--
	--><button type="button" class="btn_normal2" name="btn_t9CopyFmCntr" id="btn_t9CopyFmCntr">Copy from CNTR</button><!--
	--><button type="button" class="btn_normal2" name="btn_t9CMbyCntr" id="btn_t9CMbyCntr">C/M by CNTR</button>
</div>
<!-- opus_design_btn(E) -->

<!-- wrap_search (S) -->
<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit"> 
		<table> 
			<tbody>
				<tr>
					<th width="50">BKG No.</th>
					<td width="180">
						<input type="text" id="bkg_no" name="bkg_no" style="ime-mode:disabled;width:110px;" dataformat="engup" value="<%=bkgNo%>" class="input1"><!-- 
						 --><button type="button" class="btn_down_list" name="btn_splitPop" id="btn_splitPop"></button>
					</td>
					<th width="50">B/L No.</th>
					<td><input name="bl_no" id="bl_no" type="text" style="ime-mode:disabled;width:110px;" dataformat="engup" value="<%=blNo%>" class="input1"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search (E) -->
		
		
<!-- wrap_result (S) -->
<div class="wrap_result coupled_btn_normal2">
		
		<!-- opus_design_inquiry(1) (S) -->
		<div class="opus_design_inquiry mar_btm_none wFit">
			<table>
				<colgroup>
					<col width="55"/>
					<col width="300"/>
					<col width="100"/>
					<col width="65"/>
					<col width="100"/>
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th>T/VVD</th>
						<td><input type="text" name="t_vvd" id="t_vvd" size="14" class="input2" readOnly><!-- 
						 --><input type="hidden" name="vsl_cd" id="vsl_cd"><!-- 
						 --><input type="hidden" name="skd_voy_no" id="skd_voy_no"><!-- 
						 --><input type="hidden" name="skd_dir_cd" id="skd_dir_cd"></td>
						<th>Cargo Type</th>
						<td><input name="bkg_cgo_tp_cd" id="bkg_cgo_tp_cd" type="text" style="ime-mode:disabled;width:44px;" dataformat="engup" class="input2" readOnly></td>
					</tr>
					<tr>
						<th>Route</th>
						<td>
							<input name="por_cd" id="por_cd" type="text" style="ime-mode:disabled;width:60px;" dataformat="engup" class="input2"  readOnly><!-- 
						 --><input name="pol_cd" id="pol_cd" type="text" style="ime-mode:disabled;width:60px;" dataformat="engup" class="input2"  readOnly><!-- 
						 --><input name="pod_cd" id="pod_cd" type="text" style="ime-mode:disabled;width:60px;" dataformat="engup" class="input2"  readOnly><!-- 
						 --><input name="del_cd" id="del_cd" type="text" style="ime-mode:disabled;width:60px;" dataformat="engup" class="input2"  readOnly></td>
						<th>R/D Term</th>
						<td>
							<input name="bkg_rcv_term_cd" id="bkg_rcv_term_cd" type="text" style="ime-mode:disabled;width:20px;" dataformat="engup" class="input2"  readOnly><!-- 
						 --><input name="bkg_de_term_cd" id="bkg_de_term_cd" type="text" style="ime-mode:disabled;width:20px;" dataformat="engup" class="input2"  readOnly></td>
						<th>Commodity</th>
						<td><input name="cmdt_cd" id="cmdt_cd" type="text" style="ime-mode:disabled;width:50px;" dataformat="engup" class="input2" readOnly><!-- 
						 --><!--input name="rep_cmdt_cd" type="text" style="width:25;" class="input2" readOnly--><!-- 
						 --><input name="cmdt_nm" id="cmdt_nm" type="text" style="ime-mode:disabled;width:500px;" class="input2" readOnly>
						</td>
					</tr>
					<tr>
						<th>Shipper</th>
						<td colspan="3"><input name="shpr_cnt_cd" id="shpr_cnt_cd" type="text" style="ime-mode:disabled;width:25px;" dataformat="engup" class="input2" readOnly><!-- 
						 --><input name="shpr_seq" id="shpr_seq" type="text" style="ime-mode:disabled;width:50px; text-align:right;" dataformat="engup" class="input2" readOnly><!-- 
						 --><input name="shpr_nm" id="shpr_nm" type="text" style="ime-mode:disabled;width:361px;" class="input2" readOnly></td>
						<th>Consignee</th>
						<td><input name="cnee_cnt_cd" id="cnee_cnt_cd" type="text" style="ime-mode:disabled;width:25px;" dataformat="engup" class="input2" readOnly><!-- 
						 --><input name="cnee_seq" id="cnee_seq" type="text" style="ime-mode:disabled;width:50px;text-align:right;" dataformat="engup" class="input2" readOnly><!-- 
						 --><input name="cnee_nm" id="cnee_nm" type="text" style="ime-mode:disabled;width:471px;" class="input2" readOnly>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<table class="line_bluedot" ><tr><td></td></tr></table>	
		<!-- opus_design_inquiry(1) (E) -->
		
		
		
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		
		
			<!-- layout_vertical_2 (LEFT) (S) -->
			<!-- 
			<div class="layout_vertical_2 pad_rgt_12" style="width:25%">
			 -->
			<div class="layout_vertical_2 pad_rgt_12" style="width:15%">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid" id="mainTable">
					<div class="opus_design_btn">		
							<button type="button" class="btn_normal" name="btn_t9AllConfirm" id="btn_t9AllConfirm">All Confirm</button>
							<button type="button" class="btn_normal" name="btn_t9AllRelease" id="btn_t9AllRelease">All Release</button>
					</div>
					<script type="text/javascript">ComSheetObject('t9sheet1');</script>
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			<!-- layout_vertical_2 (LEFT) (E) -->
			
			
			
			<!-- layout_vertical_2 (RIGHT) (S) -->
			<!-- 
			<div class="layout_vertical_2" style="width:75%">
			 -->
			<div class="layout_vertical_2" style="width:85%">
				<!-- opus_design_inquiry(2) (S) -->
				<div class="opus_design_inquiry"  >
					<table>
						<colgroup>
							<col width="60"/>
							<col width="100"/>
							<col width="120"/>
							<col width="170"/>
							<col width="65"/>
							<col width="100"/>
							<col />
						</colgroup>	
						<tbody>
							<tr>
								<th>TP/SZ</th>
								<td><input name="cntr_tpsz_cd" id="cntr_tpsz_cd" type="text" style="ime-mode:disabled;width:40px;" dataformat="engup" class="input2" readOnly></td>
								<th>Seal No.</th>
								<td><select name="cntr_seal_no" id="cntr_seal_no" style="width:120px;" class="input2" readOnly></select></td>
								<th>R/D Term</th>
								<td><input name="rcv_term_cd" id="rcv_term_cd" type="text" style="ime-mode:disabled;width:20px;" dataformat="engup" class="input2" readOnly><!-- 
								 --><input name="de_term_cd" id="de_term_cd" type="text" style="ime-mode:disabled;width:20px;" dataformat="engup" class="input2" readOnly></td>
								<td>
									<div class="opus_design_inquiry sm wAuto mar_none floatL">
										<table>
										<tr><td>
										DG&nbsp;<input name="dcgo_flg" id="dcgo_flg" type="checkbox" class="trans">&nbsp;
					                    BB&nbsp;<input name="bb_cgo_flg" id="bb_cgo_flg" type="checkbox" class="trans">&nbsp;
										AK&nbsp;<input name="awk_cgo_flg" id="awk_cgo_flg" type="checkbox" class="trans">&nbsp;
										RF&nbsp;<input name="rc_flg" id="rc_flg" type="checkbox" class="trans">&nbsp;
										RD&nbsp;<input name="rd_cgo_flg" id="rd_cgo_flg" type="checkbox" class="trans">&nbsp;
										HG&nbsp;<input name="hngr_flg" id="hngr_flg" type="checkbox" class="trans">
										</td></tr>
										</table>
									</div>
								</td>												
							</tr>
							<tr>
								<th>Volume</th>
								<td><input name="cntr_vol_qty" id="cntr_vol_qty" type="text" style="ime-mode:disabled;width:40px;" class="input2" readOnly></td>
								<th>Ahead / Short-ship&nbsp;</th>
								<td><input name="adv_shtg_cd" id="adv_shtg_cd" type="text" style="ime-mode:disabled;width:35px;" dataformat="engup" class="input2" readOnly></td>
						   </tr>
							<tr>
								<th>Package</th>
								<td><input name="pck_qty" id="pck_qty" type="text" style="width:60px; text-align:right" class="input2" readOnly dataformat="int" maxlength="7"><!-- 
								 --><input name="pck_tp_cd" id="pck_tp_cd" type="text" style="ime-mode:disabled;width:25px;" dataformat="engup" maxlength="2" class="input2" readOnly></td>
								<th>Weight</th>
								<td><input name="cntr_wgt" id="cntr_wgt" type="text" style="width:120px; text-align:right" class="input2" readOnly dataformat="float" maxlength="13" pointcount="3"><!-- 
								 --><input name="wgt_ut_cd" id="wgt_ut_cd" type="text" style="ime-mode:disabled;width:35px;" dataformat="engup" class="input2" readOnly></td>
								<th>Measure</th>
								<td colspan="2">
									<input name="meas_qty" id="meas_qty" type="text" style="width:120px; text-align:right" class="input2" readOnly dataformat="float" maxlength="9" pointcount="3"><!-- 
								 --><input name="meas_ut_cd" id="meas_ut_cd" type="text" style="ime-mode:disabled;width:35px;" dataformat="engup" class="input2" readOnly></td>
							</tr>
						</tbody>
					</table>
				<table class="line_bluedot" ><tr><td></td></tr></table>	
				</div>		
				<!-- opus_design_inquiry(2) (E) -->		
				
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid mar_btm_none clear" id="mainTable" >
					<div class="opus_design_btn">		
							<button type="button" class="btn_normal" name="btn_t9multishp" id="btn_t9multishp">Multi-Shipment</button> 
							<button type="button" class="btn_normal" name="btn_t9Add" id="btn_t9Add">Row Add</button>
							<button type="button" class="btn_normal" name="btn_t9Del" id="btn_t9Del">Row Delete</button>
							<button type="button" class="btn_normal" name="btn_t9CopyMnd" id="btn_t9CopyMnd">Copy from M&amp;D</button>
					</div>
					<script type="text/javascript">ComSheetObject('t9sheet2');</script>
					<script type="text/javascript">ComSheetObject('t9sheet3');</script>
				<table class="line_bluedot" ><tr><td></td></tr></table>	
				</div>
				<!-- opus_design_grid(E) -->
				
				<!-- opus_design_inquiry(3) (S) -->	
				<div class="opus_design_inquiry" id="mainTable" >
					<table class="wAuto floatR">
						<colgroup>
							<col width="105"/>
							<col width="105"/>
							<col width="105"/>
							<col width="105"/>
							<col width="105"/>
							<col/>
						</colgroup>	
						<tbody>
							<tr>
								<th>Total Package</th>
								<td><input name="cm_pck_qty" id="cm_pck_qty" type="text" style="width:90px; text-align:right" class="input2" readOnly dataformat="int" maxlength="7"></td>
								<th>Total Weight</th>
								<td><input name="cm_cntr_wgt" id="cm_cntr_wgt" type="text" style="width:90px; text-align:right" class="input2" readOnly dataformat="float" maxlength="13" pointcount="3"></td>
								<th>Total Measure</th>
								<td><input name="cm_meas_qty" id="cm_meas_qty" type="text" style="width:90px; text-align:right" class="input2" readOnly dataformat="float" maxlength="9" pointcount="3"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- opus_design_inquiry(3) (E) -->	
				
			</div>
			<!-- layout_vertical_2 (RIGHT) (E) -->
		</div>
		<!-- layout_wrap (E) -->	
</div>	
<!-- wrap_result (E) -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0">
<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder="0" marginHeight="0' marginWidth="0" width="150px" height="82px"  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING="0" scrolling="no"/></IFRAME>
</div>
</form>
