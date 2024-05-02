<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0101.jsp
*@FileTitle  : Notified Subscriber - Search Inquiry
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
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Setting Error at server side.
	String strErrMsg = "";						//Error Message

	Logger log = Logger.getLogger("com.clt.apps.common.popup");
	String cop_no = request.getParameter("cop_no") == null ? "" : request.getParameter("cop_no");
//out.println(cop_no);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);


		event = (CommonPopUpManageEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// The data obtained from the server side on load.
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
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span id="titles">COP Summary</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="70" />
				<col width="130" />
				<col width="70" />
				<col width="130" />
				<col width="90" />
				<col width="130" />
				<col width="70" />
				<col width="130" />
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tr>
                <th>BKG No. :</th>
                <td  id="bkg_no" name="bkg_no" ></td>
                <th>B/L No. :</th>
                <td  id="bl_no" name="bl_no" ></td>
                <th>Container No. :</th>
                <td  id="cntr_no" name="cntr_no" ></td>
                <th>COP No. :</th>
                <td  id="cop_no1" name="cop_no1" ><input name="cop_no" value="<%=cop_no%>" type="hidden" readonly id="cop_no" /> </td>
                <th>R/D Term : </th>
                <td  id="rdterm" name="rdterm" ></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="70" />
				<col width="130" />
				<col width="70" />
				<col width="130" />
				<col width="90" />
				<col width="130" />
				<col width="70" />
				<col width="130" />
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tr>
                <th>VVD : </th>
                <td  id="vvd" name="vvd" ></td>
                <th>POR : </th>
                <td  id="por" name="por" ></td>
                <th>POL : </th>
                <td  id="pol" name="pol" ></td>
                <th>POD : </th>
                <td  id="pod" name="pod" ></td>
                <th>DEL : </th>
                <td  id="del" name="del" ></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>