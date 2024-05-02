<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9210.jsp
*@FileTitle  : Terminal Invoice Holding Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	String hld_rmk_inp_nm = request.getParameter("hld_rmk_inp_nm")!=null&&!request.getParameter("hld_rmk_inp_nm").equals("")?request.getParameter("hld_rmk_inp_nm"):"";
	String isZZ = request.getParameter("isZZ")!=null&&!request.getParameter("isZZ").equals("")?request.getParameter("isZZ"):"";
%>

<script type="text/javascript">
	var hld_rmk_inp_nm = "<%=hld_rmk_inp_nm%>";
	var isZZ  = "<%=isZZ%>";
	function setupPage(){
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Invoice Holding Remark</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<% if (isZZ==null || isZZ.trim().equals("")){ %><button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><% }%><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Remark</th>
						<td>
							<%if(isZZ==null || isZZ.trim().equals("")){ %>
							<input type="text" name="hld_rmk" value="" maxlength="1000" style="width:200px;" onkeydown="tes_chkInput(this);" onblur="tes_chkInput(this);" id="hld_rmk" />
							<%} else{ %>
							<input type="text" name="hld_rmk" value="" maxlength="1000" style="width:200px;" readonly id="hld_rmk" />
							<%} %>
						</td>	
				</tbody>
			</table>
		</div>
	</div>		
</div>
</form>