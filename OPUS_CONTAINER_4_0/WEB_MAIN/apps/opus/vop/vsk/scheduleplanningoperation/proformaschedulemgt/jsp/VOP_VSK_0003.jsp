<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0003.jsp
*@FileTitle : P/F SKD Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0003Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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


<form name="form">
<input type="hidden" name="f_cmd"         id="f_cmd">
<input type="hidden" name="pagerows"      id="pagerows">
<input type="hidden" name="min_max_spd"   id="min_max_spd">
<input type="hidden" name="port_cd"       id="port_cd">
<input type="hidden" name="port_name"     id="port_name">
<input type="hidden" name="zd"            id="zd">
<input type="hidden" name="port_info_cnt" id="port_info_cnt">
<input type="hidden" name="curr_pos"      id="curr_pos">
<input type="hidden" name="first_port_cd" id="first_port_cd">
<input type="hidden" name="second_port_cd"id="second_port_cd">
<input type="hidden" name="third_port_cd" id="third_port_cd">
<input type="hidden" name="data_pos"      id="data_pos">
<input type="hidden" name="yd_cd"         id="yd_cd">
<input type="hidden" name="currPos"       id="currPos">
<input type="hidden" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd">
<input type="hidden" name="check_vsl_skd" id="check_vsl_skd">
<input type="hidden" name="vps_port_cd"   id="vps_port_cd">
<input type="hidden" name="act_arr_dt"    id="act_arr_dt">
<input type="hidden" name="pre_port_cd"   id="pre_port_cd">
<input type="hidden" name="pre_etd_dt"    id="pre_etd_dt">
<input type="hidden" name="mml_usd_flg" id="mml_usd_flg" value="N">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button>	
		<button type="button" class="btn_normal" name="btn_Delete" 			id="btn_Delete">Delete</button>	
		<button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button>	
		<button type="button" class="btn_normal" name="btn_MSimulation" 	id="btn_MSimulation">M/Calculation</button>	
		<button type="button" class="btn_normal" name="btn_ASimulation"		id="btn_ASimulation">A/Calculation</button>				
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>				
					<col width="50"/>
					<col width="100"/>
					<col width="50"/>
					<col width="100"/>
					<col width="50"/>
					<col width="100"/>
					<col width="50"/>	
					<col width="100"/>	
					<col width="50"/>				
					<col width="*" />
			   </colgroup>
				<tr>
					<th>Lane Code</th>
					<td><input type="text" style="width:60px;ime-mode:disabled;text-align:center" name="vsl_slan_cd" id="vsl_slan_cd" class="input1" dataformat="engup" maxlength="3"  value="" tabIndex="1" onKeyPress="if(event.keyCode==13) doSearch();"><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button></td>
					<th>P/F SKD Type</th>
					<td><input type="text" style="width:58px;ime-mode:disabled;text-align:center" name="pf_svc_tp_cd" id="pf_svc_tp_cd" class="input1" dataformat="num" maxlength="4" value="" tabIndex="2" onKeyPress="if(event.keyCode==13) doSearch();"><button type="button" id="btns_search02" name="btns_search02" class="input_seach_btn"></button></td> 
					<th>Standard IND</th>   
					<td><select name="slan_stnd_flg" id="slan_stnd_flg" style="width:50px;" class="input1" tabIndex="3"><option value="N" selected="selected">N</option><option value="Y">Y</option></select></td>					
					<td colspan="2"></td>
					<th>Updated Date</th>
					<td><input type="text" style="width:110px;text-align:center" name="upd_dt" id="upd_dt" class="input2" readOnly="readonly" value=""></td> 
				</tr>
				<tr>
					<th>Vessel Class</th>
					<td colspan="3" style="padding-left:2;">
					<script type="text/javascript">ComComboObject('combo1',1,60,0,1);</script><input type="text" style="width:25px;ime-mode:disabled;text-align:right" name="n1st_vsl_clss_knt" id="n1st_vsl_clss_knt" maxlength="2" dataformat="int" class="input1" value="" onKeyPress="if(event.keyCode==13) doSearch();"><!-- 
					 --><script type="text/javascript">ComComboObject('combo2',1,62,0,1);</script><input type="text" style="width:35px;ime-mode:disabled;text-align:right" name="n2nd_vsl_clss_knt" id="n2nd_vsl_clss_knt" maxlength="2" dataformat="int" class="input" value="" onKeyPress="if(event.keyCode==13) doSearch();"><!-- 
					 --><script type="text/javascript">ComComboObject('combo3',1,62,0,1);</script><input type="text" style="width:25px;ime-mode:disabled;text-align:right" name="n3rd_vsl_clss_knt" id="n3rd_vsl_clss_knt" maxlength="2" dataformat="int" class="input" value="" onKeyPress="if(event.keyCode==13) doSearch();"></td>
					<th>Duration</th>
					<td><input type="text" name="svc_dur_dys" 		id="svc_dur_dys" style="width:50px;ime-mode:disabled;text-align:right" maxlength="4" dataformat="num" class="input" value="" onKeyPress="if(event.keyCode==13) doSearch();"></td>
					<th>Frequency</th>
					<td><input type="text" name="brth_itval_dys" 	id="brth_itval_dys" style="width:50px;ime-mode:disabled;text-align:right" maxlength="4" dataformat="num" class="input2"  value="" readOnly></td> 
					<th>P/F SKD History</th>
					<td colspan="2"><button type="button" id="btns_search03" name="btns_search03" class="input_seach_btn"></button></td>
				</tr>
				<tr>
					<th>Remark(s)</th>
					<td colspan="8"><input type="text" style="width:116%;ime-mode:disabled" name="pf_skd_rmk" id="pf_skd_rmk" dataformat="excepthan" maxlength="4000"  class="input" value="" ></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>



<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid "  name="tabLayer" id="tabLayer">	
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" 	id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_RowInsert" id="btn_RowInsert">Row Insert</button>	
			<button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>	
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>	
		</div>
		<!-- opus_design_btn(E) -->					
	    <script type="text/javascript">ComSheetObject('sheet1');</script><br>
		<script type="text/javascript">ComSheetObject('sheet2');</script><br>
		
		<!-- opus_design_data(S) -->
		<div class="opus_design_data" >
			<table border="0" style="width:100%; background-color:white;" class="grid2">
				<tbody>
					<colgroup>
						<col width="110px"/>
						<col width="65px"/>
						<col width="100px"/>
						<col width="65px"/>
						<col width="100px"/>
						<col width="65px"/>
						<col width="110px"/>
						<col width="65px"/>
						<col width="110px"/>
						<col width="65px"/>
						<col width="120px"/>
						<col width="65px"/>															
			   		</colgroup>
			   		<tr>
						<th><b>Maximum Speed</b></th>
						<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="max_spd" id="max_spd" value="" readOnly="readonly"></td> 
						<th><b>Sea Buffer Ratio</b></th>
						<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="sea_buf_rat" id="sea_buf_rat" value="" readOnly="readonly"></td>
						<th><b>P/F Speed Ratio</b></th>
						<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="pf_spd_rat" id="pf_spd_rat" value="" readOnly="readonly"></td>
						<th><b>Total Buffer Ratio</b></th>
						<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="tot_buf_rat" id="tot_buf_rat" value="" readOnly="readonly"></td>
						<th><b>Port Buffer Ratio</b></th>
						<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="port_buf_rat" id="port_buf_rat" value="" readOnly="readonly"></td>
						<th><b>Buffer Speed Ratio</b></th>
						<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="buf_spd_rat" id="buf_spd_rat" value="" readOnly="readonly"></td>				
					</tr>						
				</tbody>
			</table>			
		</div>
		<!-- opus_design_data(E) -->	
	</div>	
	<!-- opus_design_grid(S) -->
</div>
</form>