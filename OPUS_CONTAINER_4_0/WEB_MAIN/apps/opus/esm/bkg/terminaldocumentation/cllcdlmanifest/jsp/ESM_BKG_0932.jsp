<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   ESM_BKG_0932.jsp
 *@FileTitle  : Container Loading List(KOREA)_Summary 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/25
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0932Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0932Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error Message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String inVvdCd = "";
	String inPolCd = "";
	String inPolYdCd = "";
	String inCllType = "";
	String inBkgStsCd = "";
	String inCntrCfmFlg = "";
	String inSortType = "";
	String mainpage = "";
	String inBlCllData = "";

	String popup_title = "";

	Logger log = Logger
			.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	String pgmNo = request.getParameter("pgmNo");
	try {

		if ("ESM_BKG_0951".equals(pgmNo)) {
			popup_title = "Load Summary by POD_Block Stowage";
		} else {
			popup_title = "Container Loading List(KOREA)_Summary";
		}

		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		mainpage = StringUtil.xssFilter(request.getParameter("mainPage"));
		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCcd")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inPolCcd"));
		inPolYdCd = StringUtil.xssFilter(request.getParameter("inPolYdCd")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inPolYdCd"));
		inCllType = StringUtil.xssFilter(request.getParameter("inCllType")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inCllType"));
		inBkgStsCd = StringUtil.xssFilter(request.getParameter("inBkgStsCd")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inBkgStsCd"));
		inCntrCfmFlg = StringUtil.xssFilter(request.getParameter("inCntrCfmFlg")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inCntrCfmFlg"));
		inSortType = StringUtil.xssFilter(request.getParameter("inSortType")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inSortType"));
		inBlCllData = StringUtil.xssFilter(request.getParameter("inBlCllData")) == null ? ""
				: StringUtil.xssFilter(request.getParameter("inBlCllData"));

		event = (EsmBkg0932Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
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

<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd">
	<input type="hidden" name="pagerows" id="pagerows"> 
	<input type="hidden" name="in_vvd_cd" id="in_vvd_cd" value="<%=inVvdCd%>">
	<input type="hidden" name="in_pol_cd" id="in_pol_cd" value="<%=inPolCd%>">
	<input type="hidden" name="in_pol_yd_cd" id="in_pol_yd_cd" value="<%=inPolYdCd%>">
	<input type="hidden" name="in_cll_type" id="in_cll_type" value="<%=inCllType%>">
	<input type="hidden" name="in_bkg_sts_cd" id="in_bkg_sts_cd" value="<%=inBkgStsCd%>">
	<input type="hidden" name="in_cntr_cfm_flg" id="in_cntr_cfm_flg" value="<%=inCntrCfmFlg%>">
	<input type="hidden" name="in_bl_cll_data" id="in_bl_cll_data" value="<%=inBlCllData %>">
	<input type="hidden" name="in_sort_type" id="in_sort_type" value="1">
	<input type="hidden" name="in_ui_type" id="in_ui_type" value="M">
	<input type="hidden" name="in_by_type" id="in_by_type" value=""> 
	<input type="hidden" name="set_to" id="set_to" value=""> 
	<input type="hidden" name="set_fm" id="set_fm" value="">
	<!-- 개발자 작업	-->
	<input type="hidden" name="in_pgm_no" id="in_pgm_no" value="<%=pgmNo%>"> 
	<input type="hidden" name="vvd_cd" id="vvd_cd" readonly> 
	<input type="hidden" name="un_loc_cd" id="un_loc_cd" readonly> 
	<input type="hidden" name="vps_etd_dt" id="vps_etd_dt" readonly> 
	<input type="hidden" name="preview_vvd_cd" id="preview_vvd_cd" readonly> 
	<input type="hidden" name="preview_pol_cd" id="preview_pol_cd" readonly> 
	<input type="hidden" name="preview_vps_etd" id="preview_vps_etd" readonly>
	<input type="hidden" name="cssm_vvd" id="cssm_vvd">
	
	<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Container Loading List(KOREA)_Summary</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><input type="radio" name="in_by_type_temp" id="P" value="P" onClick="goBySearch('P')" class="trans" checked><label for="P">By POD</label><!-- 
			 --><input type="radio" name="in_by_type_temp" id="M" value="M" class="trans" onClick="goBySearch('M')"><label for="M">By MLB</label><!-- 
			 --><input type="radio" name="in_by_type_temp" id="T" value="T" class="trans" onClick="goBySearch('T')"><label for="T">By T/S VVD</label><!-- 
			 <button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button> 
			 --><button type="button" class="btn_normal" name="btn_Print" 	id="btn_Print">Print</button><!-- 
			<button type="button" class="btn_normal" name="btn_Pdf_Print" 	id="btn_Pdf_Print">PDF Print</button>
			 --><%if(!"true".equals(mainpage)){ %><!-- 
				 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!-- 
			 --><%} %><!-- 		
		 --></div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
	<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<!-- <table>
				<colgroup>
					<col width="50">
					<col width="*">
				</colgroup>
				<tr>
					<th>TO :</th>
					<td><input type="text" style="width: 300px;"class="input" name="setText1" id="setText1" dataformat="exceptengdn" maxlength="80">
						 <button type="button" name="btns_search1" id="btns_search1" class="input_seach_btn"></button></td>
				</tr>
				<tr>
					<th>FM :</th>
					<td><!-- 
					<input type="text" style="width: 300px;" class="input" name="setText2" id="setText2" dataformat="exceptengdn" maxlength="80">
					<button type="button" name="btns_search2" id="btns_search1" class="input_seach_btn"></button></td>
				</tr>
			</table> 
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>-->
			<table>
				<colgroup>
					<col width="50">
					<col width="150">
					<col width="80">
					<col width="80">
					<col width="80">
					<col width="*">
				</colgroup>
				<tr>
					<th>VVD :</th>
					<td><input type="text" style="width: 200px;" class="input2" value="" name="vvd_cd_nm" id="vvd_cd_nm" readonly></td>
					<th>POL :</th>
					<td><input type="text" style="width: 60px;" class="input2" value="" name="pol_cd_print" id="pol_cd_print" readonly></td>
					<th>ETD :</th>
					<td><input type="text" style="width: 120px;" class="input2" value="" name="vps_etd" id="vps_etd" readonly></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">		
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="200">
					<col width="*">
				</colgroup>
				<tr>
					<th class="title_design pad_btm_12">Loading Summary by
					<div id="1pod" style="display: inline;">POD</div>
					<div id="1apod" style="display: none;">A.POD</div>
					<div id="1mlb" style="display: none;">MLB</div>
					</th>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table>
				<tr>
					<td> * Note : excluded Void slot, POD - UN code</td>
				</tr>
			</table>
		</div>
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_inquiry" id="mainTable">
			<table class="grid_2">
				<colgroup>
					<col width="0">
					<col width="10">
					<col width="100">
				</colgroup>
				<tr >
					<th><strong>TOTAL(20'/40')</strong></th>
					<%if("LOCAL".equals(inCllType)){ %>
					<td><input type="text" name="local_20" id="local_20" value="" size="1" style="width: 130px; text-align: center; font-weight: bold" readonly><!-- 
						 --><input type="text" name="local_40" id="local_40" value="" size="1" style="width: 450px; margin-left:4px; text-align: center; font-weight: bold" readonly></td>
				    <%}else if("TS".equals(inCllType)){ %>
					<td><input type="text" name="ts_20" id="ts_20" value="" size="1" style="width: 130px; text-align: center; font-weight: bold;" readonly><!-- 
						 --><input type="text" name="ts_40" id="ts_40" value="" size="1" style="width: 450px; text-align: center; font-weight: bold; margin-left:4px;" readonly></td>
					<%}else if("EMPTY".equals(inCllType)){ %>
					<td><input type="text" name="mt_20" id="mt_20" value="" size="1" style="width: 130px; text-align: center; font-weight: bold;" readonly><!-- 
						 --><input type="text" name="mt_40" id="mt_40" value="" size="1" style="width: 450px; text-align: center; font-weight: bold; margin-left:4px;" readonly></td>
				    <%} %>
					<!--<td><input type="text" name="mt_20" id="mt_20" value="" size="2" style="width: 38px; text-align: right; font-weight: bold;" readonly>  
						<input type="text" name="mt_40" id="mt_40" value="" size="2" style="width: 124px; text-align: right; font-weight: bold;margin-left:4px;" readonly></td>
					<td><input type="text" name="sm_20" id="sm_20" value="" size="2" style="width: 38px; text-align: right; font-weight: bold;" readonly>
						 <input type="text" name="sm_40" id="sm_40" value="" size="2" style="width: 124px; text-align: right; font-weight: bold; margin-left:4px;" readonly></td>-->
				</tr>
				<tr>
					<th><strong>TOTAL(20'+40')</strong></th>
					<%if("LOCAL".equals(inCllType)){ %>
					<td colspan="2"><input type="text" name="local" id="local" value="" size="1" style="width: 588px; text-align: center; font-weight: bold" readonly></td>
					<%}else if("TS".equals(inCllType)){ %>
					<td colspan="2"><input type="text" name="ts" id="ts" value="" size="1" style="width: 588px; text-align: center; font-weight: bold" readonly></td>
					<%}else if("EMPTY".equals(inCllType)){ %>
					<td colspan="2"><input type="text" name="mt" id="mt" value="" size="1" style="width: 588px; text-align: center; font-weight: bold" readonly></td>
					<%} %>
					<!--  <td><input type="text" name="mt" id="mt" value="" size="2" style="width: 170px; text-align: right; font-weight: bold" readonly></td>
					<td><input type="text" name="sm" id="sm" value="" size="2" style="width: 170px; text-align: right; font-weight: bold" readonly></td>-->
				</tr>
			</table>
		</div>
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="240">
					<col width="*">
				</colgroup>
				<tr>
					<th class="title_design pad_btm_12">Special Cargo Summary by
						<div id="2pod" style="display: inline;">POD</div>
						<div id="2apod" style="display: none;">A.POD</div>
						<div id="2mlb" style="display: none;">MLB</div>
					</th>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class="opus_design_inquiry">
			<!--<table class="grid_2">
				<colgroup>
					<col width="70">
					<col width="*">
				</colgroup>
				 <tr>
					<th><strong>Remarks</strong></th>
					<td><textarea name="remark" id="remark" style="width: 100%;resize: none;" rows="5" ></textarea></td>
				</tr>
			</table> -->
		</div>
		<div class="opus_design_grid" id="mainTable" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet6');</script>
		</div>
		<div class="opus_design_inquiry" id="mainTable" style="display: none">
			<table>
				<colgroup>
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="*">
				</colgroup> 
				<tr>
					<th>D2</th>
					<td><input type="text" name="local_d2" id="local_d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>D4</th>
					<td><input type="text" name="local_d4" id="local_d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>D5</th>
					<td><input type="text" name="local_d5" id="local_d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td>D7</td>
					<td><input type="text" name="local_d7" id="local_d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>D8</th>
					<td><input type="text" name="local_d8" id="local_d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td>D9</td>
					<td><input type="text" name="local_d9" id="local_d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>DW</th>
					<td><input type="text" name="local_dw" id="local_dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>DX</th>
					<td><input type="text" name="local_dx" id="local_dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>R2</th>
					<td><input type="text" name="local_r2" id="local_r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>R4</th>
					<td><input type="text" name="local_r4" id="local_r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>R5</th>
					<td><input type="text" name="local_r5" id="local_r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>F2</th>
					<td><input type="text" name="local_f2" id="local_f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>F4</th>
					<td><input type="text" name="local_f4" id="local_f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>F5</th>
					<td><input type="text" name="local_f5" id="local_f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
				<tr>
					<th>O2</th>
					<td><input type="text" name="local_o2" id="local_o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>O4</th>
					<td><input type="text" name="local_o4" id="local_o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>O5</th>
					<td><input type="text" name="local_o5" id="local_o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>S2</th>
					<td><input type="text" name="local_s2" id="local_s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>S4</th>
					<td><input type="text" name="local_s4" id="local_s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>T2</th>
					<td><input type="text" name="local_t2" id="local_t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>T4</th>
					<td><input type="text" name="local_t4" id="local_t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>A2</th>
					<td><input type="text" name="local_a2" id="local_a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>A4</th>
					<td><input type="text" name="local_a4" id="local_a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>P2</th>
					<td><input type="text" name="local_p2" id="local_p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>P4</th>
					<td><input type="text" name="local_p4" id="local_p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>Z2</th>
					<td><input type="text" name="local_z2" id="local_z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>Z4</th>
					<td><input type="text" name="local_z4" id="local_z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td></td>
					<td></td>
					</tr>
				<tr>
					<th >D3</th>
					<td><input type="text" name="local_d3" id="local_d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >R9</th>
					<td><input type="text" name="local_r9" id="local_r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th   style="font-size:8">ETC</th>
					<td><input type="text" name="local_etc" id="local_etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td></td>
					<td align="center" class="sm"></td>
					<td></td>
					<td align="center" class="sm"></td>
					<td></td>
					<td align="center" class="sm"></td>
					<td></td>
					<td align="center" class="sm"></td>
					<td></td>
					<td align="center" class="sm"></td>
					<td></td>
					<td align="center" class="sm"></td>
					<td></td>
					<td align="center" class="sm"></td>
					<td></td>
					<td align="center" class="sm"></td>
					<td></td>
					<td align="center" class="sm"></td>
					<th>Total</th>
					<td><input type="text" name="local_totalTpSize" id="local_totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
			</table>
		</div>
		<div class="opus_design_inquiry" id="mainTable" style="display:none">
			<table> 
			 	<tr>
					<th width="37">Local</th>
					<td width="32"><input type="text" name="local_local" id="local_local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">Full</th>
					<td width="30"><input type="text" name="local_localFull" id="local_localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">Empty</th>
					<td width="30"><input type="text" name="local_localEmpty" id="local_localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head" width="35">T/S		</td>
					<td width="30"><input type="text" name="local_ts" id="local_ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<td  width="35">Full</td>
					<td width="30"><input type="text" name="local_tsFull" id="local_tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">Empty</th>
					<td width="30"><input type="text" name="local_tsEmpty" id="local_tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<td class="tr2_head" width="35">WGT</td>
					<td width="60"><input type="text" name="local_wgt" id="local_wgt" value="" size="15" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
			</table>
		</div>
		<!-- opus_desing_data(S) -->
		
			<!-- opus_desing_grid(S) -->
		<div class="opus_design_grid" id="mainTable" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet7');</script>
			<script type="text/javascript">ComSheetObject('sheet8');</script>
			<script type="text/javascript">ComSheetObject('sheet9');</script>
			<script type="text/javascript">ComSheetObject('sheet10');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_desing_data(S) -->
		<div class="opus_design_inquiry" id="mainTable" style="display:none">
			<table> 
				<tr>
					<th  width="35">D2	</th>
					<td width="30"><input type="text" name="ts_d2" id="ts_d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">D4	</th>
					<td width="30"><input type="text" name="ts_d4" id="ts_d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">D5</th>
					<td width="30"><input type="text" name="ts_d5" id="ts_d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">D7</th>
					<td width="30"><input type="text" name="ts_d7" id="ts_d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">D8</th>
					<td width="30"><input type="text" name="ts_d8" id="ts_d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">D9	</th>
					<td width="30"><input type="text" name="ts_d9" id="ts_d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">DW</th>
					<td width="30"><input type="text" name="ts_dw" id="ts_dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">DX</th>
					<td width="30"><input type="text" name="ts_dx" id="ts_dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">R2</th>
					<td width="30"><input type="text" name="ts_r2" id="ts_r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">R4</th>
					<td width="30"><input type="text" name="ts_r4" id="ts_r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">R5</th>
					<td width="30"><input type="text" name="ts_r5" id="ts_r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">F2</th>
					<td width="30"><input type="text" name="ts_f2" id="ts_f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">F4</th>
					<td width="30"><input type="text" name="ts_f4" id="ts_f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th  width="35">F5</th>
					<td width="30"><input type="text" name="ts_f5" id="ts_f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
				<tr>
					<th >O2</th>
					<td><input type="text" name="ts_o2" id="ts_o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >O4</th>
					<td><input type="text" name="ts_o4" id="ts_o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >O5</th>
					<td><input type="text" name="ts_o5" id="ts_o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >S2</th>
					<td><input type="text" name="ts_s2" id="ts_s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >S4</th>
					<td><input type="text" name="ts_s4" id="ts_s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >T2</th>
					<td><input type="text" name="ts_t2" id="ts_t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >T4</th>
					<td><input type="text" name="ts_t4" id="ts_t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >A2</th>
					<td><input type="text" name="ts_a2" id="ts_a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >A4</th>
					<td><input type="text" name="ts_a4" id="ts_a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >P2</th>
					<td><input type="text" name="ts_p2" id="ts_p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >P4</th>
					<td><input type="text" name="ts_p4" id="ts_p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >Z2</th>
					<td><input type="text" name="ts_z2" id="ts_z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th >Z4</th>
					<td><input type="text" name="ts_z4" id="ts_z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td ></td>
					<td align="center" class="sm"></td>
					</tr>
				<tr>
					<th >D3</th>
					<td><input type="text" name="ts_d3" id="ts_d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td >R9</td>
					<td><input type="text" name="ts_r9" id="ts_r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th style="font-size:8">ETC</th>
					<td><input type="text" name="ts_etc" id="ts_etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<th  colspan="2">Total</th>
					<td colspan="2"><input type="text" name="ts_totalTpSize" id="ts_totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry" id="mainTable" style="display:none">
			<table> 
			 	<tr>
					<th>Local</th>
					<td><input type="text" name="ts_local" id="ts_local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>Full</th>
					<td><input type="text" name="ts_localFull" id="ts_localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>Empty</th>
					<td><input type="text" name="ts_localEmpty" id="ts_localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>T/S</th>
					<td><input type="text" name="ts_ts" id="ts_ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>Full</th>
					<td><input type="text" name="ts_tsFull" id="ts_tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>Empty</th>
					<td><input type="text" name="ts_tsEmpty" id="ts_tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>WGT</th>
					<td><input type="text" name="ts_wgt" id="ts_wgt" value="" size="15" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(S) -->
		
		
		<!-- opus_desing_grid(S) -->
		<div class="opus_design_grid" id="mainTable" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet11');</script>
			<script type="text/javascript">ComSheetObject('sheet12');</script>
			<script type="text/javascript">ComSheetObject('sheet13');</script>
			<script type="text/javascript">ComSheetObject('sheet14');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_desing_data(S) -->
		<div class="opus_design_inquiry" id="mainTable" style="display:none">
			<table> 
				<tr>
					<th>D2	</th>
					<td><input type="text" name="preview_d2" id="preview_d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>D4</th>
					<td><input type="text" name="preview_d4" id="preview_d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>D5</th>
					<td><input type="text" name="preview_d5" id="preview_d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>D7</th>
					<td><input type="text" name="preview_d7" id="preview_d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>D8</th>
					<td><input type="text" name="preview_d8" id="preview_d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>D9</th>
					<td><input type="text" name="preview_d9" id="preview_d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>DW</th>
					<td><input type="text" name="preview_dw" id="preview_dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>DX</th>
					<td><input type="text" name="preview_dx" id="preview_dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>R2</th>
					<td><input type="text" name="preview_r2" id="preview_r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>R4</th>
					<td><input type="text" name="preview_r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>R5</th>
					<td><input type="text" name="preview_r5" id="preview_r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>F2</th>
					<td><input type="text" name="preview_f2" id="preview_f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>F4</th>
					<td><input type="text" name="preview_f4" id="preview_f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>F5</th>
					<td><input type="text" name="preview_f5" id="preview_f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
				<tr>
					<th>O2</th>
					<td><input type="text" name="preview_o2" id="preview_o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>O4</th>
					<td><input type="text" name="preview_o4" id="preview_o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>O5</th>
					<td><input type="text" name="preview_o5" id="preview_o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>S2</th>
					<td><input type="text" name="preview_s2" id="preview_s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>S4</th>
					<td><input type="text" name="preview_s4" id="preview_s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>T2</th>
					<td><input type="text" name="preview_t2" id="preview_t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>T4</th>
					<td><input type="text" name="preview_t4" id="preview_t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>A2</th>
					<td><input type="text" name="preview_a2" id="preview_a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>A4</th>
					<td><input type="text" name="preview_a4" id="preview_a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>P2</th>
					<td><input type="text" name="preview_p2" id="preview_p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>P4</th>
					<td><input type="text" name="preview_p4" id="preview_p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>Z2</th>
					<td><input type="text" name="preview_z2" id="preview_z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>Z4</th>
					<td><input type="text" name="preview_z4" id="preview_z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<td></td>
					<td align="center" class="sm"></td>
				</tr>
				 <tr>
					<th>D3</th>
					<td><input type="text" name="preview_d3" id="preview_d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th>R9</th>
					<td><input type="text" name="preview_r9" id="preview_r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
					<th style="font-size:8">ETC</th>
					<td><input type="text" name="preview_etc" id="preview_etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>		
					<td></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>
					<td ></td>
					<td align="center" class="sm"></td>		
					<td ></td>
					<td align="center" class="sm"></td>		
					<td ></td>
					<td align="center" class="sm"></td>		
					<td ></td>
					<td align="center" class="sm"></td>		
					<th  colspan="2">Total</th>
					<td  colspan="2"><input type="text" name="preview_totalTpSize" id="preview_totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry" id="mainTable" style="display: none"> 
			<table> 
				<colgroup>
					<col width="37">
					<col width="32">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="30">
					<col width="35">
					<col width="40">
				</colgroup>
			 	<tr>
					<th>Local</th>
					<td><input type="text" name="preview_local" id="preview_local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>Full</th>
					<td><input type="text" name="preview_localFull" id="preview_localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>Empty</th>
					<td><input type="text" name="preview_localEmpty" id="preview_localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>T/S</th>
					<td><input type="text" name="preview_ts" id="preview_ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>Full</th>
					<td><input type="text" name="preview_tsFull" id="preview_tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>Empty</th>
					<td><input type="text" name="preview_tsEmpty" id="preview_tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
					<th>WGT</th>
					<td><input type="text" name="preview_wgt" id="preview_wgt" value="" size="10" style="text-align:center;font-weight:bold" readonly></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
</form>