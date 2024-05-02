<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0118GS.jsp
*@FileTitle : COP Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : sangHyun-Kim
*@LastVersion : 1.0
* 2008-08-01 sangHyun-Kim
* 1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.ESD_SCE_0118EventResponse"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>

<%

	ESD_SCE_0118EventResponse eventResponse   = null;
	String                   strErrMsg       = "" ;
	Exception                serverException = null;
	DBRowSet 				 rowSet = null;
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (ESD_SCE_0118EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	rowSet = eventResponse.getRowSet();
            } // end if
        } // end else
	} catch(Exception e) {
        out.println(e.toString());
    }
	
	if(serverException == null) {
		
%>
<SHEET>
<DATA>
<%
String temp = "";
int i =1;
if (rowSet != null) {
	while (rowSet.next()){
%>
		<TR>
<%
			for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
				temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
%>
				<TD><![CDATA[<%=temp%>]]></TD>
<%
			}
			i = 1;
%>
</TR>
<%
	}
}
%>
  </DATA>
</SHEET>
<%
    } else {
%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>
