<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tescommon.event.TESCommonEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String mode		= request.getParameter("mode")!=null&&!request.getParameter("mode").equals("")?request.getParameter("mode"):"";
	String coid		= request.getParameter("coid")!=null&&!request.getParameter("coid").equals("")?request.getParameter("coid"):"";
	String idx		= request.getParameter("idx")!=null&&!request.getParameter("idx").equals("")?request.getParameter("idx"):"";
	String f_cmd	= request.getParameter("f_cmd")!=null&&!request.getParameter("f_cmd").equals("")?request.getParameter("f_cmd"):"";
	String def		= request.getParameter("def")!=null&&!request.getParameter("def").equals("")?request.getParameter("def"):"";
	String functionName		= request.getParameter("functionName")!=null&&!request.getParameter("functionName").equals("")?request.getParameter("functionName"):"";
	String ifrId	= request.getParameter("ifrId")!=null&&!request.getParameter("ifrId").equals("")?request.getParameter("ifrId"):"";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body onload="setupPage();"><!-- onunload="alert('bye!! - '+document.form.ifrId.value);"-->
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="mode"	value="<%=mode%>">
<input type="hidden" name="coid"	value="<%=coid%>">
<input type="hidden" name="idx"		value="<%=idx%>">
<input type="hidden" name="f_cmd"	value="<%=f_cmd%>">
<input type="hidden" name="def"		value="<%=def%>">
<input type="hidden" name="functionName" value="<%=functionName%>">
<input type="hidden" name="ifrId"	value="<%=ifrId%>">
<%
	String param_name2 = null;
	java.util.Enumeration enums2 = request.getParameterNames();
	while (enums2.hasMoreElements()){
		param_name2 = (String)enums2.nextElement();
		if (
			param_name2!=null && 
			!param_name2.equals("mode") && !param_name2.equals("coid") && !param_name2.equals("idx") && 
			!param_name2.equals("f_cmd") && !param_name2.equals("def") && !param_name2.equals("functionName") && 
			!param_name2.equals("ifrId")
			) 
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

</form>
</body>
</html>
