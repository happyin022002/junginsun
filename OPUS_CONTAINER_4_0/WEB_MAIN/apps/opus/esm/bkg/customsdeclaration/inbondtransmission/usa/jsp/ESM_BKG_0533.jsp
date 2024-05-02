<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :
*@FileTitle  :
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0533Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0533Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0533Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch (Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
<input type="hidden" name="bl_cntr_gubun" value="Cntr" id="bl_cntr_gubun" />
<input type="hidden" name="page_no" value="ESM_BKG_0533" id="page_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_TransAN" id="btn_TransAN">Transmit Arrival</button><!--
		 --><button type="button" class="btn_normal" name="btn_TransExp" id="btn_TransExp">Transmit Export</button>
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
	<div class="opus_design_inquiry wFit">
		<table align="left" style="width:400px;">
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
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 80px;ime-mode:disabled;" class="input" name="vvd" dataformat="engup" maxlength="9" fullfill caption="VVD" id="vvd"/></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod" maxlength="5" style="width:50px;ime-mode:disabled;" class="input" dataformat="engup" caption="POD" fullfill id="pod" /></td>
					<th>Hub</th>
					<td><input type="text" name="hub" style="width:50px;ime-mode:disabled;" class="input" dataformat="engup" id="hub" /></td>
					<th>Container No.</th>
					<td><input type="text" name="cntr_no" style="width:115px; ime-mode:disabled" class="input" maxlength="14" dataformat="engup" id="cntr_no" /></td>
					<th>B/L No.</th>
					<td><input type="text" name="bl_no" style="width:90px; ime-mode:disabled" class="input" maxlength="12" dataformat="engup" id="bl_no" /></td>
					<td>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<th>MIB Type</th>
					<td><select name="ibd_tp_cd" id="ibd_tp_cd" style="width:70px;" class="input1">
							<option value="All" selected>All</option>
							<option value="61">61</option>
							<option value="62">62</option>
							<option value="63">63</option>
							<option value="612">61&62</option>
							<option value="623">62&63</option>
						</select></td>
					<th>Arrival</th>
					<td><select name="arr_dt" id="arr_dt" style="width:50px;" class="input1">
							<option value="" selected>All</option>
							<option value="Y">Yes</option>
							<option value="N">No</option>
						</select></td>
					<th>Export</th>
					<td><select name="xpt_dt" id="xpt_dt" style="width:50px;" class="input1">
							<option value="" selected>All</option>
							<option value="Y">Yes</option>
							<option value="N">No</option>
						</select></td>
					<td colspan="4"><table style="width:200px;">
							<tr>
								<th>Customs Response</th>
								<td><select name="edi_error" style="width:60;" class="input1">
										<option value="" selected>All</option>
										<option value="NA">No Arrival</option>
										<option value="NE">No Export</option>
									</select></td>
							</tr>
						</table></td>
					<td>&nbsp;&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<table style="width:400px;">
			<colgroup>
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th class="sm"><input type="checkbox" name="arr_gubun" class="trans" id="arr_gubun" value="1" />&nbsp;&nbsp;Arrival Date</th>
					<td class="sm"><input type="text" style="width: 70px; ime-mode:disabled" class="input2" dataformat="ymd" name="fromd" caption="Arrival Date From" cofield="tod" maxlength="10" readonly="true" id="fromd" /><!--
						--><input type="text" name="fromt" style="width:40px;" value="00:00" class="input2" dataformat="hm" caption="Arrival Date From" maxlength="5" readonly="true" id="fromt" /><!--
						-->~ <input type="text" style="width: 70px; ime-mode:disabled" class="input2" dataformat="ymd" name="tod" caption="Arrival Date To" cofield="fromd" maxlength="10" readonly="true" id="tod" /><!--
						--><input type="text" name="tot" style="width:40px;" value="23:59" class="input2" dataformat="hm" caption="Arrival Date To" maxlength="5" readonly="true" id="tot" /><!--
						--><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
				</tr>
				<tr>
					<th class="sm">EQ Office</th>
					<td class="sm"><input type="text" name="eq_ofc" style="width:70px; ime-mode:disabled" class="input2" maxlength="5" dataformat="engup" readonly="true" id="eq_ofc" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer" style="display:inline">
		<div class="opus_design_btn">
			<table>
				<tr>
					<td><input type="text" style="width:80px; ime-mode:disabled" name="set_arr_d" class="input1 mar_btm_4" dataformat="ymd" maxlength="10" id="set_arr_d" /><input type="text" style="width:40px;" name="set_arr_t" class="input1 mar_btm_4" maxlength="5" dataformat="hm" id="set_arr_t" /></td>
					<td><button type="button" class="btn_accent" name="btn_t1SetArrivalDate" id="btn_t1SetArrivalDate">Set Arrival Date</button><!--
						--><button type="button" class="btn_normal" name="btn_t1SetExportDate" id="btn_t1SetExportDate">Set Export Date</button>
					</td>
				</tr>
			</table>

		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">
		<div class="opus_design_btn">
			<table>
				<tr>
					<td><input type="text" style="width:80px;ime-mode:disabled" name="set_arr_d" class="input1 mar_btm_4" dataformat="ymd" maxlength="10" id="set_arr_d" /><input type="text" style="width:40px;" name="set_arr_t" class="input1 mar_btm_4" maxlength="5" dataformat="hm" id="set_arr_t" /></td>
					<td><button type="button" class="btn_accent" name="btn_t2SetArrivalDate" id="btn_t2SetArrivalDate">Set Arrival Date</button><!--
						--><button type="button" class="btn_normal" name="btn_t2SetExportDate" id="btn_t2SetExportDate">Set Export Date</button>
					</td>
				</tr>
			</table>

		</div>
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

</div>
</form>