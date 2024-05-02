<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : esm_bkg_0907.jsp
*@FileTitle  : TRO-Container Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0907Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmBkg0907Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.TransferOrderIssue");
	
	try {

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="io_bnd_cd"><!-- cntr_cd popup use -->

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TRO - Container Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr class="h23">
						<th width="80">Booking No.</th>
						<td width=""><input type="text" name="bkg_no" class="input2" style="width:100;" readonly></td>
					</tr>
					</table>
			</div>		
			</div>	
		<div class="wrap_result">		
    	<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	
</div>
</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>
