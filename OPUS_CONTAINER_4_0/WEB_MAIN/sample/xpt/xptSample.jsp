<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.clt.framework.table.ComRptDsgnXptInfoVO"%>
<%@page import="com.clt.framework.component.rdexport.ReportDesignerExporter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ReportDesignerExporter reportDesignerExporter = new ReportDesignerExporter();
	List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
	ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
	comRptDsgnXptInfoVO.setCreUsrId("Test");
	comRptDsgnXptInfoVO.setRdTmpltNm("TEST.mrd");
	comRptDsgnXptInfoVO.setRdParaCtnt("");
	comRptDsgnXptInfoVO.setXptFileNm("TESTPDF.pdf");
	comRptDsgnXptInfoVO.setUpdUsrId("Test");
	comRptDsgnXptInfoVO.setXptFileTpCd("5");
	

	ComRptDsgnXptInfoVO comRptDsgnXptInfoVO1 = new ComRptDsgnXptInfoVO();
	comRptDsgnXptInfoVO1.setCreUsrId("Test");
	comRptDsgnXptInfoVO1.setRdTmpltNm("TEST.mrd");
	comRptDsgnXptInfoVO1.setRdParaCtnt("");
	comRptDsgnXptInfoVO1.setXptFileNm("TESTPDF.pdf");
	comRptDsgnXptInfoVO1.setUpdUsrId("Test");
	comRptDsgnXptInfoVO1.setXptFileTpCd("5");
	
	comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
	comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO1);
	
	reportDesignerExporter.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
	String fileReturnKey = reportDesignerExporter.export();
	out.print(fileReturnKey);
%>
</body>
</html>