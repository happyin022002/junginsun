<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0009GS.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-08-29 SeongMun_Kang
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.ESD_SCE_0009Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.ESD_SCE_0009EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.hanjin.framework.core.layer.event.Event" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.event.ESD_SCE_0009Event_R" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.event.ESD_SCE_0009EventResponse_R" %>
<%
    ESD_SCE_0009Event_R event = null;
    ESD_SCE_0009EventResponse_R eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet
    Exception serverException = null;               //서버에서 발생한 에러

    String strErrMsg = "";                          //에러메세지
    //String strErrMsg2 = "COP Update Fail";

	
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (ESD_SCE_0009Event_R)request.getAttribute("Event");
        	
			eventResponse = (ESD_SCE_0009EventResponse_R)request.getAttribute("EventResponse");
            
        } // end else
    }catch(Exception ex) {
        out.println(ex.toString());
    }
%>
<%
	if (serverException == null) {
%>
<ERROR>
</ERROR>
<%
	} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
%>