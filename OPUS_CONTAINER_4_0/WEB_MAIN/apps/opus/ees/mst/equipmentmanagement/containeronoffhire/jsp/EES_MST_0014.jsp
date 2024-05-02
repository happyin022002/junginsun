<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0014.jsp
*@FileTitle  : Leased Container 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
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
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffHire");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="hidden_curdate" name="hidden_curdate" type="hidden" />
<input id="hid_old_new" name="hid_old_new" type="hidden" />
<input id="hid_tp_sz" name="hid_tp_sz" type="hidden" />
<input id="hid_app_vol" name="hid_app_vol" type="hidden" />
<input id="hid_pick_vol" name="hid_pick_vol" type="hidden" />
<input id="hid_pick_date" name="hid_pick_date" type="hidden" />
<input id="hid_min_onh_dys" name="hid_min_onh_dys" type="hidden" />
<input id="hid_pkup_chg_cr_amt" name="hid_pkup_chg_cr_amt" type="hidden" />
<input id="hid_pkup_chg_amt" name="hid_pkup_chg_amt" type="hidden" />
<input id="hid_lift_on_chrg" name="hid_lift_on_chrg" type="hidden" />
<input id="hid_free_dys" name="hid_free_dys" type="hidden" />
<input id="hid_cntr_spec_no" name="hid_cntr_spec_no" type="hidden" />
<input id="approval_no_h" name="approval_no_h" type="hidden" />
<input id="eff_dt" name="eff_dt" type="hidden" />
<input id="exp_dt" name="exp_dt" type="hidden" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
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
			<tr>
				<th>Creation Type</th>
				<td><select style="width: 130px;" class="input1" name="ctype" id="ctype"><option value="0" selected>General</option><option value="1">W/O Check Digit</option><option value="2">Serial Range</option></select></td>
				<th>On-hire Date</th>
				<td><input type="text" style="width: 75px" dataformat="ymd" class="input1" value="" name="hire_date0" id="hire_date0" style="text-align:center"><button type="button" class="calendar ir" name="cal_img" id="cal_img"></button><!--
                    --><input type="text" style="width:50px;ime-mode:disabled" maxlength="4" class="input1" tabindex="5" id="p_time" name="p_time" dataformat="hm"><!--
                    --><input type="hidden" style="width:112px;ime-mode:disabled" maxlength="16" class="input1" id="hire_date" name="hire_date"></td>
				<th>On-hire Yard</th>
				<td colspan="3"><input type="text" style="width: 75px" class="input1" value="" dataformat="engup" name="sts_evnt_yd_cd" id="sts_evnt_yd_cd"  maxlength="7" style="ime-mode:disabled"><button type="button" class="input_seach_btn" name="ComOpenPopupWithTargetYard" id="ComOpenPopupWithTargetYard"></button><input type="text" style="width: 225px" class="input2" ReadOnly value="" name="yd_cd_nm" id="yd_cd_nm" style="ime-mode:disabled"></td>
			</tr>
			<tr>
				<th>AGMT No.</th>
				<td><input type="text" style="width: 35px;" class="input1" dataformat="engup" name="agmt_cty_cd" id="agmt_cty_cd" maxlength="3" value="HHO" readonly><input type="text" style="width: 81px;text-align:right" class="input1" dataformat="num" name="agmt_seq" id="agmt_seq" style="ime-mode:disabled" maxlength="6"><button type="button" class="input_seach_btn" name="ComOpenPopupWithTargetAgmtNo" id="ComOpenPopupWithTargetAgmtNo"></button></td>
				<th>Lease Term</th>
				<td><input type="text" style="width: 75px;text-align:center;" class="input2" dataformat="engup" value="" ReadOnly name="lstm_cd" id="lstm_cd" maxlength="2"></td>
				<th>Contract No.</th>
				<td colspan="3"><input type="text" style="width: 150px" class="input2" dataformat="engup" value="" ReadOnly name="ref_no" id="ref_no" maxlength="12"></td>
			</tr>
			<tr>
				<th>Lessor</th>
				<td colspan="7"><input type="text" style="width: 65px" class="input2"  value="" name="vndr_seq" id="vndr_seq" dataformat="engup" ReadOnly maxlength="6" caption="Lessor"><input type="text" style="width: 240px" class="input2" value="" name="vndr_nm" id="vndr_nm" readonly caption="Lessor"></td>
			</tr>
			<tr>
				<th width="40">Auth No.</th>
				<td width="120"><script type="text/javascript">ComComboObject('approval_no', 16, 145, 1);</script></td>
				<th width="40">Auth Vol.</th>
				<td width="120"><input type="text" style="width:73px" class="input2" dataformat="engup" value="" ReadOnly name="approval_vol" id="approval_vol"></td>
				<th width="50">Pick up Vol.</th>
				<td width="100"><input type="text" style="width:75px;" class="input2" dataformat="engup" value="" ReadOnly name="pick_up_vol" id="pick_up_vol"></td>
				<th width="40">Pick up Period</th>
				<td><input type="text" style="width: 75px;text-align:center;" class="input2" dataformat="" value="" ReadOnly name="pkup_fm_dt" id="pkup_fm_dt">~&nbsp;<!--
				--><input type="text" style="width: 75px;text-align:center;" class="input2" dataformat="" value="" ReadOnly name="pick_up_due_date" id="pick_up_due_date"></td>
			</tr>
			<tr>
				<th>CNTR Serial Range</th>
				<td colspan="3"><!--
				 --><input type="text" style="width: 55px" class="input2" dataformat="engup" maxlength="4" name="cntr_no0" id="cntr_no0"><!-- 
				 --><input type="text" style="width: 80px" class="input2" dataformat="engup" maxlength="6" name="cntr_no1" id="cntr_no1"><!-- 
				 --><input type="text" style="width: 80px" class="input2" dataformat="engup" maxlength = "6" name="cntr_no2" id="cntr_no2"><!-- 
				 --><input type="text" style="width: 82px" class="input2" ReadOnly name="cntr_no3" id="cntr_no3"></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_master" id="btn_master">Master</button>
			<button type="button" class="btn_normal mar_rgt_4" name="btn_add" id="btn_add">Row Add</button>
			<input type="text" style="width:55px" class="floatL" dataformat="num" value="1" maxlength="4" name="mk_cnt">
			<button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Row Copy</button>
			<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
			<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div style="display: none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>