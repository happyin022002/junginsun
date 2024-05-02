<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_9016.jsp
*@FileTitle  : Vessel Rename Information(Pop-Up)
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
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk9016Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<%
	VopVsk9016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");

	String oldCd = "";
	String oldNm = "";
	String newCd = "";
	String newNm = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk9016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		oldCd = StringUtil.xssFilter(request.getParameter("vsl_renm_old_vsl_cd"));
		oldNm = StringUtil.xssFilter(request.getParameter("vsl_renm_old_vsl_eng_nm"));
		newCd = StringUtil.xssFilter(request.getParameter("vsl_renm_new_vsl_cd"));
		newNm = StringUtil.xssFilter(request.getParameter("vsl_renm_new_vsl_eng_nm"));
		
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vps_port_cd" value="<%=StringUtil.xssFilter(request.getParameter("vps_port_cd"))%>" id="vps_port_cd" />
<input type="hidden" name="clpt_ind_seq" value="<%=StringUtil.xssFilter(request.getParameter("clpt_ind_seq"))%>" id="clpt_ind_seq" />
<input type="hidden" name="skd_cng_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("skd_cng_sts_cd"))%>" id="skd_cng_sts_cd" />


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Vessel Rename</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Ok" 		    id="btn_Ok">Ok</button>
			<button type="button" class="btn_accent" name="btn_Cancel" 		id="btn_Cancel">Rename Cancel</button>
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
					<col width="120"/>
					<col width="120"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td colspan="3"><input type="text" style="width:50px;" name="vsl_cd" value="<%=StringUtil.xssFilter(request.getParameter("vsl_cd"))%>" class="input1"><!--
						--><input type="text" style="width:40px" name="skd_voy_no" value="<%=StringUtil.xssFilter(request.getParameter("skd_voy_no"))%>"class="input1"><!--
						--><input type="text" style="width:20px;" name="skd_dir_cd" value="<%=StringUtil.xssFilter(request.getParameter("skd_dir_cd"))%>" class="input1"></td>
					</tr>
					<tr>
						<th title="Old Vessel Voyage Direction">Old Vessel Code</th>
						<td><input type="text" style="width:60px;ime-mode:disabled;text-align:center" name="vsl_renm_old_vsl_cd" id="vsl_renm_old_vsl_cd" class="input" maxlength="4" dataformat="engup" value="<%=oldCd%>"><button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button></td>
						<th title="Vessel Voyage Direction">Old Vessel Name</th>
						<td><input type="text" style="width:160px;ime-mode:disabled;text-align:center" name="vsl_renm_old_vsl_eng_nm" id="vsl_renm_old_vsl_eng_nm" class="input" value="<%=oldNm%>"></td>
					</tr>
					<tr>
						<th title="New Vessel Voyage Direction">New Vessel Code</th>
						<td><input type="text" style="width:60px;ime-mode:disabled;text-align:center" name="vsl_renm_new_vsl_cd" id="vsl_renm_new_vsl_cd" class="input" maxlength="4" dataformat="engup" value="<%=newCd%>"><button type="button" class="input_seach_btn" name="btns_search2" id="btns_search2"></button></td>
						<th title="Vessel Voyage Direction">New Vessel Name</th>
						<td><input type="text" style="width:160px;ime-mode:disabled;text-align:center" name="vsl_renm_new_vsl_eng_nm" id="vsl_renm_new_vsl_eng_nm" class="input" value="<%=newNm%>"></td>
					</tr>				
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

</div>
</form>