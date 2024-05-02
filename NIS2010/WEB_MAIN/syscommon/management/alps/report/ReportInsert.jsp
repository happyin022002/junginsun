<%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.hanjin.syscommon.management.alps.report.vo.ReportDesignerVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>등록 결과 화면</title>
</head>
<body>

	<h3><%
	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	if(eventResponse != null){
		String checkFlag = (String)eventResponse.getCustomData("checkFlag");
		out.print(checkFlag);
	}else{
		out.print("등록 실패 :(");
	}	
	%></h3>
</body>
</html>