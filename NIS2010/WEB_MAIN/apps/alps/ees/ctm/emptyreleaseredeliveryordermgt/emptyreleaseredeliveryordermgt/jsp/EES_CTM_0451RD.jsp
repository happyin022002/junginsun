<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0451RD.jsp
*@FileTitle : Release/Re-delivery Order Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.16 김상수
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
String report= (String)eventResponse.getCustomData("RD");
out.print(report);
%>