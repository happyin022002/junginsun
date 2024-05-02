<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0876.jsp
*@FileTitle  : NIS vs Portnet Reconciliation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;OPUS vs Portnet Reconciliation Print</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
	</div>
</div>
<!-- layer_popup_contents(S) -->
