<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0044.jsp
*@FileTitle  : Container Master Update 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
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
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%
	EesMst0044Event event     = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//error from server
	String strErrMsg          = "";						//error message
	int rowCount	          = 0;						//count of DB resultSET list
	String successFlag        = "";
	String codeList           = "";
	String pageRows           = "100";
	String strUsr_id		  = "";
	String strUsr_nm		  = "";
	String strUsr_off_cd      = "";
	Logger log                = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffHire");
	String cntr_no            = "";
	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id                 =	account.getUsr_id();
		strUsr_nm                 = account.getUsr_nm();
	    strUsr_off_cd             = account.getOfc_cd();
		event                     = (EesMst0044Event)request.getAttribute("Event");
		cntr_no                   = StringUtil.xssFilter((String)request.getParameter("cntr_no"));
		if (cntr_no == null) cntr_no ="";
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=OfficeCodeMgr.getOfficeCodeListToJS("000002", "LSE")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">

<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="head_cntr_tpsz_cd" id="head_cntr_tpsz_cd" value=""> 
<input type="hidden" name="cntr_tpsz_cd_h" id="cntr_tpsz_cd_h" value="">
<input type="hidden" name="vndr_abbr_nm_h" id="vndr_abbr_nm_h" value="">

<input type="hidden" name="lot_pln_yr" id="lot_pln_yr" value="">
<input type="hidden" name="lot_loc_cd" id="lot_loc_cd" value="">
<input type="hidden" name="lot_cntr_tpsz_cd" id="lot_cntr_tpsz_cd" value="">
<input type="hidden" name="lot_seq" id="lot_seq" value="">

<input type="hidden" name="lsr_cd" id="lsr_cd" value="">
<input type="hidden" name="lsr_nm" id="lsr_nm" value="">
<input type="hidden" name="usr_ofc_cd" id="usr_ofc_cd" value="<%= strUsr_off_cd %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<div class="location"><span id="navigation"></span></div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90px">
				<col width="155px">
				<col width="54px">
				<col width="110px">
				<col width="50px">
				<col width="185px">
				<col width="70px">
				<col width="180px">
				<col width="70px">
				<col width="210px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>CNTR No.</th>
					<td><input type="text" style="width: 80px; text-align:center; text-transform:uppercase; ime-mode:disabled;" required dataformat="engup" maxlength="10" onKeyPress="ComKeyOnlyAlphabet('uppernum');" name="cntr_no" id="cntr_no"  value="<%=cntr_no%>"><input type="text" style="width: 15px;" class="input2"  readOnly value="" dataformat="num" name="chk_dgt" id="chk_dgt"><input type="text" style="width: 50px;" class="input2"  readOnly value="" name="aciac_div_cd" id="aciac_div_cd" style="text-align:center"></td>
					<th>TP/SZ</th>
					<td><script type="text/javascript"> ComComboObject("cntr_tpsz_cd", 1, 80, 1, 0, 0, false); </script></td>
					<th>ISO Code</th>
					<td><input type="text" style="width: 60px;" class="input2"  readOnly value="" name="cntr_tpsz_iso_cd" id="cntr_tpsz_iso_cd" style="text-align:center"></td>
					<th>Material</th>
					<td><script type="text/javascript">ComComboObject('cntr_mtrl_cd',2,150,0,1,1);</script></td>
					<!--  <td><select style="width: 130px;" required name="cntr_mtrl_cd" id="cntr_mtrl_cd"><option value="" selected></option><option value="SS">Stainless Steel</option><option value="SU">Steel (Unspecified)</option><option value="AU">Aluminum</option></select></td>-->
					<th>Gross Weight</th>
                    <td><input type="text" style="width: 90px;" class="input"  value="" dataformat="float" pointcount="3" name="cntr_grs_wgt" id="cntr_grs_wgt" style="text-align:right" onblur="obj_focusout01()">KG<label></label><input type="text" style="width: 90px;" class="input2"  readOnly value="" name="cntr_grs_wgt_lbs" id="cntr_grs_wgt_lbs" dataformat="float" style="text-align:right">LBS</td></td>
					<td></td>
				</tr>
				
				<tr>
                    <th>Lease Term</th>
                    <td><input type="text" style="width: 80px;" class="input2"  readOnly value="" name="sub_lstm_cd"  id="sub_lstm_cd" style="text-align:center"></td>
                    <th>Owner Lease Term</th>
                    <td><input type="text" style="width: 80px;" class="input2"  readOnly value="" name="lstm_cd" id="lstm_cd" style="text-align:center"></td>
                    <th>Current</th>
                    <td><input type="text" style="width: 120px;" class="input2"  readOnly value="" name="cntr_use_co_cd" id="cntr_use_co_cd" style="text-align:center"></td>
                    <th>Ownership</th>
                    <td><input type="text" style="width: 150px;" class="input2"  readOnly value="" name="ownr_co_cd" id="ownr_co_cd" style="text-align:center"></td>
                    <th>Tare Weight</th>
                    <td><input type="text" style="width: 90px;" class="input"  value="" dataformat="float" pointcount="3" name="tare_wgt" id="tare_wgt" style="text-align:right" onblur="obj_focusout01()">KG<label></label><input type="text" style="width: 90px;" class="input2"  readOnly value="" name="tare_wgt_lbs" id="tare_wgt_lbs" dataformat="float" style="text-align:right">LBS</td>
                    <td></td>
                </tr>
                
                <tr>
                    <th>Manufacturer</th>
                    <td><script type="text/javascript">ComComboObject('vndr_abbr_nm',2,75,1,0,0,false);</script><input type="text" style="width:190px;" class="input2"  readOnly value="" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" style="text-align:left"></td>
                    <th>Manufacture Date</th>
                    <td><input type="text" style="width:80px;" class="input"  dataformat="ymd" name="mft_dt" id="mft_dt" style="text-align:center"><button type="button" class="calendar ir" name="cal_img" id="cal_img"></button></td>
                    <th>SPEC No.</th>
                    <td><input type="text" style="width: 120px" class="input1" value="" name="cntr_spec_no" id="cntr_spec_no" readonly style="text-align:center"><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget3" id="ComOpenPopupWithTarget3"></button></td>
                    <th>SPEC Classification</th>
                    <td><input type="text" style="width: 100px" class="input2" value="" name="cntr_spec_tp_cd" id="cntr_spec_tp_cd" readonly style="text-align:center"></td>
                    <th>Pay Load</th>
                    <td><input type="text" style="width: 90px;" class="input2"  readOnly value="" name="pay_load" id="pay_load" style="text-align:right">KG<label></label><input type="text" style="width: 90px;" class="input2"  readOnly value="" name="pay_load_lbs" id="pay_load_lbs" dataformat="float" style="text-align:right">LBS</td>
                    <td></td>               
                </tr>
                
                <tr>
                    <th>Unit Type</th>
                    <td><script type="text/javascript">ComComboObject('rf_tp_cd',1,270,1,0,0,false);</script></td>
                    <th>Humidity Control</th>
                    <td><script type="text/javascript">ComComboObject('rf_humid_ctrl_val_cd',1,110,1,0,0,false);</script></td>
                    <th>Compressor</th>
                    <td><input type="text" style="width: 120px;" class="input"  value="" readOnly name="rf_cmpr_ctnt" id="rf_cmpr_ctnt" style="text-align:center"></td>
                    <th></th>
                    <td style="font-weight: bold;"><input type="checkbox" class="trans" name="d2_payld_flg" id="d2_payld_flg" onClick="return false" style="display:none;"> <label style="display:none;">D2 H/P</label></td>
                </tr> 
			</tbody>
		</table>
		
		
	</div>
	<!-- opus_design_inquiry(E) -->
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>	
</div>
</form>