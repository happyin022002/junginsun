<%/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0249.jsp
*@FileTitle  : Customer Code Entry 
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0249Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0249Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // error from server
	String strErrMsg = ""; // error message
	int rowCount = 0; // count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bUsr_ofc = false;
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");

	try
	{
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0249Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null)
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}
	catch (Exception e)
	{
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
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="120">
				<col width="80">
				<col width="120">
				<col width="80">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width: 80px; ime-mode: disabled" dataformat="engup" class="input" name="vvd_cd" maxlength="9" caption="VVD" id="vvd_cd" /></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" style="width: 80px; ime-mode: disabled" maxlength="5" class="input" dataformat="engup" name="pol_cd" caption="POL" id="pol_cd" /></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" style="width: 80px; ime-mode: disabled" class="input1" dataformat="engup" name="vps_port_cd" maxlength="5" caption="POD" id="vps_port_cd" /></td>
				<th>ETA</th>
				<td><input type="text" style="width: 85px; ime-mode: disabled" class="input" maxlength="10" dataformat="ymd" name="s_vps_eta_dt" caption="ETA" cofield="e_vps_eta_dt" id="s_vps_eta_dt" /> ~  <input type="text" style="width: 85px; ime-mode: disabled" class="input" maxlength="10" dataformat="ymd" name="e_vps_eta_dt" caption="ETA" cofield="s_vps_eta_dt" id="e_vps_eta_dt" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
			</tr>
			<tr>
				<th>LANE</th>
				<td><input type="text" style="width: 80px; ime-mode: disabled" class="input" dataformat="engup" name="slan_cd" maxlength="3" caption="LANE" id="slan_cd" /> </td>
				<th>&nbsp;</th>
				<td>&nbsp;</td>
				<th>Operator</th>
				<td><input type="text" style="width: 80px;" class="input" dataformat="enguponly" name="crr_cd" maxlength="4" caption="Operator" id="crr_cd" /> </td>
				<th>CRN</th>
				<td><input type="text" style="width: 234px; ime-mode: disabled" dataformat="engup" class="input" name="cvy_ref_no" maxlength="20" caption="CRN" id="cvy_ref_no" /> </td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
</div>
</form>