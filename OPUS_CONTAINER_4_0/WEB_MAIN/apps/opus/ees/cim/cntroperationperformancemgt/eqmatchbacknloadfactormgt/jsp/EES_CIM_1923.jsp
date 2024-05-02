<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1923.jsp
*@FileTitle : TMNL M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EES_CIM_1023HTMLAction"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1023Event"%>

<html>
<head>
<title>TMNL M/B by Logistics-Wise</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    function setupPage(){
        loadPage();     
    }
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 

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
    <h3 class="title_design">TMNL M/B by Logistics-Wise</h3>
        <div class="opus_design_RD"> 
            <script language="javascript">rdViewerObject();</script>
        </div>
    </div>
</div>

</form>
</body>
</html>

