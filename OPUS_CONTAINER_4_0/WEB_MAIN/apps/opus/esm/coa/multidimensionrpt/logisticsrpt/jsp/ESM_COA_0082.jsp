<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0082.jsp
*@FileTitle  : Logistics Exp. by Node & Link
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0082Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsmCoa0082Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;             //Error from server
    String strErrMsg = "";                          //Error message
    Logger log = Logger.getLogger("com.clt.apps.multidimensionrpt.logisticsrpt");
    try {
        event = (EsmCoa0082Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage();
        
    }
</script>
<div style="height:0px">
<iframe height="0" width="0" name="frmHidden"></iframe>
</div>
<form name="form" method="post"  onKeyDown="keyEnterTmlTrs();">
<input  type="hidden" name="f_cmd" id="f_cmd">
<input  type="hidden" name="iPage" id="iPage">
<input  type="hidden" name="f_report" value="1" id="f_report">

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down Excel</button>
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

<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
             <colgroup>
                <col width="110" />
                <col width="70"  />
                <col width="200" />
                <col width="111" />
                <col width="250" />
                <col width="95"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Period</td>
                    <td colspan="5">
                        <script type="text/javascript">coaPeriod1("1","");</script>
                    </td>
                    <td>
                        <strong><label for="f_split_mw">Split by Month / Week</label><!--</strong>
                        --><input type="checkbox" name="f_split_mw" id="f_split_mw" value="T" class="trans" onClick="viewMonWeek();">
                    </td>
                </tr>
                <tr><td colspan="7" class="line_bluedot"></td></tr>                
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Trade/Lane</td>
                    <th>Trade</th>
                    <td><script type="text/javascript">ComComboObject('f_trd_cd',1, 100 , 0 )</script></td>
                    <th>Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_rlane_cd',1, 100 , 0 )</script></td>
                    <th>Direction</th>
                    <td><script type="text/javascript">ComComboObject('f_skd_dir_cd',1, 70 , 0 )</script></td>
                </tr>
                <tr><td colspan="7" class="line_bluedot"></td></tr>                  
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Organization</td>
                    <tH>RHQ</tH>
                    <td><script type="text/javascript">ComComboObject('f_rhq_cd',1, 100 , 0 )</script></td>
                    <tH>Control Office</tH>
                    <td colspan="3"><script type="text/javascript">ComComboObject('f_ctrl_ofc_cd',1, 100 , 0 )</script></td>
                </tr>
                <tr><td colspan="7" class="line_bluedot"></td></tr>                  
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Activities</td>
                    <th>Cost Group</th>
                    <td><script type="text/javascript">ComComboObject('f_lgs_kpi_cost_grp_cd',1, 100 , 0 )</script></td>
                    <th>In/Out</th>
                    <td><script type="text/javascript">ComComboObject('f_in_out',1, 100 , 0 )</script></td>
                    <th>Logistics KPI</th>
                    <td>
                        <div id="div_kpi">
                            <script type="text/javascript">ComComboObject('f_lgs_kpi_cd',1, 120 , 0 )</script>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <th>
                        <span id="div_tm_nod_title" style="display:inline">Node</span>
                        <span id="div_tr_route_title" style="display:none">Route N1st</span>
                    </th>
                    <td><input type="text" style="width:100px;" name="f_nod_cd" maxlength="7"  dataformat="engup" onKeyPress="onlyEngNumber();"></td>
                    <td colspan="4">
                        <span id="div_tr_nod_to" style="display:inline"></span>
                        <span id="div_tr_route_to" style="display:none">
                            N2nd<!--
                            --><input type="text" style="width:60px;" name="f_nod_cd2" maxlength="7" onKeyPress="onlyEngNumber();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
                            -->N3rd<!--
                            --><input type="text" style="width:60px;" name="f_nod_cd3" maxlength="7" onKeyPress="onlyEngNumber();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
                            -->N4th<!--
                            --><input type="text" style="width:60px;" name="f_nod_cd4" maxlength="7" onKeyPress="onlyEngNumber();">
                        </span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2">
                        <strong><label for="f_islane_display">Display Trade / Lane</label></strong><!--
                        --><input type="checkbox" name="f_islane_display" id="f_islane_display" value="1" class="trans">
                    </td>
                    <td colspan="2">
                        <strong><label for="f_istpsz_display">Display Type/Size</label></strong><!--
                        --><input type="checkbox" name="f_istpsz_display" id="f_istpsz_display" value="1" class="trans">
                    </td>
                    <td colspan="2">
                        <strong><label for="f_isnode_display">Display Node</label></strong><!--
                        --><input type="checkbox" name="f_isnode_display" id="f_isnode_display" value="1" class="trans">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="6">
                        <strong><label for="f_incld_mt">Including Empty Pick-up/Return</label></strong><!--
                        --><input type="checkbox" name="f_incld_mt" id="f_incld_mt" value="T" unchecked class="trans">
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
        <div class="opus_design_btn" align="right"  style="margin-bottom:4px;">
            <div id="div_zoom_in" style="display:inline">
                <button type="button" class="btn_down mar_left_4" name="bu_Zoom_in" id="bu_Zoom_in" title="Zoom in(+)"></button>
            </div>
            <div id="div_zoom_out" style="display:none">
            	<button type="button" class="btn_down mar_left_4" name="bu_Zoom_out" id="bu_Zoom_out" title="Zoom out(-)"></button>
            </div>
        </div>

        <div id="div_tmnl" style="display:inline">
            <script type="text/javascript">ComSheetObject('sheet1');</script> 
        </div>
        <div id="div_trans" style="display:none">
            <script type="text/javascript">ComSheetObject('sheet2');</script> 
        </div>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
