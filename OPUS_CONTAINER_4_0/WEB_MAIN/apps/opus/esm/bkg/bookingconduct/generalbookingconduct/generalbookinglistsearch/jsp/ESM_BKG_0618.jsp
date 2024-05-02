<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0616.jsp
*@FileTitle  : Booking EDI Transmit to Terminal 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0618Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%
	String strErrMsg = "";						// error message
	List<BkgComboVO> loadPort = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		loadPort = (List<BkgComboVO>) eventResponse.getCustomData("load_port");

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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />

<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Batch EDI</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Ok</button>  
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="100" />
					<col width="150" />
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th class="sm">Load Port Facility</th> 
						<td class="sm"><%=HTMLUtil.getComboString("edi_ref_cd", "width:100%;", "", "", "", "", loadPort)%></td>
						<th class="sm">VVD</th> 
						<td class="sm"><select name="vvd" style="width:100%;" required caption="VVD"></select></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- inquiry_area(E) -->
	</div>
</div>
<script type="text/javascript">
	ComSheetObject('sheet1');
</script>
<!-- popup_contens_area(E) -->
</form>