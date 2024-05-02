<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_014GS2.jsp
*@FileTitle : Brokerage Detail & History fo BL Pop-up 화면 요율 정보 Retrieve
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-08
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-02-08 Hwang GyeongNam
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
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.ESM_AGT_014Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.ESM_AGT_014EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%
	ESM_AGT_014Event event = null;
	ESM_AGT_014EventResponse eventResponse = null;	// RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				// error from server
	DBRowSet rowSet	= null;							// Database ResultSet (요율 정보)
	String strErrMsg = "";							// error message
	int rowCount = 0;								// 요율 정보 건수
	int i = 1;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_014Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_014EventResponse)request.getAttribute("EventResponse");
			
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
			if (rowSet != null) {
				while (rowSet.next()) {
%>
		<TR>
			<TD></TD>
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