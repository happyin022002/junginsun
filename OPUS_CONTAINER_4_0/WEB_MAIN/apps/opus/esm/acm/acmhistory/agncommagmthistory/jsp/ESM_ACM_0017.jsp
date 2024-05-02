<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0017.jsp
*@FileTitle  : Special Compensation CSR Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.event.EsmAcm0017Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmAcm0017Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String aproStep = "";
	String inv_sub_sys_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.ACMRequest.AGNCommRequest");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmAcm0017Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		aproStep = com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(strOfc_cd, "ACM");
		inv_sub_sys_cd = JSPUtil.getParameter(request,"inv_sub_sys_cd".trim(), "");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
<form name="form"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ap_ofc_cd" id="ap_ofc_cd" />
<input type="hidden" name="agmt_his_no" id="agmt_his_no" />
<input type="hidden" name="agn_agmt_no" id="agn_agmt_no" />

<!-- 개발자 작업 -->
<input type="hidden" name="login_ofc" value="<%=strOfc_cd%>" id="login_ofc" />
	<!-- 로그인 한 사용자의 ofc_cd -->
<input type="hidden" name="aproSeqKey" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd)%>" id="aproSeqKey" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit" id="mainTable">
		<table>
			<colgroup>
				<col width="60">
				<col width="150">
				<col width="40">
				<col width="150">
				<col width="60">
				<col width="*">
			</colgroup>
			<tr>
				<th>RHQ</th>
				<td><select name="rhq_cd_disp" id="rhq_cd_disp" style="width: 100px; display: none;" class="input1" tabindex="1" onchange="frmObj_OnChange();"></select><!-- 
					 --><input name="rhq_cd" type="text" class="input1" style="width: 100px; text-align: center;" tabindex="1" readonly id="rhq_cd" />
				</td>
				<th>Office</th>
				<td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width: 100px;" tabindex="2" onchange="frmObj_OnChange();"></select></td>
				<th>Sub Office</th>
				<td><select name="agn_cd" required caption="Sub Office" class="input1" style="width: 100px;" tabindex="3"></select></td>
			</tr>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<table>
		<colgroup>
			<col width="">
			<col width="*">
		</colgroup>
		<tr>
			<h3 class="title_design">Agreement List</h3>
			<td></td>
		</tr>
	</table>
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
	<table>
		<colgroup>
			<col width="">
			<col width="*">
		</colgroup>
		<tr>
			<h3 class="title_design">Master History</h3>
			<td></td>
		</tr>
	</table>
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<table>
		<colgroup>
			<col width="">
			<col width="*">
		</colgroup>
		<tr>
			<h3 class="title_design">Detail(Compensation) History</h3>
			<td></td>
		</tr>
	</table>
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>