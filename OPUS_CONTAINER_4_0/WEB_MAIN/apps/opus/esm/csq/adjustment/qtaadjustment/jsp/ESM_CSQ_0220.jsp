<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0220.jsp
*@FileTitle  : QTA Edit for IAS Sector
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0220Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0220Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.adjustment.qtaadjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCsq0220Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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
<input type="hidden" name="f_bse_tp_cd" value="Q" id="f_bse_tp_cd" />
<input type="hidden" name="f_trd_cd" id="f_trd_cd" value="IAS"/> 

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_CmcbCreation" id="btn_CmcbCreation" type="button">CMCB Adjust Creation</button><!--
		--><button class="btn_normal" name="btn_Downexcel" id="btn_Downexcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_Loadexcel" id="btn_Loadexcel" type="button">Load Excel</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="65">
				<col width="50">
				<col width="65">
				<col width="150">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="50">
				<col width="80">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Year</th>
					<td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 55, 0, 1)</script></td>
					<th>Quarter</th>
					<td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 55, 0, 1 )</script></td>
					<td><div id="div_period"></div></td>										
					<th>Office View</th>
					<td><script type="text/javascript">ComComboObject('f_ofc_vw_cd', 1, 70, 0, 1)</script></td>
					<th>RHQ</th>
					<td><script type="text/javascript">ComComboObject('f_rhq_cd', 1, 70, 0)</script></td>
					<th>Office</th>
					<td><script type="text/javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 0)</script></td>
					<th>Main</th>
					<td><select  name="f_csq_mn_sctr_flg" id="f_csq_mn_sctr_flg" style="width:70px;" class="input">
							<option value="All" selected="selected">All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="50">
				<col width="65">
				<col width="50">
				<col width="65">
				<col width="30">
				<col width="40">
				<col width="40">
				<col width="25">
				<col width="75">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="50">
				<col width="80">
				<col width="50">
				<col width="80">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Month</th>
					<td><script type="text/javascript">ComComboObject('f_to_mon', 1, 55, 0)</script></td>
					<th>Week</th>
					<td><script type="text/javascript">ComComboObject('f_to_wk', 1, 55, 0)</script></td>
					<th>VVD</th>
					<td><input type="text" style="width:40px; ime-mode:disabled" name="f_vsl_cd" id="f_vsl_cd" class="input" maxlength="4" dataformat="engup"></td>
					<td><input type="text" style="width:40px; ime-mode:disabled" name="f_skd_voy_no" id="f_skd_voy_no" class="input" maxlength="4" dataformat="engup"></td>
					<td><input type="text" style="width:25px; ime-mode:disabled" name="f_skd_dir_cd" id="f_skd_dir_cd" class="input" maxlength="1" dataformat="engup"></td>										
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject('f_sub_trd_cd', 1, 70, 1, 1)</script></td>
					<th>Lane Bound</th>
					<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 70, 0 ,1  )</script></td>
					<th>R/Lane</th>
					<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 70, 0, 1)</script></td>
					<th>POL</th>
					<td><script type="text/javascript">ComComboObject('f_pol_cd', 1, 70, 0)</script></td>
					<th>POD</th>
					<td><script type="text/javascript">ComComboObject('f_pod_cd', 1, 70, 0)</script></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_laneOfc" id="btn_laneOfc" type="button">Lane Office</button><!--  
			--><button class="btn_normal" name="btn_sctrOfc" id="btn_sctrOfc" type="button">Sector Office</button><!--  
			--><button class="btn_normal" name="btn_pairAdd" id="btn_pairAdd" type="button">POL-POD Pair Add</button><!--  
			--><button class="btn_normal" name="btn_ofcAdd" id="btn_ofcAdd" type="button">Office Add</button>
		</div>
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td style="text-align:right;" id="sheet_unit">[Unit: TEU, $, TEU/$]</td>
					</tr>
				</tbody>
			</table>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
