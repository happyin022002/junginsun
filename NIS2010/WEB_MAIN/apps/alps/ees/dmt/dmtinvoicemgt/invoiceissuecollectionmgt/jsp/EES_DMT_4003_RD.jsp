<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4003_RD.jsp
*@FileTitle : Invoice Issue Preview - RD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 김태균
*@LastVersion : 1.0 
* 2009.09.11 김태균
* 1.0 최초 생성 
=========================================================*/ 
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
String report= (String)eventResponse.getCustomData("RD");
out.print(report);

%>
