<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0951.jsp
*@FileTitle  : Load summary by POD 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0951Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0951Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0951Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!-- <title>Load Summary by POD</title> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->

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

<!-- <body  onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows id="pagerows">
<input type="hidden" name="in_ui_type"  id="in_ui_type" value="P">
<!-- ======================================================================== -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print for CBF</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- ============================================================================ -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<tr>
				<th width="40">VVD </th> 
				<td width="40"><input type="text" style="width:80px;" name="in_vvd_cd" value="" dataformat="engup" class="input1" maxlength="9" style="ime-mode:disabled"></td>	
				<th width="30">POL</th>
				<td width="40"><input type="text" style="width:50px;" name="in_pol_cd" value="" dataformat="engup" class="input1" maxlength="5" style="ime-mode:disabled"><!-- 
				 --><input type="text" name="in_pol_yd_cd" style="width:30px;" value="" class="input1" maxlength="2" dataformat="engup" style="ime-mode:disabled"></td>
				<th width="70">BKG Office</th>
				<td><input type="text" style="width:100px;" name="in_bkg_ofc_cd" value="" dataformat="engup" class="input" maxlength="6" style="ime-mode:disabled"></td> 
			</tr>
		</tbody>
	</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="2"></td></tr></table></div>
	<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<tr>
				<td></td>
				<td colspan="5"><input type="text" style="width:700px;" name="setText1" value="" class="input" dataformat="uppernum2" maxlength="80"></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="5"><input type="text" style="width:700px;" name="setText2" value="" class="input" dataformat="uppernum2" maxlength="100"></td>
			</tr>
			 <tr>
				<th width="40">VVD</th>
				<td width="500"><input type="text" name="vvd_cd" style="width:500px;" value="" class="input2" readonly></td>
				<th width="40">POL</th>
				<td width="50"><input type="text" name="un_loc_cd" style="width:51px;" value="" class="input2" readonly></td>
				<th width="40">ETD</th>
				<td><input type="text" name="vps_etd_dt" style="width:140px;" value="" class="input2" readonly></td>	
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- =============================================================================================== -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
<h3 class="title_design grid_heading_clear">Loading Summary by POD</h3>
<div class="grid_option_left">
	<input type="text" style="width:130px;" value="(excluded Void slot)" class="input2" readonly>
	<input type="text" style="width:100px;" value="POD : UN code" class="input2" readonly>	
</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width:98%">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
<h3 class="title_design">Special Stowage by POD</h3>
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width:98%">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<h3 class="title_design">Special Stowage Request by POD</h3>
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width:98%">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->

<div class="opus_design_inquiry">
	<table>
			<colgroup>
				<col width="100"/>
				<col width="300"/>
				<col width="300"/>
				<col width="300"/>
				<col width="*" />
			</colgroup>
		<tbody>
			<tr>
					<td></td>
					<td>OD  - On Deck stowage						<br>ODTB - On Deck top & One bay STWG	<br>UDAB - Under Deck away from heating source <br>UDHG - Under Deck as high as possible</td>
					<td>ODET – On Deck except top					<br>ODTS - On Deck top stowage			<br>UDAV - Under Deck Avoid Boiler			   <br>UDTS - Under Deck top stowage </td>
					<td>ODHD - On Deck top stowage for hot delivery	<br>UD - Under Deck						<br>UDBW - Under Deck below water line		   <br>PCOD – Precaution Container On Deck stowage</td>
					<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->


<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<colgroup>
					<col width="100"/>
					<col width="900"/>
					<col width="*"/>
		</colgroup>
		<tbody>
				<tr> 
					<th>Remark(s)</th>
					<td><textarea name="remark" style="width:900px;height:60px;" dataformat="uppernum2"></textarea></td>
					<td></td>
				</tr>
		</tbody>
	</table>
</div>

</div>
<!-- opus_design_inquiry(E) -->
</form>