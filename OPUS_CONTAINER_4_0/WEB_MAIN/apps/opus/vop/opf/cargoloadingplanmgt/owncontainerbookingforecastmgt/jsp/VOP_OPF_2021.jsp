<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : vop_opf_2021.jsp
*@FileTitle  : Weight Group (Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf2021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String slan_cd = "";
	String slan_cd_desc = "";
	String skd_dir_cd = "";
	String pol_cd = "";
	
	if(request.getParameter("slan_cd")!=null) {
		slan_cd	= request.getParameter("slan_cd");
	}
	if(request.getParameter("slan_cd_desc")!=null) {
		slan_cd_desc	= request.getParameter("slan_cd_desc");
	}
	if(request.getParameter("skd_dir_cd")!=null) {
		skd_dir_cd	= request.getParameter("skd_dir_cd");
	}
	if(request.getParameter("pol_cd")!=null) {
		pol_cd	= request.getParameter("pol_cd");
	}
	
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopOpf2021Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="sel_skd_dir_cd" id="sel_skd_dir_cd" value="<%=StringUtil.xssFilter(skd_dir_cd)%>">
<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Weight Group (Inquiry)</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents"
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="10" />
				<col width="200" />
				<col width="100" />
				<col width="50" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Lane</th>
				<td><input type="text" tabindex="1" style="width:55px;" dataformat="engup" maxlength="3" fullfill="" caption="Lane" class="input1" name="slan_cd" value="<%=StringUtil.xssFilter(slan_cd)%>" required="" id="slan_cd" /><button type="button" id="slan_cd_pop" name="slan_cd_pop" class="input_seach_btn"></button><input type="text" style="width:200px;" class="input2" name="slan_cd_desc" value="<%=StringUtil.xssFilter(slan_cd_desc)%>" readonly></td>
				<th>Direction</th>
				<td width="90">
					<select tabIndex="2" style="width:45px;" class="input1" name="skd_dir_cd" id="skd_dir_cd" onchange="skd_dir_cd_change(this.form)">
					<option value="E">E</option>
					<option value="W">W</option>
					<option value="S">S</option>
					<option value="N">N</option>
					</select>
				</td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" tabindex="3" style="width:55px;" dataformat="engup" maxlength="5" fullfill="" caption="POL" class="input1" name="pol_cd" value="<%=StringUtil.xssFilter(pol_cd)%>" required="" id="pol_cd" /><button type="button" id="pol_cd_pop" name="pol_cd_pop" class="input_seach_btn"></button></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</div>
</form>