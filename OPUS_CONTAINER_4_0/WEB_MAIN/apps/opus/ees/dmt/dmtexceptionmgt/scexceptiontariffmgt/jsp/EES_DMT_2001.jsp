<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2001.jsp
*@FileTitle  : DEM/DET Exception - S/C Exception Terms Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg 	 = "";						//error message
	int rowCount	 	 = 0;						//count of DB ResultSet list
	
	String successFlag 	 = "";
	String codeList   	 = "";
	String pageRows  	 = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	Logger log 			 = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt");
	
	String proposalNo 	 = request.getParameter("prop_no") 		!= null ? request.getParameter("prop_no") 	: "" ;
	String scrnAuth 	 = request.getParameter("scrn_auth") 	!= null ? request.getParameter("scrn_auth") : "Y" ;
	String amdtSeq 		 = request.getParameter("amdt_seq") 	!= null ? request.getParameter("amdt_seq") 	: "" ;
	String caller 		 = request.getParameter("caller") 		!= null ? request.getParameter("caller") 	: "" ;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
	   
		event = (EesDmt2001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="max_version" id="max_version" />
<input type="hidden" name="caller" value="<%= caller %>" id="caller" />
<!-- Parameters for Serarching subordinate item of S/C Exception Tariff  Group Seq.  -->
<input type="hidden" name="prop_no" id="prop_no" />
<input type="hidden" name="sc_expt_ver_seq" id="sc_expt_ver_seq" />
<input type="hidden" name="sc_expt_prev_ver_seq" id="sc_expt_prev_ver_seq" />
<input type="hidden" name="sc_expt_grp_seq" id="sc_expt_grp_seq" />
<!-- Parameters for Serarching  Rep.Commodity, Actual Customer, Commodity -->
<input type="hidden" name="amdt_seq" value="<%= amdtSeq %>" id="amdt_seq" />
<input type="hidden" name="cust_type" id="cust_type" />
<!-- Parameters for checking divide Common or Rep Commodity -->
<input type="hidden" name="prc_cmdt_tp_cd" id="prc_cmdt_tp_cd" />
<input type="hidden" name="dmdt_expt_ver_sts_cd" id="dmdt_expt_ver_sts_cd" />
<input type="hidden" name="conti_cd" id="conti_cd" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="rgn_cd" id="rgn_cd" />
<input type="hidden" name="ste_cd" id="ste_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<!--  Comparing  Continent , inputing BKG POR(O) or DEL(I)  Continent and  Coverage of BKG POR(O) or DEL(I)'Cnt_cd -->
<input type="hidden" name="fnl_dest_cnt_cd" id="fnl_dest_cnt_cd" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Parameters for checking Calculation Type  -->
<input type="hidden" name="chk_calc_tp_in" id="chk_calc_tp_in" />
<input type="hidden" name="chk_calc_tp_combined" id="chk_calc_tp_combined" />
<input type="hidden" name="result" id="result" />
<input type="hidden" name="result_cnt" id="result_cnt" />
<input type="hidden" name="result_ste" id="result_ste" />
<input type="hidden" name="result_rgn" id="result_rgn" />
<input type="hidden" name="result_loc" id="result_loc" />
<!--  Parameters for checking mandatory of Rate Adjustment  -->
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="dmdt_cntr_cgo_tp_cd" id="dmdt_cntr_cgo_tp_cd" />
<!-- Parameters for modified authority about popUp Screen -->
<input type="hidden" name="isEditable" value="<%= scrnAuth %>" id="isEditable" />
<!-- Customer Seq.of Contract Party-->
<input type="hidden" name="custSeq" id="custSeq" />
<!-- Parameters for Deleting Origin data, case in copyed data from 2103 Screen's status is modification -->
<input type="hidden" name="hist_prop_no" id="hist_prop_no" />
<input type="hidden" name="sc_expt_hist_ver_seq" id="sc_expt_hist_ver_seq" />
<!-- Parameters for saving S/C Duration  -->
<input type="hidden" name="sc_eff_dt" id="sc_eff_dt" />
<input type="hidden" name="sc_exp_dt" id="sc_exp_dt" />
<!-- Parameters for checking  authority about Accept, Accept Cancel -->
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>" id="ofc_cd" />
<input type="hidden" name="isAcceptAuth" id="isAcceptAuth" />
<!-- Parameters for Serarching Multi Coverage -->
<input type="hidden" name="select_row" id="select_row" />
<!-- Parameters for checking Duplication -->
<input type="hidden" name="sc_expt_fm_conti_cd" id="sc_expt_fm_conti_cd" />
<input type="hidden" name="sc_expt_fm_cnt_cd" id="sc_expt_fm_cnt_cd" />
<input type="hidden" name="sc_expt_fm_rgn_cd" id="sc_expt_fm_rgn_cd" />
<input type="hidden" name="sc_expt_fm_ste_cd" id="sc_expt_fm_ste_cd" />
<input type="hidden" name="sc_expt_fm_loc_cd" id="sc_expt_fm_loc_cd" />
<input type="hidden" name="fnl_dest_rgn_cd" id="fnl_dest_rgn_cd" />
<input type="hidden" name="fnl_dest_ste_cd" id="fnl_dest_ste_cd" />
<input type="hidden" name="fnl_dest_loc_cd" id="fnl_dest_loc_cd" />
<input type="hidden" name="rcv_de_term_cd" id="rcv_de_term_cd" />
<input type="hidden" name="coverage_list" id="coverage_list" />
<input type="hidden" name="act_cust_list" id="act_cust_list" />
<input type="hidden" name="cmdt_list" id="cmdt_list" />
<input type="hidden" name="max_ver_status" id="max_ver_status" />
<input type="hidden" name="max_ver" id="max_ver" />

<div class="layer_popup_title"> 
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>DEM/DET Exception - S/C Exception Terms Entry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			   <span id="btnNewLayer"><button          class="btn_accent" type="button" name="btn_New"          id="btn_New">New</button></span><!--
			--><span id="btnUpdateLayer"><button       class="btn_normal" type="button" name="btn_Update"       id="btn_Update">Update</button></span><!--
			--><span id="btnSaveLayer"><button         class="btn_normal" type="button" name="btn_Request"      id="btn_Request">Request</button></span><!--
			--><span id="btnDeleteLayer"><button       class="btn_normal" type="button" name="btn_Delete"       id="btn_Delete">Delete</button></span><!--
			--><span id="btnAcceptLayer"><button       class="btn_normal" type="button" name="btn_Accept"       id="btn_Accept">Accept</button></span><!--
			--><span id="btnAcceptCancelLayer"><button class="btn_normal" type="button" name="btn_AcceptCancel" id="btn_AcceptCancel">Accept&nbsp;Cancel</button></span><!--
			--><span id="btnCloseLayer"><button        class="btn_normal" type="button" name="btn_Close"        id="btn_Close">Close</button></span>
		</div>	
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">	
			<table>
				<colgroup>
					<col width="35" />		
					<col width="120" />	
					<col width="90" />	
					<col width="110" />	
					<col width="90" />	
					<col width="70" />
					<col width="80" />	
					<col width="150" />				
					<col width="*" />				
			   </colgroup> 
				<tbody>
					<tr>
						<th>S/C No.</th>
						<td><input type="text" name="sCNo" id="sCNo" style="width:80px;" class="input2"></td>
						<th>Proposal No.</th>
						<td><input type="text" name="proposalNo" id="proposalNo" style="width:85px;" class="input2" value="<%= proposalNo %>"></td>
						<th>Version</th>
						<td><select name="version" id="version" style="width:60px;" class="input" onChange="doActionRetrieveByVer(0)"></select></td>
						<th>STS</th>
						<td><input type="text" name="status"  id="status" style="width:80px;" class="input2" value=""><!-- 
							 --><button type="button" class="input_seach_btn" onClick="openWinSearchTariffHistory()"></button></td>
						<th>Contract Party</th>
						<td>
							<input type="text" name="custCd" id="custCd" id="custCd" style="width:70px;" class="input2"><!-- 
							 --><input type="text" name="custNm" id="custNm" style="width:330px;" class="input2">
						</td>
						</tr> 
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_inquiry(E) -->
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn"> 
				<span id="btnAddSCLayer"><button  class="btn_normal" type="button"  name="btn_AddGroup"  id="btn_AddGroup">Row Add</button></span>
				<span id="btnCopySCLayer"><button class="btn_normal" type="button"  name="btn_CopyGroup" id="btn_CopyGroup">Row&nbsp;Copy</button></span>
				<span id="btnSaveSCLayer"><button class="btn_normal" type="button"  name="btn_SaveGroup" id="btn_SaveGroup">Save</button></span>
				<span id="btnDelSCLayer"><button  class="btn_normal" type="button"  name="btn_DelGroup"  id="btn_DelGroup">Delete</button></span>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<!-- layout_wrap(S) -->
		<div class="layout_wrap" style="width:100%;margin-bottom:20px">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:28%;margin-right:2%;">
				<div class="opus_design_grid">
					<h3 style="height: 26px"><input type="checkbox" name="chkMultiCoverage" id="chkMultiCoverage" class="trans" disabled> Multi Coverage</h3>
					<div class="opus_design_btn"> 
						<span id="btnAddMultiCoverageLayer"><button class="btn_normal" type="button" name="btn_AddMultiCoverage" id="btn_AddMultiCoverage">Row Add</button></span>
						<span id="btnDelMultiCoverageLayer"><button class="btn_normal" type="button" name="btn_DelMultiCoverage" id="btn_DelMultiCoverage">Row Delete</button></span>
					</div>
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
			</div>
			<!-- layout_vertical_2(E) -->		
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:25%;margin-right:2%;">
				<div class="opus_design_grid">
					<h3 style="height: 26px"><input type="checkbox" name="chkFreeTime" id="chkFreeTime" class="trans" disabled> Tiered Free Time</h3>
					<div class="opus_design_btn"> 
						<span id="btnAddFreeTimeLayer"><button  class="btn_normal" type="button" name="btn_AddFreeTime" id="btn_AddFreeTime">Row Add</button></span>
						<span id="btnDelFreeTimeLayer" ><button class="btn_normal" type="button" name="btn_DelFreeTime" id="btn_DelFreeTime">Row Delete</button></span>
					</div>
					<script type="text/javascript">ComSheetObject('sheet3');</script>
				</div>
			</div>
			<!-- layout_vertical_2(E) -->
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:43%">
				<div class="opus_design_grid">
					<h3 class="pad_rgt_12"><input type="checkbox" name="chkRateAdjustment" id="chkRateAdjustment" class="trans" onClick="checkRateAdjustment()"> Rate Adjustment</h3>
					<h3 class="pad_rgt_12">Currency</h3>
					<h3 style="position: relative;top: -5px;"><select name="currency" id="currency" style="width:80px;" class="input" onChange="setCurrencyVal()"></select></h3>		
					<div class="opus_design_btn"> 
						<span id="btnAddRateAdjustmentLayer"><button class="btn_normal" type="button" name="btn_AddRateAdjustment" id="btn_AddRateAdjustment">Row Add</button></span>
						<span id="btnDelRateAdjustmentLayer"><button class="btn_normal" type="button" name="btn_DelRateAdjustment" id="btn_DelRateAdjustment">Row Delete</button></span>
					</div>
					<script type="text/javascript">ComSheetObject('sheet4');</script>
				</div>
			</div>
			<!-- layout_vertical_2(E) -->
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width: 49%;margin-right:2%">
				<div class="opus_design_grid" id="mainTable">
					<h3 class="pad_rgt_12">Customer</h3>
					<h3 style="position: relative;top: -5px;">
						<select name="customerType" id="customerType" style="width:150px;" class="input" onChange="searchCustomerByTypeChange()">
							<option value="Y" selected>Actual Customer</option>
							<option value="N">Affiliate</option>
						</select>
					</h3>
					<div class="opus_design_btn"> 
						<span id="btnAddCustomerLayer"><button class="btn_normal" type="button" name="btn_AddCustomer" id="btn_AddCustomer">Row Add</button></span>
						<span id="btnDelCustomerLayer"><button class="btn_normal" type="button" name="btn_DelCustomer" id="btn_DelCustomer">Row Delete</button></span>
					</div>
					<script type="text/javascript">ComSheetObject('sheet5');</script>
				</div>
			</div>
			<div class="layout_vertical_2" style="width: 49%;">
				<div class="opus_design_grid" id="mainTable">
					<h3 class="pad_rgt_12" style="height: 30px">Commodity</h3>
					<div class="opus_design_btn">
						<span id="btnAddCommodityLayer"><button class="btn_normal" type="button" name="btn_AddCommodity" id="btn_AddCommodity">Row Add</button></span>
						<span id="btnDelCommodityLayer"><button class="btn_normal" type="button" name="btn_DelCommodity" id="btn_DelCommodity">Row Delete</button></span>
					</div>
					<script type="text/javascript">ComSheetObject('sheet6');</script>
				</div>
			</div>
			<div class="layout_vertical_2" style="display:none;">
				<div class="opus_design_grid" id="mainTable" style="display:none;">
					<script type="text/javascript">ComSheetObject('sheet7');</script>
				</div>
			</div>
		</div>
	</div>
</div>	
</form>