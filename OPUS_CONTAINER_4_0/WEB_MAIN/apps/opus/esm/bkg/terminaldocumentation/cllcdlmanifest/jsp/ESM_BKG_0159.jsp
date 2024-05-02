<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0159.jsp
*@FileTitle  : ESM_BKG_0159
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0159Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0159Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");
	String whereGubun = JSPUtil.getParameter(request,"pgmNo");
	String bkgNoList = JSPUtil.getParameter(request,"bkg_no_list");
	String popMode = JSPUtil.getParameter(request,"pop_mode");
	String vgmVvd = JSPUtil.getParameter(request,"vgm_vvd");
	String vgmPol = JSPUtil.getParameter(request,"vgm_pol");
	//String whereGubun = (String)request.getAttribute("UI_NUMBER");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0159Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="in_list_type" id="in_list_type" />
<input type="hidden" name="in_cntr_match" id="in_cntr_match" />
<input type="hidden" name="in_pol_ts" id="in_pol_ts" />
<input type="hidden" name="in_pod_ts" id="in_pod_ts" />
<input type="hidden" name="in_cntr_cfm_flg" id="in_cntr_cfm_flg" />
<input type="hidden" name="in_bkg_cgo_tp_cd_temp" id="in_bkg_cgo_tp_cd_temp" />
<input type="hidden" name="vvd_nkm" id="vvd_nkm" />
<input type="hidden" name="un_loc_cd" id="un_loc_cd" />
<input type="hidden" name="vps_eta_dt" id="vps_eta_dt" />
<input type="hidden" name="vps_etd_dt" id="vps_etd_dt" />
<input type="hidden" name="vps_etb_dt" id="vps_etb_dt" />
<input type="hidden" name="in_order_by_type" id="in_order_by_type" />
<input type="hidden" name="in_ofc_cd_type" id="in_ofc_cd_type" />
<input type="hidden" name="in_including_type" id="in_including_type" />
<input type="hidden" name="key" id="key" />
<input type="hidden" name="fax" id="fax" />
<input type="hidden" name="email" id="email" />
<input type="hidden" name="vessel_name" id="vessel_name" />
<input type="hidden" name="where_gubun" id="where_gubun" value="<%=whereGubun %>" />
<input type="hidden" name="bkg_no_list" id="bkg_no_list" value="<%=bkgNoList %>" />
<input type="hidden" name="pop_mode" id="pop_mode" value="<%=popMode %>" />
<input type="hidden" name="vgm_vvd" id="vgm_vvd" value="<%=vgmVvd %>" />
<input type="hidden" name="vgm_pol" id="vgm_pol" value="<%=vgmPol %>" />

<input type="hidden" size="200" name="com_mrdPath" value="apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0783.mrd" id="com_mrdPath" />
<input type="hidden" size="200" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" size="200" name="com_mrdTitle" value="Container Loading/Discharging List_Print" id="com_mrdTitle" />
<input type="hidden" size="200" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Container Loading/Discharging List_Print</span>" id="com_mrdBodyTitle">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downExcel" 	id="btn_downExcel">Down Excel</button><!--
		 <button type="button" class="btn_normal" name="TAO/ODCY" 	id="TAO/ODCY">TAO/ODCY</button> 
		 --><button type="button" class="btn_normal" name="btn_print" 	id="btn_print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->

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
		<div class="layout_wrap">
			<div class="layout_flex_fixed floatR" style="width:190px;">
				<h3 class="title_design">Container Status</h3>
				<table class="grid2 wAuto" style="width:200px;">
					<tr>
						<th>Confirm</th>
						<td align="center"><input type="checkbox" value="" class="trans" checked name="in_cntr_cfm_flg1" id="in_cntr_cfm_flg1" /><label for="in_cntr_cfm_flg1">Y</label><!-- 
						 --><input type="checkbox" value="" class="trans" checked name="in_cntr_cfm_flg2" id="in_cntr_cfm_flg2" /><label for="in_cntr_cfm_flg2">N</label></td>
					</tr>
					<tr>
						<th>CNTR#<br> Non Match</th>
						<td align="center"><input type="checkbox" value=""class="trans"  name="in_cntr_match_temp" id="in_cntr_match_temp" <%if(!whereGubun.equals("ESM_BKG_0159-1")){%>disabled<%}%>>
					</tr>
					<tr>
						<th colspan="2" class="mar_top_8 sm">
							<label for="in_including_type_temp">Including Partial Container</label><!--
							--><input type="checkbox" value="Y" class="trans" name="in_including_type_temp" checked id="in_including_type_temp" />
						</th>
					</tr>
				</table>
			</div>
			<div class="layout_flex_flex">
				<table>
					<colgroup>
						<col width="60">
						<col width="180">
  						<col width="5">
						<col width="180">
						<col width="60">
						<col width="122">
						<col width="60">
						<col width="242">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th class="sm">List Type</th>
				   	 		<td class="sm"><input type="radio" name="in_list_type_temp" id="in_list_type_temp" value=""class="trans" onClick="clickListType(0);" <%if(whereGubun.equals("ESM_BKG_0159-1")){%>checked<%}%>><label for="in_list_type_temp">Loading</label><!-- 
				   	 		 --><input type="radio" value="" name="in_list_type_temp" id="in_list_type_temp_1" onclick="clickListType(1);" class="trans" <%if(whereGubun.equals("ESM_BKG_0159-2")){%>checked<%}%>><label for="in_list_type_temp_1">Discharging</label></td>
				   	 		<td></td>
				   	 		<th class="sm mar_left_8 pad_left_4"><input type="radio" name="in_ofc_cd_type_temp" id="in_ofc_cd_type_temp" value=""class="trans" checked><label for="in_ofc_cd_type_temp">Booking</label><!-- 
				   	 		 --><input type="radio" name="in_ofc_cd_type_temp" id="in_ofc_cd_type_temp_1" value=""class="trans"><label for="in_ofc_cd_type_temp_1">Sales Office</label></th>
							<td class="sm pad_rgt_4"><input type="text" style="width:50px; ime-mode:disabled" class="input" name="in_ofc_cd" value="" maxlength="5" dataformat="enguponly"></td>
							<th>Booking Status</th>
							<td>
								<select style="width:50px;" class="input" name="in_bkg_sts_cd" id="in_bkg_sts_cd">
								<option value="A" selected>All</option>
								<option value="F">F</option>
								<option value="W">W</option>
								</select></td>
							<th>Cargo Type</th>
							<td><script type="text/javascript">ComComboObject('in_bkg_cgo_tp_cd', 2, 60, 1, 0);</script></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="40">
						<col width="120">
						<col width="40">
						<col width="188">
						<col width="210">
						<col width="200">
						<col width="103">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th title="Vessel Voyage Direction">VVD</th>
							<td><input type="text" style="width:90px;" name="in_vvd_cd" class="input1" value="" dataformat="engup" otherchar="," id="in_vvd_cd" />
							<img class="cursor" src="img/opus/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="javascript:getVvds();"></td>
							<th title="Port of Loading">POL</th>
							<td><input type="text" id="pod_cd" style="width:55px; ime-mode:disabled" name="in_pol_cd" class="<%if(whereGubun.equals("ESM_BKG_0159-1")){%>input1<%}else{%>input<%}%>" value="" maxlength="5" dataformat="engup"><!-- 
							 --><input type="text" id="pod_yd_cd" style="width:30px;ime-mode:disabled" class="<%if(whereGubun.equals("ESM_BKG_0159-1")){%>input1<%}else{%>input<%}%>" name="in_pol_yd_cd" value="" maxlength="2" dataformat="engup"><!--
							 -->(<input type="checkbox" value="" class="trans" name="in_pol_ts1" id="in_pol_ts1" /><!--
							 --><label for="in_pol_ts1">Local</label><input type="checkbox" value="" class="trans" name="in_pol_ts2" id="in_pol_ts2" /><!--
							 --><label for="in_pol_ts2" style="margin-right:0">T/S</label>)</td>
							<th title="Port of Discharging">POD</th>
							<td><input type="text" id="pol_cd" style="width:50px;ime-mode:disabled" class="<%if(whereGubun.equals("ESM_BKG_0159-1")){%>input<%}else{%>input1<%}%>" name="in_pod_cd" value="" maxlength="5" dataformat="engup"><!-- 
							 --><input type="text" id="pol_yd_cd" style="width:30px;ime-mode:disabled" class="<%if(whereGubun.equals("ESM_BKG_0159-1")){%>input<%}else{%>input1<%}%>" value="" name="in_pod_yd_cd" maxlength="2" dataformat="engup"><!--
							 -->(<input type="checkbox" value="" class="trans" name="in_pod_ts1" id="in_pod_ts1" /><label for="in_pod_ts1">Local</label><!-- 
							 --><input type="checkbox" value="" class="trans" name="in_pod_ts2" id="in_pod_ts2" /><label for="in_pod_ts2" style="margin-right:0">T/S</label>)</td>
							<th>EQ TP/SZ</th>
							<td><script type="text/javascript">ComComboObject('in_cntr_tpsz_cd', 2, 60, 1, 0);</script></td>
						</tr>				
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="40">
						<col width="80">
						<col width="80">
						<col width="60">
						<col width="80">
						<col width="100">
						<col width="137">
						<col width="140">
						<col width="132">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th title="Place of Receipt">POR</th>
							<td><input type="text" style="width:50px;" class="input" name="in_por_cd" value="" maxlength="5" dataformat="engup" id="in_por_cd" /></td>
							<th title="Place of Delivery">DEL</th>
							<td><input type="text" style="width:50px;" class="input" name="in_del_cd" value="" maxlength="5" dataformat="engup" id="in_del_cd" /></td>
							<th>R/D Term</th>
							<td><script type="text/javascript">ComComboObject('in_rcv_term_cd', 2, 60, 1, 0);</script><!-- 
							 --><script type="text/javascript">ComComboObject('in_de_term_cd', 2, 60, 1, 0);</script></td>
							<th>Service Mode</th>
							<td><script type="text/javascript">ComComboObject('in_org_trns_svd_mod_cd', 2, 80, 1, 0);</script><!-- 
							 --><script type="text/javascript">ComComboObject('in_dest_trns_svc_mod_cd', 2, 80, 1, 0);</script></td>
							<th>SCC</th>
							<td><input type="text" style="width:95px;" class="input" name="in_scc_cd" value="" maxlength="5" dataformat="enguponly" id="in_scc_cd" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="90" />
						<col width="737" />		
						<col width="100" />		
						<col width="*" />	
					</colgroup>
					<tbody>
						<tr>
							<th class="sm">Special Cargo</th>
							<td class="sm"><input type="checkbox" value="Y" class="trans" name="in_dcgo_flg" id="in_dcgo_flg" /><label for="in_dcgo_flg">Danger</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_rc_flg" id="in_rc_flg"><label for="in_rc_flg">Reefer</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_awk_cgo_flg" id="in_awk_cgo_flg"><label for="in_awk_cgo_flg">Awkward</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_bb_cgo_flg" id="in_bb_cgo_flg"><label for="in_bb_cgo_flg">Break Bulk</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_stwg_cd" id="in_stwg_cd"><label for="in_stwg_cd">Stowage</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_hot_de_flg" id="in_hot_de_flg"><label for="in_hot_de_flg">Hot (Premier)</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_rd_cgo_flg" id="in_rd_cgo_flg"><label for="in_rd_cgo_flg">Reefer Dry</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_soc_flg" id="in_soc_flg"><label for="in_soc_flg">SOC</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_prct_flg" id="in_prct_flg"><label for="in_prct_flg">Pre-caution</label><!-- 
						     --><input type="checkbox" value="Y" class="trans" name="in_hngr_flg" id="in_hngr_flg"><label for="in_hngr_flg">GOH</label></td> 
							<th>Full P/UP Yard</th>
							<td><input type="text" style="width:78px;" class="input" name="in_pkup_nod_cd" value="" maxlength="7" dataformat="engup" id="in_pkup_nod_cd" /></td>
						</tr>					
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_ediDownload" id="btn_ediDownload">EDI Download</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_cllForEdi"  	id="btn_cllForEdi">CLL for EDI</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_edi" 	id="btn_edi">EDI</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_faxemail" 	id="btn_faxemail">Fax/E-mail</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_sort" 	id="btn_sort">Sort</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable2" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable3" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable3" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable3" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
	<!-- opus_design_grid(S) -->
	
	<div class="opus_design_data">
		<table class="grid_2">
			<tr>
				<th>D2</th>
				<td><input type="text" name="d2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d2" class="w100"/></td>
				<th>D4</th>
				<td><input type="text" name="d4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d4" class="w100"/></td>
				<th>D5</th>
				<td><input type="text" name="d5" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d5" class="w100"/></td>
				<th>D7</th>
				<td><input type="text" name="d7" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d7" class="w100"/></td>
				<th>D8</th>
				<td><input type="text" name="d8" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d8" class="w100"/></td>
				<th>D9</th>
				<td><input type="text" name="d9" value="" size="2" style="text-align:center;font-weight:bold" readonly id="d9" class="w100"/></td>
				<th>DW</th>
				<td><input type="text" name="dw" value="" size="2" style="text-align:center;font-weight:bold" readonly id="dw" class="w100"/></td>
				<th>DX</th>
				<td><input type="text" name="dx" value="" size="2" style="text-align:center;font-weight:bold" readonly id="dx" class="w100"/></td>
				<th>R2</th>
				<td><input type="text" name="r2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="r2" class="w100"/></td>
				<th>R4</th>
				<td><input type="text" name="r4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="r4" class="w100" /></td>
				<th>R5</th>
				<td><input type="text" name="r5" value="" size="2" style="text-align:center;font-weight:bold" readonly id="r5" class="w100" /></td>
				<th>F2</th>
				<td><input type="text" name="f2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="f2" class="w100"/></td>
				<th>F4</th>
				<td><input type="text" name="f4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="f4" class="w100" /></td>
				<th>F5</th>
				<td><input type="text" name="f5" value="" size="2" style="text-align:center;font-weight:bold" readonly id="f5" class="w100" /></td>
			</tr>
			<tr>
				<th>O2</th>
				<td><input type="text" name="o2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="o2" class="w100"/></td>
				<th>O4</th>
				<td><input type="text" name="o4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="o4" class="w100"/></td>
				<th>O5</th>
				<td><input type="text" name="o5" value="" size="2" style="text-align:center;font-weight:bold" readonly id="o5" class="w100"/></td>
				<th>S2</th>
				<td><input type="text" name="s2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="s2" class="w100"/></td>
				<th>S4</th>
				<td><input type="text" name="s4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="s4" class="w100"/></td>
				<th>T2</th>
				<td><input type="text" name="t2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="t2" class="w100"/></td>
				<th>T4</th>
				<td><input type="text" name="t4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="t4" class="w100"/></td>
				<th>A2</th>
				<td><input type="text" name="a2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="a2" class="w100"/></td>
				<th>A4</th>
				<td><input type="text" name="a4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="a4" class="w100"/></td>
				<th>P2</th>
				<td><input type="text" name="p2" value="" size="2" style="text-align:center;font-weight:bold" readonly id="p2" class="w100"/></td>
				<th>P4</th>
				<td><input type="text" name="p4" value="" size="2" style="text-align:center;font-weight:bold" readonly id="p4" class="w100"/></td>
				<th>20'</th>
				<td><input type="text" name="total20" value="" size="2" style="text-align:center;font-weight:bold" readonly id="total20" class="w100"/></td>
				<th>40'</th>
				<td colspan="5"><input type="text" name="total40" value="" size="2" style="text-align:center;font-weight:bold" readonly id="total40" class="w100"/></td>

			</tr>
		</table>
	<table class="grid_2">
			<tr>
				<th>Full</th>
				<td><input type="text" name="full" value="" size="3" style="text-align:center;font-weight:bold" readonly id="full" class="w100"/></td>
				<th>Empty</th>
				<td><input type="text" name="empty" value="" size="3" style="text-align:center;font-weight:bold" readonly id="empty" class="w100"/></td>
				<th>Local</th>
				<td><input type="text" name="local" value="" size="3" style="text-align:center;font-weight:bold" readonly id="local" class="w100"/></td>
				<th>T/S</th>
				<td><input type="text" name="ts" value="" size="3" style="text-align:center;font-weight:bold" readonly id="ts"class="w100" /></td>
				<th>Est.</th>
				<td><input type="text" name="ewgt" value="" size="10" style="text-align:center;font-weight:bold" readonly id="ewgt" class="w100"/></td>
				<th>Weight</th>
				<td><input type="text" name="wgt" value="" size="10" style="text-align:center;font-weight:bold" readonly id="wgt" class="w100"/></td>
				<th>Measure</th>
				<td><input type="text" name="measure" value="" size="10" style="text-align:center;font-weight:bold" readonly id="measure" class="w100"/></td>
				<th><b>Total</b></th>
				<td><input type="text" name="totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly id="totalTpSize" class="w100"/></td>
			</tr>
		</table>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet6');</script>
		</div>
	</div>
</div>
</form>