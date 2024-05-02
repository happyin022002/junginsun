<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0108_01.jsp
*@FileTitle  : S/C Performance Summary
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri010801Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri010801Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] rhqs = null;
    String[] aproOfcCds = null;    
    String[] scNoPrefixs = null;    
    String[] svcScpCds = null;    
    String[] custTpCds = null;    
    
    Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri010801Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // rhq Combo Data 
        rhqs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // Approval Office Combo Data 
        aproOfcCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("aproOfcCd"));
        // S/C No Combo Data 
        scNoPrefixs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scNoPrefix"));
        // Scope Combo Data 
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Customer Type Combo Data 
        custTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTpCd"), true , "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";
    var rhqComboText = "|<%=rhqs[1]%>";

    var aproOfcCdComboValue = "|<%=aproOfcCds[0]%>";
    var aproOfcCdComboText = "|<%=aproOfcCds[1]%>";
    
    var scNoPrefixComboValue = "|<%=scNoPrefixs[0]%>";
    var scNoPrefixComboText = "|<%=scNoPrefixs[1]%>";

    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";
    
    var custTpCdComboValue = "|<%=custTpCds[0]%>";
    var custTpCdComboText = "|<%=custTpCds[1]%>";

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

<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" id="searchParam" name="sc_no">
<input type="hidden" id="searchParam" name="rf_flg">
<input type="hidden" id="searchParam" name="gamt_flg">

<!-- page(S) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_result">
	<div class="opus_design_inquiry wFit">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="60" />
	            <col width="87" />
	            <col width="35" />
	            <col width="97" />
	            <col width="35" />
	            <col width="90" />
	            <col width="55" />
	            <col width="130" />
	            <col width="80" />
	            <col width="80" />
	            <col width="100" />
	            <col width="50" />
	            <col width="60" />
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th><nobr>S/C Effective Date</nobr></th>
					<td colspan="3">
						<input type="text" class="input1" style="width:80px;text-align:center;" caption="S/C Effective From Date" name="eff_dt" cofield="exp_dt" dataformat="ymd" maxLength="10" minlength="8"><!-- 
						 --><button type="button" class="calendar ir" name="btns_calendar3" id="btns_calendar3"></button>&nbsp;~&nbsp;
						<input type="text" class="input1" style="width:80px;text-align:center;" caption="S/C Effective To Date" name="exp_dt" cofield="eff_dt" dataformat="ymd" maxLength="10" minlength="8"><!-- 
						 --><button type="button" class="calendar ir" name="btns_calendar4" id="btns_calendar4"></button>
					</td>
	                <th>Period</th>
	                <td colspan="3">
	                	<input type="text" class="input" style="width:80px;text-align:center;" caption="Period From Date" name="bl_obrd_dt_from" !cofield="bl_obrd_dt_to" dataformat="ymd" maxLength="10" minlength="8"><!-- 
	                	 --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>&nbsp;~&nbsp;
	                	<input type="text" class="input" style="width:80px;text-align:center;" caption="Period To Date" name="bl_obrd_dt_to" !cofield="bl_obrd_dt_from" dataformat="ymd" maxLength="10" minlength="8"><!-- 
	                	 --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>
	                	 <input type="checkbox" name="by_scope" id="by_scope" value="Y" class="trans" checked><nobr><label for="by_scope">By Scope</label></nobr>
	                </td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
				</tr>
				<tr>
					<th>RHQ</th>
					<td><script type="text/javascript">ComComboObject('rhq', 1, 80, 0, 0, 0, false);</script></td>
	                <th title="Approval Office">A.OFC</th>
	                <td><script type="text/javascript">ComComboObject('prop_apro_ofc_cd', 2, 80, 0, 0, 0, false);</script></td>
					<th title="Contract Office">C.OFC</th>
					<td>
						<input type="text" name="ctrt_cust_sls_ofc_cd" style="width:65px;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"><!-- 
						 --><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget" id="ComOpenPopupWithTarget"></button>
					</td>
					<th>S/C  No.</th>
					<td>
						<script type="text/javascript">ComComboObject('sc_no_prefix', 2, 55, 0, 0, 0, false);</script><!-- 
						 --><input type="text" class="input" style="width:60px;text-align:center;ime-mode:disabled" name="sc_no_suffix" dataformat="num" maxLength="6">
					</td>
					<th>SVC Scope</th>
					<td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 70, 0, 0, 0, false);</script></td>
					<th>Customer Type</th>
					<td><script type="text/javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 40, 0, 0, 0, false);</script></td>
					<th>S/C Type</th>
					<td><script type="text/javascript">ComComboObject('sc_type', 1, 100, 0, 0, 0, false);</script></td>
				</tr>
				</table>
			</div>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<div class="opus_design_inquiry wFit">
				<table>
			<colgroup>
	            <col width="60" />
	            <col width="87" />
	            <col width="35" />
	            <col width="97" />
	            <col width="35" />
	            <col width="90" />
	            <col width="55" />
	            <col width="130" />
	            <col width="80" />
	            <col width="80" />
	            <col width="100" />
	            <col width="50" />
	            <col width="60" />
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Total MQC</th>
					<td colspan="3">
						<input type="text" class="input2" name="total_mqc" style="width:80px;text-align:right;" readonly><!-- 
						 --><input type="text" class="input2" style="width:50px;text-align:center;" value="FEU" readonly>
					</td>
					<th>No. of S/C</th>
					<td><input type="text" class="input2" name="noof_sc" style="width:65px;text-align:center;" readonly></td>
					<th>Total Performance</th>
					<td>
						<input type="text" class="input2" name="total_performance" style="width:80px;text-align:right;" readonly><!-- 
						 --><input type="text" class="input2" style="width:50px;text-align:center;" value="FEU" readonly>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	
	<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>

<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->

<!-- opus_design_grid(E) -->

<div style="display: none">
<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
</div>
<!-- page(E) -->

</form>