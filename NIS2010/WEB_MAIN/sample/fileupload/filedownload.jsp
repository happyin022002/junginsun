<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.hanjin.framework.core.config.SiteConfigFactory"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <form name="form" action="/hanjin/FileDownload" method="post">
key :<input type="text" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" size="55" >
<br>
<input type="button" value="DownLoadJsp" onclick="form.submit()">

</form>

</body>
</html>