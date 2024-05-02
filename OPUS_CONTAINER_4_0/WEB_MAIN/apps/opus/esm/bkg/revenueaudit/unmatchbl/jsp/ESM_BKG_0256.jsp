<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0256.jsp
*@FileTitle  : Unmatch B/L Inquiry by Auditor
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0256Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0256Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] rhqs = null;
	String[] scps = null;
	String[] contiCd = null;
	String[] contractTypes = null;
	String[] errorTypes = null;
	String[] ratingTypes = null;
	String[] status1s = null;
	String[] status2s = null;
	String[] records = null;
	//String[] bdrstatus = null;
	
	Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.UnmatchBL");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0256Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		// rhq
		rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
		// contiCd
		contiCd = RASUtil.getValueObject2StringArray((List<RsltContiListVO>)eventResponse.getCustomData("contiCd"), false , "|", "\t", "getContiCd", "getContiNm");
		// Contract Type
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // Error Type 
        errorTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("errorType"), false , "|", "\t", "getCode", "getName");
        // Rating Type 
        ratingTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ratingType"), false , "|", "\t", "getCode", "getName");
        // status1
        status1s = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("status1"), false , "|", "\t", "getCode", "getName");
        // status2 
        status2s = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("status2"), false , "|", "\t", "getCode", "getName");
        // record 
        records = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("record"), false , "|", "\t", "getCode", "getName");

       // bdrstatus = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("record"), false , "|", "\t", "getCode", "getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";
    var contiCdComboValue = "|<%=contiCd[0]%>";
    var contiCdComboText = "|<%=contiCd[1]%>";

    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
    
    var errorTypeComboValue = "|<%=errorTypes[0]%>";
    var errorTypeComboText = "|<%=errorTypes[1]%>";
    
    var ratingTypeComboValue = "|<%=ratingTypes[0]%>";
    var ratingTypeComboText = "|<%=ratingTypes[1]%>";
    

    var status1ComboValue = "|<%=status1s[0]%>";
    var status1ComboText = "|<%=status1s[1]%>";

    var status2ComboValue = "|<%=status2s[0]%>";
    var status2ComboText = "|<%=status2s[1]%>";

    var recordComboValue = "<%=records[0]%>";
    var recordComboText = "<%=records[1]%>";
   
  


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
<!-- combo -->
<input type="hidden" name="cd" value="" id="cd" />
<input type="hidden" name="etc1" value="" id="etc1" />
<input type="hidden" name="etc2" value="" id="etc2" />
<input type="hidden" name="etc3" value="" id="etc3" />
<input type="hidden" name="bkg_no_arr" value="" id="bkg_no_arr" />
<!-- BACKEND JOB -->
<input type="hidden" name="backendjob_key" value="" id="backendjob_key" />
<!-- Error Seq -->
<input type="hidden" name="audit_seq_cd" value="" id="audit_seq_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="90" />
				<col width="120" />
				<col width="100" />
				<col width="90" />
				<col width="10" />
				<col width="90" />
				<col width="60" />
				<col width="90" />
				<col width="60" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>RHQ</th>
				<td><script type="text/javascript"> ComComboObject('rct_rhq_cd', 1, 75, 0, 0, 0, false);</script></td>
				<th>Office</th>
				<td><script type="text/javascript"> ComComboObject('rct_ofc_cd', 1, 65, 0, 0, 0, false);</script></td>
				<td><input type="radio" name="dt_type" value="ETD" class="trans" checked="" id="dt_type" />  Audit Date(I)
					<input type="radio" name="dt_type" value="PCT" class="trans" id="dt_type"> POL ETD</td>
				<td>
				<input name="rt_aply_dt_from" type="text" style="width:80px;text-align:center;" class="input1" caption="From Date" dataformat="ymd" maxlength="10" minlength="8" id="rt_aply_dt_from" />
				<button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>
				~
				<input name="rt_aply_dt_to" type="text" style="width:80px;text-align:center;" class="input1" caption="To Date" dataformat="ymd" maxlength="10" minlength="8" id="rt_aply_dt_to" />
				<button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
				</td>
				<th>T/VVD</th>
				<td><input type="text" name="vvd_cd" style="width:83px;text-align:center;ime-mode:disabled" value="" caption="T/VVD" dataformat="engup" maxlength="9" id="vvd_cd" /></td>
				<th>B/L No.</th>
				<td><input type="text" name="bl_no" style="width:105px;text-align:center;ime-mode:disabled" value="" caption="B/L No" dataformat="engup" maxlength="12" id="bl_no" /></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="90" />
				<col width="120" />
				<col width="100" />
				<col width="90" />
				<col width="90" />
				<col width="170" />
				<col width="60" />
				<col width="100" />
				<col width="100" />
				<col width="90" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>BDR Status</th>
				<td><script type="text/javascript"> ComComboObject('bdr_status_cd', 1, 75, 0, 0, 0, false);</script></td>
				<th>POR/DEL Cont.</th>
                <td><script type="text/javascript">ComComboObject('conti_cd', 1, 85, 0, 0, 0, false);</script></td>      
                <td><script type="text/javascript">ComComboObject('conti_cd2', 1, 85, 0, 0, 0, false);</script></td> 
				<th>Contract Type</th>
				<td><script type="text/javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 55, 0, 0, 0, false);</script></td>
				<th>Contract No.</th>
				<td><input type="text" name="contract_no" style="width:100px;text-align:center;ime-mode:disabled" value="" caption="Contract No" dataformat="engup" maxlength="12" id="contract_no" /> </td>
				<th>Rating Type</th>
				<td><script type="text/javascript"> ComComboObject('auto_rat_flg', 1, 105, 0, 0, 0, false);</script></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="90" />
				<col width="120" />
				<col width="100" />
				<col width="90" />
				<col width="90" />
				<col width="230" />
				<col width="100" />
				<col width="100" />
				<col width="80" />
				<col width="10" />
				<col width="*" />
			</colgroup>
			<tr class="h23">	
			    <th>Error Type</th>
				<td><script type="text/javascript"> ComComboObject('umch_tp_cd', 1, 100, 0, 0, 0, false);</script></td>
				<th>Charge</th>
                <td><script type="text/javascript">ComComboObject('chg_cd', 2, 55, 0, 0, 0, false);</script></td>
				<th>Error Status </th>
				<td>
				<script type="text/javascript"> ComComboObject('rev_aud_sts_cd', 1, 80, 0, 0, 0, false);</script>
				<script type="text/javascript"> ComComboObject('rev_aud_stl_knd_cd', 1, 140, 0, 0, 0, false);</script>
				</td>
				<th>Rater ID</th>
				<td><input type="text" name="rater_id" style="width:100px;text-align:center;ime-mode:disabled;" value="" maxlength="20" id="rater_id" /></td>
				<th class="sm">Error Seq.</th>
				<td class="sm"><input type="radio" class="trans" name="audit_seq_radio" value="P" checked="" id="audit_seq_radio" /> Present <input type="radio" class="trans" name="audit_seq_radio" value="H" id="audit_seq_radio" />History</td>
				<td></td>
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
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Filtered_Bl" 		id="btn_Filtered_Bl">B/L Count</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ReAudit" 			id="btn_ReAudit">Re-Audit</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Settle" 			id="btn_Settle">Manual Settle</button>		
	</div>
	<!-- opus_design_btn(E) -->
	<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet0');</script>
</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width: 100%">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 380px">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table class="grid2 noinput2">
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="100" />
						<col width="100" />
						<col width="100" />
					</colgroup>
					<tr class="tr2_head">
						<th rowspan="2"  class="align_center">Total</th>
						<th class="align_center">B/L Count</th> 
						<th class="align_center">Error B/L</th>
						<th class="align_center">Error Case</th>
					</tr>
					<tr align="center">
						<td><input type="text" name="filtered_bkg_count" style="width:100px; text-align: center" class="noinput" value="" readonly id="filtered_bkg_count" /> </td>
						<td><input type="text" name="unmatched_bl_count" style="width:100px; text-align: center" class="noinput" value="" readonly id="unmatched_bl_count" /> </td>
						<td><input type="text" name="unmatched_case_count" style="width:100px; text-align: center" class="noinput" value="" readonly id="unmatched_case_count" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
     <!-- layout_vertical_2(E) -->
     <!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 10px">
	<div style="height:50px"></div>
	</div>
	 <!-- layout_vertical_2(E) --> 
     <!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 580px">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table class="grid2 noinput2">
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="100" />
						<col width="100" />
						<col width="100" />
						<col width="100" />
						<col width="100" />
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tr class="tr2_head">
						<th class="align_center">Error Kind</th>
						<th class="align_center">A1</th>
				        <th class="align_center">A2</th>
						<th class="align_center">B</th>
						<th class="align_center">C</th>
						<th class="align_center">D</th>
						<th class="align_center">E</th>
						<th class="align_center">F</th>
						</tr>
					<tr align="center">
					    <th class="align_center">Total</th>
						<td><input type="text" name="unmatch_al" style="width:60px; text-align: center;" class="noinput" value="" readonly id="unmatch_al" /> </td>
					    <td><input type="text" name="unmatch_all" style="width:60px; text-align: center;" class="noinput" value="" readonly id="unmatch_all" /> </td>
						<td><input type="text" name="unmatch_b" style="width:60px; text-align: center;" class="noinput" value="" readonly id="unmatch_b" /> </td>
						<td><input type="text" name="unmatch_c" style="width:60px; text-align: center;" class="noinput" value="" readonly id="unmatch_c" /> </td>
						<td><input type="text" name="unmatch_d" style="width:60px; text-align: center;" class="noinput" value="" readonly id="unmatch_d" /> </td>
						<td><input type="text" name="unmatch_e" style="width:60px; text-align: center;" class="noinput" value="" readonly id="unmatch_e" /> </td>
						<td><input type="text" name="unmatch_f" style="width:60px; text-align: center;" class="noinput" value="" readonly id="unmatch_f" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
     <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
