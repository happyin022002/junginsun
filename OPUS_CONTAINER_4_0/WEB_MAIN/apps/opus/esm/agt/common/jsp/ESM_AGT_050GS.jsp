<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_050GS.jsp
*@FileTitle : Container type Retrieve 및 다중 Optional(Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-13
*@LastModifier : Sung-An Jang
*@LastVersion : 1.0
* 2008-03-13 Sung-An Jang
* 1.0 최초 Insert
=========================================================*/ 
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.ESM_AGT_050Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.ESM_AGT_050EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%

	ESM_AGT_050Event event = null;
	ESM_AGT_050EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//error from server
	DBRowSet rowSet = null;						    //DB ResultSet
	String strErrMsg = "";							//error message

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_050Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_050EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
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
  <DATA>

<%
		int i =1;
		if (rowSet != null) {
			while (rowSet.next()) {
%>
					<TR>
<%
				//for (int j=0; j<rowSet.getMetaData().getColumnCount(); j++) {
%>						
						<TD></TD>
						<TD></TD>
						<TD><%=JSPUtil.getNull(rowSet.getString(i++))%></TD>
						<TD><%=JSPUtil.getNull(rowSet.getString(i++))%></TD>
						<TD><%=JSPUtil.getNull(rowSet.getString(i++))%></TD>
<%
				//}
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