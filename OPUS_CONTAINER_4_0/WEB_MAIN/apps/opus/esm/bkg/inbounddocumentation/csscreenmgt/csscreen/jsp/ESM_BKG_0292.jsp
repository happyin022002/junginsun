<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292.jsp
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0292Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0292Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CsScreenMgtSC.CsScreenBC");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0292Event)request.getAttribute("Event");
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
	var strUsr_id    = "<%=strUsr_id%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
        $('<button type="button" class="btn_accent" name="btn_Retrieve"		id="btn_Retrieve">Retrieve</button>').appendTo(".opus_design_btn");
        $('<button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button>').appendTo(".opus_design_btn");
        $('<button type="button" class="btn_normal" name="btn_History" 		id="btn_History">History</button>').appendTo(".opus_design_btn");
        $('<button type="button" class="btn_normal" name="btn_BLPreview" 	id="btn_BLPreview">B/L Preview</button>').appendTo(".opus_design_btn");
        $('<button type="button" class="btn_normal" name="btn_BkgMain"   	id="btn_BkgMain">BKG Main</button>').appendTo(".opus_design_btn");
        $('<button type="button" class="btn_normal" name="btn_charge"   	id="btn_charge">Charge</button>').appendTo(".opus_design_btn");
        $('#btn_charge').after($('#btn_Close'));
		loadPage();
	}
	
</script>


<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="mainPage" name="mainPage" value="<%=JSPUtil.getNull(request.getParameter(" mainpage")) %>" type="hidden" />
<input id="h_cntr_no" name="h_cntr_no" value="" type="hidden" />
<input id="h_po_no" name="h_po_no" value="" type="hidden" />
<input id="hdn_bl_no" name="hdn_bl_no" value="" type="hidden" />
<input id="xmlData" name="xmlData" value="" type="hidden" />
<input id="bl_no" name="bl_no" value="" type="hidden" />
<input id="h_split" name="h_split" value="" type="hidden" />
<input id="h_mrd_id" name="h_mrd_id" value="" type="hidden" />
<input id="h_local_lang_flg" name="h_local_lang_flg" value="" type="hidden" />
<!-- Ivoce Bil_Amt Total-->
<input id="invTotBilAmt" name="invTotBilAmt" type="hidden" />
<input id="h_old_bl_no" name="h_old_bl_no" value="" type="hidden" />
<input id="h_old_bkg_no" name="h_old_bkg_no" value="" type="hidden" />
<!-- RD  -->
<input id="com_mrdPath" name="com_mrdPath" value="" type="hidden" />
<input id="com_mrdArguments" name="com_mrdArguments" value="" type="hidden" />
<!-- 
<input id="com_mrdSaveDialogDir" size="200" name="com_mrdSaveDialogDir" value="" type="hidden" />
<input id="com_mrdSaveDialogFileName" size="200" name="com_mrdSaveDialogFileName" value="" type="hidden" />
<input id="com_mrdSaveDialogFileExt" size="200" name="com_mrdSaveDialogFileExt" value="" type="hidden" />
<input id="com_mrdSaveDialogFileExtLimit" size="200" name="com_mrdSaveDialogFileExtLimit" value="" type="hidden" />
-->
<input id="com_mrdTitle" name="com_mrdTitle" value="" type="hidden" />
<input id="com_mrdDisableToolbar" name="com_mrdDisableToolbar" value="" type="hidden" />
<input id="com_mrdBodyTitle" name="com_mrdBodyTitle" value="" type="hidden" />

<!-- TPB Status -->
<input id="tpb_status" name="tpb_status" type="hidden" />
<input id="oaXmlData" name="oaXmlData" type="hidden" />
<input id="refInfo_do_split_flg" name="refInfo_do_split_flg" type="hidden" />
<!-- D/O status code -->
<input id="rlse_sts_cd" name="rlse_sts_cd" type="hidden" />
<!-- D/O last status code -->
<input id="last_rlse_sts_cd" name="last_rlse_sts_cd" type="hidden" />
<!-- DO No.-->
<input id="h_do_no" name="h_do_no" type="hidden" />
<input id="pre_ctnt" name="pre_ctnt" type="hidden" />
<input id="demDtlXmlData" name="demDtlXmlData" type="hidden" />


<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<% if(!mainPage.equals("true")){ %>
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<% } %>

<!-- wrap_search(S) -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
		<table>
			<colgroup>
				<col width="55" />
				<col width="160" />
				<col width="55" />
				<col width="220" />
				<col width="95" />
				<col width="140" />
				<col width="55" />
				<col width="120" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>B/L No.</th>
		            <td><script type="text/javascript">ComComboObject('combo_bl_no', 1, 125, 0);</script></td>
					<th>BKG No.</th>
					<td><input type="text" name = "bkg_no" caption="BKG No." maxlength="13" size="13" class="input" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>" dataformat="engup" style="width:120px; ime-mode:disabled" onChange="conditionReset();"><button type="button" class="btn_etc" name="btn_split" id="btn_split">SPLIT</button></td>
					<th class="sm">Container No.</th>
					<td class="sm"><input type="text" name="cntr_no" caption="Container No." size="11" class="input" value="" dataformat="engup" maxlength="11" style="width:100px; ime-mode:disabled" ></td>
					<th class="sm">P/O No.</th>
					<td class="sm"><input type="text" name = "po_no" maxlength="50" caption="Po No." class="input" value="" dataformat="engup" style="width:100px; ime-mode:disabled" ></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search(E) -->


			
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->
	
	<!--TAB B/L Info(S) -->
	<div id="tabLayer" style="display:inline;">	
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:65%">
				<div class="opus_design_inquiry sm" style="width:98%;height:105px">
					<table> 
						<tr>
							<th width="75">Arrival VVD</th>
							<td width="449">
								<input type="text" name = "frm_t1sheet1_arrival_vvd" style="width:94px;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name = "frm_t1sheet1_arrival_vvd_nm" style="width:300px;" class="input2" value="" readonly="readonly"></td>
							<th width="50">Partial</th>
							<td width="69"><input type="text" name = "frm_t1sheet1_partial" style="width:51px;" class="input2" value="" readonly="readonly"></td>
							<th width="70">T/S Route</th>
							<td><button type="button" class="input_seach_btn" name="btn_ts_route" id="btn_ts_route"></button></td>			
						</tr>
					</table> 
					<table> 
						<tr>
							<th width="31">ETA</th>
							<td width="168"><input type="text" name = "frm_t1sheet1_vps_eta_dt" style="width:110px;" class="input2" value="" readonly="readonly"></td>
							<th width="40">ATA</th>
							<td width="130"><input type="text" name = "frm_t1sheet1_vps_etb_dt" style="width:110px;" class="input2" value="" readonly="readonly"></td>
							<th width="45">Lane</th>
							<td width="71"><input type="text" name = "frm_t1sheet1_slan_cd" style="width:43px;" class="input2" value="" readonly="readonly"></td>
							<th width="73">RCV Term</th>
							<td width="69"><input type="text" name = "frm_t1sheet1_rcv_term_cd" style="width:51px;" class="input2" value="" readonly="readonly"></td>
							<th width="70">DEL Term</th>
							<td><input type="text" name = "frm_t1sheet1_de_term_cd" style="width:25px;" class="input2" value="" readonly="readonly"></td>
						</tr>
					</table> 
					<table> 
						<tr>
							<th width="31">POR</th>
							<td width="70"><input type="text" name = "frm_t1sheet1_por_cd" style="width:55px;" class="input2" value="" readonly="readonly"></td>
							<th width="30">POL</th>
							<td width="70"><input type="text" name = "frm_t1sheet1_pol_cd" style="width:55px;" class="input2" value="" readonly="readonly"></td>
							<th width="30">POD</th>
							<td width="233"><input type="text" name = "frm_t1sheet1_pod_cd" style="width:56px;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name = "frm_t1sheet1_pod_yd_cd" style="width:30px;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name = "frm_t1sheet1_pod_nm" style="width:132px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="readonly"></td>
							<th width="30">DEL</th>
							<td><input type="text" name = "frm_t1sheet1_del_cd" style="width:50px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name = "frm_t1sheet1_del_yd_cd" style="width:30px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name = "frm_t1sheet1_del_nm" style="width:148px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="readonly"></td>
						</tr>
					</table>
				</div>
		    </div>
		    <div class="layout_vertical_2" style="width:35%">
		        <div class="opus_design_grid" style="width:100%;height:105px">
					<script type="text/javascript">ComSheetObject('t1sheet1');</script>
					<script type="text/javascript">ComSheetObject('t1sheet2');</script>
		        </div>
		    </div>
		</div>
	
		<div class="layout_wrap">
			<div class="layout_vertical_2 " style="width:65%">
		    	<div class="opus_design_inquiry sm" style="width:98%;height:200px">
					<table> 
						<tr>
							<th width="31">PKG</th>
							<td width="100"><input type="text" name="frm_t1sheet1_pck_qty" style="width:56px;text-align:right;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name="frm_t1sheet1_pck_tp_cd" style="width:25px;" class="input2" value="" readonly="readonly"></td>
							<th width="30">WGT</th>
							<td width="117">
								<input type="text" name="frm_t1sheet1_act_wgt" style="width:70px;text-align:right;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name="frm_t1sheet1_wgt_ut_cd" style="width:35px;" class="input2" value="" readonly="readonly"></td>
							<th width="75">Contract No.</th>
							<td><input type="text" name="frm_t1sheet1_sc_no" style="width:188px;" class="input2" value="" readonly="readonly"><!--  
								--><button type="button" class="input_seach_btn" name="btn_contract_no" id="btn_contract_no"></button></td>
						</tr>
						<tr>
							<th colspan="3">&nbsp;Customs Description</th>
							<td colspan="3"><input type="text" name = "frm_t1sheet1_cstms_desc" style="width:417px; overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="readonly"></td>	
						</tr>
					</table>  
					
					<div style="padding-right:7px;">
						<table class="grid_2" style="width:591px"> 
							<colgroup>
								<col width="18%"/>
								<col width="18%"/>
								<col />
							</colgroup>
							<tr><th>Shipper</th>
								<td><input type="text" name="frm_t1sheet1_shp_cust_cd" style="width:100%;" class="noinput2" value="" readonly="readonly"></td>
								<td><input type="text" name="frm_t1sheet1_shp_cust_nm" style="width:100%;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="readonly"></td></tr>
							<tr><th>Consignee</th>
								<td><input type="text" name="frm_t1sheet1_csg_cust_cd" style="width:100%;" class="noinput2" value="" readonly="readonly"></td>
								<td><input type="text" name="frm_t1sheet1_csg_cust_nm" style="width:343px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="readonly"><!-- 
									--><button type="button" class="input_seach_btn" name="btn_consignee" id="btn_consignee"></button></td></tr>
							<tr><th>Notify</th>
								<td><input type="text" name="frm_t1sheet1_noy_cust_cd" style="width:100%;" class="noinput2" value="" readonly="readonly"></td>
								<td><input type="text" name="frm_t1sheet1_noy_cust_nm" style="width:343px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="readonly"><!-- 
									--><button type="button" class="input_seach_btn" name="btn_notify" id="btn_notify"></button></td></tr>
							<tr><th>A.Notify</th>
								<td><input type="text" name="frm_t1sheet1_aoy_cust_cd" style="width:100%;" class="noinput2" value="" readonly="readonly"></td>
								<td><input type="text" name="frm_t1sheet1_aoy_cust_nm" style="width:343px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="readonly"><!-- 
									--><button type="button" class="input_seach_btn" name="btn_a_notify" id="btn_a_notify"></button></td></tr>
						</table>
					</div>	
		        </div>
		    </div>
		    
		    
			 <div class="layout_vertical_2" style="width:35%;">
		    	<div class="opus_design_inquiry sm" style="width:100%;height:200px">
					<table> 
						<tr>
							<th width="100">BKG STS </th>
							<td width="70"><input type="text" name = "frm_t1sheet1_bkg_sts_cd" style="width:30px;" class="input2" value="" readonly="readonly"></td>
							<td width="87">
								<label for="frm_t1sheet1_bdr_flg"><strong>BDR</strong></label>
								<input type="checkbox" id="frm_t1sheet1_bdr_flg" name="frm_t1sheet1_bdr_flg" value="" class="trans" disabled></td>
							<td><label for="frm_t1sheet1_corr_flg"><strong>C/A</strong></label>
								<input type="checkbox" value="" name="frm_t1sheet1_corr_flg" class="trans" disabled>
								<button type="button" class="input_seach_btn" name="btn_corr_flg" id="btn_corr_flg"></button></td>
						</tr>
						<tr>
							<th>Customs Ref. No.</th>
							<td colspan="3">
								<input type="text" name="frm_t1sheet1_cust_ref_no" style="width:132px;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name="frm_t1sheet1_cust_ref_nm" style="width:105px;" class="input2" value="" readonly="readonly"></td>	
						</tr>
					</table> 
					<table> 
						<tr>
							<th width="40">FRT</th>
							<td width="189"><input type="text" name="frm_t1sheet1_frt_flg" style="width:56px;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name="frm_t1sheet1_frt_dt" style="width:110px;" class="input2"  readonly="readonly"></td> 
							<th width="40">Office</th>
							<td><input type="text" name="frm_t1sheet1_frt_ofc_cd" style="width:64px;" class="input2" value="" readonly="readonly"></td> 
						</tr>
						<tr>
							<th>B/L</th>
							<td><input type="text" name="frm_t1sheet1_obl_rdem_flg" style="width:56px;" class="input2" value="" readonly="readonly"><!--
								--><input type="text" name="frm_t1sheet1_obl_rdem_dt" style="width:110px;" class="input2" value="" readonly="readonly"></td> 
							<th>Office</th>
							<td><input type="text" name="frm_t1sheet1_obl_rdem_ofc_cd" style="width:64px;" class="input2" value="" readonly="readonly"></td> 
						</tr>
					</table>
					<div style="padding-right:7px;">
						<table class="grid_2" style="width:346px"> 
							<colgroup>
								<col width="20%" />
								<col />
							</colgroup>
							<tr>
								<th>Outstanding Amount</th>
								<td class="input2"><select style="width:100%;" name="tot_ots_amt"></select></td> 
							</tr>
							<tr>
								<th>Outstanding Demurrage</th>
								<td class="input2"><select style="width:100%;" name="tot_bil_amt"></select></td> 
							</tr>
						</table>
					</div>
		        </div>
		    </div>
		</div>
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('t1sheet3');</script>
			<script type="text/javascript">ComSheetObject('t1sheet4');</script>
			<script type="text/javascript">ComSheetObject('t1sheet6');</script>										
			<script type="text/javascript">ComSheetObject('t1sheet7');</script>										
		</div>
		<!-- opus_design_grid(E) -->		
	</div>
	<!--TAB B/L Info(E) -->
	
	<!--TAB Movement (S) -->
	<div id="tabLayer" style="display:none;">
		<iframe name="t1frame" id="t1frame" style="width:100%; height: 500px;" scrolling="no" frameborder='no' border='0' framespacing='0' src="about:blank"></iframe>
	</div>
	<!--TAB Movement (E) -->
	
	
	<!--TAB Cargo Release (S) -->
	<div id="tabLayer" style="display:none;">
		<iframe name="t2frame" id="t2frame" style="width:100%; height: 700px;" scrolling="no" frameborder='no' border='0' framespacing='0' src="about:blank"></iframe>
	</div>
	<!--TAB Cargo Release (E) -->
	
	<!--TAB S/O Info (S) -->
	<div id="tabLayer" style="display:none;">  
		<iframe name="t3frame" id="t3frame" style="width:100%; height: 600px;" scrolling="no" frameborder='no' border='0' framespacing='0' src="about:blank"></iframe>
	</div>
	<!--TAB S/O Info (E) -->
	
	
	<!--TAB A/N & Invoice (S) -->
	<div id="tabLayer" style="display:none;">  
		<iframe name="t4frame" id="t4frame" style="width:100%; height: 480px;" scrolling="no" frameborder='no' border='0' framespacing='0' src="about:blank"></iframe>
	</div>
	<!--TAB A/N & Invoice (E) -->
	
	<div class="opus_design_data" >
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	
</div>
<!-- wrap_result(E) -->

<% if(!mainPage.equals("true")){ %>
</div>
<!-- popup_contens_area(E) -->
<% } %>

</form> 