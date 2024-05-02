<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9130.jsp
*@FileTitle  : On-dock Rail Charge Invoice Save & Confirm - Coincidence 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9130Event"%>
<%
	String wrk_dt = JSPUtil.getNull(request.getParameter("wrk_dt"));
	String min_wrk_dt = JSPUtil.getNull(request.getParameter("min_wrk_dt"));
	String cost_cd_ftr_rmk = JSPUtil.getNull(request.getParameter("cost_cd_ftr_rmk")); //2016.09.09 AGMT COST CD Add
%>


<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="rcv_dt" id="rcv_dt" />
<input type="hidden" name="verify_chk" id="verify_chk" />
<input type="hidden" name="excel_chk" id="excel_chk" />
<input type="hidden" name="tml_so_ofc_cty_cd" id="tml_so_ofc_cty_cd" />
<input type="hidden" name="tml_so_seq" id="tml_so_seq" />
<input type="hidden" name="io_bnd_cd" id="io_bnd_cd" />
<input type="hidden" name="max_wrk_dt" id="max_wrk_dt" />
<input type="hidden" name="min_wrk_dt" id="min_wrk_dt" />
<input type="hidden" name="wrk_dt" id="wrk_dt"  value="<%=wrk_dt %>" />
<input type="hidden" name="min_wrk_dt" id="min_wrk_dt"  value="<%=min_wrk_dt %>" />
<input type="hidden" name="cost_cd_ftr_rmk" id="cost_cd_ftr_rmk"  value="<%=cost_cd_ftr_rmk %>" /><!-- 2016.09.09 AGMT COST CD Add -->

<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="tmp_cntr_tpsz_cd" id="tmp_cntr_tpsz_cd" />
<input type="hidden" name="row" id="row" />

<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>File Import</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_verify" id="btn_verify">Verify</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_loadexcel" 	id="btn_loadexcel">Load Excel</button><!--
				--><button type="button"  class="btn_normal"  name="btn_rowdel" id="btn_rowdel">Delete</button>
				<button type="button" class="btn_normal" name="btn_sampleExecl" id="btn_sampleExecl">Sample Excel</button>
					
				</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
<div id="hidden_sheets" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet_hidden');</script>
</div>