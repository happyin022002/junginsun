<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0680.jsp
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0680Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0680Event event     = null;         //PDTO(Data Transfer Object including Parameters)
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

    String code = "";
    String value = "";
    String mainPage = "";
    
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.FullReleaseOrder");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
        strCntCd  = account.getCnt_cd();
        mainPage = JSPUtil.getNull(request.getParameter("mainPage"));

        event = (EsmBkg0680Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        //  extract additional data obtained from the server during Initial loading ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>


<script type="text/javascript">

    /**************************************
    Global Variables
    **************************************/

    var lginOfcCd = "<%=strOfcCd %>";  //Login user office code
    var lginCntCd = "<%=strCntCd %>";  //Login user country code
    var lginUsrId = "<%=strUsr_id %>"; //Login user id
   	var evtCode = "<%=code %>|";
	var evtValue = "<%=value %>|";
 
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
<!-- Hold OR UN-HOLD devision value -->
<input type="hidden" name="evnt_flag" id="evnt_flag" />
<!--If O/BL bring or not - Hidden attribute retrieve calling value -->
<input type="hidden" name="h_ori_obl_rdem_flg" id="h_ori_obl_rdem_flg" />
<!--If O/BL bring or not - the time inputting O/BL Received OR Other DOC Receive,  changing value-->
<input type="hidden" name="h_aft_obl_rdem_flg" id="h_aft_obl_rdem_flg" />
<!--- Before changing value in D/O EVENT -->
<input type="hidden" name="pre_ctnt" id="pre_ctnt" />
<!---After changing  value in D/O EVENT-->
<input type="hidden" name="crnt_ctnt" id="crnt_ctnt" />
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
<input type="hidden" name="h_do_no_split" id="h_do_no_split" />
<!--if OBL is changing or not-->
<input type="hidden" name="obl_cng_flg" id="obl_cng_flg" />
<!--value after O/BL Received changing  -->
<input type="hidden" name="old_obl_rdem_knt" id="old_obl_rdem_knt" />
<!--value before O/BL Received changing-->
<input type="hidden" name="new_obl_rdem_knt" id="new_obl_rdem_knt" />

<!-- Remark for Release  -->
<input type="hidden" name="releaseRemark" id="releaseRemark" />

<input type="hidden" name="h_cntr_no" id="h_cntr_no" />

<!-- RD part  -->
<input type="hidden" name="h_mrd_id" id="h_mrd_id" />
<input type="hidden" name="h_mrd_param" id="h_mrd_param" />
<input type="hidden" name="h_local_lang_flg" id="h_local_lang_flg" />
<input type="hidden" name="com_mrdPath"  id="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="">

<input type="hidden" name="com_mrdTitle" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" name="com_mrdDisableToolbar" value="">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="">

<!--DEM.DET popup calling parameter 2009-12-08-->
<input type='hidden' name ="demDtlXmlData" id ="demDtlXmlData">
<input type='hidden' name ='h_hold_remark' id ='h_hold_remark' value = "">
<input type='hidden' name ="split_flg" id="split_flg">


<% if (!mainPage.equals("true")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>India Cargo Release ( ESM_BKG_0680 )</span></h2>
		<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_release" id="btn_release">Release</button><!--
		--><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_preview" id="btn_preview">Preview</button><!--
		--><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!--
		--><button type="button" class="btn_normal" name="btn_receiverinfo" id="btn_receiverinfo">Receiver Info</button><!--
		--><button type="button" class="btn_normal" name="btn_remark" id="btn_remark">External Remark(s)</button><!--
		--><button type="button" class="btn_normal" name="btn_hold" id="hld">Hold</button><!--
		--><button type="button" class="btn_normal" name="btn_unhold" id="uhld" style="display:none">Hold Removal</button><!--
		--><button type="button" class="btn_normal" name="btn_history" id="btn_history">History</button><!--
		--><button type="button" class="btn_normal" name="btn_form_setup" id="btn_form_setup">Form Setup</button><!-- 
		--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
	</div>
</div>
<%}else{%>
<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_release" id="btn_release">Release</button><!--
		--><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_preview" id="btn_preview">Preview</button><!--
		--><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!--
		--><button type="button" class="btn_normal" name="btn_receiverinfo" id="btn_receiverinfo">Receiver Info</button><!--
		--><button type="button" class="btn_normal" name="btn_remark" id="btn_remark">External Remark(s)</button><!--
		--><button type="button" class="btn_normal" name="btn_hold" id="hld">Hold</button><!--
		--><button type="button" class="btn_normal" name="btn_unhold" id="uhld" style="display:none">Hold Removal</button><!--
		--><button type="button" class="btn_normal" name="btn_history" id="btn_history">History</button><!--
		--><button type="button" class="btn_normal" name="btn_form_setup" id="btn_form_setup">Form Setup</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<%}%>

<%if (!mainPage.equals("true")) { %><div class="layer_popup_contents"><%}%>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="45"/>
				<col width="10"/>
				<col width="90"/>
				<col width="10"/>
				<col width="140" />
				<col width="*"/>
			</colgroup>
		  <tr>
			<th>B/L No.</th>
				<td><input name="bl_no" id="bl_no" caption="B/L No." type="text" style="width:125px;ime-mode:disabled; background-image : url('style/images/theme_default/select.png'); background-position:center right; background-repeat:no-repeat;" dataformat="engup" class="input" maxlength="13"></td>
			<th>BKG No.</th>
			<td>
				<input name="bkg_no" id="bkg_no" caption="BKG No." type="text" style="width:120px;" class="input" maxlength="13" dataformat="engup" style="ime-mode:disabled" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>"><!--  
				--><input name='blInfo_split_flg' id='blInfo_split_flg' type="text" style="width:40px ;color:red; font-weight:bold;text-align: center" readOnly class="input2">
			</td>
			<th>Container No.</th>
			<td><input name="cntr_no" id="cntr_no" caption="Container No." fullfill type="text" style="width:120px;" class="input" maxlength="11" dataformat = "engup" style="ime-mode:disabled"></td> 
           </tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(S) -->
<div class="wrap_result">
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="45">
				<col width="60">
				<col width="45">
				<col width="60">
				<col width="70">
				<col width="130">
				<col width="55">
				<col width="10">
				<col width="75">
				<col width="10">
				<col width="147">
				<col width="*">
			</colgroup>
			<tr>
             <th title="Place of Receipt">POR</th>
             <td><input type="text" style="width:50px;text-align:center;" class="input2" readonly="true" name="blInfo_por_cd" id="blInfo_por_cd" /></td>
             <th>POL</th>
             <td><input type="text" style="width:50px;text-align:center;" class="input2" readonly="true" name="blInfo_pol_cd" id="blInfo_pol_cd" /></td>
             <th title="Port of Discharging">POD</th>
             <td><input type="text" style="width:50px;text-align:center;" class="input2" readonly="true" name="blInfo_pod_cd" id="blInfo_pod_cd" /></td>
             <th title="Place of Delivery">DEL</th>
             <td><input type="text" style="width:50px;text-align:center;" class="input2" readonly="true" name="blInfo_del_cd" id="blInfo_del_cd" /></td>
             <th>DEL Term</th>
             <td><input type="text" style="width:79px; text-align: left" class="input2" readonly="true" name="blInfo_de_term_desc" id="blInfo_de_term_desc" /></td>
             <th>Arrival Vessel</th>
             <td><input type="text" style="width:100px;text-align:left;" class="input2" readonly="true" name="blInfo_arrival_vessel" id="blInfo_arrival_vessel" /></td>
           </tr>

		   <tr>
             <th>ETA</th>
             <td colspan="3"><input type="text" style="width:156px;text-align:center;" class="input2"  readonly="true" name="blInfo_vps_eta_dt" id="blInfo_vps_eta_dt"></td>
             <th>PKG</th>
             <td><input type="text" style="width:50px;text-align:right;"  class="input2" readonly="true" name="blInfo_pck_qty" id ="blInfo_pck_qty"><input type="text" style="width:30px;text-align:center;" class="input2" readonly="true" name="blInfo_pck_tp_cd" id="blInfo_pck_tp_cd"></td>
             <th>WGT</th>
             <td><input type="text" style="width:70px;text-align:right;"  class="input2" readonly="true" name="blInfo_act_wgt" id="blInfo_act_wgt"><input type="text" style="width:30px;text-align:center;" class="input2" readonly="true" name="blInfo_wgt_ut_cd" id="blInfo_wgt_ut_cd"></td>
             <th>MEA</th>
             <td><input type="text" style="width:45px;text-align:right;"  class="input2" readonly="true" name="blInfo_meas_qty" id="blInfo_meas_qty"><input type="text" style="width:30px;text-align:center;" class="input2" readonly="true" name="blInfo_meas_ut_cd" id="blInfo_meas_ut_cd"></td>
             <th>Discharging Terminal</th>
             <td><input type="text" style="width:100px;text-align:left;" class="input2" readonly="true" name="blInfo_dsch_loc" id="blInfo_dsch_loc"></td>
            </tr>
		</tbody>
	</table>	
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
		<colgroup>
			<col width="45">
			<col width="150">
			<col width="45">
			<col width="50">
			<col width="35">
			<col width="50">
			<col width="10">
			<col width="*">
		</colgroup>
		<tr>
           <th>IGM</th>
           <td><input type="text" caption="IGM MF No." name="refInfo_ida_imp_gen_mf_no" id="refInfo_ida_imp_gen_mf_no" style="width:80px" class="input" maxlength="10" style="ime-mode: disabled" dataformat="engup" /><input type="text" caption="IGM Year"   name="refInfo_ida_cgor_ord_yr"   id="refInfo_ida_cgor_ord_yr"   style="width:36px" class="input" maxlength="2"  style="ime-mode: disabled" dataformat="engup" /></td>
           <th>TRO/I</th>
           <td><input type="text" style="width:30px;text-align:center;" class="input2" readonly="true" name="cstmsInfo_troi_flg" id="cstmsInfo_troi_flg"></td>
           <th>SOC</th>
           <td><input type="text" style="width: 30px; text-align: center" class="input2" readonly="true" name="blInfo_soc_flg" id="blInfo_soc_flg"></td>
           <th>Consignee</th>
           <td><input type="text" name="blInfo_ccust_nm" id="blInfo_ccust_nm" style="width:150px;text-align:left;" class="input2" readonly="true"><input type="text" name="blInfo_ccust_addr"  id="blInfo_ccust_addr"  style="width:390px;text-align:left;" class="input2" readonly="true"></td>
           <td></td>
       </tr>
	   <tr>
		  <th>Line #</th>
		  <td><input type="text" caption="IGM Line No." name="refInfo_ida_cstms_asgn_line_no" id="refInfo_ida_cstms_asgn_line_no" style="width:120px" class="input" style="ime-mode: disabled" dataformat="engup" /></td>
		  <th>Partial</th>
		  <td><input type="text" style="width:30px;text-align:center;" class="input2" readonly="true" name="blInfo_cntr_prt_flg" id="blInfo_cntr_prt_flg"></td>
		  <td></td>
		  <td></td>
		  <th>Notify</th>
		  <td><input type="text" name="blInfo_ncust_nm" id="blInfo_ncust_nm"   style="width:150px;text-align:left;" class="input2" readonly="true"><input type="text" name="blInfo_ncust_addr" id="blInfo_ncust_addr" style="width:390px;text-align:left;" class="input2" readonly="true"></td>
	    </tr>
		</tbody>
	</table>	
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="125">
				<col width="100">
				<col width="70">
				<col width="109">
				<col width="160">
				<col width="105">
				<col width="*">
			</colgroup>
			<tr>
             <th>D/O No Split By CNTR</th>
             <td><input type="radio" name="refInfo_do_split_flg" id="refInfo_do_split_flg" value="N" class="trans" checked="true"><label for="refInfo_do_split_flg">No</label>
             	 <input type="radio" name="refInfo_do_split_flg" id="refInfo_do_split_flg" value="Y" class="trans"><label for="refInfo_do_split_flg">Yes</label></td>                       
             <td id="div_remain_cnt"  style="visibility:hidden" width="180px">Remain CNTR<!-- 
                 --><input type="text" style="width:32px;" class="input2 mar_left_4" name="remain_cnt" id="remain_cnt" readonly="true" ></td>    
             <th>DMDT Payment Type</th>
             <td><select name="refInfo_ida_do_dmdt_pay_tp_cd" id="refInfo_ida_do_dmdt_pay_tp_cd" style="width:127px;" class="input1"></select></td>
             <th>Validity Date</th>
             <td><input type="text" style="width:80px;" class="input" name="refInfo_ida_do_vty_dt" id ="refInfo_ida_do_vty_dt" dataformat="ymd" maxlength="10" caption="Validity Date" onKeyPress="obj_KeyPress(this);"></td>
            </tr>
		</tbody>
	</table>	
</div>

<!-- opus_design_grid(S) -->

<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('cntrRlseSts');</script>
		<script type="text/javascript">ComSheetObject('doRlseSts');</script>
</div>

<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->

<!-- layout_wrap(S) -->
<div class="layout_wrap">
	<div class="layout_vertical_2" style="width:600px">
		<div class="opus_design_inquiry pad_rgt_12" style="width:100%;">    
			<table>
				<tbody>
					<colgroup>
						<col width="120">
						<col width="10">
						<col width="20">
						<col width="30">
						<col width="160">
						<col width="35">
						<col width="35">
						<col width="55">
						<col width="*">
					</colgroup>			
					<tr>                                          
		               <th><h3 class="title_design">Bill of Lading Status</h3></th> 
		               <td></td>                         
		               <td><input type="text" name="blIss_obl_rdem_flg" id="blIss_obl_rdem_flg" style="width:25px; color:blue; font-weight:bold;text-align:center;" class="input2" readOnly></td>
		               <th>No</th>
		               <td><input type="text" name="blIss_obl_cpy_knt" id="blIss_obl_cpy_knt" style="width:25px;color:black;text-align:center; font-weight:bold;margin-right:8px" class="input2" readOnly><button type="button" class="btn_etc" name="btn_obl_cancel" id="btn_obl_cancel" >RCV Cancel</button></td>                                     
		               <th><h3 class="title_design">TPB</h3></th>                        
		               <td><img src="img/btng_icon_g.gif" width="13px" height="13px" border="0" align="absmiddle" id="tpb_icon"></td>
		               <td><input type="text" style="width:20px;text-align:center;" name='tpb_cd' id='tpb_cd' class="input2" readOnly><img class="cursor" name="btn_tpb" src="img/btns_search.gif" id="btn_tpb" src="img/btns_search.gif" width="19px" height="20px" border="0" align="absmiddle"></td>
		               <td><input type="text" name="hold_flag" id="hold_flag" style="width:50px; text-align:center;" class="input2_1" readOnly><input type="hidden" name="refInfo_do_hld_flg" id="refInfo_do_hld_flg"></td>
		             </tr>
		             <tr height="8"></tr>
				</tbody>
			</table>	
			<table>
				<tbody>
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
		                <td><input type="text" name="blIss_bl_tp_cd" id="blIss_bl_tp_cd" style="width:45px;text-align:center;" class="input2" readOnly></td>
		                <th>OFC</th>
		                <td><input type="text" name="blIss_obl_iss_ofc_cd" id ="blIss_obl_iss_ofc_cd" style="width:60px;" class="input2" readOnly><input type="text" name="blIss_obl_iss_usr_id" id="blIss_obl_iss_usr_id" style="width:70px;" class="input2" readOnly></td>
		                <th>DT</th>
		                <td><input type="text" name="blIss_obl_iss_dt" id="blIss_obl_iss_dt" style="width:110px;" class="input2" readOnly></td>
		            </tr>
		            <tr>
		                <th>B/L Receive</th>
		                <td><input type="text" name="blIss_obl_rdem_knt" id ="blIss_obl_rdem_knt" style="width:45px;text-align:center;" class="input" dataformat="int" style="ime-mode: disabled" maxlength='3' onKeyPress="ComKeyOnlyNumber(this);" ></td>
		                <th>OFC</th>
		                <td><input type="text" name="blIss_obl_rdem_ofc_cd"  id="blIss_obl_rdem_ofc_cd"  style="width:60px;" class="input2" readOnly><input type="text" name="blIss_obl_rdem_usr_id"  id="blIss_obl_rdem_usr_id" style="width:70px;" class="input2" readOnly></td>
		                <th>DT</th>
		                <td><input type="text" name="blIss_obl_rdem_dt" id="blIss_obl_rdem_dt" style="width:110px;" class="input2" readOnly><input type="text" name="bl_surr_rmk_flg" id ="bl_surr_rmk_flg" style="width:50px;" class="noinput2" readOnly><button type="button" name="btn_bl_surr_rmk" id="btn_bl_surr_rmk" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
		            </tr>
		            <tr>
		                <th>Other DOC RCV</th>
		                <td><select style="width:45px;text-align:center;" name="blIss_bl_otr_doc_rcv_cd" id="blIss_bl_otr_doc_rcv_cd"><option value=""></option><option value="LG">LG</option><option value="LI">LI</option></select></td>
		                <th>OFC</th>
		                <td><input type="text" name="blIss_otr_doc_rcv_ofc_cd" id ="blIss_otr_doc_rcv_ofc_cd" style="width:60px;" class="input2" readOnly><input type="text" name="blIss_otr_doc_rcv_usr_id" id ="blIss_otr_doc_rcv_usr_id" style="width:70px;" class="input2" readOnly></td>
		                <th>DT</th>
		                <td><input type="text" name="blIss_otr_doc_rcv_dt" id="blIss_otr_doc_rcv_dt" style="width:110px;" class="input2" readOnly><select name="blIss_otr_doc_cgor_flg" id="blIss_otr_doc_cgor_flg" style="width:80px;text-align:center;"><option> </option><option value="N">Non-Accept</option><option value="Y">Accept</option></select></td>
		            </tr>
		            <tr>
		                <th>B/L Entry RCV</th>
		                <td><select name="blIss_ibd_doc_rcv_flg" id="blIss_ibd_doc_rcv_flg" style="width:45px;text-align:center;"><option value="N">N</option><option value="Y">Y</option></select></td>
		                <th>OFC</th>
		                <td><input type="text" name="blIss_ibd_doc_rcv_ofc_cd"  id="blIss_ibd_doc_rcv_ofc_cd" style="width:60px;" class="input2" readOnly><input type="text" name="blIss_ibd_doc_rcv_usr_id" id="blIss_ibd_doc_rcv_usr_id" style="width:70px;" class="input2" readOnly></td>
		                <th>DT</th>
		                <td><input type="text" name="blIss_ibd_doc_rcv_dt"  id="blIss_ibd_doc_rcv_dt" style="width:110px;text-align:center;" class="input2" readOnly></td>
		            </tr>
					</tbody>
				</table>
				<table><tr height="8"></tr></table>
		</div>
	</div>
	
	<div class="layout_vertical_2" style="width:500px;">
		<div class="opus_design_inquiry" style="width:100%;">
			<table>
				<tbody>
					<colgroup>
						<col width="140"/>
						<col width="*" />
					</colgroup>
					<tr>
		  			     <th><h3 class="title_design">Freight Received Status</h3></th>
		     		 	 <td><input type="text" style="width:30px;text-align:center;" class="input2_1" name="otsRcvInfo_tot_ots_sts_cd" readonly="" id="otsRcvInfo_tot_ots_sts_cd" /><select style="width:150px;font-weight:bold;" class="input2" name='tot_ots_amt' id='tot_ots_amt'></select></td>
		             </tr>
		             <tr height="8"></tr>
		         </tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="60">
				 	  	 <col width="60">
				 	  	 <col width="60">
				 	  	 <col width="130">
				 	  	 <col width="60">
				 	  	 <col width="*">
					</colgroup>
		             <tr>
		                 <th>PPD1</th>
		                 <td><input type="text" name="otsRcvInfo_ppt_sts_cd" style="width:27px;text-align:center;" class="input2" readonly id="otsRcvInfo_ppt_sts_cd" /> </td>
		                 <th>OFC</th>
		                 <td><input type="text" name="otsRcvInfo_ppt_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readonly="" id="otsRcvInfo_ppt_rcv_ofc_cd" /><input type="text" name="otsRcvInfo_ppt_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readonly="" id="otsRcvInfo_ppt_rcv_usr_id" /></td>
		                 <th>DT</th>
		                 <td><input type="text" name="otsRcvInfo_ppt_rcv_dt" style="width:125px;text-align:center;" class="input2" readonly id="otsRcvInfo_ppt_rcv_dt" /> </td>
		             </tr>
		             <tr>
			             <th>CCT1</th>
			             <td>
			            	 <input type="text" name="otsRcvInfo_cct_sts_cd" style="width:27px;text-align:center;color:red;" class="input2" readOnly>&nbsp;<img src="img/btns_search.gif" id="div_btn_cct" name="btn_cct" style="visibility:hidden" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			             <th>OFC</th>
			             <td><input type="text" name="otsRcvInfo_cct_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readOnly><input type="text" name="otsRcvInfo_cct_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readOnly></td>
			             <th>DT</th>
			             <td><input type="text" name="otsRcvInfo_cct_rcv_dt" style="width:125px;text-align:center;" class="input2" readOnly></td>
		             </tr>
		             <tr>
		                 <th>PPD2</th>
		                 <td><input type="text" name="otsRcvInfo_n3pty_ppt_sts_cd" style="width:27px;text-align:center;" class="input2" readonly id="otsRcvInfo_n3pty_ppt_sts_cd" /> </td>
		                 <th>OFC</th>
		                 <td><input type="text" name="otsRcvInfo_n3pty_ppt_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readonly="" id="otsRcvInfo_n3pty_ppt_rcv_ofc_cd" /><input type="text" name="otsRcvInfo_n3pty_ppt_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readonly="" id="otsRcvInfo_n3pty_ppt_rcv_usr_id" /></td>
		                 <th>DT</th>
		                 <td><input type="text" name="otsRcvInfo_n3pty_ppt_rcv_dt" style="width:125px;text-align:center;" class="input2" readonly id="otsRcvInfo_n3pty_ppt_rcv_dt" /> </td>
		             </tr>
		            <tr>
		            	<th>CCT2</th>
			            <td><input type="text" name="otsRcvInfo_n3pty_cct_sts_cd" style="width:27px;text-align:center;color:red;" class="input2" readOnly>&nbsp;<img src="img/btns_search.gif" id="div_btn_third_cct" style="visibility:hidden" name="btn_third_cct" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			            </td>
			            <th>OFC</th>
			            <td><input type="text" name="otsRcvInfo_n3pty_cct_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readOnly><!-- 
			             --><input type="text" name="otsRcvInfo_n3pty_cct_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readOnly></td>
			            <th>DT</th>
			            <td><input type="text" name="otsRcvInfo_n3pty_cct_rcv_dt" style="width:125px;text-align:center;" class="input2" readOnly></td>
		            </tr>
		         </tbody>
			</table>
		</div>
	</div>
</div>

<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="181">
				<col width="125">
				<col width="120">
				<col width="60">
				<col width="35">
				<col width="*">
			</colgroup>
			<tr>                                           
            	<th><h3 class="title_design mar_top_8">Demurrage Status/Outstanding</h3></th>
            	<td><input type="text" name="demur_sts"  id="demur_sts" style="width:25px; font-weight:bold;" class="input2"><select style="width:160px;font-weight:bold;" class="input2" name="tot_bil_amt" id="tot_bil_amt"></select></td>                                        
                <th>Demurrage Type</th>
                <td><input type="text" name="demur_type" id="demur_type" style="width:35px;" class="input2" readonly="true"></td>                                 
                <th>Expect Delivery Date</th>
                <td><input type="text" name='exp_del_dt' id='exp_del_dt' style="width:75px;ime-mode:disabled" class="input1" caption="Expect Delivery Date" dataformat="ymd" minlength="8" maxlength="8" required="true"><button type="button" class="calendar ir" name="img_exp_del_dt" id="img_exp_del_dt" style="margin-right:10px"></button><button type="button" class="btn_etc" name="btn_dem_retrieve" id="btn_dem_retrieve">Retrieve</button><button type="button" class="btn_etc" name="btn_dmdt" id="btn_dmdt">DMDT</button></td>                                               
            </tr>
		</tbody>
	</table>
</div>

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('demInfo');</script>
		<script type="text/javascript">ComSheetObject('demDtl');</script>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->
<div class="opus_design_data">
<div class="layout_wrap">
    <div class="layout_vertical_2 pad_rgt_8">
	<table class="grid2 mar_none">
		<tbody>
			<tr> 
               	<th>O/B Remark(s)</th>  
            </tr>             
           	<tr>
       			<td>
       			<textarea style="resize:none; width: 100%; height:20px" row="3" name='blInfo_obl_iss_rmk' id='blInfo_obl_iss_rmk' readonly class="noinput2"></textarea>
       		</td>          
            </tr>	
       </tbody>
	</table>
	</div>
	<!-- <div class="layout_vertical_2" align="center" >
	<td width="2%" valign="top"></td>
	<div style="height: 50px;">&nbsp;</div>
	</div> -->
	<div class="layout_vertical_2">
	<table>
		<tbody>
			<tr>
                <td class="pad_top_4">
                	<button type="button" class="btn_etc mar_btm_4" name="btn_hold_remark" id="btn_hold_remark" style="width:100%" >Hold / Internal  Remark(s)</button>
                </td>
             </tr>
             <tr>      			                     
             	<td class="mar_btm_4">
             		<textarea style="width:100%; height:20px;" name='refInfo_inter_rmk' id='refInfo_inter_rmk' onKeyDown="fncTextareaMaxLine(this.value)"></textarea>
             	</td>
            </tr>
		</tbody>
	</table>
	</div>
</div>
 </div>
<%if (!mainPage.equals("true")) { %><br><!-- 하단 잘림 문제로 공백 추가 --><%}%> 
</div>
<!----------------------------------------------------------------------
    Hidden IB Sheet Define
----------------------------------------------------------------------->
<!--Japan D/O Release basic Information-->
<script type="text/javascript">ComSheetObject("blInfo");</script>
<!--Japan D/O Release ReferenceInformation-->
<script type="text/javascript">ComSheetObject("refInfo");</script>
<!--B/L INFO for JApan customs declaration-->
<script type="text/javascript">ComSheetObject("cstmsInfo");</script>
<!--whether Original B/L can be received or not and  Detail Information-->
<script type="text/javascript">ComSheetObject("blIss");</script>
<!-- Outstanding AmountsInformation-->
<script type="text/javascript">ComSheetObject("otsRcvInfo");</script>
<!--Total Billable Amount-->
<script type="text/javascript">ComSheetObject("totBlbAmt");</script>
<!--Partial containerInformation retrieve-->
<script type="text/javascript">ComSheetObject("partial");</script>
<!--OutStanding Amount popup용 retrieve-->
<script type="text/javascript">ComSheetObject('otsRcvPop');</script>


<%if (!mainPage.equals("true")) { %></div><%}%>
</form>