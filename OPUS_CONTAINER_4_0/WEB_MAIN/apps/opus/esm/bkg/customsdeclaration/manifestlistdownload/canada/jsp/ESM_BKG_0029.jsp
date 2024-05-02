<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0029.jsp
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
        EsmBkg0029Event  event = null;                       //PDTO(Data Transfer Object including Parameters)
        Exception serverException   = null;                  //error from server
        String strErrMsg = "";                                       //error message
        int rowCount   = 0;                                         //count of DB resultSET list

        String successFlag = "";
        String codeList  = "";
        String pageRows  = "100";

        String strUsr_id              = "";
        String strUsr_nm              = "";
        boolean isCA_Usr              = false;
        String strCnt_cd              = "";
        Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
        
        String main_page = "";
        try {
               main_page = JSPUtil.getNull(request.getParameter("mainPage"));
                SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
               strUsr_id =    account.getUsr_id();
               strUsr_nm = account.getUsr_nm();
               if ("ESM_BKG_0029_2".equals(request.getParameter("pgmNo")))
               {
                       isCA_Usr = true;
                       strCnt_cd = "CA";
               }
               event = (EsmBkg0029Event)request.getAttribute("Event");
               serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

               if (serverException != null) {
                       strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
               }

               // If you imported data from the server initialization when loading
               GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        }catch(Exception e) {
               out.println(e.toString());
        }
        
%>

<script type="text/javascript">
        function setupPage(){
               var errMessage = "<%=strErrMsg%>";
               if (errMessage.length >= 1) {
                       showErrMessage(errMessage);
               } // end if
               loadPage('<%=isCA_Usr%>', '<%=strUsr_id%>');
        }
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="B/L Inquiry">
<input type="hidden" name="com_mrdBodyTitle" value="B/L Inquiry">
<input type="hidden" name="com_mrdDisableToolbar">
<%
        String sBlNo = request.getParameter("bl_no");
        if (sBlNo == null) sBlNo = "";
        String vvd = request.getParameter("vvd");
        if (vvd == null) vvd = "";
        String pod = request.getParameter("pod");
        if (pod == null) pod = "";
        String eta = request.getParameter("eta");
        if (eta == null) eta = "";
        String type = request.getParameter("type");
        if (type == null) type = "";
%>
<input type="hidden" name="tab_no" value="1" id="tab_no" />
<input type="hidden" name="type" value="<%=StringUtil.xssFilter(type)%>" id="type" />
<input type="hidden" name="cust_tp" id="cust_tp" />
<input type="hidden" name="cust_seq" caption="Country Seq." id="cust_seq" />
<input type="hidden" name="cust_cnt_cd" caption="Country Code" id="cust_cnt_cd" />

<!-- %@include file="/apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>  -->

<%if (!"true".equals(main_page)) {%>
        <div class="layer_popup_title">
               <div class="page_title_area clear">
                       <h2 class="page_title"><span id="titles">Manifest Details by B/L</span></h2>
                       <div class="opus_design_btn">  
                              <button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
                              --><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
                              --><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
                              --><button class="btn_normal" name="btn_Reactivate" id="btn_Reactivate" type="button">Reactivate</button><!--
                              --><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
                              --><button class="btn_normal" name="btn_Container" id="btn_Container" type="button">Container</button><!--
                              --><button class="btn_normal" name="btn_CM" id="btn_CM" type="button">C/M</button><!--
                              --><button class="btn_normal" name="btn_ViewMsg" id="btn_ViewMsg" type="button">View MSG</button><!--
                              --><button class="btn_normal" name="btn_Transmit" id="btn_Transmit" type="button">Transmit</button><!--
                              --><button class="btn_normal" name="btn_Terminal" id="btn_Terminal" type="button">Terminal EDI</button><!-- 
                               --><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
                       </div>
               </div>
        </div>
<%} else {%>
        <div class="page_title_area clear">
               <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
               <div class="opus_design_btn">  
                       <button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
                       --><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
                       --><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
                       --><button class="btn_normal" name="btn_Reactivate" id="btn_Reactivate" type="button">Reactivate</button><!--
                       --><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
                       --><button class="btn_normal" name="btn_Container" id="btn_Container" type="button">Container</button><!--
                       --><button class="btn_normal" name="btn_CM" id="btn_CM" type="button">C/M</button><!--
                       --><button class="btn_normal" name="btn_ViewMsg" id="btn_ViewMsg" type="button">View MSG</button><!--
                       --><button class="btn_normal" name="btn_Transmit" id="btn_Transmit" type="button">Transmit</button><!--
                       --><button class="btn_normal" name="btn_Terminal" id="btn_Terminal" type="button">Terminal EDI</button>
               </div>
               
               <div class="location">
                       <span id="navigation"></span>
               </div>
        </div>
        
<%}%>


<%--
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->
        
        <!-- opus_design_btn (S) -->
        <div class="opus_design_btn">
               <button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
               --><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
               --><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
               --><button class="btn_normal" name="btn_Reactivate" id="btn_Reactivate" type="button">Reactivate</button><!--
               --><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
               --><button class="btn_normal" name="btn_Container" id="btn_Container" type="button">Container</button><!--
               --><button class="btn_normal" name="btn_CM" id="btn_CM" type="button">C/M</button><!--
               --><button class="btn_normal" name="btn_ViewMsg" id="btn_ViewMsg" type="button">View MSG</button><!--
               --><button class="btn_normal" name="btn_Transmit" id="btn_Transmit" type="button">Transmit</button><!--
               --><button class="btn_normal" name="btn_Terminal" id="btn_Terminal" type="button">Terminal EDI</button><!-- 
                --><%if(!"true".equals(main_page)){ %><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><%} %>
        </div> 
        <!-- opus_design_btn (E) -->
        <!-- page_location(S) -->
        <div class="location">
               <!-- location 내용 동적생성 (별도 코딩 불필요) -->
               <span id="navigation"></span>
        </div>
        <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
 --%>

<%if(!main_page.equals("true")){%><div class="layer_popup_contents" style="margin-bottom:-100px;"><%}%>
 
 
<div class="wrap_search_tab clear">
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry wFit">
               <table>
                       <tbody>
                              <colgroup>
                                      <col width="65">
                                      <col width="132">
                                      <col width="40">
                                      <col width="30">
                                      <col width="90">
                                      <col width="40">
                                      <col width="170">
                                      <col width="80">
                                      <col width="40">
                                      <col width="160">
                                      <col width="15">
                                      <col width="40">
                                      <col width="15">
                                      <col width="*">
                              </colgroup>
                              <tr>
                                      <th>B/L No.</th>
                                      <td valign="middle"><input type="text" style="width:100px;ime-mode:disabled" class="input" name="bl_no" id="bl_no" maxlength="12" dataformat="engup"  value="<%=StringUtil.xssFilter(sBlNo)%>">
                                      <th>Filer</th>
                                      <td><input type="text" style="width:20px;" class="input2" ReadOnly name="frm_cstms_file_tp_cd" id="frm_cstms_file_tp_cd">
                                      </td>
                                      <td align="center"><span id="frm_mf_sts_cd"></span></td>
                                      <th align="right">Type</th>
                                     <td><script type="text/javascript">ComComboObject('frm_trsp_tp_id', 2, 130, 1, 0, 1);</script></td>
                    <th>Empty&nbsp;<input type="checkbox" value="1" class="trans" name="frm_full_mty_cd" id="frm_full_mty_cd"></th>    
                                      <th>Stage</th>
                                      <td><input type="text" style="width:35px;" class="input2" ReadOnly name="frm_cstms_mf_tp_cd" id="frm_cstms_mf_tp_cd"><!-- 
                                       --><script type="text/javascript">ComComboObject('frm_cstms_trsm_sts_cd', 1, 70, 1, 0, 0);</script>
                                      </td>
                    <th>F:</th>
                    <td><input type="text" style="width:20px;" class="input2" ReadOnly name="frm_frt_clt_flg" id="frm_frt_clt_flg"></td>
                    <th>O:</th>
                    <td><input type="text" style="width:20px;" class="input2" ReadOnly name="frm_obl_rdem_flg" id="frm_obl_rdem_flg"></td>
                              </tr>
                       </tbody>
               </table>
               <table>
                       <tbody>
                              <colgroup>
                                      <col width="65">
                                      <col width="130">
                                      <col width="40">
                                      <col width="30">
                                      <col width="130">
                                      <col width="*">
                              </colgroup>
                              <tr>
                                      <th>M.B/L No.</th>
                                      <td><input type="text" style="width:100px;" class="input2" ReadOnly name="frm_m_bl_no" id="frm_m_bl_no"></td>
                                      <th>T.BDR</th>
                                      <td>    
                                             <input type="text" style="width:20px;" class="input2" ReadOnly name="frm_t_bdr_flg" id="frm_t_bdr_flg">
                                      </td>
                                      <th align="right">CGO Control No.</th>
                                      <td><input type="text" style="width:130px;" class="input2" ReadOnly name="frm_ccn_no" id="frm_ccn_no"></td>
                              </tr>
                       </tbody>
               </table>
        </div>
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
        <div class="opus_design_inquiry wFit">
               <table>
                       <tbody>
                              <colgroup>
                                      <col width="30">
                                      <col width="120">
                                      <col width="30">
                                      <col width="90">
                                      <col width="30">
                                      <col width="90">
                                      <col width="30">
                                      <col width="90">
                                      <col width="30">
                                      <col width="180">
                                      <col width="30">
                                      <col width="*">
                              </colgroup>
                              <tr>
                                      <th title="Vessel Voyage Direction">VVD</th>
                                      <td><input type="text" style="width:90px;" class="input2" ReadOnly name="frm_vvd_cd" id="frm_vvd_cd" value="<%=StringUtil.xssFilter(vvd)%>"></td>
                                      <th title="Place of Receipt">POR</th>
                                      <td><input type="text" style="width:60px;ime-mode:disabled" class="input2" ReadOnly name="frm_por_cd" id="frm_por_cd" maxlength="5" dataformat="engup" minlength="5" caption="POR" ></td>
                                      <th title="Port of Loading">POL</th>
                                      <td><input type="text" style="width:60px;" class="input2" ReadOnly name="frm_pol_cd" id="frm_pol_cd" maxlength="5" dataformat="engup" minlength="5" caption="POL" ></td>
                                      <th title="Port of Discharging">POD</th>
                                      <td><input type="text" style="width:60px;" class="input2" ReadOnly name="frm_pod_cd" id="frm_pod_cd" value="<%=StringUtil.xssFilter(pod)%>" ></td>
                                      <th>ETA</th>
                                      <td><input type="text" style="width:130px;" class="input2" ReadOnly name="frm_vps_eta_dt" id="frm_vps_eta_dt" value="<%=StringUtil.xssFilter(eta)%>" ></td>
                                      <th title="Place of Delivery">DEL</th>
                                      <td><input type="text" style="width:78px;" class="input" name="frm_del_cd" id="frm_del_cd" maxlength="5" dataformat=engup minlength="5" caption="DEL"></td>
                              </tr>
                       </tbody>
               </table>
               <table>
                       <tbody>
                              <colgroup>
                                      <col width="30">
                                      <col width="118">
                                      <col width="30">
                                      <col width="120">
                                      <col width="90">
                                      <col width="30">
                                      <col width="90">
                                      <col width="120">
                                      <col width="*">
                              </colgroup>
                              <tr>
                                      <th>Q'ty</th>
                                      <td><input type="text" style="width:50px;text-align:right" class="input" name="frm_pck_qty" id="frm_pck_qty" maxlength="12" dataformat="num" caption="Q'ty"><!-- 
                                       --><input type="text" style="width:36px;" class="input" name="frm_ams_pck_tp_cd" id="frm_ams_pck_tp_cd" maxlength="5" dataformat="enguponly" caption="Q'ty Unit"></td>
                                      <th>WGT</th>
                                      <td>
                                             <input type="text" style="width:105px;text-align:right;" class="input" name="frm_cgo_wgt" id="frm_cgo_wgt" maxlength="22" dataformat="num" caption="WGT"></td>
                                      <td>
                                            <script type="text/javascript">ComComboObject('frm_wgt_ut_cd', 1, 60, 1, 3);</script>
                                      </td>
                                      <th>HUB</th>
                                      <td><input type="text" style="width:60px;" class="input" name="frm_hub_loc_cd" id="frm_hub_loc_cd" maxlength="5" dataformat="engup" minlength="5" caption="HUB"></td>
                                      <th>Location of Goods</th>
                                      <td><input type="text" style="width:200px;" class="input" name="frm_ibd_loc_gds_desc" id="frm_ibd_loc_gds_desc" maxlength="100" dataformat="engupetc" caption="Location of Goods"></td>
                              </tr>
                       </tbody>
               </table>
               <table><tr><td height="10"></td></tr></table>
        </div>
        <!-- opus_design_inquiry(E) -->
</div>

        
<div class="wrap_result">
        <!-- opus_tab_btn(S) -->
        <div class="opus_design_tab">
               <script type="text/javascript">ComTabObject('tab1')</script>
        </div>
        <!-- opus_tab_btn(E) -->

        <!-- opus_design_grid(S) -->  
        <div id="tabLayer" style="display:inline">
               <!-- layout_wrap(S) -->
               <div class="layout_wrap">
                   <div class="layout_vertical_2" style="width:49%;">
                       <!-- opus_design_grid(S) -->
                       <div class="opus_design_inquiry sm pad_8">
                       <table style="width:100%;" >
                                             <tbody>
                                                     <colgroup>
                                                             <col width="80"/>
                                                             <col width="200"/>
                                                             <col width="80"/>
                                                             <col width="*"/>
                                                     </colgroup>
                                                     <tr>
                                                             <th>Shipper</th>
                                                             <td colspan="3"><input type="text" style="width:30px;" class="input" name="frm_cust_cnt_cd1" id="frm_cust_cnt_cd1" maxlength="2" dataformat="enguponly" caption="Shipper Country Code">
                                                                 <input type="text" style="width:60px;  class="input"  name="frm_cust_seq1" id="frm_cust_seq1" maxlength="6" dataformat="engup" caption="Shipper Sequence">
                                                                 <button type="button" class="btn_down_list" name="btn_cust_s" id="btn_cust_s"></button>
                                                             </td>
                                                     </tr>
                                                     <tr>
                                                             <th>Name</th>
                                                             <td colspan="3"><textarea rows="2" name="frm_cust_nm1" id="frm_cust_nm1" maxlength="500" dataformat="engupetc" caption="Shipper Name" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden;resize:none;"  class="textarea_img2" wrap="physical"></textarea></td>
                                                     </tr>
                                                     <tr>
                                                             <th>Address</th>
                                                             <td colspan="3"><textarea rows="3" name="frm_cust_addr1" id="frm_cust_addr1" maxlength="500" dataformat="engupetc" caption="Shipper Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img3" wrap="physical"></textarea></td>
                                                     </tr>
                                                     <tr>
                                                            <th>City/State</th>
                                                             <td><input type="text" style="width:135px;" class="input" name="frm_cust_cty_nm1" id="frm_cust_cty_nm1" maxlength="500" dataformat="engup" caption="Shipper City"><!-- 
                                                              --><input type="text" style="width:25px;" class="input" name="frm_cust_ste_cd1" id="frm_cust_ste_cd1" maxlength="2" dataformat="engup" caption="Shipper State"></td>
                                                            <th>Country/Zip</th>
                                                             <td><input type="text" style="width:25px;" class="input" name="frm_cstms_decl_cnt_cd1" id="frm_cstms_decl_cnt_cd1" maxlength="2" dataformat="engup" caption="Shipper Country"><!-- 
                                                              --><input type="text" style="width:87px;" class="input" name="frm_cust_zip_id1" id="frm_cust_zip_id1" maxlength="10" dataformat="engup" caption="Shipper Zip"></td>
                                                     </tr>
                                             </tbody>
                                      </table>
                              </div>
                              <div class="opus_design_inquiry sm pad_8 mar_top_12">
                                      <table style="width:100%">
                                             <tbody>
                                                     <colgroup>
                                                             <col width="80"/>
                                                             <col width="200"/>
                                                             <col width="80"/>
                                                             <col width="*"/>
                                                     </colgroup>
                                                     <tr>
                                                             <th>Consignee</th>
                                                             <td><input type="text" style="width:30px;" class="input" name="frm_cust_cnt_cd2" id="frm_cust_cnt_cd2" maxlength="2" dataformat="engupetc" caption="Consignee Country Code">
                                                                    <input type="text" style="width:60px;text-align:right;" class="input" name="frm_cust_seq2" id="frm_cust_seq2" maxlength="6" dataformat="engupetc" caption="Consignee Sequence">
                                                                    <button type="button" class="btn_down_list" name="btn_cust_c" id="btn_cust_c"></button>
                                                             </td>
                                                             <th>B/L type</th>
                                                             <td><input type="text" style="width:30px;" class="input2" name="frm_to_ord_flg" id="frm_to_ord_flg" readonly="readonly"></td>
                                                     </tr>
                                                     <tr>
                                                             <th>Name</th>
                                                             <td colspan="3"><textarea rows="2" name="frm_cust_nm2" id="frm_cust_nm2" maxlength="500" dataformat="engupetc" caption="Consignee Name" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img2" wrap="physical"></textarea></td>
                                                     </tr>
                                                     <tr>
                                                             <th>Address</th>
                                                             <td colspan="3"><textarea rows="3" name="frm_cust_addr2" id="frm_cust_addr2" maxlength="500" dataformat="engupetc" caption="Consignee Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img3" wrap="physical"></textarea></td>
                                                     </tr>
                                                     <tr>
                                                            <th>City/State</th>
                                                             <td><input type="text" style="width:135px;" class="input" name="frm_cust_cty_nm2" id="frm_cust_cty_nm2" maxlength="500" dataformat="engup" caption="Consignee City"><!-- 
                                                              --><input type="text" style="width:25px;" class="input" name="frm_cust_ste_cd2" id="frm_cust_ste_cd2" maxlength="2" dataformat="engup" caption="Consignee State"></td>
                                                            <th>Country/Zip</th>
                                                             <td><input type="text" style="width:25px;" class="input" name="frm_cstms_decl_cnt_cd2" id="frm_cstms_decl_cnt_cd2" maxlength="2" dataformat="engup" caption="Consignee Country"><!-- 
                                                              --><input type="text" style="width:87px;" class="input" name="frm_cust_zip_id2" id="frm_cust_zip_id2" maxlength="10" dataformat="engup" caption="Consignee Zip"></td>
                                                     </tr>
                                             </tbody>
                                      </table>
                              </div>
                       </div>
                       <div class="layout_vertical_2" style="width:30px;">
                       <table><tr><td></td></tr></table>
                   </div>      
                       <div class="layout_vertical_2" style="width:50%; float:right;">
                       <!-- opus_design_grid(S) -->
                       <div class="opus_design_inquiry sm pad_8">
                           <table style="width:100%">
                                             <tbody>
                                             <colgroup>
                                                     <col width="100">
                                                     <col width="200">
                                                     <col width="80">
                                                     <col width="*">
                                             </colgroup>
                                                     <tr>
                                                             <th>Notify</th>
                                                             <td colspan="3"><input type="text" style="width:30px;" class="input" name="frm_cust_cnt_cd3" id="frm_cust_cnt_cd3" maxlength="2" dataformat="engup" caption="Notify Country Code">
                                                                    <input type="text" style="width:60px;text-align:right;" class="input" name="frm_cust_seq3" id="frm_cust_seq3" maxlength="6" dataformat="engup" caption="Notify Sequence"> 
                                                                    <button type="button" class="btn_down_list" name="btn_cust_n" id="btn_cust_n"></button>
                                                             </td>
                                                     </tr>
                                                     <tr>
                                                             <th>Name</th>
                                                             <td colspan="3"><textarea rows="2" name="frm_cust_nm3" id="frm_cust_nm3" maxlength="500" dataformat="engupetc" caption="Notify Name" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img2" wrap="physical"></textarea></td>
                                                     </tr>
                                                     <tr>
                                                             <th>Address</th>
                                                             <td colspan="3"><textarea rows="3" name="frm_cust_addr3" id="frm_cust_addr3" maxlength="500" dataformat="engupetc" caption="Notify Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img3" wrap="physical"></textarea></td>
                                                     </tr>
                                                     <tr>
                                                            <th>City/State</th>
                                                             <td><input type="text" style="width:135px;" class="input" name="frm_cust_cty_nm3" id="frm_cust_cty_nm3" maxlength="500" dataformat="engup" caption="Notify City"><!-- 
                                                                     --><input type="text" style="width:25px;" class="input" name="frm_cust_ste_cd3" id="frm_cust_ste_cd3" maxlength="2" dataformat="engup" caption="Notify State"></td>
                                                            <th>Country/Zip</th>
                                                             <td><input type="text" style="width:25px;" class="input" name="frm_cstms_decl_cnt_cd3" id="frm_cstms_decl_cnt_cd3" maxlength="2" dataformat="engup" caption="Notify Country"><!-- 
                                                              --><input type="text" style="width:87px;" class="input" name="frm_cust_zip_id3" id="frm_cust_zip_id3" maxlength="10" dataformat="engup" caption="Notify Zip"></td>
                                                     </tr>
                                             </tbody>
                                      </table>
                              </div>
                              <div class="opus_design_inquiry sm pad_8 mar_top_12">
                                      <table style="width:100%">
                                             <tbody>
                                                     <colgroup>
                                                             <col width="100">
                                                             <col width="200">
                                                             <col width="80">
                                                             <col width="*">
                                                     </colgroup>
                                                     <tr>
                                                             <th>Delivery Address</th>
                                                             <td colspan="3"><input type="text" style="width:60px;" class="input" name="frm_in_tz_yd_cd1" id="frm_in_tz_yd_cd1" maxlength="5" dataformat="engup" caption="Yard Code">
                                                                    <input type="text" style="width:30px;" class="input" name="frm_in_tz_yd_cd2" id="frm_in_tz_yd_cd2" maxlength="2" dataformat="engup" caption="Yard Code">
                                                                    <button type="button" class="btn_down_list" name="btn_cust_d" id="btn_cust_d"></button>
                                                             </td>
                                                     </tr>
                                                     <tr>
                                                             <th>Name</th>
                                                             <td colspan="3"><textarea rows="2" name="frm_in_tz_yd_nm" id="frm_in_tz_yd_nm" maxlength="500" dataformat="engupetc" caption="Yard Name" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img2" wrap="physical"></textarea></td>
                                                     </tr>
                                                     <tr>
                                                             <th>Address</th>
                                                             <td colspan="3"><textarea rows="3" name="frm_in_tz_yd_addr" id="frm_in_tz_yd_addr" maxlength="500" dataformat="engupetc" caption="Yard Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img3" wrap="physical"></textarea></td>
                                                             
                                                     </tr>
                                                     <tr>
                                                            <th>City/State</th>
                                                             <td><input type="text" style="width:135px;" class="input" name="frm_in_tz_yd_cty_nm" id="frm_in_tz_yd_cty_nm" maxlength="500" dataformat="engup" caption="Yard City"><!-- 
                                                              --><input type="text" style="width:25px;" class="input" name="frm_in_tz_yd_ste_cd" id="frm_in_tz_yd_ste_cd" maxlength="2" dataformat="engup" caption="Yard State"></td>
                                                            <th>Country/Zip</th>
                                                             <td><input type="text" style="width:25px;" class="input" name="frm_in_tz_yd_cnt_cd" id="frm_in_tz_yd_cnt_cd" maxlength="2" dataformat="engup" caption="Yard Country"><!-- 
                                                              --><input type="text" style="width:87px;" class="input" name="frm_in_tz_yd_zip_id" id="frm_in_tz_yd_zip_id" maxlength="10" dataformat="engup" caption="Yard Zip"></td>
                                                     </tr>
                                             </tbody>
                                      </table>
                       </div>
                   </div>
               </div>
               <!-- layout_wrap(E) -->
               <div class="opus_design_data">
                       <table style="width:950px;">
                              <tbody>
                                      <colgroup>
                                             <col width="75">
                                             <col width="*">
                                      </colgroup>
                                      <tr>
                                              <th>Remark(s)</th>
                                              <td ><input type="text" style="width:100%;" class="input" name="frm_diff_rmk" id="frm_diff_rmk" maxlength="4000" dataformat="engup" caption="Remark"></td>
                                       </tr>
                              </tbody>
                       </table>
               </div>
        </div>
        <div style="display:none;">
               <script type="text/javascript">ComSheetObject('sheet1');</script>
               <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
               <script type="text/javascript">ComSheetObject('sheet3');</script>
        </div>
               
        <div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
               <script type="text/javascript">ComSheetObject('sheet4');</script>
        </div>
        
        <div style="display:none;">
               <script type="text/javascript">ComSheetObject('sheet5');</script>
        </div>
        <!-- opus_design_grid(E) -->
</div>
<%if (!"true".equals(main_page)) {%></div><%}%>
</form>
</body>