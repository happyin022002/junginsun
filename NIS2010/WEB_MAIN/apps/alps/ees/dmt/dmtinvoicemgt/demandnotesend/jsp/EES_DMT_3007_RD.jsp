<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3109_RD.jsp
*@FileTitle : Demand Note Issue by Booking - RD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.18 최성환
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