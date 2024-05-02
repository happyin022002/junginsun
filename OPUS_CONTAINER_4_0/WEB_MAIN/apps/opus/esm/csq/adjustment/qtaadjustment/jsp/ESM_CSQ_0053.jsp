<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0053.jsp
*@FileTitle  : Portion Adjustment by RHQ
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/05
=========================================================*/	
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmCsq0053Event)request.getAttribute("Event");
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
<input type="hidden" name="f_gubun" value="RHQ" id="f_gubun" />
<input type="hidden" name="f_bse_tp_cd" value="Q" id="f_bse_tp_cd" />
<input type="hidden" name="f_qta_step_cd" value="" id="f_qta_step_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Creation" id="btn_Creation" type="button">Creation</button><!--
		--><button class="btn_normal" name="btn_Downexcel" id="btn_Downexcel" type="button">Down Excel</button><!--
		--></div>
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
				<col width="50">
				<col width="75">
				<col width="65">
				<col width="85">
				<col width="175">
				<col width="80">
				<col width="*">		
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Year</th>
					<td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
					<th>Quarter</th>
					<td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 70, 1, 1)</script></td>
					<td><div id="div_period"></div></td>
					<th>Office View</th>
					<td><script type="text/javascript">ComComboObject('f_ofc_vw_cd', 1, 80, 1, 1)</script></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="50">
				<col width="75">
				<col width="65">
				<col width="85">
				<col width="90">
				<col width="85">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>	
				<tr>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 60, 1)</script></td>
					<th>R/Lane</th>
					<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script></td>
					<th>Trade Bound</th>
					<td><script type="text/javascript">ComComboObject('f_conv_dir_cd', 1, 65, 1)</script></td>
					<th>N.OB/OB</th>
					<td><script type="text/javascript">ComComboObject('f_ob_div_cd', 1, 80, 1, 1)</script></td>
					<td></td>
				</tr>
		   </tbody>
		</table>
		</div>
		</div>
		<div class="wrap_result">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="sheetLayer" name="sheetLayer">
			<div class="opus_design_btn">
			<button class="btn_accent" name="btn_FigureInquiry" id="btn_FigureInquiry" type="button">Figure Inquiry</button><!--
			--><button class="btn_normal" name="btn_RowGrpAdd" id="btn_RowGrpAdd" type="button">RHQ Group Row&nbsp;Add</button><!--
			--><button class="btn_normal" name="btn_RowAdd" id="btn_RowAdd" type="button">Office Row&nbsp;Add</button><!--
			--></div>
			<div class="opus_design_inquiry">
			<table>
			<colgroup>
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
						<td class="gray" height="19" style="text-align: right;" id="sheet_unit">[Unit: %]</td>
				</tr>
			</tbody>
			</table>
			</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>	
			<div class="opus_design_inquiry">
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table>
					<colgroup>
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td><img src="/opuscntr/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td>
						</tr>
						<tr>
							<td><h3 class="title_design2">When you use "Office Group Row Add" & "Creation" button, specific R/Lane information must be selected.</h3></td>
						</tr>
					</tbody>
				</table>
			</div>	
			</div>
			<!-- opus_design_grid(E) -->
		</div>
</form>