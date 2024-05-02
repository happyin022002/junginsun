<%@page import="com.clt.apps.opus.cps.cni.common.CniConst"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%
GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
String report= (String)eventResponse.getCustomData(CniConst.RD);
out.print(report);
%>