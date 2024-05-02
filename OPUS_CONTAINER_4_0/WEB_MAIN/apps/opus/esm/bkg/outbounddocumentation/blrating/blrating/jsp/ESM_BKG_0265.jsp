<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0265.jsp
*@FileTitle  : Freight & Charge_Freight & Charge Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0265Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0265Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server		
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0265Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//extract additional data obtained from the server during Initial loading ..
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
<input type="hidden" name="readOnly" value="<%=JSPUtil.getParameter(request, "readOnly")%>" id="readOnly" />

<!-- 개발자 작업	-->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>Charge Remark</span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_clause" id="btn_clause" type="button">Pre Set Clause</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<table>
		<colgroup>
			<col width="90">
			<col width="200">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th class="align_left">Booking No.</th>
				<td><input type="text" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" class="" style="width:110px;" readonly id="bkg_no" /></td>
				<td>&nbsp;</td>
			</tr>
		</tbody>
	</table>
	<br>
	<table>
		<tr>
			<td><h3 class="title_design">Internal Charge Remark for Audit</h3></td>
		</tr>
		<tr>
			<td><textarea rows="6" style="resize:none;font-family:Courier New;width:100%; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img7" wrap="physical" dataformat="engup" otherchar="<%=getSpecialChars()%>"   wrap="hard"  name="inter_rmk" onpaste="javascript:mousePaste(this)" tabindex=64></textarea></td>
		</tr>
		<tr>
			<td><h3 class="title_design">External Charge Remark</h3></td>
		</tr>
		<tr>
			<td><textarea rows="6" style="resize:none;font-family:Courier New;:width:100%; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img7" wrap="physical" dataformat="engup" otherchar="<%=getSpecialChars()%>"   wrap="hard"  name="diff_rmk" onpaste="javascript:mousePaste(this)" tabindex=64></textarea></td>
		</tr>
	</table>
</div>
<div id="Layer1" style="display:none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>

</form>
<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>