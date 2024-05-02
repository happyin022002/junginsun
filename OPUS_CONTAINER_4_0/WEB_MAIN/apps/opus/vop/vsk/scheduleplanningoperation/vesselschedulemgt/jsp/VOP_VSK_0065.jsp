<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0065.jsp
*@FileTitle : VSL SKD history Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0065Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0065Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0065Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script typr="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="pagerows" 	id="pagerows">
<input type="hidden" name="loc_cd" 		id="loc_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_t1Retrieve" 	id="btn_t1Retrieve">Retrieve</button>	
			<button type="button" class="btn_normal" name="btn_t1New" 		id="btn_t1New">New</button>
			<button type="button" class="btn_normal" name="btn_t1DownExcel" id="btn_t1DownExcel">Down Excel</button>
		</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->



<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="50"/>
				<col width="200"/>
				<col width="70"/>
				<col width="120"/>
				<col width="110"/>
				<col width="80"/>
				<col width="60"/>
				<col width="80" />
				<col width="*" />
		    </colgroup>
			<tr>
				<th>Period</th>
				<td>
					<input type="text" name="fm_dt" 		id="fm_dt" style="width:80px;text-align:center;" class="input1" value="" maxlength="8" size="10"><!--  
					--><span class="dash">~</span><!-- 
					 --><input type="text" name="to_dt" 		id="to_dt" style="width:80px;text-align:center;" class="input1" value="" maxlength="8" size="10"><!-- 
					  --><button type="button" class="calendar" name="btn_period" id="btn_period"></button>
				</td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td>
					<input type="text" name="vsl_cd" 		id="vsl_cd" style="width:44px;text-align:center;ime-mode:disabled;" class="input" value=""  dataformat="engup" maxlength="4"><!-- 
					 --><input type="text" name="skd_voy_no" 	id="skd_voy_no" style="width:44px;text-align:center;ime-mode:disabled;" class="input" value="" dataformat="num" maxlength="4"><!-- 
					 --><input type="text" name="skd_dir_cd" 	id="skd_dir_cd" style="width:22px;text-align:center;ime-mode:disabled;" class="input" value=""  dataformat="engup" maxlength="1"><!-- 
					  --><button type="button" class="input_seach_btn" name="btn_vvd_search" id="btn_vvd_search"></button>
				</td>
				<th>Lane Code</th>
				<td>
					<input type="text" name="vsl_slan_cd" 	id="vsl_slan_cd" style="width:40px;text-align:center;ime-mode:disabled;" class="input" value=""  dataformat="engup" maxlength="3"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_slan_cd" id="btn_slan_cd"></button>
				</td>
				<th>Port</th>
				<td>
					<input type="text" name="vps_port_cd" 	id="vps_port_cd" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" value="" dataformat="engup" maxlength="5"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_port_cd" id="btn_port_cd"></button>
				</td>
					<th width="40">&nbsp;&nbsp;&nbsp;&nbsp;Booking&nbsp;&nbsp;</th>
					<td class="wrap_search_tab" >
					 <input type="radio" name="bkg_atch_flg" value="A" class="trans" id="bkg_atch_flg3" checked="" />&nbsp;&nbsp;All&nbsp;&nbsp;						
					 <input type="radio" name="bkg_atch_flg" value="Y" class="trans" id="bkg_atch_flg1"  />&nbsp;&nbsp;Attached&nbsp;&nbsp;
					 <input type="radio" name="bkg_atch_flg" value="N"  class="trans" id="bkg_atch_flg2" />&nbsp;&nbsp;Not Attached
					<td></td> 
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
<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
	
<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">

	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
