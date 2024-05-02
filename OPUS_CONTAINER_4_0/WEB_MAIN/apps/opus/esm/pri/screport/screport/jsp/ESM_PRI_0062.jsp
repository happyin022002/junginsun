<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0062.jsp
*@FileTitle  : S/C List Inquiry
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0062Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>


<%
    EsmPri0062Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] svcScpCds = null;
    String[] scNoPrefixs = null;
    String[] custTpCds = null;
    String[] aproOfcCds = null;
    
    Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");
    
    try {
    	
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri0062Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // Service Scope Combo Data creation
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // S/C No Combo Data creation
        scNoPrefixs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scNoPrefix"));
        // Customer Type Combo Data creation
        custTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTpCd"), true , "|", "\t", "getCode", "getName");
        // Approval Office Combo Data creation 
        aproOfcCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("aproOfcCd"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">

    var svcScpComboValue = "|<%=svcScpCds[0]%>";
    var svcScpComboText = "|<%=svcScpCds[1]%>";

    var scNoPrefixComboValue = "|<%=scNoPrefixs[0]%>";
    var scNoPrefixComboText = "|<%=scNoPrefixs[1]%>";

    var custTpCdComboValue = "|<%=custTpCds[0]%>";
    var custTpCdComboText = "|<%=custTpCds[1]%>";

    var aproOfcCdComboValue = "|<%=aproOfcCds[0]%>";
    var aproOfcCdComboText = "|<%=aproOfcCds[1]%>";
    
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

<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" id="searchParam" name="sc_no"    value="">
<input type="hidden" id="searchParam" name="rf_flg"   value="">
<input type="hidden" id="searchParam" name="gamt_flg" value="">
<input type="hidden" id="searchParam" name="eff_dt"   value="">
<input type="hidden" id="searchParam" name="exp_dt"   value="">

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
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_opensc" id="btn_opensc">Open S/C</button><!--
		--><button type="button" class="btn_normal" name="btn_viewsc" id="btn_viewsc">View S/C</button><!--
		--><button type="button" class="btn_normal" name="btn_amdhistory" id="btn_amdhistory">AMD History</button>
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
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	    	<colgroup>
	            <col width="100px" />
	            <col width="170px" />
	            <col width="100px"/>
	            <col width="170px" />
	            <col width="100px"/>
	            <col width="170px" />
	            <col width="100px"/>
	            <col width="170px" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>SVC Scope</th>
					<td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 60, 0, 0, 0, false);</script><input type="text" name="svc_scp_nm" style="width:100px;" class="input2" readonly></td>
						
					<th>S/C No.</th>
					<td><input type="text" class="input" style="width:90px;text-align:center;ime-mode:disabled" name="sc_no_suffix" dataformat="engup" maxLength="9"></td>
					
					<td colspan="4">
						<table class="sm"> 
							<tr class="h23">
								<td style="padding-left:4px"><input type="radio" name="rdoDate" value="2" class="trans" checked><th>S/C Effective Date</th>
								<td><input type="text" class="input1" style="width:75px;text-align:center" caption="S/C Effective From Date" name="eff_date_from" cofield="eff_date_to" dataformat="ymd" maxLength="10" minlength="8"><!-- 
									 --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~ <input type="text" class="input1" style="width:75px;text-align:center" caption="S/C Effective To Date" name="eff_date_to" cofield="eff_date_from" dataformat="ymd" maxLength="10" minlength="8"><!-- 
									 --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>
								</td>
								<td><input type="radio" name="rdoDate" value="1" class="trans"><th>Access Date</th></td>
								<td>
								   	<input type="text" style="width:70;text-align:center" name="access_date" class="input" dataformat="ymd" maxLength="10" minlength="8" caption="Access Date"><!-- 
									 --><button type="button" class="calendar ir" name="btns_calendar3" id="btns_calendar3"></button>
								   </td>
							</tr> 
						</table>
					</td>
				</tr>
				<tr>
					<th>Customer Type</th>
					<td><script type="text/javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 60, 0, 0, 0, false);</script></td>
	                <th>Approval Office</th>
	                <td><script type="text/javascript">ComComboObject('prop_apro_ofc_cd', 2, 90, 0, 0, 0, false);</script></td>
					<th>Contract Office</th>
					<td><input type="text" name="ctrt_cust_sls_ofc_cd" style="width:84px;text-align:center;ime-mode:disabled" class="input" dataformat="enguponly" maxLength="6"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_contract_ofc" id="btn_contract_ofc"></button></td>
					<th>S/C Type&nbsp;</th>
					<td><script type="text/javascript">ComComboObject('sc_type', 1, 98, 0, 0, 0, false);</script></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
	    	<colgroup>
	            <col width="105px" />
	            <col width="180px" />
	            <col width="105px"/>
	            <col />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Total MQC</th>
					<td><input type="text" name="total_mqc" style="width:90px;text-align:right;" class="input2" readonly><input type="text" value="FEU" style="width:40px;text-align:center;" class="input2" readonly></td>
					<th>No. of S/C</th>
					<td><input type="text" name="noof_sc" style="width:90px;text-align:center;" class="input2" readonly></td>
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
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>