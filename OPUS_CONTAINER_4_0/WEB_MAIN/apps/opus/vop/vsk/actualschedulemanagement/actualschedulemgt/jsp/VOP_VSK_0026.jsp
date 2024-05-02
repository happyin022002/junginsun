<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName :  VOP_VSK_0026.jsp
*@FileTitle : Actual SKD Report Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ActualScheduleManagement.ActualScheduleMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="port_skd_sts_cd" id="port_skd_sts_cd">
<input type="hidden" name="clpt_seq" id="clpt_seq">
<input type="hidden" name="turn_port_flg" id="turn_port_flg">
<input type="hidden" name="turn_port_ind_cd" id="turn_port_ind_cd">
<input type="hidden" name="turn_skd_voy_no" id="turn_skd_voy_no">
<input type="hidden" name="turn_skd_dir_cd" id="turn_skd_dir_cd">
<input type="hidden" name="turn_clpt_ind_seq" id="turn_clpt_ind_seq">
<input type="hidden" name="pre_port_cd" id="pre_port_cd">
<input type="hidden" name="pre_etd_dt" id="pre_etd_dt">

<!-- <input type="hidden" name="lst_eta_dt" id="lst_eta_dt">
<input type="hidden" name="lst_etb_dt" id="lst_etb_dt">
<input type="hidden" name="lst_etd_dt" id="lst_etd_dt"> -->

<input type="hidden" name="vps_eta_dt" id="vps_eta_dt">
<input type="hidden" name="vps_etb_dt" id="vps_eta_dt">
<input type="hidden" name="vps_etd_dt" id="vps_eta_dt">

<input type="hidden" name="loc_cd" id="loc_cd">
<!-- RD -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="">   
<input type="hidden" name="com_mrdSaveDialogFileExt" id="com_mrdSaveDialogFileExt" value="ppt">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" id="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt">
<input type="hidden" name="com_mrdSaveDialogFileName" id="com_mrdSaveDialogFileName" value="">
<input type="hidden" name="com_mrdSaveDialogDir" id="com_mrdSaveDialogDir" value="c:\users\">
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" value="">

<input type="hidden" name= "clpt_ind_seq">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 		
		 --><button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print_arr" 	id="btn_print_arr">Arrival Report</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_print_dep" 	id="btn_print_dep">Departure Report</button><!-- 								
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
<table>
	<tbody>
		<colgroup>
			<col width="100"/>
			<col width="100"/>
			<col width="100"/>																
			<col width="165"/>																
			<col width="60"/>																
			<col width="90"/>																
			<col width="81"/>	
			<col width="*" />
		</colgroup>
		
		<tr>
			<th title="Vessel Voyage Direction">VVD</th>
			<td> <input type="text" name="vsl_cd"     id="vsl_cd"     dataformat="engup"     style="width:48px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><!-- 
			  --><input type="text" name="skd_voy_no" id="skd_voy_no" dataformat="num"       style="width:48px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><!-- 
			  --><input type="text" name="skd_dir_cd" id="skd_dir_cd" dataformat="enguponly" style="width:25px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();" ><!--  
			  --><!-- <input type="hidden" name="hidden1" id="hidden1" style="width:0px;"  value="" > -->
			  	<button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button></td>
			<th>Port</th>
			<td width="390"><script language="javascript">ComComboObject('vps_port_cd', 4, 100, 1, 1, 1);</script></td>
			<!-- 
			<th>Call Ind.</th>
			<td><select name="clpt_ind_seq" id="clpt_ind_seq" style="width:80px;" class="input1"></select></td>
			 -->
			<th>Created Date</th>
			<td><input type="text" name="cre_dt" id="cre_dt" style="width:110px;text-align:center;" class="input2" value="" readonly="readonly"><input type="text" name="cre_usr_id" id="cre_usr_id" style="width:70px;" class="input2" value="" readonly="readonly"></td>
		</tr>
		<tr>
			<!-- 
			<th>Calling Terminal</th>
			<td><script  type="text/javascript">ComComboObject('yd_cd',2,85,1,0);</script></td>
			 -->
			<th>Vessel Condition</th>
			<td colspan="3" ><input type="text" name="port_skd_sts_nm" id="port_skd_sts_nm" style="width:80px;text-align:center;" class="input2" value="" readonly="readonly"></td>
			<th>Updated Date</th>
			<td><input type="text" name="upd_dt" id="upd_dt" style="width:110px;text-align:center;" class="input2" value="" readonly="readonly"><input type="text" name="upd_usr_id" id="upd_usr_id" style="width:70px;" class="input2"  value="" readonly="readonly"></td>				
		</tr>					
		<tr>
			<th>Remark(s)</th>
			<td colspan="7"><textarea name="diff_rmk" id="diff_rmk" style="width:775px;height:40px;ime-mode:disabled;resize: none;" readonly="readonly"></textarea></td>
		</tr>
		<%--<tr>
			<th>Port</th>
			<td><input type="text" name="vps_port_cd" id="vps_port_cd" dataformat="enguponly" style="width:62px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" onfocus="this.select();"><button type="button" id="btn_port" name="btn_port" class="input_seach_btn"></button></td>
			<th title="Vessel Voyage Direction">VVD</th>
			<td><input type="text" name="vsl_cd" id="vsl_cd" dataformat="engup" style="width:48px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><input type="text" name="skd_voy_no" id="skd_voy_no" dataformat="num" style="width:48px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><input type="text" name="skd_dir_cd" id="skd_dir_cd" dataformat="enguponly" style="width:25px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();"><button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button></td>
			<th>Call Ind.</th>
			<td><select name="clpt_ind_seq" id="clpt_ind_seq" style="width:80px;" class="input1"></select></td>
			<th>Created Date</th>
			<td><input type="text" name="cre_dt" id="cre_dt" style="width:150px;height:100%;text-align:center;" class="input2" value="" readonly="readonly"><input type="text" name="cre_usr_id" id="cre_usr_id" style="width:70px;" class="input2" value="" readonly="readonly"></td>
		</tr>
		<tr>
			<th>Calling Terminal</th>
			<td><input type="text" name="yd_cd" id="yd_cd" style="width:80px;text-align:center;" class="input2" value="" readonly="readonly"></td>
			<th>Vessel Condition</th>
			<td colspan="3"><input type="text" name="port_skd_sts_nm" id="port_skd_sts_nm" style="width:80px;text-align:center;" class="input2" value="" readonly="readonly"></td>
			<th>Updated Date</th>
			<td><input type="text" name="upd_dt" id="upd_dt" style="width:150px;height:100%;text-align:center;" class="input2" value="" readonly="readonly"><input type="text" name="upd_usr_id" id="upd_usr_id" style="width:70px;" class="input2"  value="" readonly="readonly"></td>				
		</tr>					
		<tr>
			<th>Remark(s)</th>
			<td colspan="7"><textarea name="diff_rmk" id="diff_rmk" class="input2" style="width:751px;height:40px;ime-mode:disabled;resize: none;" readonly="readonly"></textarea></td>
		</tr> --%>
	</tbody>
</table>	
</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	
	<!-- opus_design_data(S) -->
	<div class="opus_design_inquiry  wFit">
		<table class="grid_2">
			<tbody>
				<tr>
					<th></th>
					<th style="text-align:center">P/F SKD</th>
					<th style="text-align:center">Initial Estimate SKD</th>
					<th style="text-align:center">Actual SKD</th>
					<th style="text-align:center">Delay(Time)</th>
					<th style="text-align:center" colspan="2">Delay Reason</th>
				</tr>				
				<tr>
					<th style="text-align:center">Arrival</th>
					<td><input type="text" name="pf_eta_dt" id="pf_eta_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="lst_eta_dt" id="lst_eta_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="act_arr_dt" id="act_arr_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" maxlength="14" readonly="readonly"></td>
					<td style="text-align:center"><input type="text" name="dlay_arr_tm" id="dlay_arr_tm" style="width:100%;text-align:Right;" class="noinput" value="" readonly="readonly"></td>
					<td style="text-align:center"><input type="text" name="vsl_arr_dlay_rsn_cd" id="vsl_arr_dlay_rsn_cd" style="width:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="vsl_arr_dlay_rsn_nm" id="vsl_arr_dlay_rsn_nm" style="width:100%;" class="noinput" value="" readonly="readonly"></td>
				</tr>				
				<tr>
					<th style="text-align:center">Berthing</th>
					<td><input type="text" name="pf_etb_dt" id="pf_etb_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="lst_etb_dt" id="lst_etb_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="act_brth_dt" id="act_brth_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" maxlength="14" readonly="readonly"></td>
					<td style="text-align:center"><input type="text" name="dlay_brth_tm" id="dlay_brth_tm" style="width:100%;text-align:Right;" class="noinput" value="" readonly="readonly"></td>
					<td style="text-align:center"><input type="text" name="vsl_brth_dlay_rsn_cd" id="vsl_brth_dlay_rsn_cd" style="width:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="vsl_brth_dlay_rsn_nm" id="vsl_brth_dlay_rsn_nm" style="width:100%;" class="noinput" value="" readonly="readonly"></td>
				</tr>				
				<tr>
					<th style="text-align:center">Departure</th>
					<td><input type="text" name="pf_etd_dt" id="pf_etd_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="lst_etd_dt" id="lst_etd_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="act_dep_dt" id="act_dep_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" maxlength="14" readonly="readonly"></td>
					<td style="text-align:center"><input type="text" name="dlay_dep_tm" id="dlay_dep_tm" style="width:100%;text-align:Right;" class="noinput" value="" readonly="readonly"></td>
					<td style="text-align:center"><input type="text" name="vsl_dep_dlay_rsn_cd" id="vsl_dep_dlay_rsn_cd" style="width:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="vsl_dep_dlay_rsn_nm" id="vsl_dep_dlay_rsn_nm" style="width:100%;" class="noinput" value="" readonly="readonly"></td>
				</tr>				
				<tr>
					<th style="text-align:center" colspan="3">Last Pilot Off</th>
					<td><input type="text" name="plt_lst_unld_dt" id="plt_lst_unld_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" maxlength="14" readonly="readonly"></td>
					<td colspan="3"></td>
				</tr>				
				<tr>
					<th style="text-align:center" colspan="3">Anchor Drop/Away Before Berthing</th>
					<td><input type="text" name="bfr_brth_ank_drp_dt" id="bfr_brth_ank_drp_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" maxlength="14" readonly="readonly"></td>
					<td><input type="text" name="bfr_brth_ank_off_dt" id="bfr_brth_ank_off_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" maxlength="14" readonly="readonly"></td>
					<td colspan="2"></td>
				</tr>				
				<tr>
					<th style="text-align:center" colspan="3">Anchor Drop/Away After Departure</th>
					<td><input type="text" name="aft_unbrth_ank_drp_dt" id="aft_unbrth_ank_drp_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" maxlength="14" readonly="readonly"></td>
					<td><input type="text" name="aft_unbrth_ank_off_dt" id="aft_unbrth_ank_off_dt" style="width:100%;height:100%;ime-mode:disabled;text-align:center;" class="noinput" value="" maxlength="14" readonly="readonly"></td>
					<td colspan="2"></td>
				</tr>				
				<tr>
					<th style="text-align:center" colspan="2">Next Port ETA</th>
					<td><input type="text" name="nxt_port_cd" id="nxt_port_cd" style="width:100%;height:100%;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td><input type="text" name="nxt_eta_dt" id="nxt_eta_dt" style="width:100%;height:100%;text-align:center;" class="noinput" value="" readonly="readonly"></td>
					<td colspan="3"></td>
				</tr>
			</tbody>			
		</table>
	</div>
	<!-- opus_design_data(E) -->
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>	
</div>
<!-- opus_design_grid(S) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
	
	<!-- opus_design_data(S) -->
	<div class="opus_design_inquiry wFit">
		<table class="grid_2">
			<tbody>
				<tr>
					<th></th>
					<th style="text-align:center" colspan="2">Arrival</th>
					<th></th>
					<th style="text-align:center" colspan="2">Departure</th>
					<th></th>
					<th style="text-align:center" colspan="2">Supply</th>
					<th></th>
				</tr> 				
				<tr>
					<th style="text-align:center">Fuel Oil</th>
					<td colspan="2"><input type="text" name="arr_foil_wgt" id="arr_foil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="dep_foil_wgt" id="dep_foil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="spl_foil_wgt" id="spl_foil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
				</tr>				
				<tr>
					<th style="text-align:center">Low Sulphur Fuel Oil</th>
					<td colspan="2"><input type="text" name="arr_low_sulp_foil_wgt" id="arr_low_sulp_foil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="dep_low_sulp_foil_wgt" id="dep_low_sulp_foil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="spl_low_sulp_foil_wgt" id="spl_low_sulp_foil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
				</tr>				
				<tr>
					<th style="text-align:center">Diesel Oil</th>
					<td colspan="2"><input type="text" name="arr_doil_wgt" id="arr_doil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="dep_doil_wgt" id="dep_doil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="spl_doil_wgt" id="spl_doil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
				</tr>				
				<tr>
					<th style="text-align:center">Low Sulphur Diesel Oil</th>
					<td colspan="2"><input type="text" name="arr_low_sulp_doil_wgt" id="arr_low_sulp_doil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="dep_low_sulp_doil_wgt" id="dep_low_sulp_doil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="spl_low_sulp_doil_wgt" id="spl_low_sulp_doil_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
				</tr>				
				<tr>
					<th style="text-align:center">Fresh Water</th>
					<td colspan="2"><input type="text" name="arr_frsh_wtr_wgt" id="arr_frsh_wtr_wgt"  style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="dep_frsh_wtr_wgt" id="dep_frsh_wtr_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="spl_frsh_wtr_wgt" id="spl_frsh_wtr_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
				</tr>				
				<tr>
					<th style="text-align:center">Ballast</th>
					<td colspan="2"><input type="text" name="arr_blst_wgt" id="arr_blst_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<td colspan="2"><input type="text" name="dep_blst_wgt" id="dep_blst_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
					<th style="text-align:center" colspan="2">Discharging</th>
					<th></th>
				</tr>				
				<tr>
					<th style="text-align:center">Draft Forward</th>
					<td colspan="2"><input type="text" name="arr_fwddr_hgt" id="arr_fwddr_hgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M</td>
					<td colspan="2"><input type="text" name="dep_fwddr_hgt" id="dep_fwddr_hgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M</td>
					<th style="text-align:center">Sludge</th>
					<td><input type="text" name="ttl_slg_wgt" id="ttl_slg_wgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M/T</td>
				</tr>				
				<tr>
					<th style="text-align:center">Draft After</th>
					<td colspan="2"><input type="text" name="arr_aftdr_hgt" id="arr_aftdr_hgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M</td>
					<td colspan="2"><input type="text" name="dep_aftdr_hgt" id="dep_aftdr_hgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">M</td>
					<th style="text-align:center">Garbage</th>
					<td><input type="text" name="ttl_gbg_qty" id="ttl_gbg_qty" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">CBM</td>
				</tr>				
				<tr>
					<th style="text-align:center">GM</th>
					<td colspan="2"><input type="text" name="arr_gm_hgt" id="arr_gm_hgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>					
					<td style="text-align:center">M</td>
					<td colspan="2"><input type="text" name="dep_gm_hgt" id="dep_gm_hgt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>					
					<td style="text-align:center">M</td>
					<td colspan="3"></td>
				</tr>				
				<tr>
					<th style="text-align:center">No. of TUG</th>
					<td colspan="2"><input type="text" name="arr_tug_bot_knt" id="arr_tug_bot_knt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">EA</td>
					<td colspan="2"><input type="text" name="dep_tug_bot_knt" id="dep_tug_bot_knt" style="width:100%;height:100%;text-align:right;" class="noinput" value="" maxlength="10" readonly="readonly"></td>
					<td style="text-align:center">EA</td>
					<td colspan="3"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_data(E) -->	
</div>
<!-- opus_design_grid(S) -->
</div>
</form>
