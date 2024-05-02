<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0022.jsp
*@FileTitle  : Some Title 
*@author     : tivity Attribute Management
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<% CodeUtilBC codeUtil = new CodeUtilBCImpl() ; %>

<script  type="text/javascript">
	<%=codeUtil.searchCodeComboSheet("skdLgc", "sce_cop_skd_lgc", "cop_skd_lgc_no a", "cop_skd_lgc_no b",
							   null, "a")%> ;

    function setupPage(){
	    loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->	
	
    <!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	
</div>
<!-- page_title_area(E) -->



<!-- wrap_result(S) -->
<div class="wrap_result" >

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	
		<script  type="text/javascript">ComSheetObject('sheet1');</script>
		
	</div>
	<!-- opus_design_grid(E) -->
	
	
</div>
<!-- wrap_result(E) -->


</form>