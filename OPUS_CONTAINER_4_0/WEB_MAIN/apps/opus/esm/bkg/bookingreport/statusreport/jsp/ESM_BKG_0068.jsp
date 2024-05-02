<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0068.jsp
*@FileTitle  : B/L(Manifest) Clearance Cross-Check List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0068Event"%>	
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%
	EsmBkg0068Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	
	//String[] contiCd = null;
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0068Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		// contiCd = RASUtil.getValueObject2StringArray((List<RsltContiListVO>)eventResponse.getCustomData("contiCd"), false, "|", "\t", "getContiCd", "getContiNm");

	} catch (Exception e) {
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
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd"> 
	<input type="hidden" name="pagerows" id="pagerows"> 
	<input type="hidden" name="ch_usr_id" id="ch_usr_id">
	<input type="hidden" name="curr_page" id="curr_page"      value="1">
	<input type="hidden" name="rows_per_page" id="rows_per_page"  value="50">
	<input type="hidden" name="mst_bkg_no" id="mst_bkg_no">
	<input type="hidden" name="ca_rsn_cd"  id="ca_rsn_cd">
	<input type="hidden" name="ca_remark" id="ca_remark">
   <input type="hidden" name="backendjob_key" id="backendjob_key" value="">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Print" 	id="btn_Print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td width="120"><input type="text" style="width:90px" value="" class="input1"  name="p_vvd" id="p_vvd" maxlength='9' required fullfill  dataformat='engup' style="ime-mode:disabled"></td>
					<th width="60">POL</th>
					<td width="60"><input type="text" style="width:60px" value="" name="p_pol_cd" id="p_pol_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"><!--
					     --><input type="text" style="width:25px" value="" class="input" name="p_pol_yd_cd" maxlength='2' dataformat='engup' style="ime-mode:disabled">
					</td>
					<th width="60">L/T</th>
					<td width="60"><%=JSPUtil.getCodeCombo("p_pol_lt", "", "", "CD20052", 0, "000001: :All")%>
					</td>
					<th width="60">POR</th>
					<td width="60"><input type="text" style="width:60px" value="" name="p_por_cd" id="p_por_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
					<th width="60">A/POD</th>
					<td width="60"><input type="text" style="width:60px" name="p_apod_cd" id="p_apod_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
					<th width="120">L/T</th>
					<td width="60"><%=JSPUtil.getCodeCombo("p_apod_lt", "", "", "CD20052", 0, "000001: :All")%>
					</td>
					<th width="60">DEL</th>
					<td width="60"><input type="text" style="width:60px" value="" class="input" name="p_del_cd" id="p_del_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" ></td>
					<th width="60">E/Q Type</th>
					<td width="60">
						<script type="text/javascript">ComComboObject('p_eq_type', 1, 60, true, '');</script>
					</td>						
				</tr>
				<tr>
					<th>BKG Office</th>
					<td>
					<input type="text" style="width: 55px" value="" class="input" name="p_bkg_ofc_cd" maxlength='6' dataformat='enguponly' style="ime-mode:disabled"><!--
					--><input	type="checkbox" value="Y" name="p_ofc_cd" id="p_ofc_cd"><label for="p_ofc_cd">Sub</label>
					</td>
					<th>BKG STF</th>
					<td><input type="text" style="width: 89px" value=""	class="input" name="p_doc_usr_id" maxlength='20' dataformat='eng' style="ime-mode:disabled"></td>
					<th>Sales Office</th>
					<td><input type="text" style="width: 60px" value=""	class="input" name="p_ob_sls_ofc_cd" maxlength='6' dataformat='enguponly' style="ime-mode:disabled"></td>
					<th>Sales Rep</th>
					<td><input type="text" style="width: 60px"	value="" class="input" name="p_ob_srep_cd" maxlength='5' dataformat='enguponly' style="ime-mode:disabled"></td>
					<th>BKG Status</th>
					<td>
						<script type="text/javascript">ComComboObject('p_bkg_sts_cd', 1, 60, true, '');</script>
					</td>
					<th>Cargo Type</th>
					<td>
						<script type="text/javascript">ComComboObject('p_cnmv_sts_cd', 1, 60, true, '');</script>
					</td>
					<th>Zone</th>
					<td>					
						<select style="width: 100px;" class="input" name="p_zone_cd">
							<option value=""></option>
							<option value="OCN">Ocean</option>
							<option value="IPT">Inter Port</option>
						</select>
					</td>
					<th>DEL Cont</th>
					<td>
						<script type="text/javascript">ComComboObject('p_del_conti', 1, 100, true, '');</script>
					</td>
				</tr>
				<tr>
					<th>Special Cargo</th>
					<td colspan="4"><div class="sm"><table><tr>
					<td>
						<input type="checkbox"  value="Y" name="p_dcgo_flg" id="p_dcgo_flg"><label for="p_dcgo_flg">Danger</label><!--
	                 --><input type="checkbox"  value="Y" name="p_rc_flg" id="p_rc_flg"><label for="p_rc_flg">Reefer</label><!--
	                 --><input type="checkbox"  value="Y" name="p_awk_cgo_flg" id="p_awk_cgo_flg"><label for="p_awk_cgo_flg">Awkward</label><!--
	                 --><input type="checkbox"  value="Y" name="p_bb_cgo_flg" id="p_bb_cgo_flg"><label for="p_bb_cgo_flg">Break Bulk</label>
		            </td>
		            </tr></table></div></td>
					<td></td>		
					<th>BDR Status</th>
						<td>
							<select style="width: 60px;" class="input" name="p_bdr_flg" id="p_bdr_flg">
								<option value=""></option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select>
						</td>
						<th>S/I Received</th>
					<td>
						<select style="width:60px;" class="input" name="p_si_flg" id="p_si_flg">
							<option value="" ></option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>
					<th>B/L Office</th>
					<td><input type="text" style="width:60px" value="" class="input" name="p_obl_iss_ofc_cd" id="p_obl_iss_ofc_cd" maxlength='6' dataformat='enguponly' style="ime-mode:disabled"></td>
					<th width="60">R/D</th>
					<td>
						<script type="text/javascript">ComComboObject('p_rcv_term_cd', 1, 45, true, '');</script>
						<script type="text/javascript">ComComboObject('p_de_term_cd', 1, 45, true, '');</script>
					</td>
				</tr>
				<tr>
					
					<th>Customer</th>
					<td colspan="5">
						<script type="text/javascript">ComComboObject('p_bkg_cust_tp_cd', 1, 50, true, '');</script><!--
						--><input type="text" style="width:40px" value="" class="input" name="p_cust_cnt_cd" id="p_cust_cnt_cd" maxlength='2' dataformat='enguponly' style="ime-mode:disabled"><!-- 
						--><input type="text" style="width:60px" value="" class="input" name="p_cust_seq" id="p_cust_seq" maxlength='6' dataformat='num' style="ime-mode:disabled"><!-- 
						--><input type="text" style="width:156px" value="" class="input" name="p_cust_nm" id="p_cust_nm" maxlength='50' dataformat='engup' style="ime-mode:disabled">
					</td>
					<th>No Good</th>
					<td colspan="5">
						<script type="text/javascript">ComComboObject('p_no_good', 1, 170, 1);</script>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->


<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear">
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Combine" id="btn_Combine">Combine</button>
			</div> 
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<table class="grid_2 noinput2"> 
		<tbody>
			<tr>	
				<th rowspan="2" align="center">Total</th>
				<th>No. of BKG</th>
				<td><input type="text" name="total_bkg" style="width:80px;text-align:center" value="" readonly></td>
				<th>BKG Q'ty</th>
				<td><input type="text" name="total_bkg_f" style="width:80px;text-align:right" value="" class="noinput2" readonly></td>
				<td><input type="text" name="total_bkg_t" style="width:80px;text-align:right" value="" class="noinput2" readonly></td>
				<th>Non-CFM CNTR</th>
				<td><input type="text" name="total_cfm" style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>Non-CM CNTR</th>
				<td><input type="text" name="total_cm" style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>No Rated B/L</th>
				<td><input type="text" name="total_charge" style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>Non-Issued B/L</th>
				<td><input type="text" name="total_issue" style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
			</tr>
			
			<tr>
				<th>No of B/L</th>
				<td><input type="text" name="total_bl"  style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>CNTR Q'ty</th>
				<td><input type="text" name="total_ctrl_f"  style="width:80px;text-align:right" value="" class="noinput2" readonly></td>
				<td><input type="text" name="total_ctrl_t"  style="width:80px;text-align:right" value="" class="noinput2" readonly></td>
				<th>Non-VL CNTR</th>
				<td><input type="text" name="total_vl"  style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>Non-M & D CNTR</th>
				<td><input type="text" name="total_md"  style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>No Approval</th>
				<td><input type="text" name="total_apprval"  style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
				<th>Non-Received S/R</th>
				<td><input type="text" name="total_receiving"  style="width:80px;text-align:center" value="" class="noinput2" readonly></td>
			</tr>
		</tbody>
	</table> 
</div>
</form>

	<!-- report popup  -->
<form name="form2" method="post">
    <input type="hidden" name="rfn" id="rfn" />
    <input type="hidden" name="mrd" id="mrd" />
    <input type="hidden" name="rd_title" id="rd_title" />
    <input type="hidden" name="rp" id="rp" />
    <input type="hidden" name="rv" id="rv" />
</form>