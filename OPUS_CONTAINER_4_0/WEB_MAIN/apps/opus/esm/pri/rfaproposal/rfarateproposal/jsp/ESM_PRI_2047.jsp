<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2047.jsp
*@FileTitle  : RFA Proposal Creation ? Rate ? Specification
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2047Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2047Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	String prcPropStsCd = JSPUtil.getNull(request.getParameter("prc_prop_sts_cd"));
	String cmdtHdrSeq = JSPUtil.getNull(request.getParameter("cmdt_hdr_seq"));
	String routSeq = JSPUtil.getNull(request.getParameter("rout_seq"));
	String rtSeq = JSPUtil.getNull(request.getParameter("rt_seq"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2047Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="cd">
<input type="hidden" name="prop_no" value="<%=propNo%>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="prc_prop_sts_cd" value="<%=prcPropStsCd%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=cmdtHdrSeq%>">
<input type="hidden" name="rout_seq" value="<%=routSeq%>">
<input type="hidden" name="rt_seq" value="<%=rtSeq%>">
<input type="hidden" name="rat_ut_cd">
<input type="hidden" name="cntr_len">
<input type="hidden" name="cntr_wdt">
<input type="hidden" name="cntr_hgt">
<input type="hidden" name="cntr_wgt">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>RFA Proposal Creation - Rate [Specification]</span></h2>
		
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry sm">
			<table border="0" style="width:100%;" class="search_sm"> 
				<tr class="h23">
					<td width="130px"><b>Measuring Unit</b></td>
					<td width="" class="stm">
					<input type="radio" name="measuring_unit" value="M" class="trans" checked>Metric (mm / Kg)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="measuring_unit" value="I" class="trans">Imperial (foot / lbs)</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="layout_wrap">
			<table class="search" border="0">
				<tr><td class="title_h"></td>
				<th class="title_s" align="left">Actual Dimension</th></tr>
			</table>
			<table border="0" style="width:100%;" class="grid2"> 
				<tr class="tr2_head">
					<th width="14%">Type (Unit)	</th>
					<th width="22%" id="len_title">Length (mm)	</th>
					<th width="22%" id="wdt_title">Width (mm)	</th>
					<th width="22%" id="hgt_title">Height (mm)	</th>
					<th width="" id="wgt_title">Weight (Kg)</th>
				</tr>
				<tr class="">
					<td width="14%" align="center"><input type="text" name="type_unit"   id="type_unit" style="width:100%;text-align:center" class="noinput" readonly>	</td>
					<td width="22%" align="center"><input type="text" name="act_cgo_len" id="act_cgo_len" maxLength="10" pointcount="2" style="width:100%;text-align:right;ime-mode:disabled" class="input1">	</td>
					<td width="22%" align="center"><input type="text" name="act_cgo_wdt" id="act_cgo_wdt" maxLength="10" pointcount="2" style="width:100%;text-align:right;ime-mode:disabled" class="input1">	</td>
					<td width="22%" align="center"><input type="text" name="act_cgo_hgt" id="act_cgo_hgt" maxLength="10" pointcount="2" style="width:100%;text-align:right;ime-mode:disabled" class="input1">	</td>
					<td width="%"   align="center"><input type="text" name="act_cgo_wgt" id="act_cgo_wgt" maxLength="19" pointcount="2" style="width:100%;text-align:right;ime-mode:disabled" class="input1">	</td>
				</tr>
			</table>
			<table class="search" border="0">
				<tr><td class="height_5"></td></tr>
				<tr><td class="title_h"></td>
					<th class="title_s" align="left">Over Dimension</th></tr>
			</table>
			<table border="0" style="width:100%;" class="grid2"> 
				<tr class="tr2_head">
					<th width="14%">Type (Void)</th>
					<th width="14%" id="front_title">Front</th>
					<th width="14%" id="rear_title">Rear</th>
					<th width="14%" id="left_title">Left</th>
					<th width="14%" id="right_title">Right</th>
					<th width="14%" id="height_title">Height</th>
					<th id="weight_title">Weight</th>
				</tr>
				<tr class="">
					<td width="" align="center"><input type="text" name="type_void" id="type_void" 				style="width:80px;text-align:center" class="noinput" readonly></td>
					<td width="" align="center"><input type="text" name="front_len" id="front_len" 	value=".00" style="width:80px;text-align:right" class="noinput" readonly></td>
					<td width="" align="center"><input type="text" name="rear_len" 	id="rear_len" 	value=".00" style="width:80px;text-align:right" class="noinput" readonly></td>
					<td width="" align="center"><input type="text" name="left_wdt" 	id="left_wdt" 	value=".00" style="width:80px;text-align:right" class="noinput" readonly></td>
					<td width="" align="center"><input type="text" name="right_wdt" id="right_wdt"	value=".00" style="width:80px;text-align:right" class="noinput" readonly></td>
					<td width="" align="center"><input type="text" name="hgt" 		id="hgt" 		value=".00" style="width:80px;text-align:right" class="noinput" readonly></td>
					<td width="" align="center"><input type="text" name="wgt" 		id="wgt"		value=".00" style="width:80px;text-align:right" class="noinput" readonly></td>			
				</tr>
			</table>
		</div>
		<div class="opus_design_data">
			<table class="search"> 	
					<tr class="h23">
					<th width="130px" align="left">Additional Dead Slot</th>
					<td width="100px"><input type="text" name="add_dead_slot" id="add_dead_slot" style="width:40px;text-align:center" value="0" class="noinput2"></td>
					<th width="170px" align="left">Total Estimated Dead Slot</th>
					<td width="">
						<input type="text" style="width:40px;text-align:center;background-color:E8EFF9;" value="Q2" class="noinput2" readonly>&nbsp;<input type="text" name="total_dead_slot1" id="total_dead_slot1" value="0" style="width:40px;text-align:center" class="noinput2" readonly>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" style="width:40px;text-align:center;background-color:E8EFF9;" value="Q4" class="noinpu2" readonly>&nbsp;<input type="text" name="total_dead_slot2" id="total_dead_slot2" value="0" style="width:40px;text-align:center" class="noinput2" readonly></td>
					</tr>
			</table>
			<table class="grid2"> 
					<tr class="h23">
					<th width="40px">Note </th>
					<td width=""><textarea name="cgo_spec_rmk" id="cgo_spec_rmk" cols="120" rows="4" style="ime-mode:disabled"></textarea></td>
					</tr>
			</table>
		</div>
		<div class="opus_design_grid">
			<table width="100%" id="mainTable" style="display:none">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>

</form>