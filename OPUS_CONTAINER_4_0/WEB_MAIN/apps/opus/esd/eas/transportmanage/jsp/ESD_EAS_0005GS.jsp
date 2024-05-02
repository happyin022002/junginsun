<%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_004GS.jsp
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0005Event"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0005EventResponse"%>

<%
	SignOnUserAccount account = null; //Session 
	EsdEas0005Event         event           = null;
	EsdEas0005EventResponse eventResponse   = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    int                      totCnt          = 0 ;
    String                   strErrMsg       = "";

    try {
    	account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event         = (EsdEas0005Event)request.getAttribute("Event");
            eventResponse = (EsdEas0005EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet();
		if(rowSet != null){
	totCnt = rowSet.getRowCount();
		} // end if
            }
        }
    }catch(Exception e) {
    	out.println(e.getMessage()) ;
    }

    if (serverException == null) {
%>

<SHEET>
  <DATA TOTAL="<%=totCnt%>">
<%
			int i =1;
			int seq = 1;
			if (rowSet != null) {
				while (rowSet.next()) {
%>
	<TR>
					<TD><![CDATA[<%=seq%>]]></TD>
<%
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
%>
						
						<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
					}
					i = 1;
					seq++;
%>
	</TR>
<%
				}
			}
%>
  </DATA>
</SHEET>
<%
        
    } else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
	
%>