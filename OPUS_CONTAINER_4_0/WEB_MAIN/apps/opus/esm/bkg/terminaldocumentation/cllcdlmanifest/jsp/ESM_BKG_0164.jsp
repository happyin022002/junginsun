<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0164.jsp
*@FileTitle  : Container Loading/Discharging Cross-Check 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================
*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0164Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0164Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0164Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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


<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="inc_mty" id="inc_mty" value="N">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="60">
					<col width="10">
					<col width="80">
					<col width="50">
					<col width="100">
					<col width="50">
					<col width="80">
					<col width="50">
					<col width="80">
					<col width="150">
					<col width="*">
				</colgroup>
				<tr>
					<th class="sm">List Type</th>
					<td class="sm"></td>
					<td class="sm"><input type="radio" name="list_type" id="list_type" value="L" class="trans" checked>Loading</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd" id="vvd" style="width:90px; ime-mode: disabled" class="input1" dataformat="engup" maxlength="9" required fullfill caption="VVD"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" id="pol_cd" style="width:70px; ime-mode: disabled" class="input1" dataformat="engup" maxlength="5" required fullfill caption="POL"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" id="pod_cd" style="width:70px; ime-mode: disabled" class="input" dataformat="engup" maxlength="5" caption="POD"></td>
					<th><input type="checkbox" name="inc_mty_chk" id="inc_mty_chk" class="trans">&nbsp;&nbsp;Including Empty</th>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table class="mar_top_4 mar_btm_4" >
			<tbody>
				<colgroup>
					<col width="120">
					<col width="150">
					<col width="*">
				</colgroup>
				<tr class="h23" align="left">
					<th class="sm">Data Cross-Check</th>
					<td class="sm pad_left_12"><input type="radio" name="data_chk" id="data_chk" value="A" class="trans" checked>All&nbsp;&nbsp;&nbsp;<!--  
						--><input type="radio" name="data_chk" id="data_chk" value="M" class="trans">Matched&nbsp;&nbsp;&nbsp;<!--  
						--><input type="radio" name="data_chk" id="data_chk" value="U" class="trans">Un-matched&nbsp;&nbsp;&nbsp;</td>
					<!-- <th>Terminal</th> -->
					<td>
						 <select name="tmnl_type" id="tmnl_type" style="width:90px;visibility:hidden">
	                        <option value="General">General</option>
	                        <option value="TTI">TTI</option>
	                        <option value="COSCO">COSCO</option>
	                        <option value="GPA">GPA</option>
	                      </select>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) --> 
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- layout_wrap (S) -->
	<div class="opus_design_grid" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_loadExcel" id="btn_loadExcel">Load Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<div class="layout_wrap" style="width: 100%">
	    <div class="layout_vertical_2" style="width: 50%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	     <div class="layout_vertical_2" style="width: 1%; height:30px"></div>
	    <div class="layout_vertical_2" style="width: 49%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet3');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
	
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet4');</script><!-- 조회결과 -->
		<script type="text/javascript">ComSheetObject('sheet5');</script><!-- 엑셀업로드내용 -->
		<script type="text/javascript">ComSheetObject('sheet6');</script><!-- 정렬 완료된 data -->
	</div>
	
<!-- layout_wrap (E) -->
</div>
</form>