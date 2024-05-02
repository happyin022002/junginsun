<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0040.jsp
*@FileTitle  : Port Tariff
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%> 
<%
    Exception serverException   = null;             //Error from server
    String strErrMsg    = "";                       //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0040");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }

</script>

<form method="post" name="form" onKeyDown="ComKeyEnter();" id="form">
<input  type="hidden" name="f_cmd">

<input type="hidden" name="cost_yrmon">
<input type="hidden" name="locl_curr_cd">
<input type="hidden" name="locl_port_amt">
<input type="hidden" name="locl_cnl_amt">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
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
        --><button type="button" class="btn_normal" name="btn_Create"   id="btn_Create">Create</button><!--
        --><!--  <button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button>--><!--
        --><button type="button" class="btn_normal" name="btn_Copy"   id="btn_Copy">Interface to COA</button><!-- SJH.20150206.ADD
        --><button type="button" class="btn_normal" name="btn_Downexcel"   id="btn_Downexcel">Down Excel</button><!--
        --><!-- <button type="button" class="btn_normal" name="btn_loadexcel"   id="btn_loadexcel">Load Excel</button> -->
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
            <tr>
                <td><script type="text/javascript">coaPeriod2("1");</script></td>	<!-- SJH.20150107.ADD -->
            </tr>
        </table>    
        <table>
             <colgroup>
                <col width="80"  />
                <col width="150"  />
                <col width="80"  />
                <col width="150"  />
                <col width="50"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Service Lane</th>
                    <td><script language="javascript">ComComboObject('f_selslane',1, 110 , 0 )</script></td>
                    <th>Vessel Class</th>
                    <td><script language="javascript">ComComboObject('f_selrlane',1, 110 , 0 )</script></td>
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td>
	                    <input type="text" name="f_vsl_cd" id="f_vsl_cd" style="width:70px;text-align:center;" maxlength="4" dataformat="engup" onClick="ComAddSeparator(this);"  onKeyUp="ComKeyEnter('f_skd_voy_no');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);">
                        <input type="text" name="f_skd_voy_no" id="f_skd_voy_no" style="width:70px;text-align:center;" maxlength="4" dataformat="num" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_dir_cd');" onkeyPress="ComKeyOnlyNumber(window);" onFocus="this.select();" >
                        <input type="text" name="f_dir_cd" id="f_dir_cd" style="width:30px;text-align:center;" maxlength="1" dataformat="engup" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_year');" onKeyPress="ComKeyOnlyAlphabet('upper');" onFocus="this.select();" onBlur="upper(this);">
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
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn mar_btm_4">
            <div id="div_zoom_in"  style="position:relative; right:0px; top:0px; display:inline"> <!-- absolute / relative -->
                <button type="button" class="btn_down mar_left_4" id="btn_zoom_in" name="bu_zoom_in" title="Alt+↑" onclick="toggleSheetSize('zoomarea0','zoomarea1');" sheetId="sheet1"></button>
                <!--<img class="cursor" src="/opuscntr/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" id="bu_zoom_in" alt="Zoom in(+)">-->
            </div>
            <div id="div_zoom_out" style="position:relative; right:0px; top:0px; display:none">
                <button type="button" class="btn_up mar_left_4" id="btn_zoom_out" name="bu_zoom_out" title="Alt+↑" onclick="toggleSheetSize('zoomarea0','zoomarea1');" sheetId="sheet1"></button>
                <!--<img class="cursor" src="/opuscntr/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" id="bu_zoom_out" alt="Zoom out(-)">-->
            </div>
        </div>
        <!-- opus_design_btn(E) -->

        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
  
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
             <colgroup>
                <col width="50"  />
                <col width="150"  />
                <col width="80"  />
                <col width="100" />
                <col width="*" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>
                        <label for="f_yrtype1">VVD</label>
                    </th>
                    <td><input type="hidden" size="3" name="f_slan_cd2" maxlength="3" style="ime-mode:disabled; text-align:center;" readonly><!-- SJH.20150108.ADD -->
						<input type="text" size="4" name="f_vsl_cd2" maxlength="4" style="ime-mode:disabled; text-align:center;" readonly><!-- 
	                     --><input type="text" size="4" name="f_skd_voy_no2" maxlength="4" style="ime-mode:disabled; text-align:center;" readonly><!--
	                     --><input type="text" size="1" name="f_dir_cd2"  maxlength="1" style="ime-mode:disabled; text-align:center;" readonly>
				    </td>
				    <th>
                        <label for="f_yrtype1">Cre. Req DT</label>
                    </th>
                    <td>
						<input type="text" name="f_rqst_dt" style='text-align:center;' readonly></input>
				    </td>
                    <td align="right">
                     	<!-- opus_delsign_btn(S) -->
                     	<div class="opus_design_grid" style="margin-bottom:-10px">
				        <div class="opus_design_btn">
				            <button type="button" class="btn_normal" name="btng_Save" id="btng_Save">Save</button>
				        </div>
				        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">

        <script language="javascript">ComSheetObject('sheet2');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>