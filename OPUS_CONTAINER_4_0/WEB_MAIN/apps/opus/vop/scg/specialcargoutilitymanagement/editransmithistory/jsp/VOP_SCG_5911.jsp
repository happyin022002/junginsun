<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5911.jsp
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
<%@ page import="com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.event.VopScg5911Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg5911Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg5911Event)request.getAttribute("Event");
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
<!-- Mail Parameter -->

<!-- Mail Parameter -->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;DG EDI Booking Sent History</span></h2>
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
					<th>Vessel Operator</th>
					<td><input type="text" name="cgo_opr_cd" style="width:55px;text-align:center;" class="input2" value="<%=crr_cd%>" caption="Vessel Operator" maxlength="4" dataformat="engup" id="cgo_opr_cd" readonly/>
					
					<th>BKG No.</th>
					<td><input type="text" name="bkg_ref_no" style="width:100px;text-align:center;" class="input2" value="<%=bkgRefNo%>" caption="BKG No." id="bkg_ref_no" readonly />
					<th>Lane</th>
					<td><input type="text" name="slan_cd" caption="Lane Code" class="input2" value="<%=slanCd%>" maxlength="3" dataformat="engup" style="width:50px;ime-mode:disabled;text-align:center;" id="slan_cd" readonly />
					<th>VVD CD</th>
						<td><input type="text" name="vsl_cd" style="width:55px;text-align:center;" class="input2" value="<%=vslCd%>" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="vsl_cd" readonly /><!-- 
						 --><input type="text" name="skd_voy_no" style="width:40px;text-align:center;" class="input2" value="<%=skdVoyNo%>" fullfill="" caption="VVD CD" maxlength="4" dataformat="engup" id="skd_voy_no" readonly /><!-- 
						 --><input type="text" name="skd_dir_cd" style="width:20px;text-align:center;" class="input2" value="<%=skdDirCd%>" fullfill="" caption="VVD CD" maxlength="1" dataformat="engup" id="skd_dir_cd" readonly />					
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