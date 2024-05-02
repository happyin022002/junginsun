<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0010.jsp
*@FileTitle : Long Range SKD Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd"    id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="op_type"            id="op_type">
<input type="hidden" name="add_call_point"     id="add_call_point" value="1">
<input type="hidden" name="add_vvd_point"      id="add_vvd_point" value="3">
<input type="hidden" name="phasein_col"        id="phasein_col">
<input type="hidden" name="phasein_row"        id="phasein_row">
<input type="hidden" name="phasein_vsl_cd"     id="phasein_vsl_cd">
<input type="hidden" name="phasein_start_date" id="phasein_start_date">
<input type="hidden" name="phasein_voy_no"     id="phasein_voy_no">
<input type="hidden" name="vsl_cd">

<!--  Add Call -->
<input type="hidden" name="add_call_port_cd"   id="add_call_port_cd">
<input type="hidden" name="add_call_yard_cd"   id="add_call_yard_cd">
<input type="hidden" name="add_call_etb"       id="add_call_etb">
<input type="hidden" name="add_call_etd"       id="add_call_etd">
<input type="hidden" name="add_call_turn_ind"  id="add_call_turn_ind">
<input type="hidden" name="add_call_position"  id="add_call_position">

<input type="hidden" name="skdDirCd1"          id="skdDirCd1">
<input type="hidden" name="skdDirCd2"          id="skdDirCd2">
<input type="hidden" name="svc_dur_dys"        id="svc_dur_dys">
<input type="hidden" name="vsl_count"          id="vsl_count">

<%// in case screen for Feeder, vsl_svc_tp_cd is "F", else "T"%>
<input type="hidden" name="vsl_svc_tp_cd"      id="vsl_svc_tp_cd" value="T">
<input type="hidden" name="slan_stnd_flg"      id="slan_stnd_flg" value="Y">
<input type="hidden" name="tmp_vsl_slan_cd"    id="tmp_vsl_slan_cd" value="">
<input type="hidden" name="pf_svc_tp_cd"       id="pf_svc_tp_cd">
<input type="hidden" name="stnd_pf_svc_tp_cd"  id="stnd_pf_svc_tp_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Extend"     id="btn_Extend"     type="button" style="display:inline">Reduce</button>
		<button class="btn_accent" name="btn_Reduce"     id="btn_Reduce"     type="button" style="display:none">Extend</button>
		<button class="btn_normal" name="btn_New"        id="btn_New"        type="button">New</button>
		<button class="btn_normal" name="btn_Save"       id="btn_Save"       type="button">Save</button>
		<button class="btn_normal" name="btn_Simulation" id="btn_Simulation" type="button">Simulation</button>
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
	<div class="opus_design_inquiry wFit">
	<table class="search"> 
		<colgroup>
			<col width="50"/>
			<col width="100"/>
			<col width="50"/>
			<col width="300"/>
			<col width="50"/>
			<col width="60"/>
			<col width="50"/>
			<col width="50"/>
			<col width="50"/>
			<col width="*"/>
		</colgroup>
		<tr>
			<th>Lane Code</th>
			<td>
				<input  name="vsl_slan_cd"  type="text"   dataformat="engup" class="input1" style="width:37px;text-align:center;ime-mode:disabled" maxlength="3" tabindex="1" id="vsl_slan_cd" />
				<button name="btns_search1" type="button" id="btns_search1"  class="input_seach_btn"></button>
			</td>
			<th>End Date</th>
			<td>
				<input name="end_year" type="text" style="width:45px;text-align:center;" class="input1" maxlength="4" tabindex="5" id="end_year" /><!-- 
				 --><button type="button" class="btn_left"  name="btns_back2" id="btns_back2"></button><!-- 
				 --><button type="button" class="btn_right" name="btns_next2" id="btns_next2"></button><!-- 
				 --><select name="selEndQuarter" id="selEndQuarter" style="width:45;" class="input1" tabindex="6">
					<option value="1" selected>1/4</option>
					<option value="2">2/4</option>
					<option value="3">3/4</option>
					<option value="4">4/4</option>
				</select><!-- 
				 --><input name="end_date" type="text" dataformat="ymd" style="width:80px;;text-align:center;" class="input1" maxlength="8" size="10" tabindex="7" id="end_date" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
			</td>
			<th>Frequency</th>
			<td><input type="text" name="brth_itval_dys" style="width:30px;text-align:center;" class="input2" tabindex="-1" readonly id="brth_itval_dys" /> </td>
			<th>Vessel No.</th>
			<td><input type="text" name="vsl_cnt" dataformat="num" style="width:22px;text-align:center;" class="input" maxlength="2" tabindex="8" id="vsl_cnt" /> </td>
			<th>Voyage No.</th>
			<td width="140"><select style="width:140px;" name="voy_no_type" id="voy_no_type" class="input"> 
				 <option value="0" selected>Normal</option>
				 <option value="1">Direction (ADD One)</option>
				 <option value="2">Sequence</option></select><!--
				  --><input type="text" name="start_date" style="width:0px;display: none;" id="start_date" /> 
			</td>
			<td><input type="text" name="voy_type_cnt" id="voy_type_cnt" style="width:30px;text-align:center;"  class="input" maxlength="1" tabindex="-1" readonly></td>		    
		</tr>
	</table>
</div>
</div>
<div class="wrap_result">	
     <div class="opus_design_grid" id="startinfo" style="display:inline">
         <script type="text/javascript">ComSheetObject('sheet1');</script>         
     </div>
	
     <div class="opus_design_grid">
     		<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_Delete"         id="btn_Delete"         type="button">Row Delete</button>
				<button class="btn_normal" name="btn_PhaseOut"       id="btn_PhaseOut"       type="button">Phase Out</button>
				<button class="btn_normal" name="btn_PhaseOutCancel" id="btn_PhaseOutCancel" type="button">Phase Out Cancel</button><!--
				<!--
				<button class="btn_normal" name="btn_AddCall" id="btn_AddCall" type="button">Add Call </button><!--
				<button class="btn_normal" name="btn_AddCallCancel" id="btn_AddCallCancel" type="button">Add Call Cancel </button><!--
				-->
				<button class="btn_normal" name="btn_SkipCall"       id="btn_SkipCall"       type="button">Skip Call </button>
				<button class="btn_normal" name="btn_SkipCallCancel" id="btn_SkipCallCancel" type="button">Skip Call Cancel </button>
			</div>
			<!-- opus_design_btn (E) -->
         <script type="text/javascript">ComSheetObject('sheet2');</script>
     </div>
				
     <div class="opus_design_grid">
         <script type="text/javascript">ComSheetObject('sheet3');</script>
     </div>
     
     <div class="opus_design_grid">
         <script type="text/javascript">ComSheetObject('sheet4');</script>
     </div>
     
     <div class="opus_design_grid">
         <script type="text/javascript">ComSheetObject('sheet5');</script>
     </div>
</div>	
</form>

