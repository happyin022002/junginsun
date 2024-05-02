<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0754.jsp
*@FileTitle  : Special Cargo Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0754Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0754Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String modalFlg = "";
	String bkgNo = "";
	String cntrNo = "";
	String cntrTpszCd = "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0754Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		
		
		modalFlg =  JSPUtil.getParameter(request, "modalFlg");
		bkgNo =  JSPUtil.getParameter(request, "bkgNo");
		cntrNo =  JSPUtil.getParameter(request, "cntrNo");
		cntrTpszCd =  JSPUtil.getParameter(request, "cntrTpszCd");
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" id="bkg_no" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" id="cntr_no" name="cntr_no" value="<%=cntrNo%>">
<input type="hidden" id="cntr_no" name="cntr_tpsz_cd" value="<%=cntrTpszCd%>">
<input type="hidden" id="modalFlg" name="modalFlg" value="<%=modalFlg%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>DG Sequence Selection</span></h2>
		
		<div class="opus_design_btn">
		<% if(modalFlg.equals("Y")){ %>.
			<button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button><!--
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		<%}else{%>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		<%}%>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
