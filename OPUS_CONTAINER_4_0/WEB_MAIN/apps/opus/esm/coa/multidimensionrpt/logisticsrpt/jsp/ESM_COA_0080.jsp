<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0080.jsp
*@FileTitle  : Logistics Exp. by Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0080Event"%>

<%
    EsmCoa0080Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;             //Error from server
    String strErrMsg = "";                          //Error message

    Logger log = Logger.getLogger("com.clt.apps.multidimensionrpt.logisticsrpt");

    try {
        event = (EsmCoa0080Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
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
        document.form.f_year.focus();
    }
</script>
<div style="margin-bottom:0px">
<iframename="frmHidden"></iframe>
</div>
<form method="post" name="form"  onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name="s_trd_cd">
<input type="hidden" name="s_rlane_cd">
<input type="hidden" name="s_skd_dir_cd">
<input type="hidden" name="s_load">
<input type="hidden" name="param9">
<input type="hidden" name="s_cost_yrmon2">
<input type="hidden" name="s_cost_wk2">
<!-- input type="hidden" name="f_split_MW" -->

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
    <div class="opus_design_inquiry wFit">
        <table>
             <colgroup>
                <col width="70"  />
                <col width="60"  />
                <col width="110" />
                <col width="90"  />
                <col width="140" />
                <col width="90"  />
                <col width="200" />
                <col width="60"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="7" height="9" border="0">Period</td>
                    <td colspan="7">
                        <script type="text/javascript">coaPeriod1("1","");</script>
                    </td>
                    <td>
                        <label for="f_split_mw"><strong>Split by Month / Week</strong></label><!--
                        --><input type="checkbox" name="f_split_mw" id="f_split_mw" value="T" checked class="trans" onClick="viewMonWeek();">
                    </td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="7" height="9" border="0">Trade / Lane</td>
                    <th>Report</th>
                    <td><script type="text/javascript">ComComboObject('f_report',1, 70 , 0 )</script></td>
                    <th>Trade</th>
                    <td><script type="text/javascript">ComComboObject('f_trd_cd',1, 100 , 0 )</script></td>
                    <th>Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script></td>
                    <th>Direction</th>
                    <td><script type="text/javascript">ComComboObject('f_skd_dir_cd',1, 100 , 0 )</script></td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="7" height="9" border="0">Activities</td>
                    <td colspan="2">
                        <label for="f_kpi_type1">&nbsp;&nbsp;&nbsp;&nbsp;<strong>KPI1</strong></label><!--
                        --><input type="radio" class="trans" name = "f_kpi_type" id = "f_kpi_type1" value="1" onClick="changeKpiType('1')" checked><!--
                        --><label for="f_kpi_type2"><strong>KPI2</strong></label><!--
                        --><input type="radio" class="trans" name = "f_kpi_type" id = "f_kpi_type2" value="2" onClick="changeKpiType('2')">
                    </td>
                    <th>Logistics KPI</th>
                    <td id="div_mnKpi" style="display:inline">
                        <script type="text/javascript">ComComboObject('f_lgs_mn_kpi_cd',1, 100 , 0 )</script>
                    </td>
                    <td id = "div_lgsKpi" style="display:none">
                        <script type="text/javascript">ComComboObject('f_lgs_kpi_cd',1, 100 , 0 )</script>
                    </td>
                    <td colspan="4">
                        <label for="f_incld_mt"><strong>Including Empty Pick-up/Return</strong></label><!--
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
        <div class="opus_design_inquiry" style="text-align:right;">
            <button type="button" class="btn_etc" name="btng_Detail" id="btng_Detail">Detail</button>
			<div class="opus_design_btn" id="div_zoom_in1" style="display:inline">
				<button type="button" class="btn_down mar_left_4" id="bu_zoom_in1" name="bu_zoom_in1" title="Zoom In (+)"></button>
			</div>
			<div class="opus_design_btn" id="div_zoom_out1" style="display:none">
				<button type="button" class="btn_up mar_left_4" id="bu_zoom_out1" name="bu_zoom_out1" title="Zoom In (-)"></button>
			</div>
        </div>
        <!-- opus_design_btn(E) -->

        <script type="text/javascript">ComSheetObject('sheet1');</script> 
    </div>
    <!-- opus_design_grid(E) -->

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable2">
    	<div class="opus_design_btn" style="text-align:right; margin-bottom:4px;">
			<div class="opus_design_btn" id="div_zoom_in2" style="display:inline">
				<button type="button" class="btn_down mar_left_4" id="bu_zoom_in2" name="bu_zoom_in2" title="Zoom In (+)"></button>
			</div>
			<div class="opus_design_btn" id="div_zoom_out2" style="display:none">
				<button type="button" class="btn_up mar_left_4" id="bu_zoom_out2" name="bu_zoom_out2" title="Zoom In (-)"></button>
			</div>
        </div>
        <script type="text/javascript">ComSheetObject('sheet2');</script> 
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
