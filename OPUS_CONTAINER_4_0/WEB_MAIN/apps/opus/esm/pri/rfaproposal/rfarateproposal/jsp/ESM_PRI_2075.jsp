<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2075.jsp
*@FileTitle  : RFA Proposal Inquiry ? Rate ? Specification
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2075Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2075Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFARateProposal");

	String propNo = JSPUtil.getNull(request.getParameter("prop_no"));
	String amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
	String svcScpCd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
	String cmdtHdrSeq = JSPUtil.getNull(request.getParameter("cmdt_hdr_seq"));
	String routSeq = JSPUtil.getNull(request.getParameter("rout_seq"));
	String rtSeq = JSPUtil.getNull(request.getParameter("rt_seq"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2075Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="prop_no" value="<%=propNo%>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>" id="svc_scp_cd" />
<input type="hidden" name="cmdt_hdr_seq" value="<%=cmdtHdrSeq%>" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" value="<%=routSeq%>" id="rout_seq" />
<input type="hidden" name="rt_seq" value="<%=rtSeq%>" id="rt_seq" />
<input type="hidden" name="rat_ut_cd" id="rat_ut_cd" />
<input type="hidden" name="cntr_len" id="cntr_len" />
<input type="hidden" name="cntr_wdt" id="cntr_wdt" />
<input type="hidden" name="cntr_hgt" id="cntr_hgt" />
<input type="hidden" name="cntr_wgt" id="cntr_wgt" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>RFA Proposal Creation - Rate [Specification]</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
		
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>					
					<col width="80"/>
					<col width="300" />	
					<col width="*" />			
				</colgroup> 
				<tbody>
					<tr>
						<th class="sm">Measuring Unit</th>
						<td class="sm"><input type="radio" id="measuring_unit" name="measuring_unit" value="M" class="trans" checked="" id="measuring_unit" /><label for = "measuring_unit">Metric (mm / Kg)</label><input type="radio" id ="measuring_unit1" name="measuring_unit" value="I" class="trans" id="measuring_unit" /><label for = "measuring_unit1">Imperial (foot / lbs)</label></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<h3 class="title_design">Actual Dimension</h3>
			<table class="grid2">				
				<tbody>
					<tr>
						<td style = "text-align:center;"><strong>Type (Unit)</strong></td>
						<td style = "text-align:center;" id="len_title" name="len_title"><strong>Length (mm)</strong></td>
						<td style = "text-align:center;" id="wdt_title" name="wdt_title"><strong>Width (mm)</strong></td>
						<td style = "text-align:center;" id="hgt_title" name="hgt_title"><strong>Height (mm)</strong></td>
						<td style = "text-align:center;" id="wgt_title" name="wgt_title"><strong>Weight (Kg)</strong></td>
					</tr>
					<tr>
						<td><input type="text" name="type_unit" style="width:100%;text-align:center" class="noinput" readonly id="type_unit" /> 	</td>
						<td><input type="text" name="act_cgo_len" dataformat="float" maxlength="10" pointcount="2" value=".00" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" readonly id="act_cgo_len" /> </td>
						<td><input type="text" name="act_cgo_wdt" dataformat="float" maxlength="10" pointcount="2" value=".00" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" readonly id="act_cgo_wdt" /> </td>
						<td><input type="text" name="act_cgo_hgt" dataformat="float" maxlength="10" pointcount="2" value=".00" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" readonly id="act_cgo_hgt" /> </td>
						<td><input type="text" name="act_cgo_wgt" dataformat="float" maxlength="19" pointcount="2" value=".00" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" readonly id="act_cgo_wgt" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<h3 class="title_design">Over Dimension</h3>
			<table class = "grid2">				
				<tbody>
					<tr>
						<td style = "text-align:center;"><strong>Type (Void)</strong></td>
						<td style = "text-align:center;" id="front_title" name="front_title"><strong>Front</strong></td>
						<td style = "text-align:center;" id="rear_title" name="rear_title"><strong>Rear</strong></td>
						<td style = "text-align:center;" id="left_title" name="left_title"><strong>Left</strong></td>
						<td style = "text-align:center;" id="right_title" name="right_title"><strong>Right</strong></td>
						<td style = "text-align:center;" id="height_title" name="height_title"><strong>Height</strong></td>
						<td style = "text-align:center;"><strong>Weight</strong></td>
					</tr>
					<tr >
						<td><input type="text" name="type_void" style="width:100%;text-align:center" class="noinput" readonly id="type_void" /> </td>
						<td><input type="text" name="front_len" value=".00" style="width:100%;text-align:right" class="noinput" readonly id="front_len" /> </td>
						<td><input type="text" name="rear_len" value=".00" style="width:100%;text-align:right" class="noinput" readonly id="rear_len" /> </td>
						<td><input type="text" name="left_wdt" value=".00" style="width:100%;text-align:right" class="noinput" readonly id="left_wdt" /> </td>
						<td><input type="text" name="right_wdt" value=".00" style="width:100%;text-align:right" class="noinput" readonly id="right_wdt" /> </td>
						<td><input type="text" name="hgt" value=".00" style="width:100%;text-align:right" class="noinput" readonly id="hgt" /> </td>
						<td><input type="text" name="wgt" value=".00" style="width:100%;text-align:right" class="noinput" readonly id="wgt" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="120"/>
					<col width="40"/>
					<col width="150"/>					
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr class="h23">
						<th>Additional Dead Slot</th>
						<td><input type="text" name="add_dead_slot" style="width:40px;text-align:center" value="0" class="noinput2" id="add_dead_slot" /> </td>
						<th>Total Estimated Dead Slot</th>
						<td><input type="text" style="width:40px;text-align:center;background-color:E8EFF9;" value="Q2" class="noinput2" id="total_dead_slot1" name="total_dead_slot1" readonly="" /><input type="text" style="width:40px;text-align:center;background-color:E8EFF9;" id="total_dead_slot2" name="total_dead_slot2" value="Q4" class="noinput2" readonly="" />
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_data">
			<table class="grid_2">
				<colgroup>					
					<col width="100"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<th>Note</th>
						<td><textarea style= "resize:none;" name="cgo_spec_rmk" cols="120" rows="4" style="ime-mode:disabled" readonly=""></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->		
		
	</div>	
</div>
</form>
