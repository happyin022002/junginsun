<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0222.jsp
*@FileTitle  : Agreement Surcharge Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================
--%>

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
    String    ofcCd                  = "";
    String    agmt_no                = "";
    String    trsp_agmt_rt_tp_cd     = "";

    agmt_no                      = ((request.getParameter("agmt_no")==null )?"":request.getParameter("agmt_no"));
    trsp_agmt_rt_tp_cd           = "P";

    String    rateTypeStr2       = "";
    String    rateTypeStr3       = "";
    String    rateTypeStr4       = "";
    String    locNodeStr2        = "";
    String    locNodeStr3        = "";
    String    locNodeStr4        = "";
    String    currencyStr2       = "";
    String    currencyStr3       = "";
    String    currencyStr4       = "";
    String    effDtStr2          = "";
    String    effDtStr3          = "";
    String    effDtStr4          = "";
    String    eq_knd_cd          = "";
    String trsp_agmt_rt_tp_ser_no= "";
    rateTypeStr2                 = ((request.getParameter("rateTypeStr2")==null )?"":request.getParameter("rateTypeStr2"));
    rateTypeStr3                 = ((request.getParameter("rateTypeStr3")==null )?"":request.getParameter("rateTypeStr3"));
    rateTypeStr4                 = ((request.getParameter("rateTypeStr4")==null )?"":request.getParameter("rateTypeStr4"));
    locNodeStr2                  = ((request.getParameter("locNodeStr2")==null )?"":request.getParameter("locNodeStr2"));
    locNodeStr3                  = ((request.getParameter("locNodeStr3")==null )?"":request.getParameter("locNodeStr3"));
    locNodeStr4                  = ((request.getParameter("locNodeStr4")==null )?"":request.getParameter("locNodeStr4"));
    currencyStr2                 = ((request.getParameter("currencyStr2")==null )?"":request.getParameter("currencyStr2"));
    currencyStr3                 = ((request.getParameter("currencyStr3")==null )?"":request.getParameter("currencyStr3"));
    currencyStr4                 = ((request.getParameter("currencyStr4")==null )?"":request.getParameter("currencyStr4"));
    effDtStr2                    = ((request.getParameter("effDtStr2")==null )?"":request.getParameter("effDtStr2"));
    effDtStr3                    = ((request.getParameter("effDtStr3")==null )?"":request.getParameter("effDtStr3"));
    effDtStr4                    = ((request.getParameter("effDtStr4")==null )?"":request.getParameter("effDtStr4"));
    eq_knd_cd                    = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));
    trsp_agmt_rt_tp_ser_no       = ((request.getParameter("trsp_agmt_rt_tp_ser_no")==null )?"":request.getParameter("trsp_agmt_rt_tp_ser_no"));

    try {
        SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId                    = account.getUsr_id();
        ofcCd                     = account.getOfc_cd();
        serverException           = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
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
<%= BizComUtil.getIBCodeCombo("curr_cd",          "", "CURR", 0, "")%>

function setupPage()
{
    var formObject = document.form;
    formObject.fm_trsp_agmt_rt_tp_cd.value = "<%=StringUtil.xssFilter(trsp_agmt_rt_tp_cd)%>";
    loadPage("<%=StringUtil.xssFilter(rateTypeStr2)%>", "<%=StringUtil.xssFilter(rateTypeStr3)%>", "<%=StringUtil.xssFilter(rateTypeStr4)%>"
           , "<%=StringUtil.xssFilter(locNodeStr2)%>",  "<%=StringUtil.xssFilter(locNodeStr3)%>",  "<%=StringUtil.xssFilter(locNodeStr4)%>"
           , "<%=StringUtil.xssFilter(currencyStr2)%>", "<%=StringUtil.xssFilter(currencyStr3)%>", "<%=StringUtil.xssFilter(currencyStr4)%>"
           , "<%=StringUtil.xssFilter(effDtStr2)%>",    "<%=StringUtil.xssFilter(effDtStr3)%>",    "<%=StringUtil.xssFilter(effDtStr4)%>");
}

</script>

<form method="post" name="form" onSubmit="return false;">

<input type="hidden" id="fm_account_ofc_cd"         name="fm_account_ofc_cd"     value="<%=StringUtil.xssFilter(ofcCd)%>" />
<input type="hidden" id="fm_account_usr_id"         name="fm_account_usr_id"     value="<%=StringUtil.xssFilter(userId)%>" />
<input type="hidden" id="f_cmd"                     name="f_cmd" />
<input type="hidden" id="header_row"                name="header_row" />
<input type="hidden" id="fm_eq_knd_cd"              name="fm_eq_knd_cd" />
<input type="hidden" id="fm_trsp_agmt_rt_tp_cd"     name="fm_trsp_agmt_rt_tp_cd" value="P" />

<input type="hidden" id="cur_page_cnt"              name="cur_page_cnt"          value="1">
<input type="hidden" id="page_size"                 name="page_size"             value="50000">
<input type="hidden" id="grid_flg"                  name="grid_flg"              value="Y">

<input type="hidden" id="rate_type2"                name="rate_type2">
<input type="hidden" id="rate_type3"                name="rate_type3">
<input type="hidden" id="rate_type4"                name="rate_type4">
<input type="hidden" id="loc_node2"                 name="loc_node2">
<input type="hidden" id="loc_node3"                 name="loc_node3">
<input type="hidden" id="loc_node4"                 name="loc_node4">
<input type="hidden" id="currency2"                 name="currency2">
<input type="hidden" id="currency3"                 name="currency3">
<input type="hidden" id="currency4"                 name="currency4">
<input type="hidden" id="eff_dt2"                   name="eff_dt2">
<input type="hidden" id="eff_dt3"                   name="eff_dt3">
<input type="hidden" id="eff_dt4"                   name="eff_dt4">
<input type="hidden" name="parm_eq_knd_cd" value="<%=StringUtil.xssFilter(eq_knd_cd)%>" id="parm_eq_knd_cd" />
<input type="hidden" id="trsp_tmp_seq" name="trsp_tmp_seq" /><!-- deliver to Update after Verify -->
<input type="hidden" name="parm_trsp_agmt_rt_tp_ser_no" value="<%=StringUtil.xssFilter(trsp_agmt_rt_tp_ser_no)%>" id="parm_trsp_agmt_rt_tp_ser_no" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">

    <!-- page_title(S) -->
    <h2 class="page_title"><span>Agreement Surcharge Rate Creation</span></h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn (S) -->
    <div class="opus_design_btn">
        <button class="btn_accent" type="button" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
     --><button class="btn_accent" type="button" id="btn_minimize" name="btn_minimize">Minimize</button><!--
     --><button class="btn_accent" type="button" id="btn_Close"    name="btn_Close">close</button><!--
 --></div>
    <!-- opus_design_btn (E) -->

    <!-- page_location(S) -->
    <div class="location">    
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>

<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search_tab">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <table>
            <colgroup>
                <col width="100" />                
                <col width="*" />                
           </colgroup> 
           <tbody>
                   <tr>
                    <th>Agreement No.</th>
                    <td><input name="fm_agmtno" id="fm_agmtno" type="text" style="width:230px;" class="input" value="<%=StringUtil.xssFilter(agmt_no)%>" readonly></td>
                   </tr>
           </tbody>
        </table>
    

<!-- wrap_search(S) -->

    <!-- opus_design_inquiry(E) -->
    <!-- opus_design_inquiry(S) -->
    <div id="MiniLayer" style="display:inline">
        <!-- layout_wrap(S) -->
        <div class="layout_wrap" style="width: 100%">
            <!-- layout_vertical_2(S) -->
            <div class="layout_vertical_2" style="width: 650px">
                <div class="opus_design_inquiry wFit">
                    <table>
                        <colgroup>
                            <col width="100" />                
                            <col width="300" />                
                            <col width="110" />                
                            <col width="*" />                
                       </colgroup> 
                       <tbody>
                               <tr>
                              <th>Service Provider</th>
                              <td><input name="fm_vndr_prmry_seq" type="text" style="width:60px;" readonly id="fm_vndr_prmry_seq" /><input name="fm_vndr_prmry_nm" type="text" style="width:165px;" readonly id="fm_vndr_prmry_nm" /> </td>
                              <td></td>
                            </tr>
                            <tr>
                              <th>Reference No.</th>
                              <td><input name="fm_agmt_ref_no" type="text" style="width:230px;" readonly id="fm_agmt_ref_no" /> </td>
                              <th>Contract Office</th>
                              <td><input name="fm_ctrt_ofc_cd" type="text" style="width:80px;" readonly id="fm_ctrt_ofc_cd" /> </td>
                            </tr>
                       </tbody>
                    </table>
                    <table>
                        <colgroup>
                            <col width="100" />                
                            <col width="*" />    
                        </colgroup>
                        <tr>
                           <th>Remarks</th>
                           <td><input name="fm_inter_rmk" type="text" style="width:490px;" readonly id="fm_inter_rmk" /> </td>
                         </tr>
                    </table>
                    <!-- opus_design_grid(S) -->
                    <div class="opus_design_grid">
                        <script type="text/javascript">ComSheetObject('sheet0');</script>
                    </div>
                    <!-- opus_design_grid(E) -->
                </div>
                <!-- opus_design_inquiry(E) -->
            </div>
             <!-- layout_vertical_2(E) -->
             <!-- layout_vertical_2(S) -->
            <div class="layout_vertical_2" style="width: 320px">
                 <!-- opus_design_grid(S) -->
                <div class="opus_design_grid">
                    <script type="text/javascript">ComSheetObject('sheet1');</script>
                </div>
                <!-- opus_design_grid(E) -->
            </div>
             <!-- layout_vertical_2(E) -->
            
        </div>
        <!-- layout_wrap(E) -->

    </div>
</div>
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_tab">
        <script >ComTabObject('tab1')</script>    
    </div>
    <div class="opus_design_grid">
        <!-- opus_design_btn (S) -->
        <div class="opus_design_btn">
            <button class="btn_accent" name="btng_rowadd" id="btng_rowadd" type="button">Row Add</button><!--
            --><button class="btn_normal" name="btng_delete" id="btng_delete" type="button">Row Delete</button><!--
            --><button class="btn_normal" name="btng_loadexcel" id="btng_loadexcel" type="button">File Import</button><!--
            --><button class="btn_normal" name="btng_reset" id="btng_reset" type="button">Reset</button><!--
            --><button class="btn_normal" name="btng_verify" id="btng_verify" type="button">Verify</button><!--
            --><button class="btn_normal" name="btng_update" id="btng_update" type="button">Update</button><!--
            --><button class="btn_normal" name="btng_downexcel" id="btng_downexcel" type="button">Down Excel</button><!--
            --><button class="btn_normal" name="btng_help" id="btng_help" type="button">Verify Rule</button><!--
            --></div>
        <!-- opus_design_btn (E) -->
    </div>
    <div id="tabLayer" style="display:inline">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script >ComSheetObject('sheet2');</script>
        </div>
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry wFit">
            <table>
                <colgroup>
                    <col width="70" />
                    <col width="400" />
                    <col width="150" />
                    <col width="*" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Verify Error</th>
                        <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_1" value="0" readonly id="verify_result_1" /><input type="text" class="input2" style="width:304px;valign:bottom;font-color:red;" name="verify_result_str_1" value="( UPDATE DISABLE! )" readonly id="verify_result_str_1" /></td>
                        <th> Updated Row Count :</th>
                        <td><input type="text"  class="input2" style="width:35px;valign:bottom;"  name="updated_rows_cnt_1" id="updated_rows_cnt_1" value="0" readonly>/ <!--
                        --><input type="text"  class="input2" style="width:35px;valign:bottom;"  name="total_rows_cnt_1" id="total_rows_cnt_1" value="0" readonly><!--
                        --><input type="hidden" name="verify_check_yn_1" value="N" id="verify_check_yn_1" /><input type="hidden" name="message_1" id="message_1" /><input type="hidden" name="nosave_1" value="N" id="nosave_1" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- opus_design_inquiry(E) -->
        <!-- opus_design_grid(E) -->
    </div>
    <div id="tabLayer" style="display:none">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script >ComSheetObject('sheet3');</script>
        </div>
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry wFit">
            <table>
                <colgroup>
                    <col width="70" />
                    <col width="400" />
                    <col width="150" />
                    <col width="*" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Verify Error</th>
                        <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_2" value="0" readonly id="verify_result_2" /><input type="text" class="input2" style="width:304px;valign:bottom;font-color:red;" name="verify_result_str_2" value="( UPDATE DISABLE! )" readonly id="verify_result_str_2" /></h3></td>
                        <th> Updated Row Count :</th>
                        <td><input type="text"  class="input2" style="width:35px;valign:bottom;"  name="updated_rows_cnt_2" id="updated_rows_cnt_2" value="0" readonly>/ <!--
                        --><input type="text"  class="input2" style="width:35px;valign:bottom;"  name="total_rows_cnt_2" id="total_rows_cnt_2" value="0" readonly><!--
                        --><input type="hidden" name="verify_check_yn_2" value="N" id="verify_check_yn_2" /><input type="hidden" name="message_2" id="message_2" /><input type="hidden" name="nosave_2" value="N" id="nosave_2" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- opus_design_inquiry(E) -->
        <!-- opus_design_grid(E) -->
    </div>
    <div id="tabLayer" style="display:none">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script >ComSheetObject('sheet4');</script>
        </div>
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry wFit">
            <table>
                <colgroup>
                    <col width="70" />
                    <col width="400" />
                    <col width="150" />
                    <col width="*" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Verify Error</th>
                        <td><input type="text" class="input2" style="width:30px;valign:bottom;" name="verify_result_3" value="0" readonly id="verify_result_3" /><input type="text" class="input2" style="width:304px;valign:bottom;font-color:red;" name="verify_result_str_3" value="( UPDATE DISABLE! )" readonly id="verify_result_str_3" /></h3></td>
                        <th> Updated Row Count :</th>
                        <td><input type="text" class="input2" style="width:35px;valign:bottom;" name="updated_rows_cnt_3" value="0" readonly id="updated_rows_cnt_3" />/ <!--
                        --><input type="text" class="input2" style="width:35px;valign:bottom;" name="total_rows_cnt_3" value="0" readonly id="total_rows_cnt_3" /><!--
                        --><input type="hidden" name="verify_check_yn_3" value="N" id="verify_check_yn_3" /><input type="hidden" name="message_3" id="message_3" /><input type="hidden" name="nosave_3" value="N" id="nosave_3" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
                <!-- receive return data and deliver main Sheet for Verify -->
        <div class="opus_design_grid" style="width:360px;">
        <script type="text/javascript">ComSheetObject('sheet5');</script>
        </div>
                <!-- receive return data and deliver main Sheet for Verify -->
        <!-- opus_design_inquiry(E) -->
        <!-- opus_design_grid(E) -->
    </div>
</div>

<div class="header_fixed"></div>

</form>
