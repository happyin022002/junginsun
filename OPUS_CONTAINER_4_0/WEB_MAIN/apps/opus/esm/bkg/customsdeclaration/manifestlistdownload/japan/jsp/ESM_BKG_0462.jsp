<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0462.jsp
*@FileTitle  :
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0462Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0462Event event = null;      //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;  //occurring error in server
	String strErrMsg = "";             //error message
	//int rowCount = 0; 				//list count of DB ResultSet
	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0462Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" 	id="btn_new"	type="button">New</button><!--
		--><button class="btn_normal" name="btn_datadl" id="btn_datadl" type="button">Data D/L</button><!--
		--><button class="btn_normal" name="btn_print"  id="btn_print"  type="button">Print</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30"/>
				<col width="120"/>
				<col width="40"/>
				<col width="120"/>
				<col width="40"/>
				<col width="120"/>
				<col width="40"/>
				<col width="120"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width: 95px" class="input1" maxlength="9" dataformat="engup" name="in_vvd_cd" id="in_vvd_cd" style="ime-mode:disabled"></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" style="width: 60px" class="input1" name="in_pod_cd" id="in_pod_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled"></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" style="width: 60px" class="input" name="in_pol_cd" id="in_pol_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled"></td>
				<th>B/L Type</th>
				<td>
					<select style="width: 80px;" name="in_bl_type">
						<option value="0" selected>ALL</option>
						<option value="1">Local</option>
						<option value="2">T/S</option>
					</select>
				</td>
				<td></td>
			</tr>
		</table>


	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100"/>
				<col width="150"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>Total B/L Count :</th>
				<td><input type="text" style="width: 80px; text-align: right" class="input2" name="totalCount" id="totalCount" disabled="disabled"></td>
				<td></td>
			</tr>
		</table>
	</div>

<div class="wrap_result_tab">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="tabLayer" style="display: none;">
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="tabLayer" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>