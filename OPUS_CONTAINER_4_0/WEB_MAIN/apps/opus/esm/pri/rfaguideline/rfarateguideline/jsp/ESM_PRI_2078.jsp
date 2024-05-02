<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2078.jsp
*@FileTitle  : RFA Guideline Inquiry - Rate (Commodity) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAGuideline.RFARateGuideline");
	
	String svcScpCd = "";
	String glineSeq = "";
	String cmdtHrdSeq = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		svcScpCd = request.getParameter("svc_scp_cd");
		glineSeq = request.getParameter("gline_seq");
		cmdtHrdSeq = request.getParameter("cmdt_hdr_seq");

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

<!-- 개발자 작업	-->
<input type="hidden" name="cd" value="">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(svcScpCd)%>" >
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(glineSeq)%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(cmdtHrdSeq)%>">

<!-- OUTER - POPUP (S)tart -->
<!-- page_title_area(S) -->
 <div class="layer_popup_title">
<div class="page_title_area clear">

	<!-- page_title(S) -->
    <h2 class="page_title">
        <span>&nbsp; RFA Guideline Inquiry - Rate (Commodity)</span>
    </h2>
    <!-- page_title(E) -->
    
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
    </div>
    <!-- opus_design_btn(E) -->
    
</div>
</div>
<!-- page_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">	
    <div class="wrap_result">
	    <!-- opus_design_grid(S) -->
	    <div id="sheet1Layer" class="opus_design_grid">
	        <script language="javascript">ComSheetObject('sheet1');</script>
	    </div>
	    <!-- opus_design_grid(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->
<!-- page(E) -->

<!-- 개발자 작업  끝 -->
</form>