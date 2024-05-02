<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0139.jsp
*@FileTitle  : Container SBU 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.event.EsmSaq0139Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0139Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaInquiry.MonthlyQuotaInquiry");
	SignOnUserAccount account = null;

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0139Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="90"/>
					<col width="180"/>
					<col width="55"/>
					<col width="280"/>
					<col width="57"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Origin</th>
					<td><input type="text" class="input1" style="width:80px;" value="<%=account.getOfc_cd()%>" name="org" readonly id="org" /> </td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:80px;" onchange="version_change();"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="quarter" id="quarter" style="width:80px;" onchange="version_change();"></select></td>
				</tr>
				<tr>
					<th>Target Group</th>
					<td><script type="text/javascript">ComComboObject("targetGrp", 2, 80, 0, 0);</script></td>
					<th>Version</th>
					<td><select name="version" id="version" class="input1" style="width:193px;"></select></td>
					<th>Unit</th>
					<td><select name="unit" id="unit" class="input1" style="width:80px;"></select></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->


<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	
	<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table style="width:100%;">
					<tbody>
						<colgroup>
							<col width="200"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<td><b>Sales Quota</b>&nbsp;&nbsp;<input type="radio" name="selType01" id="selType01" value="Q" class="trans" checked>&nbsp;&nbsp;&nbsp;&nbsp;<b>Load Target</b>&nbsp;&nbsp;<input type="radio" id="selType01" name="selType01" value="T" class="trans"></td>
							<th>Trade</th>
							<td><select name="trade01" id="trade01" style="width:60px;" !onchange="subTrade_change()"></select></td>
							<th>Bound</th>
							<td><select name="dirCd01" id="dirCd01" style="width:60px;"></select></td>
							<th>Item</th>
							<td><script type="text/javascript">ComComboObject("item01", 2, 100, 0, 1, 1);</script>
							<button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go<button></td>
							<td class="gray" style="text-align:right"><span class="gray pad_btm_8" id="sheet_unit" name="sheet_unit" style="display:block;" >Unit : TEU / USD / USD 1,000*</span></td>
						</tr> 
					</tbody>
				</table>
			</div>
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('tradeGroupSheet');</script>
			</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" style="display:none">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table style="width:100%;">
					<tbody>
						<colgroup>
							<col width="200"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<td><b>Sales Quota</b>&nbsp;&nbsp;<input type="radio" name="selType02" id="selType02" value="Q" class="trans" checked>&nbsp;&nbsp;&nbsp;&nbsp;<b>Load Target</b>&nbsp;&nbsp;<input type="radio" id="selType02" name="selType02" value="T" class="trans"></td>
							<th>Trade</th>
							<td><select name="trade02" id="trade02" style="width:60px;" !onchange="subTrade_change()"></select></td>
							<th>Bound</th>
							<td><select name="dirCd02" id="dirCd02" style="width:60px;"></select></td>
							<th>Item</th>
							<td><script type="text/javascript">ComComboObject("item02", 2, 100, 0, 1, 1);</script>
							<button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go<button></td>
							<td class="gray" style="text-align:right"><span class="gray pad_btm_8" id="sheet_unit" name="sheet_unit" style="display:block;" >Unit : TEU / USD / USD 1,000*</span></td>
						</tr> 
					</tbody>
				</table>
			</div>
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('laneSheet');</script>
			</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table style="width:100%;">
					<tbody>
						<colgroup>
							<col width="200"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<td><b>Sales Quota</b>&nbsp;&nbsp;<input type="radio" name="selType03" id="selType03" value="Q" class="trans" checked>&nbsp;&nbsp;&nbsp;&nbsp;<b>Load Target</b>&nbsp;&nbsp;<input type="radio" id="selType03" name="selType03" value="T" class="trans"></td>
							<th>Trade</th>
							<td><select name="trade03" id="trade03" style="width:60px;" !onchange="subTrade_change()"></select></td>
							<th>Bound</th>
							<td><select name="dirCd03" id="dirCd03" style="width:60px;"></select></td>
							<th>Item</th>
							<td><script type="text/javascript">ComComboObject("item03", 2, 100, 0, 1, 1);</script>
							<button type="button" class="btn_etc" name="btn_retrieve" id="btn_retrieve">Go<button></td>
							<td class="gray" style="text-align:right"><span class="gray pad_btm_8" id="sheet_unit" name="sheet_unit" style="display:block;" >Unit : TEU / USD / USD 1,000*</span></td>
						</tr> 
					</tbody>
				</table>
			</div>
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('rhqSheet');</script>
			</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
