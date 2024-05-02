<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0158.jsp
*@FileTitle  : Office/Volum Activity
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0158Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmCoa0158Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//Error from server

	String strErrMsg = "";							//Error message
	Logger log = Logger.getLogger("com.clt.apps.multidimensionrpt.logisticsrpt");

	try {
		event = (EsmCoa0158Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		document.form.f_year.focus();
	}
</script>
<div style="height:0px">
<iframe height="0" width="0" name="frmHidden"></iframe>
</div>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_rhq_cd" id="s_rhq_cd" />
<input type="hidden" name="s_cntr_ofc_cd" id="s_cntr_ofc_cd" />
<input type="hidden" name="s_lgs_kpi_cost_grp_cd" id="s_lgs_kpi_cost_grp_cd" />
<input type="hidden" name="s_kpi_cd" id="s_kpi_cd" />
<input type="hidden" name="s_cost_yrmon2" id="s_cost_yrmon2" />
<input type="hidden" name="s_cost_wk2" id="s_cost_wk2" />
<!-- page_title_area(S) -->
<div class="page_title_area clear" >
    <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">		
	        <table>
	       		<colgroup>
	       			<col width="150">
	       			<col width="800">
	       			<col width="100">
	       			<col width="*">
	       		</colgroup>
	       		<tr>
	       			<td><h3 class="title_design2">Period</h3></td>
	       			<td><script type="text/javascript">coaPeriod1("1","");</script></td>
	       			<th>Split by Month / Week</th>
					<td>
						<input type="checkbox" name="f_split_mw" value="T" checked="" class="trans" onclick="viewMonWeek();" id="f_split_mw" />
					</td>
	       		</tr>
	       </table>
	       
		   <table>
				<colgroup>
					<col width="150">
					<col width="50">
					<col width="224">
					<col width="50">
					<col width="130">
					<col width="*">
			    </colgroup>
			    <tbody>
			    	<tr>
			    		<td><h3 class="title_design2">Organization</h3></td>
						<th>Report</th>
						<td>
							<script type="text/javascript">ComComboObject('f_report',1, 150 , 0 )</script>
						</td>
						<th>RHQ</th>
						<td>
							<script type="text/javascript">ComComboObject('f_rhq_cd',1, 120 , 0 )</script>
						</td>
						<th>Office</th>
						<td>
							<script type="text/javascript">ComComboObject('f_ctrl_ofc_cd',1, 120 , 0 )</script>
						</td>
					</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable">
				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn mar_btm_4">
					<div id="div_zoom_in1">
					 	<button type="button" class="btn_down" name="bu_zoom_in" title="Zoom in(+)"></button>
					 </div>
					 <div id="div_zoom_out1" style="display:none">
					 	<button type="button" class="btn_up" name="bu_zoom_out"  title="Zoom out(-)" ></button>
					</div>
				</div>
				<!-- opus_design_btn(E) -->
				<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>