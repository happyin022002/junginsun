<%@page import="com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0023R1VO"%><%@ page contentType="text/html; charset=UTF-8"%><%@page import="com.clt.framework.core.config.SubSystemConfigFactory"%><%@page import="com.clt.syscommon.common.table.ComUpldFileVO"%><%@page import="java.util.List"%><%@page import="com.clt.framework.core.layer.event.GeneralEventResponse"%><%
GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
String report= (String)eventResponse.getCustomData("RD");
out.print(report);
%>