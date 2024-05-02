<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0269.jsp
*@FileTitle  : Freight & Charge_S/C Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0269Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0269Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0269Event)request.getAttribute("Event");
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
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" id="bkg_no" />
<input type="hidden" name="sc_no" value="<%=JSPUtil.getParameter(request, "sc_no")%>" id="sc_no" />
<input type="hidden" name="application_date" value="<%=JSPUtil.getParameter(request, "application_date")%>" id="application_date" />
<input type="hidden" name="tp_sz" value="<%=JSPUtil.getParameter(request, "tp_sz")%>" id="tp_sz" />
<input type="hidden" name="cgo" value="<%=JSPUtil.getParameter(request, "cgo")%>" id="cgo" />
<input type="hidden" name="qty" value="<%=JSPUtil.getParameter(request, "qty")%>" id="qty" />
<input type="hidden" name="brk_dwn_flg" value="<%=JSPUtil.getParameter(request, "brk_dwn_flg")%>" id="brk_dwn_flg" />
<input type="hidden" name="frm_t10sheet1_brk_dwn_flg" value="<%=JSPUtil.getParameter(request, "frm_t10sheet1_brk_dwn_flg")%>" id="frm_t10sheet1_brk_dwn_flg" />
<input type="hidden" name="svc_scp_cd" value="<%=JSPUtil.getParameter(request, "svc_scp_cd")%>" id="svc_scp_cd" />
<input type="hidden" name="term_cd" value="<%=JSPUtil.getParameter(request, "frt_term_cd")%>" id="term_cd" />
<input type="hidden" name="ca_flg" value="<%=JSPUtil.getParameter(request, "ca_flg")%>" id="ca_flg" />

<input type="hidden" name="frm_svc_scp_cd" id="frm_svc_scp_cd" />
<input type="hidden" name="frm_bdr_cng_flg" id="frm_bdr_cng_flg" />
<input type="hidden" name="frm_appldt" id="frm_appldt" />
<input type="hidden" name="frm_cmdtcd" id="frm_cmdtcd" />
<input type="hidden" name="frm_repcmdtcd" id="frm_repcmdtcd" />
<input type="hidden" name="ctrt_tp_cd" value="S" id="ctrt_tp_cd" />
<input type="hidden" name="rt_aud_tp_cd" value="R" id="rt_aud_tp_cd" />
<input type="hidden" name="cmdt_cd_old" id="cmdt_cd_old" />
<input type="hidden" name="sc_code" id="sc_code" />
<input type="hidden" name="frm_bkg_vvd" id="frm_bkg_vvd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">S/C Information</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Select" id="btn_Select" type="button">Select</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_3" style="width:70%;">
	        <!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<tbody>
						<colgroup>
							<col width="60">
							<col width="150">
							<col width="30">
							<col width="150">
							<col width="50px">
							<col width="60">
							<col width="*">
						</colgroup>
						<tr class="h23">
							<th>BKG No.</th>
							<td><input type="text" style="width:110px;" class="input" name="frm_bkg_no" id="frm_bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" readonly></td>
							<th>CRD</th>
							<td><input type="text" style="width:80px;text-align: center" class="input1" dataformat="ymd" style="ime-mode:disabled" name="frm_cntr_cdr_dt" id="frm_cntr_cdr_dt" value="<%=JSPUtil.getParameter(request, "application_date")%>" ><!--  
								--><button type="button" class="calendar" name="pop_on_board_date" id="pop_on_board_date"></button></td>
							<th>S/C No.</th>
							<td><input type="text" style="width:110px;" class="input" name="frm_fsc_no" id="frm_fsc_no" value="<%=JSPUtil.getParameter(request, "sc_no")%>" readonly></td>
						</tr>
					</tbody>
				</table>
				<table class="grid_2" style="width:690px;">
					<tbody>
						<colgroup>
							<col width="100">
							<col width="30">
							<col width="60">
							<col width="*">
						</colgroup>
						<tr align="center">
							<th class="tr2_head" style="text-align:center;"><strong>Shipper</strong></th>
							<td class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_s_cust_cnt_cd" id="frm_s_cust_cnt_cd" value='' readonly></td>
							<td class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_s_cust_seq" id="frm_s_cust_seq" value='' readonly></td>
							<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left"class="noinput2" name="frm_s_cust_nm" id="frm_s_cust_nm" value='' readonly></td>
						</tr>
						<tr align="center">
							<th class="tr2_head" style="text-align:center;"><strong>Consignee</strong></th>
							<td class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_c_cust_cnt_cd" id="frm_c_cust_cnt_cd" value='' readonly></td>
							<td class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_c_cust_seq" id="frm_c_cust_seq" value='' readonly></td>
							<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_c_cust_nm" id="frm_c_cust_nm" value='' readonly></td>
						</tr>
						<tr align="center">
							<th class="tr2_head" style="text-align:center;"><strong>Notify</strong></th>
							<td class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_n_cust_cnt_cd" id="frm_n_cust_cnt_cd" value='' readonly>	</td>
							<td class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_n_cust_seq" id="frm_n_cust_seq" value='' readonly>	</td>
							<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_n_cust_nm" id="frm_n_cust_nm" value='' readonly></td>
						</tr>
						<tr align="center">
							<th class="tr2_head" style="text-align:center;"><strong>Also NTFY</strong></th>
							<td class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_a_cust_cnt_cd" id="frm_a_cust_cnt_cd" value='' readonly>	</td>
							<td class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_a_cust_seq" id="frm_a_cust_seq" value='' readonly>	</td>
							<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_a_cust_nm" id="frm_a_cust_nm" value='' readonly></td>
						</tr>
						<tr align="center">
							<th class="tr2_head" style="text-align:center;"><strong>SC customer</strong></th>
							<td class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_p_cust_cnt_cd" id="frm_p_cust_cnt_cd" value='' readonly></td>
							<td class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_p_cust_seq" id="frm_p_cust_seq" value='' readonly>	</td>
							<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_p_cust_nm" id="frm_p_cust_nm" value='' readonly>	</td>
						</tr>
						<tr align="center">
							<th class="tr2_head" style="text-align:center;"><strong>Commodity</strong>&nbsp;</th>
							<td colspan="2" class="input2"><input type="text" style="width: 100%; text-align: right" class="input" name="frm_cmdt_cd" id="frm_cmdt_cd" value='' readonly ></td>
							<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_cmdt_nm" id="frm_cmdt_nm" value='' readonly></td>
						</tr>
						<tr align="center">
							<th class="tr2_head" style="text-align:center;"><strong>Rep. Commodity</strong></th>
							<td colspan="2" class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_rep_cmdt_cd" id="frm_rep_cmdt_cd" value='' readonly></td>
							<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_rep_cmdt_nm" id="frm_rep_cmdt_nm" value='' readonly></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
	    </div>
	    <div class="layout_vertical_3" style="width:3%">
	    	<div >&nbsp;</div>
	    </div>
	    <div class="layout_flex_flex" style="padding-left:700px;padding-top:3px">
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet0');</script>
			</div>
		</div>
	</div>
	<!-- layout_wrap(E) -->
</div>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="60">
					<col width="180">
					<col width="55">
					<col width="*">
				</colgroup>
				<tr class="h23">
					<th>Weight</th>
					<td><input type="text" style="width:108px;text-align:right;" class="input2" name="frm_act_wgt" id="frm_act_wgt" value="" readonly><input type="text" style="width:30px;text-align:right;" class="input2" name="frm_act_wgt1" id="frm_act_wgt1" value="" ></td>
					<th>Measure</th>
					<td><input type="text" style="width:110px;text-align:right;" class="input2" name="frm_meas_qty" id="frm_meas_qty" value="" readonly><input type="text" style="width:40px;text-align:center;" class="input2" name="frm_meas_ut_cd" id="frm_meas_ut_cd" value="" readonly></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="190">
					<col width="240">
					<col width="25">
					<col width="85">
					<col width="35">
					<col width="80">
					<col width="25">
					<col width="70">
					<col width="50">
					<col width="40">
					<col width="60">
					<col width="*">
				</colgroup>
				<tr>
					<th>Booking Route Information</th>
					<td>
						<input type="text" style="width:50px;" class="input2" name="frm_bkg_por_cd" id="frm_bkg_por_cd" value="" readonly><!--  
						--><input type="text" style="width:50px;" class="input2" name="frm_bkg_pol_cd" id="frm_bkg_pol_cd" value="" readonly><!--  
						--><input type="text" style="width:50px;" class="input2" name="frm_bkg_pod_cd" id="frm_bkg_pod_cd" value="" readonly><!--  
						--><input type="text" style="width:50px;" class="input2" name="frm_del_cd" id="frm_del_cd" value="" readonly>
					</td>
					<th>Pre</th>
					<td><input type="text" style="width:50px;text-align:center;" class="input2"  name="frm_vv_pol_cd" id="frm_vv_pol_cd"  value="" readonly></td>
					<th>Post</th>
					<td><input type="text" style="width:50px;text-align:center;" class="input2"  name="frm_vv_pod_cd" id="frm_vv_pod_cd" value="" readonly></td>
					<th>R/D</th>
					<td><input type="text" style="width:18px;text-align:center;" class="input2"  name="frm_rcv_term_cd" id="frm_rcv_term_cd" value="" readonly><input type="text" style="width:18px;text-align:center;" class="input2"  name="frm_de_term_cd" id="frm_de_term_cd"  value="" readonly></td>
					<th>Special</th>
					<td><input type="text" style="width:18px;text-align:center;" class="input2"  name="frm_special" id="frm_special" value="" readonly></td>
					<th>FRT Term</th>
					<td><input type="text" style="width:18px;text-align:center;" class="input2"  name="frm_frt_term_cd" id="frm_frt_term_cd" value="<%=JSPUtil.getParameter(request, "frt_term_cd")%>" readonly></td>
				</tr>
			</tbody>
		</table>
		<table border="0" style="width:979" id="multi_curr_msg"> 
			<tr>
				<td align="left" style="color: red;">&nbsp;<span id="span_multi_curr_msg"/></span></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid" style="display:none"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
	<div class="opus_design_grid" style="display:none"><script type="text/javascript">ComSheetObject('sheet2');</script></div>
	<div class="opus_design_grid"><script type="text/javascript">ComSheetObject('sheet3');</script></div>
	<div class="opus_design_grid"><script type="text/javascript">ComSheetObject('sheet4');</script></div>
	<div class="opus_design_grid"><script type="text/javascript">ComSheetObject('sheet5');</script></div>
</div>
</form>
