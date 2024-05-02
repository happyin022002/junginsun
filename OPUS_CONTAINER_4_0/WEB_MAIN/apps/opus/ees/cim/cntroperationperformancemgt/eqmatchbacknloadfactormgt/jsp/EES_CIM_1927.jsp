<%
/*=========================================================
*right(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1927.jsp
*@FileTitle  : Location M/B by BKG-Wise
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EES_CIM_1027HTMLAction"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1027Event"%>

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
		<h2 class="page_title"><span>Location M/B by BKG-Wise</span></h2>
		
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

