<!--%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0028GS.jsp
*@FileTitle : Exception Alert/통지 대상 등록 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-08-30 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
%-->
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.online.edisend.event.EdiSendEvent"%>
<%@ page import="com.clt.apps.opus.esd.sce.online.edisend.event.EdiSendEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%

    EdiSendEvent event = null;
    EdiSendEventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;                     //서버에서 발생한 에러
    String successFlag = "";
    String strErrMsg = "";                                  //에러메세지
    
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EdiSendEvent)request.getAttribute("Event");
            eventResponse = (EdiSendEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	successFlag = eventResponse.getSuccessFlag();
                
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<%
    if (serverException == null) {
%>
<SHEET>
  		  <ETC-DATA>
    	    <ETC NAME="issuccess"><%=successFlag%></ETC>
    	  </ETC-DATA>
    	  </SHEET>
 <%
 }
 %>