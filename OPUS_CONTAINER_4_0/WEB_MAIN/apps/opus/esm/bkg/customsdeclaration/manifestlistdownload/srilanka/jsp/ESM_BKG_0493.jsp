<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0493.jsp
*@FileTitle  : Vessel Registeration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0493Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.*" %>

<%
	EsmBkg0493Event  event = null;              //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = "";                      //Error message
	int rowCount     = 0;                       //DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id        = "";
	String strUsr_nm        = "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	<%=ConstantMgr.getCompanyNameToJS()%>
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pgNo">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="call_port">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="sr_sts_cd">
<input type="hidden" name="rgst_dt">
<input type="hidden" name="rjct_dt">
<input type="hidden" name="vsl_auth_no">
<input type="hidden" name="sr_sts_desc">
<input type="hidden" name="sr_cmt_desc">
<input type="hidden" name="decl_bl_qty">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button">
			<span id="title"></span>
		</button>
	</h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_ViewResponse" id="btn_ViewResponse">View Response</button>
		<button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">Transmit</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- inquiry_area(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry">
	<!--  biz_1 (S) -->
	<table>
		<colgroup>
			<col width="30px"  />
			<col width="155px" />
			<col width="30px"  />
			<col width="135px" />
			<col width="110px" />
			<col width=""      />
		</colgroup>
		<tbody>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input name = "frm_vvd_number" dataformat="engup" style="width:80px; ime-mode: disabled" type="text" class="input1" value="" maxlength="9" style="text-align:center"></td>
				<th title="Port of Discharging">POD</th>
				<td><input  name = "pod_cd" dataformat="engup" style="width:50px; ime-mode: disabled;" type="text" class="input1" value="LKCMB" maxlength="5" style="text-align:center"></td>
				<th>Last Call Port CD</th>
				<td><input  name = "frm_call_port_cd" dataformat="engup" style="width:50px; ime-mode: disabled;" type="text" class="input1" value="" maxlength="5" style="text-align:center"></td>
			</tr>
		</tbody>
	</table>
	<!--  biz_1   (E) -->
</div>
</div>
<!-- inquiry_area(E) -->

<!-- data_area(S) -->
<div class="wrap_result">
<div class="opus_design_inquiry">
	<table class="grid2 wFit">
		<colgroup>
			<col width="180px"  />
			<col width="190px"  />
			<col width="110px"  />
			<col width=""       />
		</colgroup>
		<tbody>
			<tr>
				<th>Vessel Registration No.</th>
				<td colspan="3"><input name= "frm_vsl_rgst_no" type="text"  dataformat="engup" style="width:120px; ime-mode: disabled" class="input" value=""></td>
			</tr>
			<tr>
				<th>Arrival  Date</th>
				<td><input name = "frm_vps_eta_dt"  dataformat="ymd" type="text" style="width:120px;" class="input" maxlength="10"></td>
				<th>Arrival  Time</th>
				<td><input type="text" name = "frm_vps_eta_dt_time" dataformat="hms" style="width:100px;" class="input" maxlength="8"></td>
			</tr>
			<tr>
				<th>Departure  Date</th>
				<td><input type="text" name = "frm_vps_etd_dt" dataformat="ymd" style="width:120px;" class="input" maxlength="10"></td>
				<th>Departure Time</th>
				<td><input type="text"  name = "frm_vps_etd_dt_time" dataformat="hms" style="width:100px;" class="input" maxlength="8"></td>
			</tr>
			<tr>
				<th>Vessel  Name</th>
				<td><input type="text" name = "frm_vsl_eng_nm"  dataformat="engup"  style="width:120px; ime-mode: disabled" class="input" value="" maxlength="50"></td>
				<th>Vessel Flag</th>
				<td><input name = "frm_vsl_rgst_cnt_cd"  dataformat="engup"  style="width:40px; ime-mode: disabled" type="text" class="input" value="" maxlength="2"></td>
				</tr>
			<tr>
				<th>Captain  Name</th>
				<td colspan="3"><input name = "frm_cap_nm" dataformat="enguponly" otherchar=" " style="width:400px; ime-mode: disabled" type="text" class="input" ></td>
			</tr>
			<tr>
				<th>Departure  Port CD</th>
				<td><input name = "frm_depature_port" type="text"   dataformat="engup" style="width:120px; ime-mode: disabled" class="input"  maxlength="5"></td>
				<th>Arrival  Port CD</th>
				<td><input name = "frm_arrival_port" type="text"   dataformat="engup" style="width:100px; ime-mode: disabled" class="input"  maxlength="5"></td>
				</tr>
			<tr>
				<th>Shipping  Agent</th>
				<td colspan="3"><input name = "frm_vsl_nm"   dataformat="engup" style="width:400px; ime-mode: disabled" type="text" class="input" value=""></td>
			</tr>
			<tr>
				<th>Local  Agent</th>
				<td colspan="3"><input name = "frm_vsl_nm2"  dataformat="engup" style="width:400px; ime-mode: disabled" type="text" class="input" value=""></td>
			</tr>
			<tr>
				<th>Vessel  Auth  No.</th>
				<td colspan="3"><input name = "frm_vsl_auth_no"  dataformat="engup" type="text" style="width:120px;" class="input" value=""></td>
			</tr>
		</tbody>
	</table>
</div>

<!-- data_area(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none">
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
