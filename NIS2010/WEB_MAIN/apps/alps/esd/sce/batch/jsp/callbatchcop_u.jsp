<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.batch.rtrmanage.event.RTRManageEvent" %>   
<%@ page import="com.hanjin.apps.alps.esd.sce.batch.rtrmanage.event.RTRManageEventResponse" %>  
<%@ page import="com.hanjin.framework.core.layer.event.EventResponse" %>  
<%@ page import="com.hanjin.apps.alps.esd.sce.batch.rtrmanage.RTRManageBSC" %>  
              
                
                
<html>

<%
        
        RTRManageEvent event = new RTRManageEvent();
        EventResponse eventresponse = new RTRManageEventResponse();                              
        RTRManageBSC rtrmanagebsc = new RTRManageBSC();

        String so_mapg_sts_cd = null;

        //System.out.println("perform start");
        
        so_mapg_sts_cd = request.getParameter("so_mapg_sts_cd"); 
        event.putSo_mapg_sts_cd(so_mapg_sts_cd);
        eventresponse = rtrmanagebsc.perform(event); 
        
        //System.out.println("perform ok");
        //System.out.println("so_mapg_sts_cd["+so_mapg_sts_cd+"]");
	
%>
<script language="JavaScript">
	alert("complete");
	history.back();
</script>


<body>
CALL RTR MANAGE Process<br> 

</body>
</html>
   
  
 






 



 


 

