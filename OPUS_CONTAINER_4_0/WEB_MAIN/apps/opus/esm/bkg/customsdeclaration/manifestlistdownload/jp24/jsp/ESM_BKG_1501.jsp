<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1501.jsp
*@FileTitle  : Advance Cargo Information Download & Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1501Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1501Event event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    //occurring error in server
	String strErrMsg = "";               //error message
	int rowCount = 0;                    //list count of DB ResultSet

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1501Event)request.getAttribute("Event");
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
	var strUsrId = "<%=strUsr_id%>";

	function setupPage() {
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

<!-- 개발자 작업 -->
<input type="hidden" name="del_trasmit_flag" id="del_trasmit_flag" />
<input type="hidden" name="vvd" id="vvd" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="pol_split_no" id="pol_split_no" />
<input type="hidden" name="rlx_div" id="rlx_div" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button><!--
		 --><button class="btn_normal" type="button" name="btn_bl_inquiry" id="btn_bl_inquiry">Manifest(B/L)</button><!--
		 --><button class="btn_normal" type="button" name="btn_data_download" id="btn_data_download">Data Download</button><!--
		 --><button class="btn_normal" type="button" name="btn_down_excel" id="btn_down_excel">Down Excel</button><!--
		 --><button class="btn_normal" type="button" name="btn_transmit" id="btn_transmit">Transmit</button><!--
		 --><button class="btn_normal" type="button" name="btn_del_transmit" id="btn_del_transmit">DEL Transmit</button><!--
		 --><button class="btn_normal" type="button" name="btn_view_file" id="btn_view_file">View Send File</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_search pad_btm_12">
	<div class="layout_wrap">
		<!-- layout_flex_fixed(S) -->
		<div class="layout_flex_fixed" style="width: 600px;">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="120" />
						<col />
						<col />
						<col width="118" />
					</colgroup>
					<tbody>
						<tr>
							<th>Retrieve from (source)</th>
							<td><select style="width:120px;" class="input1" name="search_div" id="search_div">
									<option value="BL" selected>B/L Data</option>
									<option value="DN">Download Data</option>
								</select>
							</td>
							<th>All or Error only</th>
							<td><select style="width:100px;" class="input1" name="error_div" id="error_div">
									<option value="" selected>All</option>
									<option value="ERR">Error B/L</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="sm" style="width:580px;">
					<colgroup>
						<col width="25" />
						<col />
						<col />
						<col />
						<col />
						<col width="118" />
					</colgroup>
					<tbody>
						<tr>
							<td align="right"><input type="radio" name="vvd_date_div"  id="vvd_date_div" value="VVD" class="trans" checked></td>
							<th style="text-align:left;"><label for="vvd_date_div">VVD</label><!--
								--><input type="text" class="input1" style="width:105px;" name="vvd_hdr" id="vvd_hdr" maxlength="9" required caption="VVD" fullfill dataformat="engup"></th>
							<th>Call Sign</th>
							<td><input type="text" class="input2" style="width:70px;" name="call_sgn_no" id="call_sgn_no" readOnly></td>
							<th>Cons Voy.</th>
							<td><input type="text" class="input2" style="width:100px;" name="ib_cssm_voy_no" id="ib_cssm_voy_no" readOnly></td>
						</tr>
						<tr>
							<td align="right"><input type="radio" name="vvd_date_div" id="vvd_date_div_1" value="DATE" class="trans"></td>
							<td colspan="3" style="padding-left:5px;" >
								<select class="input" name="vps_dt_div" id="vps_dt_div" style="width:60px; font-weight:bold;">
									<option value="ETD" selected>ETD</option>
									<option value="ETA">ETA</option>
									</select><!--
								 --><input type="text" class="input2" style="width:75px;" name="date_fm" id="date_fm" dataformat="ymd" maxlength="10" caption="From Date" cofield="date_to" readOnly>~ <!--
								 --><input type="text" class="input2" style="width:75px;" name="date_to" id="date_to" dataformat="ymd" maxlength="10" caption="To Date" cofield="date_fm" readOnly><!--
								 --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir" disabled></button></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="160" />
						<col />
						<col />
						<col />
						<col />
						<col width="78" />
					</colgroup>
					<tbody>
						<tr>
							<td><select class="input" name="pol_div" id="pol_div" style="width:70px; font-weight:bold;">
									<option value="VVD_POL" selected>V/POL</option>
									<option value="BKG_POL">B/POL</option>
								</select><!--
								 --><input type="text" class="input" style="width:60px;" caption="POL" name="pol_cd_hdr" id="pol_cd_hdr" maxlength="5" dataformat="engup"></td>
							<td><select class="input" name="pod_div" id="pod_div" style="width:70px; font-weight:bold;">
									<option value="VVD_POD" selected>V/POD</option>
									<option value="BKG_POD">B/POD</option>
								</select><!--
								 --><input type="text" class="input2" style="width:20px; border-right-style:none; margin-right:0px;" name="vvd_pod_prefix" id="vvd_pod_prefix" value="JP" readOnly><input type="text" class="input" style="width:40px; border-left-style:none; margin-left:0px;" name="vvd_pod_postfix" id="vvd_pod_postfix" maxlength="3" dataformat="engup"><!--
								 --><input type="text" class="input" style="width:60px; display:none;" caption="POL" name="bkg_pod_hdr" id="bkg_pod_hdr" maxlength="5" dataformat="engup"><!--
								 --><select name="pod_split_no" id="pod_split_no" class="input" style="width:40px;">
									<option value="" selected></option>
								<% for (int k=1; k<10; k++) { %>
									<option value="<%=k%>"><%=k%></option>
								<% } %>
								</select></td>
							<th>BKG OFC</th>
							<td><input type="text" class="input" style="width:60px;" caption="BKG OFC" name="bkg_ofc_cd" id="bkg_ofc_cd" maxlength="6" dataformat="engup"></td>
							<th>L/T</th>
							<td><select style="width:58px;" class="input" name="lt_div" id="lt_div">
									<option value="" selected>All</option>
									<option value="L">Local</option>
									<option value="T">T/S</option>
								</select></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="50" />
						<col />
						<col />
						<col />
						<col />
						<col width="119" />
					</colgroup>
					<tbody>
						<tr>
							<th>B/L No.</th>
							<td><input type="text" class="input" style="width:98px;" caption="BL NO"  name="bl_no" id="bl_no" maxlength="12" dataformat="engup"></td>
							<th>Customs Results</th>
							<td><select style="width:90px;" class="input" name="cstms_rslts" id="cstms_rslts">
									<option value="" selected></option>
									<option value="ALL_RSLT">All Result</option>
									<option value="SAS111">SAS111</option>
									<option value="SAS108">SAS108</option>
									<option value="SAMR">SAMR</option>
									<option value="SCMR">SCMR</option>
								</select>
							</td>
							<th>BKG Staff</th>
							<td><input type="text" class="input" style="width:99px;" caption="BKG Staff" name="doc_usr_id"  id="doc_usr_id" maxlength="20" dataformat="engup"></td>
						</tr>
						<tr>
							<th colspan="6" height="20" style="text-align:left; vertical-align:bottom; color:#3333aa">※ All dates are in POL local time.</th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="layout_flex_flex" style="padding-left:605px">
			<div class="opus_design_gird" style="margin-top:5px">
				<script type="text/javascript">ComSheetObject("sheet1");</script>
			</div>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject("sheet2");</script>
	</div>
	<div class="opus_design_inquiry wFit">
		<table style="width:600px">
			<colgroup>
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
			<tbody>
				<tr>
					<th>Transmission Status</th>
					<th>:</th>
					<th>Total B/L</th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_ttl_bl"></td>
					<th>=</th>
					<th>Success B/L</th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_snt_scc_bl" readonly></td>
					<th>+</th>
					<th style="color:red;">Error B/L</th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_snt_err_bl" readonly></td>
					<th>+</th>
					<th style="color:red;">Missing B/L</span></th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_miss_bl" readonly></td>
					<th style="color:red;">* NYK' Error B/L</th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_com_err_bl" readonly></td>
				</tr>
				<tr>
					<th>JP customs enforcement</th>
					<th>:</th>
					<th style="color:red">DNL</th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_dnl" name="disp_dnl" readonly></td>
					<td></td>
					<th style="color:red">DNU</th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_dnu" name="disp_dnu" readonly></td>
					<td></td>
					<th style="color:red">SPD</th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_spd" name="disp_spd" readonly></td>
					<td></td>
					<th style="color:red">HLD</th>
					<td><input type="text" class="input2" style="width:50px; text-align:right;" id="disp_hld" name="disp_hld" readonly></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</form>