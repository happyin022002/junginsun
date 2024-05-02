<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0701.jsp
*@FileTitle  : Unmatch B/L Inquiry by Office
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
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0701Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0701Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRhq_ofc_cd    = "";
	String strOfc_cd        = "";
	
    String[] rhqs = null;
    String[] contiCd = null;
    String[] contractTypes = null;
    String[] errorTypes = null;
    String[] ratingTypes = null;
    String[] status1s = null;
    String[] status2s = null;
    String[] records = null;
	
	Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.UnmatchBL");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0701Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
     	// rhq
        contiCd = RASUtil.getValueObject2StringArray((List<RsltContiListVO>)eventResponse.getCustomData("contiCd"), false, "|", "\t", "getContiCd", "getContiNm");
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

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

	function setupPage(){
		
		rhqComboValue = "|<%=rhqs[0]%>";
	    contiCdComboValue = "|<%=contiCd[0]%>";
	    contiCdComboText = "|<%=contiCd[1]%>";

	    contractTypeComboValue = "|<%=contractTypes[0]%>";
	    contractTypeComboText = "|<%=contractTypes[1]%>";
	    
	    errorTypeComboValue = "|<%=errorTypes[0]%>";
	    errorTypeComboText = "|<%=errorTypes[1]%>";
	    
	    ratingTypeComboValue = "|<%=ratingTypes[0]%>";
	    ratingTypeComboText = "|<%=ratingTypes[1]%>";

	    status1ComboValue = "|<%=status1s[0]%>";
	    status1ComboText = "|<%=status1s[1]%>";

	    status2ComboValue = "|<%=status2s[0]%>";
	    status2ComboText = "|<%=status2s[1]%>";

	    recordComboValue = "<%=records[0]%>";
	    recordComboText = "<%=records[1]%>";
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id ="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- combo -->
<input type="hidden" name="cd" id="cd"   value=""> 
<input type="hidden" name="etc1" id="etc1" value="">
<input type="hidden" name="etc2" id="etc2" value="">
<input type="hidden" name="etc3" id="etc3" value="">
<input type="hidden" name="rdn_no_pop" id="rdn_no_pop" value="">
<input type="hidden" name="strRhq_ofc_cd" id="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" id="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="bkg_no_arr" id="bkg_no_arr" value="">

<input type="hidden" name="backendjob_key" id="backendjob_key" value="">
<!-- Error Seq -->
<input type="hidden" name="audit_seq_cd" id="audit_seq_cd" value="">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
	<div class="opus_design_btn">			
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>		
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
			<!--  biz_1 (S) -->				
				<table> 		
					<colgroup>
					    <col width="75">
					    <col width="80">
					    <col width="110">
					    <col width="80">
					    <col width="204">
					    <col width="245">
					    <col width="46">
					    <col width="100">
					    <col width="48">
					    <col width="*">
					  </colgroup>			
						<tr>
							<th>RHQ</th>
							<td><script type="text/javascript">ComComboObject('rct_rhq_cd', 1, 70, 0, 0, 0, false);</script></td>
							<th>Office</th>
							<td><script type="text/javascript">ComComboObject('rct_ofc_cd', 1, 70, 0, 0, 0, false);</script></td>
							<td><input type="radio" id="dt_type" name="dt_type" value="ETD" class="trans" checked> <b>Audit Date(I)</b> <input type="radio" id="dt_type" name="dt_type" value="PCT" class="trans" > <b>POL ETD</b>&nbsp;</td>
							<td><input name="rt_aply_dt_from" type="text" style="width:80px;text-align:center;" class="input1" caption="From Date" dataformat="ymd" otherchar="-" maxLength="10" minlength="8"><!--
							--><button type="button" name="btns_calendar1" id="btns_calendar1"  class="calendar ir"></button><!--
							-->~ <input name="rt_aply_dt_to" type="text" style="width:80px;text-align:center;"  class="input1" caption="To Date" dataformat="ymd" otherchar="-" maxLength="10" minlength="8"><!--
							--><button type="button" name="btns_calendar2" id="btns_calendar2"  class="calendar ir"></button></td>
							<th>T/VVD</th>
							<td><input type="text" name="vvd_cd" id="vvd_cd" style="width:85px;text-align:center;ime-mode:disabled" value="" caption="T/VVD" dataformat="engup" maxLength="9"></td>
							<th>B/L No.</th>
							<td><input type="text" name="bl_no" id="bl_no" style="width:100px;text-align:center;ime-mode:disabled" value="" caption="B/L No" dataformat="engup" maxLength="12"></td>
						</tr>
					</table>
					
					<table>
						<colgroup>
						    <col width="75">
						    <col width="90">
						    <col width="100">
						    <col width="90">
						    <col width="100">
						    <col width="92">
						    <col width="66">
						    <col width="130">
						    <col width="110">
						    <col width="100">				    
						    <col width="*">
					  	</colgroup>
						<tr>
							<th>BDR Status</th>
							<td><script type="text/javascript"> ComComboObject('bdr_status_cd', 1, 70, 0, 0, 0, false);</script></td>
							<th>POR/DEL Cont.</th>
	                        <td><script type="text/javascript">ComComboObject('conti_cd', 1, 85, 0, 0, 0, false);</script></td>      
	                        <td><script type="text/javascript">ComComboObject('conti_cd2', 1, 85, 0, 0, 0, false);</script></td>
							<th>Contract Type</th>
							<td><script type="text/javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 55, 0, 0, 0, false);</script></td>
							<th>Contract No.</th>
							<td><input type="text" name="contract_no" id="contract_no" style="width:85px;text-align:center;ime-mode:disabled" value="" caption="Contract No" dataformat="engup" maxLength="12"></td>
							<th>Rating Type</th>
							<td><script type="text/javascript"> ComComboObject('auto_rat_flg', 1, 90, 0, 0, 0, false);</script></td>
						</tr>	
					</table>
					<table>	
					<colgroup>
					    <col width="75">
					    <col width="115">
					    <col width="75">
					    <col width="70">
					    <col width="85">
					    <col width="129">
					    <col width="55">
					    <col width="80">
					    <col width="122">
					    <col width="80">						    			    
					    <col width="130">						    			    
					    <col width="*">
				  	</colgroup>
					<tr>	
					    <th>Error Type</th>
						<td><script type="text/javascript"> ComComboObject('umch_tp_cd', 1, 95, 0, 0, 0, false);</script></td>
						<th>Charge</th>
                    	<td><script type="text/javascript">ComComboObject('chg_cd', 2, 55, 0, 0, 0, false);</script></td>
						<th>Error Status </th>
						<td><script type="text/javascript"> ComComboObject('rev_aud_sts_cd', 1, 80, 0, 0, 0, false);</script></td>
						<td><script type="text/javascript"> ComComboObject('rev_aud_stl_knd_cd', 1, 110, 0, 0, 0, false);</script></td>
						<th>Rater ID</th>
						<td><input type="text" id="rater_id" name="rater_id" style="width:85px;text-align:center;ime-mode:disabled;" value="" maxLength="20"></td>
						<th class="sm">&nbsp;Error Seq.</th>
						<td class="sm pad_left_4"><input type="radio" class="trans" id="audit_seq_radio" name="audit_seq_radio" value="P" checked>Present <input type="radio" class="trans" id="audit_seq_radio" name="audit_seq_radio" value="H">History</td>	
						<td></td>																	
					</tr>	
				</table>		
				<!--  biz_1   (E) -->	
		</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- opus_design_grid(S) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
<script type="text/javascript">ComSheetObject('sheet0');</script>
<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_normal" name="btn_Filtered_Bl" id="btn_Filtered_Bl">B/L Count</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ReAudit" id="btn_ReAudit">Re-Audit</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Settle" id="btn_Settle">Manual Settle(Office)</button>
	</div>
	<!-- opus_design_btn(E) -->		
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width:100%">
    <div class="layout_vertical_2" style="width:45%;margin-right: 5%;">
        <!-- opus_design_grid(S) -->
        <div class="grid_2 noinput2">
            <!-- !!!IBSheet GRID!!! -->
             <table>
             	<colgroup>
					<col width="80" />				
					<col width="80" />				
					<col width="80" />				
					<col width="80" />				
		   		</colgroup>  
   				<tr>
					<th rowspan="2"  class="align_center">Total</th>
 					<th class="align_center">B/L Count</th> 
					<th class="align_center">Error B/L</th>
					<th class="align_center">Error Case</th></tr>
				<tr>
					<td><input type="text" name="filtered_bkg_count" id="filtered_bkg_count"   style="width:100px; text-align: center" class="noinput" value="" readonly></td>
					<td><input type="text" name="unmatched_bl_count" id="unmatched_bl_count"   style="width:100px; text-align: center" class="noinput" value="" readonly></td> 
					<td><input type="text" name="unmatched_case_count" id="unmatched_case_count" style="width:100px; text-align: center" class="noinput" value="" readonly></td>
				</tr>
  			</table>
			
        </div>
        <!-- opus_design_grid(e) -->
    </div>
    <div class="layout_vertical_2" style="width:50%">
        <!-- opus_design_grid(S) -->
        <div class="grid_2 noinput2">
            <!-- !!!IBSheet GRID!!! -->
            <table> 
            	<colgroup>
					<col width="63" />				
					<col width="63" />				
					<col width="63" />				
					<col width="63" />				
					<col width="63" />				
					<col width="63" />				
					<col width="63" />				
					<col width="63" />				
		   		</colgroup> 
				<tr>
					<th class="align_center">Error Kind</th>
					<th class="align_center">A1</th>
					<th class="align_center">A2</th>  
					<th class="align_center">B</th>
					<th class="align_center">C</th>
					<th class="align_center">D</th>
					<th class="align_center">E</th>
					<th class="align_center">F</th>
				</tr>
				<tr>
				    <th>Total</th>
					<td><input type="text" name="unmatch_al" id='unmatch_al' style="width:60px; text-align: center"  class="noinput" value="" readonly></td>
					<td><input type="text" name="unmatch_all" id="unmatch_all" style="width:60px; text-align: center"  class="noinput" value="" readonly></td> 
					<td><input type="text" name="unmatch_b" id="unmatch_b" style="width:60px; text-align: center"  class="noinput" value="" readonly></td>
					<td><input type="text" name="unmatch_c" id="unmatch_c" style="width:60px; text-align: center"  class="noinput" value="" readonly></td> 
					<td><input type="text" name="unmatch_d" id="unmatch_d" style="width:60px; text-align: center"  class="noinput" value="" readonly></td> 
					<td><input type="text" name="unmatch_e" id="unmatch_e" style="width:60px; text-align: center"  class="noinput" value="" readonly></td>
					<td><input type="text" name="unmatch_f" id="unmatch_f" style="width:60px; text-align: center"  class="noinput" value="" readonly></td>
				</tr>
			</table>	
        </div>
        <!-- opus_design_grid(e) -->
    </div>
</div>
<!-- layout_wrap(e) -->
</div>
<!-- wrap_result(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display: none">
<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->
</form>