<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079_06.jsp
*@FileTitle  :  In-bound C/S Screen US
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066801Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg066801Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (EsmBkg066801Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
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

		$('<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_new" name="btn_new">New</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_inquiry" name="btn_inquiry">Manifest Details by B/L</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_inquiry2" id="btn_inquiry2">Canada Manifest Details by B/L</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_history" name="btn_history">History</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_preview" name="btn_preview">B/L Preview</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_BkgMain" name="btn_BkgMain">BKG Main</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_charge" name="btn_charge">Charge</button>').appendTo("#btnArea");
        
		loadPage();
	}
</script>
	
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" >
<input type="hidden" name="pagerows"  id="pagerows">
<input type='hidden' name ='mainPage' id='mainPage' value="<%=JSPUtil.getNull(request.getParameter("mainPage"))%>">

<input type='hidden' name ='h_cntr_no' id='h_cntr_no' value = "">
<input type='hidden' name ='h_po_no' id='h_po_no' value = "">
<input type='hidden' name ='h_split' id='h_split' value = "">
<input type='hidden' name ='h_hbl_no' id='h_hbl_no' value = "">
<input type='hidden' name ='xmlData' id='xmlData' value = "">
<input type='hidden' name ='bl_no' id="bl_no" value = "" >
<input type='hidden' name ='h_mov_cntr_no' id='h_mov_cntr_no' value = "">
<input type='hidden' name ='h_mrd_id' id='h_mrd_id' value = "">
<input type='hidden' name ='h_local_lang_flg' id='h_local_lang_flg' value = "">
<!-- Ivoce Bil_Amt Total-->
<input type='hidden' name ='invTotBilAmt' id='invTotBilAmt'>
<input type='hidden' name ='h_old_bl_no' id='h_old_bl_no' value = "">
<input type='hidden' name ='h_old_bkg_no' id='h_old_bkg_no' value = "">
<!-- RD part  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="">

<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" value=""> 
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="">
<input type='hidden' name ="demDtlXmlData" id="demDtlXmlData">

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<% 
if(!mainPage.equals("true")){
%>
<div class="layer_popup_contents">
<%} %>
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
	 	 <table>
	    	<colgroup>
	           <col width="50">
	            <col width="100">
	            <col width="80">
	            <col width="80">
	            <col width="50">
	            <col width="120">
	            <col width="50">
	            <col width="80">
	            <col width="50">
	            <col width="80">
	            <col width="*">
	        </colgroup>
	        <tbody>
	        	<tr>
	        		<th>B/L No.</th>
                    <td><script type="text/javascript">ComComboObject('combo_bl_no', 1, 125, 0);</script></td>
					<th>BKG No.</th>
					<td><input type="text" name="bkg_no" id="bkg_no" caption="BKG No." maxlength="13" style="width:100px;" class="input" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>" dataformat="eng" style="ime-mode:disabled" onChange="conditionReset();"></td>
					<td><button type="button" class="btn_etc" name="btn_split" id="btn_split" style="width:70px;text-align:center;">SPLIT</button></td>
					<th>Container No.</th>
					<td><input type="text" name="cntr_no" id="cntr_no" caption="Container No." style="width:100px;" class="input" value="" dataformat="engup" maxlength="11" style="ime-mode:disabled" ></td>
					<th>P/O No.</th>
					<td><input type="text" name="po_no" id="po_no" style="width:80px;" class="input" value="" dataformat="engup" otherchar="-_$." style="ime-mode:disabled" ></td>
					<th>H.B/L No.</th>
					<td><input type="text" name="hbl_no" id="hbl_no" style="width:100px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" ></td>
	        	</tr>
	        </tbody>
	    </table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_tab">
		<script >ComTabObject('tab1')</script>
	</div>
<!--  tabLayer  B/L Info  -->
<div id="tabLayer">	
	<!-- first data -->	
		<div class="layout_wrap">
		    <div class="layout_vertical_2 " style="width:65%">
		    	<div class="opus_design_inquiry sm" style="width:98%">
				<table> 
						<col width="75">
						<col width="82">
						<col width="186">
						<col width="50">
						<col width="30">
						<col width="63">
						<col width="87">
						<col width="80">
						<col width="*">
			        <tbody>
						<tr>
							<th>Arrival VVD</th>
							<td><input type="text" name="frm_t1sheet1_arrival_vvd" style="width:90px" class="input2" value="" readonly="true" id="frm_t1sheet1_arrival_vvd" /> </td>
							<td><input type="text" name="frm_t1sheet1_arrival_vvd_nm" style="width:180px" class="input2" value="" readonly="true" id="frm_t1sheet1_arrival_vvd_nm" /></td>
							<th>BKG STS</th>
							<td><input type="text" name="frm_t1sheet1_bkg_sts_cd" style="width:30px;" class="input2" value="" readonly id="frm_t1sheet1_bkg_sts_cd" /> </td>
							<th>Partial</th>
							<td><input type="text" name="frm_t1sheet1_partial" id="frm_t1sheet1_partial" style="width:60px;" class="input2" value="" readonly="true" /> </td>
							<th>T/S Route</th>
							<td><button type="button" class="input_seach_btn" name="btn_ts_route" id="btn_ts_route"></button></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="30" />
						<col width="147" />
						<col width="30" />
						<col width="135" />
						<col width="30" />
						<col width="76" />
						<col width="64" />
						<col width="76" />
						<col width="78" />
						<col width="*" />
					</colgroup>
			        <tbody>
						<tr>
							<th>ETA</th>
							<td><input type="text" name="frm_t1sheet1_vps_eta_dt" style="width:135px;" class="input2" value="" readonly="true" id="frm_t1sheet1_vps_eta_dt" /> </td>
							<th>ATA</th>
							<td><input type="text" name="frm_t1sheet1_vps_etb_dt" style="width:145px;" class="input2" value="" readonly="true" id="frm_t1sheet1_vps_etb_dt" /> </td>
							<th>Lane</th>
							<td><input type="text" name="frm_t1sheet1_slan_cd" style="width:53px;" class="input2" value="" readonly="true" id="frm_t1sheet1_slan_cd" /> </td>
							<th>RCV Term</th>
							<td><input type="text" name="frm_t1sheet1_rcv_term_cd" style="width:50px;" class="input2" value="" readonly="true" id="frm_t1sheet1_rcv_term_cd" /> </td>
							<th>DEL Term</th>
							<td><input type="text" name="frm_t1sheet1_de_term_cd" style="width:20px;" class="input2" value="" readonly="true" id="frm_t1sheet1_de_term_cd" /> </td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="30" />
						<col width="66" />
						<col width="25" />
						<col width="70" />
						<col width="25" />
						<col width="243" />
						<col width="30" />
						<col width="*" />
					</colgroup>
			        <tbody>
			        	<tr>
							<th title="Place of Receipt">POR</th>
							<td><input type="text" name="frm_t1sheet1_por_cd" style="width:56px;" class="input2" value="" readonly="true" id="frm_t1sheet1_por_cd" /> </td>
							<th title="Port of Loading">POL</th>
							<td><input type="text" name="frm_t1sheet1_pol_cd" style="width:60px;" class="input2" value="" readonly="true" id="frm_t1sheet1_pol_cd" /> </td>
							<th title="Port of Discharging">POD</th>
							<td><input type="text" name="frm_t1sheet1_pod_cd" style="width:56px;" class="input2" value="" readonly="true" id="frm_t1sheet1_pod_cd" /><input type="text" name="frm_t1sheet1_pod_yd_cd" style="width:30px;" class="input2" value="" readonly="true" id="frm_t1sheet1_pod_yd_cd" /><input type="text" name="frm_t1sheet1_pod_nm" style="width:125px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true" id="frm_t1sheet1_pod_nm" /> </td>
							<th title="Place of Delivery">DEL</th>
							<td><input type="text" name="frm_t1sheet1_del_cd" style="width:50px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true" id="frm_t1sheet1_del_cd" /><input type="text" name="frm_t1sheet1_del_yd_cd" style="width:30px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true" id="frm_t1sheet1_del_yd_cd" /><input type="text" name="frm_t1sheet1_del_nm" style="width:120px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true" id="frm_t1sheet1_del_nm" /></td>
						</tr>
			        </tbody>
			    </table>
			</div>
			</div>
	        <div class="layout_vertical_2 " style="width:35%">
		    	<div class="opus_design_inquiry sm" style="width:100%">
	        	<script type="text/javascript">ComSheetObject('t1sheet1');</script>										
				<script type="text/javascript">ComSheetObject('t1sheet3');</script>
	        	</div>
	         </div>
	
		</div>
	<!-- first data -->
	<!-- second data -->	
		<div class="layout_wrap">
		    <div class="layout_vertical_2 " style="width:65%">
		    	<div class="opus_design_inquiry sm" style="width:98%">
				<table>
					<colgroup>
						<col width="30">
						<col width="75">
						<col width="65">
						<col width="50">
						<col width="180">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>PKG</th>
							<td><input type="text" name="frm_t1sheet1_pck_qty" style="width:56px;text-align:right;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true" id="frm_t1sheet1_pck_qty" /><input type="text" name="frm_t1sheet1_pck_tp_cd" style="width:25px;" class="input2" value="" readonly="true" id="frm_t1sheet1_pck_tp_cd" /></td>
							<th>WGT</th>
							<td><input type="text" name="frm_t1sheet1_act_wgt" style="width:70px;text-align:right;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true" id="frm_t1sheet1_act_wgt" /><input type="text" name="frm_t1sheet1_wgt_ut_cd" style="width:35px;" class="input2" value="" readonly="true" id="frm_t1sheet1_wgt_ut_cd" /></td>
							<th class="align_right">Contract No.</th>
							<td><input type="text" name="frm_t1sheet1_sc_no" style="width:87%;" class="input2 input_search" value="" readonly="true" id="frm_t1sheet1_sc_no" /><button type="button" class="input_seach_btn" name="btn_contract_no" id="btn_contract_no"></button></td>
						</tr>
						</tbody>
					</table>
					<table>
					<colgroup>
						<col width="60" />
						<col width="33" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th class="align_left">Customs Description</th>
							<td></td>
							<td><input type="text" name="frm_t1sheet1_cstms_desc" style="width:493px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true" id="frm_t1sheet1_cstms_desc" /></td>
						</tr>
					</tbody>
				</table>
				<h3 style="margin-bottom:0" class="title_design">Customer Information</h3>
				<table>
					<colgroup>
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<td class="align_right">
								<button type="button" class="btn_etc" name="btn_instruction" id="btn_instruction" style="width:100px;text-align:center;">Instruction</button><!-- 
								 --><button type="button" class="btn_etc" name="btn_pu_history" id="btn_pu_history" style="width:100px;text-align:center;">P/U History</button>
                           	</td>
                          </tr>
					</tbody>
				</table>
				
				<table  class="grid2">
					<colgroup>
						<col width="70" />
						<col width="90" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th class="tr2_head">Shipper</th>
							<td><input type="text" name="frm_t1sheet1_shp_cust_cd" style="width:84px;" class="noinput2" value="" readonly="true" id="frm_t1sheet1_shp_cust_cd" /></td>
							<td><input type="text" name="frm_t1sheet1_shp_cust_nm" style="width:100%;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true" id="frm_t1sheet1_shp_cust_nm" /> </td>
						</tr>
						<tr>
							<th class="tr2_head">Consignee</th>
							<td><input type="text" name="frm_t1sheet1_csg_cust_cd" style="width:84px;" class="noinput2" value="" readonly="true" id="frm_t1sheet1_csg_cust_cd" /></td>
							<td><input type="text" name="frm_t1sheet1_csg_cust_nm" style="width:94%;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2 input_search" value="" readonly="true" id="frm_t1sheet1_csg_cust_nm" /><button type="button" class="input_seach_btn" name="btn_consignee" id="btn_consignee"></button></td>
						</tr>
						<tr>
							<th class="tr2_head">Notify</th>
							<td><input type="text" name="frm_t1sheet1_noy_cust_cd" style="width:84px;" class="noinput2" value="" readonly="true" id="frm_t1sheet1_noy_cust_cd" /></td>
							<td><input type="text" name="frm_t1sheet1_noy_cust_nm" style="width:94%;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2 input_search" value="" readonly="true" id="frm_t1sheet1_noy_cust_nm" /><button type="button" class="input_seach_btn" name="btn_notify" id="btn_notify"></button></td>
						</tr>
						<tr>
							<th class="tr2_head">A.Notify</th>
							<td><input type="text" name="frm_t1sheet1_aoy_cust_cd" style="width:84px;" class="noinput2" value="" readonly="true" id="frm_t1sheet1_aoy_cust_cd" /></td>
							<td><input type="text" name="frm_t1sheet1_aoy_cust_nm" style="width:94%;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2 input_search" value="" readonly="true" id="frm_t1sheet1_aoy_cust_nm" /><button type="button" class="input_seach_btn" name="btn_a_notify" id="btn_a_notify"></button></td>
						</tr>
					</tbody>
				</table>
				</div>
		    </div>
		    <div class="layout_vertical_2" style="width:35%;">
		    	<div class="opus_design_inquiry sm" style="width:100%">
				<table class="search">
					<colgroup>
						<col width="70" />
						<col width="100" />
						<col width="30" />
						<col width="52" />
						<col width="62" />
						<col width="*" />
					</colgroup>
					<tbody> 
						<tr>
							<th><label id="CHK01">BDR</label><input type="checkbox" name="frm_t1sheet1_bdr_flg"  id="CHK01" value="" class="trans" disabled></th>
							<th><label id="CHK02">C/A</label><input type="checkbox" value="" name="frm_t1sheet1_corr_flg" id="CHK02" class="trans" disabled><button type="button" class="input_seach_btn" name="btn_corr_flg" id="btn_corr_flg"></button></th>
							<th>Filer</th>
							<td><input type="text" name="frm_t1sheet1_cstms_file_tp_cd" style="width:30px;" class="input2" value="" readonly id="frm_t1sheet1_cstms_file_tp_cd" /></td>
							<th>CUS LOC</th>
							<td><input type="text" name="frm_t1sheet1_cstms_loc_cd" style="width:80px;" class="input2" value="" readonly id="frm_t1sheet1_cstms_loc_cd" /> </td>
						</tr>
						</tbody>
					</table>
					<table class="search">
					<colgroup>
						<col width="70" />
						<col width="55" />
						<col width="83" />
						<col width="*" />
					</colgroup>
					<tbody> 
						<tr>
							<th>MIB No.</th>
							<td><input type="text" name="frm_t1sheet1_ibd_trsp_no" style="width:100px;" class="input2" value="" readonly id="frm_t1sheet1_ibd_trsp_no" /> </td>
							<th>IT Date</th>
							<td><input type="text" name="frm_t1sheet1_ibd_trsp_iss_dt" style="width:133px;" class="input2" value="" readonly id="frm_t1sheet1_ibd_trsp_iss_dt" /> </td>
						</tr>
					</tbody>
				</table>

				<table>
					<colgroup>
						<col width="70" />
						<col width="170" />
						<col width="*" />
					</colgroup>
					<tbody> 
						<tr>
							<th>FRT</th>
							<td><input type="text" name="frm_t1sheet1_frt_clt_flg" style="width:35px;" class="input2" value="" readonly id="frm_t1sheet1_frt_clt_flg" /><!-- 
							 --><input type="text" name="frm_t1sheet1_frt_clt_lst_dt" style="width:140px;" class="input2" value="" readonly id="frm_t1sheet1_frt_clt_lst_dt" /><!-- 
							 --><input type="text" name="frm_t1sheet1_frt_clt_ofc_cd" style="width:140px;" class="input2" value="" readonly id="frm_t1sheet1_frt_clt_ofc_cd" /></td>
							 <td></td>
						</tr>
						<tr>
							<th>B/L</th>
							<td><input type="text" name="frm_t1sheet1_us_obl_rdem_flg" style="width:35px;" class="input2" value="" readonly id="frm_t1sheet1_us_obl_rdem_flg" /><!-- 
							 --><input type="text" name="frm_t1sheet1_obl_rdem_dt" style="width:140px;" class="input2" value="" readonly id="frm_t1sheet1_obl_rdem_dt" /><!-- 
							 --><input type="text" name="frm_t1sheet1_obl_rdem_ofc_cd" style="width:140px;" class="input2" value="" readonly id="frm_t1sheet1_obl_rdem_ofc_cd" /> </td>
							<td></td>
						</tr>
						<tr>
							<th>Customs</th>
							<td><input type="text" name="frm_t1sheet1_cstms_clr_cd" style="width:35px;" class="input2" value="" readonly id="frm_t1sheet1_cstms_clr_cd" /><!-- 
						 	--><input type="text" name="frm_t1sheet1_cstms_clr_lst_dt" style="width:140px;" class="input2" value="" readonly id="frm_t1sheet1_cstms_clr_lst_dt" /><!-- 
							 --><button type="button" class="btn_etc" name="btn_c_flag" id="btn_c_flag" style="width:140px;text-align:center;">C flag / CNTR</button></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table class="grid2 wAuto"> 
					<colgroup>
						<col width="70" />
						<col width="*" />
					</colgroup>
					<tbody> 
					<tr>
						<th class="tr2_head">Outstanding Amount</th>
						<td><select style="width:240px;font-weight:bold;" class="input2" name="tot_ots_amt" id="tot_ots_amt"></select></td> 
					</tr>
					<tr>
						<th class="tr2_head">Outstanding Demurrage</th>
						<td class="noinput2"><select style="width:240px;font-weight:bold;" class="input2" name="tot_bil_amt" id="tot_bil_amt"></select></td> 
					</tr>
					</table>	
				</div>	
		    </div>
		</div>
	<!-- second data -->

	<div class="opus_design_tab">
		<script >ComTabObject('t1tab1')</script>
	</div>
	<!-- t1tabLayer US -->
		<div id="t1tabLayer">				
			<div class="opus_design_inquiry">
				<table> 
					<tr class="align_center">
						<td width="34"><input type="text" name="frm_t1sheet1_1_cntr_cnt" id="frm_t1sheet1_1_cntr_cnt" style="width:33px; height:20px; border:#E8E7EC 1px solid;  background-color:#F7E1EC; text-align:center;" value="" readonly></td>
						<th width="92">Container(s)</th>
						<td width="536"></td>
						<td width="92"><input type="text" name="frm_t1sheet1_1_wgt_sum" id="frm_t1sheet1_1_wgt_sum" style="width:92px; height:20px; border:#E8E7EC 1px solid;  background-color:#F7E1EC; text-align:right;" value="" readonly></td>
						<td width="48"><input type="text" name="frm_t1sheet1_1_pkg_sum" id="frm_t1sheet1_1_pkg_sum" style="width:48px; height:20px; border:#E8E7EC 1px solid;  background-color:#F7E1EC; text-align:right;" value="" readonly></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('t1sheet1_1');</script>
			</div>
		</div>
		<!-- t1tabLayer US-->
		
		<!-- t1tabLayer General-->
		<div id="t1tabLayer" style="display:none">
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('t1sheet1_2');</script>
			</div>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('t1sheet1_3');</script>
			</div>
				<script type="text/javascript">ComSheetObject('t1sheet5');</script>
				<script type="text/javascript">ComSheetObject('t1sheet6');</script>
			</div>
		</div>
		<!-- t1tabLayer General-->
		
		
		<!--  tabLayer Cargo Release -->
		<div id="tabLayer" style="display:none;">		
		   	<table>
			   	<tr>
			   		<td>
						<iframe name="t2frame" id="t2frame" style="width:100%;height:430px;" scrolling="no" frameborder='no' border='0' framespacing='0'></iframe>
					</td>
				</tr>
			</table>
		</div>
		<!--  tabLayer Cargo Release -->
		
		<!-- ************************************************************************************************** -->
		<!--  tabLayer Movement -->
		<div id="tabLayer" style="display:none">
				<!-- Grid BG Box  (S) -->
		   	<table>
			   	<tr>
			   		<td>
						<iframe name="t3frame" id="t3frame" style="width:100%;height:430px;" scrolling="no"frameborder='no' border='0' framespacing='0'></iframe>
					</td>
				</tr>
			</table>
		</div>
		<!--  tabLayer Movement -->
		
		<!-- ************************************************************************************************** -->
		<!--  tabLayer Customs Result -->
		<div id="tabLayer" style="display:none">
		   	<table id="mainTable">
			   	<tr>
			   		<td>
						<iframe name="t4frame" id="t4frame" style="width:100%;height:430px;" scrolling="no"frameborder='no' border='0' framespacing='0'></iframe>
					</td>
				</tr>
			</table>
		</div>
		<!--  tabLayer Customs Result -->
		
		<!-- ************************************************************************************************** -->
		
		<!--  tabLayer S/O Info -->
		<div id="tabLayer" style="display:none">
		   	<table id="mainTable">
			   	<tr>
			   		<td>
						<iframe name="t5frame" id="t5frame" style="width:100%;height:430px;" scrolling="no" frameborder='no' border='0' framespacing='0'></iframe>
					</td>
				</tr>
			</table>
		</div>
		<!--  tabLayer S/O Info -->
		
		
		<!-- ************************************************************************************************** -->
		
		<!--  tabLayer A/N Sent -->
		<div id="tabLayer" style="display:none">
		   	<table id="mainTable">
			   	<tr>
			   		<td>
						<iframe name="t6frame" id="t6frame" style="width:100%;height:530px;" scrolling="no"frameborder='no' border='0' framespacing='0'></iframe>
					</td>
				</tr>
			</table>
		</div>
		<!--  tabLayer A/N Sent -->
		
		<!-- ************************************************************************************************** -->
		
		
		<!--tabLayer  Pickup Notice  -->
		<div id="tabLayer" style="display:none">
		
			<!-- Grid BG Box (S)-->
		   	<table id="mainTable">
			   	<tr>
			   		<td>
						<iframe name="t7frame" id="t7frame" style="width:100%;height:600px;" scrolling="no" frameborder='no' border='0' framespacing='0'></iframe>
					</td>
				</tr>
			</table>
		<!--tabLayer  Pickup Notice  -->
		</div>
		
		
		
		<!-- ************************************************************************************************** -->
		
		
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		
</div>
<!--  tabLayer B/L Info -->

		
</div>
<% 
if(!mainPage.equals("true")){
%>
</div>
<%} %>
</form>
 