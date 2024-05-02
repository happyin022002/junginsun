<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0054
*@FileTitle  : RU Label - Search Condition
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/17
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0054Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesMst0054Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet List the number of

	SignOnUserAccount account = null;
	String par_rulabel_type = "";
	String par_rstr_usg_lbl = "";
	try {

		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EesMst0054Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end if

	   par_rulabel_type = (StringUtil.xssFilter(request.getParameter("par_rulabel_type")) == null)? "": StringUtil.xssFilter(request.getParameter("par_rulabel_type"));	  
	   par_rstr_usg_lbl = (StringUtil.xssFilter(request.getParameter("par_rstr_usg_lbl")) == null)? "": StringUtil.xssFilter(request.getParameter("par_rstr_usg_lbl"));
		  
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

<form method="post" name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<input id="par_rulabel_type" name="par_rulabel_type" type="hidden" value="<%=par_rulabel_type %>"/>
<input id="par_rstr_usg_lbl" name="par_rstr_usg_lbl" type="hidden" value="<%=par_rstr_usg_lbl %>" />
<input id="chk_lbl" name="chk_lbl" type="hidden" />
<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>RU Label - Search Condition</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button>
			<button type="button" class="btn_normal" name="btn_OK"  	id="btn_OK">OK</button>
			<button type="button" class="btn_normal" name="btn_Close"  	id="btn_Close">Close</button> 
		</div>
		<!-- opus_design_btn(E) -->

	</div>
	<!-- page_title_area(E) -->

</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
</div>
</form>