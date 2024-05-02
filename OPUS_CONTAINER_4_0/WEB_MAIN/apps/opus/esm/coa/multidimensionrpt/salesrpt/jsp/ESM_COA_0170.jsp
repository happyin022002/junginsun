<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0170.jsp
*@FileTitle  : RMK POPUP
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException = null;
    String strErrMsg = "";
    
    String f_bkg_no = "";
    String f_pro_vw = "";
    String f_pro_lvl = "";
    String f_cost_yrmon = "";
    String f_rout_no = "";
    String f_cntr_tpsz_cd = "";		//SJH.20140904.ADD
    String f_type_cd = "";			//SJH.20141027.ADD
    
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.multidimensionrpt.sales.jsp.ESM_COA_0170");
    try {
        f_bkg_no = JSPUtil.getNull(request.getParameter("f_bkg_no"));
        f_pro_vw =  JSPUtil.getNull(request.getParameter("f_pro_vw"));
        f_pro_lvl =  JSPUtil.getNull(request.getParameter("f_pro_lvl"));
        f_cost_yrmon =  JSPUtil.getNull(request.getParameter("f_cost_yrmon"));
        f_rout_no =  JSPUtil.getNull(request.getParameter("f_rout_no"));
        f_cntr_tpsz_cd =  JSPUtil.getNull(request.getParameter("f_cntr_tpsz_cd"));	//SJH.20140904.ADD
        f_type_cd =  JSPUtil.getNull(request.getParameter("f_type_cd"));			//SJH.20141027.ADD
        
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } //end of if
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<!-- <iframe height="0" width="0" name="frmHidden"></iframe> -->
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
        setRetrieveAction();
    }
</script>

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1">
<!--  Form value from the parent window -->
<input type="hidden" name="f_bkg_no" value="<%=f_bkg_no%>">
<input type="hidden" name="f_pro_vw" value="<%=f_pro_vw%>">
<input type="hidden" name="f_pro_lvl" value="<%=f_pro_lvl%>">
<input type="hidden" name="f_cost_yrmon" value="<%=f_cost_yrmon%>">
<input type="hidden" name="f_rout_no" value="<%=f_rout_no%>">
<input type="text" name="f_cntr_tpsz_cd" value="<%=f_cntr_tpsz_cd%>">	<!-- SJH.20140904.ADD -->
<input type="text" name="f_type_cd" value="<%=f_type_cd%>">			<!-- SJH.20141027.ADD -->

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>Inquiry by BKG Remark.</span></h2>
        <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btng_Downexcel" id="btng_Downexcel">Down Excel</button><!--
            --><button type="button" class="btn_normal" name="btng_Close" id="btng_Close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 

        <!-- page_location(S) -->
        <div class="location">
            <span id="navigation"></span>
        </div>
        <!-- page_location(E) -->
    </div>
<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <h3 class="title_design">Cost Remark Inquiry</h3>
       <div class="opus_design_btn" style="margin-bottom:3px">
            <div id="div_zoom_in1" style="display:inline">
                <button type="button" class="btn_up" name="bu_zoom_in1" id="bu_zoom_in1" title ="Zoom in(+)"></button>
                <!--<img class="cursor" src="/opuscntr/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">-->
            </div>
            <div id="div_zoom_out1" style="display:none">
                <button type="button" class="btn_down" name="bu_zoom_out1" id="bu_zoom_out1" title ="Zoom out(-)"></button>
                <!--<img class="cursor" src="/opuscntr/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">-->
            </div>
        </div>
        <div id="mainTable">
            <script language="javascript">ComSheetObject('sheet1');</script>
        </div>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</div>
<!-- popup_contens_area(E) -->

</form>
