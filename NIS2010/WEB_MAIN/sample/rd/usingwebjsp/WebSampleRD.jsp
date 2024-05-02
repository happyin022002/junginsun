
<%@page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>
<%@page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@page import="com.hanjin.syscommon.common.table.ComUpldFileVO"%>
<%@page import="java.util.List"%>
<%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%><%
GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
List<ComUpldFileVO> list = (List<ComUpldFileVO>)eventResponse.getCustomData("RD");
String rdDelimiter = SubSystemConfigFactory.get("RDWEB.DELIMITER");
for(int i=0;i<list.size();i++){
	out.println(list.get(i).getFileSavId()+rdDelimiter+list.get(i).getFileUpldNm()+rdDelimiter+list.get(i).getFileSzCapa());
}
%>