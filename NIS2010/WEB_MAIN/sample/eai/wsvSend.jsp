<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.jf.transfer.TransferEAI" %>
<%@ page import="com.jf.transfer.ws.AxAyDocClient" %>
<%@ page import="com.jf.transfer.ws.AxDocClient" %>
<%@ page import="com.hanjin.integration.alps.SynchWebServicesSampleDocument" %>
<%@ page import="com.hanjin.integration.alps.SynchWebServicesSampleDocument.SynchWebServicesSample" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.hanjin.sample.eai.jms.Dummy" %>

<%
	
		try {
			long startTime = System.currentTimeMillis();
			
			//NamingManager.setInitialContextFactoryBuilder(new DatabaseContextFactory());
			
			TransferEAI transferEAI;
			
			SynchWebServicesSampleDocument doc = SynchWebServicesSampleDocument.Factory.newInstance();
			SynchWebServicesSample synchwssample = doc.addNewSynchWebServicesSample();
			synchwssample.setCmdtCd(request.getParameter("message"));
			
			String type = request.getParameter("type");
			
			if (type.equals("axay")) {
				transferEAI = new AxAyDocClient("http://localhost:7001/hanjin/webservices/WSDocProxy?WSDL", Dummy.class);
			} else { // type = "ax"
				transferEAI = new AxDocClient("http://localhost:7001/hanjin/webservices/WSDocProxy?WSDL", Dummy.class);
			}
			
			transferEAI.setFactory("jms/ALPSJ_CFA");
			transferEAI.setQueue("jms/ALPSJ_DQRA");
			
			transferEAI.setObj(doc);
			
			System.out.println(request.getParameter("message"));
			
			transferEAI.commit("WSVSendTest" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
			
			long endTime = System.currentTimeMillis();
			
			System.out.println("=============== Summary ===============");
			System.out.println("Started at " + startTime);
			System.out.println("Ended at " + endTime);
			long elapsed = endTime - startTime;
			System.out.println("Time Elapsed: " + elapsed + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}


	response.sendRedirect("wsvTest.jsp");
	
%>