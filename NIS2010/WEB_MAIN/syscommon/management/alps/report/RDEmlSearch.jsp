<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.hanjin.syscommon.management.alps.report.vo.ComEmlVO" %>
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
		List<ComEmlVO> voList = eventResponse.getRsVoList();
		int dataCnt = voList.size();
		int[] stsDataCnt = {0,0,0,0,0};
		
		for(int j=0; j<dataCnt; j++){
			ComEmlVO vo = voList.get(j);
			if(vo.getEmlProcStsCd().equals("0")){
				stsDataCnt[0]++;
			}else if(vo.getEmlProcStsCd().equals("1")){
				stsDataCnt[1]++;
			}else if(vo.getEmlProcStsCd().equals("2")){
				stsDataCnt[2]++;
			}else if(vo.getEmlProcStsCd().equals("3")){
				stsDataCnt[3]++;
			}else if(vo.getEmlProcStsCd().equals("4")){
				stsDataCnt[4]++;
			}
		}
		%>
		<h3>데이터 건수</h3>
		<table style="font-size:12" border=1 cellspacing="1" cellpadding="5" bordercolor="#000000">
		<tr bgcolor="FFCC99"><th>전송상태</th><th>건수</th></tr>
		<tr><th>0</th><th><%out.print(stsDataCnt[0]);%></th></tr>
		<tr><th>1</th><th><%out.print(stsDataCnt[1]);%></th></tr>
		<tr><th>2</th><th><%out.print(stsDataCnt[2]);%></th></tr>
		<tr><th>3</th><th style="color:green"><%out.print(stsDataCnt[3]);%></th></tr>
		<tr><th>4</th><th style="color:red"><%out.print(stsDataCnt[4]);%></th></tr>
		<tr><th>총 데이터 건수</th><th><%out.print(dataCnt);%>건</th></tr>
		</table>
		<h3>데이터 목록</h3>
		<table style="font-size:12" border=1 cellspacing="1" cellpadding="5" bordercolor="#000000"> 
			<tr bgcolor="66CCFF">
			<th>EML_SND_NO</th>
			<th>RD_SUB_SYS_CD</th>
			<th>BAT_FLG</th>
			<th>EML_TIT_NM</th>
			<th>EML_PROC_STS_CD</th>
			<th>SNDR_NM</th>
			<th>SNDR_EML</th>
			<th>TO_EML_CTNT</th>
			<th>SMTP_IP</th>
			<th>DELT_FLG</th>
			<th>CRE_USR_ID</th>
			<th>UPD_DT</th>
			</tr>
		<%
		for(int i=0; i<dataCnt; i++){
			ComEmlVO vo = voList.get(i);
		%>
			<tr align='left'>
			<td><%out.print(vo.getEmlSndNo());%></td>
			<td><%out.print(vo.getRdSubSysCd());%></td>
			<td><%out.print(vo.getBatFlg());%></td>
			<td><%out.print(vo.getEmlTitNm());%></td>
			<td><%out.print(vo.getEmlProcStsCd());%></td>
			<td><%out.print(vo.getSndrNm());%></td>
			<td><%out.print(vo.getSndrEml());%></td>
			<td><%out.print(vo.getToEmlCtnt());%></td>
			<td><%out.print(vo.getSmtpIp());%></td>
			<td><%out.print(vo.getDeltFlg());%></td>
			<td><%out.print(vo.getCreUsrId());%></td>
			<td><%out.print(vo.getUpdDt());%></td>
			</tr>
		<%}%>
		</table>
</body>
</html>