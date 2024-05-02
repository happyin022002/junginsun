<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.hanjin.syscommon.management.alps.report.vo.ComFaxVO" %>
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
		List<ComFaxVO> voList = eventResponse.getRsVoList();
		int dataCnt = voList.size();
		int[] stsDataCnt = {0,0,0,0,0,0,0};
	
		for(int j=0; j<dataCnt; j++){
			ComFaxVO vo = voList.get(j);
			if(vo.getFaxProcStsCd().equals("0")){
				stsDataCnt[0]++;
			}else if(vo.getFaxProcStsCd().equals("1")){
				stsDataCnt[1]++;
			}else if(vo.getFaxProcStsCd().equals("2")){
				stsDataCnt[2]++;
			}else if(vo.getFaxProcStsCd().equals("3")){
				stsDataCnt[3]++;
			}else if(vo.getFaxProcStsCd().equals("4")){
				stsDataCnt[4]++;
			}else if(vo.getFaxProcStsCd().equals("5")){
				stsDataCnt[5]++;
			}else if(vo.getFaxProcStsCd().equals("6")){
				stsDataCnt[6]++;
			}
		}
		%>
		<h3>데이터 건수</h3>
		<table style="font-size:12" border=1 cellspacing="1" cellpadding="5" bordercolor="#000000">
		<tr bgcolor="FFCC99"><th>전송상태</th><th>건수</th></tr>
		<tr><th>0</th><th><%out.print(stsDataCnt[0]);%></th></tr>
		<tr><th>1</th><th><%out.print(stsDataCnt[1]);%></th></tr>
		<tr><th>2</th><th><%out.print(stsDataCnt[2]);%></th></tr>
		<tr><th>3</th><th><%out.print(stsDataCnt[3]);%></th></tr>
		<tr><th>4</th><th style="color:red"><%out.print(stsDataCnt[4]);%></th></tr>
		<tr><th>5</th><th style="color:green"><%out.print(stsDataCnt[5]);%></th></tr>
		<tr><th>6</th><th><%out.print(stsDataCnt[6]);%></th></tr>
		<tr><th>총 데이터 건수</th><th><%out.print(dataCnt);%>건</th></tr>
		</table>
		<h3>데이터 목록</h3>
		<table style="font-size:12" border=1 cellspacing="1" cellpadding="5" bordercolor="#000000"> 
			<tr bgcolor="66CCFF">
			<th>FAX_SND_NO</th>
			<th>RD_SUB_SYS_CD</th>
			<th>RD_APPL_CD</th>
			<th>BAT_FLG</th>
			<th>FAX_TIT_NM</th>
			<th>FAX_PROC_STS_CD</th>
			<th>RCVR_INFO_CTNT</th>
			<th>PARA_INFO_CTNT</th>
			<th>OFC_CD</th>
			<th>FAX_IP</th>
			<th>RPT_FILE_NM</th>
			<th>TTL_PG_KNT</th>
			<th>XPT_RSLT_CD</th>
			<th>XPT_DT</th>
			<th>FTP_RSLT_CD</th>
			<th>FTP_DT</th>
			<th>FTP_ERR_MSG</th>
			<th>FAX_DT</th>
			<th>FAX_ERR_MSG</th>
			<th>DELT_FLG</th>
			<th>CRE_USR_ID</th>
			<th>CRE_DT</th>
			<th>UPD_USR_ID</th>
			<th>UPD_DT</th>
			</tr>
		<%
		for(int i=0; i<dataCnt; i++){
			ComFaxVO vo = voList.get(i);
		%>
			<tr align='left'>
			<td><%out.print(vo.getFaxSndNo());%></td>
			<td><%out.print(vo.getRdSubSysCd());%></td>
			<td><%out.print(vo.getRdApplCd());%></td>
			<td><%out.print(vo.getBatFlg());%></td>
			<td><%out.print(vo.getFaxTitNm());%></td>
			<td><%out.print(vo.getFaxProcStsCd());%></td>
			<td><%out.print(vo.getRcvrInfoCtnt());%></td>
			<td><%out.print(vo.getParaInfoCtnt());%></td>
			<td><%out.print(vo.getOfcCd());%></td>
			<td><%out.print(vo.getFaxIp());%></td>
			<td><%out.print(vo.getRptFileNm());%></td>
			<td><%out.print(vo.getTtlPgKnt());%></td>
			<td><%out.print(vo.getXptRsltCd());%></td>
			<td><%out.print(vo.getXptDt());%></td>
			<td><%out.print(vo.getFtpRsltCd());%></td>
			<td><%out.print(vo.getFtpDt());%></td>
			<td><%out.print(vo.getFtpErrMsg());%></td>
			<td><%out.print(vo.getFaxDt());%></td>
			<td><%out.print(vo.getFaxErrMsg());%></td>
			<td><%out.print(vo.getDeltFlg());%></td>
			<td><%out.print(vo.getCreUsrId());%></td>
			<td><%out.print(vo.getCreDt());%></td>
			<td><%out.print(vo.getUpdUsrId());%></td>
			<td><%out.print(vo.getUpdDt());%></td>
			</tr>
		<%}%>
		</table>
</body>
</html>