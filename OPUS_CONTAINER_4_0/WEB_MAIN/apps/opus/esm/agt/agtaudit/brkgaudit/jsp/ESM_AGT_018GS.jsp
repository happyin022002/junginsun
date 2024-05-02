<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_018GS.jsp
*@FileTitle : Agent Commission AP Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-22
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-22 Jung-Hyung, Kim
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
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.ESM_AGT_018Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.ESM_AGT_018EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%
	ESM_AGT_018Event event = null;
	ESM_AGT_018EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//error from server
	DBRowSet rowSet = null;							//DB ResultSet
	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_018Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_018EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
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
	<DATA TOTAL="<%=rowCount%>">
<%
			int i =1;
			if (rowSet != null) {
				while (rowSet.next()) {
%>
		<TR>
			<TD></TD>
			<TD>R</TD>
<%
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
%>
			<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
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