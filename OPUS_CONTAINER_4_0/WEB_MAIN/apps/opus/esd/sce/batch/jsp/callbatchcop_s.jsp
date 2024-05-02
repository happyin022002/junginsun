<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="com.clt.apps.opus.esd.sce.batch.copmanage.event.COPManageEvent" %>                
<%@ page import="com.clt.apps.opus.esd.sce.batch.copmanage.event.COPManageEventResponse" %>  
<%@ page import="com.clt.framework.core.layer.event.EventResponse" %>  
<%@ page import="com.clt.apps.opus.esd.sce.batch.copmanage.COPManageBSC" %>                
                
                
<html>

<%
	
        COPManageEvent event = new COPManageEvent();
        
        //System.out.println("perform 8");
        EventResponse eventresponse = new COPManageEventResponse();                              
        COPManageBSC copmanagebsc = new COPManageBSC();
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
   
  
 






 



 


 

