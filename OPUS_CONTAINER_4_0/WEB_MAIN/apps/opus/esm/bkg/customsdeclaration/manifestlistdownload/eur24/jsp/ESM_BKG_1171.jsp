<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1171.js
*@FileTitle  : A/N with MRNs (FI) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1171Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1171Event  event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount	 = 0;				//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.opus.CustomsDeclaration.ManifestListDownload");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1171Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_cmd_detail" id="f_cmd_detail" />
<input type="hidden" name="p_vvd_cd" id="p_vvd_cd" />
<input type="hidden" name="vvd" id="vvd" />
<input type="hidden" name="cvy_ref_no" id="cvy_ref_no" />
<input type="hidden" name="form_cstms_port_cd" id="form_cstms_port_cd" />
<input type="hidden" name="form_cstms_yd_cd" id="form_cstms_yd_cd" />
<input type="hidden" name="cstms_yd_cd" id="cstms_yd_cd" />
<input type="hidden" name="form_port_net_no" id="form_port_net_no" />
<input type="hidden" name="form_cvy_ref_no_hidden" id="form_cvy_ref_no_hidden" />
<input type="hidden" name="form_cvy_ref_no" id="form_cvy_ref_no" />
<input type="hidden" name="form_ibflag" id="form_ibflag" />
<input type="hidden" name="eur_edi_msg_tp_id" value="ARN" id="eur_edi_msg_tp_id" />
<input type="hidden" name="form_an_edi_svc_flg" id="form_an_edi_svc_flg" />
<input type="hidden" name="cvy_ref_no" id="cvy_ref_no" />
<input type="hidden" name="port_net_no" id="port_net_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downExcel" id="btn_downExcel" type="button">Down  Excel</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_transmit" id="btn_transmit" type="button">Transmit</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
		<colgroup>
			<col width="105">
			<col width="50">
			<col width="80">
			<col width="50">
			<col width="100">
			<col width="50">
			<col width="50">
			<col width="100">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th>VVD CODE</th>
				<td><input type="text" style="width:80px;" class="input1" name="form_fi_vvd" dataformat="" maxlength="9" fullfill="" caption="VVD" id="form_fi_vvd" /></td>
				<th>B/L No.</th>
				<td><input type="text" style="width:100px;" class="input" name="form_bl_no" dataformat="eng" maxlength="13" caption="BL No" id="form_bl_no" /></td>
			    <th>Port net NO.</th>
				<td><input type="text" style="width:80px;" class="input" name="form_fi_cvy_ref_no" dataformat="engup" maxlength="50" caption="Port net No" id="form_fi_cvy_ref_no" /></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" style="width:60px;" class="input2" readonly="true" name="form_fi_cstms_yd_cd" value="FIKTK" dataformat="engup" maxlength="5" id="form_fi_cstms_yd_cd" /></td>
				<td><input type="checkbox" name="chk_all" style="border-style:none" id="chk_all" /><label for = "chk_all"><strong>All BKGs</strong></label></td>
			</tr> 
		</table>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<table>
		<colgroup>
			<col width="105">
			<col width="150">
			<col width="130">
			<col width="30">
			<col width="30">
			<col width="30">
			<col width="30">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th>Vessel Name</th>
				<td><input type="text" style="width:160px;" class="input2" readonly="true" name="form_vsl_eng_nm" maxlength="50" id="form_vsl_eng_nm" /></td>
				<th>Lloyd No.(IMO)</th>
				<td><input type="text" style="width:80px;" class="input2" readonly="true" name="form_lloyd_no" dataformat="eng" maxlength="20" id="form_lloyd_no" /></td>
				<th>Vessel Flag</th>
				<td><input type="text" style="width:150px;" class="input2" readonly="true" name="form_piclb_desc" dataformat="eng" maxlength="100" id="form_piclb_desc" /></td>
				<th>Operator</th>
				<td><input type="text" style="width:40px;" class="input2" readonly="true" name="form_crr_cd" dataformat="eng" maxlength="10" id="form_crr_cd" /></td>									
			</tr> 
			<tr id="fiEtaView">
				<th>ETA</th>
				<td><input type="text" style="width:120px;" class="input2" readonly="true" name="form_eta_dt" caption="Estimated Time of Arrival" id="form_eta_dt" /></td>
				<th>ETD</th>
				<td><input type="text" style="width:120px;" class="input2" readonly="true" name="form_etd_dt" caption="Estimated Departure Date" id="form_etd_dt" /></td>
			</tr>
			<tr>	
				<th>First Office</th>
				<td><input type="text" style="width:80px;" class="input2" readonly="true" name="form_n1st_port_ofc_cd" dataformat="eng" maxlength="10" caption="First Port Office Code" id="form_n1st_port_ofc_cd" /></td>
				<th>Calling Terminal</th>
				<td><input type="text" style="width:80px;" class="input2" readonly="true" name="form_tml_cd" dataformat="engup" maxlength="15" caption="Terminal Code" id="form_tml_cd" /><input type="text" style="width:240px;" class="input2" readonly="true" name="form_tml_nm" dataformat="engup" maxlength="50" caption="Terminal Name" id="form_tml_nm" /></td>
			</tr> 
			<tr>
				<th>Last Calling Port</th>
				<td><input type="text" style="width:80px;" class="input2" name="form_lst_clpt_cd" dataformat="engup" maxlength="5" readonly="true" id="form_lst_clpt_cd" /></td>
				<th>Next Calling Port</th>
				<td><input type="text" style="width:80px;" class="input2" name="form_nxt_clpt_cd" dataformat="engup" maxlength="5" readonly="true" id="form_nxt_clpt_cd" /></td>
			</tr> 
			<tr>
				<th>Cert. Reg No.</th>
				<td><input type="text" style="width:80px;" class="input2" name="form_rgst_no" dataformat="eng" maxlength="15" id="form_rgst_no" /></td>
				<th>Cert. Reg Date</th>
				<td><input type="text" style="width:100px;" class="input2" name="form_rgst_dt" dataformat="ymd" maxlength="10" id="form_rgst_dt" /></td>
				<th>Cert. Reg Location</th>
				<td><input type="text" style="width:80px;" class="input2" name="form_rgst_port_cd" dataformat="engup" maxlength="5" id="form_rgst_port_cd" /></td>
				<th>Ack. Status</th>
		        <td><select style="width: 150px;" name="p_ack_status" id="p_ack_status">
						 <option value="" selected>All</option>
						 <option value="A">Accepted</option>
						 <option value="R">Rejected</option>
						 <option value="NR">Not Received</option>
						 <option value="NA">N/A</option>
						 <option value="CA">Conditionally Accepted</option>
						 <option value="H">Customs Hold</option>
						 <option value="L">Customs Release</option>
						 <option value="D">Customs Release rejection</option>
				    </select>
		       </td>
			</tr> 
			<tr>	
				<th>Gross Ton</th>
				<td><input type="text" style="width:80px;" class="input2" name="form_grs_rgst_tong_wgt" dataformat="num" maxlength="15" id="form_grs_rgst_tong_wgt" /></td>
				<th>Net Ton</th>
				<td><input type="text" style="width:80px;" class="input2" name="form_net_rgst_tong_wgt" dataformat="num" maxlength="15" id="form_net_rgst_tong_wgt" /></td>
			</tr> 
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" id="btn_History" name="btn_History">Transmit & Receive History</button><!-- 
			 --><button type="button" class="btn_normal" id="btn_viewMsg" name="btn_viewMsg">View Message</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<div class="opus_design_data">
		<table>
			<tr>
				<th>FlatFile</th>
			</tr> 
			<tr>
				<td><textarea name="flatfile" cols="600" rows="20"  wrap="hard" style="resize:none;width: 100%; background-color: #FBFBFB; border: 1 solid #AEAEAE;"  style="overflow:hidden; ime-mode:disabled;"></textarea></td>
			</tr> 
		</table>
	</div>
</div>
</form>