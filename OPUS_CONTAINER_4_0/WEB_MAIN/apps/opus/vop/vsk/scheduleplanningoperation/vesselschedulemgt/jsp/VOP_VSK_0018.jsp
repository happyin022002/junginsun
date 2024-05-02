<%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0018.jsp
*@FileTitle : VSL SKD Delete & Closing
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
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";
	String strUsrAuthTpCd = "";
	String availActivate = "";

	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();	   
		strUsrAuthTpCd = account.getUsr_auth_tp_cd();
		
		// Super User && CLTCO && PUSCOV autority
		if ("S".equals(strUsrAuthTpCd) || "CLTCO".equals(strOfc_cd) || "PUSCOV".equals(strOfc_cd)) {
			availActivate = "Y";
		}
		
		event = (VopVsk0018Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="vvdList" id="vvdList">
<input type="hidden" name="tmp_vsl_slan_cd" id="tmp_vsl_slan_cd" value="">
<input type="hidden" name="tmp_vsl_cd" id="tmp_vsl_cd" value="">
<input type="hidden" name="availActivate" id="availActivate" value="<%=availActivate %>">
<%// in case screen for feeder, vsl_svc_tp_cd is "F", else "T"%>
<input type="hidden" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="">
<input type="hidden" name="slan_stnd_flg" id="slan_stnd_flg"  value="Y">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_Delete" 			id="btn_Delete">Delete</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_SkdHolding" 		id="btn_SkdHolding">SKD Holding</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_SkdOpen" 		id="btn_SkdOpen">SKD Open</button><!-- 		
		<% if ("Y".equals(availActivate)) {%>
		<!--in case Super User Or Office Code("CLTCO"), SKD Activate button active-->
		--><button type="button" class="btn_normal" name="btn_SkdActivate" 	id="btn_SkdActivate">SKD Activate</button><!-- 		
		<%}%>
		--><button type="button" class="btn_normal" name="btn_BookingList" 	id="btn_BookingList">Booking List</button>		
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
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="80"/>
				<col width="90"/>
				<col width="80"/>
				<col width="90"/>
				<col width="60"/>
				<col width="80"/>													
				<col width="*" />
		   </colgroup>
			<tr>
					<th>Lane Code</th>
					<td>
						<input type="text" style="width:37px;text-align:center;background-color:#ffffff;ime-mode:disabled;" dataformat="engup" class="input1" value="" name="vsl_slan_cd" id="vsl_slan_cd" maxlength="3" tabindex="1"><!-- 
						 --><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button>
					</td>
					<th>Vessel Code</th>
					<td>
						<input type="text" style="width:60px;text-align:center; ime-mode:disabled;" dataformat="engup" name="vsl_cd" id="vsl_cd" maxlength="4" tabindex="2"><!-- 
						 --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button>
					</td>
					<th>Status</th>
					<td>
						<select name="skd_sts_cd" style="width:85px" tabindex="3">
						    <option value="">ALL</option>
							<option value="ACT">Active</option>
							<!-- option value="RDY">Ready</option -->
							<option value="MSK">Masked</option>
							<option value="CLO">Holding</option>
						</select>
					</td>
					<td></td>
				</tr>
		</tbody>
	</table>	
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>	
</div>
<!-- opus_design_grid(S) -->	
</form>