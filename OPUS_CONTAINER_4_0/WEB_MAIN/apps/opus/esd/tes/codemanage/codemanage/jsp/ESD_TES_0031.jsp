<% /*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : UI_ESD_TES_031.jsp
*@FileTitle : Carrier Code Creation/Retrieve
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/ %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0031Event"%>
<%
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->
<div class="wrap_result">
<!-- 시트영역 -->
<div class="opus_design_grid">	
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- 시트영역 -->
<div class="header_fixed"></div>
</div>
</form>
