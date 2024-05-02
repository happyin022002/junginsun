<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0060.jsp
*@FileTitle  : Rate Search 
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0060Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri0060Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] charges = null;
    String[] customerTypes = null;
    String[] tpSzs = null;
    String[] cargoTypes = null;
    String[] rates = null;
    String[] scNoPrefixs = null;
    String[] svcScpCds = null;
    String[] rateTypes = null;
    
    Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri0060Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // charges Combo Data 
        charges = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("charge"), false , "|", "\t", "getCode", "getName");
        // customer type Combo Data 
        customerTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("customerType"), true , "|", "\t", "getCode", "getName");
        // tp sz Combo Data 
        tpSzs = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("tpSz"), false);
        // cargo type Combo Data 
        cargoTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoType"), true , "|", "\t", "getCode", "getName");
        // rate, mqc Combo Data 
        rates = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rate"), false , "|", "\t", "getCode", "getName");
        // sc no Combo Data 
        scNoPrefixs = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scNoPrefix"));
        // scope Combo Data 
        svcScpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("svcScpCd"));
        // rate type Combo Data 
        rateTypes = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rateType"), true , "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">

    var chargeComboValue = "<%=charges[0]%>";
    var chargeComboText = "<%=charges[1]%>";

    var customerTypeComboValue = "|<%=customerTypes[0]%>";
    var customerTypeComboText = "|<%=customerTypes[1]%>";

    var tpSzComboValue = "<%=tpSzs[0]%>";
    var tpSzComboText = "<%=tpSzs[1]%>";

    var cargoTypeComboValue = "<%=cargoTypes[0]%>";
    var cargoTypeComboText = "<%=cargoTypes[1]%>";

    var rateComboValue = "|<%=rates[0]%>";

    var scNoPrefixComboValue = "|<%=scNoPrefixs[0]%>";
    var scNoPrefixComboText = "|<%=scNoPrefixs[1]%>";

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    var  rateTypeComboValue = "<%=rateTypes[0]%>";
    var  rateTypeComboText = "<%=rateTypes[1]%>";

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
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="job_status">

<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" name ="etc1" value="">
<input type="hidden" id="searchParam" name="sc_no">
<input type="hidden" id="searchParam" name="cmdt_nm">
<input type="hidden" id="searchParam" name="act_cust_nm">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_gotosc" id="btn_gotosc">Go to S/C</button>
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
    	<colgroup>
            <col width="95" />
            <col width="123" />
            <col width="110" />
            <col width="232" />
            <col width="75" />
            <col width="70" />
            <col width="150" />
            <col width="70" />
            <col width="150" />
            <col width="70" />
            <col width="*" />
            <col width="*" />
        </colgroup>
    	<tbody>
			<tr>
				<th>Charge</th>
				<td><script type="text/javascript">ComComboObject('chg_cd', 1, 110, 0, 1, 0, false);</script></td>
                <th>S/C EFF Date</th>
                <td>
					<input type="text" style="width:75px;text-align:center;" class="input1" name="eff_dt" caption="S/C EFF Date From" cofield="exp_dt" dataformat="ymd" maxLength="10" minlength="8"><!-- 
                   	 --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>
                   	<input type="text" style="width:75px;text-align:center;" class="input" name="exp_dt" caption="S/C EFF Date To" cofield="eff_dt" dataformat="ymd" maxLength="10" minlength="8"><!-- 
                   	 --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td>
                <th>Origin</th>
                <td><input type="text" name="rout_pnt_loc_def_cd_ori" style="width:65px;text-align:center;ime-mode:disabled" class="input1" dataformat="engup" maxLength="5"></td>
                <th>Destination</th>
                <td><input type="text" name="rout_pnt_loc_def_cd_dest" style="width:60px;text-align:center;ime-mode:disabled" class="input1" dataformat="engup" maxLength="5"></td>
                <th>Origin Via</th>
                <td><input type="text" name="rout_via_port_def_cd_ori" style="width:60px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="5"></td>
                <th>Dest Via</th>
                <td><input type="text" name="rout_via_port_def_cd_dest" style="width:60px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="5"></td>
			</tr>
			<tr>
				<th>Customer Type</th>
				<td><script type="text/javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 37, 0, 0, 0, false);</script></td>
                <th>Commodity</th>
                <td><input type="text" style="width:75px;text-align:center;ime-mode:disabled" class="input" name="prc_cmdt_def_cd" dataformat="num" maxLength="6"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_commodity"></button></td>
                <th>TP/SZ</th>
                <td><script type="text/javascript">ComComboObject('rat_ut_cd', 2, 65, 0, 0, 0, false);</script></td>
                <th>Cargo Type</th>
                <td><script type="text/javascript">ComComboObject('prc_cgo_tp_cd', 2, 60, 0, 0, 0, false);</script></td>
                <th>Rate</th>
                <td colspan="3"><script type="text/javascript">ComComboObject('fnl_frt_rt', 1, 40, 0, 0, 0, false);</script><input type="text" style="width:80px;text-align:right;ime-mode:disabled" class="input" name="fnl_frt_rt_amt" dataformat="int" maxLength="6"></td>
			</tr>
			<tr>
				<th>S/C No.</th>
                <td>
                	<input type="text" name="sc_no_s" style="width:109px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="9"></td>
                <th>SVC Scope</th>
                <td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 0, 0, false);</script></td>
                <th>Rate Type</th>
                <td><script type="text/javascript">ComComboObject('gen_spcl_rt_tp_cd', 2, 65, 0, 0, 0, false);</script></td>
                <th>Commodity Group</th>
                <td><script type="text/javascript">ComComboObject('cmdt_hdr_seq', 1, 120, 0, 0, 0, false);</script></td>
                <th>Actual Customer</th>
                <td colspan="3"><script type="text/javascript">ComComboObject('act_cust_cd', 1, 136, 0, 0, 0, false);</script></td>
			</tr>
			<tr>
				<th>MQC</th>
				<td>
                	<script type="text/javascript">ComComboObject('fnl_mqc', 1, 40, 0, 0, 0, false);</script><input type="text" style="width:65px;text-align:right;ime-mode:disabled" class="input" name="fnl_mqc_qty" dataformat="int" maxLength="6"></td>
                <th>Request OFC</th>
                <td>
                	<input type="text" style="width:75px;text-align:center;ime-mode:disabled" class="input" name="prop_scp_ofc_cd" id="prop_scp_ofc_cd" dataformat="enguponly" maxLength="6"><!-- 
					 --><button type="button" class="input_seach_btn" id="btn_reqOfc" name="btn_reqOfc"></button>
                </td>
                <th>S. Rep</th>
                <td colspan="7"><script teyp="text/javascript">ComComboObject('prop_scp_srep_cd', 2, 65, 0, 0, 0, false);</script><input type="text" name="prop_scp_srep_nm" id="prop_scp_srep_nm" style="width:80px;" class="input2" readonly></td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result" >
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet2');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet3');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->

</form>