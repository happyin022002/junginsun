<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1124.js
*@FileTitle  : Europe Advanced Manifest : B/L Inquiry - customer Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1124Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%	EsmBkg1124Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strCnt_cd   = "";
    String strOfc_cd   = "";
	String strPgmNo     = "";
	String strBlNo      = "";
	String strTransMode = "";       
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.Customstransmission");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
        strOfc_cd = account.getOfc_cd();
		event = (EsmBkg1124Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strBlNo = JSPUtil.getNull(request.getParameter("bl_no"));
        strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
        codeList = HttpUtil.makeXML(request,response);
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		//showErrMessage(errMessage);
	} // end if
	
	$('<button type="button" class="btn_accent" name="btn_Retrieve"		id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button>').appendTo("#btnArea");		
    $('<button type="button" class="btn_normal" name="btn_Save"  		id="btn_Save">Save</button>').appendTo("#btnArea");		
    $('<button type="button" class="btn_normal" name="btn_Transmit"  	id="btn_Transmit">Transmit Manifest</button>').appendTo("#btnArea");		
			
	loadPage();
	
	$('#btn_Transmit').after($('#btn_Close'));
    
}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cstms_port_cd" id="cstms_port_cd" />
<input type="hidden" name="code_list" value="<%=codeList%>" id="code_list" />
<input type="hidden" name="cust_type" id="cust_type" />
<input type="hidden" name="mk_desc" id="mk_desc" />
<input type="hidden" name="gds_desc" id="gds_desc" />
<input type="hidden" name="func" id="func" />
<input type="hidden" name="cn_flg" value="Y" id="cn_flg" />
<input type="hidden" name="eur_flg" value="Y" id="eur_flg" />
<input type="hidden" name="s_ibflag" id="s_ibflag" />
<input type="hidden" name="f_ibflag" id="f_ibflag" />
<input type="hidden" name="n_ibflag" id="n_ibflag" />
<input type="hidden" name="c_ibflag" id="c_ibflag" />
<input type="hidden" name="cstms_yd_cd" id="cstms_yd_cd" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="kts_send_dt" id="kts_send_dt" />
<input type="hidden" name="search_prev_doc_no" value="" id="search_prev_doc_no" />
<input type="hidden" name="ack_cd" value="" id="ack_cd" />
<input type="hidden" name="his_ack_cd" value="" id="his_ack_cd" />

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>

<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<colgroup>
			<col width="80">
			<col width="150">
			<col width="80">
			<col width="150">
			<col width="50">
			<col width="80">
			<col width="110">
			<col width="120">
			<col width="*">
	    </colgroup>
	    <tbody>
			<tr>
				<th>B/L No.</th>
				<td><input type="text" name="bl_no" id="bl_no" style="width:110px; ime-mode: disabled;" class="input1" value="<%=strBlNo%>" dataformat="engup" maxlength="12" <%="".equals(strBlNo) ? "required" : "readonly"%> caption="B/L No."></td>
                <th>Type</th>
				<td><select name="type_cd" id="type_cd" style="width:80px;" class="input2" disabled=true><option value="O" selected>Export</option></select></td>
				<th>Status</th>
				<td id='msg_func_id_field'><input type="text" name="msg_func_id" id="msg_func_id" style="width:100px;" class="input2" readonly></td>
			    <td id='msg_func_hold_field'><select name="msg_func_hold" id="msg_func_hold" style="width:100px;"></select></td>
				<td><input type="text" name="local_time" id="local_time" style="width:110px;" class="input2" readonly></td>
				<th>MRN</th>
				<td><input type="text" name="mvmt_ref_no" id="mvmt_ref_no" style="width:150px;" class="input2" readonly></td>
			</tr>
		</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	    <table>
		<colgroup>
			<col width="80">
			<col width="150">
			<col width="100">
			<col width="220">
			<col width="120">
			<col width="*">
	    </colgroup>
	    <tbody>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><script type="text/javascript">ComComboObject('vvd', 2, 110, 0, 0,0);</script></td>
				<th>Vessel Name</th>
				<td><input type="text" name="vsl_eng_nm" id="vsl_eng_nm" style="width:200px;" class="input2" readonly></td>
				<th>IMO(Lloyd) Code</th>
				<td><input type="text" name="lloyd_no" id="lloyd_no" style="width:80px;" class="input2" readonly></td>
			</tr>
		</tbody>
		</table>
	    <table>
			<colgroup>
				<col width="80">
				<col width="70">
				<col width="55">
				<col width="70">
				<col width="55">
				<col width="70">
				<col width="55">
				<col width="70">
				<col width="100">
				<col width="*">
		    </colgroup>
		    <tbody>
			<tr>
				<th title="Place of Receipt">POR</th>
				<td><input type="text" name="por_cd" id="por_cd" style="width:60px;" class="input" maxlength="5" dataformat="engup"></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="bkg_pol_cd" id="bkg_pol_cd" style="width:60px;" class="input" maxlength="5" dataformat="engup"></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" name="bkg_pod_cd" id="bkg_pod_cd" style="width:60px;" class="input" maxlength="5" dataformat="engup"></td>
				<th title="Place of Delivery">DEL</th>
				<td><input type="text" name="del_cd" id="del_cd" style="width:60px;" class="input" maxlength="5" dataformat="engup"></td>
				<th>R/D Term</th>
				<td><input type="text" name="rcv_term_cd" id="rcv_term_cd" style="width:25px;" class="input2" readonly>/ <input type="text" name="de_term_cd" id="de_term_cd" style="width:25px;" class="input2" readonly></td>
			</tr>
		</tbody>
		</table>
	    <table>
			<colgroup>
				<col width="80">
				<col width="200">
				<col width="50">
				<col width="240">
				<col width="50">
				<col width="*">
		    </colgroup>
			<tbody>
			<tr>
				<th>Package</th>
				<td><input type="text" name="pck_qty" id="pck_qty" style="width:105px; text-align:right;" class="input" dataformat="float" maxlength="15" caption="Package"><input type="text" name="pck_tp_cd" id="pck_tp_cd" style="width:35px;" class="input" dataformat="engup"></td>
				<th>Weight</th>
				<td><input type="text" name="act_wgt" id="act_wgt" style="width:100px; text-align:right;" class="input" dataformat="float" maxlength="23" caption="Weight"><select name="wgt_ut_cd" id="wgt_ut_cd" style="width:80px;"><option value="KGS" selected>KGS</option><option value="LBS">LBS</option></select></td>
				<th>Measure</th>
				<td><input type="text" name="meas_qty" id="meas_qty" style="width:100px; text-align:right;" class="input" dataformat="float" maxlength="15" caption="Measure"><select name="meas_ut_cd" id="meas_ut_cd" style="width:80px;"><option value="CBM" selected>CBM</option><option value="CBF">CBF</option></select></td>	
			</tr>
		</tbody>
		</table>
	    <table>
			<colgroup>
				<col width="80">
				<col width="475">
				<col width="70">
				<col width="*">
		    </colgroup>
		    <tbody>
			<tr>
				<th>Cargo Desc.</th>
				<td><input type="text" name="cstms_desc" id="cstms_desc" style="width:450px;" class="input" dataformat="engupetc"></td>	
				<th>Prev. Doc</th>
				<td><input type="text" name="prev_doc_no" id="prev_doc_no" style="width:170px;" class="input2" Readonly><input type="text" name="prev_doc_yd" id="prev_doc_yd" style="width:90px;" class="input2" Readonly><button type="button" class="input_seach_btn" name="btn_prevDoc_pop" id="btn_prevDoc_pop"></button></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid" id="mainTable" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div name="tabLayer" id="tabLayer" style="display:inline;">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2"  style="width:49%;">
		        <div class="opus_design_inquiry sm pad_8">
		            <table>
							<colgroup>
								<col width="80">
								<col width="200">
								<col width="50">
								<col width="130">
								<col width="50">
								<col width="*">
						    </colgroup>
							<tbody>
							<tr>
								<th>Shipper</th>
								<td colspan="5"><input type="text" style="width:30px;" class="input" name="s_cust_cnt_cd" id="s_cust_cnt_cd" maxlength="2" required fullfill dataformat="engup" caption="Shipper Country Code"><!-- 
									 --><input type="text" style="width:60px;text-align:right;" class="input" name="s_cust_seq" id="s_cust_seq" maxlength="6" dataformat="engup" caption="Shipper Sequence"><!-- 
									 --><button name="pop_shipper" id="pop_shipper" type="button" class="btn_down_list"></button>
								</td>
							</tr>
							<tr>
								<th>Name</th>
								<td colspan="5"><textarea rows="2" name="s_cust_nm" id="s_cust_nm" maxlength="500" dataformat="engupetc" caption="Shipper Name" 	style="width:50%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr>
								<th>Address</th>
								<td colspan="5"><textarea rows="3" name="s_cust_addr" id="s_cust_addr" maxlength="350" dataformat="engupetc" caption="Shipper Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr>
						 		<th>City</th>
								<td><input type="text" style="width:135px;" class="input" name="s_cust_cty_nm" id="s_cust_cty_nm" maxlength="500" dataformat="engupetc" caption="Shipper City"></td>
						 		<th>Country</th>
								<td><input type="text" style="width:30px;" class="input" name="s_cstms_decl_cnt_cd" id="s_cstms_decl_cnt_cd" maxlength="2" dataformat="engup" caption="Shipper Country"></td>
						 		<th>Zip</th>
								<td><input type="text" style="width:87px;" class="input" name="s_cust_zip_id" id="s_cust_zip_id" maxlength="10" dataformat="engupetc" caption="Shipper Zip"></td>
							</tr>
							<tr>
								<th>Street</th>
								<td>
									<input type="text" name="s_eur_cstms_st_nm" id="s_eur_cstms_st_nm" dataformat="engupetc" style="width:150px;" maxlength="50" class="input" style="ime-mode:disabled">
								</td>
						 		<th>EORI#</th>
								<td colspan=5><input type="text" name="s_eori_no" id="s_eori_no" dataformat="engupetc" style="width:100px;" maxlength="20" class="input" style="ime-mode:disabled"><!-- 
									 --><input type="hidden" name="s_eori_no_ori" id="s_eori_no_ori" dataformat="engupetc" style="width:100px;" maxlength="20" class="input" style="ime-mode:disabled">
								</td>
							</tr>
						</tbody>
					</table>
					</div>
					<div class="opus_design_inquiry sm pad_8 mar_top_12">
		            <table>
						<tbody>
							<colgroup>
								<col width="80">
								<col width="200">
								<col width="50">
								<col width="130">
								<col width="50">
								<col width="*">
						    </colgroup>
							<tr>
								<th>Consignee</th>
								<td colspan="5"><input type="text" style="width:30px;" class="input" name="c_cust_cnt_cd" id="c_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Consignee Country Code"><!-- 
									 --><input type="text" style="width:60px;text-align:right;" class="input"  name="c_cust_seq" id="c_cust_seq" maxlength="6" dataformat="engup" caption="Consignee Sequence"><!-- 
									 --><button name="pop_consignee" id="pop_consignee" type="button" class="btn_down_list"></button>
								</td>
							</tr>
							<tr>
								<th>Name</th>
								<td colspan="5"><textarea rows="2" name="c_cust_nm" id="c_cust_nm" maxlength="500" dataformat="engupetc" caption="Consignee Name" 	style="width:70%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img2" wrap="physical;"></textarea></td>
							</tr>
							<tr>
								<th>Address</th>
								<td colspan="5"><textarea rows="3" name="c_cust_addr" id="c_cust_addr" maxlength="350" dataformat="engupetc" caption="Consignee Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img3" wrap="physical;"></textarea></td>
							</tr>
							<tr>
						 		<th>City</th>
								<td><input type="text" style="width:135px;" class="input" name="c_cust_cty_nm" id="c_cust_cty_nm" maxlength="500" dataformat="engupetc" caption="Consignee City"></td>
						 		<th>Country</th>
								<td><input type="text" style="width:30px;" class="input" name="c_cstms_decl_cnt_cd" id="c_cstms_decl_cnt_cd" maxlength="2" dataformat="engup" caption="Consignee Country"></td>
						 		<th>Zip</th>
								<td><input type="text" style="width:87px;" class="input" name="c_cust_zip_id" id="c_cust_zip_id" maxlength="10" dataformat="engupetc" caption="Consignee Zip"></td>
							</tr>
							<tr>
								<th>Street</th>
								<td>
									<input type="text" name="c_eur_cstms_st_nm" id="c_eur_cstms_st_nm" dataformat="engupetc" style="width:150px;" maxlength="50" class="input" style="ime-mode:disabled">
								</td>
						 		<th>EORI#</th>
								<td colspan=5><input type="text" name="c_eori_no" id="c_eori_no" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" style="ime-mode:disabled"><!-- 
									 --><input type="hidden" name="c_eori_no_ori" id="c_eori_no_ori" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" style="ime-mode:disabled">
								</td>
							</tr>
						</tbody>
					</table>
		        </div>
		    </div>
		    <div class="layout_vertical_2" style="width:50%; float:right;">
		        <div class="opus_design_inquiry sm pad_8">
		            <table>
						<tbody>
							<colgroup>
								<col width="80">
								<col width="200">
								<col width="50">
								<col width="130">
								<col width="50">
								<col width="*">
						    </colgroup>
							<tr>
								<th>FWRD</th>
								<td colspan="5"><!-- 
									 --><input type="text" style="width:30px;" class="input" name="f_cust_cnt_cd" id="f_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Forwarder Country Code"><!-- 
									 --><input type="text" style="width:60px;text-align:right;" class="input"  name="f_cust_seq" id="f_cust_seq" maxlength="6" dataformat="engup" caption="Forwarder Sequence"><!-- 
									 --><button name="pop_fwrd" id="pop_fwrd" type="button" class="btn_down_list"></button>
								</td>
							</tr>
							<tr>
								<th>Name</th>
								<td colspan="5"><textarea rows="2" name="f_cust_nm" maxlength="500" dataformat="engupetc" caption="Forwarder Name" 	style="width:50%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img2" wrap="physical;"></textarea></td>
							</tr>
							<tr>
								<th>Address</th>
								<td colspan="5"><textarea rows="3" name="f_cust_addr" id="f_cust_addr" maxlength="350" dataformat="engupetc" caption="Forwarder Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr>
						 		<th>City</th>
								<td><input type="text" style="width:135px;" class="input" name="f_cust_cty_nm" id="f_cust_cty_nm" maxlength="500" dataformat="engupetc" caption="Forwarder City"></td>
						 		<th>Country</th>
								<td><input type="text" style="width:30px;" class="input" name="f_cstms_decl_cnt_cd" id="f_cstms_decl_cnt_cd" maxlength="2" dataformat="engup" caption="Forwarder Country"></td>
						 		<th>Zip</th>
								<td><input type="text" style="width:87px;" class="input" name="f_cust_zip_id" id="f_cust_zip_id" maxlength="10" dataformat="engupetc" caption="Forwarder Zip"></td>
							</tr>
							<tr>
								<th>Street</th>
								<td><input type="text" name="f_eur_cstms_st_nm" id="f_eur_cstms_st_nm" dataformat="engupetc" style="width:150px;" maxlength="50" class="input" style="ime-mode:disabled"></td>
						 		<th>EORI#</th>
								<td colspan= "5"><!-- 
									 --><input type="text" name="f_eori_no" id="f_eori_no" dataformat="engupetc" style="width:100px;" maxlength="20" class="input" style="ime-mode:disabled"><!-- 
									 --><input type="hidden" name="f_eori_no_ori" id="f_eori_no_ori" dataformat="engupetc" style="width:100px;" maxlength="20" class="input" style="ime-mode:disabled">
								</td>
							</tr>
							</table>
							</div>
							<div class="opus_design_inquiry sm pad_8 mar_top_12">
							<table>
						<tbody>
							<colgroup>
								<col width="80">
								<col width="200">
								<col width="50">
								<col width="130">
								<col width="50">
								<col width="*">
						    </colgroup>
							<tr>
								<th>Notify</th>
								<td colspan="5"><input type="text" style="width:30px;" class="input" name="n_cust_cnt_cd" id="n_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Notify Country Code"><!-- 
									 --><input type="text" style="width:60px;text-align:right;" class="input"  name="n_cust_seq" id="n_cust_seq" maxlength="6" dataformat="engup" caption="Notify Sequence"><!-- 
									 --><button name="pop_notify" id="pop_notify" type="button" class="btn_down_list"></button>
								</td>
							</tr>
							<tr>
								<th>Name</td>
								<td colspan="5"><textarea rows="2" name="n_cust_nm" id="n_cust_nm" maxlength="500" dataformat="engupetc" caption="Notify Name" 	style="width:50%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr>
								<th>Address</td>
								<td colspan="5"><textarea rows="3" name="n_cust_addr" id="n_cust_addr" maxlength="350" dataformat="engupetc" caption="Notify Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden; resize:none;" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr>
						 		<th>City</td>
								<td><input type="text" style="width:135px;" class="input" name="n_cust_cty_nm" id="n_cust_cty_nm" maxlength="500" dataformat="engupetc" caption="Notify City"></td>
						 		<th>Country</td>
								<td><input type="text" style="width:30px;" class="input" name="n_cstms_decl_cnt_cd" id="n_cstms_decl_cnt_cd" maxlength="2" dataformat="engup" caption="Notify Country"></td>
						 		<th>Zip</td>
								<td><input type="text" style="width:87px;" class="input" name="n_cust_zip_id" id="n_cust_zip_id" maxlength="10" dataformat="engupetc" caption="Notify Zip"></td>
							</tr>
							<tr>
								<th>Street</td>
								<td><input type="text" name="n_eur_cstms_st_nm" id="n_eur_cstms_st_nm" dataformat="engupetc" style="width:150px;" maxlength="50" class="input" style="ime-mode:disabled"></td>
						 		<th>EORI#</td>
								<td colspan=3><!-- 
									 --><input type="text" name="n_eori_no" id="n_eori_no" dataformat="engupetc" style="width:100px;" maxlength="20" class="input" style="ime-mode:disabled"><!-- 
									 --><input type="hidden" name="n_eori_no_ori" id="n_eori_no_ori" dataformat="engupetc" style="width:100px;" maxlength="20" class="input" style="ime-mode:disabled">
								</td>
							</tr>
						</tbody>
					</table>
		        </div>
		    </div>
		</div>
		<!-- layout_wrap(E) -->
		<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style  = "display: none">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd1" 	id="btn_RowAdd1">Row Add</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_RowDel1" 	id="btn_RowDel1">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		<div class="opus_design_btn mar_top_12">
			<button type="button" class="btn_accent" name="btn_RowAdd2" 	id="btn_RowAdd2">Row Add</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_RowDel2" 	id="btn_RowDel2">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>
	</div>
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style  = "display: none">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd3" 	id="btn_RowAdd3">Row Add</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_RowDel3" 	id="btn_RowDel3">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
		
	<div style="display:none;">
		<table class="search"> 
			<tr>
				<td width="145">FlatFile</td>
			</tr> 
			<tr>
				<td>
					<textarea name="flatfile" cols="600" rows="20"  wrap="hard" style="width: 100%; background-color: #FBFBFB; border: 1 solid #AEAEAE;"  style="overflow:hidden; ime-mode:disabled;"></textarea>
				</td>
			</tr> 
		</table>
	</div>
	<div class="opus_design_grid" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

<%if(!mainPage.equals("true")){	%></div><%}%>

</form>