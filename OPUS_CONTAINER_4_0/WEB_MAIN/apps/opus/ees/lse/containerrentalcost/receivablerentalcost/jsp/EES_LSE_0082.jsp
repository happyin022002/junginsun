<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0082.jsp
*@FileTitle  : EQ Receivable Charge Summary by Charge Type & TY/SZ
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0082Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    function setupPage(){
        loadPage();     
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 

<div class="layer_popup_title">
    <div class="page_title_area clear">
        <h2 class="page_title"><span>EQ Receivable Charge Summary</span></h2>
        
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
    </div>
</div>

<div class="layer_popup_contents">
    <div class="wrap_search">
        
    </div>
    
    <div class="wrap_result">
        <div class="opus_design_RD"> 
            <script language="javascript">rdViewerObject();</script>
        </div>
    </div>
</div>

</form>
