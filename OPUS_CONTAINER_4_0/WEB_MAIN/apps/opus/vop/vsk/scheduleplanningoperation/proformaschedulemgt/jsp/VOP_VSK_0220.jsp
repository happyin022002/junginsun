<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0220.jsp
*@FileTitle  : Information Input for SKD Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0220Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0220Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");
	
	String vslSlanCd = JSPUtil.getNull(request.getParameter("vsl_slan_cd"));
	String skdDirCd = JSPUtil.getNull(request.getParameter("skd_dir_cd"));
	String pfSvcTpCd = JSPUtil.getNull(request.getParameter("pf_svc_tp_cd"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0220Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="slan_stnd_flg" id="slan_stnd_flg" />
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>" id="skd_dir_cd" />
<input type="hidden" name="clpt_seq" value="" id="clpt_seq" />
<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Information Input for SKD Creation (P/F SKD Use)</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_ok" id="btn_ok" type="button">Ok</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
			</div>
			<!-- opus_design_btn (E) -->
		</div>
	</div>

<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="125" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
			<tr>
				<th>Lane Code</th>
				<td><input type="text" name="vsl_slan_cd" style="width:60px;text-align:center;" value="<%=vslSlanCd %>" class="input2" readonly="readonly" id="vsl_slan_cd" /><input type="text" name="vsl_slan_nm" style="width:270px;" value="" class="input2" readonly="readonly" id="vsl_slan_nm" />  </td>
			</tr>
			<tr>
				<th>P/F SKD Type</th>
				<td><input type="text" name="pf_svc_tp_cd" style="width:60px;text-align:center;ime-mode:disabled;" value="<%=pfSvcTpCd %>" class="input1" maxlength="4" id="pf_svc_tp_cd" /><button type="button" id="btn_pf_lane_help" name="btn_pf_lane_help" class="input_seach_btn"></button></td>
			</tr>
			<tr>
				<th>Start Port /Day</th>
				<td><script type="text/javascript">ComComboObject('port_cd',3,60,1,0);</script>/ <input type="text" style="width:40px;text-align:center;" name="etb_dy_cd" id="etb_dy_cd" value="" class="input2_1" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Start Port ETB Date</th>
				<td><input type="text" name="vps_etb_dt" maxlength="10" style="width:80px;text-align:center;" value="" class="input1" id="vps_etb_dt" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
			</tr>
			</tbody>
		</table>
	</div>
	</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>