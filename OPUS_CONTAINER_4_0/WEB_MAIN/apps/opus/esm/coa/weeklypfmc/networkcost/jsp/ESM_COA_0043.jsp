<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0043.jsp
*@FileTitle  : AVG-hire by Own-VSL
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
    Exception serverException = null;   //Error from server
    String strErrMsg = "";              //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0043");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_header">


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
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
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
                <col width="80" />
                <col width="75"  />
                <col width="220" />
                <col width="50"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td>
                        <label for="f_yrtype1">YYYY-MM</label>
                        <div style="display:none;">
                        <!--
                        --><input type="radio" name="f_yrtype" id="f_yrtype1" class="trans" value="yrmon" onClick="setYrMon()" checked><!--
                        --><label for="f_yrtype2">YYYY-WW</label><!--
                        --><input type="radio" name="f_yrtype" id="f_yrtype2" class="trans" value="yrwk">
                        </div>
                    </td>
                    <td><input type="text" style="width:60px" class="input1" name="f_yearweek" id="f_yearweek" dataformat="ym" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td>
                    <td><div id="div_period"></div></td>
                    <th>Vessel</th>
                    <td><script type="text/javascript">ComComboObject('f_selvessel',1, 80 , 0 )</script></td>
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
        
        <!--
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
        </div>
        -->
        
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
