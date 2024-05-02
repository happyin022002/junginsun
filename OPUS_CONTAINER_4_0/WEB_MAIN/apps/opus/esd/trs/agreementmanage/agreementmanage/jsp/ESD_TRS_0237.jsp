<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESD_TRS_0237.jsp
*@FileTitle      : Common Surcharge Management
*Open Issues     : 
*Change history  : 
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%

    Exception serverException = null;
    String strErrMsg = "";
    String userId    = "";
    String ofcCd     = "";

    String optionStr  = "000020:ALL:ALL";
    String optionStr2 = "000020::";
    String optionStr3 = "000020:AL:AL";

    // Combo Objects Settings
    String selTrsComScgKnd = "";
    String selAgmtTrspTpCd = "";
    String selBndCd        = "";

    selTrsComScgKnd  = JSPUtil.replace(JSPUtil.getCodeCombo("com_scg_knd_cd",  "01", "style='width:210;'", "CD30002", 0, optionStr),"&","&amp;");
    selAgmtTrspTpCd  = JSPUtil.getCodeCombo("agmt_trsp_tp_cd", "01", "style='width:98;'",  "CD00283", 0, optionStr);
    selBndCd         = JSPUtil.getCodeCombo("bnd_cd",          "01", "style='width:98;'",  "CD02362", 0, optionStr);  // CD02362, CD02997

    try
    {
        SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId                    = account.getUsr_id();
        ofcCd                     = account.getOfc_cd();

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }
    catch(Exception e)
    {
        out.println(e.toString());
    }

    String today = DateTime.getFormatString("yyyy-MM-dd");

%>
<script type="text/javascript">

<%=JSPUtil.getIBCodeCombo("com_scg_knd_cd",  "", "CD30002", 0, "")%>
<%=JSPUtil.getIBCodeCombo("agmt_trsp_tp_cd", "", "CD00283", 0, "")%>
<%=JSPUtil.getIBCodeCombo("eq_knd_cd",       "", "CD01132", 0, "")%>
<%=JSPUtil.getIBCodeCombo("eq_tp_cd",        "", "CD02544", 0, "")%>
<%=JSPUtil.getIBCodeCombo("cgo_tp_cd",       "", "CD00748", 0, "")%>
<%=JSPUtil.getIBCodeCombo("bnd_cd",          "", "CD02362", 0, "")%>
<%=JSPUtil.getIBCodeCombo("rt_tp_cd",        "", "CD01937", 0, "")%>
<%=BizComUtil.getIBCodeCombo("curr_cd",         "", "CURR", 2, "")%>

function setupPage()
{
    loadPage();
}

</script>

<form method = "post" name = "form" onsubmit = "return false;">

<input type = "hidden" id = "account_ofc_cd"     name = "account_ofc_cd"     value = "<%=ofcCd%>">
<input type = "hidden" id = "account_usr_id"     name = "account_usr_id"     value = "<%=userId%>">
<input type = "hidden" id = "f_cmd"              name = "f_cmd">
<input type = "hidden" id = "trsp_agmt_rt_tp_cd" name = "trsp_agmt_rt_tp_cd" value = "P"> 
<input type = "hidden" id = "header_row"         name = "header_row">
<input type = "hidden" id = "hid_today"          name = "hid_today"          value = "<%=today%>">



    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        
        <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->
    
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn"><!--
            --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
            --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>            
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
    <div class="opus_design_inquiry wFit" id="MiniLayer">
        <!--  MiniLayer (S) -->
        <table>
            <colgroup>                            
                <col width="55px" />
                <col width="30px" />
                <col width="30px" />
                <col width="55px" />
                <col width="30px" />
                <col width="30px" />
                <col width="55px" />
                <col width="30px" />
                <col width="30px" />
                <col width="120px" />
                <col width="70" />
                <col width="" />
            </colgroup>
        <tbody>
            <tr>
                <th colspan=2>Effective Date</th>
                <td colspan=2>
                    <input name = "dt_cond" id = "dt_all" type = "radio" value = "ALL" onclick="fun_dateChange('ALL')" checked><label for = "dt_all">ALL</label>
                    <input name = "dt_cond" id = "dt_eff" type = "radio" value = "EFF" onclick="fun_dateChange('EFF')"><label for = "dt_eff">DATE</label>
                </td>
                <td>
                <input id = "eff_dt" name = "eff_dt" type = "text" style = "width:80;" class = "input2" maxlength = "8" onFocus = "javascript:delHypen(this);" onBlur = "javascript:getHypen(this);" dataformat="ymd" disabled="disabled"><!--
                 --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir" disabled="disabled"></button>
                </td>
                <th>Surcharge Kind</th>
                <td colspan=2><%=selTrsComScgKnd%></td>
                <th>Cost Mode</th>
                <td>
                    <select id="trsp_cost_mod_cd" name="trsp_cost_mod_cd" style="width:98;">
                        <option value="ALL">ALL</option>
                        <option value="CY">CY</option>
                        <option value="DR">DR</option>
                    </select>
                </td>
                <th>Trans Mode</th>
                <td><%=selAgmtTrspTpCd%></td>
                <td></td>
            </tr>
            <tr>
                <th>RCC</th>
                <td colspan=2>
                	<script type="text/javascript">ComComboObject('rcc_cd', 1, 70, 1, 0);</script>
                </td>
                <th>LCC</th>
                <td colspan=1><!--
                    --><input id = "lcc_cd" name = "lcc_cd" type = "text" class = "input" style = "width:60;text-transform:uppercase;" onkeyup = "ComChkObjValid(this)" maxlength="5" dataformat="engup"><!--
                    --><button type = "button" class = "input_seach_btn" onclick = "openRccPopUp('LCC');"></button><!--
                --></td>
                <th>SCC</th>
                <td colspan=2><!--
                    --><input id = "scc_cd" name = "scc_cd" type = "text" class = "input" style = "width:61;text-transform:uppercase;" onkeyup = "ComChkObjValid(this)" maxlength="5" dataformat="engup"><!--
                    --><button type = "button" class = "input_seach_btn" onclick = "openRccPopUp('SCC');"></button><!--
                --></td>
                <th>Equipment Kind</th>
                <td colspan=2>
                   <input id = "btns_radio_eq" name = "btns_radio_eq" type = "radio" value = ""  class = "trans" onclick = "change_eq_val();checkDigit();" checked>ALL&nbsp;&nbsp;&nbsp;
                   <input id = "btns_radio_eq" name = "btns_radio_eq" type = "radio" value = "U" class = "trans" onclick = "change_eq_val();">Container&nbsp;&nbsp;&nbsp;
                   <input id = "btns_radio_eq" name = "btns_radio_eq" type = "radio" value = "Z" class = "trans" onclick = "change_eq_val();">Chassis&nbsp;&nbsp;&nbsp;
                   <input id = "btns_radio_eq" name = "btns_radio_eq" type = "radio" value = "G" class = "trans" onclick = "change_eq_val();">Genset&nbsp;
                   <input id = "eq_knd_cd"     name = "eq_knd_cd"     type = "hidden">
                </td>
            </tr>
            <tr>
                <th>Cargo</th>
                <td colspan=2>
                    <select id="cgo_tp_cd" name="cgo_tp_cd" style="width:98;" onchange = "change_cgo_tp();">
                        <option value="ALL">ALL</option>
                        <option value="F">FULL</option>
                        <option value="M">EMPTY</option>
                    </select>
                </td>
                <th>Bound</th>
                <td colspan=1><%=selBndCd%></td>
                <td></td>
                <td></td>
                <td></td>
                <th>EQ Type/Size</th>
                <td colspan=2><!--
                    --><select id="eq_tp_cd" name="eq_tp_cd" style="width:70;" onchange = "change_eq_tp();"></select><!--
                    --><select id="eq_sz_cd" name="eq_sz_cd" style="width:70;"></select><!--
                --></td>
            </tr>
            </tbody>
        </table>
    </div>
    </div>

    <div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" id="mainTable">
        <!-- opus_grid_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btng_row_add"     id="btng_row_add">Row Add</button>
            <button type="button" class="btn_normal" name="btng_row_delete"  id="btng_row_delete">Row Delete</button>
            <button type="button" class="btn_normal" name="btng_loadexcel"   id="btng_loadexcel">File Import</button>
            <button type="button" class="btn_normal" name="btng_downexcel"   id="btng_downexcel">Down Excel</button>
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
