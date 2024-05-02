<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5912.jsp
*@FileTitle  : IMDG Item Booking Summary
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/12/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event.VopScg5912Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg5912Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg        = "";						//error message
	int rowCount	        = 0;						//count of DB resultSET list

	String successFlag      = "";
	String codeList         = "";
	String pageRows         = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.specialcargoutilitymanagement.editransmithistory");
	
	String rgnShpOprCd  = JSPUtil.getParameter(request, "rgn_shp_opr_cd".trim(), "");
	String bkgRefNo     = JSPUtil.getParameter(request, "bkg_ref_no".trim(), "");
	String slanCd       = JSPUtil.getParameter(request, "slan_cd".trim(), "");
	String vslCd        = JSPUtil.getParameter(request, "vsl_cd".trim(), "");
	String skdVoyNo     = JSPUtil.getParameter(request, "skd_voy_no".trim(), "");
	String skdDirCd     = JSPUtil.getParameter(request, "skd_dir_cd".trim(), "");
	String crrCd        = JSPUtil.getParameter(request, "crr_cd".trim(), "");
	
	String polCd 	 = JSPUtil.getParameter(request, "pol_cd".trim(), "");
	String podCd 	 = JSPUtil.getParameter(request, "pod_cd".trim(), "");
	
	String ediTrsmStsCd = JSPUtil.getParameter(request, "edi_trsm_sts_cd".trim(), "");
	if("I".equals(ediTrsmStsCd)){
		ediTrsmStsCd	= "Original";
	}else if("U".equals(ediTrsmStsCd)){
		ediTrsmStsCd	= "Update";
	}else if("R".equals(ediTrsmStsCd)){
		ediTrsmStsCd	= "Reject";
	}else{
		ediTrsmStsCd	= "";		
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg5912Event)request.getAttribute("Event");
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
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" id = "f_cmd"       name = "f_cmd" />
<input type="hidden" id = "pagerows"    name = "pagerows" />
<input type="hidden" id = "cgo_opr_cd"  name = "rgn_shp_opr_cd" value="<%=rgnShpOprCd%>" />
<input type="hidden" id = "bkg_ref_no"  name = "bkg_ref_no"     value="<%=bkgRefNo%>" />
<input type="hidden" id = "slan_cd"     name = "slan_cd"        value="<%=slanCd%>" />
<input type="hidden" id = "vsl_cd"      name = "vsl_cd"         value="<%=vslCd%>" />
<input type="hidden" id = "skd_voy_no"  name = "skd_voy_no"     value="<%=skdVoyNo%>" />
<input type="hidden" id = "skd_dir_cd"  name = "skd_dir_cd"     value="<%=skdDirCd%>" />
<input type="hidden" id = "trsm_bnd_cd" name = "crr_cd"         value="<%=crrCd%>" />
<input type="hidden" id = "pol_cd" 		name = "pol_cd"   		value="<%=polCd%>" />
<input type="hidden" id = "pod_cd" 		name = "pod_cd"   		value="<%=podCd%>" />
<!-- Mail Parameter -->

<!-- Mail Parameter -->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;IMDG Item Booking Summary</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_normal" name="btn_apvl_dtl" id="btn_apvl_dtl">Approval Details</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents"  style="overflow:hidden;">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table class="search" border="0" > 
				<colgroup>
					<col width="80px"  />				
					<col width="60px"  />				
					<col width="60px"  />
					<col width="80px"  />
					<col width="35px"  />
					<col width="60px"  />
					<col width="50px"  />
					<col width="*"     />
			   </colgroup>
			   <tbody>		   		
				<tr>
					<th>BKG Ref. No.</th>
					<td><input type="text" name="bkg_ref_no" style="width:120px;text-align:center;" class="input2" value="<%=bkgRefNo%>" caption="BKG No." id="bkg_ref_no" readonly />
					<th>Booking Status</th>
					<td><input type="text" name="edi_trsm_sts_cd" caption="Booking Status" class="input2" value="<%=ediTrsmStsCd%>" maxlength="3" dataformat="engup" style="width:75px;ime-mode:disabled;text-align:center;" id="edi_trsm_sts_cd" readonly />										
				</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>