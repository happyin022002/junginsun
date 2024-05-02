<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0128.jsp
*@FileTitle  : General Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0128Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    EsmBkg0128Event event     = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //error from the server	
    String strErrMsg = "";                    //error messege
    int rowCount     = 0;                     //the number of DB ResultSet List

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100"; 

    String strUsr_id   = "";
    String strUsr_nm   = "";
    String strOfcCd    = "";
    String strCntCd    = "";
    String mainPage	   = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
        strCntCd  = account.getCnt_cd();


        event = (EsmBkg0128Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        mainPage = JSPUtil.getNull(request.getParameter("mainPage"));

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
    /**************************************
        Global Variables
    **************************************/

    var lginOfcCd = "<%=strOfcCd %>"; //Login user office code
    var lginCntCd = "<%=strCntCd %>"; //Login user country code
    var strUsr_id = "<%=strUsr_id%>"; //Login user id

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<div id="blLayer" class="blLayer" style="position:absolute;z-index: 999; background-color:#ffffff; visibility: hidden; overflow-y:auto; overflow-x:hidden; border-width:1px; border-style:solid;"></div>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!----------------------------------------------------------------------
    Hidden Value Define
----------------------------------------------------------------------->
<input type="hidden" name="h_cntr_no" id="h_cntr_no" />
<input type="hidden" name="xmlData" id="xmlData" />
<input type="hidden" name="oaXmlData" id="oaXmlData" />
<input type="hidden" name="blInfo_do_split_flg" id="blInfo_do_split_flg" />
<!-- Hold OR UN-HOLD devision value -->
<input type="hidden" name="evnt_flag" id="evnt_flag" />
<!--If O/BL bring or not - Hidden attribute retrieve calling value -->
<input type="hidden" name="h_ori_obl_rdem_flg" id="h_ori_obl_rdem_flg" />
<!--If O/BL bring or not - the time inputting O/BL Received OR Other DOC Receive,  changing value-->
<input type="hidden" name="h_aft_obl_rdem_flg" id="h_aft_obl_rdem_flg" />
<!--- Before changing value in D/O EVENT -->
<input type="hidden" name="pre_ctnt" id="pre_ctnt" />
<!-- Ivoce Bil_Amt Total-->
<input type="hidden" name="invTotBilAmt" id="invTotBilAmt" />
<!-- Dor Interface issue and condition Information -->
<input type="hidden" name="dorStsCd" id="dorStsCd" />
<!-- D / O-related tasks that occur in major EVENT -->
<input type="hidden" name="do_cng_evnt_cd" id="do_cng_evnt_cd" />
<!-- TPB Status -->
<input type="hidden" name="tpb_status" id="tpb_status" />
<!-- D/O proceed condition code -->
<input type="hidden" name="rlse_sts_cd" id="rlse_sts_cd" />
<!--final D/O proceed condition code -->
<input type="hidden" name="last_rlse_sts_cd" id="last_rlse_sts_cd" />
<!-- DO number-->
<input type="hidden" name="h_do_no" id="h_do_no" />
<!--if OBL is changing or not-->
<input type="hidden" name="obl_cng_flg" id="obl_cng_flg" />
<!--value after O/BL Received changing  -->
<input type="hidden" name="old_obl_rdem_knt" id="old_obl_rdem_knt" />
<!--value before O/BL Received changing-->
<input type="hidden" name="new_obl_rdem_knt" id="new_obl_rdem_knt" />
<!-- Remark for Release  -->
<input type="hidden" name="releaseRemark" id="releaseRemark" />
<input type="hidden" name="crnt_ctnt" id="crnt_ctnt" />

<input type="hidden" name="h_cntr_no" id="h_cntr_no" />
<!-- RD part  -->
<input type="hidden" name="h_mrd_id" id="h_mrd_id" />
<input type="hidden" name="h_mrd_param" id="h_mrd_param" />
<input type="hidden" name="h_local_lang_flg" id="h_local_lang_flg" />
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />

<input type="hidden" name="com_mrdTitle" value="" id="com_mrdTitle" />
<input type="hidden" name="com_mrdDisableToolbar" value="" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdBodyTitle" value="" id="com_mrdBodyTitle" />

<!--DEM.DET popup calling parameter 2009-12-08-->
<input type="hidden" name="demDtlXmlData" id="demDtlXmlData" />
<input type="hidden" name="h_hold_remark" value="" id="h_hold_remark" />
<input type='hidden' name ='dubai_mrd_id'>
<input type='hidden' name ="refInfo_do_split_flg" id="refInfo_do_split_flg">

<% if (!mainPage.equals("true")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Cargo Release Creation (ESM_BKG_0128)</span></h2>
		
		<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button><!--  
		--><button type="button" class="btn_normal" name="btn_release" 		id="btn_release">Release</button><!--  
		--><button type="button" class="btn_normal" name="btn_cancel"  		id="btn_cancel">Cancel</button><!--  
		--><button type="button" class="btn_normal" name="btn_preview" 		id="btn_preview">Preview</button><!--  
		--><button type="button" class="btn_normal" name="btn_print"        id="btn_print">Print</button><!--
		--><button type="button" class="btn_normal" name="btn_receiverinfo" id="btn_receiverinfo">Receiver Info</button><!-- 
		--><button type="button" class="btn_normal" name="btn_remark" 		id="btn_remark">External Remark(s)</button><!--  
		--><button type="button" class="btn_normal" name="btn_hold"  		id="btn_hold">Hold</button><!--  
		--><button type="button" class="btn_normal" name="btn_unhold" 		id="btn_unhold" style="display:none">Hold Removal</button><!--  
		--><button type="button" class="btn_normal" name="btn_history" 		id="btn_history">History</button><!--  
		--><button type="button" class="btn_normal" name="btn_form_setup"  	id="btn_form_setup">Form Setup</button><!--
		--><button type="button" class="btn_normal" name="btn_cy"  			id="btn_cy">CY or Unstuff</button><!-- 
		--><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
		</div>
	</div>
</div>
<%}else{%>
<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button><!--  
		--><button type="button" class="btn_normal" name="btn_release" 		id="btn_release">Release</button><!--  
		--><button type="button" class="btn_normal" name="btn_cancel"  		id="btn_cancel">Cancel</button><!--  
		--><button type="button" class="btn_normal" name="btn_preview" 		id="btn_preview">Preview</button><!--  
		--><button type="button" class="btn_normal" name="btn_print"        id="btn_print">Print</button><!--
		--><button type="button" class="btn_normal" name="btn_receiverinfo" id="btn_receiverinfo">Receiver Info</button><!-- 
		--><button type="button" class="btn_normal" name="btn_remark" 		id="btn_remark">External Remark(s)</button><!--  
		--><button type="button" class="btn_normal" name="btn_hold"  		id="btn_hold">Hold</button><!--  
		--><button type="button" class="btn_normal" name="btn_unhold" 		id="btn_unhold" style="display:none">Hold Removal</button><!--  
		--><button type="button" class="btn_normal" name="btn_history" 		id="btn_history">History</button><!--  
		--><button type="button" class="btn_normal" name="btn_form_setup"  	id="btn_form_setup">Form Setup</button><!--
		--><button type="button" class="btn_normal" name="btn_cy"  			id="btn_cy">CY or Unstuff</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<%}%>

<%if (!mainPage.equals("true")) { %><div class="layer_popup_contents"><%}%>
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="45">
				<col width="180">
				<col width="40">
				<col width="210">
				<col width="60">
				<col width="130">
				<col width="*">
			</colgroup>
	        <tr>
                  <th>B/L No.</th>
                  <td><input name="bl_no" id="bl_no" caption="B/L No." type="text" style="width:125px;ime-mode:disabled; background-image : url('style/images/theme_default/select.png'); background-position:center right; background-repeat:no-repeat;" dataformat="engup" class="input" maxlength="13"></td>
                  <th>BKG No.</th>
                  <td><input name="bkg_no" caption="BKG No." type="text" style="width:120px;" class="input" maxlength="13" value="<%=JSPUtil.getNull(request.getParameter("bkg_no")) %>" id="bkg_no" dataformat="engup"><!--  
                  --><input name='blInfo_split_flg' id='blInfo_split_flg' type="text" dataformat="engup" style="width:40px;color:red; font-weight:bold;text-align: center" readOnly class="input2"></td>
                  <th>Container No.</th>
                  <td><input name="cntr_no" caption="Container No." type="text" style="width:120px;" class="input" maxlength="11" id="cntr_no" dataformat="engup" fullfill="true"></td>
                  <td></td>
             </tr>
        </table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_inquiry(E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30">
				<col width="60">
				<col width="30">
				<col width="80">
				<col width="40">
				<col width="110">
				<col width="50">
				<col width="50">
				<col width="150">
				<col width="120">
				<col width="55">
				<col width="*">
			</colgroup>
             <tr>
                 <th title="Place of Receipt">POR</th>
                 <td><input type="text" style="width: 50px; text-align: center" class="input2" readonly="readonly" name="blInfo_por_cd" id="blInfo_por_cd"></td>
                 <th title="Port of Loading">POL</th>
                 <td><input type="text" style="width: 50px; text-align: center" class="input2" readonly="readonly" name="blInfo_pol_cd" id="blInfo_pol_cd"></td>
                 <th title="Port of Discharging">POD</th>
                 <td><input type="text" style="width: 52px; text-align: center" class="input2" readonly="readonly" name="blInfo_pod_cd" id="blInfo_pod_cd"></td>
                 <th title="Place of Delivery">DEL</th>
                 <td><input type="text" style="width: 50px; text-align: center" class="input2" readonly="readonly" name="blInfo_del_cd" id="blInfo_del_cd"></td>
                 <th>DEL Term</th>
                 <td><input type="text" style="width:79px; text-align: left" class="input2" readonly="readonly" name="blInfo_de_term_desc" id="blInfo_de_term_desc"></td>
                 <th>Arrival Vessel</th>
                 <td><input type="text" style="width: 100%; text-align: left" class="input2" readonly="readonly" name="blInfo_arrival_vessel" id="blInfo_arrival_vessel"></td>
             </tr>
        </table>
        <table>
			<colgroup>
				<col width="30">
				<col width="170">
				<col width="40">
				<col width="110">
				<col width="50">
				<col width="120">
				<col width="87">
				<col width="115">
				<col width="50">
				<col width="*">
			</colgroup>
             <tr>
                 <th>ETA</th>
                 <td><input type="text" style="width: 140px; text-align: center" class="input2" readonly="readonly" name="blInfo_vps_eta_dt" id="blInfo_vps_eta_dt"></td>
                 <th>PKG</th>
                 <td><input type="text" style="width: 52px; text-align: right" class="input2" readOnly name="blInfo_pck_qty" id='blInfo_pck_qty'><!--  
                 --><input type="text" style="width: 30px; text-align: center" class="input2" readOnly name="blInfo_pck_tp_cd" id='blInfo_pck_tp_cd'></td>
                 <th>WGT</th>
                 <td><input type="text" style="width: 80px; text-align: right" class="input2" readOnly name="blInfo_act_wgt" id="blInfo_act_wgt"><!-- 
                      --><input type="text" style="width: 30px; text-align: center" class="input2" readOnly name="blInfo_wgt_ut_cd" id='blInfo_wgt_ut_cd'></td>
                 <th>MEA</th>
                 <td><input type="text" style="width: 45px; text-align: right" class="input2" readOnly name="blInfo_meas_qty" id='blInfo_meas_qty'><!-- 
                      --><input type="text" style="width: 30px; text-align: center" class="input2" readOnly name="blInfo_meas_ut_cd" id='blInfo_meas_ut_cd'>
                 </td>
                 <th>Discharging CY</th>
                 <td><input type="text" style="width: 100%; text-align: left" class="input2" readOnly name="blInfo_dsch_loc" id='blInfo_dsch_loc'></td>
             </tr>
    	</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<table class="line_bluedot"><tr><td></td></tr></table>
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="250">
				<col width="60">
				<col width="60">
				<col width="70">
				<col width="140">
				<col width="630">
			</colgroup>
			<tr>
                 <td><input type="text" style="width:112px;" class="input" name="blInfo_cstms_ref_nm" id='blInfo_cstms_ref_nm' maxlength='50'><!--  
                 --><input type="text" style="width:121px;" class="input" value="" name="blInfo_cstms_ref_ctnt" id='blInfo_cstms_ref_ctnt' maxlength='20'></td>
                 <th>Partial</th>
                 <td><input type="text" style="width:30px; text-align: center" class="input2" readOnly name="blInfo_cntr_prt_flg" id='blInfo_cntr_prt_flg'></td>
              	 <th>Consignee</th>
                 <td><input type="text" name="blInfo_ccust_nm" id='blInfo_ccust_nm' style="width:140px;text-align:left;" class="input2" readOnly></td>
                 <td><input type="text" name="blInfo_ccust_addr" id='blInfo_ccust_addr'  style="width:100%;text-align:left;" class="input2" readOnly></td>
             </tr>
             <tr>
                 <td><input type="text" style="width:112px;"  class="input" name="blInfo_cstms_asgn_nm" id='blInfo_cstms_asgn_nm' maxlength='50' ><!--  
                 --><input type="text" style="width:121px;" class="input" value="" name="blInfo_cstms_asgn_ctnt" id='blInfo_cstms_asgn_ctnt' maxlength='20'></td>
                 <th>SOC</th>
                 <td><input type="text" style="width: 30px; text-align: center" class="input2" readOnly name="blInfo_soc_flg" id='blInfo_soc_flg'></td>
                 <th>Notify</th>
                 <td><input type="text" name="blInfo_ncust_nm" id='blInfo_ncust_nm'  style="width:140px;text-align:left;" class="input2" readOnly></td>
                 <td><input type="text" name="blInfo_ncust_addr" id='blInfo_ncust_addr' style="width:100%;text-align:left;" class="input2" readOnly></td>
             </tr>
         </table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<!-- opus_design_grid(S) 
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('doRlseSts');</script>
	</div>
	-->
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
		<script type="text/javascript">ComSheetObject('doRlseStsCntr');</script>
		<script type="text/javascript">ComSheetObject('doRlseStsBl');</script>
	</div>
	<!-- opus_design_grid(E) -->
		 <!-- layout_vertical_2(S) -->
		<div class="layout_wrap wFit">
     	<div class="layout_flex_fixed pad_rgt_12" style="width:660px">
     		<div class="opus_design_inquiry">
     			<table>
					<colgroup>
						<col width="150">
						<col width="35">
						<col width="30">
						<col width="40">
						<col width="100">
						<col width="50">
						<col width="50">
						<col width="80">
						<col width="*">
					</colgroup>
		            <tr>
		                <th><h3 class="title_design">Bill of Lading Status</h3></th>
		                <td><input type="text" name="blInfo_obl_rdem_flg" id='blInfo_obl_rdem_flg' style="width:25px; color:blue; font-weight:bold;text-align:center;" class="input2" readonly>
		                <th>No</th>
		                <td><input type="text" name="blInfo_obl_cpy_knt" id='blInfo_obl_cpy_knt' style="width:25px;color:black;text-align:center; font-weight:bold;" class="input2" readonly></td>
		                <td><button type="button" class="btn_etc" name="btn_obl_cancel" id="btn_obl_cancel">RCV Cancel</button></td>
		                <th><h3 class="title_design">TPB</h3></th>
		                <td><img src="img/btng_icon_g.gif" width="13px" height="13px" border="0" align="absmiddle" id="tpb_icon"></td>
		                <td><!--  
		                --><input type="text" style="width:20px;text-align:center;" name='tpb_cd' id='tpb_cd' class="input2" readOnly>&nbsp;<!--  
		                --><button type="button" name="btn_tpb" id="btn_tpb" class="input_seach_btn"></button></td>
		                <td><!--  
		                --><input type="text" name='hold_flag' id='hold_flag' style="width:50px; text-align:center;" class="input2_1" readOnly><!--  
		                --><input type="hidden" name='blInfo_do_hld_flg' id='blInfo_do_hld_flg'></td>
		            </tr>
		         </table>
     		</div>
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="100">
						<col width="70">
						<col width="40">
						<col width="150">
						<col width="30">
						<col width="*">
					</colgroup>
	                 <tr>
	                     <th>B/L Issue</th>
	                     <td><input type="text" name="blInfo_bl_tp_cd" id='blInfo_bl_tp_cd' style="width:55px; text-align: center" class="input2" readOnly></td>
	                     <th>OFC</th>
	                     <td><!--  
	                     --><input type="text" name="blInfo_obl_iss_ofc_cd" id='blInfo_obl_iss_ofc_cd' style="width:60px;" class="input2" readOnly><!--  
	                     --><input type="text" name="blInfo_obl_iss_usr_id" id='blInfo_obl_iss_usr_id' style="width:70px;" class="input2" readOnly></td>
	                     <th>DT</th>
	                     <td><!--  
	                     --><input type="text" name="blInfo_obl_iss_dt" id='blInfo_obl_iss_dt' style="width:110px;" class="input2" readOnly><!--  
	                     --><input type="text" style="width:100px; text-align:center;" value="" class="noinput2" readOnly></td>
	                 </tr>
	
	                 <tr>
	                     <th>B/L Receive</th>
	                     <td><input type="text" name="blInfo_obl_rdem_knt" id='blInfo_obl_rdem_knt' style="width:55px;text-align:center;ime-mode: disabled" class="input" dataformat="num" maxlength='3'></td>
	                     <th>OFC</th>
	                     <td><!--  
	                     --><input type="text" name="blInfo_obl_rdem_ofc_cd" id='blInfo_obl_rdem_ofc_cd' style="width:60px;text-align:left;" class="input2" readOnly><!--  
	                     --><input type="text" name="blInfo_obl_rdem_usr_id" id='blInfo_obl_rdem_usr_id' style="width:70px;text-align:left;" class="input2" readOnly></td>
	                     <th>DT</th>
	                     <td><!--  
	                     --><input type="text" name="blInfo_obl_rdem_dt" id='blInfo_obl_rdem_dt' style="width:110px;text-align:left;" class="input2" readOnly><!--  
	                     --><input type="text" name="bl_surr_rmk_flg" id='bl_surr_rmk_flg' style="width:70px;text-align:center;" class="noinput2" readOnly><!--  
	                     --><button type="button" name="btn_bl_surr_flg" id="btn_bl_surr_flg" class="input_seach_btn"></button></td>
	                 </tr>
	                 <tr>
	                     <th>Other DOC RCV</th>
	                     <td>
	                         <select style="width:55px; text-align:center;" name="blInfo_bl_otr_doc_rcv_cd" id='blInfo_bl_otr_doc_rcv_cd'><!--  
	                         	--><option value=""></option><!--  
	                         	--><option value="LG">LG</option><!--  
	                         	--><option value="LI">LI</option></select>
	                     </td>
	                     <th>OFC</th>
	                     <td><!--  
	                     --><input type="text" name="blInfo_otr_doc_rcv_ofc_cd" id='blInfo_otr_doc_rcv_ofc_cd' style="width:60px;" class="input2" readOnly><!--  
	                     --><input type="text" name="blInfo_otr_doc_rcv_usr_id" id='blInfo_otr_doc_rcv_usr_id' style="width:70px;" class="input2" readOnly></td>
	                     <th>DT</th>
	                     <td><!--  
	                     --><input type="text" name="blInfo_otr_doc_rcv_dt" id='blInfo_otr_doc_rcv_dt' style="width:110px;" class="input2" readOnly><!--  
	                     --><select name="blInfo_otr_doc_cgor_flg" id='blInfo_otr_doc_cgor_flg' style="width:100px;text-align:center;"><!--  
	                     --><option></option><!--  
	                     --><option value="N">Non-Accept</option><!--  
	                     --><option value="Y">Accept</option><!--  
	                     --></select></td>
	                 </tr>
	
	                 <tr>
	                     <th>Inbond DOC RCV</th>
	                     <td><select name="blInfo_ibd_doc_rcv_flg" id="blInfo_ibd_doc_rcv_flg" style="width:55px;text-align:center;"><!-- 
                                     --><option value="N">N</option><!-- 
                                     --><option value="Y">Y</option><!-- 
                                 --></select></td>
	                     <th>OFC</th>
	                     <td><input name="blInfo_ibd_doc_rcv_ofc_cd" id="blInfo_ibd_doc_rcv_ofc_cd" type="text" name="" style="width:60px;text-align:left;" value="" class="input2" readOnly><!-- 
	                          --><input name="blInfo_ibd_doc_rcv_usr_id" id="blInfo_ibd_doc_rcv_usr_id" type="text" name="" style="width:70px;text-align:left;" value="" class="input2" readOnly></td>
	                     <th>DT</th>
	                     <td><input name="blInfo_ibd_doc_rcv_dt" id="blInfo_ibd_doc_rcv_dt" type="text" name="" style="width:110px;text-align:left;" value="" class="input2" readOnly><!-- 
	                          --><input type="text" name="" style="width:100px;text-align:left;" value="" class="noinput2" readOnly>
	                     </td>
	                 </tr>
	             </table>
			</div>
			<!-- opus_design_grid(E) -->
     	</div>
     	<!-- layout_vertical_2(E) -->
     	
     	 <!-- layout_vertical_2(S) -->
     	 <div class="layout_flex_flex"  style="padding-left:660px">
     		<div>
     	
     		<!-- opus_design_inquiry(S) -->
		
				 <table>
				 	  <colgroup>
				 	  	 <col width="180">
				 	  	 <col width="*">
				 	  </colgroup>
                      <tr>
                          <th><h3 class="title_design">Freight Received Status</h3></th>
                          <td><input type="text" name='blInfo_tot_ots_sts_cd' id='blInfo_tot_ots_sts_cd' style="width:20px;text-align:center;" class="input2" readonly><!--  
                          --><select style="width:150px;font-weight:bold;" class="input2" name='tot_ots_amt' id="tot_ots_amt"></select>
                          </td>
                      </tr>
                  </table>
			 </div>
			<!-- opus_design_inquiry(E) -->
			
			<!-- opus_design_inquiry(S) -->
			 <div class="opus_design_inquiry">
			 	 <table style="width:421px">
			 	 	 <colgroup>
				 	  	 <col width="40">
				 	  	 <col width="80">
				 	  	 <col width="40">
				 	  	 <col width="140">
				 	  	 <col width="40">
				 	  	 <col width="111">
				 	  </colgroup>
                      <tr>
                          <th>PPD1</th>
                          <td><input type="text" name="blInfo_ppt_sts_cd" id='blInfo_ppt_sts_cd' style="width:27px;text-align:center;" class="input2" readOnly></td>
                          <th>OFC</th>
                          <td><!-- 
                           --><input type="text" name="blInfo_ppt_rcv_ofc_cd" id='blInfo_ppt_rcv_ofc_cd' style="width:50px;text-align:left;" class="input2" readOnly><!-- 
                            --><input type="text" name="blInfo_ppt_rcv_usr_id" id='blInfo_ppt_rcv_usr_id' style="width:60px;text-align:left;" class="input2" readOnly></td>
                          <th>DT</th>
                          <td><input type="text" name="blInfo_ppt_rcv_dt" id='blInfo_ppt_rcv_dt' style="width:110px;text-align:center;" class="input2" readOnly></td>
                      </tr>
                      <tr>
                          <th>CCT1</th>
                          <td><input type="text" name="blInfo_cct_sts_cd" id='blInfo_cct_sts_cd' style="width:27px;text-align:center;color:red;" class="input2" readOnly><!-- 
                            --><button type="button" name="btn_cct" id="div_btn_cct" class="input_seach_btn"></button></td>
                          <th>OFC</th>
                          <td><!-- 
                           --><input type="text" name="blInfo_cct_rcv_ofc_cd" id='blInfo_cct_rcv_ofc_cd' style="width:50px;text-align:left;" class="input2" readOnly><!-- 
                            --><input type="text" name="blInfo_cct_rcv_usr_id" id='blInfo_cct_rcv_usr_id' style="width:60px;text-align:left;" class="input2" readOnly></td>
                          <th>DT</th>
                          <td><input type="text" name="blInfo_cct_rcv_dt" id='blInfo_cct_rcv_dt' style="width:110px;text-align:center;" class="input2" readOnly></td>
                      </tr>
                      <tr>
                          <th>PPD2</th>
                          <td><input type="text" name="blInfo_n3pty_ppt_sts_cd" id='blInfo_n3pty_ppt_sts_cd' style="width:27px;text-align:center;" class="input2" readOnly></td>
                          <th>OFC</th>
                          <td><!-- 
                           --><input type="text" name="blInfo_n3pty_ppt_rcv_ofc_cd" id='blInfo_n3pty_ppt_rcv_ofc_cd' style="width:50px;text-align:left;" class="input2" readOnly><!-- 
                            --><input type="text" name="blInfo_n3pty_ppt_rcv_usr_id" id='blInfo_n3pty_ppt_rcv_usr_id' style="width:60px;text-align:left;" class="input2" readOnly></td>
                          <th>DT</th>
                          <td><input type="text" name="blInfo_n3pty_ppt_rcv_dt" id='blInfo_n3pty_ppt_rcv_dt' style="width:110px;text-align:center;" class="input2" readOnly></td>
                      </tr>
                      <tr>
                          <th>CCT2</th>
                          <td><input type="text" name="blInfo_n3pty_cct_sts_cd" id='blInfo_n3pty_cct_sts_cd' style="width:27px;text-align:center;color:red;" class="input2" readOnly><!--  
                          --><button type="button" name="btn_third_cct" id="div_btn_third_cct" class="input_seach_btn"></button></td>
                          <th>OFC</th>
                          <td><!-- 
                           --><input type="text" name="blInfo_n3pty_cct_rcv_ofc_cd" id='blInfo_n3pty_cct_rcv_ofc_cd' style="width:50px;text-align:left;" class="input2" readOnly><!-- 
                            --><input type="text" name="blInfo_n3pty_cct_rcv_usr_id" id='blInfo_n3pty_cct_rcv_usr_id' style="width:60px;text-align:left;" class="input2" readOnly></td>
                          <th>DT</th>
                          <td><input type="text" name="blInfo_n3pty_cct_rcv_dt" id='blInfo_n3pty_cct_rcv_dt' style="width:110px;text-align:center;" class="input2" readOnly></td>
                      </tr>
                  </table>
			 </div>
			 <!-- opus_design_inquiry(S) -->
     	</div>
     
     	<!-- layout_vertical_2(E) -->
 	</div>
	<div class="opus_design_inquiry wFit">	 	
		<table>
			<colgroup>
		 	  	 <col width="220"> 
		 	  	 <col width="180">
		 	  	 <col width="100">
		 	  	 <col width="40">
		 	  	 <col width="140">
		 	  	 <col width="160">
		 	  	 <col width="60">
		 	  	 <col width="*">
		 	  </colgroup>
	             <tr>
	                 <th><h3 class="title_design">Demurrage Status/Outstanding</h3></th>
	                 <td><!-- 
	                  --><input type="text" name='demur_sts' id='demur_sts' style="width:25px; font-weight:bold;" class="input2" readOnly><!-- 
	                   --><select style="width:130px; font-weight:bold;" name='tot_bil_amt' id="tot_bil_amt"></select></td>
	                 <th>Demurrage Type</th>
	                 <td><input type="text" name='demur_type' id='demur_type' style="width:35px;" class="input2" readOnly></td>
	                 <th>Expect Delivery Date</th>
	                 <td><!-- 
	                  --><input type="text" name='exp_del_dt' id='exp_del_dt' style="width:120px;ime-mode:disabled" class="input1" caption="Expect Delivery Date" dataformat="ymd"><!-- 
	                  --><button type="button" class="calendar ir" name="img_exp_del_dt" id="img_exp_del_dt"></button></td>
	                 <td class="sm"><button type="button" class="btn_etc" id='btn_dem_retrieve' name="btn_dem_retrieve" >Retrieve</button></td>
	                 <td><button type="button" class="btn_etc" id='btn_dmdt' name="btn_dmdt" >DMDT</button></td>
	             </tr>
	      	</table>
	</div>      		 	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!--Demurrage-->
       	<script type="text/javascript">ComSheetObject('demInfo');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id='mainTable' style="display: none;">
		<!--Demurrage-->
       	<script type="text/javascript">ComSheetObject('demDtl');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_data(S) -->
	<div class="opus_design_data">
		<div class="layout_wrap">
		    <div class="layout_vertical_2 pad_rgt_12">
			<table class="grid_2">
				<tbody>
					<tr> 
				     <th><b>O/B Remark(s)</b></td>
				    </tr>             
		           	<tr>
		       		<td><textarea style="width:100%; height:18px; resize:none;" name="blInfo_obl_iss_rmk" id="blInfo_obl_iss_rmk" readonly class="noinput2"></textarea></td>          
		            </tr>	
		       </tbody>
			</table>
			</div>
			<div class="layout_vertical_2">
			<table>
				<tbody>
				<tr>
		           <td class="pad_top_4"><button type="button" class="btn_etc mar_btm_4" style="width: 100%;text-align: center;color:gray;resize:none" id="btn_hold_remark" name="btn_hold_remark">Hold / Internal  Remark(s)</button> </td>
		        </tr>
		        <tr>      			                     
		           <td><textarea style="width:100%;  height:22px;resize:none" name="blInfo_inter_rmk" id="blInfo_inter_rmk" ></textarea></td>
		        </tr>
				</tbody>
			</table>
			</div>
		</div>
	 </div>              
     <!-- opus_design_data(E) -->
	<!-- opus_design_data(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('blInfo');</script>
		<script type="text/javascript">ComSheetObject('totBlbAmt');</script>
		<script type="text/javascript">ComSheetObject('partial');</script>
	</div> 
	<!-- opus_design_grid(E) -->

</div>	
<%if (!mainPage.equals("true")) { %></div><%}%>
</form> 