<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0250.jsp
*@FileTitle  : Port SKD Information(Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0250Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<%
	VopVsk0250Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");

	String clptIndSeq 	= null;
	String clptSeq 		= null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0250Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		clptIndSeq 	= request.getParameter("clpt_ind_seq");
		clptIndSeq 	= clptIndSeq==null || clptIndSeq.length()==0 ? "" : clptIndSeq;
		
		clptSeq 	= request.getParameter("clpt_seq");
		clptSeq 	= clptSeq==null || clptSeq.length()==0 ? "" : clptSeq;

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="clpt_ind_seq" value="<%=StringUtil.xssFilter(clptIndSeq)%>" id="clpt_ind_seq" />
<input type="hidden" name="clpt_seq" value="<%=StringUtil.xssFilter(clptSeq)%>" id="clpt_seq" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Port SKD Information</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Close" 		id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" id="tabLayer" style="visible:false">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		
		<!-- opus_design_grid(E) -->
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>				
					<col width="120"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:50px;" name="vsl_cd" value="<%=StringUtil.xssFilter(request.getParameter("vsl_cd"))%>" class="input1"><!--
						--><input type="text" style="width:40px" name="skd_voy_no" value="<%=StringUtil.xssFilter(request.getParameter("skd_voy_no"))%>"class="input1"><!--
						--><input type="text" style="width:20px;" name="skd_dir_cd" value="<%=StringUtil.xssFilter(request.getParameter("skd_dir_cd"))%>" class="input1"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">	
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>				
					<col width="120"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<th>Vessel Name</th>
						<td><input type="text" style="width:100%;text-align:center;" name="vsl_eng_nm" class="input" id="vsl_eng_nm" /></td>
					</tr>
					<tr>
						<th>Port Code</th>
						<td><input type="text" style="width:100%;text-align:center;" name="vps_port_cd" value="<%=StringUtil.xssFilter(request.getParameter("vps_port_cd")) %>" id="vps_port_cd" class="input"></td>
					</tr>
					<tr>
						<th>Call Indicator</th>
						<td><input type="text" style="width:100%;text-align:center;" name="clpt_ind_seq2" class="input" id="clpt_ind_seq" /></td>
					</tr>
					<tr>
						<th>Status</th>
						<td><input type="text" style="width:100%;text-align:center;" name="skd_ind" class="input" id="skd_ind" /></td>
					</tr>
					<tr>
						<th>Change Indicator</th>
						<td><input type="text" style="width:100%;text-align:center;" name="cng_ind" class="input" id="cng_ind" /></td>
					</tr> 
					<tr>
						<th>ETA ( PF / EST )</th>
						<td><input type="text" style="width:49.5%;text-align:center;" name="pf_eta_dt" class="input" id="pf_eta_dt" /><input type="text" style="width:49%;text-align:center;" name="vps_eta_dt" class="input" id="vps_eta_dt" /></td>
					</tr>
					<tr>
						<th>ETB ( PF / EST )</th>
						<td><input type="text" style="width:49.5%;text-align:center;" name="pf_etb_dt" class="input" id="pf_etb_dt" /><input type="text" style="width:49%;text-align:center;" name="vps_etb_dt" class="input" id="vps_etb_dt" /></td>
					</tr>
					<tr>
						<th>ETD ( PF / EST )</th>
						<td><input type="text" style="width:49.5%;text-align:center;" name="pf_etd_dt" class="input" id="pf_etd_dt" /><input type="text" style="width:49%;text-align:center;" name="vps_etd_dt" class="input" id="vps_etd_dt" /></td>
					</tr>
					<tr>
						<th>Remark</th>
						<td><input type="text" style="width:100%;text-align:center;" name="vps_rmk" class="input" id="vps_rmk" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>	
</div>
</form>