<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4003_RD.jsp
*@FileTitle : Invoice Issue Preview - RD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/ 
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%
GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
String report= (String)eventResponse.getCustomData("RD");
out.print(report);

%>
