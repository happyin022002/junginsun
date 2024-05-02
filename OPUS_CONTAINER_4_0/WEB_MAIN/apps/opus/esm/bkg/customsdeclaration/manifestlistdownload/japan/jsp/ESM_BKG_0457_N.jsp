<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0457.jsp
*@FileTitle  : ESM_BKG_0457
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0457Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0457Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server
	String strErrMsg = ""; //error messege
	//int rowCount = 0; //the number of DB ResultSet List

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0457Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

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

<!-- 개발자 작업 -->
<input type="hidden" name="cust_type" id="cust_type" />
<input type="hidden" name="form1_bl_no" id="form1_bl_no" />
<input type="hidden" name="form1_bl_split_no" id="form1_bl_split_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_reactivate" id="btn_reactivate" disabled>Reactivate</button><!--
		--><button type="button" class="btn_normal" name="btn_container" id="btn_container">Container</button><!--
		--><button type="button" class="btn_normal" name="btn_marks" id="btn_marks">Marks & Desc</button><!--
		--><button type="button" class="btn_normal" name="btn_approval" id="btn_approval">Approval No.</button><!--
		--><button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit" disabled>Transmit to SEA-NACCS</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="60" />
				<col width="20" />
				<col width="44" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>B/L No.</th>
					<td>
						<input type="text" style="width:100px" class="input1" name="in_bl_no" dataformat="engup" maxlength="12"><!--
					--><input type="text" style="width:30px" class="input1" name="in_bl_split_no" dataformat="engup" maxlength="2"><!--
					--><input type="text" style="width:50px" class="input2" name="form1_jp_bl_sts_cd" readonly><!--
					--><input type="text" style="width:50px" class="input2" name="form1_dcgo_flg" readonly><!--
					--><input type="text" style="width:50px" class="input2" name="form1_locl_ts_flg" readonly>
					</td>
					<th>Stage </th>
					<td>
						<input type="text" style="width:60px" class="input2" name="form1_jp_edi_trsm_stg_tp_cd" readonly><!--
						--><select style="width:80px;" name="form1_full_mty_cd">
							<option value="E" selected>Empty</option><!--
							--><option value="F"></option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<colgroup>
				<col width="60" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="20" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td width="120">
						<input type="text" style="width:100px;" class="input2" name="form1_vvd_cd" readonly="" id="form1_vvd_cd" />
					</td>
					<th title="Port of Discharging">POD</th>
					<td width="120">
						<input type="text" style="width:65px;" class="input" name="form1_pod_cd" dataformat="engup" maxlength="5" id="form1_pod_cd" /><!--
						--><input type="text" style="width:26px;" dataformat="engup" name="form1_pod_split_cd" class="input" maxlength="2" id="form1_pod_split_cd" />
					</td>
					<th>ETA</th>
					<td width="120">
						<input type="text" style="width:80px;" class="input2" name="form1_eta_dt" readonly="" id="form1_eta_dt" />
					</td>
					<th title="Place of Receipt">POR</th>
					<td width="150">
						<input type="text" style="width:65px;" class="input" name="form1_bkg_por_cd" dataformat="engup" maxlength="5" id="form1_bkg_por_cd" />
					</td>
					<th title="Port of Loading">POL</th>
					<td width="120">
						<input type="text" style="width:65px;" class="input" name="form1_bkg_pol_cd" dataformat="engup" maxlength="5" id="form1_bkg_pol_cd" />
					</td>
					<th title="Place of Delivery">DEL</th>
					<td>
						<input type="text" style="width:65px;" class="input" name="form1_bkg_del_cd" dataformat="engup" maxlength="5" id="form1_bkg_del_cd" />
					</td>
				</tr>
			</tbody>
		</table>
		<table style="margin-top:5px">
			<colgroup>
				<col width="60" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="150" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>N.VVD</th>
					<td width="120">
						<input type="text" style="width:100px;" class="input2" name="form1_pst_vvd_cd" readonly="" id="form1_pst_vvd_cd" />
					</td>
					<th>N.POD</th>
					<td width="120">
						<input type="text" style="width:90px;" class="input2" name="form1_pst_rly_pod_cd" readonly="" id="form1_pst_rly_pod_cd" />
					</td>
					<th>Q'ty</th>
					<td width="120">
						<input type="text" style="width:40px;" class="input" dataformat="num" name="form1_pck_qty" id="form1_pck_qty" /><!--
						--><input type="text" style="width:35px;" class="input" name="form1_pck_tp_cd" dataformat="engup" maxlength="2" id="form1_pck_tp_cd" />
					</td>
					<th>WGT</th>
					<td width="150">
						<input type="text" style="width:70px;text-align:right" class="input" dataformat="float" name="form1_grs_wgt" id="form1_grs_wgt" /><!--
						--><select style="width:57;" name="form1_wgt_ut_cd">
							<option value="KGS" selected>KGS</option><!--
							--><option value="LBS">LBS</option>
						</select>
					</td>
					<th>MEA</th>
					<td>
						<input type="text" style="width:70px;text-align:right" class="input" dataformat="float" name="form1_meas_qty" id="form1_meas_qty" /><!--
						--><select style="width:57px;" name="form1_meas_ut_cd">
							<option value="CBM" selected>CBM</option><!--
							--><option value="CBF">CBF</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	<!-- opus_design_grid(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="layout_vertical_2 pad_rgt_8" style="width:50%">
			<table>
				<colgroup>
					<col width="82"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th class="sm">Shipper</th>
					<td class="sm">
						<input type="text" name="form1_cust_cnt_cd" dataformat="engup" style="width:30px;" maxlength="2" class="input" id="form1_cust_cnt_cd" /><!--
						--><input type="text" name="form1_cust_seq" style="width:60px;text-align:right;" maxlength="6" dataformat="num" class="input" id="form1_cust_seq" /><!--
						--><button type="button" class="btn_down_list" id="btn_cust1" name="btn_cust1"></button>
					</td>
				</tr>
			</table>
			<table class="grid_2">
				<colgroup>
					<col width="81" />
					<col width="150" />
					<col width="70" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th class="sm">Name</th>
						<td width="350" colspan="3">
							<textarea name="form1_cust_nm" dataformat="engupetc" style="width:100%;resize:none;margin-top:3px;" rows="2" maxlength="500" ></textarea>
						</td>
					</tr>
					<tr>
						<th class="sm">Address</th>
						<td width="350" colspan="3">
							<textarea name="form1_cust_addr" dataformat="engupetc" style="width:100%;resize:none" rows="3" maxlength="500"></textarea>
						</td>
					</tr>
					<tr>
						<th class="sm">Tel.</th>
						<td>
							<input type="text" name="form1_phn_no" dataformat="num" style="width:100%;resize:none" class="input" maxlength="20" id="form1_phn_no" />
						</td>
						<th class="sm">Fax.</th>
						<td>
							<input type="text" name="form1_fax_no" dataformat="num" style="width:100%;resize:none" class="input" maxlength="20" id="form1_fax_no" />
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="82"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th class="sm">Consignee</th>
					<td class="sm">
						<input type="text" name="form1_cust_cnt_cd2" dataformat="engup" style="width:30px;" maxlength="2" class="input" id="form1_cust_cnt_cd2" /><!--
					--><input type="text" name="form1_cust_seq2" style="width:60px;text-align:right;" maxlength="6" dataformat="num" class="input" id="form1_cust_seq2" /><!--
					--><button type="button" class="btn_down_list" id="btn_cust2" name="btn_cust2"></button>
					</td>
				</tr>
			</table>
			<table style="margin-top:3px" class="grid_2">
				<colgroup>
					<col width="81" />
					<col width="150" />
					<col width="70" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th class="sm">Name</th>
						<td width="350" colspan="3">
							<textarea name="form1_cust_nm2" dataformat="engupetc" style="width:100%;resize:none;margin-top:3px;" rows="2" maxlength="500"></textarea>
						</td>
					</tr>
					<tr>
						<th class="sm">Address</th>
						<td width="350" colspan="3">
							<textarea name="form1_cust_addr2" dataformat="engupetc" style="width:100%;resize:none" rows="3" maxlength="500"></textarea>
						</td>
					</tr>
					<tr>
						<th class="sm">Tel.</th>
						<td>
							<input type="text" name="form1_phn_no2" dataformat="num" style="width:100%;resize:none" class="input" maxlength="20" id="form1_phn_no2" />
						</td>
						<th class="sm">Fax.</th>
						<td>
							<input type="text" name="form1_fax_no2" dataformat="num" style="width:100%;resize:none" class="input" maxlength="20" id="form1_fax_no2" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="layout_vertical_2 pad_rgt_8" style="width:50%">
			<table>
				<colgroup>
					<col width="82"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th class="sm">Notify</th>
					<td class="sm">
						<input type="text" name="form1_cust_cnt_cd3" dataformat="engup" style="width:30px;" maxlength="2" class="input" id="form1_cust_cnt_cd3" /><!--
					--><input type="text" name="form1_cust_seq3" style="width:60px; text-align:right;" maxlength="6" dataformat="num" class="input" id="form1_cust_seq3" /><!--
					--><button type="button" class="btn_down_list" id="btn_cust3" name="btn_cust3"></button>
					</td>
				</tr>
			</table>
			<table class="grid_2">
				<colgroup>
					<col width="81" />
					<col width="150" />
					<col width="70" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th class="sm">Name</th>
						<td width="350" colspan="3">
							<textarea name="form1_cust_nm3" dataformat="engupetc" style="width:100%;resize:none;margin-top:3px;" rows="2" maxlength="500"></textarea>
						</td>
					</tr>
					<tr>
						<th class="sm">Address</th>
						<td colspan="3">
							<textarea name="form1_cust_addr3" dataformat="engupetc" style="width:100%;resize:none" rows="3" maxlength="500"></textarea>
						</td>
					</tr>
					<tr>
						<th class="sm">Tel.</th>
						<td>
							<input type="text" name="form1_phn_no3" dataformat="num" style="width:100%;resize:none" class="input" maxlength="20" id="form1_phn_no3" />
						</td>
						<th class="sm">Fax.</th>
						<td>
							<input type="text" name="form1_fax_no3" dataformat="num" style="width:100%;resize:none" class="input" maxlength="20" id="form1_fax_no3" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>