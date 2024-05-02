<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0922.jsp
*@FileTitle  : Office Search(Agent List) Popup Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0922Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0922Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//error from server
	String strErrMsg = ""; 				//error message
	int rowCount = 0; 					//DB ResultSet List count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0922Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	  String ofc_cd   = JSPUtil.getParameter(request,"ofc_cd");
	  String custFunc       = JSPUtil.getNull(request.getParameter("func"));	  
%>


<script type="text/javascript">

	    if(!opener) opener = window.dialogArguments;
	    if(!opener) opener=parent;
		<%
				if(!custFunc.equals("")) {					
		%>
		var callbackMethod = opener.<%= custFunc%>;
		//var callbackMethod = <%= custFunc%>;
		<%
				} else{
		%>
			var callbackMethod = null; 
		<%
				}
		%>
		
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="bl_prn_dvc_nm" value="" id="bl_prn_dvc_nm" />
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Office Inquiry</span></h2>
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<table class="grid_2">
				<colgroup>
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th style="text-align:center;">Office Code</th> 
						<td><input type="text" style="width:100px;text-align:center;ime-mode:disabled;" dataformat='enguponly' class="input1" value="<%=ofc_cd%>" name="ofc_cd" id="ofc_cd"></td>
					</tr>
					<tr>
						<th style="text-align:center;">Name</th> 
						<td><input type="text" style="width:90%;ime-mode:disabled;" class="noinput" value="" name="eng_nm" id="eng_nm"></td>
					</tr>
					<tr>
						<th style="text-align:center;">Address</th> 
						<td><textarea  style="width:90%;height:40px;resize:none;" name="address" id="address"></textarea></td>
					</tr>
					<tr>
						<th style="text-align:center;">Country</th> 
						<td><input type="text" style="width:90%" class="noinput" value="" name="country" id="country"></td>
					</tr>
					<tr>
						<th style="text-align:center;">Phone No.(Rep.)</th> 
						<td><input type="text" style="width:90%" class="noinput" value="" name="phone_no" id="phone_no"></td>
					</tr>
					<tr>
						<th style="text-align:center;">Fax No.(Rep.)</th> 
						<td><input type="text" style="width:90%" class="noinput" value="" name="fax_no" id="fax_no"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid"  style="display:none">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
 	 </div>
</div>

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>