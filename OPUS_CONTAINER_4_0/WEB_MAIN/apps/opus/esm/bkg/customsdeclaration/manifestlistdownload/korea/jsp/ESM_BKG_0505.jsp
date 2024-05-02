<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0505.jsp
*@FileTitle  : B/L Inquiry(Add & Edit B/L) Customer Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<script  type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<%
	// IN-Bound, OUT-Bound 구분 ( I / O )
	String ioBndCd = JSPUtil.getParameter(request, "io_bnd_cd");
	String vvd     = JSPUtil.getParameter(request, "vvd");
	String portCd  = JSPUtil.getParameter(request, "port_cd");
	String mrnNo   = JSPUtil.getParameter(request, "mrn_no");
	String blNo    = JSPUtil.getParameter(request, "bl_no");
	String cstmsDeclTpCd = JSPUtil.getParameter(request, "cstms_decl_tp_cd");
	String podTmlCd = JSPUtil.getParameter(request, "pod_tml_cd");
	String cgoSpecClear = JSPUtil.getParameter(request, "cgo_spec_clear");
	String mode    = JSPUtil.getParameter(request, "mode");

	if (ioBndCd==null) ioBndCd = "I";
	if (vvd==null) 	   vvd     = "";
	if (portCd==null)  portCd  = "";
	if (mrnNo==null)   mrnNo   = "";
	if (blNo==null)    blNo    = "";
	if (cstmsDeclTpCd==null)    cstmsDeclTpCd    = "";
	if (podTmlCd==null) podTmlCd = "";
	if (cgoSpecClear==null) cgoSpecClear = "";
	if (mode==null)    mode    = "ADD";
%>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>" id="io_bnd_cd" />
<input type="hidden" name="vvd_1" value="<%=vvd%>" id="vvd_1" />
<input type="hidden" name="port_cd" value="<%=portCd%>" id="port_cd" />
<input type="hidden" name="mrn_no" value="<%=mrnNo%>" id="mrn_no" />
<input type="hidden" name="mode" value="<%=mode%>" id="mode" />
<input type="hidden" name="cstms_decl_tp_cd" value="<%=cstmsDeclTpCd%>" id="cstms_decl_tp_cd" />
<input type="hidden" name="old_cstms_decl_tp_cd" id="old_cstms_decl_tp_cd" />
<input type="hidden" name="bkg_cgo_tp_cd" id="bkg_cgo_tp_cd" />
<input type="hidden" name="cgo_trsp_cd" id="cgo_trsp_cd" />
<input type="hidden" name="pck_tp_cd" id="pck_tp_cd" />
<input type="hidden" name="kr_cstms_wh_tp_cd" id="kr_cstms_wh_tp_cd" />
<input type="hidden" name="cmdt_cd" id="cmdt_cd" />
<input type="hidden" name="biz_rgst_no" id="biz_rgst_no" />
<input type="hidden" name="trns_seq" id="trns_seq" />
<input type="hidden" name="cgo_spec_clear" value="<%=cgoSpecClear%>" id="cgo_spec_clear" />
<input type="hidden" name="pod_tml_cd" value="<%=podTmlCd%>" id="pod_tml_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>B/L Inquiry(Add &amp; Edit B/L) Customer Info</span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_BLBKGNoASSGN" id="btn_BLBKGNoASSGN">B/L &amp; BKG No. Assign</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"> Service Management > Booking/Documentation > Manifest > Korea > B/L Inquiry Customer Info</span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col width="80px"/>
				<col />
				<col width="80px"/>
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>B/L No.</th>
					<td><input type="text" class="input1" style="width:105px;" name="bl_no" dataformat="engup" value="<%=blNo%>" maxlength="12" id="bl_no" /></td>
					<th>Trans.</th>
					<td colspan="9"><script type="text/javascript">ComComboObject('cboTrans', 1, 105, 1, 1);</script></td>
				</tr>
				<tr class="line_bluedot"><td colspan="12"></td></tr>
				<tr>
					<th>BKG No.</th>
					<td><input type="text" class="input" style="width:105px;" name="bkg_no" maxlength="13" dataformat="engup" id="bkg_no" /></td>
					<th>Cargo Type</th>
					<td colspan="2" style="padding-right:0px;">
						<table>
							<tr>
								<td><script type="text/javascript">ComComboObject("cboCargoType", 2, 130, 1,0,1);</script></td>
								<th>Cargo Specific</th>
							</tr>
						</table>
					</td>
					<td colspan="7"><script type="text/javascript">ComComboObject("cboCargoSpec", 1, 300, 1);</script></td>
				</tr>
				<tr>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" class="input" style="width:60px;" maxlength="5" dataformat="engup" name="por_cd" id="por_cd" /></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" class="input" style="width:80px;" maxlength="9" dataformat="engup" name="vvd" value="<%=vvd%>" id="vvd" /></td>
					<th>MSN</th>
					<td><input type="text" class="input" style="width:40px;" maxlength="4" dataformat="num" name="msn_no" id="msn_no" /></td>
					<th>B/L Type</th>
					<td><%=JSPUtil.getCodeCombo("kr_cstms_bl_tp_cd", "", "style='width:101'", "CD01535", 0, "")%></td>
					<th>F/Forwarder Code</th>
					<td colspan="3"><input type="text" class="input" style="width:148px;" name="fldr_cd" id="fldr_cd" /></td>
				</tr>
				<tr>
					<th title="Port of Loading">POL</th>
					<td><input type="text" class="input" style="width:60px;" maxlength="5" dataformat="engup" name="pol_cd" id="pol_cd" /></td>
					<th>Package</th>
					<td><input type="text" class="input" style="width:60; text-align:right;" dataformat="int" name="pck_qty" value="0"><script type="text/javascript">ComComboObject('cboPackage', 2, 50, 1);</script></td>
					<th>Weight</th>
					<td><input type="text" class="input" style="width:60px; text-align:right;" dataformat="float" name="cntr_ttl_wgt" value="0.0" id="cntr_ttl_wgt" /><%=JSPUtil.getCodeCombo("wgt_ut_cd", "", "style='width:50'", "CD00775", 0, "")%></td>
					<th>Measure</th>
					<td><input type="text" class="input" style="width:60px; text-align:right;" dataformat="float" name="meas_qty" value="0.000" id="meas_qty" /><%=JSPUtil.getCodeCombo("bl_meas_ut_cd", "", "style='width:60;'", "CD01116", 0, "")%></td>
					<th>Customs Code</th>
					<td colspan="3"><input type="text" class="input" style="width:50px; text-align:center;" dataformat="num" maxlength="3" name="tax_code1" value="000" id="tax_code1" /><input type="text" class="input" style="width:50px; text-align:center;" dataformat="num" maxlength="2" name="tax_code2" value="00" id="tax_code2" /></td>
				</tr>
				<tr>
					<th title="Port of Discharging">POD</th>
					<td colspan="2" style="padding-right:0px;">
						<table>
							<tr>
								<td><input type="text" class="input" style="width:60px;" maxlength="5" dataformat="engup" name="pod_cd" id="pod_cd" /></td>
								<th>Bond Area Code</th>
							</tr>
						</table>
					</td>
					<td colspan="2" style="padding-right:0px;">
						<table>
							<tr>
								<td><input type="text" class="input" style="width:82px;" maxlength="10" dataformat="engup" name="bd_area_cd" id="bd_area_cd" /></td>
								<th>Warehouse Info.</th>
							</tr>
						</table>
					</td>
					<td colspan="3"><script type="text/javascript">ComComboObject('cboWarehouse', 2, 40, 1);</script><input type="text" class="input" style="width:90; " dataformat="eng" name="kr_wh_cd"></td>
					<th>IMDG Code</th>
					<td colspan="3"><input type="text" class="input" style="width:50px;" maxlength="3" dataformat="engup" name="imdg_clss_cd" id="imdg_clss_cd" /><input type="text" class="input" style="width:50px;" maxlength="3" dataformat="eng" name="n2nd_imdg_clss_cd" id="n2nd_imdg_clss_cd" /><input type="text" class="input" style="width:50px;" maxlength="3" dataformat="engup" name="n3rd_imdg_clss_cd" id="n3rd_imdg_clss_cd" /></td>
				</tr>
				 <tr>
					<th title="Place of Delivery">DEL</th>
					<td colspan="2" style="padding-right:0px;">
						<table>
							<tr>
								<td><input type="text" class="input" style="width:60px;" maxlength="5" dataformat="engup" name="del_cd" id="del_cd" /></td>
								<th>Commodity Code(KR)</th>
							</tr>
						</table>
					</td>
					<td colspan="2" style="padding-right:0px;">
						<table>
							<tr>
								<td><script type="text/javascript">ComComboObject('cboGoods', 2, 70, 1,0,1);</script></td>
								<th>Unit of Measurement</th>
							</tr>
						</table>
					</td>
					<td colspan="2" style="padding-right:0px;">
						<table>
							<tr>
								<td><%=JSPUtil.getCodeCombo("kr_meas_ut_cd", "", "style='width:60px;'", "CD02251", 0, "")%></td>
								<th>Business Reg. No.</th>
							</tr>
						</table>
					</td>
					<td><script type="text/javascript">ComComboObject('cboBizNo', 2, 110, 0, 0, 0, true);</script></td>
					<th>Bulk WGT</th>
					<td><input type="text" class="input" style="width:80px; text-align:right;" maxlength="21" dataformat="float" name="bb_cgo_wgt" value="0.00" id="bb_cgo_wgt" /></td>
					<th>Bulk MEA</th>
					<td><input type="text" class="input" style="width:80px; text-align:right;" maxlength="21" dataformat="float" name="bb_cgo_meas_qty" value="0.000" id="bb_cgo_meas_qty" /></td>
				 </tr>
				 <tr>
					<th>Cargo Desc.1</th>
					<td colspan="11"><input type="text" class="input" style="width:100%;" dataformat="engup" name="cgo_desc1" id="cgo_desc1" otherchar=" " /></td>
				 </tr>
				<tr>
					<th>Cargo Desc.2</th>
					<td colspan="11"><textarea style="width:100%; height:50px;resize:none;" name="cgo_desc2" id="cgo_desc2" dataformat="engupspace"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject("tab1")</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t1RowAdd" id="btn_t1RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_t1Delete" 	id="btn_t1Delete">Row Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_t1LoadExcel" 	id="btn_t1LoadExcel">Load Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>

	<div id="tabLayer" style="display:none">
		<div class= "opus_design_inquiry">

			<table class="grid_2">
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
				<tr>
					<td><b>Shipper Name</b></td>
					<td><input type="text" style="width:100%;" class="input" name="s_cust_nm" dataformat="engup" id="s_cust_nm" otherchar=" &amp;-,." /></td>
				</tr>
				<tr>
					<td><b>Shipper Address</b></td>
					<td><input type="text" style="width:100%;" class="input" name="s_cust_addr" dataformat="engup" id="s_cust_addr" otherchar=" &amp;-,." /></td>
				</tr>
				<tr>
					<td><b>Consignee Name</b></td>
					<td><input type="text" style="width:100%;" class="input" name="c_cust_nm" dataformat="engup" id="c_cust_nm" otherchar=" &amp;-,." /></td>
				</tr>
				<tr>
					<td><b>Consignee Address</b></td>
					<td><input type="text" style="width:100%;" class="input" name="c_cust_addr" dataformat="engup" id="c_cust_addr" otherchar=" &amp;-,." /></td>
				</tr>
				<tr>
					<td><b>Notify Name</b></td>
					<td><input type="text" style="width:100%;" class="input" name="n_cust_nm" dataformat="engup" id="n_cust_nm" otherchar=" &amp;-,." /></td>
				</tr>
				<tr>
					<td><b>Notify Address</b></td>
					<td><input type="text" style="width:100%;" class="input" name="n_cust_addr" dataformat="engup" id="n_cust_addr" otherchar=" &amp;-,." /></td>
				</tr>
			</table>
			<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			</div>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t3RowAdd" id="btn_t3RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_t3Delete" 	id="btn_t3Delete">Row Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_t3LoadExcel" 	id="btn_t3LoadExcel">Load Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
	</div>
</div>
</form>