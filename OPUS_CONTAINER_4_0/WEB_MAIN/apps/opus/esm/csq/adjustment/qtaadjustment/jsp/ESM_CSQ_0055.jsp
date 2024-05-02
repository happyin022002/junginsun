<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0055.jsp
*@FileTitle  : QTA Edit
*@author     : CLT
*@version    : 1.0 
*@since      : 2015/01/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0055Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmCsq0055Event)request.getAttribute("Event");
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

<form name="form" method="post" style="margin: 0px">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<div class="page_title_area">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" id="btn_Retrieve" name="btn_Retrieve" >Retrieve</button><!-- 
		--><button type="button" class="btn_normal" id="btn_Save" name="btn_Save" >Save</button><!-- 
		--><button type="button" class="btn_normal" id="btn_Creation" name="btn_Creation">CMCB Adjust Creation</button><!-- 
		--><button type="button" class="btn_normal" id="btn_Downexcel" name="btn_Downexcel">Down Excel</button><!-- 
		--><button type="button" class="btn_normal" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
	
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="50">
				<col width="70">
				<col width="50">
				<col width="60">
				<col width="30">
				<col width="40">
				<col width="40">
				<col width="30">
				<col width="80">
				<col width="85">
				<col width="55">
				<col width="80">
				<col width="80">
				<col width="75">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Year</th>
                    <td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
                    <th>Quarter</th>
                    <td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 50, 1, 1 )</script></td>
                    <td colspan="4" ><div style="width:160px;" id="div_period"></div></td>
                    <th>Office View</th>
					<td><script type="text/javascript">ComComboObject('f_ofc_vw_cd', 1, 75, 1, 1)</script></td>
					<th>RHQ</th>
					<td><script type="text/javascript">ComComboObject('f_rhq_cd', 1, 70, 1)</script></td>
					<th>Office</th>
					<td><script type="text/javascript">ComComboObject('f_rgn_ofc_cd', 1, 65, 1)</script></td>
					<th>Portion Connected</th>
					<td><script type="text/javascript">ComComboObject('f_csq_cng_tp_cd', 1, 70, 1)</script></td>
				</tr>
				<tr>
					<th>Month</th>
					<td><script type="text/javascript">ComComboObject('f_to_mon', 1, 60, 1)</script></td>
					<th>Week</th>
					<td><script type="text/javascript">ComComboObject('f_to_wk', 1, 50, 1)</script></td>
					<th>VVD</th>
					<td colspan="3"><input type="text" style="width:38px; ime-mode:disabled" name="f_vsl_cd" id="f_vsl_cd" class="input" maxlength="4" dataformat="engup"><input type="text" style="width:38px; ime-mode:disabled" name="f_skd_voy_no" id="f_skd_voy_no" class="input" maxlength="4" dataformat="engup"><input type="text" style="width:23px; ime-mode:disabled" name="f_skd_dir_cd" id="f_skd_dir_cd" class="input" maxlength="1" dataformat="engup"></td>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 75, 1, 1)</script></td>
					<th>R/Lane</th>
					<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script></td>
					<th>Lane Bound</th>
					<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 65, 1 )</script></td>
					<th></th>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn" id="ias_office_add">
			<button type="button" class="btn_normal" id="btn_ofcAdd" name="btn_ofcAdd">IAS Office Add</button>
		</div>
		<div class="opus_design_inquiry">
			<table>
			<colgroup>
				<col width="120">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th style="height:30px;"><div style="display:none"><input type="checkbox" name="f_decimal_flg" id="f_decimal_flg" value="Y" class="trans"><label for="f_decimal_flg">Decimal G.RPB</label></div></th>
					<td style="text-align:right;">[Unit: TEU, TEU/$, $]</td>
				</tr>
			</tbody>
		</table>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>