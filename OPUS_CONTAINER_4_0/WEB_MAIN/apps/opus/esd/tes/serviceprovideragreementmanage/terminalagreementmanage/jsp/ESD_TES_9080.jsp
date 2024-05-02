<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9080.jsp
*@FileTitle  : Agreement Storage Remark Column Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String lgs_cost_cd 		= "";
	String row 				= "";
	String sheetObj 		= "";
	String agmt_rmk 		= "";
	String mode 			= "";
	
	lgs_cost_cd	= JSPUtil.getParameter(request, "pop_cost_cd ".trim(), "");
	row 		= JSPUtil.getParameter(request, "pop_row 	 ".trim(), "");
	sheetObj 	= JSPUtil.getParameter(request, "pop_sheetObj".trim(), "");
	agmt_rmk	= JSPUtil.getParameter(request, "pop_agmt_rmk".trim(), "");
	mode		= JSPUtil.getParameter(request, "pop_mode".trim(), "");

%>

<script type="text/javascript">
	var mode  = "<%=mode%>";
</script>
<script type="text/javascript">
	function setupPage(){
	}
</script>


<form name="form">
<input type="hidden" name="row" value="<%=row%>" id="row" />
<input type="hidden" name="sheetObj" value="<%=sheetObj%>" id="sheetObj" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Remarks Column</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			<% if( mode.trim().equals("create")){%><!-- 
				 --><button type="button" class="btn_accent" name="btn_apply" id="btn_apply">Apply</button><!-- 
			 --><%} %><!--
			 <% if( mode.trim().equals("create")){%><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!--
			 <% } else { %><!--
			 --><button type="button" class="btn_accent" name="btn_close" 	id="btn_close">Close</button><!--
			 <% } %>
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Cost Code</th>
						<td><input type="text" name="lgs_cost_cd" maxlength="7" style="width:90px;" value="<%=lgs_cost_cd%>" readonly id="lgs_cost_cd" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
				</colgroup>
				<tbody>
					<tr>
						<td><textarea name="agmt_dtl_rmk" style="width:100%;height:200px;resize:none;"><%=agmt_rmk%></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>