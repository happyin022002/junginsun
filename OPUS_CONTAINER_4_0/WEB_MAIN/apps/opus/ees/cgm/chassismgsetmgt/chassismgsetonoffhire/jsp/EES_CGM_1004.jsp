<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1004.jsp
*@FileTitle  : Chassis Master Inquiry
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1003Event"%>


<%
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    function setupPage(){
        loadPage();     
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Chassis Master Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>