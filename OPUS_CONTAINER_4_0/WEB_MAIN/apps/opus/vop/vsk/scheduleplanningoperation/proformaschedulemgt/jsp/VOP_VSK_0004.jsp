<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0004.jsp
*@FileTitle : P/F SKD Inquiry
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
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0004Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (VopVsk0004Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="min_max_spd" id="min_max_spd">
<input type="hidden" name="port_cd" id="port_cd">
<input type="hidden" name="port_name" id="port_name">
<input type="hidden" name="mml_usd_flg" id="mml_usd_flg">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button>		
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
					<col width="1px"/>
					<col width="1px"/>
					<col width="1px"/>
					<col width="1px"/>
					<col width="1px"/>
					<col width="1px"/>
					<col width="1px"/>
					<col width="1px"/>
					<col width="1px"/>										
					<col width="*" />
			   </colgroup>
				<tr>
					<th>Lane Code</th>
					<td><input type="text" style="width:50px;text-align:center;ime-mode:disabled;text-align:center" name="vsl_slan_cd" id="vsl_slan_cd" class="input1" maxlength="3" dataformat="engup" value="" tabIndex="1" onKeyPress="if(event.keyCode==13) doSearch();"><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button></td>
					<th>P/F SKD Type</th>
					<td><input type="text" style="width:51px;text-align:center;ime-mode:disabled" name="pf_svc_tp_cd" id="pf_svc_tp_cd" class="input1" maxlength="4" dataformat="num" value="" tabIndex="2" onKeyPress="if(event.keyCode==13) doSearch();"><button type="button" id="btns_search02" name="btns_search02" class="input_seach_btn"></button></td> 
					<th>Standard IND</th>   
					<td><input type="text" style="width:40px;text-align:center" name="slan_stnd_flg" id="slan_stnd_flg" class="input2" value="" readOnly="readonly"></td>
					<td></td>   
					<td></td>				
					<th>Created Date</th>
					<td><input type="text" style="width:110px;text-align:center;" name="cre_dt" id="cre_dt" class="input2" value="" readOnly="readonly"><input type="text" style="width:200px;text-align:left;" name="cre_usr_id" id="cre_usr_id" class="input2" value="" readOnly="readonly"></td>
				</tr>
				<tr>
					<th>Vessel Class</th>
					<td colspan="3">
						<input type="text" style="width:50px;text-align:center;" name="n1st_vsl_clss_cd" id="n1st_vsl_clss_cd" class="input2" value="" readOnly="readonly"><!-- 
						 --><input type="text" style="width:20px;text-align:right;" name="n1st_vsl_clss_knt" id="n1st_vsl_clss_knt" class="input2" value="" readOnly="readonly"><!-- 
						 --><input type="text" style="width:60px;text-align:center;" name="n2nd_vsl_clss_cd" id="n2nd_vsl_clss_cd" class="input2" value="" readOnly="readonly"><!-- 
						 --><input type="text" style="width:20px;text-align:right;" name="n2nd_vsl_clss_knt" id="n2nd_vsl_clss_knt" class="input2" value="" readOnly="readonly"><!-- 
						 --><input type="text" style="width:59px;text-align:center;" name="n3rd_vsl_clss_cd" id="n3rd_vsl_clss_cd" class="input2" value="" readOnly="readonly"><!-- 
						 --><input type="text" style="width:25px;text-align:right;" name="n3rd_vsl_clss_knt" id="n3rd_vsl_clss_knt" class="input2" value="" readOnly="readonly">
					</td>
					<th>Duration</th>
					<td><input type="text" style="width:40px;text-align:right" name="svc_dur_dys" id="svc_dur_dys" class="input2" value="" readOnly="readonly"></td> 
					<th>Frequency</th>   
					<td><input type="text" style="width:40px;text-align:right" name="brth_itval_dys" id="brth_itval_dys" class="input2" value="" readOnly="readonly"></td>
					<th>Updated Date</th>
					<td><input type="text" style="width:110px;text-align:center;" name="upd_dt" id="upd_dt" class="input2" value="" readOnly="readonly"><input type="text" style="width:200px;text-align:left;" name="upd_usr_id" id="upd_usr_id" class="input2" value="" readOnly="readonly"></td>
				</tr>
			</tbody>
		</table>	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width:100%" name="tabLayer" id="tabLayer">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
	<!-- opus_design_grid(S) -->	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>	
		</div>
		<!-- opus_design_btn(E) -->	
			
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>	
	<!-- opus_design_grid(S) -->	
</div>
</form>
