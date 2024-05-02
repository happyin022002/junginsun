<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0329
*@FileTitle  : Korea Manifest Download
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0329Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnNoVO"%>

<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0329Event event 		= null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException 	= null; //서버에서 발생한 에러
	String strErrMsg 			= ""; 	//에러메세지
	int rowCount 				= 0; 	//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList 			= "";
	String pageRows 			= "100";

	String strUsr_id 			= "";
	String strUsr_nm 			= "";
	String strOfc_cd			= "";
	boolean bBtn_Disabled 		= true;
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.KorManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0329Event) request.getAttribute("Event");

		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		if ("US".equals(account.getCnt_cd()) || "CA".equals(account.getCnt_cd())) bBtn_Disabled = false;

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length>= 1) {
			// showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="in_bound" name="in_bound" value="I" type="hidden" />
<input id="bl_dl" name="bl_dl" value="bl" type="hidden" />
<input id="all_err" name="all_err" value="all" type="hidden" />
<input id="in_pol_tmnl" name="in_pol_tmnl" type="hidden" />
<input id="in_pod_tmnl" name="in_pod_tmnl" value="KRPUSHN" type="hidden" />
<input id="mrn_chk_no" name="mrn_chk_no" type="hidden" />
<input id="mrn_nbr" name="mrn_nbr" type="hidden" />
<input id="in_blno" name="in_blno" type="hidden" />
<input id="in_bkg_no" name="in_bkg_no" type="hidden" />
<input id="strOfc_cd" name="strOfc_cd" value="<%=strOfc_cd%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn"><!--
		--><button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_New" name="btn_New" class="btn_normal">New</button><!--
		--><button type="button" id="btn_Delete" name="btn_Delete" class="btn_normal">Delete</button><!--
		--><button type="button" id="btn_DownExcel" name="btn_DownExcel" class="btn_normal">Down Excel</button><!--
		--><button type="button" id="btn_DataDL" name="btn_DataDL" class="btn_normal">Data D/L</button><!--
		--><button type="button" id="btn_AddBL" name="btn_AddBL" class="btn_normal">Add B/L</button><!--
		--><button type="button" id="btn_EditBL" name="btn_EditBL" class="btn_normal">Edit B/L</button><!--
		--><button type="button" id="btn_Transmission" name="btn_Transmission" class="btn_normal">Transmission</button><!--
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
				<col width="39"/>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tr>
				<th>MRN</th>
				<td><input type="text" name="mrn_no" id="mrn_no" class="input2" style="width:95px; text-align:center;" readOnly></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" name="in_vvd" id="in_vvd" class="input1" style="width:85px; text-align:center;" dataformat="engup"  maxlength="9" onfocus="javascript:funcOnFocus('vvd');"></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="in_pol" id="in_pol" class="input" style="width:50px; text-align:center;" dataformat="engup" maxlength="5" onChange="funcOnFocus('pol')"><!--
					--><input type="text" name="in_pol_yd" id="in_pol_yd" class="input" style="width:25px; text-align:center;" dataformat="engup" maxlength="2"></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" name="in_pod" id="in_pod" class="input1" style="width:50px; text-align:center;" dataformat="engup" maxlength="5" onChange="funcOnFocus('pod')"><!--
					--><input type="text" name="in_hn" id="in_hn" class="input" style="width:25px; text-align:center;" dataformat="engup" maxlength="2"></td>
				<th>Type</th>
				<td><select style="width:105px;" class="input" name="sel_type" id="sel_type">
						<option value=" " selected>  </option>
						<option value="A">A : Local</option>
						<option value="M">M : eMpty Local</option>
					</select></td>
				<th>Trans</th>
				<td class="sm pad_left_4"><input type="radio" class="trans" name="rad_ib" id="rad_ib" checked><label for="rad_ib">I/B</label><input type="radio" class="trans" name="rad_ob" id="rad_ob"><label for="rad_ob">O/B</label></td>
				<td></td>
				<td class="sm pad_left_4"><input type="radio" class="trans" name="rad_all" id="rad_all" checked><label for="rad_all">All</label><input type="radio" class="trans" name="rad_err" id="rad_err"><label for="rad_err">Error</label></td>
				<th id="sc_td1" style="display:none;">C/S</th>
				<th id="sc_td2" style="display:none;"><script type="text/javascript">ComComboObject('sc', 2, 80, 1, 0)</script></th>
				<td style="text-align:right;"><input type="text" class="input" name="msn_start_num" id="msn_start_num" style="width:50px; text-align:right; display:none;" maxlength="4" dataformat="num"></td>
				<td style="display:none;"><button style="display:none;" type="button" id="btn_msn_save" name="btn_msn_save" class="btn_etc">MSN Save</button></td>
				<th id="etb_td1" style="display:none;">ETB</th>
				<th id="etb_td2" style="display:none;"><input type="text" name="etb_dt" class="input2" style="width:80; text-align:center;" ReadOnly></th>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="39 "/>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col width="65" />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tr>
				<td>&nbsp;</td>
				<td><select name="bl_bkg_tp" id="bl_bkg_tp" class="input" disabled style="width:95px;'">
						<option VALUE="BL">B/L No.</option>
						<option VALUE="BKG">BKG No.</option>
					</select><!--
					--><input type="text" class="input" style="width:105px; text-align:center;" name="bl_bkg_no" id="bl_bkg_no" dataformat="eng"></td>
				<th>Data</th>
				<td class="sm pad_left_4">
					<input type="radio" class="trans" name="rad_nodownlist" id="rad_nodownlist" checked><label for="rad_nodownlist">B/L List</label>
					<input type="radio" class="trans" name="rad_downedlist" id="rad_downedlist"><label for="rad_downedlist">D/L List</label></td>
				<td style="display:none;">
					<input type="radio" class="trans" name="rad_mftcheck" id="rad_mftcheck"><label for="rad_mftcheck">M/F Chk</label>
					<input type="radio" class="trans" name="rad_crscheck" id="rad_crscheck"><label for="rad_crscheck">Cross Chk</label></td>
				<th>B/L Type</th>
				<td><select style="width:80px;" class="input" name="bl_type" id="bl_type" onchange="javascript:funcBlTypeOnChange(this);">
						<option selected>ALL</option>
						<option value="S">Simple</option>
						<option value="C">Consol</option>
						<option value="E">Empty</option>
						<option value="M">T/S Empty</option>
					</select></td>
				<th><span id="cgo_tp1">CGO TP</span><span id="el_no1" style="display:none;">E/L No.</span></th>
				<td><select style="width:50px;" class="input" name="cgo_tp" id="cgo_tp" onchange="javascript:funcCargoTypeOnChange(this);">
						<option selected>ALL</option>
						<option value="I">I</option>
						<option value="T">T</option>
					</select>
					<select style="width:50px; display:none;" class="input" name="el_type" id="el_type" onchange="javascript:funcElTypeOnChange(this);">
						<option selected>ALL</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
					</select></td>
				<th>Correction</th>
				<td><script type="text/javascript">ComComboObject('correction', 1, 50, 1, 0)</script></td>
				<th><span id="span_eta_etd">ETA</span></th>
				<td><input type="text" name="eta_etd" id="eta_etd" class="input2" style="width:80px; text-align:center;" ReadOnly></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table class="grid_2 wAuto" id="mainTable">
			<colgroup>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="*" />
			</colgroup>
			<tr>
				<th><b>B/L :</b></th>
				<td>Local <input type="text" style="width:35px;" class="input" style="text-align:right;" name="bl_local" readOnly></td>
				<td>T/S	<input type="text" style="width:35px;" class="input" style="text-align:right;" name="bl_ts" readOnly></td>
				<td>Empty <input type="text" style="width:35px;" class="input" style="text-align:right;" name="bl_empty" readOnly></td>
				<td>T/S E. <input type="text" style="width:35px;" class="input" style="text-align:right;" name="bl_ts_empty" readOnly></td>
				<td>Total <input type="text" style="width:35px;" class="input" style="text-align:right;" name="bl_total" readOnly></td>
				<th><b>CNTR :</b></th>
				<td>Local <input type="text" style="width:35px;" class="input" style="text-align:right;" name="cntr_local" readOnly></td>
				<td>T/S	<input type="text" style="width:35px;" class="input" style="text-align:right;" name="cntr_ts" readOnly></td>
				<td>Empty <input type="text" style="width:35px;" class="input" style="text-align:right;" name="cntr_empty" readOnly></td>
				<td>T/S E. <input type="text" style="width:35px;" class="input" style="text-align:right;" name="cntr_ts_empty" readOnly></td>
				<td>Total <input type="text" style="width:35px;" class="input" style="text-align:right;" name="cntr_total" readOnly></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->


</div>
</form>
<form name="transmitForm" id="transmitForm" method="POST" Action="ESM_BKG_0344.do?pgmNo=ESM_BKG_0344" target="transmitWindow">
<input type="hidden" name="in_vvd">
<input type="hidden" name="in_pol">
<input type="hidden" name="in_type">
<input type="hidden" name="in_pod">
<input type="hidden" name="in_blno">
<input type="hidden" name="in_bound">
<input type="hidden" name="in_tml">
<input type="hidden" name="dwell">
<input type="hidden" name="ib_vvd">
<input type="hidden" name="ib_seq">
<input type="hidden" name="ib_cblno">
<input type="hidden" name="ib_port">
<input type="hidden" name="ib_bkgno">
<input type="hidden" name="ib_type">
</form>
