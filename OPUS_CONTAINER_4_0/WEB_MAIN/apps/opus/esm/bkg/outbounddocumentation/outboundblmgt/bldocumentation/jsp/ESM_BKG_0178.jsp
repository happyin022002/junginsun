<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0178.jsp
*@FileTitle  : C/M by Container 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
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
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0178Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0178Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //error from server
    String strErrMsg = "";                        //error message
    int rowCount     = 0;                        //count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");
	String cntrNo = "";
	String cntrTpCd = "";
	String tVvd = "";
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EsmBkg0178Event)request.getAttribute("Event");
		cntrNo = event.getCntrNo();
		tVvd   = event.getTVvd();
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // getting data from server when load the initial screen
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
        
        $('<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_cntrlist"	id="btn_cntrlist">CNTR List</button>').appendTo("#btnArea");
        
        $('#btn_cntrlist').after($('#btn_Close'));
        
        document.getElementById("title").innerHTML = "C/M by Container";
        
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="bkg_no" id="bkg_no">
<input type="hidden" name="bdr_flg" id="bdr_flg">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<tr>
				<th width="60">Container No.</th>
				<td width="60"><input type="text" name="cntr_no" id="cntr_no" value="<%=cntrNo%>" style="ime-mode:disabled; width: 105px;" dataformat="engup" class="input1"><input type="text" name="cntr_tpsz_cd" id="cntr_tpsz_cd" value="<%=cntrTpCd%>" style="ime-mode:disabled; width: 30px;" dataformat="engup" class="input2" readOnly></td>
				<th width="60">Seal No.</th>
				<td width="60"><select name="cntr_seal_no" id="cntr_seal_no" style="width: 100px;" class="input2"></select></td>
				<th width="60">T/VVD</th>
				<td width="130"><input type="text" name="t_vvd" id="t_vvd" value="<%=tVvd%>" style="ime-mode:disabled; width: 80px;" dataformat="engup" class="input1"></td>
				<th width="67">BKG Office</th>
				<td><input type="text" name="bkg_ofc_cd" id="bkg_ofc_cd" style="ime-mode:disabled; width: 50px;" dataformat="engupnum" class="input2" readOnly ></td>
			</tr>
			<tr>
				<th>Route</th>
				<td><input type="text" name="por_cd" id="por_cd" style="ime-mode:disabled; width: 50px;" dataformat="engupnum" class="input2" readOnly><input type="text" name="pol_cd" id="pol_cd" style="ime-mode:disabled; width: 50px;" dataformat="engupnum" class="input2" readOnly><input type="text" name="pod_cd" id="pod_cd"  style="ime-mode:disabled; width: 50px;" dataformat="engupnum" class="input2" readOnly><input type="text" name="del_cd" id="del_cd" style="ime-mode:disabled; width: 50px;" dataformat="engupnum" class="input2" readOnly></td>
				<th>R/D Term</th>
				<td><input type="text" name="rcv_term_cd" id="rcv_term_cd" style="ime-mode:disabled; width: 20px;" dataformat="engupnum" class="input2" readOnly><input type="text" name="de_term_cd" id="de_term_cd" style="ime-mode:disabled; width: 20px;" dataformat="engupnum" class="input2" readOnly></td>
				<th>Ahead / Short-ship</th>
				<td><input type="text" name="adv_shtg_cd" id="adv_shtg_cd"  style="ime-mode:disabled; width: 35px;" dataformat="engupnum" class="input2" readOnly></td>
				<td colspan="2">
					<label for="dcgo_flg">DG</label><input type="checkbox" name="dcgo_flg" id="dcgo_flg">
					<label for="bb_cgo_flg">BB</label><input type="checkbox" name="bb_cgo_flg" id="bb_cgo_flg">
					<label for="awk_cgo_flg">AK</label><input type="checkbox" name="awk_cgo_flg" id="awk_cgo_flg">
					<label for="rc_flg">RF</label><input type="checkbox" name="rc_flg" id="rc_flg">
					<label for="rd_cgo_flg">RD</label><input type="checkbox" name="rd_cgo_flg" id="rd_cgo_flg">
					<label for="hngr_flg">HG</label><input type="checkbox" name="hngr_flg" id="hngr_flg">
				</td>
			</tr>
			<tr>
				<th>Package</th>
				<td><input type="text" name="pck_qty" id="pck_qty"  style="width: 80px;text-align:right" class="input2" readOnly dataformat="int" maxlength="7"><input type="text" name="pck_tp_cd" id="pck_tp_cd" style="ime-mode:disabled; width: 35px;" dataformat="engup" maxlength="2" class="input2" readOnly></td>
				<th>Weight</th>
				<td><input type="text" name="cntr_wgt" id="cntr_wgt" style="width: 80px;text-align:right" class="input2" readOnly dataformat="float" maxlength="13" pointcount="3"><input type="text" name="wgt_ut_cd" id="wgt_ut_cd" style="ime-mode:disabled; width: 35px;" dataformat="engupnum" class="input2" readOnly></td>
				<th>Measure</th>
				<td colspan="2"><input type="text" name="meas_qty" id="meas_qty" style="width: 80px;text-align:right" class="input2" readOnly dataformat="float" maxlength="9" pointcount="3"><input type="text" name="meas_ut_cd" id="meas_ut_cd" style="ime-mode:disabled; width: 35px;" dataformat="engupnum"  class="input2" readOnly></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button>
		<button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
	</div>	
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	
	<table class="grid_option_right grid2 noinput2" style="width:600px">
		<tbody>
			<tr>
				<th width="120">Total Package</th>
				<td><input name="cm_pck_qty" id="cm_pck_qty" type="text" style="width: 90px; text-align:right" class="input2" readOnly dataformat="int" maxlength="7"></td>
				<th width="120">Total Weight</th>
				<td><input name="cm_cntr_wgt" id="cm_cntr_wgt" type="text" style="width: 90px; text-align:right" class="input2" readOnly dataformat="float" maxlength="13" pointcount="3"></td>
				<th width="120">Total Measure</th>
				<td><input name="cm_meas_qty" id="cm_meas_qty" type="text" style="width: 90px; text-align:right" class="input2" readOnly dataformat="float" maxlength="9" pointcount="3"></td>
			</tr>
		</tbody>
	</table>
</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
<!-- opus_design_data(E) -->
</form>
<form name="form2" id="form2">
<input type="hidden" name="func" id="func">
<input type="hidden" name="mk_desc" id="mk_desc">
<input type="hidden" name="gds_desc" id="gds_desc">
</form>