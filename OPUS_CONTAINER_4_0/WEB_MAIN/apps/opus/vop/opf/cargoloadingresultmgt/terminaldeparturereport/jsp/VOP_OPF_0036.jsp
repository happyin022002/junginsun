<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0036.jsp
*@FileTitle  : TDR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm(); 


		event = (VopOpf0036Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="port_cd" id="port_cd" />
<input type="hidden" name="voy_no" id="voy_no" />
<input type="hidden" name="dir_cd" id="dir_cd" />
<input type="hidden" name="clpt_ind_seq" id="clpt_ind_seq" />
<input type="hidden" name="sys_create" value="In" id="sys_create" />
<input type="hidden" name="comboCd" value="" id="comboCd" />

<input type="hidden" name="chkDate" dataformat="ymdhm" id="chkDate" />
<!-- Container Status -->
<input type="hidden" name="status1" id="status1" />
<input type="hidden" name="status2" id="status2" />
<!-- Specail Carge Status -->
<input type="hidden" name="sc_status1" id="sc_status1" />
<input type="hidden" name="sc_status2" id="sc_status2" />
<input type="hidden" name="sc_status3" id="sc_status3" />
<input type="hidden" name="cargo_type1" id="cargo_type1" />
<input type="hidden" name="cargo_type2" id="cargo_type2" />
<!-- Container No Search -->
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="misHandleChk" value="SD" id="misHandleChk" />

<!-- TDR_UTILIZE Carge Status -->
<input type="hidden" name="sl_status1" id="sl_status1" />
<input type="hidden" name="sl_status2" id="sl_status2" />

<!-- Report Popup -->
<input type="hidden" size="200" name="com_mrdPath" value="apps/opus/vop/opf/cargoloadingresultmgt/terminaldeparturereport/report/VOP_OPF_1036.mrd" id="com_mrdPath" />
<input type="hidden" size="200" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\" id="com_mrdSaveDialogDir" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="TerminalDepartureReport" id="com_mrdSaveDialogFileName" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" size="200" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" size="200" name="com_mrdTitle" value="Terminal Departure Report" id="com_mrdTitle" />
<input type="hidden" size="200" name="com_mrdBodyTitle" value="Terminal Departure Report" id="com_mrdBodyTitle" />
<input type="hidden" size="200" name="com_isBatch" value="Y" id="com_isBatch" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_ExcludefromTPR" id="btn_ExcludefromTPR" type="button">Exclude from TPR</button><!--
		--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

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
			<colgroup>
				<col width="70" />				
				<col width="180" />				
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>VVD CD</th>
					<td><!-- required fullfill  --><!-- 
					 --><input type="text" style="width:55px;" class="input1" name="vsl_cd" caption="Vessel Code" maxlength="4" dataformat="engup" id="vsl_cd" onchange="vsl_cd_onchange()"/><!-- 
					 --><input type="text" style="width:40px;" class="input1" name="skd_voy_no" caption="Schedule Voyage Number" maxlength="4" dataformat="num" id="skd_voy_no" onchange="skd_voy_no_onchange()"/><!-- 
					 --><input type="text" style="width:20px;" class="input1" name="skd_dir_cd" caption="Schedule Direction Code" maxlength="1" dataformat="enguponly" id="skd_dir_cd" /><!-- 
					 --><button type="button" id="btns_searchVvd" name="btns_searchVvd" class="input_seach_btn"></button>

					</td>
					<th>Port</th>
						<td><script language="javascript">ComComboObject('yd_cd', 3, 100, 0, 1, 0, true);</script>&nbsp;
							<input type="text" style="width:340px;" class="input2" name="yd_nm" id="yd_nm" readonly></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tabTdr')</script>
	</div>
	<!-- opus_design_tab(E) -->
	
	<!-- TAB [ SKD & COND ] (S) -->
	<div id="tabLayer" style="display:none;">
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry wFit">
					<table>
						<tr>
							<td><h3 class="title_design">Arrival/Departure Time</h3>	</td>
							
		                    <td><!-- opus_design_btn (S) -->
								<div class="opus_design_btn">
								<button class="btn_accent" name="btn_t1ActualInfo" id="btn_t1ActualInfo" type="button">Import Actual SKD & Cond</button><!--
								--></div>
								<!-- opus_design_btn (E) -->		                    
		                    </td>
		                                  
						</tr>
					</table>
					<div class="opus_design_data">
						<table class="grid_2"> 
							<colgroup>
								<col width="200" />				
								<col width="*" />				
								<col width="200" />	
								<col width="*" />							
						   </colgroup> 
						   <tbody>
								<tr>
									<th style="text-align:center; padding:3px" colspan="2"><b>Arrival</b></th>
									<th style="text-align:center;" colspan="2"><b>Departure</b></th>
								</tr>
								<tr>
									<th style="text-align:center;"><b>First Pilot On</b></th>
									<td class="input2" style="padding:3px"><input type="text" style="width:120px;" class="input" value="" name="first_pilot_on" maxlength="16" dataformat="ymdhm" caption="First Pilot On" id="first_pilot_on" /> </td>
									<th style="text-align:center;"><b>Unberth</b></th>
									<td class="input2" style="padding:3px"><input type="text" style="width:120px;" class="input" value="" name="unberth" maxlength="16" dataformat="ymdhm" id="unberth" /> </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>Anchorage</b></th>
									<td class="input2" style="padding:3px"><input type="text" style="width:120px;" class="input" value="" name="anchorage_arr" dataformat="ymdhm" maxlength="16" id="anchorage_arr" /> </td>
									<th style="text-align:center;"><b>Anchorage</b></th>
									<td class="input2" style="padding:3px"><input type="text" style="width:120px;" class="input" value="" name="anchorage_dep" dataformat="ymdhm" maxlength="16" id="anchorage_dep" /> </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>Berth</b></th>
									<td class="input2" style="padding:3px"><input type="text" style="width:120px;" class="input" value="" name="berth" dataformat="ymdhm" maxlength="16" id="berth" /> </td>
									<th style="text-align:center;"><b>Last Pilot Off</b></th>
									<td class="input2" style="padding:3px"><input type="text" style="width:120px;" class="input" value="" name="last_pilot_off" dataformat="ymdhm" maxlength="16" id="last_pilot_off" /> </td>
								</tr>
								<tr>
									<td colspan="2" rowspan="2" class="input2"></td>
									<th style="text-align:center; padding:3px"><b>ETA Next Port</b></th>
<!--
									<td class="sm"><input type="text" style="width:55px;" value="" name="eta_next_port" required="" fullfill="" readonly id="eta_next_port" />&nbsp;<input type="text" style="width:120px;" value="" name="eta_next_date" dataformat="ymdhm" maxlength="12" readonly id="eta_next_date" />  </td>
-->
									<td class="sm" style="padding:3px"><input type="text" style="width:55px;" value="" name="eta_next_port" readonly id="eta_next_port" />&nbsp;<input type="text" style="width:120px;" value="" name="eta_next_date" dataformat="ymdhm" maxlength="16" readonly id="eta_next_date" />  </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>ETA Canal</b></th>
<!--
									<td class="sm"><input type="text" style="width:55px;"  value="" name="next_canal" required="" fullfill="" readonly id="next_canal" />&nbsp;<input type="text" style="width:120px;" value="" name="eta_canal" dataformat="ymdhm" maxlength="12" readonly id="eta_canal" />  </td>
-->
									<td class="sm" style="padding:3px"><input type="text" style="width:55px;"  value="" name="next_canal" readonly id="next_canal" />&nbsp;<input type="text" style="width:120px;" value="" name="eta_canal" dataformat="ymdhm" maxlength="16" readonly id="eta_canal" />  </td>
								</tr>
							</tbody>
						</table>
					</div>
		
					<table class="line_bluedot mar_top_12"><tr><td colspan="8"></td></tr></table>
					<h3 class="title_design mar_btm_8">Vessel Condition</h3>
					
					<div class="opus_design_data">
						<table class="grid_2">
							<colgroup>
								<col width="150" />				
								<col width="90" />				
								<col width="90" />	
								<col width="90" />				
								<col width="90" />				
								<col width="90" />
								<col width="*" />				
								<col width="90" />				
								<col width="90" />	
								<col width="90" />				
								<col width="90" />				
								<col width="90" />
								<col width="*" />				
						   </colgroup> 
						   <tbody>
								<tr>
									<th></th>
									<th colspan="6" style="text-align:center; padding:3px;"><b>Arrival</b></th>
									<th colspan="6" style="text-align:center;"><b>Departure</b></th>
								</tr>
								<tr>
									<th style="text-align:center;"><b>Draft (meter)</b></th>
									<th style="text-align:center;"><b>FWD</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="arr_draft_fwd" dataformat="float" otherchar="-" otherchar="-" maxlength="6" id="arr_draft_fwd" /> </td>
									<th style="text-align:center;"><b>AFT</b></th>
									<td class="input2" style="padding:3px;" colspan="3"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="arr_draft_aft" dataformat="float" otherchar="-" otherchar="-" maxlength="6" id="arr_draft_aft" /> </td>
									<th class="input2" style="text-align:center;"><b>FWD</b></th>
									<td style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_draft_fwd" dataformat="float" otherchar="-" otherchar="-" maxlength="6" id="dep_draft_fwd" /> </td>
									<th class="input2" style="text-align:center;"><b>AFT</b></th>
									<td class="input2" style="padding:3px;" colspan="3"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_draft_aft" dataformat="float" otherchar="-" otherchar="-" maxlength="6" id="dep_draft_aft" /> </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>Ballast (M/T)</b></th>
									<td colspan="6" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="arr_ballast" dataformat="float" otherchar="-" otherchar="-" maxlength="12" id="arr_ballast" /> </td>
									<td colspan="6" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="dep_ballast" dataformat="float" otherchar="-" otherchar="-" maxlength="12" id="dep_ballast" /> </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>ROB (M/T)</b></th>
									<th style="text-align:center;" style="padding:3px;"><b>F.O</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="arr_rob_fo" dataformat="float" otherchar="-" otherchar="-" maxlength="12" id="arr_rob_fo" /> </td>
									<th style="text-align:center;"><b>D.O</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="arr_rob_do" dataformat="float" otherchar="-" maxlength="12" id="arr_rob_do" /> </td>
									<th style="text-align:center;"><b>F.W</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:90px;text-align:right;" class="input" value="" name="arr_rob_fw" dataformat="float" otherchar="-" maxlength="12" id="arr_rob_fw" /> </td>
									<th style="text-align:center;"><b>F.O</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_rob_fo" dataformat="float" otherchar="-" maxlength="12" id="dep_rob_fo" /> </td>
									<th style="text-align:center;"><b>D.O</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_rob_do" dataformat="float" otherchar="-" maxlength="12" id="dep_rob_do" /> </td>
									<th style="text-align:center;"><b>F.W</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:90px;text-align:right;" class="input" value="" name="dep_rob_fw" dataformat="float" otherchar="-" maxlength="12" id="dep_rob_fw" /> </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>Low Sulphur (M/T)</b></th>
									<th style="text-align:center;"><b>F.O</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="arr_low_sul_fo" maxlength="12" dataformat="float" otherchar="-" id="arr_low_sul_fo" /> </td>
									<th style="text-align:center;"><b>D.O</b></th>
									<td class="input2" style="padding:3px;" colspan="3"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="arr_low_sul_do" maxlength="12" dataformat="float" otherchar="-" id="arr_low_sul_do" /> </td>
									<th style="text-align:center;"><b>F.O</b></th>
									<td class="input2"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_low_sul_fo" maxlength="12" dataformat="float" otherchar="-" id="dep_low_sul_fo" /> </td>
									<th style="text-align:center;"><b>D.O</b></th>
									<td class="input2" colspan="3" ><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_low_sul_do" maxlength="12" dataformat="float" otherchar="-" id="dep_low_sul_do" /> </td>
								</tr>
								<tr>
									<th  colspan="7"><b>Supply (M/T)</b></th>
									<th style="text-align:center;"><b>F.O</b></th>
									<td style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_slp_fo" dataformat="float" otherchar="-" maxlength="12" id="dep_slp_fo" /> </td>
									<th style="text-align:center;"><b>D.O</th>
									<td style="padding:3px;" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_slp_do" dataformat="float" otherchar="-" maxlength="12" id="dep_slp_do" /> </td>
									<th style="text-align:center;"><b>F.W</th>
									<td style="padding:3px;"><input type="text" style="width:90px;text-align:right;" class="input" value="" name="dep_slp_fw" dataformat="float" otherchar="-" maxlength="12" id="dep_slp_fw" /> </td>
								</tr>
								<tr>
									<th colspan="7"><b>Supply Low Sulphur (M/T)</b></th>
									<th style="text-align:center;"><b>F.O</b></th>
									<td class="input2" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_low_sul_fo_wgt" maxlength="12" dataformat="float" otherchar="-" id="dep_low_sul_fo_wgt" /> </td>
									<th style="text-align:center;"><b>D.O</b></th>
									<td colspan=3" class="input2" style="padding:3px;"><input type="text" style="width:80px;text-align:right;" class="input" value="" name="dep_low_sul_do_wgt" maxlength="12" dataformat="float" otherchar="-" id="dep_low_sul_do_wgt" /> </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>DWT/Displ. (M/T)</b></th>
									<td colspan="2" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="arr_dwt" dataformat="float" otherchar="-" maxlength="12" id="arr_dwt" /> </td>
									<td colspan="4" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="arr_displt" dataformat="float" otherchar="-" maxlength="12" id="arr_displt" /> </td>
									<td colspan="2" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="dep_dwt" dataformat="float" otherchar="-" maxlength="12" id="dep_dwt" /> </td>
									<td colspan="4" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="dep_displ" maxlength="12" dataformat="float" otherchar="-" id="dep_displ" /> </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>GM (meter)</b></th>
									<td colspan="6" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="arr_gm" maxlength="6" dataformat="float" otherchar="-" id="arr_gm" /> </td>
									<td colspan="6" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="dep_gm" maxlength="6" dataformat="float" otherchar="-" id="dep_gm" /> </td>
								</tr>
								<tr>
									<th style="text-align:center;"><b>Tugboat</b></th>
									<td colspan="6" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="arr_tugboat" dataformat="float" otherchar="-" maxlength="6" id="arr_tugboat" /> </td>
									<td colspan="6" class="input2" style="padding:3px;"><input type="text" style="width:129px;text-align:right;" class="input" value="" name="dep_tugboat" dataformat="float" otherchar="-" maxlength="6" id="dep_tugboat" /> </td>
								</tr>
							</tbody>
						</table>
					</div>
					
			</div>
			
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid"  style="display:none;">			
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- TAB [ SKD & COND ] (E) -->
	
	<!-- TAB [ Port Log ] (S) -->
	<div id="tabLayer" >
	
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="100" />				
					<col width="70" />						
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
				   		<th>Number of Used Crane</th>
						<td style="padding:3px;"><input type="text" style="width:60px;text-align:center" class="input" value="" dataformat="num" maxlength="2" name="used_crane" id="used_crane" onblur="used_crane_onblur()"/> </td>
						<th>Average Number of Used Crane</th>
						<td style="padding:3px;"><input type="text" style="width:60px;text-align:center" class="input" value="" name="avg_crane" maxlength="4" readonly id="avg_crane" /> </td>
			   		</tr>
			   </tbody>
			</table>
			<h3 class="title_design mar_top_12">Working Hours</h3>
			
			
			<div class="opus_design_data">
				<table class="grid_2">
					<colgroup>
						<col width="200" />				
						<col width="*" />
						<col width="200" />				
						<col width="*" />			
						<col width="200" />						
						<col width="*" />				
				   </colgroup> 
				   <tbody>
						<tr>
							<th style="text-align:center;"><b>Gross Work Hours</b></th>
							<td style="padding:3px;"><input type="text" style="width:110px;text-align:right;" class="input" value="" name="gross_work" maxlength="6" id="gross_work" dataformat="num" otherchar=":"/> </td>
							<th style="text-align:center;"><b>Net Work Hours</b></th>
							<td><input type="text" style="width:110px;text-align:right;" class="input" value="" name="net_work" maxlength="6" id="net_work" dataformat="num" otherchar=":"/> </td>
							<th  id="net_work" name="net_work" style="text-align:center;"><b>Lost Time by G/Crane</b></th>
							<td style="padding:3px;"><input type="text" style="width:130px;text-align:right;" class="input" value="" name="lost_time" maxlength="6" id="lost_time" dataformat="num" otherchar=":"/> </td>
						</tr>
						<tr>
							<th style="text-align:center;"><b>Gross Gang Hours</b></th>
							<td style="padding:3px;"><input type="text" style="width:110px;text-align:right;" class="input" value="" name="gross_gang" maxlength="6" id="gross_gang" dataformat="num" otherchar=":"/> </td>
							<th style="text-align:center;"><b>Net Gang Hours</b></th>
							<td style="padding:3px;"><input type="text" style="width:110px;text-align:right;" class="input" value="" name="net_gang" maxlength="6" id="net_gang" dataformat="num" otherchar=":"/> </td>
							<td colspan="2"></td>
						</tr>
					</tbody>
				</table>
			</div>


			<table class="height_5"><tr><td></td></tr></table>
			<h3 class="title_design mar_top_12">Handling Moves</h3>
			<div class="opus_design_data">
				<table class="grid_2">
					<colgroup>
						<col width="200" />				
						<col width="*" />
						<col width="200" />				
						<col width="*" />		
						<col width="200" />						
						<col width="*" />				
				   </colgroup> 
				   <tbody>
						<tr>
							<th style="text-align:center;"><b>Hatch Cover Handling</b></th>
							<td style="padding:3px;"><input type="text" style="width:110px;text-align:right;" class="input" value="" name="hatch_handl" dataformat="num" maxlength="4" id="hatch_handl" /> </td>
							<th style="text-align:center;"><b>Gear Box Handling</b></th>
							<td style="padding:3px;"><input type="text" style="width:110px;text-align:right;" class="input" value="" name="gear_handl" dataformat="num" maxlength="4" id="gear_handl" /> </td>
							<th style="text-align:center;"><b>Total Container Handling Moves</b></th>
							<td style="padding:3px;"><input type="text" style="width:130px;text-align:right;" class="input" readonly value="" name="move_handl" dataformat="num" maxlength="6" id="move_handl" /> </td>
						</tr>
					</tbody>
				</table>
			</div>
			<table class="height_5"><tr><td></td></tr></table>

			<h3 class="title_design mar_top_12">Productivity</h3>
			<div class="opus_design_data">
				<table class="grid_2">
				<colgroup>
					<col width="130">
					<col width="70">
					<col width="120">
					<col width="60">
					<col width="130">
					<col width="125">
					<col width="60">
					<col width="120">
					<col width="60">
					<col width="*">
				</colgroup>
				   <tbody>
						<tr>
							<th style="text-align:center;"><b>Terminal</b></th>
							<th style="text-align:center;"><b>Gross</b></th>
							<td style="padding:3px;"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="tmnl_gross" dataformat="float" otherchar="-" maxlength="5" id="tmnl_gross" /> </td>
							<th style="text-align:center;"><b>Net</b></th>
							<td style="padding:3px;"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="tmnl_net" dataformat="float" otherchar="-" maxlength="5" id="tmnl_net" /> </td>
							<th style="text-align:center;"><b>Per Gang</b></th>
							<th style="text-align:center;"><b>Gross</b></th>
							<td style="padding:3px;"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="per_gang_gross" dataformat="float" otherchar="-" maxlength="5" id="per_gang_gross" /> </td>
							<th style="text-align:center;"><b>Net</b></th>
							<td style="padding:3px;"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="per_gan_net" dataformat="float" otherchar="-" maxlength="5" id="per_gan_net" /> </td>
						</tr>
					</tbody>
				</table>
				<table class="height_5"><tr><td></td></tr></table>
			</div>
		</div>
		<!-- opus_design_inquiry(E) -->	
				
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">			
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	
	</div>
	<!-- TAB [ Port Log ] (E) -->
	
	<!-- TAB [ Disch. Vol. ] (S) -->
	<div id="tabLayer" style="display:none">
	   <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
	</div>
	<!-- TAB [ Disch. Vol. ] (E) -->
	
	<!-- TAB [ Load. Vol. ] (S) -->
	<div id="tabLayer" style="display:none">
	    <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
	</div>
	<!-- TAB [ Load. Vol. ] (E) -->
	<!-- TAB [ COD ] (S) -->
	<div id="tabLayer" style="display:none">
	    <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
	</div>
	<!-- TAB [ COD ] (E) -->
	<!-- TAB [ R/H ] (S) -->
	<div id="tabLayer" style="display:none">
	    <iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="600"></iframe>
	</div>
	<!-- TAB [ R/H ] (E) -->
	<!-- TAB [ Mishandle ] (S) -->
	<div id="tabLayer" style="display:none">
	    <iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
	</div>
	<!-- TAB [ Mishandle ] (E) -->
	
	<!-- TAB [ Slot ] (S) --> 
	<div id="tabLayer" style="display:none">
	    <iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
	</div>
	<!-- TAB [ Slot ] (E) -->
	
	<!-- TAB [ Temp. STWG ] (S) -->
	<div id="tabLayer" style="display:none">
	    <iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
	</div>
	<!-- TAB [ Temp. STWG ] (E) -->
	<!-- TAB [ Remark ] (S) -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
			<table>
				<tr><td><textarea style="width:99%;height:400px; resize:none;" name="tdr_info" id="tdr_info" onblur="tdr_info_onchange()"></textarea></td>
				</tr>
			</table>
		</div>

		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->
	</div>
	<div id="tdrHeader" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheetTdrH');</script>
	</div>
	<div id="tdrTransc" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheetTransc');</script>
	</div>
	<TEXTAREA NAME="tabLayerStatus" ROWS="2" COLS="200" style="display:none;"></TEXTAREA>
	<TEXTAREA NAME="s_parameter" style="width:100%;height:50;display:none;"></TEXTAREA>
	<!-- TAB [ Remark ] (E) -->
	
	
	</div>
</form>
