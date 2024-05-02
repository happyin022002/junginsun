<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0225.jsp
*@FileTitle  : Agreement Rate Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    Exception                    serverException        = null;            //Server Exception
    String                        strErrMsg            = "";                                 //Error Message
    String    userId        = "";
    String    ofcCd        = "";
    String  agmt_no     = "";
    String  ofc_cd      = "";
    String  trsp_agmt_rt_tp_ser_no = "";
    String  trsp_agmt_rt_tp_cd     = "";
    String  fm_effective_agmt      = "";
    String  eq_knd_cd = "";
    try {
        agmt_no = ((request.getParameter("chk_agmt_no")==null )?"":request.getParameter("chk_agmt_no"));    
        ofc_cd = ((request.getParameter("chk_ofc_cd")==null )?"":request.getParameter("chk_ofc_cd"));    
        trsp_agmt_rt_tp_ser_no = ((request.getParameter("chk_trsp_agmt_rt_tp_ser_no")==null )?"":request.getParameter("chk_trsp_agmt_rt_tp_ser_no"));    
        trsp_agmt_rt_tp_cd     = ((request.getParameter("chk_trsp_agmt_rt_tp_cd")==null )?"":request.getParameter("chk_trsp_agmt_rt_tp_cd"));
        fm_effective_agmt     = ((request.getParameter("fm_effective_agmt")==null )?"":request.getParameter("fm_effective_agmt"));
        eq_knd_cd  = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));

        SignOnUserAccount account    = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId                       = account.getUsr_id();
        ofcCd                        = account.getOfc_cd();
        serverException              = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>


<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("trsp_cost_mod_cd",    "", "CD02177", 0, "")%>
<%= JSPUtil.getIBCodeCombo("agmt_trsp_tp_cd",    "", "CD00283", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cgo_tp_cd",            "", "CD00748", 0, "")%>
<%= JSPUtil.getIBCodeCombo("rail_svc_tp_cd",    "", "CD00916", 0, "")%>
<%= BizComUtil.getIBCodeCombo("curr_cd",        "", "CURR", 2, "")%>
<%= JSPUtil.getIBCodeCombo("wtr_term_cd",        "", "CD01354", 0, "")%>
<%= JSPUtil.getIBCodeCombo("spcl_cgo_cntr_tp_cd",     "", "CD01507", 0, "")%>

  function setupPage(){
    loadPage();
  }
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd" value="<%=StringUtil.xssFilter(ofcCd)%>" id="fm_account_ofc_cd" />
<input type="hidden" name="fm_account_usr_id" value="<%=StringUtil.xssFilter(userId)%>" id="fm_account_usr_id" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="header_row" id="header_row" />
<input type="hidden" name="tot_page_cnt" value="" id="tot_page_cnt" />
<input type="hidden" name="cur_page_cnt" value="" id="cur_page_cnt" />
<input type="hidden" name="page_size" value="5000" id="page_size" />
<input type="hidden" name="grid_flg" value="Y" id="grid_flg" />
<input type="hidden" name="TRSP_SO_EQ_KIND" value="" id="TRSP_SO_EQ_KIND" />
<input type="hidden" name="fm_trsp_agmt_rt_tp_ser_no" value="<%=StringUtil.xssFilter(trsp_agmt_rt_tp_ser_no)%>" id="fm_trsp_agmt_rt_tp_ser_no" />
<input type="hidden" name="fm_eq_knd_cd" id="fm_eq_knd_cd" />
<input type="hidden" name="fm_effective_agmt" value="<%=StringUtil.xssFilter(fm_effective_agmt)%>" id="fm_effective_agmt" />

<input type="hidden" name="chk_trsp_cost_mod_cd" id="chk_trsp_cost_mod_cd" />
<input type="hidden" name="chk_agmt_trsp_tp_cd" id="chk_agmt_trsp_tp_cd" />
<input type="hidden" name="chk_cgo_tp_cd" id="chk_cgo_tp_cd" />
<input type="hidden" name="chk_cust_cd" id="chk_cust_cd" />
<input type="hidden" name="chk_cmdt_grp_cd" id="chk_cmdt_grp_cd" />
<input type="hidden" name="chk_rail_svc_tp_cd" id="chk_rail_svc_tp_cd" />
<input type="hidden" name="chk_fm_nod_cd" id="chk_fm_nod_cd" />
<input type="hidden" name="chk_fm_nod_yd" id="chk_fm_nod_yd" />
<input type="hidden" name="chk_via_nod_cd" id="chk_via_nod_cd" />
<input type="hidden" name="chk_via_nod_yd" id="chk_via_nod_yd" />
<input type="hidden" name="chk_dor_nod_cd" id="chk_dor_nod_cd" />
<input type="hidden" name="chk_dor_nod_yd" id="chk_dor_nod_yd" />
<input type="hidden" name="chk_to_nod_cd" id="chk_to_nod_cd" />
<input type="hidden" name="chk_to_nod_yd" id="chk_to_nod_yd" />
<input type="hidden" name="chk_trsp_dist_tp_cd" id="chk_trsp_dist_tp_cd" />
<input type="hidden" name="chk_trsp_agmt_dist" id="chk_trsp_agmt_dist" />
<input type="hidden" name="chk_dist_meas_ut_cd" id="chk_dist_meas_ut_cd" />
<input type="hidden" name="fm_trsp_agmt_rt_tp_cd" value="P" id="fm_trsp_agmt_rt_tp_cd" />
<input type="hidden" id="custCode" name="custCode" />
<input type="hidden" name="parm_eq_knd_cd" value="<%=StringUtil.xssFilter(eq_knd_cd)%>" id="parm_eq_knd_cd" />
<input type="hidden" id="trsp_tmp_seq" name="trsp_tmp_seq" /><!-- deliver to Update after Verify -->

    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
       <!-- page_title(S) -->
        <h2 class="page_title"><span>Agreement Rate Correction</span></h2>
        <!-- page_title(E) -->
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" id="btn_retrieve"     name="btn_retrieve">Retrieve</button><!--
         --><button type="button" class="btn_normal" id="btn_minimize"  name="btn_minimize">Minimize</button><!--
         --><button type="button" class="btn_accent" id="btn_Close"     name="btn_Close">Close</button><!--
     --></div>
        <!-- opus_design_btn(E) -->
    </div>
    <!-- page_title_area(E) -->
    
    <div class="wrap_search_tab">
        <div class="layout_wrap"  id="MiniLayer">
           <!-- layout_flex_fixed(S) -->
           <div class="layout_vertical_2" style="width:600px">
                   <div class= "opus_design_inquiry wFit">
                    <table>
                        <colgroup>
                            <col width="100" />
                            <col width="110" />
                            <col width="170" />
                            <col width="*" />
                        </colgroup>
                        <tbody>
                            <tr>
                              <th>Agreement No.</th>
                              <td><input name="fm_agmtno" type="text" style="width:80px;" class="input" value="<%=StringUtil.xssFilter(agmt_no)%>" readonly id="fm_agmtno" /> </td>
                              <th>Service Provider</th>
                              <td><input name="fm_vndr_prmry_seq" type="text" style="width:65px;" readonly id="fm_vndr_prmry_seq" /><input name="fm_vndr_prmry_nm" type="text" style="width:141px;" readonly id="fm_vndr_prmry_nm" /></td>
                            </tr>
                            <tr>
                              <th>Contract Office</th>
                              <td colspan="4"><input name="fm_ctrt_ofc_cd" type="text" style="width:80px;" readonly id="fm_ctrt_ofc_cd" /> </td>
                            </tr>
                            <tr>
                              <th>Reference No.</th>
                              <td><input name="fm_agmt_ref_no" type="text" style="width:80px;" readonly id="fm_agmt_ref_no" /> </td>
                              <th>Remark</th>
                              <td colspan="2"><input name="fm_inter_rmk" type="text" style="width:210px;" readonly id="fm_inter_rmk" /> </td>
                            </tr>
                            <tr><td><script type="text/javascript">ComSheetObject('sheet0');</script></td></tr>
                            <tr></tr>
                        </tbody>
                    </table>
                </div>
           </div>
           <!-- layout_flex_fixed(E) -->
           <!-- layout_flex_flex(S) -->
           <div class="layout_vertical_2" style="height:120px;width:360px;">
                   <div class="opus_design_grid" id="mainTable" >
                       <script type="text/javascript">ComSheetObject('sheet1');</script>
                   </div>
           </div>
           <div class= "opus_design_inquiry wFit">
                    <table>
                        <colgroup>
                            <col width="30" />
                            <col width="65" />
                            <col width="85" />
                            <col width="35" />
                            <col width="95" />
                            <col width="35" />
                            <col width="95" />
                            <col width="35" />
                            <col width="*" />
                        </colgroup>
                        <tbody>
                            <tr><td colspan="14"></td></tr>
                            <tr><td colspan="14"></td></tr>
                            <tr>
                                <th>From</th>
                                <td><input name="search_fm_loc" type="text" style="width:60px;" maxlength="5" onchange="getComboList(this, document.form.search_fm_yard, 'F');" onblur="setgetUpper(this);" id="search_fm_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_fm_yard', 1, 45, 0)</script><button type="button" id="btns_frmnode" name="btns_frmnode" class="input_seach_btn"></button></td>
                                <th>Via</th>
                                <td><input name="search_via_loc" type="text" style="width:60px;" maxlength="5" onchange="getComboList(this, document.form.search_via_yard, 'V');" onblur="setgetUpper(this);" id="search_via_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_via_yard', 1, 45, 0);</script><button type="button" id="btns_vianode" name="btns_vianode" class="input_seach_btn"></button></td>
                                <th>Door</th>
                                <td><input name="search_door_loc" type="text" style="width:60px;" maxlength="5" onchange="getComboList(this, document.form.search_door_yard, 'D');" onblur="setgetUpper(this);" id="search_door_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><button type="button" id="btns_dornode" name="btns_dornode" class="input_seach_btn"></button></td>
                                <th>To</th>
                                <td><input name="search_to_loc" type="text" style="width:60px;" maxlength="5" onchange="getComboList(this, document.form.search_to_yard, 'T');" onblur="setgetUpper(this);" id="search_to_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_to_yard', 1, 48, 0);</script><button type="button" id="btns_tonode" name="btns_tonode" class="input_seach_btn"></button></td>
                            </tr>
                        </tbody>
                    </table>
            </div>            
        </div>
    </div>
    <div class= "wrap_result">
        <!-- opus_tab_btn(S) -->
        <div class="opus_design_tab">
            <script type="text/javascript">ComTabObject('tab1')</script>
        </div>
        <!-- opus_tab_btn(E) -->
        <div id="tabLayer" name="tabLayer" style="display:inline">
            <div class= "opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="70" />
                        <col width="270" />
                        <col width="400" />
                        <col width="90" />
                        <col width="30" />
                        <col width="20" />
                        <col width="60" />
                        <col width="10" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                          <th>Effective Date</th>
                          <td>
                            <input name="fm_eff_fm_dt1" type="text" style="width:80px;" class="input" value="" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" id="fm_eff_fm_dt1" dataformat="ymd" /><!-- 
                             -->~ <input name="fm_eff_to_dt1" type="text" style="width:80px;" class="input" value="" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" id="fm_eff_to_dt1" dataformat="ymd" /><!-- 
                             --><button type="button" id="btng_calendar1" name="btng_calendar1" class="calendar ir"></button><button class="btn_etc" id="btng_date_apply1" name="btng_date_apply1"  >Date Apply</button>
                          </td>   
                          <th>Page Size :</th>
                          <td>
                            <select style="width:60;" class="input" name="page_size1" onChange="javascript:input_change();">
                              <option value="500">500</option>
                              <option value="1000">1000</option>
                              <option value="3000" selected>3000</option>
                              <option value="5000">5000</option>
                            </select>
                          </td>
                          <td><button class="btn_left" name="reward1" id="reward1"></button></td>
                          <th>Page :</th>
                          <td><input type="text" class="input2" style="width:30px; valign:bottom; text-align:right;" name="tot_page_cnt1" value="0" id="tot_page_cnt1" /><input type="text" style="width:30px; valign:bottom; text-align:right" name="cur_page_cnt1" value="1" onkeydown="if (event.keyCode == 13) gotopage();" id="cur_page_cnt1" /></td>
                          <td></td>
                          <td><button class="btn_right" name="forward1" id="forward1"></button></td>
                        </tr>
                       </tbody>
                   </table>
               </div>
            <div class="opus_design_grid clear" id="mainTable" >
                <div class="opus_design_btn">
                    <button type="button" class="btn_accent" name="btng_rowadd"     id="btng_rowadd">Row Add</button><!--
                    --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Row Delete</button><!--
                    --><button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">File Import</button><!--
                    --><button type="button" class="btn_normal" name="btng_reset" id="btng_reset">Reset</button><!--
                    --><button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button><!--
                    --><button type="button" class="btn_normal" name="btng_update" id="btng_update">Update</button><!--
                    --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--
                    --><button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button><!--
                    --><button type="button" class="btn_normal" name="btng_help" id="btng_help">Verify Rule</button><!--
                --></div>
                   <script type="text/javascript">ComSheetObject('sheet2');</script>
               </div>
               <div class= "opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="70" />
                        <col width="350" />
                        <col width="100" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                            <th><h3 class="title_design" style="vertical-align: bottom;">Verify Error</h3></th>
                            <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_1" value="0" readonly id="verify_result_1" /><input type="text" class="input2" style="width:304px;valign:bottom;font-color:red;" name="verify_result_str_1" value="( UPDATE DISABLE! )" readonly id="verify_result_str_1" /></td>
                            <th>Updated Row Count</th>
                            <td>
                              <input type="text" class="input2" style="width:35px;valign:bottom;" name="updated_rows_cnt_1" value="0" readonly id="updated_rows_cnt_1" /><!-- 
                               -->/ <input type="text" class="input2" style="width:35px;valign:bottom;" name="total_rows_cnt_1" value="0" readonly id="total_rows_cnt_1" />
                              <input type="hidden" name="verify_check_yn_1" value="N" id="verify_check_yn_1" />
                              <input type="hidden" name="message_1" id="message_1" />
                              <input type="hidden" name="nosave_1" value="N" id="nosave_1" />
                            </td>
                          </tr>
                       </tbody>
                   </table>
               </div>
        </div>
        <div id="tabLayer" name="tabLayer" style="display:none">
            <div class= "opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="70" />
                        <col width="270" />
                        <col width="400" />
                        <col width="90" />
                        <col width="30" />
                        <col width="20" />
                        <col width="60" />
                        <col width="10" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                          <th>Effective Date</th>
                          <td width="">
                            <input name="fm_eff_fm_dt2" type="text" style="width:80px;" class="input" value="" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" id="fm_eff_fm_dt2" dataformat="ymd" /><!-- 
                             -->~ <input name="fm_eff_to_dt2" type="text" style="width:80px;" class="input" value="" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" id="fm_eff_to_dt2" dataformat="ymd" /><!-- 
                             --><button type="button" id="btng_calendar2" name="btng_calendar2" class="calendar ir"></button><button class="btn_etc" id="btng_date_apply2" name="btng_date_apply2"  >Date Apply</button>
                          </td>   
                          <th>Page Size :</th>
                          <td>
                            <select style="width:60px;" class="input" name="page_size2" id="page_size2" onChange="javascript:input_change();">
                              <option value="500">500</option>
                              <option value="1000">1000</option>
                              <option value="3000" selected>3000</option>
                              <option value="5000">5000</option>
                            </select>
                          </td>
                          <td><button class="btn_left" name="reward2" id="reward2"></button></td>
                          <th>Page :</th>
                          <td><input type="text" class="input2" style="width:30px; valign:bottom; text-align:right;" name="tot_page_cnt2" value="0" id="tot_page_cnt2" /><input type="text" style="width:30px; valign:bottom; text-align:right" name="cur_page_cnt2" value="1" onkeydown="if (event.keyCode == 13) gotopage();" id="cur_page_cnt2" /></td>
                          <td></td>
                          <td><button class="btn_right" name="forward2" id="forward2"></button></td>
                        </tr>
                       </tbody>
                   </table>
               </div>
            <div class="opus_design_grid clear" id="mainTable" >
                <div class="opus_design_btn">
                    <button type="button" class="btn_accent" name="btng_rowadd"     id="btng_rowadd">Row Add</button><!--
                    --><button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">File Import</button><!--
                    --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Delete</button><!--
                    --><button type="button" class="btn_normal" name="btng_reset" id="btng_reset">Reset</button><!--
                    --><button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button><!--
                    --><button type="button" class="btn_normal" name="btng_update" id="btng_update">Update</button><!--
                    --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--
                    --><button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button><!--
                    --><button type="button" class="btn_normal" name="btng_help" id="btng_help">Verify Rule</button><!--
                --></div>
                   <script type="text/javascript">ComSheetObject('sheet3');</script>
               </div>
               <div class= "opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="70" />
                        <col width="350" />
                        <col width="100" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                            <th><h3 class="title_design" style="vertical-align: bottom;">Verify Error</h3></th>
                            <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_2" value="0" readonly id="verify_result_2" /><input type="text" class="input2" style="width:304px;valign:bottom;font-color:red;" name="verify_result_str_2" value="( UPDATE DISABLE! )" readonly id="verify_result_str_2" /></td>
                            <th>Updated Row Count</th>
                            <td>
                              <input type="text" class="input2" style="width:35px;valign:bottom;" name="updated_rows_cnt_2" value="0" readonly id="updated_rows_cnt_2" /><!-- 
                               -->/ <input type="text" class="input2" style="width:35px;valign:bottom;" name="total_rows_cnt_2" value="0" readonly id="total_rows_cnt_2" />
                              <input type="hidden" name="verify_check_yn_2" value="N" id="verify_check_yn_2" />
                              <input type="hidden" name="message_2" id="message_2" />
                              <input type="hidden" name="nosave_2" value="N" id="nosave_2" />
                            </td>
                          </tr>
                       </tbody>
                   </table>
               </div>
        </div>
        <div id="tabLayer" name="tabLayer" style="display:none">
            <div class= "opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="70" />
                        <col width="270" />
                        <col width="400" />
                        <col width="90" />
                        <col width="30" />
                        <col width="20" />
                        <col width="60" />
                        <col width="10" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                          <th>Effective Date</th>
                          <td width="">
                            <input name="fm_eff_fm_dt3" type="text" style="width:80px;" class="input" value="" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" id="fm_eff_fm_dt3" dataformat="ymd" /><!-- 
                             -->~ <input name="fm_eff_to_dt3" type="text" style="width:80px;" class="input" value="" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" id="fm_eff_to_dt3" dataformat="ymd" /><!-- 
                             --><button type="button" id="btng_calendar3" name="btng_calendar3" class="calendar ir"></button><button class="btn_etc" id="btng_date_apply3" name="btng_date_apply3"  >Date Apply</button>
                          </td>   
                          <th>Page Size :</th>
                          <td>
                            <select style="width:60px;" class="input" name="page_size3" id="page_size3" onChange="javascript:input_change();">
                              <option value="500">500</option>
                              <option value="1000">1000</option>
                              <option value="3000" selected>3000</option>
                              <option value="5000">5000</option>
                            </select>
                          </td>
                          <td><button class="btn_left" name="reward3" id="reward3"></button></td>
                          <th>Page :</th>
                          <td><input type="text" class="input2" style="width:30px; valign:bottom; text-align:right;" name="tot_page_cnt3" value="0" id="tot_page_cnt3" /><input type="text" style="width:30px; valign:bottom; text-align:right" name="cur_page_cnt3" value="1" onkeydown="if (event.keyCode == 13) gotopage();" id="cur_page_cnt3" /></td>
                          <td></td>
                          <td><button class="btn_right" name="forward3" id="forward3"></button></td>
                        </tr>
                       </tbody>
                   </table>
               </div>
            <div class="opus_design_grid clear" id="mainTable" >
                <div class="opus_design_btn">
                    <button type="button" class="btn_accent" name="btng_rowadd"     id="btng_rowadd">Row Add</button><!--
                    --><button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">File Import</button><!--
                    --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Delete</button><!--
                    --><button type="button" class="btn_normal" name="btng_reset" id="btng_reset">Reset</button><!--
                    --><button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button><!--
                    --><button type="button" class="btn_normal" name="btng_update" id="btng_update">Update</button><!--
                    --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--
                    --><button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button><!--
                    --><button type="button" class="btn_normal" name="btng_help" id="btng_help">Verify Rule</button><!--
                --></div>
                   <script type="text/javascript">ComSheetObject('sheet4');</script>
               </div>
               <div class="opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="70" />
                        <col width="350" />
                        <col width="100" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                            <th><h3 class="title_design" style="vertical-align: bottom;">Verify Error</h3></th>
                            <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_3" value="0" readonly id="verify_result_3" /><input type="text" class="input2" style="width: 305px; valign:bottom; font-color:red;" name="verify_result_str_3" value="( UPDATE DISABLE! )" readonly id="verify_result_str_3" /></td>
                            <th>Updated Row Count</th>
                            <td>
                              <input type="text" class="input2" style="width:35px;valign:bottom;" name="updated_rows_cnt_3" value="0" readonly id="updated_rows_cnt_3" /><!-- 
                               -->/ <input type="text" class="input2" style="width:35px;valign:bottom;" name="total_rows_cnt_3" value="0" readonly id="total_rows_cnt_3" />
                              <input type="hidden" name="verify_check_yn_3" value="N" id="verify_check_yn_3" />
                              <input type="hidden" name="message_3" id="message_3" />
                              <input type="hidden" name="nosave_3" value="N" id="nosave_3" />
                            </td>
                          </tr>
                       </tbody>
                   </table>
               </div>
        </div>
        <div class= "opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="50" />
                        <col width="90" />
                        <col width="50" />
                        <col width="100" />
                        <col width="65" />
                        <col width="50" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                          <!-- Repeat Pattern -->
                                <th>RATE TYPE</th>
                                <td>
                                  <select name="fm_scal_rate_type" style="width:80px;" class="input">
                                    <option value="1">Rate</option>
                                    <option value="2">Roundtrip</option>
                                  </select>
                                </td>
                                <th>Scaling</th>
                                <td>
                                  <input name="fm_scal_value" type="text" style="width:30px;" class="input" id="fm_scal_value" /><!--  
                                  --><select name="fm_scal_uom" style="width:50px;" class="input">
                                    <option value="0">%</option>
                                    <option value="1">Flat</option>
                                  </select>
                                </td>
                                <th>Round Off</th>
                                <td>
                                  <select name="fm_round_off" style="width:40px;" class="input">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                  </select>
                                </td>
                                <td><button class="btn_etc"  id="btng_scaling" name="btng_scaling">Rate Scaling</button></td>
                        </tr>
                       </tbody>
                   </table>
               </div>
           </div>
                <!-- receive return data and deliver main Sheet for Verify -->
                <div class="opus_design_grid" style="width:360px;">
                <script type="text/javascript">ComSheetObject('sheet5');</script>
                </div>
                <!-- receive return data and deliver main Sheet for Verify -->
</form>
