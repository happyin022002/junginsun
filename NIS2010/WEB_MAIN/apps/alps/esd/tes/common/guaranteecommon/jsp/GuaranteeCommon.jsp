<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeCommon.jsp
*@FileTitle : GuaranteeCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.22 yOng hO lEE
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.guaranteecommon.event.GuaranteeCommonEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	GuaranteeCommonEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GuaranteeCommon.GuaranteeCommon");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (GuaranteeCommonEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<%
	String tes_mode	= request.getParameter("tes_mode") != null && !request.getParameter("tes_mode").equals("") ? request.getParameter("tes_mode") : "";
	String oid		= request.getParameter("oid") != null && !request.getParameter("oid").equals("") ? request.getParameter("oid") : "";
	String idx		= request.getParameter("idx") != null && !request.getParameter("idx").equals("") ? request.getParameter("idx") : "";
	String f_cmd	= request.getParameter("f_cmd") != null && !request.getParameter("f_cmd").equals("") ? request.getParameter("f_cmd") : "";
	String def		= request.getParameter("def") != null && !request.getParameter("def").equals("") ? request.getParameter("def") : "";
	String functionName		= request.getParameter("functionName") != null && !request.getParameter("functionName").equals("") ? request.getParameter("functionName") : "";
	String ifrId	= request.getParameter("ifrId") != null && !request.getParameter("ifrId").equals("") ? request.getParameter("ifrId") : "";
	String sheetObj	= request.getParameter("sheetObj") != null && !request.getParameter("sheetObj").equals("") ? request.getParameter("sheetObj") : "";
%>
<html>
<head>
<title>GuaranteeCommon</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<!-- 개발자 작업	-->


<body onload="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="tes_mode" value="<%=tes_mode%>">
<input type="hidden" name="oid" value="<%=oid%>">
<input type="hidden" name="idx" value="<%=idx%>">
<input type="hidden" name="f_cmd" value="<%=f_cmd%>">
<input type="hidden" name="def" value="<%=def%>">
<input type="hidden" name="functionName" value="<%=functionName%>">
<input type="hidden" name="ifrId" value="<%=ifrId%>">
<input type="hidden" name="sheetObj" value="<%=sheetObj%>">

<%
	String param_name2 = null;
	java.util.Enumeration enums2 = request.getParameterNames();
	while (enums2.hasMoreElements()){
		param_name2 = (String)enums2.nextElement();
		if (param_name2!=null && 
			!param_name2.equals("tes_mode") && !param_name2.equals("oid") && 
			!param_name2.equals("idx") && !param_name2.equals("f_cmd") && 
			!param_name2.equals("def") && !param_name2.equals("functionName") && 
			!param_name2.equals("ifrId") && !param_name2.equals("sheetObj")) 
		{
			out.println("<input type='hidden' name='" + param_name2 + "'  value='" + request.getParameter(param_name2)+"'>");
		}
	}
%>

	<table width="100%" id="mainTable">
		<tr><td>
			 <script language="javascript">ComSheetObject('sheet');</script>
		</td></tr>
	</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>