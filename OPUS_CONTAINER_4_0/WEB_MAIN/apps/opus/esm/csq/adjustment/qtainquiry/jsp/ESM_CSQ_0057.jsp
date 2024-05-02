<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0057.jsp
*@FileTitle  : QTA Inquiry_Yearly Overall (Currently Updated)
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.adjustment.qtainquiry.event.EsmCsq0057Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.adjustment.qtainquiry");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmCsq0057Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_bse_tp_cd" value="Y" id="f_bse_tp_cd" />
<!-- 개발자 작업	-->


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_RawDataDownExcel" id="btn_RawDataDownExcel" type="button">Raw Data Export</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->




<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="70">
				<col width="105">
				<col width="50">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td class="sm pad_left_8"><input type="radio" name="f_year_tp_cd" id="f_year_tp_cd_1" class="trans" value="I" checked><label for="f_year_tp_cd_1"><strong>Initial Fixed</strong></label></td>
					<th>Year</th>
					<td colspan="2"><script type="text/javascript">ComComboObject('f_bse_yr', 1, 88, 1, 1 )</script></td>
					<th>Office View</th>
					<td><script type="text/javascript">ComComboObject('f_ofc_vw_cd', 1, 75, 1, 1)</script></td>
					<th>Office Level</th>
					<td><script type="text/javascript">ComComboObject('f_ofc_lvl', 1, 90, 1, 1)</script></td>
					<th><div id="div_rhq">RHQ</div></th>
					<td><script type="text/javascript">ComComboObject('f_rhq_cd', 1, 70, 1 )</script></td>	
					<th><div id="div_ofc">Office</div></th>
					<td><script type="text/javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 1)</script></td>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<td class="sm pad_left_8"><input type="radio" name="f_year_tp_cd" id="f_year_tp_cd_2" class="trans" value="C"><label for="f_year_tp_cd_2"><strong>Currently Updated</strong></label></td>
					<th><div id="div_monwk">Month</div></th>
					<td>
						<div id="div_mon" style="display:inline">
							<input type="text" style="text-align:center; class="input" size="3" maxlength="2" onkeypress="ComKeyOnlyNumber(window);" name="f_fm_mon" id="f_fm_mon" />
							<span class="dash">~</span>
							<input type="text" style="text-align:center; class="input" size="3" maxlength="2" onKeyPress='ComKeyOnlyNumber(window);' name="f_to_mon">
						</div>
						<div id="div_wk" style="display:none">
							<input type="text" style="text-align:center;" class="input" size="3" maxlength="3" onkeypress="ComKeyOnlyNumber(window);" name="f_fm_wk" id="f_fm_wk" />
							<span class="dash">~</span>
							<input type="text" style="text-align:center;" class="input" size="3" maxlength="3" onKeyPress='ComKeyOnlyNumber(window);' name="f_to_wk">
						</div>
					</td>
					<th><input type="checkbox" value="W" name="chk_week" class="trans" id="chk_week" /><label for="chk_week">Week</label></th>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 75, 1)</script></td>
					<th>R/Lane</th>
					<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 90, 1)</script></td>
					<th>Lane Bound</th>
					<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 70, 1)</script></td>
					<th></th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70">
				<col width="70">
				<col width="150">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<td>&nbsp;&nbsp;<input type="checkbox" value="W" name="f_chk_week" class="trans" id="f_chk_week"/><label for="f_chk_week"><strong>Week</strong></label></td>
				<td>&nbsp;&nbsp;<input type="checkbox" value="V" name="f_chk_vvd" class="trans" id="f_chk_vvd"/><label for="f_chk_vvd"><strong>VVD</strong></label></td>
				<td><div style="display:none"><input type="checkbox" value="A" name="f_chk_aloc_qta" class="trans" id="f_chk_aloc_qta"/><label for="f_chk_aloc_qta"><strong>ALLOC = QTA Only</strong></label></div></td>
				<td><div style="display:none"><input type="checkbox" value="D" name="f_chk_decimal" class="trans" id="f_chk_decimal"/><label for="f_chk_decimal"><strong>Decimal G.RPB</strong></label></div></td>
				<td style="text-align:right;"><label>[Unit: TEU, $, TEU/$]</label></td>
			</tr>	
		</table>
	</div>
	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>