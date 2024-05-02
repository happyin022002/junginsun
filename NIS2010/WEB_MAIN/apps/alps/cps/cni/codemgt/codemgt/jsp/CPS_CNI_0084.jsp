<%@page import="com.hanjin.apps.alps.cps.cni.common.CniConst"%><%@ page contentType="text/html; charset=UTF-8"%><%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%><%
GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
String report= (String)eventResponse.getCustomData(CniConst.RD);
out.print(report);%>