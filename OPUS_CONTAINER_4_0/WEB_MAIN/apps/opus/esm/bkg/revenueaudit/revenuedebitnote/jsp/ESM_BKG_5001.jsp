<%
/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_5001.jsp
*@FileTitle  : RDN Receipt by Office Print View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
%>
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
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    
    String successFlag = "";
    String codeList  = "";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.RevenueDebitNote");
    
    String progId = "";    
    String cookiesJSessionId="";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        progId = StringUtil.xssFilter(request.getParameter("progId"));
        
        Cookie[] cookies = request.getCookies();
          if (cookies != null) {
              for (int loop = 0; loop < cookies.length; loop++) {
                     if (cookies[loop].getName().equals("JSESSIONID")) {
                             cookiesJSessionId=cookies[loop].getValue();
                      }
              }
       }

        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
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
<input type="hidden" name="prog_id" value="<%=progId%>">    
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Revenue Debit Note</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
<div class="wrap_result">
		<div class="opus_design_RD">
		<script type="text/javascript">rdViewerObject('rd1');</script>
	    </div>
</div>
</div>
</form>