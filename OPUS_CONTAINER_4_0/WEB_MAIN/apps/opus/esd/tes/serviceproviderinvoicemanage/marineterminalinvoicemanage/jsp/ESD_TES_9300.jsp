<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9300.jsp
*@FileTitle  : Office Hierarchy Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	String ofc_cd	 = request.getParameter("ofc_cd"		)!=null&&!request.getParameter("ofc_cd"		).equals("")?request.getParameter("ofc_cd" 		):"";
	String param_nm	 = request.getParameter("param_nm"		)!=null&&!request.getParameter("param_nm"	).equals("")?request.getParameter("param_nm"	):"";
	%>
<script type="text/javascript">

    function setupPage(){
        loadPage();
    }

</script>
<form  name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>" id="ofc_cd" />
<input type="hidden" name="param_nm" value="<%=param_nm%>" id="param_nm" />
<input type="hidden" name="src_ofc" value="" id="src_ofc" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>S/O Office Select</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		    <button class="btn_accent"  type="button"  name="btn_apply" id="btn_apply">Apply</button><!-- 
		 --><button class="btn_normal"  type="button" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
	<div class="opus_design_data">
		<table class="sbutton">
			<tbody>
				<tr>
					<th><input type="checkbox" value="" class="trans" name="incl_sub" id="incl_sub"> Incl. Sub Office</th>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="hidden_sheet" style="display:none">
		<script type="text/javascript">ComSheetObject('etc_hidden');</script>
	</div>
</div>	
</form>