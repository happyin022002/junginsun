<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1090.jsp
*@FileTitle  : General Inventory(Print)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1089Event"%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    function setupPage(){
        loadPage();     
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>General Inventory Inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button><!--  
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->
</div>
<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
<!-- opus_design_inquiry(E) -->
</form>
