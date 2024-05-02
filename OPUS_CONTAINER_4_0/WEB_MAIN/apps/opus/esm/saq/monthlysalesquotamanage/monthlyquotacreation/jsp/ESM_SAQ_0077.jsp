<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0077.jsp
*@FileTitle  : Model Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0077Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0077Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaCreation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0077Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Model Result</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_basedatacreation" 	id="btn_basedatacreation">Base Data Creation</button><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" 			id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_saveasfinal" 		id="btn_saveasfinal">Save As Final Version</button>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="30" />
					<col width="100" />
					<col width="50" />
					<col width="100" />
					<col width="50" />
					<col width="100" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:65px;" onchange="search_onChange();"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="bse_qtr_cd" id="bse_qtr_cd" style="width:65px;" onchange="search_onChange();"></select></td>
					<th>Version</th>
					<td><select name="version" id="version" class="input1" style="width:100px;"></select></td>
					<th>Unit</th>
					<td><select name="unit" id="unit" class="input1" style="width:65px;"></select></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<span class="grid_option_right pad_btm_8" id="sheetUnit">Unit : TEU, 1,000USD</span>
		<script type="text/javascript">ComSheetObject('modelResult01');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<span class="grid_option_right pad_btm_8" id="sheetUnit">Unit : TEU, 1,000USD</span>
		<script type="text/javascript">ComSheetObject('modelResult02');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<span class="grid_option_right pad_btm_8" id="sheetUnit">Unit : TEU, 1,000USD</span>
		<script type="text/javascript">ComSheetObject('modelResult03');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>				

</form>