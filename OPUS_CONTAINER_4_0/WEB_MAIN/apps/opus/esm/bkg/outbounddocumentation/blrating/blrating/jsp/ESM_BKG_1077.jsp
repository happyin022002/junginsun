<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1077.jsp
*@FileTitle  : Rating Application Date Search 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1077Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1077Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1077Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    function setupPage(){  
	    loadPage();
    }
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bkg_no" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" type="hidden" />
<input id="bdrflag" name="bdrflag" value="<%=JSPUtil.getParameter(request, "bdrflag")%>" type="hidden" />
<input id="caflag" name="caflag" value="<%=JSPUtil.getParameter(request, "caflag")%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Rating Application Date Search</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn1_Apply" name="btn1_Apply" class="btn_accent">Apply</button><!--
		--><button type="button" id="btn1_Close" name="btn1_Close" class="btn_normal">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">	
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	
		<div class="opus_design_inquiry sm" style="margin-right: 20px; width: 470px;">
			<div id='options'>
				Application Date - CRD : From or to US, CA, MX bookings
			</div>
			<div id='options2'>
				ETD of 1st VVD : The other bookings
			</div>
			
		</div>
		
		
		<div id='options2'>
				Application Date &nbsp;&nbsp;  <input id="apply_dt" style="width:80px;" class="input2" value="" name="apply_dt" readonly type="text" />
			</div>
	</div>

		

</div>

</form>			