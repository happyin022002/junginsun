<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1802.jsp
*@FileTitle  : XML View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg1802Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRevMsgVO" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1802Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//error from server
	String strErrMsg 	= "";						//error message
	int rowCount	 	= 0;						//count of DB resultSET list
	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String mainPage 	= "";
	
	String sndrId 	= request.getParameter("sndr_id");
	String rqstNo 	= request.getParameter("rqst_no");
	String rqstSeq 	= request.getParameter("rqst_seq");
	String msgSeq 	= request.getParameter("msg_seq");
	
	BkgXterRevMsgVO bkgXterRevMsgVO = null;
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.UserSetupMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1802Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

//		bkgXterRevMsgVO = (BkgXterRevMsgVO) eventResponse.getCustomData("bkgXterRevMsgVO");
		
	}catch(Exception e) {
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="xter_sndr_id" id="xter_sndr_id" value="<%=StringUtil.xssFilter(sndrId) %>">
<input type="hidden" name="xter_rqst_no" id="xter_rqst_no" value="<%=StringUtil.xssFilter(rqstNo) %>">
<input type="hidden" name="xter_rqst_seq" id="xter_rqst_seq" value="<%=StringUtil.xssFilter(rqstSeq) %>">
<input type="hidden" name="xter_rqst_msg_seq" id="xter_rqst_msg_seq" value="<%=StringUtil.xssFilter(msgSeq) %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Pegasus XML View</span></h2>
	<!-- page_title(E) -->	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<table class="sm">
		<tr>
		    <td><textarea name=xml_and_edi_msg_desc id="xml_and_edi_msg_desc" style="resize:none;font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden;overflow-y:scroll" cols="45" rows="25" class="textarea" readOnly></textarea></td>				
	  	</tr>			
	</table>
</div>
<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>

</form>


