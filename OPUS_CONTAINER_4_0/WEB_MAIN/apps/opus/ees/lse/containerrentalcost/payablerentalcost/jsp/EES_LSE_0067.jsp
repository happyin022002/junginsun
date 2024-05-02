<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0067.jsp
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.25 진준성
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0067Event"%>
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
        <h2 class="page_title"><span>EQ Payable Charge Summary  </span></h2>
        
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button><!-- 
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
    </div>
</div>


<div class="layer_popup_contents">
        
        <div class="wrap_result">
            <div class="opus_design_RD"> 
                <script language="javascript">rdViewerObject();</script>
            </div>
        </div>
    </div>
<!-- popup_contens_area(E) -->

</form>