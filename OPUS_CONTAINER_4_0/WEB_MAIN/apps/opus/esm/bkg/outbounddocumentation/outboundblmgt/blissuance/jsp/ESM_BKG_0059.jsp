<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0059.jsp
*@FileTitle  : Cancel Issue Release
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0059Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0059Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0059Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
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
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>" id="strUsr_id" />
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>" id="strOfc_cd" />
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" id="bkg_no" />
<input type="hidden" name="bl_no" value="<%=JSPUtil.getParameter(request, "bl_no")%>" id="bl_no" />
<input type="hidden" name="bl_iss_tp_cd" value="<%=JSPUtil.getParameter(request, "bl_iss_tp_cd")%>" id="bl_iss_tp_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Documentation Requirement</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit" >
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>				            
					<col width="50">
					<col width="40">
					<col width="100">
					<col width="80">
					<col width="120">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>B/L Type</th>
						<td></td>
						<td><input type="radio" value="W" name="bl_tp_cd" id='bl_tp_cd1' class="trans"> Sea Waybill</td>
						<td> <input type="radio" value="O" name="bl_tp_cd" id='bl_tp_cd2' class="trans"> O.B/L</td>
						<td> <input type="radio" value="S" name="bl_tp_cd" id='bl_tp_cd3' class="trans"> Surrender</td>
						<td><input type="hidden" name="frm_sheet1_rqst_bl_tp_cd" id="frm_sheet1_rqst_bl_tp_cd"></td>
					</tr>
				</tbody>
			</table>
	</div>
	<div class="opus_design_data">
			
			<table>
				<colgroup>				            
					<col width="250">
					<col width=100>
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td><h3 class="title_design">No. of Document to Print</h3></td>
						<td></td>
						<td><button type="button" class="btn_etc"  name="btn_pre_set" id="btn_pre_set">Pre Set</button></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<table  class="grid2">
				<colgroup>				            
					<col width="120">
					<col width="90">
					<col width="90">
					<col width="90">
					<col width="90">
					<col width="90">
				</colgroup>
				<tbody>
						<tr>
							<th></th>
							<th>Rated</th>
							<th>Unrated</th>
							<th>Prepaid</th>
							<th>Collect</th>
							<th>Total</th>
						</tr>
						<tr>
							<th>Original B/L</th>
							<td><input type="text" style="width: 100%;" class="input" maxlength="5" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_obl_rt_incl_knt" id="frm_sheet1_obl_rt_incl_knt"></td>
							<td><input type="text" style="width: 100%;" class="input" maxlength="5" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_obl_rt_xcld_knt" id="frm_sheet1_obl_rt_xcld_knt"></td>
							<td><input type="text" style="width: 100%;" class="input" maxlength="5" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_obl_ppd_knt" id="frm_sheet1_obl_ppd_knt"></td>
							<td><input type="text" style="width: 100%;" class="input" maxlength="5" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_obl_clt_knt" id="frm_sheet1_obl_clt_knt"></td>
							<td><input type="text" style="width: 100%;" class="input" value="" name="frm_sheet1_obl_ttl_knt" id="frm_sheet1_obl_ttl_knt" readonly></td>
						</tr>
						<tr>
							<th>N/N Copy</th>
							<td><input type="text" style="width: 100%;" class="input" maxlength="5" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_non_nego_rt_incl_knt" id="frm_sheet1_non_nego_rt_incl_knt"></td>
							<td><input type="text" style="width: 100%;" class="input" maxlength="5" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_non_nego_rt_xcld_knt" id="frm_sheet1_non_nego_rt_xcld_knt"></td>
							<td><input type="text" style="width: 100%;" class="input" maxlength="5" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_non_nego_ppd_knt" id="frm_sheet1_non_nego_ppd_knt"></td>
							<td><input type="text" style="width: 100%;" class="input" maxlength="5" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_non_nego_clt_knt" id="frm_sheet1_non_nego_clt_knt"></td>
							<td><input type="text" style="width: 100%;" class="input" value="" name="frm_sheet1_cpy_ttl_knt" id="frm_sheet1_cpy_ttl_knt" readonly></td>
						</tr>
				</tbody>
			</table>
			<table>
				<colgroup>				            
					<col width="80">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Issue Place</th>
						<td>
							<input type="text" style="width: 165px;margin-bottom:5px" class="input" value="" dataformat="engup" style="ime-mode:disabled" name="frm_sheet1_rqst_iss_plc_nm" id="frm_sheet1_rqst_iss_plc_nm"><!-- 
							 --><input type="text" style="width: 160px;margin-bottom:5px" class="input2" value="" name="frm_sheet1_loc_nm" id="frm_sheet1_loc_nm" readonly>
						</td>
					</tr>
					<tr>
						<th>Issue Date</th>
						<td><input type="text" style="width: 165px;margin-bottom:5px" class="input" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="" name="frm_sheet1_rqst_iss_dt" id="frm_sheet1_rqst_iss_dt"></td>
					</tr>
				</tbody>
			</table>
			<table style="margin-bottom:10px">
				<colgroup>				            
					<col width="80">
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Deliver To</th>
						<td>
							<input type="radio" value="S" name="bl_de_to_cd" id="bl_de_to_cd1" class="trans">Shipper
						</td>
						<td>
							<input type="radio" value="F" name="bl_de_to_cd" id="bl_de_to_cd2" class="trans">FWDR
						</td>
						<td>
							<input type="hidden" name="frm_sheet1_bl_de_to_cd" id="frm_sheet1_bl_de_to_cd" style="margin-bottom:5px">
						</td>
					</tr>
				</tbody>
			</table>
			<table style="margin-bottom:10px">
				<colgroup>				            
					<col width="80">
					<col width="100">
					<col width="90">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Method</th>
						<td>
							<input type="radio" value="E" name="bl_de_mzd_cd" id="bl_de_mzd_cd1" class="trans">Express Mail
						</td>
						<td>
							<input type="radio" value="R" name="bl_de_mzd_cd" id="bl_de_mzd_cd2" class="trans">Regular Mail
						</td>
						<td>
							<input type="radio" value="P" name="bl_de_mzd_cd" id="bl_de_mzd_cd3" class="trans">Pick Up
						</td>
						<td>
							<input type="hidden" name="frm_sheet1_bl_de_mzd_cd" id="frm_sheet1_bl_de_mzd_cd">
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>				            
					<col width="70">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Remark(s)</th>
						<td><textarea rows="5" style="width: 99%;resize:none" name="frm_sheet1_bl_doc_rqst_rmk" id="frm_sheet1_bl_doc_rqst_rmk"></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>