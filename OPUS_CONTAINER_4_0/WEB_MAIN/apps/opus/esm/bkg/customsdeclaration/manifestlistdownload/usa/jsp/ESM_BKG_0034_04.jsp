<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_04.jsp
*@FileTitle  :  B/L Inquiry_Remarks
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0034Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmBkg0034Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0034Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="<%=pageRows %>" id="pagerows" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="tab_no" value="4" id="tab_no" />
<input type="hidden" name="bl_no" id="bl_no" />
<input type="hidden" name="bak_diff_rmk" id="bak_diff_rmk" />

<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width:998px">
    <div class="layout_vertical_2" style="margin-top:27px">
		<table> 
	        <tr>
	        	<td><textarea name="diff_rmk" style="width:99%;height:253px;resize:none" ></textarea></td>
	        </tr>
        </table> 
    </div>
    <div class="layout_vertical_2">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
	        <!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_railAMS" id="btn_railAMS" type="button">Rail AMS History</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
            <script type="text/javascript">ComSheetObject('t4sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
</div>
<!-- layout_wrap(E) -->
</form>
