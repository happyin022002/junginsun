<%@ page contentType="text/html; charset=UTF-8"%>
<%
 	String principal = request.getParameter("principal");
 	String quantity = request.getParameter("quantity");
 	String iRate = request.getParameter("i_rate");
 	String uPrice = request.getParameter("u_price");
 	String nPayment = request.getParameter("n_payment");
 	String pmt = request.getParameter("pmt");	
 	String pmtDiem = request.getParameter("pmt_diem");	
 %>
	 	
<%	
 	out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
 	out.println("<Excel>");	
 	out.println("<IBSheetSet>");								
	out.println("<StartRow>2</StartRow>");		 					
	out.println("<ViewCols>0|1|2|3|4</ViewCols>");					
	out.println("<DATA>");				
	out.println("<TR>");	
	out.println("<TD>원      금 (U$)</TD>");
	out.println("<TD>");
	out.println(principal);		
	out.println("</TD>");
	out.println("<TD>수          량 (Unit)</TD>");
	out.println("<TD>");	
	out.println(quantity);		
	out.println("</TD>");
	out.println("<TD></TD>");
	out.println("</TR>");
	out.println("<TR>");	
	out.println("<TD>이  자 율 (년)</TD>");
	out.println("<TD>");	
	out.println(iRate);	
	out.println("</TD>");
	out.println("<TD>단          가 (U$)</TD>");
	out.println("<TD>");	
	out.println(uPrice);		
	out.println("</TD>");	
	out.println("<TD></TD>");
	out.println("</TR>");		
	out.println("<TR>");	
	out.println("<TD>기      간 (회)</TD>");
	out.println("<TD>");
	out.println(nPayment);	
	out.println("</TD>");
	out.println("<TD>PMT</TD>");
	out.println("<TD>");	
	out.println(pmt);		
	out.println("</TD>");
	out.println("<TD>");
	out.println(pmtDiem);
	out.println("</TD>");
	out.println("</TR>");	
	out.println("</DATA>");
 	out.println("</IBSheetSet>");
 	out.println("</Excel>");
%>