<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0154.jsp
*@FileTitle  : Space Charter Revenue Missing List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<script language="javascript">
    function setupPage() {
        loadPage();
    }
</script>
<body>
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_chkprd" value="<%= StringUtil.xssFilter(request.getParameter("f_chkprd"))%>">
<input type="hidden" name="f_year" value="<%=StringUtil.xssFilter(request.getParameter("f_year"))%>">
<input type="hidden" name="f_fm_mon" value="<%=StringUtil.xssFilter(request.getParameter("f_fm_mon"))%>">
<input type="hidden" name="f_to_mon" value="<%=StringUtil.xssFilter(request.getParameter("f_to_mon"))%>">
<input type="hidden" name="f_fm_wk" value="<%=StringUtil.xssFilter(request.getParameter("f_fm_wk"))%>">
<input type="hidden" name="f_to_wk" value="<%=StringUtil.xssFilter(request.getParameter("f_to_wk"))%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Space Charter Revenue Missing List</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<div class="wrap_result">		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
</div>
</div>
</form>
</body>


