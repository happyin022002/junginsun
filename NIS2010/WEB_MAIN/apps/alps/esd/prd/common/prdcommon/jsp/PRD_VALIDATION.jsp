<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.prdcommon.event.PrdCommonEvent"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.event.ESD_PRD_0004Event"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.prdcommon.event.PrdCommonEvent"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.prdcommon.event.PrdCommonEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.framework.core.layer.event.Event"%>
<%
	ESD_PRD_0004Event event004 = null;
	PrdCommonEvent   eventCommon = null;
	PrdCommonEventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;            		//서버에서 발생한 에러
    DBRowSet rowSet     = null;                         //DB ResultSet
    String strErrMsg 	= "";                           //에러메세지
    int rowCount     	= 0;                            //DB ResultSet 리스트의 건수
    FormCommand formcommand = new FormCommand();
    String eventName = "";
    String comData1 = "";
    String comData2 = "";
    boolean isDoor = false;
    try {

    	 eventName = ((Event)request.getAttribute("Event")).getEventName();

    	 if(eventName.equals("ESD_PRD_0004Event")) {
    		 event004 = (ESD_PRD_0004Event)request.getAttribute("Event");
    	 }
    	 if(eventName.equals("PrdCommonEvent")) {
    		 eventCommon = (PrdCommonEvent)request.getAttribute("Event");
    	 }   	 
        //event = (ESD_PRD_0004Event)request.getAttribute("Event");

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            comData1 = "";
            comData2 = "";
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{

            eventResponse = (PrdCommonEventResponse)request.getAttribute("EventResponse");

            if (eventResponse != null) {
                
            	//sRow = event.getRow();
                
            	//sDir = event.getSkd_dir_cd();
            	rowSet = eventResponse.getRs();
                if(rowSet != null){

                     rowCount = rowSet.getRowCount();
                     
             		if(eventName.equals("PrdCommonEvent")) {
            	        formcommand = eventCommon.getFormCommand();
            	        if( formcommand.isCommand(FormCommand.COMMAND07)) {
                            while (rowSet.next()) {
                           	 comData1 = JSPUtil.getNull(rowSet.getString("vsl_slan_nm"));
                            }            	        	
            	        } else if(formcommand.isCommand(FormCommand.COMMAND04)) {
            	        	isDoor = eventResponse.isDoor();
                            while (rowSet.next()) {
                              	 comData1 = JSPUtil.getNull(rowSet.getString("nod_nm"));
                              	 comData2 = JSPUtil.getNull(rowSet.getString("loc_cd"));
                               }            	        	
            	        } else if(formcommand.isCommand(FormCommand.COMMAND08)) {
                            while (rowSet.next()) {
                              	 comData1 = JSPUtil.getNull(rowSet.getString("comData1")); //VNDR_ABBR_NM
                              	 comData2 = JSPUtil.getNull(rowSet.getString("comData2")); //vndr_lgl_eng_nm
                               }            	        	
               	        }
            		}
             		

                     
                } // end if
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<%
    if (serverException == null) {
    	
		if(eventName.equals("PrdCommonEvent")) {
	        formcommand = eventCommon.getFormCommand();
		}

%>
<?xml version="1.0"  ?>
<SHEET>
	<DATA></DATA>
	<ETC-DATA>
     	<ETC KEY="rowCount"><![CDATA[<%=rowCount%>]]></ETC>
     	<ETC KEY="comData1"><![CDATA[<%=comData1%>]]></ETC>
     	<ETC KEY="comData2"><![CDATA[<%=comData2%>]]></ETC>
     	<ETC KEY="isDoor"><![CDATA[<%=isDoor%>]]></ETC>
	</ETC-DATA> 
</SHEET>
<%
}	else {%>
<ERROR>
	<ETC-DATA>
     	<ETC KEY="rowCount"><![CDATA[<%=rowCount%>]]></ETC>
     	<ETC KEY="comData1"><![CDATA[<%=comData1%>]]></ETC>
     	<ETC KEY="comData2"><![CDATA[<%=comData2%>]]></ETC>     	
     	<ETC KEY="isDoor"><![CDATA[<%=isDoor%>]]></ETC>     	
	</ETC-DATA> 
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>
