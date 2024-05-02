<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_5029.jsp
*@FileTitle : Discharging Cargo Declaration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.04.24 박상훈
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;Sea Export Cargo Manifest Print</span></h2>
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
