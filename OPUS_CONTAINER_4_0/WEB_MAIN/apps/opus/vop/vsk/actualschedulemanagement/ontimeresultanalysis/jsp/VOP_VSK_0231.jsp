<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0231.jsp
*@FileTitle  : SKD for Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0231Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0231Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ActualScheduleManagement.OnTimeResultAnalysis");

	String vsl_cd = "";
	String voy_no = "";
	String dir_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0231Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		vsl_cd = event.getAttribute("vsl_cd") == null ? "" : event.getAttribute("vsl_cd").toString();	
		voy_no = event.getAttribute("voy_no") == null ? "" : event.getAttribute("voy_no").toString();	
		dir_cd = event.getAttribute("dir_cd") == null ? "" : event.getAttribute("dir_cd").toString();	

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="tmp_vsl_cd" id="tmp_vsl_cd" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>SKD for Conversion</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 			id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ok" 				id="btn_ok">Select</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->
</div>


<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>				
				<col width="30"/>
				<col width="180"/>
				<col width="50"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr class="h23">
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="vsl_cd" class="input1" maxlength="4" dataformat="engup" value="<%=vsl_cd %>" tabindex="1" id="vsl_cd" /><!-- 
						  --><input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="voy_no" class="input1" maxlength="4" dataformat="num" value="<%=voy_no %>" tabindex="2" id="voy_no" /><!-- 
						  --><input type="text" style="width:20px;ime-mode:disabled;text-align:center" name="dir_cd" class="input1" maxlength="1" dataformat=enguponly value="<%=dir_cd %>" tabindex="3" id="dir_cd"/><!-- 
						  --><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button></td>
					<th>Lane Code</th>
					<td><input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="vsl_slan_cd" class="input2" maxlength="3" dataformat="engup" value="" tabindex="4" readonly id="vsl_slan_cd" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</div>
</form>
