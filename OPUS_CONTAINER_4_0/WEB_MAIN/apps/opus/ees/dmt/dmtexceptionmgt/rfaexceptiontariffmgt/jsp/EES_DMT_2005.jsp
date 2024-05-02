<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2005.jsp
*@FileTitle  : DEM/DET Adjustment Request - Before Booking Approval 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2005Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strOfc_cd	= "";
	String strUsr_rhq 	= "";

	Logger log = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");
	
	String darNo 	= request.getParameter("dar_no") 	!= null ? (String)request.getParameter("dar_no") 	: "" ;
	String caller 	= request.getParameter("caller") 	!= null ? (String)request.getParameter("caller") 	: "" ;
	String sheetId 	= request.getParameter("sheetId") 	!= null ? (String)request.getParameter("sheetId") 	: "" ;
	
	boolean isPopup = darNo.length() > 0 && caller.length() > 0 ? true : false;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  	= account.getUsr_id();
		strUsr_nm 	  	= account.getUsr_nm();
		strOfc_cd 	  	= account.getOfc_cd();
		strUsr_rhq 		= account.getRhq_ofc_cd();
	   
		event = (EesDmt2005Event)request.getAttribute("Event");
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
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="caller" 	value="<%= caller %>">
<input type="hidden" name="sheetId" value="<%= sheetId %>">
<input type="hidden" name="popup_flag">
<input type="hidden" name="popup_upd_dt">
<input type="hidden" name="prop_no">
<input type="hidden" name="cust_seq">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="rfa_expt_dar_no">
<input type="hidden" name="rfa_expt_mapg_seq">
<input type="hidden" name="rfa_expt_ver_seq">
<input type="hidden" name="rfa_rqst_dtl_seq">
<input type="hidden" name="rfa_expt_apro_no">
<input type="hidden" name="apro_ofc_cd">
<input type="hidden" name="cvrg_cmb_seq" id="cvrg_cmb_seq" /><!-- [2016.01.04] NYK Add -->
<!-- Parameters for saving Comment History  -->
<input type="hidden" name="prog_seq">
<input type="hidden" name="prog_rmk">
<!-- Parameters for Serarching Common code of CNTR/Cargo Type -->
<input type="hidden" name="code1" value="CD02053">
<input type="hidden" name="code2" value="CD01963">
<!-- Parameters for dividing Common or Rep Commodity -->
<input type="hidden" name="prc_cmdt_tp_cd">
<input type="hidden" name="dmdt_expt_rqst_sts_cd">
<input type="hidden" name="dmdt_expt_rqst_sts_desc">
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<!-- Comparing  Continent , inputing BKG POR(O) or DEL(I)  Continent and  Coverage of BKG POR(O) or DEL(I)'Cnt_cd-->
<input type="hidden" name="fnl_dest_cnt_cd">
<input type="hidden" name="pagerows">
<!-- Parameters for checking  button authority -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">
<input type="hidden" name="usr_id" 		value="<%= strUsr_id %>">
<input type="hidden" name="usr_role_cd" value="DMT01,DMT02,DMT03,DMT04">
<input type="hidden" name="pgm_no" 		value="EES_DMT_2005">
<input type="hidden" name="ofc_cd" 		value="<%= strOfc_cd %>">
<input type="hidden" name="rhq_ofc_cd" 	value="<%= strUsr_rhq %>">
<!-- Parameters for checking Calculation Type  -->
<input type="hidden" name="chk_calc_tp_in">
<input type="hidden" name="dmdt_ctrt_expt_tp_cd" value="B">
<input type="hidden" name="chk_calc_tp_combined">
<input type="hidden" name="result">
<input type="hidden" name="result_cnt">
<input type="hidden" name="result_ste">
<input type="hidden" name="result_rgn">
<input type="hidden" name="result_loc">
<!--Parameters for sending email about  Approval, Counter Offer, Reject -->
<input type="hidden" name="rfa_no">
<input type="hidden" name="cust_cd">
<input type="hidden" name="cust_nm">
<!--Parameters for checking Duplication -->
<input type="hidden" name="max_ver_status">
<input type="hidden" name="max_ver">


<% if (isPopup) { %>
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
 
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title"></span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn" id="btnPopUpLayer" style="display:none">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_Approval" id="btn_Approval">Approval</button><!--
		 --><button type="button" class="btn_normal" name="btn_CounterOffer" id="btn_CounterOffer">Counter Offer</button><!--
		 --><button type="button" class="btn_normal" name="btn_Reject" id="btn_Reject">Reject</button><!--
		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		
		<div id="btnCloseLayer" style="display:none">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">

<!-- popup_title_area(E) -->
<%	} else { %>
		<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	   
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn" id="btnMainLayer" style="display:none">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_Approval" id="btn_Approval">Approval</button><!--
		 --><button type="button" class="btn_normal" name="btn_CounterOffer" id="btn_CounterOffer">Counter Offer</button><!--
		 --><button type="button" class="btn_normal" name="btn_Reject" id="btn_Reject">Reject</button>
		</div>
		<!-- opus_design_btn(E) -->
		
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
<!-- page_title_area(E) -->
<% } %>

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="70" />
	            <col width="105" />
	            <col width="100" />
	            <col width="130" />
	            <col width="120" />
	            <col width="100" />
	            <col width="70" />
	            <col width="80" />
	            <col width="65" />
	            <col width="100" />
	            <col width="60" />
	            <col width="*" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>RFA No.</th>
					<td><input type="text" name="rFANo" style="width:90px;" class="input2"></td>
					<th>Proposal No.</th>
					<td><input type="text" name="proposalNo" style="width:92px;" class="input2"><!--
					--><button type="button" class="input_seach_btn"  onClick="openWinSearchRFA()"></button></td>
					<th>DAR History</th>
					<td><button type="button" class="input_seach_btn"  onClick="openWinSearchDARHistory()"></button></td>
					<th>Customer</th>
					<td colspan="3"><input type="text" name="custCd" style="width:70px;" class="input2"><input type="text" name="custNm" style="width:237px;" class="input2"></td>
					<td id="tdBtnAffiliate" align="right" width="50px">
						<button type="button" class="btn_etc" name="btn_Affiliate" id="btn_Affiliate">Affiliate</button>
					</td>
					<td></td>
				</tr>
				
				<tr class="h23">
					<th>APVL OFC</th>
					<td><input type="text" name="approvalOfcCd" style="width:90px;" class="input2"></td>
					<th>DAR No.</th>
					<td><input type="text" name="darNo" style="width:122px;ime-mode:disabled" value="<%=darNo%>" class="input2" dataformat="engup" maxlength="15"></td>
					<th>Version</th>
					<td><select name="version" style="width:53px;" class="input" onChange="checkRFAByVersion()"></select></td>
					<th>APVL No.</th>
					<td><input type="text" name="approvalNo" style="width:120px;ime-mode:disabled" class="input2" dataformat="engup"></td>
					<th>Status</th>
					<td><input type="text" name="status" style="width:109px;" class="input2"></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
	
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">

		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- layout_wrap(S) -->
	<% if (isPopup) { %>
	<div class="layout_wrap" style="width:100%;margin-bottom:30px">
	<% } else { %>
	<div class="layout_wrap" style="width:100%">
	<% } %>
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 40%;margin-right:2%;">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<h3 style="height:25px;"><input type="checkbox" name="chkMultiOrgDest" id="chkMultiOrgDest" class="trans"> Multi Origin or Destination</h3>
				<script type="text/javascript">ComSheetObject('sheet2');</script>		
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	     <!-- layout_vertical_2(E) -->
	     
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 58%">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<h3 class="pad_rgt_12"><input type="checkbox" name="chkRateAdjustment" id="chkRateAdjustment" class="trans"> Rate Adjustment</h3>
				<h3 class="pad_rgt_12">Currency</h3>
				<h3 style="position: relative;top: -5px;"><input type="text" name="currency" id="currency" style="width:80;" class="input2"></h3>
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
				<script type="text/javascript">ComSheetObject('sheet5');</script>
			</div>
		</div>
	     <!-- layout_vertical_2(E) -->
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 49%;">
			<div class="opus_design_grid" id="mainTable">
				<h3 class="pad_rgt_12" style="height: 26px">Commodity</h3>
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
				<textarea name="comment" id="comment" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width:100%;height:122px;background-color:#E8E7EC;"></textarea>		
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	     <!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>

<% if (isPopup) { %>
</div>
<% } %>
<!-- wrap_result(E) -->
</form>
