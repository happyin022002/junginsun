<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0965.jsp
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0965Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0965Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
	String strPort_cd		= "";
	String dType			= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		strPort_cd = strCnt_cd + strOfc_cd.substring(0, 3);
		
	   
		event = (EsmBkg0965Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// parent window parameter setting
		
		dType = (StringUtil.xssFilter(request.getParameter("d_type")) == null) ? "" : StringUtil.xssFilter(request.getParameter("d_type"));
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
<%--=JSPUtil.getIBCodeCombo("anr_role_div_cd_", "", "CD20020", 0, "")--%>
<%--=JSPUtil.getIBCodeCombo("reason_resending_", "", "CD20021", 0, "")--%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=dType%>');
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="bay_pln_id" id="bay_pln_id">
<input type="hidden" name="dg_list_local_yn" id="dg_list_local_yn">
<input type="hidden" name="trans_type" id="trans_type">
<input type="hidden" name="cond_type" id="cond_type"> <!-- input Validation type ("bl_no", "pol_cd", "pod_cd", "cntr_no") -->
<input type="hidden" name="cond_value" id="cond_value"><!-- input Validation value -->
<input type="hidden" name="search_type" id="search_type"><!-- "ALL_SEARCH", "ETC_SEARCH" -->
<input type="hidden" name="ui_type" id="ui_type" value="ESM_BKG_0965">
<input type="hidden" name="bl_no" id="bl_no">	
<input type="hidden" name="hid_d_type" id="hid_d_type">	
<input type="hidden" name="hid_vvd_cd" id="hid_vvd_cd">	
<input type="hidden" name="hid_port_cd" id="hid_port_cd">	

<input type="hidden" name="init_d_type" id="init_d_type" value="<%= dType %>">
<input type="hidden" name="currMainPageListCnt" id="currMainPageListCnt" value="0">
<input type="hidden" name="frm_spcl_cgo_prnr_clz_flg" id="frm_spcl_cgo_prnr_clz_flg">
<!-- ======================================================================== -->
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
			<button type="button" class="btn_accent" name="btn1_Close_SCG" id="btn1_Close_SCG">Close SCG</button><!-- 
		 --><button type="button" class="btn_accent" name="btn1_Open_SCG" id="btn1_Open_SCG">Open SCG</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Append_Retrieve" id="btn1_Append_Retrieve">Booking Data Append</button><!-- 
		 --><label for="dg_list_copy_check"><strong>Copy</strong></label><input type="checkbox" value="" id="dg_list_copy_check" name="dg_list_copy_check" disabled> <!-- 
		 --><input type="hidden" id="dg_list_copy_flag" name="dg_list_copy_flag" value="N"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_New" id="btn1_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Save" id="btn1_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_EDITransmit" id="btn1_EDITransmit">EDI Transmit</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_EDICancel" id="btn1_EDICancel">EDI  Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_SentResult" id="btn1_SentResult">Transmit (Sending Results)</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_DownExcel" id="btn1_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- wrap_search(S) -->  
<div class="wrap_search">

<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<!-- table 1 (S) -->
	<table>		
		<tr>
			<th width="75">Declaration</th>
			<td width="430">
				<input type="checkbox" name="d_type1" id="d_type1" value="D"><label for="d_type1">Discharging</label><!--
			 --><input type="checkbox" name="d_type2" id="d_type2" value="T"><label for="d_type2">Transit</label><!--
			 --><input type="checkbox" name="d_type3" id="d_type3" value="L"><label for="d_type3">Loading</label><!--
			 --><input type="checkbox" name="d_type4" id="d_type4" value="P"><label for="d_type4">Pre-carriage</label><!--
			 --><input type="checkbox" name="d_type5" id="d_type5" value="O"><label for="d_type5">On-Carriage</label><!--
			 --><input type="hidden" name="d_type" value="D" required caption="Declaration">
			</td>
			<th width="30">VVD</th>
			<td width="90"><input type="text" style="width:90px; ime-mode: disabled" value="" class="input1" name="vvd_cd" dataformat="engup" required maxlength="9" fullfill caption="VVD"></td>
			<th width="30">Port</th>
			<td width="80"><script type="text/JavaScript">ComComboObject("port_cd", 1, 65,1, 1);</script></td>											  
			<td width="70">
				<input type="checkbox" value="" id="barge_check" name="barge_check" disabled><label for="barge_check"><strong>BARGE</strong></label>
				<input type="hidden" id="barge_flag" name="barge_flag" value="N">
			</td>
			<td><input type="checkbox" value="" id="bay_plan_upload_check" name="bay_plan_upload_check"><label for="bay_plan_upload_check"><strong>Bay-Plan Upload Required</strong></label></td> 
		</tr>		
	</table>
	<!-- Table 1 (E) -->	
	<!-- Table 2 (S) -->
	<table class="grid2" style="width:1000px; font-weight: bold;">
		<tr>
			<th width="150">Arrival</th>
			<td width="160"><input type="text" style="width:80px; ime-mode: disabled" class="input" name="frm_eta_d" dataformat="ymd" caption="Arrival Date" maxlength="10"><!-- 
			 --><input type="text" style="width:72px; ime-mode: disabled" class="input"name="frm_eta_t" dataformat="hm" caption="Arrival Time" maxlength="5">
			</td>
			<th width="140">Departure</th>
			<td width="130"><input type="text" style="width:80px; ime-mode: disabled" class="input" name="frm_etd_d" dataformat="ymd" caption="Departure Date" maxlength="10"><!-- 
			 --><input type="text" style="width:45px; ime-mode: disabled" class="input" name="frm_etd_t" dataformat="hm" caption="Arrival Time" maxlength="5">
			</td>
			<th width="90">Berth</th>
			<td><input type="text" style="width:70px; ime-mode: disabled" class="input" name="frm_brth_yd_cd" dataformat="eng" maxlength="7" caption="Berth"><!-- 
			 --><input type="text" style="width:200px; ime-mode: disabled" class="input" name="frm_yd_nm">
			</td>
		</tr>
		<tr>
			<th>Auto Transmit</th>
			<td><input type="text" style="width:80px;" class="input2" name="frm_auto_snd_tp_cd" readOnly></td>
			<th>Vessel Code</th>
			<td><input type="text" style="width:80px;  ime-mode: disabled" dataformat="engup" class="input" name="frm_vsl_cd"></td>
			<th><div id="layoutView">Vessel Name</div></th>
			<td><input type="text" style="width:274px;  ime-mode: disabled" class="input" dataformat="engupetc" name="frm_vsl_eng_nm"></td>
		</tr>
		<tr>
			<th>Vessel Flag/Call Sign</th>
			<td><input type="text" style="width:80px; ime-mode: disabled" class="input" name="frm_vsl_cnt_cd" dataformat="engup" maxlength="2" caption="Vessel Flag"><!-- 
			 --><input type="text" style="width:72px; ime-mode: disabled" class="input" name="frm_call_sgn_no" dataformat="engupetc" maxlength="14" caption="Call Sign">
			</td>
			<th>Lloyd Code</th> 
			<td><input type="text" style="width:80px; ime-mode: disabled" class="input" name="frm_lloyd_no" dataformat="engup" maxlength="12" caption="Lloyd code"></td>
			<th>SSR</th>
			<td><input type="text" style="width:100px; ime-mode: disabled" value="" class="input1" name="frm_svc_rqst_no" dataformat="num" required maxlength="7" caption="SSR"></td>
		</tr>
		<tr>
			<th>Agent or Agent Forwarder</th>
			<td><script type="text/javascript">ComComboObject('anr_role_div_cd',1,155, 1);</script></td>
			<th>Reason of Re-sending</th>
			<td><script type="text/javascript">ComComboObject('reason_resending',1,130, 1);</script></td>
			<th>Sent Status</th>
			<td><input type="hidden" style="width:100px; background-color:white; font-weight:bold;" name="frm_ack_rcv_sts_cd" id="frm_ack_rslt_id" readOnly><!-- 
			 --><input type="text" style="width:274px;background-color:white; font-weight:bold;" name="ack_rcv_sts_cd_name" id="frm_ack_rslt_id_name" readOnly>
			</td>
		</tr>
	</table>
	<!-- Table 5 (E) -->
</div>
<!-- opus_design_inquiry(E) -->

</div>
<!-- wrap_search(E) -->  

<!-- wrap_result(S) -->  
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
		
	<div class="grid_option_left">	
	<table>
		<tbody>							
			<tr>
				<th width="60">B/L No.</th>
				<td width="120"><input type="text" style="width:100px; ime-mode: disabled" class="input" name="filter_bl_no" dataformat="engup" maxlength="12" caption="B/L No."></td>
				<th width="90">Container No.</th>
				<td width="110"><input type="text" style="width:110px; ime-mode: disabled" class="input" name="filter_cntr_no"dataformat="engup" maxlength="14" caption="Container No."></td>
				<td><button type="button" class="btn_etc" name="btn1_Filter" id="btn1_Filter">Filter</button></td>						
				<th width="110">Cargo Operator</th>
				<td width="50"><input type="text" style="width:40px; ime-mode: disabled" class="input" name="filter_cgo_opr"dataformat="engup" maxlength="3" caption="Cargo Operator"></td>
				<td><button type="button" class="btn_etc" name="btn1_Filter2" id="btn1_Filter2">Filter</button></td>						
			</tr>
		</tbody>
	</table>		
	</div>
	
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button"  class="btn_normal" name="btn1_BayPlan" id="btn1_BayPlan">Bay-Plan</button>
			<button type="button"  class="btn_normal" name="btn2_RowAdd" id="btn2_RowAdd">Row Add</button>
			<button type="button"  class="btn_normal" name="btn2_Delete" id="btn2_Delete">Row Delete</button>
			<button type="button"  class="btn_normal" name="btn2_history" id="btn2_history">History</button>								
		</div>
		<!-- opus_design_btn(E) -->						
		<script type="text/javascript">ComSheetObject('sheet2');</script>									
	</div>		
	
	<div class="grid_option_left">	
		<table>
			<tbody>
				<tr>
					<th width="100">Total Container</th>
					<td><input type="text" style="width:100px; ime-mode: disabled; text-align:Center;" class="input2" name="cntr_cnt" readOnly></td>
				</tr>
			</tbody>					
		</table>
	</div>
</div>	
	
</form>
