<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.batch.mailcargotracking.event.MailCargoTrackingEvent" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.batch.MailCargoTrackingBSC" %>
             
                
                
<html>

<%
  /*     COPManageEvent event = new COPManageEvent();
        
        System.out.println("perform 8");
        EventResponse eventresponse = new COPManageEventResponse();                              
        COPManageBSC copmanagebsc = new COPManageBSC();
        eventresponse = copmanagebsc.perform(event); 
        
        System.out.println("perform ok");

	System.out.println("b1");*/
	
	RequestDataSetBC         dataSet = RequestDataSetBC.getInstance(request) ;
	MailCargoTrackingEvent event   = new MailCargoTrackingEvent(dataSet) ;
	MailCargoTrackingBSC   bsc     = new MailCargoTrackingBSC() ;
	bsc.perform(event) ;
	
		

	
%>
<script language="JavaScript">
	alert("success");
	history.back();
</script>


<body>
CALL COP MANAGE Process<br> 

</body>
</html>
   
  
 






 



 


 

