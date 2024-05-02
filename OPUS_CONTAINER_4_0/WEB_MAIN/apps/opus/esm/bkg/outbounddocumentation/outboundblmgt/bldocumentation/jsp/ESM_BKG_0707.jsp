<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0707.jsp
*@FileTitle  : Mark And Description for C/M
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
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0707Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0707Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");
	
    String bkgNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0707Event)request.getAttribute("Event");
        bkgNo = event.getBkgNo();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
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
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>
</head>


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="cntr_knt">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Copy C/M to Description of Goods</span></h2>
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_OK" id="btn_OK">Copy to Description</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_data">
			<table class="grid2">
				<colgroup>
					<col width="*" />
				</colgroup>
				<tbody>
						<tr><th><strong>Description of Goods</strong></th></tr>
						<tr>
							<td><input type="text" name="pck_cmdt_desc" style="ime-mode:disabled;width:100%;text-align:left;" class="noinput2" readOnly></td>
						</tr>
						<tr>
							<td><input type="text" name="cntr_cmdt_desc" style="ime-mode:disabled;width:100%;text-align:left;" class="noinput2" readOnly></td>
						</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td><textarea name="dg_cmdt_desc" cols="49" rows="10" style="ime-mode:disabled;width:100%;resize:none; font-family:Courier New; font-size:15px; text-indent:0px; overflow-x:hidden;" wrap="physical"></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>
