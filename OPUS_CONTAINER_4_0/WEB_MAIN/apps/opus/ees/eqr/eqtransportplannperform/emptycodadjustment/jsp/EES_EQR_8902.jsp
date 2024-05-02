<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_8902.js
*@FileTitle  : MTY Repo Inquiry by Period
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EES_EQR_8002HTMLAction"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr8002Event"%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    function setupPage(){
        loadPage();     
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

    <!-- page_title(S) -->
    <h2 class="page_title"><span>MTY Repo Inquiry by Period</span></h2>
    <!-- page_title(E) -->
    
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btng_print"   id="btng_print">Print</button><!--
        --><button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
    </div>
    <!-- opus_design_btn(E) -->
    
</div>
<!-- page_title_area(E) -->

<div style="height:100%;">  
    <!-- opus_design_btn(E) -->     
    <script type="text/javascript">rdViewerObject();</script>       
</div>
</form>