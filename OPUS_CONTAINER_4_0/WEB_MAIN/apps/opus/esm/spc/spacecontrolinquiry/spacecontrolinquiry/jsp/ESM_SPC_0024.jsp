<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0024.jsp
*@FileTitle  : No-Show Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
	
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
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="1"/>
					<col width="100"/>
					<col width="60"/>
					<col width="100"/>
					<col width="60"/>
					<col width="100"/>
					<col width="60"/>
					<col width="100"/>
					<col width="60"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Type</th>
					<td><span style="display:none;"><input type="radio" name="type" id="type" value="M" class="trans">Monthly</span><!--
						--><input type="radio" name="type" value="2" class="trans" checked="" id="type" />D-7&nbsp&nbsp&nbsp&nbsp<!--
						--><input type="radio" name="type" value="1" class="trans" id="type" />D-2
					</td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:80px;"></select></td>
					<th>Month</th>
					<td><select class="input1" name="month" id="month" style="width:80px;" onchange="changePeriod();"></select></td>
					<th>Week</th>
					<td colspan="2"><select class="input1" name="week" id="week" style="width:80px;" onchange="changePeriod();"></select></td>
				</tr>
				<tr>
					<th>RHQ</th>
					<td><script type="text/javascript">ComComboObject("rhq", 2, 100, 0, 1);</script></td>
					<th>Office</th>
					<td><input type="text" name="office" style="width:80px;" value="<%=ofc_cd%>" maxlength="6" dataformat="engup" id="office" /></td>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject("trade", 2, 80, 0, 0);</script></td>
					<th>Lane</th>
					<td><script type="text/javascript">ComComboObject("lane", 4, 80, 0, 0, 2);</script></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="text" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" dataformat="engup" id="vvd" /></td>
				</tr>				
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" name="tabLayer" style="display:inline">
		<table>
			<tr>
				<td><b>(WK <span id="sheet1_wk" name="sheet1_wk"></span>)</b></td>
				<td align="right"><b>(Unit : TEU)</b></td>
			</tr>
		</table>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear mar_top_8" >
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<table>
			<colgroup>
					<col width="100"/>
					<col width="10"/>
					<col width="30"/>
					<col width="*"/>
			</colgroup>
			<tr>
				<th>Data Selection</th>
				<td><input type="checkbox" name="ofcCheck" id="ofcCheck" class="trans" checked onclick="dataSelectionByTradeByOffice();"></td>
				<th>ByOffice</th>			
				<td align="right"><b>(Unit : TEU)</b></td>
			</tr>
		</table>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear mar_top_8" >
			<script type="text/javascript">ComSheetObject('t1sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" name="tabLayer" style="display:none">
		<table>
			<tr>		
				<td align="right"><b>(Unit : TEU)</b></td>
			</tr>
		</table>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear mar_top_8" >
			<script type="text/javascript">ComSheetObject('t1sheet3');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<table>
			<tr>		
				<td align="right"><b>(Unit : TEU)</b></td>
			</tr>
		</table>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear mar_top_8" >
			<script type="text/javascript">ComSheetObject('t1sheet4');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" name="tabLayer" style="display:none">
		<table>
			<tr>		
				<td align="right"><b>(Unit : TEU)</b></td>
			</tr>
		</table>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear mar_top_8" >
			<script type="text/javascript">ComSheetObject('t1sheet5');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
</div>
</form>
