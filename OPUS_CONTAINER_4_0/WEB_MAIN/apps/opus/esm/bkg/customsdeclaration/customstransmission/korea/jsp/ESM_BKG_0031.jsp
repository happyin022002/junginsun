<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0031.jsp
*@FileTitle  : Manifest Amendment Transmission To Korean Customs
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.*"%>
<%
	// InBound, OutBound Distinction
	String ioBndCd = request.getParameter("io_bnd_cd")==null?"I":request.getParameter("io_bnd_cd");
	// B/L NO
	String blNo    = request.getParameter("bl_no")==null?"":request.getParameter("bl_no");
	// BKG NO
	String bkgNo = request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no");
	// MODE 구분 (ADD / EDIT)
	String mode    = request.getParameter("mode")==null?"ADD":request.getParameter("mode");
	// IN TYPE
	String inType    = request.getParameter("in_type")==null?"ADD":request.getParameter("in_type");
	// VVD
	String vvd    = request.getParameter("vvd")==null?"":request.getParameter("vvd");
	// PORT_CD
	String polCd = request.getParameter("pol_cd")==null?"":request.getParameter("pol_cd");
	String podCd = request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
	String portCd = request.getParameter("port_cd")==null?"":request.getParameter("port_cd");
	// Cargo Spec Processing
	String cgoSpecClear = request.getParameter("cgo_spec_clear")==null?"":request.getParameter("cgo_spec_clear");
	// CSTMS_DECL_TP_CD
	String cstmsDeclTpCd = request.getParameter("cstms_decl_tp_cd")==null?"":request.getParameter("cstms_decl_tp_cd");

	if (cstmsDeclTpCd.equals("")) {
		if (ioBndCd.equals("I")) cstmsDeclTpCd = "I"; else cstmsDeclTpCd="E";
	}
%>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}

</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="amdt_rcvr_flg" value="A" id="amdt_rcvr_flg" />
<input type="hidden" name="kr_cstms_corr_id" id="kr_cstms_corr_id" />
<input type="hidden" name="cgo_spec" id="cgo_spec" />
<input type="hidden" name="cmdt_cd" id="cmdt_cd" />
<input type="hidden" name="kr_cstms_wh_tp_cd" id="kr_cstms_wh_tp_cd" />
<input type="hidden" name="biz_no" id="biz_no" />
<input type="hidden" name="pck_tp_cd" id="pck_tp_cd" />
<input type="hidden" name="biz_rgst_no" id="biz_rgst_no" />
<input type="hidden" name="kr_meas_ut_cd" id="kr_meas_ut_cd" />
<input type="hidden" name="mode" value="<%=mode%>" id="mode" />
<input type="hidden" name="cstms_decl_tp_cd" value="<%=cstmsDeclTpCd%>" id="cstms_decl_tp_cd" />
<input type="hidden" name="old_cstms_decl_tp_cd" value="<%=cstmsDeclTpCd%>" id="old_cstms_decl_tp_cd" />
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>" id="io_bnd_cd" />
<input type="hidden" name="in_type" value="<%=inType%>" id="in_type" />
<input type="hidden" name="pol_loc" value="<%=polCd%>" id="pol_loc" />
<input type="hidden" name="pod_loc" value="<%=podCd%>" id="pod_loc" />
<input type="hidden" name="port_cd" value="<%=portCd%>" id="port_cd" />
<input type="hidden" name="por_cd" id="por_cd" />
<input type="hidden" name="del_cd" id="del_cd" />
<input type="hidden" name="frt_fwrd_cd" id="frt_fwrd_cd" />
<input type="hidden" name="kr_cstms_dept_cd" id="kr_cstms_dept_cd" />
<input type="hidden" name="trns_seq" id="trns_seq" />
<input type="hidden" name="trans_chk" id="trans_chk" />
<input type="hidden" name="org_bl_no" id="org_bl_no" />
<input type="hidden" name="cgo_spec_clear" value="<%=cgoSpecClear%>" id="cgo_spec_clear" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Korea : BL Amendment (Add and Edit)</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
				<button type="button" class="btn_accent" id="btn_Retrieve" name="btn_Retrieve">Retrieve</button><!--
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
			 --><button type="button" class="btn_normal" name="btn_CorrectionListClear" id="btn_CorrectionListClear">Correction List Clear</button><!--
			 --><button type="button" class="btn_normal" name="btn_TransAmendment" id="btn_TransAmendment">Trans Amendment</button><!--
			 --><button type="button" class="btn_normal" name="btn_TransDischAmend" id="btn_TransDischAmend">Trans Disch Amend</button>
	</div>
	 <!-- opus_design_btn(E) -->
	 <!-- page_location(S) -->
<!-- 	<div class="location">	 -->
<!-- 		 <span>Service Management</span> &gt; -->
<!-- 	 	 <span>Booking/Documentation </span> &gt; -->
<!-- 	  	 <span>manifest</span> &gt; -->
<!-- 	  	 <span>Korea</span> &gt; -->
<!-- 	  	 <span>Manifest Amend</span> -->
<!--    		<a href="" class="ir">URL Copy</a> -->
<!-- 	</div> -->
	<!-- page_location(E) -->
</div>

<div class="wrap_search_tab">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			 <table>
				<colgroup>
					<col width="100">
					<col width="60">
					<col width="80">
					<col width="120">
					<col width="90">
					<col width="60">
					<col width="80">
					<col width="*">
				</colgroup>
				<tbody>
					 <tr>
						<th>Receiver</th>
						<td><script type="text/javascript">ComComboObject('cboReceiver', 2, 40, 1, 1);</script></td>
						<th>Sub No.</th>
						<td><input type="text" style="width:150px; text-align:center;" class="input2" name="smt_amd_no" id="smt_amd_no" readOnly></td>
						<th>B/L No.</th>
						<td><input type="text" style="width:100px; text-align:center;" class="input1" value="<%=blNo%>" name="bl_no" id="bl_no"  dataformat="eng" maxlength="12"></td>
						<th>Trans</th>
						<td><script type="text/javascript">ComComboObject('cboTrans', 2, 90, 1, 1);</script></td>
					</tr>
				</tbody>
			</table>
			<table>
				 <colgroup>
					<col width="100">
					<col width="60">
					<col width="80">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Correction</th>
						<td><script type="text/javascript">ComComboObject('cboCorrection', 2, 40, 1, 1);</script></td>
						<th>Reason</th>
						<td><input type="text" style="width:347px" class="input" name="corr_rsn" id="corr_rsn"></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table>
			   <colgroup>
					<col width="100">
					<col width="80">
					<col width="50">
					<col width="80">
					<col width="70">
					<col width="116">
					<col width="120">
					<col width="175">
					<col width="180">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>MRN</th>
						<td><input type="text" style="width:80px; text-align:center;" class="input" name="mrn_no" id="mrn_no" maxlength="11" dataformat="eng" otherchar="!@#$%^&*().*~ " ></td>
						<th>MSN</th>
						<td><input type="text" style="width:80px; text-align:center;" class="input" name="msn_no" id="msn_no" maxlength="4" dataformat="eng" otherchar="!@#$%^&*().*~ "></td>
						<th>BKG No.</th>
						<td><input type="text" style="width:108px" class="input" name="bkg_no" id="bkg_no" maxlength="13" dataformat="eng"  value="<%=bkgNo%>"></td>
						<th>Cargo Type</th>
						<td>
							<%=JSPUtil.getCodeCombo("bkg_cgo_tp_cd", "", "width:125px;", "CD00767", 0, "")%></td>
						<th>B/L Type</th>
						<td>
							<%=JSPUtil.getCodeCombo("kr_cstms_bl_tp_cd", "", "style='width:80px' onFocus='setOldData(this.value)' onChange='krCstmsBlTpCd_onChange()'", "CD01535", 0, "")%><!--
						 --><input type="text" style="display:inline; width:50px; text-align:center;" name="cstms_fwrd_id" id="cstms_fwrd_id" class="input" maxlength="4" dataformat="eng" onChange="cstmsFwrdId_OnChange();" onFocus="cstmsFwrdId_OnFocus();">
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="100">
					<col width="80">
					<col width="50">
					<col width="80">
					<col width="70">
					<col width="100">
					<col width="120">
					<col width="80">
					<col width="50">
					<col width="100">
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:80px; text-align:center;" class="input" name="vvd" id="vvd" value="<%=vvd%>" dataformat="engup" maxlength="9" onFocus="setOldData(this.value)" onChange="vvd_onChange()"></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width:80px; text-align:center;" class="input" name="pol_cd" id="pol_cd" value="<%=polCd%>" maxlength="5" dataformat="engup" onFocus="setOldData(this.value)" onChange="pol_onChange()"></td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:109px; text-align:center;" class="input" name="pod_cd" id="pod_cd" value="<%=podCd%>" maxlength="5" dataformat="engup" onFocus="setOldData(this.value)" onChange="pod_onChange()"></td>
						<th>Call Sign</th>
						<td><input type="text" style="width:124px; text-align:center;" class="input" name="vsl_call_sgn_cd" id="vsl_call_sgn_cd" dataformat="eng" otherchar="!@#$%^&*().*~ " maxlength="5" onFocus="setOldData(this.value)" onChange="vslCallSgnCd_onChange()"></td>
						<th>Year</th>
						<td>
							<input type="text" style="width:44px" class="input" name="eta_dt" id="eta_dt"><!--
							 --><input type="text" style="width:30px" class="input" name="call_knt" id="call_knt">
						</td>
						<th>Cargo Spec.</th>
						<td><script type="text/javascript">ComComboObject('cboCargoSpec', 1, 100, 1);</script></td>
					</tr>
					</tbody>
			</table>
			<table>
				<colgroup>
					<col width="100">
					<col width="184">
					<col width="110">
					<col width="70">
					<col width="120">
					<col width="255">
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					 <tr>
						<th>VSL Name</th>
						<td><input type="text" style="width:169px" class="input" name="vsl_nm"  id="vsl_nm" onFocus="setOldData(this.value)" onChange="vslNm_onChange()"></td>
						<th>Flag</th>
						<td><input type="text" style="width:109px; text-align:center;" class="input" name="vsl_cnt_cd" id="vsl_cnt_cd" dataformat="eng" otherchar="!@#$%^&*().*~ " onFocus="setOldData(this.value)" onChange="vslCntCd_onChange()"></td>
						<th>IMDG Code</th>
						<td>
							<input type="text" style="width:60px; text-align:center;" class="input" name="imdg_clss_cd" id="imdg_clss_cd" onFocus="setOldData(this.value)" onChange="imdgClssCd_onChange()"><!--
							 --><input type="text" style="width:60px; text-align:center;" class="input" name="n2nd_imdg_clss_cd" id="n2nd_imdg_clss_cd" onFocus="setOldData(this.value)" onChange="n2ndImdgClssCd_onChange()"><!--
							 --><input type="text" style="width:56px; text-align:center;" class="input" name="n3rd_imdg_clss_cd" id="n3rd_imdg_clss_cd" onFocus="setOldData(this.value)" onChange="n3rdImdgClssCd_onChange()">
						</td>
						<th>HS Code</th>
						<td><script type="text/javascript">ComComboObject('cboGoods', 2, 100, 1);</script></td>
					</tr>
				</tbody>
			</table>
			<table>
				 <colgroup>
					<col width="100">
					<col width="184">
					<col width="110">
					<col width="126">
					<col width="110">
					<col width="150">
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
					 <tr>
						<th>Package</th>
						<td>
							<input type="text" style="width:60px;text-align:right" class="input" name="pck_qty" id="pck_qty" value="0" dataformat="int" onFocus="setPckOldData(this.value)" onChange="pckQty_onChange()" ><!--
							 --><script type="text/javascript">ComComboObject('cboPackage', 2, 104, 1);</script>
						</td>
						<th>Weight</th>
						<td>
							<input type="text" style="width:46px;text-align:right" class="input" name="cntr_ttl_wgt" id="cntr_ttl_wgt" value="0.0" dataformat="float" onFocus="setOldData(this.value)" onChange="cntrTtlWgt_onChange()"><!--
							--><%=JSPUtil.getCodeCombo("wgt_ut_cd", "", "style='width:60px'", "CD00775", 0, "")%>
						   </td>
						<th>Measure</th>
						<td>
							<input type="text" style="width:124px;text-align:right" class="input" name="meas_qty" id="meas_qty" value="0.00" dataformat="float" onFocus="setOldData(this.value)" onChange="measQty_onChange()"><!--
							 --><%=JSPUtil.getCodeCombo("meas_ut_cd", "", "style='width:58px;' onfocus='setOldData(this.value)' onChange='measUtCd_onChange()'", "CD01116", 0, "")%>
						   </td>
						<th>Biz No.</th>
						<td>
							<script type="text/javascript">ComComboObject('cboBizNo', 2, 203, 0,0,0,true);
							<%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeForMultiCombo("p_cbo_bizno_temp_","KR", "MANI_KR_BIZ_NO","")%>
							</script>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				 <colgroup>
					<col width="100">
					<col width="144">
					<col width="150">
					<col width="176">
					<col width="60">
					<col width="214">
					<col width="40">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Bond Area Code</th>
						<td><input type="text" style="width:123px;text-align:center" class="input" name="bd_area_cd" id="bd_area_cd" dataformat="eng" maxlength="10" onFocus="setOldData(this.value)" onChange="bdAreaCd_onChange()"></td>
						<th>Warehouse Info.</th>
						<td>
							<script type="text/javascript">ComComboObject('cboWhTpCd', 2, 60, 1);</script><!--
							 --><input type="text" style="width:92px;text-align:center" class="input" name="kr_wh_cd" id="kr_wh_cd">
						</td>
						<th>Customs</th>
						<td>
							<input type="text" style="width:63px;text-align:center" maxlength="3" class="input" dataformat="int" name="cstms_ofc_cty_cd" id="cstms_ofc_cty_cd" value="000"><!--
							 --><input type="text" style="width:56px;text-align:center" maxlength="2" dataformat="int" class="input" name="kr_cstms_dept_cd" id="kr_cstms_dept_cd" value="00"></td>
						<th>PA</th>
						<td>
							<input type="text" style="width:70px;text-align:center" maxlength="3" dataformat="int" class="input" name="kr_port_auth_cd" id="kr_port_auth_cd">
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="100">
					<col width="144">
					<col width="150">
					<col width="166">
					<col width="70">
					<col width="60">
					<col width="114">
					 <col width="70">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>MEA Unit</th>
						<td>
							<script type="text/javascript">ComComboObject('cboMeaUnit', 2, 40, 1);</script>
						</td>
						<th>Bulk WGT</th>
						<td><input type="text" style="width:58px;text-align:right" class="input" dataformat="float" name="bb_cgo_wgt" id="bb_cgo_wgt" value="0.0" onFocus="setOldData(this.value)" onChange="bbCgoWgt_onChange()"></td>
						<th>Bulk MEA</th>
						<td><input type="text" style="width:63px;text-align:right" class="input" dataformat="float" name="bb_cgo_meas_qty" id="bb_cgo_meas_qty" value="0.00" onFocus="setOldData(this.value)" onChange="bbCgoMeasQty_onChange()" ></td>
						<th>Quay <input type="text" style="width:60px;text-align:center;" class="input" name="io_tml_loc_cd" id="io_tml_loc_cd" dataformat="eng" otherchar="!@#$%^&*().*~ " maxlength="5" onFocus="setOldData(this.value)" onChange="ioTmlLocCd_onChange()"></th>
						<th>하역</th>
						<td><input type="text" style="width:70px;text-align:center;" class="input" name="dchg_mzd_cd" id="dchg_mzd_cd" maxlength="1" dataformat="int" onFocus="setOldData(this.value)" onChange="dchgMzdCd_onChange()"></td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><td><strong>Cargo Desc. 1</strong></td>
						<td><input type="text" style="width:100%;" class="noinput" name="cgo_desc1" id="cgo_desc1"></td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><td><strong>Cargo Desc. 2</strong></td>
						<td><textarea cols="" rows="4" style="width:100%;resize:none" name="cgo_desc2" id="cgo_desc2" class="input"></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" style="display:inline;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >
			<div class="opus_design_btn">
				<button class="btn_normal" type="button"  name="btn_t1RowAdd" id="btn_t1RowAdd">Row Add</button><!--
			 --><button class="btn_normal" type="button"  name="btn_t1SelectAll" id="btn_t1SelectAll">Select All</button><!--
			--><button class="btn_normal" type="button"  name="btn_t1Delete" id="btn_t1Delete">Row Delete</button><!--
			--><button class="btn_normal" type="button"  name="btn_t1LoadExcel" id="btn_t1LoadExcel">Load Excel</button>
			</div>
			 <script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<div id="tabLayer" style="display:none">
		<div class="opus_design_data">
			<table class="grid2">
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><th><strong>shipper Name</strong></th>
						<td><input type="text" style="width:100%;" class="noinput" name="s_cust_nm" id="s_cust_nm" onFocus="setOldData(this.value)" onChange="sCustNm_onChange()" value="<%=ConstantMgr.getCompanyName()%>"></td>
					</tr>
				</tbody>
			</table>
			<table class="grid2 mar_btm_8">
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><th><strong>Shipper Address</strong></th>
						<td><input type="text" style="width:100%;" class="noinput" name="s_cust_addr" id="s_cust_addr" onFocus="setOldData(this.value)" onChange="sCustAddr_onChange()" value="KRPUS"></td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><th><strong>Consignee Name</strong></th>
						<td><input type="text" style="width:100%;" class="noinput" name="c_cust_nm" id="c_cust_nm" onFocus="setOldData(this.value)" onChange="cCustNm_onChange()" value="<%=ConstantMgr.getCompanyName()%>"></td>
					</tr>
				</tbody>
			</table>
			<table class="grid2 mar_btm_8" >
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><th><strong>Consignee Address</strong></th>
						<td><input type="text" style="width:100%;" class="noinput" name="c_cust_addr" id="c_cust_addr" onFocus="setOldData(this.value)" onChange="cCustAddr_onChange()"></td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><th><strong>Notify Name</strong></th>
						<td><input type="text" style="width:100%;" class="noinput" name="n_cust_nm" id="n_cust_nm" onFocus="setOldData(this.value)" onChange="nCustNm_onChange()" value="<%=ConstantMgr.getCompanyName()%>"></td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><th><strong>Notify Address</strong></th>
						<td><input type="text" style="width:100%;" class="noinput" name="n_cust_addr" id="n_cust_addr" onFocus="setOldData(this.value)" onChange="nCustAddr_onChange()"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
		<div id="tabLayer" style="display:none">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable" >
				<div class="opus_design_btn">
					<button class="btn_normal" type="button"  name="btn_t3RowAdd" id="btn_t3RowAdd">Row Add</button><!--
				 --><button class="btn_normal" type="button"  name="btn_t3SelectAll" id="btn_t3SelectAll">Select All</button><!--
				--><button class="btn_normal" type="button"  name="btn_t3Delete" id="btn_t3Delete">Row Delete</button><!--
				--><button class="btn_normal" type="button"  name="btn_t3LoadExcel" id="btn_t3LoadExcel">Load Excel</button>
				</div>
				 <script type="text/javascript">ComSheetObject('t3sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<div id="tabLayer" style="display:none">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable" >
				<div class="opus_design_btn">
					<button class="btn_normal" type="button"  name="btn_t4RowAdd" id="btn_t4RowAdd">Row Add</button><!--
				 --><button class="btn_normal" type="button"  name="btn_t4SelectAll" id="btn_t4SelectAll">Select All</button><!--
				--><button class="btn_normal" type="button"  name="btn_t4Delete" id="btn_t4Delete">Row Delete</button><!--
				--><button class="btn_normal" type="button"  name="btn_t4LoadExcel" id="btn_t4LoadExcel">Load Excel</button>
				</div>
				 <script type="text/javascript">ComSheetObject('t4sheet1');</script>
			</div>
			<div class="opus_design_grid" id="mainTable" >
				<script type="text/javascript">ComSheetObject('t4sheet2');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
</div>
</form>