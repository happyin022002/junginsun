<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_034GS3.jsp
*@FileTitle : Brokerage AP Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-30
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-30 Jung-Hyung, Kim
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.ESM_AGT_034Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.ESM_AGT_034EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

	ESM_AGT_034Event event = null;
	ESM_AGT_034EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//서버에서 발생한 에러
	DBRowSet rowSet1 = null;						//DB ResultSet
	DBRowSet rowSet2 = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_034Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_034EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet1 = eventResponse.getRs();
				rowSet2 = eventResponse.getRs2();
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
		int i = 1;
		if (rowSet1 != null) {
			while (rowSet1.next()) {
				i = 1;
%>
		<TR>
<%
				for (int j=0; j<rowSet1.getMetaData().getColumnCount(); j++) {
%>
			<TD><![CDATA[<%=JSPUtil.getNull(rowSet1.getString(i++))%>]]></TD>
<%
				}
%>
		</TR>
<%
			}
		}
%>
	</DATA>
	<ETC-DATA>
		<ETC KEY="sxml1">
    		<![CDATA[
    		<?xml version="1.0" ?>
    		<SHEET>
				<DATA>
<%
		if (rowSet2 != null) {
			while (rowSet2.next()) {
				i = 1;
%>
					<TR>
<%
				for (int j=0; j<rowSet2.getMetaData().getColumnCount(); j++) {
%>
						<TD><%=JSPUtil.getNull(rowSet2.getString(i++))%></TD>
<%
				}
%>
					</TR>
<%
			}
		}
%>
				</DATA>
			</SHEET>
			]]>
    	</ETC>
    </ETC-DATA>
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