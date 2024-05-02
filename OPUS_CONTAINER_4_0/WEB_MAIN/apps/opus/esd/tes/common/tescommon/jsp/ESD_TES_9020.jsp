<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : c.jsp
*@FileTitle  : Terminal Invoice Reject Reason
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
		param_name = (String) enums.nextElement();
	}
	String rjct_sts_inp_nm = request.getParameter("rjct_sts_inp_nm")!=null&&!request.getParameter("rjct_sts_inp_nm").equals("")?request.getParameter("rjct_sts_inp_nm"):"";
	String rjct_fn_nm	= request.getParameter("rjct_fn_nm")!=null&&!request.getParameter("rjct_fn_nm").equals("")?request.getParameter("rjct_fn_nm"):"";
%>



<script type="text/javascript">
	var rjct_sts_inp_nm = "<%=rjct_sts_inp_nm%>";
	var rjct_fn_nm = "<%=rjct_fn_nm%>";
	
	function setupPage(){

		<%-- var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage(); --%>
	}
</script>

<form name="form">

<div class="layer_popup_title">
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Reject Reason</span></h2>
		<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
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
	
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Reason</th>
						<td>
							<select name="inv_rjct_rmk" id="inv_rjct_rmk" style="width:200px;">
								<option value="AD" selected>Amount Discrepancy</option>
								<option value="VD">VVD Discrepancy</option>
								<option value="CD">CNTR No. Discrepancy</option>
								<option value="PD">Period Discrepancy</option>
								<option value="DB">Double Billing</option>
								<option value="3P">3rd Party CNTR</option>
							</select>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
</div>
</form>