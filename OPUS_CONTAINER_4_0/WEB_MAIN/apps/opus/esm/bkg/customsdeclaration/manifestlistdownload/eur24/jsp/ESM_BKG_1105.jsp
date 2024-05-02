<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1105.jsp
*@FileTitle  : Europe Advanced Manifest - Diversion Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1105Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	EsmBkg1105Event  event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg1105Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
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
		document.form.form_vvd.focus();
	}
	<%=ConstantMgr.getCompanyCodeToJS()%>
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd_detail">
<input type="hidden" name="cvy_ref_no">
<input type="hidden"  name="vvd">
<input type="hidden" name="cstms_port_cd">
<input type="hidden" name="cstms_yd_cd">
<input type="hidden" name="p_vvd_cd">
<input type="hidden" name="form_ibflag">
<input type="hidden" name="form_rvis_n1st_clpt_cd_old">
<input type="hidden" name="rvis_n1st_clpt_cd">
<input type="hidden" name="eur_edi_msg_tp_id" value = "DIV">
<input type="hidden" name="rvis_cstms_yd_cd">
<input type="hidden" name="form_rvis_cstms_yd_cd">
<input type="hidden" name="dvs_rqst_smt_flg">
<input type="hidden" name="form_dvs_edi_svc_flg">
<input type="hidden" name="form_dvs_rqst_edi_svc_flg">

	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		    --><button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Transmit</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) -->
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>

<!-- 검색영역 -->
<div class="wrap_search">
	<div class="opus_design_inquiry">		
		<table>
			<colgroup>
		  		<col width="150px"></col>
		  		<col width="210px"></col>
		  		<col width="120px"></col>
		  		<col width="150px"></col>
		  		<col width="170px"></col>
		  		<col width="210px"></col>
		  		<col width="100px"></col>
		  		<col width="40px"></col>			  		
		  		<col width=""></col>  		
		  	</colgroup> 			
			<tbody>
				<tr>
					<th>VVD CODE</th>
					<td><input type="text" style="width:100px;" class="input1" name="form_vvd" id="form_vvd"  dataformat="engup" maxlength="9" minlength="9" caption="VVD CODE"></td>
					<th>CRN No.</th>
					<td><input type="text" style="width:140px" class="input" name="form_cvy_ref_no" id="form_cvy_ref_no"  dataformat="engup" maxlength="50"  caption="CRN No." ></td>
					<th>POFE(Port of 1st Entry)</th>
					<td><script type="text/javascript">ComComboObject('form_first_eu_port', 1, 100, 1, 0);</script><input type="text" style="width:80px" class="input2" readOnly="true" name="form_cstms_yd_cd" dataformat="engup" maxlength="10" caption="Yard">	</td>
				</tr>
				<tr ><td colspan="9" class="line_bluedot"></td></tr>

				<tr>
					<th>Vessel Name</th>
					<td><input type="text" style="width:200px" class="input2" readOnly="true" name="form_vsl_eng_nm" id="form_vsl_eng_nm" maxlength="50"></td>
					<th>Lloyd No.(IMO)</th>
					<td><input type="text" style="width:90px" class="input2" readOnly="true" name="form_lloyd_no" id="form_lloyd_no" dataformat="engup" maxlength="20"></td>
					<th>Vessel Flag</th>
					<td><input type="text" style="width:200px" class="input2" readOnly="true" name="form_piclb_desc" id="form_piclb_desc" dataformat="engupetc" maxlength="100"></td>
					<th>Operator</th>
					<td><input type="text" style="width:50px" class="input2" readOnly="true" name="form_crr_cd" id="form_crr_cd" dataformat="engupetc" maxlength="10"></td>
					<td></td>
				</tr>
				<tr>
					<th>Original Country & Port</th>
					<td><input type="text" style="width:80px" class="input2"  readOnly="true" name="form_cstms_port_cd" id="form_cstms_port_cd" dataformat="engup" maxlength="10"></td>
					<th>Original First Office</th>
					<td><input type="text" style="width:90px" class="input2"  name="form_n1st_port_ofc_cd" id="form_n1st_port_ofc_cd" dataformat="engup" maxlength="10" ></td>
					<th>ENS ETA</th>
					<td colspan="4"><input type="text" style="width:120px" class="input2" readOnly="true" name="form_init_eta_dt" id="form_init_eta_dt" caption="Estimated Time of Arrival"></td>
				</tr>
				<tr>
					<th>New Country & Port</th>
					<td><input type="text" style="width:80px" class="input2"  name="form_rvis_n1st_clpt_cd" id="form_rvis_n1st_clpt_cd" dataformat="engup" maxlength="10" onblur="obj_change()"><script type="text/javascript">ComComboObject('form_tml_cd', 1, 90, 2, 0);</script></td>
					<th>New First Office</th>
					<td><input type="text" style="width:90px" class="input2" name="form_n1st_port_ofc_cd_new" id="form_n1st_port_ofc_cd_new" dataformat="engup" maxlength="10" readonly></td>
					<th>ETA</th>
					<td colspan="4"><input type="text" style="width:120px" class="input2" readOnly="true" name="form_eta_dt" id="form_eta_dt" caption="Estimated Time of Arrival"></td>
				</tr>
				<tr>
					<th>Last Calling Port</th>
					<td>
						<input type="text" style="width:80px" class="input2" name="form_lst_clpt_cd" id="form_lst_clpt_cd" dataformat="engup" maxlength="5">
					</td>
					<th>Next Calling Port</th>
					<td colspan="6">
						<input type="text" style="width:90px" class="input2" name="form_nxt_clpt_cd" id="form_nxt_clpt_cd" dataformat="engup" maxlength="5">
					</td>
				</tr>
				<tr>
					<th>D/R submitted by Other Operator</th>
					<td colspan="8"><input type="checkbox" style="width:20px" class="input" name="form_dvs_rqst_smt_flg" id="form_dvs_rqst_smt_flg" ></td>				
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="line_bluedot"></div>

	<!-- 검색영역 -->
	<div class="opus_design_inquiry">		
		<table>
				<colgroup>
			  		<col width="150px"></col>
			  		<col width="210px"></col>
			  		<col width="30px"></col>
			  		<col width="160px"></col>
			  		<col width="145px"></col>
			  		<col width="80px"></col>			  					  		
			  		<col width="130px"></col>
			  		<col width=""></col>
			  	</colgroup> 			
				<tbody>
				<tr>
					<th>Updated Date</th>
					<td><input type="text" style="width:130px" class="input2" name="form_upd_dt" id="form_upd_dt" ></td>
					<th>By</th>
					<td colspan="5"><input type="text" style="width:80px" class="input2" name="form_upd_usr_id" id="form_upd_usr_id"  dataformat="engupetc" maxlength="10"><input type="text" style="width:80px" class="input2" name="form_upd_ofc_cd" id="form_upd_ofc_cd"  dataformat="engup" maxlength="10"></td>
				</tr>
				<tr>
					<th>(GMT)</th>
					<td colspan="7"><input type="text" style="width:130px" class="input2" name="form_upd_dt_gmt" id="form_upd_dt_gmt"></td>
				</tr>
				<tr>
					<th>EDI Transmission Date</th>
					<td><input type="text" style="width:130px" class="input2" name="form_snd_dt" id="form_snd_dt"></td>
					<th>By</th>
					<td><input type="text" style="width:80px" class="input2" name="form_snd_usr_id" id="form_snd_usr_id"  dataformat="engupetc" maxlength="10"><input type="text" style="width:80px" class="input2" name="form_snd_ofc_cd"  dataformat="engup" maxlength="10"></td>
					<th>EDI ACK</th>
					<td><input type="text" style="width:80px" class="input2" name="form_ack" id="form_ack" dataformat="engupetc" maxlength="10"></td>
					<td><input type="text" style="width:130px" class="input2" name="form_edi_rcv_dt" id="form_edi_rcv_dt"><button type="button" id="btn_viewMsg" name="btn_viewMsg" class="input_seach_btn"></button></td>
					<td></td>
				</tr>
				<tr>
					<th>(GMT)</th>
					<td colspan="3"><input type="text" style="width:130px" class="input2" name="form_snd_dt_gmt" id="form_snd_dt_gmt"></td>
					<th>(GMT)</th>
					<td></td>
					<td><input type="text" style="width:130px" class="input2" name="form_edi_rcv_dt_gmt" id="form_edi_rcv_dt_gmt"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- 검색영역 -->
	<div class="opus_design_inquiry" style="font-weight:bold;">		
	<table style="width:1000px; border:1px solid #c7e2f8; background-color:#eceff0; height:30px">
		<tr>	
			<td>* In case Operator is not <%=ConstantMgr.getCompanyName()%>, Transmit button becomes disabled instead of transmit EDI,
			<br>&nbsp;&nbsp; you should click on D/R submitted by Other Operator and click "Save" button to prevent origin office not to send ENS EDI after D/R EDI is submitted by other operator.
			<br>* Transmit button will become activated from 3 days before ETA of new port.
			</td>
		</tr>
	</table>
	</div>
	<div class="opus_design_inquiry" style="font-weight:bold;">
	<table style="width:1000px; border:1px solid #c7e2f8; background-color:#eceff0; height:30px">
		<tr>	
			<td>		
				* POFE ETA time is inserted as 12:00 when vessel operator is a consortium member.
			</td>
		</tr>
	</table>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	</div>
</form>
<style>
.importantRed {
  background-color: red !important;
}
</style>

