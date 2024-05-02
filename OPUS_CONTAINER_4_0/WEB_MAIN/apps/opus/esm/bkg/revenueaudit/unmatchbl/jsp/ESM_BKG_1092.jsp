<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1092.jsp
*@FileTitle  : Audit by Commodity And Route 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1092Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg1092Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         // error from server
    String strErrMsg = "";                      // error message
    int rowCount     = 0;                       // count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRhq_ofc_cd    = "";
    String strOfc_cd        = "";
    
    String[] rhqs = null;
    String[] offices = null;
    String[] contractTypes = null;
    String[] cargoTypes = null;
    String[] usaSvcModCds = null;
    String[] svcScpCds = null;
    String[] rTerms = null;
    String[] dTerms = null;

    String[] bkgStatuCds = null;
    String[] splitFlgs = null;
    String[] chargeFlgs = null;
    String[] ratingTypes = null;

    String[] ratUtCds = null;

    Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        event = (EsmBkg1092Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // RHQ
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // Office
        offices = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("office"));
        if(null == offices){
            offices = new String[] {"", ""};
        }
        // Contract Type
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // cargo type term Combo Data 
        cargoTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoType"), true , "|", "\t", "getCode", "getName");
		// USA Service Mode Code
		usaSvcModCds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("usaSvcModCd"), false , "|", "\t", "getCode", "getName");
        
        // Scope
        svcScpCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // r term Combo Data 
        rTerms = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rTerm"), false , "|", "\t", "getCode", "getName");
        // d term Combo Data 
        dTerms = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dTerm"), false , "|", "\t", "getCode", "getName");

        // BKG Status Combo Data 
        bkgStatuCds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("bkgStatuCd"), true , "|", "\t", "getCode", "getName");
        // Split Status Combo Data 
        splitFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("splitFlg"), true , "|", "\t", "getCode", "getName");
        // Charge Status Combo Data 
        chargeFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chargeFlg"), true , "|", "\t", "getCode", "getName");
        // Rating Type 
        ratingTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ratingType"), false , "|", "\t", "getCode", "getName");

		// Rating Unit
		ratUtCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"));
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>

<script type="text/javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";

    var officeComboValue = "|<%=offices[0]%>";
    
    if(officeComboValue == "|"){
        officeComboValue = "";
    }
    
    var contractTypeComboValue = "<%=contractTypes[0]%>";
    var contractTypeComboText = "<%=contractTypes[1]%>";

    var cargoTypeComboValue = "|<%=cargoTypes[0]%>";
    var cargoTypeComboText = "|<%=cargoTypes[1]%>";

    var usaSvcModCdComboValue = "|<%=usaSvcModCds[0]%>";
    var usaSvcModCdComboText = "|<%=usaSvcModCds[1]%>";
    
    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    var ratingTypeComboValue = "|<%=ratingTypes[0]%>";
    var ratingTypeComboText = "|<%=ratingTypes[1]%>";
    
    var rTermComboValue = "|<%=rTerms[0]%>";
    var rTermComboText = "|<%=rTerms[1]%>";

    var dTermComboValue = "|<%=dTerms[0]%>";
    var dTermComboText = "|<%=dTerms[1]%>";

    
    var bkgStatuCdComboValue = "|<%=bkgStatuCds[0]%>";
    var bkgStatuCdComboText = "|<%=bkgStatuCds[1]%>";

    var chargeFlgComboValue = "|<%=chargeFlgs[0]%>";
    var chargeFlgComboText = "|<%=chargeFlgs[1]%>";

    var splitFlgComboValue = "|<%=splitFlgs[0]%>";
    var splitFlgComboText = "|<%=splitFlgs[1]%>";

    var ratUtCdComboValue = "<%=ratUtCds[0]%>";
    var ratUtCdComboText = "<%=ratUtCds[1]%>";
 
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        }
        loadPage();
    }
</script>

<script type="text/javascript">

    function setupPage(){  

	    loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="search_date" value="ETD">
<input type="hidden" name="charge_type" value="RATED">
<input type="hidden" name="charge_condition" value="AND">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<!--  MiniLayer (S) -->
		<table>
			<tbody>
				<tr>
					<th width="100">RHQ</th>
					<td width="100">
						<script type="text/javascript">ComComboObject('bkg_rhq_cd', 1, 85, 0, 1, 0, false);</script>
					</td>
					<th width="80">Office</th>
					<td width="103">
						<script type="text/javascript">ComComboObject('bkg_ofc_cd', 1, 70, 0, 0, 0, false);</script>
					</td>
					<td width="120" colspan="6">
							<table class="sm">
								<tr>
									<th>Date</th>
									<td>
										<input type="radio" value="BKG" name="r_date" id="r_date_bkg"><label for="r_date_bkg">BKG</label>
										<input type="radio" value="APPL" name="r_date" id="r_date_appl"><label for="r_date_appl">Appl.</label>
										<input type="radio" value="ETD" name="r_date" id="r_date_etd" checked><label for="r_date_etd">ETD</label>
									</td>
									<td>
										<input type="text" style="width:72px;text-align:center;" class="input1" name="from_dt" caption="From Date" dataformat="ymd" maxLength="10" minlength="8"><!--
										--><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>
										~
										<input type="text" style="width:72px;text-align:center;" class="input1" name="to_dt" caption="To Date" dataformat="ymd" maxLength="10" minlength="8"><!--
										--><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>
									</td>
								</tr>
							</table>
						
					</td>
					<th width="100">T/VVD</th>
					<td width="120">
						<input type="text" style="width:80px;text-align:center;ime-mode:disabled" class="input" name="vvd" id="vvd" caption="T/VVD" dataformat="engup" maxlength="9"><!--  
						--><button type="button" class="input_seach_btn" name="vvd_popup" id="vvd_popup"></button>
					</td>				
					<th width="60">B/L No.</th>
					<td colspan="3">
						<input type="text" style="width:100px;text-align:center;ime-mode:disabled" class="input" name="bl_no" caption="B/L No" dataformat="engup" maxlength="12">
					</td>
				</tr>
				<tr>
					<th>Contract Type</th>
					<td>
						<script type="text/javascript">ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 1, 0, false);</script>
					</td>
					<th>Contract No.</th>
					<td colspan="3">
						<input type="text" style="width:83px;text-align:center;ime-mode:disabled" class="input1" name="ctrt_no" caption="Contract No." dataformat="engup" maxLength="11"><!--
						--><button type="button" class="input_seach_btn" name="ctrt_popup" id="ctrt_popup"></button>
					</td>
					<th>Commodity</th>
					<td colspan="3">
						<input type="text" style="width:50px;text-align:center;ime-mode:disabled" class="input1" name="cmdt_cd" dataformat="engup" maxLength="6"><!--
						--><button type="button" class="input_seach_btn" name="cmdt_popup" id="cmdt_popup"></button>
					</td>
					<th>Cargo Type</th>
					<td>
						<script type="text/javascript">ComComboObject('cargo_type', 2, 80, 0, 0, 0, false);</script>
					</td>
					<th>USA SVC Mode</th>
					<td colspan="5">
						<script type="text/javascript">ComComboObject('usa_svc_mod_cd', 1, 100, 0, 0, 0, false);</script>
					</td>
				</tr>
			</tbody>
		</table>				
		<table>
			<tbody>
				<tr>
					<th  width="91">Scope</th>
					<td>
						<script type="text/javascript">ComComboObject('svc_scp_cd', 2, 55, 0, 0, 0, false);</script>
					</td>
					<th title="Place of Receipt" width="40">POR</th>
					<td>
						<input type="text" style="width:60px;ime-mode:disabled;" class="input" name="por_cd" dataformat="engup" maxlength="5">
					</td>
					<th title="Port of Loading" width="30">POL</th>
					<td>
						<input type="text" style="width:60px;ime-mode:disabled;" class="input" name="pol_cd" dataformat="engup" maxlength="5">
					</td>
					<th title="Port of Discharging"width="30">POD</th>
					<td>
						<input type="text" style="width:60px;ime-mode:disabled;" class="input" name="pod_cd" dataformat="engup" maxlength="5">
					</td>
					<th title="Place of Delivery"width="30">DEL</th>
					<td>
						<input type="text" style="width:60px;ime-mode:disabled;" class="input" name="del_cd" dataformat="engup" maxlength="5">
					</td>
					<th width="70">R/D Term</th>
	                <td>
	                	<script type="text/javascript">ComComboObject('rcv_term_cd', 1, 75, 0, 0, 0, false);</script><!-- 
	                	--><script type="text/javascript">ComComboObject('de_term_cd', 1, 75, 0, 0, 0, false);</script>
	                </td>      
					<th width = "88">Customer</th>
					<td>
						<%=JSPUtil.getCodeCombo("bkg_cust_tp_cd", "", "", "CD00880", 0, "")%><!--
						--><input type="text" style="width:30px;text-align:center;ime-mode:disabled;" class="input" name="cust_cnt_cd" dataformat="enguponly" maxlength="2"><!--
						--><input type="text" style="width:50px;text-align:center;ime-mode:disabled;" class="input" name="cust_seq" dataformat="engup" maxlength="6"><!--
						--><input type="text" style="width:117px;text-align:left;ime-mode:disabled;" class="input" name="cust_nm" dataformat="engup" maxlength="20">
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<table class="line_bluedot"><tr><td></td></tr></table>

	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th width="92">BDR Status</th>
					<td width="95">
						<script type="text/javascript">ComComboObject('bdr_flg', 1, 62, 0, 0, 0, false);</script>
					</td>
					<th width="60">BKG Status</th>
					<td width="60">
						<script type="text/javascript">ComComboObject('bkg_sts_cd', 2, 82, 0, 0, 0, false);</script>
					</td>
					<th width="90">Split Status</th>
					<td width="90">
						<script type="text/javascript">ComComboObject('split_flg', 2, 82, 0, 0, 0, false);</script>
					</td>  
					<th width="95">Charge Status</th>
	                <td width="90">
	                	<script type="text/javascript">ComComboObject('charge_flg', 2, 82, 0, 0, 0, false);</script>
	                </td>
					<th width="80">Rating Type</th>
					<td>
						<script type="text/javascript"> ComComboObject('auto_rat_flg', 1, 130, 0, 0, 0, false);</script>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<table class="line_bluedot"><tr><td></td></tr></table>
		
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th width="75">Charge</th>
					<td width="140">
						<div class="sm">
							<table>
								<tr>
									<td>
										<input type="radio" id="chg_tp_rated" name="chg_tp" value="RATED" checked><label for="chg_tp_rated">Rated</label><!--
										--><input type="radio" id="chg_tp_non_rated" name="chg_tp" value="NOTRATED"><label for="chg_tp_non_rated">Not Rated</label>
									</td>
								</tr>
							</table>
						</div>
					</td>
					<td width="230">
						<div class="sm">
							<table>
								<tr>
									<td>
										<script type="text/javascript">ComComboObject('chg_cd', 2, 60, 0, 0, 0, false);</script>
									</td>
									<td>
										<input type="radio" id="chg_cond_and" name="chg_cond" value="AND" checked><label for="chg_cond_and">And</label><!--
										--><input type="radio" id="chg_cond_or" name="chg_cond" value="OR"><label for="chg_cond_or">Or</label>
									</td>
									<td>
										<script type="text/javascript">ComComboObject('chg_cd1', 2, 60, 0, 0, 0, false);</script>
									</td>
								</tr>
							</table>
						</div>
					</td>		
					<th width="60">Currency</th>
					<td width="140">
						<input type="text" style="width:60;text-align:center;ime-mode:disabled;" class="input" name="curr_cd" dataformat="enguponly" maxlength="3">
					</td>
					<th width="70">Per Type</th>
					<td width="70">
						<script type="text/javascript"> ComComboObject('rat_ut_cd', 1, 60, 0, 0, 0, false);</script>
					</td>
					<td>	
						<div class="sm">
								<table>
									<tr>
										<th>Bill Type</th>
										<td>
		                              		<input type="checkbox" id="bill_type_all" name="bill_type_all"  value="ALL" checked><label for="bill_type_all">ALL</label><!--
		                              		--><input type="checkbox" id="bill_type_n" name="bill_type_n" value="N" checked><label for="bill_type_n">Normal</label><!--
		                              		--><input type="checkbox" id="bill_type_m" name="bill_type_m" value="M" checked><label for="bill_type_m">Master</label><!--
		                              		--><input type="checkbox" id="bill_type_c" name="bill_type_c" value="C" checked><label for="bill_type_c">Covered</label><!--
		                              		--><input type="checkbox" id="bill_type_b" name="bill_type_b" value="B" checked><label for="bill_type_b">Co-Biz</label>
		                              	</td>
									</tr>
								</table>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_inquiry" style="text-align:right;">
		<table>
			<tbody>
				<colgroup>
					<col width="88%">
					<col width="5%">
					<col width="*">
				</colgroup>
				<tr>
					<td></td>
					<th>B/L Count</th>
					<td><input type="text" style="width:60px;text-align:right" class="input" value="" name="bl_cnt" id="bl_cnt" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<div style="display: none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
</form>
