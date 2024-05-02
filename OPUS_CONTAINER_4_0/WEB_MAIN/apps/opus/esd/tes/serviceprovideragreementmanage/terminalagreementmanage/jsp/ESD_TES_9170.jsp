<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9170.jsp
*@FileTitle  : Agreement Storage Rate List Excel Load
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9170Event"%>


<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("vol_ut_cd", "01", "CD00177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_code", "01", "CD00890", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("tml_sto_agmt_tp_code", "01", "CD00169", 0, "")%>
    function setupPage(){
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="lgsCostCDSheet" id="lgsCostCDSheet" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Storage Rate Excel Upload</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_loadexcel" 		id="btn_loadexcel">Load Excel</button>
		<button type="button" class="btn_normal" name="btn_verify" 			id="btn_verify">Verify</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->	
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- <button type="button" class="btn_accent" name="btn_loadexcel" 		id="btn_loadexcel">Load Excel</button> -->
		</div>
		<!-- opus_design_btn(E) -->		
		<script type="text/javascript">ComSheetObject('sheet');</script>		
	</div>
	<!-- opus_design_grid(E) -->	
	
</div>
<!-- opus_design_grid(S) -->
<div style="display:none">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
	<!-- opus_design_grid(E) -->
</form>