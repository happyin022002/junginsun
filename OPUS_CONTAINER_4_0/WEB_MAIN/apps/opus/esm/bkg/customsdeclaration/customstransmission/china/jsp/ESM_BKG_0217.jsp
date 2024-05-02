<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0217.jsp
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/09
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg0217Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0217Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String mainPage = "";
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strCnt_cd   = "";
	String strOfc_cd   = "";

	String strPgmNo     = "";
	String strBlNo      = "";
	String strTransMode = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.Customstransmission");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOfc_cd = account.getOfc_cd();

		mainPage = request.getParameter("mainPage");
		event = (EsmBkg0217Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBlNo = JSPUtil.getNull(request.getParameter("bl_no"));
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
		strTransMode = event.getTransMode();
		strTransMode = strTransMode == null ? JSPUtil.getNull(request.getParameter("trans_mode")) : strTransMode;
		codeList = HttpUtil.makeXML(request,response);

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="trans_mode" value="<%=strTransMode%>" id="trans_mode" />
<input type="hidden" name="bl_mk_desc" id="bl_mk_desc" />
<input type="hidden" name="vvd" id="vvd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="bkg_pol_cd" id="bkg_pol_cd" />
<input type="hidden" name="bkg_pod_cd" id="bkg_pod_cd" />
<input type="hidden" name="chn_mf_snd_ind_cd" id="chn_mf_snd_ind_cd" />
<input type="hidden" name="code_list" value="<%=codeList%>" id="code_list" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Transmit" id="btn_Transmit" type="button">Transmit Manifest</button><!--
		--><% if( "D".equals(strTransMode)) { %>
				<script type="text/javascript">ComComboObject('msg_type', 1, 155, 1, 1);</script>
			<% }else{ %>
				<script type="text/javascript">ComComboObject('msg_type', 1, 120, 1, 1);</script>
			<% } %><!--
			--><button class="btn_normal" name="btn_Mark" id="btn_Mark" type="button">Remark(s)</button><!--
			--><%if(!"true".equals(mainPage)){ %><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
			<% } %>
		</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table style="width:900px">
			<colgroup>
				<col width="50" />
				<col width="150" />
				<col width="80" />
				<col width="202" />
				<col width="75" />
				<col width="*" />
		   </colgroup>
		   <tbody>
				<tr>
					<th>B/L No.</th>
					<td><input type="text" name="bl_no" id="bl_no" style="width:110px; ime-mode: disabled;" class="<%="".equals(strBlNo) ? "input1" : "input2"%>" value="<%=strBlNo%>" dataformat="engup" maxlength="12" <%="".equals(strBlNo) ? "required" : "readOnly"%> caption="B/L No."></td>
					<th>BKG No.</th>
					<td><input type="text" name="bkg_no" id="bkg_no" style="width:110px;" class="input2" <%=!"".equals(strBlNo) ? "readOnly" : ""%>  dataformat="engup" maxlength="13" caption="BKG No."></td>
					<th>MSG STS</th>
					<td><input type="text" name="trsm_msg_tp_id" id="trsm_msg_tp_id" style="width:100px;" class="input2" readOnly><!--
								  --><input type="text" name="mf_snd_dt" id="mf_snd_dt" style="width:150px;" class="input2" readOnly></td>
				</tr>
			</tbody>
		</table>

		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

		<table style="width:900px">
			<colgroup>
				<col width="55" />
				<col width="150" />
				<col width="55" />
				<col width="150" />
				<col width="75" />
				<col width="*" />
		   </colgroup>
		   <tbody>
				<tr>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" name="por_cd" style="width:60px;" class="input" maxlength="5" id="por_cd" dataformat="engup" /> </td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vsl_nm" style="width:180px;" class="input2" readOnly id="vsl_nm" /> </td>
					<th>On Board Date</th>
					<td><input type="text" name="bl_obrd_dt" style="width:80px;" class="input2" readOnly id="bl_obrd_dt" /> </td>
					<th>B/L Issue Date</th>
					<td><input type="text" name="bl_iss_dt" style="width:80px;" class="input" id="bl_iss_dt" /> </td>
				</tr>
				<tr>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" style="width:60px;" class="input" maxlength="5" id="pol_cd" dataformat="engup"/> </td>
					<th>Trans Port</th>
					<td><input type="text" name="port_cd" style="width:60px;" class="input2" readOnly id="port_cd" dataformat="engup"/> </td>
					<th>R/D Term</th>
					<td><input type="text" name="rcv_term_cd" style="width:25px;" class="input2" readOnly id="rcv_term_cd" />/ <input type="text" name="de_term_cd" style="width:25px;" class="input2" readOnly id="de_term_cd" /></td>
					<th>Trans IND</th>
					<td><script type="text/javascript">ComComboObject('trsp_mod_id', 1, 158, 1, 0);</script></td>
					<td style="display:none;"></div><script type="text/javascript">ComComboObject('seal_pty_tp_cd', 1, 0, 1, 0);</script></td>
				</tr>
				<tr>
					<th>V.POD</th>
					<td><input type="text" name="vvd_pod_cd" style="width:60px;" class="input2" maxlength="5" readOnly id="vvd_pod_cd" dataformat="engup"/> </td>
					<th>Freight</th>
					<td><input type="text" name="frt_term_cd" style="width:30px;" class="input2" readOnly id="frt_term_cd" /> </td>
					<th>Temp.</th>
					<td><input type="text" name="temp" style="width:86px;text-align:right;" class="input" dataformat="float" maxlength="9" id="temp" /><input type="text" name="temp_unit" style="width:25px;" class="input2" readOnly id="temp_unit" /></td>
					<td></td>
					<td style="display:none;"><input type="text" name="bkg_cgo_tp_cd" style="width:60px;" class="input2" maxlength="5" readOnly id="bkg_cgo_tp_cd" /> </td>
				</tr>
				<tr>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" style="width:60px;" class="input" maxlength="5" id="pod_cd" dataformat="engup"/> </td>
					<th>Package</th>
					<td><input type="text" name="pck_qty" style="width:105px; text-align:right;" class="input" dataformat="float" maxlength="15" caption="Package" id="pck_qty" /><input type="text" name="pck_tp_cd" style="width:35px;" class="input" id="pck_tp_cd" /></td>
					<th>Weight</th>
					<td><input type="text" name="act_wgt" style="width:155px; text-align:right;" class="input" dataformat="float" maxlength="23" caption="Weight" id="act_wgt" /><!--
									 --><script type="text/javascript">ComComboObject('wgt_ut_cd', 1, 55, 1, 0);</script></td>
					<th>Measure</th>
					<td><input type="text" name="meas_qty" style="width:100px; text-align:right;" class="input" dataformat="float" maxlength="15" caption="Measure" id="meas_qty" /><!--
								  --><script type="text/javascript">ComComboObject('meas_ut_cd', 1, 55, 1, 0);</script></td>
				</tr>
				<tr>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="del_cd" style="width:60px;" class="input" maxlength="5" id="del_cd" dataformat="engup"/> </td>
					<th>Cargo Desc.</th>
					<td  colspan="5"><input type="text" name="cstms_desc" style="width:380px;" class="input" id="cstms_desc" dataformat="engup"/> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" style="display:inline">
		 <div class="opus_design_grid">
		 <div class="opus_design_btn">
		<button class="btn_normal" name="btn_RowAdd" id="btn_RowAdd" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_RowDel" id="btn_RowDel" type="button">Row Delete</button><!--
		--></div>
		<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
			<table class="grid_2">
			<colgroup>
			  <col width="190" />
			  <col width="*" />
			</colgroup>
			<tr>
				<th>Shipper Name</th>
				<td><input type="text" name="shpr_nm" style="width:100%;" class="noinput"></td>
			</tr>
			<tr>
				<th>Shipper Address</th>
				<td><input type="text" name="shpr_addr" style="width:100%;" class="noinput"></td>
			</tr>
			<tr>
				<th>Consignee Name</th>
				<td><input type="text" name="cnee_nm" style="width:100%;" class="noinput"></td>
			</tr>
			<tr>
				<th>Consignee Address</th>
				<td><input type="text" name="cnee_addr" style="width:100%;" class="noinput"></td>
			</tr>
			<tr>
				<th>Notify Name</th>
				<td><input type="text" name="ntfy_nm" style="width:100%;" class="noinput"></td>
			</tr>
			<tr>
				<th>Notify Address</th>
				<td><input type="text" name="ntfy_addr" style="width:100%;" class="noinput"></td>
			</tr>
			</table>
		   <div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		   </div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid">
		 <div class="opus_design_btn">
			<button class="btn_normal" name="btn_RowAdd_3" id="btn_RowAdd_3" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_RowDel_3" id="btn_RowDel_3" type="button">Row Delete</button><!--
		--></div>
		<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
	</div>
</div>
</form>