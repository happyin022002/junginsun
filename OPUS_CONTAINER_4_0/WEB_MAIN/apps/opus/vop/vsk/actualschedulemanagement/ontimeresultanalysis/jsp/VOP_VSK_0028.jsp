<%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0028.jsp
*@FileTitle : Report data Creation
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
<%@ page import="com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0028Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String header = "";
	Logger log = Logger.getLogger("com.clt.apps.actualschedulemanagement.ontimeresultanalysis");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0028Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="exist" id="exist">
<input type="hidden" name="dlay_rsn_cd" id="dlay_rsn_cd">
<input type="hidden" name="dlay_rsn_nm" id="dlay_rsn_nm">
<input type="hidden" name="skd_cng_sts_cd" id="skd_cng_sts_cd">
<input type="hidden" name="tmp_vsl_cd" id="tmp_vsl_cd" value="">
<input type="hidden" name="conv_clpt_seq" id="conv_clpt_seq" onchange="convClptSeqChange()">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_Update" 			id="btn_Update">Update</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_Delete" 			id="btn_Delete">Delete</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_Conversion" 		id="btn_Conversion">Conversion</button>					
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
			<colgroup>
				<col width="40"/>
				<col width="170"/>
				<col width="60"/>
				<col width="80"/>
				<col width="80"/>																
				<col width="*" />
		   </colgroup>
		   <tbody>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>   
				<td><input type="text" name="vsl_cd" id="vsl_cd" dataformat="engup" tabindex="1" value="" maxlength="4" style="width:45px;text-align:center;ime-mode:disabled;text-align:center;" class="input1"><!-- 
				 --><input type="text" name="voy_no" id="voy_no" dataformat="num" tabindex="2" value="" maxlength="4" style="width:37px;text-align:center;ime-mode:disabled;text-align:center;" class="input1"><!-- 
				 --><input type="text" name="dir_cd" id="dir_cd" dataformat="enguponly"tabindex="3" value="" maxlength="1" style="width:20px;text-align:center;ime-mode:disabled;text-align:center;" class="input1"><!-- 
				 --><button type="button" name="btn_search" id="btn_search" class="input_seach_btn"></button>					
				<th>Lane Code</th>   
				<td><input type="text" name="vsl_slan_cd" id="vsl_slan_cd" style="width:45px;text-align:center;" class="input2" tabindex="-1" readOnly></td>
				<th>Actual Month</th>
				<td><input type="text" name="act_year" maxlength="4" style="width:40px;text-align:center;ime-mode:disabled;text-align:center;"  class="input">
				<input type="text" name="act_month" style="width:30px;text-align:center;ime-mode:disabled;text-align:center;"  class="input1"></td>				
			</tr>
		</tbody>
	</table>	
</div>
<!-- opus_design_inquiry(E) -->
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer">	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>	
</div>
<!-- opus_design_grid(S) -->	
</form>