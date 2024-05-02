<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1050.jsp
*@FileTitle  : Container Vol. Adjustment
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
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1050Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1050Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentationCM");

	String bkgNo      = "";
	String cntrNo     = "";
	String cntrVol    = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1050Event)request.getAttribute("Event");
		bkgNo     = event.getBkgNo();
		cntrNo    = event.getCntrNo();
		cntrVol   = event.getCntrVol();
				
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="cntr_vol" value="<%=cntrVol%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Container Vol. Adjustment</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">Ok</button><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- inquiry_area(S) -->
		<div class="opus_design_inquiry">
			<table> 
				<colgroup>
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Container No.</th>
						<td><input type="text" name="cntr_no" value="<%=cntrNo%>" style="ime-mode:disabled;width:300px;" class="input2" readOnly ></td>
						
					</tr>
				</tbody>
			</table>
		</div>
		<!-- inquiry_area(E) -->
	</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->	
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>
