<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1085.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1085Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1085Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1085Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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

<form name="form" method="post">

<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="tab_no" id="tab_no" value="1">
<input type="hidden" name="sheet_no" id="sheet_no">
<input id="calllback" name="calllback" value="callback1086" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!--
	--><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!--
	--><button type="button" class="btn_normal" name="btn_Edi" 			id="btn_Edi">EDI File Download</button><!--
	--><button type="button" class="btn_normal" name="btn_Excel" 			id="btn_Excel">Excel File Download</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->

<!-- wrap_search (S) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="40"/>
				<col width="60"/>
				<col width="175"/>
				<col width="100"/>
				<col width="113"/>
				<col width="100"/>
				<col width="60"/>
				<col width="60"/>
				<col width="60"/>
				<col width="60"/>
				<col width="60"/>
				<col width="80"/>
				<col width="80"/>
				<col width="50"/>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th class="sm">Data</th>
					<td class="sm"><!--
					--><input type="radio" class="trans" name="data_type" id="data_type" value="bl">B/L &nbsp;&nbsp;<!--
					--><input type="radio" class="trans" name="data_type" id="data_type" value="dl" checked="checked">D/L&nbsp;&nbsp;</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><!--
					--><input type="text" style="width:85px;ime-mode:disabled" class="input1" name="vvd" id="vvd" maxlength="9" dataformat="engup" caption="VVD" fullfill /></td>
					<th>Vessel Name</th>
					<td><!--
					--><input type="text" style="width:90px;" class="input2" name="vvd_nm" id="vvd_nm" readonly="readonly" /></td>
					<th title="Port of Loading">POL</th>
					<td><!--
					--><input type="text" style="width:50px;ime-mode:disabled" class="input" name="pol_cd" id="pol_cd" maxlength="5" dataformat="engup" caption="POL" fullfill /></td>
					<th title="Port of Discharging">POD</th>
					<td><!--
					--><input type="text" style="width:50px;ime-mode:disabled" class="input1" name="pod_cd" id="pod_cd" maxlength="5" dataformat="engup" caption="POD" fullfill /></td>
					<th>B/L No.</th>
					<td><!--
					--><input type="text" style="width:105px;ime-mode:disabled" class="input" name="bl_no" id="bl_no" maxlength="12" dataformat="engup" caption="B/L No." fullfill /></td>
					<th class="sm cgo1" style="display:none">Cargo Type</th>
					<td class="sm pad_rgt_8 cgo1" style="display:none"><%=JSPUtil.getCodeCombo("cgo_type", "", "", "CD20023", 0, "")%></td>
					<th class="sm cgo2">Cargo Code</th>
					<td class="sm pad_rgt_8 cgo2"><script type="text/javascript">ComComboObject('cgo_code', 2, 50, 1, 0);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div>
			<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="140"/>
					<col width="60"/>
					<col width="110"/>
					<col width="80"/>
					<col width="100" />
					<col width="60" />
					<col width="90" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Arrival Date</th>
					<td><!--
					--><input type="text" style="width:80px;ime-mode: disabled" class="input" maxlength="10" dataformat="ymd" name="eta_dt" id="eta_dt" caption="Arrival Date"><!--
					--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>
					<th>Rotation No.</th>
					<td><!--
					--><input type="text" style="width:90px;ime-mode:disabled" class="input" name="rotn_no" id="rotn_no" maxlength="10" dataformat="engup" caption="Rotation No.">
					</td>
					<th>No. of Installment</th>
					<td><!--
					--><input type="text" style="width:50px;ime-mode:disabled" class="input" name="instl_no" id="instl_no" maxlength="4" dataformat="int" caption="No. of Installment">
					</td>
					<th>MRN No.</th>
					<td><!--
					--><input type="text" style="width:80px;ime-mode:disabled" class="input" name="mrn_no" id="mrn_no" maxlength="7" dataformat="engup" caption="MRN No.">
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search (E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_bl1" 	id="btn_bl1">B/L Detail</button>
			<button type="button" class="btn_normal" name="btn_cust1" 	id="btn_cust1">Customer Detail</button>
			<button type="button" class="btn_normal" name="btn_Unit1" 	id="btn_Unit1">Package Unit</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_bl2" 		id="btn_bl2">B/L Detail</button><!--
		--><button type="button" class="btn_normal" name="btn_cust2" 	id="btn_cust2">Customer Detail</button><!--
		--><button type="button" class="btn_normal" name="btn_Unit2" 	id="btn_Unit2">Package Unit</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
