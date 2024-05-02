<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_bkg_1087.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1087Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1087Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

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
		event = (EsmBkg1087Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bl_no" value="<%=JSPUtil.getParameter(request, request.getParameter("bl_no"))%>" id="bl_no" />
<input type="hidden" name="pod_cd" value="<%=JSPUtil.getParameter(request, request.getParameter("pod_cd"))%>" id="pod_cd" />
<input type="hidden" name="tabIndex" value="<%=JSPUtil.getParameter(request, request.getParameter("tabIndex"))%>" id="tabIndex" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span id="title"></span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->

	<!-- tabLayer1 (S) -->
	<div  id="tabLayer"  style="display:inline;">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="40" />
					<col width="105" />
					<col width="30" />
					<col width="70" />
					<col width="30" />
					<col width="80" />
					<col width="30" />
					<col width="60" />
					<col width="30" />
					<col width="60" />
					<col width="30" />
					<col width="60" />
					<col width="30" />
					<col width="80" />
					<col width="*" />
			   </colgroup>
			   <tbody>
					<tr>
						<th>B/L No.</th>
						<td><input type="text" value="<%=JSPUtil.getParameter(request, request.getParameter("bl_no"))%>"  style="width:100px;" class="input2" readonly="readonly"></td>
						<th>Line</th>
						<td><input type="text" style="width:60px;ime-mode:disabled" class="input" name="bl_du_line_id" maxlength="6" dataformat="engup" caption="Line"></td>
						<th>Agent</th>
						<td><input type="text" style="width:70px;ime-mode:disabled" class="input" name="bl_du_voy_agn_id" maxlength="6" dataformat="engup" caption="Agent"></td>
						<th title="Place of Receipt">POR</th>
						<td><input type="text" name="bl_por_cd" style="width:55px;" class="input2" readonly="readonly" id="bl_por_cd" /> </td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" name="bl_pol_cd" style="width:55px;" class="input2" readonly="readonly" id="bl_pol_cd" /> </td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" value="<%=JSPUtil.getParameter(request, request.getParameter("pod_cd"))%>" name="bl_pod_cd" style="width:55px;" class="input2" readonly="readonly" id="bl_pod_cd" /> </td>
						<th title="Place of Delivery">DEL</th>
						<td><input type="text" name="bl_del_cd" style="width:60px;" class="input2" readonly="readonly" id="bl_del_cd" /> </td>
						<td></td>
					</tr>
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="70" />
					<col width="140" />
					<col width="80" />
					<col width="120" />
					<col width="80" />
					<col width="*" />
			   </colgroup>
			   <tbody>
					<tr>
						<th>Org. B/L No.</th>
						<td><input type="text" style="width:100px;ime-mode:disabled" class="input" name="bl_org_bl_no" id="bl_org_bl_no" maxlength="12" fullfill dataformat="engup" caption="Org. B/L No."></td>
						<th>Org. Voyage</th>
						<td><input type="text" style="width:100px;ime-mode:disabled" class="input" name="bl_org_vvd" id="bl_org_vvd" maxlength="9" fullfill dataformat="engup" caption="Org. Voyage"></td>
						<th>Org. Vsl Nm</th>
						<td><input type="text" style="width:150px;ime-mode:disabled" class="input" name="bl_vsl_nm" maxlength="50" dataformat="engup" caption="Org. Vsl Nm" id="bl_vsl_nm" /> </td>
					</tr>
			   </tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		</div>
		<!-- opus_design_inquiry(E) -->

		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
			<div class="layout_vertical_3 wAuto">
			   <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table class="wAuto">
						<colgroup>
							<col width="80" />
							<col width="*" />
					   </colgroup>
					   <tbody>
							<tr>
								<th>Manifest No.</th>
								<td><input type="text" style="width:150px;ime-mode:disabled" class="input" name="bl_du_mf_no" maxlength="8" dataformat="engup" caption="Manifest No." id="bl_du_mf_no" /> </td>
							</tr>
							<tr>
								<th>Cargo Code</th>
								<td><script type="text/javascript">ComComboObject('bl_du_cgo_cd', 2, 150, 1, 0, 1);</script></td>
							</tr>
							<tr>
								<th>Org. Country</th>
								<td><input type="text" style="width:150px;ime-mode:disabled" class="input" name="bl_org_cnt_cd" maxlength="2" dataformat="engup" caption="Org. Country" id="bl_org_cnt_cd" /> </td>
							</tr>
							<tr>
								<th>PKG Qty</th>
								<td><input type="text" style="width:150px;ime-mode:disabled;text-align:right" class="input" name="bl_pck_qty" maxlength="12" dataformat="num" caption="PKG Qty" id="bl_pck_qty" /> </td>
							</tr>
							<tr>
								<th>LCL CNTR</th>
								<td><input type="text" style="width:150px;ime-mode:disabled" class="input" name="bl_cntr_no" maxlength="14" dataformat="engup" caption="LCL CNTR" id="bl_cntr_no" /> </td>
							</tr>
							<tr>
								<th>Tare WGT</th>
								<td><input type="text" style="width:150px;ime-mode:disabled;text-align:right" class="input" name="bl_tare_wgt" maxlength="9" dataformat="float" caption="Tare WGT" id="bl_tare_wgt" /> </td>
							</tr>
							<tr>
								<th>No of Pallet</th>
								<td><input type="text" style="width:150px;ime-mode:disabled;text-align:right" class="input" name="bl_plt_qty" maxlength="6" dataformat="num" caption="No of Pallet" id="bl_plt_qty" /> </td>
							</tr>
							<tr><td colspan="6"><table class="height_5"><tr><td></td></tr></table></td></tr>
					   </tbody>
					</table>
				</div>
				<!-- opus_design_inquiry(E) -->
			</div>

			<div class="layout_vertical_3 wAuto">
				 <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table class="wAuto">
						<colgroup>
							<col width="120" />
							<col width="*" />
					   </colgroup>
					   <tbody>
							<tr>
								<th>Trade Code</th>
								<td><script type="text/javascript">ComComboObject('bl_du_trd_cd', 2, 150, 1, 0, 1);</script></td>
							</tr>
							<tr>
								<th>Console</th>
								<td><select name="bl_cnsl_cgo_flg" id="bl_cnsl_cgo_flg" style="width:150px">
									<option value="Y">Y</option><option value="N">N</option></select></td>
							</tr>
							<tr>
								<th>T/S Mode</th>
								<td><script type="text/javascript">ComComboObject('bl_du_ts_mod_cd', 2, 150, 1, 0, 1);</script></td>
							</tr>
							<tr>
								<th>PKG Type</th>
								<td><input type="text" style="width:150px;ime-mode:disabled" class="input" name="bl_du_pck_desc" maxlength="100" dataformat="engup" caption="PKG Type" id="bl_du_pck_desc" /> </td>
							</tr>
							<tr>
								<th>No of CNTR</th>
								<td><input type="text" style="width:150px;ime-mode:disabled;text-align:right" class="input" name="bl_cntr_knt" maxlength="5" dataformat="num" caption="No of CNTR" id="bl_cntr_knt" /> </td>
							</tr>
							<tr>
								<th>Cargo WGT</th>
								<td><input type="text" style="width:150px;ime-mode:disabled;text-align:right" class="input" name="bl_cgo_wgt" maxlength="18" dataformat="float" caption="Cargo WGT" id="bl_cgo_wgt" /> </td>
							</tr>
							<tr>
								<th>Total Qty</th>
								<td><input type="text" style="width:150px;ime-mode:disabled;text-align:right" class="input" name="bl_du_ttl_qty" maxlength="9" dataformat="num" caption="Total Qty" id="bl_du_ttl_qty" /> </td>
							</tr>
							<tr><td colspan="6"><table class="height_5"><tr><td></td></tr></table></td></tr>
					   </tbody>
					</table>
				</div>
				<!-- opus_design_inquiry(E) -->
			</div>

			<div class="layout_vertical_3 wAuto">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table>
						<colgroup>
							<col width="120" />
							<col width="*" />
					   </colgroup>
					   <tbody>
							<tr>
								<th>Svc Type</th>
								<td><script type="text/javascript">ComComboObject('bl_du_cntr_svc_tp_cd', 2, 100, 1, 0, 1);</script></td>
							</tr>
							<tr>
								<th>CMDT Code</th>
								<td><input type="text" style="width:100px;ime-mode:disabled" class="input" name="bl_du_cmdt_cd" maxlength="10" dataformat="engup" caption="CMDT Code" id="bl_du_cmdt_cd" /> </td>
							</tr>
							<tr>
								<th>PKG Type Code</th>
								<td><input type="text" style="width:100px;ime-mode:disabled" class="input" name="bl_du_pck_tp_cd" maxlength="3" dataformat="engup" caption="PKG Type Code" id="bl_du_pck_tp_cd" /> </td>
							</tr>
							<tr>
								<th>No of TEU(s)</th>
								<td><input type="text" style="width:100px;ime-mode:disabled;text-align:right" class="input" name="bl_bkg_teu_qty" maxlength="12" dataformat="float" caption="No of TEU(s)" id="bl_bkg_teu_qty" /> </td>
							</tr>
							<tr>
								<th>Gross WGT</th>
								<td><input type="text" style="width:100px;ime-mode:disabled;text-align:right" class="input" name="bl_grs_wgt" maxlength="18" dataformat="float" caption="Gross WGT" id="bl_grs_wgt" /> </td>
							</tr>
							<tr>
								<th>Freight TONE</th>
								<td><input type="text" style="width:100px;ime-mode:disabled;text-align:right" class="input" name="bl_du_frt_wgt" maxlength="9" dataformat="float" caption="Freight TONE" id="bl_du_frt_wgt" /> </td>
							</tr>
							<tr>
								<th>Messure</th>
								<td><input type="text" style="width:100px;ime-mode:disabled;text-align:right" class="input" name="bl_meas_qty" maxlength="12" dataformat="float" caption="Messure" id="bl_meas_qty" /> </td>
							</tr>
					   </tbody>
					</table>
				</div>
				<!-- opus_design_inquiry(E) -->
			</div>
		</div>
		<!-- layout_wrap(E) -->

		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
			<div class="layout_vertical_2 wAuto">
			   <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table class="grid_2 wAuto">
						<colgroup>
							<col width="360" />
					   </colgroup>
					   <tbody>
							<tr><th style="text-align:center;">Mark & Numbers</th></tr>
							<tr>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="6" name="bl_mk_no_ctnt" id="bl_mk_no_ctnt" maxlength="1000" dataformat="exceptengdn" caption="Mark & Numbers"></textarea></td>
							</tr>
					   </tbody>
					 </table>
				</div>
				<!-- opus_design_inquiry(E) -->
			</div>
			<div class="layout_vertical_2">
			   <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry pad_left_12">
					<table class="grid_2 wAuto">
						<colgroup>
							<col width="360" />
					   </colgroup>
					   <tbody>
							<tr><th style="text-align:center;">Desc</th></tr>
							<tr>
							<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="6" class="input" name="bl_cmdt_desc" id="bl_cmdt_desc" maxlength="100" dataformat="exceptengdn" caption="Desc"></textarea></td></tr>
					   </tbody>
					 </table>
				</div>
				<!-- opus_design_inquiry(E) -->
			</div>
		</div>
		<!-- layout_wrap(E) -->


	</div>
	<!-- tabLayer1 (E) -->

	<!-- tabLayer2 (S) -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="50" />
					<col width="*" />
			   </colgroup>
			   <tbody>
					<tr>
						<th>B/L No.</th>
						<td><input type="text" value="<%=JSPUtil.getParameter(request, request.getParameter("bl_no")) %>" style="width:100px;" class="input2" readonly="readonly"></td>
					</tr>
			   </tbody>
			 </table>
		</div>
		<!-- opus_design_inquiry(E) -->

		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
			<div class="layout_vertical_2 wAuto">
			   <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table class="wAuto">
						<colgroup>
							<col width="80" />
							<col width="340" />
					   </colgroup>
					   <tbody>
							<tr>
								<td><h3 class="title_design">Shipper</h3></td>
								<td align="right"><strong>Country Code</strong>&nbsp;<input name="bl_s_cust_cnt_cd"  id="bl_s_cust_cnt_cd" type="text" style="width:50px;" maxlength="2" dataformat="engup" caption="Shipper Country Code"></td>
							</tr>
					   </tbody>
					 </table>
					 <table class="grid_2 wAuto">
						<colgroup>
							<col width="80" />
							<col width="340" />
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:center;">Name</th>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_s_cust_nm" id="bl_s_cust_nm" maxlength="30" dataformat="exceptengdn" caption="Shipper Name"></textarea></td></tr>
							<tr>
								<th style="text-align:center;">Address</th>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_s_cust_addr" id="bl_s_cust_addr" maxlength="240" dataformat="exceptengdn" caption="Shipper Address"></textarea></td></tr>
						</tbody>
					</table>
				</div>
				<!-- opus_design_inquiry(E) -->
			</div>
			<div class="layout_vertical_2">
			   <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry pad_left_12">
					<table>
						<colgroup>
							<col width="70" />
							<col width="*" />
					   </colgroup>
					   <tbody>
							<tr>
								<td><h3 class="title_design">Org. Shipper</h3></td>
								<td></td>
							</tr>
					   </tbody>
					 </table>
					 <table class="grid_2 wAuto">
						<colgroup>
							<col width="80" />
							<col width="340" />
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:center;">Name</th>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_s_org_cust_nm" id="bl_s_org_cust_nm" maxlength="30" dataformat="exceptengdn" caption="Org. Shipper Name"></textarea></td>
							</tr>
							<tr>
								<th style="text-align:center;">Address</th>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_s_org_cust_addr" id="bl_s_org_cust_addr" maxlength="240" dataformat="exceptengdn" caption="Org. Shipper Address"></textarea>
							</td></tr>
						</tbody>
					</table>


				</div>
				<!-- opus_design_inquiry(E) -->
			</div>
		</div>
		<!-- layout_wrap(E) -->

		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
			<div class="layout_vertical_2 wAuto">
			   <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table>
						<colgroup>
							<col width="80" />
							<col width="340" />
					   </colgroup>
					   <tbody>
							<tr>
								<td><h3 class="title_design">Consignee</h3></td>
								<td align="right"><strong>Code</strong>&nbsp;<input name="bl_c_du_cust_id" id="bl_c_du_cust_id" type="text" style="width:100px;" maxlength="10" dataformat="exceptengdn" caption="Consignee Code"></td>
							</tr>
					   </tbody>
					 </table>
					 <table class="grid_2 wAuto">
						<colgroup>
							<col width="80" />
							<col width="340" />
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:center;">Name</th>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_c_cust_nm" id="bl_c_cust_nm" maxlength="48" dataformat="exceptengdn" caption="Consignee Name"></textarea></td>
							</tr>
							<tr>
								<th style="text-align:center;">Address</th>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_c_cust_addr" id="bl_c_cust_addr" maxlength="240" dataformat="exceptengdn" caption="Consignee Address"></textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- opus_design_inquiry(E) -->
			</div>
			<div class="layout_vertical_2">
			   <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry pad_left_12">
					<table>
						<colgroup>
							<col width="100" />
							<col width="320" />
					   </colgroup>
					   <tbody>
							<tr>
								<td><h3 class="title_design">Org. Consignee</h3></td>
								<td></td>
							</tr>
					   </tbody>
					 </table>
					 <table class="grid_2 wAuto">
						<colgroup>
							<col width="80" />
							<col width="340" />
						</colgroup>
						<tbody>
							<tr>
								<th style="text-align:center;">Name</th>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_c_org_cust_nm" id="bl_c_org_cust_nm" maxlength="30" dataformat="exceptengdn" caption="Org. Consignee Name"></textarea></td>
							</tr>
							<tr>
								<th style="text-align:center;">Address</th>
								<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_c_org_cust_addr" id="bl_c_org_cust_addr" maxlength="240" dataformat="exceptengdn" caption="Org. Consignee Address"></textarea></td>
							</tr>
						</tbody>
					</table>


				</div>
				<!-- opus_design_inquiry(E) -->
			</div>
		</div>
		<!-- layout_wrap(E) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="70" />
					<col width="*" />
			   </colgroup>
			   <tbody>
					<tr>
						<td><h3 class="title_design">Notify</h3></td>
						<td></td>
					</tr>
			   </tbody>
			 </table>
			 <table class="grid_2 wAuto">
				<colgroup>
					<col width="80" />
					<col width="340" />
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:center;">Name</th>
						<td><textarea style="width:100%;ime-mode:disabled; resize:none;" rows="3" name="bl_n_cust_nm" id="bl_n_cust_nm" maxlength="48" dataformat="exceptengdn" caption="Notify Name"></textarea></td></tr>
					<tr>
						<th style="text-align:center;">Address</th>
						<td><textarea style="width:100%;ime-mode:disabled;resize:none;" rows="3" name="bl_n_cust_addr" id="bl_n_cust_addr" maxlength="240" dataformat="exceptengdn" caption="Notify Address"></textarea></td></tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- tabLayer2 (E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
