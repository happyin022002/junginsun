<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1008.jsp
*@FileTitle  : Chassis On-Hire Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1008Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EesCgm1008Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	String form_day         = "";
	String form_hs          = "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		form_day  = DateTime.getDateString().replace(".","-");  
		form_hs   = DateTime.getShortTimeString();
		form_hs   = form_hs.substring(0,2) + ":" + form_hs.substring(2,4);
		event = (EesCgm1008Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="cre_id" name="cre_id" value="<%=strUsr_id %>" type="hidden" />
<input id="form_day" name="form_day" value="<%=form_day %>" type="hidden" />
<input id="eq_knd_cd" class="input2" style="width:40px;text-align:center" name="eq_knd_cd" value="Z" type="hidden" />
<input id="vndr_seq" class="input2" style="width:80px;text-align:center" name="vndr_seq" type="hidden" />
<input id="agmt_no" class="input2" style="width:80px;text-align:center" name="agmt_no" type="hidden" />
<input id="eq_no" class="input2" style="width:80px;text-align:center" name="eq_no" type="hidden" />
<input id="chss_veh_id_no_tmp" class="input2" style="width:80px;text-align:center" name="chss_veh_id_no_tmp" type="hidden" />
<input id="chss_tit_no_tmp" class="input2" style="width:80px;text-align:center" name="chss_tit_no_tmp" type="hidden" />
<input id="chss_als_no_tmp" class="input2" style="width:80px;text-align:center" name="chss_als_no_tmp" type="hidden" />
<input id="n2nd_chss_als_no_tmp" class="input2" style="width:80px;text-align:center" name="n2nd_chss_als_no_tmp" type="hidden" />
<input id="own_lse" class="input2" style="width:50px;text-align:center" name="own_lse" value="O" type="hidden" />
<input id="ofc_cd" name="ofc_cd" type="hidden" />
<input id="yd_cd" name="yd_cd" type="hidden" />
<input id="agmt_ver_no" name="agmt_ver_no" type="hidden" />
<input id="loc_cd" name="loc_cd" type="hidden" />

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
		<button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_verify" id="btn_verify">Verify</button>
		<button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">On-Hire Confirm</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
			<colgroup>
					<col width="125px"/>
					<col width="70px"/>
					<col width="119px"/>
					<col width="70px"/>
					<col width="221px"/>
					<col width="70px"/>
					<col width="180px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th class="sm"> <input id="ownleas" class="trans" name="ownleas" onclick="chk('O')" value="O" checked="" type="radio" />OWN<label></label><input id="ownleas" class="trans" name="ownleas" onclick="chk('L')" value="L" type="radio" />Leased</th>
					<th>Office</th>
					<td><input id="onh_ofc_cd" style="width: 55px; ime-mode:disabled" class="input1" dataformat="engup" maxlength="6" name="onh_ofc_cd" type="text" /><button class="input_seach_btn" name="ComOpenPopupWithTargetOffice" id="ComOpenPopupWithTargetOffice" type="button"></button></td>
					<th>On-hire Date</th>
					<td><input id="onh_dt" style="width: 80px; ime-mode: disabled" class="input1" name="onh_dt" dataformat="ymd" maxlength="10" type="text" /><button class="calendar ir" name="btn_Calendar_a" id="btn_Calendar_a" type="button"></button><input id="onh_dt_hm" style="width: 50px; text-align: center; ime-mode:disabled" class="input1" name="onh_dt_hm" dataformat="hm" maxlength="4" value="00:00" type="text" /></td>
					<th>On-hire Yard</th>
					<td><input type="text" style="width: 70px; ime-mode:disabled" class="input1" dataformat="engup" maxlength="7" name="onh_yd_cd" id="onh_yd_cd" ><button type="button" class="input_seach_btn" name="ComOpenPopupWithTargetYard" id="ComOpenPopupWithTargetYard"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
			<colgroup>
					<col width="100px"/>
					<col width="120px"/>
					<col width="86px"/>
					<col width="70px"/>
					<col width="229px"/>
					<col width="70px"/>
					<col width="180px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Agreement No.</th>
					<td><input id="agreement_no" style="width: 80px; ime-mode:disabled" class="input1" dataformat="engup" maxlength="10" name="agreement_no" type="text" /><button class="input_seach_btn" name="ComOpenPopupWithTargetAgree" id="ComOpenPopupWithTargetAgree" type="button"></button></td>
					<th></th>
					<th>Reference No.</th>
					<td><input id="agmt_ref_no" style="width: 162px;" class="input2" readonly="" name="agmt_ref_no" type="text" /></td>
					<th>Lease Term</th>
					<td><input id="agmt_lstm_cd" style="width: 40px;" class="input2" readonly="" name="agmt_lstm_cd" type="text" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
			<colgroup>
					<col width="100px"/>
					<col width="460px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Lessor</th>
					<td><input id="vndr_lgl_eng_nm" style="width: 455px;" class="input2" readonly="" name="vndr_lgl_eng_nm" type="text" /></td>
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
            <div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_rowadd" id="btn_rowadd">Row Add</button>
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
					<button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Load Excel</button>
					<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
<!-- opus_design_grid(E) -->
</div>
</form>