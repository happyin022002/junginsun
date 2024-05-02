<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0708.jsp
*@FileTitle  :   C/A Issue Reason Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception        serverException = null;	//error from the server	
	String strErrMsg = "";						//error messege

	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.BdrCorrection");
	String calllFunc = "";
	try {		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		calllFunc  = JSPUtil.getParameter(request, "func");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Enter reason for cancellation</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_select" id="btn_select">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_inquiry">
		<table class="grid_2">
			<tbody>
				<tr>
					<th class="align_center"><b>Remark(s)</b></th>
					<td><textarea name="xter_rmk" id="xter_rmk" cols="40" rows="3" style="resize:none;font-family:Courier New; font-size:12px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img5" wrap="physical" dataformat="excepthan" onBlur="javascript:validateCols('5','40',this);" wrap="hard" maxlength="1000" Caption="Remark" disabled="disabled"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

</div>
</form>