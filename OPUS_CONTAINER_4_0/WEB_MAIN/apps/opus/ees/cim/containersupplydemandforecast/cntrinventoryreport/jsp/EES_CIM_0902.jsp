<%--
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0902.jsp
*@FileTitle  : EQ Operation Trend (Inventory Trend) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================
*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EES_CIM_0001HTMLAction"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0002Event"%>

<%
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    function setupPage(){
        loadPage();     
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />

<div class="layer_popup_title">
    <div class="page_title_area clear">
        <h2 class="page_title"><span>Total Inventory</span></h2>
        
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
    </div>
</div>

<div class="layer_popup_contents">
    <div class="wrap_result" style="height:100%">
    <h3 class="title_design">Total Inventory</h3>
        <div class="opus_design_RD"> 
            <script language="javascript">rdViewerObject();</script>
        </div>
    </div>
</div>
</form>