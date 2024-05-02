<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0966.jsp
*@FileTitle  : DG Declare EDI Transmit 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
*/
%>

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
		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	<%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeForMultiCombo("port_cd_", "BE", "MANI_PORT_CD","1")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage('<%=dType%>', '<%=strOfc_cd%>');
	}
</script>


<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="bay_pln_id" id="bay_pln_id">
<input type="hidden" name="dg_list_local_yn" id="dg_list_local_yn">
<input type="hidden" name="trans_type" id="trans_type">
<input type="hidden" name="cnt_cd" id="cnt_cd" value="<%= strCnt_cd %>">
<input type="hidden" name="cond_type" id="cond_type"> 	<!-- input Validation type ("bl_no", "pol_cd", "pod_cd", "cntr_no") -->
<input type="hidden" name="cond_value" id="cond_value">	<!-- input Validation value -->
<input type="hidden" name="search_d_type" id="search_d_type">
<input type="hidden" name="pol_cd" id="pol_cd">
<input type="hidden" name="pod_cd" id="pod_cd">
<input type="hidden" name="hid_d_type" id="hid_d_type">	
<input type="hidden" name="hid_vvd_cd" id="hid_vvd_cd">	
<input type="hidden" name="hid_port_cd" id="hid_port_cd">	
<input type="hidden" name="ui_type" id="ui_type" value="ESM_BKG_0966">	
<input type="hidden" name="bl_no" id="bl_no" value="">
<input type="hidden" name="cell_chk" id="cell_chk" value="">
<input type="hidden" name="frm_spcl_cgo_prnr_clz_flg" id="frm_spcl_cgo_prnr_clz_flg">

<!-- Bay-Paln detail pop use setting... -->
<input type="hidden" name="currMainPageListCnt" id="currMainPageListCnt" value="0">	

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
		 --><button type="button" class="btn_accent" name="btn1_Append_Retrieve" id="btn1_Append_Retrieve">Booking Data Append</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_New" id="btn1_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Save" id="btn1_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_EDITransmit" id="btn1_EDITransmit">EDI Transmit</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_EDICancel" id="btn1_EDICancel">EDI Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_SentResult" id="btn1_SentResult">Transmit (Sending Results)</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_DownExcel" id="btn1_DownExcel">Down Excel</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit" >
	<table>
		<tbody>
			<colgroup>
				<col width="40"/>
				<col width="120"/>
				<col width="60"/>
				<col width="80"/>
				<col width="50"/>
				<col width="50"/>
				<col width="40"/>
				<col width="40"/>
				<col width="40"/>
				<col width="40"/>
				<col width="40"/>
				<col width="40"/>
				<col width="40"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th class="sm">Declaration</th>
				<td class="sm"><!-- 
					 --><input type="radio" name="d_type" value="D" class="trans" checked>&nbsp;Import&nbsp;&nbsp;<!-- 
					 --><input type="radio" name="d_type" value="T" class="trans">&nbsp;Transit&nbsp;&nbsp;<!-- 
					 --><input type="radio" name="d_type" value="L" class="trans">&nbsp;Export&nbsp;&nbsp;<!-- 
				 --></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:90px; ime-mode: disabled" value="" class="input1" name="vvd_cd" id="vvd_cd" dataformat="engup" required maxlength="9" fullfill caption="VVD"></td>
				<th>Port</th>
				<td style="text-align:left;"><input type="text" style="width:70px; ime-mode: disabled" value="<%= strPort_cd %>" class="input1" name="port_cd" id="port_cd" dataformat="engup" required maxlength="5" fullfill caption="Port"></td>
				<th>Cargo Oper</th>
				<td><input type="text" style="width:40px;" class="input" name="cargo_oper_cd" value="" maxlength="3" dataformat="engup" id="cargo_oper_cd" fullfill caption="Cargo Operator"></td>
				<th>POL</th>
				<td><input type="text" style="width:55px;" class="input" name="pol_code" value="" maxlength="5" dataformat="engup" id="pol_code" fullfill caption="POL"></td>
				<th>POD</th>
				<td><input type="text" style="width:55px;" class="input" name="pod_code" value="" maxlength="5" dataformat="engup" id="pod_code" fullfill caption="POD"></td>
				<th>B/L No.</th>
				<td><input type="text" style="width:100px;" class="input" name="bl_number" value="" id="bl_number" ></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- <div class="opus_design_data" style="width: 1000px;">  콤보 색이 변경이 안되 class 삭제함-->
<div  style="width: 1000px;">
	<table class="grid_2">
		<colgroup>
		    <col width="150"/>
			<col width="140"/>
			<col width="100"/>
			<col width="140"/>
			<col width="100"/>
			<col width="*" />
		</colgroup>
	    <tr>
		    <th>Arrival</th>
		    <td>
		    	<input type="text" style="width: 80px; ime-mode: disabled" class="input" name="frm_eta_d" id="frm_eta_d" dataformat="ymd" caption="Arrival Date" maxlength="10"><!-- 
				 --><input type="text" style="width: 45px; ime-mode: disabled" class="input" name="frm_eta_t" id="frm_eta_t" dataformat="hm" caption="Arrival Time" maxlength="5"><!-- 
		     --></td>
		    <th>Departure</th>
		    <td>
		    	<input type="text" style="width: 80px; ime-mode: disabled" class="input" name="frm_etd_d" id="frm_etd_d" dataformat="ymd" caption="Departure Date" maxlength="10"><!-- 
				 --><input type="text" style="width: 45px; ime-mode: disabled" class="input" name="frm_etd_t" id="frm_etd_t" dataformat="hm" caption="Arrival Time" maxlength="5"><!-- 
		     --></td>
		    <th>Berth</th>
		    <td>
		    	<input type="text" style="width: 70px; ime-mode: disabled" class="input" name="frm_brth_yd_cd" id="frm_brth_yd_cd" dataformat="engup" maxlength="7" caption="Berth"><!-- 
				 --><input type="text" style="width: 286px;" class="input" name="frm_yd_nm" id="frm_yd_nm"><!-- 
		     --></td>
		</tr>
		<tr>
		    <th>Auto Transmit</th>
		    <td><input type="text" style="width: 80px;" class="input2" name="frm_auto_snd_tp_cd" id="frm_auto_snd_tp_cd" readOnly></td>
		    <th>Vessel Code</th>
		    <td><input type="text" style="width: 80px; ime-mode: disabled" dataformat="engup" class="input" name="frm_vsl_cd" id="frm_vsl_cd"></td>
		    <th>Vessel Name</th>
		    <td><input type="text" style="width:360px; ime-mode: disabled" class="input" name="frm_vsl_eng_nm" id="frm_vsl_eng_nm"></td>
		</tr>
		<tr>
		    <th>Vessel Flag</th>
		    <td><input type="text" style="width: 80px; ime-mode: disabled" class="input" name="frm_vsl_cnt_cd" id="frm_vsl_cnt_cd" dataformat="enguponly" maxlength="2"></td>
		    <th>Lloyd Code</th>
		    <td><input type="text" style="width: 80px; ime-mode: disabled" class="input" name="frm_lloyd_no" id="frm_lloyd_no"  dataformat="engup" maxlength="12" caption="Lloyd code"></td>
		    <th>Call Sign</th>
		    <td><input type="text" style="width: 70px; ime-mode: disabled" class="input" name="frm_call_sgn_no" id="frm_call_sgn_no" dataformat="engup" maxlength="14" caption="Call Sign"></td>
		</tr>
		<tr>
		    <th>Number of Calling<br>(For RTM)</th>
		    <td><script type="text/javascript">ComComboObject('rtm_call_no', 1, 100, 1, 0);</script></td>
		    <th>UVI / CRN</th>
		    <td><input type="text" style="width: 130px; ime-mode: disabled" class="input" name="frm_svc_rqst_no" id="frm_svc_rqst_no" dataformat="engup" maxlength="14" caption="UVI"></td>
		    <th>Sent Status</th>
		    <td>
		    	<input class="input" type="hidden" style="width: 100%; font-weight:bold;" name="frm_ack_rcv_sts_cd" id="frm_ack_rslt_id" readOnly><!-- 
				 --><input type="text" style="width: 360px; font-weight:bold;" name="ack_rcv_sts_cd_name" id="frm_ack_rslt_id_name" readOnly><!-- 
		     --></td>
		</tr>
	</table>
</div>
<!-- layout_wrap (E) -->

</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display: none;">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
 </div>
<!-- opus_design_grid(E) -->		

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="grid_option_left">	
	<table>
		<tbody>
			<colgroup>
				<col width="80"/>
				<col width="50"/>
				<col width="80"/>
				<col width="50"/>
				<col width="100"/>
				<col width="100"/>
				<col width="115"/>
				<col width="105"/>
				<col width="105"/>
				<col width="115"/>
			</colgroup>
			<tr>
				<th>DG Ref No.</th>
				<td><input type="text" style="width: 110px; ime-mode: disabled" class="input" name="filter_dg_ref_no" id="filter_dg_ref_no"></td>
				<th>B/L No.</th>
				<td><input type="text" style="width: 100px; ime-mode: disabled" class="input" name="filter_bl_no" id="filter_bl_no"></td>
				<th>Container No.</th>
				<td><input type="text" style="width: 110px; ime-mode: disabled" class="input" name="filter_cntr_no" id="filter_cntr_no" dataformat="engup" otherchar="_-" maxlength="14" caption="Container No."></td>				
				<td><button type="button" style="width: 80px; ime-mode: disabled" class="btn_etc" name="btn1_Filter" id="btn1_Filter">Filter</button></td>
				<th>Send Type to Original&nbsp;<input type="checkbox" value="" class="trans" name="send_type_check_orgin" id="send_type_check_orgin"></th>
				<th>Auto Update<input type="checkbox" value="" class="trans" name="auto_update" id="auto_update" checked ="checked"></th>
			</tr>
		</tbody>
	</table>
	</div>
	<div class="opus_design_btn">
	    <button type="button" class="btn_normal" name="btn1_Substitute" id="btn1_Substitute">CNTR Substitute</button><!-- 
		 --><button type="button" class="btn_normal" name="btn2_RowAdd" id="btn2_RowAdd">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn2_Delete" id="btn2_Delete">Row Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn2_history" id="btn2_history">History</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	<div class="opus_design_grid">
	<table>
		<colgroup>
				<col width="90"/>
				<col width="*"/>
		</colgroup>
		<tr>
			<th>Total Container</th>
			<td><input type="text" style="width:100px; ime-mode: disabled; text-align:Center" class="input2" name="cntr_cnt" id="cntr_cnt" readOnly></td>
		</tr>
	</table>
	</div>
</div>
<!-- opus_design_grid(E) -->		


</div>
<!-- wrap_result(E) -->			
</form>