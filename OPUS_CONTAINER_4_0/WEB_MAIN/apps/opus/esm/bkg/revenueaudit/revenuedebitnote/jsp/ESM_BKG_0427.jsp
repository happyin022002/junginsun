<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0427.jsp
*@FileTitle  : RDN Status Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0427Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0427Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	
    String[] rhqs = null;
    
    String[] auditTools = null;
    String[] contractTypes = null;
    
    String[] discrepancyKinds = null;
    //String[] unmatchTypes = null;
	
	Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.RevenueDebitNote");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strUsr_office_cd =	account.getOfc_cd();
		//strUsr_office_nm =  account.getOfc_eng_nm();

		event = (EsmBkg0427Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // Audit Tool 
        auditTools = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("auditTool"), false , "|", "\t", "getCode", "getName");
        // Contract Type
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // Unmatch Type
        //unmatchTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("unmatchType"), false , "|", "\t", "getCode", "getName");
        // Discrepancy Kind 1
       discrepancyKinds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("discrepancyKind"), false);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";

    var auditToolComboValue = "|<%=auditTools[0]%>";
    var auditToolComboText = "|<%=auditTools[1]%>";
    
    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
    
    var discrepancyKindComboValue = "<%=discrepancyKinds[0]%>";
    var discrepancyKindComboText = "<%=discrepancyKinds[1]%>";     

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
<!-- combo -->
<input type="hidden" name="cd"   value=""> 
<input type="hidden" name="etc1" value="">
<input type="hidden" name="etc2" value="">
<input type="hidden" name="etc3" value="">
<!-- rdn status cd -->
<input type="hidden" name="rdn_sts_cd" value="">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down&nbsp;Excel</button>
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
<!--Page Title, Historical (E)-->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="1px" />
            <col width="99px" />
            <col width="100px" />
            <col width="110px" />
            <col width="75px" />
            <col width="115px" />
            <col width="80px" />
            <col width="115px" />
            <col width="80px" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
				<th>Receipt RHQ</th>
				<td><script language="javascript">ComComboObject('rct_rhq_cd', 1, 76, 0, 0, 0, false);</script></td>
				<th>Receipt Office</th>
				<td><script language="javascript">ComComboObject('rct_ofc_cd', 1, 91, 0, 0, 0, false);</script></td>
				<th>Resp. RHQ</th>
				<td><script language="javascript">ComComboObject('respb_rhq_cd', 1, 100, 0, 0, 0, false);</script></td>
				<th>Resp. Office</th>
				<td><script language="javascript">ComComboObject('respb_ofc_cd', 1, 100, 0, 0, 0, false);</script></td>
				<th>Error Kind&nbsp;</th>
				<td><script language="javascript">ComComboObject('umch_tp_cd',2, 120, '');</script></td>
			</tr>
			<tr>
				<th>RDN Issue Date</th>
				<td>
					<input name="rdn_iss_dt_from" type="text" style="width:75px;text-align:center;"  value="" class="input1" caption="From Date" maxlength="10" dataformat="ymd"><!-- 
			     --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~
				   	<input name="rdn_iss_dt_to" type="text" style="width:75px;text-align:center;"  value="" class="input1" caption="To Date" maxlength="10" dataformat="ymd"><!-- 
			   	 --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button>
				</td>
				<th>RDN No.</th>
				<td>
					<input type="text" class="input" style="width:100px;text-align:center;ime-mode:disabled" name="rdn_no" value="" caption="RDN No" dataformat="engup" maxLength="9">
				</td>
				<th>B/L No.</th>
				<td><input type="text" class="input" style="width:100px;text-align:center;ime-mode:disabled" name="bl_no" value="" caption="B/L No" dataformat="engup" maxLength="12"></td>
				<th>C. Type</th>
				<td><script language="javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 55, 0, 0, 0, false);</script></td>
				<th>Audit Tool</th>
				<td><script language="javascript"> ComComboObject('rev_aud_tool_cd', 1, 100, 0, 0, 0, false);</script></td>
			</tr>
			<tr>
				<td class="sm" colspan="5">&nbsp;&nbsp;<b>Status</b>&nbsp;
					<input name="all" 		  	 type="checkbox" value="ALL" class="trans" checked onClick="checkAll();">ALL
					<input name="rdn_sts_check"  type="checkbox" value="IS"  class="trans" checked onClick="checkItem();">Issued
					<input name="rdn_sts_check"  type="checkbox" value="AC"  class="trans" checked onClick="checkItem();">Accepted
					<input name="rdn_sts_check"  type="checkbox" value="RR"  class="trans" checked onClick="checkItem();">Revise Requested
					<input name="rdn_sts_check"  type="checkbox" value="RV"  class="trans" checked onClick="checkItem();">Revised
					<input name="rdn_sts_check"  type="checkbox" value="CR"  class="trans" checked onClick="checkItem();">Cancel Requested
					<input name="rdn_sts_check"  type="checkbox" value="ST"  class="trans" checked onClick="checkItem();">Settled
					<input name="rdn_sts_check"  type="checkbox" value="CL"  class="trans" checked onClick="checkItem();">Canceled
				</td>
				<td>
					&nbsp;&nbsp;&nbsp;<button type="button" class="btn_etc" name="btn_SettledAll">Settled All</button>
					<button type="button" class="btn_etc" name="btn_UnsettledAll">Unsettled All</button>
				</td>
				<td colspan="4"></td>

			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->	

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet0');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    
    <!-- opus_grid_left(S)-->
    <div class="grid_option_left wFit">
	    <table class="grid2"> 
			<tr>
				<th rowspan="2" ><b>Total</b></th>
				<th><b>RDN Count</b></th> 
				<th><b>RDN Amount (USD)</b></th>
			<tr>
				<td class="pad_4"><input type="text" name="rdn_count" style="width:100%; text-align: center" value="" readonly></td>
				<td><input type="text" name="rdn_amount_count" style="width:100%; text-align: center" value="" readonly></td>
			</tr>
		</table>
	</div>
	<!-- opus_grid_left(E)-->
</div>
</div>
<!-- opus_design_grid(E) -->
	
</form>