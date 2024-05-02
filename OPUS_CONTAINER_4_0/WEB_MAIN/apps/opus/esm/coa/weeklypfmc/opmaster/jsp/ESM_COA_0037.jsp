<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0037.jsp
*@FileTitle  : Create Vessel table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
    Exception serverException   = null;             //Error from server
    String strErrMsg    = "";                       //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0037");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form method="post" name="form" onKeyDown="ComKeyEnter();" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="f_header" id="f_header" />
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
        --><button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_Downexcel"   id="btn_Downexcel">Down Excel</button>
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
                <col width="1"  />
                <col width="60" />
                <col width="100" />
                <col width="*" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Vessel</th>
                    <td><input type="text" style="width:45px" name="f_vsl_cd"  id="f_vsl_cd" maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" dataformat="engup" ></td>
                    <th><input type="checkbox" name="f_chkdel" id="f_chkdel" value="Y" class="trans"><label for="f_chkdel">Deleted Data</label></th>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
    
<!-- wrap_result(S) -->
<div class="wrap_result">    
    <div class="opus_design_grid"  id="mainTable">
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_Rowadd" id="btn_Rowadd">Row Add</button><!-- 
             --><button type="button" class="btn_normal" name="btng_Crrinfo" id="btng_Crrinfo">Vessel Info.</button><!-- 
             --><button type="button" class="btn_normal" name="btn_SubTrade" id="btn_SubTrade">Sub Trade Info.</button>
         </div>
        <div class="opus_design_btn mar_btm_4" style="margin-right:-3px">
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
    
</div>
<!-- wrap_result(E) -->
</form>
