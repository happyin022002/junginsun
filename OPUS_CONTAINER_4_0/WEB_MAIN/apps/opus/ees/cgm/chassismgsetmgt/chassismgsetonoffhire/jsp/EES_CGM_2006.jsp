<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2006.jsp
*@FileTitle  : M.G.Set Master Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2006Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EesCgm2006Event event     = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount     = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log       = Logger .getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesCgm2006Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
	String eqNo = StringUtil.xssFilter(request.getParameter("eq_no"));
	if(eqNo == null) eqNo = "";
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="eq_knd_cd" name="eq_knd_cd" value="G" calss="input1" type="hidden" />
<input id="master_save_flag" name="master_save_flag" type="hidden" />
<input id="org_atch_dt" name="org_atch_dt" type="hidden" />
<input id="org_atch_yd_cd" name="org_atch_yd_cd" type="hidden" />
<input id="org_dtch_dt" name="org_dtch_dt" type="hidden" />
<input id="org_dtch_yd_cd" name="org_dtch_yd_cd" type="hidden" />
<input id="yd_cd" name="yd_cd" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_new" name="btn_new" class="btn_normal">New</button><!--
		--><button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button><!--
		--><button type="button" id="btn_mgstmvmt" name="btn_mgstmvmt" class="btn_normal">MGST MVMT</button><!--
		--><button type="button" id="btn_chssmvmt" name="btn_chssmvmt" class="btn_normal">CHSS MVMT</button><!--
		--><button type="button" id="btn_status" name="btn_status" class="btn_normal">Status</button><!--
		--><button type="button" id="btn_mnr" name="btn_mnr" class="btn_normal">M&R</button><!--
	--></div>
<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->



<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="55px" />
					<col width="55px" />
					<col width="150px" />
					<col width="50px" />
					<col width="198px" />
					<col width="50px" />
					<col width="250px" />
					<col width="50px" />
					<col width="150px" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>M.G. Set No.</th>
					<td><input id="eq_no" style="ime-mode:disabled; width: 100px; text-align:center;" class="input1" name="eq_no" value="<%=eqNo %>" maxlength="10" dataformat="engup" type="text" /> </td>
					<th>Type</th>
					<td><input id="eq_tpsz_cd" name="eq_tpsz_cd" style="width: 70px; text-align:center;" class="input2" readonly type="text" /> </td>
					<th>Manufactured Date</th>
					<td><input id="mft_dt" name="mft_dt" style="width: 80px; ime-mode:disabled; text-align:center;" dataformat="ymd" onfocus="domFunFocusDel(this)" class="input" maxlength="8" type="text" /><button class="calendar ir" name="btn_Calendar_a" id="btn_Calendar_a" type="button"></button></td>
					<th>Warranty Date</th>
					<td><input id="mgst_warr_end_dt" name="mgst_warr_end_dt" style="width: 80px; ime-mode:disabled; text-align:center;" dataformat="ymd" onfocus="domFunFocusDel(this)" class="input" maxlength="8" type="text" /><button class="calendar ir" name="btn_Calendar_b" id="btn_Calendar_b" type="button"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="20px" />
					<col width="50px" />
					<col width="428px" />
					<col width="50px" />
					<col width="228px" />
					<col width="50px" />
					<col width="150px" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Model No.</th>
					<td><input id="eq_spec_no" name="eq_spec_no" style="width: 270px; text-align:center;" class="input2" readonly type="text" /> </td>
					<th>Voltage</th>
					<td><input id="mgst_vltg_capa" name="mgst_vltg_capa" style="width: 80px; text-align:Right;" class="input2" readonly type="text" />   volt</td>
					<th>Fuel Capacity</th>
					<td><input id="mgst_fuel_capa" name="mgst_fuel_capa" style="width: 80px; text-align:Right;" class="input2" readonly type="text" />   ltrs</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Machine Serial No.</th>
					<td><input id="mgst_mchn_ser_no" style="width: 270px; text-align:center;" class="input" name="mgst_mchn_ser_no" maxlength="15" dataformat="engup" type="text" /> </td>
					<th>Current Hours</th>
					<td><input id="mgst_run_hrs" name="mgst_run_hrs" style="width: 80px; text-align:right; ime-mode:disabled" class="input" dataformat="num" maxlength="4" type="text" />   hours</td>
					<th>Last Updated Date</th>
					<td><input id="mgst_run_hrs_upd_dt" name="mgst_run_hrs_upd_dt" style="width: 130px; text-align:center;" class="input2" readonly type="text" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table class="line_bluedot"><tr><td colspan="5"></td></tr></table>
		<h3 class="title_design">On-Hire Status</h3>
		
		<table>
			<tbody>
				<colgroup>
					<col width="80px" />
					<col width="54px" />
					<col width="150px" />
					<col width="50px" />
					<col width="238px" />
					<col width="50px" />
					<col width="252px" />
					<col width="50px" />
					<col width="150px" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Status</th>
					<td><input id="aciac_div_cd" name="aciac_div_cd" style="width:100px;text-align:center;color:red;" class="input2" readonly type="text" /> </td>
					<th>Yard</th>
					<td><input id="crnt_yd_cd" name="crnt_yd_cd" style="width:70px;text-align:center;" class="input2" readonly type="text" /> </td>
					<th>On-hire Date</th>
					<td><input id="onh_dt" name="onh_dt" style="width:80px;text-align:center;" class="input2" readonly type="text" /> </td>
					<th>On-hire Office</th>
					<td><input id="onh_ofc_cd" name="onh_ofc_cd" style="width:80px;text-align:center;" class="input2" readonly type="text" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="41px" />
					<col width="50px" />
					<col width="150px" />
					<col width="50px" />
					<col width="264px" />
					<col width="54px" />
					<col width="500px" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Agreement No.</th>
					<td><input id="agreement_no" name="agreement_no" style="width:100px;text-align:center;" class="input2" readonly type="text" /> </td>
					<th>Term</th>
					<td><input id="agmt_lstm_cd" name="agmt_lstm_cd" style="width:70px;text-align:center;color:blue;" class="input2" readonly type="text" /> </td>
					<th>Lessor</th>
					<td><input id="vndr_lgl_eng_nm" name="vndr_lgl_eng_nm" style="width: 419px;" class="input2" readonly type="text" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="48px" />
					<col width="52px" />
					<col width="120px" />
					<col width="10px" />
					<col width="335px" />
					<col width="53px" />
					<col width="300px" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Reference No.</th>
					<td><input id="agmt_ref_no" name="agmt_ref_no" style="width:100px;text-align:center;" class="input2" readonly type="text" /> </td>
					<th></th>
					<td></td>
					<th></th>
					<td class="sm">
						<input id="cntr_chk" value="" class="trans" name="cntr_chk" type="checkbox" />  <strong>CNTR</strong><label></label><input id="atch_cntr" name="atch_cntr" style="width:90px;text-align:center;" class="input2" readonly="" type="text" />
						<label></label><label></label>
						<input id="chs_chk" value="" class="trans" name="chs_chk" type="checkbox" />  <strong>Chassis</strong><label></label><input id="atch_chs" name="atch_chs" style="width:90px;text-align:center;" class="input2" readonly="" type="text" />
						<label></label><label></label>
						<input id="bare_chk" value="" class="trans" name="bare_chk" type="checkbox" />  <strong>Bare</strong>
						<label></label>
						<input id="damage_chk" value="" class="trans" name="damage_chk" type="checkbox" />  <strong>Damage</strong>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<div class="opus_design_grid wFit"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
		
		<table>
			<tbody>
				<colgroup>
					<col width="53px" />
					<col width="50px" />
					<col width="150px" />
					<col width="220px" />
					<col width="50px" />
					<col width="150px" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Created Date</th>
					<td><input id="cre_dt" name="cre_dt" style="width:80px;text-align:center;" class="input2" readonly type="text" /> By <input id="cre_usr_id" name="cre_usr_id" style="width:100px;text-align:center;" class="input2" readonly type="text" /></td>
					<td></td>
					<th>Updated Date</th>
					<td><input id="upd_dt" name="upd_dt" style="width:80px;text-align:center;" class="input2" readonly type="text" /> By <input id="upd_usr_id" name="upd_usr_id" style="width:100px;text-align:center;" class="input2" readonly type="text" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
        	<h3 class="title_design">M.G.Set Attach/Detach History</h3>
            <div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_delgrid" id="btn_delgrid">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
<!-- opus_design_grid(E) --> 

<!-- opus_design_grid(S) -->
        <div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
<!-- opus_design_grid(E) -->         
</div>
</form>