<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0632.jsp
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0632Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0632Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0632Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="vsl_cd" id="vsl_cd">
<input type="hidden" name="skd_voy_no" id="skd_voy_no">
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
		
<!-- opus_design_inquiry(S) -->
<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<tr>
				<th width="68">T/VVD</th>						
				<td width="300" colspan="7">
					<input type="text" name="vvd_sig" dataformat="engup" maxlength="9" class="input" style="width:80px;" value="" onBlur="javascript:searchLane(this);" id="vvd_sig" /><!--
					--><input type="text" name="slan_cd" dataformat="engup" maxlength="3" class="input2" style="width:35px;" value="" readonly id="slan_cd" /><!--
					--><input type="text" name="vvd_idx" dataformat="engup" maxlength="3" class="input2" style="width:18px;" value="" readonly id="vvd_idx" /><!--
					--><button type="button"  class="input_seach_btn" onClick="javascript:getVvds();"></button><!--
					--><script type="text/javascript">ComComboObject('vvd', 1, 120, true, 1);</script>
				</td>
				<th width="80">Cargo Type</th>
				<td width="100"><script type="text/javascript">ComComboObject('bkg_cgo_tp_cd', 2, 40, true, '');</script></td>
				<th width="80">Customer</th>
				<td width="200" colspan="2">
					<select name="bkg_cust_tp_cd" id="bkg_cust_tp_cd" style="width:65px;" class="input">
						<option value="S" selected>SH</option>
						<option value="C">CN</option>
						<option value="N">NT</option>
						<option value="">ALL</option>
					</select><input type="text" name="cust_cnt_cd" id="cust_cnt_cd" dataformat="enguponly" maxlength="2" class="input" style="width:30px;" value=""><!--
					--><input type="text" name="cust_seq" id="cust_seq" dataformat="num" maxlength="6" class="input" style="width:40px;" value=""><!--
					--><input type="text" name="cust_nm" id="cust_nm" class="input" style="width:100px;" value="">
				</td>
				<th width="80">Contract No.</th>
				<td>
					<select name="cuntract_tp" id="cuntract_tp" style="width:85px;" class="input2">
						<option value="A" selected>S/C NO</option>
						<option value="B">RFA NO</option>
					</select><!--
					 --><input type="text" name="cuntract_no" id="cuntract_no" class="input" style="width:85px;" value="" dataformat="engup">
				</td>
			</tr>
			<tr>
				<th>B/POL</th>
				<td><input type="text" name="pol_cd" id="pol_cd" dataformat="engup" maxlength="5" class="input" style="width:45px;" value=""></td>
				<th>B/POD</th>
				<td ><input type="text" name="pod_cd" id="pod_cd" dataformat="engup" maxlength="5" class="input" style="width:45px;" value=""></td>
				<th title="Place of Receipt">POR</th>
				<td ><input type="text" name="por_cd" id="por_cd" dataformat="engup" maxlength="5" class="input" style="width:45px;" value=""></td>
				<th title="Place of Delivery">DEL</th>
				<td><input type="text" name="del_cd" id="del_cd"  dataformat="engup" maxlength="5" class="input" style="width:45px;" value=""></td>
				<th>Commodity</th>
				<td><input type="text" name="rep_cmdt_cd" id="rep_cmdt_cd" dataformat="engup" maxlength="4" class="input" style="width:40px;" value=""><!--
					--><input type="text" name="cmdt_cd" id="cmdt_cd" dataformat="engup" maxlength="6" class="input" style="width:55px;" value=""></td>
				<th class="sm">Special</th>
				<td class="sm" colspan="2">
					<div style="width: 219px;">
						<table>
							<tr>
								<td>
									<input type="checkbox" id="dcgo_flg" name="dcgo_flg" value="Y"><label for="dcgo_flg">D/G</label><!--
									--><input type="checkbox" id="rc_flg" name="rc_flg" value="Y"><label for="rc_flg">RF</label><!--
									--><input type="checkbox" id="awk_cgo_flg" name="awk_cgo_flg" value="Y"><label for="awk_cgo_flg">AK</label><!--
									--><input type="checkbox" id="bb_cgo_flg" name="bb_cgo_flg" value="Y"><label for="bb_cgo_flg">BB</label><!--
									--><input type="checkbox" id="rd_cgo_flg" name="rd_cgo_flg" value="Y"><label for="rd_cgo_flg">RD</label>
								</td>
							</tr>
						</table>
					</div>
				</td>
				<th>Load View</th>
				<td>
					<select name="load_view" id="load_view" style="width:174px;" class="input">
						<option value="1" selected>Actual Load include Memo</option>
						<option value="0" >B/L exclude Memo</option>	
					</select>
				</td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<tr>
				<th width="100">Booking Office</th>
				<td width="130"><input type="text" name="bkg_ofc_cd" id="bkg_ofc_cd" dataformat="enguponly" maxlength="6" class="input" style="width:50px;" value=""><!--
					--><input type="checkbox" id="bkg_ofc_sub" name="bkg_ofc_sub" value="Y"><label for="bkg_ofc_sub">Incl Sub</label>
				</td>
				<th width="110">Sales Office</th>
				<td width="120">
					<input type="text" name="ob_sls_ofc_cd" id="ob_sls_ofc_cd" dataformat="enguponly" maxlength="6" class="input" style="width:50px;" value=""><!--
					--><input type="checkbox" id="ob_sls_ofc_sub" name="ob_sls_ofc_sub" value="Y"><label for="ob_sls_ofc_sub">Incl Sub</label>
				</td>
				<th width="120">Sales Rep</th>
				<td width="60"><input type="text" name="ob_srep_cd" id="ob_srep_cd" dataformat="engup" maxlength="6" class="input" style="width:50px;" value=""></td>
				<th width="120">Contract Office</th>
				<td width="60"><input type="text" name="ctrt_ofc_cd" id="ctrt_ofc_cd" dataformat="enguponly" maxlength="6" class="input" style="width:50px;" value=""></td>
				<th width="90">Contract Rep</th>
				<td width="100"><input type="text" name="ctrt_srep_cd" id="ctrt_srep_cd" dataformat="engup" maxlength="6" class="input" style="width:45px;" value=""></td>
				<th width="80">I/B Office</th>
				<td><input type="text" name="ib_sls_ofc_cd" id="ib_sls_ofc_cd" dataformat="enguponly" maxlength="6" class="input" style="width:45px;" value=""><!--
					--><input type="checkbox" id="ib_sls_ofc_sub" name="ib_sls_ofc_sub" value="Y"><label for="ib_sls_ofc_sub">Incl Sub</label>
				</td>
			</tr>
			<tr>
				<th>Service Route Origin</th>
				<td><script type="text/javascript">ComComboObject('org_rout_cd', 2, 50, true, '');</script></td>
				<th>Service Route Dest</th>
				<td><script type="text/javascript">ComComboObject('dest_rout_cd', 2, 50, true, '');</script></td>
				<th>Service Mode Origin</th>
				<td><script type="text/javascript">ComComboObject('org_svc_mod_cd', 2, 50, true, '');</script></td>
				<th>Service Mode Dest</th>
				<td><script type="text/javascript">ComComboObject('dest_inlnd_svc_mod_cd', 2, 50, true, '');</script></td>
				<th>Country Origin</th>
				<td><input type="text" name="org_cnt" id="org_cnt" dataformat="enguponly" maxlength="2" class="input" style="width:45px;" value=""></td>
				<th>Country Dest</th>
				<td><input type="text" name="dest_cnt"  id="dest_cnt" dataformat="enguponly" maxlength="2" class="input" style="width:45px;" value=""></td>
			</tr>
			<tr>
				<th>Report Kind</th>
				<td colspan="3"><script type="text/javascript">ComComboObject('rep_knd', 1, 180, true, '');</script></td>
				<th>Group By</th>
				<td colspan="3"><script type="text/javascript">ComComboObject('grp_by', 1, 220, true, '');</script></td>
				<th>Freight Term</th>
				<td>
					<select name="frt_term_cd"  id="frt_term_cd" style="width:85px;" class="input">
					<option value="" selected>All</option>
					<option value="P">Prepaid</option>
					<option value="C">Collect</option>
					</select>
				</td>
				<th class="sm">SVC Scope</th>
				<td class="sm">
					<div style="width: 150px;">
						<table>
							<tr>
								<td><input type="radio" name="ioc_cd" id="ioc_cd_all" value="" checked><label for="ioc_cd_all">All</label><!--
									--><input type="radio" name="ioc_cd" id="ioc_cd_ocean"value="O"><label for="ioc_cd_ocean">Ocean</label><!--
									--><input type="radio" name="ioc_cd" id="ioc_cd_ipc" value="I"><label for="ioc_cd_ipc">IPC</label>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->

</div>
<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" id="reportKind" >
		<div class="grid_option_left mar_btm_8">
			<table>
				<tbody>
					<tr>
						<td width="240"><div class="sm"><table><tr>
							<th width="100">Ranking Option</th>
							<td>
								 <input type="radio" id="r_option_v" name="r_option" value="V" checked><label for="r_option_v">Volume</label><!--
							  --><input type="radio" id="r_option_r" name="r_option" value="R"><label for="r_option_r">RPB</label>
							</td>
						</tr></table></div></td>
						<th width="40">From</th>
						<td width="90"><input type="text" name="op_from" id="op_from" dataformat="int" class="input" style="width:80px;" value=""></td>
						<th width="25">To</th>
						<td><input type="text" name="op_to" id="op_to" dataformat="int" class="input" style="width:80px;" value=""></td>
				</tbody>
			</table>	
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet6');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet7');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet8');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet9');</script>
	</div>
	<div class="opus_design_grid clear" id="reportKind" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet10');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>