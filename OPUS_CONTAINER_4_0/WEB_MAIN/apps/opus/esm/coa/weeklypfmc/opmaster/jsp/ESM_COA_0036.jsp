<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0036.jsp
*@FileTitle  : Create lane table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;                 //Error from server
    String strErrMsg    = "";                           //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0036");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("ESM_COA_0036 Exception : " + e.toString());
    }
%>
<script type="text/javascript">
    function setupPage(){
        var errMessage  = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form method="post" name="form" id="form">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">


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
                <col width="40" />
                <col width="100" />
                <col width="40" />
                <col width="100" />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Trade</th>
                    <td><script type="text/javascript">ComComboObject('f_cbotrade',1, 80 , 0 )</script></td>
                    <th>S.Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_cboslane',1, 80 , 0 )</script></td>
                    <td><input type="checkbox" name="f_chkdel" id="f_chkdel" value="Y" class="trans"><label for="f_chkdel">Deleted Data</label></td>
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
    <div class="opus_design_grid"  >
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_Rowadd" id="btn_Rowadd">Row Add</button>

            <div id="div_zoom_in" style="display:inline" title="asdas"> <!-- absolute / relative -->
            	<button class="btn_down mar_left_4" type="button" name="bu_zoom_in" id="bu_zoom_in" title="Zoom in(+)"></button>
            </div>
            <div id="div_zoom_out" style="display:none">
                <button class="btn_up mar_left_4" type="button" name="bu_zoom_out" id="bu_zoom_out" title="Zoom out(-)"></button>
            </div>
        </div>
        <!-- opus_design_btn(E) -->
        
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
