<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0426.jsp
*@FileTitle  : RDN Issuance by Regional Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0426Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0426Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	//String strUsr_office_nm = "";
	
    String[] rhqs = null;
    String[] discrepancyKinds = null;
    String[] rdnIssRsnCds = null;
    String[] auditTools = null;
	
	Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.RevenueDebitNote");
	
	String rdn_no_pop = JSPUtil.getNull(request.getParameter("rdn_no"));
	String blNo = JSPUtil.getNull(request.getParameter("bl_no"));
	String rctRhqCdPop = JSPUtil.getNull(request.getParameter("rct_rhq_cd"));
	String rctOfcCdPop = JSPUtil.getNull(request.getParameter("rct_ofc_cd"));
	String isPop = JSPUtil.getNull(request.getParameter("isPop"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strUsr_office_cd =	account.getOfc_cd();
		//strUsr_office_nm =  account.getOfc_eng_nm();

		event = (EsmBkg0426Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // Discrepancy Kind 1
        discrepancyKinds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("discrepancyKind"), false);
        // Discrepancy Kind 3
        rdnIssRsnCds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rdnIssRsnCd"), false , "|", "\t", "getCode", "getName");
        // Audit Tool 
        auditTools = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("auditTool"), false , "|", "\t", "getCode", "getName");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var gStrUsr_office_cd = "<%=strUsr_office_cd%>";
    var rhqComboValue = "<%=rhqs[0]%>";
    var discrepancyKindComboValue = "<%=discrepancyKinds[0]%>";
    var discrepancyKindComboText = "<%=discrepancyKinds[1]%>";
    var rdnIssRsnCdComboValue = "<%=rdnIssRsnCds[0]%>";
    var rdnIssRsnCdComboText = "<%=rdnIssRsnCds[1]%>";
    var auditToolComboValue = "<%=auditTools[0]%>";
    var auditToolComboText = "<%=auditTools[1]%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- rdn_no -->
<input type="hidden" name="rdn_no" value="" id="rdn_no" />
<!-- revise_seq -->
<input type="hidden" name="rvis_seq" value="" id="rvis_seq" />
<!-- PROG_SEQ -->
<input type="hidden" name="prog_seq" value="" id="prog_seq" />
<!-- rdn status cd -->
<input type="hidden" name="rdn_sts_cd" value="" id="rdn_sts_cd" />
<!-- combo -->
<input type="hidden" name="cd" value="" id="cd" />
<input type="hidden" name="etc1" value="" id="etc1" />
<input type="hidden" name="etc2" value="" id="etc2" />
<input type="hidden" name="etc3" value="" id="etc3" />

<input type="hidden" name="rct_ofc_cd_hidden" value="" id="rct_ofc_cd_hidden" />
<input type="hidden" name="respb_ofc_cd_hidden" value="" id="respb_ofc_cd_hidden" />
<input type="hidden" name="umch_sub_tp_cd_hidden" value="" id="umch_sub_tp_cd_hidden" />

<!-- BOOKING -->
<input type="hidden" name="bkg_no" value="" id="bkg_no" />
<input type="hidden" name="bkg_no_split" value="" id="bkg_no_split" />
<input type="hidden" name="cntBlno" value="0" id="cntBlno" />

<!--when call pop, rdn_no	-->
<input type="hidden" name="isPop" value="<%=isPop%>" id="isPop" />
<input type="hidden" name="rdn_no_pop" value="<%=rdn_no_pop%>" id="rdn_no_pop" />
<input type="hidden" name="rct_rhq_cd_pop" value="<%=rctRhqCdPop%>" id="rct_rhq_cd_pop" />
<input type="hidden" name="rct_ofc_cd_pop" value="<%=rctOfcCdPop%>" id="rct_ofc_cd_pop" />

<!-- CTRT_TP_CD -->
<input type="hidden" name="ctrt_tp_cd" value="" id="ctrt_tp_cd" />
<input type="hidden" name="rdn_iss_dt_wk" value="" id="rdn_iss_dt_wk" />

<!-- Groupware Popup -->
<input type="hidden" name="gw_subject" id="gw_subject" />
<input type="hidden" name="gw_contents" id="gw_contents" />
<input type="hidden" name="gw_template" id="gw_template" />
<input type="hidden" name="gw_args" id="gw_args" />



<%if("Y".equals(isPop)) { %>

<div class="layer_popup_title">
	<div class="page_title_area clear">

		<h2 class="page_title"><span id="title">RDN Issuance by Auditor</span></h2>

		<div class="opus_design_btn">
		
		<!-- 
			--><button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
			--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
			--><button class="btn_normal" name="btn_Issue" id="btn_Issue" type="button">Issue</button><!--
			--><button class="btn_normal" name="btn_Revise" id="btn_Revise" type="button">Revise</button><!--
			--><button class="btn_normal" name="btn_Cancel" id="btn_Cancel" type="button">Cancel</button><!--
			--><button class="btn_normal" name="btn_Settle" id="btn_Settle" type="button">Settle</button><!--
			--><button class="btn_normal" name="btn_Copy" id="btn_Copy" type="button">Copy</button><!--
			--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
		    --><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!-- 
		 --></div>
	</div>
</div>


<%}else{%>
<div class="page_title_area clear">
	<h2 class="page_title"><button type="button"><span id="title">RDN Issuance by Auditor</span></button></h2>
	
	<div class="opus_design_btn"><!-- 
		--><button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Issue" id="btn_Issue" type="button">Issue</button><!--
		--><button class="btn_normal" name="btn_Revise" id="btn_Revise" type="button">Revise</button><!--
		--><button class="btn_normal" name="btn_Cancel" id="btn_Cancel" type="button">Cancel</button><!--
		--><button class="btn_normal" name="btn_Settle" id="btn_Settle" type="button">Settle</button><!--
		--><button class="btn_normal" name="btn_Copy" id="btn_Copy" type="button">Copy</button><!--
		--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!-- 
		--><%if("Y".equals(isPop)) { %><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><%} %><!-- 
	 --></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
</div>
<%} %>

<%if("Y".equals(isPop)) { %><div class="layer_popup_contents"><%} %>
<div class="opus_design_grid" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet0');</script>
</div>

<div class="wrap_search sm">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table style="width:979px;">
			<tbody>
				<colgroup>
					<col width="105">
					<col width="130">
					<col width="100">
					<col width="300">
					<col width="110">
					<col width="130">
					<col width="*">
				</colgroup>
				<tr>
					<th>RDN No. </th>				   
					<td><script type="text/javascript"> ComComboObject('rdn_no_cd', 1, 100, 0, 1, 0, true);</script></td>
					<th>B/L No. </th>
					<td colspan="5"><input type="text" class="input1" style="width:100px;text-align:center;ime-mode:disabled" name="bl_no" id="bl_no" value="<%=blNo%>" caption="B/L No" dataformat="engup" maxLength="12"></td> 
				</tr>
				<tr>
					<th>Issue Office</th>
					<td><input type="text" name="iss_ofc_cd" id="iss_ofc_cd" style="width:100px;text-align:center;" class="input2" value="<%=strUsr_office_cd %>" readonly></td>
					<th>Status</th>
					<td><input type="text" name="rdn_sts_nm" id="rdn_sts_nm" style="width:100px;text-align:center;" class="input2" value="" readonly ></td> 
					<th>Issue Date </th>
					<td><input type="text" name="rdn_iss_dt" id="rdn_iss_dt" style="width:100px;text-align:center;" class="input2" value="" readonly></td> 
					<th>Status Update Date </th>
					<td><input type="text" name="sts_upd_dt" id="sts_upd_dt" maxlength="10" style="width:100px;text-align:center;" class="input2" value="" readonly></td> 
				</tr>
				<tr>
					<th>Receipt RHQ</th>	
					<td><script type="text/javascript"> ComComboObject('rct_rhq_cd', 1, 100, 0, 1, 0, false);</script></td>
					<th>Receipt Office </th>	
					<td><script type="text/javascript"> ComComboObject('rct_ofc_cd', 1, 100, 0, 1, 0, false);</script></td>
					<th>Responsible RHQ</th>
					<td><script type="text/javascript"> ComComboObject('respb_rhq_cd', 1, 100, 0, 1, 0, false);</script></td>
					<th>Responsible Office</th>
					<td><script type="text/javascript"> ComComboObject('respb_ofc_cd', 1, 100, 0, 1, 0, false);</script></td>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap" style="height:190px">
		    <div class="layout_vertical_2" style="width:530px;">
		        <table>
					<tbody>
						<colgroup>
							<col width="105">
							<col width="*">
						</colgroup>
						<tr>
							<th>Error Kind</th>
							<td><script type="text/javascript">ComComboObject('umch_tp_cd', 1, 123, 0, 1, 0, false);</script><!-- 
							 --><script type="text/javascript">ComComboObject('umch_sub_tp_cd', 1, 120, 0, 1, 0, false);</script><!-- 
							 --><script type="text/javascript">ComComboObject('rdn_iss_rsn_cd', 1, 120, 0, 1, 0, false);</script></td>		
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<colgroup>
							<col width="105">
							<col width="*">
						</colgroup>
						<tr>
							<th>Error Remarks</th>
							<td><input type="text" name="umch_rmk" id="umch_rmk" style="width:371px;ime-mode:disabled" class="input" value=""></td>	
						</tr>
						<tr>
							<th>Audit Tool</th>
							<td><script type="text/javascript"> ComComboObject('rev_aud_tool_cd', 1, 200, 0, 1, 0, false);</script></td>		
						</tr>
					</tbody>
				</table>
		    </div>
		    <div class="layout_vertical_2" style="width:510px;">
		        <table>
					<tbody>
						<colgroup>
							<col width="85">
							<col width="*">
						</colgroup>
						<tr>
							<th>Contract No.</th>
							<td><input type="text" name="sc_rfa_no" id="sc_rfa_no" style="width:100px;text-align:center" class="input2" value="" readonly></td>		
						</tr>
					</tbody>
				</table>
				<div class="opus_design_grid" style="width:510px;">
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" id="btn_RowAdd" name="btn_RowAdd">Row Add</button><!--  
						--><button type="button" class="btn_normal" id="btn_Delete" name="btn_Delete">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
		    </div>
		</div>
		<!-- layout_wrap(E) -->
		<div class="line_bluedot"></div>
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:530px;">
		        <table style="width:510px;background-color:white;" class="grid_2">
					<tbody>
						<colgroup>
							<col width="250">
							<col width="*">
						</colgroup>
						<tr>
							<td class="sm"><b>Remarks (Auditor)</b></td>
							<td style="background-color:#F3F2F8; border:0px;"></td>
						</tr>								
						<tr><td colspan="2"><textarea name="rdn_rmk" id="rdn_rmk" cols="" rows="4" style="width:100%;ime-mode:disabled;resize:none;"></textarea></td></tr>
					</tbody>
				</table>
		    </div>
		    <div class="layout_vertical_2" style="width:590px;">
		       <table style="width:510px;background-color:white;" class="grid_2">
					<tbody>
						<colgroup>
							<col width="250">
							<col width="*">
						</colgroup>
						<tr>
							<td align="center" class="sm"><b>Remarks (Office)</b></td>
							<td style="background-color:#F3F2F8; border:0px;" align="right"><strong>C/A No.</strong>&nbsp;&nbsp;<input type="text" class="input" name="bkg_corr_no" id="bkg_corr_no" style="width:141px;text-align:center" value="" readonly>
							</td>
						</tr>								
						<tr><td colspan="2"><textarea class="textarea2" name="receiver_rmk" id="receiver_rmk" cols="" rows="4" style="width:100%; resize:none;" readonly> </textarea></td></tr>
					</tbody>
				</table>
		    </div>
		</div>
		<!-- layout_wrap(E) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<div class="opus_design_grid" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
</div>
<%if("Y".equals(isPop)) { %></div><%} %>
</form>