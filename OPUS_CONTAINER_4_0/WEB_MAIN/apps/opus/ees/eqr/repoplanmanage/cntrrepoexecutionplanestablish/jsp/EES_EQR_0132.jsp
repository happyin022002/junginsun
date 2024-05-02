<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0132.jsp
*@FileTitle  : Search Send History email / fax
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0132Event"%>

<%
	EesEqr0132Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String user_id   = "";
	String target	 = "";
	String job_cd 	 = "";
	String strErrMsg = "";

	try {

	    //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    //userId=account.getUsr_id();
	    event = (EesEqr0132Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		user_id = event.getSignOnUserAccount().getUsr_id();
		target  = event.getTarget();
		job_cd = event.getJobCd();
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
<form  name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="user_id" value="<%= user_id %>" id="user_id" />
<input type="hidden" name="target" value="<%= target %>" id="target" />
<input type="hidden" name="job_cd" value="<%= job_cd %>" id="job_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>E-mail/Fax Sender History</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		 <script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
</div>
</form>