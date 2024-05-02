<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0326.jsp
*@FileTitle  : Japan Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0326Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0326Event event     = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //error from server
    String strErrMsg = "";                    //error message
    int rowCount     = 0;                     //count of DB resultSET list

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";

    String strUsr_id   = "";
    String strUsr_nm   = "";
    String strOfc_cd   = "";
    String strCnt_cd   = "";

    String code = "";
    String value = "";
    String mainPage	   = "";
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        strCnt_cd = account.getCnt_cd();

        event = (EsmBkg0326Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
        mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
     
    }catch(Exception e) {
        out.println(e.toString());
    }
%>


<script type="text/javascript">
    var lginOfcCd = "<%=strOfc_cd%>"; // login usr_ofc_cd
    var lginCntCd = "<%=strCnt_cd%>"; // login usr_cnt_cd
    var strUsr_id = "<%=strUsr_id%>"; // login usr_id
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

<div id="blLayer" class="blLayer" style="position:absolute;z-index: 999; background-color:#ffffff; visibility: hidden; overflow-y:auto; overflow-x:hidden; border-width:1px; border-style:solid;"></div>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!----------------------------------------------------------------------
    Hidden Value Define
----------------------------------------------------------------------->
<input type="hidden" name ="dirty_flag" id ="dirty_flag">
<input type="hidden" name ="h_cntr_no" id ="h_cntr_no">
<input type='hidden' name ="xmlData" id ="xmlData">
<input type='hidden' name ='evnt_flag' id ='evnt_flag'>
<input type='hidden' name ='h_ori_obl_rdem_flg' id ='h_ori_obl_rdem_flg'>
<input type='hidden' name ='h_aft_obl_rdem_flg' id ='h_aft_obl_rdem_flg'>
<input type='hidden' name ='pre_ctnt' id ='pre_ctnt'>
<input type='hidden' name ='crnt_ctnt' id ='crnt_ctnt'>
<input type='hidden' name ='invTotBilAmt' id ='invTotBilAmt'>
<input type='hidden' name ='jpDoSndStsCd' id ='jpDoSndStsCd'>
<input type='hidden' name ='do_cng_evnt_cd' id ='do_cng_evnt_cd'>
<input type='hidden' name ='tpb_status' id ='tpb_status'>
<input type='hidden' name ='rlse_sts_cd' id ='rlse_sts_cd'>
<input type='hidden' name ='last_rlse_sts_cd' id ='last_rlse_sts_cd'>
<input type='hidden' name ='do_no' id ='do_no'>
<input type='hidden' name ='do_no_split' id ='do_no_split'>
<input type='hidden' name ='svc_cd' id ='svc_cd'>
<input type='hidden' name ='obl_cng_flg' id ='obl_cng_flg'>
<input type='hidden' name ='old_obl_rdem_knt' id ='old_obl_rdem_knt'>
<input type='hidden' name ='new_obl_rdem_knt' id ='new_obl_rdem_knt'>
<input type='hidden' name ="oaXmlData" id ="oaXmlData">

<!-- Remark for Release  -->
<input type='hidden' name ='releaseRemark'>

<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">

<input type='hidden' name ='mrd_id' id ='mrd_id'>
<input type='hidden' name ='mrd_param' id ='mrd_param'>

<input type='hidden' name ="demDtlXmlData" id ="demDtlXmlData">
<input type='hidden' name ='h_hold_remark' id ='h_hold_remark' value = "">

<% if (!mainPage.equals("true")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Japan Cargo Release ( ESM_BKG_0326 )</span></h2>
<%}else{%>
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<%}%>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_assign" id="btn_assign">Assign / Issue</button><!--
        --><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">D/O Cancel</button><!--
        --><button type="button" class="btn_normal" name="btn_if" id="btn_if">DOR I/F</button><!--
        --><button type="button" class="btn_normal" name="btn_dorcancel" id="btn_dorcancel">DOR Cancel</button><!--
        --><button type="button" class="btn_normal" name="btn_receiverinfo" id="btn_receiverinfo">Receiver Info.</button> 
    </div>
    <!-- opus_design_btn(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_remark" id="btn_remark">External Remark(s)</button><!--
        --><span id="hld"  style="display:"><button type="button" class="btn_normal" name="btn_hold" id="btn_hold">Hold</button></span><!--
        --><span id="uhld" style="display:none"><button type="button" class="btn_normal" name="btn_hold" id="btn_hold">Hold Removal</button></span><!--
        --><button type="button" class="btn_normal" name="btn_history" id="btn_history">History</button><!--
        --><button type="button" class="btn_normal" name="btn_form_setup" id="btn_form_setup">Form Setup</button><!--
        --><button type="button" class="btn_normal" name="btn_doprint" id="btn_doprint">D/O Preview</button><!--
        --><button type="button" class="btn_normal" name="btn_print" id="btn_print">D/O Print</button><!--
        --><button type="button" class="btn_normal" name="btn_recprint" id="btn_recprint">Receipt Preview</button><!-- 
         --><%if(!"true".equals(mainPage)){ %><!-- 
				 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!-- 
			 --><%} %>
    </div>
    <!-- opus_design_btn(E) -->
<% if (!mainPage.equals("true")) { %>	
		</div>
	</div>
<%}else{%>
    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<% } %>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="55"  />
                <col width="160" />
                <col width="60"  />
                <col width="200" />
                <col width="95"  />
                <col width="120" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>B/L No.</th>
                    <td><input name="bl_no" id="bl_no" caption="B/L No." type="text" style="width:125px;ime-mode:disabled; background-image : url('style/images/theme_default/select.png'); background-position:center right; background-repeat:no-repeat;" dataformat="engup" class="input" maxlength="13" value="<%=JSPUtil.getNull(request.getParameter("bl_no"))%>"></td>
                    <th>BKG No.</th>
                    <td>
                        <input name="bkg_no" id="bkg_no" caption="BKG No." style="width:120px;" class="input" maxlength="13" style="ime-mode:disabled" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>"><!--
                     --><input name='blInfo_split_flg' id='blInfo_split_flg' style="width:40px;color:red; font-weight:bold;text-align: center" readonly class="input2">
                    </td>
                    <th>Container No.</th>
                    <td class="pad_top_4 pad_btm_4">
                        <input name="cntr_no" id="cntr_no" caption="Container No." fullfill style="width:120px;" class="input" maxlength="11" style="ime-mode:disabled">
                    </td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->   
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="34"  />
                <col width="62"  />
                <col width="27"  />
                <col width="70"  />
                <col width="27"  />
                <col width="105" />
                <col width="27"  />
                <col width="130" />
                <col width="65"  />
                <col width="110" />
                <col width="100" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th title="Place of Receipt">POR</th>
                    <td><input style="width: 50px; text-align: center" class="input2" readonly name="blInfo_por_cd" id="blInfo_por_cd"></td>
                    <th title="Port of Loading">POL</th>
                    <td><input style="width: 50px; text-align: center" class="input2" readonly name="blInfo_pol_cd" id="blInfo_pol_cd"></td>
                    <th title="Port of Discharging">POD</th>
                    <td><input style="width: 50px; text-align: center" class="input2" readonly name="blInfo_pod_cd" id="blInfo_pod_cd"></td>
                    <th title="Place of Delivery">DEL</th>
                    <td><input style="width: 50px; text-align: center" class="input2" readonly name="blInfo_del_cd" id="blInfo_del_cd"></td>
                    <th> DEL Term</th>
                    <td><input style="width: 79px; text-align: left" class="input2" readonly name="blInfo_de_term_desc" id="blInfo_de_term_desc"></td>
                    <th>Arrival Vessel</th>
                    <td><input style="width: 222px; text-align: center" class="input2" readonly name="blInfo_arrival_vessel" id="blInfo_arrival_vessel"></td>
                </tr>
                <tr>
                    <th>ETA</th>
                    <td colspan="3"><input style="width: 139px; text-align: center" class="input2" readonly name="blInfo_vps_eta_dt" id="blInfo_vps_eta_dt"></td>
                    <th>PKG</th>
                    <td>
                        <input style="width: 50px; text-align: right" class="input2" readonly name="blInfo_pck_qty" id="blInfo_pck_qty"><!--
                        --><input style="width: 30px; text-align: center" class="input2" readonly name="blInfo_pck_tp_cd" id="blInfo_pck_tp_cd">
                    </td>
                    <th>WGT</th>
                    <td>
                        <input style="width: 70px; text-align: right" class="input2" readonly name="blInfo_act_wgt" id="blInfo_act_wgt"><!--
                        --><input style="width: 30px; text-align: center" class="input2" readonly name="blInfo_wgt_ut_cd" id="blInfo_wgt_ut_cd">
                    </td>
                    <th>MEA</th>
                    <td>
                        <input style="width: 45px; text-align: right" class="input2" readonly name="blInfo_meas_qty" id="blInfo_meas_qty"><!--
                        --><input style="width: 30px; text-align: center" class="input2" readonly name="blInfo_meas_ut_cd" id="blInfo_meas_ut_cd">
                    </td>
                    <th>Discharging CY</th>
                    <td><input style="width:222px;" class="input2" readonly name="blInfo_dsch_loc" id="blInfo_dsch_loc"></td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->
    </div>
    <!-- opus_design_inquiry(E) -->
<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="30"  />
                <col width="58"  />
                <col width="30"  />
                <col width="108" />
                <col width="40"  />
                <col width="32"  />
                <col width="70"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th colspan="3">CY Operator Code</th>
                    <td><input name="cstmsInfo_cy_op_cd" id="cstmsInfo_cy_op_cd" caption="CY Operator Code" maxlength="5"style="width:87px;" class="input1" required="true" style="ime-mode:disabled"></td>
                    <th>Partial</th>
                    <td><input style="width:30px;text-align: center" class="input2" readonly name="blInfo_cntr_prt_flg" id="blInfo_cntr_prt_flg"></td>
                    <th>Consignee</th>
                    <td>
                        <input name="blInfo_ccust_nm" id="blInfo_ccust_nm" style="width:150px;text-align:left;" class="input2" readonly /><!--
                        --><input name="blInfo_ccust_addr" id="blInfo_ccust_addr" style="width:455px;text-align:left;" class="input2" readonly />
                    </td>
                </tr>
                <tr>
                    <th>ICG</th>
                    <td>
                        <select style="width:50px;text-align:center;" name='cstmsInfo_info_cgo_flg' id='cstmsInfo_info_cgo_flg'>
                            <option value="N">N</option>
                            <option value="Y">Y</option>
                        </select>
                    </td>
                    <th>CNTR</th>
                    <td><input style="width:87px;" name="cstmsInfo_full_mty_cd" id="cstmsInfo_full_mty_cd" class="input2" readonly /></td>
                    <th>SOC</th>
                    <td><input style="width: 30px; text-align: center" class="input2" readonly name="blInfo_soc_flg" id="blInfo_soc_flg"></td>
                    <th>Notify</th>
                    <td>
                        <input name="blInfo_ncust_nm" id="blInfo_ncust_nm" style="width:150px;text-align:left;" class="input2" readonly /><!--
                        --><input name="blInfo_ncust_addr" id="blInfo_ncust_addr" style="width:455px;text-align:left;" class="input2" readonly />
                    </td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->
    </div>
    <!-- opus_design_inquiry(E) -->

    <table class="line_bluedot"><tr><td></td></tr></table>

    
    <!-- opus_design_inquiry(S) -->           
    <div class="opus_design_inquiry" >
        <table>
			<colgroup>
                <col width="50"/>
                <col width="220"/>
                <col width="70"/>
                <col width="50"/> 
                <col width="*"/>
            </colgroup>            
            <tbody>
                <tr>
                    <th>D/O ID</th>
                    <td><input style="width:100px;ime-mode:disabled" name="japDoInfo_jp_do_id" id="japDoInfo_jp_do_id" class="input" maxlength="10" dataformat="engup"><!--
                     --><button type="button" class="btn_etc" name="btn_do_id_save" id="btn_do_id_save">D/O ID SAVE</button>
                    </td>
                    <th>DOR Stowage</th>
                    <td><input class="mar_rgt_none" style="width:35px;color:red;font-weight:bold;" name="dorStowage" id="dorStowage" class="input2" readonly></td>
                    <td>&nbsp; </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
    
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <script type="text/javascript">ComSheetObject('doRlseSts');</script>
    </div>
    <!-- opus_design_grid(E) -->
    
    <table class="line_bluedot"><tr><td></td></tr></table>
    
    <!-- layout_wrap(S) -->
    <div class="layout_wrap wFit">
        <!-- layout_flex_fixed(S) -->
        <div class="layout_flex_fixed pad_rgt_12" style="width:620px">
            <!-- opus_design_inquiry(S)  -->
            <div class="opus_design_inquiry">
                <table>
                    <colgroup>
                        <col width="130" />
                        <col width="35" />
                        <col width="35" />
                        <col width="35" />
                        <col width="180" />
                        <col width="" />
                        <col width="35" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th class="align_left"><h3 class="title_design">Bill of Lading Status</h3></th>
                            <td><input name="blIss_obl_rdem_flg" id="blIss_obl_rdem_flg" style="width:35px;" class="input2" readonly /></td>
                            <th>No</th>
                            <td><input name="blIss_obl_cpy_knt" id="blIss_obl_cpy_knt" style="width:35px;color:black;text-align:center; font-weight:bold;" class="input2" readonly /></td>
                            <td><button type="button" class="btn_etc" name="btn_obl_cancel" id="btn_obl_cancel">RCV Cancel</button></td>
                            <th class="align_left"><h3 class="title_design">TPB</h3></th>
                            <td class="align_center"><img src="img/btng_icon_g.gif" width="13" height="13" border="0" align="absmiddle" id="tpb_icon"></td>
                            <td>
                                <input style="width:35px;text-align:center;" name='tpb_cd' id='tpb_cd' class="input2" readonly /><!--
                                --><button type="button" class="input_seach_btn" name="btn_tpb" id="btn_tpb"></button>
                            </td>
                            <td class="pad_rgt_none">
                                <input name='hold_flag' id='hold_flag' class="mar_rgt_none" style="width:50px; text-align:center;" class="input2_1" readonly /><!--
                                --><input class="mar_rgt_none" type="hidden" name='refInfo_do_hld_flg' id='refInfo_do_hld_flg' />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- opus_design_inquiry(E)  -->
            <!-- opus_design_inquiry(S)  -->
            <div class="opus_design_inquiry" style="height:128px">
                <table>
                    <colgroup>
                        <col />
                        <col width="40" />
                        <col width="40" />
                        <col />
                        <col width="30" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>B/L Issue</th>
                            <td><input name="blIss_bl_tp_cd" id="blIss_bl_tp_cd" style="width:55px" class="align_center input2" readonly /></td>
                            <th>OFC</th>
                            <td>
                                <input name="blIss_obl_iss_ofc_cd" id="blIss_obl_iss_ofc_cd" style="width:60px;" class="input2" readonly /><!-- 
                             --><input name="blIss_obl_iss_usr_id" id="blIss_obl_iss_usr_id" style="width:70px;" class="input2" readonly />
                            </td>
                            <th>DT</th>
                            <td>
                                <input name="blIss_obl_iss_dt" id="blIss_obl_iss_dt" style="width:110px;" class="input2" readonly /><!-- 
                             --><input style="width:10px" value="" class="noinput2" readonly />
                            </td>
                        </tr>
                        <tr>
                            <th>B/L Receive</th>
                            <td><input name="blIss_obl_rdem_knt" id="blIss_obl_rdem_knt" style="width:55px" class="align_center" dataformat="num" style="ime-mode: disabled" maxlength='3' /></td>
                            <th>OFC</th>
                            <td>
                                <input name="blIss_obl_rdem_ofc_cd" id="blIss_obl_rdem_ofc_cd" style="width:60px;" class="input2" readonly /><!-- 
                             --><input name="blIss_obl_rdem_usr_id" id="blIss_obl_rdem_usr_id" style="width:70px;" class="input2" readonly />
                            </td>
                            <th>DT</th>
                            <td>
                                <input name="blIss_obl_rdem_dt" id="blIss_obl_rdem_dt" style="width:110px;text-align:center;" class="input2" readonly /><!-- 
                             --><input name="bl_surr_rmk_flg" id="bl_surr_rmk_flg" style="width:72px;text-align:center;" value="" class="noinput2" readonly /><!-- 
                             --><button type="button" class="input_seach_btn" id="div_btn_bl_surr_flg" name="btn_bl_surr_rmk"></button>
                            </td>
                        </tr>
                        <tr>
                            <th>Other DOC RCV</th>
                            <td>
                                <select name="blIss_bl_otr_doc_rcv_cd" id="blIss_bl_otr_doc_rcv_cd" style="width:55px">
                                </select>
                            </td>
                            <th>OFC</th>
                            <td>
                                <input name="blIss_otr_doc_rcv_ofc_cd" id="blIss_otr_doc_rcv_ofc_cd" style="width:60px;" class="input2" readonly /><!-- 
                             --><input name="blIss_otr_doc_rcv_usr_id" id="blIss_otr_doc_rcv_usr_id" style="width:70px;" class="input2" readonly />
                            </td>
                            <th>DT</th>
                            <td>
                                <input name="blIss_otr_doc_rcv_dt" id="blIss_otr_doc_rcv_dt" style="width:110px;" class="input2" readonly /><!-- 
                             --><select name="blIss_otr_doc_cgor_flg" id="blIss_otr_doc_cgor_flg" style="width:101px">
                                    <option></option>
                                    <option value="N">Non-Accept</option>
                                    <option value="Y">Accept</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Inbond DOC RCV</th>
                            <td><select name="blIss_ibd_doc_rcv_flg" id="blIss_ibd_doc_rcv_flg" style="width:55px;text-align:center;">
                                    <option value="N">N</option>
                                    <option value="Y">Y</option>
                                </select></td>
                            <th>OFC</th>
                            <td>
                                <input type="text" name="blIss_ibd_doc_rcv_ofc_cd" id="blIss_ibd_doc_rcv_ofc_cd" style="width:60px;text-align:center;" value="" class="input2" readOnly><!--
                                --><input type="text" name="blIss_ibd_doc_rcv_usr_id" id="blIss_ibd_doc_rcv_usr_id" style="width:70px;text-align:center;" value="" class="input2" readOnly>
                            </td>
                            <th>DT</th>
                            <td>
                                <input type="text" name="blIss_ibd_doc_rcv_dt" id="blIss_ibd_doc_rcv_dt" style="width:110px;text-align:center;" value="" class="input2" readOnly><!--
                                --><input type="text" name="" style="width:110px;text-align:center;" value="" class="noinput2" readOnly>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- opus_design_inquiry(E) -->
        </div>
        <!-- layout_flex_fixed(E) -->

        <!-- layout_flex_flex(S) -->
        <div class="layout_flex_flex" style="padding-left:660px">
            
            <!-- opus_design_inquiry(S) -->
            <div class="opus_design_inquiry">
                <table>
                    <colgroup>
                        <col width="158"  />
                        <col width="" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th class="align_left pad_left_8"><h3 class="title_design">Freight Received Status</h3></th>
                            <td>
                                <input style="width:35px;text-align:center;" class="input2_1" name='otsRcvInfo_tot_ots_sts_cd' id='otsRcvInfo_tot_ots_sts_cd' readonly /><!--
                             --><select style="width:150px;font-weight:bold;" class="input2" name='tot_ots_amt' id='tot_ots_amt'></select>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- opus_design_inquiry(E) -->
            <!-- opus_design_inquiry(S) -->
            <div class="opus_design_inquiry">
                <table>
                    <colgroup>
                        <col />
                        <col width="30" />
                        <col />
                        <col width="170" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>PPD1</th>
                            <td style="width:75px"><input name="otsRcvInfo_ppt_sts_cd" id="otsRcvInfo_ppt_sts_cd" style="width:40px;text-align:center;" class="input2" readonly /></td>
                            <th>OFC</th>
                            <td>
                                <input name="otsRcvInfo_ppt_rcv_ofc_cd" id="otsRcvInfo_ppt_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readonly /><!-- 
                             --><input name="otsRcvInfo_ppt_rcv_usr_id" id="otsRcvInfo_ppt_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readonly />
                            </td>
                            <th>DT</th>
                            <td><input name="otsRcvInfo_ppt_rcv_dt" id="otsRcvInfo_ppt_rcv_dt" style="text-align:center;" class="input2" readonly /></td>
                        </tr>
                        <tr>
                            <th>CCT1</th>
                            <td>
                              <input name="otsRcvInfo_cct_sts_cd" id="otsRcvInfo_cct_sts_cd" style="width:40px;text-align:center;color:red;" class="input2" readonly /><!-- 
                           --><button type="button" id="div_btn_cct" name="btn_cct" class="input_seach_btn" ></button>
                            </td>
                            <th>OFC</th>
                            <td>
                                <input name="otsRcvInfo_cct_rcv_ofc_cd" id="otsRcvInfo_cct_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readonly /><!-- 
                             --><input name="otsRcvInfo_cct_rcv_usr_id" id="otsRcvInfo_cct_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readonly />
                            </td>
                            <th>DT</th>
                            <td><input name="otsRcvInfo_cct_rcv_dt" id="otsRcvInfo_cct_rcv_dt" style="text-align:center;" class="input2" readonly /></td>
                        </tr>
                        <tr>
                            <th>PPD2</th>
                            <td><input name="otsRcvInfo_n3pty_ppt_sts_cd" id="otsRcvInfo_n3pty_ppt_sts_cd" style="width:40px;text-align:center;" class="input2" readonly /></td>
                            <th>OFC</th>
                            <td>
                                <input name="otsRcvInfo_n3pty_ppt_rcv_ofc_cd" id="otsRcvInfo_n3pty_ppt_rcv_ofc_cd" style="width:60px;text" class="input2" readonly /><!-- 
                             --><input name="otsRcvInfo_n3pty_ppt_rcv_usr_id" id="otsRcvInfo_n3pty_ppt_rcv_usr_id" style="width:70px;" class="input2" readonly />
                            </td>
                            <th>DT</th>
                            <td><input name="otsRcvInfo_n3pty_ppt_rcv_dt" id="otsRcvInfo_n3pty_ppt_rcv_dt" style="text-align:center;" class="input2" readonly /></td>
                        </tr>
                        <tr>
                            <th>CCT2</th>
                            <td>
                               <input name="otsRcvInfo_n3pty_cct_sts_cd" id="otsRcvInfo_n3pty_cct_sts_cd" style="width:40px;text-align:center;color:red;" class="input2" readonly /><!-- 
                            --><button type="button" class="input_seach_btn" id="div_btn_third_cct" name="btn_third_cct" ></button>
                            </td>
                            <th>OFC</th>
                            <td>
                                <input name="otsRcvInfo_n3pty_cct_rcv_ofc_cd" id="otsRcvInfo_n3pty_cct_rcv_ofc_cd" style="width:60px" class="input2" readonly /><!-- 
                             --><input name="otsRcvInfo_n3pty_cct_rcv_usr_id" id="otsRcvInfo_n3pty_cct_rcv_usr_id" style="width:70px" class="input2" readonly /></td>
                            <th>DT</th>
                            <td><input name="otsRcvInfo_n3pty_cct_rcv_dt" id="otsRcvInfo_n3pty_cct_rcv_dt" style="text-align:center;" class="input2" readonly /></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- opus_design_inquiry(E) -->
        </div>
        <!-- layout_flex_flex(E) -->
    </div>
    <!-- layout_wrap(E) -->

    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        
        <table>
        
			<colgroup>
                <col width="220">
                <col width="180">
                <col width="120">
                <col width="60">
                <col width="100">
                <col width="*">
            </colgroup>        
            <tbody>
                <td><h3 class="title_design floatL">Demurrage Status/Outstanding</h3></td>
                <td><input type="text" name='demur_sts' id='demur_sts' style="width:35px; font-weight:bold;" class="input2" readOnly><!-- 
                 --><select style="width:160px;font-weight:bold;" class="input2" name='tot_bil_amt' id='tot_bil_amt'></select></td>
                <th>Demurrage Type</th>
                <td><input type="text" name='demur_type' id='demur_type' style="width:35px;" class="input2" readonly></td>
                <th>Expect Delivery Date</th>
                <td class="pad_rgt_none">
                    <input type="text" name='exp_del_dt' id='exp_del_dt' style="width:75px;ime-mode:disabled" class="input1" caption="Expect Delivery Date" dataformat="ymd"/><!-- 
                 --><button name="img_exp_del_dt" id="img_exp_del_dt" type="button" class="calendar" style="margin-right:10px"></button><!-- 
                 --><button name="btn_dem_retrieve" id="btn_dem_retrieve" type="button" class="btn_etc">Retrieve &nbsp; </button><!-- 
                 --><button name="btn_dmdt" id='btn_dmdt' type="button" class="btn_etc mar_rgt_none">DMDT &nbsp; </button></td>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
	<div class="opus_design_grid">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" >
            <script type="text/javascript">ComSheetObject('demInfo');</script>
        </div>
        <!-- opus_design_grid(E) -->

        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" style="display:none">
            <script type="text/javascript">ComSheetObject('demDtl');</script>
        </div>
        <!-- opus_design_grid(E) -->
	</div>

    
    <!-- layout_wrap(S) -->
        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2 pad_rgt_8" style="width:50.7%">
            <!-- grid2(S) -->
            <table class="grid2 mar_none">
                <thead>
                    <tr>
                        <th>O/B Remark(s)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="noinput2">
                            <textarea style="width: 100%; height:18px;" name='blInfo_obl_iss_rmk' id='blInfo_obl_iss_rmk' readonly class="noinput2"></textarea>
                        </td>
                    </tr>
                </tbody>
            </table>
            <!-- grid2(E) -->
        </div>
        <!-- layout_vertical_2(E) -->
        
        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2" style="width:49.3%">
            <button type="button" class="btn_etc w100 mar_btm_4" name="btn_hold_remark" id="hold_remark">Hold / Internal  Remark(s)</button><!-- 
         --><textarea style="width:100%; height:20px;" name='refInfo_inter_rmk' id='refInfo_inter_rmk' onKeyDown="fncTextareaMaxLine(this.value)"></textarea>
        </div>
        <!-- layout_vertical_2(E) -->
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        
    <!-- layout_wrap(E) -->    
<!----------------------------------------------------------------------
    Hidden IB Sheet Define
----------------------------------------------------------------------->
<script type="text/javascript">ComSheetObject('blInfo');</script>
<script type="text/javascript">ComSheetObject('refInfo');</script>
<script type="text/javascript">ComSheetObject('cstmsInfo');</script>
<script type="text/javascript">ComSheetObject('blIss');</script>
<script type="text/javascript">ComSheetObject('otsRcvInfo');</script>
<script type="text/javascript">ComSheetObject('totBlbAmt');</script>
<script type="text/javascript">ComSheetObject('japDoInfo');</script>
<script type="text/javascript">ComSheetObject('partial');</script>
<script type="text/javascript">ComSheetObject('otsRcvPop');</script>
</div>
<!-- wrap_result(E) -->

</form>
 