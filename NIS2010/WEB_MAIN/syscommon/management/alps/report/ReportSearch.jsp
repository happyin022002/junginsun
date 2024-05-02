<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.hanjin.syscommon.management.alps.report.vo.ReportDesignerVO" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
		<%
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		List<ReportDesignerVO> voList = eventResponse.getRsVoList();
		int cnt = voList.size();
		%>
	<div align= "left">
		<h2>��ȸ�� ������ ����: <%out.print(cnt);%>��</h2>
		<table  style="font-size:12" border=1 cellspacing="1" cellpadding="5" bordercolor="#000000"> 
			<tr bgcolor="66CCFF" >
			<th>�Ϸù�ȣ</th>
			<th>MRD���ϸ�</th>
			<th>FAX/Email</th>
			<th>����</th>
			<th>����</th>
			</tr>
		<%
		for(int i=0; i<cnt; i++){
		ReportDesignerVO vo = voList.get(i);
		%>
			<tr align='center'>
			<td><%out.print(vo.getRdApplCd());%></td>
			<td><%out.print(vo.getRdTmpltNm());%></td>
			<td><%out.print(vo.getFaxEmlDivCd());%></td>
			<td><%out.print(vo.getJbTitCtnt());%></td>
			<td><%out.print(vo.getJbDesc());%></td>
			</tr>
		<%}%>
		</table>
	</div>
</body>
</html>