<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0027.jsp
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
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
<%@ page import="com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (VopVsk0027Event)request.getAttribute("Event");
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
<input type="hidden" name="loc_cd" id="loc_cd">
<input type="hidden" name="country_cd" id="country_cd">
<input type="hidden" name="rcv_dt" id="rcv_dt">
<input type="hidden" name="rcv_seq" id="rcv_seq">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<div style="display: none">
			<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button>
		</div>					
	</div>
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
			<col width="*" />
		</colgroup>
		<tr>
			<th>Period</th>
			<td><input type="text" name="fm_dt" id="fm_dt" dataformat="ymd" style="width:80px;text-align:center;" class="input1" value="" maxlength="8" size="10"><button type="button" id="btn_cal1" name="btn_cal1" class="calendar ir"></button>~<input type="text" name="to_dt" id="to_dt" dataformat="ymd" style="width:80px;text-align:center;" class="input1" value="" maxlength="8" size="10"><button type="button" id="btn_cal2" name="btn_cal2" class="calendar ir"></button></td>
			<th>CTRL H/Q</th>
			<td><script  type="text/javascript">ComComboObject('vskd_port_rhq_cd',1,80,1,0);</script><script  type="text/javascript">ComComboObject('sls_ofc_cd',1,70,1,0);</script></td>
			<th>Port</th>
			<td><input type="text" name="vps_port_cd" id="vps_port_cd" dataformat="engup" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" onfocus="this.select();"><button type="button" id="btn_port" name="btn_port" class="input_seach_btn"></button><script  type="text/javascript">ComComboObject('tml_cd',2,80,1,0);</script></td>
			<th>Result</th>
			<td><script  type="text/javascript">ComComboObject('scs_flg',1,60,1,0);</script></td>
		</tr>
		<tr>
			<!-- 20150407 Off-lane -> Feeder 로 수정 by TaeWoong Kim
				 Because of User's Request
			 -->				
			<td class="wrap_search_btn" colspan="2"><input type="radio" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="" class="trans" checked="checked"> <b>All</b> <input type="radio" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="T" class="trans"> <b>Trunk</b> <input type="radio" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="O" class="trans"> <b>Feeder</b> </td>
			<th title="Vessel Voyage Direction">VVD</th>
			<td><input type="text" name="vsl_cd" id="vsl_cd" dataformat="engup" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><input type="text" name="skd_voy_no" id="skd_voy_no" dataformat="num" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();"><input type="text" name="skd_dir_cd" id="skd_dir_cd" dataformat="enguponly" style="width:20px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();"><button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button></td>
			<th>IMO No.</th>
			<td><input type="text" name="lloyd_no" id="lloyd_no" style="width:150px;text-align:left;ime-mode:disabled;" class="input1" value="" maxlength="20" onfocus="this.select();"></td>
			<th>Call Sign</th>
			<td><input type="text" name="call_sgn_no" id="call_sgn_no" style="width:120px;text-align:left;ime-mode:disabled;" class="input1" value="" maxlength="15" onfocus="this.select();"></td>			
		</tr>		
	</tbody>
</table>	
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_t1Retrieve" 		id="btn_t1Retrieve">Retrieve</button>			
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>	
	</div>
	<!-- opus_design_grid(S) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_t2Retrieve" 		id="btn_t2Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_t2New" 			id="btn_t2New">New</button>		
			<button type="button" class="btn_normal" name="btn_t2DownExcel" 	id="btn_t2DownExcel">Down Excel</button>					
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>	
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_t3Retrieve" 		id="btn_t3Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_t3New" 			id="btn_t3New">New</button>		
			<button type="button" class="btn_normal" name="btn_t3DownExcel" 	id="btn_t3DownExcel">Down Excel</button>					
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>	
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_t4Retrieve" 		id="btn_t4Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_t4New" 			id="btn_t4New">New</button>		
			<button type="button" class="btn_normal" name="btn_t4DownExcel" 	id="btn_t4DownExcel">Down Excel</button>					
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>	
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_t5Retrieve" 		id="btn_t5Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_t5New" 			id="btn_t5New">New</button>		
			<button type="button" class="btn_normal" name="btn_t5DownExcel" 	id="btn_t5DownExcel">Down Excel</button>					
			<button type="button" class="btn_normal" name="btn_t5Retry" 		id="btn_t5DownExcel">Retry</button>					
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t5sheet1');</script>	
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>