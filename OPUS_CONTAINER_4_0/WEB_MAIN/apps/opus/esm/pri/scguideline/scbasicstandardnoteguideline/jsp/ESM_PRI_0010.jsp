<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0010.jsp
*@FileTitle  : Standard Note Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event.EsmPri0010Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] prcCustTpCd = null;	//CUSTOMER TYPE
	String[] svcScpCd = null;		//SERVICE SCOPE
	
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCBasicStandardNoteGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		prcCustTpCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CUST_TP_CD"));
		svcScpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SVC_SCP_CD"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var prcCustTpCdComboValue = "<%=prcCustTpCd[0]%>";
    var prcCustTpCdComboText = "<%=prcCustTpCd[1]%>";
    
	var svcScpCdComboValue = "<%=svcScpCd[0]%>";
    var svcScpCdComboText = "<%=svcScpCd[1]%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input name="note_hdr_seq" type="hidden" value="">
<input name="note_seq" type="hidden" value="">
<input name="cd" type="hidden" value="">

<!-- seleted year -->
<input type="hidden" name="note_ref_yr_hidden" value="">
<!-- svc_scp_cd -->
<input type="hidden" name="svc_scp_cd_hidden" value="">
<!-- seleted Duration -->
<input type="hidden" name="eff_dt_hidden" value="">
<input type="hidden" name="exp_dt_hidden" value="">
<!-- seleted note nm -->
<input type="hidden" name="note_nm_hidden" value="">
<!-- cust type nm -->
<input type="hidden" name="prc_cust_tp_cd_hidden" value="">
<!-- note_nm -->
<input type="hidden" name="note_nm" value="">


<!-- Use it for saving old search condition key value when you copy it. -->
<input type="hidden" name="svc_scp_cd_copy" value="">
<input type="hidden" name="prc_cust_tp_cd_copy" value="">
<input type="hidden" name="note_hdr_seq_copy" value="">

<!-- ett_dt_before -->
<input type="hidden" name="exp_dt_before" value="">
 
<input type="hidden" name="exp_dt_hidden_select" value="">

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
            <col width="30px" />
            <col width="53px" />
            <col width="90px" />
            <col width="230px" />
            <col width="75px" />
            <col width="220px" />
            <col width="*" />
        </colgroup>
        <tbody>
			<tr>
				<th>Year</th>
				<td><input name="note_ref_yr" type="text" maxlength="4" style="width:40px;"  value="" class="input1" onkeyup="javascript:searchDuration();"></td>
				<th>Service Scope</th>			 	
				<td><script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 1, 0, false);</script>
					&nbsp;<input name="svc_scp_nm" type="text" style="width:240px;"  value="" class="input2" readonly="true">
				</td>
				<th>Duration</th>
				<td>
					<table class="search">
						<tr>
							<td>
								<script type="text/javascript">ComComboObject("gline_seq", 3, 90, 1, 1, 2, true);</script>								
								<span class="dash"> - </span>											   
					     		<input name="eff_dt" 			id="eff_dt" 		type="hidden" 	value="" class="input1" caption="Effective Date" required>					  
					     		<input name="eff_dt_hidden" 	id="eff_dt_hidden" 	type="hidden" 	value="" class="input1">
					     		<input name="exp_dt" 			id="exp_dt" 		type="text" 	style="width: 90px;"  value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required>
							</td>
						</tr>
					</table>
				</td>
				<td></td>
			</tr>				
			<tr>
				<th>Standard Note</th>
				<td colspan="3"><script language="javascript">ComComboObject('note_nm_cd', 1, 490, 0, 1, 0, true);</script></td>
				<th>Cust. Type</th>
				<td colspan="2">
					<script language="javascript">ComComboObject('prc_cust_tp_cd', 2, 90, 0, 0, 0, false);</script>
				</td>
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
    <script language="javascript">ComSheetObject('sheet0');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
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
<!-- page(E) -->
</div>
</form>