<%
/*=========================================================

*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0055.jsp
*@FileTitle  : Container List
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/24

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesMst0055Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (EesMst0055Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name=hid_type value="<%= StringUtil.xssFilter(request.getParameter("hid_type"))  %>" id="hid_type" />
<input type="hidden" name=lot_no value="<%= StringUtil.xssFilter(request.getParameter("lot_no"))  %>" id="lot_no" />
<input type="hidden" name="term_cng_seq" value="<%= StringUtil.xssFilter(request.getParameter("term_cng_seq"))  %>" id="term_cng_seq" />

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Container List</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_normal" name="btn_close"  	id="btn_close" formmethod="post">Close</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->
</div>
<div class="wrap_result bg">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>


<%@include file="/bizcommon/include/common_opus.jsp" %>