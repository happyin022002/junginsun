<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.jf.transfer.TransferEAI" %>
<%@ page import="com.jf.transfer.jms.send.vandor.WeblogicSendQClient" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.hanjin.sample.eai.jms.Dummy" %>

<%
	int maxRun = Integer.parseInt(request.getParameter("loop"));
	
	for (int i = 0; i < maxRun; i++) {
	
		try {
			//long startTime = System.currentTimeMillis();			
			TransferEAI transferEAI = new WeblogicSendQClient("t3://203.246.130.159:5110", Dummy.class);
			
			transferEAI.setFactory("jms/ALPSJ_CFA");
			transferEAI.setQueue("jms/ALPSJ_DQSA");
			transferEAI.setDestination("SAM001-0001");
			String instanceId = "SAM001-0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()) + "-" + i;
			String msgHeader = "<InstanceId>" + instanceId + "</InstanceId>\n";
			String msgBody = "<Message>" + request.getParameter("message") + "</Message>";
			transferEAI.setMessage(msgHeader + msgBody);
			
			//System.out.println("Instance ID: " + msgHeader.substring(msgHeader.indexOf("<InstanceId>") + 12, msgHeader.indexOf("</InstanceId>")));
			//System.out.println(msgHeader + msgBody);
			
			transferEAI.commit(instanceId);
			
			//long endTime = System.currentTimeMillis();
			
			//System.out.println("=============== Summary ===============");
			//System.out.println("Started at " + startTime);
			//System.out.println("Ended at " + endTime);
			//long elapsed = endTime - startTime;
			//System.out.println("Time Elapsed: " + elapsed + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	response.sendRedirect("jmsTest.jsp");
	
%>