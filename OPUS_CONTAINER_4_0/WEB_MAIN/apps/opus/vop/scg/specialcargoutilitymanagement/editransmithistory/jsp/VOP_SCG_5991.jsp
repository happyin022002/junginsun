<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5991.jsp
*@FileTitle  : DG EDI Booking History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event.VopScg5991Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg5991Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg   = "";					//error message
	int rowCount	   = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.clt.apps.specialcargoutilitymanagement.editransmithistory");
	
	String cgoOprCd  = JSPUtil.getParameter(request, "cgo_opr_cd".trim() , "");
	String crr_cd    = JSPUtil.getParameter(request, "crr_cd".trim()     , "");
	String bkgRefNo  = JSPUtil.getParameter(request, "bkg_ref_no".trim() , "");
	String slanCd    = JSPUtil.getParameter(request, "slan_cd".trim()    , "");
	String vslCd     = JSPUtil.getParameter(request, "vsl_cd".trim()     , "");
	String skdVoyNo  = JSPUtil.getParameter(request, "skd_voy_no".trim() , "");
	String skdDirCd  = JSPUtil.getParameter(request, "skd_dir_cd".trim() , "");
	String trsmBndCd = JSPUtil.getParameter(request, "trsm_bnd_cd".trim(), "");
	
	String polCd 	 = JSPUtil.getParameter(request, "pol_cd".trim(), "");
	String podCd 	 = JSPUtil.getParameter(request, "pod_cd".trim(), "");
	
	String prnrSpclCgoSeq = JSPUtil.getParameter(request, "prnr_spcl_cgo_seq".trim(), "");
	
	String title = "O".equals(trsmBndCd)? "Out" : "In";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg5991Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
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
		loadPage('<%=trsmBndCd%>');
	}
</script>

<form name="form">
<input type="hidden" id = "f_cmd"       name = "f_cmd" />
<input type="hidden" id = "pagerows"    name = "pagerows" />
<input type="hidden" id = "cgo_opr_cd"  name = "cgo_opr_cd"    value="<%=cgoOprCd%>" />
<input type="hidden" id = "crr_cd"      name = "crr_cd"        value="<%=crr_cd%>" />
<input type="hidden" id = "bkg_ref_no"  name = "bkg_ref_no"    value="<%=bkgRefNo%>" />
<input type="hidden" id = "slan_cd"     name = "slan_cd"       value="<%=slanCd%>" />
<input type="hidden" id = "vsl_cd"      name = "vsl_cd"        value="<%=vslCd%>" />
<input type="hidden" id = "skd_voy_no"  name = "skd_voy_no"    value="<%=skdVoyNo%>" />
<input type="hidden" id = "skd_dir_cd"  name = "skd_dir_cd"    value="<%=skdDirCd%>" />
<input type="hidden" id = "trsm_bnd_cd" name = "trsm_bnd_cd"   value="<%=trsmBndCd%>" />
<input type="hidden" id = "pol_cd" 		name = "pol_cd"   		value="<%=polCd%>" />
<input type="hidden" id = "pod_cd" 		name = "pod_cd"   		value="<%=podCd%>" />
<input type="hidden" id = "prnr_spcl_cgo_seq" name = "prnr_spcl_cgo_seq" value="<%=prnrSpclCgoSeq%>" />
<input type="hidden" id = "tabSelectedIdx" name="tabSelectedIdx" value="0" />
<!-- Mail Parameter -->

<!-- Mail Parameter -->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;<%=title%> Bound Flat File</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<!-- popup_contens_area(S) -->
<!-- <div class="layer_popup_contents" style="overflow:hidden;">
	<div class="opus_design_inquiry">
		<div id='content' style="height:480px;overflow:auto;"></div>
	</div>
</div> -->
<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->
	<div id="tabLayer" style="display:none"  style="position:relative;">
		<div class="opus_design_grid">
			<div id='IFTMBF_MSG' style="height:450px;overflow:auto;"></div>
		</div>
	</div>
	<div id="tabLayer" style="display:none"  style="position:relative;">
		<div class="opus_design_grid">
			<div id='APERAK_MSG' style="height:450px;overflow:auto;"></div>
		</div>
	</div>
	<div class="opus_design_grid" style="height:0px;width:0px;">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>