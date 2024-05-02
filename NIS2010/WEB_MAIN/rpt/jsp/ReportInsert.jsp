<%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Result Screen</title>
</head>
<body>
	<%
	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	if(eventResponse != null){
		String checkFlag = (String)eventResponse.getCustomData("checkFlag");
		out.print(checkFlag);
	}
	%>
</body>
</html>