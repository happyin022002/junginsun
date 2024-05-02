<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="com.clt.apps.opus.esd.sce.batch.actualdatareceive.event.ActualDataReceiveEvent" %>                
<%@ page import="com.clt.apps.opus.esd.sce.batch.actualdatareceive.event.ActualDataReceiveEventResponse" %>  
<%@ page import="com.clt.framework.core.layer.event.EventResponse" %>  
<%@ page import="com.clt.apps.opus.esd.sce.batch.actualdatareceive.ActualDataReceiveBSC" %>                
                
                
<html>

<%
	
ActualDataReceiveEvent event = new ActualDataReceiveEvent();
        
        //System.out.println("perform 8");
        EventResponse eventresponse = new ActualDataReceiveEventResponse();                              
        ActualDataReceiveBSC copmanagebsc = new ActualDataReceiveBSC();
        eventresponse = copmanagebsc.perform(event); 
        
        //System.out.println("perform ok");

	//System.out.println("b1");
		

	
%>
<script language="JavaScript">
	alert("success");
	history.back();
</script>


<body>
CALL COP MANAGE Process<br> 

</body>
</html>
   
  
 






 



 


 

