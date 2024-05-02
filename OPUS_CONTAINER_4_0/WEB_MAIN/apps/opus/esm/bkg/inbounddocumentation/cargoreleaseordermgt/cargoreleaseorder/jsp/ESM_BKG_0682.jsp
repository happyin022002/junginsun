<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0682.jps
*@FileTitle  : Korea Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0682Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0682Event event     = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //error from server
    String strErrMsg = "";                    //error message
    int rowCount     = 0;                     //count of DB resultSET list

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
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
        strCntCd  = account.getCnt_cd();
        mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
        
        event = (EsmBkg0682Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">


    var lginOfcCd = "<%=strOfcCd %>"; //Login user office code
    var lginCntCd = "<%=strCntCd %>"; //Login user national code
    var strUsr_id = "<%=strUsr_id%>"; //Login user ID

    var evtCode = "<%=code %>|";
    var evtValue = "<%=code %>|";
    
    function setupPage(){
        loadStartDate = new Date();
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }
</script>


<div id="blLayer" class="blLayer" style="position:absolute;z-index: 999; background-color:#ffffff; visibility: hidden; overflow-y:auto; overflow-x:hidden; border-width:1px; border-style:solid;"></div>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name ="h_cntr_no" 		id ="h_cntr_no">
<input type='hidden' name ="xmlData" 		id ="xmlData">
<input type='hidden' name ="oaXmlData" 		id ="oaXmlData">
<input type='hidden' name ='evnt_flag'      id ='evnt_flag'>
<input type='hidden' name ='h_ori_obl_rdem_flg' id ='h_ori_obl_rdem_flg'>
<input type='hidden' name ='h_aft_obl_rdem_flg' id ='h_aft_obl_rdem_flg'>
<input type='hidden' name ='pre_ctnt' 			id ='pre_ctnt'>
<input type='hidden' name ='crnt_ctnt' 			id ='crnt_ctnt'>
<!-- Ivoce Bil_Amt Total-->
<input type='hidden' name ='invTotBilAmt' 		id ='invTotBilAmt'>
<input type='hidden' name ='dorStsCd' 			id ='dorStsCd'>
<input type='hidden' name ='do_cng_evnt_cd' 	id ='do_cng_evnt_cd'>
<!-- TPB Status -->
<input type='hidden' name ='tpb_status' 		id ='tpb_status'>
<input type='hidden' name ='rlse_sts_cd' 		id ='rlse_sts_cd'>
<input type='hidden' name ='last_rlse_sts_cd' 	id ='last_rlse_sts_cd'>
<!-- DO Number-->
<input type='hidden' name ='do_no' 				id ='do_no'>
<input type='hidden' name ='do_no_split' 		id ='do_no_split'>
<input type='hidden' name ='svc_cd' 			id ='svc_cd'>
<input type='hidden' name ='obl_cng_flg' 		id ='obl_cng_flg'>
<input type='hidden' name ='old_obl_rdem_knt' 	id ='old_obl_rdem_knt'>
<input type='hidden' name ='new_obl_rdem_knt' 	id ='new_obl_rdem_knt'>

<input type='hidden' name ='h_obl_rcv_flg' 		id ='h_obl_rcv_flg'>
<input type="hidden" name="nation_flag" 		id ="nation_flag" value="kor">
<!-- DO Number-->
<input type='hidden' name ='h_do_no' 			id ='h_do_no'>
<input type='hidden' name ='h_do_no_split' 		id ='h_do_no_split'>
<!-- Remark for Release  -->
<input type='hidden' name ='releaseRemark' 		id ='releaseRemark'>
<input type='hidden' name ='disc_loc_cd' 		id ='disc_loc_cd'>
<input type='hidden' name ='self_trns_flg' 		id ='self_trns_flg'>

<input type="hidden" name="com_mrdPath" 		id ="com_mrdPath">
<input type="hidden" name="com_mrdArguments" 	id="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" 		id="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle" 	id="com_mrdBodyTitle">
<input type='hidden' name ='mrd_id'  			id ='mrd_id'>
<input type='hidden' name ='mrd_param' 			id ='mrd_param'>
<input type='hidden' name ='usr_id' 			id ='usr_id' value="<%=strUsr_id%>">

<input type='hidden' name ="demDtlXmlData" 		id ="demDtlXmlData">
<input type='hidden' name ='h_hold_remark' 		id ='h_hold_remark' value = "">
<% if (!mainPage.equals("true")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Korea Cargo Release (D/O)</span></h2>
		<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve"			id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save"  			id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_assign" 			id="btn_assign">Assign</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_release"			id="btn_release">Release</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cancel"   			id="btn_cancel">D/O Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_receiverinfo"   	id="btn_receiverinfo">Receiver Info</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_remark"   			id="btn_remark">External Remark</button><!-- 
		 --><span id="hld"><button type="button" class="btn_normal" name="btn_Hold" id="btn_Hold">Hold</button></span><!-- 
		 --><span id="uhld" style="display:none"><button type="button" class="btn_normal" name="btn_Hold" id="btn_uHold">Hold Removeval</button></span><!-- 
		 --><button type="button" class="btn_normal" name="btn_History"   		id="btn_History">History</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_form_setup"   		id="btn_form_setup">Form Setup</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_preview"   		id="btn_preview">Preview</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print"   		id="btn_print">Print</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_bl_preview"   		id="btn_bl_preview">B/L Preview</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
	</div>
</div>
<%}else{%>
<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve"			id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save"  			id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_assign" 			id="btn_assign">Assign</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_release"			id="btn_release">Release</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cancel"   			id="btn_cancel">D/O Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_receiverinfo"   	id="btn_receiverinfo">Receiver Info</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_remark"   			id="btn_remark">External Remark</button><!-- 
		 --><span id="hld"><button type="button" class="btn_normal" name="btn_Hold" id="btn_Hold">Hold</button></span><!-- 
		 --><span id="uhld" style="display:none"><button type="button" class="btn_normal" name="btn_Hold" id="btn_uHold">Hold Removeval</button></span><!-- 
		 --><button type="button" class="btn_normal" name="btn_History"   		id="btn_History">History</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_form_setup"   		id="btn_form_setup">Form Setup</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_preview"   		id="btn_preview">Preview</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print"   		id="btn_print">Print</button><!-- 	
		 --><button type="button" class="btn_normal" name="btn_bl_preview"   		id="btn_bl_preview">B/L Preview</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<%}%>
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>


<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
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
			<tbody>
			<tr>				
                <th>B/L No.</th>
                <td><input name="bl_no" id="bl_no" caption="B/L No." type="text" style="width:125px;ime-mode:disabled; background-image : url('style/images/theme_default/select.png'); background-position:center right; background-repeat:no-repeat;" dataformat="engup" class="input" maxlength="13"></td>
                <th>BKG No.</th>
                <td><input dataformat="engup" name="bkg_no" id="bkg_no" caption="BKG No." type="text" style="width:120px;" class="input" maxlength="13" style="ime-mode:disabled" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>"><input name='blInfo_split_flg'  id='blInfo_split_flg' type="text" style="width:40px;color:red; font-weight:bold;text-align: center" readOnly class="input2"></td> 
                <th>Container No.</th>
                <td><input dataformat="engup" name="cntr_no" id="cntr_no" caption="Container No."  type="text" style="width:120px;" class="input" maxlength="11" style="ime-mode:disabled" fullfill></td>
                <td></td>                  
             </tr>
          	</tbody>         
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_inquiry wFit">
		<table >	
			<colgroup>
				<col width="40">
				<col width="60">
				<col width="40">
				<col width="60">
				<col width="60">
				<col width="110">
				<col width="40">
				<col width="150">
				<col width="70">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
			<tr>           
	            <th title="Place of Receipt">POR</th>
	            <td><input type="text" style="width: 50px; text-align: center" class="input2" readOnly name="blInfo_por_cd" id="blInfo_por_cd"></td>
	            <th title="Port of Loading">POL</th>
	            <td><input type="text" style="width: 50px; text-align: center" class="input2" readOnly name="blInfo_pol_cd" id="blInfo_pol_cd"></td>
	            <th title="Port of Discharging">POD</th>
	            <td><input type="text" style="width: 50px; text-align: center" class="input2" readOnly name="blInfo_pod_cd" id="blInfo_pod_cd"></td>
	            <th title="Place of Delivery">DEL</th>
	            <td><input type="text" style="width: 100px; text-align: center" class="input2" readOnly name="blInfo_del_cd" id="blInfo_del_cd"></td>
	            <th>DEL Term</th>
	            <td><input type="text" style="width:89px; text-align: left" class="input2" readOnly name="blInfo_de_term_desc" id="blInfo_de_term_desc"></td>
	            <th>Arrival Vessel</th>
	            <td><input type="text" style="width: 100px; text-align: left" class="input2" readOnly name="blInfo_arrival_vessel" id="blInfo_arrival_vessel"></td>
	         </tr>
           </tbody>
		</table>	
		<table>
			<colgroup>
				<col width="40">
				<col width="160">
				<col width="60">
				<col width="110">
				<col width="40">
				<col width="150">
				<col width="70">
				<col width="100">
				<col width="220">
				<col width="*">
			</colgroup>	
			<tbody>	
            <tr>
                <th>ETA</th>
                <td><input type="text" style="width:150px; text-align: center" class="input2" readOnly name="blInfo_vps_eta_dt" id="blInfo_vps_eta_dt"></td>
                <th>PKG</th>
                <td><input type="text" style="width: 52px; text-align: right" class="input2" readOnly name="blInfo_pck_qty" id="blInfo_pck_qty"><input type="text" style="width: 30px; text-align: center" class="input2" readOnly name="blInfo_pck_tp_cd" id="blInfo_pck_tp_cd"></td>
                <th>WGT</th>
                <td><input type="text" style="width: 80px; text-align: right" class="input2" readOnly name="blInfo_act_wgt" id="blInfo_act_wgt"><input type="text" style="width: 40px; text-align: center" class="input2" readOnly name="blInfo_wgt_ut_cd" id="blInfo_wgt_ut_cd"></td>
                <th>MEA</th>
                <td><input type="text" style="width: 45px; text-align: right" class="input2" readOnly name="blInfo_meas_qty" id="blInfo_meas_qty"><input type="text" style="width: 40px; text-align: center" class="input2" readOnly name="blInfo_meas_ut_cd" id="blInfo_meas_ut_cd"></td>
                <th>Discharging CY</th>
                <td><input type="text" style="width:100px;" class="input2" readOnly name="blInfo_loc_nm" id="blInfo_loc_nm"></td>
            </tr> 
            </tbody>            
		</table>
	</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
	
	<div class="opus_design_inquiry wFit">
		<table >	
				<colgroup>
					<col width="40"/>
					<col width="150"/>
					<col width="70"/>
					<col width="30"/>
					<col width="70"/>
					<col width="*"/>
				</colgroup>	
				<tbody>
				<tr>
	                 <th>MRN</th>
	                 <td><input type="text" name="blInfo_mf_ref_no" id="blInfo_mf_ref_no" style="width:139px" class="input2" readOnly></td>
	                 <th>Partial</th>
	                 <td><input type="text" style="width:30px;text-align: center" class="input2" readOnly name="blInfo_cntr_prt_flg" id="blInfo_cntr_prt_flg"></td>
	                 <th>Consignee</th>
	                 <td><input type="text" name="blInfo_ccust_nm" id="blInfo_ccust_nm" style="width:360px;text-align:left;" class="input2" readOnly><input type="text" name="blInfo_ccust_addr" id="blInfo_ccust_addr"  style="width:259px;text-align:left;" class="input2" readOnly></td>
                </tr>
                <tr>
	                 <th>MSN</th>
	                 <td><input type="text" name="blInfo_mf_seq_no" id="blInfo_mf_seq_no" style="width:139px" class="input2" readOnly></td>
	                 <th>SOC</th>
	                 <td><input type="text" style="width: 30px; text-align: center" class="input2" readOnly name="blInfo_soc_flg" id="blInfo_soc_flg"></td>
	                 <th>Notify</th>
	                 <td><input type="text" name="blInfo_ncust_nm" id="blInfo_ncust_nm"   style="width:360px;text-align:left;" class="input2" readOnly><input type="text" name="blInfo_ncust_addr" id="blInfo_ncust_addr" style="width:259px;text-align:left;" class="input2" readOnly></td>
                </tr>
           	</tbody>		
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<div class="layout_vertical_3 mar_rgt_4">
			<table >	
				<colgroup>
					<col width="70"/>
					<col width="30"/>
					<col width="70"/>
					<col width="90"/>
					<col width="*"/>
				</colgroup>	
				<tbody>
				<tr>
	            	<th>Entry Type</th>
	                <td><input type="text" name="blInfo_cstms_clr_tp_cd" id="blInfo_cstms_clr_tp_cd" style="width:30px;" class="input2" readOnly></td>
	                <th>Warehouse</th>
	                <td><input type="text" style="width:90px;" class="input2" name="blInfo_cstms_clr_wh_cd" id="blInfo_cstms_clr_wh_cd" readOnly><input type="text" 	  style="width:90px;" class="input2" name="blInfo_wh_nm" id="blInfo_wh_nm" readOnly></td>
				  	<td></td>
	           	</tr>
              	<tr>
             		<td></td>
             		<td></td>
             		<td></td>
             		<td style="text-align:right;"><button type="button" class="btn_etc" name="btn_msnbonded" id="btn_msnbonded" >Customs Decl.Info</button>
                    </td>  
                    <td></td>            
                </tr>
	       		</tbody>
			</table>	
		</div>
		<div class="layout_vertical_3 mar_rgt_4">
		<table>	
			<colgroup>
				<col width="80"/>
				<col width="20"/>
				<col width="80"/>
				<col width="20"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>	
            <tr>    
                <td><button type="button" class="btn_etc" name="btn_do" id="btn_do">DO issue</button></td>                                    
             	<td><input type="checkbox" class="trans" name='edo_rqst_sts' id='edo_rqst_sts' value='do' disabled></td>
          		<td><button type="button" class="btn_etc" name="btn_self" id="btn_self">Self Trans Request</button></td>                                    
             	<td><input type="checkbox" class="trans" name='edo_rqst_sts' id='edo_rqst_sts' value='self' disabled></td>
          		<td><button type="button" class="btn_etc" name="btn_bonded" id="btn_bonded">Bonded Trans Request</button> </td>                                    
             	<td><input type="checkbox" class="trans" name='edo_rqst_sts' id='edo_rqst_sts' value='bonded' disabled></td>
          	</tr>
          </tbody>
		</table>
		<table>	
            <tr> 
     			<td><button type="button" class="btn_etc" name="btn_attorney" id="btn_attorney">Power of Attorney</button><!--                                   
             	 --><button type="button" class="btn_etc" name="btn_edoinquiry" id="btn_edoinquiry">ED/O Inquiry</button><!-- 
     			 --><button type="button" class="btn_etc" name="btn_edotransmit" id="btn_edotransmit">ED/O Trans</button><!-- 
     			 --><button type="button" class="btn_etc" name="btn_edoresult" id="btn_edoresult">ED/O Result</button></td>
            </tr>
			</table>          
		</div>
		<div class="layout_vertical_3" >
			<table>	
			  	<tr style="float: left;height: 29px">
                	<th>Self Trans To TMNL</th>
	                <td><input type="checkbox" class="trans" id='selfTransToTMN' id='selfTransToTMN' ></td>
	            </tr>
	            <tr>
      	         	<!-- <td><button type="button" class="btn_etc" name="btn_stcancel" id="btn_stcancel">S/T Cancel</button>
                   	 <button type="button" class="btn_etc" name="btn_edisend" id="btn_edisend">EDI Send</button> </td>-->
				 </tr> 
			</table>         
		</div>
	</div>
</div>

<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('doRlseSts');</script>                                
</div>	           
	
	<div class="layout_wrap">
		<div class="layout_vertical_2" style="width:600px">
			<div class="opus_design_inquiry pad_rgt_12" style="width:100%;">
				<table>
					<colgroup>
						<col width="155"/>
						<col width="35"/>
						<col width="20"/>
						<col width="35"/>
						<col width="100"/>
						<col width="40"/>
						<col width="30"/>
						<col width="65"/>
						<col width="*"/>
					</colgroup>
					<tr>
		                <td><h3 class="title_design">Bill of Lading Status</h3></td>
		                <td><input type="text" name="blInfo_obl_rdem_flg" id="blInfo_obl_rdem_flg" style="width:25px; color:blue; font-weight:bold;text-align:center;" class="input2" readonly></td>
		                <th>No</th>
		                <td><input type="text" name="blInfo_obl_cpy_knt" id="blInfo_obl_cpy_knt" style="width:25px;color:black;text-align:center; font-weight:bold;" class="input2" readonly></td>
		                <td><button type="button" class="btn_etc" name="btn_obl_cancel" id="btn_obl_cancel">RCV Cancel</button></td>
		                <th><h3 class="title_design">TPB</h3></th>
		                <td><img src="img/btng_icon_g.gif" width="13" height="13" border="0" align="absmiddle" id="tpb_icon"></td>
		                <td><input type="text" style="width:20px;;text-align:center;" name='tpb_cd' id='tpb_cd' class="input2" readOnly><button class="input_seach_btn" name="btn_tpb" id="btn_tpb" type="button"></button></td>
		                <td><input type="text" name='hold_flag' id='hold_flag' style="width:50px; text-align:center;" class="input2_1" readOnly><input type="hidden" name='blInfo_do_hld_flg' id='blInfo_do_hld_flg'></td>
		            </tr>
		            <tr height="8"></tr>
				</table>
			
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
	                    <td><input type="text" name="blInfo_bl_tp_cd" id="blInfo_bl_tp_cd" style="width:40px; text-align:center" class="input2" readOnly></td>
	                    <th>OFC</th>
	                    <td><input type="text" name="blInfo_obl_iss_ofc_cd" id="blInfo_obl_iss_ofc_cd" style="width:60px;" class="input2" readOnly><input type="text" name="blInfo_obl_iss_usr_id" id="blInfo_obl_iss_usr_id" style="width:70px;" class="input2" readOnly></td>
	                    <th>DT</th>
	                    <td><input type="text" name="blInfo_obl_iss_dt" id="blInfo_obl_iss_dt" style="width:110px;" class="input2" readOnly><input type="text" style="width:1px;	text-align:center;"  class="noinput2" readOnly></td>
	               	</tr>
	            	<tr>
	                   <th>B/L Receive</th>
	                   <td><input type="text" name="blInfo_obl_rdem_knt" id="blInfo_obl_rdem_knt" style="width:40px;text-align:center;" class="input" dataformat="int" style="ime-mode: disabled" maxlength='3'></td>
	                   <th>OFC</th>
	                   <td><input type="text" name="blInfo_obl_rdem_ofc_cd" id="blInfo_obl_rdem_ofc_cd" style="width:60px;" class="input2" readOnly><input type="text" name="blInfo_obl_rdem_usr_id" id="blInfo_obl_rdem_usr_id" style="width:70px;" class="input2" readOnly></td>
	                   <th>DT</th>
	                   <td><input type="text" name="blInfo_obl_rdem_dt" id="blInfo_obl_rdem_dt" style="width:110px;text-align:center;" class="input2" readOnly><input type="text" name="bl_surr_rmk_flg" id="bl_surr_rmk_flg" style="width:54px;text-align:center;"  class="input2" readOnly><button class="input_seach_btn" name="btn_bl_surr_rmk" id="btn_bl_surr_rmk" type="button"></button></td>
		             </tr>
		             <tr>
		                 <th>Other DOC RCV</th>
		                 <td><select style="width:40px;text-align:center;" name="blInfo_bl_otr_doc_rcv_cd" id="blInfo_bl_otr_doc_rcv_cd"></select></td>
		                 <th>OFC</th>
		                 <td><input type="text" name="blInfo_otr_doc_rcv_ofc_cd" id="blInfo_otr_doc_rcv_ofc_cd" style="width:60px;" class="input2" readOnly><input type="text" name="blInfo_otr_doc_rcv_usr_id" id="blInfo_otr_doc_rcv_usr_id" style="width:70px;" class="input2" readOnly></td>
		                 <th>DT</th>
		                 <td><input type="text" name="blInfo_otr_doc_rcv_dt" id="blInfo_otr_doc_rcv_dt" style="width:110px;" class="input2" readOnly><select name="blInfo_otr_doc_cgor_flg" id="blInfo_otr_doc_cgor_flg" style="width:70px;text-align:center;"><option ></option><option value="N">Non-Accept</option><option value="Y">Accept</option></select></td>
		             </tr>
	                <tr>
	                    <th>Inbond DOC RCV</th>
	                    <td><input type="text" name="blInfo_ibd_doc_rcv_flg" id="blInfo_ibd_doc_rcv_flg" style="width:40px;text-align:center;"  class="input2" readOnly></td>
	                    <th>OFC</th>
	                    <td><input type="text" name="blInfo_ibd_doc_rcv_ofc_cd" id="blInfo_ibd_doc_rcv_ofc_cd" style="width:60px;"  class="input2" readOnly><input type="text" name="blInfo_ibd_doc_rcv_usr_id" id="blInfo_ibd_doc_rcv_usr_id" style="width:70px;text-align:center;"  class="input2" readOnly></td>
	                    <th>DT</th>
	                    <td><input type="text" name="blInfo_ibd_doc_rcv_dt" id="blInfo_ibd_doc_rcv_dt" style="width:110px;text-align:center;"  class="input2" readOnly><input type="text" name="" id="" style="width:1px;text-align:center;"  class="noinput2" readOnly></td>
	                </tr>
		          </table>
			</div>
		</div>
		<div class="layout_vertical_2" style="width:500px;">
			<div class="opus_design_inquiry" style="width:100%;">
				<table class="search">	
					<colgroup>
						<col width="180">
				 	  	 <col width="*">
					</colgroup>					                       
	                <tr>
	                    <td><h3 class="title_design">Freight Received Status</h3></td>                               
	                    <td><input type="text" style="width:20px;text-align:center;" class="input2_1" name='blInfo_tot_ots_sts_cd' id='blInfo_tot_ots_sts_cd' readonly><select style="width:150px;font-weight:bold;" class="input2" name='tot_ots_amt' id='tot_ots_amt'></select></td>
	                </tr>
					<tr height="8"></tr>	                
		        </table>
				<table>	
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
	                    <td><input type="text" name="blInfo_ppt_sts_cd" id="blInfo_ppt_sts_cd" style="width:27px;text-align:center;" class="input2" readOnly></td>
	                    <th>OFC</th>
	                    <td><input type="text" name="blInfo_ppt_rcv_ofc_cd" id="blInfo_ppt_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readOnly><input type="text" name="blInfo_ppt_rcv_usr_id" id="blInfo_ppt_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readOnly></td>
	                    <th>DT</th>
	                    <td><input type="text" name="blInfo_ppt_rcv_dt" id="blInfo_ppt_rcv_dt" style="width:125px;text-align:center;" class="input2" readOnly></td>
	                </tr>
	                <tr>
	                    <th>CCT1</th>
	                    <td><input type="text" name="blInfo_cct_sts_cd" id="blInfo_cct_sts_cd" style="width:27px;text-align:center;color:red;" class="input2" readOnly><button class="input_seach_btn" name="btn_cct" id="btn_cct" type="button"></button></td>
	                    <th>OFC</th>
	                    <td><input type="text" name="blInfo_cct_rcv_ofc_cd" id="blInfo_cct_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readOnly><input type="text" name="blInfo_cct_rcv_usr_id" id="blInfo_cct_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readOnly></td>
	                    <th>DT</th>
	                    <td><input type="text" name="blInfo_cct_rcv_dt" id="blInfo_cct_rcv_dt" style="width:125px;text-align:center;" class="input2" readOnly></td>
	                </tr>
	                <tr>
	                    <th>PPD2</th>
	                    <td><input type="text" name="blInfo_n3pty_ppt_sts_cd" id="blInfo_n3pty_ppt_sts_cd" style="width:27px;text-align:center;" class="input2" readOnly></td>
	                    <th>OFC</th>
	                    <td><input type="text" name="blInfo_n3pty_ppt_rcv_ofc_cd" id="blInfo_n3pty_ppt_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readOnly><input type="text" name="blInfo_n3pty_ppt_rcv_usr_id" id="blInfo_n3pty_ppt_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readOnly></td>
	                    <th>DT</th>
	                    <td><input type="text" name="blInfo_n3pty_ppt_rcv_dt" id="blInfo_n3pty_ppt_rcv_dt" style="width:125px;text-align:center;" class="input2" readOnly></td>
	                </tr>
	                <tr>
	                   <th>CCT2</th>
	                   <td><input type="text" name="blInfo_n3pty_cct_sts_cd" id="blInfo_n3pty_cct_sts_cd" style="width:27px;text-align:center;color:red;" class="input2" readOnly><button class="input_seach_btn" name="btn_third_cct" id="btn_third_cct" type="button"></button></td>
	                   <th>OFC</th>
	                   <td><input type="text" name="blInfo_n3pty_cct_rcv_ofc_cd" id="blInfo_n3pty_cct_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readOnly><input type="text" name="blInfo_n3pty_cct_rcv_usr_id" id="blInfo_n3pty_cct_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readOnly></td>
	                   <th>DT</th>
	                   <td><input type="text" name="blInfo_n3pty_cct_rcv_dt" id="blInfo_n3pty_cct_rcv_dt" style="width:125px;text-align:center;" class="input2" readOnly></td>
	               </tr>
	        	</table>
			</div>
		</div>

</div>                   
<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
	 	  	 <col width="220"> 
	 	  	 <col width="175">
	 	  	 <col width="110">
	 	  	 <col width="40">
	 	  	 <col width="140">
	 	  	 <col width="160">
	 	  	 <col width="135">
	 	  	 <col width="*">
	 	  </colgroup>
		<tbody>
 			<tr>
	            <td><h3 class="title_design mar_top_8">Demurrage Status/Outstanding</h3></td>
                  <td><!-- 
                   --><input type="text" name='demur_sts' id='demur_sts' style="width:25px; font-weight:bold;" class="input2" readOnly><!-- 
                    --><select style="width:130px; font-weight:bold;" name='tot_bil_amt' id="tot_bil_amt"></select></td>
                  <th>Demurrage Type</th>
                  <td><input type="text" name='demur_type' id='demur_type' style="width:35px;" class="input2" readOnly></td>
                  <th>Expect Delivery Date</th>
                  <td><!-- 
                   --><input type="text" name='exp_del_dt' id='exp_del_dt' style="width:120px;ime-mode:disabled" class="input1" caption="Expect Delivery Date"  dataformat="ymd"><!--  
                   --><button type="button" class="calendar ir" name="img_exp_del_dt" id="img_exp_del_dt"></button></td>
                  <td><button type="button" class="btn_etc" id='btn_dem_retrieve' name="btn_dem_retrieve" >Retrieve</button><!--
                  --><button type="button" class="btn_etc" id='btn_dmdt' name="btn_dmdt" >DMDT</button></td>
                  <td></td>
            </tr>
		</tbody>
	</table>
</div>
	
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('demInfo');</script>	
	</div>
	
	<div class="opus_design_grid clear" id="" style="display:none">
		<script type="text/javascript">ComSheetObject('demDtl');</script>	
	</div>
	
	<!-- opus_design_inquiry(S) -->

			<div class="layout_vertical_2 pad_rgt_12"  style="width:50.7%">
				<table class="grid_2">
				 	<tr>
            			<th style="text-align:center;"><strong>O/B Remark(s)</strong></td>
      				</tr>
				 	<tr>
              			<td><textarea style="width:100%; height:25px;resize:none" name="blInfo_obl_iss_rmk" id="blInfo_obl_iss_rmk" readonly class="noinput2"></textarea></td>
      				</tr>
				</table>
			</div>
			<div class="layout_vertical_2"  style="width:49.3%">
				<table>
		<tbody>
			<tr>
                <td class="pad_top_4 pad_btm_4"><button type="button" class="btn_etc" style="width:100%;" id="btn_hold_remark" name="btn_hold_remark">Hold / Internal  Remark(s)</button></td>
			         </tr>
					<tr>
			        	<td><textarea style="width:100%; height:25px;resize:none" name="blInfo_inter_rmk" id="blInfo_inter_rmk" onKeyDown="fncTextareaMaxLine(this.value)"></textarea></td>
			         </tr>
			    </table>
			</div>
	
	
	<!----------------------------------------------------------------------
	    Hidden IB Sheet Define
	----------------------------------------------------------------------->
	<!--Korea D/O Release basic information-->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('blInfo');</script>
	</div>
	<!--Korea D/O Release Reference information
	<script language="javascript">ComSheetObject('refInfo');</script>
	-->
	<!--B/L INFO in order to report Korea Customs
	<script language="javascript">ComSheetObject('cstmsInfo');</script>
	-->
	<!--
	<script language="javascript">ComSheetObject('blIss');</script>
	-->
	<!--
	<script language="javascript">ComSheetObject('otsRcvInfo');</script>
	-->
	<!--Total Billable Amount-->
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('totBlbAmt');</script>
	</div>
	<!--KT-NET
	<script language="javascript">ComSheetObject('ktNet');</script>
	-->
	<!--S/T Cancel
	<script language="javascript">ComSheetObject('stCancel');</script>
	-->
	<!--Partial container information retrieve-->
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('partial');</script>
	</div>
	<!--retrieve for OutStanding Amount Pop-up
	<script language="javascript">ComSheetObject('otsRcvPop');</script>
	-->
<%if(!mainPage.equals("true")){	%></div><%}%>	
</form>
