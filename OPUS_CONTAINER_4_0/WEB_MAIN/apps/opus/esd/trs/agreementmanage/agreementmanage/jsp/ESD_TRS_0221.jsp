<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0221.jsp
*@FileTitle  : Agreement Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException = null;
    String      strErrMsg    = "";
    String      userId    = "";
    String      ofcCd        = "";

    try {
        SignOnUserAccount account    = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
           userId                        = account.getUsr_id();
           ofcCd                        = account.getOfc_cd();
        serverException                = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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

  function setupPage()
  {
    loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"      value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"      value="<%=userId%>">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="fm_trsp_agmt_rt_tp_cd"      value="">
<input type="hidden" name="header_row"    >
<input type="hidden" name="fm_eq_knd_cd"      value="U">
<input type="hidden" name="fm_trsp_agmt_rt_tp_radio"      value="P"> <!--Setting Pair Type always-->

<input type="hidden" name="grid_flg"        value="Y">
<input type="hidden" name="TRSP_SO_EQ_KIND" value="">

<!-- Temporary...... -->
<input type="hidden" id="page_size" name="page_size" value="100000">
<input type="hidden" id="tot_page_cnt" name="tot_page_cnt" value="0">
<input type="hidden" id="cur_page_cnt" name="cur_page_cnt" value="1">

<input type="hidden" id="custCode"     name="custCode" />
<input type="hidden" id="eq_knd_cd"    name="eq_knd_cd" />
<input type="hidden" id="trsp_tmp_seq" name="trsp_tmp_seq" /><!-- deliver to Update after Verify -->

    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        
        <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->
    
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_creation" id="btn_creation">AGMT Create</button><!--
            --><button type="button" class="btn_normal" name="btn_attach" id="btn_attach">Attach File</button><!--
            --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
        </div>
        <!-- opus_design_btn(E) -->
    
           <!-- page_location(S) -->
           <div class="location">
            <!-- location 내용 동적생성 (별도 코딩 불필요) -->
            <span id="navigation"></span>
           </div>
           <!-- page_location(E) -->
    </div>
    <!-- page_title_area(E) -->
    
    <!-- wrap_search_tab(S) -->
    <div class="wrap_search">
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry" >
            <!--  MiniLayer (S) -->
            <table >
                <colgroup>
                    <col width="108"/>
                    <col width="130"/>
                    <col width="" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Agreement No.</th>
                        <td>
                            <input type="text" id="fm_agmtno" name="fm_agmtno" style="width:80px;" class="input1" value="" onKeyup="javascript:doSearchEnter();" dataformat="engup"><!--
                            --><button type="button" class="input_seach_btn" name='btn_agmtno' id='btn_agmtno'></button>
                        </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- opus_design_inquiry(E) -->
    </div>
    <!-- wrap_search_tab(E) -->
    
    <!-- wrap_search_tab(S) -->
    <div class="wrap_result">
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry opus_design_inquiryTab">
            <!--  MiniLayer (S) -->
            <div class="layout_wrap" id="MiniLayer">
                 <!-- layout_vertical_2(S) -->
                   <div class="layout_flex_fixed" style="width:540px">
                    <table>
                        <colgroup>
                            <col width="108"/>
                            <col width="62"/>
                            <col width="200"/>
                            <col width="" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>Service Provider</th>
                                <td colspan="4">
                                    <input name="fm_vndr_prmry_seq" type="text"  style="width:60px;" readonly><!--
                                    --><input name="fm_vndr_prmry_nm" type="text" style="width:165px;" readonly>
                                </td>
                            </tr>
                            <tr>
                                <th>Reference No.</th>
                                <td colspan="2">
                                    <input name="fm_agmt_ref_no" type="text" style="width:230px;" readonly>
                                </td>
                                <th>Contract Office</th>
                                <td>
                                    <input name="fm_ctrt_ofc_cd" type="text" style="width: 100%;" readonly>
                                </td>
                            </tr>
                            <tr>
                                <th>Remarks</th>
                                <td colspan="4">
                                    <input name="fm_inter_rmk" type="text" style="width:100%;" readonly>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <!-- opus_design_grid(S)-->
                    <div class="opus_design_grid">
                        <script type="text/javascript">ComSheetObject('sheet0');</script>
                    </div>
                    <!-- opus_design_grid(S)-->

                </div>
                <div class="layout_flex_flex" style="padding-left:550px">
                    <!-- opus_design_grid(S)-->
                    <div class="opus_design_grid" style="width:360px;">
                        <script type="text/javascript">ComSheetObject('sheet1');</script>
                    </div>
                    <!-- opus_design_grid(S)-->
                </div>
            </div>
        </div>
    <!-- wrap_result(S) -->
        <!-- opus_design_tab(S) -->
        <div class="opus_design_tab">
            <script type="text/javascript">ComTabObject('tab1')</script>
        </div>
        
        <div class="opus_design_grid">
            <div class="grid_option_left">
                <table>
                    <colgroup>
                        <col width="94"/>
                        <col width="300"/>
                        <col width="" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>Effective Date</th>
                            <td>
                                <input name="fm_eff_fm_dt" type="text" style="width:80px;" class="input" value="" dataformat="ymd">~
                                <input name="fm_eff_to_dt" type="text" style="width:80px;" class="input" value="" dataformat="ymd"><!--
                                --><button type="button" class="calendar" name="btng_calendar" id="btng_calendar"></button><button type="button" class="btn_etc" name="btng_date_apply" id="btng_date_apply">Date Apply</button>
                            </td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- opus_grid_btn(S) -->
            <div class="opus_design_btn">
                <button type="button" class="btn_normal" name="btng_surcharge" id="btng_surcharge">Surcharge</button><!--
                --><button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
                --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Row Delete</button><!--
                --><button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">File Import</button><!--
                --><button type="button" class="btn_normal" name="btng_reset" id="btng_reset">Reset</button><!--
                --><button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button><!--
                --><button type="button" class="btn_normal" name="btng_update" id="btng_update">Update</button><!--
                --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--
                --><button type="button" class="btn_normal" name="btng_help" id="btng_help">Verify Rule</button>
            </div>
            <!-- opus_grid_btn(E) -->
               <!-- opus_design_grid(S) -->
            <div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
                <script type="text/javascript">ComSheetObject('sheet2');</script>
                <span class="grid_option_left"> 
                    <div class="grid_option_left">
                        <br/>
                        <table>
                            <colgroup>
                                <col width="110"/>
                                <col width="50"/>
                                <col width="305"/>
                                <col width="130"/>
                                <col width="130"/>
                                <col width="" />
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th><h3 class="title_design">Verify Error : </h3></th>
                                    <td>
                                        <input type="text"  class="input2" style="width:45px;valign:bottom;"  name="verify_result_1" value="0" readonly>
                                    </td>
                                    <td>
                                        <input type="text"  class="input2" style="width:304;valign:bottom;font-color:red;"  name="verify_result_str_1" value="( UPDATE DISABLE! )" readonly>
                                    </td>
                                    
                                    <th>Updated Row Count : </th>
                                    <td>
                                        <input type="text"  class="input2" style="width:45px;valign:bottom;"  name="updated_rows_cnt_1" value="0" readonly>&nbsp;/&nbsp;
                                          <input type="text"  class="input2" style="width:45px;valign:bottom;"  name="total_rows_cnt_1" value="0" readonly>
                                          <input type="hidden" name="verify_check_yn_1"    value="N">
                                          <input type="hidden" name="message_1"    >
                                         <input type="hidden" name="nosave_1" value="N">
                                    </td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </span>
            </div>
            
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
                <script type="text/javascript">ComSheetObject('sheet3');</script>
                <span class="grid_option_left"> 
                    <div class="grid_option_left">
                        <br/>
                        <table>
                            <colgroup>
                                <col width="110"/>
                                <col width="50"/>
                                <col width="305"/>
                                <col width="130"/>
                                <col width="130"/>
                                <col width="" />
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th><h3 class="title_design">Verify Error : </h3></th>
                                    <td>
                                        <input type="text"  class="input2" style="width:45px;valign:bottom;"  name="verify_result_2" value="0" readonly>
                                    </td>
                                    <td>
                                        <input type="text"  class="input2" style="width:304;valign:bottom;font-color:red;"  name="verify_result_str_2" value="( UPDATE DISABLE! )" readonly>
                                    </td>
                                    
                                    <th>Updated Row Count : </th>
                                    <td>
                                        <input type="text"  class="input2" style="width:45px;valign:bottom;"  name="updated_rows_cnt_2" value="0" readonly>/&nbsp;<!--
                                          --><input type="text"  class="input2" style="width:45px;valign:bottom;"  name="total_rows_cnt_2" value="0" readonly><!--
                                          --><input type="hidden" name="verify_check_yn_2"    value="N"><!--
                                          --><input type="hidden" name="message_2"><!--
                                          --><input type="hidden" name="nosave_2" value="N">
                                    </td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </span>
            </div>
            
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
                <script type="text/javascript">ComSheetObject('sheet4');</script>
                <div class="grid_option_left">
                    <br/>
                    <table>
                        <colgroup>
                            <col width="110"/>
                            <col width="50"/>
                            <col width="305"/>
                            <col width="130"/>
                            <col width="130"/>
                            <col width="" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <th><h3 class="title_design">Verify Error : </h3></th>
                                <td>
                                    <input type="text"  class="input2" style="width:45px;valign:bottom;"  name="verify_result_3" value="0" readonly>
                                </td>
                                <td>
                                    <input type="text"  class="input2" style="width:304;valign:bottom;font-color:red;"  name="verify_result_str_3" value="( UPDATE DISABLE! )" readonly>
                                </td>
                                
                                <th>Updated Row Count : </th>
                                <td>
                                    <input type="text"  class="input2" style="width:45px;valign:bottom;"  name="updated_rows_cnt_3" value="0" readonly>&nbsp;/&nbsp;
                                       <input type="text"  class="input2" style="width:45px;valign:bottom;"  name="total_rows_cnt_3" value="0" readonly>
                                       <input type="hidden" name="verify_check_yn_3"    value="N">
                                       <input type="hidden" name="message_3">
                                       <input type="hidden" name="nosave_3" value="N">
                                </td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
                    
            <div class="layout_flex_flex" style="padding-left:550px">
                <!-- receive return data and deliver main Sheet for Verify -->
                <div class="opus_design_grid" style="width:360px;">
                <script type="text/javascript">ComSheetObject('sheet5');</script>
                </div>
                <!-- receive return data and deliver main Sheet for Verify -->
            </div>
        </div>
    </div>
    <div class="header_fixed"></div>
</form>
