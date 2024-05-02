<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2003.jsp
*@FileTitle  : DEM/DET Adjustment Request - Before Booking Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2003Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
	EesDmt2003Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");

	String proposalNo 	= request.getParameter("prop_no") 	!= null ? request.getParameter("prop_no") 	: "" ;
	String scrnAuth 	= request.getParameter("scrn_auth") != null ? request.getParameter("scrn_auth") : "Y" ;
	String amdtSeq 		= request.getParameter("amdt_seq") 	!= null ? request.getParameter("amdt_seq") 	: "" ;	
	String caller 		= request.getParameter("caller") 	!= null ? request.getParameter("caller") 	: "" ;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EesDmt2003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rhqOfcList = OfficeCodeMgr.getOfficeCodeList("000004","COM");//RHQ_OFC_LIST
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
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
<input type="hidden" name="caller" value="<%= caller %>" id="caller" />
<!-- parameter for retrieving Actual Customer  -->
<input type="hidden" name="prop_no" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%= amdtSeq %>" id="amdt_seq" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="rfa_expt_dar_no" id="rfa_expt_dar_no" />
<input type="hidden" name="rfa_expt_mapg_seq" id="rfa_expt_mapg_seq" />
<input type="hidden" name="rfa_expt_ver_seq" id="rfa_expt_ver_seq" />
<input type="hidden" name="rfa_expt_prev_ver_seq" id="rfa_expt_prev_ver_seq" />
<input type="hidden" name="rfa_rqst_dtl_seq" id="rfa_rqst_dtl_seq" />
<input type="hidden" name="apro_ofc_cd" id="apro_ofc_cd" />
<input type="hidden" name="cvrg_cmb_seq" id="cvrg_cmb_seq" /><!-- [2016.01.04] NYK Add -->
<!--  parameter for saving Comment History  -->
<input type="hidden" name="prog_seq" id="prog_seq" />
<input type="hidden" name="prog_rmk" id="prog_rmk" />
<!--  parameter for retrieving CNTR/Cargo Type common code -->
<input type="hidden" name="code1" value="CD02053" id="code1" />
<input type="hidden" name="code2" value="CD01963" id="code2" />
<!--  parameter for retrieving whether is Common or Rep Commodity not -->
<input type="hidden" name="prc_cmdt_tp_cd" id="prc_cmdt_tp_cd" />
<input type="hidden" name="dmdt_expt_rqst_sts_cd" id="dmdt_expt_rqst_sts_cd" />
<input type="hidden" name="dmdt_expt_rqst_sts_desc" id="dmdt_expt_rqst_sts_desc" />
<input type="hidden" name="conti_cd" id="conti_cd" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="rgn_cd" id="rgn_cd" />
<input type="hidden" name="ste_cd" id="ste_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<!-- BKG POR (O) or DEL (I) entered in the Continent and the Coverage of CN parameters for comparison with the Continent  -->
<input type="hidden" name="fnl_dest_cnt_cd" id="fnl_dest_cnt_cd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Button, the parameters used to check permissions -->
<input type="hidden" name="role_permit" id="role_permit" />
<input type="hidden" name="role_auth" id="role_auth" />
<input type="hidden" name="usr_id" value="<%= strUsr_id %>" id="usr_id" />
<input type="hidden" name="usr_role_cd" value="DMT01,DMT05" id="usr_role_cd" />
<input type="hidden" name="pgm_no" value="EES_DMT_2005" id="pgm_no" />
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>" id="ofc_cd" />
<input type="hidden" name="rhq_ofc_cd" value="<%= strRhq_ofc_cd %>" id="rhq_ofc_cd" />
<!-- Parameters for Calculation Type Check  -->
<input type="hidden" name="chk_calc_tp_in" id="chk_calc_tp_in" />
<input type="hidden" name="dmdt_ctrt_expt_tp_cd" value="B" id="dmdt_ctrt_expt_tp_cd" />
<input type="hidden" name="chk_calc_tp_combined" id="chk_calc_tp_combined" />
<input type="hidden" name="result" id="result" />
<input type="hidden" name="result_cnt" id="result_cnt" />
<input type="hidden" name="result_ste" id="result_ste" />
<input type="hidden" name="result_rgn" id="result_rgn" />
<input type="hidden" name="result_loc" id="result_loc" />
<!-- Rate Adjustment required to check whether the parameters for  -->
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="dmdt_cntr_cgo_tp_cd" id="dmdt_cntr_cgo_tp_cd" />
<!-- Modify permissions for the current variable pop-up screen -->
<input type="hidden" name="isEditable" value="<%= scrnAuth %>" id="isEditable" />
<!-- Customer Seq retrieved from Contract Party.-->
<input type="hidden" name="custSeq" id="custSeq" />
<!-- Copied from the screen when you enter 2105, the existing version is updated on the status of an existing version of the parameters needed to delete the information -->
<input type="hidden" name="rfa_expt_hist_dar_no" id="rfa_expt_hist_dar_no" />
<input type="hidden" name="rfa_expt_hist_mapg_seq" id="rfa_expt_hist_mapg_seq" />
<input type="hidden" name="rfa_expt_hist_ver_seq" id="rfa_expt_hist_ver_seq" />
<!-- Approval, Counter Offer, Reject E-mail is used to transfer parameters -->
<input type="hidden" name="rfa_expt_apro_no" id="rfa_expt_apro_no" />
<input type="hidden" name="rfa_no" id="rfa_no" />
<input type="hidden" name="cust_cd" id="cust_cd" />
<input type="hidden" name="cust_nm" id="cust_nm" />
<!-- Multi Origin or Dest. Parameters that are used to lookup -->
<input type="hidden" name="select_row" id="select_row" />
<!-- Parameters that are used for redundancy check -->
<input type="hidden" name="dmdt_cntr_tp_cd" id="dmdt_cntr_tp_cd" />
<input type="hidden" name="dmdt_cgo_tp_cd" id="dmdt_cgo_tp_cd" />
<input type="hidden" name="cvrg_cnt_cd" id="cvrg_cnt_cd" />
<input type="hidden" name="cvrg_rgn_cd" id="cvrg_rgn_cd" />
<input type="hidden" name="cvrg_ste_cd" id="cvrg_ste_cd" />
<input type="hidden" name="cvrg_loc_cd" id="cvrg_loc_cd" />
<input type="hidden" name="fnl_dest_rgn_cd" id="fnl_dest_rgn_cd" />
<input type="hidden" name="fnl_dest_ste_cd" id="fnl_dest_ste_cd" />
<input type="hidden" name="fnl_dest_loc_cd" id="fnl_dest_loc_cd" />
<input type="hidden" name="act_cust_seq" id="act_cust_seq" />
<input type="hidden" name="act_cust_cnt_cd" id="act_cust_cnt_cd" />
<input type="hidden" name="coverage_list" id="coverage_list" />
<input type="hidden" name="max_ver_status" id="max_ver_status" />
<input type="hidden" name="max_ver" id="max_ver" />
<input type="hidden" name="dar_no_check" id="dar_no_check" />
<!-- APVL No. Viewed as a result of the parameters that are used to store -->
<input type="hidden" name="apvlno_ofc" id="apvlno_ofc" />
<input type="hidden" name="apvlno_dar" id="apvlno_dar" />
<input type="hidden" name="apvlno_ver" id="apvlno_ver" />
<input type="hidden" name="cmdt_list" id="cmdt_list" />

<div class="layer_popup_title"> 
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>DEM/DET Adjustment Request - Before Booking Request</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			   <button class="btn_accent" type="button" name="btn_New"          id="btn_New"     	 >New</button><!--
			--><button class="btn_normal" type="button" name="btn_Update"       id="btn_Update"      >Update</button><!--
			--><button class="btn_normal" type="button" name="btn_Request"      id="btn_Request"     >Request</button><!--
			--><button class="btn_normal" type="button" name="btn_Cancel"       id="btn_Cancel"      >Cancel</button><!--
			--><button class="btn_normal" type="button" name="btn_Approval"     id="btn_Approval"    >Approval</button><!--
			--><button class="btn_normal" type="button" name="btn_CounterOffer" id="btn_CounterOffer">Counter Offer</button><!--
			--><button class="btn_normal" type="button" name="btn_Reject"       id="btn_Reject"      >Reject</button><!--
			--><button class="btn_normal" type="button" name="btn_Close"        id="btn_Close"        >Close</button><!--
			--><button class="btn_line" style="display:none" type="button" name="btnLineLayer" id="btnLineLayer" ></button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70">				
					<col width="130">				
					<col width="100">				
					<col width="130">				
					<col width="140">				
					<col width="100">				
					<col width="50">				
					<col width="70">				
					<col width="*">				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>RFA No.</th>
						<td><input type="text" name="rFANo" style="width:90px;" class="input2" id="rFANo" /></td>
						<th>Proposal No.</th>
						<td><input type="text" name="proposalNo" style="width:90px;" class="input2" value="<%= proposalNo %>" dataformat="engup" id="proposalNo" /><button type="button" class="input_seach_btn" onClick="openWinSearchRFA()"></button></td>
						<th>DAR History</th>
						<td><button onclick="openWinSearchDARHistory()" type="button" class="input_seach_btn"></button></td>
						<th>Customer</th>
						<td><input type="text" name="custCd" style="width:70px;" class="input2" id="custCd" /><input type="text" name="custNm" style="width:230px;" class="input2" id="custNm" /> </td>
						<td id="tdBtnAffiliate"><button type="button" name="btn_Affiliate" id="btn_Affiliate" class="btn_etc">Affiliate</button></td>
			   		</tr>
		   		</tbody>
		   	</table>
		   	<table>
		   		<tbody>	
		   			<colgroup>
						<col width="70">				
						<col width="130">				
						<col width="100">				
						<col width="130">				
						<col width="123">				
						<col width="68">				
						<col width="94">				
						<col width="130">				
						<col width="45">				
						<col width="*">				
				   </colgroup> 
			   		<tr>
			   			<th>APVL OFC</th>
			   			<td>
						<script type="text/javascript">ComComboObject('approvalOfcCd', 1 ,80 , 1 , 1 , 0, true);</script>
						</td>
						<th>DAR No.</th>
						<td><script type="text/javascript">ComComboObject('combo1', 1, 140, 1, 0, 0, true)</script></td>
						<th>Version</th>
						<td><select name="version" id="version" style="width:50px;" class="input" onchange="doActionRetrieveByVerChange()"></select></td>
						<th>APVL No.</th>
						<td><script type="text/javascript">ComComboObject('combo2', 1, 135, 1, 0, 0, true)</script></td>
						<th>Status</th>
						<td><input type="text" name="status" style="width:117px;" class="input2" id="status" /> </td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_AddBKGReqDetail"  id="btn_AddBKGReqDetail"  type="button">Row Add</button>
				<button class="btn_normal" name="btn_CopyBKGReqDetail" id="btn_CopyBKGReqDetail" type="button">Row Copy</button>
				<button class="btn_normal" name="btn_SaveBKGReqDetail" id="btn_SaveBKGReqDetail" type="button">Save</button>
				<button class="btn_normal" name="btn_DelBKGReqDetail"  id="btn_DelBKGReqDetail"  type="button">Delete</button>
			</div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
		
		<!-- layout_wrap(S) -->
		<div class="layout_wrap" style="width: 100%;margin-bottom: 30px">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width: 40%;margin-right: 2%;">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid">
					<h3><input type="checkbox" name="chkMultiOrgDest" id="chkMultiOrgDest" class="trans" disabled> Multi Origin or Destination</h3>
					<!-- opus_design_btn (S) -->
					<div class="opus_design_btn">
						<button class="btn_accent" name="btn_AddMultiOrgDest" id="btn_AddMultiOrgDest" type="button">Row Add</button>
						<button class="btn_normal" name="btn_DelMultiOrgDest" id="btn_DelMultiOrgDest" type="button">Row Delete</button>
					</div>
					<!-- opus_design_btn (E) -->
					<script type="text/javascript">ComSheetObject('sheet2');</script>		
				</div>
				<!-- opus_design_grid(E) -->
			</div>
		     <!-- layout_vertical_2(E) -->
		     
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width: 58%">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid">
					<h3 class="pad_rgt_12"><input type="checkbox" name="chkRateAdjustment" id="chkRateAdjustment" class="trans" onClick="checkRateAdjustment()"> Rate Adjustment</h3>
					<h3 class="pad_rgt_12">Currency</h3>
					<h3 style="position: relative;top: -5px;"><select name="currency" id="currency" style="width:80px;" class="input" onChange="setCurrencyVal()"></select></h3>
					<!-- opus_design_btn (S) -->
					<div class="opus_design_btn">
						<button class="btn_accent" name="btn_AddRateAdjustment" id="btn_AddRateAdjustment" type="button">Row Add</button>
						<button class="btn_normal" name="btn_DelRateAdjustment" id="btn_DelRateAdjustment" type="button">Row Delete</button>
					</div>
					<!-- opus_design_btn (E) -->
					<script type="text/javascript">ComSheetObject('sheet3');</script>		
				</div>
				<!-- opus_design_grid(E) -->
			</div>
		     <!-- layout_vertical_2(E) -->
		</div>
		<!-- layout_wrap(E) -->
		
		<!-- layout_wrap(S) [2016.01.04] NYK Add start -->
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div class="layout_wrap" style="width: 100%; margin-bottom: 30px">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:49%;margin-right:2%;">
				<div class="opus_design_grid">
					<h3 style="height: 26px"><input type="checkbox" name="chkFreeTime" id="chkFreeTime" class="trans" disabled> Tiered Free Time</h3>
					<div class="opus_design_btn"> 
						<span id="btnAddFreeTimeLayer"><button  class="btn_normal" type="button" name="btn_AddFreeTime" id="btn_AddFreeTime">Row Add</button></span>
						<span id="btnDelFreeTimeLayer" ><button class="btn_normal" type="button" name="btn_DelFreeTime" id="btn_DelFreeTime">Row Delete</button></span>
					</div>
					<script type="text/javascript">ComSheetObject('sheet5');</script>
				</div>
			</div>
		     <!-- layout_vertical_2(E) -->
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width: 49%;">
				<div class="opus_design_grid" id="mainTable">
					<h3 class="pad_rgt_12" style="height: 26px">Commodity</h3>
					<div class="opus_design_btn">
						<span id="btnAddCommodityLayer"><button class="btn_normal" type="button" name="btn_AddCommodity" id="btn_AddCommodity">Row Add</button></span>
						<span id="btnDelCommodityLayer"><button class="btn_normal" type="button" name="btn_DelCommodity" id="btn_DelCommodity">Row Delete</button></span>
					</div>
					<script type="text/javascript">ComSheetObject('sheet6');</script>
				</div>
			</div>
		     <!-- layout_vertical_2(E) -->
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<!-- layout_wrap(E) [2016.01.04] NYK Add e n d -->
		
		<!-- layout_wrap(S) -->
		<div class="layout_wrap" style="width: 100%">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width: 49%;margin-right: 2%;">
				<!-- opus_design_grid(S) -->
				<h3 class="title_design">Comment History</h3>
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet4');</script>		
				</div>
				<!-- opus_design_grid(E) -->
			</div>
		     <!-- layout_vertical_2(E) -->
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width: 49%">
				<!-- opus_design_grid(S) -->
				<h3><input type="checkbox" name="chkComment" id="chkComment" class="trans" onClick="checkComment()">Comment </h3>
				<div class="opus_design_grid">
					<textarea name="comment" id="comment" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width:100%;height:100px;background-color:#E8E7EC;"></textarea>		
				</div>
				<!-- opus_design_grid(E) -->
			</div>
		     <!-- layout_vertical_2(E) -->
		</div>
		<!-- layout_wrap(E) -->
	</div>
	<!-- wrap_result(E) -->
</div>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>

</form>			
