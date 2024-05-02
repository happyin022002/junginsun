<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0936.jsp
*@FileTitle  : BKG CGO SPE Detail Popup - AK
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSet list

	String bkg_no  = "";	
	String cntr_no  = "";
	String ui_conti_cd = "";
	String tro_seq ="";

	bkg_no = ((request.getParameter("bkg_no")==null )?"":request.getParameter("bkg_no"));	
	cntr_no = ((request.getParameter("cntr_no")==null )?"":request.getParameter("cntr_no"));
	ui_conti_cd = request.getParameter("ui_conti_cd") == null ? "" : request.getParameter("ui_conti_cd").trim();
	tro_seq = ((request.getParameter("tro_seq")==null )?"":request.getParameter("tro_seq"));
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
</head>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(bkg_no)%>" id="bkg_no" />
<input type="hidden" name="cntr_no" value="<%=StringUtil.xssFilter(cntr_no)%>" id="cntr_no" />
<input type="hidden" name="ui_conti_cd" value="<%=StringUtil.xssFilter(ui_conti_cd)%>" id="ui_conti_cd" />
<input type="hidden" name="tro_seq" value="<%=StringUtil.xssFilter(tro_seq)%>" id="tro_seq" />
<div class="layer_popup_contents"  style="overflow:hidden">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>BKG CGO SPE Detail- AK</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>