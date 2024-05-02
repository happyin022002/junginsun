<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_VSK_0015.jsp
*@FileTitle : Coastal SKD Simulation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	VopVsk0015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String eml = "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		eml = account.getUsr_eml();
		
		event = (VopVsk0015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
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
	}
</script>


<form name="form" id="form">
<input type="hidden" name="f_cmd"        id="f_cmd">
<input type="hidden" name="pagerows"     id="pagerows">
<input type="hidden" name="loc_cd"       id="loc_cd">
<input type="hidden" name="vps_port_cd"  id="vps_port_cd">
<input type="hidden" name="clpt_ind_seq" id="clpt_ind_seq">
<input type="hidden" name="yd_cd"        id="clpt_ind_seq">
<input type="hidden" name="rtv_flg"      id="rtv_flg">
<input type="hidden" name="fm_loc_cd"    id="fm_loc_cd">
<input type="hidden" name="to_loc_cd"    id="to_loc_cd">
<input type="hidden" name="vsl_sim_tp_cd"id="vsl_sim_tp_cd" value="C">
<input type="hidden" name="spd"          id="spd">
<input type="hidden" name="vps_eta_dt"   id="vps_eta_dt">
<input type="hidden" name="com_subject"  id="com_subject">
<input type="hidden" name="com_content"  id="com_content">
<input type="hidden" name="com_from"     id="com_from" value="<%=eml%>">
<input type="hidden" name="act_arr_dt"   id="act_arr_dt">
<input type="hidden" name="pre_port_cd"  id="pre_port_cd">
<input type="hidden" name="pre_etd_dt"   id="pre_etd_dt">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_e_mail" id="btn_e_mail" type="button">E-Mail</button><!--
		--><!--<button class="btn_normal" name="btn_settlement" id="btn_settlement" type="button">Settlement</button>--><!--
		--><button class="btn_normal" name="btn_loadableweight" id="btn_loadableweight" type="button">Loadable Weight</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
			   
				<col width="0"  />
				<col width="100"/>		
				<col width="90" />	
				<col width="90" />		
				<col width="90" />
				<col width="90" />
				<col width="*"  />
		   </colgroup>
			<tbody>
				<tr>
				   
					<td rowspan="2" style="width:0px;">
					
					<input type="radio" name="rdo_tran"  id="rdo_tran1" value="" class="trans" style="display:none;" checked="checked">
					<!-- //::FOR.NYK.START::by dongsoo:2014-09-17:://	
					<label for="rdo_tran1"><b>Coastal SKD</b></label><br><br>
					//::FOR.NYK.FINISH::by dongsoo:2014-09-17::// -->
					<input type="radio" name="rdo_tran" id="rdo_tran2" value="" class="trans" style="display:none;">
					 <!-- //::FOR.NYK.START::by dongsoo:2014-09-17:://	
					<label for="rdo_tran2"><b>Recovery Plan</b></label>
					 //::FOR.NYK.FINISH::by dongsoo:2014-09-17:://-->
					</td>
					<th title="Vessel Voyage Direction">VVD</th>   
					<td><input type="text" name="vsl_cd" id="vsl_cd" dataformat ="engup" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><!-- 
					 --><input type="text" name="skd_voy_no" id="skd_voy_no" dataformat ="num" style="width:40px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><!--
					 --><input type="text" name="skd_dir_cd" id="skd_dir_cd" dataformat ="enguponly" style="width:25px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();"><!-- 
					 --><button type="button" id="btn_vvd_search" name="btn_vvd_search" class="input_seach_btn"></button></td>
					<th>Bound</th>
					<td><select name="bound" id="bound" style="width:50px;" class="input">
						<option value="1">1</option>
						<option value="3" selected="selected">3</option>
						<option value="5">5</option>
						</select></td>
					<!-- <th>&nbsp;</th>
					<td><input type="text" name="sim_dt" id="sim_dt" style="width:80px;text-align:center;" class="input2" value="" maxlength="10" readonly="readonly">
					<input type="text" name="sim_no" id="sim_no" style="width:40px;text-align:center;" class="input2" value="" readonly="readonly"> 
					<button type="button" id="btn_sim_no" name="btn_sim_no" class="input_seach_btn"></button></td> -->
					<th>Created Date</th>
					<td><input type="text" name="cre_dt" id="cre_dt" style="width:115px;text-align:center;" class="input2" value="" readonly="readonly"><!-- 
					 --><input type="text" name="cre_usr_id" id="cre_usr_id" style="width:100px;;text-align:center;" class="input2" value="" readonly="readonly"></td>
				</tr>
				<tr>
					<th>Lane Code</th>
					<td><input type="text" name="vsl_slan_cd" id="vsl_slan_cd" style="width:50px;text-align:center;" class="input2" value="" readonly="readonly"></td>    
					<th>P/F SKD Type</th>
					<td><input type="text" name="pf_svc_tp_cd" id="pf_svc_tp_cd" style="width:50px;text-align:center;" class="input2" value="" readonly="readonly"></th>
					<th>Updated Date</th>
					<td><input type="text" name="upd_dt" id="upd_dt" style="width:115px;text-align:center;" class="input2" value="" readonly="readonly"><!-- 
					 --><input type="text" name="upd_usr_id" style="width:100px;;text-align:center;" class="input2" value="" readonly="readonly"></td>
				</tr>	
			</tbody>
		</table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="clear">		  
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<table>
					<tr>

					
						<td><div id="div_reverse_call_1"><button class="btn_accent"  type="button" name="btn_reverse_call_1" id="btn_reverse_call_1">Reverse Call</button></div><!-- 
			 				--><div id="div_reverse_call_2" style="display:none;"><button class="btn_normal"  type="button" name="btn_reverse_call_2" id="btn_reverse_call_2">Reverse Call</button></div></td>
						<td><div id="div_skip_call_1"><button class="btn_normal" name="btn_skip_call_1" id="btn_skip_call_1" type="button">Skip Call</button></div><!-- 
			 				--><div id="div_skip_call_2" style="display:none;"><button class="btn_normal" name="btn_skip_call_2" id="btn_skip_call_2" type="button">Skip Call</button></div></td>
			 				
					    <td><div id="div_skip_call_cancel_1"><button class="btn_normal" name="btn_skip_call_cancel_1" id="btn_skip_call_cancel_1" type="button">Skip Call Cancel</button></div><!-- 
						 --><div id="div_skip_call_cancel_2" style="display:none;"><button class="btn_normal"  name="btn_skip_call_cancel_2" id="btn_skip_call_cancel_2" type="button">Skip Call Cancel</button></div></td>

			 				
						<td><div id="div_add_call_1"><button class="btn_normal" id="btn_add_call_1" type="button" name="btn_add_call_1">ADD Call</button></div><!-- 
			 				--><div id="div_add_call_2" style="display:none;"><button class="btn_normal" name="btn_add_call_2" id="btn_add_call_2" type="button">Load Excel</button></div></td>
						<td><div id="div_row_hide_1"><button class="btn_normal" name="btn_row_hide_1" id="btn_row_hide_1" type="button">Row Hide</button></div><!-- 
			 				--><div id="div_row_hide_2" style="display:none;"><button class="btn_normal" name="btn_row_hide_2" id="btn_row_hide_2" type="button">Row Hide</button></div></td>
						<td><div id="div_row_hide_cancel_1"><button class="btn_normal" name="btn_row_hide_cancel_1" id="btn_row_hide_cancel_1" type="button">Row Hide Cancel</button></div><!-- 
			 			--><div id="div_row_hide_cancel_2" style="display:none;"><button class="btn_normal" name="btn_row_hide_cancel_2" id="btn_row_hide_cancel_2" type="button">Row Hide Cancel</button></div></td>
						<td style="padding-left:2px;"><div id="div_col_show"></div><div id="div_plan_col_show" style="display: none" style="padding-left:2px;"> </div> </td>
					</tr>
			</table>
		</div>
		</div>
		
		<th><label style="color:blue;"><b>* Auto Update doesn't work under checkbox ticked for subsequent ports.</b></label>
			&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="chk_voyage" id="chk_voyage" value="" class="trans" >&nbsp;<b>Voyage</b>&nbsp;
			<input type="text" id="voyage" name="voyage" style="width:105px;text-align:center;ime-mode:disabled;" class="input" value="" dataformat="engupetc" maxlength="10" onfocus="this.select();" >
			<button class="btn_normal" id="btn_apply" name="btn_apply" type="button">Apply</button>
		</th>
		
		<div class="opus_design_btn">
			<table>
				<tbody>
					<tr>
					
						<!-- td><div id="div_priv_call_1"><button class="btn_accent"  type="button" name="div_priv_call_1" id="div_priv_call_1">Private Call</button></div>
							<div id="div_priv_call_cancel_1" style="display:none;"><button class="btn_normal"  type="button" name="div_priv_call_cancel_1" id="div_priv_call_cancel_1">Private Call Cancel</button></div></td -->
						
						<td><div id="div_vsl_rename_1"><button class="btn_accent"  type="button" name="btn_vsl_rename_1" id="btn_vsl_rename_1">Vessel Rename</button></div><!-- 
			 				--><div id="div_vsl_rename_2" style="display:none;"><button class="btn_normal"  type="button" name="btn_vsl_rename_2" id="btn_vsl_rename_2">Vessel Rename</button></div></td>
						<td><div id="div_vsl_slide_1"><button class="btn_accent"  type="button" name="btn_vsl_slide_1" id="btn_vsl_slide_1">Vessel Slide</button></div><!-- 
			 				--><div id="div_vsl_slide_2" style="display:none;"><button class="btn_normal"  type="button" name="btn_vsl_slide_2" id="btn_vsl_slide_2">Vessel Slide</button></div></td>
						<td><div id="div_p_in_1"><button class="btn_accent"  type="button" name="btn_p_in_1" id="btn_p_in_1">Phase In</button></div><!-- 
			 				--><div id="div_p_in_2" style="display:none;"><button class="btn_normal"  type="button" name="btn_p_in_2" id="btn_p_in_2">Phase In</button></div></td>
						<td><div id="div_p_in_cancel_1"><button class="btn_accent"  type="button" name="btn_p_in_cancel_1" id="btn_p_in_cancel_1">Phase In Cancel</button></div><!-- 
			 				--><div id="div_p_in_cancel_2" style="display:none;"><button class="btn_normal"  type="button" name="btn_p_in_cancel_2" id="btn_p_in_cancel_2">Phase In Cancel</button></div></td>

						<td><div id="div_p_out_1"><button class="btn_normal" name="btn_p_out_1" id="btn_p_out_1" type="button">Phase Out</button></div><!-- 
			 				--><div id="div_p_out_2" style="display:none;"><button class="btn_normal" name="btn_p_out_2" id="btn_p_out_2" type="button">Phase Out</button></div></td>
						<td><div id="div_p_out_cancel_1"><button class="btn_normal" name="btn_p_out_cancel_1" id="btn_p_out_cancel_1" type="button">Phase Out Cancel</button></div><!-- 
							--><div id="div_p_out_cancel_2" style="display:none;"><button class="btn_normal"  name="btn_p_out_cancel_2" id="btn_p_out_cancel_2" type="button">Phase Out Cancel</button></div></td>

											
						<td><div id="div_add_call_cancel_1"><button class="btn_normal" name="btn_add_call_cancel_1" id="btn_add_call_cancel_1" type="button">ADD Call Cancel</button></div><!-- 
			  				--><div id="div_add_call_cancel_2" style="display:none;"><button class="btn_normal" name="btn_add_call_cancel_2" id="btn_add_call_cancel_2" type="button">ADD Call Cancel</button></div>
						</td>
						<td><div id="div_col_hide" style="padding-left:2px;"></div ><div id="div_plan_col_hide" style="display: none" style="padding-left:2px;"></div></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- 
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		 -->		
	</div>
	<!-- opus_design_grid(E) -->

	<div class="opus_design_data">
		<table class="grid_2" style = "width: 1256px">
			<colgroup>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Remark(s)</th> 
					<td><textarea style="width:100%;height:50px;ime-mode:disabled; resize:none;" name="skd_rmk" id="skd_rmk" class="textarea"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="div_remark_tmp"  style="display:none">
		<table >
			<tr>
				<td>
					<div id="div_remark">
						<script type="text/javascript">ComComboObject('remark',1,104,1,0);</script>
					</div>
				</td>
			</tr>
		</table>
	</div>
	
</div>
</form>
