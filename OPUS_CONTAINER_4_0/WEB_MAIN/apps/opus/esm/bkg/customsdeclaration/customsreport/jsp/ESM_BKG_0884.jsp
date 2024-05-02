<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0884.jsp
*@FileTitle  : PSA Import Status I/F Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String titlePrefix = "";
	String pod = JSPUtil.getParameter(request, "pod");
	if (!"".equals(pod)) {
		if ("SG".equals(pod.substring(0, 2))) {
			titlePrefix = "PSA";
		} else {
			titlePrefix = "TML";
		}
	}
%>

<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	var titlePrefix = "<%=titlePrefix%>";
	function setupPage() {
		loadPage();
	}
</script>

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;<%=titlePrefix%> Import Status I/F Print</span></h2>
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
