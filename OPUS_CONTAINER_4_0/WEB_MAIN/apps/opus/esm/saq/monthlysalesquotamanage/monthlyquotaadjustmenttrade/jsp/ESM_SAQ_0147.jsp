<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0147.jsp
*@FileTitle  : Monthly Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0147Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String gline_ver_no = JSPUtil.getParameter(request, "gline_ver_no", "");
	String mqta_step_cd = JSPUtil.getParameter(request, "mqta_step_cd", "");
	String bse_yr = JSPUtil.getParameter(request, "bse_yr", "");
	String bse_qtr_cd = JSPUtil.getParameter(request, "bse_qtr_cd", "");
	String trdCd = JSPUtil.getParameter(request, "trdCd", "");
	String dir_cd = JSPUtil.getParameter(request, "dir_cd", "");
	String mqta_ver_no = JSPUtil.getParameter(request, "mqta_ver_no", "");
	String unit_tp = JSPUtil.getParameter(request, "unit", "");

%>


<script type="text/javascript">
function setupPage(){
	loadPage();
}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="gline_ver_no" value="<%=gline_ver_no%>" id="gline_ver_no" />
<input type="hidden" name="mqta_step_cd" value="<%=mqta_step_cd%>" id="mqta_step_cd" />
<input type="hidden" name="bse_yr" value="<%=bse_yr%>" id="bse_yr" />
<input type="hidden" name="bse_qtr_cd" value="<%=bse_qtr_cd%>" id="bse_qtr_cd" />
<input type="hidden" name="trdCd" value="<%=trdCd%>" id="trdCd" />
<input type="hidden" name="dir_cd" value="<%=dir_cd%>" id="dir_cd" />
<input type="hidden" name="mqta_ver_no" value="<%=mqta_ver_no%>" id="mqta_ver_no" />
<input type="hidden" name="unit_tp" value="<%=unit_tp%>" id="unit_tp" />


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	<h2 class="page_title"><span>Monthly Adjustment</span></h2>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry">
			<table>
				<colgroup>
					<col width="30" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Unit</th>
						<td><select name="unit" id="unit" class="input1" style="width:80px;"></select></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" style="width:800px;">
				 <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>