<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0228.jsp
*@FileTitle  : Agreement Surcharge Rate Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
    Exception serverException        = null;    
    String    strErrMsg              = "";
    String    userId                 = "";
    String    ofc_cd                 = "";
    String    agmt_no                = "";
    String    trsp_agmt_rt_tp_ser_no = "";
    String    trsp_agmt_rt_tp_cd     = "";
    String    fm_effective_agmt      = "";
    String    eq_knd_cd              = "";
    agmt_no                = ((request.getParameter("chk_agmt_no")==null )?"":request.getParameter("chk_agmt_no"));    
    ofc_cd                 = ((request.getParameter("chk_ofc_cd")==null )?"":request.getParameter("chk_ofc_cd"));    
    trsp_agmt_rt_tp_ser_no = ((request.getParameter("chk_trsp_agmt_rt_tp_ser_no")==null )?"":request.getParameter("chk_trsp_agmt_rt_tp_ser_no"));    
    trsp_agmt_rt_tp_cd     = ((request.getParameter("chk_trsp_agmt_rt_tp_cd")==null )?"":request.getParameter("chk_trsp_agmt_rt_tp_cd"));
    fm_effective_agmt      = ((request.getParameter("fm_effective_agmt")==null )?"":request.getParameter("fm_effective_agmt"));
    eq_knd_cd              = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));

    // Agreement Correction ( ESD_TRS_0224 ) 화면에서 넘어온 값
    String rateTypeStr1 = "";
    String rateTypeStr1_1 = "";
    String rateTypeStr2 = "";
    rateTypeStr1 = ((request.getParameter("rate_type1")==null )?"":request.getParameter("rate_type1"));
    rateTypeStr1_1 = ((request.getParameter("rate_type1_1")==null )?"":request.getParameter("rate_type1_1"));
    rateTypeStr2 = ((request.getParameter("rate_type2")==null )?"":request.getParameter("rate_type2"));

    try
    {
        SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId                    = account.getUsr_id();
        ofc_cd                    = account.getOfc_cd();
        serverException           = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }
    catch(Exception e)
    {
        out.println(e.toString());
    }
%>

<script type="text/javascript">

<%= JSPUtil.getIBCodeCombo("trsp_cost_mod_cd",    "", "CD02177", 0, "")%>
<%= JSPUtil.getIBCodeCombo("agmt_trsp_tp_cd",     "", "CD00283", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cgo_tp_cd",           "", "CD00748", 0, "")%>
<%= JSPUtil.getIBCodeCombo("rail_svc_tp_cd",      "", "CD00916", 0, "")%>
<%= JSPUtil.getIBCodeCombo("trsp_scg_cd",         "", "CD30002", 0, "")%>
<%= JSPUtil.getIBCodeCombo("spcl_cgo_cntr_tp_cd", "", "CD01507", 0, "")%>
<%= BizComUtil.getIBCodeCombo("curr_cd",       "", "CURR", 2, "")%>

function setupPage()
{
    var formObject = document.form;
    loadPage("<%=StringUtil.xssFilter(rateTypeStr1)%>", "<%=StringUtil.xssFilter(rateTypeStr2)%>");
}

</script>

<form method="post" name="form" onSubmit="return false;">

<input type="hidden" id="fm_account_ofc_cd"         name="fm_account_ofc_cd"         value="<%=StringUtil.xssFilter(ofc_cd)%>" />
<input type="hidden" id="fm_account_usr_id"         name="fm_account_usr_id"         value="<%=StringUtil.xssFilter(userId)%>" />
<input type="hidden" id="f_cmd"                     name="f_cmd" />
<input type="hidden" id="header_row"                name="header_row" />
<input type="hidden" id="cur_page_cnt"              name="cur_page_cnt"              value="1" />
<input type="hidden" id="page_size"                 name="page_size"                 value="50000" />
<input type="hidden" id="grid_flg"                  name="grid_flg"                  value="Y" />
<input type="hidden" id="fm_trsp_agmt_rt_tp_ser_no" name="fm_trsp_agmt_rt_tp_ser_no" value="<%=StringUtil.xssFilter(trsp_agmt_rt_tp_ser_no)%>" />
<input type="hidden" id="fm_eq_knd_cd"              name="fm_eq_knd_cd" />
<input type="hidden" id="fm_effective_agmt"         name="fm_effective_agmt"         value="<%=StringUtil.xssFilter(fm_effective_agmt)%>" />

<input type="hidden" id="chk_trsp_cost_mod_cd"      name="chk_trsp_cost_mod_cd" />
<input type="hidden" id="chk_agmt_trsp_tp_cd"       name="chk_agmt_trsp_tp_cd" />
<input type="hidden" id="chk_cgo_tp_cd"             name="chk_cgo_tp_cd" />
<input type="hidden" id="chk_cust_cd"               name="chk_cust_cd" />
<input type="hidden" id="chk_cmdt_grp_cd"           name="chk_cmdt_grp_cd" />
<input type="hidden" id="chk_rail_svc_tp_cd"        name="chk_rail_svc_tp_cd" />
<input type="hidden" id="chk_fm_nod_cd"             name="chk_fm_nod_cd" />
<input type="hidden" id="chk_fm_nod_yd"             name="chk_fm_nod_yd" />
<input type="hidden" id="chk_via_nod_cd"            name="chk_via_nod_cd" />
<input type="hidden" id="chk_via_nod_yd"            name="chk_via_nod_yd" />
<input type="hidden" id="chk_dor_nod_cd"            name="chk_dor_nod_cd" />
<input type="hidden" id="chk_dor_nod_yd"            name="chk_dor_nod_yd" />
<input type="hidden" id="chk_to_nod_cd"             name="chk_to_nod_cd" />
<input type="hidden" id="chk_to_nod_yd"             name="chk_to_nod_yd" />
<input type="hidden" id="chk_trsp_scg_cd"           name="chk_trsp_scg_cd" />
<input type="hidden" id="chk_agmt_route_all_flg"    name="chk_agmt_route_all_flg" />
<input type="hidden" id="fm_trsp_agmt_rt_tp_cd"     name="fm_trsp_agmt_rt_tp_cd"     value="P" />
<input type="hidden" name="rate_type1">
<input type="hidden" name="rate_type1_1"     		name="rate_type1_1"				 value="<%=StringUtil.xssFilter(rateTypeStr1_1)%>">
<input type="hidden" name="rate_type2">
<input type="hidden" name="parm_eq_knd_cd" value="<%=StringUtil.xssFilter(eq_knd_cd)%>" id="parm_eq_knd_cd" />
<input type="hidden" id="trsp_tmp_seq" name="trsp_tmp_seq" /><!-- deliver to Update after Verify -->

    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
       <!-- page_title(S) -->
        <h2 class="page_title"><span>Agreement Surcharge Rate Correction</span></h2>
        <!-- page_title(E) -->
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
         --><button type="button" class="btn_normal" id="btn_minimize" name="btn_minimize">Minimize</button><!--
         --><button type="button" class="btn_accent" id="btn_Close"    name="btn_Close">Close</button><!--
     --></div>
        <!-- opus_design_btn(E) -->
        <!-- page_location(S) -->
        <div class="location">
            <span id="navigation"></span>
        </div>
        <!-- page_location(E) -->
    </div>
    <!-- page_title_area(E) -->    
<div class="wrap_search">
    <div class="layout_wrap wFit"  id="MiniLayer">
       <!-- layout_flex_fixed(S) -->
       <div class="layout_vertical_2" >
               <div class= "opus_design_inquiry">
                <table>
                    <colgroup>
                        <col width="1" />
                        <col width="120" />
                        <col width="60" />
                        <col width="60" />
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
                          <td colspan="4"><input name="fm_ctrt_ofc_cd" type="text" style="width:80px;" maxlength="6" readonly id="fm_ctrt_ofc_cd" /> </td>
                        </tr>
                        <tr>
                          <th>Reference No.</th>
                          <td><input name="fm_agmt_ref_no" type="text" style="width:80px;" readonly id="fm_agmt_ref_no" /> </td>
                          <th>Remark</th>
                          <td colspan="2"><input name="fm_inter_rmk" type="text" style="width:210px;" readonly id="fm_inter_rmk" /> </td>
                        </tr>
                        <tr><td><script type="text/javascript">ComSheetObject('sheet0');</script></td></tr>
                    </tbody>
                </table>
            </div>
       </div>
       <!-- layout_flex_fixed(E) -->
       <!-- layout_flex_flex(S) -->
       <div class="layout_vertical_2" style="height:90px;">
               <div class="opus_design_grid" id="mainTable" >
                   <script type="text/javascript">ComSheetObject('sheet1');</script>
               </div>
       </div>
    </div>
</div>
    <div class="wrap_result">
        <!-- opus_tab_btn(S) -->
        <div class="opus_design_tab">
            <script type="text/javascript">ComTabObject('tab1')</script>
        </div>
        <!-- opus_tab_btn(E) -->
        <div id="tabLayer" name="tabLayer" style="display:inline">
            <div class="opus_design_grid clear" id="mainTable" >
                <div class="opus_design_btn">
                    <button type="button" class="btn_accent" name="btng_rowadd"    id="btng_rowadd">Row Add</button><!--
                    --><button type="button" class="btn_normal" name="btng_delete"    id="btng_delete">Row Delete</button><!--
                    --><button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">File Import</button><!--
					--><button type="button" class="btn_normal" name="btng_reset"     id="btng_reset">Reset</button><!--
					--><button type="button" class="btn_normal" name="btng_verify"    id="btng_verify">Verify</button><!--
                    --><button type="button" class="btn_normal" name="btng_update"    id="btng_update">Update</button><!--
                    --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--
                    --><button type="button" class="btn_normal" name="btng_history"   id="btng_history">Rate History</button><!--
                    --><button type="button" class="btn_normal" name="btng_help"      id="btng_help">Verify Rule</button><!--
                --></div>
                   <script type="text/javascript">ComSheetObject('sheet2');</script>
               </div>
               <div class= "opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="100" />
                        <col width="350" />
                        <col width="100" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                               <td><h3 class="title_design">Verify Error</h3></td>
                            <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_1" value="0" readonly id="verify_result_1" /><input type="text" class="input2" style="width:304px;valign:bottom;font-color:red;" name="verify_result_str_1" value="( UPDATE DISABLE! )" readonly id="verify_result_str_1" /></td>
                            <th>Updated Row Count</th>
                            <td><!-- 
                               --><input type="text" class="input2" style="width:35px;valign:bottom;" name="updated_rows_cnt_1" value="0" readonly id="updated_rows_cnt_1" /><!-- 
                               -->/ <input type="text" class="input2" style="width:35px;valign:bottom;" name="total_rows_cnt_1" value="0" readonly id="total_rows_cnt_1" /><!-- 
                               --><input type="hidden" name="verify_check_yn_1" value="N" id="verify_check_yn_1" /><!-- 
                               --><input type="hidden" name="message_1" id="message_1" /><!-- 
                               --><input type="hidden" name="nosave_1" value="N" id="nosave_1" />
                            </td>
                         </tr>
                       </tbody>
                   </table>
               </div>
        </div>
        <div id="tabLayer" name="tabLayer" style="display:none">
            <div class="opus_design_grid clear" id="mainTable" >
                <div class="opus_design_btn">
                    <button type="button" class="btn_accent" name="btng_rowadd"     id="btng_rowadd">Row Add</button><!--
                    --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Row Delete</button><!--
                    --><button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">File Import</button><!--
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
                           <col width="100" />
                        <col width="350" />
                        <col width="100" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                               <td><h3 class="title_design">Verify Error</h3></td>
                            <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_2" value="0" readonly id="verify_result_2" /><input type="text" class="input2" style="width:304px;valign:bottom;font-color:red;" name="verify_result_str_2" value="( UPDATE DISABLE! )" readonly id="verify_result_str_2" /></td>
                            <th>Updated Row Count</th>
                            <td>
                              <input type="text" class="input2" style="width:35px;valign:bottom;" name="updated_rows_cnt_2" value="0" readonly="" id="updated_rows_cnt_2" /><!-- 
                               -->/ <input type="text" class="input2" style="width:35px;valign:bottom;" name="total_rows_cnt_2" value="0" readonly="" id="total_rows_cnt_2" />
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
            <div class="opus_design_grid clear" id="mainTable" >
                <div class="opus_design_btn">
                    <button type="button" class="btn_accent" name="btng_rowadd"     id="btng_rowadd">Row Add</button><!--
                    --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Row Delete</button><!--
                    --><button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">File Import</button><!--
                    --><button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button><!--
                    --><button type="button" class="btn_normal" name="btng_update" id="btng_update">Update</button><!--
                    --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--
                    --><button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button><!--
                    --><button type="button" class="btn_normal" name="btng_help" id="btng_help">Verify Rule</button><!--
                --></div>
                   <script type="text/javascript">ComSheetObject('sheet4');</script>
               </div>
               <div class= "opus_design_inquiry wFit">
                   <table>
                       <colgroup>
                           <col width="100" />
                        <col width="350" />
                        <col width="100" />
                        <col width="*" />
                       </colgroup>
                       <tbody>
                           <tr>
                               <td><h3 class="title_design">Verify Error</h3></td>
                            <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_3" value="0" readonly id="verify_result_3" /><input type="text" class="input2" style="width:304px;valign:bottom;font-color:red;" name="verify_result_str_3" value="( UPDATE DISABLE! )" readonly id="verify_result_str_3" /></td>
                            <th>Updated Row Count</th>
                            <td>
                              <input type="text" class="input2" style="width:35px;valign:bottom;" name="updated_rows_cnt_3" value="0" readonly="" id="updated_rows_cnt_3" /><!-- 
                               -->/ <input type="text" class="input2" style="width:35px;valign:bottom;" name="total_rows_cnt_3" value="0" readonly="" id="total_rows_cnt_3" />
                              <input type="hidden" name="verify_check_yn_3" value="N" id="verify_check_yn_3" />
                              <input type="hidden" name="message_3" id="message_3" />
                              <input type="hidden" name="nosave_3" value="N" id="nosave_3" />
                            </td>
                         </tr>
                       </tbody>
                   </table>
               </div>
                <!-- receive return data and deliver main Sheet for Verify -->
		        <div class="opus_design_grid" style="width:360px;">
		        <script type="text/javascript">ComSheetObject('sheet5');</script>
		        </div>
                <!-- receive return data and deliver main Sheet for Verify -->
        </div>
    </div>
</form>
