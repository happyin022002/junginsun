<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0038.jsp
*@FileTitle  : Sub trade management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;                 //Error from server
    String strErrMsg    = "";                           //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0038");
    try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
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

		<div class="layer_popup_title">
			<div class="page_title_area clear">
				<h2 class="page_title"><span>SUB Trade Info</span></h2>
				
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
				</div>
			</div>
		</div>


<body onload="javascript:setupPage();">
<form method="post" name="form">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="txtVsl_cd">
<input type="hidden" name="f_chkdel">


		
		<div class="layer_popup_contents">
			<div class="wrap_search">
				<div class="opus_design_inquiry wFit">
									<script language="javascript">ComSheetObject('sheet1');</script></script>
				</div>
			</div>
		</div>
</form>
</body>
<!-- : ( Button : pop ) (E) -->
