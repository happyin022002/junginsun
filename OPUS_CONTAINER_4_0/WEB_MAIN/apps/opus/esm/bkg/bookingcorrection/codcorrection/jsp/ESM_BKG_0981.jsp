<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0981.jsp
*@FileTitle : COD Application at BKG Office
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0981Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0981Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo			= "";
	String strcodRqstSeq    = "";
	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.CODCorrection");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0981Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBkgNo =JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());
		strcodRqstSeq =event.getCodRqstSeq();

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>COD History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bkg_no" value="<%=strBkgNo%>" id="bkg_no" />
<input type="hidden" name="cod_rqst_seq" value="<%=strcodRqstSeq%>" id="cod_rqst_seq" />
 
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>COD History</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_print" id="btn_print">Print</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div> 	
</div>
 
  
<div class="layer_popup_contents" style="overflow:hidden">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
			<script type="text/javascript">comRdObject('report1');</script>
	</div>
	</div> 	
</div>

</form>