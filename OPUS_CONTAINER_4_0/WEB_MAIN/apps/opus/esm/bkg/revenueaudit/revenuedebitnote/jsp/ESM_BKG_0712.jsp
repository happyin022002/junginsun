<%
/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0712.jsp
*@FileTitle  : RDN Receipt by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0712Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0712Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	//String strUsr_office_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.RevenueDebitNote");
	
	String rdn_no_pop = JSPUtil.getNull(request.getParameter("rdn_no"));
	String isPop = JSPUtil.getNull(request.getParameter("isPop"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strUsr_office_cd =	account.getOfc_cd();
		//strUsr_office_nm =  account.getOfc_eng_nm();

		event = (EsmBkg0712Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd" 	id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- rdn_no -->
<input type="hidden" name="rdn_no" 	id="rdn_no" 	value="">
<!-- revise_seq -->
<input type="hidden" name="rvis_seq" id="rvis_seq" 	value="">
<!-- PROG_SEQ -->
<input type="hidden" name="prog_seq" id="prog_seq" 	value="">
<!-- rdn status cd -->
<input type="hidden" name="rdn_sts_cd" id="rdn_sts_cd" value="">
<!-- combo -->
<input type="hidden" name="cd" id="cd"  value=""> 
<input type="hidden" name="etc1" 	id="etc1" value="">
<input type="hidden" name="etc2" 	id="etc2" value="">
<input type="hidden" name="etc3" 	id="etc3" value="">

<!-- BOOKING -->
<input type="hidden" name="bkg_no" 	id="bkg_no"  	 value=""> 
<input type="hidden" name="bkg_no_split" 	id="bkg_no_split" value="">
<!-- ca no count -->
<!--<input type="hidden" 	name="count_bkg_corr_no" id="count_bkg_corr_no" 	value=""> -->

<!--  rdn_no in case of calling pop	-->
<input type="hidden" name="rdn_no_pop" id="rdn_no_pop" value="<%=rdn_no_pop %>">

<!-- CTRT_TP_CD -->
<input type="hidden" name="ctrt_tp_cd" id="ctrt_tp_cd" value=""> 

<!-- LOGIN OFFICE CODE -->
<input type="hidden" name="in_user_ofc_cd" 	id="in_user_ofc_cd" 	value="<%=strUsr_office_cd%>"> 

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->	
	<div class="opus_design_btn">
		<button type="button" 		class="btn_accent" name="btn_Retrieve" 			id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" 		class="btn_normal" name="btn_New"  				id="btn_New">New</button><!--
		--><button type="button" 		class="btn_normal" name="btn_Save"  			id="btn_Save">Save</button><!--
		--><button type="button" 		class="btn_normal" name="btn_Accept" 			id="btn_Accept">Accept</button><!--
		--><button type="button" 		class="btn_normal" name="btn_ReviseRequest" 	id="btn_ReviseRequest">Revise Request</button><!--
		--><button type="button" 		class="btn_normal" name="btn_CancelRequest" 	id="btn_CancelRequest">Cancel Request</button><!--
		--><button type="button" 		class="btn_normal" name="btn_Print" 			id="btn_Print">Print</button>
		<%if("Y".equals(isPop)){%>
		<button type="button" 		class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>
		<%}%>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="80px;"/>
				<col width="120px;"/>
				<col width="100px;"/>
				<col width="186px;"/>
				<col width="100px;"/>
				<col width="120px;"/>
				<col width="140px;"/>
				<col width="*" />
		    </colgroup>
			<tr>
				<th>RDN No. </th>
				<td><script type="text/javascript"> ComComboObject('rdn_no_cd', 1, 100, 0, 1, 0, true);</script></td>
				<th>B/L No. </th>
				<td colspan="5">
					<input type="text" name="bl_no" 		id="bl_no" 			style="width:100px;text-align:center;ime-mode:disabled" class="input1"  value="" caption="B/L No" dataformat="engup" maxLength="12">
				</td> 
			</tr>
			<tr>
				<th>Issue Office</th>
				<td>
					<input type="text" name="iss_ofc_cd" 	id="iss_ofc_cd" 	style="width:100px;text-align:center;" 					class="input2" 	value="" readonly>
				</td>
				<th>Status</th>
				<td>
					<input type="text" name="rdn_sts_nm" 	id="rdn_sts_nm" 	style="width:100px;text-align:center;" 					class="input2" 	value="" readonly>
				</td> 
				<th>Issue Date </th>
				<td>
					<input type="text" name="rdn_iss_dt" 	id="rdn_iss_dt" 	style="width:100px;text-align:center;" 					class="input2" 	value="" readonly>
				</td> 
				<th>Status Update Date</th>
				<td>
					<input type="text" name="sts_upd_dt" 	id="sts_upd_dt" 	style="width:100px;text-align:center;" 					class="input2" 	value="" readonly maxlength="10">
				</td> 
			</tr>
			<tr>
				<th>RHQ</th>
				<td>
					<input type="text" name="rct_rhq_cd" 	id="rct_rhq_cd" 	style="width:100px;text-align:center;" 					class="input2" 	value="" readonly>
				</td>
				<th>Receipt Office </th>
				<td>
					<input type="text" name="rct_ofc_cd" 	id="rct_ofc_cd" 	style="width:100px;text-align:center;" 					class="input2" 	value="" readonly>
				</td>
				<th>Responsible RHQ</th>
				<td>
					<input type="text" name="respb_rhq_cd" 	id="respb_rhq_cd" 	style="width:100px;text-align:center;" 					class="input2" 	value="" readonly>
				</td> 
				<th>Responsible Office</th>
				<td>
					<input type="text" name="respb_ofc_cd" 	id="respb_ofc_cd" 	style="width:100px;text-align:center;" 					class="input2" 	value="" readonly>
				</td> 
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="80px;"/>
				<col width="410px;"/>
				<col width="100px;"/>
				<col width="*" />
		    </colgroup>
			<tr>
				<th>Error Kind</th>
				<td>
					<input type="text" name="umch_tp_cd" 		id="umch_tp_cd"			style="width:118px;" class="input2" value="" readonly><!-- 
					--><input type="text" name="umch_sub_tp_cd" 	id="umch_sub_tp_cd"		style="width:118px;" class="input2" value="" readonly><!--
				    --><input type="text" name="rdn_iss_rsn_cd" 	id="rdn_iss_rsn_cd"		style="width:118px;" class="input2" value="" readonly>
				</td>
				<th>Contract No.</th>
				<td>
					<input type="text" name="sc_rfa_no" 		id="sc_rfa_no" 			style="width:100px;text-align:center;" class="input2" value="" readonly>
				</td>		
			</tr>
		</tbody>
	</table>

<!-- opus_design_inquiry(E) -->
</div>


<!-- Hidden sheet for Transaction (S) -->
<div style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet0');</script>
</div>
<!-- Hidden sheet for Transaction (E) -->

<div class="layout_wrap" style="height:120px">

   <!-- layout_vertical_2(S) -->
   <div  class="layout_flex_fixed" style="width:500px">
       <!-- opus_design_grid(S) -->
       <div class="opus_design_inquiry">       
            <table>
			<tbody>
				<colgroup>
					<col width="1px;"/>
					<col width="386px;"/>
			    </colgroup>
				<tr>
					<th style="padding-top: 0px;">Error Remarks</th>
					<td style="padding-top: 5px;">
						<input type="text" name="umch_rmk" id="umch_rmk" style="width:366px;" class="input2" value="" readonly>
					</td>		
				</tr>
				<tr>
					<th style="padding-top: 0px;">Audit Tool</th>
					<td style="padding-top: 5px;">
						<input type="text" name="rev_aud_tool_cd" id="rev_aud_tool_cd" style="width:200px;" class="input2" value="" readonly>
					</td>		
				</tr>
			</tbody>
		</table>
       </div>
       <!-- opus_design_grid(E) -->
   </div>
   <!-- layout_vertical_2(E) -->
   
    <!-- layout_vertical_2(S) -->
   <div class="layout_flex_flex" style="padding-left:498px">
       <!-- opus_design_inquiry(S) -->
       <div class="opus_design_grid" style="width:498px">
          <script type="text/javascript">ComSheetObject('sheet1');</script>
       </div>
       <!-- opus_design_inquiry(E) -->
   </div>
   <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) --> 


<div class="line_bluedot"></div>
<div class="opus_design_inquiry wFit">

<div class="layout_wrap">
	 <div class="pad_left_8 layout_flex_fixed" style="width:50%">	
		<div class="opus_design_inquiry ">
		<table>
				<tbody>
					<colgroup>
						<col width="120"/>
						<col width="*" />
				    </colgroup>
					<tr>
						<th style="height:26px !important; ">Remarks (Auditor)</th>
						<td></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center; padding:2px 3px 2px 3px; height:65px;">
							<textarea name="rdn_rmk" id="rdn_rmk" cols="" rows="4" style="width:98%; resize: none;" class="textarea2" readonly></textarea>
						</td>
					</tr>
				</tbody>
			</table>		
		</div>
	</div>
	  <div class="layout_flex_fixed" style="width:50%"> 
		<div class="opus_design_inquiry" style="width:99%">
			<table>
				<tbody>
					<colgroup>
						<col width="125"/>
						<col width="*" />
				    </colgroup>
					<tr>
						<th>Remarks (Office)</th>
						<td style="text-align:center;">
							<strong>C/A No.</strong>&nbsp;&nbsp;<input type="text" class="input" style="width:141px;text-align:center;ime-mode:disabled" name="bkg_corr_no" id="bkg_corr_no" value="" caption="C/A No" maxLength="10">
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center; padding:2px 3px 2px 3px; hieght:65px;">
							<textarea name="receiver_rmk" id="receiver_rmk" style="width:100%;ime-mode:disabled;resize: none;" cols="" rows="4"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>
</div>
</form>