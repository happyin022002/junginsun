<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0938.jsp
*@FileTitle  : EU Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0938Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0938Event event     = null;         //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";

    String strUsr_id   = "";
    String strUsr_nm   = "";
    String strOfcCd    = "";
    String strCntCd    = "";
    String strBkgNo    = ""; // Parameter Booking Number
    String code = "";
    String value = "";
    String mainPage = "";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
        strCntCd  = account.getCnt_cd();


        event = (EsmBkg0938Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        mainPage = JSPUtil.getNull(request.getParameter("mainPage"));

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // If you imported data from the server initialization when loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
        strBkgNo = JSPUtil.getParameter(request, "bkg_no");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">

    /**************************************
        Global variable declaration
    **************************************/

    var lginOfcCd = "<%=strOfcCd %>";
    var lginCntCd = "<%=strCntCd %>";
    var strUsr_id = "<%=strUsr_id%>";

    var parBkgNo = "<%=strBkgNo %>";
    var evtCode = "<%=code %>|";
	var evtValue = "<%=code %>|";
	
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<style type="text/css">
	body {
	overflow-x: hidden;
}
</style>

<form name="form">
	<input type="hidden" name="f_cmd" name="f_cmd">
	<input type="hidden" name="pagerows" name="pagerows">
	<!----------------------------------------------------------------------
	    Hidden Value Define
	----------------------------------------------------------------------->
	<input type="hidden" name ="h_cntr_no" id ="h_cntr_no">
	<input type='hidden' name ="xmlData" id ="xmlData">
	<input type='hidden' name ="oaXmlData" id ="oaXmlData">
	<input type='hidden' name ="refInfo_do_split_flg" id ="refInfo_do_split_flg">
	<!-- Hold OR UN-HOLD status Values -->
	<input type='hidden' name ='evnt_flag' id ='evnt_flag'>
	<input type='hidden' name ='h_ori_obl_rdem_flg' id ='h_ori_obl_rdem_flg'>
	<input type='hidden' name ='h_aft_obl_rdem_flg' id ='h_aft_obl_rdem_flg'>
	<!---D/O EVENT before Value -->
	<input type='hidden' name ='pre_ctnt' id ='pre_ctnt'>
	<!-- Ivoce Bil_Amt Total-->
	<input type='hidden' name ='invTotBilAmt' id ='invTotBilAmt'>
	<!-- Dor Interface Performance and status of issue-->
	<input type='hidden' name ='dorStsCd' name ='dorStsCd'>
	<!-- D/O Major EVENT -->
	<input type='hidden' name ='do_cng_evnt_cd' id ='do_cng_evnt_cd'>
	<!-- TPB Status -->
	<input type='hidden' name ='tpb_status' id ='tpb_status'>
	<!-- D / O status code of the process -->
	<input type='hidden' name ='rlse_sts_cd' id ='rlse_sts_cd'>
	<!--The final D / O status code of -->
	<input type='hidden' name ='last_rlse_sts_cd' id ='last_rlse_sts_cd'>
	<!-- DO NO-->
	<input type='hidden' name ='h_do_no' id ='h_do_no'>
	<!--OBL Whether to change-->
	<input type='hidden' name ='obl_cng_flg' id ='obl_cng_flg'>
	<!--O/BL Received Change after Value -->
	<input type='hidden' name ='old_obl_rdem_knt' id ='old_obl_rdem_knt'>
	<!--O/BL Received Change before Value -->
	<input type='hidden' name ='new_obl_rdem_knt' id ='new_obl_rdem_knt'>
	<!-- Remark for Release  -->
	<input type='hidden' name ='releaseRemark' id ='releaseRemark'>
	<input type='hidden' name ='crnt_ctnt' id ='crnt_ctnt'>
	
	<input type="hidden" name="h_cntr_no" id="h_cntr_no">
	<!-- RD -->
	<input type="hidden" name="h_mrd_id" id="h_mrd_id">
	<input type="hidden" name="h_mrd_param" id="h_mrd_param">
	<input type="hidden" name="h_local_lang_flg" id="h_local_lang_flg">
	<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="">
	<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="">
	
	<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" value="">
	<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" value="">
	<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="">
	
	<input type='hidden' name ="demDtlXmlData" id ="demDtlXmlData">
	<input type='hidden' name ='h_hold_remark' id ='h_hold_remark' value = "">	
	<!-- page_title_area(S) -->
	<div id="blLayer" class="blLayer" style="position:absolute;z-index: 999; background-color:#ffffff; visibility: hidden; overflow-y:auto; overflow-x:hidden; border-width:1px; border-style:solid;"></div>
<% if (!mainPage.equals("true")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>EU Cargo Release (D/O) ( ESM_BKG_0938 )</span></h2>
<%}else{%>
<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<%}%>	
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button><!--  
		--><button type="button" class="btn_normal" name="btn_release" 	id="btn_release">Release</button><!--  
		--><button type="button" class="btn_normal" name="btn_f_cntr_rls" 	id="btn_f_cntr_rls">F/CNTR RLS</button><!--  
		--><button type="button" class="btn_normal" name="btn_cancel"  	id="btn_cancel">Cancel</button><!--  
		--><button type="button" class="btn_normal" name="btn_preview" 	id="btn_preview">Preview</button><!--  
		--><button type="button" class="btn_normal" name="btn_print"    id="btn_print">Print</button><!--
		--><button type="button" class="btn_normal" name="btn_remark" id="btn_remark">External Remark(s)</button><!--  
		--><span id="div_hold_btn"><button type="button" class="btn_normal" name="btn_hold"  	id="btn_hold">Hold</button></span><!--  
		--><span id="div_unhold_btn"><button type="button" class="btn_normal" name="btn_unhold" 	id="btn_unhold">Hold Removal</button></span><!--  
		--><span id="div_cntr_hold_btn"><button type="button" class="btn_normal" name="btn_cntr_hold"  	id="btn_cntr_hold">CNTR Hold</button></span><!--  
		--><span id="div_cntr_unhold_btn"><button type="button" class="btn_normal" name="btn_cntr_unhold" 	id="btn_cntr_unhold">CNTR Hold Removal</button></span><!--  
		--><button type="button" class="btn_normal" name="btn_history" 	id="btn_history">History</button><!--  
		--><button type="button" class="btn_normal" name="btn_form_setup"  	id="btn_form_setup">Form Setup</button><!-- 
		--><button type="button" class="btn_normal" name="btn_receiverinfo" 	id="btn_receiverinfo">Receiver Info</button><!-- 
			 --><%if(!"true".equals(mainPage)){ %><!-- 
				 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!-- 
			 --><%} %><!--   
		--></div>
		<!-- opus_design_btn(E) -->
<% if (!mainPage.equals("true")) { %>	
		</div>
	</div>
<%}else{%>
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
	</div>
<% } %>		

	<!-- page_title_area(E) -->

<%if (!mainPage.equals("true")) { %><div class="layer_popup_contents"><%}%>
	<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="50">
				<col width="160">
				<col width="60">
				<col width="210">
				<col width="90">
				<col width="120">
				<col width="*">
			</colgroup>
	        <tr>
                  <th>B/L No.</th>
                  <td>
                      <input name="bl_no" id="bl_no" caption="B/L No." type="text" style="width:125px;ime-mode:disabled; background-image : url('style/images/theme_default/select.png'); background-position:center right; background-repeat:no-repeat;" dataformat="engup" class="input" maxlength="13">
                  </td>
                  <th>BKG No.</th>
                  <td><input name="bkg_no" id="bkg_no" caption="BKG No." dataformat="engup" type="text" style="width:120px;ime-mode:disabled" class="input" maxlength="12" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>"><!-- 
                       --><input name='blInfo_split_flg' id='blInfo_split_flg' type="text" dataformat="engup" style="width:40px;color:red; font-weight:bold;text-align: center" readOnly class="input2">
                  </td>
                  <th>Container No.</th>
                  <td>
                      <input name="cntr_no" id='cntr_no' caption="Container No." fullfill dataformat="engup" type="text" style="width:120px;ime-mode:disabled" class="input" maxlength="11">
                  </td>
                  <td></td>
             </tr>
        </table> 
	</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="60">
				<col width="40">
				<col width="60">
				<col width="60">
				<col width="110">
				<col width="40">
				<col width="150">
				<col width="70">
				<col width="100">
				<col width="110">
				<col width="*">
			</colgroup>
             <tr>
                 <th title="Place of Receipt">POR</th>
                 <td><input type="text" style="width: 50px; text-align: center" class="input2" readOnly name="blInfo_por_cd" id='blInfo_por_cd'></td>
                 <th title="Port of Loading">POL</th>
                 <td><input type="text" style="width: 50px; text-align: center" class="input2" readOnly name="blInfo_pol_cd" id='blInfo_pol_cd'></td>
                 <th title="Port of Discharging">POD</th>
                 <td><input type="text" style="width: 52px; text-align: center" class="input2" readOnly name="blInfo_pod_cd" id="blInfo_pod_cd"></td>
                 <th title="Place of Delivery">DEL</th>
                 <td><input type="text" style="width: 50px; text-align: center" class="input2" readOnly name="blInfo_del_cd" id="blInfo_del_cd"></td>
                 <th>DEL Term</tg>
                 <td><input type="text" style="width:89px; text-align: left" class="input2" readOnly name="blInfo_de_term_desc" id='blInfo_de_term_desc'></td>
                 <th>Arrival Vessel</th>
                 <td><input type="text" style="width: 100%; text-align: left" class="input2" readOnly name="blInfo_arrival_vessel" id='blInfo_arrival_vessel'></td>
             </tr>
        </table>
        <table>
			<colgroup>
				<col width="50">
				<col width="160">
				<col width="60">
				<col width="110">
				<col width="40">
				<col width="150">
				<col width="70">
				<col width="100">
				<col width="110">
				<col width="*">
			</colgroup>
             <tr>
                 <th>ETA</th>
                 <td><input type="text" style="width: 150px; text-align: center" class="input2" readOnly name="blInfo_vps_eta_dt" id='blInfo_vps_eta_dt'></td>
                 <th>PKG</th>
                 <td>
                     <input type="text" style="width: 52px; text-align: right" class="input2" readOnly name="blInfo_pck_qty" id='blInfo_pck_qty'><!-- 
                      --><input type="text" style="width: 30px; text-align: center" class="input2" readOnly name="blInfo_pck_tp_cd" id='blInfo_pck_tp_cd'>
                 </td>
                 <th>WGT</th>
                 <td>
                     <input type="text" style="width: 80px; text-align: right" class="input2" readOnly name="blInfo_act_wgt" id="blInfo_act_wgt"><!-- 
                      --><input type="text" style="width: 40px; text-align: center" class="input2" readOnly name="blInfo_wgt_ut_cd" id='blInfo_wgt_ut_cd'>
                 </td>
                 <th>MEA</th>
                 <td>
                     <input type="text" style="width: 45px; text-align: right" class="input2" readOnly name="blInfo_meas_qty" id='blInfo_meas_qty'><!-- 
                      --><input type="text" style="width: 40px; text-align: center" class="input2" readOnly name="blInfo_meas_ut_cd" id='blInfo_meas_ut_cd'>
                 </td>
                 <th>Discharging CY</th>
                 <td><input type="text" style="width: 100%; text-align: left" class="input2" readOnly name="blInfo_dsch_loc" id='blInfo_dsch_loc'></td>
             </tr>
    	</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="270">
				<col width="55">
				<col width="40">
				<col width="90">
				<col width="141">
				<col width="*">
			</colgroup>
			<tr>
                 <td><input type="text" style="width:112px;" class="input" name="euCstmsInfo_cstms_ref_nm" id='euCstmsInfo_cstms_ref_nm' maxlength='50'><!-- 
                  --><input type="text" style="width:121px;" class="input" value="" name="euCstmsInfo_cstms_ref_ctnt" id='euCstmsInfo_cstms_ref_ctnt' maxlength='20'></td>
                 <th>Partial</th>
                 <td><input type="text" style="width:30px; text-align: center" class="input2" readOnly name="blInfo_cntr_prt_flg" id='blInfo_cntr_prt_flg'></td>
              	 <th>Consignee</th>
                 <td><input type="text" name="blInfo_ccust_nm" id='blInfo_ccust_nm' style="width:140px;text-align:left;" class="input2" readOnly></td>  
                 <td><input type="text" name="blInfo_ccust_addr" id='blInfo_ccust_addr'  style="width:100%;text-align:left;" class="input2" readOnly></td>
             </tr>
             <tr>
                 <td><input type="text" style="width:112px;"  class="input" name="euCstmsInfo_cstms_asgn_nm" id='euCstmsInfo_cstms_asgn_nm' maxlength='50' ><!--  
                 --><input type="text" style="width:121px;" class="input" value="" name="euCstmsInfo_cstms_asgn_ctnt" id='euCstmsInfo_cstms_asgn_ctnt' maxlength='20'></td>
                 <th>SOC</th>
                 <td><input type="text" style="width: 30px; text-align: center" class="input2" readOnly name="blInfo_soc_flg" id='blInfo_soc_flg'></td>
                 <th>Notify</th>
                 <td><input type="text" name="blInfo_ncust_nm" id='blInfo_ncust_nm'  style="width:140px;text-align:left;" class="input2" readOnly></td>  
                 <td><input type="text" name="blInfo_ncust_addr" id='blInfo_ncust_addr' style="width:100%;text-align:left;" class="input2" readOnly></td>
             </tr>
         </table>
	</div>
	<!-- opus_design_inquiry(E) -->

	<div class="opus_design_data">
		<table>
			<colgroup>
				<col width="200" />
				<col width="150" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td><h3 class="title_design">D/O No. Split By CNTR</h3></td>
					<td class="pad_btm_8"><input type="radio" onclick="setSplitFlag('N');" class="trans" value="N" name="split_flg" id="split_flg1"><label for="split_flg1">No</label><!-- 
					--><input type="radio" onclick="setSplitFlag('Y');" class="trans mar_left_4" value="Y" name="split_flg" id="split_flg2"><label for="split_flg2">Yes</label></td>
					<td id="div_remain_cnt" class="pad_btm_8" style="visibility:hidden"><label for="remain_cntr_cnt"><strong>Remain CNT</strong></label><input type="text" style="width:32px;" class="input2 mar_left_4" name="remain_cntr_cnt" id="remain_cntr_cnt" readonly ></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('euDoRlseStsCntr');</script>
		<script type="text/javascript">ComSheetObject('euDoRlseStsBl');</script>
	</div>
	<!-- opus_design_grid(E) -->

<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
<!-- opus_design_inquiry(S) -->

	<div class="layout_wrap">
		 <!-- layout_vertical_2(S) -->
     	<div class="layout_flex_fixed" style="width:600px">
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="160">
						<col width="30">
						<col width="30">
						<col width="165">
						<col width="50">
						<col width="20">
						<col width="*">
					</colgroup>
		            <tr>
		                <td><h3 class="title_design mar_top_8">Bill of Lading Status</h3></td>
		                <td><input type="text" name="blIss_obl_rdem_flg" id='blIss_obl_rdem_flg' style="width:25px; color:blue; font-weight:bold;text-align:center;" class="input2" readonly>
		                <th>No</th>
		                <td><input type="text" name="blIss_obl_cpy_knt" id='blIss_obl_cpy_knt' style="width:25px;color:black;text-align:center; font-weight:bold;margin-right:8px" class="input2" readonly><!--
		                --><button type="button" class="btn_etc" name="btn_obl_cancel" id="btn_obl_cancel">RCV Cancel</button></td>
		                <td><h3 class="title_design mar_top_8">TPB</h3></td>
		                <td><img src="img/btng_icon_g.gif" width="13px" height="13px" border="0" align="absmiddle" id="tpb_icon"></td>
		                <td><!--  
		                --><input type="text" style="width:20px;text-align:center;" name='tpb_cd' id='tpb_cd' class="input2" readOnly><!--  
		                --><button type="button" name="btn_tpb" id="btn_tpb" class="input_seach_btn" style="visibility: hidden;margin-right:10px"></button><!--  
		                --><input type="text" name='hold_flag' id='hold_flag' style="width:50px; text-align:center;" class="input2_1" readOnly><!--  
		                --><input type="hidden" name='refInfo_do_hld_flg' id='refInfo_do_hld_flg'></td>
		            </tr>
		         </table>
			</div>
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="150">
						<col width="100">
						<col width="100">
						<col width="100">
						<col width="100">
						<col width="*">
					</colgroup>
	                 <tr>
	                     <th>B/L Issue</th>
	                     <td><input type="text" name="blIss_bl_tp_cd" id='blIss_bl_tp_cd' style="width:45px; text-align: center" class="input2" readOnly></td>
	                     <th>OFC</th>
	                     <td><!--  
	                     --><input type="text" name="blIss_obl_iss_ofc_cd" id='blIss_obl_iss_ofc_cd' style="width:60px;" class="input2" readOnly><!--  
	                     --><input type="text" name="blIss_obl_iss_usr_id" id='blIss_obl_iss_usr_id' style="width:70px;" class="input2" readOnly></td>
	                     <th>DT</th>
	                     <td><!--  
	                     --><input type="text" name="blIss_obl_iss_dt" id='blIss_obl_iss_dt' style="width:110px;" class="input2" readOnly><!--  
	                     --><input type="text" style="width:50px; text-align:center;" value="" class="noinput2" readOnly></td>
	                 </tr>
	
	                 <tr>
	                     <th>B/L Receive</th>
	                     <td><input type="text" name="blIss_obl_rdem_knt" id='blIss_obl_rdem_knt' style="width:45px;text-align:center;ime-mode: disabled" class="input" dataformat="num" maxlength='3'></td>
	                     <th>OFC</th>
	                     <td><!--  
	                     --><input type="text" name="blIss_obl_rdem_ofc_cd" id='blIss_obl_rdem_ofc_cd' style="width:60px;text-align:lrft;" class="input2" readOnly><!--  
	                     --><input type="text" name="blIss_obl_rdem_usr_id" id='blIss_obl_rdem_usr_id' style="width:70px;text-align:left;" class="input2" readOnly></td>
	                     <th>DT</th>
	                     <td><!--  
	                     --><input type="text" name="blIss_obl_rdem_dt" id='blIss_obl_rdem_dt' style="width:110px;text-align:center;" class="input2" readOnly><!--  
	                     --><input type="text" name="bl_surr_rmk_flg" id='bl_surr_rmk_flg' style="width:50px;text-align:center;" class="noinput2" readOnly><!--  
	                     --><button type="button" name="div_btn_bl_surr_flg" id="div_btn_bl_surr_flg" class="input_seach_btn" onClick="openPopup('cust_cd')" style="visibility: hidden;"></button></td>
	                 </tr>
	
	                 <tr>
	                     <th>Other DOC RCV</th>
	                     <td>
	                         <select style="width:45px; text-align:center;" name="blIss_bl_otr_doc_rcv_cd" id='blIss_bl_otr_doc_rcv_cd'></select>
	                     </td>
	                     <th>OFC</th>
	                     <td><!--  
	                     --><input type="text" name="blIss_otr_doc_rcv_ofc_cd" id='blIss_otr_doc_rcv_ofc_cd' style="width:60px;" class="input2" readOnly><!--  
	                     --><input type="text" name="blIss_otr_doc_rcv_usr_id" id='blIss_otr_doc_rcv_usr_id' style="width:70px;" class="input2" readOnly></td>
	                     <th>DT</th>
	                     <td><!--  
	                     --><input type="text" name="blIss_otr_doc_rcv_dt" id='blIss_otr_doc_rcv_dt' style="width:110px;" class="input2" readOnly><!--  
	                     --><select name="blIss_otr_doc_cgor_flg" id='blIss_otr_doc_cgor_flg' style="width:100px;text-align:center;"><!--  
	                     --><option></option><!--  
	                     --><option value="N">Non-Accept</option><!--  
	                     --><option value="Y">Accept</option><!--  
	                     --></select></td>
	                 </tr>
	
	                 <tr>
	                     <th>Inbond DOC RCV</th>
	                     <td><input type="text" name="blIss_ibd_doc_rcv_flg" id="blIss_ibd_doc_rcv_flg" style="width:45px;text-align:left;" value="" class="input2" readOnly></td>
	                     <th>OFC</th>
	                     <td>
	                         <input type="text"  name="blIss_ibd_doc_rcv_ofc_cd" id="blIss_ibd_doc_rcv_ofc_cd" style="width:60px;text-align:left;" value="" class="input2" readOnly><!-- 
	                          --><input type="text" name="blIss_ibd_doc_rcv_usr_id" id="blIss_ibd_doc_rcv_usr_id" style="width:70px;text-align:left;" value="" class="input2" readOnly></td>
	                     <th>DT</th>
	                     <td>
	                         <input type="text" name="blIss_ibd_doc_rcv_dt" id="blIss_ibd_doc_rcv_dt" style="width:110px;text-align:left;" value="" class="input2" readOnly><!-- 
	                          --><input type="text" name="" style="width:50px;text-align:left;" value="" class="noinput2" readOnly>
	                     </td>
	                 </tr>
	             </table>
			</div>
			<!-- opus_design_grid(E) -->
     	</div>
     	<!-- layout_vertical_2(E) -->
     	
     	 <!-- layout_vertical_2(S) -->
     	<div class="layout_flex_flex" style="padding-left:658px">
     		<!-- opus_design_inquiry(S) -->
			 <div class="opus_design_inquiry">
				 <table>
				 	  <colgroup>
				 	  	 <col width="180">
				 	  	 <col width="*">
				 	  </colgroup>
                      <tr>
                          <td><h3 class="title_design mar_top_8">Freight Received Status</h3></td>
                          <td>
                              <input type="text" style="width:20px;text-align:center;" class="input2_1" name='otsRcvInfo_tot_ots_sts_cd' id='otsRcvInfo_tot_ots_sts_cd' readonly><!-- 
                               --><select style="width:150px;font-weight:bold;" class="input2" name='tot_ots_amt' id="tot_ots_amt"></select>
                          </td>
                      </tr>
                  </table>
			 </div>
			<!-- opus_design_inquiry(E) -->
			
			<!-- opus_design_inquiry(S) -->
			 <div class="opus_design_inquiry">
			 	 <table>
			 	 	 <colgroup>
				 	  	 <col width="30">
				 	  	 <col width="60">
				 	  	 <col width="30">
				 	  	 <col width="130">
				 	  	 <col width="60">
				 	  	 <col width="*">
				 	  </colgroup>
                      <tr>
                          <th>PPD1</th>
                          <td><input type="text" name="otsRcvInfo_ppt_sts_cd" id='otsRcvInfo_ppt_sts_cd' style="width:27px;text-align:center;" class="input2" readOnly></td>
                          <th>OFC</th>
                          <td><!-- 
                           --><input type="text" name="otsRcvInfo_ppt_rcv_ofc_cd" id='otsRcvInfo_ppt_rcv_ofc_cd' style="width:60px;text-align:left;" class="input2" readOnly><!-- 
                            --><input type="text" name="otsRcvInfo_ppt_rcv_usr_id" id='otsRcvInfo_ppt_rcv_usr_id' style="width:70px;text-align:left;" class="input2" readOnly></td>
                          <th>DT</th>
                          <td><input type="text" name="otsRcvInfo_ppt_rcv_dt" id='otsRcvInfo_ppt_rcv_dt' style="width:125px;text-align:center;" class="input2" readOnly></td>
                      </tr>
                      <tr>
                          <th>CCT1</th>
                          <td><input type="text" name="otsRcvInfo_cct_sts_cd" id='otsRcvInfo_cct_sts_cd' style="width:27px;text-align:center;color:red;" class="input2" readOnly><!-- 
                            --><button type="button" name="div_btn_cct" id="div_btn_cct" class="input_seach_btn"></button></td>
                          <th>OFC</th>
                          <td><!-- 
                           --><input type="text" name="otsRcvInfo_cct_rcv_ofc_cd" id='otsRcvInfo_cct_rcv_ofc_cd' style="width:60px;text-align:left;" class="input2" readOnly><!-- 
                            --><input type="text" name="otsRcvInfo_cct_rcv_usr_id" id='otsRcvInfo_cct_rcv_usr_id' style="width:70px;text-align:left;" class="input2" readOnly></td>
                          <th>DT</th>
                          <td><input type="text" name="otsRcvInfo_cct_rcv_dt" id='otsRcvInfo_cct_rcv_dt' style="width:125px;text-align:center;" class="input2" readOnly></td>
                      </tr>
                      <tr>
                          <th>PPD2</th>
                          <td><input type="text" name="otsRcvInfo_n3pty_ppt_sts_cd" id='otsRcvInfo_n3pty_ppt_sts_cd' style="width:27px;text-align:center;" class="input2" readOnly></td>
                          <th>OFC</th>
                          <td><!-- 
                           --><input type="text" name="otsRcvInfo_n3pty_ppt_rcv_ofc_cd" id='otsRcvInfo_n3pty_ppt_rcv_ofc_cd' style="width:60px;text-align:left;" class="input2" readOnly><!-- 
                            --><input type="text" name="otsRcvInfo_n3pty_ppt_rcv_usr_id" id='otsRcvInfo_n3pty_ppt_rcv_usr_id' style="width:70px;text-align:left;" class="input2" readOnly></td>
                          <th>DT</th>
                          <td><input type="text" name="otsRcvInfo_n3pty_ppt_rcv_dt" id='otsRcvInfo_n3pty_ppt_rcv_dt' style="width:125px;text-align:center;" class="input2" readOnly></td>
                      </tr>
                      <tr>
                          <th>CCT2</th>
                          <td><input type="text" name="otsRcvInfo_n3pty_cct_sts_cd" id='otsRcvInfo_n3pty_cct_sts_cd' style="width:27px;text-align:center;color:red;" class="input2" readOnly><!--  
                          --><button type="button" name="div_btn_third_cct" id="div_btn_third_cct" class="input_seach_btn"></button></td>
                          <th>OFC</th>
                          <td><!-- 
                           --><input type="text" name="otsRcvInfo_n3pty_cct_rcv_ofc_cd" id='otsRcvInfo_n3pty_cct_rcv_ofc_cd' style="width:60px;text-align:left;" class="input2" readOnly><!-- 
                            --><input type="text" name="otsRcvInfo_n3pty_cct_rcv_usr_id" id='otsRcvInfo_n3pty_cct_rcv_usr_id' style="width:70px;text-align:left;" class="input2" readOnly></td>
                          <th>DT</th>
                          <td><input type="text" name="otsRcvInfo_n3pty_cct_rcv_dt" id='otsRcvInfo_n3pty_cct_rcv_dt' style="width:125px;text-align:center;" class="input2" readOnly></td>
                      </tr>
                  </table>
			 </div>
			 <!-- opus_design_inquiry(S) -->
     	</div>
     	<!-- layout_vertical_2(E) -->
	</div>

	 <div class="opus_design_inquiry">
 		<table>
			 <colgroup>
		 	  	 <col width="220"> 
		 	  	 <col width="180">
		 	  	 <col width="100">
		 	  	 <col width="50">
		 	  	 <col width="130">
		 	  	 <col width="160">
		 	  	 <col width="140">
		 	  	 <col width="*">
		 	  </colgroup>
              <tr>
                  <td><h3 class="title_design mar_top_8">Demurrage Status/Outstanding</h3></td>
                  <td><!-- 
                   --><input type="text" name='demur_sts' id='demur_sts' style="width:25px; font-weight:bold;" class="input2" readOnly><!-- 
                    --><select style="width:130px; font-weight:bold;" name='tot_bil_amt' id="tot_bil_amt"></select></td>
                  <th>Demurrage Type</th>
                  <td><input type="text" name='demur_type' id='demur_type' style="width:35px;" class="input2" readOnly></td>
                  <th>Expect Delivery Date</th> 
                  <td><!-- 
                   --><input type="text" name='exp_del_dt' id='exp_del_dt' style="width:120px;ime-mode:disabled" class="input1" caption="Expect Delivery Date" dataformat="ymd"><!--  
                   --><button type="button" class="calendar ir" name="img_exp_del_dt" id="img_exp_del_dt"></button></td>
                  <td><button type="button" class="btn_etc" id='btn_dem_retrieve' name="btn_dem_retrieve" >Retrieve</button><!--
                  --><button type="button" class="btn_etc" id='btn_dmdt' name="btn_dmdt" >DMDT</button></td>
                  <td></td>
              </tr>
       	</table>
 	</div>
 	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id='mainTable'>
		<!--Demurrage-->
       	<script type="text/javascript">ComSheetObject('demInfo');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id='mainTable' style="display: none;"">
		<!--Demurrage-->
       	<script type="text/javascript">ComSheetObject('demDtl');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_data(S) -->
	<div class="layout_vertical_2 pad_rgt_12"  style="width:50.7%">
				<table class="grid_2">
				 	<tr>
	         <th><strong>O/B Remark(s)</strong></t>
	         </tr>
				 	<tr>
	         <td class="noinput2" style="text-align:center;"><textarea style="width:100%; height:25px;resize:none" name="blInfo_obl_iss_rmk" id="blInfo_obl_iss_rmk" readonly class="noinput2"></textarea></td>
	        </tr>
				</table>
			</div>
			<div class="layout_vertical_2"  style="width:49.3%">
				<table>
		<tbody>
			<tr>
	        <th  class="pad_top_4 pad_btm_4"><button type="button" class="btn_etc" style="width: 100%;" id="hold_remark" name="btn_hold_remark">Hold / Internal  Remark(s)</button></th>
	          </tr>
					<tr>
			        	<td><textarea style="width:100%; height:25px;resize:none" name="refInfo_inter_rmk" id="refInfo_inter_rmk" ></textarea></td>
	        </tr>
			    </table>
			</div>
			
     <!-- opus_design_data(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_RD rd_hidden">
		<script type="text/javascript">ComSheetObject('blInfo');</script>
		<script type="text/javascript">ComSheetObject('otsRcvPop');</script>
		<script type="text/javascript">ComSheetObject('partial');</script>
		<script type="text/javascript">ComSheetObject('totBlbAmt');</script>
		<script type="text/javascript">ComSheetObject('otsRcvInfo');</script>
		<script type="text/javascript">ComSheetObject('euCstmsInfo');</script>
		<script type="text/javascript">ComSheetObject('blIss');</script>
	</div> 
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_RD rd_hidden">
		<script type="text/javascript">ComSheetObject('refInfo');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>	
<%if (!mainPage.equals("true")) { %></div><%}%>
</form> 