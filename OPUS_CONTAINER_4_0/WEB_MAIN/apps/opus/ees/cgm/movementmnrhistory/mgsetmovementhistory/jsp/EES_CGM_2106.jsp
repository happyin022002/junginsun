<%--
/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2106.jsp
*@FileTitle  : Movement Inquiry by Mgset
*@author     : CLT
*@version    : 1.0
*@since      : 2016/11/22
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event.EesCgm2105Event"%>


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
		<h2 class="page_title"><span>Movement Inquiry by Mgset</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button><!-- 
		 	--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>
