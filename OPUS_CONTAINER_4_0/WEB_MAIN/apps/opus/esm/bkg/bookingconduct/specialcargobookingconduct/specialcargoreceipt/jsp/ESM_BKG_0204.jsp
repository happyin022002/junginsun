<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0204.jsp
*@FileTitle  : Dangerous cargo application
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0204Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0204Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String imdg_un_no = "";
	String imdg_clss_cd = "";
	String prp_shp_nm = "";
	String bkg_no = "";
	String imdg_amdt_no = "";      
	String pol_cd = "";
	String pod_cd = "";
	String pop_type = "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0204Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		imdg_un_no =  JSPUtil.getParameter(request, "imdg_un_no");
		imdg_clss_cd =  JSPUtil.getParameter(request, "imdg_clss_cd");
		prp_shp_nm =  JSPUtil.getParameter(request, "prp_shp_nm");
		bkg_no =  JSPUtil.getParameter(request, "bkg_no");
		imdg_amdt_no =  JSPUtil.getParameter(request, "imdg_amdt_no");
		pol_cd =  JSPUtil.getParameter(request, "pol_cd");
		pod_cd =  JSPUtil.getParameter(request, "pod_cd");
		pop_type = JSPUtil.getParameter(request, "pop_type");

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
<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
<input type="hidden" name="imdg_amdt_no_origin" value="<%=imdg_amdt_no%>" id="imdg_amdt_no_origin" />
<input type="hidden" name="pol_cd" value="<%=pol_cd%>" id="pol_cd" />
<input type="hidden" name="pod_cd" value="<%=pod_cd%>" id="pod_cd" />
<input type="hidden" name="pop_type" value="<%=pop_type%>" id="pop_type" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>IMDG Code Inquiry by UN No.</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
	    	<button type="button" class="btn_accent"  name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
   	     --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
   	     --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
 
 
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		 <table> 
           <colgroup>
                <col width="50">
                <col width="70">
                <col width="80">
                <col width="90">
                <col width="100">
                <col width="300">
                <col width="50">
                <col width="*">
            </colgroup>
            <tbody>
           		<tr>
					<th>UN No.</th>
					<td><input name="imdg_un_no" id="imdg_un_no" type="text" style="width:50px;" class="input1" value="<%=imdg_un_no%>" maxlength="4"></td>
					<th>IMDG Class</th>
					<td><input  name="imdg_clss_cd" id="imdg_clss_cd" type="text" style="width:50px;" class="input" value="<%=imdg_clss_cd%>" maxlength="3"></td>
					<th>Proper Shipping Name</th>
					<td><input type='text' style='width:90%;' class='input' style="ime-mode:disabled"  name='prp_shp_nm' id='prp_shp_nm' value='<%=prp_shp_nm%>'></td>
					<th>Amdt No.</th>
					<td><select name="imdg_amdt_no" id="imdg_amdt_no" style="width:90px;" class="input"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
 
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>