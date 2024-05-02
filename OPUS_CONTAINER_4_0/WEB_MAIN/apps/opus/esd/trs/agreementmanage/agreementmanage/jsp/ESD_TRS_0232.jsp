<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0232.jsp
*@FileTitle  : Agreement Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%
    Exception serverException     = null;
    String    strErrMsg           = "";
    String    userId              = "";
    String    ofcCd               = "";

    String    optionStr2          = "000020::";
    String    optionStr3          = "000020:A:";
    
    String    selCOSTMODE		  = ""; // Cost Mode Combo
    String    selTRANSMODE        = ""; // Trans Mode Combo
    String    selCARGOMODE        = ""; // Cargo Type Combo
    String    selRAILSVC          = ""; // Rail Service Combo

    selCOSTMODE					  = JSPUtil.getCodeCombo("fm_trsp_cost_mod_cd", "01", "style=width:120px", "CD02177", 0, optionStr3);
    selTRANSMODE                  = JSPUtil.getCodeCombo("fm_agmt_trsp_tp_cd", "01", "style=width:80px",     "CD00283", 0, optionStr2);
    selCARGOMODE                  = JSPUtil.getCodeCombo("fm_cgo_tp_cd",       "01", "style='width:98px;'",  "CD00748", 0, optionStr2);
    selRAILSVC                    = JSPUtil.getCodeCombo("fm_rail_svc_tp_cd",  "01", "style='width:120px;'", "CD00916", 1, optionStr2);

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

function setupPage()
{
    loadPage();
}

</script>

<form method="post" id="form" name="form" onSubmit="return false;">

<input type="hidden" id="fm_account_ofc_cd"          name="fm_account_ofc_cd"          value="<%=ofcCd%>" />
<input type="hidden" id="fm_account_usr_id"          name="fm_account_usr_id"          value="<%=userId%>" />
<input type="hidden" id="f_cmd"                      name="f_cmd" />
<input type="hidden" id="old_ofc_cd"                 name="old_ofc_cd" />
<input type="hidden" id="chk_agmt_no"                name="chk_agmt_no" />
<input type="hidden" id="chk_trsp_agmt_rt_tp_ser_no" name="chk_trsp_agmt_rt_tp_ser_no" />
<input type="hidden" id="chk_trsp_agmt_rt_tp_cd"     name="chk_trsp_agmt_rt_tp_cd" />
<input type="hidden" id="eq_knd_cd"                  name="eq_knd_cd" />

<!-- Pair Type set to always -->
<input type="hidden" id="fm_trsp_agmt_rt_tp_cd"      name="fm_trsp_agmt_rt_tp_cd"      value="P" />

        <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        
        <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->
    
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn"><!--
            --><button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button><!--
            --><button type="button" id="btn_reset"    name="btn_reset"    class="btn_normal">Reset</button><!--
            --><button type="button" id="btn_minimize" name="btn_minimize"  class="btn_normal">Minimize</button>            
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
    
    <div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div id="MiniLayer" class="opus_design_inquiry wFit">
        <!--  MiniLayer (S) -->
        <table>
            <colgroup>                            
                <col width="100" />
                <col width="130" />
                <col width="140" />
                <col width="100" />
                <col width="120" />
                <col width="90"  />
                <col width="100" />
                <col width="*"   />
            </colgroup>
            <tbody>
                <tr>
                    <th>Agreement No.</th>
                    <td><!--
                    --><input type="text" id="fm_agmtno" name="fm_agmtno" style="width:92px;" class="input1" value="" onKeyup="javascript:doSearchEnter();" dataformat="engup" /><!--
                    --><button type="button" id="btn_agmtno" name="btn_agmtno" class="input_seach_btn"></button><!--
                    --></td>
                    <th>Service Provider</th>
                    <td><!--
                    --><input type="text" id="fm_vndr_prmry_seq" name="fm_vndr_prmry_seq" style="width:80px;" class="input1" value="" onBlur="vender_blur();" dataformat="engup"><!--
                    --><input type="text" id="fm_vndr_prmry_nm" name="fm_vndr_prmry_nm" style="width:117px;" class="input" value="" readonly dataformat="engup"><!--
                    --><button type="button" id="btn_serviceprovider" name="btn_serviceprovider" class="input_seach_btn"></button><!--
                    --></td>
                    <th>Contract Office</th>
                    <td><!--
                    --><input type="text" id="fm_ctrt_ofc_cd" name="fm_ctrt_ofc_cd" style="width:98px;" class="input1" value="" dataformat="engup" maxlength="5"><!--
                    --></td>
                    <td><!--
                    --><input type="checkbox" id="chk_office" name="chk_office" value="" class="trans" onClick="javascript:getSubOffice();"><label for="chk_office">Incl. Sub OFC</label><!--
                    --></td>
                    <td></td>
                </tr>
                <tr>
                    <th>Effective AGMT</th>
                    <td>
                        <select id="fm_effective_agmt" name="fm_effective_agmt" style="width:120px;" class="input">
                            <option value="C">Current</option>
                            <option value="A" selected>ALL</option>
                        </select>
                    </td>
                    <th>Customer Nominated</th>
                    <td colspan="4"><!--
                        --><input type="text" id="fm_cust_cd" name="fm_cust_cd" style="width:80px;" class="input1" dataformat="engup"><!--
                        --><button type="button" id="btn_vndr_prmry_seq" name="btn_vndr_prmry_seq" class="input_seach_btn" onClick="vndr_OnPopupClick();"></button><!--
                    --></td>
                    <td></td>
                </tr>
                <tr>
                    <th>Cost Mode</th>
                    <td><%=selCOSTMODE%></td>
                    <!-- <td>
                   <select id="fm_trsp_cost_mod_cd" name="fm_trsp_cost_mod_cd" style="width:120px;" class="input">
                   <option value="A" selected>ALL</option>
                   <option value="DR">DR</option>
                   <option value="CY">CY</option>
                   <option value="BS">BS</option>
                   <option value="BF">BF</option>
                   <option value="MF">MF</option>
                   <option value="DC">DC</option>
                   <option value="MM">MM</option>
                   </select>
                   </td> -->
                    <th>Trans Mode</th>
                    <td><!--
                    --><%=selTRANSMODE%><!--
                    --></td>                    
                    <th>Cargo Type</th>
                    <td><!--
                    --><%=selCARGOMODE%><!--
                    --></td>
                    <td></td>
                </tr>
                <tr>
                    <th>Rail Service</th>
                    <td><!--
                    --><%=selRAILSVC%><!--
                    --></td>
                    <th>Commodity Group Code</th>
                    <td><!--
                    --><input type="text" id="fm_cmdt_grp_cd" name="fm_cmdt_grp_cd" style="width:80px;" class="input1" value="" dataformat="engup"><!--
                    --></td>
                    <th>Surcharge Kind</th>
                    <td><!--
                    --><select id="fm_trsp_scg_cd" name="fm_trsp_scg_cd" style="width:98px;" class="input"><!--
                    --><option value="A" selected>ALL</option><!--
                    --><option value="F">Fuel</option><!--
                    --></select><!--
                    --></td>                    
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    </div>
    
    <div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div id="mainTable" class="opus_design_grid">
        <!-- opus_grid_btn(S) -->
        <div class="opus_design_btn"><!--
        --><button type="button" id="btng_allrateinquiry"      name="btng_allrateinquiry"      class="btn_normal">Rate Inquiry By AGMT NO.</button><!--
        --><button type="button" id="btng_rateinquiry"         name="btng_rateinquiry"         class="btn_normal">Rate Inquiry</button><!--
        --><button type="button" id="btng_allsurchargeinquiry" name="btng_allsurchargeinquiry" class="btn_normal">Surcharge Inquiry By AGMT NO.</button><!--
        --><button type="button" id="btng_surchargeinquiry"    name="btng_surchargeinquiry"    class="btn_normal">Surcharge Inquiry</button><!--
        --><button type="button" id="btng_downexcel"           name="btng_downexcel"           class="btn_normal">Down Excel</button>
        </div>
        <!-- opus_grid_btn(E) -->
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet0');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->        
    </div>
    <!-- opus_design_grid(E) -->
    </div>
    <div class="header_fixed"></div>
</form>
