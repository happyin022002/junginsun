<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0068.jsp
*@FileTitle  : B/L(Manifest) Clearance Cross-Check List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0068Event"%>	
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%
	EsmBkg0068Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	
	//String[] contiCd = null;
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0068Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		// contiCd = RASUtil.getValueObject2StringArray((List<RsltContiListVO>)eventResponse.getCustomData("contiCd"), false, "|", "\t", "getContiCd", "getContiNm");

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
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd"> 
	<input type="hidden" name="pagerows" id="pagerows"> 
	<input type="hidden" name="ch_usr_id" id="ch_usr_id">
	<input type="hidden" name="curr_page" id="curr_page"      value="1">
	<input type="hidden" name="rows_per_page" id="rows_per_page"  value="50">
	<input type="hidden" name="mst_bkg_no" id="mst_bkg_no">
	<input type="hidden" name="ca_rsn_cd"  id="ca_rsn_cd">
	<input type="hidden" name="ca_remark" id="ca_remark">
	<input type="hidden" name="vgm_opt" id="vgm_opt" value="A">
   <input type="hidden" name="backendjob_key" id="backendjob_key" value="">
   <input type="hidden" name="strUsr_id" 	id="strUsr_id" value="">
   <input type="hidden" name="fax" 	id="fax" value="">
   <input type="hidden" name="email" 	id="email" value="">
   <input type="hidden" name="bkg_no_list" id="bkg_no_list" value="">
   <input type="hidden" name="cntr_no_list" id="cntr_no_list" value="">
   
   <input type="hidden" name="un_loc_cd" 	id="un_loc_cd" value="">
   <input type="hidden" name="vps_eta_dt" 	id="vps_eta_dt" value="">
   <input type="hidden" name="vps_etd_dt" 	id="vps_etd_dt" value="">
   <input type="hidden" name="vps_etb_dt" 	id="vps_etb_dt" value="">
   <input type="hidden" name="cssm_vvd" 	id="cssm_vvd" value="">
   <input type="hidden" name="d2" 	id="d2" value="">
   <input type="hidden" name="d4" 	id="d4" value="">
   <input type="hidden" name="d5" 	id="d5" value="">
   <input type="hidden" name="d7" 	id="d7" value="">
   <input type="hidden" name="d8" 	id="d8" value="">
   <input type="hidden" name="d9" 	id="d9" value="">
   <input type="hidden" name="dw" 	id="dw" value="">
   <input type="hidden" name="dx" 	id="dx" value="">
   <input type="hidden" name="r2" 	id="r2" value="">
   <input type="hidden" name="r4" 	id="r4" value="">
   <input type="hidden" name="r5" 	id="r5" value="">
   <input type="hidden" name="f2" 	id="f2" value="">
   <input type="hidden" name="f4" 	id="f4" value="">
   <input type="hidden" name="f5" 	id="f5" value="">
   <input type="hidden" name="o2" 	id="o2" value="">
   <input type="hidden" name="o4" 	id="o4" value="">
   <input type="hidden" name="o5" 	id="o5" value="">
   <input type="hidden" name="s2" 	id="s2" value="">
   <input type="hidden" name="s4" 	id="s4" value="">
   <input type="hidden" name="t2" 	id="t2" value="">
   <input type="hidden" name="t4" 	id="t4" value="">
   <input type="hidden" name="a2" 	id="a2" value="">
   <input type="hidden" name="a4" 	id="a4" value="">
   <input type="hidden" name="p2" 	id="p2" value="">
   <input type="hidden" name="p4" 	id="o5" value="">
   <input type="hidden" name="z2" 	id="z2" value="">
   <input type="hidden" name="z4" 	id="z4" value="">
   <input type="hidden" name="t20" 	id="t20" value="">
   <input type="hidden" name="t40" 	id="t40" value="">
   <input type="hidden" name="wgt" 	id="wgt" value="">
   <input type="hidden" name="mea" 	id="mea" value="">
   <input type="hidden" name="e_wgt" 	id="e_wgt" value="">
   <input type="hidden" name="lcl" 	id="lcl" value="">
   <input type="hidden" name="ts" 	id="ts" value="">
   <input type="hidden" name="ttl" 	id="ttl" value="">
   <input type="hidden" name="save_flg" 	id="save_flg" value="N">
   <input type="hidden" name="srch_mlt_bkg" 	id="srch_mlt_bkg" value="N">
   <input type="hidden" name="edi_tp_cd" 	id="edi_tp_cd" value="N">
   
<input type="hidden" size="200" name="com_mrdPath" value="apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0783.mrd" id="com_mrdPath" />
<input type="hidden" size="200" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" size="200" name="com_mrdTitle" value="Container Loading/Discharging List_Print" id="com_mrdTitle" />
<input type="hidden" size="200" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Container Loading/Discharging List_Print</span>" id="com_mrdBodyTitle">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		<button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button>
		--><button type="button" class="btn_normal" name="btn_History"  	id="btn_History">History</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Print" 	id="btn_Print">Print</button><!-- 
		--><button type="button" class="btn_normal" name="btn_email" 	id="btn_email">E-Mail</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td width="120">
						<input type="text" style="width:90px" value="" class="input1"  name="in_vvd" id="in_vvd" maxlength='9' required fullfill  dataformat='engup' style="ime-mode:disabled">
					</td>
					<th width="30">POL</th>
					<td width="60">
						<input type="text" style="width:60px" value="" name="in_pol_cd" id="in_pol_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input1">
						<input type="text" style="width:24px" value="" name="in_pol_yd_cd" id="in_pol_yd_cd" maxlength='2' dataformat='engup' style="ime-mode:disabled" class="input">
					</td>
					<th width="30">L/T</th>
					<td width="60"><%=JSPUtil.getCodeCombo("in_pol_lt", "", "", "CD20052", 0, "000001: :All")%>
					</td>
					<th width="30">POD</th>
					<td width="60">
						<input type="text" style="width:60px" value="" name="in_pod_cd" id="in_pod_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input">
						<input type="text" style="width:24px" value="" name="in_pod_yd_cd" id="in_pod_yd_cd" maxlength='2' dataformat='engup' style="ime-mode:disabled" class="input">
					</td>
					<th width="30">L/T</th>
					<td width="60" colspan="2"><%=JSPUtil.getCodeCombo("in_pod_lt", "", "", "CD20052", 0, "000001: :All")%>
					</td>
					<th class="align_right" style="height:20px">R/D Term</th>
			        <td class="align_left">
			        	<script type="text/javascript" >ComComboObject('rcv_term_cd', 2, 40, 1, 0, 0)</script>
			            <script type="text/javascript" >ComComboObject('de_term_cd', 2, 40, 1, 0, 0)</script>
			        </td>
			        <th>BKG Office</th>
					<td>
						<input type="text" style="width: 55px" value="" class="input" name="in_bkg_ofc_cd" maxlength='6' dataformat='enguponly' style="ime-mode:disabled">
					</td>						
				</tr>
				<tr>
					<th>VGM Option</th>
					<td colspan="3" >
						<input type="radio" class="trans" name="r_vgm_opt" id="A" value="" style="width:10px" checked><label for="A"> ALL</label>
					    <input type="radio" class="trans" name="r_vgm_opt" id="I" value="" style="width:10px"> <label for="I"> Received</label>
					    <input type="radio" class="trans" name="r_vgm_opt" id="N" value="" style="width:10px"><label for="N"> Not Received</label>
					</td>
					<th>VGM</th>
					<!-- <td><input type="text" style="width: 60px" value=""	class="input" name="in_vgm"  style="ime-mode:disabled"></td> -->
					<td><select class="input" name="in_vgm" id="in_vgm">
						 <option value="ALL">ALL</option>
						 <option value="ECOM">ECOM</option>
						 <option value="EDI">EDI</option>
					</select></td>
					<th style="text-align:right;">On Board Date</th>
					<td colspan="4">
						<input type="text" style="width:80px" value="" class="input"  name="board_from_dt" id="board_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input"  name="board_to_dt" id="board_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_board_date" id="btn_board_date"></button>
					</td>
					<th style="text-align:right;">Booking Date</th>
					<td colspan="3">
						<input type="text" style="width:80px" value="" class="input"  name="bkg_from_dt" id="bkg_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input"  name="bkg_to_dt" id="bkg_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_bkg_date" id="btn_bkg_date"></button>
					</td>
				</tr>
				<tr>
					<th>Customer</th>
					<td colspan="5">
						<script type="text/javascript">ComComboObject('p_bkg_cust_tp_cd', 1, 50, true, '');</script><!--
						--><input type="text" style="width:40px" value="" class="input" name="in_cust_cnt_cd" id="in_cust_cnt_cd" maxlength='2' dataformat='enguponly' style="ime-mode:disabled"><!-- 
						--><input type="text" style="width:60px" value="" class="input" name="in_cust_seq" id="in_cust_seq" maxlength='6' dataformat='num' style="ime-mode:disabled"><!-- 
						--><input type="text" style="width:156px" value="" class="input" name="in_cust_nm" id="in_cust_nm" maxlength='50' dataformat='engup' style="ime-mode:disabled">
					</td>
					<th>Validation</th>
					<td colspan="2">
						<input type="checkbox"  value="Y" name="mss_sig" id="mss_sig"><label for="mss_sig">Missing Signatory</label>
					</td>
					<td colspan="2">
						<input type="checkbox"  value="Y" name="late_upd" id="late_upd"><label for="late_upd">Late Update</label>
					</td>
					<th>Booking No.</th>
					<td>
						<input type="text" name="bkg_no"  id="bkg_no" class="input1" style="width:110px;" maxlength="13" dataformat="engup" />
						<button type="button" class="multiple_inq ir" style="background: url(./style/images/theme_default/sprite_common.png) -98px -157px no-repeat; background-color:#fff;" name="btn_multBkgNo" id="btn_multBkgNo"></button>
					</td>
				</tr>
				<tr>
					<td colspan="7">
					</td>
					<td colspan="2">
						<input type="checkbox"  value="Y" name="ovr_payld" id="ovr_payld"><label for="ovr_payld">Over P/L</label>
					</td>
					<td colspan="1">
						<input type="checkbox"  value="Y" name="diff_5_pct" id="diff_5_pct" onclick="onCheck(this);"><label for="diff_5_pct">+/- 5%</label>
					</td>
					<td>
						<input type="checkbox"  value="Y" name="diff_10_pct" id="diff_10_pct" onclick="onCheck(this);"><label for="diff_10_pct">+/- 10%</label>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

	<div id='layList' style='position:absolute; z-index:999; display:none; background-color: white;'> <!-- background-color: #d4f6ff; -->
		<table>
			<tr>
				<td>
					<label style="margin-right: 0px;">Rows : </label>
					<label style="margin-right: 0px;" id="rows">000</label>
					<label style="margin-right: 0px;">/</label>
					<label>100</label>
				</td>
			</tr>
		</table>
		<textarea id="mult_bkg_no" name="mult_bkg_no" placeholder="Booking No." class="multi_value mar_none" style="top:0; text-transform: uppercase; width:145px; height: 140px;"></textarea>
	</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear">
			<div class="opus_design_btn">
			<!-- <button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button> -->
			<button type="button" class="btn_accent" name="btn_edi" id="btn_edi">CLL EDI</button>
			<button type="button" class="btn_accent" name="btn_edi_others" id="btn_edi_others">Manual EDI</button>
			<!-- <button type="button" class="btn_accent" name="btn_email" id="btn_email">E-mail</button> -->
			<!--<button type="button" class="btn_accent" name="btn_chk_all" id="btn_chk_all">Check All</button>
			<button type="button" class="btn_accent" name="btn_un_chk_all" id="btn_un_chk_all">Uncheck All</button>-->
			<!-- <button type="button" class="btn_accent" name="btn_vgm_upd" id="btn_vgm_upd">VGM Update</button> -->
			 <button type="button" class="btn_accent" name="btn_vgm_close" id="btn_vgm_close">VGM Close</button>
			</div> 
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<div class="opus_design_grid" id="mainTable2" style="display: none;">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
	</div>
	<!-- opus_design_grid(E) -->
	<table class="grid_2 noinput2"> 
		<tbody>
			<tr>
				<td style="width:80px;text-align:center">Total</td>
			</tr>
			<tr>	
				<th>No. of BKG</th>
				<td><input type="text" name="ttl_bkg" style="width:80px;text-align:center" value="" readonly></td>
				<th>BKG Q'ty</th>
				<td><input type="text" name="ttl_qty_f" style="width:80px;text-align:right" value="" class="noinput2" readonly></td>
				<td><input type="text" name="ttl_qty_t" style="width:80px;text-align:right" value="" class="noinput2" readonly></td>
				<th>Declared VGM</th>
				<td><input type="text" name="ttl_vgm" style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>Non-Declared VGM</th>
				<td><input type="text" name="ttl_non_vgm" style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>Non-Received VGM</th>
				<td><input type="text" name="ttl_non_rcvd_vgm" style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>Close BKG</th>
				<td><input type="text" name="ttl_clz_bkg" style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
			</tr>
		</tbody>
	</table> 
</div>
</form>

	<!-- report popup  -->
<form name="form2" method="post">
    <input type="hidden" name="rfn" id="rfn" />
    <input type="hidden" name="mrd" id="mrd" />
    <input type="hidden" name="rd_title" id="rd_title" />
    <input type="hidden" name="rp" id="rp" />
    <input type="hidden" name="rv" id="rv" />
</form>